package com.zyql.agentfront.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import k7.w;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0013J\u0010\u0010\u0019\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0011J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010\u0015¨\u0006%"}, d2 = {"Lcom/zyql/agentfront/bean/ToolResponse;", "Landroid/os/Parcelable;", "", "callId", "Lcom/zyql/agentfront/bean/ToolResult;", "response", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/zyql/agentfront/bean/ToolResult;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "()Lcom/zyql/agentfront/bean/ToolResult;", "copy", "(Ljava/lang/String;Lcom/zyql/agentfront/bean/ToolResult;)Lcom/zyql/agentfront/bean/ToolResponse;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCallId", "Lcom/zyql/agentfront/bean/ToolResult;", "getResponse", "CREATOR", "k7/w", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToolResponse implements Parcelable {
    public static final w CREATOR = new w();
    private final String callId;
    private final ToolResult response;

    public ToolResponse(String callId, ToolResult response) {
        k.f(callId, "callId");
        k.f(response, "response");
        this.callId = callId;
        this.response = response;
    }

    public static /* synthetic */ ToolResponse copy$default(ToolResponse toolResponse, String str, ToolResult toolResult, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toolResponse.callId;
        }
        if ((i & 2) != 0) {
            toolResult = toolResponse.response;
        }
        return toolResponse.copy(str, toolResult);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCallId() {
        return this.callId;
    }

    /* renamed from: component2, reason: from getter */
    public final ToolResult getResponse() {
        return this.response;
    }

    public final ToolResponse copy(String callId, ToolResult response) {
        k.f(callId, "callId");
        k.f(response, "response");
        return new ToolResponse(callId, response);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolResponse)) {
            return false;
        }
        ToolResponse toolResponse = (ToolResponse) other;
        return k.b(this.callId, toolResponse.callId) && k.b(this.response, toolResponse.response);
    }

    public final String getCallId() {
        return this.callId;
    }

    public final ToolResult getResponse() {
        return this.response;
    }

    public int hashCode() {
        return this.response.hashCode() + (this.callId.hashCode() * 31);
    }

    public String toString() {
        return "ToolResponse(callId=" + this.callId + ", response=" + this.response + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeString(this.callId);
        parcel.writeParcelable(this.response, flags);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ToolResponse(Parcel parcel) {
        k.f(parcel, "parcel");
        String string = parcel.readString();
        string = string == null ? "" : string;
        ToolResult toolResult = (ToolResult) parcel.readParcelable(ToolResult.class.getClassLoader());
        this(string, toolResult == null ? new ToolResult(new ToolContent(EmptyList.f4893a, false)) : toolResult);
    }
}
