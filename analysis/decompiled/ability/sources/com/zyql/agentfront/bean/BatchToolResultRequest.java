package com.zyql.agentfront.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.List;
import k7.b;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001%B!\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0016J\u0010\u0010\u001a\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0012J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b!\u0010\u0014R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b#\u0010\u0016¨\u0006&"}, d2 = {"Lcom/zyql/agentfront/bean/BatchToolResultRequest;", "Landroid/os/Parcelable;", "", "Lcom/zyql/agentfront/bean/ToolResultRequest;", "results", "", AgentBusWakeContract.EXTRA_TRACE_ID, AppAgent.CONSTRUCT, "(Ljava/util/List;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/List;", "component2", "()Ljava/lang/String;", "copy", "(Ljava/util/List;Ljava/lang/String;)Lcom/zyql/agentfront/bean/BatchToolResultRequest;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getResults", "Ljava/lang/String;", "getTraceId", "CREATOR", "k7/b", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BatchToolResultRequest implements Parcelable {
    public static final b CREATOR = new b();
    private final List<ToolResultRequest> results;
    private final String traceId;

    public BatchToolResultRequest(List<ToolResultRequest> results, String str) {
        k.f(results, "results");
        this.results = results;
        this.traceId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BatchToolResultRequest copy$default(BatchToolResultRequest batchToolResultRequest, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = batchToolResultRequest.results;
        }
        if ((i & 2) != 0) {
            str = batchToolResultRequest.traceId;
        }
        return batchToolResultRequest.copy(list, str);
    }

    public final List<ToolResultRequest> component1() {
        return this.results;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final BatchToolResultRequest copy(List<ToolResultRequest> results, String traceId) {
        k.f(results, "results");
        return new BatchToolResultRequest(results, traceId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchToolResultRequest)) {
            return false;
        }
        BatchToolResultRequest batchToolResultRequest = (BatchToolResultRequest) other;
        return k.b(this.results, batchToolResultRequest.results) && k.b(this.traceId, batchToolResultRequest.traceId);
    }

    public final List<ToolResultRequest> getResults() {
        return this.results;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iHashCode = this.results.hashCode() * 31;
        String str = this.traceId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BatchToolResultRequest(results=" + this.results + ", traceId=" + this.traceId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeTypedList(this.results);
        parcel.writeString(this.traceId);
    }

    public /* synthetic */ BatchToolResultRequest(List list, String str, int i, e eVar) {
        this(list, (i & 2) != 0 ? null : str);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BatchToolResultRequest(Parcel parcel) {
        k.f(parcel, "parcel");
        List listCreateTypedArrayList = parcel.createTypedArrayList(ToolResultRequest.CREATOR);
        this(listCreateTypedArrayList == null ? EmptyList.f4893a : listCreateTypedArrayList, parcel.readString());
    }
}
