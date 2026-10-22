package com.bytedance.android.shopping.deepfeed.slice.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import bd3.c;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.deepfeed.slice.service.b;
import com.bytedance.android.shopping.deepfeed.slice.service.d;
import com.bytedance.android.shopping.deepfeed.weights.video.VideoProgressBar;
import com.bytedance.android.shopping.deepfeed.weights.video.VideoProgressTextLayout;
import com.bytedance.android.shopping.inflow.cardui.product.header.indicator.ProductCardProgressIndicator;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/indicator/DeepFeedSlcIndicatorView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "state", "", "setPlayState", LynxVideoManagerLite.FILL, "setFillCurrent", "", "totalDuration", "setTotalDuration", "", "count", LynxTemplateRender.RENDER_PHASE_SETUP, "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedSlcIndicatorView extends ConstraintLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f173548h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProductCardProgressIndicator f173549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VideoProgressTextLayout f173550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f173551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f173552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final VideoProgressBar f173553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f173554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SlcTemplateContext f173555g;

    public static final class a implements fd3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedSlcIndicatorView f173556a;

        @Override // fd3.a
        public final void onDragEnd() {
            DeepFeedSlcIndicatorView r100 = this.f173556a;
            ExtensionsKt.gone(r100.f173550b);
            b r101 = r100.R5();
            if (r101 == null) goto L5;
            r101.M(MapsKt.mapOf(TuplesKt.to("hidden_search", Boolean.FALSE)));
        L5:
            b r102 = r100.R5();
            if (r102 == null) goto L9;
            r102.Q();
            return;
        }

        @Override // fd3.a
        public final void onDragStart() {
            DeepFeedSlcIndicatorView r100 = this.f173556a;
            r100.f173549a.setVisibility(4);
            r100.f173553e.setVisibility(0);
            r100.f173550b.setVisibility(0);
            b r101 = r100.R5();
            if (r101 == null) goto L5;
            r101.M(MapsKt.mapOf(TuplesKt.to("hidden_search", Boolean.TRUE)));
        L5:
            float r102 = r100.f173553e.getDragProgress();
            VideoProgressTextLayout r103 = r100.f173550b;
            int r104 = r100.f173551c;
            r103.f174281a.setText(VideoProgressTextLayout.a((int) (r102 * r104)));
            r103.f174282b.setText(VideoProgressTextLayout.a(r104));
        }

        public a(DeepFeedSlcIndicatorView r100) {
            this.f173556a = r100;
        }

        @Override // fd3.a
        public final void a(float r100) {
            SlcTemplateContext r101 = this.f173556a.f173555g;
            d r102 = null;
            Object r103 = null;
            if (r101 == null) goto L9;
            Object r104 = r101.o(d.class);
            if ((r104 instanceof d) == false) goto L8;
            r103 = r104;
        L8:
            r102 = (d) r103;
        L9:
            if (r102 == null) goto L12;
            r102.b(r100 * 100);
            return;
        }

        @Override // fd3.a
        public final void b(float r100) {
            DeepFeedSlcIndicatorView r101 = this.f173556a;
            int r102 = DeepFeedSlcIndicatorView.f173548h;
            VideoProgressTextLayout r103 = r101.f173550b;
            int r104 = r101.f173551c;
            r103.f174281a.setText(VideoProgressTextLayout.a((int) (r100 * r104)));
            r103.f174282b.setText(VideoProgressTextLayout.a(r104));
        }

        @Override // fd3.a
        public final void c(float r100) {
            DeepFeedSlcIndicatorView r101 = this.f173556a;
            int r102 = DeepFeedSlcIndicatorView.f173548h;
            r101.getClass();
            this.f173556a.f173550b.setAlpha(r100);
            this.f173556a.invalidate();
        }
    }

    public DeepFeedSlcIndicatorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeepFeedSlcIndicatorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final void setPlayState(boolean r100) {
    }

    public final b R5() {
        SlcTemplateContext r100 = this.f173555g;
        Object r101 = null;
        if (r100 == null) goto L10;
        Object r102 = r100.o(b.class);
        if ((r102 instanceof b) == false) goto L9;
        r101 = r102;
    L9:
        return (b) r101;
    L10:
        return null;
    }

    public final void S5() {
        ExtensionsKt.gone(this.f173550b);
        this.f173553e.c(0.0f);
        setPlayState(false);
        this.f173549a.b(0, 0.0f);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        if (Intrinsics.areEqual(this.f173552d, "video") == false) goto L5;
    L13:
        boolean r102 = true;
    L14:
        if (r102 == false) goto L19;
        if (this.f173553e.a(r100) == false) goto L19;
        return true;
    L19:
        if (this.f173553e.getVisibility() != 0) goto L21;
        r101 = true;
    L21:
        if (r101 == false) goto L26;
        if (this.f173553e.a(r100) == false) goto L26;
        return true;
    L26:
        return super.onTouchEvent(r100);
    L5:
        if (Intrinsics.areEqual(this.f173552d, "mix") == true) goto L7;
    L12:
        r102 = false;
        goto L14
    L7:
        if (this.f173549a.f176244i != 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
    L9:
        r103 = false;
        goto L10
    }

    public final void setFillCurrent(boolean r100) {
        this.f173549a.setFillCurrent(r100);
    }

    public final void setTotalDuration(long r100) {
        this.f173551c = (int) (r100 / ((long) 1000));
    }

    public final void setup(int r100) {
        this.f173549a.setup(r100);
    }

    public DeepFeedSlcIndicatorView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        AttributeSet r113 = null;
        int r100 = 0;
        ProductCardProgressIndicator r114 = new ProductCardProgressIndicator(r110, null, 6, 0);
        this.f173549a = r114;
        VideoProgressTextLayout r101 = new VideoProgressTextLayout(r110, r113, 6, r100);
        r101.setAlpha(0.0f);
        Unit r102 = Unit.INSTANCE;
        this.f173550b = r101;
        this.f173552d = "image";
        VideoProgressBar r103 = new VideoProgressBar(r110, r113, 4, r100);
        a r115 = new a(this);
        Intrinsics.checkNotNullParameter(r115, "callback");
        r103.f174275j = r115;
        r103.f174276k = true;
        r103.f174277l = null;
        this.f173553e = r103;
        this.f173554f = new c("", 0, 0, "", 2.0d);
        r114.setId(ViewGroup.generateViewId());
        r103.setId(ViewGroup.generateViewId());
        r101.setId(ViewGroup.generateViewId());
        int r116 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        ConstraintLayout.LayoutParams r117 = new ConstraintLayout.LayoutParams(-1, com.bytedance.android.ec.hybrid.list.util.c.d(2));
        r117.topToTop = 0;
        r117.bottomToBottom = 0;
        r117.startToStart = 0;
        r117.endToEnd = 0;
        addView(r114, r117);
        ConstraintLayout.LayoutParams r118 = new ConstraintLayout.LayoutParams(-1, com.bytedance.android.ec.hybrid.list.util.c.d(2));
        r118.topToTop = 0;
        r118.bottomToBottom = 0;
        r118.startToStart = 0;
        r118.endToEnd = 0;
        addView(r103, r118);
        ConstraintLayout.LayoutParams r119 = new ConstraintLayout.LayoutParams(-1, -2);
        r119.bottomToTop = r103.getId();
        r119.startToStart = 0;
        r119.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) r119).bottomMargin = com.bytedance.android.ec.hybrid.list.util.c.d(12);
        addView(r101, r119);
        setClipChildren(false);
        S5();
    }

    public /* synthetic */ DeepFeedSlcIndicatorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
