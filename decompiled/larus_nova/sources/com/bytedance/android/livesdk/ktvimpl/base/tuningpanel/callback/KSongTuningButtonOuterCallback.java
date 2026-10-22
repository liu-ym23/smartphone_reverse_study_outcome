package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view.TuningButtonListAdapter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class KSongTuningButtonOuterCallback implements bc0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f143472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public bc0.c f143473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f143474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LifecycleOwner f143475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a f143476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zb0.a f143477f;

    @Override // bc0.b
    public final int c() {
        return 2;
    }

    public final ec0.a f() {
        return (ec0.a) this.f143472a.getValue();
    }

    @Override // bc0.b
    public final void clearData() {
        this.f143474c.clear();
        this.f143473b = null;
    }

    public final void g() {
        ec0.a r100 = f();
        final Boolean r101 = null;
        if (r100 == null) goto L5;
        final Boolean r102 = Boolean.valueOf(r100.b());
    L6:
        ec0.a r103 = f();
        if (r103 == null) goto L9;
        r101 = Boolean.valueOf(r103.h());
    L9:
        bc0.c r104 = this.f143473b;
        if (r104 == null) goto L13;
        r104.m2(new KSongTuningButtonOuterCallback$handleScoreSwitchChanged$1(r102, r101), TuningButtonType.SCORE_ITEM, false);
        return;
    L13:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // bc0.b
    public final void a(TuningButtonListAdapter r110) {
        Intrinsics.checkNotNullParameter(r110, "tuningButtonUIAbility");
        this.f143473b = r110;
        if (r110 == null) goto L11;
        ArrayList r100 = new ArrayList();
        r100.add(new ac0.a(TuningButtonType.ORIGIN_ITEM, s1.B(R.string.ttlive_ktv_sing_original), false, false, 0.0f, 60));
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r101 = this.f143476e;
        if (r101 != null) goto L7;
    L9:
        Unit r102 = Unit.INSTANCE;
        r110.y2(r100);
        return;
    L7:
        if (r101.isInRealTimeChorus() == true) goto L9;
        r100.add(new ac0.a(TuningButtonType.SCORE_ITEM, s1.B(R.string.ttlive_ktv_component_score_switch_title), false, false, 0.0f, 60));
        goto L9
    }

    @Override // bc0.b
    public final void b(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        this.f143475d = r100;
    }

    public KSongTuningButtonOuterCallback(com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100, KSongTuningPanelOuterCallback r101) {
        this.f143476e = r100;
        this.f143477f = r101;
        this.f143472a = LazyKt.lazy(KSongTuningButtonOuterCallback$tuningMusicControl$2.INSTANCE);
        this.f143474c = new CompositeDisposable();
    }

    @Override // bc0.b
    public final void d(TuningButtonListAdapter r100, WeakReference r101, LifecycleOwner r102) {
        Intrinsics.checkNotNullParameter(r100, "tuningButtonUIAbility");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "owner");
        if (((Context) r101.get()) == null) goto L23;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r103 = this.f143476e;
        if (r103 == null) goto L7;
        r103.i();
    L7:
        bc0.c r104 = this.f143473b;
        if (r104 == null) goto L10;
        r104.m2(new KSongTuningButtonOuterCallback$handleOriginSwitchChanged$1(this), TuningButtonType.ORIGIN_ITEM, false);
    L10:
        ec0.a r105 = f();
        if (r105 == null) goto L16;
        LifecycleOwner r106 = this.f143475d;
        if (r106 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mLifecycleOwner");
    L15:
        r105.f(r106, new c(this));
    L16:
        g();
        ec0.a r107 = f();
        if (r107 == null) goto L24;
        LifecycleOwner r108 = this.f143475d;
        if (r108 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mLifecycleOwner");
    L21:
        r107.r(r108, new d(this));
        return;
    L24:
        return;
    }

    @Override // bc0.b
    public final void e(TuningButtonListAdapter r100, ac0.a r101, final boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tuningButtonUIAbility");
        Intrinsics.checkNotNullParameter(r101, "tuningButtonData");
        bc0.c r103 = this.f143473b;
        if (r103 == null) goto L5;
        r103.m2(new KSongTuningButtonOuterCallback$onButtonChecked$1(this, r102), r101.getType(), false);
    L5:
        zb0.a r104 = this.f143477f;
        if (r104 == null) goto L9;
        r104.d(r101, r102);
        return;
    }
}
