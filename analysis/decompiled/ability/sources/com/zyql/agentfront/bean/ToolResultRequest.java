package com.zyql.agentfront.bean;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.io.Serializable;
import java.util.Map;
import k7.y;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u00010BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0017J\u001e\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0017J^\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0017J\u0010\u0010!\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b!\u0010\u0015J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010'\u001a\u0004\b)\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b*\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b+\u0010\u0017R%\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b-\u0010\u001cR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b.\u0010\u0017¨\u00061"}, d2 = {"Lcom/zyql/agentfront/bean/ToolResultRequest;", "Landroid/os/Parcelable;", "", Key.KEY_TOOL_CALL_ID, "toolName", "result", "sourcePackage", "", "extra", AgentBusWakeContract.EXTRA_TRACE_ID, AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "()Ljava/util/Map;", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lcom/zyql/agentfront/bean/ToolResultRequest;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToolCallId", "getToolName", "getResult", "getSourcePackage", "Ljava/util/Map;", "getExtra", "getTraceId", "CREATOR", "k7/y", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToolResultRequest implements Parcelable {
    public static final y CREATOR = new y();
    private final Map<String, String> extra;
    private final String result;
    private final String sourcePackage;
    private final String toolCallId;
    private final String toolName;
    private final String traceId;

    public ToolResultRequest(String toolCallId, String toolName, String result, String str, Map<String, String> map, String str2) {
        k.f(toolCallId, "toolCallId");
        k.f(toolName, "toolName");
        k.f(result, "result");
        this.toolCallId = toolCallId;
        this.toolName = toolName;
        this.result = result;
        this.sourcePackage = str;
        this.extra = map;
        this.traceId = str2;
    }

    public static /* synthetic */ ToolResultRequest copy$default(ToolResultRequest toolResultRequest, String str, String str2, String str3, String str4, Map map, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toolResultRequest.toolCallId;
        }
        if ((i & 2) != 0) {
            str2 = toolResultRequest.toolName;
        }
        if ((i & 4) != 0) {
            str3 = toolResultRequest.result;
        }
        if ((i & 8) != 0) {
            str4 = toolResultRequest.sourcePackage;
        }
        if ((i & 16) != 0) {
            map = toolResultRequest.extra;
        }
        if ((i & 32) != 0) {
            str5 = toolResultRequest.traceId;
        }
        Map map2 = map;
        String str6 = str5;
        return toolResultRequest.copy(str, str2, str3, str4, map2, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSourcePackage() {
        return this.sourcePackage;
    }

    public final Map<String, String> component5() {
        return this.extra;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final ToolResultRequest copy(String toolCallId, String toolName, String result, String sourcePackage, Map<String, String> extra, String traceId) {
        k.f(toolCallId, "toolCallId");
        k.f(toolName, "toolName");
        k.f(result, "result");
        return new ToolResultRequest(toolCallId, toolName, result, sourcePackage, extra, traceId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolResultRequest)) {
            return false;
        }
        ToolResultRequest toolResultRequest = (ToolResultRequest) other;
        return k.b(this.toolCallId, toolResultRequest.toolCallId) && k.b(this.toolName, toolResultRequest.toolName) && k.b(this.result, toolResultRequest.result) && k.b(this.sourcePackage, toolResultRequest.sourcePackage) && k.b(this.extra, toolResultRequest.extra) && k.b(this.traceId, toolResultRequest.traceId);
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getResult() {
        return this.result;
    }

    public final String getSourcePackage() {
        return this.sourcePackage;
    }

    public final String getToolCallId() {
        return this.toolCallId;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iC = a.c(a.c(this.toolCallId.hashCode() * 31, 31, this.toolName), 31, this.result);
        String str = this.sourcePackage;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, String> map = this.extra;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str2 = this.traceId;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.toolCallId;
        String str2 = this.toolName;
        String str3 = this.result;
        String str4 = this.sourcePackage;
        Map<String, String> map = this.extra;
        String str5 = this.traceId;
        StringBuilder sbW = a.w("ToolResultRequest(toolCallId=", str, ", toolName=", str2, ", result=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", sourcePackage=", str4, ", extra=");
        sbW.append(map);
        sbW.append(", traceId=");
        sbW.append(str5);
        sbW.append(")");
        return sbW.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeString(this.toolCallId);
        parcel.writeString(this.toolName);
        parcel.writeString(this.result);
        parcel.writeString(this.sourcePackage);
        Map<String, String> map = this.extra;
        parcel.writeSerializable(map instanceof Serializable ? (Serializable) map : null);
        parcel.writeString(this.traceId);
    }

    public /* synthetic */ ToolResultRequest(String str, String str2, String str3, String str4, Map map, String str5, int i, e eVar) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : map, (i & 32) != 0 ? null : str5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ToolResultRequest(Parcel parcel) {
        k.f(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        String string2 = parcel.readString();
        String str2 = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        String str3 = string3 == null ? "" : string3;
        String string4 = parcel.readString();
        Serializable serializable = parcel.readSerializable();
        this(str, str2, str3, string4, serializable instanceof Map ? (Map) serializable : null, parcel.readString());
    }
}
