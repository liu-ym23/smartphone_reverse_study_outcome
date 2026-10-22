package h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4746a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4747b;

    public /* synthetic */ a0(Object obj, int i) {
        this.f4746a = i;
        this.f4747b = obj;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int i = this.f4746a;
        Object obj = this.f4747b;
        switch (i) {
            case 0:
                ((b0) obj).j();
                break;
            case 1:
                la.a aVar = ((la.b) obj).f7820b;
                if (!"android.intent.action.ACTION_POWER_CONNECTED".equals(intent.getAction())) {
                    if (!"android.intent.action.ACTION_POWER_DISCONNECTED".equals(intent.getAction())) {
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            androidx.room.a0 a0Var = new androidx.room.a0(5);
                            a0Var.f1506f = this;
                            a0Var.f1507g = context;
                            VarHandle.storeStoreFence();
                            sa.c.f(a0Var);
                            break;
                        }
                    } else {
                        ua.c.a("EnvironmentReceiver", "ACTION_POWER_DISCONNECTED, charging = false");
                        aVar.a();
                        break;
                    }
                } else {
                    ua.c.a("EnvironmentReceiver", "ACTION_POWER_CONNECTED, charging = true");
                    aVar.c();
                    break;
                }
                break;
            default:
                context.getClass();
                intent.getClass();
                n5.a aVar2 = (n5.a) obj;
                switch (aVar2.f8761g) {
                    case 0:
                        String action = intent.getAction();
                        if (action != null) {
                            g5.u.d().a(n5.b.f8762a, "Received ".concat(action));
                            switch (action.hashCode()) {
                                case -1886648615:
                                    if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                                        aVar2.b(Boolean.FALSE);
                                        break;
                                    }
                                    break;
                                case -54942926:
                                    if (action.equals("android.os.action.DISCHARGING")) {
                                        aVar2.b(Boolean.FALSE);
                                        break;
                                    }
                                    break;
                                case 948344062:
                                    if (action.equals("android.os.action.CHARGING")) {
                                        aVar2.b(Boolean.TRUE);
                                        break;
                                    }
                                    break;
                                case 1019184907:
                                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                                        aVar2.b(Boolean.TRUE);
                                        break;
                                    }
                                    break;
                            }
                        }
                        break;
                    case 1:
                        if (intent.getAction() != null) {
                            g5.u.d().a(n5.c.f8763a, "Received " + intent.getAction());
                            String action2 = intent.getAction();
                            if (action2 != null) {
                                int iHashCode = action2.hashCode();
                                if (iHashCode == -1980154005) {
                                    if (action2.equals("android.intent.action.BATTERY_OKAY")) {
                                        aVar2.b(Boolean.TRUE);
                                        break;
                                    }
                                } else if (iHashCode == 490310653 && action2.equals("android.intent.action.BATTERY_LOW")) {
                                    aVar2.b(Boolean.FALSE);
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        if (intent.getAction() != null) {
                            g5.u.d().a(n5.i.f8774a, "Received " + intent.getAction());
                            String action3 = intent.getAction();
                            if (action3 != null) {
                                int iHashCode2 = action3.hashCode();
                                if (iHashCode2 == -1181163412) {
                                    if (action3.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                                        aVar2.b(Boolean.FALSE);
                                        break;
                                    }
                                } else if (iHashCode2 == -730838620 && action3.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                                    aVar2.b(Boolean.TRUE);
                                    break;
                                }
                            }
                        }
                        break;
                }
        }
    }
}
