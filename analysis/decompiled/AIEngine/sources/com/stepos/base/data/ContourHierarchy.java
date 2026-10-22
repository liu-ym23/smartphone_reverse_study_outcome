package com.stepos.base.data;

import ai.onnxruntime.a;
import h0.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ContourHierarchy {
    private final int firstChild;
    private final int next;
    private final int parent;
    private final int previous;

    public ContourHierarchy(int i10, int i11, int i12, int i13) {
        this.next = i10;
        this.previous = i11;
        this.firstChild = i12;
        this.parent = i13;
    }

    public static /* synthetic */ ContourHierarchy copy$default(ContourHierarchy contourHierarchy, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = contourHierarchy.next;
        }
        if ((i14 & 2) != 0) {
            i11 = contourHierarchy.previous;
        }
        if ((i14 & 4) != 0) {
            i12 = contourHierarchy.firstChild;
        }
        if ((i14 & 8) != 0) {
            i13 = contourHierarchy.parent;
        }
        return contourHierarchy.copy(i10, i11, i12, i13);
    }

    public final int component1() {
        return this.next;
    }

    public final int component2() {
        return this.previous;
    }

    public final int component3() {
        return this.firstChild;
    }

    public final int component4() {
        return this.parent;
    }

    public final ContourHierarchy copy(int i10, int i11, int i12, int i13) {
        return new ContourHierarchy(i10, i11, i12, i13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContourHierarchy)) {
            return false;
        }
        ContourHierarchy contourHierarchy = (ContourHierarchy) obj;
        return this.next == contourHierarchy.next && this.previous == contourHierarchy.previous && this.firstChild == contourHierarchy.firstChild && this.parent == contourHierarchy.parent;
    }

    public final int getFirstChild() {
        return this.firstChild;
    }

    public final int getNext() {
        return this.next;
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getPrevious() {
        return this.previous;
    }

    public int hashCode() {
        return Integer.hashCode(this.parent) + a.d(this.firstChild, a.d(this.previous, Integer.hashCode(this.next) * 31, 31), 31);
    }

    public String toString() {
        int i10 = this.next;
        int i11 = this.previous;
        int i12 = this.firstChild;
        int i13 = this.parent;
        StringBuilder sbD = e.d(i10, "ContourHierarchy(next=", i11, ", previous=", ", firstChild=");
        sbD.append(i12);
        sbD.append(", parent=");
        sbD.append(i13);
        sbD.append(")");
        return sbD.toString();
    }
}
