package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleService;
import androidx.work.i;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5607f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static SystemForegroundService f5608g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f5609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SystemForegroundDispatcher f5611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public NotificationManager f5612e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Notification f5614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f5615c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SystemForegroundService f5616d;

        public a(SystemForegroundService r10, int r11, Notification r12, int r13) {
            this.f5616d = r10;
            this.f5613a = r11;
            this.f5614b = r12;
            this.f5615c = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT < 31) goto L5;
            e.a(this.f5616d, this.f5613a, this.f5614b, this.f5615c);
            return;
        L5:
            d.a(this.f5616d, this.f5613a, this.f5614b, this.f5615c);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Notification f5618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SystemForegroundService f5619c;

        public b(SystemForegroundService r10, int r11, Notification r12) {
            this.f5619c = r10;
            this.f5617a = r11;
            this.f5618b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5619c.f5612e.notify(this.f5617a, this.f5618b);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SystemForegroundService f5621b;

        public c(SystemForegroundService r10, int r11) {
            this.f5621b = r10;
            this.f5620a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5621b.f5612e.cancel(this.f5620a);
        }
    }

    public static class d {
        @DoNotInline
        public static void a(Service r10, int r11, Notification r12, int r13) {
            r10.startForeground(r11, r12, r13);
        }
    }

    public static class e {
        @DoNotInline
        public static void a(Service r10, int r11, Notification r12, int r13) {
            r10.startForeground(r11, r12, r13);     // Catch: ForegroundServiceStartNotAllowedException -> L4
            return;
        L4:
            e = move-exception;
            i.e().l(SystemForegroundService.a(), "Unable to start foreground service", e);
        }
    }

    static {
        f5607f = i.i("SystemFgService");
        f5608g = null;
    }

    public SystemForegroundService() {
    }

    public static /* synthetic */ String a() {
        return f5607f;
    }

    private void b() {
        this.f5609b = new Handler(Looper.getMainLooper());
        this.f5612e = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher r10 = new SystemForegroundDispatcher(getApplicationContext());
        this.f5611d = r10;
        r10.k(this);
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void cancelNotification(int r10) {
        this.f5609b.post(new c(this, r10));
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void notify(int r10, Notification r11) {
        this.f5609b.post(new b(this, r10, r11));
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        f5608g = this;
        b();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f5611d.i();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        super.onStartCommand(r10, r11, r12);
        if (this.f5610c == false) goto L5;
        i.e().f(f5607f, "Re-initializing SystemForegroundService after a request to shut-down.");
        this.f5611d.i();
        b();
        this.f5610c = false;
    L5:
        if (r10 == null) goto L9;
        this.f5611d.j(r10);
        return 3;
    L9:
        return 3;
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void startForeground(int r10, int r11, Notification r12) {
        this.f5609b.post(new a(this, r10, r12, r11));
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void stop() {
        this.f5610c = true;
        i.e().a(f5607f, "All commands completed.");
        stopForeground(true);
        f5608g = null;
        stopSelf();
    }
}
