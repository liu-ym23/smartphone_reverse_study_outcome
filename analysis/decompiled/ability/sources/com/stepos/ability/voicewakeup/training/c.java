package com.stepos.ability.voicewakeup.training;

import B9.Q;
import Ba.f;
import D6.i;
import G6.e;
import S7.k;
import g1.AbstractC1451a;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final i f3396a;
    public final e b;
    public final k c;
    public final Q d;
    public final f e;
    public final String f;
    public TrainingListenEffect g;
    public S7.a h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3397j;
    public boolean k;
    public long l;
    public boolean m;
    public boolean n;
    public boolean o;

    public c(i iVar, e eVar, k kVar, Q q5, f fVar, String str) {
        this.f3396a = iVar;
        this.b = eVar;
        this.c = kVar;
        this.d = q5;
        this.e = fVar;
        this.f = str;
    }

    public final void a() {
        S7.a aVar = this.h;
        if (aVar != null) {
            aVar.invoke();
        }
        this.h = null;
        TrainingListenEffect trainingListenEffect = this.g;
        this.g = null;
        this.i = false;
        if (trainingListenEffect != null) {
            try {
                trainingListenEffect.destroy();
            } catch (Exception e) {
                this.e.invoke(e);
            } finally {
                e(false);
            }
        }
    }

    public final void b(Throwable th) {
        this.e.invoke(th);
        this.k = true;
        a();
        this.d.invoke(Boolean.valueOf(this.m && !this.f3397j));
    }

    public final void c(long j5, float f) {
        if (!this.f3397j && this.m && j5 == this.l) {
            boolean z10 = this.k;
            Q q5 = this.d;
            if (z10) {
                q5.invoke(Boolean.TRUE);
                return;
            }
            try {
                if (this.i) {
                    a();
                }
                if (this.g == null) {
                    TrainingListenEffect trainingListenEffect = (TrainingListenEffect) this.f3396a.invoke();
                    this.g = trainingListenEffect;
                    e(true);
                    trainingListenEffect.start();
                    q5.invoke(Boolean.FALSE);
                }
                TrainingListenEffect trainingListenEffect2 = this.g;
                if (trainingListenEffect2 != null) {
                    trainingListenEffect2.setVolume(Math.abs(f) <= Float.MAX_VALUE ? AbstractC1451a.t(f, 0.0f, 1.0f) : 0.0f);
                }
            } catch (Exception e) {
                b(e);
            } catch (LinkageError e6) {
                b(e6);
            }
        }
    }

    public final void d() {
        this.o = false;
        this.m = false;
        this.l++;
        this.d.invoke(Boolean.FALSE);
        TrainingListenEffect trainingListenEffect = this.g;
        if (trainingListenEffect == null || this.i) {
            return;
        }
        this.i = true;
        try {
            trainingListenEffect.setVolume(0.0f);
            long jRelease = trainingListenEffect.release();
            if (jRelease < 0) {
                jRelease = 0;
            }
            this.h = (S7.a) this.b.invoke(Long.valueOf(jRelease), new A6.i(9, this, trainingListenEffect));
        } catch (Exception e) {
            this.e.invoke(e);
            a();
        }
    }

    public final void e(boolean z10) {
        if (kotlin.jvm.internal.k.b(this.f, "settings") && this.n != z10) {
            try {
                ((TrainingListenController$session$1) this.c).invoke(Boolean.valueOf(z10));
                this.n = z10;
            } catch (Exception e) {
                this.e.invoke(e);
            }
        }
    }

    public final void f() {
        this.o = false;
        this.m = false;
        this.l++;
        a();
        this.d.invoke(Boolean.FALSE);
    }
}
