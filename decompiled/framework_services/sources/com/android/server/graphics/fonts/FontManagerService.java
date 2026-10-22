package com.android.server.graphics.fonts;

import android.R;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontUpdateRequest;
import android.graphics.fonts.SystemFonts;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SharedMemory;
import android.os.ShellCallback;
import android.text.FontConfig;
import android.util.AndroidException;
import android.util.ArrayMap;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import com.android.internal.graphics.fonts.IFontManager;
import com.android.internal.security.VerityUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.Preconditions;
import com.android.server.LocalServices;
import com.android.server.SystemServerInitThreadPool;
import com.android.server.SystemService;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.DirectByteBuffer;
import java.nio.NioUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes2.dex */
public final class FontManagerService extends IFontManager.Stub {
    private static final String CONFIG_XML_FILE = "/data/fonts/config/config.xml";
    private static final String FONT_FILES_DIR = "/data/fonts/files";
    private static final String TAG = "FontManagerService";
    private final Context mContext;
    private String mDebugCertFilePath;
    private final boolean mIsSafeMode;
    private SharedMemory mSerializedFontMap;
    private final Object mSerializedFontMapLock;
    private UpdatableFontDir mUpdatableFontDir;
    private final Object mUpdatableFontDirLock;

    private static class FsverityUtilImpl implements UpdatableFontDir.FsverityUtil {
        private final String[] mDerCertPaths;

        FsverityUtilImpl(String[] derCertPaths) {
            this.mDerCertPaths = derCertPaths;
        }

        @Override // com.android.server.graphics.fonts.UpdatableFontDir.FsverityUtil
        public boolean isFromTrustedProvider(String fontPath, byte[] pkcs7Signature) {
            byte[] digest = VerityUtils.getFsverityDigest(fontPath);
            if (digest != null) goto L6;
            Log.w(FontManagerService.TAG, "Failed to get fs-verity digest for " + fontPath);
            return false;
        L6:
            String[] r3 = this.mDerCertPaths;
            int r4 = r3.length;
            int r5 = 0;
        L7:
            if (r5 >= r4) goto L26;
            String certPath = r3[r5];
            InputStream is = new FileInputStream(certPath);     // Catch: IOException -> L14
            if (VerityUtils.verifyPkcs7DetachedSignature(pkcs7Signature, digest, is) == true) goto L12;
            is.close();     // Catch: IOException -> L14
        L25:
            r5 = r5 + 1;
            goto L7
        L12:
            is.close();     // Catch: IOException -> L14
            return true;
        L18:
            th = move-exception;
            is.close();     // Catch: Throwable -> L21
        L23:
            throw th;     // Catch: IOException -> L14
        L21:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L14
        L24:
            Log.w(FontManagerService.TAG, "Failed to read certificate file: " + certPath);
            goto L25
        L26:
            return false;
        }

        @Override // com.android.server.graphics.fonts.UpdatableFontDir.FsverityUtil
        public void setUpFsverity(String filePath) throws IOException {
            VerityUtils.setUpFsverity(filePath);
        }

        @Override // com.android.server.graphics.fonts.UpdatableFontDir.FsverityUtil
        public boolean rename(File src, File dest) {
            return src.renameTo(dest);
        }
    }

    public static final class Lifecycle extends SystemService {
        private final FontManagerService mService;
        private final CompletableFuture<Void> mServiceStarted;

        /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
        static /* bridge */ /* synthetic */ FontManagerService m4258$$Nest$fgetmService(Lifecycle r0) {
            return r0.mService;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmServiceStarted, reason: not valid java name */
        static /* bridge */ /* synthetic */ CompletableFuture m4259$$Nest$fgetmServiceStarted(Lifecycle r0) {
            return r0.mServiceStarted;
        }

        public Lifecycle(Context context, boolean safeMode) {
            super(context);
            this.mServiceStarted = new CompletableFuture();
            this.mService = new FontManagerService(context, safeMode, this.mServiceStarted, null);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            LocalServices.addService(FontManagerInternal.class, new AnonymousClass1(this));
            publishBinderService("font", this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 480) goto L6;
            this.mServiceStarted.join();
            return;
        }
    }

    static class SystemFontException extends AndroidException {
        private final int mErrorCode;

        SystemFontException(int errorCode, String msg, Throwable cause) {
            super(msg, cause);
            this.mErrorCode = errorCode;
        }

        SystemFontException(int errorCode, String msg) {
            super(msg);
            this.mErrorCode = errorCode;
        }

        int getErrorCode() {
            return this.mErrorCode;
        }
    }

    public static /* synthetic */ void $r8$lambda$6ntzwgOp0lINWCpV58rCsi7uat4(FontManagerService r0, CompletableFuture r1) {
        r0.lambda$new$0(r1);
    }

