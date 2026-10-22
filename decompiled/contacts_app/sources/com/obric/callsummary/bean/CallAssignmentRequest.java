package com.obric.callsummary.bean;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm.constant.TraceStatsConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallAssignmentDean.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/obric/callsummary/bean/CallAssignmentRequest;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "data", "Lcom/obric/callsummary/bean/CallAssignment;", TraceStatsConsts.STATS_BASE_MODULE, "(ILjava/lang/String;Lcom/obric/callsummary/bean/CallAssignment;Ljava/lang/String;)V", "getBase", "()Ljava/lang/String;", "getCode", "()I", "getData", "()Lcom/obric/callsummary/bean/CallAssignment;", "getMsg", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallAssignmentRequest {
    private final String base;
    private final int code;
    private final CallAssignment data;
    private final String msg;

    public CallAssignmentRequest() {
        this(0, null, null, null, 15, null);
    }

    public static /* synthetic */ CallAssignmentRequest copy$default(CallAssignmentRequest r0, int r1, String r2, CallAssignment r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.msg;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.data;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.base;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final CallAssignment component3() {
        return this.data;
    }

    public final String component4() {
        return this.base;
    }

    public final CallAssignmentRequest copy(int r1, String r2, CallAssignment r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r3, "data");
        return new CallAssignmentRequest(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CallAssignmentRequest) == true) goto L8;
        return false;
    L8:
        CallAssignmentRequest r6 = (CallAssignmentRequest) r5;
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r6.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.base, r6.base) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Integer.hashCode(this.code) * 31) + this.msg.hashCode()) * 31) + this.data.hashCode()) * 31;
        String r2 = this.base;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "CallAssignmentRequest(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", base=" + this.base + ')';
    }

    public CallAssignmentRequest(int r2, String r3, CallAssignment r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r4, "data");
        this.code = r2;
        this.msg = r3;
        this.data = r4;
        this.base = r5;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public /* synthetic */ CallAssignmentRequest(int r2, String r3, CallAssignment r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = new CallAssignment(null, 1, null);
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final CallAssignment getData() {
        return this.data;
    }

    public final String getBase() {
        return this.base;
    }
}
