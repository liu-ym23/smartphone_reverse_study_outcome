package ao7;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    public interface a {
    }

    public static void a(ShareContent r100) {
        if (r100.getImageTokenShareInfo() == null) goto L7;
        String r101 = r100.getImageTokenShareInfo().f504260a;
    L5:
        String r102 = r101;
        if (r100.getFromChannel() != ShareChannelType.LONG_IMAGE) goto L16;
        eo7.a r103 = eo7.a.b.f473353a;     // Catch: Throwable -> L30
        if (r103.f473344r == true) goto L15;
    L14:
        boolean r104 = false;
    L20:
        if (r104 == true) goto L22;
        return;
    L22:
        if (TextUtils.isEmpty(r102) == true) goto L34;
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L30
        if (r100.getImage().getConfig() == Bitmap.Config.ARGB_8888) goto L28;
        Bitmap r106 = r100.getImage().copy(Bitmap.Config.ARGB_8888, false);     // Catch: Throwable -> L30
        if (r106 == null) goto L28;
        r100.setImage(r106);     // Catch: Throwable -> L30
    L28:
        boolean r107 = zn7.a.b(r100.getImage(), r102);     // Catch: Throwable -> L30
        go7.b.d(r100, r107, r102, !r107 ? 1 : 0, System.currentTimeMillis() - r105);     // Catch: Throwable -> L30
        return;
    L34:
        return;
    L15:
        r104 = ((Boolean) r103.c("enable_long_image_hidden_watermark", Boolean.FALSE)).booleanValue();     // Catch: Throwable -> L30
        goto L20
    L16:
        eo7.a r108 = eo7.a.b.f473353a;     // Catch: Throwable -> L30
        if (r108.f473344r == false) goto L14;
        r104 = ((Boolean) r108.c("enable_hidden_watermark", Boolean.TRUE)).booleanValue();     // Catch: Throwable -> L30
    L35:
        return;
    L7:
        if (r100.getTokenShareInfo() == null) goto L9;
        r101 = r100.getTokenShareInfo().f504260a;
        goto L5
    L9:
        r101 = "";
        goto L5
    }
}
