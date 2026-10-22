package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.aikernel.sdk.ext.Params;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class FileProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = null;
    private static final File DEVICE_ROOT = null;
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static final HashMap<String, PathStrategy> sCache = null;
    private int mResourceId;
    private PathStrategy mStrategy;

    static class Api21Impl {
        private Api21Impl() {
        }

        static File[] getExternalMediaDirs(Context r0) {
            return r0.getExternalMediaDirs();
        }
    }

    interface PathStrategy {
        File getFileForUri(Uri r1);

        Uri getUriForFile(File r1);
    }

    static class SimplePathStrategy implements PathStrategy {
        private final String mAuthority;
        private final HashMap<String, File> mRoots;

        SimplePathStrategy(String r2) {
            this.mRoots = new HashMap();
            this.mAuthority = r2;
        }

        void addRoot(String r3, File r4) {
            if (TextUtils.isEmpty(r3) == true) goto L11;
            this.mRoots.put(r3, r4.getCanonicalFile());
            return;
        L7:
            e = move-exception;
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r4, e);
        L11:
            throw new IllegalArgumentException("Name must not be empty");
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public Uri getUriForFile(File r6) {
            String r7 = r6.getCanonicalPath();     // Catch: IOException -> L21
            Iterator<Map.Entry<String, File>> r0 = this.mRoots.entrySet().iterator();
            Map.Entry<String, File> r1 = null;
        L5:
            if (r0.hasNext() == false) goto L12;
            Map.Entry<String, File> r2 = r0.next();
            String r3 = r2.getValue().getPath();
            if (r7.startsWith(r3) == false) goto L5;
            if (r1 == null) goto L11;
            if (r3.length() <= r1.getValue().getPath().length()) goto L5;
        L11:
            r1 = r2;
            goto L5
        L12:
            if (r1 == null) goto L20;
            String r4 = r1.getValue().getPath();
            if (r4.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L16;
            String r8 = r7.substring(r4.length());
        L18:
            return new Uri.Builder().scheme(Params.CONTENT).authority(this.mAuthority).encodedPath(Uri.encode(r1.getKey()) + '/' + Uri.encode(r8, LibrarianImpl.Constants.SEPARATOR)).build();
        L16:
            r8 = r7.substring(r4.length() + 1);
            goto L18
        L20:
            throw new IllegalArgumentException("Failed to find configured root that contains " + r7);
        L22:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r6);
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public File getFileForUri(Uri r5) {
            String r0 = r5.getEncodedPath();
            int r1 = r0.indexOf(47, 1);
            String r3 = Uri.decode(r0.substring(1, r1));
            String r2 = Uri.decode(r0.substring(r1 + 1));
            File r4 = this.mRoots.get(r3);
            if (r4 == null) goto L14;
            File r6 = new File(r4, r2);
            File r7 = r6.getCanonicalFile();     // Catch: IOException -> L11
            if (r7.getPath().startsWith(r4.getPath()) == false) goto L10;
            return r7;
        L10:
            throw new SecurityException("Resolved path jumped beyond configured root");
        L12:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r6);
        L14:
            throw new IllegalArgumentException("Unable to find configured root for " + r5);
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    static {
        COLUMNS = new String[]{"_display_name", "_size"};
        DEVICE_ROOT = new File(LibrarianImpl.Constants.SEPARATOR);
        sCache = new HashMap();
    }

    public FileProvider() {
        this.mResourceId = 0;
    }

    protected FileProvider(int r1) {
        this.mResourceId = r1;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r2, ProviderInfo r3) {
        super.attachInfo(r2, r3);
        if (r3.exported == true) goto L18;
        if (r3.grantUriPermissions == false) goto L16;
        String r4 = r3.authority.split(";")[0];
        HashMap<String, PathStrategy> r0 = sCache;
        monitor-enter(r0);
        r0.remove(r4);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        this.mStrategy = getPathStrategy(r2, r4, this.mResourceId);
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new SecurityException("Provider must grant uri permissions");
    L18:
        throw new SecurityException("Provider must not be exported");
    }

    public static Uri getUriForFile(Context r1, String r2, File r3) {
        return getPathStrategy(r1, r2, 0).getUriForFile(r3);
    }

    public static Uri getUriForFile(Context r0, String r1, File r2, String r3) {
        return getUriForFile(r0, r1, r2).buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, r3).build();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r6, String[] r7, String r8, String[] r9, String r10) {
        File r5 = this.mStrategy.getFileForUri(r6);
        String r11 = r6.getQueryParameter(DISPLAYNAME_FIELD);
        if (r7 != null) goto L5;
        r7 = COLUMNS;
    L5:
        String[] r12 = new String[r7.length];
        Object[] r13 = new Object[r7.length];
        int r14 = r7.length;
        int r0 = 0;
        int r1 = 0;
    L6:
        if (r0 >= r14) goto L19;
        String r2 = r7[r0];
        if ("_display_name".equals(r2) == false) goto L15;
        r12[r1] = "_display_name";
        int r3 = r1 + 1;
        if (r11 != null) goto L12;
        String r4 = r5.getName();
    L13:
        r13[r1] = r4;
    L17:
        r1 = r3;
    L18:
        r0 = r0 + 1;
        goto L6
    L12:
        r4 = r11;
        goto L13
    L15:
        if ("_size".equals(r2) == false) goto L18;
        r12[r1] = "_size";
        r3 = r1 + 1;
        r13[r1] = Long.valueOf(r5.length());
        goto L17
    L19:
        String[] r15 = copyOf(r12, r1);
        Object[] r16 = copyOf(r13, r1);
        MatrixCursor r17 = new MatrixCursor(r15, 1);
        r17.addRow(r16);
        return r17;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r2) {
        File r1 = this.mStrategy.getFileForUri(r2);
        int r3 = r1.getName().lastIndexOf(46);
        if (r3 < 0) goto L7;
        String r4 = r1.getName().substring(r3 + 1);
        String r5 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r4);
        if (r5 == null) goto L9;
        return r5;
    L9:
        return "application/octet-stream";
    L7:
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return this.mStrategy.getFileForUri(r1).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri r1, String r2) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(r1), modeToMode(r2));
    }

    private static PathStrategy getPathStrategy(Context r2, String r3, int r4) {
        HashMap<String, PathStrategy> r0 = sCache;
        monitor-enter(r0);
        PathStrategy r1 = r0.get(r3);     // Catch: Throwable -> L16
        if (r1 == null) goto L20;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r1;
    L20:
        r1 = parsePathStrategy(r2, r3, r4);     // Catch: XmlPullParserException -> L8 IOException -> L11 Throwable -> L16
        r0.put(r3, r1);     // Catch: Throwable -> L16
        goto L14
    L8:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L16
    L11:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    static XmlResourceParser getFileProviderPathsMetaData(Context r2, String r3, ProviderInfo r4, int r5) {
        if (r4 == null) goto L13;
        if (r4.metaData != null) goto L7;
        if (r5 == 0) goto L7;
        r4.metaData = new Bundle(1);
        r4.metaData.putInt(META_DATA_FILE_PROVIDER_PATHS, r5);
    L7:
        XmlResourceParser r6 = r4.loadXmlMetaData(r2.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (r6 == null) goto L11;
        return r6;
    L11:
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    L13:
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + r3);
    }

    private static PathStrategy parsePathStrategy(Context r7, String r8, int r9) throws IOException, XmlPullParserException {
        SimplePathStrategy r0 = new SimplePathStrategy(r8);
        XmlResourceParser r10 = getFileProviderPathsMetaData(r7, r8, r7.getPackageManager().resolveContentProvider(r8, 128), r9);
    L3:
        int r11 = r10.next();
        if (r11 == 1) goto L36;
        if (r11 != 2) goto L3;
        String r12 = r10.getName();
        File r3 = null;
        String r2 = r10.getAttributeValue(null, "name");
        String r4 = r10.getAttributeValue(null, "path");
        if (TAG_ROOT_PATH.equals(r12) == false) goto L11;
        r3 = DEVICE_ROOT;
    L34:
        if (r3 == null) goto L3;
        r0.addRoot(r2, buildPath(r3, new String[]{r4}));
        goto L3
    L11:
        if (TAG_FILES_PATH.equals(r12) == false) goto L14;
        r3 = r7.getFilesDir();
        goto L34
    L14:
        if (TAG_CACHE_PATH.equals(r12) == false) goto L17;
        r3 = r7.getCacheDir();
        goto L34
    L17:
        if (TAG_EXTERNAL.equals(r12) == false) goto L20;
        r3 = Environment.getExternalStorageDirectory();
        goto L34
    L20:
        if (TAG_EXTERNAL_FILES.equals(r12) == false) goto L25;
        File[] r13 = ContextCompat.getExternalFilesDirs(r7, null);
        if (r13.length <= 0) goto L34;
        r3 = r13[0];
        goto L34
    L25:
        if (TAG_EXTERNAL_CACHE.equals(r12) == false) goto L30;
        File[] r14 = ContextCompat.getExternalCacheDirs(r7);
        if (r14.length <= 0) goto L34;
        r3 = r14[0];
        goto L34
    L30:
        if (TAG_EXTERNAL_MEDIA.equals(r12) == false) goto L34;
        File[] r15 = Api21Impl.getExternalMediaDirs(r7);
        if (r15.length <= 0) goto L34;
        r3 = r15[0];
        goto L34
    L36:
        return r0;
    }

    private static int modeToMode(String r3) {
        if ("r".equals(r3) == false) goto L6;
        return 268435456;
    L6:
        if ("w".equals(r3) == false) goto L8;
    L21:
        return 738197504;
    L8:
        if ("wt".equals(r3) == true) goto L21;
        if ("wa".equals(r3) == false) goto L14;
        return 704643072;
    L14:
        if ("rw".equals(r3) == false) goto L17;
        return 939524096;
    L17:
        if ("rwt".equals(r3) == false) goto L20;
        return 1006632960;
    L20:
        throw new IllegalArgumentException("Invalid mode: " + r3);
    }

    private static File buildPath(File r4, String... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = r5[r1];
        if (r2 == null) goto L7;
        r4 = new File(r4, r2);
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r4;
    }

    private static String[] copyOf(String[] r2, int r3) {
        String[] r0 = new String[r3];
        System.arraycopy(r2, 0, r0, 0, r3);
        return r0;
    }

    private static Object[] copyOf(Object[] r2, int r3) {
        Object[] r0 = new Object[r3];
        System.arraycopy(r2, 0, r0, 0, r3);
        return r0;
    }
}
