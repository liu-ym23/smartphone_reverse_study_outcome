package androidx.work.impl.foreground;

import A0.b;
import A0.c;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.RunnableC0209k;
import androidx.lifecycle.J;
import e.EnumC0546d;
import java.util.UUID;
import s0.t;
import t0.C0913H;

@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes.dex */
public class SystemForegroundService extends J implements b {

    /* renamed from: f, reason: collision with root package name */
    public static final String f4340f = t.f("SystemFgService");

    /* renamed from: b, reason: collision with root package name */
    public Handler f4341b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4342c;

    /* renamed from: d, reason: collision with root package name */
    public c f4343d;

    /* renamed from: e, reason: collision with root package name */
    public NotificationManager f4344e;

    public final void a() {
        this.f4341b = new Handler(Looper.getMainLooper());
        this.f4344e = (NotificationManager) getApplicationContext().getSystemService("notification");
        c cVar = new c(getApplicationContext());
        this.f4343d = cVar;
        if (cVar.f37i != null) {
            t.d().b(c.f28j, "A callback already exists.");
        } else {
            cVar.f37i = this;
        }
    }

    @Override // androidx.lifecycle.J, android.app.Service
    public final void onCreate() {
        super.onCreate();
        a();
    }

    @Override // androidx.lifecycle.J, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f4343d.f();
    }

    @Override // androidx.lifecycle.J, android.app.Service
    public final int onStartCommand(Intent intent, int i4, int i5) {
        super.onStartCommand(intent, i4, i5);
        boolean z4 = this.f4342c;
        String str = f4340f;
        if (z4) {
            t.d().e(str, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.f4343d.f();
            a();
            this.f4342c = false;
        }
        if (intent == null) {
            return 3;
        }
        c cVar = this.f4343d;
        cVar.getClass();
        String action = intent.getAction();
        boolean zEquals = "ACTION_START_FOREGROUND".equals(action);
        String str2 = c.f28j;
        if (zEquals) {
            t.d().e(str2, "Started foreground service " + intent);
            cVar.f30b.a(new RunnableC0209k(9, cVar, intent.getStringExtra("KEY_WORKSPEC_ID")));
            cVar.e(intent);
            return 3;
        }
        if ("ACTION_NOTIFY".equals(action)) {
            cVar.e(intent);
            return 3;
        }
        if (!"ACTION_CANCEL_WORK".equals(action)) {
            if (!"ACTION_STOP_FOREGROUND".equals(action)) {
                return 3;
            }
            t.d().e(str2, "Stopping foreground service");
            b bVar = cVar.f37i;
            if (bVar == null) {
                return 3;
            }
            SystemForegroundService systemForegroundService = (SystemForegroundService) bVar;
            systemForegroundService.f4342c = true;
            t.d().a(str, "All commands completed.");
            systemForegroundService.stopForeground(true);
            systemForegroundService.stopSelf();
            return 3;
        }
        t.d().e(str2, "Stopping foreground work for " + intent);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return 3;
        }
        UUID uuidFromString = UUID.fromString(stringExtra);
        C0913H c0913h = cVar.f29a;
        c0913h.getClass();
        c0913h.f15328e.a(new C0.b(c0913h, uuidFromString));
        return 3;
    }
}
