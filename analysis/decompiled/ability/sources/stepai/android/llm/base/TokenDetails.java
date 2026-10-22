package stepai.android.llm.base;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\rJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\r¨\u0006\u001c"}, d2 = {"Lstepai/android/llm/base/TokenDetails;", "Landroid/os/Parcelable;", "", "cachedTokens", AppAgent.CONSTRUCT, "(I)V", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "copy", "(I)Lstepai/android/llm/base/TokenDetails;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCachedTokens", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TokenDetails implements Parcelable {
    public static final Parcelable.Creator<TokenDetails> CREATOR = new Creator();

    @SerializedName("cached_tokens")
    private final int cachedTokens;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TokenDetails> {
        @Override // android.os.Parcelable.Creator
        public final TokenDetails createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new TokenDetails(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final TokenDetails[] newArray(int i) {
            return new TokenDetails[i];
        }
    }

    public TokenDetails(int i) {
        this.cachedTokens = i;
    }

    public static /* synthetic */ TokenDetails copy$default(TokenDetails tokenDetails, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = tokenDetails.cachedTokens;
        }
        return tokenDetails.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCachedTokens() {
        return this.cachedTokens;
    }

    public final TokenDetails copy(int cachedTokens) {
        return new TokenDetails(cachedTokens);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TokenDetails) && this.cachedTokens == ((TokenDetails) other).cachedTokens;
    }

    public final int getCachedTokens() {
        return this.cachedTokens;
    }

    public int hashCode() {
        return Integer.hashCode(this.cachedTokens);
    }

    public String toString() {
        return a.i(this.cachedTokens, "TokenDetails(cachedTokens=", ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeInt(this.cachedTokens);
    }
}
