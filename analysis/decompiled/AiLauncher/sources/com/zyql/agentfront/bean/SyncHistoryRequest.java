package com.zyql.agentfront.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001!B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J&\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0012J\u0010\u0010\u0017\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0010J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u0012R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001f\u0010\u0012¨\u0006\""}, d2 = {"Lcom/zyql/agentfront/bean/SyncHistoryRequest;", "Landroid/os/Parcelable;", "", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, DidiCardProvider.KEY_TRACE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/SyncHistoryRequest;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionKey", "getTraceId", "CREATOR", Const.INTENT_KEY_APIKEY, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SyncHistoryRequest implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String sessionKey;
    private final String traceId;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/zyql/agentfront/bean/SyncHistoryRequest$a;", "Landroid/os/Parcelable$Creator;", "Lcom/zyql/agentfront/bean/SyncHistoryRequest;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/zyql/agentfront/bean/SyncHistoryRequest;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/zyql/agentfront/bean/SyncHistoryRequest;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.zyql.agentfront.bean.SyncHistoryRequest$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<SyncHistoryRequest> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SyncHistoryRequest createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new SyncHistoryRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SyncHistoryRequest[] newArray(int size) {
            return new SyncHistoryRequest[size];
        }

        public Companion() {
        }
    }

    public SyncHistoryRequest(String sessionKey, String str) {
        p.i(sessionKey, "sessionKey");
        this.sessionKey = sessionKey;
        this.traceId = str;
    }

    public static /* synthetic */ SyncHistoryRequest copy$default(SyncHistoryRequest syncHistoryRequest, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = syncHistoryRequest.sessionKey;
        }
        if ((i10 & 2) != 0) {
            str2 = syncHistoryRequest.traceId;
        }
        return syncHistoryRequest.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final SyncHistoryRequest copy(String sessionKey, String traceId) {
        p.i(sessionKey, "sessionKey");
        return new SyncHistoryRequest(sessionKey, traceId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncHistoryRequest)) {
            return false;
        }
        SyncHistoryRequest syncHistoryRequest = (SyncHistoryRequest) other;
        return p.d(this.sessionKey, syncHistoryRequest.sessionKey) && p.d(this.traceId, syncHistoryRequest.traceId);
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iHashCode = this.sessionKey.hashCode() * 31;
        String str = this.traceId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SyncHistoryRequest(sessionKey=" + this.sessionKey + ", traceId=" + this.traceId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        parcel.writeString(this.sessionKey);
        parcel.writeString(this.traceId);
    }

    public /* synthetic */ SyncHistoryRequest(String str, String str2, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? null : str2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SyncHistoryRequest(Parcel parcel) {
        p.i(parcel, "parcel");
        String string = parcel.readString();
        this(string == null ? "" : string, parcel.readString());
    }
}
