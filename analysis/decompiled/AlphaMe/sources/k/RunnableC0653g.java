package k;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.text.TextUtils;
import android.view.MenuItem;
import androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryChargingProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryNotLowProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$NetworkStateProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$StorageNotLowProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsrpk.RpkEvent;
import com.stepos.statsrpk.RpkInfo;
import com.stepos.statsrpk.RpkUsageStats;
import d.C0527a;
import java.util.Map;
import java.util.UUID;
import s0.C0850h;
import t0.J;

/* renamed from: k.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0653g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13188a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13189b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f13190c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f13191d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f13192e;

    public /* synthetic */ RunnableC0653g(int i4, Object obj, Object obj2, Object obj3, Object obj4) {
        this.f13188a = i4;
        this.f13192e = obj;
        this.f13189b = obj2;
        this.f13190c = obj3;
        this.f13191d = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        B0.r rVarI;
        long jInsertWithOnConflict;
        long jQueryNumEntries;
        int i4 = 0;
        switch (this.f13188a) {
            case 0:
                C0654h c0654h = (C0654h) this.f13189b;
                if (c0654h != null) {
                    C0527a c0527a = (C0527a) this.f13192e;
                    ((ViewOnKeyListenerC0655i) c0527a.f12410b).f13196A = true;
                    c0654h.f13194b.c(false);
                    ((ViewOnKeyListenerC0655i) c0527a.f12410b).f13196A = false;
                }
                MenuItem menuItem = (MenuItem) this.f13190c;
                if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                    ((C0661o) this.f13191d).q(menuItem, null, 4);
                    return;
                }
                return;
            case 1:
                Object obj = this.f13191d;
                Object obj2 = this.f13190c;
                Object obj3 = this.f13189b;
                try {
                    boolean booleanExtra = ((Intent) obj3).getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra2 = ((Intent) obj3).getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                    boolean booleanExtra3 = ((Intent) obj3).getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra4 = ((Intent) obj3).getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                    s0.t.d().a(ConstraintProxyUpdateReceiver.f4329a, "Updating proxies: (BatteryNotLowProxy (" + booleanExtra + "), BatteryChargingProxy (" + booleanExtra2 + "), StorageNotLowProxy (" + booleanExtra3 + "), NetworkStateProxy (" + booleanExtra4 + "), ");
                    C0.m.a((Context) obj2, ConstraintProxy$BatteryNotLowProxy.class, booleanExtra);
                    C0.m.a((Context) obj2, ConstraintProxy$BatteryChargingProxy.class, booleanExtra2);
                    C0.m.a((Context) obj2, ConstraintProxy$StorageNotLowProxy.class, booleanExtra3);
                    C0.m.a((Context) obj2, ConstraintProxy$NetworkStateProxy.class, booleanExtra4);
                    return;
                } finally {
                    ((BroadcastReceiver.PendingResult) obj).finish();
                }
            case 2:
                Object obj4 = this.f13191d;
                UUID uuid = (UUID) this.f13189b;
                String string = uuid.toString();
                s0.t tVarD = s0.t.d();
                String str = C0.v.f325c;
                StringBuilder sb = new StringBuilder("Updating progress for ");
                sb.append(uuid);
                sb.append(" (");
                Object obj5 = this.f13190c;
                sb.append((C0850h) obj5);
                sb.append(")");
                tVarD.a(str, sb.toString());
                Object obj6 = this.f13192e;
                ((C0.v) obj6).f326a.beginTransaction();
                try {
                    rVarI = ((C0.v) obj6).f326a.g().i(string);
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                if (rVarI == null) {
                    throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                }
                if (rVarI.f168b == s0.G.f14154b) {
                    B0.n nVar = new B0.n(string, (C0850h) obj5);
                    B0.p pVarF = ((C0.v) obj6).f326a.f();
                    androidx.room.A a4 = pVarF.f160a;
                    a4.assertNotSuspendingTransaction();
                    a4.beginTransaction();
                    try {
                        pVarF.f161b.insert(nVar);
                        a4.setTransactionSuccessful();
                        a4.endTransaction();
                    } catch (Throwable th) {
                        a4.endTransaction();
                        throw th;
                    }
                } else {
                    s0.t.d().g(str, "Ignoring setProgressAsync(...). WorkSpec (" + string + ") is not in a RUNNING state.");
                }
                ((D0.j) obj4).j(null);
                ((C0.v) obj6).f326a.setTransactionSuccessful();
                return;
            case 3:
                RpkUsageStats rpkUsageStats = (RpkUsageStats) this.f13192e;
                if (rpkUsageStats.mRpkInstance != null) {
                    com.stepos.statsrpk.d dVar = rpkUsageStats.mRpkInstance;
                    String str2 = (String) this.f13189b;
                    String str3 = (String) this.f13190c;
                    Map map = (Map) this.f13191d;
                    dVar.getClass();
                    T2.d.a("RpkInstanceImpl", "onEvent eventName: " + str2 + ", pageName: " + str3 + ", properties: " + map);
                    t.d dVar2 = dVar.f12365a;
                    if (dVar2 == null || TextUtils.isEmpty(str2) || !((S2.a) dVar2.f15275c).f1791a.getBoolean("active", true) || dVar2.a(str2) == 0) {
                        return;
                    }
                    RpkEvent rpkEvent = new RpkEvent();
                    rpkEvent.f12344a = "action_x";
                    rpkEvent.f12345b = str2;
                    rpkEvent.f12346c = str3;
                    rpkEvent.f12347d = map;
                    rpkEvent.f12348e = ((com.stepos.statsrpk.d) dVar2.f15276d).f12366b.a();
                    ((android.support.v4.media.session.c) dVar2.f15273a).b(rpkEvent, (RpkInfo) dVar2.f15274b);
                    return;
                }
                return;
            default:
                com.stepos.statsrpk.service.d dVar3 = (com.stepos.statsrpk.service.d) this.f13192e;
                String str4 = (String) this.f13189b;
                String str5 = (String) this.f13190c;
                TrackerPayload trackerPayload = (TrackerPayload) this.f13191d;
                dVar3.getClass();
                if (str4 == null || trackerPayload == null) {
                    return;
                }
                T2.d.a("a", "Queuing event for sending later, appKey:" + str4 + ", payload:" + trackerPayload);
                dVar3.f12381c.c();
                V2.a aVar = dVar3.f12381c;
                synchronized (aVar) {
                    try {
                        if (aVar.e()) {
                            try {
                                if (!J.x(aVar.f1934b)) {
                                    i4 = 2;
                                }
                                G2.c cVarA = G2.c.a(i4, trackerPayload);
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("appKey", str4);
                                contentValues.put("rpkPkgName", str5);
                                contentValues.put("eventSessionId", cVarA.f645c);
                                contentValues.put("encrypt", Integer.valueOf(cVarA.f644b));
                                contentValues.put("eventData", cVarA.f647e);
                                jInsertWithOnConflict = aVar.f1933a.insertWithOnConflict("events", null, contentValues, 5);
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        } else {
                            jInsertWithOnConflict = -1;
                        }
                        T2.d.a("a", "succ add event, inserted:" + jInsertWithOnConflict);
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                if (jInsertWithOnConflict > 0) {
                    V2.a aVar2 = dVar3.f12381c;
                    synchronized (aVar2) {
                        String str6 = "appKey='" + str4 + "'";
                        synchronized (aVar2) {
                            jQueryNumEntries = DatabaseUtils.queryNumEntries(aVar2.f1933a, "events", str6);
                        }
                        boolean zV = com.airbnb.lottie.h.v((Context) dVar3.f825b);
                        T2.d.a("a", "cacheCheck appKey:" + str4 + " ------------------ eventSize:" + jQueryNumEntries + ", flushCacheLimit:5, networkAvailable:" + zV);
                        if (jQueryNumEntries >= 5 || !zV) {
                            return;
                        }
                        dVar3.i(str4, dVar3.f12381c.a(str4));
                        return;
                    }
                    boolean zV2 = com.airbnb.lottie.h.v((Context) dVar3.f825b);
                    T2.d.a("a", "cacheCheck appKey:" + str4 + " ------------------ eventSize:" + jQueryNumEntries + ", flushCacheLimit:5, networkAvailable:" + zV2);
                    if (jQueryNumEntries >= 5) {
                        return;
                    } else {
                        return;
                    }
                }
                return;
        }
    }
}
