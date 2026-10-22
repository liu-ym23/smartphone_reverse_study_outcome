package com.bytedance.android.live.ktv.common.tuningpanel.ability;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.model.bean.h;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view.e;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.tuningpanel.ability.a$a, reason: collision with other inner class name */
    public static final class C1143a {
        public static /* synthetic */ void a(a r100, boolean r101, String r102) {
            r100.H(r101, r102, ITuningCore$updateRealRtcCellular$1.INSTANCE);
        }

        public static /* synthetic */ void b(a r100, float r101, int r102) {
            boolean r103 = true;
            if ((r102 & 2) == 0) goto L5;
            boolean r104 = true;
        L7:
            if ((r102 & 4) != 0) goto L10;
            r103 = false;
        L10:
            r100.m(r101, r104, r103);
            return;
        L5:
            r104 = false;
            goto L7
        }
    }

    float A();

    void B(boolean r100);

    void C();

    int D();

    void E();

    MutableLiveData<Boolean> F();

    void G(float r100);

    void H(boolean r100, String r101, Function1<? super Boolean, Unit> r102);

    Boolean I();

    void K(boolean r100);

    void L();

    int M();

    int N();

    boolean O();

    void P();

    void Q(h r100, boolean r101);

    boolean R();

    void S(boolean r100);

    int U();

    float V();

    float X();

    void Y(boolean r100);

    boolean Z();

    boolean a();

    void a0(LifecycleOwner r100, Observer<Boolean> r101);

    void b();

    void b0();

    void c();

    void c0(double r100);

    void clearData();

    boolean d(TuningVolumeType r100);

    float e();

    void e0(float r100);

    float f();

    void f0();

    void g(float r100);

    void g0(double r100);

    boolean h();

    void i();

    boolean isInRealTimeChorus();

    void j(float r100);

    void k(boolean r100);

    void m(float r100, boolean r101, boolean r102);

    boolean n();

    void o();

    void onPageCreate();

    void onPageResume();

    void onPageStop();

    boolean p();

    void q(boolean r100, boolean r101);

    boolean r();

    void s();

    void setTuningEffect(String r100);

    void t(LifecycleOwner r100, Observer<Boolean> r101);

    int u();

    boolean v();

    int w();

    void x(LifecycleOwner r100, e r101);

    void y();
}
