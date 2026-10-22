package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleService;
import androidx.work.i;
import androidx.work.impl.utils.s;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemAlarmService extends LifecycleService implements SystemAlarmDispatcher.CommandsCompletedListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5459d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SystemAlarmDispatcher f5460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5461c;

    static {
        f5459d = i.i("SystemAlarmService");
    }

    public SystemAlarmService() {
    }

    public final void a() {
        SystemAlarmDispatcher r10 = new SystemAlarmDispatcher(this);
        this.f5460b = r10;
        r10.k(this);
    }

    @Override // androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.CommandsCompletedListener
    public void onAllCommandsCompleted() {
        this.f5461c = true;
        i.e().a(f5459d, "All commands completed in dispatcher");
        s.a();
        stopSelf();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        a();
        this.f5461c = false;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f5461c = true;
        this.f5460b.i();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        super.onStartCommand(r10, r11, r12);
        if (this.f5461c == false) goto L5;
        i.e().f(f5459d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
        this.f5460b.i();
        a();
        this.f5461c = false;
    L5:
        if (r10 == null) goto L9;
        this.f5460b.a(r10, r12);
        return 3;
    L9:
        return 3;
    }
}
