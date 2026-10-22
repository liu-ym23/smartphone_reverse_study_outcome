package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.bytedance.android.live.core.utils.s1;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: classes11.dex */
public final class d extends ScalingUtils.AbstractScaleType {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f159781e = null;

    static {
        f159781e = new d();
    }

    public d() {
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
    public final void getTransformImpl(Matrix r100, Rect r101, int r102, int r103, float r104, float r105, float r106, float r107) {
        if (r101 != null) goto L4;
        return;
    L4:
        float r108 = s1.y();
        float r109 = s1.y() / r103;
        float r110 = r102;
        float r111 = r108 / r110;
        if (r109 <= r111) goto L11;
        float r112 = r110 * r109;
        float r113 = r101.left + ((r101.width() - r112) * 0.5f);
        float r114 = (r101.top + (r101.height() - r112)) * 0.5f;
        if (r100 == null) goto L9;
        r100.setScale(r109, r109);
    L9:
        if (r100 == null) goto L17;
        r100.postTranslate(r113 + 0.5f, r114 + 0.5f);
        return;
    L17:
        return;
    L11:
        float r115 = r110 * r111;
        float r116 = r101.left + ((r101.width() - r115) * 0.5f);
        float r117 = (r101.top + (r101.height() - r115)) * 0.5f;
        if (r100 == null) goto L14;
        r100.setScale(r111, r111);
    L14:
        if (r100 == null) goto L19;
        r100.postTranslate(r116 + 0.5f, r117 + 0.5f);
        return;
    }
}
