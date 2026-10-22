package com.stepos.aiengine.algorithm.sla;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.io.File;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u00042\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/SlaInput;", "Landroid/os/Parcelable;", "Audio", "Text", "Companion", "Lcom/stepos/aiengine/algorithm/sla/SlaInput$Audio;", "Lcom/stepos/aiengine/algorithm/sla/SlaInput$Text;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface SlaInput extends Parcelable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.f23684a;
    public static final int DEFAULT_CHANNEL_COUNT = 1;
    public static final int DEFAULT_SAMPLE_RATE = 16000;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000eJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/SlaInput$Audio;", "Lcom/stepos/aiengine/algorithm/sla/SlaInput;", "Landroid/os/Bundle;", "audio", "<init>", "(Landroid/os/Bundle;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(Landroid/os/Bundle;)Lcom/stepos/aiengine/algorithm/sla/SlaInput$Audio;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Bundle;", "getAudio", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Audio implements SlaInput {
        public static final Parcelable.Creator<Audio> CREATOR = new Creator();
        private final Bundle audio;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Audio> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Audio createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                return new Audio(parcel.readBundle(Audio.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Audio[] newArray(int i10) {
                return new Audio[i10];
            }
        }

        public Audio(Bundle audio) {
            p.i(audio, "audio");
            this.audio = audio;
        }

        public static /* synthetic */ Audio copy$default(Audio audio, Bundle bundle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                bundle = audio.audio;
            }
            return audio.copy(bundle);
        }

        /* renamed from: component1, reason: from getter */
        public final Bundle getAudio() {
            return this.audio;
        }

        public final Audio copy(Bundle audio) {
            p.i(audio, "audio");
            return new Audio(audio);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Audio) && p.d(this.audio, ((Audio) other).audio);
        }

        public final Bundle getAudio() {
            return this.audio;
        }

        public int hashCode() {
            return this.audio.hashCode();
        }

        public String toString() {
            return "Audio(audio=" + this.audio + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            p.i(dest, "dest");
            dest.writeBundle(this.audio);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005J\"\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005J\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005J*\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/SlaInput$Companion;", "", "<init>", "()V", "DEFAULT_SAMPLE_RATE", "", "DEFAULT_CHANNEL_COUNT", "audioFromBytes", "Lcom/stepos/aiengine/algorithm/sla/SlaInput$Audio;", "pcm", "", "sampleRate", "channelCount", "audioFromPath", "path", "", "audioFromFd", "pfd", "Landroid/os/ParcelFileDescriptor;", "audioFromUri", "contentResolver", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "text", "Lcom/stepos/aiengine/algorithm/sla/SlaInput$Text;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public static final int DEFAULT_CHANNEL_COUNT = 1;
        public static final int DEFAULT_SAMPLE_RATE = 16000;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f23684a = new Companion();

        public static /* synthetic */ Audio audioFromBytes$default(Companion companion, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i10 = 16000;
            }
            if ((i12 & 4) != 0) {
                i11 = 1;
            }
            return companion.audioFromBytes(bArr, i10, i11);
        }

        public static /* synthetic */ Audio audioFromFd$default(Companion companion, ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i10 = 16000;
            }
            if ((i12 & 4) != 0) {
                i11 = 1;
            }
            return companion.audioFromFd(parcelFileDescriptor, i10, i11);
        }

        public static /* synthetic */ Audio audioFromPath$default(Companion companion, String str, int i10, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i10 = 16000;
            }
            if ((i12 & 4) != 0) {
                i11 = 1;
            }
            return companion.audioFromPath(str, i10, i11);
        }

        public static /* synthetic */ Audio audioFromUri$default(Companion companion, ContentResolver contentResolver, Uri uri, int i10, int i11, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                i10 = 16000;
            }
            if ((i12 & 8) != 0) {
                i11 = 1;
            }
            return companion.audioFromUri(contentResolver, uri, i10, i11);
        }

        public final Audio audioFromBytes(byte[] pcm, int sampleRate, int channelCount) {
            p.i(pcm, "pcm");
            return new Audio(SingleFileBundle.INSTANCE.fromBytes(pcm, sampleRate, channelCount).toBundle());
        }

        public final Audio audioFromFd(ParcelFileDescriptor pfd, int sampleRate, int channelCount) {
            p.i(pfd, "pfd");
            return new Audio(SingleFileBundle.INSTANCE.fromFileDescriptor(pfd, sampleRate, channelCount).toBundle());
        }

        public final Audio audioFromPath(String path, int sampleRate, int channelCount) throws FileNotFoundException {
            p.i(path, "path");
            ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(new File(path), SQLiteDatabase.CREATE_IF_NECESSARY);
            p.f(parcelFileDescriptorOpen);
            return audioFromFd(parcelFileDescriptorOpen, sampleRate, channelCount);
        }

        public final Audio audioFromUri(ContentResolver contentResolver, Uri uri, int sampleRate, int channelCount) throws FileNotFoundException {
            p.i(contentResolver, "contentResolver");
            p.i(uri, "uri");
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                return audioFromFd(parcelFileDescriptorOpenFileDescriptor, sampleRate, channelCount);
            }
            throw new IllegalArgumentException("Cannot open URI: " + uri);
        }

        public final Text text(String text) {
            p.i(text, "text");
            return new Text(text);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/SlaInput$Text;", "Lcom/stepos/aiengine/algorithm/sla/SlaInput;", "", "text", "<init>", "(Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;)Lcom/stepos/aiengine/algorithm/sla/SlaInput$Text;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Text implements SlaInput {
        public static final Parcelable.Creator<Text> CREATOR = new Creator();
        private final String text;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Text> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Text createFromParcel(Parcel parcel) {
                p.i(parcel, "parcel");
                return new Text(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Text[] newArray(int i10) {
                return new Text[i10];
            }
        }

        public Text(String text) {
            p.i(text, "text");
            this.text = text;
        }

        public static /* synthetic */ Text copy$default(Text text, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = text.text;
            }
            return text.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final Text copy(String text) {
            p.i(text, "text");
            return new Text(text);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Text) && p.d(this.text, ((Text) other).text);
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "Text(text=" + this.text + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            p.i(dest, "dest");
            dest.writeString(this.text);
        }
    }
}
