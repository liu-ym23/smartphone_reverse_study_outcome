package kotlinx.coroutines.internal;

import Ua.N;
import Za.C1193m;
import Za.w;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0012\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u00042\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0004H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0004H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u001f\u001a\u00060\u0000j\u0002`\u00042\n\u0010\u001e\u001a\u00060\u0000j\u0002`\u0004H\u0082\u0010¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010!\u001a\u00020\u000e2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0004H\u0002¢\u0006\u0004\b!\u0010\"J\u0018\u0010#\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0004H\u0082\u0010¢\u0006\u0004\b#\u0010\u0017R\u0014\u0010%\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0015\u0010)\u001a\u00060\u0000j\u0002`\u00048F¢\u0006\u0006\u001a\u0004\b(\u0010\u0017R\u0015\u0010+\u001a\u00060\u0000j\u0002`\u00048F¢\u0006\u0006\u001a\u0004\b*\u0010\u0017R\u0011\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010,8\u0002X\u0082\u0004R\u0011\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00000,8\u0002X\u0082\u0004R\u0013\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0,8\u0002X\u0082\u0004¨\u00060"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "", Const.INTENT_KEY_UMID, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "", "permissionsBitmask", Const.INTENT_KEY_APIKEY, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;I)Z", "forbiddenElementsBit", "LY8/t;", "f", "(I)V", "next", "c", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "q", "()Z", "r", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "toString", "()Ljava/lang/String;", "LZa/w;", "s", "()LZa/w;", "current", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "p", "isRemoved", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/lang/Object;", "k", "nextNode", "l", "prevNode", "LOa/e;", "_next", "_prev", "_removedRef", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class LockFreeLinkedListNode {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36773a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36774b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36775c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public final boolean a(LockFreeLinkedListNode node, int permissionsBitmask) {
        LockFreeLinkedListNode lockFreeLinkedListNodeL;
        do {
            lockFreeLinkedListNodeL = l();
            if (lockFreeLinkedListNodeL instanceof C1193m) {
                return (((C1193m) lockFreeLinkedListNodeL).forbiddenElementsBitmask & permissionsBitmask) == 0 && lockFreeLinkedListNodeL.a(node, permissionsBitmask);
            }
        } while (!lockFreeLinkedListNodeL.c(node, this));
        return true;
    }

    public final boolean c(LockFreeLinkedListNode node, LockFreeLinkedListNode next) {
        f36774b.set(node, this);
        f36773a.set(node, next);
        if (!f36773a.compareAndSet(this, next, node)) {
            return false;
        }
        node.i(next);
        return true;
    }

    public final boolean d(LockFreeLinkedListNode node) {
        f36774b.set(node, this);
        f36773a.set(node, this);
        while (j() == this) {
            if (f36773a.compareAndSet(this, this, node)) {
                node.i(this);
                return true;
            }
        }
        return false;
    }

    public final void f(int forbiddenElementsBit) {
        a(new C1193m(forbiddenElementsBit), forbiddenElementsBit);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        if (kotlinx.coroutines.internal.LockFreeLinkedListNode.f36773a.compareAndSet(r3, r2, ((Za.w) r4).f7762a) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode g() {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = n()
            java.lang.Object r0 = r0.get(r7)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        Lc:
            r3 = r1
        Ld:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = m()
            java.lang.Object r4 = r4.get(r2)
            if (r4 != r7) goto L26
            if (r0 != r2) goto L1a
            goto L25
        L1a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = n()
            boolean r0 = r1.compareAndSet(r7, r0, r2)
            if (r0 != 0) goto L25
            goto L0
        L25:
            return r2
        L26:
            boolean r5 = r7.p()
            if (r5 == 0) goto L2d
            return r1
        L2d:
            boolean r5 = r4 instanceof Za.w
            if (r5 == 0) goto L4f
            if (r3 == 0) goto L44
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = m()
            Za.w r4 = (Za.w) r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = r4.ref
            boolean r2 = r5.compareAndSet(r3, r2, r4)
            if (r2 != 0) goto L42
            goto L0
        L42:
            r2 = r3
            goto Lc
        L44:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = n()
            java.lang.Object r2 = r4.get(r2)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto Ld
        L4f:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode"
            kotlin.jvm.internal.p.g(r4, r3)
            r3 = r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto Ld
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.g():kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    public final LockFreeLinkedListNode h(LockFreeLinkedListNode current) {
        while (current.p()) {
            current = (LockFreeLinkedListNode) f36774b.get(current);
        }
        return current;
    }

    public final void i(LockFreeLinkedListNode next) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36774b;
        do {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(next);
            if (j() != next) {
                return;
            }
        } while (!f36774b.compareAndSet(next, lockFreeLinkedListNode, this));
        if (p()) {
            next.g();
        }
    }

    public final Object j() {
        return f36773a.get(this);
    }

    public final LockFreeLinkedListNode k() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Object objJ = j();
        w wVar = objJ instanceof w ? (w) objJ : null;
        if (wVar != null && (lockFreeLinkedListNode = wVar.ref) != null) {
            return lockFreeLinkedListNode;
        }
        p.g(objJ, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (LockFreeLinkedListNode) objJ;
    }

    public final LockFreeLinkedListNode l() {
        LockFreeLinkedListNode lockFreeLinkedListNodeG = g();
        return lockFreeLinkedListNodeG == null ? h((LockFreeLinkedListNode) f36774b.get(this)) : lockFreeLinkedListNodeG;
    }

    public boolean p() {
        return j() instanceof w;
    }

    public boolean q() {
        return r() == null;
    }

    public final LockFreeLinkedListNode r() {
        Object objJ;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            objJ = j();
            if (objJ instanceof w) {
                return ((w) objJ).ref;
            }
            if (objJ == this) {
                return (LockFreeLinkedListNode) objJ;
            }
            p.g(objJ, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            lockFreeLinkedListNode = (LockFreeLinkedListNode) objJ;
        } while (!f36773a.compareAndSet(this, objJ, lockFreeLinkedListNode.s()));
        lockFreeLinkedListNode.g();
        return null;
    }

    public final w s() {
        w wVar = (w) f36775c.get(this);
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(this);
        f36775c.set(this, wVar2);
        return wVar2;
    }

    public String toString() {
        return new PropertyReference0Impl(this) { // from class: kotlinx.coroutines.internal.LockFreeLinkedListNode.toString.1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, w9.InterfaceC5753l
            public Object get() {
                return N.a(this.receiver);
            }
        } + '@' + N.b(this);
    }
}
