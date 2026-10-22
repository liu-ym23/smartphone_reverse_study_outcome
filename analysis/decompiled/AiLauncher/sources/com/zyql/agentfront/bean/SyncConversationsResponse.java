package com.zyql.agentfront.bean;

import Z8.C1173v;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001*B-\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ6\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001aJ\u0010\u0010\u001e\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0014J\u001a\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b$\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010\u0018R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010\u001a¨\u0006+"}, d2 = {"Lcom/zyql/agentfront/bean/SyncConversationsResponse;", "Landroid/os/Parcelable;", "", "Lcom/zyql/agentfront/bean/SessionInfo;", "sessions", "", "success", "", "errorMessage", "<init>", "(Ljava/util/List;ZLjava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/List;", "component2", "()Z", "component3", "()Ljava/lang/String;", ChatTracker.CLICK_COPY, "(Ljava/util/List;ZLjava/lang/String;)Lcom/zyql/agentfront/bean/SyncConversationsResponse;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getSessions", "Z", "getSuccess", "Ljava/lang/String;", "getErrorMessage", "CREATOR", Const.INTENT_KEY_APIKEY, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SyncConversationsResponse implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String errorMessage;
    private final List<SessionInfo> sessions;
    private final boolean success;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/zyql/agentfront/bean/SyncConversationsResponse$a;", "Landroid/os/Parcelable$Creator;", "Lcom/zyql/agentfront/bean/SyncConversationsResponse;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/zyql/agentfront/bean/SyncConversationsResponse;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/zyql/agentfront/bean/SyncConversationsResponse;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.zyql.agentfront.bean.SyncConversationsResponse$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<SyncConversationsResponse> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SyncConversationsResponse createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new SyncConversationsResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SyncConversationsResponse[] newArray(int size) {
            return new SyncConversationsResponse[size];
        }

        public Companion() {
        }
    }

    public SyncConversationsResponse() {
        this(null, false, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyncConversationsResponse copy$default(SyncConversationsResponse syncConversationsResponse, List list, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = syncConversationsResponse.sessions;
        }
        if ((i10 & 2) != 0) {
            z10 = syncConversationsResponse.success;
        }
        if ((i10 & 4) != 0) {
            str = syncConversationsResponse.errorMessage;
        }
        return syncConversationsResponse.copy(list, z10, str);
    }

    public final List<SessionInfo> component1() {
        return this.sessions;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component3, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final SyncConversationsResponse copy(List<SessionInfo> sessions, boolean success, String errorMessage) {
        p.i(sessions, "sessions");
        return new SyncConversationsResponse(sessions, success, errorMessage);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncConversationsResponse)) {
            return false;
        }
        SyncConversationsResponse syncConversationsResponse = (SyncConversationsResponse) other;
        return p.d(this.sessions, syncConversationsResponse.sessions) && this.success == syncConversationsResponse.success && p.d(this.errorMessage, syncConversationsResponse.errorMessage);
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final List<SessionInfo> getSessions() {
        return this.sessions;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int iHashCode = ((this.sessions.hashCode() * 31) + Boolean.hashCode(this.success)) * 31;
        String str = this.errorMessage;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SyncConversationsResponse(sessions=" + this.sessions + ", success=" + this.success + ", errorMessage=" + this.errorMessage + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        parcel.writeTypedList(this.sessions);
        parcel.writeByte(this.success ? (byte) 1 : (byte) 0);
        parcel.writeString(this.errorMessage);
    }

    public SyncConversationsResponse(List<SessionInfo> sessions, boolean z10, String str) {
        p.i(sessions, "sessions");
        this.sessions = sessions;
        this.success = z10;
        this.errorMessage = str;
    }

    public /* synthetic */ SyncConversationsResponse(List list, boolean z10, String str, int i10, i iVar) {
        this((i10 & 1) != 0 ? C1173v.m() : list, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? null : str);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SyncConversationsResponse(Parcel parcel) {
        p.i(parcel, "parcel");
        List listCreateTypedArrayList = parcel.createTypedArrayList(SessionInfo.INSTANCE);
        this(listCreateTypedArrayList == null ? C1173v.m() : listCreateTypedArrayList, parcel.readByte() != 0, parcel.readString());
    }
}
