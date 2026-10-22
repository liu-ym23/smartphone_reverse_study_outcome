package com.android.server.graphics.fonts;

import android.graphics.fonts.FontUpdateRequest;
import android.graphics.fonts.SystemFonts;
import android.os.FileUtils;
import android.os.LocaleList;
import android.system.ErrnoException;
import android.system.Os;
import android.text.FontConfig;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.Base64;
import android.util.Slog;
import com.android.internal.art.ArtStatsLog;
import com.android.internal.util.FrameworkStatsLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
final class UpdatableFontDir {
    private static final String FONT_SIGNATURE_FILE = "font.fsv_sig";
    private static final String RANDOM_DIR_PREFIX = "~~";
    private static final String TAG = "UpdatableFontDir";
    private final AtomicFile mConfigFile;
    private final Function<Map<String, File>, FontConfig> mConfigSupplier;
    private int mConfigVersion;
    private final Supplier<Long> mCurrentTimeSupplier;
    private final File mFilesDir;
    private final ArrayMap<String, FontFileInfo> mFontFileInfoMap;
    private final FsverityUtil mFsverityUtil;
    private long mLastModifiedMillis;
    private final FontFileParser mParser;

    private static final class FontFileInfo {
        private final File mFile;
        private final String mPsName;
        private final long mRevision;

        /* JADX INFO: renamed from: -$$Nest$fgetmFile, reason: not valid java name */
        static /* bridge */ /* synthetic */ File m4260$$Nest$fgetmFile(FontFileInfo r0) {
            return r0.mFile;
        }

        FontFileInfo(File file, String psName, long revision) {
            this.mFile = file;
            this.mPsName = psName;
            this.mRevision = revision;
        }

        public File getFile() {
            return this.mFile;
        }

        public String getPostScriptName() {
            return this.mPsName;
        }

        public File getRandomizedFontDir() {
            return this.mFile.getParentFile();
        }

        public long getRevision() {
            return this.mRevision;
        }

        public String toString() {
            return "FontFileInfo{mFile=" + this.mFile + ", psName=" + this.mPsName + ", mRevision=" + this.mRevision + '}';
        }
    }

    interface FontFileParser {
        String buildFontFileName(File r1) throws IOException;

        String getPostScriptName(File r1) throws IOException;

        long getRevision(File r1) throws IOException;

        void tryToCreateTypeface(File r1) throws Throwable;
    }

    interface FsverityUtil {
        boolean isFromTrustedProvider(String r1, byte[] r2);

        boolean rename(File r1, File r2);

        void setUpFsverity(String r1) throws IOException;
    }

    public static /* synthetic */ FontConfig $r8$lambda$l6wKUt3kHk5foaoReX8Hx16jJGk(Map r0) {
        return lambda$new$0(r0);
    }

    UpdatableFontDir(File filesDir, FontFileParser parser, FsverityUtil fsverityUtil, File configFile) {
        this(filesDir, parser, fsverityUtil, configFile, new UpdatableFontDir$$ExternalSyntheticLambda0(), new UpdatableFontDir$$ExternalSyntheticLambda1());
    }

    private static /* synthetic */ FontConfig lambda$new$0(Map map) {
        return SystemFonts.getSystemFontConfig(map, 0, 0);
    }

    UpdatableFontDir(File filesDir, FontFileParser parser, FsverityUtil fsverityUtil, File configFile, Supplier<Long> currentTimeSupplier, Function<Map<String, File>, FontConfig> configSupplier) {
        this.mFontFileInfoMap = new ArrayMap();
        this.mFilesDir = filesDir;
        this.mParser = parser;
        this.mFsverityUtil = fsverityUtil;
        this.mConfigFile = new AtomicFile(configFile);
        this.mCurrentTimeSupplier = currentTimeSupplier;
        this.mConfigSupplier = configSupplier;
    }

