package com.zyql.agentfront.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import k7.p;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001*B-\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ6\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001aJ\u0010\u0010\u001e\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0014J\u001a\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b$\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010\u0018R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010\u001a¨\u0006+"}, d2 = {"Lcom/zyql/agentfront/bean/SyncConversationsResponse;", "Landroid/os/Parcelable;", "", "Lcom/zyql/agentfront/bean/SessionInfo;", "sessions", "", "success", "", "errorMessage", AppAgent.CONSTRUCT, "(Ljava/util/List;ZLjava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/List;", "component2", "()Z", "component3", "()Ljava/lang/String;", "copy", "(Ljava/util/List;ZLjava/lang/String;)Lcom/zyql/agentfront/bean/SyncConversationsResponse;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getSessions", "Z", "getSuccess", "Ljava/lang/String;", "getErrorMessage", "CREATOR", "k7/p", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SyncConversationsResponse implements Parcelable {
    public static final p CREATOR = new p();
    private final String errorMessage;
    private final List<SessionInfo> sessions;
    private final boolean success;

    public SyncConversationsResponse() {
        this(null, false, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SyncConversationsResponse copy$default(SyncConversationsResponse syncConversationsResponse, List list, boolean z10, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = syncConversationsResponse.sessions;
        }
        if ((i & 2) != 0) {
            z10 = syncConversationsResponse.success;
        }
        if ((i & 4) != 0) {
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
        k.f(sessions, "sessions");
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
        return k.b(this.sessions, syncConversationsResponse.sessions) && this.success == syncConversationsResponse.success && k.b(this.errorMessage, syncConversationsResponse.errorMessage);
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
        int iD = a.d(this.sessions.hashCode() * 31, 31, this.success);
        String str = this.errorMessage;
        return iD + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        List<SessionInfo> list = this.sessions;
        boolean z10 = this.success;
        String str = this.errorMessage;
        StringBuilder sb = new StringBuilder("SyncConversationsResponse(sessions=");
        sb.append(list);
        sb.append(", success=");
        sb.append(z10);
        sb.append(", errorMessage=");
        return B7.a.q(sb, str, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeTypedList(this.sessions);
        parcel.writeByte(this.success ? (byte) 1 : (byte) 0);
        parcel.writeString(this.errorMessage);
    }

    public SyncConversationsResponse(List<SessionInfo> sessions, boolean z10, String str) {
        k.f(sessions, "sessions");
        this.sessions = sessions;
        this.success = z10;
        this.errorMessage = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SyncConversationsResponse(Parcel parcel) {
        k.f(parcel, "parcel");
        List listCreateTypedArrayList = parcel.createTypedArrayList(SessionInfo.CREATOR);
        this(listCreateTypedArrayList == null ? EmptyList.f4893a : listCreateTypedArrayList, parcel.readByte() != 0, parcel.readString());
    }

    public SyncConversationsResponse(List list, boolean z10, String str, int i, e eVar) {
        this((i & 1) != 0 ? EmptyList.f4893a : list, (i & 2) != 0 ? false : z10, (i & 4) != 0 ? null : str);
    }
}
