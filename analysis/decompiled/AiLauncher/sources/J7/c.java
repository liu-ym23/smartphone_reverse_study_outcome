package J7;

import Y8.t;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0014¨\u0006\u0016"}, d2 = {"LJ7/c;", "", "<init>", "()V", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)V", "f", "ctx", "c", "Ljava/lang/String;", "cachedOaid", "", "Z", RobotInfo.STATUS_STARTED, "Ljava/lang/Object;", "lock", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static volatile boolean started;

    /* renamed from: a, reason: collision with root package name */
    public static final c f3742a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static volatile String cachedOaid = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Object lock = new Object();

    public static final String b() {
        return cachedOaid;
    }

    public static final void d(Context context) {
        p.i(context, "context");
        if (started) {
            return;
        }
        synchronized (lock) {
            if (started) {
                return;
            }
            final Context applicationContext = context.getApplicationContext();
            c cVar = f3742a;
            p.f(applicationContext);
            cVar.c(applicationContext);
            K7.a aVar = new K7.a() { // from class: J7.b
                @Override // K7.a
                public final void a() {
                    c.e(applicationContext);
                }
            };
            try {
                Result.Companion companion = Result.INSTANCE;
                K7.c.c(applicationContext, aVar);
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            f3742a.c(applicationContext);
            started = true;
            t tVar = t.f7040a;
        }
    }

    public static final void e(Context context) {
        c cVar = f3742a;
        p.f(context);
        cVar.c(context);
    }

    public static final void f() {
        synchronized (lock) {
            if (started) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    K7.c.a();
                    Result.b(t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
                started = false;
                t tVar = t.f7040a;
            }
        }
    }

    public final void c(Context ctx) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(K7.c.b(ctx));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            str = "";
        }
        cachedOaid = str;
    }
}
