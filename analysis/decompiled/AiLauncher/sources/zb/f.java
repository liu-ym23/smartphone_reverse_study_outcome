package zb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lzb/f;", "", "<init>", "()V", "", "method", "", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Z", Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_PKGNAME, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f45437a = new f();

    public static final boolean a(String method) {
        p.i(method, "method");
        return (p.d(method, "GET") || p.d(method, "HEAD")) ? false : true;
    }

    public static final boolean d(String method) {
        p.i(method, "method");
        return p.d(method, "POST") || p.d(method, "PUT") || p.d(method, "PATCH") || p.d(method, "PROPPATCH") || p.d(method, "QUERY") || p.d(method, "REPORT");
    }

    public final boolean b(String method) {
        p.i(method, "method");
        return !p.d(method, "PROPFIND");
    }

    public final boolean c(String method) {
        p.i(method, "method");
        return p.d(method, "PROPFIND");
    }
}
