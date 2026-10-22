package com.zyql.agentfront.bean;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import k7.t;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001-BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0016JR\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0016J\u0010\u0010\u001f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0014J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b'\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b(\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b)\u0010\u0016R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b*\u0010\u0016R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b+\u0010\u0016¨\u0006."}, d2 = {"Lcom/zyql/agentfront/bean/ToolCallRequest;", "Landroid/os/Parcelable;", "", "originMessageId", Key.KEY_TOOL_CALL_ID, "conversationId", "toolName", "arguments", AgentBusWakeContract.EXTRA_TRACE_ID, AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/ToolCallRequest;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOriginMessageId", "getToolCallId", "getConversationId", "getToolName", "getArguments", "getTraceId", "CREATOR", "k7/t", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToolCallRequest implements Parcelable {
    public static final t CREATOR = new t();
    private final String arguments;
    private final String conversationId;
    private final String originMessageId;
    private final String toolCallId;
    private final String toolName;
    private final String traceId;

    public ToolCallRequest(String str, String toolCallId, String conversationId, String toolName, String str2, String str3) {
        k.f(toolCallId, "toolCallId");
        k.f(conversationId, "conversationId");
        k.f(toolName, "toolName");
        this.originMessageId = str;
        this.toolCallId = toolCallId;
        this.conversationId = conversationId;
        this.toolName = toolName;
        this.arguments = str2;
        this.traceId = str3;
    }

    public static /* synthetic */ ToolCallRequest copy$default(ToolCallRequest toolCallRequest, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toolCallRequest.originMessageId;
        }
        if ((i & 2) != 0) {
            str2 = toolCallRequest.toolCallId;
        }
        if ((i & 4) != 0) {
            str3 = toolCallRequest.conversationId;
        }
        if ((i & 8) != 0) {
            str4 = toolCallRequest.toolName;
        }
        if ((i & 16) != 0) {
            str5 = toolCallRequest.arguments;
        }
        if ((i & 32) != 0) {
            str6 = toolCallRequest.traceId;
        }
        String str7 = str5;
        String str8 = str6;
        return toolCallRequest.copy(str, str2, str3, str4, str7, str8);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOriginMessageId() {
        return this.originMessageId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getArguments() {
        return this.arguments;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final ToolCallRequest copy(String originMessageId, String toolCallId, String conversationId, String toolName, String arguments, String traceId) {
        k.f(toolCallId, "toolCallId");
        k.f(conversationId, "conversationId");
        k.f(toolName, "toolName");
        return new ToolCallRequest(originMessageId, toolCallId, conversationId, toolName, arguments, traceId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolCallRequest)) {
            return false;
        }
        ToolCallRequest toolCallRequest = (ToolCallRequest) other;
        return k.b(this.originMessageId, toolCallRequest.originMessageId) && k.b(this.toolCallId, toolCallRequest.toolCallId) && k.b(this.conversationId, toolCallRequest.conversationId) && k.b(this.toolName, toolCallRequest.toolName) && k.b(this.arguments, toolCallRequest.arguments) && k.b(this.traceId, toolCallRequest.traceId);
    }

    public final String getArguments() {
        return this.arguments;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getOriginMessageId() {
        return this.originMessageId;
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
        int iC = a.c(a.c(a.c((str == null ? 0 : str.hashCode()) * 31, 31, this.toolCallId), 31, this.conversationId), 31, this.toolName);
        String str2 = this.arguments;
        int iHashCode = (iC + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.traceId;
        return iHashCode + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        String str = this.originMessageId;
        String str2 = this.toolCallId;
        String str3 = this.conversationId;
        String str4 = this.toolName;
        String str5 = this.arguments;
        String str6 = this.traceId;
        StringBuilder sbW = a.w("ToolCallRequest(originMessageId=", str, ", toolCallId=", str2, ", conversationId=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", toolName=", str4, ", arguments=");
        return androidx.appfunctions.metadata.a.p(sbW, str5, ", traceId=", str6, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeString(this.originMessageId);
        parcel.writeString(this.toolCallId);
        parcel.writeString(this.conversationId);
        parcel.writeString(this.toolName);
        parcel.writeString(this.arguments);
        parcel.writeString(this.traceId);
    }

    public /* synthetic */ ToolCallRequest(String str, String str2, String str3, String str4, String str5, String str6, int i, e eVar) {
        this((i & 1) != 0 ? null : str, str2, str3, str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ToolCallRequest(Parcel parcel) {
        k.f(parcel, "parcel");
        String string = parcel.readString();
        String string2 = parcel.readString();
        String str = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        String str2 = string3 == null ? "" : string3;
        String string4 = parcel.readString();
        this(string, str, str2, string4 == null ? "" : string4, parcel.readString(), parcel.readString());
    }
}
