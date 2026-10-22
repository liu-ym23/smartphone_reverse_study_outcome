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
import androidx.annotation.DoNotInline;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.toolbox.ServerElements;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f2512c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final File f2513d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap f2514e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PathStrategy f2515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2516b;

    public interface PathStrategy {
        File getFileForUri(Uri r10);

        Uri getUriForFile(File r10);
    }

    public static class a {
        @DoNotInline
        public static File[] a(Context r10) {
            return r10.getExternalMediaDirs();
        }
    }

    public static class b implements PathStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap f2518b;

        public b(String r10) {
            this.f2518b = new HashMap();
            this.f2517a = r10;
        }

        public void a(String r10, File r11) {
            if (TextUtils.isEmpty(r10) == true) goto L11;
            this.f2518b.put(r10, r11.getCanonicalFile());
            return;
        L7:
            e = move-exception;
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r11, e);
        L11:
            throw new IllegalArgumentException("Name must not be empty");
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public File getFileForUri(Uri r10) {
            String r11 = r10.getEncodedPath();
            int r12 = r11.indexOf(47, 1);
            String r13 = Uri.decode(r11.substring(1, r12));
            String r14 = Uri.decode(r11.substring(r12 + 1));
            File r15 = (File) this.f2518b.get(r13);
            if (r15 == null) goto L14;
            File r16 = new File(r15, r14);
            File r17 = r16.getCanonicalFile();     // Catch: IOException -> L11
            if (r17.getPath().startsWith(r15.getPath()) == false) goto L10;
            return r17;
        L10:
            throw new SecurityException("Resolved path jumped beyond configured root");
        L12:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r16);
        L14:
            throw new IllegalArgumentException("Unable to find configured root for " + r10);
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public Uri getUriForFile(File r10) {
            String r11 = r10.getCanonicalPath();     // Catch: IOException -> L21
            Iterator r12 = this.f2518b.entrySet().iterator();
            Map.Entry r13 = null;
        L5:
            if (r12.hasNext() == false) goto L12;
            Map.Entry r14 = (Map.Entry) r12.next();
            String r15 = ((File) r14.getValue()).getPath();
            if (r11.startsWith(r15) == false) goto L5;
            if (r13 == null) goto L11;
            if (r15.length() <= ((File) r13.getValue()).getPath().length()) goto L5;
        L11:
            r13 = r14;
            goto L5
        L12:
            if (r13 == null) goto L20;
            String r16 = ((File) r13.getValue()).getPath();
            if (r16.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L16;
            String r17 = r11.substring(r16.length());
        L18:
            return new Uri.Builder().scheme(ServerElements.CONTENT).authority(this.f2517a).encodedPath(Uri.encode((String) r13.getKey()) + '/' + Uri.encode(r17, LibrarianImpl.Constants.SEPARATOR)).build();
        L16:
            r17 = r11.substring(r16.length() + 1);
            goto L18
        L20:
            throw new IllegalArgumentException("Failed to find configured root that contains " + r11);
        L22:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r10);
        }
    }

    static {
        f2512c = new String[]{"_display_name", "_size"};
        f2513d = new File(LibrarianImpl.Constants.SEPARATOR);
        f2514e = new HashMap();
    }

    public FileProvider() {
        this.f2516b = 0;
    }

    public static File a(File r10, String... r11) {
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        String r14 = r11[r13];
        if (r14 == null) goto L7;
        r10 = new File(r10, r14);
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        return r10;
    }

    public static Object[] b(Object[] r10, int r11) {
        Object[] r12 = new Object[r11];
        System.arraycopy(r10, 0, r12, 0, r11);
        return r12;
    }

    public static String[] c(String[] r10, int r11) {
        String[] r12 = new String[r11];
        System.arraycopy(r10, 0, r12, 0, r11);
        return r12;
    }

    public static XmlResourceParser d(Context r10, String r11, ProviderInfo r12, int r13) {
        if (r12 == null) goto L13;
        if (r12.metaData != null) goto L7;
        if (r13 == 0) goto L7;
        Bundle r14 = new Bundle(1);
        r12.metaData = r14;
        r14.putInt("android.support.FILE_PROVIDER_PATHS", r13);
    L7:
        XmlResourceParser r15 = r12.loadXmlMetaData(r10.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (r15 == null) goto L11;
        return r15;
    L11:
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    L13:
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + r11);
    }

    public static PathStrategy e(Context r10, String r11, int r12) {
        HashMap r13 = f2514e;
        monitor-enter(r13);
        PathStrategy r14 = (PathStrategy) r13.get(r11);     // Catch: Throwable -> L8
        if (r14 == null) goto L21;
    L16:
        monitor-exit(r13);     // Catch: Throwable -> L8
        return r14;
    L21:
        r14 = h(r10, r11, r12);     // Catch: Throwable -> L8 XmlPullParserException -> L10 IOException -> L13
        r13.put(r11, r14);     // Catch: Throwable -> L8
        goto L16
    L13:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L8
    L10:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public static Uri f(Context r10, String r11, File r12) {
        return e(r10, r11, 0).getUriForFile(r12);
    }

    public static int g(String r10) {
        if ("r".equals(r10) == false) goto L6;
        return 268435456;
    L6:
        if ("w".equals(r10) == false) goto L8;
    L21:
        return 738197504;
    L8:
        if ("wt".equals(r10) == true) goto L21;
        if ("wa".equals(r10) == false) goto L14;
        return 704643072;
    L14:
        if ("rw".equals(r10) == false) goto L17;
        return 939524096;
    L17:
        if ("rwt".equals(r10) == false) goto L20;
        return 1006632960;
    L20:
        throw new IllegalArgumentException("Invalid mode: " + r10);
    }

    public static PathStrategy h(Context r10, String r11, int r12) {
        b r13 = new b(r11);
        XmlResourceParser r14 = d(r10, r11, r10.getPackageManager().resolveContentProvider(r11, 128), r12);
    L3:
        int r15 = r14.next();
        if (r15 == 1) goto L36;
        if (r15 != 2) goto L3;
        String r16 = r14.getName();
        File r17 = null;
        String r18 = r14.getAttributeValue(null, "name");
        String r19 = r14.getAttributeValue(null, "path");
        if ("root-path".equals(r16) == false) goto L11;
        r17 = f2513d;
    L34:
        if (r17 == null) goto L3;
        r13.a(r18, a(r17, new String[]{r19}));
        goto L3
    L11:
        if ("files-path".equals(r16) == false) goto L14;
        r17 = r10.getFilesDir();
        goto L34
    L14:
        if ("cache-path".equals(r16) == false) goto L17;
        r17 = r10.getCacheDir();
        goto L34
    L17:
        if ("external-path".equals(r16) == false) goto L20;
        r17 = Environment.getExternalStorageDirectory();
        goto L34
    L20:
        if ("external-files-path".equals(r16) == false) goto L25;
        File[] r20 = ContextCompat.f(r10, null);
        if (r20.length <= 0) goto L34;
        r17 = r20[0];
        goto L34
    L25:
        if ("external-cache-path".equals(r16) == false) goto L30;
        File[] r21 = ContextCompat.e(r10);
        if (r21.length <= 0) goto L34;
        r17 = r21[0];
        goto L34
    L30:
        if ("external-media-path".equals(r16) == false) goto L34;
        File[] r22 = a.a(r10);
        if (r22.length <= 0) goto L34;
        r17 = r22[0];
        goto L34
    L36:
        return r13;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r10, ProviderInfo r11) {
        super.attachInfo(r10, r11);
        if (r11.exported == true) goto L18;
        if (r11.grantUriPermissions == false) goto L16;
        String r12 = r11.authority.split(";")[0];
        HashMap r13 = f2514e;
        monitor-enter(r13);
        r13.remove(r12);     // Catch: Throwable -> L12
        monitor-exit(r13);     // Catch: Throwable -> L12
        this.f2515a = e(r10, r12, this.f2516b);
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new SecurityException("Provider must grant uri permissions");
    L18:
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        return this.f2515a.getFileForUri(r10).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        File r11 = this.f2515a.getFileForUri(r10);
        int r12 = r11.getName().lastIndexOf(46);
        if (r12 < 0) goto L7;
        String r13 = r11.getName().substring(r12 + 1);
        String r14 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r13);
        if (r14 == null) goto L9;
        return r14;
    L9:
        return "application/octet-stream";
    L7:
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri r10, String r11) {
        return ParcelFileDescriptor.open(this.f2515a.getFileForUri(r10), g(r11));
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        File r15 = this.f2515a.getFileForUri(r10);
        String r16 = r10.getQueryParameter("displayName");
        if (r11 != null) goto L5;
        r11 = f2512c;
    L5:
        String[] r17 = new String[r11.length];
        Object[] r18 = new Object[r11.length];
        int r19 = r11.length;
        int r20 = 0;
        int r21 = 0;
    L6:
        if (r20 >= r19) goto L19;
        String r22 = r11[r20];
        if ("_display_name".equals(r22) == false) goto L16;
        r17[r21] = "_display_name";
        int r23 = r21 + 1;
        if (r16 != null) goto L12;
        String r24 = r15.getName();
    L13:
        r18[r21] = r24;
    L14:
        r21 = r23;
    L18:
        r20 = r20 + 1;
        goto L6
    L12:
        r24 = r16;
        goto L13
    L16:
        if ("_size".equals(r22) == false) goto L18;
        r17[r21] = "_size";
        r23 = r21 + 1;
        r18[r21] = Long.valueOf(r15.length());
        goto L14
    L19:
        String[] r25 = c(r17, r21);
        Object[] r26 = b(r18, r21);
        MatrixCursor r27 = new MatrixCursor(r25, 1);
        r27.addRow(r26);
        return r27;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        throw new UnsupportedOperationException("No external updates");
    }
}
