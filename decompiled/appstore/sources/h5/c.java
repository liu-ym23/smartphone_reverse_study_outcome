package h5;

import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.Message;
import com.bytedanceos.common.toolbox.ServerElements;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Field f20334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Field f20335g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Field f20336h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Field f20337i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Field f20338j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Field f20339k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f20342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f20343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f20344e;

    public c(String r10, int r11, long r12, String r13) {
        this.f20340a = r10;
        this.f20341b = r11;
        this.f20342c = r12;
        this.f20343d = r13;
        this.f20344e = Thread.currentThread().getName();
    }

    public static c a(Message r14) {
        switch(r14.what) {
            case 114: goto L38;
            case 115: goto L31;
            case 116: goto L29;
            case 117: goto L6;
            case 118: goto L6;
            case 119: goto L6;
            case 120: goto L6;
            case 121: goto L22;
            case 122: goto L15;
            case 123: goto L8;
            default: goto L6;
        };
    L6:
        throw new IllegalArgumentException("message.what = " + r14.what + " is not excepted!");     // Catch: Throwable -> L52
    L8:
        if (f20339k != null) goto L10;
        f20339k = a.a(r14.obj.getClass(), "token");     // Catch: Throwable -> L52
    L10:
        IBinder r10 = (IBinder) f20339k.get(r14.obj);     // Catch: Throwable -> L52
        if (r10 == null) goto L51;
        return new c(d.c().d(r10), r14.what, System.currentTimeMillis(), r10.toString());
    L15:
        if (f20338j != null) goto L17;
        f20338j = a.a(r14.obj.getClass(), "token");     // Catch: Throwable -> L52
    L17:
        IBinder r11 = (IBinder) f20338j.get(r14.obj);     // Catch: Throwable -> L52
        if (r11 == null) goto L51;
        return new c(d.c().d(r11), r14.what, System.currentTimeMillis(), r11.toString());
    L22:
        if (f20337i != null) goto L24;
        f20337i = a.a(r14.obj.getClass(), "token");     // Catch: Throwable -> L52
    L24:
        IBinder r12 = (IBinder) f20337i.get(r14.obj);     // Catch: Throwable -> L52
        if (r12 == null) goto L51;
        return new c(d.c().d(r12), r14.what, System.currentTimeMillis(), r12.toString());
    L29:
        return new c(d.c().d((IBinder) r14.obj), r14.what, System.currentTimeMillis(), r14.obj.toString());
    L31:
        if (f20336h != null) goto L33;
        f20336h = a.a(r14.obj.getClass(), "token");     // Catch: Throwable -> L52
    L33:
        IBinder r13 = (IBinder) f20336h.get(r14.obj);     // Catch: Throwable -> L52
        if (r13 == null) goto L51;
        return new c(d.c().d(r13), r14.what, System.currentTimeMillis(), r13.toString());
    L38:
        if (f20334f != null) goto L41;
        f20334f = a.a(r14.obj.getClass(), ServerElements.INFO);     // Catch: Throwable -> L52
    L41:
        if (f20335g != null) goto L43;
        f20335g = a.a(r14.obj.getClass(), "token");     // Catch: Throwable -> L52
    L43:
        ServiceInfo r15 = (ServiceInfo) f20334f.get(r14.obj);     // Catch: Throwable -> L52
        if (r15 == null) goto L47;
        String r16 = r15.name;     // Catch: Throwable -> L52
    L49:
        return new c(r16, r14.what, System.currentTimeMillis(), f20335g.get(r14.obj).toString());
    L47:
        r16 = null;
    L51:
        return new c("unknow", r14.what, System.currentTimeMillis(), "unknow");
    }

    public String toString() {
        return "ServiceFollowBean{mServiceName='" + this.f20340a + "', mWhat=" + this.f20341b + ", mTimeStamp=" + this.f20342c + ", mToken='" + this.f20343d + "', mThreadName='" + this.f20344e + "'}";
    }
}