    void loadFontFileMap() {
        this.mFontFileInfoMap.clear();
        long r3 = 0;
        this.mLastModifiedMillis = 0;
        char r0 = 1;
        this.mConfigVersion = 1;
        PersistentSystemFontConfig.Config config = readPersistentConfig();     // Catch: Throwable -> L9
        this.mLastModifiedMillis = config.lastModifiedMillis;     // Catch: Throwable -> L9
        File[] dirs = this.mFilesDir.listFiles();     // Catch: Throwable -> L9
        if (dirs != null) goto L11;
        Slog.e(TAG, "Could not read: " + this.mFilesDir);     // Catch: Throwable -> L9
        if (0 != 0) goto L101;
        this.mFontFileInfoMap.clear();
        this.mLastModifiedMillis = 0;
        FileUtils.deleteContents(this.mFilesDir);
        this.mConfigFile.delete();
        return;
    L101:
        return;
    L11:
        FontConfig fontConfig = null;
        int r9 = dirs.length;     // Catch: Throwable -> L9
        int r10 = 0;
        int r11 = 0;
    L13:
        if (r11 >= r9) goto L53;
        File dir = dirs[r11];     // Catch: Throwable -> L9
        if (dir.getName().startsWith(RANDOM_DIR_PREFIX) == false) goto L16;
        if (config.updatedFontDirs.contains(dir.getName()) == true) goto L23;
        Slog.i(TAG, "Deleting obsolete dir: " + dir);     // Catch: Throwable -> L9
        FileUtils.deleteContentsAndDir(dir);     // Catch: Throwable -> L9
        int r16 = r10;
    L43:
        r11 = r11 + 1;     // Catch: Throwable -> L9
        r10 = r16;
        r3 = 0;
        goto L13
    L23:
        File signatureFile = new File(dir, FONT_SIGNATURE_FILE);     // Catch: Throwable -> L9
        if (signatureFile.exists() == false) goto L25;
        byte[] signature = Files.readAllBytes(Paths.get(signatureFile.getAbsolutePath(), new String[r10]));     // Catch: Throwable -> L9 IOException -> L48
        File[] files = dir.listFiles();     // Catch: Throwable -> L9
        if (files == null) goto L44;
        r16 = r10;
        if (files.length != 2) goto L44;
        if (files[r16].equals(signatureFile) == false) goto L38;
        File fontFile = files[r0];     // Catch: Throwable -> L9
    L39:
        FontFileInfo fontFileInfo = validateFontFile(fontFile, signature);     // Catch: Throwable -> L9
        if (fontConfig != null) goto L42;
        fontConfig = this.mConfigSupplier.apply(Collections.emptyMap());     // Catch: Throwable -> L9
    L42:
        r0 = 1;
        addFileToMapIfSameOrNewer(fontFileInfo, fontConfig, true);     // Catch: Throwable -> L9
        goto L43
    L38:
        fontFile = files[r16];     // Catch: Throwable -> L9
    L44:
        Slog.e(TAG, "Unexpected files in dir: " + dir);     // Catch: Throwable -> L9
        if (0 != 0) goto L104;
        this.mFontFileInfoMap.clear();
        this.mLastModifiedMillis = 0;
        FileUtils.deleteContents(this.mFilesDir);
        this.mConfigFile.delete();
        return;
    L104:
        return;
    L49:
        Slog.e(TAG, "Failed to read signature file.");     // Catch: Throwable -> L9
        if (0 != 0) goto L105;
        this.mFontFileInfoMap.clear();
        this.mLastModifiedMillis = 0;
        FileUtils.deleteContents(this.mFilesDir);
        this.mConfigFile.delete();
        return;
    L105:
        return;
    L25:
        Slog.i(TAG, "The signature file is missing.");     // Catch: Throwable -> L9
        if (0 != 0) goto L103;
        this.mFontFileInfoMap.clear();
        this.mLastModifiedMillis = r3;
        FileUtils.deleteContents(this.mFilesDir);
        this.mConfigFile.delete();
        return;
    L103:
        return;
    L16:
        Slog.e(TAG, "Unexpected dir found: " + dir);     // Catch: Throwable -> L9
        if (0 != 0) goto L102;
        this.mFontFileInfoMap.clear();
        this.mLastModifiedMillis = r3;
        FileUtils.deleteContents(this.mFilesDir);
        this.mConfigFile.delete();
        return;
    L102:
        return;
    L53:
        int i = 0;
    L55:
        if (i >= config.fontFamilies.size()) goto L73;
        FontUpdateRequest.Family family = config.fontFamilies.get(i);     // Catch: Throwable -> L9
        int j = 0;
    L58:
        if (j >= family.getFonts().size()) goto L71;
        FontUpdateRequest.Font font = (FontUpdateRequest.Font) family.getFonts().get(j);     // Catch: Throwable -> L9
        if (this.mFontFileInfoMap.containsKey(font.getPostScriptName()) == true) goto L66;
        if (fontConfig != null) goto L65;
        fontConfig = this.mConfigSupplier.apply(Collections.emptyMap());     // Catch: Throwable -> L9
    L65:
        if (getFontByPostScriptName(font.getPostScriptName(), fontConfig) != null) goto L66;
        Slog.e(TAG, "Unknown font that has PostScript name " + font.getPostScriptName() + " is requested in FontFamily " + family.getName());     // Catch: Throwable -> L9
        if (0 != 0) goto L106;
        this.mFontFileInfoMap.clear();
        this.mLastModifiedMillis = 0;
        FileUtils.deleteContents(this.mFilesDir);
        this.mConfigFile.delete();
        return;
    L106:
        return;
    L66:
        j = j + 1;     // Catch: Throwable -> L9
        goto L58
    L71:
        i = i + 1;
        goto L55
    L73:
        if (1 != 0) goto L79;
    L74:
        this.mFontFileInfoMap.clear();
        this.mLastModifiedMillis = 0;
        FileUtils.deleteContents(this.mFilesDir);
        this.mConfigFile.delete();
        return;
    L79:
        return;
    L9:
        t = move-exception;
        Slog.e(TAG, "Failed to load font mappings.", t);     // Catch: Throwable -> L80
        if (0 == 0) goto L74;
        return;
    L80:
        th = move-exception;
        if (0 != 0) goto L83;
        this.mFontFileInfoMap.clear();
        this.mLastModifiedMillis = 0;
        FileUtils.deleteContents(this.mFilesDir);
        this.mConfigFile.delete();
    L83:
        throw th;
    }

