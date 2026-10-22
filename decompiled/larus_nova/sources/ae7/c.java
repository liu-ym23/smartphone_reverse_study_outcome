package ae7;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3110a = null;

    static {
        f3110a = Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + Environment.DIRECTORY_DCIM + "/Camera";
    }

    public static String f(String r100) {
        int r101 = r100.length();
        char[] r102 = r100.toCharArray();
        int r103 = 0;
        char r104 = 0;
        int r105 = 0;
    L4:
        if (r103 >= r101) goto L10;
        char r106 = r102[r103];
        if (r106 != '/') goto L8;
        if (r104 != '/') goto L8;
    L9:
        r103 = r103 + 1;
        r104 = r106;
    L8:
        r102[r105] = r106;
        r105 = r105 + 1;
        goto L9
    L10:
        if (r104 == '/') goto L12;
    L14:
        if (r105 != r101) goto L16;
        return r100;
    L16:
        return new String(r102, 0, r105);
    L12:
        if (r101 <= 1) goto L14;
        r105 = r105 - 1;
        goto L14
    }

    public static boolean g(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L16;
        boolean r101 = "mounted".equals(Environment.getExternalStorageState());     // Catch: Exception -> L6
    L7:
        if (r101 == false) goto L17;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L11;
        return false;
    L11:
        if (r102.delete() == false) goto L19;
        return true;
    L19:
        return false;
    L17:
        return false;
    L6:
        r101 = false;
        goto L7
    L16:
        return false;
    }

    public static void b(PolarisFileInputStreamWrapper r100, OutputStream r101) throws IOException {
        byte[] r102 = new byte[4096];     // Catch: Throwable -> L15
        if (r101 == null) goto L14;
    L5:
        int r103 = r100.read(r102);     // Catch: Throwable -> L15
        if (r103 <= 0) goto L7;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L15
        goto L5
    L7:
        r101.flush();     // Catch: Throwable -> L15
        r100.close();     // Catch: IOException -> L20
    L24:
        r101.close();     // Catch: IOException -> L21
        return;
    L34:
        return;
    L14:
        throw new IOException("Failed to copy input:" + r100 + "output:" + r101);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r100.close();     // Catch: IOException -> L22
    L17:
        if (r101 == null) goto L35;
        r101.close();     // Catch: IOException -> L23
        throw th;
    L36:
        throw th;
    L35:
        throw th;
    }

    public static boolean e(Context r100, Uri r101) {
        if (r100 != null) goto L14;
    L11:
        return false;
    L14:
        AssetFileDescriptor r102 = ContentResolverWrapper.openAssetFileDescriptor(r100.getContentResolver(), r101, "r");     // Catch: FileNotFoundException -> L13
        if (r102 != null) goto L16;
        return false;
    L16:
        r102.close();     // Catch: IOException -> L12
        return true;
    L18:
        return true;
    }

    public static Uri a(ContentResolver r110, Uri r111, ContentValues r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240017);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (Uri) r107.f474983b;
    L21:
        return r110.insert(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Uri c(Context r100, String r101, String r102) {
        PolarisFileWrapper r103 = new PolarisFileWrapper(f3110a);
        if (r103.exists() == true) goto L5;
        r103.mkdirs();
    L5:
        String r104 = Environment.DIRECTORY_DCIM + "/Camera/";
        if (r100 != null) goto L8;
    L22:
        return null;
    L8:
        if (TextUtils.isEmpty(r101) == true) goto L22;
        if (TextUtils.isEmpty(r104) == true) goto L22;
        if (r104.endsWith(HTTP.URL_DEFAULT) == true) goto L14;
        r104 = r104.concat(HTTP.URL_DEFAULT);
    L14:
        ContentValues r105 = new ContentValues();
        r105.put("_display_name", r101);
        r105.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        r105.put("mime_type", r102);
        if (Build.VERSION.SDK_INT < 29) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == false) goto L20;
        Uri r107 = MediaStore.Images.Media.getContentUri("external_primary");
        r105.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r104);
    L24:
        return a(r100.getContentResolver(), r107, r105);
    L20:
        Uri r108 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        r105.put("_data", f(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + r104 + HTTP.URL_DEFAULT + r101));
        r107 = r108;
        goto L24
    L17:
        r106 = false;
        goto L18
    }

    public static Uri d(Context r100, String r101, String r102) {
        ContentValues r103 = new ContentValues();
        r103.put("title", r101);
        r103.put("_display_name", r101);
        r103.put("mime_type", r102);
        return a(r100.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r103);
    }
}
