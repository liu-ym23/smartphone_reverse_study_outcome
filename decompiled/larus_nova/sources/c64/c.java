package c64;

import android.util.Size;
import android.widget.ImageView;
import com.bytedance.awemeopen.infra.base.player.resize.VideoScaleModel;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements d {
    public c() {
    }

    @Override // c64.d
    public final b a(int r100, int r101, int r102, int r103) {
        boolean r104 = false;
        if (r100 <= r101) goto L5;
        boolean r105 = true;
    L6:
        if (r102 <= r103) goto L9;
        r104 = true;
    L9:
        if ((r104 ^ r105) == true) goto L28;
        int r106 = f.f22591a;
        if (r102 <= 0) goto L25;
        if (r103 <= 0) goto L25;
        if (r100 > r102) goto L19;
        if (r101 > r103) goto L19;
        float r107 = r100;
        float r108 = r101;
        float r109 = Math.min((r107 * 1.0f) / r102, (1.0f * r108) / r103);
        Size r110 = new Size((int) (r107 / r109), (int) (r108 / r109));
    L27:
        return new b(r110, ImageView.ScaleType.CENTER_CROP, VideoScaleModel.FILL);
    L19:
        if (r100 <= r102) goto L22;
        if (r101 <= r103) goto L22;
        float r111 = r100;
        float r112 = r101;
        float r113 = Math.min((r111 * 1.0f) / r102, (1.0f * r112) / r103);
        r110 = new Size((int) (r111 / r113), (int) (r112 / r113));
    L22:
        if (r100 >= r102) goto L24;
        float r114 = r100;
        float r115 = (1.0f * r114) / r102;
        r110 = new Size((int) (r114 / r115), (int) (r101 / r115));
        goto L27
    L24:
        float r116 = r101;
        float r117 = (1.0f * r116) / r103;
        r110 = new Size((int) (r100 / r117), (int) (r116 / r117));
    L25:
        r110 = new Size(r100, r101);
        goto L27
    L28:
        return new b(f.a(r100, r101, r102, r103), ImageView.ScaleType.FIT_CENTER, VideoScaleModel.FIT);
    L5:
        r105 = false;
        goto L6
    }
}
