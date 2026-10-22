package com.zyql.agentfront.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import k7.q;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001!B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J&\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0012J\u0010\u0010\u0017\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0010J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u0012R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001f\u0010\u0012¨\u0006\""}, d2 = {"Lcom/zyql/agentfront/bean/SyncHistoryRequest;", "Landroid/os/Parcelable;", "", "sessionKey", AgentBusWakeContract.EXTRA_TRACE_ID, AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/SyncHistoryRequest;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionKey", "getTraceId", "CREATOR", "k7/q", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SyncHistoryRequest implements Parcelable {
    public static final q CREATOR = new q();
    private final String sessionKey;
    private final String traceId;

    public SyncHistoryRequest(String sessionKey, String str) {
        k.f(sessionKey, "sessionKey");
        this.sessionKey = sessionKey;
        this.traceId = str;
    }

    public static /* synthetic */ SyncHistoryRequest copy$default(SyncHistoryRequest syncHistoryRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = syncHistoryRequest.sessionKey;
        }
        if ((i & 2) != 0) {
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
        k.f(sessionKey, "sessionKey");
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
        return k.b(this.sessionKey, syncHistoryRequest.sessionKey) && k.b(this.traceId, syncHistoryRequest.traceId);
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
        return a.m("SyncHistoryRequest(sessionKey=", this.sessionKey, ", traceId=", this.traceId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeString(this.sessionKey);
        parcel.writeString(this.traceId);
    }

    public /* synthetic */ SyncHistoryRequest(String str, String str2, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SyncHistoryRequest(Parcel parcel) {
        k.f(parcel, "parcel");
        String string = parcel.readString();
        this(string == null ? "" : string, parcel.readString());
    }
}
