package com.zyql.agentfront.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.List;
import k7.r;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001-B9\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJB\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u001bJ\u0010\u0010 \u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b \u0010\u0015J\u001a\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b#\u0010$R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b&\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b(\u0010\u0019R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b*\u0010\u001bR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010)\u001a\u0004\b+\u0010\u001b¨\u0006."}, d2 = {"Lcom/zyql/agentfront/bean/SyncHistoryResponse;", "Landroid/os/Parcelable;", "", "Lcom/zyql/agentfront/bean/SessionChatMessage;", "messages", "", "success", "", "errorMessage", AgentBusWakeContract.EXTRA_TRACE_ID, AppAgent.CONSTRUCT, "(Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/List;", "component2", "()Z", "component3", "()Ljava/lang/String;", "component4", "copy", "(Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/SyncHistoryResponse;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getMessages", "Z", "getSuccess", "Ljava/lang/String;", "getErrorMessage", "getTraceId", "CREATOR", "k7/r", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SyncHistoryResponse implements Parcelable {
    public static final r CREATOR = new r();
    private final String errorMessage;
    private final List<SessionChatMessage> messages;
    private final boolean success;
    private final String traceId;

    public SyncHistoryResponse() {
        this(null, false, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyncHistoryResponse copy$default(SyncHistoryResponse syncHistoryResponse, List list, boolean z10, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = syncHistoryResponse.messages;
        }
        if ((i & 2) != 0) {
            z10 = syncHistoryResponse.success;
        }
        if ((i & 4) != 0) {
            str = syncHistoryResponse.errorMessage;
        }
        if ((i & 8) != 0) {
            str2 = syncHistoryResponse.traceId;
        }
        return syncHistoryResponse.copy(list, z10, str, str2);
    }

    public final List<SessionChatMessage> component1() {
        return this.messages;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component3, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final SyncHistoryResponse copy(List<SessionChatMessage> messages, boolean success, String errorMessage, String traceId) {
        k.f(messages, "messages");
        return new SyncHistoryResponse(messages, success, errorMessage, traceId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncHistoryResponse)) {
            return false;
        }
        SyncHistoryResponse syncHistoryResponse = (SyncHistoryResponse) other;
        return k.b(this.messages, syncHistoryResponse.messages) && this.success == syncHistoryResponse.success && k.b(this.errorMessage, syncHistoryResponse.errorMessage) && k.b(this.traceId, syncHistoryResponse.traceId);
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final List<SessionChatMessage> getMessages() {
        return this.messages;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iD = a.d(this.messages.hashCode() * 31, 31, this.success);
        String str = this.errorMessage;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.traceId;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        List<SessionChatMessage> list = this.messages;
        boolean z10 = this.success;
        String str = this.errorMessage;
        String str2 = this.traceId;
        StringBuilder sb = new StringBuilder("SyncHistoryResponse(messages=");
        sb.append(list);
        sb.append(", success=");
        sb.append(z10);
        sb.append(", errorMessage=");
        return a.p(sb, str, ", traceId=", str2, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeTypedList(this.messages);
        parcel.writeByte(this.success ? (byte) 1 : (byte) 0);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.traceId);
    }

    public SyncHistoryResponse(List<SessionChatMessage> messages, boolean z10, String str, String str2) {
        k.f(messages, "messages");
        this.messages = messages;
        this.success = z10;
        this.errorMessage = str;
        this.traceId = str2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SyncHistoryResponse(Parcel parcel) {
        k.f(parcel, "parcel");
        List listCreateTypedArrayList = parcel.createTypedArrayList(SessionChatMessage.CREATOR);
        this(listCreateTypedArrayList == null ? EmptyList.f4893a : listCreateTypedArrayList, parcel.readByte() != 0, parcel.readString(), parcel.readString());
    }

    public SyncHistoryResponse(List list, boolean z10, String str, String str2, int i, e eVar) {
        this((i & 1) != 0 ? EmptyList.f4893a : list, (i & 2) != 0 ? false : z10, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
    }
}
