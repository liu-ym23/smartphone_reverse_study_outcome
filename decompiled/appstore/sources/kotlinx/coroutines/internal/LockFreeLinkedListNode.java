package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class LockFreeLinkedListNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21567a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21568b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21569c = null;

    @Volatile
    @Nullable
    private volatile Object _next;

    @Volatile
    @Nullable
    private volatile Object _prev;

    @Volatile
    @Nullable
    private volatile Object _removedRef;

    public static abstract class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LockFreeLinkedListNode f21570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public LockFreeLinkedListNode f21571c;

        public a(LockFreeLinkedListNode r10) {
            this.f21570b = r10;
        }

        @Override // kotlinx.coroutines.internal.b
        public /* bridge */ /* synthetic */ void b(Object r10, Object r11) {
            e((LockFreeLinkedListNode) r10, r11);
        }

        public void e(LockFreeLinkedListNode r10, Object r11) {
            if (r11 != null) goto L4;
            boolean r12 = true;
        L5:
            if (r12 == false) goto L7;
            LockFreeLinkedListNode r13 = this.f21570b;
        L8:
            if (r13 != null) goto L10;
            return;
        L10:
            if (androidx.concurrent.futures.a.a(LockFreeLinkedListNode.b(), r10, this, r13) == false) goto L15;
            if (r12 == false) goto L16;
            LockFreeLinkedListNode r14 = this.f21570b;
            LockFreeLinkedListNode r15 = this.f21571c;
            kotlin.jvm.internal.q.d(r15);
            LockFreeLinkedListNode.a(r14, r15);
            return;
        L16:
            return;
        L15:
            return;
        L7:
            r13 = this.f21571c;
            goto L8
        L4:
            r12 = false;
            goto L5
        }
    }

    static {
        f21567a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
        f21568b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
        f21569c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    }

    public LockFreeLinkedListNode() {
        this._next = this;
        this._prev = this;
    }

    public static final /* synthetic */ void a(LockFreeLinkedListNode r10, LockFreeLinkedListNode r11) {
        r10.f(r11);
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater b() {
        return f21567a;
    }

    public final boolean c(LockFreeLinkedListNode r10) {
        f21568b.lazySet(r10, this);
        f21567a.lazySet(r10, this);
    L4:
        if (g() != this) goto L5;
        if (androidx.concurrent.futures.a.a(f21567a, this, this, r10) == false) goto L4;
        r10.f(this);
        return true;
    L5:
        return false;
    }

    public final LockFreeLinkedListNode d(u r10) {
    L2:
        LockFreeLinkedListNode r11 = (LockFreeLinkedListNode) f21568b.get(this);
        LockFreeLinkedListNode r12 = r11;
    L3:
        LockFreeLinkedListNode r13 = null;
    L4:
        AtomicReferenceFieldUpdater r14 = f21567a;
        Object r15 = r14.get(r12);
        if (r15 == this) goto L6;
        if (j() == true) goto L14;
        if (r15 == r10) goto L16;
        if ((r15 instanceof u) == true) goto L19;
        if ((r15 instanceof v) == true) goto L22;
        kotlin.jvm.internal.q.e(r15, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        r13 = r12;
        r12 = (LockFreeLinkedListNode) r15;
        goto L4
    L22:
        if (r13 != null) goto L24;
        r12 = (LockFreeLinkedListNode) f21568b.get(r12);
        goto L4
    L24:
        if (androidx.concurrent.futures.a.a(r14, r13, r12, ((v) r15).f21627a) == false) goto L2;
        r12 = r13;
        goto L3
    L19:
        ((u) r15).a(r12);
        goto L2
    L16:
        return r12;
    L14:
        return null;
    L6:
        if (r11 == r12) goto L7;
        if (androidx.concurrent.futures.a.a(f21568b, this, r11, r12) == false) goto L2;
        return r12;
    L7:
        return r12;
    }

    public final LockFreeLinkedListNode e(LockFreeLinkedListNode r10) {
    L3:
        if (r10.j() == false) goto L4;
        r10 = (LockFreeLinkedListNode) f21568b.get(r10);
        goto L3
    L4:
        return r10;
    }

    public final void f(LockFreeLinkedListNode r10) {
        AtomicReferenceFieldUpdater r11 = f21568b;
    L3:
        LockFreeLinkedListNode r12 = (LockFreeLinkedListNode) r11.get(r10);
        if (g() != r10) goto L5;
        if (androidx.concurrent.futures.a.a(f21568b, r10, r12, this) == false) goto L3;
        if (j() == false) goto L15;
        r10.d(null);
        return;
    L15:
        return;
    }

    public final Object g() {
        AtomicReferenceFieldUpdater r10 = f21567a;
    L3:
        Object r11 = r10.get(this);
        if ((r11 instanceof u) == false) goto L5;
        ((u) r11).a(this);
        goto L3
    L5:
        return r11;
    }

    public final LockFreeLinkedListNode h() {
        return o.b(g());
    }

    public final LockFreeLinkedListNode i() {
        LockFreeLinkedListNode r10 = d(null);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return e((LockFreeLinkedListNode) f21568b.get(this));
    }

    public boolean j() {
        return g() instanceof v;
    }

    public boolean k() {
        if (l() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final LockFreeLinkedListNode l() {
    L2:
        Object r10 = g();
        if ((r10 instanceof v) == true) goto L5;
        if (r10 == this) goto L8;
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r11 = (LockFreeLinkedListNode) r10;
        v r12 = r11.m();
        if (androidx.concurrent.futures.a.a(f21567a, this, r10, r12) == false) goto L2;
        r11.d(null);
        return null;
    L8:
        return (LockFreeLinkedListNode) r10;
    L5:
        return ((v) r10).f21627a;
    }

    public final v m() {
        AtomicReferenceFieldUpdater r10 = f21569c;
        v r11 = (v) r10.get(this);
        if (r11 != null) goto L6;
        v r12 = new v(this);
        r10.lazySet(this, r12);
        return r12;
    L6:
        return r11;
    }

    public final int n(LockFreeLinkedListNode r10, LockFreeLinkedListNode r11, a r12) {
        f21568b.lazySet(r10, this);
        AtomicReferenceFieldUpdater r13 = f21567a;
        r13.lazySet(r10, r11);
        r12.f21571c = r11;
        if (androidx.concurrent.futures.a.a(r13, this, r11, r12) == true) goto L7;
        return 0;
    L7:
        if (r12.a(this) != null) goto L9;
        return 1;
    L9:
        return 2;
    }

    public String toString() {
        return new AnonymousClass1(this) + '@' + kotlinx.coroutines.e0.b(this);
    }
}
