package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a0 extends RoundedFrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f181518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f181519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f181520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f181521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f181522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ECDraweeView f181523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f181524h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f181525i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final t f181526j;

    public final TextView getTvBottomLeft() {
        TextView r100 = this.f181520d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvBottomLeft");
    L5:
        return r100;
    }

    public final FrameLayout getVideoContainer() {
        FrameLayout r100 = this.f181522f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
    L5:
        return r100;
    }

    public final ECDraweeView getIvCover() {
        return this.f181523g;
    }

    @Override // com.bytedance.android.ec.core.widget.RoundedFrameLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        this.f181519c.set(0.0f, 0.0f, getWidth(), getHeight());
        r100.drawRoundRect(this.f181519c, getBorderRadius(), getBorderRadius(), this.f181518b);
    }

    public final void setIvCover(ECDraweeView r100) {
        this.f181523g = r100;
    }

    public final void setTvBottomLeft(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f181520d = r100;
    }

    public final void setVideoContainer(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f181522f = r100;
    }

    public a0(Context r100, t r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "ability");
        super(r100);
        this.f181526j = r110;
        Paint r101 = new Paint(1);
        r101.setColor(-1);
        r101.setStrokeWidth(com.bytedance.android.shopping.extensions.b.a(Double.valueOf(1.5d)));
        r101.setStyle(Paint.Style.STROKE);
        Unit r102 = Unit.INSTANCE;
        this.f181518b = r101;
        this.f181519c = new RectF();
        FrameLayout r103 = new FrameLayout(getContext());
        this.f181522f = r103;
        addView(r103, -1, -1);
        String r104 = r110.getParams().f181555d.f181590e;
        if (r104 == null) goto L8;
        ECDraweeView r111 = new ECDraweeView(getContext(), null, 0, 6, null);
        this.f181523g = r111;
        GenericDraweeHierarchy r105 = r111.getHierarchy();
        if (r105 == null) goto L7;
        r105.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    L7:
        com.bytedance.android.ec.core.utils.y.d(r111, r104);
        addView(r111, new FrameLayout.LayoutParams(-1, -1));
    L8:
        addView(new z(this, getContext()), -1, -1);
        TextView r106 = new TextView(getContext());
        this.f181520d = r106;
        r106.setTypeface(Typeface.DEFAULT_BOLD);
        r106.setTextColor(-1);
        ViewExtensionsKt.h(r106, 12);
        r106.setShadowLayer(com.bytedance.android.ec.core.utils.q.a(2), com.bytedance.android.ec.core.utils.q.a(1), com.bytedance.android.ec.core.utils.q.a(1), 872415232);
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-2, -2);
        r112.bottomMargin = com.bytedance.android.shopping.extensions.b.a(6);
        r112.gravity = 81;
        r112.leftMargin = 0;
        addView(r106, r112);
        ImageView r107 = new ImageView(getContext());
        r107.setImageResource(R.drawable.anchor_v4_float_video_icon_pause);
        r107.setScaleType(ImageView.ScaleType.CENTER);
        this.f181521e = r107;
        r107.setVisibility(8);
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(-2, -2);
        r113.gravity = 17;
        addView(r107, r113);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f181526j.getParams().f181555d.f181588c == true) goto L5;
        super.onMeasure(r100, r101);
        return;
    L5:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r102 = this.f181526j.getParams().f181554c.f181582e;
        Integer r103 = r102.l();
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.intValue();
    L9:
        Integer r106 = r102.c();
        if (r106 == null) goto L12;
        r104 = r106.intValue();
    L12:
        if (r105 <= 0) goto L18;
        if (r104 <= 0) goto L18;
        if (r105 <= r104) goto L16;
        int r107 = com.bytedance.android.shopping.anchorv4.video.p007float.m.f167631f;
        int r108 = com.bytedance.android.shopping.anchorv4.video.p007float.m.f167631f;
        int r109 = RangesKt.coerceAtLeast((int) ((r104 / r105) * r108), com.bytedance.android.shopping.anchorv4.video.p007float.m.f167632g);
    L17:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r108, 1073741824), View.MeasureSpec.makeMeasureSpec(r109, 1073741824));
        return;
    L16:
        int r110 = com.bytedance.android.shopping.anchorv4.video.p007float.m.f167631f;
        r109 = com.bytedance.android.shopping.anchorv4.video.p007float.m.f167631f;
        r108 = RangesKt.coerceAtLeast((int) ((r105 / r104) * r109), com.bytedance.android.shopping.anchorv4.video.p007float.m.f167632g);
    L18:
        super.onMeasure(r100, r101);
        return;
    L8:
        r105 = 0;
        goto L9
    }
}
