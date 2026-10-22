package com.obric.database.entity;

import com.obric.callsummary.widget.CallSummaryWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallFeatureEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003JI\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lcom/obric/database/entity/CallFeatureEntity;", "", "callCreateTime", "", "feature", "", "status", CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY, "", "phoneNumber", "id", "(JIILjava/lang/String;Ljava/lang/String;J)V", "getCallCreateTime", "()J", "getFeature", "()I", "getId", "getPhoneNumber", "()Ljava/lang/String;", "getStatus", "setStatus", "(I)V", "getSummary", "setSummary", "(Ljava/lang/String;)V", "changeStatus", "", "available", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallFeatureEntity {
    public static final Companion Companion = null;
    public static final int FEATURE_CALL_INTELLIGENT_MASK = 4;
    public static final int FEATURE_CALL_RECORD_MASK = 2;
    public static final int FEATURE_CALL_SUMMARY_MASK = 1;
    public static final int STATUS_ASR_FAIL_CAN_NOT_USE_MOBILE_NETWORK = 16;
    public static final int STATUS_CALL_RECORD_ASR_MASK = 2;
    public static final int STATUS_CALL_RECORD_ASR_WORKING_MASK = 4;
    public static final int STATUS_CALL_SUMMARY_MASK = 1;
    public static final int STATUS_ONLY_USE_INTELLIGENT_CALL = 8;
    private final long callCreateTime;
    private final int feature;
    private final long id;
    private final String phoneNumber;
    private int status;
    private String summary;

    /* JADX INFO: compiled from: CallFeatureEntity.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eJ.\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/database/entity/CallFeatureEntity$Companion;", "", "()V", "FEATURE_CALL_INTELLIGENT_MASK", "", "FEATURE_CALL_RECORD_MASK", "FEATURE_CALL_SUMMARY_MASK", "STATUS_ASR_FAIL_CAN_NOT_USE_MOBILE_NETWORK", "STATUS_CALL_RECORD_ASR_MASK", "STATUS_CALL_RECORD_ASR_WORKING_MASK", "STATUS_CALL_SUMMARY_MASK", "STATUS_ONLY_USE_INTELLIGENT_CALL", "getFeature", "summaryEnabled", "", "recordEnabled", "intelligentCallEnable", "getStatus", "summaryAvailable", "recordASRAvailable", "recordASRWorking", "onlyUseIntelligentCall", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int getFeature(boolean r1, boolean r2, boolean r3) {
            if (r2 == false) goto L4;
            ?? r4 = (r1 ? 1 : 0) | 2;
        L4:
            if (r3 == true) goto L6;
            return r4;
        L6:
            return r4 | 4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int getStatus(boolean r1, boolean r2, boolean r3, boolean r4) {
            if (r2 == false) goto L4;
            int r5 = (r1 ? 1 : 0) | 2;
        L4:
            if (r3 == false) goto L6;
            r5 = (r5 == true ? 1 : 0) | 4;
        L6:
            if (r4 == true) goto L8;
            return r5;
        L8:
            return r5 | 8;
        }

        private Companion() {
        }

        public static /* synthetic */ int getFeature$default(Companion r1, boolean r2, boolean r3, boolean r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = false;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r4 = false;
        L12:
            return r1.getFeature(r2, r3, r4);
        }

        public static /* synthetic */ int getStatus$default(Companion r1, boolean r2, boolean r3, boolean r4, boolean r5, int r6, Object r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = false;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = false;
        L12:
            if ((r6 & 8) == 0) goto L15;
            r5 = false;
        L15:
            return r1.getStatus(r2, r3, r4, r5);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ CallFeatureEntity copy$default(CallFeatureEntity r9, long r10, int r12, int r13, String r14, String r15, long r16, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        long r1 = r9.callCreateTime;
    L7:
        if ((r18 & 2) == 0) goto L9;
        int r3 = r9.feature;
    L11:
        if ((r18 & 4) == 0) goto L13;
        int r4 = r9.status;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.summary;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.phoneNumber;
    L23:
        if ((r18 & 32) == 0) goto L25;
        long r7 = r9.id;
    L27:
        return r9.copy(r1, r3, r4, r5, r6, r7);
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final long component1() {
        return this.callCreateTime;
    }

    public final int component2() {
        return this.feature;
    }

    public final int component3() {
        return this.status;
    }

    public final String component4() {
        return this.summary;
    }

    public final String component5() {
        return this.phoneNumber;
    }

    public final long component6() {
        return this.id;
    }

    public final CallFeatureEntity copy(long r11, int r13, int r14, String r15, String r16, long r17) {
        return new CallFeatureEntity(r11, r13, r14, r15, r16, r17);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof CallFeatureEntity) == true) goto L8;
        return false;
    L8:
        CallFeatureEntity r9 = (CallFeatureEntity) r8;
        if (this.callCreateTime == r9.callCreateTime) goto L12;
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
        if (Intrinsics.areEqual(this.phoneNumber, r9.phoneNumber) == true) goto L24;
        return false;
    L24:
        if (this.id == r9.id) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Long.hashCode(this.callCreateTime) * 31) + Integer.hashCode(this.feature)) * 31) + Integer.hashCode(this.status)) * 31;
        String r1 = this.summary;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.phoneNumber;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + Long.hashCode(this.id);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "CallFeatureEntity(callCreateTime=" + this.callCreateTime + ", feature=" + this.feature + ", status=" + this.status + ", summary=" + this.summary + ", phoneNumber=" + this.phoneNumber + ", id=" + this.id + ')';
    }

    public CallFeatureEntity(long r1, int r3, int r4, String r5, String r6, long r7) {
        this.callCreateTime = r1;
        this.feature = r3;
        this.status = r4;
        this.summary = r5;
        this.phoneNumber = r6;
        this.id = r7;
    }

    public /* synthetic */ CallFeatureEntity(long r12, int r14, int r15, String r16, String r17, long r18, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 32) == 0) goto L5;
        long r9 = 0;
    L6:
        this(r12, r14, r15, r16, r17, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }

    public final long getCallCreateTime() {
        return this.callCreateTime;
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

    public final String getSummary() {
        return this.summary;
    }

    public final void setSummary(String r1) {
        this.summary = r1;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final long getId() {
        return this.id;
    }

    public final void changeStatus(int r2, boolean r3) {
        if (r3 == false) goto L4;
        int r4 = r2 | (this.status & (~r2));
    L5:
        this.status = r4;
        return;
    L4:
        int r5 = this.status;
        r4 = (~r2) & r5;
        goto L5
    }
}
