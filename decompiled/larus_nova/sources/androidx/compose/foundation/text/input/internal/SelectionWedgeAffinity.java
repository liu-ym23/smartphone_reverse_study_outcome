package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "", "startAffinity", "Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "endAffinity", "<init>", "(Landroidx/compose/foundation/text/input/internal/WedgeAffinity;Landroidx/compose/foundation/text/input/internal/WedgeAffinity;)V", "affinity", "(Landroidx/compose/foundation/text/input/internal/WedgeAffinity;)V", "getStartAffinity", "()Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "getEndAffinity", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectionWedgeAffinity {
    public static final int $stable = 0;
    private final WedgeAffinity endAffinity;
    private final WedgeAffinity startAffinity;

    public static /* synthetic */ SelectionWedgeAffinity copy$default(SelectionWedgeAffinity r100, WedgeAffinity r101, WedgeAffinity r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.startAffinity;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.endAffinity;
    L9:
        return r100.copy(r101, r102);
    }

    public final WedgeAffinity component1() {
        return this.startAffinity;
    }

    public final WedgeAffinity component2() {
        return this.endAffinity;
    }

    public final SelectionWedgeAffinity copy(WedgeAffinity r100, WedgeAffinity r101) {
        return new SelectionWedgeAffinity(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SelectionWedgeAffinity) == true) goto L8;
        return false;
    L8:
        SelectionWedgeAffinity r101 = (SelectionWedgeAffinity) r100;
        if (this.startAffinity == r101.startAffinity) goto L12;
        return false;
    L12:
        if (this.endAffinity == r101.endAffinity) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.startAffinity.hashCode() * 31) + this.endAffinity.hashCode();
    }

    public String toString() {
        return "SelectionWedgeAffinity(startAffinity=" + this.startAffinity + ", endAffinity=" + this.endAffinity + ')';
    }

    public final WedgeAffinity getEndAffinity() {
        return this.endAffinity;
    }

    public final WedgeAffinity getStartAffinity() {
        return this.startAffinity;
    }

    public SelectionWedgeAffinity(WedgeAffinity r100) {
        this(r100, r100);
    }

    public SelectionWedgeAffinity(WedgeAffinity r100, WedgeAffinity r101) {
        this.startAffinity = r100;
        this.endAffinity = r101;
    }
}
