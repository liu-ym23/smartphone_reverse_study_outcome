package io.ktor.util.internal;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001:\u0004NOPQB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\t2\n\u0010\b\u001a\u00060\u0000j\u0002`\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\t2\n\u0010\b\u001a\u00060\u0000j\u0002`\u0007H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0013\u0010\r\u001a\u00060\u0000j\u0002`\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00060\u0000j\u0002`\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ-\u0010\u0013\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00072\n\u0010\u0010\u001a\u00060\u0000j\u0002`\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u001a\u001a\u00020\u00192\n\u0010\u0015\u001a\u00060\u0000j\u0002`\u00072\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0081\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00172\n\u0010\u0015\u001a\u00060\u0000j\u0002`\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\t2\n\u0010\u0015\u001a\u00060\u0000j\u0002`\u0007¢\u0006\u0004\b\u001e\u0010\u000bJ)\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 \"\f\b\u0000\u0010\u001f*\u00060\u0000j\u0002`\u00072\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0004\b!\u0010\"J/\u0010#\u001a\u00020\u00172\n\u0010\u0015\u001a\u00060\u0000j\u0002`\u00072\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010$J7\u0010'\u001a\u00020\u00172\n\u0010\u0015\u001a\u00060\u0000j\u0002`\u00072\u0016\u0010&\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0007\u0012\u0004\u0012\u00020\u00170%H\u0086\bø\u0001\u0000¢\u0006\u0004\b'\u0010(JG\u0010)\u001a\u00020\u00172\n\u0010\u0015\u001a\u00060\u0000j\u0002`\u00072\u0016\u0010&\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0007\u0012\u0004\u0012\u00020\u00170%2\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0086\bø\u0001\u0000¢\u0006\u0004\b)\u0010*J'\u0010+\u001a\u00020\u00172\n\u0010\u0015\u001a\u00060\u0000j\u0002`\u00072\n\u0010\b\u001a\u00060\u0000j\u0002`\u0007H\u0001¢\u0006\u0004\b+\u0010,J/\u0010/\u001a\u00020.2\n\u0010\u0015\u001a\u00060\u0000j\u0002`\u00072\n\u0010\b\u001a\u00060\u0000j\u0002`\u00072\u0006\u0010-\u001a\u00020\u0019H\u0001¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0017H\u0016¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\t¢\u0006\u0004\b3\u0010\u0003J\u0011\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b5\u00106J\u0015\u00107\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b7\u0010\u000eJ\u0017\u00109\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u000708¢\u0006\u0004\b9\u0010:J\u001a\u0010;\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001f\u0018\u0001H\u0086\b¢\u0006\u0004\b;\u0010<J1\u0010=\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001f\u0018\u00012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170%H\u0086\bø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\tH\u0001¢\u0006\u0004\b?\u0010\u0003J'\u0010C\u001a\u00020\t2\n\u0010@\u001a\u00060\u0000j\u0002`\u00072\n\u0010\b\u001a\u00060\u0000j\u0002`\u0007H\u0000¢\u0006\u0004\bA\u0010BJ\u000f\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FR\u0011\u0010G\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\bG\u00102R\u0011\u0010\b\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\bH\u0010<R\u0015\u0010J\u001a\u00060\u0000j\u0002`\u00078F¢\u0006\u0006\u001a\u0004\bI\u0010\u000eR\u0011\u0010@\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\bK\u0010<R\u0015\u0010M\u001a\u00060\u0000j\u0002`\u00078F¢\u0006\u0006\u001a\u0004\bL\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006R"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode;", "", "<init>", "()V", "Lio/ktor/util/internal/Removed;", "removed", "()Lio/ktor/util/internal/Removed;", "Lio/ktor/util/internal/Node;", "next", "LY8/t;", "finishAdd", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "finishRemove", "markPrev", "()Lio/ktor/util/internal/LockFreeLinkedListNode;", "findHead", "_prev", "Lio/ktor/util/internal/OpDescriptor;", "op", "correctPrev", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/OpDescriptor;)Lio/ktor/util/internal/LockFreeLinkedListNode;", "node", "Lkotlin/Function0;", "", "condition", "Lio/ktor/util/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lp9/a;)Lio/ktor/util/internal/LockFreeLinkedListNode$CondAddOp;", "addOneIfEmpty", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)Z", "addLast", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)Lio/ktor/util/internal/LockFreeLinkedListNode$AddLastDesc;", "addLastIf", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lp9/a;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lp9/l;)Z", "addLastIfPrevAndIf", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lp9/l;Lp9/a;)Z", "addNext", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)Z", "condAdd", "", "tryCondAddNext", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode$CondAddOp;)I", "remove", "()Z", "helpRemove", "Lio/ktor/util/internal/AtomicDesc;", "describeRemove", "()Lio/ktor/util/internal/AtomicDesc;", "removeFirstOrNull", "Lio/ktor/util/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lio/ktor/util/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "removeFirstIfIsInstanceOf", "()Ljava/lang/Object;", "removeFirstIfIsInstanceOfOrPeekIf", "(Lp9/l;)Ljava/lang/Object;", "helpDelete", "prev", "validateNode$ktor_utils", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "validateNode", "", "toString", "()Ljava/lang/String;", "isRemoved", "getNext", "getNextNode", "nextNode", "getPrev", "getPrevNode", "prevNode", "CondAddOp", "AddLastDesc", "RemoveFirstDesc", "AbstractAtomicDesc", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public class LockFreeLinkedListNode {
    static final /* synthetic */ AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
    static final /* synthetic */ AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
    private static final /* synthetic */ AtomicReferenceFieldUpdater removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object removedRef = null;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\tJ%\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\u0010\n\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0010\u001a\u00020\u000f2\n\u0010\n\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\u0010\n\u001a\u00060\u0006j\u0002`\u00072\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007H$¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0014\u001a\u00020\u000b2\n\u0010\n\u001a\u00060\u0006j\u0002`\u00072\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007H$¢\u0006\u0004\b\u0014\u0010\u0013J'\u0010\u0016\u001a\u00020\u00152\n\u0010\n\u001a\u00060\u0006j\u0002`\u00072\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007H$¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001b\u001a\u00020\u00152\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078$X¤\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u0006#"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lio/ktor/util/internal/AtomicDesc;", "<init>", "()V", "Lio/ktor/util/internal/OpDescriptor;", "op", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "takeAffectedNode", "(Lio/ktor/util/internal/OpDescriptor;)Lio/ktor/util/internal/LockFreeLinkedListNode;", "affected", "", "next", "failure", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Ljava/lang/Object;", "", "retry", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "onPrepare", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "updatedNext", "LY8/t;", "finishOnSuccess", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "Lio/ktor/util/internal/AtomicOp;", "prepare", "(Lio/ktor/util/internal/AtomicOp;)Ljava/lang/Object;", "complete", "(Lio/ktor/util/internal/AtomicOp;Ljava/lang/Object;)V", "getAffectedNode", "()Lio/ktor/util/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "PrepareOp", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class AbstractAtomicDesc extends AtomicDesc {

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B-\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u001e\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc$PrepareOp;", "Lio/ktor/util/internal/OpDescriptor;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "next", "Lio/ktor/util/internal/AtomicOp;", "op", "Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", Const.JSON_KEY_DESC, "<init>", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/AtomicOp;Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;)V", "", "affected", "perform", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/AtomicOp;", "Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class PrepareOp extends OpDescriptor {
            public final AbstractAtomicDesc desc;
            public final LockFreeLinkedListNode next;
            public final AtomicOp<LockFreeLinkedListNode> op;

            /* JADX WARN: Multi-variable type inference failed */
            public PrepareOp(LockFreeLinkedListNode next, AtomicOp<? super LockFreeLinkedListNode> op, AbstractAtomicDesc desc) {
                p.i(next, "next");
                p.i(op, "op");
                p.i(desc, "desc");
                this.next = next;
                this.op = op;
                this.desc = desc;
            }

            @Override // io.ktor.util.internal.OpDescriptor
            public Object perform(Object affected) {
                p.g(affected, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) affected;
                Object objOnPrepare = this.desc.onPrepare(lockFreeLinkedListNode, this.next);
                if (objOnPrepare == null) {
                    LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, this.op.isDecided() ? this.next : this.op);
                    return null;
                }
                if (objOnPrepare == LockFreeLinkedListKt.REMOVE_PREPARED) {
                    if (LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, this.next.removed())) {
                        lockFreeLinkedListNode.helpDelete();
                    }
                    return objOnPrepare;
                }
                this.op.tryDecide(objOnPrepare);
                LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, this.next);
                return objOnPrepare;
            }
        }

        @Override // io.ktor.util.internal.AtomicDesc
        public final void complete(AtomicOp<?> op, Object failure) {
            p.i(op, "op");
            boolean z10 = failure == null;
            LockFreeLinkedListNode this$0 = getThis$0();
            if (this$0 == null) {
                if (z10) {
                    throw new IllegalStateException("Check failed.");
                }
                return;
            }
            LockFreeLinkedListNode queue = getQueue();
            if (queue == null) {
                if (z10) {
                    throw new IllegalStateException("Check failed.");
                }
            } else {
                if (LockFreeLinkedListNode._next$FU.compareAndSet(this$0, op, z10 ? updatedNext(this$0, queue) : queue) && z10) {
                    finishOnSuccess(this$0, queue);
                }
            }
        }

        public Object failure(LockFreeLinkedListNode affected, Object next) {
            p.i(affected, "affected");
            p.i(next, "next");
            return null;
        }

        public abstract void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next);

        /* renamed from: getAffectedNode */
        public abstract LockFreeLinkedListNode getThis$0();

        /* renamed from: getOriginalNext */
        public abstract LockFreeLinkedListNode getQueue();

        public abstract Object onPrepare(LockFreeLinkedListNode affected, LockFreeLinkedListNode next);

        @Override // io.ktor.util.internal.AtomicDesc
        public final Object prepare(AtomicOp<?> op) {
            Object objPerform;
            p.i(op, "op");
            while (true) {
                LockFreeLinkedListNode lockFreeLinkedListNodeTakeAffectedNode = takeAffectedNode(op);
                Object obj = lockFreeLinkedListNodeTakeAffectedNode._next;
                if (obj == op || op.isDecided()) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(lockFreeLinkedListNodeTakeAffectedNode);
                } else {
                    Object objFailure = failure(lockFreeLinkedListNodeTakeAffectedNode, obj);
                    if (objFailure != null) {
                        return objFailure;
                    }
                    if (retry(lockFreeLinkedListNodeTakeAffectedNode, obj)) {
                        continue;
                    } else {
                        p.g(obj, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
                        PrepareOp prepareOp = new PrepareOp((LockFreeLinkedListNode) obj, op, this);
                        if (LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNodeTakeAffectedNode, obj, prepareOp) && (objPerform = prepareOp.perform(lockFreeLinkedListNodeTakeAffectedNode)) != LockFreeLinkedListKt.REMOVE_PREPARED) {
                            return objPerform;
                        }
                    }
                }
            }
        }

        public boolean retry(LockFreeLinkedListNode affected, Object next) {
            p.i(affected, "affected");
            p.i(next, "next");
            return false;
        }

        public LockFreeLinkedListNode takeAffectedNode(OpDescriptor op) {
            p.i(op, "op");
            LockFreeLinkedListNode this$0 = getThis$0();
            p.f(this$0);
            return this$0;
        }

        public abstract Object updatedNext(LockFreeLinkedListNode affected, LockFreeLinkedListNode next);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0003*\u00060\u0001j\u0002`\u00022\u00020\u0004B\u001b\u0012\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00020\u00102\n\u0010\r\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\u0010\r\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000f\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\u00020\u000e2\n\u0010\r\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000f\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u0015\u0010\u0014J'\u0010\u0017\u001a\u00020\u00162\n\u0010\r\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000f\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u0017\u0010\bR\u0018\u0010\u0005\u001a\u00060\u0001j\u0002`\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u0006\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u001c\u0010\u001b\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u00060\u0001j\u0002`\u00028DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a¨\u0006\u001e"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode$AddLastDesc;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "queue", "node", "<init>", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "Lio/ktor/util/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lio/ktor/util/internal/OpDescriptor;)Lio/ktor/util/internal/LockFreeLinkedListNode;", "affected", "", "next", "", "retry", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "onPrepare", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "updatedNext", "LY8/t;", "finishOnSuccess", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "getAffectedNode", "()Lio/ktor/util/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static class AddLastDesc<T extends LockFreeLinkedListNode> extends AbstractAtomicDesc {
        private static final /* synthetic */ AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");
        private volatile /* synthetic */ Object _affectedNode;
        public final T node;
        public final LockFreeLinkedListNode queue;

        public AddLastDesc(LockFreeLinkedListNode queue, T node) {
            p.i(queue, "queue");
            p.i(node, "node");
            this.queue = queue;
            this.node = node;
            if (node._next != node || node._prev != node) {
                throw new IllegalStateException("Check failed.");
            }
            this._affectedNode = null;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            p.i(affected, "affected");
            p.i(next, "next");
            this.node.finishAdd(this.queue);
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        /* renamed from: getAffectedNode */
        public final LockFreeLinkedListNode getThis$0() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        /* renamed from: getOriginalNext, reason: from getter */
        public final LockFreeLinkedListNode getQueue() {
            return this.queue;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object onPrepare(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            p.i(affected, "affected");
            p.i(next, "next");
            _affectedNode$FU.compareAndSet(this, null, affected);
            return null;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public boolean retry(LockFreeLinkedListNode affected, Object next) {
            p.i(affected, "affected");
            p.i(next, "next");
            return next != this.queue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        
            return r0;
         */
        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final io.ktor.util.internal.LockFreeLinkedListNode takeAffectedNode(io.ktor.util.internal.OpDescriptor r5) {
            /*
                r4 = this;
                java.lang.String r0 = "op"
                kotlin.jvm.internal.p.i(r5, r0)
            L5:
                io.ktor.util.internal.LockFreeLinkedListNode r0 = r4.queue
                java.lang.Object r0 = r0._prev
                java.lang.String r1 = "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode"
                kotlin.jvm.internal.p.g(r0, r1)
                io.ktor.util.internal.LockFreeLinkedListNode r0 = (io.ktor.util.internal.LockFreeLinkedListNode) r0
                java.lang.Object r1 = r0._next
                io.ktor.util.internal.LockFreeLinkedListNode r2 = r4.queue
                if (r1 != r2) goto L17
                goto L19
            L17:
                if (r1 != r5) goto L1a
            L19:
                return r0
            L1a:
                boolean r3 = r1 instanceof io.ktor.util.internal.OpDescriptor
                if (r3 == 0) goto L24
                io.ktor.util.internal.OpDescriptor r1 = (io.ktor.util.internal.OpDescriptor) r1
                r1.perform(r0)
                goto L5
            L24:
                io.ktor.util.internal.LockFreeLinkedListNode r0 = io.ktor.util.internal.LockFreeLinkedListNode.access$correctPrev(r2, r0, r5)
                if (r0 == 0) goto L5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.internal.LockFreeLinkedListNode.AddLastDesc.takeAffectedNode(io.ktor.util.internal.OpDescriptor):io.ktor.util.internal.LockFreeLinkedListNode");
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object updatedNext(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            p.i(affected, "affected");
            p.i(next, "next");
            T t10 = this.node;
            LockFreeLinkedListNode._prev$FU.compareAndSet(t10, t10, affected);
            T t11 = this.node;
            LockFreeLinkedListNode._next$FU.compareAndSet(t11, t11, this.queue);
            return this.node;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\n2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\rR\u001e\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode$CondAddOp;", "Lio/ktor/util/internal/AtomicOp;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "newNode", "<init>", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "affected", "", "failure", "LY8/t;", "complete", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)V", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "oldNext", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        public final LockFreeLinkedListNode newNode;
        public LockFreeLinkedListNode oldNext;

        public CondAddOp(LockFreeLinkedListNode newNode) {
            p.i(newNode, "newNode");
            this.newNode = newNode;
        }

        @Override // io.ktor.util.internal.AtomicOp
        public void complete(LockFreeLinkedListNode affected, Object failure) {
            p.i(affected, "affected");
            boolean z10 = failure == null;
            LockFreeLinkedListNode lockFreeLinkedListNode = z10 ? this.newNode : this.oldNext;
            if (lockFreeLinkedListNode != null && LockFreeLinkedListNode._next$FU.compareAndSet(affected, this, lockFreeLinkedListNode) && z10) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = this.newNode;
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.oldNext;
                p.f(lockFreeLinkedListNode3);
                lockFreeLinkedListNode2.finishAdd(lockFreeLinkedListNode3);
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\t\u001a\u00020\bH\u0004¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\u00122\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0004¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0017\u001a\u0004\u0018\u00010\r2\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u000e\u001a\u00060\u0003j\u0002`\u0004H\u0004¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\r2\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u000e\u001a\u00060\u0003j\u0002`\u0004H\u0004¢\u0006\u0004\b\u0019\u0010\u0018J'\u0010\u001b\u001a\u00020\u001a2\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u000e\u001a\u00060\u0003j\u0002`\u0004H\u0004¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0005\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0017\u0010\"\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001c\u0010'\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$¨\u0006("}, d2 = {"Lio/ktor/util/internal/LockFreeLinkedListNode$RemoveFirstDesc;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "queue", "<init>", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "Lio/ktor/util/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lio/ktor/util/internal/OpDescriptor;)Lio/ktor/util/internal/LockFreeLinkedListNode;", "affected", "", "next", "failure", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Ljava/lang/Object;", "node", "", "validatePrepared", "(Ljava/lang/Object;)Z", "retry", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "onPrepare", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "updatedNext", "LY8/t;", "finishOnSuccess", "(Lio/ktor/util/internal/LockFreeLinkedListNode;Lio/ktor/util/internal/LockFreeLinkedListNode;)V", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "getResult", "()Ljava/lang/Object;", "getResult$annotations", "()V", "result", "getAffectedNode", "()Lio/ktor/util/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {
        private static final /* synthetic */ AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_affectedNode");
        private static final /* synthetic */ AtomicReferenceFieldUpdater _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_originalNext");
        private volatile /* synthetic */ Object _affectedNode;
        private volatile /* synthetic */ Object _originalNext;
        public final LockFreeLinkedListNode queue;

        public RemoveFirstDesc(LockFreeLinkedListNode queue) {
            p.i(queue, "queue");
            this.queue = queue;
            this._affectedNode = null;
            this._originalNext = null;
        }

        public static /* synthetic */ void getResult$annotations() {
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object failure(LockFreeLinkedListNode affected, Object next) {
            p.i(affected, "affected");
            p.i(next, "next");
            if (affected == this.queue) {
                return LockFreeLinkedListKt.getLIST_EMPTY();
            }
            return null;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            p.i(affected, "affected");
            p.i(next, "next");
            affected.finishRemove(next);
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        /* renamed from: getAffectedNode */
        public final LockFreeLinkedListNode getThis$0() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        /* renamed from: getOriginalNext */
        public final LockFreeLinkedListNode getQueue() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        public final T getResult() {
            T t10 = (T) getThis$0();
            p.f(t10);
            return t10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object onPrepare(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            p.i(affected, "affected");
            p.i(next, "next");
            if (affected instanceof LockFreeLinkedListHead) {
                throw new IllegalStateException("Check failed.");
            }
            if (!validatePrepared(affected)) {
                return LockFreeLinkedListKt.REMOVE_PREPARED;
            }
            _affectedNode$FU.compareAndSet(this, null, affected);
            _originalNext$FU.compareAndSet(this, null, next);
            return null;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final boolean retry(LockFreeLinkedListNode affected, Object next) {
            p.i(affected, "affected");
            p.i(next, "next");
            if (!(next instanceof Removed)) {
                return false;
            }
            affected.helpDelete();
            return true;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode takeAffectedNode(OpDescriptor op) {
            p.i(op, "op");
            Object next = this.queue.getNext();
            p.g(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            return (LockFreeLinkedListNode) next;
        }

        @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object updatedNext(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            p.i(affected, "affected");
            p.i(next, "next");
            return next.removed();
        }

        public boolean validatePrepared(T node) {
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"io/ktor/util/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lio/ktor/util/internal/LockFreeLinkedListNode$CondAddOp;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lio/ktor/util/internal/Node;", "affected", "", "prepare", "(Lio/ktor/util/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 176)
    /* renamed from: io.ktor.util.internal.LockFreeLinkedListNode$makeCondAddOp$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44191 extends CondAddOp {
        final /* synthetic */ InterfaceC5063a<Boolean> $condition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C44191(LockFreeLinkedListNode lockFreeLinkedListNode, InterfaceC5063a<Boolean> interfaceC5063a) {
            super(lockFreeLinkedListNode);
            this.$condition = interfaceC5063a;
        }

        @Override // io.ktor.util.internal.AtomicOp
        public Object prepare(LockFreeLinkedListNode affected) {
            p.i(affected, "affected");
            if (this.$condition.invoke().booleanValue()) {
                return null;
            }
            return LockFreeLinkedListKt.getCONDITION_FALSE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LockFreeLinkedListNode correctPrev(LockFreeLinkedListNode _prev, OpDescriptor op) {
        Object obj;
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode = null;
            while (true) {
                obj = _prev._next;
                if (obj == op) {
                    return _prev;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(_prev);
                } else if (!(obj instanceof Removed)) {
                    Object obj2 = this._prev;
                    if (obj2 instanceof Removed) {
                        return null;
                    }
                    if (obj != this) {
                        p.g(obj, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
                        lockFreeLinkedListNode = _prev;
                        _prev = (LockFreeLinkedListNode) obj;
                    } else {
                        if (obj2 == _prev) {
                            return null;
                        }
                        if (_prev$FU.compareAndSet(this, obj2, _prev) && !(_prev._prev instanceof Removed)) {
                            return null;
                        }
                    }
                } else {
                    if (lockFreeLinkedListNode != null) {
                        break;
                    }
                    _prev = LockFreeLinkedListKt.unwrap(_prev._prev);
                }
            }
            _prev.markPrev();
            _next$FU.compareAndSet(lockFreeLinkedListNode, _prev, ((Removed) obj).ref);
            _prev = lockFreeLinkedListNode;
        }
    }

    private final LockFreeLinkedListNode findHead() {
        LockFreeLinkedListNode nextNode = this;
        while (!(nextNode instanceof LockFreeLinkedListHead)) {
            nextNode = nextNode.getNextNode();
            if (nextNode == this) {
                throw new IllegalStateException("Cannot loop to this while looking for list head");
            }
        }
        return nextNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishAdd(LockFreeLinkedListNode next) {
        Object obj;
        do {
            obj = next._prev;
            if ((obj instanceof Removed) || getNext() != next) {
                return;
            }
        } while (!_prev$FU.compareAndSet(next, obj, this));
        if (getNext() instanceof Removed) {
            p.g(obj, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            next.correctPrev((LockFreeLinkedListNode) obj, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishRemove(LockFreeLinkedListNode next) {
        helpDelete();
        next.correctPrev(LockFreeLinkedListKt.unwrap(this._prev), null);
    }

    private final LockFreeLinkedListNode markPrev() {
        Object obj;
        LockFreeLinkedListNode lockFreeLinkedListNodeFindHead;
        do {
            obj = this._prev;
            if (obj instanceof Removed) {
                return ((Removed) obj).ref;
            }
            if (obj == this) {
                lockFreeLinkedListNodeFindHead = findHead();
            } else {
                p.g(obj, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
                lockFreeLinkedListNodeFindHead = (LockFreeLinkedListNode) obj;
            }
        } while (!_prev$FU.compareAndSet(this, obj, lockFreeLinkedListNodeFindHead.removed()));
        return (LockFreeLinkedListNode) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Removed removed() {
        Removed removed = (Removed) this.removedRef;
        if (removed != null) {
            return removed;
        }
        Removed removed2 = new Removed(this);
        removedRef$FU.lazySet(this, removed2);
        return removed2;
    }

    public final void addLast(LockFreeLinkedListNode node) {
        Object prev;
        p.i(node, "node");
        do {
            prev = getPrev();
            p.g(prev, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
        } while (!((LockFreeLinkedListNode) prev).addNext(node, this));
    }

    public final boolean addLastIf(LockFreeLinkedListNode node, InterfaceC5063a<Boolean> condition) {
        int iTryCondAddNext;
        p.i(node, "node");
        p.i(condition, "condition");
        C44191 c44191 = new C44191(node, condition);
        do {
            Object prev = getPrev();
            p.g(prev, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            iTryCondAddNext = ((LockFreeLinkedListNode) prev).tryCondAddNext(node, this, c44191);
            if (iTryCondAddNext == 1) {
                return true;
            }
        } while (iTryCondAddNext != 2);
        return false;
    }

    public final boolean addLastIfPrev(LockFreeLinkedListNode node, InterfaceC5074l<? super LockFreeLinkedListNode, Boolean> predicate) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        p.i(node, "node");
        p.i(predicate, "predicate");
        do {
            Object prev = getPrev();
            p.g(prev, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
            if (!predicate.invoke(lockFreeLinkedListNode).booleanValue()) {
                return false;
            }
        } while (!lockFreeLinkedListNode.addNext(node, this));
        return true;
    }

    public final boolean addLastIfPrevAndIf(LockFreeLinkedListNode node, InterfaceC5074l<? super LockFreeLinkedListNode, Boolean> predicate, InterfaceC5063a<Boolean> condition) {
        int iTryCondAddNext;
        p.i(node, "node");
        p.i(predicate, "predicate");
        p.i(condition, "condition");
        C44191 c44191 = new C44191(node, condition);
        do {
            Object prev = getPrev();
            p.g(prev, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
            if (!predicate.invoke(lockFreeLinkedListNode).booleanValue()) {
                return false;
            }
            iTryCondAddNext = lockFreeLinkedListNode.tryCondAddNext(node, this, c44191);
            if (iTryCondAddNext == 1) {
                return true;
            }
        } while (iTryCondAddNext != 2);
        return false;
    }

    public final boolean addNext(LockFreeLinkedListNode node, LockFreeLinkedListNode next) {
        p.i(node, "node");
        p.i(next, "next");
        _prev$FU.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        atomicReferenceFieldUpdater.lazySet(node, next);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, next, node)) {
            return false;
        }
        node.finishAdd(next);
        return true;
    }

    public final boolean addOneIfEmpty(LockFreeLinkedListNode node) {
        p.i(node, "node");
        _prev$FU.lazySet(node, this);
        _next$FU.lazySet(node, this);
        while (getNext() == this) {
            if (_next$FU.compareAndSet(this, this, node)) {
                node.finishAdd(this);
                return true;
            }
        }
        return false;
    }

    public final <T extends LockFreeLinkedListNode> AddLastDesc<T> describeAddLast(T node) {
        p.i(node, "node");
        return new AddLastDesc<>(this, node);
    }

    public AtomicDesc describeRemove() {
        if (isRemoved()) {
            return null;
        }
        return new AbstractAtomicDesc() { // from class: io.ktor.util.internal.LockFreeLinkedListNode.describeRemove.1
            private static final /* synthetic */ AtomicReferenceFieldUpdater _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(AnonymousClass1.class, Object.class, "_originalNext");
            private volatile /* synthetic */ Object _originalNext = null;

            @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            public Object failure(LockFreeLinkedListNode affected, Object next) {
                p.i(affected, "affected");
                p.i(next, "next");
                if (next instanceof Removed) {
                    return LockFreeLinkedListKt.getALREADY_REMOVED();
                }
                return null;
            }

            @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            public void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
                p.i(affected, "affected");
                p.i(next, "next");
                LockFreeLinkedListNode.this.finishRemove(next);
            }

            @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            /* renamed from: getAffectedNode, reason: from getter */
            public LockFreeLinkedListNode getThis$0() {
                return LockFreeLinkedListNode.this;
            }

            @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            /* renamed from: getOriginalNext */
            public LockFreeLinkedListNode getQueue() {
                return (LockFreeLinkedListNode) this._originalNext;
            }

            @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            public Object onPrepare(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
                p.i(affected, "affected");
                p.i(next, "next");
                _originalNext$FU.compareAndSet(this, null, next);
                return null;
            }

            @Override // io.ktor.util.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            public Removed updatedNext(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
                p.i(affected, "affected");
                p.i(next, "next");
                return next.removed();
            }
        };
    }

    public final RemoveFirstDesc<LockFreeLinkedListNode> describeRemoveFirst() {
        return new RemoveFirstDesc<>(this);
    }

    public final Object getNext() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(getNext());
    }

    public final Object getPrev() {
        while (true) {
            Object obj = this._prev;
            if (obj instanceof Removed) {
                return obj;
            }
            p.g(obj, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
            if (lockFreeLinkedListNode.getNext() == this) {
                return obj;
            }
            correctPrev(lockFreeLinkedListNode, null);
        }
    }

    public final LockFreeLinkedListNode getPrevNode() {
        return LockFreeLinkedListKt.unwrap(getPrev());
    }

    public final void helpDelete() {
        Object next;
        LockFreeLinkedListNode lockFreeLinkedListNodeMarkPrev = markPrev();
        Object obj = this._next;
        p.g(obj, "null cannot be cast to non-null type io.ktor.util.internal.Removed");
        LockFreeLinkedListNode lockFreeLinkedListNode = ((Removed) obj).ref;
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode2 = null;
            while (true) {
                Object next2 = lockFreeLinkedListNode.getNext();
                if (next2 instanceof Removed) {
                    lockFreeLinkedListNode.markPrev();
                    lockFreeLinkedListNode = ((Removed) next2).ref;
                } else {
                    next = lockFreeLinkedListNodeMarkPrev.getNext();
                    if (next instanceof Removed) {
                        if (lockFreeLinkedListNode2 != null) {
                            break;
                        } else {
                            lockFreeLinkedListNodeMarkPrev = LockFreeLinkedListKt.unwrap(lockFreeLinkedListNodeMarkPrev._prev);
                        }
                    } else if (next != this) {
                        p.g(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
                        LockFreeLinkedListNode lockFreeLinkedListNode3 = (LockFreeLinkedListNode) next;
                        if (lockFreeLinkedListNode3 == lockFreeLinkedListNode) {
                            return;
                        }
                        lockFreeLinkedListNode2 = lockFreeLinkedListNodeMarkPrev;
                        lockFreeLinkedListNodeMarkPrev = lockFreeLinkedListNode3;
                    } else if (_next$FU.compareAndSet(lockFreeLinkedListNodeMarkPrev, this, lockFreeLinkedListNode)) {
                        return;
                    }
                }
            }
            lockFreeLinkedListNodeMarkPrev.markPrev();
            _next$FU.compareAndSet(lockFreeLinkedListNode2, lockFreeLinkedListNodeMarkPrev, ((Removed) next).ref);
            lockFreeLinkedListNodeMarkPrev = lockFreeLinkedListNode2;
        }
    }

    public final void helpRemove() {
        Object next = getNext();
        Removed removed = next instanceof Removed ? (Removed) next : null;
        if (removed == null) {
            throw new IllegalStateException("Must be invoked on a removed node");
        }
        finishRemove(removed.ref);
    }

    public final boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    public final CondAddOp makeCondAddOp(LockFreeLinkedListNode node, InterfaceC5063a<Boolean> condition) {
        p.i(node, "node");
        p.i(condition, "condition");
        return new C44191(node, condition);
    }

    public boolean remove() {
        Object next;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            next = getNext();
            if ((next instanceof Removed) || next == this) {
                return false;
            }
            p.g(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
        } while (!_next$FU.compareAndSet(this, next, lockFreeLinkedListNode.removed()));
        finishRemove(lockFreeLinkedListNode);
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, io.ktor.util.internal.LockFreeLinkedListNode] */
    public final /* synthetic */ <T> T removeFirstIfIsInstanceOf() {
        while (true) {
            Object next = getNext();
            p.g(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            ?? r02 = (T) ((LockFreeLinkedListNode) next);
            if (r02 == this) {
                return null;
            }
            p.o(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (r02 == 0) {
                return null;
            }
            if (r02.remove()) {
                return r02;
            }
            r02.helpDelete();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, io.ktor.util.internal.LockFreeLinkedListNode, java.lang.Object] */
    public final /* synthetic */ <T> T removeFirstIfIsInstanceOfOrPeekIf(InterfaceC5074l<? super T, Boolean> predicate) {
        p.i(predicate, "predicate");
        while (true) {
            Object next = getNext();
            p.g(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            p.o(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (lockFreeLinkedListNode == 0) {
                return null;
            }
            if (predicate.invoke(lockFreeLinkedListNode).booleanValue() || lockFreeLinkedListNode.remove()) {
                return lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode.helpDelete();
        }
    }

    public final LockFreeLinkedListNode removeFirstOrNull() {
        while (true) {
            Object next = getNext();
            p.g(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            if (lockFreeLinkedListNode.remove()) {
                return lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode.helpDelete();
        }
    }

    public String toString() {
        return t.b(getClass()).t() + '@' + hashCode();
    }

    public final int tryCondAddNext(LockFreeLinkedListNode node, LockFreeLinkedListNode next, CondAddOp condAdd) {
        p.i(node, "node");
        p.i(next, "next");
        p.i(condAdd, "condAdd");
        _prev$FU.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        atomicReferenceFieldUpdater.lazySet(node, next);
        condAdd.oldNext = next;
        if (atomicReferenceFieldUpdater.compareAndSet(this, next, condAdd)) {
            return condAdd.perform(this) == null ? 1 : 2;
        }
        return 0;
    }

    public final void validateNode$ktor_utils(LockFreeLinkedListNode prev, LockFreeLinkedListNode next) {
        p.i(prev, "prev");
        p.i(next, "next");
        if (prev != this._prev) {
            throw new IllegalStateException("Check failed.");
        }
        if (next != this._next) {
            throw new IllegalStateException("Check failed.");
        }
    }
}
