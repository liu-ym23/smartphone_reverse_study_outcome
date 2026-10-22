package u5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.stepos.agentbus.platform.AgentBusApp;

/* loaded from: classes.dex */
public final class c extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10109a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10110b;

    public /* synthetic */ c(int i2, Object obj) {
        this.f10109a = i2;
        this.f10110b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int i2 = this.f10109a;
        Object obj = this.f10110b;
        switch (i2) {
            case 0:
                q7.k.e(context, "context");
                q7.k.e(intent, "intent");
                Log.i("AgentBusApp", "ACTION_USER_UNLOCKED received — running deferred init");
                AgentBusApp agentBusApp = (AgentBusApp) obj;
                agentBusApp.unregisterReceiver(this);
                int i10 = AgentBusApp.f2679h;
                agentBusApp.b();
                break;
            default:
                i5.f fVar = (i5.f) obj;
                String action = intent != null ? intent.getAction() : null;
                if (action != null) {
                    int iHashCode = action.hashCode();
                    if (iHashCode == -2128145023) {
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            i5.f.u(fVar, "screen off", (p7.a) fVar.f4653g);
                            break;
                        }
                    } else if (iHashCode == -1454123155 && action.equals("android.intent.action.SCREEN_ON")) {
                        i5.f.u(fVar, "screen on", (p7.a) fVar.f4654h);
                        break;
                    }
                }
                break;
        }
    }
}
