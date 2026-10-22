package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a0 extends Service implements x {

    /* renamed from: c, reason: collision with root package name */
    public final p5.m f1356c;

    public a0() {
        p5.m mVar = new p5.m(4);
        mVar.f9741f = new z(this, true);
        mVar.f9742g = new Handler(Looper.getMainLooper());
        VarHandle.storeStoreFence();
        this.f1356c = mVar;
    }

    @Override // androidx.lifecycle.x
    public final q getLifecycle() {
        return (z) this.f1356c.f9741f;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        intent.getClass();
        p5.m mVar = this.f1356c;
        mVar.getClass();
        mVar.K(o.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        p5.m mVar = this.f1356c;
        mVar.getClass();
        mVar.K(o.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        p5.m mVar = this.f1356c;
        mVar.getClass();
        mVar.K(o.ON_STOP);
        mVar.K(o.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i) {
        p5.m mVar = this.f1356c;
        mVar.getClass();
        mVar.K(o.ON_START);
        super.onStart(intent, i);
    }
}
