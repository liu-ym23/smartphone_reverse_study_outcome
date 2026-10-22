package io.ktor.util.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0004\b\r\u0010\bJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/util/internal/AtomicOp;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/internal/OpDescriptor;", "<init>", "()V", "", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "tryDecide", "(Ljava/lang/Object;)Z", "affected", "prepare", "failure", "LY8/t;", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "perform", "isDecided", "()Z", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class AtomicOp<T> extends OpDescriptor {
    private static final /* synthetic */ AtomicReferenceFieldUpdater consensus$FU = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "consensus");
    private volatile /* synthetic */ Object consensus = LockFreeLinkedListKt.NO_DECISION;

    private final Object decide(Object decision) {
        return tryDecide(decision) ? decision : this.consensus;
    }

    public abstract void complete(T affected, Object failure);

    public final boolean isDecided() {
        return this.consensus != LockFreeLinkedListKt.NO_DECISION;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.ktor.util.internal.OpDescriptor
    public final Object perform(Object affected) {
        Object objDecide = this.consensus;
        if (objDecide == LockFreeLinkedListKt.NO_DECISION) {
            objDecide = decide(prepare(affected));
        }
        complete(affected, objDecide);
        return objDecide;
    }

    public abstract Object prepare(T affected);

    public final boolean tryDecide(Object decision) {
        if (decision != LockFreeLinkedListKt.NO_DECISION) {
            return consensus$FU.compareAndSet(this, LockFreeLinkedListKt.NO_DECISION, decision);
        }
        throw new IllegalStateException("Check failed.");
    }
}
