package com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: IAppFunctionConvert.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFunctionConvertRequest {
    private final long actionId;
    private final String argumentsJson;
    private final String convertClassName;
    private final Map<String, String> ext;
    private final Map<String, String> extras;
    private final String intentName;
    private final long jobId;
    private final long messageId;
    private final String nodeId;
    private final String nodeResultsJson;
    private final long questionId;

    public static /* synthetic */ AppFunctionConvertRequest copy$default(AppFunctionConvertRequest r16, String r17, long r18, long r20, long r22, long r24, String r26, String r27, String r28, String r29, Map r30, Map r31, int r32, Object r33) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r30, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r31, Map.class, "com.obric.aiagent.plugin");
        if ((r32 & 1) == 0) goto L5;
        String r4 = r16.intentName;
    L7:
        if ((r32 & 2) == 0) goto L9;
        long r5 = r16.questionId;
    L11:
        if ((r32 & 4) == 0) goto L13;
        long r7 = r16.messageId;
    L15:
        if ((r32 & 8) == 0) goto L17;
        long r9 = r16.actionId;
    L19:
        if ((r32 & 16) == 0) goto L21;
        long r11 = r16.jobId;
    L23:
        if ((r32 & 32) == 0) goto L25;
        String r13 = r16.nodeId;
    L27:
        if ((r32 & 64) == 0) goto L29;
        String r14 = r16.convertClassName;
    L31:
        if ((r32 & 128) == 0) goto L33;
        String r15 = r16.argumentsJson;
    L35:
        if ((r32 & 256) == 0) goto L37;
        String r6 = r16.nodeResultsJson;
    L39:
        if ((r32 & 512) == 0) goto L41;
        Map<String, String> r8 = r16.extras;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        Map<String, String> r1 = r16.ext;
    L47:
        return r16.copy(r4, r5, r7, r9, r11, r13, r14, r15, r6, r8, r1);
    L45:
        r1 = r3;
        goto L47
    L41:
        r8 = r2;
        goto L43
    L37:
        r6 = r29;
        goto L39
    L33:
        r15 = r28;
        goto L35
    L29:
        r14 = r27;
        goto L31
    L25:
        r13 = r26;
        goto L27
    L21:
        r11 = r24;
        goto L23
    L17:
        r9 = r22;
        goto L19
    L13:
        r7 = r20;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }

    public final String component1() {
        return this.intentName;
    }

    public final Map<String, String> component10() {
        return this.extras;
    }

    public final Map<String, String> component11() {
        return this.ext;
    }

    public final long component2() {
        return this.questionId;
    }

    public final long component3() {
        return this.messageId;
    }

    public final long component4() {
        return this.actionId;
    }

    public final long component5() {
        return this.jobId;
    }

    public final String component6() {
        return this.nodeId;
    }

    public final String component7() {
        return this.convertClassName;
    }

    public final String component8() {
        return this.argumentsJson;
    }

    public final String component9() {
        return this.nodeResultsJson;
    }

    public final AppFunctionConvertRequest copy(String r19, long r20, long r22, long r24, long r26, String r28, String r29, String r30, String r31, Map<String, String> r32, Map<String, String> r33) {
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r32, Map.class, "com.obric.aiagent.plugin");
        Map r17 = (Map) ZeusTransformUtils.wrapperContextForParams(r33, Map.class, "com.obric.aiagent.plugin");
        o.e(r19, "intentName");
        o.e(r28, "nodeId");
        o.e(r29, "convertClassName");
        return new AppFunctionConvertRequest(r19, r20, r22, r24, r26, r28, r29, r30, r31, r16, r17);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AppFunctionConvertRequest.class) == true) goto L8;
        return false;
    L8:
        AppFunctionConvertRequest r10 = (AppFunctionConvertRequest) ZeusTransformUtils.preCheckCast(r9, AppFunctionConvertRequest.class, "com.obric.aiagent.plugin");
        if (o.a(this.intentName, r10.intentName) == true) goto L12;
        return false;
    L12:
        if (this.questionId == r10.questionId) goto L15;
        return false;
    L15:
        if (this.messageId == r10.messageId) goto L18;
        return false;
    L18:
        if (this.actionId == r10.actionId) goto L21;
        return false;
    L21:
        if (this.jobId == r10.jobId) goto L24;
        return false;
    L24:
        if (o.a(this.nodeId, r10.nodeId) == true) goto L27;
        return false;
    L27:
        if (o.a(this.convertClassName, r10.convertClassName) == true) goto L30;
        return false;
    L30:
        if (o.a(this.argumentsJson, r10.argumentsJson) == true) goto L33;
        return false;
    L33:
        if (o.a(this.nodeResultsJson, r10.nodeResultsJson) == true) goto L36;
        return false;
    L36:
        if (o.a(this.extras, r10.extras) == true) goto L39;
        return false;
    L39:
        if (o.a(this.ext, r10.ext) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((this.intentName.hashCode() * 31) + Long.hashCode(this.questionId)) * 31) + Long.hashCode(this.messageId)) * 31) + Long.hashCode(this.actionId)) * 31) + Long.hashCode(this.jobId)) * 31) + this.nodeId.hashCode()) * 31) + this.convertClassName.hashCode()) * 31;
        String r1 = this.argumentsJson;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.nodeResultsJson;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Map<String, String> r8 = this.extras;
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

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AppFunctionConvertRequest(intentName=").append(this.intentName).append(", questionId=").append(this.questionId).append(", messageId=").append(this.messageId).append(", actionId=").append(this.actionId).append(", jobId=").append(this.jobId).append(", nodeId=").append(this.nodeId).append(", convertClassName=").append(this.convertClassName).append(", argumentsJson=").append(this.argumentsJson).append(", nodeResultsJson=").append(this.nodeResultsJson).append(", extras=").append(this.extras).append(", ext=").append(this.ext).append(')');
        return r0.toString();
    }

    public AppFunctionConvertRequest(String r9, long r10, long r12, long r14, long r16, String r18, String r19, String r20, String r21, Map<String, String> r22, Map<String, String> r23) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        o.e(r9, "intentName");
        o.e(r18, "nodeId");
        o.e(r19, "convertClassName");
        this.intentName = r9;
        this.questionId = r10;
        this.messageId = r12;
        this.actionId = r14;
        this.jobId = r16;
        this.nodeId = r18;
        this.convertClassName = r19;
        this.argumentsJson = r20;
        this.nodeResultsJson = r21;
        this.extras = r4;
        this.ext = r5;
    }

    public /* synthetic */ AppFunctionConvertRequest(String r22, long r23, long r25, long r27, long r29, String r31, String r32, String r33, String r34, Map r35, Map r36, int r37, h r38) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r35, Map.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r36, Map.class, "com.obric.aiagent.plugin");
        if ((r37 & 128) == 0) goto L5;
        String r17 = null;
    L7:
        if ((r37 & 256) == 0) goto L9;
        String r18 = null;
    L11:
        if ((r37 & 512) == 0) goto L13;
        Map r19 = null;
    L15:
        if ((r37 & 1024) == 0) goto L17;
        Map r20 = null;
    L18:
        this(r22, r23, r25, r27, r29, r31, r32, r17, r18, r19, r20);
        return;
    L17:
        r20 = r2;
        goto L18
    L13:
        r19 = r1;
        goto L15
    L9:
        r18 = r34;
        goto L11
    L5:
        r17 = r33;
        goto L7
    }

    public final String getIntentName() {
        return this.intentName;
    }

    public final long getQuestionId() {
        return this.questionId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final long getActionId() {
        return this.actionId;
    }

    public final long getJobId() {
        return this.jobId;
    }

    public final String getNodeId() {
        return this.nodeId;
    }

    public final String getConvertClassName() {
        return this.convertClassName;
    }

    public final String getArgumentsJson() {
        return this.argumentsJson;
    }

    public final String getNodeResultsJson() {
        return this.nodeResultsJson;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }
}
