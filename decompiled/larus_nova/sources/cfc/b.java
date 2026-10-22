package cfc;

import android.graphics.Bitmap;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.ss.android.vesdk.VELogUtil;
import java.io.BufferedOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f23556a = null;

    public b() {
    }

    static {
        f23556a = b.class.getSimpleName();
    }

    public static void a(Bitmap r100, String r101, Bitmap.CompressFormat r102) {
        if (r102 == null) goto L5;
    L16:
        String r103 = f23556a;
        VELogUtil.d(r103, "Bitmap " + r101 + " saving");
        BufferedOutputStream r104 = null;
        r104 = null;
        PolarisFileOutputStreamWrapper r105 = null;
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L40 IOException -> L42
        BufferedOutputStream r107 = new BufferedOutputStream(r106);     // Catch: Throwable -> L35 IOException -> L37
    L88:
        r100.compress(r102, 100, r107);     // Catch: Throwable -> L31 IOException -> L33
        r107.flush();     // Catch: Throwable -> L31 IOException -> L33
        r107.close();     // Catch: IOException -> L23
    L76:
        r106.close();     // Catch: IOException -> L27
    L29:
        VELogUtil.i(r103, "Bitmap " + r101 + " saved!");
        return;
    L27:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L76
    L33:
        e = e;
    L39:
        r105 = r106;
    L70:
        VELogUtil.e(r103, "Err when saving bitmap...path = " + r101);     // Catch: Throwable -> L56
        e.printStackTrace();     // Catch: Throwable -> L56
        if (r107 != null) goto L74;
    L50:
        if (r105 == null) goto L90;
        r105.close();     // Catch: IOException -> L53
        return;
    L53:
        e = move-exception;
        e.printStackTrace();
        return;
    L90:
        return;
    L74:
        r107.close();     // Catch: IOException -> L48
    L48:
        e = move-exception;
        e.printStackTrace();
    L56:
        th = th;
        r106 = r105;
    L58:
        r104 = r107;
    L59:
        if (r104 != null) goto L80;
    L64:
        if (r106 == null) goto L92;
        r106.close();     // Catch: IOException -> L67
        throw th;
    L67:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L92:
        throw th;
    L80:
        r104.close();     // Catch: IOException -> L62
    L62:
        e = move-exception;
        e.printStackTrace();
    L31:
        th = th;
    L37:
        e = e;
        r107 = null;
    L35:
        th = th;
        goto L59
    L42:
        e = e;
        r107 = null;
    L40:
        th = th;
        r106 = null;
        goto L59
    L5:
        if (r101.toLowerCase().endsWith(".jpg") == false) goto L7;
    L15:
        r102 = Bitmap.CompressFormat.JPEG;
        goto L16
    L7:
        if (r101.toLowerCase().endsWith(".jpeg") == true) goto L15;
        if (r101.toLowerCase().endsWith(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT) == false) goto L13;
        r102 = Bitmap.CompressFormat.PNG;
        goto L16
    L13:
        if (r101.toLowerCase().endsWith(".webp") == false) goto L16;
        r102 = Bitmap.CompressFormat.WEBP;
        goto L16
    }
}
