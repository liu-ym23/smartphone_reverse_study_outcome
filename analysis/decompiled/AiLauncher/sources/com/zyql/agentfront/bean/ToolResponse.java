package com.zyql.agentfront.bean;

import Z8.C1173v;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0013J\u0010\u0010\u0019\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0011J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010\u0015¨\u0006%"}, d2 = {"Lcom/zyql/agentfront/bean/ToolResponse;", "Landroid/os/Parcelable;", "", "callId", "Lcom/zyql/agentfront/bean/ToolResult;", UxipConstants.f30685x, "<init>", "(Ljava/lang/String;Lcom/zyql/agentfront/bean/ToolResult;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "()Lcom/zyql/agentfront/bean/ToolResult;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Lcom/zyql/agentfront/bean/ToolResult;)Lcom/zyql/agentfront/bean/ToolResponse;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCallId", "Lcom/zyql/agentfront/bean/ToolResult;", "getResponse", "CREATOR", Const.INTENT_KEY_APIKEY, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ToolResponse implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String callId;
    private final ToolResult response;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/zyql/agentfront/bean/ToolResponse$a;", "Landroid/os/Parcelable$Creator;", "Lcom/zyql/agentfront/bean/ToolResponse;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/zyql/agentfront/bean/ToolResponse;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/zyql/agentfront/bean/ToolResponse;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.zyql.agentfront.bean.ToolResponse$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<ToolResponse> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ToolResponse createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new ToolResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ToolResponse[] newArray(int size) {
            return new ToolResponse[size];
        }

        public Companion() {
        }
    }

    public ToolResponse(String callId, ToolResult response) {
        p.i(callId, "callId");
        p.i(response, "response");
        this.callId = callId;
        this.response = response;
    }

    public static /* synthetic */ ToolResponse copy$default(ToolResponse toolResponse, String str, ToolResult toolResult, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = toolResponse.callId;
        }
        if ((i10 & 2) != 0) {
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
        p.i(callId, "callId");
        p.i(response, "response");
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
        return p.d(this.callId, toolResponse.callId) && p.d(this.response, toolResponse.response);
    }

    public final String getCallId() {
        return this.callId;
    }

    public final ToolResult getResponse() {
        return this.response;
    }

    public int hashCode() {
        return (this.callId.hashCode() * 31) + this.response.hashCode();
    }

    public String toString() {
        return "ToolResponse(callId=" + this.callId + ", response=" + this.response + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        parcel.writeString(this.callId);
        parcel.writeParcelable(this.response, flags);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ToolResponse(Parcel parcel) {
        p.i(parcel, "parcel");
        String string = parcel.readString();
        string = string == null ? "" : string;
        ToolResult toolResult = (ToolResult) parcel.readParcelable(ToolResult.class.getClassLoader());
        this(string, toolResult == null ? new ToolResult(new ToolContent(C1173v.m(), false)) : toolResult);
    }
}
