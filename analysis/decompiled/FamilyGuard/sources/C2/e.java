package C2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface;

/* loaded from: classes.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private IDigitalWellbeingInterface f602b;

    /* renamed from: a, reason: collision with root package name */
    private final Object f601a = new Object();

    /* renamed from: c, reason: collision with root package name */
    private final a f603c = new a();

    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (e.this.f601a) {
                e.this.f602b = IDigitalWellbeingInterface.Stub.asInterface(iBinder);
                e.this.f601a.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            e.this.f602b = null;
        }
    }

    public e(Context context) {
    }

    protected void c(Intent intent) {
        P1.a.a().bindService(intent, this.f603c, 1);
    }

    public IDigitalWellbeingInterface d() throws InterruptedException {
        IDigitalWellbeingInterface iDigitalWellbeingInterface;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.e("DWServiceSync", "getService must not be called on main thread", new IllegalStateException());
            throw new InterruptedException("getService on main thread");
        }
        Intent intent = new Intent("com.stepos.digitalwellbeing.dws");
        intent.setPackage(P1.a.a().getPackageName());
        if (this.f602b == null) {
            c(intent);
        }
        synchronized (this.f601a) {
            while (true) {
                try {
                    iDigitalWellbeingInterface = this.f602b;
                    if (iDigitalWellbeingInterface == null) {
                        this.f601a.wait();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return iDigitalWellbeingInterface;
    }

    protected void e() {
        try {
            this.f602b = null;
            P1.a.a().unbindService(this.f603c);
        } catch (Exception unused) {
        }
    }
}
