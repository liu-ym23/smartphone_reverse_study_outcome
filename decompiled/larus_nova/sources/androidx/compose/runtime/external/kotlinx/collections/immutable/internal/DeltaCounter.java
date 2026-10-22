package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0086\u0002J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "", "count", "", "<init>", "(I)V", "getCount", "()I", "setCount", "plusAssign", "", "that", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeltaCounter {
    public static final int $stable = 8;
    private int count;

    public DeltaCounter() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public static /* synthetic */ DeltaCounter copy$default(DeltaCounter r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.count;
    L6:
        return r100.copy(r101);
    }

    public final int component1() {
        return this.count;
    }

    public final DeltaCounter copy(int r100) {
        return new DeltaCounter(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DeltaCounter) == true) goto L9;
        return false;
    L9:
        if (this.count == ((DeltaCounter) r100).count) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.count;
    }

    public String toString() {
        return "DeltaCounter(count=" + this.count + ')';
    }

    public final int getCount() {
        return this.count;
    }

    public DeltaCounter(int r100) {
        this.count = r100;
    }

    public final void plusAssign(int r100) {
        this.count += r100;
    }

    public final void setCount(int r100) {
        this.count = r100;
    }

    public /* synthetic */ DeltaCounter(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100);
    }
}
