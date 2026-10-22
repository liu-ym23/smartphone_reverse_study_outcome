package com.obric.contactsdk.loader;

import com.obric.callsummary.widget.CallSummaryWidget;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallFeatureEntityUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/contactsdk/loader/CallAssignmentData;", "", CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY, "", "deadline", "", "significance", "", "keys", "", "(Ljava/lang/String;JILjava/util/List;)V", "getDeadline", "()J", "getKeys", "()Ljava/util/List;", "getSignificance", "()I", "getSummary", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallAssignmentData {
    private final long deadline;
    private final List<String> keys;
    private final int significance;
    private final String summary;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallAssignmentData copy$default(CallAssignmentData r3, String r4, long r5, int r7, List r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.summary;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.deadline;
    L8:
        long r0 = r5;
        if ((r9 & 4) == 0) goto L11;
        r7 = r3.significance;
    L11:
        int r11 = r7;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.keys;
    L14:
        String r6 = r4;
        return r3.copy(r6, r0, r11, r8);
    }

    public final String component1() {
        return this.summary;
    }

    public final long component2() {
        return this.deadline;
    }

    public final int component3() {
        return this.significance;
    }

    public final List<String> component4() {
        return this.keys;
    }

    public final CallAssignmentData copy(String r7, long r8, int r10, List<String> r11) {
        Intrinsics.checkNotNullParameter(r7, CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY);
        Intrinsics.checkNotNullParameter(r11, "keys");
        return new CallAssignmentData(r7, r8, r10, r11);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof CallAssignmentData) == true) goto L8;
        return false;
    L8:
        CallAssignmentData r9 = (CallAssignmentData) r8;
        if (Intrinsics.areEqual(this.summary, r9.summary) == true) goto L12;
        return false;
    L12:
        if (this.deadline == r9.deadline) goto L15;
        return false;
    L15:
        if (this.significance == r9.significance) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.keys, r9.keys) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.summary.hashCode() * 31) + Long.hashCode(this.deadline)) * 31) + Integer.hashCode(this.significance)) * 31) + this.keys.hashCode();
    }

    public String toString() {
        return "CallAssignmentData(summary=" + this.summary + ", deadline=" + this.deadline + ", significance=" + this.significance + ", keys=" + this.keys + ')';
    }

    public CallAssignmentData(String r2, long r3, int r5, List<String> r6) {
        Intrinsics.checkNotNullParameter(r2, CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY);
        Intrinsics.checkNotNullParameter(r6, "keys");
        this.summary = r2;
        this.deadline = r3;
        this.significance = r5;
        this.keys = r6;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final long getDeadline() {
        return this.deadline;
    }

    public final int getSignificance() {
        return this.significance;
    }

    public /* synthetic */ CallAssignmentData(String r7, long r8, int r10, List r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = CollectionsKt.emptyList();
    L5:
        this(r7, r8, r10, r11);
    }

    public final List<String> getKeys() {
        return this.keys;
    }
}
