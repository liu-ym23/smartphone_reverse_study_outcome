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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001%B!\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0016J\u0010\u0010\u001a\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0012J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b!\u0010\u0014R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b#\u0010\u0016¨\u0006&"}, d2 = {"Lcom/zyql/agentfront/bean/BatchToolResultRequest;", "Landroid/os/Parcelable;", "", "Lcom/zyql/agentfront/bean/ToolResultRequest;", "results", "", DidiCardProvider.KEY_TRACE_ID, "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/List;", "component2", "()Ljava/lang/String;", ChatTracker.CLICK_COPY, "(Ljava/util/List;Ljava/lang/String;)Lcom/zyql/agentfront/bean/BatchToolResultRequest;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getResults", "Ljava/lang/String;", "getTraceId", "CREATOR", Const.INTENT_KEY_APIKEY, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BatchToolResultRequest implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<ToolResultRequest> results;
    private final String traceId;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/zyql/agentfront/bean/BatchToolResultRequest$a;", "Landroid/os/Parcelable$Creator;", "Lcom/zyql/agentfront/bean/BatchToolResultRequest;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/zyql/agentfront/bean/BatchToolResultRequest;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/zyql/agentfront/bean/BatchToolResultRequest;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.zyql.agentfront.bean.BatchToolResultRequest$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<BatchToolResultRequest> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BatchToolResultRequest createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new BatchToolResultRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BatchToolResultRequest[] newArray(int size) {
            return new BatchToolResultRequest[size];
        }

        public Companion() {
        }
    }

    public BatchToolResultRequest(List<ToolResultRequest> results, String str) {
        p.i(results, "results");
        this.results = results;
        this.traceId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BatchToolResultRequest copy$default(BatchToolResultRequest batchToolResultRequest, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = batchToolResultRequest.results;
        }
        if ((i10 & 2) != 0) {
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
        p.i(results, "results");
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
        return p.d(this.results, batchToolResultRequest.results) && p.d(this.traceId, batchToolResultRequest.traceId);
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
        p.i(parcel, "parcel");
        parcel.writeTypedList(this.results);
        parcel.writeString(this.traceId);
    }

    public /* synthetic */ BatchToolResultRequest(List list, String str, int i10, i iVar) {
        this(list, (i10 & 2) != 0 ? null : str);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BatchToolResultRequest(Parcel parcel) {
        p.i(parcel, "parcel");
        List listCreateTypedArrayList = parcel.createTypedArrayList(ToolResultRequest.INSTANCE);
        this(listCreateTypedArrayList == null ? C1173v.m() : listCreateTypedArrayList, parcel.readString());
    }
}
