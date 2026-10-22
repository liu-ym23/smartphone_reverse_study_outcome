package d.n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes4.dex */
class p extends o {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a<T> implements j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f38598a;

        public a(Iterator r3) {
            this.f38598a = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.aiagent.plugin");
        }

        @Override // d.n.j
        public Iterator<T> a() {
            return this.f38598a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    static final class b<T> extends d.h.b.p implements d.h.a.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ T f38599a;

        b(T r1) {
            this.f38599a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public final T invoke() {
            return this.f38599a;
        }
    }

    public static final <T> j<T> a(Iterator<? extends T> r2) {
        Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return m.a((j) ZeusTransformUtils.preCheckCast(new a(r3), j.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> j<T> a(T... r1) {
        d.h.b.o.e(r1, "elements");
        return d.a.i.k(r1);
    }

    public static final <T> j<T> a() {
        return (j) ZeusTransformUtils.preCheckCast(f.f38573a, j.class, "com.obric.aiagent.plugin");
    }

    public static final <T> j<T> a(j<? extends T> r2) {
        j<T> r3 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (ZeusTransformUtils.instanceOf(r3, d.n.a.class) == false) goto L6;
        return r3;
    L6:
        return (j) ZeusTransformUtils.preCheckCast(new d.n.a(r3), j.class, "com.obric.aiagent.plugin");
    }

    public static final <T> j<T> a(T r3, d.h.a.b<? super T, ? extends T> r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "nextFunction");
        if (r3 != null) goto L6;
        return (j) ZeusTransformUtils.preCheckCast(f.f38573a, j.class, "com.obric.aiagent.plugin");
    L6:
        return (j) ZeusTransformUtils.preCheckCast(new i((d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r3), d.h.a.a.class, "com.obric.aiagent.plugin"), r5), j.class, "com.obric.aiagent.plugin");
    }

    public static final <T> j<T> a(d.h.a.a<? extends T> r2, d.h.a.b<? super T, ? extends T> r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "seedFunction");
        d.h.b.o.e(r5, "nextFunction");
        return (j) ZeusTransformUtils.preCheckCast(new i(r4, r5), j.class, "com.obric.aiagent.plugin");
    }
}
