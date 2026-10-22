package com.bytedance.android.livesdk.ktvimpl.ktvroom.theme;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d extends ScalingUtils.AbstractScaleType {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f144894e = null;

    static {
        f144894e = new d();
    }

    public d() {
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
    public final void getTransformImpl(Matrix r100, Rect r101, int r102, int r103, float r104, float r105, float r106, float r107) {
        Intrinsics.checkNotNullParameter(r100, "outTransform");
        Intrinsics.checkNotNullParameter(r101, "parentRect");
        float r108 = r101.left;
        float r109 = r101.top;
        r100.setScale(r106, r107);
        r100.postTranslate(r108 + 0.5f, r109 + 0.5f);
    }
}
