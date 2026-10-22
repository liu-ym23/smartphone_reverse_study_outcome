package com.stepos.ability.net.biz.model;

import B7.a;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.ability.commoninternal.SLAScene;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\b\u00101\u001a\u00020\u0003H\u0016J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010#J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0019\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0013HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÒ\u0001\u0010B\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R.\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001aR\u001a\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b/\u0010#R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001a¨\u0006H"}, d2 = {"Lcom/stepos/ability/net/biz/model/ToolItem;", "", HintConstants.AUTOFILL_HINT_NAME, "", "functionName", "description", "type", "capabilityType", "permission", "callType", "callingMethod", InjectExperienceResult.REASON_TIMEOUT, "", "deviceType", "inputSchema", "Lcom/stepos/ability/net/biz/model/InputSchema;", "outputSchema", "Lcom/stepos/ability/net/biz/model/OutputSchema;", "extra", "", "version", "abilityId", SLAScene.SLA_SCENE, AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/stepos/ability/net/biz/model/InputSchema;Lcom/stepos/ability/net/biz/model/OutputSchema;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getFunctionName", "getDescription", "getType", "getCapabilityType", "getPermission", "getCallType", "getCallingMethod", "getTimeout", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeviceType", "getInputSchema", "()Lcom/stepos/ability/net/biz/model/InputSchema;", "getOutputSchema", "()Lcom/stepos/ability/net/biz/model/OutputSchema;", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "getVersion", "getAbilityId", "getSlaScene", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/stepos/ability/net/biz/model/InputSchema;Lcom/stepos/ability/net/biz/model/OutputSchema;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/stepos/ability/net/biz/model/ToolItem;", "equals", "", "other", "hashCode", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToolItem {

    @SerializedName("abilityId")
    private final Integer abilityId;

    @SerializedName("callType")
    private final String callType;

    @SerializedName("callingMethod")
    private final String callingMethod;

    @SerializedName("capabilityType")
    private final String capabilityType;

    @SerializedName("description")
    private final String description;

    @SerializedName("deviceType")
    private final String deviceType;

    @SerializedName("extra")
    private Map<String, ? extends Object> extra;

    @SerializedName("functionName")
    private final String functionName;

    @SerializedName("inputSchema")
    private final InputSchema inputSchema;

    @SerializedName(HintConstants.AUTOFILL_HINT_NAME)
    private final String name;

    @SerializedName("outputSchema")
    private final OutputSchema outputSchema;

    @SerializedName("permission")
    private final String permission;

    @SerializedName(SLAScene.SLA_SCENE)
    private final String slaScene;

    @SerializedName(InjectExperienceResult.REASON_TIMEOUT)
    private final Integer timeout;

    @SerializedName("type")
    private final String type;

    @SerializedName("version")
    private final String version;

    public ToolItem(String str, String functionName, String description, String str2, String str3, String str4, String callType, String callingMethod, Integer num, String deviceType, InputSchema inputSchema, OutputSchema outputSchema, Map<String, ? extends Object> map, String str5, Integer num2, String str6) {
        k.f(functionName, "functionName");
        k.f(description, "description");
        k.f(callType, "callType");
        k.f(callingMethod, "callingMethod");
        k.f(deviceType, "deviceType");
        this.name = str;
        this.functionName = functionName;
        this.description = description;
        this.type = str2;
        this.capabilityType = str3;
        this.permission = str4;
        this.callType = callType;
        this.callingMethod = callingMethod;
        this.timeout = num;
        this.deviceType = deviceType;
        this.inputSchema = inputSchema;
        this.outputSchema = outputSchema;
        this.extra = map;
        this.version = str5;
        this.abilityId = num2;
        this.slaScene = str6;
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component10, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* renamed from: component11, reason: from getter */
    public final InputSchema getInputSchema() {
        return this.inputSchema;
    }

    /* renamed from: component12, reason: from getter */
    public final OutputSchema getOutputSchema() {
        return this.outputSchema;
    }

    public final Map<String, Object> component13() {
        return this.extra;
    }

    /* renamed from: component14, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component15, reason: from getter */
    public final Integer getAbilityId() {
        return this.abilityId;
    }

    /* renamed from: component16, reason: from getter */
    public final String getSlaScene() {
        return this.slaScene;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFunctionName() {
        return this.functionName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCapabilityType() {
        return this.capabilityType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPermission() {
        return this.permission;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCallType() {
        return this.callType;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCallingMethod() {
        return this.callingMethod;
    }

    /* renamed from: component9, reason: from getter */
    public final Integer getTimeout() {
        return this.timeout;
    }

    public final ToolItem copy(String name, String functionName, String description, String type, String capabilityType, String permission, String callType, String callingMethod, Integer timeout, String deviceType, InputSchema inputSchema, OutputSchema outputSchema, Map<String, ? extends Object> extra, String version, Integer abilityId, String slaScene) {
        k.f(functionName, "functionName");
        k.f(description, "description");
        k.f(callType, "callType");
        k.f(callingMethod, "callingMethod");
        k.f(deviceType, "deviceType");
        return new ToolItem(name, functionName, description, type, capabilityType, permission, callType, callingMethod, timeout, deviceType, inputSchema, outputSchema, extra, version, abilityId, slaScene);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolItem)) {
            return false;
        }
        ToolItem toolItem = (ToolItem) other;
        return k.b(this.name, toolItem.name) && k.b(this.functionName, toolItem.functionName) && k.b(this.description, toolItem.description) && k.b(this.type, toolItem.type) && k.b(this.capabilityType, toolItem.capabilityType) && k.b(this.permission, toolItem.permission) && k.b(this.callType, toolItem.callType) && k.b(this.callingMethod, toolItem.callingMethod) && k.b(this.timeout, toolItem.timeout) && k.b(this.deviceType, toolItem.deviceType) && k.b(this.inputSchema, toolItem.inputSchema) && k.b(this.outputSchema, toolItem.outputSchema) && k.b(this.extra, toolItem.extra) && k.b(this.version, toolItem.version) && k.b(this.abilityId, toolItem.abilityId) && k.b(this.slaScene, toolItem.slaScene);
    }

    public final Integer getAbilityId() {
        return this.abilityId;
    }

    public final String getCallType() {
        return this.callType;
    }

    public final String getCallingMethod() {
        return this.callingMethod;
    }

    public final String getCapabilityType() {
        return this.capabilityType;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final String getFunctionName() {
        return this.functionName;
    }

    public final InputSchema getInputSchema() {
        return this.inputSchema;
    }

    public final String getName() {
        return this.name;
    }

    public final OutputSchema getOutputSchema() {
        return this.outputSchema;
    }

    public final String getPermission() {
        return this.permission;
    }

    public final String getSlaScene() {
        return this.slaScene;
    }

    public final Integer getTimeout() {
        return this.timeout;
    }

    public final String getType() {
        return this.type;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.name;
        int iC = a.c(a.c((str == null ? 0 : str.hashCode()) * 31, 31, this.functionName), 31, this.description);
        String str2 = this.type;
        int iHashCode = (iC + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.capabilityType;
        int iHashCode2 = (iHashCode + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.permission;
        int iC2 = a.c(a.c((iHashCode2 + (str4 == null ? 0 : str4.hashCode())) * 31, 31, this.callType), 31, this.callingMethod);
        Integer num = this.timeout;
        int iC3 = a.c((iC2 + (num == null ? 0 : num.hashCode())) * 31, 31, this.deviceType);
        InputSchema inputSchema = this.inputSchema;
        int iHashCode3 = (iC3 + (inputSchema == null ? 0 : inputSchema.hashCode())) * 31;
        OutputSchema outputSchema = this.outputSchema;
        int iHashCode4 = (iHashCode3 + (outputSchema == null ? 0 : outputSchema.hashCode())) * 31;
        Map<String, ? extends Object> map = this.extra;
        int iHashCode5 = (iHashCode4 + (map == null ? 0 : map.hashCode())) * 31;
        String str5 = this.version;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.abilityId;
        int iHashCode7 = (iHashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str6 = this.slaScene;
        return iHashCode7 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setExtra(Map<String, ? extends Object> map) {
        this.extra = map;
    }

    public String toString() {
        String str = this.name;
        String str2 = this.functionName;
        String str3 = this.callType;
        String str4 = this.callingMethod;
        Integer num = this.timeout;
        String str5 = this.version;
        String str6 = this.slaScene;
        boolean z10 = this.abilityId != null;
        boolean z11 = this.inputSchema != null;
        boolean z12 = this.outputSchema != null;
        StringBuilder sbW = a.w("ToolItem(name=", str, ", functionName=", str2, ", callType=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", callingMethod=", str4, ", timeout=");
        sbW.append(num);
        sbW.append(", version=");
        sbW.append(str5);
        sbW.append(", slaScene=");
        sbW.append(str6);
        sbW.append(", abilityId=<redacted>, hasAbilityId=");
        sbW.append(z10);
        sbW.append(", inputSchema=<redacted>, hasInputSchema=");
        sbW.append(z11);
        sbW.append(", outputSchema=<redacted>, hasOutputSchema=");
        sbW.append(z12);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ ToolItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, String str9, InputSchema inputSchema, OutputSchema outputSchema, Map map, String str10, Integer num2, String str11, int i, e eVar) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, str7, str8, (i & 256) != 0 ? null : num, str9, inputSchema, outputSchema, map, (i & 8192) != 0 ? null : str10, (i & 16384) != 0 ? null : num2, (i & 32768) != 0 ? null : str11);
    }
}
