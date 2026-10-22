package okhttp3.internal.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.List;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.af;
import okhttp3.b;
import okhttp3.q;
import okhttp3.v;

/* JADX INFO: compiled from: JavaNetAuthenticator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q f39789d;

    /* JADX INFO: renamed from: okhttp3.internal.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JavaNetAuthenticator.kt */
    public /* synthetic */ class C1072a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f39790a = null;

        static {
            int[] r0 = new int[Proxy.Type.values().length];
            r0[Proxy.Type.DIRECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f39790a = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public a(q r3) {
        q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        o.e(r4, "defaultDns");
        this.f39789d = r4;
    }

    public /* synthetic */ a(q r2, int r3, h r4) {
        q r5 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = q.f40188b;
    L5:
        this(r5);
    }

    @Override // okhttp3.b
    public ab authenticate(af r20, ad r21) {
        o.e(r21, "response");
        List<okhttp3.h> r1 = r21.q();
        ab r3 = r21.a();
        v r4 = r3.a();
        if (r21.d() != 407) goto L5;
        boolean r2 = true;
    L6:
        if (r20 == null) goto L9;
        Proxy r6 = r20.b();
        if (r6 == null) goto L9;
    L10:
        Iterator<okhttp3.h> r5 = r1.iterator();
    L12:
        if (r5.hasNext() == false) goto L32;
        okhttp3.h r7 = (okhttp3.h) ZeusTransformUtils.preCheckCast(r5.next(), okhttp3.h.class, "com.obric.aiagent.plugin");
        if (d.o.o.a("Basic", r7.a(), true) == false) goto L12;
        if (r20 == null) goto L21;
        okhttp3.a r8 = r20.a();
        if (r8 == null) goto L21;
        q r9 = r8.a();
        if (r9 == null) goto L21;
    L23:
        if (r2 == false) goto L25;
        SocketAddress r11 = r6.address();
        o.a(r11, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetSocketAddress r10 = (InetSocketAddress) ZeusTransformUtils.preCheckCast(r11, InetSocketAddress.class, "com.obric.aiagent.plugin");
        String r12 = r10.getHostName();
        o.c(r6, "proxy");
        PasswordAuthentication r13 = Authenticator.requestPasswordAuthentication(r12, a(r6, r4, r9), r10.getPort(), r4.a(), r7.b(), r7.a(), r4.e(), Authenticator.RequestorType.PROXY);
    L26:
        if (r13 == null) goto L12;
        if (r2 == false) goto L29;
        String r0 = "Proxy-Authorization";
    L30:
        String r14 = r13.getUserName();
        o.c(r14, "auth.userName");
        char[] r15 = r13.getPassword();
        o.c(r15, "auth.password");
        return r3.h().a(r0, okhttp3.o.a(r14, new String(r15), r7.c())).b();
    L29:
        r0 = "Authorization";
        goto L30
    L25:
        String r16 = r4.b();
        o.c(r6, "proxy");
        r13 = Authenticator.requestPasswordAuthentication(r16, a(r6, r4, r9), r4.c(), r4.a(), r7.b(), r7.a(), r4.e(), Authenticator.RequestorType.SERVER);
    L21:
        r9 = this.f39789d;
        goto L23
    L32:
        return null;
    L9:
        r6 = Proxy.NO_PROXY;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private final InetAddress a(Proxy r3, v r4, q r5) {
        q r2 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
        Proxy.Type r6 = r3.type();
        if (r6 != null) goto L5;
        int r7 = -1;
    L7:
        if (r7 == 1) goto L11;
        SocketAddress r8 = r3.address();
        o.a(r8, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress r9 = ((InetSocketAddress) ZeusTransformUtils.preCheckCast(r8, InetSocketAddress.class, "com.obric.aiagent.plugin")).getAddress();
        o.c(r9, "address() as InetSocketAddress).address");
        return r9;
    L11:
        return (InetAddress) ZeusTransformUtils.preCheckCast(p.k(r2.lookup(r4.b())), InetAddress.class, "com.obric.aiagent.plugin");
    L5:
        r7 = C1072a.f39790a[r6.ordinal()];
        goto L7
    }
}
