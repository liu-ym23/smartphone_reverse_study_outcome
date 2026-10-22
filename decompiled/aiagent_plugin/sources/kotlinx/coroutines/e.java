package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: Await.kt */
/* JADX INFO: loaded from: classes4.dex */
final class e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f39269b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final au<T>[] f39270a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    /* JADX INFO: compiled from: Await.kt */
    private final class a extends ch {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f39271e = null;
        private volatile /* synthetic */ Object _disposer$volatile;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public bf f39272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e<T> f39273b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final n<List<? extends T>> f39274d;

        static {
            f39271e = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer$volatile");
        }

        private static final /* synthetic */ AtomicReferenceFieldUpdater k() {
            return f39271e;
        }

        public a(e r3, n<? super List<? extends T>> r4) {
            n<List<? extends T>> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
            this.f39273b = r3;
            this.f39274d = r5;
        }

        public final bf a() {
            bf r0 = this.f39272a;
            if (r0 == null) goto L5;
            return r0;
        L5:
            d.h.b.o.c("handle");
            return null;
        }

        public final void a(bf r3) {
            this.f39272a = (bf) ZeusTransformUtils.wrapperContextForParams(r3, bf.class, "com.obric.aiagent.plugin");
        }

        public final e<T>.b b() {
            return (b) ZeusTransformUtils.preCheckCast(k().get(this), b.class, "com.obric.aiagent.plugin");
        }

        public final void a(e<T>.b r2) {
            k().set(this, r2);
        }

        @Override // kotlinx.coroutines.bw
        public void a(Throwable r6) {
            if (r6 == null) goto L9;
            Object r7 = this.f39274d.a(r6);
            if (r7 == null) goto L16;
            this.f39274d.a(r7);
            e<T>.b r5 = b();
            if (r5 == null) goto L17;
            r5.a();
            return;
        L17:
            return;
        L16:
            return;
        L9:
            if (e.a().decrementAndGet(this.f39273b) != 0) goto L19;
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f39274d, d.c.d.class, "com.obric.aiagent.plugin");
            au[] r9 = e.a(this.f39273b);
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r9.length), Collection.class, "com.obric.aiagent.plugin");
            int r2 = 0;
            int r3 = r9.length;
        L11:
            if (r2 >= r3) goto L13;
            r0.add(r9[r2].f());
            r2 = r2 + 1;
            goto L11
        L13:
            List r10 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
            d.n.a r1 = d.n.f38560a;
            r8.resumeWith(d.n.f(r10));
            return;
        }
    }

    /* JADX INFO: compiled from: Await.kt */
    private final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e<T> f39275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e<T>.a[] f39276b;

        public b(e r1, e<T>.a[] r2) {
            this.f39275a = r1;
            this.f39276b = r2;
        }

        public final void a() {
            e<T>.a[] r3 = this.f39276b;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].a().dispose();
            r1 = r1 + 1;
            goto L3
        }

        @Override // kotlinx.coroutines.m
        public void a(Throwable r1) {
            a();
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f39276b + ']';
        }
    }

    static {
        f39269b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount$volatile");
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater b() {
        return f39269b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(au<? extends T>[] r1) {
        this.f39270a = r1;
        this.notCompletedCount$volatile = r1.length;
    }

    public static final /* synthetic */ AtomicIntegerFieldUpdater a() {
        return b();
    }

    public static final /* synthetic */ au[] a(e r0) {
        return r0.f39270a;
    }

    public final Object a(d.c.d<? super List<? extends T>> r18) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        o r3 = new o(d.c.a.b.a(r1), 1);
        r3.e();
        n r4 = (n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.aiagent.plugin");
        int r5 = a(this).length;
        a[] r6 = new a[r5];
        int r7 = 0;
        int r8 = 0;
    L3:
        if (r8 >= r5) goto L5;
        au r9 = a(this)[r8];
        r9.s_();
        a r10 = new a(this, r4);
        r10.a(ce.a((ca) ZeusTransformUtils.preCheckCast(r9, ca.class, "com.obric.aiagent.plugin"), false, false, (bw) ZeusTransformUtils.preCheckCast(r10, bw.class, "com.obric.aiagent.plugin"), 3, null));
        d.x r11 = d.x.f38692a;
        r6[r8] = r10;
        r8 = r8 + 1;
        goto L3
    L5:
        e<T>.b r12 = new b(this, r6);
    L6:
        if (r7 >= r5) goto L9;
        r6[r7].a(r12);
        r7 = r7 + 1;
        goto L6
    L9:
        if (r4.b() == false) goto L11;
        r12.a();
    L12:
        Object r0 = r3.h();
        if (r0 != d.c.a.b.a()) goto L15;
        d.c.b.a.h.c(r1);
    L15:
        return r0;
    L11:
        q.a(r4, (m) ZeusTransformUtils.preCheckCast(r12, m.class, "com.obric.aiagent.plugin"));
        goto L12
    }
}
