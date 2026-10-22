package p2;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.a;
import androidx.work.impl.foreground.SystemForegroundService;
import h0.e;
import h2.f;
import h2.j;
import i2.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.coroutines.Job;
import m2.c;
import mb.y;
import q2.k;
import q2.p;
import r2.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements c, b {

    /* renamed from: m, reason: collision with root package name */
    public static final String f11394m = j.f("SystemFgDispatcher");

    /* renamed from: a, reason: collision with root package name */
    public final androidx.work.impl.b f11395a;

    /* renamed from: b, reason: collision with root package name */
    public final s2.b f11396b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f11397c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public k f11398d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f11399e;
    public final HashMap h;

    /* renamed from: j, reason: collision with root package name */
    public final HashMap f11400j;

    /* renamed from: k, reason: collision with root package name */
    public final WorkConstraintsTracker f11401k;

    /* renamed from: l, reason: collision with root package name */
    public SystemForegroundService f11402l;

    public a(Context context) {
        androidx.work.impl.b bVarA = androidx.work.impl.b.a(context);
        this.f11395a = bVarA;
        this.f11396b = bVarA.f2880d;
        this.f11398d = null;
        this.f11399e = new LinkedHashMap();
        this.f11400j = new HashMap();
        this.h = new HashMap();
        this.f11401k = new WorkConstraintsTracker(bVarA.f2885j);
        bVarA.f2882f.a(this);
    }

    public static Intent c(Context context, k kVar, f fVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", kVar.f11498a);
        intent.putExtra("KEY_GENERATION", kVar.f11499b);
        intent.putExtra("KEY_NOTIFICATION_ID", fVar.f9268a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", fVar.f9269b);
        intent.putExtra("KEY_NOTIFICATION", fVar.f9270c);
        return intent;
    }

    @Override // i2.b
    public final void a(k kVar, boolean z) {
        Map.Entry entry;
        synchronized (this.f11397c) {
            try {
                Job job = ((p) this.h.remove(kVar)) != null ? (Job) this.f11400j.remove(kVar) : null;
                if (job != null) {
                    job.cancel(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f fVar = (f) this.f11399e.remove(kVar);
        if (kVar.equals(this.f11398d)) {
            if (this.f11399e.size() > 0) {
                Iterator it = this.f11399e.entrySet().iterator();
                Object next = it.next();
                while (true) {
                    entry = (Map.Entry) next;
                    if (!it.hasNext()) {
                        break;
                    } else {
                        next = it.next();
                    }
                }
                this.f11398d = (k) entry.getKey();
                if (this.f11402l != null) {
                    f fVar2 = (f) entry.getValue();
                    this.f11402l.b(fVar2.f9268a, fVar2.f9269b, fVar2.f9270c);
                    this.f11402l.f2969d.cancel(fVar2.f9268a);
                }
            } else {
                this.f11398d = null;
            }
        }
        SystemForegroundService systemForegroundService = this.f11402l;
        if (fVar == null || systemForegroundService == null) {
            return;
        }
        j.d().a(f11394m, "Removing Notification (id: " + fVar.f9268a + ", workSpecId: " + kVar + ", notificationType: " + fVar.f9269b);
        systemForegroundService.f2969d.cancel(fVar.f9268a);
    }

    @Override // m2.c
    public final void b(p pVar, androidx.work.impl.constraints.a aVar) {
        if (aVar instanceof a.b) {
            String str = pVar.f11505a;
            j.d().a(f11394m, "Constraints unmet for WorkSpec " + str);
            k kVarT = y.t(pVar);
            int i10 = ((a.b) aVar).f2929a;
            androidx.work.impl.b bVar = this.f11395a;
            bVar.f2880d.d(new l(bVar.f2882f, new i2.k(kVarT), true, i10));
        }
    }

    public final void d(Intent intent) {
        if (this.f11402l == null) {
            throw new IllegalStateException("handleNotify was called on the destroyed dispatcher");
        }
        int i10 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        k kVar = new k(stringExtra, intent.getIntExtra("KEY_GENERATION", 0));
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        j jVarD = j.d();
        StringBuilder sbE = e.e("Notifying with (id:", intExtra, ", workSpecId: ", stringExtra, ", notificationType :");
        sbE.append(intExtra2);
        sbE.append(")");
        jVarD.a(f11394m, sbE.toString());
        if (notification == null) {
            throw new IllegalArgumentException("Notification passed in the intent was null.");
        }
        f fVar = new f(intExtra, intExtra2, notification);
        LinkedHashMap linkedHashMap = this.f11399e;
        linkedHashMap.put(kVar, fVar);
        f fVar2 = (f) linkedHashMap.get(this.f11398d);
        if (fVar2 == null) {
            this.f11398d = kVar;
        } else {
            this.f11402l.f2969d.notify(intExtra, notification);
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                i10 |= ((f) ((Map.Entry) it.next()).getValue()).f9269b;
            }
            fVar = new f(fVar2.f9268a, i10, fVar2.f9270c);
        }
        this.f11402l.b(fVar.f9268a, fVar.f9269b, fVar.f9270c);
    }

    public final void e() {
        this.f11402l = null;
        synchronized (this.f11397c) {
            try {
                Iterator it = this.f11400j.values().iterator();
                while (it.hasNext()) {
                    ((Job) it.next()).cancel(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f11395a.f2882f.f(this);
    }

    public final void f(int i10) {
        j.d().e(f11394m, "Foreground service timed out, FGS type: " + i10);
        for (Map.Entry entry : this.f11399e.entrySet()) {
            if (((f) entry.getValue()).f9269b == i10) {
                k kVar = (k) entry.getKey();
                androidx.work.impl.b bVar = this.f11395a;
                bVar.f2880d.d(new l(bVar.f2882f, new i2.k(kVar), true, -128));
            }
        }
        SystemForegroundService systemForegroundService = this.f11402l;
        if (systemForegroundService != null) {
            systemForegroundService.f2967b = true;
            j.d().a(SystemForegroundService.f2966e, "Shutting down.");
            systemForegroundService.stopForeground(true);
            systemForegroundService.stopSelf();
        }
    }
}
