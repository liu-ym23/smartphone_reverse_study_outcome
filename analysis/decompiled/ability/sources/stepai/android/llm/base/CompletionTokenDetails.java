package stepai.android.llm.base;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000fJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000fJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b \u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b!\u0010\u000f¨\u0006\""}, d2 = {"Lstepai/android/llm/base/CompletionTokenDetails;", "Landroid/os/Parcelable;", "", "reasoningTokens", "acceptedPredictionTokens", "rejectedPredictionTokens", AppAgent.CONSTRUCT, "(III)V", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "component3", "copy", "(III)Lstepai/android/llm/base/CompletionTokenDetails;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getReasoningTokens", "getAcceptedPredictionTokens", "getRejectedPredictionTokens", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CompletionTokenDetails implements Parcelable {
    public static final Parcelable.Creator<CompletionTokenDetails> CREATOR = new Creator();

    @SerializedName("accepted_prediction_tokens")
    private final int acceptedPredictionTokens;

    @SerializedName("reasoning_tokens")
    private final int reasoningTokens;

    @SerializedName("rejected_prediction_tokens")
    private final int rejectedPredictionTokens;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CompletionTokenDetails> {
        @Override // android.os.Parcelable.Creator
        public final CompletionTokenDetails createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new CompletionTokenDetails(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final CompletionTokenDetails[] newArray(int i) {
            return new CompletionTokenDetails[i];
        }
    }

    public CompletionTokenDetails(int i, int i6, int i10) {
        this.reasoningTokens = i;
        this.acceptedPredictionTokens = i6;
        this.rejectedPredictionTokens = i10;
    }

    public static /* synthetic */ CompletionTokenDetails copy$default(CompletionTokenDetails completionTokenDetails, int i, int i6, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i = completionTokenDetails.reasoningTokens;
        }
        if ((i11 & 2) != 0) {
            i6 = completionTokenDetails.acceptedPredictionTokens;
        }
        if ((i11 & 4) != 0) {
            i10 = completionTokenDetails.rejectedPredictionTokens;
        }
        return completionTokenDetails.copy(i, i6, i10);
    }

    /* renamed from: component1, reason: from getter */
    public final int getReasoningTokens() {
        return this.reasoningTokens;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAcceptedPredictionTokens() {
        return this.acceptedPredictionTokens;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRejectedPredictionTokens() {
        return this.rejectedPredictionTokens;
    }

    public final CompletionTokenDetails copy(int reasoningTokens, int acceptedPredictionTokens, int rejectedPredictionTokens) {
        return new CompletionTokenDetails(reasoningTokens, acceptedPredictionTokens, rejectedPredictionTokens);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompletionTokenDetails)) {
            return false;
        }
        CompletionTokenDetails completionTokenDetails = (CompletionTokenDetails) other;
        return this.reasoningTokens == completionTokenDetails.reasoningTokens && this.acceptedPredictionTokens == completionTokenDetails.acceptedPredictionTokens && this.rejectedPredictionTokens == completionTokenDetails.rejectedPredictionTokens;
    }

    public final int getAcceptedPredictionTokens() {
        return this.acceptedPredictionTokens;
    }

    public final int getReasoningTokens() {
        return this.reasoningTokens;
    }

    public final int getRejectedPredictionTokens() {
        return this.rejectedPredictionTokens;
    }

    public int hashCode() {
        return Integer.hashCode(this.rejectedPredictionTokens) + a.a(this.acceptedPredictionTokens, Integer.hashCode(this.reasoningTokens) * 31, 31);
    }

    public String toString() {
        int i = this.reasoningTokens;
        int i6 = this.acceptedPredictionTokens;
        return androidx.appfunctions.metadata.a.o(androidx.appfunctions.metadata.a.s(i, "CompletionTokenDetails(reasoningTokens=", i6, ", acceptedPredictionTokens=", ", rejectedPredictionTokens="), ")", this.rejectedPredictionTokens);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeInt(this.reasoningTokens);
        dest.writeInt(this.acceptedPredictionTokens);
        dest.writeInt(this.rejectedPredictionTokens);
    }
}
