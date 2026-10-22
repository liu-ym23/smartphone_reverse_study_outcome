package o5;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.content.Intent;
import android.util.Log;
import androidx.work.impl.foreground.SystemForegroundService;
import g5.l;
import g5.u;
import h5.d;
import h5.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kc.x0;
import l5.c;
import l5.g;
import ne.b;
import od.f;
import p5.i;
import p5.j;
import p5.p;
import td.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements g, h5.a {

    /* renamed from: n, reason: collision with root package name */
    public static final String f9223n = u.f("SystemFgDispatcher");

    /* renamed from: c, reason: collision with root package name */
    public r f9224c;

    /* renamed from: f, reason: collision with root package name */
    public i f9225f;

    /* renamed from: g, reason: collision with root package name */
    public Object f9226g;

    /* renamed from: h, reason: collision with root package name */
    public j f9227h;
    public LinkedHashMap i;

    /* renamed from: j, reason: collision with root package name */
    public HashMap f9228j;

    /* renamed from: k, reason: collision with root package name */
    public HashMap f9229k;

    /* renamed from: l, reason: collision with root package name */
    public b f9230l;

    /* renamed from: m, reason: collision with root package name */
    public SystemForegroundService f9231m;

    @Override // l5.g
    public final void a(p pVar, c cVar) {
        if (cVar instanceof l5.b) {
            String str = pVar.f9764a;
            u.d().a(f9223n, "Constraints unmet for WorkSpec " + str);
            r rVar = this.f9224c;
            j jVarR = h.r(pVar);
            int i = ((l5.b) cVar).f7735a;
            i iVar = rVar.f5373d;
            d dVar = rVar.f5375f;
            h5.j jVar = new h5.j();
            jVar.f5348a = jVarR;
            iVar.q(new q5.g(dVar, jVar, true, i));
        }
    }

    public final void b(Intent intent) {
        LinkedHashMap linkedHashMap = this.i;
        if (this.f9231m == null) {
            f.e("handleNotify was called on the destroyed dispatcher");
            return;
        }
        int i = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        j jVar = new j(stringExtra, intent.getIntExtra("KEY_GENERATION", 0));
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        u.d().a(f9223n, "Notifying with (id:" + intExtra + ", workSpecId: " + stringExtra + ", notificationType :" + intExtra2 + ")");
        if (notification == null) {
            g5.f.s("Notification passed in the intent was null.");
            return;
        }
        l lVar = new l(intExtra, notification, intExtra2);
        linkedHashMap.put(jVar, lVar);
        l lVar2 = (l) linkedHashMap.get(this.f9227h);
        if (lVar2 == null) {
            this.f9227h = jVar;
        } else {
            this.f9231m.f1681h.notify(intExtra, notification);
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                i |= ((l) ((Map.Entry) it.next()).getValue()).f4328b;
            }
            lVar = new l(lVar2.f4327a, lVar2.f4329c, i);
        }
        SystemForegroundService systemForegroundService = this.f9231m;
        int i3 = lVar.f4327a;
        int i10 = lVar.f4328b;
        Notification notification2 = lVar.f4329c;
        systemForegroundService.getClass();
        String str = SystemForegroundService.i;
        try {
            systemForegroundService.startForeground(i3, notification2, i10);
        } catch (ForegroundServiceStartNotAllowedException e10) {
            if (u.d().f4344a <= 5) {
                Log.w(str, "Unable to start foreground service", e10);
            }
        } catch (SecurityException e11) {
            if (u.d().f4344a <= 5) {
                Log.w(str, "Unable to start foreground service", e11);
            }
        }
    }

    public final void c() {
        this.f9231m = null;
        synchronized (this.f9226g) {
            try {
                Iterator it = this.f9229k.values().iterator();
                while (it.hasNext()) {
                    ((x0) it.next()).e(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f9224c.f5375f.f(this);
    }

    public final void d(int i) {
        u.d().e(f9223n, "Foreground service timed out, FGS type: " + i);
        for (Map.Entry entry : this.i.entrySet()) {
            if (((l) entry.getValue()).f4328b == i) {
                j jVar = (j) entry.getKey();
                r rVar = this.f9224c;
                i iVar = rVar.f5373d;
                d dVar = rVar.f5375f;
                jVar.getClass();
                h5.j jVar2 = new h5.j();
                jVar2.f5348a = jVar;
                iVar.q(new q5.g(dVar, jVar2, true, -128));
            }
        }
        SystemForegroundService systemForegroundService = this.f9231m;
        if (systemForegroundService != null) {
            systemForegroundService.f1679f = true;
            u.d().a(SystemForegroundService.i, "Shutting down.");
            systemForegroundService.stopForeground(true);
            systemForegroundService.stopSelf();
        }
    }

    @Override // h5.a
    public final void e(j jVar, boolean z10) {
        Map.Entry entry;
        synchronized (this.f9226g) {
            try {
                x0 x0Var = ((p) this.f9228j.remove(jVar)) != null ? (x0) this.f9229k.remove(jVar) : null;
                if (x0Var != null) {
                    x0Var.e(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        l lVar = (l) this.i.remove(jVar);
        if (jVar.equals(this.f9227h)) {
            if (this.i.size() > 0) {
                Iterator it = this.i.entrySet().iterator();
                Object next = it.next();
                while (true) {
                    entry = (Map.Entry) next;
                    if (!it.hasNext()) {
                        break;
                    } else {
                        next = it.next();
                    }
                }
                this.f9227h = (j) entry.getKey();
                if (this.f9231m != null) {
                    l lVar2 = (l) entry.getValue();
                    SystemForegroundService systemForegroundService = this.f9231m;
                    int i = lVar2.f4327a;
                    int i3 = lVar2.f4328b;
                    Notification notification = lVar2.f4329c;
                    systemForegroundService.getClass();
                    String str = SystemForegroundService.i;
                    try {
                        systemForegroundService.startForeground(i, notification, i3);
                    } catch (ForegroundServiceStartNotAllowedException e10) {
                        if (u.d().f4344a <= 5) {
                            Log.w(str, "Unable to start foreground service", e10);
                        }
                    } catch (SecurityException e11) {
                        if (u.d().f4344a <= 5) {
                            Log.w(str, "Unable to start foreground service", e11);
                        }
                    }
                    this.f9231m.f1681h.cancel(lVar2.f4327a);
                }
            } else {
                this.f9227h = null;
            }
        }
        SystemForegroundService systemForegroundService2 = this.f9231m;
        if (lVar == null || systemForegroundService2 == null) {
            return;
        }
        u.d().a(f9223n, "Removing Notification (id: " + lVar.f4327a + ", workSpecId: " + jVar + ", notificationType: " + lVar.f4328b);
        systemForegroundService2.f1681h.cancel(lVar.f4327a);
    }
}
