package com.stepos.ability.net.biz.model;

import B7.a;
import androidx.autofill.HintConstants;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.ability.commoninternal.SLAScene;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\bC\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B³\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0019\u0012\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0019\u0012\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b \u0010!J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010T\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0019HÆ\u0003J\u0019\u0010U\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0019HÆ\u0003J\u0019\u0010V\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0019HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jã\u0002\u0010[\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00192\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00192\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010_\u001a\u00020\u0003HÖ\u0001J\t\u0010`\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R&\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00109R&\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00109R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010%R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010%R\u0016\u0010\u001e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010%R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010%¨\u0006a"}, d2 = {"Lcom/stepos/ability/net/biz/model/AbilityInfoRsp;", "", "abilityId", "", "appName", "", "appSource", "pkg", "appId", "toolUniqueName", HintConstants.AUTOFILL_HINT_NAME, "functionName", "description", "type", "capabilityType", "authType", "permission", "appVersion", "callingMethod", InjectExperienceResult.REASON_TIMEOUT, "deviceType", "mcpUrl", "mcpTag", "mcpType", "inputSchema", "", "outputSchema", "extra", "version", "signature", "callType", SLAScene.SLA_SCENE, AppAgent.CONSTRUCT, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAbilityId", "()I", "getAppName", "()Ljava/lang/String;", "getAppSource", "getPkg", "getAppId", "getToolUniqueName", "getName", "getFunctionName", "getDescription", "getType", "getCapabilityType", "getAuthType", "getPermission", "getAppVersion", "getCallingMethod", "getTimeout", "getDeviceType", "getMcpUrl", "getMcpTag", "getMcpType", "getInputSchema", "()Ljava/util/Map;", "getOutputSchema", "getExtra", "getVersion", "getSignature", "getCallType", "getSlaScene", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "equals", "", "other", "hashCode", "toString", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityInfoRsp {

    @SerializedName("abilityId")
    private final int abilityId;

    @SerializedName("appId")
    private final int appId;

    @SerializedName("appName")
    private final String appName;

    @SerializedName("appSource")
    private final String appSource;

    @SerializedName("appVersion")
    private final String appVersion;

    @SerializedName("authType")
    private final String authType;

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
    private final Map<String, Object> extra;

    @SerializedName("functionName")
    private final String functionName;

    @SerializedName("inputSchema")
    private final Map<String, Object> inputSchema;

    @SerializedName("mcpTag")
    private final String mcpTag;

    @SerializedName("mcpType")
    private final String mcpType;

    @SerializedName("mcpUrl")
    private final String mcpUrl;

    @SerializedName(HintConstants.AUTOFILL_HINT_NAME)
    private final String name;

    @SerializedName("outputSchema")
    private final Map<String, Object> outputSchema;

    @SerializedName("permission")
    private final String permission;

    @SerializedName("packageName")
    private final String pkg;

    @SerializedName("signature")
    private final String signature;

    @SerializedName(SLAScene.SLA_SCENE)
    private final String slaScene;

    @SerializedName(InjectExperienceResult.REASON_TIMEOUT)
    private final String timeout;

    @SerializedName("toolUniqueName")
    private final String toolUniqueName;

    @SerializedName("type")
    private final String type;

    @SerializedName("version")
    private final String version;

    public AbilityInfoRsp(int i, String appName, String appSource, String str, int i6, String toolUniqueName, String str2, String functionName, String str3, String str4, String str5, String str6, String permission, String appVersion, String callingMethod, String str7, String str8, String str9, String str10, String str11, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Map<String, ? extends Object> map3, String str12, String str13, String callType, String str14) {
        k.f(appName, "appName");
        k.f(appSource, "appSource");
        k.f(toolUniqueName, "toolUniqueName");
        k.f(functionName, "functionName");
        k.f(permission, "permission");
        k.f(appVersion, "appVersion");
        k.f(callingMethod, "callingMethod");
        k.f(callType, "callType");
        this.abilityId = i;
        this.appName = appName;
        this.appSource = appSource;
        this.pkg = str;
        this.appId = i6;
        this.toolUniqueName = toolUniqueName;
        this.name = str2;
        this.functionName = functionName;
        this.description = str3;
        this.type = str4;
        this.capabilityType = str5;
        this.authType = str6;
        this.permission = permission;
        this.appVersion = appVersion;
        this.callingMethod = callingMethod;
        this.timeout = str7;
        this.deviceType = str8;
        this.mcpUrl = str9;
        this.mcpTag = str10;
        this.mcpType = str11;
        this.inputSchema = map;
        this.outputSchema = map2;
        this.extra = map3;
        this.version = str12;
        this.signature = str13;
        this.callType = callType;
        this.slaScene = str14;
    }

    public static /* synthetic */ AbilityInfoRsp copy$default(AbilityInfoRsp abilityInfoRsp, int i, String str, String str2, String str3, int i6, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, Map map, Map map2, Map map3, String str19, String str20, String str21, String str22, int i10, Object obj) {
        String str23;
        String str24;
        int i11 = (i10 & 1) != 0 ? abilityInfoRsp.abilityId : i;
        String str25 = (i10 & 2) != 0 ? abilityInfoRsp.appName : str;
        String str26 = (i10 & 4) != 0 ? abilityInfoRsp.appSource : str2;
        String str27 = (i10 & 8) != 0 ? abilityInfoRsp.pkg : str3;
        int i12 = (i10 & 16) != 0 ? abilityInfoRsp.appId : i6;
        String str28 = (i10 & 32) != 0 ? abilityInfoRsp.toolUniqueName : str4;
        String str29 = (i10 & 64) != 0 ? abilityInfoRsp.name : str5;
        String str30 = (i10 & 128) != 0 ? abilityInfoRsp.functionName : str6;
        String str31 = (i10 & 256) != 0 ? abilityInfoRsp.description : str7;
        String str32 = (i10 & 512) != 0 ? abilityInfoRsp.type : str8;
        String str33 = (i10 & 1024) != 0 ? abilityInfoRsp.capabilityType : str9;
        String str34 = (i10 & 2048) != 0 ? abilityInfoRsp.authType : str10;
        String str35 = (i10 & 4096) != 0 ? abilityInfoRsp.permission : str11;
        String str36 = (i10 & 8192) != 0 ? abilityInfoRsp.appVersion : str12;
        int i13 = i11;
        String str37 = (i10 & 16384) != 0 ? abilityInfoRsp.callingMethod : str13;
        String str38 = (i10 & 32768) != 0 ? abilityInfoRsp.timeout : str14;
        String str39 = (i10 & 65536) != 0 ? abilityInfoRsp.deviceType : str15;
        String str40 = (i10 & 131072) != 0 ? abilityInfoRsp.mcpUrl : str16;
        String str41 = (i10 & 262144) != 0 ? abilityInfoRsp.mcpTag : str17;
        String str42 = (i10 & 524288) != 0 ? abilityInfoRsp.mcpType : str18;
        Map map4 = (i10 & 1048576) != 0 ? abilityInfoRsp.inputSchema : map;
        Map map5 = (i10 & 2097152) != 0 ? abilityInfoRsp.outputSchema : map2;
        Map map6 = (i10 & 4194304) != 0 ? abilityInfoRsp.extra : map3;
        String str43 = (i10 & 8388608) != 0 ? abilityInfoRsp.version : str19;
        String str44 = (i10 & 16777216) != 0 ? abilityInfoRsp.signature : str20;
        String str45 = (i10 & 33554432) != 0 ? abilityInfoRsp.callType : str21;
        if ((i10 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0) {
            str24 = str45;
            str23 = abilityInfoRsp.slaScene;
        } else {
            str23 = str22;
            str24 = str45;
        }
        return abilityInfoRsp.copy(i13, str25, str26, str27, i12, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, map4, map5, map6, str43, str44, str24, str23);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAbilityId() {
        return this.abilityId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component11, reason: from getter */
    public final String getCapabilityType() {
        return this.capabilityType;
    }

    /* renamed from: component12, reason: from getter */
    public final String getAuthType() {
        return this.authType;
    }

    /* renamed from: component13, reason: from getter */
    public final String getPermission() {
        return this.permission;
    }

    /* renamed from: component14, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: component15, reason: from getter */
    public final String getCallingMethod() {
        return this.callingMethod;
    }

    /* renamed from: component16, reason: from getter */
    public final String getTimeout() {
        return this.timeout;
    }

    /* renamed from: component17, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* renamed from: component18, reason: from getter */
    public final String getMcpUrl() {
        return this.mcpUrl;
    }

    /* renamed from: component19, reason: from getter */
    public final String getMcpTag() {
        return this.mcpTag;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component20, reason: from getter */
    public final String getMcpType() {
        return this.mcpType;
    }

    public final Map<String, Object> component21() {
        return this.inputSchema;
    }

    public final Map<String, Object> component22() {
        return this.outputSchema;
    }

    public final Map<String, Object> component23() {
        return this.extra;
    }

    /* renamed from: component24, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component25, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    /* renamed from: component26, reason: from getter */
    public final String getCallType() {
        return this.callType;
    }

    /* renamed from: component27, reason: from getter */
    public final String getSlaScene() {
        return this.slaScene;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAppSource() {
        return this.appSource;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPkg() {
        return this.pkg;
    }

    /* renamed from: component5, reason: from getter */
    public final int getAppId() {
        return this.appId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getToolUniqueName() {
        return this.toolUniqueName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component8, reason: from getter */
    public final String getFunctionName() {
        return this.functionName;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AbilityInfoRsp copy(int abilityId, String appName, String appSource, String pkg, int appId, String toolUniqueName, String name, String functionName, String description, String type, String capabilityType, String authType, String permission, String appVersion, String callingMethod, String timeout, String deviceType, String mcpUrl, String mcpTag, String mcpType, Map<String, ? extends Object> inputSchema, Map<String, ? extends Object> outputSchema, Map<String, ? extends Object> extra, String version, String signature, String callType, String slaScene) {
        k.f(appName, "appName");
        k.f(appSource, "appSource");
        k.f(toolUniqueName, "toolUniqueName");
        k.f(functionName, "functionName");
        k.f(permission, "permission");
        k.f(appVersion, "appVersion");
        k.f(callingMethod, "callingMethod");
        k.f(callType, "callType");
        return new AbilityInfoRsp(abilityId, appName, appSource, pkg, appId, toolUniqueName, name, functionName, description, type, capabilityType, authType, permission, appVersion, callingMethod, timeout, deviceType, mcpUrl, mcpTag, mcpType, inputSchema, outputSchema, extra, version, signature, callType, slaScene);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbilityInfoRsp)) {
            return false;
        }
        AbilityInfoRsp abilityInfoRsp = (AbilityInfoRsp) other;
        return this.abilityId == abilityInfoRsp.abilityId && k.b(this.appName, abilityInfoRsp.appName) && k.b(this.appSource, abilityInfoRsp.appSource) && k.b(this.pkg, abilityInfoRsp.pkg) && this.appId == abilityInfoRsp.appId && k.b(this.toolUniqueName, abilityInfoRsp.toolUniqueName) && k.b(this.name, abilityInfoRsp.name) && k.b(this.functionName, abilityInfoRsp.functionName) && k.b(this.description, abilityInfoRsp.description) && k.b(this.type, abilityInfoRsp.type) && k.b(this.capabilityType, abilityInfoRsp.capabilityType) && k.b(this.authType, abilityInfoRsp.authType) && k.b(this.permission, abilityInfoRsp.permission) && k.b(this.appVersion, abilityInfoRsp.appVersion) && k.b(this.callingMethod, abilityInfoRsp.callingMethod) && k.b(this.timeout, abilityInfoRsp.timeout) && k.b(this.deviceType, abilityInfoRsp.deviceType) && k.b(this.mcpUrl, abilityInfoRsp.mcpUrl) && k.b(this.mcpTag, abilityInfoRsp.mcpTag) && k.b(this.mcpType, abilityInfoRsp.mcpType) && k.b(this.inputSchema, abilityInfoRsp.inputSchema) && k.b(this.outputSchema, abilityInfoRsp.outputSchema) && k.b(this.extra, abilityInfoRsp.extra) && k.b(this.version, abilityInfoRsp.version) && k.b(this.signature, abilityInfoRsp.signature) && k.b(this.callType, abilityInfoRsp.callType) && k.b(this.slaScene, abilityInfoRsp.slaScene);
    }

    public final int getAbilityId() {
        return this.abilityId;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppSource() {
        return this.appSource;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getAuthType() {
        return this.authType;
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

    public final Map<String, Object> getInputSchema() {
        return this.inputSchema;
    }

    public final String getMcpTag() {
        return this.mcpTag;
    }

    public final String getMcpType() {
        return this.mcpType;
    }

    public final String getMcpUrl() {
        return this.mcpUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> getOutputSchema() {
        return this.outputSchema;
    }

    public final String getPermission() {
        return this.permission;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final String getSlaScene() {
        return this.slaScene;
    }

    public final String getTimeout() {
        return this.timeout;
    }

    public final String getToolUniqueName() {
        return this.toolUniqueName;
    }

    public final String getType() {
        return this.type;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iC = a.c(a.c(Integer.hashCode(this.abilityId) * 31, 31, this.appName), 31, this.appSource);
        String str = this.pkg;
        int iC2 = a.c(androidx.constraintlayout.core.dsl.a.a(this.appId, (iC + (str == null ? 0 : str.hashCode())) * 31, 31), 31, this.toolUniqueName);
        String str2 = this.name;
        int iC3 = a.c((iC2 + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.functionName);
        String str3 = this.description;
        int iHashCode = (iC3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.type;
        int iHashCode2 = (iHashCode + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.capabilityType;
        int iHashCode3 = (iHashCode2 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.authType;
        int iC4 = a.c(a.c(a.c((iHashCode3 + (str6 == null ? 0 : str6.hashCode())) * 31, 31, this.permission), 31, this.appVersion), 31, this.callingMethod);
        String str7 = this.timeout;
        int iHashCode4 = (iC4 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.deviceType;
        int iHashCode5 = (iHashCode4 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.mcpUrl;
        int iHashCode6 = (iHashCode5 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.mcpTag;
        int iHashCode7 = (iHashCode6 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.mcpType;
        int iHashCode8 = (iHashCode7 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Map<String, Object> map = this.inputSchema;
        int iHashCode9 = (iHashCode8 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, Object> map2 = this.outputSchema;
        int iHashCode10 = (iHashCode9 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, Object> map3 = this.extra;
        int iHashCode11 = (iHashCode10 + (map3 == null ? 0 : map3.hashCode())) * 31;
        String str12 = this.version;
        int iHashCode12 = (iHashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.signature;
        int iC5 = a.c((iHashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31, 31, this.callType);
        String str14 = this.slaScene;
        return iC5 + (str14 != null ? str14.hashCode() : 0);
    }

    public String toString() {
        int i = this.abilityId;
        String str = this.appName;
        String str2 = this.appSource;
        String str3 = this.pkg;
        int i6 = this.appId;
        String str4 = this.toolUniqueName;
        String str5 = this.name;
        String str6 = this.functionName;
        String str7 = this.description;
        String str8 = this.type;
        String str9 = this.capabilityType;
        String str10 = this.authType;
        String str11 = this.permission;
        String str12 = this.appVersion;
        String str13 = this.callingMethod;
        String str14 = this.timeout;
        String str15 = this.deviceType;
        String str16 = this.mcpUrl;
        String str17 = this.mcpTag;
        String str18 = this.mcpType;
        Map<String, Object> map = this.inputSchema;
        Map<String, Object> map2 = this.outputSchema;
        Map<String, Object> map3 = this.extra;
        String str19 = this.version;
        String str20 = this.signature;
        String str21 = this.callType;
        String str22 = this.slaScene;
        StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(i, "AbilityInfoRsp(abilityId=", ", appName=", str, ", appSource=");
        androidx.constraintlayout.core.dsl.a.A(sbK, str2, ", pkg=", str3, ", appId=");
        sbK.append(i6);
        sbK.append(", toolUniqueName=");
        sbK.append(str4);
        sbK.append(", name=");
        androidx.constraintlayout.core.dsl.a.A(sbK, str5, ", functionName=", str6, ", description=");
        androidx.constraintlayout.core.dsl.a.A(sbK, str7, ", type=", str8, ", capabilityType=");
        androidx.constraintlayout.core.dsl.a.A(sbK, str9, ", authType=", str10, ", permission=");
        androidx.constraintlayout.core.dsl.a.A(sbK, str11, ", appVersion=", str12, ", callingMethod=");
        androidx.constraintlayout.core.dsl.a.A(sbK, str13, ", timeout=", str14, ", deviceType=");
        androidx.constraintlayout.core.dsl.a.A(sbK, str15, ", mcpUrl=", str16, ", mcpTag=");
        androidx.constraintlayout.core.dsl.a.A(sbK, str17, ", mcpType=", str18, ", inputSchema=");
        sbK.append(map);
        sbK.append(", outputSchema=");
        sbK.append(map2);
        sbK.append(", extra=");
        sbK.append(map3);
        sbK.append(", version=");
        sbK.append(str19);
        sbK.append(", signature=");
        androidx.constraintlayout.core.dsl.a.A(sbK, str20, ", callType=", str21, ", slaScene=");
        return a.q(sbK, str22, ")");
    }

    public /* synthetic */ AbilityInfoRsp(int i, String str, String str2, String str3, int i6, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, Map map, Map map2, Map map3, String str19, String str20, String str21, String str22, int i10, e eVar) {
        this(i, str, str2, str3, i6, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, map, (i10 & 2097152) != 0 ? null : map2, map3, (i10 & 8388608) != 0 ? null : str19, (i10 & 16777216) != 0 ? null : str20, str21, (i10 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? null : str22);
    }
}
