package A0;

import B0.g;
import B0.k;
import B0.r;
import C0.p;
import Z2.o0;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.foreground.SystemForegroundService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import s.AbstractC0831a;
import s0.C0852j;
import s0.t;
import t0.C0913H;
import t0.InterfaceC0918d;
import t0.x;

/* loaded from: classes.dex */
public final class c implements x0.e, InterfaceC0918d {

    /* renamed from: j, reason: collision with root package name */
    public static final String f28j = t.f("SystemFgDispatcher");

    /* renamed from: a, reason: collision with root package name */
    public final C0913H f29a;

    /* renamed from: b, reason: collision with root package name */
    public final E0.a f30b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f31c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public k f32d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f33e;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f34f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f35g;

    /* renamed from: h, reason: collision with root package name */
    public final stepos.support.v7.app.palette.b f36h;

    /* renamed from: i, reason: collision with root package name */
    public b f37i;

    public c(Context context) {
        C0913H c0913hE0 = C0913H.e0(context);
        this.f29a = c0913hE0;
        this.f30b = c0913hE0.f15328e;
        this.f32d = null;
        this.f33e = new LinkedHashMap();
        this.f35g = new HashMap();
        this.f34f = new HashMap();
        this.f36h = new stepos.support.v7.app.palette.b(c0913hE0.f15334k);
        c0913hE0.f15330g.a(this);
    }

    public static Intent a(Context context, k kVar, C0852j c0852j) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", c0852j.f14204a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", c0852j.f14205b);
        intent.putExtra("KEY_NOTIFICATION", c0852j.f14206c);
        intent.putExtra("KEY_WORKSPEC_ID", kVar.f150a);
        intent.putExtra("KEY_GENERATION", kVar.f151b);
        return intent;
    }

    public static Intent d(Context context, k kVar, C0852j c0852j) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", kVar.f150a);
        intent.putExtra("KEY_GENERATION", kVar.f151b);
        intent.putExtra("KEY_NOTIFICATION_ID", c0852j.f14204a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", c0852j.f14205b);
        intent.putExtra("KEY_NOTIFICATION", c0852j.f14206c);
        return intent;
    }

    @Override // x0.e
    public final void b(r rVar, x0.c cVar) {
        if (cVar instanceof x0.b) {
            String str = rVar.f167a;
            t.d().a(f28j, g.m("Constraints unmet for WorkSpec ", str));
            k kVarV = B0.f.v(rVar);
            C0913H c0913h = this.f29a;
            c0913h.getClass();
            x token = new x(kVarV);
            t0.r processor = c0913h.f15330g;
            Intrinsics.checkNotNullParameter(processor, "processor");
            Intrinsics.checkNotNullParameter(token, "token");
            c0913h.f15328e.a(new p(processor, token, true, -512));
        }
    }

    @Override // t0.InterfaceC0918d
    public final void c(k kVar, boolean z4) {
        Map.Entry entry;
        synchronized (this.f31c) {
            try {
                o0 o0Var = ((r) this.f34f.remove(kVar)) != null ? (o0) this.f35g.remove(kVar) : null;
                if (o0Var != null) {
                    o0Var.b(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C0852j c0852j = (C0852j) this.f33e.remove(kVar);
        int i4 = 0;
        if (kVar.equals(this.f32d)) {
            if (this.f33e.size() > 0) {
                Iterator it = this.f33e.entrySet().iterator();
                Object next = it.next();
                while (true) {
                    entry = (Map.Entry) next;
                    if (!it.hasNext()) {
                        break;
                    } else {
                        next = it.next();
                    }
                }
                this.f32d = (k) entry.getKey();
                if (this.f37i != null) {
                    C0852j c0852j2 = (C0852j) entry.getValue();
                    SystemForegroundService systemForegroundService = (SystemForegroundService) this.f37i;
                    systemForegroundService.f4341b.post(new d(systemForegroundService, c0852j2.f14204a, c0852j2.f14206c, c0852j2.f14205b));
                    SystemForegroundService systemForegroundService2 = (SystemForegroundService) this.f37i;
                    systemForegroundService2.f4341b.post(new e(c0852j2.f14204a, i4, systemForegroundService2));
                }
            } else {
                this.f32d = null;
            }
        }
        b bVar = this.f37i;
        if (c0852j == null || bVar == null) {
            return;
        }
        t.d().a(f28j, "Removing Notification (id: " + c0852j.f14204a + ", workSpecId: " + kVar + ", notificationType: " + c0852j.f14205b);
        SystemForegroundService systemForegroundService3 = (SystemForegroundService) bVar;
        systemForegroundService3.f4341b.post(new e(c0852j.f14204a, i4, systemForegroundService3));
    }

    public final void e(Intent intent) {
        int i4 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        k kVar = new k(stringExtra, intent.getIntExtra("KEY_GENERATION", 0));
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        t tVarD = t.d();
        StringBuilder sb = new StringBuilder("Notifying with (id:");
        sb.append(intExtra);
        sb.append(", workSpecId: ");
        sb.append(stringExtra);
        sb.append(", notificationType :");
        tVarD.a(f28j, AbstractC0831a.d(sb, intExtra2, ")"));
        if (notification == null || this.f37i == null) {
            return;
        }
        C0852j c0852j = new C0852j(intExtra, intExtra2, notification);
        LinkedHashMap linkedHashMap = this.f33e;
        linkedHashMap.put(kVar, c0852j);
        if (this.f32d == null) {
            this.f32d = kVar;
            SystemForegroundService systemForegroundService = (SystemForegroundService) this.f37i;
            systemForegroundService.f4341b.post(new d(systemForegroundService, intExtra, notification, intExtra2));
            return;
        }
        SystemForegroundService systemForegroundService2 = (SystemForegroundService) this.f37i;
        systemForegroundService2.f4341b.post(new android.support.v4.os.a(systemForegroundService2, intExtra, notification, 7));
        if (intExtra2 != 0) {
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                i4 |= ((C0852j) ((Map.Entry) it.next()).getValue()).f14205b;
            }
            C0852j c0852j2 = (C0852j) linkedHashMap.get(this.f32d);
            if (c0852j2 != null) {
                SystemForegroundService systemForegroundService3 = (SystemForegroundService) this.f37i;
                systemForegroundService3.f4341b.post(new d(systemForegroundService3, c0852j2.f14204a, c0852j2.f14206c, i4));
            }
        }
    }

    public final void f() {
        this.f37i = null;
        synchronized (this.f31c) {
            try {
                Iterator it = this.f35g.values().iterator();
                while (it.hasNext()) {
                    ((o0) it.next()).b(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f29a.f15330g.f(this);
    }
}
