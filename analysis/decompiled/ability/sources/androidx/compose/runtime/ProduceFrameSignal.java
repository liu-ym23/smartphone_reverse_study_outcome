package androidx.compose.runtime;

import C7.r;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import m9.C1718k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u0015\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/ProduceFrameSignal;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/platform/SynchronizedObject;", "lock", "LC7/r;", "awaitFrameRequest", "(Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "takeFrameRequestLocked", "LH7/c;", "requestFrameLocked", "()LH7/c;", "pendingFrameContinuation", "Ljava/lang/Object;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class ProduceFrameSignal {
    private Object pendingFrameContinuation;

    public final Object awaitFrameRequest(Object obj, H7.c<? super r> cVar) {
        C1718k c1718k;
        synchronized (obj) {
            if (this.pendingFrameContinuation == RecomposerKt.ProduceAnotherFrame) {
                this.pendingFrameContinuation = RecomposerKt.FramePending;
                return r.f317a;
            }
            C1718k c1718k2 = new C1718k(1, U7.a.I(cVar));
            c1718k2.y();
            synchronized (obj) {
                try {
                    if (this.pendingFrameContinuation == RecomposerKt.ProduceAnotherFrame) {
                        this.pendingFrameContinuation = RecomposerKt.FramePending;
                        c1718k = c1718k2;
                    } else {
                        this.pendingFrameContinuation = c1718k2;
                        c1718k = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (c1718k != null) {
                c1718k.resumeWith(r.f317a);
            }
            Object objX = c1718k2.x();
            return objX == CoroutineSingletons.f4909a ? objX : r.f317a;
        }
    }

    public final H7.c<r> requestFrameLocked() {
        Object obj = this.pendingFrameContinuation;
        if (obj instanceof H7.c) {
            this.pendingFrameContinuation = RecomposerKt.FramePending;
            return (H7.c) obj;
        }
        if (kotlin.jvm.internal.k.b(obj, RecomposerKt.ProduceAnotherFrame) || kotlin.jvm.internal.k.b(obj, RecomposerKt.FramePending)) {
            return null;
        }
        if (obj != null) {
            throw new IllegalStateException(androidx.compose.foundation.b.r(obj, "invalid pendingFrameContinuation "));
        }
        this.pendingFrameContinuation = RecomposerKt.ProduceAnotherFrame;
        return null;
    }

    public final void takeFrameRequestLocked() {
        if (!(this.pendingFrameContinuation == RecomposerKt.FramePending)) {
            PreconditionsKt.throwIllegalStateException("frame not pending");
        }
        this.pendingFrameContinuation = null;
    }
}
