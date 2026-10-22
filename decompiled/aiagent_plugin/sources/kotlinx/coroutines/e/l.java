package kotlinx.coroutines.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.p;
import d.x;
import kotlinx.coroutines.internal.al;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: Select.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q<Object, Object, Object, Object> f39306a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f39307b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final al f39308c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final al f39309d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final al f39310e = null;
    private static final al f = null;

    /* JADX INFO: compiled from: Select.kt */
    static final class a extends p implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f39311a = null;

        static {
            f39311a = new a();
        }

        a() {
            super(3);
        }

        public final Void a(Object r1, Object r2, Object r3) {
            return null;
        }

        @Override // d.h.a.q
        public /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return a(r1, r2, r3);
        }
    }

    public static final /* synthetic */ m a(int r0) {
        return b(r0);
    }

    public static final /* synthetic */ boolean a(n r2, d.h.a.b r3) {
        return b((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ q b() {
        return f39306a;
    }

    public static final /* synthetic */ al c() {
        return f39307b;
    }

    public static final /* synthetic */ al d() {
        return f39310e;
    }

    public static final /* synthetic */ al e() {
        return f39309d;
    }

    public static final /* synthetic */ al f() {
        return f39308c;
    }

    static {
        f39306a = (q) ZeusTransformUtils.preCheckCast(a.f39311a, q.class, "com.obric.aiagent.plugin");
        f39307b = new al("STATE_REG");
        f39308c = new al("STATE_COMPLETED");
        f39309d = new al("STATE_CANCELLED");
        f39310e = new al("NO_RESULT");
        f = new al("PARAM_CLAUSE_0");
    }

    private static final boolean b(n<? super x> r2, d.h.a.b<? super Throwable, x> r3) {
        n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super Throwable, x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        Object r6 = r4.a(x.f38692a, null, r5);
        if (r6 != null) goto L6;
        return false;
    L6:
        r4.a(r6);
        return true;
    }

    private static final m b(int r3) {
        if (r3 == 0) goto L15;
        if (r3 == 1) goto L18;
        if (r3 == 2) goto L17;
        if (r3 != 3) goto L11;
        return m.f39315d;
    L11:
        throw new IllegalStateException(("Unexpected internal result: " + r3).toString());
    L17:
        return m.f39314c;
    L18:
        return m.f39313b;
    L15:
        return m.f39312a;
    }

    public static final al a() {
        return f;
    }
}
