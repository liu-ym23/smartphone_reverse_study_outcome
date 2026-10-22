package stepai.android.llm.base;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0013J\u0010\u0010\u0017\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJB\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0013J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b(\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b)\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b+\u0010\u0018R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010,\u001a\u0004\b-\u0010\u001a¨\u0006."}, d2 = {"Lstepai/android/llm/base/Usage;", "Landroid/os/Parcelable;", "", "promptTokens", "completionTokens", "totalTokens", "Lstepai/android/llm/base/TokenDetails;", "promptTokensDetails", "Lstepai/android/llm/base/CompletionTokenDetails;", "completionTokensDetails", AppAgent.CONSTRUCT, "(IIILstepai/android/llm/base/TokenDetails;Lstepai/android/llm/base/CompletionTokenDetails;)V", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "component3", "component4", "()Lstepai/android/llm/base/TokenDetails;", "component5", "()Lstepai/android/llm/base/CompletionTokenDetails;", "copy", "(IIILstepai/android/llm/base/TokenDetails;Lstepai/android/llm/base/CompletionTokenDetails;)Lstepai/android/llm/base/Usage;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getPromptTokens", "getCompletionTokens", "getTotalTokens", "Lstepai/android/llm/base/TokenDetails;", "getPromptTokensDetails", "Lstepai/android/llm/base/CompletionTokenDetails;", "getCompletionTokensDetails", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Usage implements Parcelable {
    public static final Parcelable.Creator<Usage> CREATOR = new Creator();

    @SerializedName("completion_tokens")
    private final int completionTokens;

    @SerializedName("completion_tokens_details")
    private final CompletionTokenDetails completionTokensDetails;

    @SerializedName("prompt_tokens")
    private final int promptTokens;

    @SerializedName("prompt_tokens_details")
    private final TokenDetails promptTokensDetails;

    @SerializedName("total_tokens")
    private final int totalTokens;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Usage> {
        @Override // android.os.Parcelable.Creator
        public final Usage createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new Usage(parcel.readInt(), parcel.readInt(), parcel.readInt(), TokenDetails.CREATOR.createFromParcel(parcel), CompletionTokenDetails.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final Usage[] newArray(int i) {
            return new Usage[i];
        }
    }

    public Usage(int i, int i6, int i10, TokenDetails promptTokensDetails, CompletionTokenDetails completionTokensDetails) {
        k.f(promptTokensDetails, "promptTokensDetails");
        k.f(completionTokensDetails, "completionTokensDetails");
        this.promptTokens = i;
        this.completionTokens = i6;
        this.totalTokens = i10;
        this.promptTokensDetails = promptTokensDetails;
        this.completionTokensDetails = completionTokensDetails;
    }

    public static /* synthetic */ Usage copy$default(Usage usage, int i, int i6, int i10, TokenDetails tokenDetails, CompletionTokenDetails completionTokenDetails, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i = usage.promptTokens;
        }
        if ((i11 & 2) != 0) {
            i6 = usage.completionTokens;
        }
        if ((i11 & 4) != 0) {
            i10 = usage.totalTokens;
        }
        if ((i11 & 8) != 0) {
            tokenDetails = usage.promptTokensDetails;
        }
        if ((i11 & 16) != 0) {
            completionTokenDetails = usage.completionTokensDetails;
        }
        CompletionTokenDetails completionTokenDetails2 = completionTokenDetails;
        int i12 = i10;
        return usage.copy(i, i6, i12, tokenDetails, completionTokenDetails2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPromptTokens() {
        return this.promptTokens;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCompletionTokens() {
        return this.completionTokens;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotalTokens() {
        return this.totalTokens;
    }

    /* renamed from: component4, reason: from getter */
    public final TokenDetails getPromptTokensDetails() {
        return this.promptTokensDetails;
    }

    /* renamed from: component5, reason: from getter */
    public final CompletionTokenDetails getCompletionTokensDetails() {
        return this.completionTokensDetails;
    }

    public final Usage copy(int promptTokens, int completionTokens, int totalTokens, TokenDetails promptTokensDetails, CompletionTokenDetails completionTokensDetails) {
        k.f(promptTokensDetails, "promptTokensDetails");
        k.f(completionTokensDetails, "completionTokensDetails");
        return new Usage(promptTokens, completionTokens, totalTokens, promptTokensDetails, completionTokensDetails);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Usage)) {
            return false;
        }
        Usage usage = (Usage) other;
        return this.promptTokens == usage.promptTokens && this.completionTokens == usage.completionTokens && this.totalTokens == usage.totalTokens && k.b(this.promptTokensDetails, usage.promptTokensDetails) && k.b(this.completionTokensDetails, usage.completionTokensDetails);
    }

    public final int getCompletionTokens() {
        return this.completionTokens;
    }

    public final CompletionTokenDetails getCompletionTokensDetails() {
        return this.completionTokensDetails;
    }

    public final int getPromptTokens() {
        return this.promptTokens;
    }

    public final TokenDetails getPromptTokensDetails() {
        return this.promptTokensDetails;
    }

    public final int getTotalTokens() {
        return this.totalTokens;
    }

    public int hashCode() {
        return this.completionTokensDetails.hashCode() + ((this.promptTokensDetails.hashCode() + a.a(this.totalTokens, a.a(this.completionTokens, Integer.hashCode(this.promptTokens) * 31, 31), 31)) * 31);
    }

    public String toString() {
        int i = this.promptTokens;
        int i6 = this.completionTokens;
        int i10 = this.totalTokens;
        TokenDetails tokenDetails = this.promptTokensDetails;
        CompletionTokenDetails completionTokenDetails = this.completionTokensDetails;
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(i, "Usage(promptTokens=", i6, ", completionTokens=", ", totalTokens=");
        sbS.append(i10);
        sbS.append(", promptTokensDetails=");
        sbS.append(tokenDetails);
        sbS.append(", completionTokensDetails=");
        sbS.append(completionTokenDetails);
        sbS.append(")");
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeInt(this.promptTokens);
        dest.writeInt(this.completionTokens);
        dest.writeInt(this.totalTokens);
        this.promptTokensDetails.writeToParcel(dest, flags);
        this.completionTokensDetails.writeToParcel(dest, flags);
    }
}
