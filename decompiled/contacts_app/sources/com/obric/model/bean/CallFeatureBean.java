package com.obric.model.bean;

import com.obric.callsummary.bean.CallSummary;
import com.obric.callsummary.widget.CallSummaryWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallFeatureBean.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\u0006\u0010#\u001a\u00020 J\u0006\u0010$\u001a\u00020 J\u0006\u0010%\u001a\u00020 J\u0006\u0010&\u001a\u00020 J\u0006\u0010'\u001a\u00020 J\u0006\u0010(\u001a\u00020 J\u0006\u0010)\u001a\u00020 J\u0006\u0010*\u001a\u00020 J\u0006\u0010+\u001a\u00020 J\b\u0010,\u001a\u00020\nH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lcom/obric/model/bean/CallFeatureBean;", "", "id", "", "feature", "", "status", CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY, "Lcom/obric/callsummary/bean/CallSummary;", "phoneNumber", "", "(JIILcom/obric/callsummary/bean/CallSummary;Ljava/lang/String;)V", "getFeature", "()I", "getId", "()J", "getPhoneNumber", "()Ljava/lang/String;", "getStatus", "setStatus", "(I)V", "getSummary", "()Lcom/obric/callsummary/bean/CallSummary;", "setSummary", "(Lcom/obric/callsummary/bean/CallSummary;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "isAsrFailCanNotUseMobileNetwork", "isCallSummaryAvailable", "isFeatureCallRecordEnabled", "isFeatureCallSummaryEnabled", "isIntelligentCallEnabled", "isOnlyUseIntelligentCall", "isRecordASRAvailable", "isRecordASRWorking", "isSummaryEmpty", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallFeatureBean {
    private final int feature;
    private final long id;
    private final String phoneNumber;
    private int status;
    private CallSummary summary;

    public static /* synthetic */ CallFeatureBean copy$default(CallFeatureBean r7, long r8, int r10, int r11, CallSummary r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.id;
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r10 = r7.feature;
    L8:
        int r3 = r10;
        if ((r14 & 4) == 0) goto L11;
        r11 = r7.status;
    L11:
        int r4 = r11;
        if ((r14 & 8) == 0) goto L14;
        r12 = r7.summary;
    L14:
        CallSummary r5 = r12;
        if ((r14 & 16) == 0) goto L18;
        r13 = r7.phoneNumber;
    L18:
        return r7.copy(r1, r3, r4, r5, r13);
    }

    public final long component1() {
        return this.id;
    }

    public final int component2() {
        return this.feature;
    }

    public final int component3() {
        return this.status;
    }

    public final CallSummary component4() {
        return this.summary;
    }

    public final String component5() {
        return this.phoneNumber;
    }

    public final CallFeatureBean copy(long r8, int r10, int r11, CallSummary r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY);
        return new CallFeatureBean(r8, r10, r11, r12, r13);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof CallFeatureBean) == true) goto L8;
        return false;
    L8:
        CallFeatureBean r9 = (CallFeatureBean) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (this.feature == r9.feature) goto L15;
        return false;
    L15:
        if (this.status == r9.status) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.summary, r9.summary) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.phoneNumber, r9.phoneNumber) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((Long.hashCode(this.id) * 31) + Integer.hashCode(this.feature)) * 31) + Integer.hashCode(this.status)) * 31) + this.summary.hashCode()) * 31;
        String r2 = this.phoneNumber;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public CallFeatureBean(long r2, int r4, int r5, CallSummary r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY);
        this.id = r2;
        this.feature = r4;
        this.status = r5;
        this.summary = r6;
        this.phoneNumber = r7;
    }

    public final long getId() {
        return this.id;
    }

    public final int getFeature() {
        return this.feature;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int r1) {
        this.status = r1;
    }

    public final CallSummary getSummary() {
        return this.summary;
    }

    public final void setSummary(CallSummary r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.summary = r2;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final boolean isSummaryEmpty() {
        return this.summary.isEmpty();
    }

    public final boolean isFeatureCallSummaryEnabled() {
        if (isFeatureCallRecordEnabled() == true) goto L6;
        return false;
    L6:
        if ((this.feature & 1) == 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L13;
        if (this.summary.summaryAndAssignmentIsEmpty() == false) goto L13;
        return false;
    L13:
        return true;
    L8:
        r0 = false;
        goto L9
    }

    public final boolean isFeatureCallRecordEnabled() {
        if ((this.feature & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isIntelligentCallEnabled() {
        if ((this.feature & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isOnlyUseIntelligentCall() {
        if ((this.status & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isRecordASRAvailable() {
        if ((this.status & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isCallSummaryAvailable() {
        if ((this.status & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isRecordASRWorking() {
        if ((this.status & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isAsrFailCanNotUseMobileNetwork() {
        if ((this.status & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("CallFeatureBean(id=").append(this.id).append(", feature=").append(this.feature).append(", status=").append(this.status).append(", summary=").append(this.summary.getLength()).append(", phoneNumber=");
        String r3 = this.phoneNumber;
        if (r3 == null) goto L5;
        int r4 = r3.length();
    L7:
        return r0.append(r4).append(')').toString();
    L5:
        r4 = -1;
        goto L7
    }
}
