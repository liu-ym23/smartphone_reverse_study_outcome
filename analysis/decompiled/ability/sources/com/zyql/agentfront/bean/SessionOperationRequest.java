package com.zyql.agentfront.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import k7.n;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001(B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0012J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0014J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0014J<\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J\u0010\u0010\u001b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0012J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010\u0012R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b%\u0010\u0014R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b&\u0010\u0014¨\u0006)"}, d2 = {"Lcom/zyql/agentfront/bean/SessionOperationRequest;", "Landroid/os/Parcelable;", "", "sessionKey", "", "operation", "newTitle", AgentBusWakeContract.EXTRA_TRACE_ID, AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/SessionOperationRequest;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionKey", "I", "getOperation", "getNewTitle", "getTraceId", "CREATOR", "k7/n", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SessionOperationRequest implements Parcelable {
    public static final n CREATOR = new n();
    public static final int OP_CLEAR = 2;
    public static final int OP_DELETE = 1;
    public static final int OP_RENAME = 3;
    private final String newTitle;
    private final int operation;
    private final String sessionKey;
    private final String traceId;

    public SessionOperationRequest(String sessionKey, int i, String str, String str2) {
        k.f(sessionKey, "sessionKey");
        this.sessionKey = sessionKey;
        this.operation = i;
        this.newTitle = str;
        this.traceId = str2;
    }

    public static /* synthetic */ SessionOperationRequest copy$default(SessionOperationRequest sessionOperationRequest, String str, int i, String str2, String str3, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = sessionOperationRequest.sessionKey;
        }
        if ((i6 & 2) != 0) {
            i = sessionOperationRequest.operation;
        }
        if ((i6 & 4) != 0) {
            str2 = sessionOperationRequest.newTitle;
        }
        if ((i6 & 8) != 0) {
            str3 = sessionOperationRequest.traceId;
        }
        return sessionOperationRequest.copy(str, i, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    /* renamed from: component2, reason: from getter */
    public final int getOperation() {
        return this.operation;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNewTitle() {
        return this.newTitle;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final SessionOperationRequest copy(String sessionKey, int operation, String newTitle, String traceId) {
        k.f(sessionKey, "sessionKey");
        return new SessionOperationRequest(sessionKey, operation, newTitle, traceId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionOperationRequest)) {
            return false;
        }
        SessionOperationRequest sessionOperationRequest = (SessionOperationRequest) other;
        return k.b(this.sessionKey, sessionOperationRequest.sessionKey) && this.operation == sessionOperationRequest.operation && k.b(this.newTitle, sessionOperationRequest.newTitle) && k.b(this.traceId, sessionOperationRequest.traceId);
    }

    public final String getNewTitle() {
        return this.newTitle;
    }

    public final int getOperation() {
        return this.operation;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iA = a.a(this.operation, this.sessionKey.hashCode() * 31, 31);
        String str = this.newTitle;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.traceId;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.sessionKey;
        int i = this.operation;
        return androidx.appfunctions.metadata.a.p(androidx.appfunctions.metadata.a.t(i, "SessionOperationRequest(sessionKey=", str, ", operation=", ", newTitle="), this.newTitle, ", traceId=", this.traceId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeString(this.sessionKey);
        parcel.writeInt(this.operation);
        parcel.writeString(this.newTitle);
        parcel.writeString(this.traceId);
    }

    public /* synthetic */ SessionOperationRequest(String str, int i, String str2, String str3, int i6, e eVar) {
        this(str, i, (i6 & 4) != 0 ? null : str2, (i6 & 8) != 0 ? null : str3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SessionOperationRequest(Parcel parcel) {
        k.f(parcel, "parcel");
        String string = parcel.readString();
        this(string == null ? "" : string, parcel.readInt(), parcel.readString(), parcel.readString());
    }
}
