package com.obric.tracker.event;

import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.tracker.intf.event.ISlardarEvent;
import com.obric.tracker.intf.event.ITeaEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: CallSummaryEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u000fHÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jy\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u000fHÆ\u0001J\u0013\u0010.\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\b\u00101\u001a\u00020\u000fH\u0016J\u0014\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020003H\u0016J\b\u00104\u001a\u00020\u000fH\u0016J\b\u00105\u001a\u000206H\u0016J\u0014\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020003H\u0016J\u0014\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n03H\u0016J\b\u00109\u001a\u00020\u000fH\u0016J\t\u0010:\u001a\u00020\u0004HÖ\u0001J\t\u0010;\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0011\u001a\u00020\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001aR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u0006<"}, d2 = {"Lcom/obric/tracker/event/CallSummaryEvent;", "Lcom/obric/tracker/intf/event/ITeaEvent;", "Lcom/obric/tracker/intf/event/ISlardarEvent;", "modelType", "", "isSummarySuccess", "", "inputTextLength", "outputTextLength", "summaryDuration", "", "callDuration", "summaryRecordDurationMs", "sentenceCount", "summaryErrorCode", "", "is_retry", "eventId", "(IZIIJJJILjava/lang/String;ILjava/lang/String;)V", "getCallDuration", "()J", "getEventId", "()Ljava/lang/String;", "setEventId", "(Ljava/lang/String;)V", "getInputTextLength", "()I", "()Z", "getModelType", "getOutputTextLength", "getSentenceCount", "getSummaryDuration", "getSummaryErrorCode", "getSummaryRecordDurationMs", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "getAction", "getCategoryParams", "", "getEventName", "getEventParams", "Lorg/json/JSONObject;", "getExtraParams", "getMetricsParams", "getScene", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallSummaryEvent implements ITeaEvent, ISlardarEvent {
    private final long callDuration;
    private String eventId;
    private final int inputTextLength;
    private final boolean isSummarySuccess;
    private final int is_retry;
    private final int modelType;
    private final int outputTextLength;
    private final int sentenceCount;
    private final long summaryDuration;
    private final String summaryErrorCode;
    private final long summaryRecordDurationMs;

    public static /* synthetic */ CallSummaryEvent copy$default(CallSummaryEvent r15, int r16, boolean r17, int r18, int r19, long r20, long r22, long r24, int r26, String r27, int r28, String r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        int r2 = r15.modelType;
    L7:
        if ((r30 & 2) == 0) goto L9;
        boolean r3 = r15.isSummarySuccess;
    L11:
        if ((r30 & 4) == 0) goto L13;
        int r4 = r15.inputTextLength;
    L15:
        if ((r30 & 8) == 0) goto L17;
        int r5 = r15.outputTextLength;
    L19:
        if ((r30 & 16) == 0) goto L21;
        long r6 = r15.summaryDuration;
    L23:
        if ((r30 & 32) == 0) goto L25;
        long r8 = r15.callDuration;
    L27:
        if ((r30 & 64) == 0) goto L29;
        long r10 = r15.summaryRecordDurationMs;
    L31:
        if ((r30 & 128) == 0) goto L33;
        int r12 = r15.sentenceCount;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r13 = r15.summaryErrorCode;
    L39:
        if ((r30 & 512) == 0) goto L41;
        int r14 = r15.is_retry;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r1 = r15.eventId;
    L47:
        return r15.copy(r2, r3, r4, r5, r6, r8, r10, r12, r13, r14, r1);
    L45:
        r1 = r29;
        goto L47
    L41:
        r14 = r28;
        goto L43
    L37:
        r13 = r27;
        goto L39
    L33:
        r12 = r26;
        goto L35
    L29:
        r10 = r24;
        goto L31
    L25:
        r8 = r22;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final int component1() {
        return this.modelType;
    }

    public final int component10() {
        return this.is_retry;
    }

    public final String component11() {
        return this.eventId;
    }

    public final boolean component2() {
        return this.isSummarySuccess;
    }

    public final int component3() {
        return this.inputTextLength;
    }

    public final int component4() {
        return this.outputTextLength;
    }

    public final long component5() {
        return this.summaryDuration;
    }

    public final long component6() {
        return this.callDuration;
    }

    public final long component7() {
        return this.summaryRecordDurationMs;
    }

    public final int component8() {
        return this.sentenceCount;
    }

    public final String component9() {
        return this.summaryErrorCode;
    }

    public final CallSummaryEvent copy(int r17, boolean r18, int r19, int r20, long r21, long r23, long r25, int r27, String r28, int r29, String r30) {
        Intrinsics.checkNotNullParameter(r30, "eventId");
        return new CallSummaryEvent(r17, r18, r19, r20, r21, r23, r25, r27, r28, r29, r30);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof CallSummaryEvent) == true) goto L8;
        return false;
    L8:
        CallSummaryEvent r9 = (CallSummaryEvent) r8;
        if (this.modelType == r9.modelType) goto L12;
        return false;
    L12:
        if (this.isSummarySuccess == r9.isSummarySuccess) goto L15;
        return false;
    L15:
        if (this.inputTextLength == r9.inputTextLength) goto L18;
        return false;
    L18:
        if (this.outputTextLength == r9.outputTextLength) goto L21;
        return false;
    L21:
        if (this.summaryDuration == r9.summaryDuration) goto L24;
        return false;
    L24:
        if (this.callDuration == r9.callDuration) goto L27;
        return false;
    L27:
        if (this.summaryRecordDurationMs == r9.summaryRecordDurationMs) goto L30;
        return false;
    L30:
        if (this.sentenceCount == r9.sentenceCount) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.summaryErrorCode, r9.summaryErrorCode) == true) goto L36;
        return false;
    L36:
        if (this.is_retry == r9.is_retry) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.eventId, r9.eventId) == true) goto L41;
        return false;
    L41:
        return true;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    /* JADX INFO: renamed from: getAction */
    public String mo779getAction() {
        return EventNameConstantsKt.CALL_SUMMARY_EVENT_NAME;
    }

    @Override // com.obric.tracker.intf.event.ITeaEvent
    public String getEventName() {
        return EventNameConstantsKt.CALL_SUMMARY_EVENT_NAME;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public String getScene() {
        return "scene";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    public int hashCode() {
        int r0 = Integer.hashCode(this.modelType) * 31;
        boolean r1 = this.isSummarySuccess;
        ?? r2 = r1;
        if (r1 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = (((((((((((((r0 + r2) * 31) + Integer.hashCode(this.inputTextLength)) * 31) + Integer.hashCode(this.outputTextLength)) * 31) + Long.hashCode(this.summaryDuration)) * 31) + Long.hashCode(this.callDuration)) * 31) + Long.hashCode(this.summaryRecordDurationMs)) * 31) + Integer.hashCode(this.sentenceCount)) * 31;
        String r4 = this.summaryErrorCode;
        if (r4 != null) goto L8;
        int r5 = 0;
    L10:
        return ((((r3 + r5) * 31) + Integer.hashCode(this.is_retry)) * 31) + this.eventId.hashCode();
    L8:
        r5 = r4.hashCode();
        goto L10
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("CallSummaryEvent(modelType=");
        r0.append(this.modelType).append(", isSummarySuccess=").append(this.isSummarySuccess).append(", inputTextLength=").append(this.inputTextLength).append(", outputTextLength=").append(this.outputTextLength).append(", summaryDuration=").append(this.summaryDuration).append(", callDuration=").append(this.callDuration).append(", summaryRecordDurationMs=").append(this.summaryRecordDurationMs).append(", sentenceCount=").append(this.sentenceCount).append(", summaryErrorCode=").append(this.summaryErrorCode).append(", is_retry=").append(this.is_retry).append(", eventId=").append(this.eventId).append(')');
        return r0.toString();
    }

    public CallSummaryEvent(int r2, boolean r3, int r4, int r5, long r6, long r8, long r10, int r12, String r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r15, "eventId");
        this.modelType = r2;
        this.isSummarySuccess = r3;
        this.inputTextLength = r4;
        this.outputTextLength = r5;
        this.summaryDuration = r6;
        this.callDuration = r8;
        this.summaryRecordDurationMs = r10;
        this.sentenceCount = r12;
        this.summaryErrorCode = r13;
        this.is_retry = r14;
        this.eventId = r15;
    }

    public /* synthetic */ CallSummaryEvent(int r17, boolean r18, int r19, int r20, long r21, long r23, long r25, int r27, String r28, int r29, String r30, int r31, DefaultConstructorMarker r32) {
        if ((r31 & 1024) == 0) goto L5;
        String r15 = "";
    L6:
        this(r17, r18, r19, r20, r21, r23, r25, r27, r28, r29, r15);
        return;
    L5:
        r15 = r30;
        goto L6
    }

    public final int getModelType() {
        return this.modelType;
    }

    public final boolean isSummarySuccess() {
        return this.isSummarySuccess;
    }

    public final int getInputTextLength() {
        return this.inputTextLength;
    }

    public final int getOutputTextLength() {
        return this.outputTextLength;
    }

    public final long getSummaryDuration() {
        return this.summaryDuration;
    }

    public final long getCallDuration() {
        return this.callDuration;
    }

    public final long getSummaryRecordDurationMs() {
        return this.summaryRecordDurationMs;
    }

    public final int getSentenceCount() {
        return this.sentenceCount;
    }

    public final String getSummaryErrorCode() {
        return this.summaryErrorCode;
    }

    public final int is_retry() {
        return this.is_retry;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public String getEventId() {
        return this.eventId;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public void setEventId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.eventId = r2;
    }

    @Override // com.obric.tracker.intf.event.ITeaEvent
    public JSONObject getEventParams() {
        JSONObject r0 = new JSONObject();
        r0.put("did", MatrixTeaManager.Companion.getInstance().getDeviceId());
        r0.put("package_name", "com.android.contacts");
        r0.put("model_type", this.modelType);
        r0.put("is_summary_success", this.isSummarySuccess ? 1 : 0);
        r0.put("input_text_length", this.inputTextLength);
        r0.put("output_text_length", this.outputTextLength);
        r0.put("summary_duration", this.summaryDuration);
        r0.put("call_duration", this.callDuration);
        r0.put("summary_record_duration_ms", this.summaryRecordDurationMs);
        r0.put("sentence_count", this.sentenceCount);
        r0.put("is_retry", this.is_retry);
        String r4 = this.summaryErrorCode;
        if (r4 == null) goto L5;
        r0.put("summary_error_code", r4);
    L5:
        return r0;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public Map<String, Object> getCategoryParams() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("package_name", "com.android.contacts");
        r0.put("model_type", Integer.valueOf(this.modelType));
        r0.put("is_summary_success", Integer.valueOf(this.isSummarySuccess ? 1 : 0));
        r0.put("input_text_length", Integer.valueOf(this.inputTextLength));
        r0.put("output_text_length", Integer.valueOf(this.outputTextLength));
        r0.put("summary_duration", Long.valueOf(this.summaryDuration));
        r0.put("call_duration", Long.valueOf(this.callDuration));
        r0.put("summary_record_duration_ms", Long.valueOf(this.summaryRecordDurationMs));
        r0.put("sentence_count", Integer.valueOf(this.sentenceCount));
        r0.put("is_retry", Integer.valueOf(this.is_retry));
        String r3 = this.summaryErrorCode;
        if (r3 == null) goto L5;
        r0.put("summary_error_code", r3);
    L5:
        return r0;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public Map<String, Long> getMetricsParams() {
        return new LinkedHashMap();
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public Map<String, Object> getExtraParams() {
        return new LinkedHashMap();
    }
}
