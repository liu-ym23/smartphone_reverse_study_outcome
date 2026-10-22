package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes4.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f39421a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f39422b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f39423c = null;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;
    private volatile /* synthetic */ Object _removedRef$volatile;

    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static abstract class a extends kotlinx.coroutines.internal.b<x> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final x f39424c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public x f39425d;

        @Override // kotlinx.coroutines.internal.b
        public /* synthetic */ void a(x r3, Object r4) {
            a2((x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.aiagent.plugin"), r4);
        }

        public a(x r1) {
            this.f39424c = r1;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(x r3, Object r4) {
            if (r4 != null) goto L4;
            boolean r5 = true;
        L5:
            if (r5 == false) goto L7;
            x r0 = this.f39424c;
        L8:
            if (r0 != null) goto L10;
            return;
        L10:
            if (x.j().compareAndSet(r3, this, r0) == false) goto L15;
            if (r5 == false) goto L16;
            x r6 = this.f39424c;
            x r2 = this.f39425d;
            d.h.b.o.a(r2);
            x.a(r6, r2);
            return;
        L16:
            return;
        L15:
            return;
        L7:
            r0 = this.f39425d;
            goto L8
        L4:
            r5 = false;
            goto L5
        }
    }

    static {
        f39421a = AtomicReferenceFieldUpdater.newUpdater(x.class, Object.class, "_next$volatile");
        f39422b = AtomicReferenceFieldUpdater.newUpdater(x.class, Object.class, "_prev$volatile");
        f39423c = AtomicReferenceFieldUpdater.newUpdater(x.class, Object.class, "_removedRef$volatile");
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater k() {
        return f39421a;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater l() {
        return f39422b;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater m() {
        return f39423c;
    }

    public x() {
        this._next$volatile = this;
        this._prev$volatile = this;
    }

    public static final /* synthetic */ void a(x r0, x r1) {
        r0.c(r1);
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater j() {
        return k();
    }

    private final af c() {
        af r0 = (af) ZeusTransformUtils.preCheckCast(m().get(this), af.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        af r1 = new af(this);
        m().set(this, r1);
        return r1;
    L6:
        return r0;
    }

    public boolean d() {
        return ZeusTransformUtils.instanceOf(f(), af.class);
    }

    public final Object f() {
        AtomicReferenceFieldUpdater r0 = k();
    L3:
        Object r1 = r0.get(this);
        if (ZeusTransformUtils.instanceOf(r1, ae.class) == false) goto L5;
        ((ae) ZeusTransformUtils.preCheckCast(r1, ae.class, "com.obric.aiagent.plugin")).b(this);
        goto L3
    L5:
        return r1;
    }

    public final x g() {
        Object r2 = f();
        if (ZeusTransformUtils.instanceOf(r2, af.class) == false) goto L5;
        af r0 = (af) ZeusTransformUtils.preCheckCast(r2, af.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == null) goto L9;
        x r1 = r0.f39361a;
        if (r1 == null) goto L9;
        return r1;
    L9:
        d.h.b.o.a(r2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (x) ZeusTransformUtils.preCheckCast(r2, x.class, "com.obric.aiagent.plugin");
    L5:
        r0 = null;
        goto L6
    }

    public final x h() {
        x r0 = a(null);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return b((x) ZeusTransformUtils.preCheckCast(l().get(this), x.class, "com.obric.aiagent.plugin"));
    }

    private final x b(x r2) {
    L3:
        if (r2.d() == false) goto L4;
        r2 = (x) ZeusTransformUtils.preCheckCast(l().get(r2), x.class, "com.obric.aiagent.plugin");
        goto L3
    L4:
        return r2;
    }

    public final boolean a(x r2) {
        l().set(r2, this);
        k().set(r2, this);
    L4:
        if (f() != this) goto L5;
        if (k().compareAndSet(this, this, r2) == false) goto L4;
        r2.c(this);
        return true;
    L5:
        return false;
    }

    public final int a(x r2, x r3, a r4) {
        l().set(r2, this);
        k().set(r2, r3);
        r4.f39425d = r3;
        if (k().compareAndSet(this, r3, r4) == true) goto L7;
        return 0;
    L7:
        if (r4.b(this) != null) goto L9;
        return 1;
    L9:
        return 2;
    }

    public boolean e() {
        if (i() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final x i() {
    L3:
        Object r1 = f();
        if (ZeusTransformUtils.instanceOf(r1, af.class) == true) goto L6;
        if (r1 == this) goto L9;
        d.h.b.o.a(r1, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        af r2 = ((x) ZeusTransformUtils.preCheckCast(r1, x.class, "com.obric.aiagent.plugin")).c();
        if (k().compareAndSet(this, r1, r2) == false) goto L3;
        ((x) ZeusTransformUtils.preCheckCast(r1, x.class, "com.obric.aiagent.plugin")).a(null);
        return null;
    L9:
        return (x) ZeusTransformUtils.preCheckCast(r1, x.class, "com.obric.aiagent.plugin");
    L6:
        return ((af) ZeusTransformUtils.preCheckCast(r1, af.class, "com.obric.aiagent.plugin")).f39361a;
    }

    private final void c(x r5) {
        AtomicReferenceFieldUpdater r0 = l();
    L3:
        x r1 = (x) ZeusTransformUtils.preCheckCast(r0.get(r5), x.class, "com.obric.aiagent.plugin");
        if (f() != r5) goto L5;
        if (l().compareAndSet(r5, r1, this) == false) goto L3;
        if (d() == false) goto L15;
        r5.a(null);
        return;
    L15:
        return;
    }

    private final x a(ae r11) {
    L3:
        x r1 = (x) ZeusTransformUtils.preCheckCast(l().get(this), x.class, "com.obric.aiagent.plugin");
        x r4 = r1;
    L4:
        x r5 = null;
    L5:
        Object r6 = k().get(r4);
        if (r6 == this) goto L7;
        if (d() == true) goto L15;
        if (r6 == r11) goto L17;
        if (ZeusTransformUtils.instanceOf(r6, ae.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, af.class) == true) goto L23;
        d.h.b.o.a(r6, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        r5 = r4;
        r4 = (x) ZeusTransformUtils.preCheckCast(r6, x.class, "com.obric.aiagent.plugin");
        goto L5
    L23:
        if (r5 != null) goto L25;
        r4 = (x) ZeusTransformUtils.preCheckCast(l().get(r4), x.class, "com.obric.aiagent.plugin");
        goto L5
    L25:
        if (k().compareAndSet(r5, r4, ((af) ZeusTransformUtils.preCheckCast(r6, af.class, "com.obric.aiagent.plugin")).f39361a) == false) goto L3;
        r4 = r5;
        goto L4
    L20:
        ((ae) ZeusTransformUtils.preCheckCast(r6, ae.class, "com.obric.aiagent.plugin")).b(r4);
        goto L3
    L17:
        return r4;
    L15:
        return null;
    L7:
        if (r1 == r4) goto L8;
        if (l().compareAndSet(this, r1, r4) == false) goto L3;
        return r4;
    L8:
        return r4;
    }

    public String toString() {
        return new b(this) + '@' + kotlinx.coroutines.ar.a(this);
    }
}
