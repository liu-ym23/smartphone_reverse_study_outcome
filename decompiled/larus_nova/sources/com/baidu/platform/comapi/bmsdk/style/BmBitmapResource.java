package com.baidu.platform.comapi.bmsdk.style;

import android.graphics.Bitmap;
import android.graphics.NinePatch;

/* JADX INFO: loaded from: classes39.dex */
public class BmBitmapResource extends BmDrawableResource {
    private static native long nativeCreate();

    private static native boolean nativeSetBitmap(long r100, Bitmap r101, int r102, int r103, boolean r104);

    private static native boolean nativeSetFillArea(long r100, int r101, int r102, int r103, int r104);

    private static native boolean nativeSetScaleX(long r100, int[] r101, int r102);

    private static native boolean nativeSetScaleY(long r100, int[] r101, int r102);

    private BmBitmapResource() {
        super(56, nativeCreate());
    }

    public BmBitmapResource(Bitmap r100) {
        super(56, nativeCreate());
        a(r100, false);
    }

    private void a(Bitmap r100, boolean r101) {
        if (r100 == null) goto L11;
        nativeSetBitmap(this.nativeInstance, r100, hashCode(), r100.hashCode(), r101);
        if (r100.getNinePatchChunk() != null) goto L6;
        return;
    L6:
        if (NinePatch.isNinePatchChunk(r100.getNinePatchChunk()) == false) goto L13;
        b r102 = b.a(r100.getNinePatchChunk());
        if (r102 == null) goto L14;
        int r103 = r100.getWidth();
        int[] r104 = r102.f32855a;
        a(r102.f32856b, r102.f32857c, new int[]{r102.f32855a[0], r103 - r104[1], r104[2], r100.getHeight() - r102.f32855a[3]});
        return;
    L14:
        return;
    L13:
        return;
    }

    private void a(int[] r100, int[] r101, int[] r102) {
        if (r100 != null) goto L4;
    L6:
        if (r101 != null) goto L8;
    L10:
        if (r102 != null) goto L12;
        return;
    L12:
        if (r102.length != 4) goto L16;
        nativeSetFillArea(this.nativeInstance, r102[0], r102[1], r102[2], r102[3]);
        return;
    L16:
        return;
    L8:
        if (r101.length <= 0) goto L10;
        nativeSetScaleY(this.nativeInstance, r101, r101.length);
        goto L10
    L4:
        if (r100.length <= 0) goto L6;
        nativeSetScaleX(this.nativeInstance, r100, r100.length);
        goto L6
    }
}
