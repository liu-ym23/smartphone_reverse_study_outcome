package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.NetworkType;
import androidx.work.i;
import androidx.work.impl.model.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintProxy extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5436a = null;

    public static class BatteryChargingProxy extends ConstraintProxy {
        public BatteryChargingProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context r10, Intent r11) {
            super.onReceive(r10, r11);
        }
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
        public BatteryNotLowProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context r10, Intent r11) {
            super.onReceive(r10, r11);
        }
    }

    public static class NetworkStateProxy extends ConstraintProxy {
        public NetworkStateProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context r10, Intent r11) {
            super.onReceive(r10, r11);
        }
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
        public StorageNotLowProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context r10, Intent r11) {
            super.onReceive(r10, r11);
        }
    }

    static {
        f5436a = i.i("ConstraintProxy");
    }

    public ConstraintProxy() {
    }

    public static void a(Context r10, List r11) {
        Iterator r12 = r11.iterator();
        boolean r13 = false;
        boolean r14 = false;
        boolean r15 = false;
        boolean r16 = false;
    L4:
        if (r12.hasNext() == false) goto L14;
        androidx.work.a r17 = ((o) r12.next()).f5679j;
        r13 = r13 | r17.f();
        r14 = r14 | r17.g();
        r15 = r15 | r17.i();
        if (r17.d() == NetworkType.NOT_REQUIRED) goto L8;
        boolean r18 = true;
    L9:
        r16 = r16 | r18;
        if (r13 == false) goto L4;
        if (r14 == false) goto L4;
        if (r15 == false) goto L4;
        if (r16 == false) goto L4;
    L8:
        r18 = false;
    L14:
        r10.sendBroadcast(ConstraintProxyUpdateReceiver.a(r10, r13, r14, r15, r16));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        i.e().a(f5436a, "onReceive : " + r11);
        r10.startService(b.a(r10));
    }
}
