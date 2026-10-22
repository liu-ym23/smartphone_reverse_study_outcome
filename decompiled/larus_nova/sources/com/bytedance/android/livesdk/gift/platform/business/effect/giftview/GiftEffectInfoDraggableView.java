package com.bytedance.android.livesdk.gift.platform.business.effect.giftview;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0003\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0015\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/giftview/GiftEffectInfoDraggableView;", "Landroid/widget/FrameLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getDraggable", "()Z", "setDraggable", "(Z)V", "draggable", "", "b", "I", "getTopMarginPx", "()I", "setTopMarginPx", "(I)V", "topMarginPx", "e", "Lkotlin/Lazy;", "getStatusBarHeight", "statusBarHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftEffectInfoDraggableView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f129321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f129322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f129323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f129324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f129325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f129326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f129327g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j80.d f129328h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f129329i;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f129330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j80.d f129331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j80.d f129332c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ GiftEffectInfoDraggableView f129333d;

        public a(GiftEffectInfoDraggableView r100) {
            this.f129333d = r100;
            this.f129330a = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
            this.f129331b = new j80.d(0.0f, 0.0f);
            this.f129332c = new j80.d(0.0f, 0.0f);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftEffectInfoDraggableView f129334a;

        public b(GiftEffectInfoDraggableView r100) {
            this.f129334a = r100;
        }

        public final void a(j80.d r100) {
            Intrinsics.checkNotNullParameter(r100, "offset");
            GiftEffectInfoDraggableView r101 = this.f129334a;
            r101.f129328h = j80.c.e(r101.f129328h, r100);
            float r102 = this.f129334a.f129328h.a().floatValue();
            float r103 = this.f129334a.f129328h.b().floatValue();
            if (this.f129334a.f129328h.a().floatValue() >= 0.0f) goto L5;
            r102 = 0.0f;
        L9:
            if (this.f129334a.f129328h.b().floatValue() >= this.f129334a.getTopMarginPx()) goto L11;
            r103 = this.f129334a.getTopMarginPx();
        L14:
            GiftEffectInfoDraggableView r104 = this.f129334a;
            j80.d r105 = new j80.d(r102, r103);
            r104.f129328h = r105;
            j80.b.e(r104, r105);
            return;
        L11:
            float r106 = this.f129334a.f129328h.b().floatValue() + this.f129334a.getHeight();
            GiftEffectInfoDraggableView r107 = this.f129334a;
            if (r106 <= (r107.f129324d + GiftEffectInfoDraggableView.a(r107))) goto L14;
            GiftEffectInfoDraggableView r108 = this.f129334a;
            r103 = (r108.f129324d + GiftEffectInfoDraggableView.a(r108)) - this.f129334a.getHeight();
            goto L14
        L5:
            float r109 = this.f129334a.f129328h.a().floatValue() + this.f129334a.getWidth();
            GiftEffectInfoDraggableView r110 = this.f129334a;
            int r111 = r110.f129323c;
            if (r109 <= r111) goto L9;
            r102 = r111 - r110.getWidth();
            goto L9
        }
    }

    public GiftEffectInfoDraggableView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GiftEffectInfoDraggableView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final int getStatusBarHeight() {
        return ((Number) this.f129325e.getValue()).intValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f129326f = getContext().getResources().getConfiguration().orientation;
    }

    public final boolean getDraggable() {
        return this.f129321a;
    }

    public final int getTopMarginPx() {
        return this.f129322b;
    }

    public static final /* synthetic */ int a(GiftEffectInfoDraggableView r100) {
        return r100.getStatusBarHeight();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        if (r100 == null) goto L5;
        int r101 = r100.orientation;
    L7:
        if (this.f129326f == r101) goto L10;
        j80.b.e(this, new j80.d(0.0f, this.f129322b));
        this.f129323c = s1.t();
        this.f129324d = s1.r();
        this.f129326f = r101;
        return;
    L10:
        return;
    L5:
        r101 = 1;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f129321a == false) goto L23;
        a r101 = this.f129327g;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        int r102 = r100.getAction();
        if (r102 != 0) goto L7;
        r101.f129333d.getParent().requestDisallowInterceptTouchEvent(true);
        r101.f129331b = j80.b.c(r100);
    L19:
        boolean r103 = false;
    L20:
        if (r103 == false) goto L23;
        return true;
    L7:
        if (r102 != 2) goto L19;
        if (j80.c.a(j80.b.c(r100), r101.f129331b) < r101.f129330a) goto L19;
        r101.f129332c = j80.b.c(r100);
        b r104 = r101.f129333d.f129329i;
        if (r104 == null) goto L14;
        GiftEffectInfoDraggableView r105 = r104.f129334a;
        r105.f129328h = j80.b.a(r105);
    L14:
        b r106 = r101.f129333d.f129329i;
        if (r106 == null) goto L17;
        r106.a(j80.c.b(j80.b.c(r100), r101.f129331b));
    L17:
        r103 = true;
    L23:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f129321a == false) goto L25;
        a r101 = this.f129327g;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        int r102 = r100.getAction();
        if (r102 == 0) goto L18;
        boolean r103 = false;
        if (r102 != 1) goto L9;
        GiftEffectInfoDraggableView r104 = r101.f129333d;
        b r105 = r104.f129329i;
        r104.getParent().requestDisallowInterceptTouchEvent(false);
    L21:
        r103 = true;
    L22:
        if (r103 == false) goto L25;
        return true;
    L9:
        if (r102 != 2) goto L11;
        j80.d r106 = j80.c.b(j80.b.c(r100), r101.f129332c);
        r101.f129332c = j80.b.c(r100);
        b r107 = r101.f129333d.f129329i;
        if (r107 == null) goto L21;
        r107.a(r106);
        goto L21
    L11:
        if (r102 != 3) goto L22;
        GiftEffectInfoDraggableView r108 = r101.f129333d;
        b r109 = r108.f129329i;
        r108.getParent().requestDisallowInterceptTouchEvent(false);
        goto L21
    L18:
        r101.f129332c = j80.b.c(r100);
        r101.f129333d.getParent().requestDisallowInterceptTouchEvent(true);
        b r110 = r101.f129333d.f129329i;
        if (r110 == null) goto L21;
        GiftEffectInfoDraggableView r111 = r110.f129334a;
        r111.f129328h = j80.b.a(r111);
    L25:
        return super.onTouchEvent(r100);
    }

    public final void setDraggable(boolean r100) {
        this.f129321a = r100;
    }

    public final void setTopMarginPx(int r100) {
        this.f129322b = r100;
    }

    public GiftEffectInfoDraggableView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f129323c = s1.t();
        this.f129324d = s1.r();
        this.f129325e = LazyKt.lazy(GiftEffectInfoDraggableView$statusBarHeight$2.INSTANCE);
        this.f129326f = 1;
        this.f129327g = new a(this);
        this.f129328h = new j80.d(0.0f, 0.0f);
        this.f129329i = new b(this);
    }

    public /* synthetic */ GiftEffectInfoDraggableView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
