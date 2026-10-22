package stepai.aios.guiagent.tracer.remote;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\bO\b\u0086\b\u0018\u00002\u00020\u0001Bç\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010G\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010H\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u00105J\u009a\u0002\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020\r2\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020\u0005HÖ\u0001J\t\u0010[\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010 \"\u0004\b)\u0010*R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010-\u001a\u0004\b.\u0010,R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010-\u001a\u0004\b/\u0010,R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010 R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00106\u001a\u0004\b7\u00105R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00106\u001a\u0004\b8\u00105R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00106\u001a\u0004\b9\u00105R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00106\u001a\u0004\b:\u00105R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00106\u001a\u0004\b;\u00105R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00106\u001a\u0004\b<\u00105R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00106\u001a\u0004\b=\u00105R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u00106\u001a\u0004\b>\u00105¨\u0006\\"}, d2 = {"Lstepai/aios/guiagent/tracer/remote/GuiTraceCompressionEvent;", "", "stepId", "", "stepIndex", "", "actionType", "stepTitle", "updatedAt", "", "llmTraceId", "llmExtra", "triggered", "", "enabled", "configValid", "configIssues", "mode", "reason", "detail", "interval", "recentWindow", "maxFieldItems", "currentStep", "chunkStartStep", "chunkEndStep", "compressedUptoStep", "rawHistoryStartStep", "rawHistoryEndStep", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getStepId", "()Ljava/lang/String;", "getStepIndex", "()I", "getActionType", "getStepTitle", "getUpdatedAt", "()J", "getLlmTraceId", "getLlmExtra", "setLlmExtra", "(Ljava/lang/String;)V", "getTriggered", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnabled", "getConfigValid", "getConfigIssues", "getMode", "getReason", "getDetail", "getInterval", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRecentWindow", "getMaxFieldItems", "getCurrentStep", "getChunkStartStep", "getChunkEndStep", "getCompressedUptoStep", "getRawHistoryStartStep", "getRawHistoryEndStep", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lstepai/aios/guiagent/tracer/remote/GuiTraceCompressionEvent;", "equals", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiTraceCompressionEvent {
    private final String actionType;
    private final Integer chunkEndStep;
    private final Integer chunkStartStep;
    private final Integer compressedUptoStep;
    private final String configIssues;
    private final Boolean configValid;
    private final Integer currentStep;
    private final String detail;
    private final Boolean enabled;
    private final Integer interval;
    private String llmExtra;
    private final String llmTraceId;
    private final Integer maxFieldItems;
    private final String mode;
    private final Integer rawHistoryEndStep;
    private final Integer rawHistoryStartStep;
    private final String reason;
    private final Integer recentWindow;
    private final String stepId;
    private final int stepIndex;
    private final String stepTitle;
    private final Boolean triggered;
    private final long updatedAt;

    public GuiTraceCompressionEvent(String stepId, int i, String str, String stepTitle, long j5, String str2, String str3, Boolean bool, Boolean bool2, Boolean bool3, String str4, String str5, String str6, String str7, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9) {
        k.f(stepId, "stepId");
        k.f(stepTitle, "stepTitle");
        this.stepId = stepId;
        this.stepIndex = i;
        this.actionType = str;
        this.stepTitle = stepTitle;
        this.updatedAt = j5;
        this.llmTraceId = str2;
        this.llmExtra = str3;
        this.triggered = bool;
        this.enabled = bool2;
        this.configValid = bool3;
        this.configIssues = str4;
        this.mode = str5;
        this.reason = str6;
        this.detail = str7;
        this.interval = num;
        this.recentWindow = num2;
        this.maxFieldItems = num3;
        this.currentStep = num4;
        this.chunkStartStep = num5;
        this.chunkEndStep = num6;
        this.compressedUptoStep = num7;
        this.rawHistoryStartStep = num8;
        this.rawHistoryEndStep = num9;
    }

    public static /* synthetic */ GuiTraceCompressionEvent copy$default(GuiTraceCompressionEvent guiTraceCompressionEvent, String str, int i, String str2, String str3, long j5, String str4, String str5, Boolean bool, Boolean bool2, Boolean bool3, String str6, String str7, String str8, String str9, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, int i6, Object obj) {
        Integer num10;
        Integer num11;
        String str10 = (i6 & 1) != 0 ? guiTraceCompressionEvent.stepId : str;
        int i10 = (i6 & 2) != 0 ? guiTraceCompressionEvent.stepIndex : i;
        String str11 = (i6 & 4) != 0 ? guiTraceCompressionEvent.actionType : str2;
        String str12 = (i6 & 8) != 0 ? guiTraceCompressionEvent.stepTitle : str3;
        long j6 = (i6 & 16) != 0 ? guiTraceCompressionEvent.updatedAt : j5;
        String str13 = (i6 & 32) != 0 ? guiTraceCompressionEvent.llmTraceId : str4;
        String str14 = (i6 & 64) != 0 ? guiTraceCompressionEvent.llmExtra : str5;
        Boolean bool4 = (i6 & 128) != 0 ? guiTraceCompressionEvent.triggered : bool;
        Boolean bool5 = (i6 & 256) != 0 ? guiTraceCompressionEvent.enabled : bool2;
        Boolean bool6 = (i6 & 512) != 0 ? guiTraceCompressionEvent.configValid : bool3;
        String str15 = (i6 & 1024) != 0 ? guiTraceCompressionEvent.configIssues : str6;
        String str16 = (i6 & 2048) != 0 ? guiTraceCompressionEvent.mode : str7;
        String str17 = (i6 & 4096) != 0 ? guiTraceCompressionEvent.reason : str8;
        String str18 = str10;
        String str19 = (i6 & 8192) != 0 ? guiTraceCompressionEvent.detail : str9;
        Integer num12 = (i6 & 16384) != 0 ? guiTraceCompressionEvent.interval : num;
        Integer num13 = (i6 & 32768) != 0 ? guiTraceCompressionEvent.recentWindow : num2;
        Integer num14 = (i6 & 65536) != 0 ? guiTraceCompressionEvent.maxFieldItems : num3;
        Integer num15 = (i6 & 131072) != 0 ? guiTraceCompressionEvent.currentStep : num4;
        Integer num16 = (i6 & 262144) != 0 ? guiTraceCompressionEvent.chunkStartStep : num5;
        Integer num17 = (i6 & 524288) != 0 ? guiTraceCompressionEvent.chunkEndStep : num6;
        Integer num18 = (i6 & 1048576) != 0 ? guiTraceCompressionEvent.compressedUptoStep : num7;
        Integer num19 = (i6 & 2097152) != 0 ? guiTraceCompressionEvent.rawHistoryStartStep : num8;
        if ((i6 & 4194304) != 0) {
            num11 = num19;
            num10 = guiTraceCompressionEvent.rawHistoryEndStep;
        } else {
            num10 = num9;
            num11 = num19;
        }
        return guiTraceCompressionEvent.copy(str18, i10, str11, str12, j6, str13, str14, bool4, bool5, bool6, str15, str16, str17, str19, num12, num13, num14, num15, num16, num17, num18, num11, num10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStepId() {
        return this.stepId;
    }

    /* renamed from: component10, reason: from getter */
    public final Boolean getConfigValid() {
        return this.configValid;
    }

    /* renamed from: component11, reason: from getter */
    public final String getConfigIssues() {
        return this.configIssues;
    }

    /* renamed from: component12, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: component13, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component14, reason: from getter */
    public final String getDetail() {
        return this.detail;
    }

    /* renamed from: component15, reason: from getter */
    public final Integer getInterval() {
        return this.interval;
    }

    /* renamed from: component16, reason: from getter */
    public final Integer getRecentWindow() {
        return this.recentWindow;
    }

    /* renamed from: component17, reason: from getter */
    public final Integer getMaxFieldItems() {
        return this.maxFieldItems;
    }

    /* renamed from: component18, reason: from getter */
    public final Integer getCurrentStep() {
        return this.currentStep;
    }

    /* renamed from: component19, reason: from getter */
    public final Integer getChunkStartStep() {
        return this.chunkStartStep;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStepIndex() {
        return this.stepIndex;
    }

    /* renamed from: component20, reason: from getter */
    public final Integer getChunkEndStep() {
        return this.chunkEndStep;
    }

    /* renamed from: component21, reason: from getter */
    public final Integer getCompressedUptoStep() {
        return this.compressedUptoStep;
    }

    /* renamed from: component22, reason: from getter */
    public final Integer getRawHistoryStartStep() {
        return this.rawHistoryStartStep;
    }

    /* renamed from: component23, reason: from getter */
    public final Integer getRawHistoryEndStep() {
        return this.rawHistoryEndStep;
    }

    /* renamed from: component3, reason: from getter */
    public final String getActionType() {
        return this.actionType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStepTitle() {
        return this.stepTitle;
    }

    /* renamed from: component5, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component6, reason: from getter */
    public final String getLlmTraceId() {
        return this.llmTraceId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getLlmExtra() {
        return this.llmExtra;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getTriggered() {
        return this.triggered;
    }

    /* renamed from: component9, reason: from getter */
    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final GuiTraceCompressionEvent copy(String stepId, int stepIndex, String actionType, String stepTitle, long updatedAt, String llmTraceId, String llmExtra, Boolean triggered, Boolean enabled, Boolean configValid, String configIssues, String mode, String reason, String detail, Integer interval, Integer recentWindow, Integer maxFieldItems, Integer currentStep, Integer chunkStartStep, Integer chunkEndStep, Integer compressedUptoStep, Integer rawHistoryStartStep, Integer rawHistoryEndStep) {
        k.f(stepId, "stepId");
        k.f(stepTitle, "stepTitle");
        return new GuiTraceCompressionEvent(stepId, stepIndex, actionType, stepTitle, updatedAt, llmTraceId, llmExtra, triggered, enabled, configValid, configIssues, mode, reason, detail, interval, recentWindow, maxFieldItems, currentStep, chunkStartStep, chunkEndStep, compressedUptoStep, rawHistoryStartStep, rawHistoryEndStep);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiTraceCompressionEvent)) {
            return false;
        }
        GuiTraceCompressionEvent guiTraceCompressionEvent = (GuiTraceCompressionEvent) other;
        return k.b(this.stepId, guiTraceCompressionEvent.stepId) && this.stepIndex == guiTraceCompressionEvent.stepIndex && k.b(this.actionType, guiTraceCompressionEvent.actionType) && k.b(this.stepTitle, guiTraceCompressionEvent.stepTitle) && this.updatedAt == guiTraceCompressionEvent.updatedAt && k.b(this.llmTraceId, guiTraceCompressionEvent.llmTraceId) && k.b(this.llmExtra, guiTraceCompressionEvent.llmExtra) && k.b(this.triggered, guiTraceCompressionEvent.triggered) && k.b(this.enabled, guiTraceCompressionEvent.enabled) && k.b(this.configValid, guiTraceCompressionEvent.configValid) && k.b(this.configIssues, guiTraceCompressionEvent.configIssues) && k.b(this.mode, guiTraceCompressionEvent.mode) && k.b(this.reason, guiTraceCompressionEvent.reason) && k.b(this.detail, guiTraceCompressionEvent.detail) && k.b(this.interval, guiTraceCompressionEvent.interval) && k.b(this.recentWindow, guiTraceCompressionEvent.recentWindow) && k.b(this.maxFieldItems, guiTraceCompressionEvent.maxFieldItems) && k.b(this.currentStep, guiTraceCompressionEvent.currentStep) && k.b(this.chunkStartStep, guiTraceCompressionEvent.chunkStartStep) && k.b(this.chunkEndStep, guiTraceCompressionEvent.chunkEndStep) && k.b(this.compressedUptoStep, guiTraceCompressionEvent.compressedUptoStep) && k.b(this.rawHistoryStartStep, guiTraceCompressionEvent.rawHistoryStartStep) && k.b(this.rawHistoryEndStep, guiTraceCompressionEvent.rawHistoryEndStep);
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final Integer getChunkEndStep() {
        return this.chunkEndStep;
    }

    public final Integer getChunkStartStep() {
        return this.chunkStartStep;
    }

    public final Integer getCompressedUptoStep() {
        return this.compressedUptoStep;
    }

    public final String getConfigIssues() {
        return this.configIssues;
    }

    public final Boolean getConfigValid() {
        return this.configValid;
    }

    public final Integer getCurrentStep() {
        return this.currentStep;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final Integer getInterval() {
        return this.interval;
    }

    public final String getLlmExtra() {
        return this.llmExtra;
    }

    public final String getLlmTraceId() {
        return this.llmTraceId;
    }

    public final Integer getMaxFieldItems() {
        return this.maxFieldItems;
    }

    public final String getMode() {
        return this.mode;
    }

    public final Integer getRawHistoryEndStep() {
        return this.rawHistoryEndStep;
    }

    public final Integer getRawHistoryStartStep() {
        return this.rawHistoryStartStep;
    }

    public final String getReason() {
        return this.reason;
    }

    public final Integer getRecentWindow() {
        return this.recentWindow;
    }

    public final String getStepId() {
        return this.stepId;
    }

    public final int getStepIndex() {
        return this.stepIndex;
    }

    public final String getStepTitle() {
        return this.stepTitle;
    }

    public final Boolean getTriggered() {
        return this.triggered;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        int iA = a.a(this.stepIndex, this.stepId.hashCode() * 31, 31);
        String str = this.actionType;
        int iC = androidx.appfunctions.metadata.a.c(B7.a.c((iA + (str == null ? 0 : str.hashCode())) * 31, 31, this.stepTitle), 31, this.updatedAt);
        String str2 = this.llmTraceId;
        int iHashCode = (iC + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.llmExtra;
        int iHashCode2 = (iHashCode + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.triggered;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.enabled;
        int iHashCode4 = (iHashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.configValid;
        int iHashCode5 = (iHashCode4 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str4 = this.configIssues;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.mode;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.reason;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.detail;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num = this.interval;
        int iHashCode10 = (iHashCode9 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.recentWindow;
        int iHashCode11 = (iHashCode10 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.maxFieldItems;
        int iHashCode12 = (iHashCode11 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.currentStep;
        int iHashCode13 = (iHashCode12 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.chunkStartStep;
        int iHashCode14 = (iHashCode13 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.chunkEndStep;
        int iHashCode15 = (iHashCode14 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.compressedUptoStep;
        int iHashCode16 = (iHashCode15 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.rawHistoryStartStep;
        int iHashCode17 = (iHashCode16 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.rawHistoryEndStep;
        return iHashCode17 + (num9 != null ? num9.hashCode() : 0);
    }

    public final void setLlmExtra(String str) {
        this.llmExtra = str;
    }

    public String toString() {
        String str = this.stepId;
        int i = this.stepIndex;
        String str2 = this.actionType;
        String str3 = this.stepTitle;
        long j5 = this.updatedAt;
        String str4 = this.llmTraceId;
        String str5 = this.llmExtra;
        Boolean bool = this.triggered;
        Boolean bool2 = this.enabled;
        Boolean bool3 = this.configValid;
        String str6 = this.configIssues;
        String str7 = this.mode;
        String str8 = this.reason;
        String str9 = this.detail;
        Integer num = this.interval;
        Integer num2 = this.recentWindow;
        Integer num3 = this.maxFieldItems;
        Integer num4 = this.currentStep;
        Integer num5 = this.chunkStartStep;
        Integer num6 = this.chunkEndStep;
        Integer num7 = this.compressedUptoStep;
        Integer num8 = this.rawHistoryStartStep;
        Integer num9 = this.rawHistoryEndStep;
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(i, "GuiTraceCompressionEvent(stepId=", str, ", stepIndex=", ", actionType=");
        a.A(sbT, str2, ", stepTitle=", str3, ", updatedAt=");
        sbT.append(j5);
        sbT.append(", llmTraceId=");
        sbT.append(str4);
        sbT.append(", llmExtra=");
        sbT.append(str5);
        sbT.append(", triggered=");
        sbT.append(bool);
        sbT.append(", enabled=");
        sbT.append(bool2);
        sbT.append(", configValid=");
        sbT.append(bool3);
        a.A(sbT, ", configIssues=", str6, ", mode=", str7);
        a.A(sbT, ", reason=", str8, ", detail=", str9);
        sbT.append(", interval=");
        sbT.append(num);
        sbT.append(", recentWindow=");
        sbT.append(num2);
        sbT.append(", maxFieldItems=");
        sbT.append(num3);
        sbT.append(", currentStep=");
        sbT.append(num4);
        sbT.append(", chunkStartStep=");
        sbT.append(num5);
        sbT.append(", chunkEndStep=");
        sbT.append(num6);
        sbT.append(", compressedUptoStep=");
        sbT.append(num7);
        sbT.append(", rawHistoryStartStep=");
        sbT.append(num8);
        sbT.append(", rawHistoryEndStep=");
        sbT.append(num9);
        sbT.append(")");
        return sbT.toString();
    }

    public /* synthetic */ GuiTraceCompressionEvent(String str, int i, String str2, String str3, long j5, String str4, String str5, Boolean bool, Boolean bool2, Boolean bool3, String str6, String str7, String str8, String str9, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, int i6, e eVar) {
        this(str, i, str2, str3, j5, str4, (i6 & 64) != 0 ? null : str5, bool, bool2, bool3, str6, str7, str8, str9, num, num2, num3, num4, num5, num6, num7, num8, num9);
    }
}
