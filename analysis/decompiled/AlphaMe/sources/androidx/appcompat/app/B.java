package androidx.appcompat.app;

import android.content.IntentFilter;

/* loaded from: classes.dex */
public abstract class B {

    /* renamed from: a, reason: collision with root package name */
    public A f2463a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ F f2464b;

    public B(F f4) {
        this.f2464b = f4;
    }

    public final void a() {
        A a4 = this.f2463a;
        if (a4 != null) {
            try {
                this.f2464b.f2512e.unregisterReceiver(a4);
            } catch (IllegalArgumentException unused) {
            }
            this.f2463a = null;
        }
    }

    public abstract int b();

    public final void c() {
        IntentFilter intentFilter;
        a();
        switch (((z) this).f2688c) {
            case 0:
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                break;
            default:
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.TIME_SET");
                intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter.addAction("android.intent.action.TIME_TICK");
                break;
        }
        if (intentFilter.countActions() == 0) {
            return;
        }
        if (this.f2463a == null) {
            this.f2463a = new A(0, this);
        }
        this.f2464b.f2512e.registerReceiver(this.f2463a, intentFilter);
    }
}
