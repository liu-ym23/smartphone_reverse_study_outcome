package X2;

import X2.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import d3.AbstractC0666b;
import d3.C0667c;
import e3.C0688b;
import g3.C0742e;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static a f5813d;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f5814e = new Object();

    /* renamed from: c, reason: collision with root package name */
    private List<c> f5817c = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private AbstractC0666b f5815a = new C0089a(30000);

    /* renamed from: b, reason: collision with root package name */
    private AbstractC0666b f5816b = new b(300000);

    /* renamed from: X2.a$a, reason: collision with other inner class name */
    class C0089a extends AbstractC0666b {
        C0089a(long j5) {
            super(j5);
        }

        @Override // d3.AbstractC0666b
        public void f() {
            for (c cVar : a.this.f5817c) {
                if (cVar != null) {
                    cVar.a("CHANGE_NAME_NETWORKCONNECT");
                }
            }
            a.this.f5815a.e();
        }
    }

    class b extends AbstractC0666b {
        b(long j5) {
            super(j5);
        }

        @Override // d3.AbstractC0666b
        public void f() {
            for (c cVar : a.this.f5817c) {
                if (cVar != null) {
                    cVar.a("CHANGE_NAME_POWER");
                }
            }
            a.this.f5816b.e();
        }
    }

    public interface c {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class d extends BroadcastReceiver {
        private d() {
        }

        public static /* synthetic */ void a(d dVar, Context context) {
            dVar.getClass();
            boolean zC = C0667c.c(context);
            C0742e.c("EnvironmentReceiver", "CONNECTIVITY_ACTION, isOnline = " + zC);
            if (zC) {
                a.this.f5815a.g();
            } else {
                a.this.f5815a.e();
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, Intent intent) {
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(intent.getAction())) {
                C0742e.c("EnvironmentReceiver", "ACTION_POWER_CONNECTED, charging = true");
                a.this.f5816b.g();
            } else if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(intent.getAction())) {
                C0742e.c("EnvironmentReceiver", "ACTION_POWER_DISCONNECTED, charging = false");
                a.this.f5816b.e();
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                C0688b.b(new Runnable() { // from class: X2.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.d.a(this.f5821a, context);
                    }
                });
            }
        }

        /* synthetic */ d(a aVar, C0089a c0089a) {
            this();
        }
    }

    private a(Context context) {
        d dVar = new d(this, null);
        try {
            context.unregisterReceiver(dVar);
        } catch (Exception unused) {
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            context.registerReceiver(dVar, intentFilter);
        } catch (Exception e6) {
            C0742e.l("EnvironmentReceiver", "Exception: " + e6.toString() + " - Cause: " + e6.getCause());
        }
    }

    public static a e(Context context) {
        if (f5813d == null) {
            synchronized (f5814e) {
                try {
                    if (f5813d == null) {
                        f5813d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f5813d;
    }

    public void d(c cVar) {
        List<c> list = this.f5817c;
        if (list == null || cVar == null) {
            return;
        }
        list.add(cVar);
    }
}
