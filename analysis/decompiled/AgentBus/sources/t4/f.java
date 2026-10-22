package t4;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import c7.l;
import c7.m;
import c7.r;
import com.stepos.zeroclaw.ipc.IZeroClawService;
import k5.s;
import k5.t;
import la.u0;
import q7.k;
import w7.e0;

/* loaded from: classes.dex */
public final class f implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f9736a;

    public f(g gVar) {
        this.f9736a = gVar;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        g gVar = this.f9736a;
        s.warn$default(gVar.f9739c, "ZeroClawConn", "ZeroClaw service binding died", null, 4, null);
        u0 u0Var = gVar.f9742f;
        u0Var.getClass();
        u0Var.g(null, c.f9733a);
        gVar.f9746j = false;
        gVar.b();
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName componentName) {
        g gVar = this.f9736a;
        s.warn$default(gVar.f9739c, "ZeroClawConn", "ZeroClaw service returned null binding", null, 4, null);
        u0 u0Var = gVar.f9742f;
        u0Var.getClass();
        u0Var.g(null, c.f9733a);
        gVar.f9746j = false;
        gVar.b();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object objN;
        Object objN2;
        g gVar = this.f9736a;
        gVar.f9745i = 0;
        IZeroClawService iZeroClawServiceAsInterface = IZeroClawService.Stub.asInterface(iBinder);
        try {
            iZeroClawServiceAsInterface.registerCallback(gVar.f9738b);
            objN = r.f1986a;
        } catch (Throwable th) {
            objN = e0.n(th);
        }
        Throwable thA = m.a(objN);
        if (thA != null) {
            s.warn$default(gVar.f9739c, "ZeroClawConn", a1.a.w("registerCallback failed: ", thA.getMessage()), null, 4, null);
        }
        u0 u0Var = gVar.f9742f;
        k.b(iZeroClawServiceAsInterface);
        a aVar = new a(iZeroClawServiceAsInterface);
        u0Var.getClass();
        u0Var.g(null, aVar);
        t tVar = gVar.f9739c;
        String str = gVar.f9740d;
        try {
            objN2 = Integer.valueOf(iZeroClawServiceAsInterface.getHealthState());
        } catch (Throwable th2) {
            objN2 = e0.n(th2);
        }
        if (objN2 instanceof l) {
            objN2 = -1;
        }
        s.info$default(tVar, "ZeroClawConn", "connected to ZeroClaw service package=" + str + " health=" + objN2, null, 4, null);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        g gVar = this.f9736a;
        s.warn$default(gVar.f9739c, "ZeroClawConn", "ZeroClaw service disconnected", null, 4, null);
        u0 u0Var = gVar.f9742f;
        u0Var.getClass();
        u0Var.g(null, c.f9733a);
        gVar.f9746j = false;
        gVar.b();
    }
}
