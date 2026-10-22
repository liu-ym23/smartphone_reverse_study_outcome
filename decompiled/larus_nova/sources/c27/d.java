package c27;

import android.app.Service;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements Handler.Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f22214b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f22215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map<IBinder, Service> f22216d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler.Callback f22217a;

    static {
        f22214b = new d();
        f22215c = null;
    }

    public d() {
    }

    public final synchronized String a(IBinder r100) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (f22216d == null) goto L20;
    L6:
        Map<IBinder, Service> r101 = f22216d;     // Catch: Throwable -> L14
        String r102 = null;
        if (r101 != null) goto L9;
    L12:
        monitor-exit(this);
        return r102;
    L9:
        if (r101.get(r100) == null) goto L12;
        r102 = f22216d.get(r100).getClass().getName();     // Catch: Throwable -> L14
        goto L12
    L20:
        Object r103 = d27.a.b();     // Catch: Throwable -> L17
        f22216d = (Map) a.a(r103.getClass(), "mServices").get(r103);     // Catch: Throwable -> L17
        goto L6
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        Set<Integer> r101 = b.f22202a;     // Catch: Throwable -> L6
        HashSet r102 = (HashSet) r101;     // Catch: Throwable -> L6
        if (r102.contains(Integer.valueOf(r100.what)) == false) goto L7;
        f22215c = c.a(r100);     // Catch: Throwable -> L6
    L7:
        Handler.Callback r103 = this.f22217a;
        if (r103 != null) goto L10;
        return false;
    L10:
        return r103.handleMessage(r100);
    }
}
