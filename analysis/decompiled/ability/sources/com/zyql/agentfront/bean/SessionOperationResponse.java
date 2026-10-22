package com.zyql.agentfront.bean;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import k7.o;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001&B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J2\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0012J\u001a\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b$\u0010\u0016¨\u0006'"}, d2 = {"Lcom/zyql/agentfront/bean/SessionOperationResponse;", "Landroid/os/Parcelable;", "", "success", "", "errorMessage", AgentBusWakeContract.EXTRA_TRACE_ID, AppAgent.CONSTRUCT, "(ZLjava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Z", "component2", "()Ljava/lang/String;", "component3", "copy", "(ZLjava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/SessionOperationResponse;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getSuccess", "Ljava/lang/String;", "getErrorMessage", "getTraceId", "CREATOR", "k7/o", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SessionOperationResponse implements Parcelable {
    public static final o CREATOR = new o();
    private final String errorMessage;
    private final boolean success;
    private final String traceId;

    public SessionOperationResponse() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ SessionOperationResponse copy$default(SessionOperationResponse sessionOperationResponse, boolean z10, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = sessionOperationResponse.success;
        }
        if ((i & 2) != 0) {
            str = sessionOperationResponse.errorMessage;
        }
        if ((i & 4) != 0) {
            str2 = sessionOperationResponse.traceId;
        }
        return sessionOperationResponse.copy(z10, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final SessionOperationResponse copy(boolean success, String errorMessage, String traceId) {
        return new SessionOperationResponse(success, errorMessage, traceId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionOperationResponse)) {
            return false;
        }
        SessionOperationResponse sessionOperationResponse = (SessionOperationResponse) other;
        return this.success == sessionOperationResponse.success && k.b(this.errorMessage, sessionOperationResponse.errorMessage) && k.b(this.traceId, sessionOperationResponse.traceId);
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        String str = this.errorMessage;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.traceId;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        boolean z10 = this.success;
        String str = this.errorMessage;
        String str2 = this.traceId;
        StringBuilder sb = new StringBuilder("SessionOperationResponse(success=");
        sb.append(z10);
        sb.append(", errorMessage=");
        sb.append(str);
        sb.append(", traceId=");
        return a.q(sb, str2, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeByte(this.success ? (byte) 1 : (byte) 0);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.traceId);
    }

    public SessionOperationResponse(boolean z10, String str, String str2) {
        this.success = z10;
        this.errorMessage = str;
        this.traceId = str2;
    }

    public /* synthetic */ SessionOperationResponse(boolean z10, String str, String str2, int i, e eVar) {
        this((i & 1) != 0 ? false : z10, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionOperationResponse(Parcel parcel) {
        this(parcel.readByte() != 0, parcel.readString(), parcel.readString());
        k.f(parcel, "parcel");
    }
}
