package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: ResponseBody.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ae implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39722a = null;

    /* JADX INFO: compiled from: ResponseBody.kt */
    public static final class a {

        /* JADX INFO: renamed from: okhttp3.ae$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ResponseBody.kt */
        public static final class C1069a extends ae {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ x f39723b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f39724c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ e.g f39725d;

            C1069a(x r3, long r4, e.g r6) {
                e.g r7 = (e.g) ZeusTransformUtils.wrapperContextForParams(r6, e.g.class, "com.obric.aiagent.plugin");
                this.f39723b = r3;
                this.f39724c = r4;
                this.f39725d = r7;
            }

            @Override // okhttp3.ae
            public x b() {
                return this.f39723b;
            }

            @Override // okhttp3.ae
            public long c() {
                return this.f39724c;
            }

            @Override // okhttp3.ae
            public e.g d() {
                return this.f39725d;
            }
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static /* synthetic */ ae a(a r0, byte[] r1, x r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = null;
        L6:
            return r0.a(r1, r2);
        }

        public final ae a(byte[] r4, x r5) {
            d.h.b.o.e(r4, "<this>");
            return a((e.g) ZeusTransformUtils.preCheckCast(new e.e().b(r4), e.g.class, "com.obric.aiagent.plugin"), r5, r4.length);
        }

        public final ae a(e.g r2, x r3, long r4) {
            e.g r1 = (e.g) ZeusTransformUtils.wrapperContextForParams(r2, e.g.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "<this>");
            return (ae) ZeusTransformUtils.preCheckCast(new C1069a(r3, r4, r1), ae.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f39722a = new a(null);
    }

    public abstract x b();

    public abstract long c();

    public abstract e.g d();

    public ae() {
    }

    public final InputStream e() {
        return d().i();
    }

    public final String f() {
        Closeable r0 = (Closeable) ZeusTransformUtils.preCheckCast(d(), Closeable.class, "com.obric.aiagent.plugin");
        e.g r1 = (e.g) ZeusTransformUtils.preCheckCast(r0, e.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        String r3 = r1.a(okhttp3.internal.c.a(r1, a()));     // Catch: Throwable -> L6
        d.f.c.a(r0, null);
        return r3;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        d.f.c.a(r0, th);
        throw th;
    }

    private final Charset a() {
        x r1 = b();
        if (r1 == null) goto L7;
        Charset r2 = r1.a(d.o.d.f38623b);
        if (r2 == null) goto L7;
        return r2;
    L7:
        return d.o.d.f38623b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        okhttp3.internal.c.a((Closeable) ZeusTransformUtils.preCheckCast(d(), Closeable.class, "com.obric.aiagent.plugin"));
    }
}
