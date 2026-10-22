package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class IntentCalling implements Parcelable {
    public static final Parcelable.Creator<IntentCalling> CREATOR = null;
    private final long actionId;
    public Map<String, String> ext;
    private final String implClassName;
    private final String inputParamTypeName;
    private final String inputParams;
    private final Parcelable inputParamsParcel;
    private final String intentName;
    private final long jobId;
    private final long messageId;
    private final long questionId;
    private final long replyFor;

    public static final class a implements Parcelable.Creator<IntentCalling> {
        public a() {
        }

        public final IntentCalling a(Parcel r22) {
            int r1 = r22.readInt();
            o.e(r22, "parcel");
            long r4 = r22.readLong();
            long r6 = r22.readLong();
            long r8 = r22.readLong();
            long r10 = r22.readLong();
            long r12 = r22.readLong();
            String r14 = r22.readString();
            String r15 = r22.readString();
            String r16 = r22.readString();
            String r17 = r22.readString();
            Parcelable r18 = r22.readParcelable(IntentCalling.class.getClassLoader());
            if (r22.readInt() != 0) goto L5;
            int r20 = r1;
            LinkedHashMap r19 = null;
        L9:
            IntentCalling r0 = new IntentCalling(r4, r6, r8, r10, r12, r14, r15, r16, r17, r18, r19);
            int r2 = r20;
            int r3 = Math.min(r2, 1);
            ClassLoader r5 = a.class.getClassLoader();
            int r7 = 1;
        L11:
            if (r7 > r3) goto L17;
            if (r7 != 1) goto L16;
            Object r9 = com.obric.a.a.b(r22, r5);
            if (r9 == null) goto L16;
            r0.ext = (Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.aiagent.plugin");
        L16:
            r7 = r7 + 1;
        L17:
            if (r7 > r2) goto L19;
            com.obric.a.a.a(r22, r5);
            r7 = r7 + 1;
            goto L17
        L19:
            return r0;
        L5:
            int r11 = r22.readInt();
            LinkedHashMap r13 = new LinkedHashMap(r11);
            int r21 = 0;
        L6:
            if (r21 == r11) goto L8;
            r13.put(r22.readString(), r22.readString());
            r21 = r21 + 1;
            r11 = r11;
            r1 = r1;
            goto L6
        L8:
            r20 = r1;
            r19 = r13;
            goto L9
        }

        public final IntentCalling[] a(int r1) {
            return new IntentCalling[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ IntentCalling createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ IntentCalling[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public IntentCalling(long r8, long r10, long r12, long r14, long r16, String r18, String r19, String r20, String r21, Parcelable r22, Map<String, String> r23) {
        Parcelable r3 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r22, Parcelable.class, "com.obric.aiagent.plugin");
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        o.e(r18, "intentName");
        o.e(r19, "implClassName");
        this.questionId = r8;
        this.messageId = r10;
        this.actionId = r12;
        this.jobId = r14;
        this.replyFor = r16;
        this.intentName = r18;
        this.implClassName = r19;
        this.inputParamTypeName = r20;
        this.inputParams = r21;
        this.inputParamsParcel = r3;
        this.ext = r4;
    }

    public static /* synthetic */ IntentCalling copy$default(IntentCalling r16, long r17, long r19, long r21, long r23, long r25, String r27, String r28, String r29, String r30, Parcelable r31, Map r32, int r33, Object r34) {
        Parcelable r2 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r31, Parcelable.class, "com.obric.aiagent.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r32, Map.class, "com.obric.aiagent.plugin");
        if ((r33 & 1) == 0) goto L5;
        long r4 = r16.questionId;
    L7:
        if ((r33 & 2) == 0) goto L9;
        long r6 = r16.messageId;
    L11:
        if ((r33 & 4) == 0) goto L13;
        long r8 = r16.actionId;
    L15:
        if ((r33 & 8) == 0) goto L17;
        long r10 = r16.jobId;
    L19:
        if ((r33 & 16) == 0) goto L21;
        long r12 = r16.replyFor;
    L23:
        if ((r33 & 32) == 0) goto L25;
        String r14 = r16.intentName;
    L27:
        if ((r33 & 64) == 0) goto L29;
        String r15 = r16.implClassName;
    L31:
        if ((r33 & 128) == 0) goto L33;
        String r5 = r16.inputParamTypeName;
    L35:
        if ((r33 & 256) == 0) goto L37;
        String r7 = r16.inputParams;
    L38:
        String r35 = r7;
        if ((r33 & 512) == 0) goto L41;
        Parcelable r9 = r16.inputParamsParcel;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        Map<String, String> r1 = r16.ext;
    L47:
        return r16.copy(r4, r6, r8, r10, r12, r14, r15, r5, r35, r9, r1);
    L45:
        r1 = r3;
        goto L47
    L41:
        r9 = r2;
        goto L43
    L37:
        r7 = r30;
        goto L38
    L33:
        r5 = r29;
        goto L35
    L29:
        r15 = r28;
        goto L31
    L25:
        r14 = r27;
        goto L27
    L21:
        r12 = r25;
        goto L23
    L17:
        r10 = r23;
        goto L19
    L13:
        r8 = r21;
        goto L15
    L9:
        r6 = r19;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }

    public final long component1() {
        return this.questionId;
    }

    public final Parcelable component10() {
        return this.inputParamsParcel;
    }

    public final Map<String, String> component11() {
        return this.ext;
    }

    public final long component2() {
        return this.messageId;
    }

    public final long component3() {
        return this.actionId;
    }

    public final long component4() {
        return this.jobId;
    }

    public final long component5() {
        return this.replyFor;
    }

    public final String component6() {
        return this.intentName;
    }

    public final String component7() {
        return this.implClassName;
    }

    public final String component8() {
        return this.inputParamTypeName;
    }

    public final String component9() {
        return this.inputParams;
    }

    public final IntentCalling copy(long r19, long r21, long r23, long r25, long r27, String r29, String r30, String r31, String r32, Parcelable r33, Map<String, String> r34) {
        Parcelable r0 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r33, Parcelable.class, "com.obric.aiagent.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r34, Map.class, "com.obric.aiagent.plugin");
        o.e(r29, "intentName");
        o.e(r30, "implClassName");
        return new IntentCalling(r19, r21, r23, r25, r27, r29, r30, r31, r32, r0, r16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, IntentCalling.class) == true) goto L8;
        return false;
    L8:
        IntentCalling r10 = (IntentCalling) ZeusTransformUtils.preCheckCast(r9, IntentCalling.class, "com.obric.aiagent.plugin");
        if (this.questionId == r10.questionId) goto L12;
        return false;
    L12:
        if (this.messageId == r10.messageId) goto L15;
        return false;
    L15:
        if (this.actionId == r10.actionId) goto L18;
        return false;
    L18:
        if (this.jobId == r10.jobId) goto L21;
        return false;
    L21:
        if (this.replyFor == r10.replyFor) goto L24;
        return false;
    L24:
        if (o.a(this.intentName, r10.intentName) == true) goto L27;
        return false;
    L27:
        if (o.a(this.implClassName, r10.implClassName) == true) goto L30;
        return false;
    L30:
        if (o.a(this.inputParamTypeName, r10.inputParamTypeName) == true) goto L33;
        return false;
    L33:
        if (o.a(this.inputParams, r10.inputParams) == true) goto L36;
        return false;
    L36:
        if (o.a(this.inputParamsParcel, r10.inputParamsParcel) == true) goto L39;
        return false;
    L39:
        if (o.a(this.ext, r10.ext) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final long getActionId() {
        return this.actionId;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final String getImplClassName() {
        return this.implClassName;
    }

    public final String getInputParamTypeName() {
        return this.inputParamTypeName;
    }

    public final String getInputParams() {
        return this.inputParams;
    }

    public final Parcelable getInputParamsParcel() {
        return this.inputParamsParcel;
    }

    public final String getIntentName() {
        return this.intentName;
    }

    public final long getJobId() {
        return this.jobId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final long getQuestionId() {
        return this.questionId;
    }

    public final long getReplyFor() {
        return this.replyFor;
    }

    public int hashCode() {
        int r0 = ((((((((((((Long.hashCode(this.questionId) * 31) + Long.hashCode(this.messageId)) * 31) + Long.hashCode(this.actionId)) * 31) + Long.hashCode(this.jobId)) * 31) + Long.hashCode(this.replyFor)) * 31) + this.intentName.hashCode()) * 31) + this.implClassName.hashCode()) * 31;
        String r1 = this.inputParamTypeName;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.inputParams;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Parcelable r8 = this.inputParamsParcel;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Map<String, String> r11 = this.ext;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setExt(Map<String, String> r3) {
        this.ext = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("IntentCalling(questionId=").append(this.questionId).append(", messageId=").append(this.messageId).append(", actionId=").append(this.actionId).append(", jobId=").append(this.jobId).append(", replyFor=").append(this.replyFor).append(", intentName=").append(this.intentName).append(", implClassName=").append(this.implClassName).append(", inputParamTypeName=").append(this.inputParamTypeName).append(", inputParams=").append(this.inputParams).append(", inputParamsParcel=").append(this.inputParamsParcel).append(", ext=").append(this.ext).append(')');
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(1);
        o.e(r5, "out");
        r5.writeLong(this.questionId);
        r5.writeLong(this.messageId);
        r5.writeLong(this.actionId);
        r5.writeLong(this.jobId);
        r5.writeLong(this.replyFor);
        r5.writeString(this.intentName);
        r5.writeString(this.implClassName);
        r5.writeString(this.inputParamTypeName);
        r5.writeString(this.inputParams);
        r5.writeParcelable(this.inputParamsParcel, r6);
        Map<String, String> r7 = this.ext;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L9:
        r5.writeValue(this.ext);
        return;
    L5:
        r5.writeInt(1);
        r5.writeInt(r7.size());
        Iterator<Map.Entry<String, String>> r8 = r7.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r5.writeString((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin"));
        r5.writeString((String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L7
    }
}