    public void update(List<FontUpdateRequest> requests) throws FontManagerService.SystemFontException {
        Iterator<FontUpdateRequest> r0 = requests.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        FontUpdateRequest request = r0.next();
        switch(request.getType()) {
            case 0: goto L9;
            case 1: goto L8;
            default: goto L4;
        };
    L8:
        request.getFontFamily().getClass();
        request.getFontFamily().getName().getClass();
        goto L4
    L9:
        request.getFd().getClass();
        request.getSignature().getClass();
        goto L4
    L11:
        ArrayMap<String, FontFileInfo> backupMap = new ArrayMap(this.mFontFileInfoMap);
        PersistentSystemFontConfig.Config curConfig = readPersistentConfig();
        Map<String, FontUpdateRequest.Family> familyMap = new HashMap();
        int i = 0;
    L13:
        if (i >= curConfig.fontFamilies.size()) goto L15;
        FontUpdateRequest.Family family = curConfig.fontFamilies.get(i);
        familyMap.put(family.getName(), family);
        i = i + 1;
        goto L13
    L15:
        long backupLastModifiedDate = this.mLastModifiedMillis;
        Iterator<FontUpdateRequest> r6 = requests.iterator();     // Catch: Throwable -> L23
    L18:
        if (r6.hasNext() == false) goto L27;
        FontUpdateRequest request2 = r6.next();     // Catch: Throwable -> L23
        switch(request2.getType()) {
            case 0: goto L25;
            case 1: goto L22;
            default: goto L18;
        };     // Catch: Throwable -> L23
    L22:
        FontUpdateRequest.Family family2 = request2.getFontFamily();     // Catch: Throwable -> L23
        familyMap.put(family2.getName(), family2);     // Catch: Throwable -> L23
        goto L18
    L25:
        installFontFile(request2.getFd().getFileDescriptor(), request2.getSignature());     // Catch: Throwable -> L23
        goto L18
    L27:
        Iterator<FontUpdateRequest.Family> r7 = familyMap.values().iterator();     // Catch: Throwable -> L23
    L29:
        if (r7.hasNext() == false) goto L35;
        if (resolveFontFilesForNamedFamily(r7.next()) != null) goto L29;
        throw new FontManagerService.SystemFontException(-9, "Required fonts are not available");     // Catch: Throwable -> L23
    L35:
        this.mLastModifiedMillis = this.mCurrentTimeSupplier.get().longValue();     // Catch: Throwable -> L23
        PersistentSystemFontConfig.Config newConfig = new PersistentSystemFontConfig.Config();     // Catch: Throwable -> L23
        newConfig.lastModifiedMillis = this.mLastModifiedMillis;     // Catch: Throwable -> L23
        Iterator<FontFileInfo> r8 = this.mFontFileInfoMap.values().iterator();     // Catch: Throwable -> L23
    L37:
        if (r8.hasNext() == false) goto L39;
        FontFileInfo info = r8.next();     // Catch: Throwable -> L23
        newConfig.updatedFontDirs.add(info.getRandomizedFontDir().getName());     // Catch: Throwable -> L23
        goto L37
    L39:
        newConfig.fontFamilies.addAll(familyMap.values());     // Catch: Throwable -> L23
        writePersistentConfig(newConfig);     // Catch: Throwable -> L23
        this.mConfigVersion++;     // Catch: Throwable -> L23
        if (1 != 0) goto L63;
        this.mFontFileInfoMap.clear();
        this.mFontFileInfoMap.putAll(backupMap);
        this.mLastModifiedMillis = backupLastModifiedDate;
        return;
    L63:
        return;
    L23:
        th = move-exception;
        if (0 != 0) goto L46;
        this.mFontFileInfoMap.clear();
        this.mFontFileInfoMap.putAll(backupMap);
        this.mLastModifiedMillis = backupLastModifiedDate;
    L46:
        throw th;
    }

