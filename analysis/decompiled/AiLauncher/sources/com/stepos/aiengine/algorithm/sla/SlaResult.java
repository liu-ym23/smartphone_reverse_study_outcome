package com.stepos.aiengine.algorithm.sla;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001eJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b \u0010\u001cJP\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b#\u0010\u001cJ\u0010\u0010$\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b$\u0010\u0016J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b-\u0010\u001aR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010.\u001a\u0004\b/\u0010\u001cR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00100\u001a\u0004\b1\u0010\u001eR\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u00100\u001a\u0004\b2\u0010\u001eR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010.\u001a\u0004\b3\u0010\u001c¨\u00064"}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "Landroid/os/Parcelable;", "Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "decision", "Lcom/stepos/aiengine/algorithm/sla/SlaExecution;", "execution", "", "asrText", "", "totalElapsedMs", "modelInferMs", "rawJson", "<init>", "(Lcom/stepos/aiengine/algorithm/sla/SlaDecision;Lcom/stepos/aiengine/algorithm/sla/SlaExecution;Ljava/lang/String;JJLjava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "component2", "()Lcom/stepos/aiengine/algorithm/sla/SlaExecution;", "component3", "()Ljava/lang/String;", "component4", "()J", "component5", "component6", ChatTracker.CLICK_COPY, "(Lcom/stepos/aiengine/algorithm/sla/SlaDecision;Lcom/stepos/aiengine/algorithm/sla/SlaExecution;Ljava/lang/String;JJLjava/lang/String;)Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "getDecision", "Lcom/stepos/aiengine/algorithm/sla/SlaExecution;", "getExecution", "Ljava/lang/String;", "getAsrText", "J", "getTotalElapsedMs", "getModelInferMs", "getRawJson", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SlaResult implements Parcelable {
    public static final Parcelable.Creator<SlaResult> CREATOR = new Creator();
    private final String asrText;
    private final SlaDecision decision;
    private final SlaExecution execution;
    private final long modelInferMs;
    private final String rawJson;
    private final long totalElapsedMs;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SlaResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SlaResult createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new SlaResult(SlaDecision.CREATOR.createFromParcel(parcel), SlaExecution.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SlaResult[] newArray(int i10) {
            return new SlaResult[i10];
        }
    }

    public SlaResult(SlaDecision decision, SlaExecution execution, String str, long j10, long j11, String str2) {
        p.i(decision, "decision");
        p.i(execution, "execution");
        this.decision = decision;
        this.execution = execution;
        this.asrText = str;
        this.totalElapsedMs = j10;
        this.modelInferMs = j11;
        this.rawJson = str2;
    }

    public static /* synthetic */ SlaResult copy$default(SlaResult slaResult, SlaDecision slaDecision, SlaExecution slaExecution, String str, long j10, long j11, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            slaDecision = slaResult.decision;
        }
        if ((i10 & 2) != 0) {
            slaExecution = slaResult.execution;
        }
        if ((i10 & 4) != 0) {
            str = slaResult.asrText;
        }
        if ((i10 & 8) != 0) {
            j10 = slaResult.totalElapsedMs;
        }
        if ((i10 & 16) != 0) {
            j11 = slaResult.modelInferMs;
        }
        if ((i10 & 32) != 0) {
            str2 = slaResult.rawJson;
        }
        String str3 = str2;
        long j12 = j11;
        String str4 = str;
        return slaResult.copy(slaDecision, slaExecution, str4, j10, j12, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final SlaDecision getDecision() {
        return this.decision;
    }

    /* renamed from: component2, reason: from getter */
    public final SlaExecution getExecution() {
        return this.execution;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAsrText() {
        return this.asrText;
    }

    /* renamed from: component4, reason: from getter */
    public final long getTotalElapsedMs() {
        return this.totalElapsedMs;
    }

    /* renamed from: component5, reason: from getter */
    public final long getModelInferMs() {
        return this.modelInferMs;
    }

    /* renamed from: component6, reason: from getter */
    public final String getRawJson() {
        return this.rawJson;
    }

    public final SlaResult copy(SlaDecision decision, SlaExecution execution, String asrText, long totalElapsedMs, long modelInferMs, String rawJson) {
        p.i(decision, "decision");
        p.i(execution, "execution");
        return new SlaResult(decision, execution, asrText, totalElapsedMs, modelInferMs, rawJson);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SlaResult)) {
            return false;
        }
        SlaResult slaResult = (SlaResult) other;
        return p.d(this.decision, slaResult.decision) && p.d(this.execution, slaResult.execution) && p.d(this.asrText, slaResult.asrText) && this.totalElapsedMs == slaResult.totalElapsedMs && this.modelInferMs == slaResult.modelInferMs && p.d(this.rawJson, slaResult.rawJson);
    }

    public final String getAsrText() {
        return this.asrText;
    }

    public final SlaDecision getDecision() {
        return this.decision;
    }

    public final SlaExecution getExecution() {
        return this.execution;
    }

    public final long getModelInferMs() {
        return this.modelInferMs;
    }

    public final String getRawJson() {
        return this.rawJson;
    }

    public final long getTotalElapsedMs() {
        return this.totalElapsedMs;
    }

    public int hashCode() {
        int iHashCode = ((this.decision.hashCode() * 31) + this.execution.hashCode()) * 31;
        String str = this.asrText;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.totalElapsedMs)) * 31) + Long.hashCode(this.modelInferMs)) * 31;
        String str2 = this.rawJson;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SlaResult(decision=" + this.decision + ", execution=" + this.execution + ", asrText=" + this.asrText + ", totalElapsedMs=" + this.totalElapsedMs + ", modelInferMs=" + this.modelInferMs + ", rawJson=" + this.rawJson + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        this.decision.writeToParcel(dest, flags);
        this.execution.writeToParcel(dest, flags);
        dest.writeString(this.asrText);
        dest.writeLong(this.totalElapsedMs);
        dest.writeLong(this.modelInferMs);
        dest.writeString(this.rawJson);
    }

    public /* synthetic */ SlaResult(SlaDecision slaDecision, SlaExecution slaExecution, String str, long j10, long j11, String str2, int i10, i iVar) {
        this(slaDecision, slaExecution, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? 0L : j10, (i10 & 16) != 0 ? 0L : j11, (i10 & 32) != 0 ? null : str2);
    }
}
