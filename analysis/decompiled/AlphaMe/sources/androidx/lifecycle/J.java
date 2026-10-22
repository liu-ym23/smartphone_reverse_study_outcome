package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class J extends Service implements G {

    /* renamed from: a, reason: collision with root package name */
    public final android.support.v4.media.session.c f3878a = new android.support.v4.media.session.c(this);

    @Override // androidx.lifecycle.G
    public final AbstractC0328z getLifecycle() {
        return (I) this.f3878a.f2364b;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.f3878a.z(EnumC0326x.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f3878a.z(EnumC0326x.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        EnumC0326x enumC0326x = EnumC0326x.ON_STOP;
        android.support.v4.media.session.c cVar = this.f3878a;
        cVar.z(enumC0326x);
        cVar.z(EnumC0326x.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i4) {
        this.f3878a.z(EnumC0326x.ON_START);
        super.onStart(intent, i4);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        return super.onStartCommand(intent, i4, i5);
    }
}
