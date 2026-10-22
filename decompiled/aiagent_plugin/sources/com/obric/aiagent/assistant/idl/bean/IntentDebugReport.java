package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IntentExecutionReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentDebugReport implements Parcelable {
    public static final Parcelable.Creator<IntentDebugReport> CREATOR = null;

    @SerializedName("ACTION_RESULT")
    private String actionResult;

    @SerializedName("COST_TIME")
    private String costTime;

    @SerializedName("ENGINE_ERROR_MSG")
    private String engineErrorMsg;

    @SerializedName("ENGINE_RESULT_CODE")
    private String engineResultCode;

    @SerializedName("PC_SEARCH_RESULT")
    private String firstIntentResult;

    @SerializedName("DOMAIN")
    private String intentDomain;

    @SerializedName("INTENT_NAME")
    private String intentName;

    @SerializedName("INTENT_PARAMETERS")
    private String intentParameters;

    @SerializedName("IS_APP_INTENT")
    private final String isAppIntent;

    @SerializedName("RESULT_CODE")
    private Integer resultCode;

    /* JADX INFO: compiled from: IntentExecutionReport.kt */
    public static final class Creator implements Parcelable.Creator<IntentDebugReport> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IntentDebugReport createFromParcel(Parcel r12) {
            o.e(r12, "parcel");
            String r1 = r12.readString();
            String r2 = r12.readString();
            String r3 = r12.readString();
            String r4 = r12.readString();
            String r5 = r12.readString();
            String r6 = r12.readString();
            String r7 = r12.readString();
            String r8 = r12.readString();
            String r9 = r12.readString();
            if (r12.readInt() != 0) goto L5;
            Integer r13 = null;
        L7:
            return new IntentDebugReport(r1, r2, r3, r4, r5, r6, r7, r8, r9, r13);
        L5:
            r13 = Integer.valueOf(r12.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntentDebugReport createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IntentDebugReport[] newArray(int r1) {
            return new IntentDebugReport[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntentDebugReport[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public IntentDebugReport() {
        this(null, null, null, null, null, null, null, null, null, null, DownloadErrorCode.ERROR_IO, null);
    }

    public static /* synthetic */ IntentDebugReport copy$default(IntentDebugReport r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, Integer r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.isAppIntent;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.intentDomain;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.intentName;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.intentParameters;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.firstIntentResult;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.engineResultCode;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = r11.engineErrorMsg;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = r11.costTime;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = r11.actionResult;
    L39:
        if ((r22 & 512) == 0) goto L41;
        Integer r1 = r11.resultCode;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String component1() {
        return this.isAppIntent;
    }

    public final Integer component10() {
        return this.resultCode;
    }

    public final String component2() {
        return this.intentDomain;
    }

    public final String component3() {
        return this.intentName;
    }

    public final String component4() {
        return this.intentParameters;
    }

    public final String component5() {
        return this.firstIntentResult;
    }

    public final String component6() {
        return this.engineResultCode;
    }

    public final String component7() {
        return this.engineErrorMsg;
    }

    public final String component8() {
        return this.costTime;
    }

    public final String component9() {
        return this.actionResult;
    }

    public final IntentDebugReport copy(String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, Integer r22) {
        return new IntentDebugReport(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, IntentDebugReport.class) == true) goto L8;
        return false;
    L8:
        IntentDebugReport r6 = (IntentDebugReport) ZeusTransformUtils.preCheckCast(r5, IntentDebugReport.class, "com.obric.aiagent.plugin");
        if (o.a(this.isAppIntent, r6.isAppIntent) == true) goto L12;
        return false;
    L12:
        if (o.a(this.intentDomain, r6.intentDomain) == true) goto L15;
        return false;
    L15:
        if (o.a(this.intentName, r6.intentName) == true) goto L18;
        return false;
    L18:
        if (o.a(this.intentParameters, r6.intentParameters) == true) goto L21;
        return false;
    L21:
        if (o.a(this.firstIntentResult, r6.firstIntentResult) == true) goto L24;
        return false;
    L24:
        if (o.a(this.engineResultCode, r6.engineResultCode) == true) goto L27;
        return false;
    L27:
        if (o.a(this.engineErrorMsg, r6.engineErrorMsg) == true) goto L30;
        return false;
    L30:
        if (o.a(this.costTime, r6.costTime) == true) goto L33;
        return false;
    L33:
        if (o.a(this.actionResult, r6.actionResult) == true) goto L36;
        return false;
    L36:
        if (o.a(this.resultCode, r6.resultCode) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r0 = this.isAppIntent;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.intentDomain;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.intentName;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.intentParameters;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.firstIntentResult;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.engineResultCode;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.engineErrorMsg;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.costTime;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.actionResult;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.resultCode;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "IntentDebugReport(isAppIntent=" + this.isAppIntent + ", intentDomain=" + this.intentDomain + ", intentName=" + this.intentName + ", intentParameters=" + this.intentParameters + ", firstIntentResult=" + this.firstIntentResult + ", engineResultCode=" + this.engineResultCode + ", engineErrorMsg=" + this.engineErrorMsg + ", costTime=" + this.costTime + ", actionResult=" + this.actionResult + ", resultCode=" + this.resultCode + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(this.isAppIntent);
        r1.writeString(this.intentDomain);
        r1.writeString(this.intentName);
        r1.writeString(this.intentParameters);
        r1.writeString(this.firstIntentResult);
        r1.writeString(this.engineResultCode);
        r1.writeString(this.engineErrorMsg);
        r1.writeString(this.costTime);
        r1.writeString(this.actionResult);
        Integer r0 = this.resultCode;
        if (r0 != null) goto L5;
        int r3 = 0;
    L6:
        r1.writeInt(r3);
        return;
    L5:
        r1.writeInt(1);
        r3 = r0.intValue();
        goto L6
    }

    public IntentDebugReport(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, Integer r10) {
        this.isAppIntent = r1;
        this.intentDomain = r2;
        this.intentName = r3;
        this.intentParameters = r4;
        this.firstIntentResult = r5;
        this.engineResultCode = r6;
        this.engineErrorMsg = r7;
        this.costTime = r8;
        this.actionResult = r9;
        this.resultCode = r10;
    }

    public final String isAppIntent() {
        return this.isAppIntent;
    }

    public final String getIntentDomain() {
        return this.intentDomain;
    }

    public final void setIntentDomain(String r1) {
        this.intentDomain = r1;
    }

    public final String getIntentName() {
        return this.intentName;
    }

    public final void setIntentName(String r1) {
        this.intentName = r1;
    }

    public final String getIntentParameters() {
        return this.intentParameters;
    }

    public final void setIntentParameters(String r1) {
        this.intentParameters = r1;
    }

    public final String getFirstIntentResult() {
        return this.firstIntentResult;
    }

    public final void setFirstIntentResult(String r1) {
        this.firstIntentResult = r1;
    }

    public final String getEngineResultCode() {
        return this.engineResultCode;
    }

    public final void setEngineResultCode(String r1) {
        this.engineResultCode = r1;
    }

    public final String getEngineErrorMsg() {
        return this.engineErrorMsg;
    }

    public final void setEngineErrorMsg(String r1) {
        this.engineErrorMsg = r1;
    }

    public final String getCostTime() {
        return this.costTime;
    }

    public final void setCostTime(String r1) {
        this.costTime = r1;
    }

    public final String getActionResult() {
        return this.actionResult;
    }

    public final void setActionResult(String r1) {
        this.actionResult = r1;
    }

    public final Integer getResultCode() {
        return this.resultCode;
    }

    public final void setResultCode(Integer r1) {
        this.resultCode = r1;
    }

    public /* synthetic */ IntentDebugReport(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, Integer r11, int r12, h r13) {
        if ((r12 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r12 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r12 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r12 & 8) == 0) goto L15;
        r5 = "";
    L15:
        if ((r12 & 16) == 0) goto L18;
        r6 = "";
    L18:
        if ((r12 & 32) == 0) goto L21;
        r7 = "";
    L21:
        if ((r12 & 64) == 0) goto L24;
        r8 = "";
    L24:
        if ((r12 & 128) == 0) goto L27;
        r9 = "";
    L27:
        if ((r12 & 256) == 0) goto L30;
        r10 = "";
    L30:
        if ((r12 & 512) == 0) goto L32;
        r11 = 0;
    L32:
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }
}
