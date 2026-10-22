package stepai.android.llm.base;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J$\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0011J\u0010\u0010\u0016\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000fJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\u0011¨\u0006\u001f"}, d2 = {"Lstepai/android/llm/base/LLMRequestAudioInputContent;", "Landroid/os/Parcelable;", "", SettingsConfig.KEY_DATA, "format", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lstepai/android/llm/base/LLMRequestAudioInputContent;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getData", "getFormat", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LLMRequestAudioInputContent implements Parcelable {
    public static final Parcelable.Creator<LLMRequestAudioInputContent> CREATOR = new Creator();
    private final String data;
    private final String format;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LLMRequestAudioInputContent> {
        @Override // android.os.Parcelable.Creator
        public final LLMRequestAudioInputContent createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new LLMRequestAudioInputContent(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final LLMRequestAudioInputContent[] newArray(int i) {
            return new LLMRequestAudioInputContent[i];
        }
    }

    public LLMRequestAudioInputContent(String data, String format) {
        k.f(data, "data");
        k.f(format, "format");
        this.data = data;
        this.format = format;
    }

    public static /* synthetic */ LLMRequestAudioInputContent copy$default(LLMRequestAudioInputContent lLMRequestAudioInputContent, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lLMRequestAudioInputContent.data;
        }
        if ((i & 2) != 0) {
            str2 = lLMRequestAudioInputContent.format;
        }
        return lLMRequestAudioInputContent.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFormat() {
        return this.format;
    }

    public final LLMRequestAudioInputContent copy(String data, String format) {
        k.f(data, "data");
        k.f(format, "format");
        return new LLMRequestAudioInputContent(data, format);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LLMRequestAudioInputContent)) {
            return false;
        }
        LLMRequestAudioInputContent lLMRequestAudioInputContent = (LLMRequestAudioInputContent) other;
        return k.b(this.data, lLMRequestAudioInputContent.data) && k.b(this.format, lLMRequestAudioInputContent.format);
    }

    public final String getData() {
        return this.data;
    }

    public final String getFormat() {
        return this.format;
    }

    public int hashCode() {
        return this.format.hashCode() + (this.data.hashCode() * 31);
    }

    public String toString() {
        return a.m("LLMRequestAudioInputContent(data=", this.data, ", format=", this.format, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeString(this.data);
        dest.writeString(this.format);
    }
}
