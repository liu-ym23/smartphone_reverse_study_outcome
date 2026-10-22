package com.bytedance.android.shopping.inflow.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ActivityCountDownTimer;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.CommonGirdleStructV2;
import com.bytedance.android.ec.model.response.anchorv3.CommonGirdleStructV2Slogan;
import com.bytedance.android.ec.model.response.anchorv3.CountDown;
import com.bytedance.android.shopping.feed.utils.h;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\u000b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\b\u0010\f\u001a\u00020\tH\u0007J\b\u0010\r\u001a\u00020\tH\u0007J\b\u0010\u000e\u001a\u00020\tH\u0007J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/inflow/view/InFlowActivityLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/utils/l1$a;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/shopping/feed/view/c;", "", "getLayout", "Lkotlin/Function1;", "Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStructV2;", "", "onActivityChangeListener", "setOnActivityChangeListener", "resumeCountDown", "pauseCountDown", "stopCountDown", "Lb53/a;", "event", "onActivityCountDownStopEvent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFlowActivityLayout extends FrameLayout implements l1.a, LifecycleObserver, com.bytedance.android.shopping.feed.view.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f176327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CommonGirdleStructV2 f176328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super CommonGirdleStructV2, Unit> f176329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f176330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f176331e;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonGirdleStructV2 f176332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InFlowActivityLayout f176333b;

        public b(CommonGirdleStructV2 r100, InFlowActivityLayout r101) {
            this.f176332a = r100;
            this.f176333b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<? super CommonGirdleStructV2, Unit> r100 = this.f176333b.f176329c;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            Unit r101 = r100.invoke(this.f176332a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InFlowActivityLayout f176334a;

        public c(InFlowActivityLayout r100) {
            this.f176334a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if ((this.f176334a.getContext() instanceof LifecycleOwner) == false) goto L12;
            Object r100 = this.f176334a.getContext();     // Catch: Throwable -> L9
            if (r100 == null) goto L8;
            ((LifecycleOwner) r100).getLifecycle().removeObserver(this.f176334a);     // Catch: Throwable -> L9
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");     // Catch: Throwable -> L9
        }
    }

    static {
    }

    public InFlowActivityLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InFlowActivityLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onStart() {
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onFinish() {
        Lazy r100 = ActivityCountDownTimer.f45499c;
        boolean r101 = true;
        ActivityCountDownTimer.a.a().f45500a--;
        ActivityCountDownTimer r102 = ActivityCountDownTimer.a.a();
        if (r102.f45500a == 0) goto L6;
        r101 = false;
    L6:
        if (r101 == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L14;
        CommonGirdleStructV2 r103 = this.f176328b;
        if (r103 == null) goto L15;
        postDelayed(new b(r103, this), 1000);
        return;
    L15:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void pauseCountDown() {
        Lazy r100 = ActivityCountDownTimer.f45499c;
        l1 r101 = ActivityCountDownTimer.a.a().f45501b;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void resumeCountDown() {
        Lazy r100 = ActivityCountDownTimer.f45499c;
        l1 r101 = ActivityCountDownTimer.a.a().f45501b;
        if (r101 == null) goto L6;
        r101.c();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void stopCountDown() {
        Lazy r100 = ActivityCountDownTimer.f45499c;
        ActivityCountDownTimer.a.a().c();
        post(new c(this));
    }

    private final int getLayout() {
        if (ld3.c.h() == false) goto L5;
        return R.layout.ec_inflow_activity_layout_largefont_ver;
    L5:
        return R.layout.ec_inflow_activity_layout;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final View b(int r100) {
        if (this.f176327a != null) goto L5;
        this.f176327a = new LinkedHashMap();
    L5:
        View r101 = this.f176327a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f176327a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void c(CommonGirdleStructV2 r110) {
        GenericDraweeView r100 = (GenericDraweeView) findViewById(R.id.common_girdle_name_pic);
        GenericDraweeView r101 = (GenericDraweeView) findViewById(R.id.common_girdle_bg_pic);
        GenericDraweeView r111 = (GenericDraweeView) findViewById(R.id.common_girdle_slogan_pic);
        this.f176328b = r110;
        if (r110 == null) goto L10;
        ECUrlModel r102 = r110.getNamePic();
        if (r102 == null) goto L10;
        ViewGroup.LayoutParams r112 = r100.getLayoutParams();
        if (r112 == null) goto L9;
        r112.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r102.getWidth()));
        r112.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r102.getHeight()));
    L9:
        int r113 = h.f175450a;
        h0.d(r100, r102, h.a.a(), null, null, null, null, 120);
    L10:
        CommonGirdleStructV2 r114 = this.f176328b;
        if (r114 == null) goto L15;
        ECUrlModel r103 = r114.getBgPic();
        if (r103 == null) goto L15;
        int r115 = h.f175450a;
        h0.d(r101, r103, h.a.a(), null, null, null, null, 120);
    L15:
        CommonGirdleStructV2 r116 = this.f176328b;
        String r104 = null;
        if (r116 == null) goto L18;
        CountDown r117 = r116.getCountdown();
    L20:
        if (r117 == null) goto L31;
        CommonGirdleStructV2 r118 = this.f176328b;
        if (r118 == null) goto L62;
        CountDown r119 = r118.getCountdown();
        if (r119 != null) goto L26;
        return;
    L26:
        if (r119.getServerTime() >= r119.getEndTime()) goto L28;
        boolean r105 = true;
    L29:
        if (r105 == false) goto L64;
        findViewById(R.id.ll_sec_kill_time).setVisibility(0);
        long r106 = System.currentTimeMillis() / 1000;
        long r107 = r119.getEndTime();
        s0.c(this);
        this.f176330d = r106;
        this.f176331e = r107;
        Lazy r120 = ActivityCountDownTimer.f45499c;
        ActivityCountDownTimer.a.a().a(this.f176330d, this.f176331e, this, null);
        return;
    L64:
        return;
    L28:
        r105 = false;
        goto L29
    L62:
        return;
    L31:
        CommonGirdleStructV2 r121 = this.f176328b;
        if (r121 == null) goto L36;
        CommonGirdleStructV2Slogan r122 = r121.getSlogan();
        if (r122 == null) goto L36;
        ECUrlModel r123 = r122.getPic();
    L37:
        if (r123 == null) goto L48;
        CommonGirdleStructV2 r124 = this.f176328b;
        if (r124 == null) goto L66;
        CommonGirdleStructV2Slogan r125 = r124.getSlogan();
        if (r125 == null) goto L67;
        ECUrlModel r108 = r125.getPic();
        if (r108 == null) goto L68;
        r111.setVisibility(0);
        ViewGroup.LayoutParams r126 = r111.getLayoutParams();
        if (r126 == null) goto L47;
        r126.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r108.getWidth()));
        r126.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r108.getHeight()));
    L47:
        int r127 = h.f175450a;
        h0.d(r111, r108, h.a.a(), null, null, null, null, 120);
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L48:
        CommonGirdleStructV2 r128 = this.f176328b;
        if (r128 == null) goto L53;
        CommonGirdleStructV2Slogan r129 = r128.getSlogan();
        if (r129 == null) goto L53;
        r104 = r129.getText();
    L53:
        if (r104 == null) goto L70;
        CommonGirdleStructV2 r130 = this.f176328b;
        if (r130 == null) goto L71;
        CommonGirdleStructV2Slogan r131 = r130.getSlogan();
        if (r131 == null) goto L72;
        String r132 = r131.getText();
        if (r132 == null) goto L73;
        TextView r109 = (TextView) findViewById(R.id.common_girdle_slogan_text);
        r109.setVisibility(0);
        r109.setText(r132);
        return;
    L73:
        return;
    L72:
        return;
    L71:
        return;
    L70:
        return;
    L36:
        r123 = null;
        goto L37
    L18:
        r117 = null;
        goto L20
    }

    @Subscribe
    public final void onActivityCountDownStopEvent(b53.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        stopCountDown();
        s0.e(this);
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onTick(long r100) {
        int r101 = c2.f45564h;
        c2 r102 = c2.a.a(getContext(), r100, false);
        if (r102.f45565a <= 0) goto L5;
        ((LinearLayout) b(R.id.days_layout)).setVisibility(0);
        ((TextView) b(R.id.tv_days)).setText(r102.f45566b);
    L5:
        ((TextView) b(R.id.tv_hours)).setText(r102.f45567c);
        ((TextView) b(R.id.tv_min)).setText(r102.f45568d);
        ((TextView) b(R.id.tv_sec)).setText(r102.f45569e);
        ((LinearLayout) b(R.id.ll_sec_kill_time)).setVisibility(0);
    }

    public final void setOnActivityChangeListener(Function1<? super CommonGirdleStructV2, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onActivityChangeListener");
        this.f176329c = r100;
    }

    public InFlowActivityLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f176327a = new LinkedHashMap();
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r103 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(getContext()).aU(getLayout(), this, true);
    L6:
        post(new com.bytedance.android.shopping.inflow.view.a(this));
        return;
    L5:
        ShoppingAsyncInflater.a r104 = ShoppingAsyncInflater.f45268e;
        Context r105 = getContext();
        r104.getClass();
        ShoppingAsyncInflater.a.a(r105).aU(getLayout(), this, true);
        goto L6
    }

    public /* synthetic */ InFlowActivityLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
