package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import kotlin.jvm.internal.Intrinsics;
import z0.AbstractC0994b;
import z0.AbstractC0995c;
import z0.AbstractC0996d;
import z0.AbstractC1003k;
import z0.C0993a;

/* loaded from: classes.dex */
public final class A extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2456a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2457b;

    public /* synthetic */ A(int i4, Object obj) {
        this.f2456a = i4;
        this.f2457b = obj;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) throws PackageManager.NameNotFoundException {
        int i4 = this.f2456a;
        Object obj = this.f2457b;
        switch (i4) {
            case 0:
                z zVar = (z) ((B) obj);
                int i5 = zVar.f2688c;
                F f4 = zVar.f2689d;
                switch (i5) {
                    case 0:
                        f4.b(true);
                        break;
                    default:
                        f4.b(true);
                        break;
                }
            case 1:
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                C0993a c0993a = (C0993a) ((AbstractC0996d) obj);
                switch (c0993a.f16392g) {
                    case 0:
                        Intrinsics.checkNotNullParameter(intent, "intent");
                        String action = intent.getAction();
                        if (action != null) {
                            s0.t.d().a(AbstractC0994b.f16393a, "Received ".concat(action));
                            switch (action.hashCode()) {
                                case -1886648615:
                                    if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                                        c0993a.b(Boolean.FALSE);
                                        break;
                                    }
                                    break;
                                case -54942926:
                                    if (action.equals("android.os.action.DISCHARGING")) {
                                        c0993a.b(Boolean.FALSE);
                                        break;
                                    }
                                    break;
                                case 948344062:
                                    if (action.equals("android.os.action.CHARGING")) {
                                        c0993a.b(Boolean.TRUE);
                                        break;
                                    }
                                    break;
                                case 1019184907:
                                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                                        c0993a.b(Boolean.TRUE);
                                        break;
                                    }
                                    break;
                            }
                        }
                        break;
                    case 1:
                        Intrinsics.checkNotNullParameter(intent, "intent");
                        if (intent.getAction() != null) {
                            s0.t.d().a(AbstractC0995c.f16394a, "Received " + intent.getAction());
                            String action2 = intent.getAction();
                            if (action2 != null) {
                                int iHashCode = action2.hashCode();
                                if (iHashCode == -1980154005) {
                                    if (action2.equals("android.intent.action.BATTERY_OKAY")) {
                                        c0993a.b(Boolean.TRUE);
                                        break;
                                    }
                                } else if (iHashCode == 490310653 && action2.equals("android.intent.action.BATTERY_LOW")) {
                                    c0993a.b(Boolean.FALSE);
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        Intrinsics.checkNotNullParameter(intent, "intent");
                        if (intent.getAction() != null) {
                            s0.t.d().a(AbstractC1003k.f16407a, "Received " + intent.getAction());
                            String action3 = intent.getAction();
                            if (action3 != null) {
                                int iHashCode2 = action3.hashCode();
                                if (iHashCode2 == -1181163412) {
                                    if (action3.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                                        c0993a.b(Boolean.FALSE);
                                        break;
                                    }
                                } else if (iHashCode2 == -730838620 && action3.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                                    c0993a.b(Boolean.TRUE);
                                    break;
                                }
                            }
                        }
                        break;
                }
            default:
                if (!"android.intent.action.ACTION_POWER_CONNECTED".equals(intent.getAction())) {
                    if (!"android.intent.action.ACTION_POWER_DISCONNECTED".equals(intent.getAction())) {
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            boolean zV = com.airbnb.lottie.h.v(context);
                            T2.d.a("EnvironmentReceiver", "CONNECTIVITY_ACTION, isOnline = " + zV);
                            if (!zV) {
                                ((K2.c) obj).f1046a.a();
                                break;
                            } else {
                                ((K2.c) obj).f1046a.c();
                                break;
                            }
                        }
                    } else {
                        T2.d.a("EnvironmentReceiver", "ACTION_POWER_DISCONNECTED, charging = false");
                        ((K2.c) obj).f1047b.a();
                        break;
                    }
                } else {
                    T2.d.a("EnvironmentReceiver", "ACTION_POWER_CONNECTED, charging = true");
                    ((K2.c) obj).f1047b.c();
                    break;
                }
                break;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A(K2.c cVar) {
        this(2, cVar);
        this.f2456a = 2;
    }
}
