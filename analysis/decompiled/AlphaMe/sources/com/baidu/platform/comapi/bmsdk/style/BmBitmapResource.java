package com.baidu.platform.comapi.bmsdk.style;

import android.graphics.Bitmap;
import android.graphics.NinePatch;

/* loaded from: classes.dex */
public class BmBitmapResource extends BmDrawableResource {
    private BmBitmapResource() {
        super(56, nativeCreate());
    }

    private void a(Bitmap bitmap, boolean z4) {
        b bVarA;
        if (bitmap != null) {
            nativeSetBitmap(this.nativeInstance, bitmap, hashCode(), bitmap.hashCode(), z4);
            if (bitmap.getNinePatchChunk() == null || !NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk()) || (bVarA = b.a(bitmap.getNinePatchChunk())) == null) {
                return;
            }
            int i4 = bVarA.f8715a[0];
            int width = bitmap.getWidth();
            int[] iArr = bVarA.f8715a;
            a(bVarA.f8716b, bVarA.f8717c, new int[]{i4, width - iArr[1], iArr[2], bitmap.getHeight() - bVarA.f8715a[3]});
        }
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBitmap(long j4, Bitmap bitmap, int i4, int i5, boolean z4);

    private static native boolean nativeSetFillArea(long j4, int i4, int i5, int i6, int i7);

    private static native boolean nativeSetScaleX(long j4, int[] iArr, int i4);

    private static native boolean nativeSetScaleY(long j4, int[] iArr, int i4);

    public BmBitmapResource(Bitmap bitmap) {
        super(56, nativeCreate());
        a(bitmap, false);
    }

    private void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (iArr != null && iArr.length > 0) {
            nativeSetScaleX(this.nativeInstance, iArr, iArr.length);
        }
        if (iArr2 != null && iArr2.length > 0) {
            nativeSetScaleY(this.nativeInstance, iArr2, iArr2.length);
        }
        if (iArr3 == null || iArr3.length != 4) {
            return;
        }
        nativeSetFillArea(this.nativeInstance, iArr3[0], iArr3[1], iArr3[2], iArr3[3]);
    }
}
