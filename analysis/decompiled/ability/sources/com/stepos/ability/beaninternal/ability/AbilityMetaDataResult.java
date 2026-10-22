package com.stepos.ability.beaninternal.ability;

import B7.a;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.SLAScene;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import j9.m;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010$\u001a\u00020\u0003H\u0016J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0019\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u000eHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009d\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015¨\u00067"}, d2 = {"Lcom/stepos/ability/beaninternal/ability/AbilityMetaDataResult;", "", "toolName", "", "description", "icon", "appVersion", "packageName", "pkgSign", "functionName", "extra", "", "inputSchema", InjectExperienceResult.REASON_TIMEOUT, "", "callingMethod", "callType", SLAScene.SLA_SCENE, AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getToolName", "()Ljava/lang/String;", "getDescription", "getIcon", "getAppVersion", "getPackageName", "getPkgSign", "getFunctionName", "getExtra", "()Ljava/util/Map;", "getInputSchema", "getTimeout", "()I", "getCallingMethod", "getCallType", "getSlaScene", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "beanInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityMetaDataResult {
    private final String appVersion;
    private final String callType;
    private final String callingMethod;
    private final String description;
    private final Map<String, Object> extra;
    private final String functionName;
    private final String icon;
    private final String inputSchema;
    private final String packageName;
    private final String pkgSign;
    private final String slaScene;
    private final int timeout;
    private final String toolName;

    public AbilityMetaDataResult(String toolName, String description, String icon, String appVersion, String packageName, String pkgSign, String functionName, Map<String, ? extends Object> map, String inputSchema, int i, String callingMethod, String callType, String str) {
        k.f(toolName, "toolName");
        k.f(description, "description");
        k.f(icon, "icon");
        k.f(appVersion, "appVersion");
        k.f(packageName, "packageName");
        k.f(pkgSign, "pkgSign");
        k.f(functionName, "functionName");
        k.f(inputSchema, "inputSchema");
        k.f(callingMethod, "callingMethod");
        k.f(callType, "callType");
        this.toolName = toolName;
        this.description = description;
        this.icon = icon;
        this.appVersion = appVersion;
        this.packageName = packageName;
        this.pkgSign = pkgSign;
        this.functionName = functionName;
        this.extra = map;
        this.inputSchema = inputSchema;
        this.timeout = i;
        this.callingMethod = callingMethod;
        this.callType = callType;
        this.slaScene = str;
    }

    public static /* synthetic */ AbilityMetaDataResult copy$default(AbilityMetaDataResult abilityMetaDataResult, String str, String str2, String str3, String str4, String str5, String str6, String str7, Map map, String str8, int i, String str9, String str10, String str11, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = abilityMetaDataResult.toolName;
        }
        return abilityMetaDataResult.copy(str, (i6 & 2) != 0 ? abilityMetaDataResult.description : str2, (i6 & 4) != 0 ? abilityMetaDataResult.icon : str3, (i6 & 8) != 0 ? abilityMetaDataResult.appVersion : str4, (i6 & 16) != 0 ? abilityMetaDataResult.packageName : str5, (i6 & 32) != 0 ? abilityMetaDataResult.pkgSign : str6, (i6 & 64) != 0 ? abilityMetaDataResult.functionName : str7, (i6 & 128) != 0 ? abilityMetaDataResult.extra : map, (i6 & 256) != 0 ? abilityMetaDataResult.inputSchema : str8, (i6 & 512) != 0 ? abilityMetaDataResult.timeout : i, (i6 & 1024) != 0 ? abilityMetaDataResult.callingMethod : str9, (i6 & 2048) != 0 ? abilityMetaDataResult.callType : str10, (i6 & 4096) != 0 ? abilityMetaDataResult.slaScene : str11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component10, reason: from getter */
    public final int getTimeout() {
        return this.timeout;
    }

    /* renamed from: component11, reason: from getter */
    public final String getCallingMethod() {
        return this.callingMethod;
    }

    /* renamed from: component12, reason: from getter */
    public final String getCallType() {
        return this.callType;
    }

    /* renamed from: component13, reason: from getter */
    public final String getSlaScene() {
        return this.slaScene;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component3, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPkgSign() {
        return this.pkgSign;
    }

    /* renamed from: component7, reason: from getter */
    public final String getFunctionName() {
        return this.functionName;
    }

    public final Map<String, Object> component8() {
        return this.extra;
    }

    /* renamed from: component9, reason: from getter */
    public final String getInputSchema() {
        return this.inputSchema;
    }

    public final AbilityMetaDataResult copy(String toolName, String description, String icon, String appVersion, String packageName, String pkgSign, String functionName, Map<String, ? extends Object> extra, String inputSchema, int timeout, String callingMethod, String callType, String slaScene) {
        k.f(toolName, "toolName");
        k.f(description, "description");
        k.f(icon, "icon");
        k.f(appVersion, "appVersion");
        k.f(packageName, "packageName");
        k.f(pkgSign, "pkgSign");
        k.f(functionName, "functionName");
        k.f(inputSchema, "inputSchema");
        k.f(callingMethod, "callingMethod");
        k.f(callType, "callType");
        return new AbilityMetaDataResult(toolName, description, icon, appVersion, packageName, pkgSign, functionName, extra, inputSchema, timeout, callingMethod, callType, slaScene);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbilityMetaDataResult)) {
            return false;
        }
        AbilityMetaDataResult abilityMetaDataResult = (AbilityMetaDataResult) other;
        return k.b(this.toolName, abilityMetaDataResult.toolName) && k.b(this.description, abilityMetaDataResult.description) && k.b(this.icon, abilityMetaDataResult.icon) && k.b(this.appVersion, abilityMetaDataResult.appVersion) && k.b(this.packageName, abilityMetaDataResult.packageName) && k.b(this.pkgSign, abilityMetaDataResult.pkgSign) && k.b(this.functionName, abilityMetaDataResult.functionName) && k.b(this.extra, abilityMetaDataResult.extra) && k.b(this.inputSchema, abilityMetaDataResult.inputSchema) && this.timeout == abilityMetaDataResult.timeout && k.b(this.callingMethod, abilityMetaDataResult.callingMethod) && k.b(this.callType, abilityMetaDataResult.callType) && k.b(this.slaScene, abilityMetaDataResult.slaScene);
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getCallType() {
        return this.callType;
    }

    public final String getCallingMethod() {
        return this.callingMethod;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final String getFunctionName() {
        return this.functionName;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getInputSchema() {
        return this.inputSchema;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPkgSign() {
        return this.pkgSign;
    }

    public final String getSlaScene() {
        return this.slaScene;
    }

    public final int getTimeout() {
        return this.timeout;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public int hashCode() {
        int iC = a.c(a.c(a.c(a.c(a.c(a.c(this.toolName.hashCode() * 31, 31, this.description), 31, this.icon), 31, this.appVersion), 31, this.packageName), 31, this.pkgSign), 31, this.functionName);
        Map<String, Object> map = this.extra;
        int iC2 = a.c(a.c(androidx.constraintlayout.core.dsl.a.a(this.timeout, a.c((iC + (map == null ? 0 : map.hashCode())) * 31, 31, this.inputSchema), 31), 31, this.callingMethod), 31, this.callType);
        String str = this.slaScene;
        return iC2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        String str = this.toolName;
        String str2 = this.functionName;
        String str3 = this.packageName;
        String str4 = this.callingMethod;
        String str5 = this.callType;
        int i = this.timeout;
        String str6 = this.slaScene;
        boolean z10 = false;
        if (this.extra != null && (!r7.isEmpty())) {
            z10 = true;
        }
        boolean z11 = !m.s0(this.inputSchema);
        StringBuilder sbW = a.w("AbilityMetaDataResult(toolName=", str, ", functionName=", str2, ", packageName=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", callingMethod=", str4, ", callType=");
        b.B(sbW, str5, ", timeout=", i, ", slaScene=");
        sbW.append(str6);
        sbW.append(", extra=<redacted>, hasExtra=");
        sbW.append(z10);
        sbW.append(", inputSchema=<redacted>, hasInputSchema=");
        return a.s(sbW, z11, ")");
    }

    public /* synthetic */ AbilityMetaDataResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map map, String str8, int i, String str9, String str10, String str11, int i6, e eVar) {
        this(str, str2, str3, str4, str5, str6, str7, map, str8, i, (i6 & 1024) != 0 ? "" : str9, (i6 & 2048) != 0 ? "" : str10, (i6 & 4096) != 0 ? null : str11);
    }
}
