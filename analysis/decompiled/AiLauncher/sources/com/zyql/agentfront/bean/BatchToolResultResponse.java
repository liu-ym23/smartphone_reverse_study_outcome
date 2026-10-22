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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00012BC\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001eJN\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\"\u0010\u001eJ\u0010\u0010#\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b#\u0010\u0016J\u001a\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010(\u001a\u0004\b)\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010*\u001a\u0004\b+\u0010\u001aR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b-\u0010\u001cR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010.\u001a\u0004\b/\u0010\u001eR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010.\u001a\u0004\b0\u0010\u001e¨\u00063"}, d2 = {"Lcom/zyql/agentfront/bean/BatchToolResultResponse;", "Landroid/os/Parcelable;", "", "Lcom/zyql/agentfront/bean/ToolResultResponse;", "results", "", "success", "", "errorCode", "", "errorMessage", DidiCardProvider.KEY_TRACE_ID, "<init>", "(Ljava/util/List;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/List;", "component2", "()Z", "component3", "()Ljava/lang/Integer;", "component4", "()Ljava/lang/String;", "component5", ChatTracker.CLICK_COPY, "(Ljava/util/List;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/BatchToolResultResponse;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getResults", "Z", "getSuccess", "Ljava/lang/Integer;", "getErrorCode", "Ljava/lang/String;", "getErrorMessage", "getTraceId", "CREATOR", Const.INTENT_KEY_APIKEY, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BatchToolResultResponse implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer errorCode;
    private final String errorMessage;
    private final List<ToolResultResponse> results;
    private final boolean success;
    private final String traceId;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/zyql/agentfront/bean/BatchToolResultResponse$a;", "Landroid/os/Parcelable$Creator;", "Lcom/zyql/agentfront/bean/BatchToolResultResponse;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/zyql/agentfront/bean/BatchToolResultResponse;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/zyql/agentfront/bean/BatchToolResultResponse;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.zyql.agentfront.bean.BatchToolResultResponse$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<BatchToolResultResponse> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BatchToolResultResponse createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new BatchToolResultResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BatchToolResultResponse[] newArray(int size) {
            return new BatchToolResultResponse[size];
        }

        public Companion() {
        }
    }

    public BatchToolResultResponse(List<ToolResultResponse> results, boolean z10, Integer num, String str, String str2) {
        p.i(results, "results");
        this.results = results;
        this.success = z10;
        this.errorCode = num;
        this.errorMessage = str;
        this.traceId = str2;
    }

    public static /* synthetic */ BatchToolResultResponse copy$default(BatchToolResultResponse batchToolResultResponse, List list, boolean z10, Integer num, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = batchToolResultResponse.results;
        }
        if ((i10 & 2) != 0) {
            z10 = batchToolResultResponse.success;
        }
        if ((i10 & 4) != 0) {
            num = batchToolResultResponse.errorCode;
        }
        if ((i10 & 8) != 0) {
            str = batchToolResultResponse.errorMessage;
        }
        if ((i10 & 16) != 0) {
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
        p.i(results, "results");
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
        return p.d(this.results, batchToolResultResponse.results) && this.success == batchToolResultResponse.success && p.d(this.errorCode, batchToolResultResponse.errorCode) && p.d(this.errorMessage, batchToolResultResponse.errorMessage) && p.d(this.traceId, batchToolResultResponse.traceId);
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
        int iHashCode = ((this.results.hashCode() * 31) + Boolean.hashCode(this.success)) * 31;
        Integer num = this.errorCode;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.errorMessage;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.traceId;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "BatchToolResultResponse(results=" + this.results + ", success=" + this.success + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", traceId=" + this.traceId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        parcel.writeTypedList(this.results);
        parcel.writeByte(this.success ? (byte) 1 : (byte) 0);
        parcel.writeValue(this.errorCode);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.traceId);
    }

    public /* synthetic */ BatchToolResultResponse(List list, boolean z10, Integer num, String str, String str2, int i10, i iVar) {
        this(list, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : str, (i10 & 16) != 0 ? null : str2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BatchToolResultResponse(Parcel parcel) {
        p.i(parcel, "parcel");
        List listCreateTypedArrayList = parcel.createTypedArrayList(ToolResultResponse.INSTANCE);
        List listM = listCreateTypedArrayList == null ? C1173v.m() : listCreateTypedArrayList;
        boolean z10 = parcel.readByte() != 0;
        Object value = parcel.readValue(Integer.TYPE.getClassLoader());
        this(listM, z10, value instanceof Integer ? (Integer) value : null, parcel.readString(), parcel.readString());
    }
}
