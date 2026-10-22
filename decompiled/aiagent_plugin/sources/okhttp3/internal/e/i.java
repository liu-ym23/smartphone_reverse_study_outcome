package okhttp3.internal.e;

import com.obric.capabilitykit.common.Ext;
import d.h.b.o;
import java.net.Proxy;
import okhttp3.ab;
import okhttp3.v;

/* JADX INFO: compiled from: RequestLine.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f39932a = null;

    static {
        f39932a = new i();
    }

    private i() {
    }

    public final String a(ab r2, Proxy.Type r3) {
        o.e(r2, Ext.KEY_REQUEST);
        o.e(r3, "proxyType");
        StringBuilder r1 = new StringBuilder();
        r1.append(r2.b());
        r1.append(' ');
        i r0 = f39932a;
        if (r0.b(r2, r3) == false) goto L5;
        r1.append(r2.a());
    L6:
        r1.append(" HTTP/1.1");
        String r4 = r1.toString();
        o.c(r4, "StringBuilder().apply(builderAction).toString()");
        return r4;
    L5:
        r1.append(r0.a(r2.a()));
        goto L6
    }

    private final boolean b(ab r1, Proxy.Type r2) {
        if (r1.f() == false) goto L5;
    L7:
        return false;
    L5:
        if (r2 != Proxy.Type.HTTP) goto L7;
        return true;
    }

    public final String a(v r2) {
        o.e(r2, "url");
        String r1 = r2.i();
        String r3 = r2.k();
        if (r3 != null) goto L5;
        return r1;
    L5:
        return r1 + '?' + r3;
    }
}
