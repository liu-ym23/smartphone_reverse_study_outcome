package stepai.android.llm.base;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u0010¨\u0006\u001c"}, d2 = {"Lstepai/android/llm/base/LLMRequestAudioUrlContent;", "Landroid/os/Parcelable;", "", BffConstant.Type.Url, AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "copy", "(Ljava/lang/String;)Lstepai/android/llm/base/LLMRequestAudioUrlContent;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUrl", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LLMRequestAudioUrlContent implements Parcelable {
    public static final Parcelable.Creator<LLMRequestAudioUrlContent> CREATOR = new Creator();
    private final String url;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LLMRequestAudioUrlContent> {
        @Override // android.os.Parcelable.Creator
        public final LLMRequestAudioUrlContent createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new LLMRequestAudioUrlContent(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final LLMRequestAudioUrlContent[] newArray(int i) {
            return new LLMRequestAudioUrlContent[i];
        }
    }

    public LLMRequestAudioUrlContent(String url) {
        k.f(url, "url");
        this.url = url;
    }

    public static /* synthetic */ LLMRequestAudioUrlContent copy$default(LLMRequestAudioUrlContent lLMRequestAudioUrlContent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lLMRequestAudioUrlContent.url;
        }
        return lLMRequestAudioUrlContent.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final LLMRequestAudioUrlContent copy(String url) {
        k.f(url, "url");
        return new LLMRequestAudioUrlContent(url);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LLMRequestAudioUrlContent) && k.b(this.url, ((LLMRequestAudioUrlContent) other).url);
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return a.m("LLMRequestAudioUrlContent(url=", this.url, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeString(this.url);
    }
}
