package com.zyql.agentfront.bean;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.io.Serializable;
import java.util.Map;
import k7.d;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001'B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0014J>\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J\u0010\u0010\u001b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0012J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0014R%\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b%\u0010\u0014¨\u0006("}, d2 = {"Lcom/zyql/agentfront/bean/CancelMessageRequest;", "Landroid/os/Parcelable;", "", "messageId", "", "extra", AgentBusWakeContract.EXTRA_TRACE_ID, AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/Map;", "component3", "copy", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lcom/zyql/agentfront/bean/CancelMessageRequest;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessageId", "Ljava/util/Map;", "getExtra", "getTraceId", "CREATOR", "k7/d", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CancelMessageRequest implements Parcelable {
    public static final d CREATOR = new d();
    private final Map<String, String> extra;
    private final String messageId;
    private final String traceId;

    public CancelMessageRequest(String messageId, Map<String, String> map, String str) {
        k.f(messageId, "messageId");
        this.messageId = messageId;
        this.extra = map;
        this.traceId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CancelMessageRequest copy$default(CancelMessageRequest cancelMessageRequest, String str, Map map, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cancelMessageRequest.messageId;
        }
        if ((i & 2) != 0) {
            map = cancelMessageRequest.extra;
        }
        if ((i & 4) != 0) {
            str2 = cancelMessageRequest.traceId;
        }
        return cancelMessageRequest.copy(str, map, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    public final Map<String, String> component2() {
        return this.extra;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final CancelMessageRequest copy(String messageId, Map<String, String> extra, String traceId) {
        k.f(messageId, "messageId");
        return new CancelMessageRequest(messageId, extra, traceId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CancelMessageRequest)) {
            return false;
        }
        CancelMessageRequest cancelMessageRequest = (CancelMessageRequest) other;
        return k.b(this.messageId, cancelMessageRequest.messageId) && k.b(this.extra, cancelMessageRequest.extra) && k.b(this.traceId, cancelMessageRequest.traceId);
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iHashCode = this.messageId.hashCode() * 31;
        Map<String, String> map = this.extra;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.traceId;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        String str = this.messageId;
        Map<String, String> map = this.extra;
        String str2 = this.traceId;
        StringBuilder sb = new StringBuilder("CancelMessageRequest(messageId=");
        sb.append(str);
        sb.append(", extra=");
        sb.append(map);
        sb.append(", traceId=");
        return a.q(sb, str2, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeString(this.messageId);
        Map<String, String> map = this.extra;
        parcel.writeSerializable(map instanceof Serializable ? (Serializable) map : null);
        parcel.writeString(this.traceId);
    }

    public /* synthetic */ CancelMessageRequest(String str, Map map, String str2, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : str2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CancelMessageRequest(Parcel parcel) {
        k.f(parcel, "parcel");
        String string = parcel.readString();
        string = string == null ? "" : string;
        Serializable serializable = parcel.readSerializable();
        this(string, serializable instanceof Map ? (Map) serializable : null, parcel.readString());
    }
}
