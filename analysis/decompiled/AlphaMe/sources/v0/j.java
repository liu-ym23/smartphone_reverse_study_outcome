package v0;

import B0.k;
import C0.y;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.ArrayList;
import java.util.Iterator;
import s0.C0844b;
import s0.t;
import t0.C0911F;
import t0.C0913H;
import t0.InterfaceC0918d;
import t0.r;

/* loaded from: classes.dex */
public final class j implements InterfaceC0918d {

    /* renamed from: k, reason: collision with root package name */
    public static final String f15707k = t.f("SystemAlarmDispatcher");

    /* renamed from: a, reason: collision with root package name */
    public final Context f15708a;

    /* renamed from: b, reason: collision with root package name */
    public final E0.a f15709b;

    /* renamed from: c, reason: collision with root package name */
    public final y f15710c;

    /* renamed from: d, reason: collision with root package name */
    public final r f15711d;

    /* renamed from: e, reason: collision with root package name */
    public final C0913H f15712e;

    /* renamed from: f, reason: collision with root package name */
    public final c f15713f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f15714g;

    /* renamed from: h, reason: collision with root package name */
    public Intent f15715h;

    /* renamed from: i, reason: collision with root package name */
    public i f15716i;

    /* renamed from: j, reason: collision with root package name */
    public final C0911F f15717j;

    public j(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f15708a = applicationContext;
        B0.e eVar = new B0.e();
        C0913H c0913hE0 = C0913H.e0(context);
        this.f15712e = c0913hE0;
        C0844b c0844b = c0913hE0.f15326c;
        this.f15713f = new c(applicationContext, c0844b.f14172c, eVar);
        this.f15710c = new y(c0844b.f14175f);
        r rVar = c0913hE0.f15330g;
        this.f15711d = rVar;
        E0.a aVar = c0913hE0.f15328e;
        this.f15709b = aVar;
        this.f15717j = new C0911F(rVar, aVar);
        rVar.a(this);
        this.f15714g = new ArrayList();
        this.f15715h = null;
    }

    public static void b() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public final void a(int i4, Intent intent) {
        t tVarD = t.d();
        String str = f15707k;
        tVarD.a(str, "Adding command " + intent + " (" + i4 + ")");
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            t.d().g(str, "Unknown command. Ignoring");
            return;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            b();
            synchronized (this.f15714g) {
                try {
                    Iterator it = this.f15714g.iterator();
                    while (it.hasNext()) {
                        if ("ACTION_CONSTRAINTS_CHANGED".equals(((Intent) it.next()).getAction())) {
                            return;
                        }
                    }
                } finally {
                }
            }
        }
        intent.putExtra("KEY_START_ID", i4);
        synchronized (this.f15714g) {
            try {
                boolean z4 = !this.f15714g.isEmpty();
                this.f15714g.add(intent);
                if (!z4) {
                    d();
                }
            } finally {
            }
        }
    }

    @Override // t0.InterfaceC0918d
    public final void c(k kVar, boolean z4) {
        E0.b bVar = ((E0.c) this.f15709b).f403d;
        String str = c.f15676f;
        Intent intent = new Intent(this.f15708a, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z4);
        c.d(intent, kVar);
        bVar.execute(new android.support.v4.os.a(this, intent, 0));
    }

    public final void d() {
        b();
        PowerManager.WakeLock wakeLockA = C0.r.a(this.f15708a, "ProcessCommand");
        try {
            wakeLockA.acquire();
            this.f15712e.f15328e.a(new h(this, 0));
        } finally {
            wakeLockA.release();
        }
    }
}
