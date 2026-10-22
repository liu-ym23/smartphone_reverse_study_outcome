package com.stepos.aiengine.data;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\nJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\nJ\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\n¨\u0006!"}, d2 = {"Lcom/stepos/aiengine/data/ContourHierarchy;", "", "", "next", "previous", "firstChild", "parent", AppAgent.CONSTRUCT, "(IIII)V", "component1", "()I", "component2", "component3", "component4", "copy", "(IIII)Lcom/stepos/aiengine/data/ContourHierarchy;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getNext", "b", "getPrevious", "c", "getFirstChild", "d", "getParent", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ContourHierarchy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int next;

    /* renamed from: b, reason: from kotlin metadata */
    public final int previous;

    /* renamed from: c, reason: from kotlin metadata */
    public final int firstChild;

    /* renamed from: d, reason: from kotlin metadata */
    public final int parent;

    public ContourHierarchy(int i, int i6, int i10, int i11) {
        this.next = i;
        this.previous = i6;
        this.firstChild = i10;
        this.parent = i11;
    }

    public static /* synthetic */ ContourHierarchy copy$default(ContourHierarchy contourHierarchy, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = contourHierarchy.next;
        }
        if ((i12 & 2) != 0) {
            i6 = contourHierarchy.previous;
        }
        if ((i12 & 4) != 0) {
            i10 = contourHierarchy.firstChild;
        }
        if ((i12 & 8) != 0) {
            i11 = contourHierarchy.parent;
        }
        return contourHierarchy.copy(i, i6, i10, i11);
    }

    /* renamed from: component1, reason: from getter */
    public final int getNext() {
        return this.next;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPrevious() {
        return this.previous;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFirstChild() {
        return this.firstChild;
    }

    /* renamed from: component4, reason: from getter */
    public final int getParent() {
        return this.parent;
    }

    public final ContourHierarchy copy(int next, int previous, int firstChild, int parent) {
        return new ContourHierarchy(next, previous, firstChild, parent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContourHierarchy)) {
            return false;
        }
        ContourHierarchy contourHierarchy = (ContourHierarchy) other;
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
        return Integer.hashCode(this.parent) + a.a(this.firstChild, a.a(this.previous, Integer.hashCode(this.next) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(this.next, "ContourHierarchy(next=", this.previous, ", previous=", ", firstChild=");
        sbS.append(this.firstChild);
        sbS.append(", parent=");
        sbS.append(this.parent);
        sbS.append(")");
        return sbS.toString();
    }
}
