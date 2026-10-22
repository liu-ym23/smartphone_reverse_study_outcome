package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import com.fasterxml.jackson.core.JsonPointer;
import g5.f;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private String mAuthority;
    private a mLocalPathStrategy;
    private final Object mLock = new Object();
    private final int mResourceId;
    private static final String[] COLUMNS = {"_display_name", "_size"};
    private static final File DEVICE_ROOT = new File("/");
    private static final HashMap<String, a> sCache = new HashMap<>();

    public c(int i) {
        this.mResourceId = i;
    }

    public static String access$000(String str) {
        return (str.length() <= 0 || str.charAt(str.length() + (-1)) != '/') ? str : str.substring(0, str.length() - 1);
    }

    public static a b(Context context, String str, int i) {
        a aVarC;
        HashMap<String, a> map = sCache;
        synchronized (map) {
            try {
                aVarC = map.get(str);
                if (aVarC == null) {
                    try {
                        try {
                            aVarC = c(context, str, i);
                            map.put(str, aVarC);
                        } catch (IOException e10) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e10);
                        }
                    } catch (XmlPullParserException e11) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e11);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVarC;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.core.content.b c(android.content.Context r6, java.lang.String r7, int r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            androidx.core.content.b r0 = new androidx.core.content.b
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r0.f1040b = r1
            r0.f1039a = r7
            java.lang.invoke.VarHandle.storeStoreFence()
            android.content.pm.PackageManager r1 = r6.getPackageManager()
            r2 = 128(0x80, float:1.8E-43)
            android.content.pm.ProviderInfo r1 = r1.resolveContentProvider(r7, r2)
            android.content.res.XmlResourceParser r7 = getFileProviderPathsMetaData(r6, r7, r1, r8)
        L1f:
            int r8 = r7.next()
            r1 = 1
            if (r8 == r1) goto Le0
            r1 = 2
            if (r8 != r1) goto L1f
            java.lang.String r8 = r7.getName()
            java.lang.String r1 = "name"
            r2 = 0
            java.lang.String r1 = r7.getAttributeValue(r2, r1)
            java.lang.String r3 = "path"
            java.lang.String r3 = r7.getAttributeValue(r2, r3)
            java.lang.String r4 = "root-path"
            boolean r4 = r4.equals(r8)
            r5 = 0
            if (r4 == 0) goto L46
            java.io.File r8 = androidx.core.content.c.DEVICE_ROOT
            goto La4
        L46:
            java.lang.String r4 = "files-path"
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L53
            java.io.File r8 = r6.getFilesDir()
            goto La4
        L53:
            java.lang.String r4 = "cache-path"
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L60
            java.io.File r8 = r6.getCacheDir()
            goto La4
        L60:
            java.lang.String r4 = "external-path"
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L6d
            java.io.File r8 = android.os.Environment.getExternalStorageDirectory()
            goto La4
        L6d:
            java.lang.String r4 = "external-files-path"
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L7f
            java.io.File[] r8 = r6.getExternalFilesDirs(r2)
            int r4 = r8.length
            if (r4 <= 0) goto La3
            r8 = r8[r5]
            goto La4
        L7f:
            java.lang.String r4 = "external-cache-path"
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L91
            java.io.File[] r8 = r6.getExternalCacheDirs()
            int r4 = r8.length
            if (r4 <= 0) goto La3
            r8 = r8[r5]
            goto La4
        L91:
            java.lang.String r4 = "external-media-path"
            boolean r8 = r4.equals(r8)
            if (r8 == 0) goto La3
            java.io.File[] r8 = r6.getExternalMediaDirs()
            int r4 = r8.length
            if (r4 <= 0) goto La3
            r8 = r8[r5]
            goto La4
        La3:
            r8 = r2
        La4:
            if (r8 == 0) goto L1f
            java.lang.String[] r3 = new java.lang.String[]{r3}
            r3 = r3[r5]
            if (r3 == 0) goto Lb4
            java.io.File r4 = new java.io.File
            r4.<init>(r8, r3)
            r8 = r4
        Lb4:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto Lda
            java.io.File r8 = r8.getCanonicalFile()     // Catch: java.io.IOException -> Lc5
            java.util.HashMap r2 = r0.f1040b
            r2.put(r1, r8)
            goto L1f
        Lc5:
            r6 = move-exception
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Failed to resolve canonical path for "
            r0.<init>(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8, r6)
            throw r7
        Lda:
            java.lang.String r6 = "Name must not be empty"
            g5.f.s(r6)
            return r2
        Le0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.c.c(android.content.Context, java.lang.String, int):androidx.core.content.b");
    }

    public static XmlResourceParser getFileProviderPathsMetaData(Context context, String str, ProviderInfo providerInfo, int i) {
        if (providerInfo == null) {
            f.s(w2.c.b("Couldn't find meta-data for provider with authority ", str));
            return null;
        }
        if (providerInfo.metaData == null && i != 0) {
            Bundle bundle = new Bundle(1);
            providerInfo.metaData = bundle;
            bundle.putInt(META_DATA_FILE_PROVIDER_PATHS, i);
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (xmlResourceParserLoadXmlMetaData != null) {
            return xmlResourceParserLoadXmlMetaData;
        }
        f.s("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        return null;
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        b bVar = (b) b(context, str, 0);
        try {
            String canonicalPath = file.getCanonicalPath();
            Map.Entry entry = null;
            for (Map.Entry entry2 : bVar.f1040b.entrySet()) {
                String path = ((File) entry2.getValue()).getPath();
                if (access$000(canonicalPath).startsWith(access$000(path) + JsonPointer.SEPARATOR) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                    entry = entry2;
                }
            }
            if (entry == null) {
                f.s(w2.c.b("Failed to find configured root that contains ", canonicalPath));
                return null;
            }
            String path2 = ((File) entry.getValue()).getPath();
            return new Uri.Builder().scheme("content").authority(bVar.f1039a).encodedPath(Uri.encode((String) entry.getKey()) + JsonPointer.SEPARATOR + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
        } catch (IOException unused) {
            f.p(file, "Failed to resolve canonical path for ");
            return null;
        }
    }

    public final a a() {
        a aVar;
        synchronized (this.mLock) {
            try {
                if (this.mAuthority == null) {
                    throw new NullPointerException("mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
                }
                if (this.mLocalPathStrategy == null) {
                    this.mLocalPathStrategy = b(getContext(), this.mAuthority, this.mResourceId);
                }
                aVar = this.mLocalPathStrategy;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        String str = providerInfo.authority;
        if (str == null || str.trim().isEmpty()) {
            throw new SecurityException("Provider must have a non-empty authority");
        }
        String str2 = providerInfo.authority.split(";")[0];
        synchronized (this.mLock) {
            this.mAuthority = str2;
        }
        HashMap<String, a> map = sCache;
        synchronized (map) {
            map.remove(str2);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return ((b) a()).a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File fileA = ((b) a()).a(uri);
        int iLastIndexOf = fileA.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileA.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public String getTypeAnonymous(Uri uri) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"UnknownNullness"})
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        int i;
        File fileA = ((b) a()).a(uri);
        if ("r".equals(str)) {
            i = 268435456;
        } else if ("w".equals(str) || "wt".equals(str)) {
            i = 738197504;
        } else if ("wa".equals(str)) {
            i = 704643072;
        } else if ("rw".equals(str)) {
            i = 939524096;
        } else {
            if (!"rwt".equals(str)) {
                f.s(w2.c.b("Invalid mode: ", str));
                return null;
            }
            i = 1006632960;
        }
        return ParcelFileDescriptor.open(fileA, i);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File fileA = ((b) a()).a(uri);
        String queryParameter = uri.getQueryParameter(DISPLAYNAME_FIELD);
        if (strArr == null) {
            strArr = COLUMNS;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i3 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i3] = "_display_name";
                i = i3 + 1;
                objArr[i3] = queryParameter == null ? fileA.getName() : queryParameter;
            } else if ("_size".equals(str3)) {
                strArr3[i3] = "_size";
                i = i3 + 1;
                objArr[i3] = Long.valueOf(fileA.length());
            }
            i3 = i;
        }
        String[] strArr4 = new String[i3];
        System.arraycopy(strArr3, 0, strArr4, 0, i3);
        Object[] objArr2 = new Object[i3];
        System.arraycopy(objArr, 0, objArr2, 0, i3);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    @SuppressLint({"StreamFiles"})
    public static Uri getUriForFile(Context context, String str, File file, String str2) {
        return getUriForFile(context, str, file).buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, str2).build();
    }
}
