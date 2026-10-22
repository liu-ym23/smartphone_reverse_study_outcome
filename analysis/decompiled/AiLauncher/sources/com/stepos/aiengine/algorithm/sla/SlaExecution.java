package com.stepos.aiengine.algorithm.sla;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001:\u00017BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0017J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001bJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b \u0010\u001bJ\u0010\u0010!\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b!\u0010\"JZ\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b%\u0010\u001bJ\u0010\u0010&\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b&\u0010\u0017J\u001a\u0010)\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010/\u001a\u0004\b0\u0010\u001dR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00101\u001a\u0004\b2\u0010\u0017R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010-\u001a\u0004\b3\u0010\u001bR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010-\u001a\u0004\b4\u0010\u001bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u00105\u001a\u0004\b6\u0010\"¨\u00068"}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/SlaExecution;", "Landroid/os/Parcelable;", "", "dispatched", "", "executor", "Lcom/stepos/aiengine/algorithm/sla/SlaExecution$Status;", "status", "", "errorCode", C3081a.ERROR_MSG, "resultJson", "", "elapsedMs", "<init>", "(ZLjava/lang/String;Lcom/stepos/aiengine/algorithm/sla/SlaExecution$Status;ILjava/lang/String;Ljava/lang/String;J)V", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Z", "component2", "()Ljava/lang/String;", "component3", "()Lcom/stepos/aiengine/algorithm/sla/SlaExecution$Status;", "component4", "component5", "component6", "component7", "()J", ChatTracker.CLICK_COPY, "(ZLjava/lang/String;Lcom/stepos/aiengine/algorithm/sla/SlaExecution$Status;ILjava/lang/String;Ljava/lang/String;J)Lcom/stepos/aiengine/algorithm/sla/SlaExecution;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getDispatched", "Ljava/lang/String;", "getExecutor", "Lcom/stepos/aiengine/algorithm/sla/SlaExecution$Status;", "getStatus", "I", "getErrorCode", "getErrorMsg", "getResultJson", "J", "getElapsedMs", "Status", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SlaExecution implements Parcelable {
    public static final Parcelable.Creator<SlaExecution> CREATOR = new Creator();
    private final boolean dispatched;
    private final long elapsedMs;
    private final int errorCode;
    private final String errorMsg;
    private final String executor;
    private final String resultJson;
    private final Status status;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SlaExecution> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SlaExecution createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new SlaExecution(parcel.readInt() != 0, parcel.readString(), Status.valueOf(parcel.readString()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SlaExecution[] newArray(int i10) {
            return new SlaExecution[i10];
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/SlaExecution$Status;", "", "<init>", "(Ljava/lang/String;I)V", "DISPATCHED", AMapLocationStaticsEntity.SUCCESS_STATUS, "FAILED", ModelFlowMeta.PLAN_UNAVAILABLE, "NOT_DISPATCHED", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Status {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;
        public static final Status DISPATCHED = new Status("DISPATCHED", 0);
        public static final Status SUCCESS = new Status(AMapLocationStaticsEntity.SUCCESS_STATUS, 1);
        public static final Status FAILED = new Status("FAILED", 2);
        public static final Status UNAVAILABLE = new Status(ModelFlowMeta.PLAN_UNAVAILABLE, 3);
        public static final Status NOT_DISPATCHED = new Status("NOT_DISPATCHED", 4);

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{DISPATCHED, SUCCESS, FAILED, UNAVAILABLE, NOT_DISPATCHED};
        }

        static {
            Status[] statusArr$values = $values();
            $VALUES = statusArr$values;
            $ENTRIES = a.a(statusArr$values);
        }

        private Status(String str, int i10) {
        }

        public static InterfaceC4149a<Status> getEntries() {
            return $ENTRIES;
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    public SlaExecution(boolean z10, String executor, Status status, int i10, String str, String str2, long j10) {
        p.i(executor, "executor");
        p.i(status, "status");
        this.dispatched = z10;
        this.executor = executor;
        this.status = status;
        this.errorCode = i10;
        this.errorMsg = str;
        this.resultJson = str2;
        this.elapsedMs = j10;
    }

    public static /* synthetic */ SlaExecution copy$default(SlaExecution slaExecution, boolean z10, String str, Status status, int i10, String str2, String str3, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = slaExecution.dispatched;
        }
        if ((i11 & 2) != 0) {
            str = slaExecution.executor;
        }
        if ((i11 & 4) != 0) {
            status = slaExecution.status;
        }
        if ((i11 & 8) != 0) {
            i10 = slaExecution.errorCode;
        }
        if ((i11 & 16) != 0) {
            str2 = slaExecution.errorMsg;
        }
        if ((i11 & 32) != 0) {
            str3 = slaExecution.resultJson;
        }
        if ((i11 & 64) != 0) {
            j10 = slaExecution.elapsedMs;
        }
        long j11 = j10;
        String str4 = str2;
        String str5 = str3;
        return slaExecution.copy(z10, str, status, i10, str4, str5, j11);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getDispatched() {
        return this.dispatched;
    }

    /* renamed from: component2, reason: from getter */
    public final String getExecutor() {
        return this.executor;
    }

    /* renamed from: component3, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    /* renamed from: component4, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component5, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    /* renamed from: component6, reason: from getter */
    public final String getResultJson() {
        return this.resultJson;
    }

    /* renamed from: component7, reason: from getter */
    public final long getElapsedMs() {
        return this.elapsedMs;
    }

    public final SlaExecution copy(boolean dispatched, String executor, Status status, int errorCode, String errorMsg, String resultJson, long elapsedMs) {
        p.i(executor, "executor");
        p.i(status, "status");
        return new SlaExecution(dispatched, executor, status, errorCode, errorMsg, resultJson, elapsedMs);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SlaExecution)) {
            return false;
        }
        SlaExecution slaExecution = (SlaExecution) other;
        return this.dispatched == slaExecution.dispatched && p.d(this.executor, slaExecution.executor) && this.status == slaExecution.status && this.errorCode == slaExecution.errorCode && p.d(this.errorMsg, slaExecution.errorMsg) && p.d(this.resultJson, slaExecution.resultJson) && this.elapsedMs == slaExecution.elapsedMs;
    }

    public final boolean getDispatched() {
        return this.dispatched;
    }

    public final long getElapsedMs() {
        return this.elapsedMs;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getExecutor() {
        return this.executor;
    }

    public final String getResultJson() {
        return this.resultJson;
    }

    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        int iHashCode = ((((((Boolean.hashCode(this.dispatched) * 31) + this.executor.hashCode()) * 31) + this.status.hashCode()) * 31) + Integer.hashCode(this.errorCode)) * 31;
        String str = this.errorMsg;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.resultJson;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Long.hashCode(this.elapsedMs);
    }

    public String toString() {
        return "SlaExecution(dispatched=" + this.dispatched + ", executor=" + this.executor + ", status=" + this.status + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", resultJson=" + this.resultJson + ", elapsedMs=" + this.elapsedMs + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeInt(this.dispatched ? 1 : 0);
        dest.writeString(this.executor);
        dest.writeString(this.status.name());
        dest.writeInt(this.errorCode);
        dest.writeString(this.errorMsg);
        dest.writeString(this.resultJson);
        dest.writeLong(this.elapsedMs);
    }

    public /* synthetic */ SlaExecution(boolean z10, String str, Status status, int i10, String str2, String str3, long j10, int i11, i iVar) {
        this(z10, str, status, (i11 & 8) != 0 ? 0 : i10, (i11 & 16) != 0 ? null : str2, (i11 & 32) != 0 ? null : str3, (i11 & 64) != 0 ? 0L : j10);
    }
}
