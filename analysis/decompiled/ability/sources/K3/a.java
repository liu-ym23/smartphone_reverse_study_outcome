package K3;

import C7.r;
import D7.w;
import T3.b;
import T3.c;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.ability.api.application.IApp;
import com.stepos.ability.api.init.IInit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a implements IApp {

    /* renamed from: a, reason: collision with root package name */
    public final Context f906a;
    public final c b;
    public Set c;

    public a(Context context, c deviceIdManager) {
        k.f(context, "context");
        k.f(deviceIdManager, "deviceIdManager");
        this.f906a = context;
        this.b = deviceIdManager;
    }

    @Override // com.stepos.ability.api.application.IApp
    public final void init() {
        Object objA;
        Object objA2;
        Set set = this.c;
        if (set == null) {
            k.n("set");
            throw null;
        }
        int size = set.size();
        Set set2 = this.c;
        if (set2 == null) {
            k.n("set");
            throw null;
        }
        Set set3 = set2;
        ArrayList arrayList = new ArrayList(w.c0(set3, 10));
        Iterator it = set3.iterator();
        while (it.hasNext()) {
            arrayList.add(((IInit) it.next()).getClass().getName());
        }
        P3.c.b("APP", "IInit set size=" + size + ", members=" + arrayList);
        Set<IInit> set4 = this.c;
        if (set4 == null) {
            k.n("set");
            throw null;
        }
        for (IInit iInit : set4) {
            P3.c.b("APP", "find init " + iInit.getClass());
            iInit.init(this.f906a);
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - Process.getStartUptimeMillis();
        long j5 = 6000 - jUptimeMillis;
        if (j5 <= 0) {
            String msg = "startupBudget exhausted: elapsed=" + jUptimeMillis + "ms deadline=6000ms, skip waiting for oaid";
            k.f(msg, "msg");
            P3.c.f1086a.invoke(5, "Ability_".concat("APP"), msg, null);
            return;
        }
        P3.c.b("APP", "startupBudget: elapsed=" + jUptimeMillis + "ms budget=" + j5 + "ms");
        b bVar = (b) this.b;
        if (!bVar.h && j5 > 0) {
            boolean zB = k.b(Looper.myLooper(), Looper.getMainLooper());
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                objA = Boolean.valueOf(bVar.e.await(j5, TimeUnit.MILLISECONDS));
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Object obj = Boolean.FALSE;
            if (objA instanceof Result.Failure) {
                objA = obj;
            }
            boolean zBooleanValue = ((Boolean) objA).booleanValue();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            StringBuilder sb = new StringBuilder("awaitDeviceId: got=");
            sb.append(zBooleanValue);
            sb.append(" waited=");
            sb.append(jCurrentTimeMillis2);
            androidx.compose.foundation.b.y(j5, "ms budget=", "ms onMain=", sb);
            sb.append(zB);
            Log.i("DeviceIdManager", sb.toString());
            if (!zBooleanValue && !bVar.h) {
                bVar.f1206j = 0;
                if (bVar.i.compareAndSet(false, true)) {
                    Log.i("DeviceIdManager", "kickRetryNow: someone is waiting, retry immediately");
                    try {
                        bVar.b.execute(new T3.a(bVar, 3));
                        objA2 = r.f317a;
                    } catch (Throwable th2) {
                        objA2 = kotlin.b.a(th2);
                    }
                    Throwable thA = Result.a(objA2);
                    if (thA != null) {
                        bVar.i.set(false);
                        Log.w("DeviceIdManager", "kickRetryNow failed", thA);
                    }
                }
            }
        }
        bVar.a();
        P3.c.b("APP", "startupBudget done: elapsed=" + (SystemClock.uptimeMillis() - Process.getStartUptimeMillis()) + "ms realOaid=" + ((b) this.b).h);
    }
}
