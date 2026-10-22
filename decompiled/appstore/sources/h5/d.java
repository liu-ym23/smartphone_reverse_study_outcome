package h5;

import android.app.Service;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d implements Handler.Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f20345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f20346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map f20347d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler.Callback f20348a;

    static {
        f20345b = new d();
        f20346c = null;
    }

    public d() {
    }

    public static void a() {
        f20346c = null;
    }

    public static c b() {
        return f20346c;
    }

    public static d c() {
        return f20345b;
    }

    public synchronized String d(IBinder r10) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (f20347d == null) goto L21;
    L6:
        Map r11 = f20347d;     // Catch: Throwable -> L12
        String r12 = null;
        if (r11 != null) goto L9;
    L14:
        monitor-exit(this);
        return r12;
    L9:
        if (r11.get(r10) == null) goto L14;
        r12 = ((Service) f20347d.get(r10)).getClass().getName();     // Catch: Throwable -> L12
        goto L14
    L21:
        Object r13 = i5.a.c();     // Catch: Throwable -> L18
        f20347d = (Map) a.a(r13.getClass(), "mServices").get(r13);     // Catch: Throwable -> L18
        goto L6
    }

    public void e() {
        Handler r10 = (Handler) i5.a.f();     // Catch: Throwable -> L4
        Field r11 = a.a(Handler.class, "mCallback");     // Catch: Throwable -> L4
        this.f20348a = (Handler.Callback) r11.get(r10);     // Catch: Throwable -> L4
        r11.set(r10, this);     // Catch: Throwable -> L4
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r10) {
        if (b.a(r10) == false) goto L5;
        f20346c = c.a(r10);     // Catch: Throwable -> L11
    L5:
        Handler.Callback r11 = this.f20348a;
        if (r11 != null) goto L8;
        return false;
    L8:
        return r11.handleMessage(r10);
    }
}
