package x;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public final class n implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final CountDownLatch f6867a;
    public final o b;
    public Object c;

    public n(CountDownLatch countDownLatch, o oVar) {
        this.f6867a = countDownLatch;
        this.b = oVar;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName componentName) {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch = this.f6867a;
        String str = i.i;
        Objects.toString(componentName);
        try {
            this.c = this.b.a(iBinder);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                String str2 = i.i;
                try {
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                try {
                    countDownLatch.countDown();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        String str = i.i;
        Objects.toString(componentName);
        try {
            this.f6867a.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
