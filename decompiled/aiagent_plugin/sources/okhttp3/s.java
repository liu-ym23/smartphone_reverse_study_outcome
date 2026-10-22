package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: FormBody.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class s extends ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f40190a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final x f40191d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f40192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f40193c;

    /* JADX INFO: compiled from: FormBody.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Charset f40194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f40195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<String> f40196c;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public a(Charset r3) {
            this.f40194a = r3;
            this.f40195b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            this.f40196c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        }

        public /* synthetic */ a(Charset r1, int r2, d.h.b.h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }

        public final a a(String r20, String r21) {
            d.h.b.o.e(r20, "name");
            d.h.b.o.e(r21, "value");
            a r14 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            ((Collection) ZeusTransformUtils.preCheckCast(r14.f40195b, Collection.class, "com.obric.aiagent.plugin")).add(v.b.a(v.f40208a, r20, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, r14.f40194a, 91, null));
            ((Collection) ZeusTransformUtils.preCheckCast(r14.f40196c, Collection.class, "com.obric.aiagent.plugin")).add(v.b.a(v.f40208a, r21, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, r14.f40194a, 91, null));
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final s a() {
            return new s(this.f40195b, this.f40196c);
        }
    }

    /* JADX INFO: compiled from: FormBody.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    public s(List<String> r3, List<String> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "encodedNames");
        d.h.b.o.e(r6, "encodedValues");
        this.f40192b = okhttp3.internal.c.b(r5);
        this.f40193c = okhttp3.internal.c.b(r6);
    }

    @Override // okhttp3.ac
    public x a() {
        return f40191d;
    }

    @Override // okhttp3.ac
    public long b() {
        return a(null, true);
    }

    @Override // okhttp3.ac
    public void a(e.f r3) {
        e.f r4 = (e.f) ZeusTransformUtils.wrapperContextForParams(r3, e.f.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "sink");
        a(r4, false);
    }

    private final long a(e.f r6, boolean r7) {
        e.f r8 = (e.f) ZeusTransformUtils.wrapperContextForParams(r6, e.f.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L5;
        e.e r9 = new e.e();
    L6:
        int r0 = 0;
        int r2 = this.f40192b.size();
    L7:
        if (r0 >= r2) goto L11;
        if (r0 <= 0) goto L10;
        r9.b(38);
    L10:
        r9.a((String) ZeusTransformUtils.preCheckCast(this.f40192b.get(r0), String.class, "com.obric.aiagent.plugin"));
        r9.b(61);
        r9.a((String) ZeusTransformUtils.preCheckCast(this.f40193c.get(r0), String.class, "com.obric.aiagent.plugin"));
        r0 = r0 + 1;
        goto L7
    L11:
        if (r7 == false) goto L13;
        long r1 = r9.b();
        r9.x();
        return r1;
    L13:
        return 0;
    L5:
        d.h.b.o.a(r8);
        r9 = r8.d();
        goto L6
    }

    static {
        f40190a = new b(null);
        f40191d = x.f40220a.a("application/x-www-form-urlencoded");
    }
}
