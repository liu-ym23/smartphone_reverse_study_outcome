package blb;

import com.ss.android.lark.image.uploader.config.ConfigManager;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    static {
    }

    public static int[] a(ImageInfo r100, flb.b r110) {
        Intrinsics.checkNotNullParameter(r100, "imageInfo");
        long r101 = r100.f426423c;
        int r102 = Math.min(r100.f426421a, r100.f426422b);
        int r103 = Math.max(r100.f426421a, r100.f426422b);
        int r104 = r100.f426424d;
        if (r110 == null) goto L5;
        int r105 = r110.f477765a;
    L6:
        if (r110 == null) goto L8;
        int r106 = r110.f477766b;
    L9:
        int[] r107 = ykb.b.f568292a.f(r101, r102, r103, r104, r105, r106);
        if (r107.length != 0) goto L12;
        boolean r108 = true;
    L14:
        if (r108 == false) goto L16;
    L17:
        com.ss.android.lark.image.uploader.config.b r109 = ConfigManager.a().getCompressConfig();
        if (r109 == null) goto L20;
        int r111 = r109.b();
    L21:
        com.ss.android.lark.image.uploader.config.b r112 = ConfigManager.a().getCompressConfig();
        if (r112 == null) goto L24;
        int r113 = r112.a();
    L25:
        r107 = new int[]{r111, r113};
    L26:
        int r114 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("CompressParamsProvider", "ImageInfo:" + r100 + ", fileCompressConfig:" + r110 + ", target short side:" + r107[0] + ", target quality:" + r107[1]);
        if (r107[0] > 0) goto L29;
        r107[0] = r102;
    L29:
        int r115 = r107[1];
        if (r115 <= 0) goto L32;
        if (r115 > 100) goto L32;
    L33:
        return r107;
    L32:
        r107[1] = 100;
        goto L33
    L24:
        r113 = 70;
        goto L25
    L20:
        r111 = 1080;
        goto L21
    L16:
        if (r107.length >= 2) goto L26;
    L12:
        r108 = false;
        goto L14
    L8:
        r106 = -1;
        goto L9
    L5:
        r105 = -1;
        goto L6
    }
}
