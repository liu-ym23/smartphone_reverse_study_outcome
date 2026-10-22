package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/snapshots/StateObject;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/snapshots/ReaderKind;", "reader", "LC7/r;", "recordReadIn-h_f27i8$runtime", "(I)V", "recordReadIn", "", "isReadIn-h_f27i8$runtime", "(I)Z", "isReadIn", "Landroidx/compose/runtime/internal/AtomicInt;", "readerKind", "Landroidx/compose/runtime/internal/AtomicInt;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class StateObjectImpl implements StateObject {
    public static final int $stable = 8;
    private final AtomicInt readerKind = new AtomicInt(0);

    /* renamed from: isReadIn-h_f27i8$runtime, reason: not valid java name */
    public final boolean m3610isReadInh_f27i8$runtime(int reader) {
        return (ReaderKind.m3598constructorimpl(this.readerKind.get()) & reader) != 0;
    }

    /* renamed from: recordReadIn-h_f27i8$runtime, reason: not valid java name */
    public final void m3611recordReadInh_f27i8$runtime(int reader) {
        int iM3598constructorimpl;
        do {
            iM3598constructorimpl = ReaderKind.m3598constructorimpl(this.readerKind.get());
            if ((iM3598constructorimpl & reader) != 0) {
                return;
            }
        } while (!this.readerKind.compareAndSet(iM3598constructorimpl, ReaderKind.m3598constructorimpl(iM3598constructorimpl | reader)));
    }
}
