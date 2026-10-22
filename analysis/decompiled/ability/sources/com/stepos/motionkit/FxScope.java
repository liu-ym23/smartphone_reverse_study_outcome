package com.stepos.motionkit;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlinx.coroutines.c;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1725r;
import m9.InterfaceC1733z;
import m9.r0;
import s9.k;
import u9.d;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/motionkit/FxScope;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "cancel", "Lm9/r;", "job", "Lm9/r;", "Lm9/z;", "scope", "Lm9/z;", "getScope", "()Lm9/z;", "", "isActive", "()Z", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FxScope {
    private final InterfaceC1725r job;
    private final InterfaceC1733z scope;

    public FxScope() {
        r0 r0VarC = AbstractC1683A.c();
        this.job = r0VarC;
        d dVar = AbstractC1691I.f5315a;
        this.scope = AbstractC1683A.b(k.f6003a.plus(r0VarC));
    }

    public final void cancel() {
        ((c) this.job).cancel(null);
    }

    public final InterfaceC1733z getScope() {
        return this.scope;
    }

    public final boolean isActive() {
        return ((c) this.job).isActive();
    }
}
