package com.google.android.material.appbar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.OverScroller;
import androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryChargingProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryNotLowProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$NetworkStateProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$StorageNotLowProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import g5.u;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2366c;

    /* renamed from: f, reason: collision with root package name */
    public Object f2367f;

    /* renamed from: g, reason: collision with root package name */
    public Object f2368g;

    /* renamed from: h, reason: collision with root package name */
    public Object f2369h;

    public /* synthetic */ h(int i) {
        this.f2366c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        OverScroller overScroller;
        switch (this.f2366c) {
            case 0:
                androidx.coordinatorlayout.widget.a aVar = (androidx.coordinatorlayout.widget.a) this.f2367f;
                AppBarLayout$BaseBehavior appBarLayout$BaseBehavior = (AppBarLayout$BaseBehavior) this.f2369h;
                View view = (View) this.f2368g;
                if (view == null || (overScroller = appBarLayout$BaseBehavior.f2309b) == null) {
                    return;
                }
                if (overScroller.computeScrollOffset()) {
                    appBarLayout$BaseBehavior.k(aVar, view, appBarLayout$BaseBehavior.f2309b.getCurrY());
                    view.postOnAnimation(this);
                    return;
                }
                g gVar = (g) view;
                appBarLayout$BaseBehavior.l(aVar, gVar);
                if (gVar.f2355p) {
                    gVar.i(gVar.j(AppBarLayout$BaseBehavior.e(aVar)));
                    return;
                }
                return;
            case 1:
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.f2369h;
                Context context = (Context) this.f2368g;
                Intent intent = (Intent) this.f2367f;
                try {
                    boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                    boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                    u.d().a(ConstraintProxyUpdateReceiver.f1669a, "Updating proxies: (BatteryNotLowProxy (" + booleanExtra + "), BatteryChargingProxy (" + booleanExtra2 + "), StorageNotLowProxy (" + booleanExtra3 + "), NetworkStateProxy (" + booleanExtra4 + "), ");
                    q5.e.a(context, ConstraintProxy$BatteryNotLowProxy.class, booleanExtra);
                    q5.e.a(context, ConstraintProxy$BatteryChargingProxy.class, booleanExtra2);
                    q5.e.a(context, ConstraintProxy$StorageNotLowProxy.class, booleanExtra3);
                    q5.e.a(context, ConstraintProxy$NetworkStateProxy.class, booleanExtra4);
                    return;
                } finally {
                    pendingResult.finish();
                }
            default:
                try {
                    objCall = ((k3.d) this.f2367f).call();
                } catch (Exception unused) {
                    objCall = null;
                }
                k3.e eVar = (k3.e) this.f2368g;
                Handler handler = (Handler) this.f2369h;
                com.stepos.statsrpk.service.d dVar = new com.stepos.statsrpk.service.d(6);
                dVar.f2885f = eVar;
                dVar.f2886g = objCall;
                VarHandle.storeStoreFence();
                handler.post(dVar);
                return;
        }
    }
}
