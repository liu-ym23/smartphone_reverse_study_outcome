package com.stepos.aiengine.algorithm.sla;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.stepos.aiengine.algorithm.sla.SlaInput;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.io.File;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0011J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u0013¨\u0006\""}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/SlaAudioInput;", "Landroid/os/Parcelable;", "Landroid/os/Bundle;", "audio", "<init>", "(Landroid/os/Bundle;)V", "Lcom/stepos/aiengine/algorithm/sla/SlaInput$Audio;", "toSlaInput", "()Lcom/stepos/aiengine/algorithm/sla/SlaInput$Audio;", "Landroid/os/Parcel;", "dest", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(Landroid/os/Bundle;)Lcom/stepos/aiengine/algorithm/sla/SlaAudioInput;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Bundle;", "getAudio", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SlaAudioInput implements Parcelable {
    public static final int DEFAULT_CHANNEL_COUNT = 1;
    public static final int DEFAULT_SAMPLE_RATE = 16000;
    private final Bundle audio;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SlaAudioInput> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005J\"\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005J\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005J*\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/SlaAudioInput$Companion;", "", "<init>", "()V", "DEFAULT_SAMPLE_RATE", "", "DEFAULT_CHANNEL_COUNT", "fromBytes", "Lcom/stepos/aiengine/algorithm/sla/SlaAudioInput;", "pcm", "", "sampleRate", "channelCount", "fromPath", "path", "", "fromFileDescriptor", "pfd", "Landroid/os/ParcelFileDescriptor;", "fromUri", "contentResolver", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ SlaAudioInput fromBytes$default(Companion companion, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i10 = 16000;
            }
            if ((i12 & 4) != 0) {
                i11 = 1;
            }
            return companion.fromBytes(bArr, i10, i11);
        }

        public static /* synthetic */ SlaAudioInput fromFileDescriptor$default(Companion companion, ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i10 = 16000;
            }
            if ((i12 & 4) != 0) {
                i11 = 1;
            }
            return companion.fromFileDescriptor(parcelFileDescriptor, i10, i11);
        }

        public static /* synthetic */ SlaAudioInput fromPath$default(Companion companion, String str, int i10, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i10 = 16000;
            }
            if ((i12 & 4) != 0) {
                i11 = 1;
            }
            return companion.fromPath(str, i10, i11);
        }

        public static /* synthetic */ SlaAudioInput fromUri$default(Companion companion, ContentResolver contentResolver, Uri uri, int i10, int i11, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                i10 = 16000;
            }
            if ((i12 & 8) != 0) {
                i11 = 1;
            }
            return companion.fromUri(contentResolver, uri, i10, i11);
        }

        public final SlaAudioInput fromBytes(byte[] pcm, int sampleRate, int channelCount) {
            p.i(pcm, "pcm");
            return new SlaAudioInput(SingleFileBundle.INSTANCE.fromBytes(pcm, sampleRate, channelCount).toBundle());
        }

        public final SlaAudioInput fromFileDescriptor(ParcelFileDescriptor pfd, int sampleRate, int channelCount) {
            p.i(pfd, "pfd");
            return new SlaAudioInput(SingleFileBundle.INSTANCE.fromFileDescriptor(pfd, sampleRate, channelCount).toBundle());
        }

        public final SlaAudioInput fromPath(String path, int sampleRate, int channelCount) throws FileNotFoundException {
            p.i(path, "path");
            ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(new File(path), SQLiteDatabase.CREATE_IF_NECESSARY);
            p.f(parcelFileDescriptorOpen);
            return fromFileDescriptor(parcelFileDescriptorOpen, sampleRate, channelCount);
        }

        public final SlaAudioInput fromUri(ContentResolver contentResolver, Uri uri, int sampleRate, int channelCount) throws FileNotFoundException {
            p.i(contentResolver, "contentResolver");
            p.i(uri, "uri");
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                return fromFileDescriptor(parcelFileDescriptorOpenFileDescriptor, sampleRate, channelCount);
            }
            throw new IllegalArgumentException("Cannot open URI: " + uri);
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SlaAudioInput> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SlaAudioInput createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new SlaAudioInput(parcel.readBundle(SlaAudioInput.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SlaAudioInput[] newArray(int i10) {
            return new SlaAudioInput[i10];
        }
    }

    public SlaAudioInput(Bundle audio) {
        p.i(audio, "audio");
        this.audio = audio;
    }

    public static /* synthetic */ SlaAudioInput copy$default(SlaAudioInput slaAudioInput, Bundle bundle, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bundle = slaAudioInput.audio;
        }
        return slaAudioInput.copy(bundle);
    }

    /* renamed from: component1, reason: from getter */
    public final Bundle getAudio() {
        return this.audio;
    }

    public final SlaAudioInput copy(Bundle audio) {
        p.i(audio, "audio");
        return new SlaAudioInput(audio);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SlaAudioInput) && p.d(this.audio, ((SlaAudioInput) other).audio);
    }

    public final Bundle getAudio() {
        return this.audio;
    }

    public int hashCode() {
        return this.audio.hashCode();
    }

    public final SlaInput.Audio toSlaInput() {
        return new SlaInput.Audio(this.audio);
    }

    public String toString() {
        return "SlaAudioInput(audio=" + this.audio + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeBundle(this.audio);
    }
}
