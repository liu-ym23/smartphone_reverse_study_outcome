package com.bytedance.applet.debugger;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003Jd\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006+"}, d2 = {"Lcom/bytedance/applet/debugger/AgentTracePanelSpan;", "", "id", "", "type", "name", "source", "startedAtMs", "", "durationMs", "input", "Lcom/google/gson/JsonElement;", BdpAppEventConstant.PARAMS_OUTPUT, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;)V", "getId", "()Ljava/lang/String;", "getType", "getName", "getSource", "getStartedAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDurationMs", "getInput", "()Lcom/google/gson/JsonElement;", "getOutput", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;)Lcom/bytedance/applet/debugger/AgentTracePanelSpan;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AgentTracePanelSpan {
    private final Long durationMs;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f191689id;
    private final JsonElement input;
    private final String name;
    private final JsonElement output;
    private final String source;
    private final Long startedAtMs;
    private final String type;

    public static /* synthetic */ AgentTracePanelSpan copy$default(AgentTracePanelSpan r100, String r110, String r111, String r112, String r113, Long r114, Long r115, JsonElement r116, JsonElement r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.f191689id;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.type;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.name;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.source;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Long r105 = r100.startedAtMs;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Long r106 = r100.durationMs;
    L27:
        if ((r118 & 64) == 0) goto L29;
        JsonElement r107 = r100.input;
    L31:
        if ((r118 & 128) == 0) goto L33;
        JsonElement r108 = r100.output;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.f191689id;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.source;
    }

    public final Long component5() {
        return this.startedAtMs;
    }

    public final Long component6() {
        return this.durationMs;
    }

    public final JsonElement component7() {
        return this.input;
    }

    public final JsonElement component8() {
        return this.output;
    }

    public final AgentTracePanelSpan copy(String r110, String r111, String r112, String r113, Long r114, Long r115, JsonElement r116, JsonElement r117) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r113, "source");
        Intrinsics.checkNotNullParameter(r116, "input");
        Intrinsics.checkNotNullParameter(r117, BdpAppEventConstant.PARAMS_OUTPUT);
        return new AgentTracePanelSpan(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AgentTracePanelSpan) == true) goto L8;
        return false;
    L8:
        AgentTracePanelSpan r101 = (AgentTracePanelSpan) r100;
        if (Intrinsics.areEqual(this.f191689id, r101.f191689id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.startedAtMs, r101.startedAtMs) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.durationMs, r101.durationMs) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.input, r101.input) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.output, r101.output) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.f191689id.hashCode() * 31) + this.type.hashCode()) * 31;
        String r101 = this.name;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.source.hashCode()) * 31;
        Long r105 = this.startedAtMs;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.durationMs;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return ((((r107 + r102) * 31) + this.input.hashCode()) * 31) + this.output.hashCode();
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "AgentTracePanelSpan(id=" + this.f191689id + ", type=" + this.type + ", name=" + this.name + ", source=" + this.source + ", startedAtMs=" + this.startedAtMs + ", durationMs=" + this.durationMs + ", input=" + this.input + ", output=" + this.output + ')';
    }

    public final Long getDurationMs() {
        return this.durationMs;
    }

    public final String getId() {
        return this.f191689id;
    }

    public final JsonElement getInput() {
        return this.input;
    }

    public final String getName() {
        return this.name;
    }

    public final JsonElement getOutput() {
        return this.output;
    }

    public final String getSource() {
        return this.source;
    }

    public final Long getStartedAtMs() {
        return this.startedAtMs;
    }

    public final String getType() {
        return this.type;
    }

    public AgentTracePanelSpan(String r100, String r101, String r102, String r103, Long r104, Long r105, JsonElement r106, JsonElement r107) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r103, "source");
        Intrinsics.checkNotNullParameter(r106, "input");
        Intrinsics.checkNotNullParameter(r107, BdpAppEventConstant.PARAMS_OUTPUT);
        this.f191689id = r100;
        this.type = r101;
        this.name = r102;
        this.source = r103;
        this.startedAtMs = r104;
        this.durationMs = r105;
        this.input = r106;
        this.output = r107;
    }
}
