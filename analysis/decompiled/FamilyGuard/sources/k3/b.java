package k3;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class b {
    public static void a(Intent intent, int i5) {
        intent.putExtra("scale", true).putExtra("scaleUpIfNeeded", true).putExtra("aspectX", 1).putExtra("aspectY", 1).putExtra("outputMaxX", i5).putExtra("outputMaxY", i5).putExtra("drawDashCircle", true);
    }

    public static void b(Intent intent, Uri uri) {
        intent.putExtra("output", uri);
        intent.addFlags(3);
        intent.setClipData(ClipData.newRawUri("output", uri));
    }

    public static boolean c(Context context, Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        try {
            if ("content".equals(scheme)) {
                return context.getContentResolver().delete(uri, null, null) > 0;
            }
            if ("file".equals(scheme)) {
                return new File(uri.getPath()).delete();
            }
            return false;
        } catch (SecurityException e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static Uri d(Context context) {
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName(), new File(h(context, e())));
        g(context, uriForFile);
        return uriForFile;
    }

    private static String e() {
        Date date = new Date(System.currentTimeMillis());
        return "ContactPhoto-" + new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss", Locale.US).format(date) + "-cropped.jpg";
    }

    public static Intent f(Context context, Uri uri, Uri uri2, int i5, String str) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setPackage("com.stepos.media.gallery");
        if (TextUtils.isEmpty(str)) {
            intent.setDataAndType(uri, "image/*");
        } else {
            intent.setDataAndType(uri, str);
        }
        g(context, uri2);
        b(intent, uri2);
        a(intent, i5);
        return intent;
    }

    public static void g(Context context, Uri uri) {
        context.grantUriPermission("com.stepos.media.camera", uri, 1);
        context.grantUriPermission("com.stepos.media.gallery", uri, 1);
        context.grantUriPermission(context.getPackageName(), uri, 1);
        context.grantUriPermission(context.getPackageName(), uri, 2);
        context.grantUriPermission("com.stepos.media.camera", uri, 2);
        context.grantUriPermission("com.stepos.media.gallery", uri, 2);
    }

    private static String h(Context context, String str) {
        File cacheDir = context.getCacheDir();
        cacheDir.mkdirs();
        return new File(cacheDir, str).getAbsolutePath();
    }
}
