package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* JADX INFO: compiled from: Dns.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f40188b = null;

    /* JADX INFO: compiled from: Dns.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f40189a = null;

        /* JADX INFO: renamed from: okhttp3.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Dns.kt */
        private static final class C1090a implements q {
            public C1090a() {
            }

            @Override // okhttp3.q
            public List<InetAddress> lookup(String r5) {
                d.h.b.o.e(r5, "hostname");
                InetAddress[] r0 = InetAddress.getAllByName(r5);     // Catch: NullPointerException -> L5
                d.h.b.o.c(r0, "getAllByName(hostname)");     // Catch: NullPointerException -> L5
                return d.a.i.g((Object[]) ZeusTransformUtils.preCheckCast(r0, Object[].class, "com.obric.aiagent.plugin"));
            L5:
                e = move-exception;
                UnknownHostException r1 = new UnknownHostException("Broken system behaviour for dns lookup of " + r5);
                r1.initCause((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
                throw ((Throwable) ZeusTransformUtils.preCheckCast(r1, Throwable.class, "com.obric.aiagent.plugin"));
            }
        }

        static {
            f40189a = new a();
        }

        private a() {
        }
    }

    List<InetAddress> lookup(String r1);

    static {
        f40187a = a.f40189a;
        f40188b = (q) ZeusTransformUtils.preCheckCast(new a.C1090a(), q.class, "com.obric.aiagent.plugin");
    }
}