    private void installFontFile(FileDescriptor fd, byte[] pkcs7Signature) throws FontManagerService.SystemFontException {
        File newDir = getRandomDir(this.mFilesDir);
        if (newDir.mkdir() == false) goto L82;
        Os.chmod(newDir.getAbsolutePath(), ArtStatsLog.ISOLATED_COMPILATION_SCHEDULED);     // Catch: ErrnoException -> L78
        File tempNewFontFile = new File(newDir, "font.ttf");     // Catch: Throwable -> L32
        FileOutputStream out = new FileOutputStream(tempNewFontFile);     // Catch: Throwable -> L32 IOException -> L64
        FileUtils.copy(fd, out.getFD());     // Catch: Throwable -> L66
        out.close();     // Catch: Throwable -> L32 IOException -> L64
        this.mFsverityUtil.setUpFsverity(tempNewFontFile.getAbsolutePath());     // Catch: Throwable -> L32 IOException -> L61
    L96:
        String fontFileName = this.mParser.buildFontFileName(tempNewFontFile);     // Catch: Throwable -> L32 IOException -> L58
        if (fontFileName == null) goto L57;
        File newFontFile = new File(newDir, fontFileName);     // Catch: Throwable -> L32
        if (this.mFsverityUtil.rename(tempNewFontFile, newFontFile) == false) goto L55;
        Os.chmod(newFontFile.getAbsolutePath(), 420);     // Catch: Throwable -> L32 ErrnoException -> L51
        File signatureFile = new File(newDir, FONT_SIGNATURE_FILE);     // Catch: Throwable -> L32
        FileOutputStream out2 = new FileOutputStream(signatureFile);     // Catch: Throwable -> L32 IOException -> L40
        out2.write(pkcs7Signature);     // Catch: Throwable -> L42
        out2.close();     // Catch: Throwable -> L32 IOException -> L40
        Os.chmod(signatureFile.getAbsolutePath(), FrameworkStatsLog.NON_A11Y_TOOL_SERVICE_WARNING_REPORT);     // Catch: Throwable -> L32 ErrnoException -> L37
        FontFileInfo fontFileInfo = validateFontFile(newFontFile, pkcs7Signature);     // Catch: Throwable -> L32
        this.mParser.tryToCreateTypeface(fontFileInfo.getFile());     // Catch: Throwable -> L34
        FontConfig fontConfig = getSystemFontConfig();     // Catch: Throwable -> L32
        if (addFileToMapIfSameOrNewer(fontFileInfo, fontConfig, false) == false) goto L31;
        if (1 != 0) goto L106;
        FileUtils.deleteContentsAndDir(newDir);
        return;
    L106:
        return;
    L31:
        throw new FontManagerService.SystemFontException(-5, "Downgrading font file is forbidden.");     // Catch: Throwable -> L32
    L34:
        t = move-exception;
        throw new FontManagerService.SystemFontException(-3, "Failed to create Typeface from file", t);     // Catch: Throwable -> L32
    L37:
        e = move-exception;
        throw new FontManagerService.SystemFontException(-1, "Failed to change the signature file mode to 600", e);     // Catch: Throwable -> L32
    L42:
        th = move-exception;
        out2.close();     // Catch: Throwable -> L45
    L47:
        throw th;     // Catch: Throwable -> L32 IOException -> L40
    L45:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L32 IOException -> L40
    L40:
        e = move-exception;
        throw new FontManagerService.SystemFontException(-1, "Failed to write font signature file to storage.", e);     // Catch: Throwable -> L32
    L51:
        e = move-exception;
        throw new FontManagerService.SystemFontException(-1, "Failed to change font file mode to 644", e);     // Catch: Throwable -> L32
    L55:
        throw new FontManagerService.SystemFontException(-1, "Failed to move verified font file.");     // Catch: Throwable -> L32
    L57:
        throw new FontManagerService.SystemFontException(-4, "Failed to read PostScript name from font file");     // Catch: Throwable -> L32
    L58:
        e = move-exception;
        throw new FontManagerService.SystemFontException(-3, "Failed to read PostScript name from font file", e);     // Catch: Throwable -> L32
    L61:
        e = move-exception;
        throw new FontManagerService.SystemFontException(-2, "Failed to setup fs-verity.", e);     // Catch: Throwable -> L32
    L66:
        th = move-exception;
        out.close();     // Catch: Throwable -> L69
    L71:
        throw th;     // Catch: Throwable -> L32 IOException -> L64
    L69:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L32 IOException -> L64
    L64:
        e = move-exception;
        throw new FontManagerService.SystemFontException(-1, "Failed to write font file to storage.", e);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        if (0 != 0) goto L77;
        FileUtils.deleteContentsAndDir(newDir);
    L77:
        throw th;
    L78:
        e = move-exception;
        throw new FontManagerService.SystemFontException(-1, "Failed to change mode to 711", e);
    L82:
        throw new FontManagerService.SystemFontException(-1, "Failed to create font directory.");
    }

