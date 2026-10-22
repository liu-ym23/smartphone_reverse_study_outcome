package v2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.lifecycle.AbstractC0545z;
import androidx.lifecycle.B;
import f2.C0702g;

/* loaded from: classes.dex */
public abstract class f implements e {

    /* renamed from: a, reason: collision with root package name */
    private final Context f23316a;

    /* renamed from: b, reason: collision with root package name */
    private final B<Boolean> f23317b;

    /* renamed from: c, reason: collision with root package name */
    private final B<Object> f23318c;

    /* renamed from: d, reason: collision with root package name */
    private ServiceConnection f23319d;

    private class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C0702g.b("ServiceProxyImpl", "onServiceConnected() called with: name = [" + componentName + "], service = [" + iBinder + "] " + f.this);
            f.this.f23318c.k(iBinder);
            f.this.f23317b.k(Boolean.TRUE);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C0702g.b("ServiceProxyImpl", "onServiceDisconnected() called with: name = [" + componentName + "] " + f.this);
            f.this.f23317b.k(Boolean.FALSE);
            f.this.f23318c.k(null);
        }

        private a() {
        }
    }

    public f(Context context) {
        this(context, true);
    }

    @Override // v2.e
    public void a() {
        C0702g.b("ServiceProxyImpl", "release() called this = " + this);
        ServiceConnection serviceConnection = this.f23319d;
        if (serviceConnection != null) {
            try {
                try {
                    this.f23316a.unbindService(serviceConnection);
                } catch (Exception e6) {
                    R1.a.b("ServiceProxyImpl", Log.getStackTraceString(e6));
                }
            } finally {
                this.f23319d = null;
                this.f23317b.k(Boolean.FALSE);
                this.f23318c.k(null);
            }
        }
    }

    @Override // v2.e
    public AbstractC0545z<Boolean> b() {
        return this.f23317b;
    }

    @Override // v2.e
    public AbstractC0545z<Object> c() {
        return this.f23318c;
    }

    protected Context f() {
        return this.f23316a;
    }

    protected abstract Intent g();

    @Override // v2.e
    public void init() {
        C0702g.b("ServiceProxyImpl", "init() called");
        if (Boolean.FALSE.equals(this.f23317b.e())) {
            C0702g.b("ServiceProxyImpl", "init() called bindService " + this);
            if (this.f23319d == null) {
                this.f23319d = new a();
            }
            this.f23316a.bindService(g(), this.f23319d, 1);
        }
    }

    public f(Context context, boolean z5) {
        B<Boolean> b6 = new B<>();
        this.f23317b = b6;
        this.f23318c = new B<>();
        this.f23319d = new a();
        this.f23316a = context;
        b6.n(Boolean.FALSE);
        C0702g.b("ServiceProxyImpl", "ServiceProxyImpl() called with: context = [" + context + "], bind = [" + z5 + "] " + this);
        if (z5) {
            C0702g.b("ServiceProxyImpl", "init() called bindService " + this);
            if (this.f23319d == null) {
                this.f23319d = new a();
            }
            context.bindService(g(), this.f23319d, 1);
        }
    }
}
