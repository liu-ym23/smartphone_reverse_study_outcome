package com.bytedance.android.live.soloktv.tuningpanel.callback;

import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view.TuningButtonListAdapter;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.live.soloktv.util.j;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.live.datacontext.n;
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

/* JADX INFO: loaded from: classes7.dex */
public final class SoloKtvTuningButtonOuterCallback implements bc0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f101567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f101568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f101569c;

    @Override // bc0.b
    public final int c() {
        return 2;
    }

    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a g() {
        return (com.bytedance.android.live.ktv.common.tuningpanel.ability.a) this.f101569c.getValue();
    }

    @Override // bc0.b
    public final void clearData() {
        ((CompositeDisposable) this.f101567a.getValue()).clear();
    }

    public SoloKtvTuningButtonOuterCallback() {
        this.f101567a = LazyKt.lazy(SoloKtvTuningButtonOuterCallback$compositeDisposable$2.INSTANCE);
        this.f101568b = LazyKt.lazy(SoloKtvTuningButtonOuterCallback$curMusic$2.INSTANCE);
        this.f101569c = LazyKt.lazy(SoloKtvTuningButtonOuterCallback$tuningCore$2.INSTANCE);
    }

    public final void h() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = g();
        if (r100 == null) goto L6;
        r100.i();
        return;
    }

    @Override // bc0.b
    public final void a(TuningButtonListAdapter r110) {
        Intrinsics.checkNotNullParameter(r110, "tuningButtonUIAbility");
        ArrayList r100 = new ArrayList();
        TuningButtonType r101 = TuningButtonType.ORIGIN_ITEM;
        String r102 = s1.B(R.string.ttlive_ktv_sing_original);
        j r103 = j.f101607a;
        MusicPanel r104 = (MusicPanel) this.f101568b.getValue();
        r103.getClass();
        boolean r105 = j.a(r104);
        MusicPanel r106 = (MusicPanel) this.f101568b.getValue();
        if (r106 != null) goto L5;
    L7:
        float r107 = 0.5f;
    L8:
        r100.add(new ac0.a(r101, r102, r105, false, r107, 40));
        if (j.i() == true) goto L31;
        TuningButtonType r108 = TuningButtonType.SCORE_ITEM;
        String r109 = s1.B(R.string.ttlive_ktv_score);
        if (com.bytedance.android.livesdk.sharedpref.c.U.getValue().booleanValue() == false) goto L21;
        SoloKtvContext.Companion.getClass();
        n<MusicPanel> r111 = SoloKtvContext.a.a().getCurMusicPanel();
        if (r111 == null) goto L17;
        MusicPanel r112 = r111.getValue();
        if (r112 == null) goto L17;
        String r113 = r112.f153593q;
    L19:
        if (TextUtils.isEmpty(r113) == true) goto L21;
        boolean r114 = true;
    L22:
        SoloKtvContext.Companion.getClass();
        n<MusicPanel> r115 = SoloKtvContext.a.a().getCurMusicPanel();
        if (r115 == null) goto L29;
        MusicPanel r116 = r115.getValue();
        if (r116 == null) goto L29;
        if (KtvUtilsKt.B(r116) != true) goto L29;
        float r117 = 1.0f;
    L30:
        r100.add(new ac0.a(r108, r109, r114, false, r117, 40));
    L29:
        r117 = 0.5f;
    L17:
        r113 = null;
    L21:
        r114 = false;
    L31:
        Unit r118 = Unit.INSTANCE;
        r110.y2(r100);
        return;
    L5:
        if (KtvUtilsKt.D(r106) != true) goto L7;
        r107 = 1.0f;
        goto L8
    }

    @Override // bc0.b
    public final void b(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
    }

    public static final void f(SoloKtvTuningButtonOuterCallback r100, Boolean r101) {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r102 = r100.g();
        if (r102 == null) goto L6;
        r102.i();
        return;
    }

    @Override // bc0.b
    public final void d(TuningButtonListAdapter r100, WeakReference r101, LifecycleOwner r102) {
        Intrinsics.checkNotNullParameter(r100, "tuningButtonUIAbility");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "owner");
        Context r103 = (Context) r101.get();
        Object r104 = null;
        if (r103 == null) goto L5;
        Object r105 = r103.getSystemService("audio");
    L7:
        if ((r105 instanceof AudioManager) == false) goto L10;
        r104 = r105;
    L10:
        AudioManager r106 = (AudioManager) r104;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r107 = g();
        if (r107 == null) goto L18;
        if (r106 == null) goto L16;
        boolean r108 = true;
        if (r106.isWiredHeadsetOn() != true) goto L16;
    L17:
        r107.K(r108);
    L16:
        r108 = false;
    L18:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r109 = g();
        if (r109 == null) goto L21;
        r109.t(r102, new a(this));
    L21:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r110 = g();
        if (r110 == null) goto L24;
        r110.a0(r102, new b(this));
    L24:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r111 = g();
        if (r111 == null) goto L29;
        MutableLiveData<Boolean> r112 = r111.F();
        if (r112 == null) goto L29;
        r112.observe(r102, new c(this, r100));
    L29:
        h();
        Disposable r113 = xs2.b.a().b(cb0.b.class).subscribe(new d(this));
        if (r113 == null) goto L33;
        RxUtilKt.c(r113, (CompositeDisposable) this.f101567a.getValue());
        return;
    L33:
        return;
    L5:
        r105 = null;
        goto L7
    }

    @Override // bc0.b
    public final void e(TuningButtonListAdapter r100, ac0.a r101, final boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tuningButtonUIAbility");
        Intrinsics.checkNotNullParameter(r101, "tuningButtonData");
        r100.m2(new SoloKtvTuningButtonOuterCallback$onButtonChecked$1(this, r102), r101.getType(), false);
    }
}
