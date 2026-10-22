package V3;

import Y8.t;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.r;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\u000bJ)\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000bJ)\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000bRB\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\t0\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"LV3/b;", "", "<init>", "()V", "", "tag", "msg", "", "tr", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_UMID, "Lkotlin/Function4;", "", "Lp9/r;", "getLogDelegate", "()Lp9/r;", "setLogDelegate", "(Lp9/r;)V", "logDelegate", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f6474a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static r<? super Integer, ? super String, ? super String, ? super Throwable, t> logDelegate = new r() { // from class: V3.a
        @Override // p9.r
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return b.h(((Integer) obj).intValue(), (String) obj2, (String) obj3, (Throwable) obj4);
        }
    };

    public static /* synthetic */ void c(b bVar, String str, String str2, Throwable th, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            th = null;
        }
        bVar.b(str, str2, th);
    }

    public static /* synthetic */ void e(b bVar, String str, String str2, Throwable th, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            th = null;
        }
        bVar.d(str, str2, th);
    }

    public static /* synthetic */ void g(b bVar, String str, String str2, Throwable th, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            th = null;
        }
        bVar.f(str, str2, th);
    }

    public static final t h(int i10, String tag, String msg, Throwable th) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        if (i10 != 3) {
            if (i10 != 4) {
                if (i10 != 5) {
                    if (i10 != 6) {
                        if (th != null) {
                            Log.v(tag, msg, th);
                        } else {
                            Log.v(tag, msg);
                        }
                    } else if (th != null) {
                        Log.e(tag, msg, th);
                    } else {
                        Log.e(tag, msg);
                    }
                } else if (th != null) {
                    Log.w(tag, msg, th);
                } else {
                    Log.w(tag, msg);
                }
            } else if (th != null) {
                Log.i(tag, msg, th);
            } else {
                Log.i(tag, msg);
            }
        } else if (th != null) {
            Log.d(tag, msg, th);
        } else {
            Log.d(tag, msg);
        }
        return t.f7040a;
    }

    public static /* synthetic */ void j(b bVar, String str, String str2, Throwable th, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            th = null;
        }
        bVar.i(str, str2, th);
    }

    public final void b(String tag, String msg, Throwable tr) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        logDelegate.invoke(3, "Ability_" + tag, msg, tr);
    }

    public final void d(String tag, String msg, Throwable tr) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        logDelegate.invoke(6, "Ability_" + tag, msg, tr);
    }

    public final void f(String tag, String msg, Throwable tr) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        logDelegate.invoke(4, "Ability_" + tag, msg, tr);
    }

    public final void i(String tag, String msg, Throwable tr) {
        p.i(tag, "tag");
        p.i(msg, "msg");
        logDelegate.invoke(5, "Ability_" + tag, msg, tr);
    }
}
