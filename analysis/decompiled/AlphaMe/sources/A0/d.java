package A0;

import android.app.Notification;
import androidx.work.impl.foreground.SystemForegroundService;

/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f38a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Notification f39b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f40c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SystemForegroundService f41d;

    public d(SystemForegroundService systemForegroundService, int i4, Notification notification, int i5) {
        this.f41d = systemForegroundService;
        this.f38a = i4;
        this.f39b = notification;
        this.f40c = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f41d, this.f38a, this.f39b, this.f40c);
    }
}
