package com.zyql.agentfront.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.List;
import k7.c;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00012BC\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001eJN\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\"\u0010\u001eJ\u0010\u0010#\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b#\u0010\u0016J\u001a\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010(\u001a\u0004\b)\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010*\u001a\u0004\b+\u0010\u001aR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b-\u0010\u001cR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010.\u001a\u0004\b/\u0010\u001eR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010.\u001a\u0004\b0\u0010\u001e¨\u00063"}, d2 = {"Lcom/zyql/agentfront/bean/BatchToolResultResponse;", "Landroid/os/Parcelable;", "", "Lcom/zyql/agentfront/bean/ToolResultResponse;", "results", "", "success", "", "errorCode", "", "errorMessage", AgentBusWakeContract.EXTRA_TRACE_ID, AppAgent.CONSTRUCT, "(Ljava/util/List;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/List;", "component2", "()Z", "component3", "()Ljava/lang/Integer;", "component4", "()Ljava/lang/String;", "component5", "copy", "(Ljava/util/List;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/BatchToolResultResponse;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getResults", "Z", "getSuccess", "Ljava/lang/Integer;", "getErrorCode", "Ljava/lang/String;", "getErrorMessage", "getTraceId", "CREATOR", "k7/c", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BatchToolResultResponse implements Parcelable {
    public static final c CREATOR = new c();
    private final Integer errorCode;
    private final String errorMessage;
    private final List<ToolResultResponse> results;
    private final boolean success;
    private final String traceId;

    public BatchToolResultResponse(List<ToolResultResponse> results, boolean z10, Integer num, String str, String str2) {
        k.f(results, "results");
        this.results = results;
        this.success = z10;
        this.errorCode = num;
        this.errorMessage = str;
        this.traceId = str2;
    }

    public static /* synthetic */ BatchToolResultResponse copy$default(BatchToolResultResponse batchToolResultResponse, List list, boolean z10, Integer num, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = batchToolResultResponse.results;
        }
        if ((i & 2) != 0) {
            z10 = batchToolResultResponse.success;
        }
        if ((i & 4) != 0) {
            num = batchToolResultResponse.errorCode;
        }
        if ((i & 8) != 0) {
            str = batchToolResultResponse.errorMessage;
        }
        if ((i & 16) != 0) {
            str2 = batchToolResultResponse.traceId;
        }
        String str3 = str2;
        Integer num2 = num;
        return batchToolResultResponse.copy(list, z10, num2, str, str3);
    }

    public final List<ToolResultResponse> component1() {
        return this.results;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component4, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final BatchToolResultResponse copy(List<ToolResultResponse> results, boolean success, Integer errorCode, String errorMessage, String traceId) {
        k.f(results, "results");
        return new BatchToolResultResponse(results, success, errorCode, errorMessage, traceId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchToolResultResponse)) {
            return false;
        }
        BatchToolResultResponse batchToolResultResponse = (BatchToolResultResponse) other;
        return k.b(this.results, batchToolResultResponse.results) && this.success == batchToolResultResponse.success && k.b(this.errorCode, batchToolResultResponse.errorCode) && k.b(this.errorMessage, batchToolResultResponse.errorMessage) && k.b(this.traceId, batchToolResultResponse.traceId);
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final List<ToolResultResponse> getResults() {
        return this.results;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iD = a.d(this.results.hashCode() * 31, 31, this.success);
        Integer num = this.errorCode;
        int iHashCode = (iD + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.errorMessage;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.traceId;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        List<ToolResultResponse> list = this.results;
        boolean z10 = this.success;
        Integer num = this.errorCode;
        String str = this.errorMessage;
        String str2 = this.traceId;
        StringBuilder sb = new StringBuilder("BatchToolResultResponse(results=");
        sb.append(list);
        sb.append(", success=");
        sb.append(z10);
        sb.append(", errorCode=");
        sb.append(num);
        sb.append(", errorMessage=");
        sb.append(str);
        sb.append(", traceId=");
        return B7.a.q(sb, str2, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeTypedList(this.results);
        parcel.writeByte(this.success ? (byte) 1 : (byte) 0);
        parcel.writeValue(this.errorCode);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.traceId);
    }

    public /* synthetic */ BatchToolResultResponse(List list, boolean z10, Integer num, String str, String str2, int i, e eVar) {
        this(list, (i & 2) != 0 ? false : z10, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BatchToolResultResponse(Parcel parcel) {
        k.f(parcel, "parcel");
        List listCreateTypedArrayList = parcel.createTypedArrayList(ToolResultResponse.CREATOR);
        List list = listCreateTypedArrayList == null ? EmptyList.f4893a : listCreateTypedArrayList;
        boolean z10 = parcel.readByte() != 0;
        Object value = parcel.readValue(Integer.TYPE.getClassLoader());
        this(list, z10, value instanceof Integer ? (Integer) value : null, parcel.readString(), parcel.readString());
    }
}
