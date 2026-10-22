package y;

import androidx.compose.runtime.internal.AtomicInt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class j implements i {
    public static final int $stable = 8;
    private final AtomicInt readerKind = new AtomicInt(0);

    /* renamed from: isReadIn-h_f27i8$runtime, reason: not valid java name */
    public final boolean m180isReadInh_f27i8$runtime(int i10) {
        return (this.readerKind.get() & i10) != 0;
    }

    /* renamed from: recordReadIn-h_f27i8$runtime, reason: not valid java name */
    public final void m181recordReadInh_f27i8$runtime(int i10) {
        int i11;
        do {
            i11 = this.readerKind.get();
            if ((i11 & i10) != 0) {
                return;
            }
        } while (!this.readerKind.compareAndSet(i11, i11 | i10));
    }
}
