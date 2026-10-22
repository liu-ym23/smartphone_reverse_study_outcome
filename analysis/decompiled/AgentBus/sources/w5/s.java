package w5;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import b0.f1;
import com.stepos.agentbus.platform.AgentBusService;

/* loaded from: classes.dex */
public final class s implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f1 f10752a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f1 f10753b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f1 f10754c;

    public s(f1 f1Var, f1 f1Var2, f1 f1Var3) {
        this.f10752a = f1Var;
        this.f10753b = f1Var2;
        this.f10754c = f1Var3;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        q7.k.e(componentName, "name");
        q7.k.e(iBinder, "binder");
        AgentBusService agentBusService = ((u5.d) iBinder).f10111c;
        this.f10752a.setValue(agentBusService);
        this.f10753b.setValue(agentBusService.f2685h);
        Boolean bool = (Boolean) agentBusService.f2687j.getValue();
        bool.getClass();
        this.f10754c.setValue(bool);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        q7.k.e(componentName, "name");
        this.f10753b.setValue(null);
        this.f10752a.setValue(null);
        this.f10754c.setValue(Boolean.FALSE);
    }
}
