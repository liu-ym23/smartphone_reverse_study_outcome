package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import eu0.b0;
import eu0.j0;
import eu0.p0;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class TipMVIView extends com.bytedance.android.anya.d<eu0.j, p0, eu0.h> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f87502p = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f87503q = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f87504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f87505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f87506j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f87507k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f87508l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f87509m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final DataCenter f87510n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ViewGroup f87511o;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TipMVIView f87512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.anya.a0 f87513b;

        public b(TipMVIView r100, com.bytedance.android.anya.a0 r101) {
            this.f87512a = r100;
            this.f87513b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            TipMVIView r102 = this.f87512a;
            r102.o(new b0(false, ((j0) this.f87513b).f473995a, r102.f87510n));
        }
    }

    public final TextView p() {
        return (TextView) this.f87507k.getValue();
    }

    static {
        f87502p = UtilityKotlinExtentionsKt.h(131);
        f87503q = UtilityKotlinExtentionsKt.h(160);
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void g() {
        LayoutInflater.from(this.f87509m).inflate(R.layout.ttlive_user_info_mvi_entrance_tip, this.f87511o, true);
        UtilityKotlinExtentionsKt.t(this.f87511o);
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        this.f87504h.clear();
    }

    public final float q() {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r100 = fu0.b.a(this.f87510n);
        if (r100 != null) goto L7;
        return f87502p;
    L7:
        if (r100.I() == false) goto L9;
        boolean r101 = true;
        if (r100.K() == true) goto L14;
        r101 = true ^ r100.x();
    L14:
        if (r101 == false) goto L17;
        return f87502p;
    L17:
        return f87503q;
    L9:
        return f87502p;
    }

    public final Context getContext() {
        return this.f87509m;
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<eu0.j> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        TipMVIView$bindToParent$1 r101 = TipMVIView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final boolean d(com.bytedance.android.anya.a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if ((r100 instanceof j0) == false) goto L8;
        ALogger.w("FansClubTipMVIView", "ShowTipEffect");
        Disposable r101 = this.f87508l;
        if (r101 == null) goto L7;
        r101.dispose();
    L7:
        j0 r102 = (j0) r100;
        o(new b0(true, r102.f473995a, this.f87510n));
        Disposable r103 = RxUtilKt.h(Observable.timer(r102.f473996b, TimeUnit.MILLISECONDS)).subscribe(new b(this, r100));
        RxUtilKt.c(r103, this.f87504h);
        Unit r104 = Unit.INSTANCE;
        this.f87508l = r103;
        return true;
    L8:
        return false;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r110, MVIState r111) {
        p0 r100 = (p0) r111;
        Intrinsics.checkNotNullParameter(r110, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r100, "state");
        com.bytedance.android.anya.internal.r r101 = r100.f474055a;
        KProperty[] r102 = p0.f474054c;
        KProperty r103 = r102[0];
        r101.getClass();
        Object r104 = r110.f41740c.a(r101);
        String r105 = "FansClubTipMVIView";
        if (r104 == null) goto L9;
        r110.f41739b.f41563a.invoke(r101);
        boolean r106 = ((Boolean) r104).booleanValue();
        ALogger.i("FansClubTipMVIView", "show=" + r106);
        if (r106 == false) goto L7;
        UtilityKotlinExtentionsKt.w(this.f87511o);
        AnimatorSet r107 = new AnimatorSet();
        ValueAnimator r112 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r112.setStartDelay(200);
        r112.setDuration(150);
        r112.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.56f, 0.46f, 1.0f));
        r112.addUpdateListener(new z(this));
        ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{0.0f, q()});
        r108.setDuration(250);
        r108.setInterpolator(PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f));
        r108.addUpdateListener(new a0(this));
        r107.playTogether(new Animator[]{r112, r108});
        AnimatorSet r109 = com.bytedance.android.live.revenue.common.e.c(p(), new float[]{1.0f, 1.2f});
        r109.setStartDelay(150);
        r109.setDuration(150);
        r109.setInterpolator(PathInterpolatorCompat.create(0.29f, 0.22f, 0.21f, 1.51f));
        Unit r113 = Unit.INSTANCE;
        AnimatorSet r114 = com.bytedance.android.live.revenue.common.e.c(p(), new float[]{1.2f, 1.0f});
        r114.setDuration(200);
        r114.setInterpolator(PathInterpolatorCompat.create(0.29f, 0.22f, 0.21f, 1.51f));
        r107.playSequentially(new Animator[]{r109, r114});
        com.bytedance.android.live.revenue.common.e.b(r107, new TipMVIView$showTip$3(this));
        r107.start();
        goto L9
    L7:
        r105 = "FansClubTipMVIView";
        AnimatorSet r115 = new AnimatorSet();
        ValueAnimator r116 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r116.setDuration(150);
        r116.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.56f, 0.46f, 1.0f));
        r116.addUpdateListener(new x(this));
        ValueAnimator r117 = ValueAnimator.ofFloat(new float[]{q(), 0.0f});
        r117.setDuration(250);
        r117.setInterpolator(PathInterpolatorCompat.create(0.4f, 0.0f, 0.68f, 0.06f));
        r117.addUpdateListener(new y(this));
        char r118 = 1;
        r115.playTogether(new Animator[]{r116, r117});
        com.bytedance.android.live.revenue.common.e.b(r115, new TipMVIView$hideTip$1(this));
        r115.start();
    L10:
        com.bytedance.android.anya.internal.r r119 = r100.f474056b;
        KProperty r120 = r102[r118];
        r119.getClass();
        Object r121 = r110.f41740c.a(r119);
        if (r121 == null) goto L14;
        r110.f41739b.f41563a.invoke(r119);
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.k r122 = (com.bytedance.android.live.profit.fansclub.widget.entrance.data.k) r121;
        ALogger.i(r105, "tip=" + r122);
        ((TextView) this.f87506j.getValue()).setText(r122.f87415a);
        p().setText(r122.f87416b);
        return;
    L14:
        return;
    L9:
        r118 = 1;
        goto L10
    }

    public TipMVIView(Context r100, DataCenter r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "containerView");
        this.f87509m = r100;
        this.f87510n = r101;
        this.f87511o = r102;
        this.f87504h = new CompositeDisposable();
        this.f87505i = LazyKt.lazy(new TipMVIView$content$2(this));
        this.f87506j = LazyKt.lazy(new TipMVIView$line1$2(this));
        this.f87507k = LazyKt.lazy(new TipMVIView$line2$2(this));
    }
}
