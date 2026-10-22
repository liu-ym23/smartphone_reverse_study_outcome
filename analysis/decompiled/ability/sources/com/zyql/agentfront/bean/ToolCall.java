package com.zyql.agentfront.bean;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.io.Serializable;
import java.util.Map;
import k7.s;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0086\b\u0018\u0000 G2\u00020\u0001:\u0001HB¡\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001fJ\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u001fJ\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u001fJ\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u001fJ\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001fJ\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u001fJ\u0012\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\u001fJ\u0012\u0010'\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u001fJ\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010\u001fJ\u0010\u0010)\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b)\u0010*J\u001e\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b+\u0010,J\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010\u001fJ°\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b0\u0010\u001fJ\u0010\u00101\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b1\u0010\u001dJ\u001a\u00104\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u000102HÖ\u0003¢\u0006\u0004\b4\u00105R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00106\u001a\u0004\b7\u0010\u001fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00106\u001a\u0004\b8\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00106\u001a\u0004\b9\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u00106\u001a\u0004\b:\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u00106\u001a\u0004\b;\u0010\u001fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u00106\u001a\u0004\b<\u0010\u001fR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u00106\u001a\u0004\b=\u0010\u001fR$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00106\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010@R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u00106\u001a\u0004\bA\u0010\u001fR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u00106\u001a\u0004\bB\u0010\u001fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010C\u001a\u0004\b\u000e\u0010*R%\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010D\u001a\u0004\bE\u0010,R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u00106\u001a\u0004\bF\u0010\u001f¨\u0006I"}, d2 = {"Lcom/zyql/agentfront/bean/ToolCall;", "Landroid/os/Parcelable;", "", "originMessageId", "conversationId", Key.KEY_TOOL_CALL_ID, "toolName", "apiName", "arguments", "packageName", "sourcePackageName", "targetAgentPackage", "result", "", "isError", "", "extra", AgentBusWakeContract.EXTRA_TRACE_ID, AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "()Z", "component12", "()Ljava/util/Map;", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;Ljava/lang/String;)Lcom/zyql/agentfront/bean/ToolCall;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOriginMessageId", "getConversationId", "getToolCallId", "getToolName", "getApiName", "getArguments", "getPackageName", "getSourcePackageName", "setSourcePackageName", "(Ljava/lang/String;)V", "getTargetAgentPackage", "getResult", "Z", "Ljava/util/Map;", "getExtra", "getTraceId", "CREATOR", "k7/s", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToolCall implements Parcelable {
    public static final s CREATOR = new s();
    private final String apiName;
    private final String arguments;
    private final String conversationId;
    private final Map<String, String> extra;
    private final boolean isError;
    private final String originMessageId;
    private final String packageName;
    private final String result;
    private String sourcePackageName;
    private final String targetAgentPackage;
    private final String toolCallId;
    private final String toolName;
    private final String traceId;

    public ToolCall(String str, String conversationId, String toolCallId, String toolName, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10, Map<String, String> map, String str8) {
        k.f(conversationId, "conversationId");
        k.f(toolCallId, "toolCallId");
        k.f(toolName, "toolName");
        this.originMessageId = str;
        this.conversationId = conversationId;
        this.toolCallId = toolCallId;
        this.toolName = toolName;
        this.apiName = str2;
        this.arguments = str3;
        this.packageName = str4;
        this.sourcePackageName = str5;
        this.targetAgentPackage = str6;
        this.result = str7;
        this.isError = z10;
        this.extra = map;
        this.traceId = str8;
    }

    public static /* synthetic */ ToolCall copy$default(ToolCall toolCall, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z10, Map map, String str11, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toolCall.originMessageId;
        }
        return toolCall.copy(str, (i & 2) != 0 ? toolCall.conversationId : str2, (i & 4) != 0 ? toolCall.toolCallId : str3, (i & 8) != 0 ? toolCall.toolName : str4, (i & 16) != 0 ? toolCall.apiName : str5, (i & 32) != 0 ? toolCall.arguments : str6, (i & 64) != 0 ? toolCall.packageName : str7, (i & 128) != 0 ? toolCall.sourcePackageName : str8, (i & 256) != 0 ? toolCall.targetAgentPackage : str9, (i & 512) != 0 ? toolCall.result : str10, (i & 1024) != 0 ? toolCall.isError : z10, (i & 2048) != 0 ? toolCall.extra : map, (i & 4096) != 0 ? toolCall.traceId : str11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOriginMessageId() {
        return this.originMessageId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsError() {
        return this.isError;
    }

    public final Map<String, String> component12() {
        return this.extra;
    }

    /* renamed from: component13, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getApiName() {
        return this.apiName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getArguments() {
        return this.arguments;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component8, reason: from getter */
    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTargetAgentPackage() {
        return this.targetAgentPackage;
    }

    public final ToolCall copy(String originMessageId, String conversationId, String toolCallId, String toolName, String apiName, String arguments, String packageName, String sourcePackageName, String targetAgentPackage, String result, boolean isError, Map<String, String> extra, String traceId) {
        k.f(conversationId, "conversationId");
        k.f(toolCallId, "toolCallId");
        k.f(toolName, "toolName");
        return new ToolCall(originMessageId, conversationId, toolCallId, toolName, apiName, arguments, packageName, sourcePackageName, targetAgentPackage, result, isError, extra, traceId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolCall)) {
            return false;
        }
        ToolCall toolCall = (ToolCall) other;
        return k.b(this.originMessageId, toolCall.originMessageId) && k.b(this.conversationId, toolCall.conversationId) && k.b(this.toolCallId, toolCall.toolCallId) && k.b(this.toolName, toolCall.toolName) && k.b(this.apiName, toolCall.apiName) && k.b(this.arguments, toolCall.arguments) && k.b(this.packageName, toolCall.packageName) && k.b(this.sourcePackageName, toolCall.sourcePackageName) && k.b(this.targetAgentPackage, toolCall.targetAgentPackage) && k.b(this.result, toolCall.result) && this.isError == toolCall.isError && k.b(this.extra, toolCall.extra) && k.b(this.traceId, toolCall.traceId);
    }

    public final String getApiName() {
        return this.apiName;
    }

    public final String getArguments() {
        return this.arguments;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getOriginMessageId() {
        return this.originMessageId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getResult() {
        return this.result;
    }

    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    public final String getTargetAgentPackage() {
        return this.targetAgentPackage;
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
        String str = this.originMessageId;
        int iC = a.c(a.c(a.c((str == null ? 0 : str.hashCode()) * 31, 31, this.conversationId), 31, this.toolCallId), 31, this.toolName);
        String str2 = this.apiName;
        int iHashCode = (iC + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.arguments;
        int iHashCode2 = (iHashCode + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.packageName;
        int iHashCode3 = (iHashCode2 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.sourcePackageName;
        int iHashCode4 = (iHashCode3 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.targetAgentPackage;
        int iHashCode5 = (iHashCode4 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.result;
        int iD = androidx.appfunctions.metadata.a.d((iHashCode5 + (str7 == null ? 0 : str7.hashCode())) * 31, 31, this.isError);
        Map<String, String> map = this.extra;
        int iHashCode6 = (iD + (map == null ? 0 : map.hashCode())) * 31;
        String str8 = this.traceId;
        return iHashCode6 + (str8 != null ? str8.hashCode() : 0);
    }

    public final boolean isError() {
        return this.isError;
    }

    public final void setSourcePackageName(String str) {
        this.sourcePackageName = str;
    }

    public String toString() {
        String str = this.originMessageId;
        String str2 = this.conversationId;
        String str3 = this.toolCallId;
        String str4 = this.toolName;
        String str5 = this.apiName;
        String str6 = this.arguments;
        String str7 = this.packageName;
        String str8 = this.sourcePackageName;
        String str9 = this.targetAgentPackage;
        String str10 = this.result;
        boolean z10 = this.isError;
        Map<String, String> map = this.extra;
        String str11 = this.traceId;
        StringBuilder sbW = a.w("ToolCall(originMessageId=", str, ", conversationId=", str2, ", toolCallId=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", toolName=", str4, ", apiName=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str5, ", arguments=", str6, ", packageName=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str7, ", sourcePackageName=", str8, ", targetAgentPackage=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str9, ", result=", str10, ", isError=");
        sbW.append(z10);
        sbW.append(", extra=");
        sbW.append(map);
        sbW.append(", traceId=");
        return a.q(sbW, str11, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeString(this.originMessageId);
        parcel.writeString(this.conversationId);
        parcel.writeString(this.toolCallId);
        parcel.writeString(this.toolName);
        parcel.writeString(this.apiName);
        parcel.writeString(this.arguments);
        parcel.writeString(this.packageName);
        parcel.writeString(this.sourcePackageName);
        parcel.writeString(this.targetAgentPackage);
        parcel.writeString(this.result);
        parcel.writeByte(this.isError ? (byte) 1 : (byte) 0);
        Map<String, String> map = this.extra;
        parcel.writeSerializable(map instanceof Serializable ? (Serializable) map : null);
        parcel.writeString(this.traceId);
    }

    public /* synthetic */ ToolCall(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z10, Map map, String str11, int i, e eVar) {
        this((i & 1) != 0 ? null : str, str2, str3, str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? false : z10, (i & 2048) != 0 ? null : map, (i & 4096) != 0 ? null : str11);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ToolCall(Parcel parcel) {
        k.f(parcel, "parcel");
        String string = parcel.readString();
        String string2 = parcel.readString();
        string2 = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        string3 = string3 == null ? "" : string3;
        String string4 = parcel.readString();
        string4 = string4 == null ? "" : string4;
        String string5 = parcel.readString();
        String string6 = parcel.readString();
        String string7 = parcel.readString();
        String string8 = parcel.readString();
        String string9 = parcel.readString();
        String string10 = parcel.readString();
        boolean z10 = parcel.readByte() != 0;
        Serializable serializable = parcel.readSerializable();
        this(string, string2, string3, string4, string5, string6, string7, string8, string9, string10, z10, serializable instanceof Map ? (Map) serializable : null, parcel.readString());
    }
}
