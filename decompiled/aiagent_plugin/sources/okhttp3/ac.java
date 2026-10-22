package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: RequestBody.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ac {
    public static final a g = null;

    /* JADX INFO: compiled from: RequestBody.kt */
    public static final class a {

        /* JADX INFO: renamed from: okhttp3.ac$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RequestBody.kt */
        public static final class C1068a extends ac {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ x f39708a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f39709b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ byte[] f39710c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f39711d;

            C1068a(x r1, int r2, byte[] r3, int r4) {
                this.f39708a = r1;
                this.f39709b = r2;
                this.f39710c = r3;
                this.f39711d = r4;
            }

            @Override // okhttp3.ac
            public x a() {
                return this.f39708a;
            }

            @Override // okhttp3.ac
            public long b() {
                return this.f39709b;
            }

            @Override // okhttp3.ac
            public void a(e.f r3) {
                e.f r4 = (e.f) ZeusTransformUtils.wrapperContextForParams(r3, e.f.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r4, "sink");
                r4.c(this.f39710c, this.f39711d, this.f39709b);
            }
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        public final ac a(x r9, byte[] r10) {
            d.h.b.o.e(r10, "content");
            return a(this, r9, r10, 0, 0, 12, null);
        }

        private a() {
        }

        public final ac a(String r4, x r5) {
            d.h.b.o.e(r4, "<this>");
            Charset r0 = d.o.d.f38623b;
            if (r5 == null) goto L7;
            r0 = x.a(r5, null, 1, null);
            if (r0 != null) goto L7;
            r0 = d.o.d.f38623b;
            r5 = x.f40220a.b(r5 + "; charset=utf-8");
        L7:
            byte[] r6 = r4.getBytes(r0);
            d.h.b.o.c(r6, "this as java.lang.String).getBytes(charset)");
            return a(r6, r5, 0, r6.length);
        }

        public static /* synthetic */ ac a(a r0, byte[] r1, x r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r4 = r1.length;
        L12:
            return r0.a(r1, r2, r3, r4);
        }

        public final ac a(byte[] r7, x r8, int r9, int r10) {
            d.h.b.o.e(r7, "<this>");
            okhttp3.internal.c.a(r7.length, r9, r10);
            return (ac) ZeusTransformUtils.preCheckCast(new C1068a(r8, r10, r7, r9), ac.class, "com.obric.aiagent.plugin");
        }

        public final ac a(x r2, String r3) {
            d.h.b.o.e(r3, "content");
            return a(r3, r2);
        }

        public static /* synthetic */ ac a(a r0, x r1, byte[] r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 4) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r5 & 8) == 0) goto L9;
            r4 = r2.length;
        L9:
            return r0.a(r1, r2, r3, r4);
        }

        public final ac a(x r2, byte[] r3, int r4, int r5) {
            d.h.b.o.e(r3, "content");
            return a(r3, r2, r4, r5);
        }
    }

    static {
        g = new a(null);
    }

    public static final ac a(x r1, String r2) {
        return g.a(r1, r2);
    }

    public static final ac a(x r1, byte[] r2) {
        return g.a(r1, r2);
    }

    public abstract x a();

    public abstract void a(e.f r1);

    public long b() {
        return -1;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public ac() {
    }
}
