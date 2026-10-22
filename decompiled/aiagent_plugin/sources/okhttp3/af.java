package okhttp3;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: Route.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f39726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Proxy f39727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InetSocketAddress f39728c;

    public af(a r2, Proxy r3, InetSocketAddress r4) {
        d.h.b.o.e(r2, SensitiveType.ADDRESS);
        d.h.b.o.e(r3, "proxy");
        d.h.b.o.e(r4, "socketAddress");
        this.f39726a = r2;
        this.f39727b = r3;
        this.f39728c = r4;
    }

    public final a a() {
        return this.f39726a;
    }

    public final Proxy b() {
        return this.f39727b;
    }

    public final InetSocketAddress c() {
        return this.f39728c;
    }

    public final boolean d() {
        if (this.f39726a.c() != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f39727b.type() != Proxy.Type.HTTP) goto L7;
        return true;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, af.class) == true) goto L5;
    L11:
        return false;
    L5:
        if (d.h.b.o.a(((af) ZeusTransformUtils.preCheckCast(r5, af.class, "com.obric.aiagent.plugin")).f39726a, this.f39726a) == false) goto L11;
        if (d.h.b.o.a(((af) ZeusTransformUtils.preCheckCast(r5, af.class, "com.obric.aiagent.plugin")).f39727b, this.f39727b) == false) goto L11;
        if (d.h.b.o.a(((af) ZeusTransformUtils.preCheckCast(r5, af.class, "com.obric.aiagent.plugin")).f39728c, this.f39728c) == false) goto L11;
        return true;
    }

    public int hashCode() {
        return ((((527 + this.f39726a.hashCode()) * 31) + this.f39727b.hashCode()) * 31) + this.f39728c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f39728c + '}';
    }
}
