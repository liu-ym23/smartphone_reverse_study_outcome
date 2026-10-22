package stepai.android.llm.base;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lstepai/android/llm/base/LLMRequestContent;", "Landroid/os/Parcelable;", AppAgent.CONSTRUCT, "()V", "type", "", "getType", "()Ljava/lang/String;", "Text", "Image", "AudioUrl", "AudioInput", "Lstepai/android/llm/base/LLMRequestContent$AudioInput;", "Lstepai/android/llm/base/LLMRequestContent$AudioUrl;", "Lstepai/android/llm/base/LLMRequestContent$Image;", "Lstepai/android/llm/base/LLMRequestContent$Text;", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class LLMRequestContent implements Parcelable {

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J$\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0011J\u0010\u0010\u0016\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000fJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\u0011¨\u0006\u001f"}, d2 = {"Lstepai/android/llm/base/LLMRequestContent$Text;", "Lstepai/android/llm/base/LLMRequestContent;", "", "text", "type", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lstepai/android/llm/base/LLMRequestContent$Text;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "getType", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Text extends LLMRequestContent {
        public static final Parcelable.Creator<Text> CREATOR = new Creator();
        private final String text;
        private final String type;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Text> {
            @Override // android.os.Parcelable.Creator
            public final Text createFromParcel(Parcel parcel) {
                k.f(parcel, "parcel");
                return new Text(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final Text[] newArray(int i) {
                return new Text[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(String text, String type) {
            super(null);
            k.f(text, "text");
            k.f(type, "type");
            this.text = text;
            this.type = type;
        }

        public static /* synthetic */ Text copy$default(Text text, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = text.text;
            }
            if ((i & 2) != 0) {
                str2 = text.type;
            }
            return text.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        public final Text copy(String text, String type) {
            k.f(text, "text");
            k.f(type, "type");
            return new Text(text, type);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Text)) {
                return false;
            }
            Text text = (Text) other;
            return k.b(this.text, text.text) && k.b(this.type, text.type);
        }

        public final String getText() {
            return this.text;
        }

        @Override // stepai.android.llm.base.LLMRequestContent
        public String getType() {
            return this.type;
        }

        public int hashCode() {
            return this.type.hashCode() + (this.text.hashCode() * 31);
        }

        public String toString() {
            return a.m("Text(text=", this.text, ", type=", this.type, ")");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            k.f(dest, "dest");
            dest.writeString(this.text);
            dest.writeString(this.type);
        }

        public /* synthetic */ Text(String str, String str2, int i, e eVar) {
            this(str, (i & 2) != 0 ? "text" : str2);
        }
    }

    public /* synthetic */ LLMRequestContent(e eVar) {
        this();
    }

    public abstract String getType();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0014J\u0010\u0010\u0018\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0010J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0014¨\u0006\""}, d2 = {"Lstepai/android/llm/base/LLMRequestContent$AudioInput;", "Lstepai/android/llm/base/LLMRequestContent;", "Lstepai/android/llm/base/LLMRequestAudioInputContent;", "audioUrl", "", "type", AppAgent.CONSTRUCT, "(Lstepai/android/llm/base/LLMRequestAudioInputContent;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Lstepai/android/llm/base/LLMRequestAudioInputContent;", "component2", "()Ljava/lang/String;", "copy", "(Lstepai/android/llm/base/LLMRequestAudioInputContent;Ljava/lang/String;)Lstepai/android/llm/base/LLMRequestContent$AudioInput;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lstepai/android/llm/base/LLMRequestAudioInputContent;", "getAudioUrl", "Ljava/lang/String;", "getType", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class AudioInput extends LLMRequestContent {
        public static final Parcelable.Creator<AudioInput> CREATOR = new Creator();

        @SerializedName("input_audio")
        private final LLMRequestAudioInputContent audioUrl;
        private final String type;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<AudioInput> {
            @Override // android.os.Parcelable.Creator
            public final AudioInput createFromParcel(Parcel parcel) {
                k.f(parcel, "parcel");
                return new AudioInput(LLMRequestAudioInputContent.CREATOR.createFromParcel(parcel), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final AudioInput[] newArray(int i) {
                return new AudioInput[i];
            }
        }

        public /* synthetic */ AudioInput(LLMRequestAudioInputContent lLMRequestAudioInputContent, String str, int i, e eVar) {
            this(lLMRequestAudioInputContent, (i & 2) != 0 ? "input_audio" : str);
        }

        public static /* synthetic */ AudioInput copy$default(AudioInput audioInput, LLMRequestAudioInputContent lLMRequestAudioInputContent, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                lLMRequestAudioInputContent = audioInput.audioUrl;
            }
            if ((i & 2) != 0) {
                str = audioInput.type;
            }
            return audioInput.copy(lLMRequestAudioInputContent, str);
        }

        /* renamed from: component1, reason: from getter */
        public final LLMRequestAudioInputContent getAudioUrl() {
            return this.audioUrl;
        }

        /* renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        public final AudioInput copy(LLMRequestAudioInputContent audioUrl, String type) {
            k.f(audioUrl, "audioUrl");
            k.f(type, "type");
            return new AudioInput(audioUrl, type);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AudioInput)) {
                return false;
            }
            AudioInput audioInput = (AudioInput) other;
            return k.b(this.audioUrl, audioInput.audioUrl) && k.b(this.type, audioInput.type);
        }

        public final LLMRequestAudioInputContent getAudioUrl() {
            return this.audioUrl;
        }

        @Override // stepai.android.llm.base.LLMRequestContent
        public String getType() {
            return this.type;
        }

        public int hashCode() {
            return this.type.hashCode() + (this.audioUrl.hashCode() * 31);
        }

        public String toString() {
            return "AudioInput(audioUrl=" + this.audioUrl + ", type=" + this.type + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            k.f(dest, "dest");
            this.audioUrl.writeToParcel(dest, flags);
            dest.writeString(this.type);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioInput(LLMRequestAudioInputContent audioUrl, String type) {
            super(null);
            k.f(audioUrl, "audioUrl");
            k.f(type, "type");
            this.audioUrl = audioUrl;
            this.type = type;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0014J\u0010\u0010\u0018\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0010J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0014¨\u0006\""}, d2 = {"Lstepai/android/llm/base/LLMRequestContent$AudioUrl;", "Lstepai/android/llm/base/LLMRequestContent;", "Lstepai/android/llm/base/LLMRequestAudioUrlContent;", "audioUrl", "", "type", AppAgent.CONSTRUCT, "(Lstepai/android/llm/base/LLMRequestAudioUrlContent;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Lstepai/android/llm/base/LLMRequestAudioUrlContent;", "component2", "()Ljava/lang/String;", "copy", "(Lstepai/android/llm/base/LLMRequestAudioUrlContent;Ljava/lang/String;)Lstepai/android/llm/base/LLMRequestContent$AudioUrl;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lstepai/android/llm/base/LLMRequestAudioUrlContent;", "getAudioUrl", "Ljava/lang/String;", "getType", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class AudioUrl extends LLMRequestContent {
        public static final Parcelable.Creator<AudioUrl> CREATOR = new Creator();

        @SerializedName("audio_url")
        private final LLMRequestAudioUrlContent audioUrl;
        private final String type;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<AudioUrl> {
            @Override // android.os.Parcelable.Creator
            public final AudioUrl createFromParcel(Parcel parcel) {
                k.f(parcel, "parcel");
                return new AudioUrl(LLMRequestAudioUrlContent.CREATOR.createFromParcel(parcel), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final AudioUrl[] newArray(int i) {
                return new AudioUrl[i];
            }
        }

        public /* synthetic */ AudioUrl(LLMRequestAudioUrlContent lLMRequestAudioUrlContent, String str, int i, e eVar) {
            this(lLMRequestAudioUrlContent, (i & 2) != 0 ? "audio_url" : str);
        }

        public static /* synthetic */ AudioUrl copy$default(AudioUrl audioUrl, LLMRequestAudioUrlContent lLMRequestAudioUrlContent, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                lLMRequestAudioUrlContent = audioUrl.audioUrl;
            }
            if ((i & 2) != 0) {
                str = audioUrl.type;
            }
            return audioUrl.copy(lLMRequestAudioUrlContent, str);
        }

        /* renamed from: component1, reason: from getter */
        public final LLMRequestAudioUrlContent getAudioUrl() {
            return this.audioUrl;
        }

        /* renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        public final AudioUrl copy(LLMRequestAudioUrlContent audioUrl, String type) {
            k.f(audioUrl, "audioUrl");
            k.f(type, "type");
            return new AudioUrl(audioUrl, type);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AudioUrl)) {
                return false;
            }
            AudioUrl audioUrl = (AudioUrl) other;
            return k.b(this.audioUrl, audioUrl.audioUrl) && k.b(this.type, audioUrl.type);
        }

        public final LLMRequestAudioUrlContent getAudioUrl() {
            return this.audioUrl;
        }

        @Override // stepai.android.llm.base.LLMRequestContent
        public String getType() {
            return this.type;
        }

        public int hashCode() {
            return this.type.hashCode() + (this.audioUrl.hashCode() * 31);
        }

        public String toString() {
            return "AudioUrl(audioUrl=" + this.audioUrl + ", type=" + this.type + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            k.f(dest, "dest");
            this.audioUrl.writeToParcel(dest, flags);
            dest.writeString(this.type);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioUrl(LLMRequestAudioUrlContent audioUrl, String type) {
            super(null);
            k.f(audioUrl, "audioUrl");
            k.f(type, "type");
            this.audioUrl = audioUrl;
            this.type = type;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0014J\u0010\u0010\u0018\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0010J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0014¨\u0006\""}, d2 = {"Lstepai/android/llm/base/LLMRequestContent$Image;", "Lstepai/android/llm/base/LLMRequestContent;", "Lstepai/android/llm/base/LLMRequestImageContent;", "imageUrl", "", "type", AppAgent.CONSTRUCT, "(Lstepai/android/llm/base/LLMRequestImageContent;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Lstepai/android/llm/base/LLMRequestImageContent;", "component2", "()Ljava/lang/String;", "copy", "(Lstepai/android/llm/base/LLMRequestImageContent;Ljava/lang/String;)Lstepai/android/llm/base/LLMRequestContent$Image;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lstepai/android/llm/base/LLMRequestImageContent;", "getImageUrl", "Ljava/lang/String;", "getType", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Image extends LLMRequestContent {
        public static final Parcelable.Creator<Image> CREATOR = new Creator();

        @SerializedName("image_url")
        private final LLMRequestImageContent imageUrl;
        private final String type;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Image> {
            @Override // android.os.Parcelable.Creator
            public final Image createFromParcel(Parcel parcel) {
                k.f(parcel, "parcel");
                return new Image(LLMRequestImageContent.CREATOR.createFromParcel(parcel), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final Image[] newArray(int i) {
                return new Image[i];
            }
        }

        public /* synthetic */ Image(LLMRequestImageContent lLMRequestImageContent, String str, int i, e eVar) {
            this(lLMRequestImageContent, (i & 2) != 0 ? "image_url" : str);
        }

        public static /* synthetic */ Image copy$default(Image image, LLMRequestImageContent lLMRequestImageContent, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                lLMRequestImageContent = image.imageUrl;
            }
            if ((i & 2) != 0) {
                str = image.type;
            }
            return image.copy(lLMRequestImageContent, str);
        }

        /* renamed from: component1, reason: from getter */
        public final LLMRequestImageContent getImageUrl() {
            return this.imageUrl;
        }

        /* renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        public final Image copy(LLMRequestImageContent imageUrl, String type) {
            k.f(imageUrl, "imageUrl");
            k.f(type, "type");
            return new Image(imageUrl, type);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Image)) {
                return false;
            }
            Image image = (Image) other;
            return k.b(this.imageUrl, image.imageUrl) && k.b(this.type, image.type);
        }

        public final LLMRequestImageContent getImageUrl() {
            return this.imageUrl;
        }

        @Override // stepai.android.llm.base.LLMRequestContent
        public String getType() {
            return this.type;
        }

        public int hashCode() {
            return this.type.hashCode() + (this.imageUrl.hashCode() * 31);
        }

        public String toString() {
            return "Image(imageUrl=" + this.imageUrl + ", type=" + this.type + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            k.f(dest, "dest");
            this.imageUrl.writeToParcel(dest, flags);
            dest.writeString(this.type);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Image(LLMRequestImageContent imageUrl, String type) {
            super(null);
            k.f(imageUrl, "imageUrl");
            k.f(type, "type");
            this.imageUrl = imageUrl;
            this.type = type;
        }
    }

    private LLMRequestContent() {
    }
}
