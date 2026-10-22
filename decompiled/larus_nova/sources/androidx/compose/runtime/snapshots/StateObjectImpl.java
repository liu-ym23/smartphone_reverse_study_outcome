package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.AtomicInt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/snapshots/StateObject;", "<init>", "()V", "readerKind", "Landroidx/compose/runtime/internal/AtomicInt;", "recordReadIn", "", "reader", "Landroidx/compose/runtime/snapshots/ReaderKind;", "recordReadIn-h_f27i8$runtime", "(I)V", "isReadIn", "", "isReadIn-h_f27i8$runtime", "(I)Z", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class StateObjectImpl implements StateObject {
    public static final int $stable = 8;
    private final AtomicInt readerKind;

    @Override // androidx.compose.runtime.snapshots.StateObject
    public /* synthetic */ StateRecord mergeRecords(StateRecord r100, StateRecord r101, StateRecord r102) {
        return StateObject.CC.$default$mergeRecords(this, r100, r101, r102);
    }

    public StateObjectImpl() {
        this.readerKind = new AtomicInt(0);
    }

    /* JADX INFO: renamed from: isReadIn-h_f27i8$runtime, reason: not valid java name */
    public final boolean m4303isReadInh_f27i8$runtime(int r100) {
        if ((r100 & ReaderKind.m4291constructorimpl(this.readerKind.get())) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: recordReadIn-h_f27i8$runtime, reason: not valid java name */
    public final void m4304recordReadInh_f27i8$runtime(int r100) {
    L2:
        int r101 = ReaderKind.m4291constructorimpl(this.readerKind.get());
        if ((r101 & r100) == 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L7;
        int r103 = ReaderKind.m4291constructorimpl(r101 | r100);
        if (this.readerKind.compareAndSet(r101, r103) == false) goto L2;
        return;
    L7:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
