package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.response.anchorv3.SpecDetail;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.facebook.drawee.generic.RoundingParams;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/InflowSkuThumbnail;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/model/response/anchorv3/SpecDetail;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/model/response/anchorv3/SpecDetail;", "getSpecDetail", "()Lcom/bytedance/android/ec/model/response/anchorv3/SpecDetail;", "setSpecDetail", "(Lcom/bytedance/android/ec/model/response/anchorv3/SpecDetail;)V", "specDetail", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "b", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getImageView", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "imageView", "Landroid/view/View;", ce.f26391f, "Lkotlin/Lazy;", "getMaskView", "()Landroid/view/View;", "maskView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowSkuThumbnail extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpecDetail f175559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECDraweeView f175560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f175561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f175562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f175563e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Drawable f175564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f175565g;

    public InflowSkuThumbnail(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InflowSkuThumbnail(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final View getMaskView() {
        return (View) this.f175565g.getValue();
    }

    public final void a() {
        removeAllViews();
        View r100 = this.f175560b;
        float r101 = 42;
        Resources r102 = Resources.getSystem();
        int r103 = MathKt.roundToInt(TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
        Resources r104 = Resources.getSystem();
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(r103, MathKt.roundToInt(TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()))));
        r105.gravity = 17;
        Unit r106 = Unit.INSTANCE;
        addView(r100, r105);
        b(this.f175560b, this.f175561c, 1);
        View r107 = getMaskView();
        float r108 = 44;
        Resources r109 = Resources.getSystem();
        int r110 = MathKt.roundToInt(TypedValue.applyDimension(1, r108, WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics())));
        Resources r111 = Resources.getSystem();
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(r110, MathKt.roundToInt(TypedValue.applyDimension(1, r108, WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()))));
        r112.gravity = 17;
        addView(r107, r112);
        getMaskView().setVisibility(4);
    }

    public final ECDraweeView getImageView() {
        return this.f175560b;
    }

    public final SpecDetail getSpecDetail() {
        return this.f175559a;
    }

    public final void c(boolean r100) {
        if (r100 == false) goto L4;
        b(this.f175560b, this.f175562d, 2);
        ExtensionsKt.visible(getMaskView());
        return;
    L4:
        b(this.f175560b, this.f175561c, 1);
        getMaskView().setVisibility(4);
    }

    public final void setSpecDetail(SpecDetail r100) {
        this.f175559a = r100;
    }

    public InflowSkuThumbnail(final Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        ECDraweeView r102 = new ECDraweeView(r100, null, 0, 6, null);
        r102.setCornerRadius(r102.getDp(8));
        Unit r111 = Unit.INSTANCE;
        this.f175560b = r102;
        this.f175561c = "#05161823";
        this.f175562d = "#ffffff";
        this.f175563e = "#161823";
        this.f175564f = com.bytedance.commerce.base.drawable.a.a(new InflowSkuThumbnail$shapeDrawable$1(this));
        this.f175565g = LazyKt.lazy(new InflowSkuThumbnail$maskView$2(this, r100));
    }

    public static void b(ECDraweeView r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$setRounding");
        RoundingParams r103 = new RoundingParams();
        r103.setCornersRadius(r100.getDp(8));
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r101)));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r105) == false) goto L10;
        r105 = null;
    L10:
        Integer r106 = (Integer) r105;
        if (r106 == null) goto L13;
        int r107 = r106.intValue();
    L14:
        r103.setBorder(r107, r100.getDp(Integer.valueOf(r102)));
        r100.getHierarchy().setRoundingParams(r103);
        return;
    L13:
        r107 = 0;
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public /* synthetic */ InflowSkuThumbnail(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
