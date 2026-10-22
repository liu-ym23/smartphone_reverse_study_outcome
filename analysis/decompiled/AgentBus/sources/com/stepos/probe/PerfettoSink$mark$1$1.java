package com.stepos.probe;

import c7.r;
import g7.d;
import i7.e;
import i7.i;
import ia.b0;
import ia.d0;
import kotlin.Metadata;
import m.x;
import p7.n;
import w7.e0;

@e(c = "com.stepos.probe.PerfettoSink$mark$1$1", f = "PerfettoSink.kt", l = {76}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lia/b0;", "Lc7/r;", "<anonymous>", "(Lia/b0;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes.dex */
public final class PerfettoSink$mark$1$1 extends i implements n {
    final /* synthetic */ String $name;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PerfettoSink$mark$1$1(String str, d dVar) {
        super(2, dVar);
        this.$name = str;
    }

    @Override // i7.a
    public final d create(Object obj, d dVar) {
        return new PerfettoSink$mark$1$1(this.$name, dVar);
    }

    @Override // p7.n
    public final Object invoke(b0 b0Var, d dVar) {
        return ((PerfettoSink$mark$1$1) create(b0Var, dVar)).invokeSuspend(r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        h7.a aVar = h7.a.f4212f;
        int i2 = this.label;
        if (i2 == 0) {
            e0.N(obj);
            this.label = 1;
            if (d0.g(150L, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e0.N(obj);
        }
        PerfettoSink perfettoSink = PerfettoSink.INSTANCE;
        try {
            PerfettoSink.INSTANCE.nativeCounter(this.$name, 0);
        } catch (Exception e10) {
            x.v("native call failed: ", e10.getMessage(), "clawbench_perfetto");
        } catch (UnsatisfiedLinkError unused) {
        }
        return r.f1986a;
    }
}
