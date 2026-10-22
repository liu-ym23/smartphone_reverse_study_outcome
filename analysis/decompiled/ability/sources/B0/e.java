package B0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import cc.dd.ee.jj.a;

/* loaded from: classes2.dex */
public final class e implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f176a;

    public e(f fVar) {
        this.f176a = fVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f176a.f177a = a.AbstractBinderC0142a.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f176a.f177a = null;
    }
}
