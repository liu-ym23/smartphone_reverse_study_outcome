package j0;

import androidx.compose.runtime.internal.AtomicInt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lj0/q;", "Lj0/p;", "<init>", "()V", "Lj0/c;", "reader", "LY8/t;", "recordReadIn-h_f27i8$runtime", "(I)V", "recordReadIn", "", "isReadIn-h_f27i8$runtime", "(I)Z", "isReadIn", "Landroidx/compose/runtime/internal/AtomicInt;", "readerKind", "Landroidx/compose/runtime/internal/AtomicInt;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class q implements p {
    public static final int $stable = 8;
    private final AtomicInt readerKind = new AtomicInt(0);

    /* renamed from: isReadIn-h_f27i8$runtime, reason: not valid java name */
    public final boolean m244isReadInh_f27i8$runtime(int reader) {
        return (C4745c.a(this.readerKind.get()) & reader) != 0;
    }

    /* renamed from: recordReadIn-h_f27i8$runtime, reason: not valid java name */
    public final void m245recordReadInh_f27i8$runtime(int reader) {
        int iA;
        do {
            iA = C4745c.a(this.readerKind.get());
            if ((iA & reader) != 0) {
                return;
            }
        } while (!this.readerKind.compareAndSet(iA, C4745c.a(iA | reader)));
    }
}