    /* synthetic */ FontManagerService(Context r1, boolean r2, CompletableFuture r3, FontManagerServiceIA r4) {
        this(r1, r2, r3);
    }

    public FontConfig getFontConfig() {
        super.getFontConfig_enforcePermission();
        return getSystemFontConfig();
    }

    public int updateFontFamily(List<FontUpdateRequest> requests, int baseVersion) {
        Preconditions.checkArgumentNonnegative(baseVersion);     // Catch: Throwable -> L6
        requests.getClass();     // Catch: Throwable -> L6
        getContext().enforceCallingPermission("android.permission.UPDATE_FONTS", "UPDATE_FONTS permission required.");     // Catch: Throwable -> L6
        update(baseVersion, requests);     // Catch: Throwable -> L6 SystemFontException -> L8
        closeFileDescriptors(requests);
        return 0;
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to update font family", e);     // Catch: Throwable -> L6
        int r1 = e.getErrorCode();     // Catch: Throwable -> L6
        closeFileDescriptors(requests);
        return r1;
    L6:
        th = move-exception;
        closeFileDescriptors(requests);
        throw th;
    }

    private static void closeFileDescriptors(List<FontUpdateRequest> requests) {
        if (requests != null) goto L4;
        return;
    L4:
        Iterator<FontUpdateRequest> r0 = requests.iterator();
    L6:
        if (r0.hasNext() == false) goto L18;
        FontUpdateRequest request = r0.next();
        if (request == null) goto L6;
        ParcelFileDescriptor fd = request.getFd();
        if (fd == null) goto L6;
        fd.close();     // Catch: IOException -> L15
    L15:
        e = move-exception;
        Slog.w(TAG, "Failed to close fd", e);
        goto L6
    }

    private FontManagerService(Context context, boolean safeMode, final CompletableFuture<Void> serviceStarted) {
        this.mUpdatableFontDirLock = new Object();
        this.mDebugCertFilePath = null;
        this.mSerializedFontMapLock = new Object();
        this.mSerializedFontMap = null;
        if (safeMode == false) goto L5;
        Slog.i(TAG, "Entering safe mode. Deleting all font updates.");
        UpdatableFontDir.deleteAllFiles(new File(FONT_FILES_DIR), new File(CONFIG_XML_FILE));
    L5:
        this.mContext = context;
        this.mIsSafeMode = safeMode;
        Slog.i(TAG, "Using optimized boot-time font loading.");
        SystemServerInitThreadPool.submit(new FontManagerService$$ExternalSyntheticLambda0(this, serviceStarted), "FontManagerService_create");
    }

    private /* synthetic */ void lambda$new$0(CompletableFuture serviceStarted) {
        initialize();
        Object r0 = this.mUpdatableFontDirLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mUpdatableFontDir == null) goto L9;
        setSystemFontMap();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        serviceStarted.complete(null);
    }

    private void setSystemFontMap() {
        Typeface.setSystemFontMap(getCurrentFontMap());     // Catch: Throwable -> L4
        return;
    L5:
        Slog.w(TAG, "Failed to set system font map of system_server");
    }

    private UpdatableFontDir createUpdatableFontDir() {
        if (this.mIsSafeMode == false) goto L6;
        return null;
    L6:
        if (VerityUtils.isFsVeritySupported() == true) goto L8;
        return null;
    L8:
        String[] certs = this.mContext.getResources().getStringArray(R.array.config_locationProviderPackageNames);
        if (this.mDebugCertFilePath == null) goto L14;
        if (Build.IS_DEBUGGABLE == false) goto L14;
        String[] tmp = new String[certs.length + 1];
        System.arraycopy(certs, 0, tmp, 0, certs.length);
        tmp[certs.length] = this.mDebugCertFilePath;
        certs = tmp;
    L14:
        return new UpdatableFontDir(new File(FONT_FILES_DIR), new OtfFontFileParser(), new FsverityUtilImpl(certs), new File(CONFIG_XML_FILE));
    }

    public void addDebugCertificate(String debugCertPath) {
        this.mDebugCertFilePath = debugCertPath;
    }

