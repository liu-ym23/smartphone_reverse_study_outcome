package bfc;

import android.media.Image;
import com.ss.android.medialib.camera.ImageFrame;
import com.ss.android.vesdk.VELogUtil;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageFrame f18852a;

    public a(ImageFrame r100) {
        this.f18852a = r100;
    }

    public final void a(int[][] r100, ByteBuffer[] r110) {
        b r101 = this.f18852a.getPlane();
        if (r101 != null) goto L5;
        return;
    L5:
        Image.Plane[] r102 = r101.f18853a;
        if (r102 != null) goto L8;
        return;
    L8:
        int r103 = 0;
    L10:
        if (r103 >= r102.length) goto L18;
        ByteBuffer r104 = r102[r103].getBuffer();
        r110[r103] = r104;
        int r105 = r104.remaining();
        int r106 = r102[r103].getRowStride();
        if (r106 > 0) goto L14;
        r106 = this.f18852a.width;
        VELogUtil.e("PlanFrame", "rowStride <= 0");
    L14:
        int r107 = r102[r103].getPixelStride();
        if (r107 > 0) goto L17;
        VELogUtil.e("PlanFrame", "pixelStride <= 0");
        r107 = 1;
    L17:
        r100[r103] = new int[]{r105, r106, r107};
        r103 = r103 + 1;
        goto L10
    }
}
