package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class u extends Service implements q {

    /* renamed from: a, reason: collision with root package name */
    public final o0 f2319a = new o0(this);

    @Override // androidx.lifecycle.q
    public final Lifecycle getLifecycle() {
        return this.f2319a.f2295a;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        kotlin.jvm.internal.g.f(intent, "intent");
        o0 o0Var = this.f2319a;
        o0Var.getClass();
        o0Var.a(Lifecycle.Event.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        o0 o0Var = this.f2319a;
        o0Var.getClass();
        o0Var.a(Lifecycle.Event.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        o0 o0Var = this.f2319a;
        o0Var.getClass();
        o0Var.a(Lifecycle.Event.ON_STOP);
        o0Var.a(Lifecycle.Event.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i10) {
        o0 o0Var = this.f2319a;
        o0Var.getClass();
        o0Var.a(Lifecycle.Event.ON_START);
        super.onStart(intent, i10);
    }
}
