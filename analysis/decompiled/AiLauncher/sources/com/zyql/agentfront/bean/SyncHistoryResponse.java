package com.zyql.agentfront.bean;

import Z8.C1173v;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001-B9\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJB\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u001bJ\u0010\u0010 \u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b \u0010\u0015J\u001a\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b#\u0010$R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b&\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b(\u0010\u0019R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b*\u0010\u001bR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010)\u001a\u0004\b+\u0010\u001b¨\u0006."}, d2 = {"Lcom/zyql/agentfront/bean/SyncHistoryResponse;", "Landroid/os/Parcelable;", "", "Lcom/zyql/agentfront/bean/SessionChatMessage;", "messages", "", "success", "", "errorMessage", DidiCardProvider.KEY_TRACE_ID, "<init>", "(Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/List;", "component2", "()Z", "component3", "()Ljava/lang/String;", "component4", ChatTracker.CLICK_COPY, "(Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/SyncHistoryResponse;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getMessages", "Z", "getSuccess", "Ljava/lang/String;", "getErrorMessage", "getTraceId", "CREATOR", Const.INTENT_KEY_APIKEY, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SyncHistoryResponse implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String errorMessage;
    private final List<SessionChatMessage> messages;
    private final boolean success;
    private final String traceId;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/zyql/agentfront/bean/SyncHistoryResponse$a;", "Landroid/os/Parcelable$Creator;", "Lcom/zyql/agentfront/bean/SyncHistoryResponse;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/zyql/agentfront/bean/SyncHistoryResponse;", "", ContentDisposition.Parameters.Size, "", "c", "(I)[Lcom/zyql/agentfront/bean/SyncHistoryResponse;", "", "errorMessage", DidiCardProvider.KEY_TRACE_ID, Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/SyncHistoryResponse;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.zyql.agentfront.bean.SyncHistoryResponse$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<SyncHistoryResponse> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SyncHistoryResponse createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new SyncHistoryResponse(parcel);
        }

        public final SyncHistoryResponse b(String errorMessage, String traceId) {
            return new SyncHistoryResponse(null, false, errorMessage, traceId, 1, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public SyncHistoryResponse[] newArray(int size) {
            return new SyncHistoryResponse[size];
        }

        public Companion() {
        }
    }

    public SyncHistoryResponse() {
        this(null, false, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyncHistoryResponse copy$default(SyncHistoryResponse syncHistoryResponse, List list, boolean z10, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = syncHistoryResponse.messages;
        }
        if ((i10 & 2) != 0) {
            z10 = syncHistoryResponse.success;
        }
        if ((i10 & 4) != 0) {
            str = syncHistoryResponse.errorMessage;
        }
        if ((i10 & 8) != 0) {
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
        p.i(messages, "messages");
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
        return p.d(this.messages, syncHistoryResponse.messages) && this.success == syncHistoryResponse.success && p.d(this.errorMessage, syncHistoryResponse.errorMessage) && p.d(this.traceId, syncHistoryResponse.traceId);
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
        int iHashCode = ((this.messages.hashCode() * 31) + Boolean.hashCode(this.success)) * 31;
        String str = this.errorMessage;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.traceId;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SyncHistoryResponse(messages=" + this.messages + ", success=" + this.success + ", errorMessage=" + this.errorMessage + ", traceId=" + this.traceId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        parcel.writeTypedList(this.messages);
        parcel.writeByte(this.success ? (byte) 1 : (byte) 0);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.traceId);
    }

    public SyncHistoryResponse(List<SessionChatMessage> messages, boolean z10, String str, String str2) {
        p.i(messages, "messages");
        this.messages = messages;
        this.success = z10;
        this.errorMessage = str;
        this.traceId = str2;
    }

    public /* synthetic */ SyncHistoryResponse(List list, boolean z10, String str, String str2, int i10, i iVar) {
        this((i10 & 1) != 0 ? C1173v.m() : list, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? null : str2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SyncHistoryResponse(Parcel parcel) {
        p.i(parcel, "parcel");
        List listCreateTypedArrayList = parcel.createTypedArrayList(SessionChatMessage.INSTANCE);
        this(listCreateTypedArrayList == null ? C1173v.m() : listCreateTypedArrayList, parcel.readByte() != 0, parcel.readString(), parcel.readString());
    }
}