    private static File getRandomDir(File parent) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16];
    L3:
        random.nextBytes(bytes);
        String dirName = RANDOM_DIR_PREFIX + Base64.encodeToString(bytes, 10);
        File dir = new File(parent, dirName);
        if (dir.exists() == true) goto L3;
        return dir;
    }

    private FontFileInfo lookupFontFileInfo(String psName) {
        return this.mFontFileInfoMap.get(psName);
    }

    private void putFontFileInfo(FontFileInfo info) {
        this.mFontFileInfoMap.put(info.getPostScriptName(), info);
    }

    private boolean addFileToMapIfSameOrNewer(FontFileInfo fontFileInfo, FontConfig fontConfig, boolean deleteOldFile) {
        FontFileInfo existingInfo = lookupFontFileInfo(fontFileInfo.getPostScriptName());
        boolean shouldAddToMap = false;
        if (existingInfo != null) goto L9;
        long preInstalledRev = getPreinstalledFontRevision(fontFileInfo, fontConfig);
        if (preInstalledRev > fontFileInfo.getRevision()) goto L11;
        shouldAddToMap = true;
    L11:
        if (shouldAddToMap == false) goto L16;
        if (deleteOldFile == false) goto L15;
        if (existingInfo == null) goto L15;
        FileUtils.deleteContentsAndDir(existingInfo.getRandomizedFontDir());
    L15:
        putFontFileInfo(fontFileInfo);
    L18:
        return shouldAddToMap;
    L16:
        if (deleteOldFile == false) goto L18;
        FileUtils.deleteContentsAndDir(fontFileInfo.getRandomizedFontDir());
        goto L18
    L9:
        if (existingInfo.getRevision() > fontFileInfo.getRevision()) goto L11;
        shouldAddToMap = true;
        goto L11
    }

    private FontConfig.Font getFontByPostScriptName(String psName, FontConfig fontConfig) {
        FontConfig.Font targetFont = null;
        int i = 0;
    L4:
        if (i >= fontConfig.getFontFamilies().size()) goto L13;
        FontConfig.FontFamily family = (FontConfig.FontFamily) fontConfig.getFontFamilies().get(i);
        int j = 0;
    L7:
        if (j >= family.getFontList().size()) goto L12;
        FontConfig.Font font = (FontConfig.Font) family.getFontList().get(j);
        if (font.getPostScriptName().equals(psName) == true) goto L10;
        j = j + 1;
        goto L7
    L10:
        targetFont = font;
    L12:
        i = i + 1;
        goto L4
    L13:
        int i2 = 0;
    L15:
        if (i2 >= fontConfig.getNamedFamilyLists().size()) goto L29;
        FontConfig.NamedFamilyList namedFamilyList = (FontConfig.NamedFamilyList) fontConfig.getNamedFamilyLists().get(i2);
        int j2 = 0;
    L18:
        if (j2 >= namedFamilyList.getFamilies().size()) goto L27;
        FontConfig.FontFamily family2 = (FontConfig.FontFamily) namedFamilyList.getFamilies().get(j2);
        int k = 0;
    L21:
        if (k >= family2.getFontList().size()) goto L26;
        FontConfig.Font font2 = (FontConfig.Font) family2.getFontList().get(k);
        if (font2.getPostScriptName().equals(psName) == true) goto L24;
        k = k + 1;
        goto L21
    L24:
        targetFont = font2;
    L26:
        j2 = j2 + 1;
        goto L18
    L27:
        i2 = i2 + 1;
        goto L15
    L29:
        return targetFont;
    }

    private long getPreinstalledFontRevision(FontFileInfo info, FontConfig fontConfig) {
        String psName = info.getPostScriptName();
        FontConfig.Font targetFont = getFontByPostScriptName(psName, fontConfig);
        if (targetFont != null) goto L6;
        return -1;
    L6:
        if (targetFont.getOriginalFile() == null) goto L8;
        File preinstalledFontFile = targetFont.getOriginalFile();
    L10:
        if (preinstalledFontFile.exists() == true) goto L12;
        return -1;
    L12:
        long revision = getFontRevision(preinstalledFontFile);
        if (revision != (-1)) goto L15;
        Slog.w(TAG, "Invalid preinstalled font file");
    L15:
        return revision;
    L8:
        preinstalledFontFile = targetFont.getFile();
        goto L10
    }

    private FontFileInfo validateFontFile(File file, byte[] pkcs7Signature) throws FontManagerService.SystemFontException {
        if (this.mFsverityUtil.isFromTrustedProvider(file.getAbsolutePath(), pkcs7Signature) == false) goto L15;
        String psName = this.mParser.getPostScriptName(file);     // Catch: IOException -> L11
        long revision = getFontRevision(file);
        if (revision == (-1)) goto L10;
        return new FontFileInfo(file, psName, revision);
    L10:
        throw new FontManagerService.SystemFontException(-3, "Font validation failed. Could not read font revision: " + file);
    L13:
        throw new FontManagerService.SystemFontException(-4, "Font validation failed. Could not read PostScript name name: " + file);
    L15:
        throw new FontManagerService.SystemFontException(-2, "Font validation failed. Fs-verity is not enabled: " + file);
    }

    private long getFontRevision(File file) {
        return this.mParser.getRevision(file);
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to read font file", e);
        return -1;
    }

    private FontConfig.NamedFamilyList resolveFontFilesForNamedFamily(FontUpdateRequest.Family fontFamily) {
        List<FontUpdateRequest.Font> fontList = fontFamily.getFonts();
        List<FontConfig.Font> resolvedFonts = new ArrayList(fontList.size());
        int i = 0;
    L4:
        if (i >= fontList.size()) goto L10;
        FontUpdateRequest.Font font = fontList.get(i);
        FontFileInfo info = this.mFontFileInfoMap.get(font.getPostScriptName());
        if (info == null) goto L7;
        resolvedFonts.add(new FontConfig.Font(FontFileInfo.m4260$$Nest$fgetmFile(info), null, info.getPostScriptName(), font.getFontStyle(), font.getIndex(), font.getFontVariationSettings(), null, 0));
        i = i + 1;
        goto L4
    L7:
        Slog.e(TAG, "Failed to lookup font file that has " + font.getPostScriptName());
        return null;
    L10:
        FontConfig.FontFamily family = new FontConfig.FontFamily(resolvedFonts, LocaleList.getEmptyLocaleList(), 0);
        return new FontConfig.NamedFamilyList(Collections.singletonList(family), fontFamily.getName());
    }

    Map<String, File> getPostScriptMap() {
        Map<String, File> map = new ArrayMap();
        int i = 0;
    L4:
        if (i >= this.mFontFileInfoMap.size()) goto L7;
        FontFileInfo info = this.mFontFileInfoMap.valueAt(i);
        map.put(info.getPostScriptName(), info.getFile());
        i = i + 1;
        goto L4
    L7:
        return map;
    }

    FontConfig getSystemFontConfig() {
        FontConfig config = this.mConfigSupplier.apply(getPostScriptMap());
        PersistentSystemFontConfig.Config persistentConfig = readPersistentConfig();
        List<FontUpdateRequest.Family> families = persistentConfig.fontFamilies;
        List<FontConfig.NamedFamilyList> mergedFamilies = new ArrayList(config.getNamedFamilyLists().size() + families.size());
        mergedFamilies.addAll(config.getNamedFamilyLists());
        int i = 0;
    L4:
        if (i >= families.size()) goto L10;
        FontConfig.NamedFamilyList family = resolveFontFilesForNamedFamily(families.get(i));
        if (family == null) goto L8;
        mergedFamilies.add(family);
    L8:
        i = i + 1;
        goto L4
    L10:
        return new FontConfig(config.getFontFamilies(), config.getAliases(), mergedFamilies, config.getLocaleFallbackCustomizations(), this.mLastModifiedMillis, this.mConfigVersion);
    }

    private PersistentSystemFontConfig.Config readPersistentConfig() {
        PersistentSystemFontConfig.Config config = new PersistentSystemFontConfig.Config();
        FileInputStream fis = this.mConfigFile.openRead();     // Catch: Throwable -> L8
        PersistentSystemFontConfig.loadFromXml(fis, config);     // Catch: Throwable -> L11
        if (fis == null) goto L19;
        fis.close();     // Catch: Throwable -> L8 Throwable -> L8
    L11:
        th = move-exception;
        if (fis != null) goto L23;
    L18:
        throw th;     // Catch: Throwable -> L8 Throwable -> L8
    L23:
        fis.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L8 Throwable -> L8
    L19:
        return config;
    }

    private void writePersistentConfig(PersistentSystemFontConfig.Config config) throws FontManagerService.SystemFontException {
        FileOutputStream fos = null;
        fos = this.mConfigFile.startWrite();     // Catch: IOException -> L5
        PersistentSystemFontConfig.writeToXml(fos, config);     // Catch: IOException -> L5
        this.mConfigFile.finishWrite(fos);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        if (fos == null) goto L9;
        this.mConfigFile.failWrite(fos);
    L9:
        throw new FontManagerService.SystemFontException(-6, "Failed to write config XML.", e);
    }

    int getConfigVersion() {
        return this.mConfigVersion;
    }

    public Map<String, FontConfig.NamedFamilyList> getFontFamilyMap() {
        PersistentSystemFontConfig.Config curConfig = readPersistentConfig();
        Map<String, FontConfig.NamedFamilyList> familyMap = new HashMap();
        int i = 0;
    L4:
        if (i >= curConfig.fontFamilies.size()) goto L10;
        FontUpdateRequest.Family family = curConfig.fontFamilies.get(i);
        FontConfig.NamedFamilyList resolvedFamily = resolveFontFilesForNamedFamily(family);
        if (resolvedFamily == null) goto L8;
        familyMap.put(family.getName(), resolvedFamily);
    L8:
        i = i + 1;
        goto L4
    L10:
        return familyMap;
    }

    static void deleteAllFiles(File filesDir, File configFile) {
        new AtomicFile(configFile).delete();     // Catch: Throwable -> L5
    L12:
        FileUtils.deleteContents(filesDir);     // Catch: Throwable -> L9
        return;
    L10:
        Slog.w(TAG, "Failed to delete " + filesDir);
        return;
    L6:
        Slog.w(TAG, "Failed to delete " + configFile);
        goto L12
    }
}