    private void initialize() {
        Object r0 = this.mUpdatableFontDirLock;
        monitor-enter(r0);
        this.mUpdatableFontDir = createUpdatableFontDir();     // Catch: Throwable -> L9
        if (this.mUpdatableFontDir != null) goto L11;
        Typeface.loadPreinstalledSystemFontMap();     // Catch: Throwable -> L9
        setSerializedFontMap(serializeSystemServerFontMap());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mUpdatableFontDir.loadFontFileMap();     // Catch: Throwable -> L9
        updateSerializedFontMap();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public Context getContext() {
        return this.mContext;
    }

    SharedMemory getCurrentFontMap() {
        Object r0 = this.mSerializedFontMapLock;
        monitor-enter(r0);
        SharedMemory r1 = this.mSerializedFontMap;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void update(int baseVersion, List<FontUpdateRequest> requests) throws SystemFontException {
        Object r0 = this.mUpdatableFontDirLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mUpdatableFontDir == null) goto L19;
        if (baseVersion == (-1)) goto L15;
        if (this.mUpdatableFontDir.getConfigVersion() == baseVersion) goto L15;
        throw new SystemFontException(-8, "The base config version is older than current.");     // Catch: Throwable -> L13
    L15:
        this.mUpdatableFontDir.update(requests);     // Catch: Throwable -> L13
        updateSerializedFontMap();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L19:
        throw new SystemFontException(-7, "The font updater is disabled.");     // Catch: Throwable -> L13
    }

    void clearUpdates() {
        UpdatableFontDir.deleteAllFiles(new File(FONT_FILES_DIR), new File(CONFIG_XML_FILE));
        initialize();
    }

    void restart() {
        initialize();
    }

    Map<String, File> getFontFileMap() {
        Object r0 = this.mUpdatableFontDirLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mUpdatableFontDir != null) goto L11;
        Map<String, File> r1 = Collections.emptyMap();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        Map<String, File> r2 = this.mUpdatableFontDir.getPostScriptMap();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    }

    public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, writer) == true) goto L5;
        return;
    L5:
        new FontManagerShellCommand(this).dumpAll(new IndentingPrintWriter(writer, "  "));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver result) {
        new FontManagerShellCommand(this).exec(this, in, out, err, args, callback, result);
    }

    public FontConfig getSystemFontConfig() {
        Object r0 = this.mUpdatableFontDirLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mUpdatableFontDir != null) goto L11;
        FontConfig r1 = SystemFonts.getSystemPreinstalledFontConfig();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        FontConfig r2 = this.mUpdatableFontDir.getSystemFontConfig();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    }

    private void updateSerializedFontMap() {
        SharedMemory serializedFontMap = serializeFontMap(getSystemFontConfig());
        if (serializedFontMap != null) goto L5;
        serializedFontMap = serializeSystemServerFontMap();
    L5:
        setSerializedFontMap(serializedFontMap);
    }

    private static SharedMemory serializeFontMap(FontConfig fontConfig) {
        ArrayMap<String, ByteBuffer> bufferCache = new ArrayMap();
        Map<String, FontFamily[]> fallback = SystemFonts.buildSystemFallback(fontConfig, bufferCache);     // Catch: Throwable -> L12 Throwable -> L14
        Map<String, Typeface> typefaceMap = SystemFonts.buildSystemTypefaces(fontConfig, fallback);     // Catch: Throwable -> L12 Throwable -> L14
        SharedMemory r3 = Typeface.serializeFontMap(typefaceMap);     // Catch: Throwable -> L12 Throwable -> L14
        Iterator<ByteBuffer> r4 = bufferCache.values().iterator();
    L6:
        if (r4.hasNext() == false) goto L11;
        ByteBuffer buffer = r4.next();
        if ((buffer instanceof DirectByteBuffer) == false) goto L6;
        NioUtils.freeDirectBuffer(buffer);
        goto L6
    L11:
        return r3;
    L12:
        th = move-exception;
        Iterator<ByteBuffer> r2 = bufferCache.values().iterator();
    L27:
        if (r2.hasNext() == false) goto L32;
        ByteBuffer buffer2 = r2.next();
        if ((buffer2 instanceof DirectByteBuffer) == false) goto L27;
        NioUtils.freeDirectBuffer(buffer2);
        goto L27
    L32:
        throw th;
    L14:
        e = move-exception;
        Slog.w(TAG, "Failed to serialize updatable font map. Retrying with system image fonts.", e);     // Catch: Throwable -> L12
        Iterator<ByteBuffer> r5 = bufferCache.values().iterator();
    L18:
        if (r5.hasNext() == false) goto L23;
        ByteBuffer buffer3 = r5.next();
        if ((buffer3 instanceof DirectByteBuffer) == false) goto L18;
        NioUtils.freeDirectBuffer(buffer3);
        goto L18
    L23:
        return null;
    }

    private static SharedMemory serializeSystemServerFontMap() {
        return Typeface.serializeFontMap(Typeface.getSystemFontMap());
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to serialize SystemServer system font map", e);
        return null;
    }

    private void setSerializedFontMap(SharedMemory serializedFontMap) {
        Object r1 = this.mSerializedFontMapLock;
        monitor-enter(r1);
        SharedMemory oldFontMap = this.mSerializedFontMap;     // Catch: Throwable -> L9
        this.mSerializedFontMap = serializedFontMap;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        if (oldFontMap == null) goto L14;
        oldFontMap.close();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
