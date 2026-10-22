package com.obric.callsummary.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallAssignmentDean.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u000bJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/callsummary/bean/CallAssignment;", "", "list", "", "Lcom/obric/callsummary/bean/CallAssignmentData;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "isEmpty", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallAssignment {
    private final List<CallAssignmentData> list;

    /* JADX WARN: Multi-variable type inference failed */
    public CallAssignment() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallAssignment copy$default(CallAssignment r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.list;
    L6:
        return r0.copy(r1);
    }

    public final List<CallAssignmentData> component1() {
        return this.list;
    }

    public final CallAssignment copy(List<CallAssignmentData> r1) {
        Intrinsics.checkNotNullParameter(r1, "list");
        return new CallAssignment(r1);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CallAssignment) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.list, ((CallAssignment) r4).list) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public String toString() {
        return "CallAssignment(list=" + this.list + ')';
    }

    public CallAssignment(List<CallAssignmentData> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        this.list = r2;
    }

    public /* synthetic */ CallAssignment(List r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        this(r1);
    }

    public final List<CallAssignmentData> getList() {
        return this.list;
    }

    public final boolean isEmpty() {
        return this.list.isEmpty();
    }
}
