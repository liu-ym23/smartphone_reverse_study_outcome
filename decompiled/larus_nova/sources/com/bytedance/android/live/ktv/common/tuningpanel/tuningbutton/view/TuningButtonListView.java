package com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Landroidx/lifecycle/LifecycleRegistry;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Lbc0/a;", "e", "getTuningButtonInnerCallback", "()Lbc0/a;", "tuningButtonInnerCallback", "Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListAdapter;", "f", "getTuningButtonListAdapter", "()Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListAdapter;", "tuningButtonListAdapter", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningButtonListView extends RecyclerView implements LifecycleOwnerCompat {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f70484h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f70485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a f70486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ec0.a f70487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f70488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f70489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f70490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ac0.b f70491g;

    public static final class a {
    }

    static {
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        return (LifecycleRegistry) this.f70485a.getValue();
    }

    private final bc0.a getTuningButtonInnerCallback() {
        return (bc0.a) this.f70489e.getValue();
    }

    private final TuningButtonListAdapter getTuningButtonListAdapter() {
        return (TuningButtonListAdapter) this.f70490f.getValue();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public final void v() {
        ec0.a r100 = this.f70487c;
        final Boolean r101 = null;
        if (r100 == null) goto L5;
        final Boolean r102 = Boolean.valueOf(r100.b());
    L6:
        ec0.a r103 = this.f70487c;
        if (r103 == null) goto L9;
        r101 = Boolean.valueOf(r103.h());
    L9:
        getTuningButtonListAdapter().m2(new TuningButtonListView$handleScoreSwitchChanged$1(r102, r101), TuningButtonType.SCORE_ITEM, false);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public Lifecycle getLifecycleCompat() {
        return getLifecycleRegistry();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLifecycleRegistry().setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getLifecycleRegistry().setCurrentState(Lifecycle.State.DESTROYED);
        bc0.b r100 = this.f70491g.f2539f;
        if (r100 == null) goto L5;
        r100.clearData();
    L5:
        this.f70488d.clear();
    }

    public final void u() {
        getTuningButtonListAdapter().m2(new TuningButtonListView$handleOriginSwitchChanged$1(this), TuningButtonType.ORIGIN_ITEM, false);
    }

    public static final /* synthetic */ bc0.a r(TuningButtonListView r100) {
        return r100.getTuningButtonInnerCallback();
    }

    public static final /* synthetic */ TuningButtonListAdapter t(TuningButtonListView r100) {
        return r100.getTuningButtonListAdapter();
    }

    public TuningButtonListView(ac0.b r210, Context r211) {
        Intrinsics.checkNotNullParameter(r210, "config");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r211);
        this.f70491g = r210;
        this.f70485a = LazyKt.lazy(new TuningButtonListView$lifecycleRegistry$2(this));
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = r210.f2544k;
        this.f70486b = r100;
        ec0.a r101 = r210.f2545l;
        this.f70487c = r101;
        this.f70488d = new CompositeDisposable();
        this.f70489e = LazyKt.lazy(new TuningButtonListView$tuningButtonInnerCallback$2(this));
        this.f70490f = LazyKt.lazy(new TuningButtonListView$tuningButtonListAdapter$2(this));
        getLifecycleRegistry().setCurrentState(Lifecycle.State.CREATED);
        bc0.b r102 = r210.f2539f;
        if (r102 == null) goto L5;
        r102.b(this);
    L5:
        setAdapter(getTuningButtonListAdapter());
        bc0.b r103 = r210.f2539f;
        if (r103 == null) goto L8;
        int r104 = r103.c();
    L9:
        GridLayoutManager r105 = new GridLayoutManager(r211, r104, 1, false);
        r105.setSpanSizeLookup(new AnonymousClass1(this));
        setLayoutManager(r105);
        bc0.b r106 = r210.f2539f;
        if (r106 == null) goto L12;
        r106.a(getTuningButtonListAdapter());
    L16:
        bc0.b r107 = r210.f2539f;
        if (r107 == null) goto L19;
        r107.d(getTuningButtonListAdapter(), new WeakReference(r211), this);
        return;
    L19:
        if (r100 == null) goto L21;
        r100.i();
    L21:
        u();
        if (r101 == null) goto L24;
        r101.f(this, new b(this));
    L24:
        v();
        if (r101 == null) goto L29;
        r101.r(this, new c(this));
        return;
    L29:
        return;
    L12:
        TuningButtonListAdapter r108 = getTuningButtonListAdapter();
        ArrayList r109 = new ArrayList();
        r109.add(new ac0.a(TuningButtonType.ORIGIN_ITEM, s1.B(R.string.ttlive_ktv_sing_original), false, false, 0.0f, 60));
        r109.add(new ac0.a(TuningButtonType.SCORE_ITEM, s1.B(R.string.ttlive_ktv_component_score_switch_title), false, false, 0.0f, 60));
        if (r100 == null) goto L15;
        r100.i();
    L15:
        Unit r110 = Unit.INSTANCE;
        r108.y2(r109);
        goto L16
    L8:
        r104 = 2;
        goto L9
    }
}
