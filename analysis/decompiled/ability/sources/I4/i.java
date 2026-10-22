package I4;

import Z7.t;
import fa.C1449a;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

/* loaded from: classes3.dex */
public final class i {
    public static final /* synthetic */ t[] d;

    /* renamed from: a, reason: collision with root package name */
    public final C1449a f800a;
    public final C1449a b;
    public final C1449a c;

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl(i.class, "glowDelayS", "getGlowDelayS()F", 0);
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        d = new t[]{nVar.e(mutablePropertyReference1Impl), androidx.compose.foundation.b.i(i.class, "rippleDelayS", "getRippleDelayS()F", 0, nVar), androidx.compose.foundation.b.i(i.class, "waterDelayS", "getWaterDelayS()F", 0, nVar), androidx.compose.foundation.b.i(i.class, "waveStartAtS", "getWaveStartAtS()F", 0, nVar), androidx.compose.foundation.b.i(i.class, "waveIntroDurS", "getWaveIntroDurS()F", 0, nVar)};
    }

    public i(A5.c cVar) {
        int i = 2;
        new C1449a(i, cVar, "glowDelayS");
        new C1449a(i, cVar, "rippleDelayS");
        this.f800a = new C1449a(i, cVar, "waterDelayS");
        this.b = new C1449a(i, cVar, "waveStartAtS");
        this.c = new C1449a(i, cVar, "waveIntroDurS");
    }
}
