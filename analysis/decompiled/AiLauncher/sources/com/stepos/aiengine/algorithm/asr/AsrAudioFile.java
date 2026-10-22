package com.stepos.aiengine.algorithm.asr;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0010J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0014¨\u0006%"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrAudioFile;", "Landroid/os/Parcelable;", "", SingleFileBundle.KEY_FILE_DESCRIPTOR, "Landroid/os/Bundle;", "audio", "<init>", "(JLandroid/os/Bundle;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()J", "component2", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(JLandroid/os/Bundle;)Lcom/stepos/aiengine/algorithm/asr/AsrAudioFile;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getFd", "Landroid/os/Bundle;", "getAudio", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AsrAudioFile implements Parcelable {
    private final Bundle audio;
    private final long fd;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<AsrAudioFile> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¨\u0006\u0010"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrAudioFile$Companion;", "", "<init>", "()V", "fromUri", "Lcom/stepos/aiengine/algorithm/asr/AsrAudioFile;", "contentResolver", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "sampleRate", "", "channelCount", "cloudBizCode", "", "cloudSourceType", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ AsrAudioFile fromUri$default(Companion companion, ContentResolver contentResolver, Uri uri, int i10, int i11, String str, String str2, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                i10 = 16000;
            }
            int i13 = i10;
            if ((i12 & 8) != 0) {
                i11 = 1;
            }
            return companion.fromUri(contentResolver, uri, i13, i11, (i12 & 16) != 0 ? null : str, (i12 & 32) != 0 ? null : str2);
        }

        public final AsrAudioFile fromUri(ContentResolver contentResolver, Uri uri, int sampleRate, int channelCount, String cloudBizCode, String cloudSourceType) throws FileNotFoundException {
            p.i(contentResolver, "contentResolver");
            p.i(uri, "uri");
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                SingleFileBundle singleFileBundleFromFileDescriptor = SingleFileBundle.INSTANCE.fromFileDescriptor(parcelFileDescriptorOpenFileDescriptor, sampleRate, channelCount);
                singleFileBundleFromFileDescriptor.putCloudScene(cloudBizCode, cloudSourceType);
                return new AsrAudioFile(parcelFileDescriptorOpenFileDescriptor.getFd(), singleFileBundleFromFileDescriptor.toBundle());
            }
            throw new IllegalArgumentException("Cannot open URI: " + uri);
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AsrAudioFile> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrAudioFile createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new AsrAudioFile(parcel.readLong(), parcel.readBundle(AsrAudioFile.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AsrAudioFile[] newArray(int i10) {
            return new AsrAudioFile[i10];
        }
    }

    public AsrAudioFile(long j10, Bundle audio) {
        p.i(audio, "audio");
        this.fd = j10;
        this.audio = audio;
    }

    public static /* synthetic */ AsrAudioFile copy$default(AsrAudioFile asrAudioFile, long j10, Bundle bundle, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = asrAudioFile.fd;
        }
        if ((i10 & 2) != 0) {
            bundle = asrAudioFile.audio;
        }
        return asrAudioFile.copy(j10, bundle);
    }

    /* renamed from: component1, reason: from getter */
    public final long getFd() {
        return this.fd;
    }

    /* renamed from: component2, reason: from getter */
    public final Bundle getAudio() {
        return this.audio;
    }

    public final AsrAudioFile copy(long fd, Bundle audio) {
        p.i(audio, "audio");
        return new AsrAudioFile(fd, audio);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AsrAudioFile)) {
            return false;
        }
        AsrAudioFile asrAudioFile = (AsrAudioFile) other;
        return this.fd == asrAudioFile.fd && p.d(this.audio, asrAudioFile.audio);
    }

    public final Bundle getAudio() {
        return this.audio;
    }

    public final long getFd() {
        return this.fd;
    }

    public int hashCode() {
        return (Long.hashCode(this.fd) * 31) + this.audio.hashCode();
    }

    public String toString() {
        return "AsrAudioFile(fd=" + this.fd + ", audio=" + this.audio + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeLong(this.fd);
        dest.writeBundle(this.audio);
    }
}
