package com.stepos.aiengine.data;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\nJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\nJ\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\n¨\u0006!"}, d2 = {"Lcom/stepos/aiengine/data/ContourHierarchy;", "", "", "next", "previous", "firstChild", "parent", "<init>", "(IIII)V", "component1", "()I", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "(IIII)Lcom/stepos/aiengine/data/ContourHierarchy;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "getNext", Const.INTENT_KEY_PKGNAME, "getPrevious", "c", "getFirstChild", Const.INTENT_KEY_UMID, "getParent", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ContourHierarchy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int next;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int previous;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int firstChild;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final int parent;

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
        return (((((Integer.hashCode(this.next) * 31) + Integer.hashCode(this.previous)) * 31) + Integer.hashCode(this.firstChild)) * 31) + Integer.hashCode(this.parent);
    }

    public String toString() {
        return "ContourHierarchy(next=" + this.next + ", previous=" + this.previous + ", firstChild=" + this.firstChild + ", parent=" + this.parent + ")";
    }
}
