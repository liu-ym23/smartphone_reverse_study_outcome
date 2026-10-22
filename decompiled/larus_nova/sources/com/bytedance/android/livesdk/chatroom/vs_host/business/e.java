package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdk.vs.LiveBlurAnimView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements wr1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveBlurAnimView f118263a;

    @Override // wr1.b
    public final LiveBlurAnimView getView() {
        return this.f118263a;
    }

    public e(Context r100) {
        this.f118263a = new LiveBlurAnimView(r100, null, 6, 0);
    }

    @Override // wr1.b
    public final void b(float r100) {
        LiveBlurAnimView r101 = this.f118263a;
        r101.f159367d = r100;
        HSImageView r102 = r101.f159365b;
        if (r102 == null) goto L6;
        r102.setAlpha(r100);
        return;
    }

    @Override // wr1.b
    public final void a(py.k r100, int r101, ImageView.ScaleType r110) {
        Intrinsics.checkNotNullParameter(r110, "scaleType");
        LiveBlurAnimView r102 = this.f118263a;
        int r103 = LiveBlurAnimView.f159363e;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r110, "scaleType");
        switch(com.bytedance.android.livesdk.vs.c.f159371a[r110.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        ScalingUtils.ScaleType r111 = ScalingUtils.ScaleType.CENTER_CROP;
    L12:
        r102.f159366c = 15;
        r102.f159367d = 1.0f;
        HSImageView r104 = r102.f159364a;
        if (r104 == null) goto L17;
        ImageLoader.bindImage(r104, r100, r104.getWidth(), r104.getHeight(), new l3(r102.f159366c));
        GenericDraweeHierarchy r105 = r104.getHierarchy();
        if (r105 == null) goto L17;
        r105.setActualImageScaleType(r111);
    L17:
        HSImageView r106 = r102.f159365b;
        if (r106 == null) goto L31;
        ImageLoader.bindImage(r106, r100, r106.getWidth(), r106.getHeight());
        GenericDraweeHierarchy r107 = r106.getHierarchy();
        if (r107 == null) goto L22;
        r107.setActualImageScaleType(r111);
    L22:
        if (r101 == 0) goto L29;
        GenericDraweeHierarchy r108 = r106.getHierarchy();
        if (r108 == null) goto L26;
        r108.setPlaceholderImage(r101, r111);
    L26:
        GenericDraweeHierarchy r109 = r106.getHierarchy();
        if (r109 == null) goto L29;
        r109.setFailureImage(r101, r111);
    L29:
        r106.setAlpha(1.0f);
        return;
    L31:
        return;
    L5:
        r111 = ScalingUtils.ScaleType.CENTER_INSIDE;
        goto L12
    L6:
        r111 = ScalingUtils.ScaleType.CENTER_CROP;
        goto L12
    L7:
        r111 = ScalingUtils.ScaleType.CENTER;
        goto L12
    L8:
        r111 = ScalingUtils.ScaleType.FIT_END;
        goto L12
    L9:
        r111 = ScalingUtils.ScaleType.FIT_CENTER;
        goto L12
    L10:
        r111 = ScalingUtils.ScaleType.FIT_START;
        goto L12
    L11:
        r111 = ScalingUtils.ScaleType.FIT_XY;
        goto L12
    }
}
