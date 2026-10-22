package com.stepos.aiengine.args;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/stepos/aiengine/args/SingleFileBundle;", "", "Landroid/os/Bundle;", "toBundle", "()Landroid/os/Bundle;", "Landroid/os/ParcelFileDescriptor;", "pfd", "LC7/r;", "putFileDescriptor", "(Landroid/os/ParcelFileDescriptor;)V", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SingleFileBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEFAULT_CHANNEL_COUNT = 1;
    public static final int DEFAULT_SAMPLE_RATE = 16000;
    public static final String KEY_BYTES = "bytes";
    public static final String KEY_CHANNEL_COUNT = "channel_count";
    public static final String KEY_FILE_DESCRIPTOR = "fd";
    public static final String KEY_PATH = "path";
    public static final String KEY_SAMPLE_RATE = "sample_rate";

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3495a;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ)\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/stepos/aiengine/args/SingleFileBundle$Companion;", "", "", SingleFileBundle.KEY_BYTES, "", "sampleRate", "channelCount", "Lcom/stepos/aiengine/args/SingleFileBundle;", "fromBytes", "([BII)Lcom/stepos/aiengine/args/SingleFileBundle;", "", SingleFileBundle.KEY_PATH, "fromPath", "(Ljava/lang/String;II)Lcom/stepos/aiengine/args/SingleFileBundle;", "Landroid/os/ParcelFileDescriptor;", "pfd", "fromFileDescriptor", "(Landroid/os/ParcelFileDescriptor;II)Lcom/stepos/aiengine/args/SingleFileBundle;", "Landroid/os/Bundle;", "bundle", "fromBundle", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/SingleFileBundle;", "KEY_PATH", "Ljava/lang/String;", "KEY_BYTES", "KEY_FILE_DESCRIPTOR", "KEY_SAMPLE_RATE", "KEY_CHANNEL_COUNT", "DEFAULT_SAMPLE_RATE", "I", "DEFAULT_CHANNEL_COUNT", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public static /* synthetic */ SingleFileBundle fromBytes$default(Companion companion, byte[] bArr, int i, int i6, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                i = 16000;
            }
            if ((i10 & 4) != 0) {
                i6 = 1;
            }
            return companion.fromBytes(bArr, i, i6);
        }

        public static /* synthetic */ SingleFileBundle fromFileDescriptor$default(Companion companion, ParcelFileDescriptor parcelFileDescriptor, int i, int i6, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                i = 16000;
            }
            if ((i10 & 4) != 0) {
                i6 = 1;
            }
            return companion.fromFileDescriptor(parcelFileDescriptor, i, i6);
        }

        public static /* synthetic */ SingleFileBundle fromPath$default(Companion companion, String str, int i, int i6, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                i = 16000;
            }
            if ((i10 & 4) != 0) {
                i6 = 1;
            }
            return companion.fromPath(str, i, i6);
        }

        public final SingleFileBundle fromBundle(Bundle bundle) {
            k.f(bundle, "bundle");
            return new SingleFileBundle(bundle, null);
        }

        public final SingleFileBundle fromBytes(byte[] bytes, int sampleRate, int channelCount) {
            k.f(bytes, "bytes");
            Bundle bundle = new Bundle();
            bundle.putByteArray(SingleFileBundle.KEY_BYTES, bytes);
            bundle.putInt("sample_rate", sampleRate);
            bundle.putInt("channel_count", channelCount);
            return new SingleFileBundle(bundle, null);
        }

        public final SingleFileBundle fromFileDescriptor(ParcelFileDescriptor pfd, int sampleRate, int channelCount) {
            k.f(pfd, "pfd");
            Bundle bundle = new Bundle();
            bundle.putParcelable(SingleFileBundle.KEY_FILE_DESCRIPTOR, pfd);
            bundle.putInt("sample_rate", sampleRate);
            bundle.putInt("channel_count", channelCount);
            return new SingleFileBundle(bundle, null);
        }

        public final SingleFileBundle fromPath(String path, int sampleRate, int channelCount) {
            k.f(path, "path");
            Bundle bundle = new Bundle();
            bundle.putString(SingleFileBundle.KEY_PATH, path);
            bundle.putInt("sample_rate", sampleRate);
            bundle.putInt("channel_count", channelCount);
            return new SingleFileBundle(bundle, null);
        }
    }

    public SingleFileBundle(Bundle bundle, e eVar) {
        this.f3495a = bundle;
    }

    public final void putFileDescriptor(ParcelFileDescriptor pfd) {
        k.f(pfd, "pfd");
        this.f3495a.putParcelable(KEY_FILE_DESCRIPTOR, pfd);
    }

    public final Bundle toBundle() {
        return new Bundle(this.f3495a);
    }
}
