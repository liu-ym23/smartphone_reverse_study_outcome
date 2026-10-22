package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0001HÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/SourceInformationSlotTableGroupIdentity;", "", "parentIdentity", "index", "", "<init>", "(Ljava/lang/Object;I)V", "getParentIdentity", "()Ljava/lang/Object;", "getIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SourceInformationSlotTableGroupIdentity {
    private final int index;
    private final Object parentIdentity;

    public static /* synthetic */ SourceInformationSlotTableGroupIdentity copy$default(SourceInformationSlotTableGroupIdentity r100, Object r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.parentIdentity;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.index;
    L9:
        return r100.copy(r101, r102);
    }

    public final Object component1() {
        return this.parentIdentity;
    }

    public final int component2() {
        return this.index;
    }

    public final SourceInformationSlotTableGroupIdentity copy(Object r100, int r101) {
        return new SourceInformationSlotTableGroupIdentity(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SourceInformationSlotTableGroupIdentity) == true) goto L8;
        return false;
    L8:
        SourceInformationSlotTableGroupIdentity r101 = (SourceInformationSlotTableGroupIdentity) r100;
        if (Intrinsics.areEqual(this.parentIdentity, r101.parentIdentity) == true) goto L12;
        return false;
    L12:
        if (this.index == r101.index) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.parentIdentity.hashCode() * 31) + this.index;
    }

    public String toString() {
        return "SourceInformationSlotTableGroupIdentity(parentIdentity=" + this.parentIdentity + ", index=" + this.index + ')';
    }

    public final int getIndex() {
        return this.index;
    }

    public final Object getParentIdentity() {
        return this.parentIdentity;
    }

    public SourceInformationSlotTableGroupIdentity(Object r100, int r101) {
        this.parentIdentity = r100;
        this.index = r101;
    }
}
