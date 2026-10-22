package com.stepos.agentbus.platform.diagnostic;

import android.os.Bundle;
import android.util.Log;
import b0.o;
import c.i;
import c7.r;
import com.stepos.agentbus.platform.AgentBusService;
import d.e;
import j0.d;
import kotlin.Metadata;
import n7.m;
import s1.u;
import w7.e0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/agentbus/platform/diagnostic/DiagnosticActivity;", "Lc/i;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DiagnosticActivity extends i {
    @Override // c.i, h2.a, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object objN;
        super.onCreate(bundle);
        try {
            u uVar = AgentBusService.f2682m;
            m.H(this);
            objN = r.f1986a;
        } catch (Throwable th) {
            objN = e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            Log.e("AgentBusDiagnostic", "AgentBusService.start failed", thA);
        }
        e.a(this, new d(-523724676, true, new o(2, this)));
    }
}
