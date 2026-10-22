package kotlinx.coroutines.internal;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.bytedance.apm.constant.PerfConsts;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000fJ%\u0010\u0017\u001a\u00020\t2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019H\u0086\bJ \u0010\u001a\u001a\u00020\t2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0001J\u0012\u0010\u001b\u001a\u00020\t2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000fJ\u001b\u0010\u001c\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0082\u0010J\u0019\u0010\u001f\u001a\u00060\u0000j\u0002`\u000f2\n\u0010 \u001a\u00060\u0000j\u0002`\u000fH\u0082\u0010J\u0014\u0010!\u001a\u00020\u00152\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0002J%\u0010\"\u001a\u00020#2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019H\u0081\bJ\u0010\u0010$\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000fH\u0014J\b\u0010%\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000fH\u0001J\b\u0010'\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020)H\u0016J(\u0010*\u001a\u00020+2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000f2\u0006\u0010,\u001a\u00020#H\u0001J%\u0010-\u001a\u00020\u00152\n\u0010.\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0000¢\u0006\u0002\b/R\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004R\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004X\u0082\u0004R\u0011\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\u00060\u0000j\u0002`\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0012\u001a\u00060\u0000j\u0002`\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u00061"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "()V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "_removedRef", "Lkotlinx/coroutines/internal/Removed;", "isRemoved", "", "()Z", "next", "getNext", "()Ljava/lang/Object;", "nextNode", "Lkotlinx/coroutines/internal/Node;", "getNextNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "prevNode", "getPrevNode", "addLast", "", "node", "addLastIf", "condition", "Lkotlin/Function0;", "addNext", "addOneIfEmpty", "correctPrev", "op", "Lkotlinx/coroutines/internal/OpDescriptor;", "findPrevNonRemoved", PerfConsts.KEY_CURRENT_GALVANIC, "finishAdd", "makeCondAddOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "remove", "removeOrNext", "removed", "toString", "", "tryCondAddNext", "", "condAdd", "validateNode", "prev", "validateNode$kotlinx_coroutines_core", "CondAddOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class LockFreeLinkedListNode {
    private static final AtomicReferenceFieldUpdater _next$FU = null;
    private static final AtomicReferenceFieldUpdater _prev$FU = null;
    private static final AtomicReferenceFieldUpdater _removedRef$FU = null;

    @Volatile
    private volatile Object _next;

    @Volatile
    private volatile Object _prev;

    @Volatile
    private volatile Object _removedRef;

    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        public final LockFreeLinkedListNode newNode;
        public LockFreeLinkedListNode oldNext;

        @Override // kotlinx.coroutines.internal.AtomicOp
        public /* bridge */ /* synthetic */ void complete(LockFreeLinkedListNode r1, Object r2) {
            complete2(r1, r2);
        }

        public CondAddOp(LockFreeLinkedListNode r1) {
            this.newNode = r1;
        }

        /* JADX INFO: renamed from: complete, reason: avoid collision after fix types in other method */
        public void complete2(LockFreeLinkedListNode r3, Object r4) {
            if (r4 != null) goto L4;
            boolean r5 = true;
        L5:
            if (r5 == false) goto L7;
            LockFreeLinkedListNode r0 = this.newNode;
        L8:
            if (r0 != null) goto L10;
            return;
        L10:
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode.access$get_next$FU$p(), r3, this, r0) == false) goto L15;
            if (r5 == false) goto L16;
            LockFreeLinkedListNode r6 = this.newNode;
            LockFreeLinkedListNode r2 = this.oldNext;
            Intrinsics.checkNotNull(r2);
            LockFreeLinkedListNode.access$finishAdd(r6, r2);
            return;
        L16:
            return;
        L15:
            return;
        L7:
            r0 = this.oldNext;
            goto L8
        L4:
            r5 = false;
            goto L5
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.internal.LockFreeLinkedListNode$makeCondAddOp$1, reason: invalid class name */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass1 extends CondAddOp {
        final /* synthetic */ Function0<Boolean> $condition;

        public AnonymousClass1(LockFreeLinkedListNode r1, Function0<Boolean> r2) {
            this.$condition = r2;
            super(r1);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public /* bridge */ /* synthetic */ Object prepare(LockFreeLinkedListNode r1) {
            return prepare2(r1);
        }

        /* JADX INFO: renamed from: prepare, reason: avoid collision after fix types in other method */
        public Object prepare2(LockFreeLinkedListNode r1) {
            if (this.$condition.invoke().booleanValue() == false) goto L6;
            return null;
        L6:
            return LockFreeLinkedListKt.getCONDITION_FALSE();
        }
    }

    static {
        _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
        _prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
        _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater r1, Function1<Object, Unit> r2, Object r3) {
    L2:
        r2.invoke(r1.get(r3));
        goto L2
    }

    public LockFreeLinkedListNode() {
        this._next = this;
        this._prev = this;
    }

    public static final /* synthetic */ void access$finishAdd(LockFreeLinkedListNode r0, LockFreeLinkedListNode r1) {
        r0.finishAdd(r1);
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater access$get_next$FU$p() {
        return _next$FU;
    }

    private final Removed removed() {
        AtomicReferenceFieldUpdater r0 = _removedRef$FU;
        Removed r1 = (Removed) r0.get(this);
        if (r1 != null) goto L6;
        Removed r2 = new Removed(this);
        r0.lazySet(this, r2);
        return r2;
    L6:
        return r1;
    }

    public final CondAddOp makeCondAddOp(LockFreeLinkedListNode r1, Function0<Boolean> r2) {
        return new AnonymousClass1(r1, r2);
    }

    public boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    public final Object getNext() {
        AtomicReferenceFieldUpdater r0 = _next$FU;
    L3:
        Object r1 = r0.get(this);
        if ((r1 instanceof OpDescriptor) == false) goto L5;
        ((OpDescriptor) r1).perform(this);
        goto L3
    L5:
        return r1;
    }

    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(getNext());
    }

    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode r0 = correctPrev(null);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return findPrevNonRemoved((LockFreeLinkedListNode) _prev$FU.get(this));
    }

    private final LockFreeLinkedListNode findPrevNonRemoved(LockFreeLinkedListNode r1) {
    L3:
        if (r1.isRemoved() == false) goto L4;
        r1 = (LockFreeLinkedListNode) _prev$FU.get(r1);
        goto L3
    L4:
        return r1;
    }

    public final boolean addOneIfEmpty(LockFreeLinkedListNode r2) {
        _prev$FU.lazySet(r2, this);
        _next$FU.lazySet(r2, this);
    L4:
        if (getNext() != this) goto L5;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_next$FU, this, this, r2) == false) goto L4;
        r2.finishAdd(this);
        return true;
    L5:
        return false;
    }

    public final void addLast(LockFreeLinkedListNode r2) {
    L3:
        if (getPrevNode().addNext(r2, this) == false) goto L3;
    }

    public final boolean addNext(LockFreeLinkedListNode r2, LockFreeLinkedListNode r3) {
        _prev$FU.lazySet(r2, this);
        AtomicReferenceFieldUpdater r0 = _next$FU;
        r0.lazySet(r2, r3);
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r0, this, r3, r2) == true) goto L6;
        return false;
    L6:
        r2.finishAdd(r3);
        return true;
    }

    public final int tryCondAddNext(LockFreeLinkedListNode r2, LockFreeLinkedListNode r3, CondAddOp r4) {
        _prev$FU.lazySet(r2, this);
        AtomicReferenceFieldUpdater r0 = _next$FU;
        r0.lazySet(r2, r3);
        r4.oldNext = r3;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r0, this, r3, r4) == true) goto L7;
        return 0;
    L7:
        if (r4.perform(this) != null) goto L9;
        return 1;
    L9:
        return 2;
    }

    /* JADX INFO: renamed from: remove */
    public boolean mo2375remove() {
        if (removeOrNext() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final LockFreeLinkedListNode removeOrNext() {
    L2:
        Object r0 = getNext();
        if ((r0 instanceof Removed) == true) goto L5;
        if (r0 == this) goto L8;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r1 = (LockFreeLinkedListNode) r0;
        Removed r2 = r1.removed();
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_next$FU, this, r0, r2) == false) goto L2;
        r1.correctPrev(null);
        return null;
    L8:
        return (LockFreeLinkedListNode) r0;
    L5:
        return ((Removed) r0).ref;
    }

    private final void finishAdd(LockFreeLinkedListNode r4) {
        AtomicReferenceFieldUpdater r0 = _prev$FU;
    L3:
        LockFreeLinkedListNode r1 = (LockFreeLinkedListNode) r0.get(r4);
        if (getNext() != r4) goto L5;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_prev$FU, r4, r1, this) == false) goto L3;
        if (isRemoved() == false) goto L15;
        r4.correctPrev(null);
        return;
    L15:
        return;
    }

    protected LockFreeLinkedListNode nextIfRemoved() {
        Object r2 = getNext();
        if ((r2 instanceof Removed) == false) goto L5;
        Removed r3 = (Removed) r2;
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.ref;
    L5:
        r3 = null;
        goto L6
    }

    private final LockFreeLinkedListNode correctPrev(OpDescriptor r9) {
    L2:
        LockFreeLinkedListNode r0 = (LockFreeLinkedListNode) _prev$FU.get(this);
        LockFreeLinkedListNode r2 = r0;
    L3:
        LockFreeLinkedListNode r3 = null;
    L4:
        AtomicReferenceFieldUpdater r4 = _next$FU;
        Object r5 = r4.get(r2);
        if (r5 == this) goto L6;
        if (isRemoved() == true) goto L14;
        if (r5 == r9) goto L16;
        if ((r5 instanceof OpDescriptor) == true) goto L19;
        if ((r5 instanceof Removed) == true) goto L22;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        r3 = r2;
        r2 = (LockFreeLinkedListNode) r5;
        goto L4
    L22:
        if (r3 != null) goto L24;
        r2 = (LockFreeLinkedListNode) _prev$FU.get(r2);
        goto L4
    L24:
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r4, r3, r2, ((Removed) r5).ref) == false) goto L2;
        r2 = r3;
        goto L3
    L19:
        ((OpDescriptor) r5).perform(r2);
        goto L2
    L16:
        return r2;
    L14:
        return null;
    L6:
        if (r0 == r2) goto L7;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(_prev$FU, this, r0, r2) == false) goto L2;
        return r2;
    L7:
        return r2;
    }

    public final void validateNode$kotlinx_coroutines_core(LockFreeLinkedListNode r4, LockFreeLinkedListNode r5) {
        boolean r1 = true;
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L13;
        if (r4 != _prev$FU.get(this)) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L13;
        throw new AssertionError();
    L7:
        r6 = false;
    L13:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L15;
        return;
    L15:
        if (r5 == _next$FU.get(this)) goto L18;
        r1 = false;
    L18:
        if (r1 == false) goto L21;
        return;
    L21:
        throw new AssertionError();
    }

    public String toString() {
        return new C05811(this) + '@' + DebugStringsKt.getHexAddress(this);
    }

    public final boolean addLastIf(LockFreeLinkedListNode r3, Function0<Boolean> r4) {
        AnonymousClass1 r0 = new AnonymousClass1(r3, r4);
    L3:
        int r5 = getPrevNode().tryCondAddNext(r3, this, r0);
        if (r5 == 1) goto L10;
        if (r5 != 2) goto L3;
        return false;
    L10:
        return true;
    }
}
