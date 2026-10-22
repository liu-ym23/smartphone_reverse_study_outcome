package com.stepos.ability.mcpserver.model;

import B7.a;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 62\u00020\u0001:\u00016B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0019\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0003J\u0019\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\t\u0010*\u001a\u00020\fHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\u0019\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0003J·\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\f2\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\fHÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR!\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019¨\u00067"}, d2 = {"Lcom/stepos/ability/mcpserver/model/ToolDescription;", "", HintConstants.AUTOFILL_HINT_NAME, "", "displayName", "description", "inputSchema", "", "outputSchema", "permissions", "", InjectExperienceResult.REASON_TIMEOUT, "", "packageName", "functionName", "callType", "abilityId", "extra", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;)V", "getName", "()Ljava/lang/String;", "getDisplayName", "getDescription", "getInputSchema", "()Ljava/util/Map;", "getOutputSchema", "getPermissions", "()Ljava/util/List;", "getTimeout", "()I", "getPackageName", "getFunctionName", "getCallType", "getAbilityId", "getExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToolDescription {
    public static final int DEFAULT_TIMEOUT_SEC = 30;
    private final int abilityId;
    private final String callType;
    private final String description;
    private final String displayName;
    private final Map<String, Object> extra;
    private final String functionName;
    private final Map<String, Object> inputSchema;
    private final String name;
    private final Map<String, Object> outputSchema;
    private final String packageName;
    private final List<String> permissions;
    private final int timeout;

    public ToolDescription(String name, String displayName, String description, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, List<String> permissions, int i, String packageName, String functionName, String callType, int i6, Map<String, ? extends Object> map3) {
        k.f(name, "name");
        k.f(displayName, "displayName");
        k.f(description, "description");
        k.f(permissions, "permissions");
        k.f(packageName, "packageName");
        k.f(functionName, "functionName");
        k.f(callType, "callType");
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.inputSchema = map;
        this.outputSchema = map2;
        this.permissions = permissions;
        this.timeout = i;
        this.packageName = packageName;
        this.functionName = functionName;
        this.callType = callType;
        this.abilityId = i6;
        this.extra = map3;
    }

    public static /* synthetic */ ToolDescription copy$default(ToolDescription toolDescription, String str, String str2, String str3, Map map, Map map2, List list, int i, String str4, String str5, String str6, int i6, Map map3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = toolDescription.name;
        }
        if ((i10 & 2) != 0) {
            str2 = toolDescription.displayName;
        }
        if ((i10 & 4) != 0) {
            str3 = toolDescription.description;
        }
        if ((i10 & 8) != 0) {
            map = toolDescription.inputSchema;
        }
        if ((i10 & 16) != 0) {
            map2 = toolDescription.outputSchema;
        }
        if ((i10 & 32) != 0) {
            list = toolDescription.permissions;
        }
        if ((i10 & 64) != 0) {
            i = toolDescription.timeout;
        }
        if ((i10 & 128) != 0) {
            str4 = toolDescription.packageName;
        }
        if ((i10 & 256) != 0) {
            str5 = toolDescription.functionName;
        }
        if ((i10 & 512) != 0) {
            str6 = toolDescription.callType;
        }
        if ((i10 & 1024) != 0) {
            i6 = toolDescription.abilityId;
        }
        if ((i10 & 2048) != 0) {
            map3 = toolDescription.extra;
        }
        int i11 = i6;
        Map map4 = map3;
        String str7 = str5;
        String str8 = str6;
        int i12 = i;
        String str9 = str4;
        Map map5 = map2;
        List list2 = list;
        return toolDescription.copy(str, str2, str3, map, map5, list2, i12, str9, str7, str8, i11, map4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component10, reason: from getter */
    public final String getCallType() {
        return this.callType;
    }

    /* renamed from: component11, reason: from getter */
    public final int getAbilityId() {
        return this.abilityId;
    }

    public final Map<String, Object> component12() {
        return this.extra;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final Map<String, Object> component4() {
        return this.inputSchema;
    }

    public final Map<String, Object> component5() {
        return this.outputSchema;
    }

    public final List<String> component6() {
        return this.permissions;
    }

    /* renamed from: component7, reason: from getter */
    public final int getTimeout() {
        return this.timeout;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component9, reason: from getter */
    public final String getFunctionName() {
        return this.functionName;
    }

    public final ToolDescription copy(String name, String displayName, String description, Map<String, ? extends Object> inputSchema, Map<String, ? extends Object> outputSchema, List<String> permissions, int timeout, String packageName, String functionName, String callType, int abilityId, Map<String, ? extends Object> extra) {
        k.f(name, "name");
        k.f(displayName, "displayName");
        k.f(description, "description");
        k.f(permissions, "permissions");
        k.f(packageName, "packageName");
        k.f(functionName, "functionName");
        k.f(callType, "callType");
        return new ToolDescription(name, displayName, description, inputSchema, outputSchema, permissions, timeout, packageName, functionName, callType, abilityId, extra);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolDescription)) {
            return false;
        }
        ToolDescription toolDescription = (ToolDescription) other;
        return k.b(this.name, toolDescription.name) && k.b(this.displayName, toolDescription.displayName) && k.b(this.description, toolDescription.description) && k.b(this.inputSchema, toolDescription.inputSchema) && k.b(this.outputSchema, toolDescription.outputSchema) && k.b(this.permissions, toolDescription.permissions) && this.timeout == toolDescription.timeout && k.b(this.packageName, toolDescription.packageName) && k.b(this.functionName, toolDescription.functionName) && k.b(this.callType, toolDescription.callType) && this.abilityId == toolDescription.abilityId && k.b(this.extra, toolDescription.extra);
    }

    public final int getAbilityId() {
        return this.abilityId;
    }

    public final String getCallType() {
        return this.callType;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDisplayName() {
        return this.displayName;
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

    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> getOutputSchema() {
        return this.outputSchema;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final List<String> getPermissions() {
        return this.permissions;
    }

    public final int getTimeout() {
        return this.timeout;
    }

    public int hashCode() {
        int iC = a.c(a.c(this.name.hashCode() * 31, 31, this.displayName), 31, this.description);
        Map<String, Object> map = this.inputSchema;
        int iHashCode = (iC + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, Object> map2 = this.outputSchema;
        int iA = androidx.constraintlayout.core.dsl.a.a(this.abilityId, a.c(a.c(a.c(androidx.constraintlayout.core.dsl.a.a(this.timeout, androidx.appfunctions.metadata.a.e(this.permissions, (iHashCode + (map2 == null ? 0 : map2.hashCode())) * 31, 31), 31), 31, this.packageName), 31, this.functionName), 31, this.callType), 31);
        Map<String, Object> map3 = this.extra;
        return iA + (map3 != null ? map3.hashCode() : 0);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.displayName;
        String str3 = this.description;
        Map<String, Object> map = this.inputSchema;
        Map<String, Object> map2 = this.outputSchema;
        List<String> list = this.permissions;
        int i = this.timeout;
        String str4 = this.packageName;
        String str5 = this.functionName;
        String str6 = this.callType;
        int i6 = this.abilityId;
        Map<String, Object> map3 = this.extra;
        StringBuilder sbW = a.w("ToolDescription(name=", str, ", displayName=", str2, ", description=");
        sbW.append(str3);
        sbW.append(", inputSchema=");
        sbW.append(map);
        sbW.append(", outputSchema=");
        sbW.append(map2);
        sbW.append(", permissions=");
        sbW.append(list);
        sbW.append(", timeout=");
        sbW.append(i);
        sbW.append(", packageName=");
        sbW.append(str4);
        sbW.append(", functionName=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str5, ", callType=", str6, ", abilityId=");
        sbW.append(i6);
        sbW.append(", extra=");
        sbW.append(map3);
        sbW.append(")");
        return sbW.toString();
    }
}
