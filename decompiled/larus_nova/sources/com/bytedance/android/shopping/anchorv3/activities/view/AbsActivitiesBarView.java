package com.bytedance.android.shopping.anchorv3.activities.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.compose.ui.spatial.RectListKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.utils.ActivityCountDownTimer;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001'B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0004¢\u0006\u0004\b%\u0010&J\b\u0010\u0005\u001a\u00020\u0004H$J\u001a\u0010\n\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\b\u0010\u000b\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007R\"\u0010\u0018\u001a\u00020\u00118\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/activities/view/AbsActivitiesBarView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/utils/l1$a;", "Landroidx/lifecycle/LifecycleObserver;", "", "getLayout", "Lkotlin/Function1;", "Lcom/bytedance/android/shopping/anchorv3/activities/vo/ActivityVO;", "", "onActivityChangeListener", "setOnActivityChangeListener", "resumeCountDown", "pauseCountDown", "stopCountDown", "Lb53/a;", "event", "onActivityCountDownStopEvent", "", "c", "J", "getMEndTime", "()J", "setMEndTime", "(J)V", "mEndTime", "d", "Lcom/bytedance/android/shopping/anchorv3/activities/vo/ActivityVO;", "getMActivityVO", "()Lcom/bytedance/android/shopping/anchorv3/activities/vo/ActivityVO;", "setMActivityVO", "(Lcom/bytedance/android/shopping/anchorv3/activities/vo/ActivityVO;)V", "mActivityVO", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsActivitiesBarView extends FrameLayout implements l1.a, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super ActivityVO, Unit> f164418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f164419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f164420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActivityVO f164421d;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityVO f164422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbsActivitiesBarView f164423b;

        public b(ActivityVO r100, AbsActivitiesBarView r101) {
            this.f164422a = r100;
            this.f164423b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<? super ActivityVO, Unit> r100 = this.f164423b.f164418a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            Unit r101 = r100.invoke(this.f164422a);     // Catch: Throwable -> L6
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
        public final /* synthetic */ AbsActivitiesBarView f164424a;

        public c(AbsActivitiesBarView r100) {
            this.f164424a = r100;
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
            if ((this.f164424a.getContext() instanceof LifecycleOwner) == false) goto L12;
            Object r100 = this.f164424a.getContext();     // Catch: Throwable -> L9
            if (r100 == null) goto L8;
            ((LifecycleOwner) r100).getLifecycle().removeObserver(this.f164424a);     // Catch: Throwable -> L9
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");     // Catch: Throwable -> L9
        }
    }

    static {
    }

    public AbsActivitiesBarView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AbsActivitiesBarView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public abstract void c(c2 r100);

    public abstract void e(ActivityVO r100, Long r101, PromotionProductStruct r102, boolean r103);

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        return false;
    }

    public abstract int getLayout();

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onStart() {
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onFinish() {
        Lazy r100 = ActivityCountDownTimer.f45499c;
        ActivityCountDownTimer.a.a().f45500a--;
        ActivityCountDownTimer r101 = ActivityCountDownTimer.a.a();
        if (r101.f45500a != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L24;
        ActivityVO r103 = this.f164421d;
        if (r103 == null) goto L25;
        int r104 = r103.getActivityType();
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L17;
        r103.setOnActivity(false);
        r103.setActivityType(0);
    L22:
        postDelayed(new b(r103, this), 1000);
        return;
    L17:
        r103.setOnActivity(false);
        r103.setActivityType(4);
        b(r103);
        goto L22
    L19:
        if (r103.isOnActivity() == true) goto L21;
        r103.setOnActivity(true);
        goto L22
    L21:
        r103.setOnActivity(false);
        r103.setActivityType(0);
        b(r103);
        goto L22
    L25:
        return;
    L24:
        return;
    L5:
        r102 = false;
        goto L6
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

    public final int hashCode() {
        return super.hashCode();
    }

    public final ActivityVO getMActivityVO() {
        return this.f164421d;
    }

    public final long getMEndTime() {
        return this.f164420c;
    }

    public final void b(ActivityVO r100) {
        if (r100.getIpActivityInfo() == null) goto L5;
        r100.setActivityType(7);
        r100.setOnActivity(true);
        d(System.currentTimeMillis(), r100.getIpActivityInfo().getEndTime());
        return;
    L5:
        r100.setActivityType(0);
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
        c(c2.a.a(getContext(), r100, false));
    }

    public final void setMActivityVO(ActivityVO r100) {
        this.f164421d = r100;
    }

    public final void setMEndTime(long r100) {
        this.f164420c = r100;
    }

    public final void setOnActivityChangeListener(Function1<? super ActivityVO, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onActivityChangeListener");
        this.f164418a = r100;
    }

    public final void d(long r100, long r110) {
        s0.c(this);
        this.f164419b = r100;
        this.f164420c = r110;
        Lazy r101 = ActivityCountDownTimer.f45499c;
        ActivityCountDownTimer.a.a().a(this.f164419b, this.f164420c, this, null);
    }

    public AbsActivitiesBarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r103 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(getContext()).aU(getLayout(), this, true);
    L6:
        post(new e53.a(this));
        return;
    L5:
        u63.a.a(getContext(), getLayout(), this, true);
        goto L6
    }

    public /* synthetic */ AbsActivitiesBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void f(ActivityVO r310, Long r311, boolean r312, AnchorV3Param r410, PromotionProductStruct r411, boolean r412) {
        Intrinsics.checkNotNullParameter(r310, "activityVO");
        ActivityVO r100 = ActivityVO.copy$default(r310, null, 0, 0, 0, null, null, null, null, false, 0, null, 0, false, null, null, null, null, null, null, null, 0, null, null, null, null, null, RectListKt.Lower26Bits, null);
        this.f164421d = r100;
        if (r100 == null) goto L60;
        int r101 = r100.getActivityType();
        if (r101 != 0) goto L7;
        setVisibility(8);
        stopCountDown();
        return;
    L7:
        if (r101 == 1) goto L39;
        if (r101 != 2) goto L11;
        setVisibility(0);
        d(System.currentTimeMillis() / 1000, r100.getEndTime());
        e(r100, r311, r411, r412);
        return;
    L11:
        if (r101 != 3) goto L13;
        setVisibility(0);
        d(System.currentTimeMillis() / 1000, r100.getEndTime());
        e(r100, r311, r411, r412);
        return;
    L13:
        if (r101 == 6) goto L33;
        if (r101 == 7) goto L29;
        if (r101 == 8) goto L25;
        if (r101 != 12) goto L20;
        setVisibility(0);
        e(r100, null, r411, r412);
        return;
    L20:
        if (r101 == 14) goto L22;
        setVisibility(8);
        stopCountDown();
        return;
    L22:
        setVisibility(0);
        e(r100, null, r411, r412);
        return;
    L25:
        if (a53.a.a() != 1) goto L27;
        setVisibility(0);
        e(r100, r311, r411, r412);
        stopCountDown();
        return;
    L27:
        setVisibility(8);
        stopCountDown();
        return;
    L29:
        if (r100.isOnActivity() == false) goto L31;
        setVisibility(0);
        d(System.currentTimeMillis() / 1000, r100.getEndTime());
    L31:
        e(r100, null, r411, r412);
        return;
    L33:
        if (r100.isOnActivity() == false) goto L35;
        setVisibility(0);
        d(System.currentTimeMillis() / 1000, r100.getEndTime());
    L35:
        e(r100, r311, r411, r412);
        return;
    L39:
        if (r100.isOnActivity() == false) goto L41;
    L42:
        setVisibility(0);
    L44:
        if (r100.isOnActivity() == false) goto L46;
        d(System.currentTimeMillis() / 1000, r100.getEndTime());
    L57:
        e(r100, r311, r411, r412);
        return;
    L46:
        if (r100.getIpActivityInfo() == null) goto L55;
        if (r411 == null) goto L54;
        PromotionProductBaseStruct r102 = r411.getBaseInfo();
        if (r102 == null) goto L54;
        if (r102.isSoldOut() != true) goto L54;
        d(System.currentTimeMillis() / 1000, r100.getStartTime());
    L54:
        d(System.currentTimeMillis() / 1000, r100.getIpActivityInfo().getEndTime());
        goto L57
    L55:
        d(System.currentTimeMillis() / 1000, r100.getStartTime());
        goto L57
    L41:
        if (r310.getIpActivityInfo() == null) goto L44;
    }
}
