package d.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;
import d.h.b.p;
import java.io.Serializable;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements g, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f38417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g.b f38418b;

    /* JADX INFO: compiled from: CoroutineContextImpl.kt */
    static final class a extends p implements m<String, g.b, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f38419a = null;

        static {
            f38419a = new a();
        }

        a() {
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ String invoke(String r3, g.b r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (g.b) ZeusTransformUtils.preCheckCast(r4, g.b.class, "com.obric.aiagent.plugin"));
        }

        public final String a(String r2, g.b r3) {
            g.b r1 = (g.b) ZeusTransformUtils.wrapperContextForParams(r3, g.b.class, "com.obric.aiagent.plugin");
            o.e(r2, "acc");
            o.e(r1, "element");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
            boolean r4 = true;
        L6:
            if (r4 == false) goto L9;
            return r1.toString();
        L9:
            return r2 + ", " + r1;
        L5:
            r4 = false;
            goto L6
        }
    }

    public c(g r3, g.b r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        g.b r6 = (g.b) ZeusTransformUtils.wrapperContextForParams(r4, g.b.class, "com.obric.aiagent.plugin");
        o.e(r5, "left");
        o.e(r6, "element");
        this.f38417a = r5;
        this.f38418b = r6;
    }

    @Override // d.c.g
    public g plus(g r3) {
        return g.a.a(this, (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.g
    public <E extends g.b> E get(g.c<E> r4) {
        g.c<E> r5 = (g.c) ZeusTransformUtils.wrapperContextForParams(r4, g.c.class, "com.obric.aiagent.plugin");
        o.e(r5, "key");
    L3:
        E r1 = (E) this.f38418b.get(r5);
        if (r1 != null) goto L5;
        g r3 = this.f38417a;
        if (ZeusTransformUtils.instanceOf(r3, c.class) == false) goto L10;
        c this = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin");
        goto L3
    L10:
        return (E) r3.get(r5);
    L5:
        return r1;
    }

    @Override // d.c.g
    public <R> R fold(R r3, m<? super R, ? super g.b, ? extends R> r4) {
        m<? super R, ? super g.b, ? extends R> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        o.e(r5, "operation");
        return r5.invoke((Object) this.f38417a.fold(r3, r5), this.f38418b);
    }

    @Override // d.c.g
    public g minusKey(g.c<?> r3) {
        g.c<?> r4 = (g.c) ZeusTransformUtils.wrapperContextForParams(r3, g.c.class, "com.obric.aiagent.plugin");
        o.e(r4, "key");
        if (this.f38418b.get(r4) != null) goto L5;
        g r5 = this.f38417a.minusKey(r4);
        if (r5 != this.f38417a) goto L10;
        return (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");
    L10:
        if (r5 != h.f38423a) goto L13;
        return (g) ZeusTransformUtils.preCheckCast(this.f38418b, g.class, "com.obric.aiagent.plugin");
    L13:
        return (g) ZeusTransformUtils.preCheckCast(new c(r5, this.f38418b), g.class, "com.obric.aiagent.plugin");
    L5:
        return this.f38417a;
    }

    private final int a() {
        int r1 = 2;
    L3:
        g r3 = this.f38417a;
        if (ZeusTransformUtils.instanceOf(r3, c.class) == false) goto L6;
        c this = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin");
    L7:
        if (this == null) goto L8;
        r1 = r1 + 1;
        goto L3
    L8:
        return r1;
    L6:
        this = null;
        goto L7
    }

    private final boolean a(g.b r3) {
        g.b r4 = (g.b) ZeusTransformUtils.wrapperContextForParams(r3, g.b.class, "com.obric.aiagent.plugin");
        return o.a(get(r4.getKey()), r4);
    }

    private final boolean a(c r4) {
    L4:
        if (a(r4.f38418b) == false) goto L5;
        g r5 = r4.f38417a;
        if (ZeusTransformUtils.instanceOf(r5, c.class) == false) goto L10;
        r4 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        goto L4
    L10:
        o.a(r5, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        return a((g.b) ZeusTransformUtils.preCheckCast(r5, g.b.class, "com.obric.aiagent.plugin"));
    L5:
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
    L12:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L7;
    L11:
        return false;
    L7:
        if (((c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin")).a() != a()) goto L11;
        if (((c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin")).a(this) == false) goto L11;
        goto L11
    }

    public int hashCode() {
        return this.f38417a.hashCode() + this.f38418b.hashCode();
    }

    public String toString() {
        return '[' + ((String) ZeusTransformUtils.preCheckCast(fold("", (m) ZeusTransformUtils.preCheckCast(a.f38419a, m.class, "com.obric.aiagent.plugin")), String.class, "com.obric.aiagent.plugin")) + ']';
    }
}
