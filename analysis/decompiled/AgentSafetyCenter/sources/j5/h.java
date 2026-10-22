package j5;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import g5.u;
import h5.r;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import p5.i;
import p5.j;
import q5.n;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements h5.a {

    /* renamed from: o, reason: collision with root package name */
    public static final String f6587o = u.f("SystemAlarmDispatcher");

    /* renamed from: c, reason: collision with root package name */
    public Context f6588c;

    /* renamed from: f, reason: collision with root package name */
    public i f6589f;

    /* renamed from: g, reason: collision with root package name */
    public n f6590g;

    /* renamed from: h, reason: collision with root package name */
    public h5.d f6591h;
    public r i;

    /* renamed from: j, reason: collision with root package name */
    public b f6592j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f6593k;

    /* renamed from: l, reason: collision with root package name */
    public Intent f6594l;

    /* renamed from: m, reason: collision with root package name */
    public SystemAlarmService f6595m;

    /* renamed from: n, reason: collision with root package name */
    public p5.e f6596n;

    public static void b() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        od.f.e("Needs to be invoked on the main thread.");
    }

    public final void a(Intent intent, int i) {
        u uVarD = u.d();
        String str = f6587o;
        uVarD.a(str, "Adding command " + intent + " (" + i + ")");
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            u.d().g(str, "Unknown command. Ignoring");
            return;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            b();
            synchronized (this.f6593k) {
                try {
                    ArrayList arrayList = this.f6593k;
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        if ("ACTION_CONSTRAINTS_CHANGED".equals(((Intent) obj).getAction())) {
                            return;
                        }
                    }
                } finally {
                }
            }
        }
        intent.putExtra("KEY_START_ID", i);
        synchronized (this.f6593k) {
            try {
                boolean zIsEmpty = this.f6593k.isEmpty();
                this.f6593k.add(intent);
                if (zIsEmpty) {
                    c();
                }
            } finally {
            }
        }
    }

    public final void c() {
        b();
        PowerManager.WakeLock wakeLockA = q5.h.a(this.f6588c, "ProcessCommand");
        try {
            wakeLockA.acquire();
            i iVar = this.i.f5373d;
            g gVar = new g();
            gVar.f6586f = this;
            VarHandle.storeStoreFence();
            iVar.q(gVar);
        } finally {
            wakeLockA.release();
        }
    }

    @Override // h5.a
    public final void e(j jVar, boolean z10) {
        r5.a aVar = (r5.a) this.f6589f.f9733h;
        Context context = this.f6588c;
        String str = b.f6559j;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z10);
        b.c(intent, jVar);
        aVar.execute(new androidx.activity.h(0, intent, this));
    }
}
