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
import androidx.core.util.ObjectsCompat;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
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
    private String mAuthority;
    private PathStrategy mLocalPathStrategy;
    private final Object mLock;
    private final int mResourceId;

    /* JADX INFO: loaded from: classes6.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static File[] getExternalMediaDirs(Context r100) {
            return r100.getExternalMediaDirs();
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface PathStrategy {
        File getFileForUri(Uri r100);

        Uri getUriForFile(File r100);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class SimplePathStrategy implements PathStrategy {
        private final String mAuthority;
        private final HashMap<String, File> mRoots;

        public SimplePathStrategy(String r100) {
            this.mRoots = new HashMap();
            this.mAuthority = r100;
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public File getFileForUri(Uri r100) {
            String r101 = r100.getEncodedPath();
            int r102 = r101.indexOf(47, 1);
            String r103 = Uri.decode(r101.substring(1, r102));
            String r104 = Uri.decode(r101.substring(r102 + 1));
            File r105 = this.mRoots.get(r103);
            if (r105 == null) goto L14;
            File r106 = new File(r105, r104);
            File r107 = r106.getCanonicalFile();     // Catch: IOException -> L11
            if (belongsToRoot(r107.getPath(), r105.getPath()) == false) goto L10;
            return r107;
        L10:
            throw new SecurityException("Resolved path jumped beyond configured root");
        L12:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r106);
        L14:
            throw new IllegalArgumentException("Unable to find configured root for " + r100);
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public Uri getUriForFile(File r100) {
            String r101 = r100.getCanonicalPath();     // Catch: IOException -> L21
            Iterator<Map.Entry<String, File>> r102 = this.mRoots.entrySet().iterator();
            Map.Entry<String, File> r103 = null;
        L5:
            if (r102.hasNext() == false) goto L12;
            Map.Entry<String, File> r104 = r102.next();
            String r105 = r104.getValue().getPath();
            if (belongsToRoot(r101, r105) == false) goto L5;
            if (r103 == null) goto L11;
            if (r105.length() <= r103.getValue().getPath().length()) goto L5;
        L11:
            r103 = r104;
            goto L5
        L12:
            if (r103 == null) goto L20;
            String r106 = r103.getValue().getPath();
            if (r106.endsWith(HTTP.URL_DEFAULT) == false) goto L16;
            String r107 = r101.substring(r106.length());
        L18:
            return new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath(Uri.encode(r103.getKey()) + '/' + Uri.encode(r107, HTTP.URL_DEFAULT)).build();
        L16:
            r107 = r101.substring(r106.length() + 1);
            goto L18
        L20:
            throw new IllegalArgumentException("Failed to find configured root that contains " + r101);
        L22:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r100);
        }

        private boolean belongsToRoot(String r100, String r101) {
            String r102 = FileProvider.access$000(r100);
            String r103 = FileProvider.access$000(r101);
            if (r102.equals(r103) == false) goto L5;
        L8:
            return true;
        L5:
            if (r102.startsWith(r103 + '/') == true) goto L8;
            return false;
        }

        public void addRoot(String r100, File r101) {
            if (TextUtils.isEmpty(r100) == true) goto L11;
            this.mRoots.put(r100, r101.getCanonicalFile());
            return;
        L7:
            e = move-exception;
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r101, e);
        L11:
            throw new IllegalArgumentException("Name must not be empty");
        }
    }

    public FileProvider() {
        this(0);
    }

    @Override // android.content.ContentProvider
    public String getTypeAnonymous(Uri r100) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    static {
        COLUMNS = new String[]{"_display_name", "_size"};
        DEVICE_ROOT = new File(HTTP.URL_DEFAULT);
        sCache = new HashMap();
    }

    private PathStrategy getLocalPathStrategy() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        ObjectsCompat.requireNonNull(this.mAuthority, "mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");     // Catch: Throwable -> L10
        if (this.mLocalPathStrategy != null) goto L7;
        this.mLocalPathStrategy = getPathStrategy(getContext(), this.mAuthority, this.mResourceId);     // Catch: Throwable -> L10
    L7:
        PathStrategy r101 = this.mLocalPathStrategy;     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public FileProvider(int r100) {
        this.mLock = new Object();
        this.mResourceId = r100;
    }

    public static /* synthetic */ String access$000(String r100) {
        return removeTrailingSlash(r100);
    }

    private static int modeToMode(String r100) {
        if ("r".equals(r100) == false) goto L6;
        return 268435456;
    L6:
        if ("w".equals(r100) == false) goto L8;
    L21:
        return 738197504;
    L8:
        if ("wt".equals(r100) == true) goto L21;
        if ("wa".equals(r100) == false) goto L14;
        return 704643072;
    L14:
        if ("rw".equals(r100) == false) goto L17;
        return 939524096;
    L17:
        if ("rwt".equals(r100) == false) goto L20;
        return 1006632960;
    L20:
        throw new IllegalArgumentException("Invalid mode: " + r100);
    }

    private static String removeTrailingSlash(String r100) {
        if (r100.length() > 0) goto L5;
        return r100;
    L5:
        if (r100.charAt(r100.length() - 1) == '/') goto L7;
        return r100;
    L7:
        return r100.substring(0, r100.length() - 1);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        File r101 = getLocalPathStrategy().getFileForUri(r100);
        int r102 = r101.getName().lastIndexOf(46);
        if (r102 < 0) goto L7;
        String r103 = r101.getName().substring(r102 + 1);
        String r104 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r103);
        if (r104 == null) goto L9;
        return r104;
    L9:
        return "application/octet-stream";
    L7:
        return "application/octet-stream";
    }

    private static File buildPath(File r100, String... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        String r104 = r101[r103];
        if (r104 == null) goto L7;
        r100 = new File(r100, r104);
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        return r100;
    }

    private static Object[] copyOf(Object[] r100, int r101) {
        Object[] r102 = new Object[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r100, ProviderInfo r101) {
        super.attachInfo(r100, r101);
        if (r101.exported == true) goto L24;
        if (r101.grantUriPermissions == false) goto L22;
        String r102 = r101.authority.split(com.alipay.sdk.m.u.i.f25853b)[0];
        Object r103 = this.mLock;
        monitor-enter(r103);
        this.mAuthority = r102;     // Catch: Throwable -> L18
        monitor-exit(r103);     // Catch: Throwable -> L18
        HashMap<String, PathStrategy> r104 = sCache;
        monitor-enter(r104);
        r104.remove(r102);     // Catch: Throwable -> L15
        monitor-exit(r104);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        th = move-exception;
        throw th;
    L22:
        throw new SecurityException("Provider must grant uri permissions");
    L24:
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri r100, String r101) throws FileNotFoundException {
        return ParcelFileDescriptor.open(getLocalPathStrategy().getFileForUri(r100), modeToMode(r101));
    }

    private static String[] copyOf(String[] r100, int r101) {
        String[] r102 = new String[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }

    private static PathStrategy getPathStrategy(Context r100, String r101, int r102) {
        HashMap<String, PathStrategy> r103 = sCache;
        monitor-enter(r103);
        PathStrategy r104 = r103.get(r101);     // Catch: Throwable -> L16
        if (r104 == null) goto L20;
    L14:
        monitor-exit(r103);     // Catch: Throwable -> L16
        return r104;
    L20:
        r104 = parsePathStrategy(r100, r101, r102);     // Catch: XmlPullParserException -> L8 IOException -> L11 Throwable -> L16
        r103.put(r101, r104);     // Catch: Throwable -> L16
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

    public static Uri getUriForFile(Context r100, String r101, File r102) {
        return getPathStrategy(r100, r101, 0).getUriForFile(r102);
    }

    private static PathStrategy parsePathStrategy(Context r100, String r101, int r102) throws IOException, XmlPullParserException {
        SimplePathStrategy r103 = new SimplePathStrategy(r101);
        XmlResourceParser r104 = getFileProviderPathsMetaData(r100, r101, r100.getPackageManager().resolveContentProvider(r101, 128), r102);
    L3:
        int r105 = r104.next();
        if (r105 == 1) goto L36;
        if (r105 != 2) goto L3;
        String r106 = r104.getName();
        File r107 = null;
        String r108 = r104.getAttributeValue(null, "name");
        String r109 = r104.getAttributeValue(null, "path");
        if (TAG_ROOT_PATH.equals(r106) == false) goto L11;
        r107 = DEVICE_ROOT;
    L34:
        if (r107 == null) goto L3;
        r103.addRoot(r108, buildPath(r107, new String[]{r109}));
        goto L3
    L11:
        if (TAG_FILES_PATH.equals(r106) == false) goto L14;
        r107 = r100.getFilesDir();
        goto L34
    L14:
        if (TAG_CACHE_PATH.equals(r106) == false) goto L17;
        r107 = r100.getCacheDir();
        goto L34
    L17:
        if (TAG_EXTERNAL.equals(r106) == false) goto L20;
        r107 = Environment.getExternalStorageDirectory();
        goto L34
    L20:
        if (TAG_EXTERNAL_FILES.equals(r106) == false) goto L25;
        File[] r110 = ContextCompat.getExternalFilesDirs(r100, null);
        if (r110.length <= 0) goto L34;
        r107 = r110[0];
        goto L34
    L25:
        if (TAG_EXTERNAL_CACHE.equals(r106) == false) goto L30;
        File[] r111 = ContextCompat.getExternalCacheDirs(r100);
        if (r111.length <= 0) goto L34;
        r107 = r111[0];
        goto L34
    L30:
        if (TAG_EXTERNAL_MEDIA.equals(r106) == false) goto L34;
        File[] r112 = Api21Impl.getExternalMediaDirs(r100);
        if (r112.length <= 0) goto L34;
        r107 = r112[0];
        goto L34
    L36:
        return r103;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return getLocalPathStrategy().getFileForUri(r100).delete() ? 1 : 0;
    }

    public static XmlResourceParser getFileProviderPathsMetaData(Context r100, String r101, ProviderInfo r102, int r103) {
        if (r102 == null) goto L13;
        if (r102.metaData != null) goto L7;
        if (r103 == 0) goto L7;
        Bundle r104 = new Bundle(1);
        r102.metaData = r104;
        r104.putInt(META_DATA_FILE_PROVIDER_PATHS, r103);
    L7:
        XmlResourceParser r105 = r102.loadXmlMetaData(r100.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (r105 == null) goto L11;
        return r105;
    L11:
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    L13:
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + r101);
    }

    public static Uri getUriForFile(Context r100, String r101, File r102, String r103) {
        return getUriForFile(r100, r101, r102).buildUpon().appendQueryParameter("displayName", r103).build();
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r110, String r111) {
        File r103 = getLocalPathStrategy().getFileForUri(r100);
        String r104 = UriProtector.getQueryParameter(r100, "displayName");
        if (r101 != null) goto L5;
        r101 = COLUMNS;
    L5:
        String[] r112 = new String[r101.length];
        Object[] r113 = new Object[r101.length];
        int r105 = r101.length;
        int r106 = 0;
        int r107 = 0;
    L6:
        if (r106 >= r105) goto L19;
        String r108 = r101[r106];
        if ("_display_name".equals(r108) == false) goto L15;
        r112[r107] = "_display_name";
        int r109 = r107 + 1;
        if (r104 != null) goto L12;
        String r114 = r103.getName();
    L13:
        r113[r107] = r114;
    L17:
        r107 = r109;
    L18:
        r106 = r106 + 1;
        goto L6
    L12:
        r114 = r104;
        goto L13
    L15:
        if ("_size".equals(r108) == false) goto L18;
        r112[r107] = "_size";
        r109 = r107 + 1;
        r113[r107] = Long.valueOf(r103.length());
        goto L17
    L19:
        String[] r115 = copyOf(r112, r107);
        Object[] r116 = copyOf(r113, r107);
        MatrixCursor r117 = new MatrixCursor(r115, 1);
        r117.addRow(r116);
        return r117;
    }
}
