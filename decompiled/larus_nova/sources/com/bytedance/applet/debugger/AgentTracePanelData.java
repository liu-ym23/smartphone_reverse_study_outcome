package com.bytedance.applet.debugger;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003Ji\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015¨\u0006/"}, d2 = {"Lcom/bytedance/applet/debugger/AgentTracePanelData;", "Lcom/bytedance/applet/debugger/AgentTracePanelPayload;", "schemaVersion", "", "messageId", "", "sectionId", "traceId", "status", "durationMs", "", "input", "spans", "", "Lcom/bytedance/applet/debugger/AgentTracePanelSpan;", BdpAppEventConstant.PARAMS_OUTPUT, "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getSchemaVersion", "()I", "getMessageId", "()Ljava/lang/String;", "getSectionId", "getTraceId", "getStatus", "getDurationMs", "()J", "getInput", "getSpans", "()Ljava/util/List;", "getOutput", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AgentTracePanelData {
    private final long durationMs;
    private final String input;
    private final String messageId;
    private final String output;
    private final int schemaVersion;
    private final String sectionId;
    private final List<AgentTracePanelSpan> spans;
    private final String status;
    private final String traceId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AgentTracePanelData copy$default(AgentTracePanelData r110, int r111, String r112, String r113, String r114, String r115, long r116, String r117, List r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        int r100 = r110.schemaVersion;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.messageId;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.sectionId;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.traceId;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.status;
    L23:
        if ((r212 & 32) == 0) goto L25;
        long r105 = r110.durationMs;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.input;
    L31:
        if ((r212 & 128) == 0) goto L33;
        List r118 = r110.spans;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r107 = r110.output;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r118, r107);
    L37:
        r107 = r211;
        goto L39
    L33:
        r118 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.schemaVersion;
    }

    public final String component2() {
        return this.messageId;
    }

    public final String component3() {
        return this.sectionId;
    }

    public final String component4() {
        return this.traceId;
    }

    public final String component5() {
        return this.status;
    }

    public final long component6() {
        return this.durationMs;
    }

    public final String component7() {
        return this.input;
    }

    public final List<AgentTracePanelSpan> component8() {
        return this.spans;
    }

    public final String component9() {
        return this.output;
    }

    public final AgentTracePanelData copy(int r110, String r111, String r112, String r113, String r114, long r115, String r210, List<AgentTracePanelSpan> r211, String r212) {
        Intrinsics.checkNotNullParameter(r111, "messageId");
        Intrinsics.checkNotNullParameter(r112, "sectionId");
        Intrinsics.checkNotNullParameter(r113, "traceId");
        Intrinsics.checkNotNullParameter(r114, "status");
        Intrinsics.checkNotNullParameter(r210, "input");
        Intrinsics.checkNotNullParameter(r211, "spans");
        Intrinsics.checkNotNullParameter(r212, BdpAppEventConstant.PARAMS_OUTPUT);
        return new AgentTracePanelData(r110, r111, r112, r113, r114, r115, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AgentTracePanelData) == true) goto L8;
        return false;
    L8:
        AgentTracePanelData r101 = (AgentTracePanelData) r100;
        if (this.schemaVersion == r101.schemaVersion) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sectionId, r101.sectionId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.traceId, r101.traceId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L24;
        return false;
    L24:
        if (this.durationMs == r101.durationMs) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.input, r101.input) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.spans, r101.spans) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.output, r101.output) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((this.schemaVersion * 31) + this.messageId.hashCode()) * 31) + this.sectionId.hashCode()) * 31) + this.traceId.hashCode()) * 31) + this.status.hashCode()) * 31;
        long r101 = this.durationMs;
        return ((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.input.hashCode()) * 31) + this.spans.hashCode()) * 31) + this.output.hashCode();
    }

    public String toString() {
        return "AgentTracePanelData(schemaVersion=" + this.schemaVersion + ", messageId=" + this.messageId + ", sectionId=" + this.sectionId + ", traceId=" + this.traceId + ", status=" + this.status + ", durationMs=" + this.durationMs + ", input=" + this.input + ", spans=" + this.spans + ", output=" + this.output + ')';
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final String getInput() {
        return this.input;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getOutput() {
        return this.output;
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final List<AgentTracePanelSpan> getSpans() {
        return this.spans;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public AgentTracePanelData(int r100, String r101, String r102, String r103, String r104, long r105, String r106, List<AgentTracePanelSpan> r110, String r111) {
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r102, "sectionId");
        Intrinsics.checkNotNullParameter(r103, "traceId");
        Intrinsics.checkNotNullParameter(r104, "status");
        Intrinsics.checkNotNullParameter(r106, "input");
        Intrinsics.checkNotNullParameter(r110, "spans");
        Intrinsics.checkNotNullParameter(r111, BdpAppEventConstant.PARAMS_OUTPUT);
        this.schemaVersion = r100;
        this.messageId = r101;
        this.sectionId = r102;
        this.traceId = r103;
        this.status = r104;
        this.durationMs = r105;
        this.input = r106;
        this.spans = r110;
        this.output = r111;
    }

    public /* synthetic */ AgentTracePanelData(int r110, String r111, String r112, String r113, String r114, long r115, String r210, List r211, String r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 1) == 0) goto L5;
        int r100 = 1;
    L7:
        if ((r213 & 16) == 0) goto L9;
        String r101 = "completed";
    L10:
        this(r100, r111, r112, r113, r101, r115, r210, r211, r212);
        return;
    L9:
        r101 = r114;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
