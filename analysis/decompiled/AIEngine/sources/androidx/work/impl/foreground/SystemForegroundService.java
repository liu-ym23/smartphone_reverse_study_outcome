package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.u;
import d0.b;
import h2.j;
import java.util.UUID;
import p2.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SystemForegroundService extends u {

    /* renamed from: e, reason: collision with root package name */
    public static final String f2966e = j.f("SystemFgService");

    /* renamed from: b, reason: collision with root package name */
    public boolean f2967b;

    /* renamed from: c, reason: collision with root package name */
    public a f2968c;

    /* renamed from: d, reason: collision with root package name */
    public NotificationManager f2969d;

    public final void a() {
        this.f2969d = (NotificationManager) getApplicationContext().getSystemService("notification");
        a aVar = new a(getApplicationContext());
        this.f2968c = aVar;
        if (aVar.f11402l != null) {
            j.d().b(a.f11394m, "A callback already exists.");
        } else {
            aVar.f11402l = this;
        }
    }

    public final void b(int i10, int i11, Notification notification) {
        String str = f2966e;
        if (Build.VERSION.SDK_INT < 31) {
            startForeground(i10, notification, i11);
            return;
        }
        try {
            startForeground(i10, notification, i11);
        } catch (ForegroundServiceStartNotAllowedException e10) {
            if (((j.a) j.d()).f9274c <= 5) {
                Log.w(str, "Unable to start foreground service", e10);
            }
        } catch (SecurityException e11) {
            if (((j.a) j.d()).f9274c <= 5) {
                Log.w(str, "Unable to start foreground service", e11);
            }
        }
    }

    @Override // androidx.lifecycle.u, android.app.Service
    public final void onCreate() {
        super.onCreate();
        a();
    }

    @Override // androidx.lifecycle.u, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f2968c.e();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        boolean z = this.f2967b;
        String str = f2966e;
        if (z) {
            j.d().e(str, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.f2968c.e();
            a();
            this.f2967b = false;
        }
        if (intent == null) {
            return 3;
        }
        a aVar = this.f2968c;
        aVar.getClass();
        String str2 = a.f11394m;
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            j.d().e(str2, "Started foreground service " + intent);
            aVar.f11396b.d(new b(aVar, intent.getStringExtra("KEY_WORKSPEC_ID")));
            aVar.d(intent);
            return 3;
        }
        if ("ACTION_NOTIFY".equals(action)) {
            aVar.d(intent);
            return 3;
        }
        if (!"ACTION_CANCEL_WORK".equals(action)) {
            if (!"ACTION_STOP_FOREGROUND".equals(action)) {
                return 3;
            }
            j.d().e(str2, "Stopping foreground service");
            SystemForegroundService systemForegroundService = aVar.f11402l;
            if (systemForegroundService == null) {
                return 3;
            }
            systemForegroundService.f2967b = true;
            j.d().a(str, "Shutting down.");
            systemForegroundService.stopForeground(true);
            systemForegroundService.stopSelf();
            return 3;
        }
        j.d().e(str2, "Stopping foreground work for " + intent);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return 3;
        }
        androidx.work.impl.b bVar = aVar.f11395a;
        UUID uuidFromString = UUID.fromString(stringExtra);
        bVar.getClass();
        androidx.work.impl.utils.a.b(bVar, uuidFromString);
        return 3;
    }

    @Override // android.app.Service
    public final void onTimeout(int i10) {
        if (Build.VERSION.SDK_INT >= 35) {
            return;
        }
        this.f2968c.f(2048);
    }

    public final void onTimeout(int i10, int i11) {
        this.f2968c.f(i11);
    }
}
