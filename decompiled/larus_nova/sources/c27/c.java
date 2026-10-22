package c27;

import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Field f22203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Field f22204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Field f22205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Field f22206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Field f22207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Field f22208k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f22211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22213e;

    public final String toString() {
        return "ServiceFollowBean{mServiceName='" + this.f22209a + "', mWhat=" + this.f22210b + ", mTimeStamp=" + this.f22211c + ", mToken='" + this.f22212d + "', mThreadName='" + this.f22213e + "'}";
    }

    public static c a(Message r110) {
        switch(r110.what) {
            case 114: goto L38;
            case 115: goto L31;
            case 116: goto L29;
            case 117: goto L50;
            case 118: goto L50;
            case 119: goto L50;
            case 120: goto L50;
            case 121: goto L22;
            case 122: goto L15;
            case 123: goto L8;
            default: goto L50;
        };
    L50:
        throw new IllegalArgumentException("message.what = " + r110.what + " is not excepted!");     // Catch: Throwable -> L53
    L8:
        if (f22208k != null) goto L10;
        f22208k = a.a(r110.obj.getClass(), "token");     // Catch: Throwable -> L53
    L10:
        IBinder r100 = (IBinder) f22208k.get(r110.obj);     // Catch: Throwable -> L53
        if (r100 == null) goto L52;
        return new c(d.f22214b.a(r100), r110.what, System.currentTimeMillis(), r100.toString());
    L15:
        if (f22207j != null) goto L17;
        f22207j = a.a(r110.obj.getClass(), "token");     // Catch: Throwable -> L53
    L17:
        IBinder r101 = (IBinder) f22207j.get(r110.obj);     // Catch: Throwable -> L53
        if (r101 == null) goto L52;
        return new c(d.f22214b.a(r101), r110.what, System.currentTimeMillis(), r101.toString());
    L22:
        if (f22206i != null) goto L24;
        f22206i = a.a(r110.obj.getClass(), "token");     // Catch: Throwable -> L53
    L24:
        IBinder r102 = (IBinder) f22206i.get(r110.obj);     // Catch: Throwable -> L53
        if (r102 == null) goto L52;
        return new c(d.f22214b.a(r102), r110.what, System.currentTimeMillis(), r102.toString());
    L29:
        return new c(d.f22214b.a((IBinder) r110.obj), r110.what, System.currentTimeMillis(), r110.obj.toString());
    L31:
        if (f22205h != null) goto L33;
        f22205h = a.a(r110.obj.getClass(), "token");     // Catch: Throwable -> L53
    L33:
        IBinder r103 = (IBinder) f22205h.get(r110.obj);     // Catch: Throwable -> L53
        if (r103 == null) goto L52;
        return new c(d.f22214b.a(r103), r110.what, System.currentTimeMillis(), r103.toString());
    L38:
        if (f22203f != null) goto L41;
        f22203f = a.a(r110.obj.getClass(), "info");     // Catch: Throwable -> L53
    L41:
        if (f22204g != null) goto L43;
        f22204g = a.a(r110.obj.getClass(), "token");     // Catch: Throwable -> L53
    L43:
        ServiceInfo r104 = (ServiceInfo) f22203f.get(r110.obj);     // Catch: Throwable -> L53
        if (r104 == null) goto L46;
        String r105 = r104.name;     // Catch: Throwable -> L53
    L48:
        return new c(r105, r110.what, System.currentTimeMillis(), f22204g.get(r110.obj).toString());
    L46:
        r105 = null;
    L52:
        return new c("unknow", r110.what, System.currentTimeMillis(), "unknow");
    }

    public c(String r100, int r101, long r102, String r103) {
        this.f22209a = r100;
        this.f22210b = r101;
        this.f22211c = r102;
        this.f22212d = r103;
        this.f22213e = ThreadMethodProxy.currentThread().getName();
    }
}
