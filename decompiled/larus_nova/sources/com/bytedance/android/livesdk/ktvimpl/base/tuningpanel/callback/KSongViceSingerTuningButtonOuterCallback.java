package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import android.content.Context;
import android.media.AudioManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view.TuningButtonListAdapter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public class KSongViceSingerTuningButtonOuterCallback implements bc0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f143480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public bc0.c f143481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f143482c;

    @Override // bc0.b
    public final int c() {
        return 1;
    }

    public com.bytedance.android.live.ktv.common.tuningpanel.ability.a f() {
        return (com.bytedance.android.live.ktv.common.tuningpanel.ability.a) this.f143482c.getValue();
    }

    @Override // bc0.b
    public final void clearData() {
        this.f143480a.clear();
        this.f143481b = null;
    }

    public KSongViceSingerTuningButtonOuterCallback() {
        this.f143480a = new CompositeDisposable();
        this.f143482c = LazyKt.lazy(KSongViceSingerTuningButtonOuterCallback$tuningCore$2.INSTANCE);
    }

    public boolean g() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = f();
        if (r100 == null) goto L7;
        r100.i();
        return false;
    L7:
        return false;
    }

    public final void h() {
        if (g() == false) goto L36;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = f();
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.h() == true) goto L38;
        bc0.c r101 = this.f143481b;
        if (r101 == null) goto L39;
        TuningButtonType r102 = TuningButtonType.ECHO_ITEM;
        String r103 = s1.B(R.string.ttlive_ktv_echo);
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r104 = f();
        boolean r105 = false;
        if (r104 == null) goto L17;
        MutableLiveData<Boolean> r106 = r104.F();
        if (r106 == null) goto L17;
        Boolean r107 = r106.getValue();
        if (r107 == null) goto L17;
        boolean r108 = r107.booleanValue();
    L18:
        Boolean r109 = null;
        if (r108 == false) goto L27;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r110 = f();
        if (r110 == null) goto L23;
        Boolean r111 = r110.I();
    L25:
        if (Intrinsics.areEqual(r111, Boolean.TRUE) == false) goto L27;
        r105 = true;
        goto L27
    L23:
        r111 = null;
    L27:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r112 = f();
        if (r112 == null) goto L31;
        r109 = r112.I();
    L31:
        if (Intrinsics.areEqual(r109, Boolean.TRUE) == false) goto L33;
        float r113 = 1.0f;
    L34:
        r101.j0(new ac0.a(r102, r103, r105, false, r113, 40));
        return;
    L33:
        r113 = 0.5f;
    L17:
        r108 = false;
        goto L18
    L39:
        return;
    L38:
        return;
    }

    @Override // bc0.b
    public final void a(TuningButtonListAdapter r110) {
        Intrinsics.checkNotNullParameter(r110, "tuningButtonUIAbility");
        if (g() == true) goto L5;
        return;
    L5:
        ArrayList r100 = new ArrayList();
        r100.add(new ac0.a(TuningButtonType.ECHO_ITEM, s1.B(R.string.ttlive_ktv_echo), false, false, 0.0f, 60));
        Unit r101 = Unit.INSTANCE;
        r110.y2(r100);
    }

    @Override // bc0.b
    public final void b(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
    }

    @Override // bc0.b
    public final void d(TuningButtonListAdapter r100, WeakReference r101, LifecycleOwner r102) {
        Intrinsics.checkNotNullParameter(r100, "tuningButtonUIAbility");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "owner");
        this.f143481b = r100;
        if (g() == true) goto L5;
        return;
    L5:
        Context r103 = (Context) r101.get();
        Object r104 = null;
        if (r103 == null) goto L8;
        Object r105 = r103.getSystemService("audio");
    L10:
        if ((r105 instanceof AudioManager) == false) goto L13;
        r104 = r105;
    L13:
        AudioManager r106 = (AudioManager) r104;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r107 = f();
        if (r107 == null) goto L21;
        if (r106 == null) goto L19;
        boolean r108 = true;
        if (r106.isWiredHeadsetOn() != true) goto L19;
    L20:
        r107.K(r108);
    L19:
        r108 = false;
    L21:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r109 = f();
        if (r109 == null) goto L24;
        r109.t(r102, new o(this));
    L24:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r110 = f();
        if (r110 == null) goto L27;
        r110.a0(r102, new p(this));
    L27:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r111 = f();
        if (r111 == null) goto L32;
        MutableLiveData<Boolean> r112 = r111.F();
        if (r112 == null) goto L32;
        r112.observe(r102, new q(this, r100));
    L32:
        h();
        Disposable r113 = xs2.b.a().b(cb0.b.class).subscribe(new r(this));
        if (r113 == null) goto L36;
        RxUtilKt.c(r113, this.f143480a);
        return;
    L36:
        return;
    L8:
        r105 = null;
        goto L10
    }

    @Override // bc0.b
    public final void e(TuningButtonListAdapter r100, ac0.a r101, final boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tuningButtonUIAbility");
        Intrinsics.checkNotNullParameter(r101, "tuningButtonData");
        r100.m2(new KSongViceSingerTuningButtonOuterCallback$onButtonChecked$1(this, r102), r101.getType(), false);
    }
}
