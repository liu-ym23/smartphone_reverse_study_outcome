package com.stepos.aiengine.args;

import La.H;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/stepos/aiengine/args/SingleFileBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "toBundle", "()Landroid/os/Bundle;", "Landroid/os/ParcelFileDescriptor;", "pfd", "LY8/t;", "putFileDescriptor", "(Landroid/os/ParcelFileDescriptor;)V", "", "bizCode", "sourceType", "putCloudScene", "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SingleFileBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEFAULT_CHANNEL_COUNT = 1;
    public static final int DEFAULT_SAMPLE_RATE = 16000;
    public static final String KEY_BYTES = "bytes";
    public static final String KEY_CHANNEL_COUNT = "channel_count";
    public static final String KEY_CLOUD_BIZ_CODE = "cloud.biz_code";
    public static final String KEY_CLOUD_SOURCE_TYPE = "cloud.source_type";
    public static final String KEY_FILE_DESCRIPTOR = "fd";
    public static final String KEY_PATH = "path";
    public static final String KEY_SAMPLE_RATE = "sample_rate";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\rJ\"\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\rJ\"\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/stepos/aiengine/args/SingleFileBundle$Companion;", "", "<init>", "()V", "KEY_PATH", "", "KEY_BYTES", "KEY_FILE_DESCRIPTOR", "KEY_SAMPLE_RATE", "KEY_CHANNEL_COUNT", "KEY_CLOUD_BIZ_CODE", "KEY_CLOUD_SOURCE_TYPE", "DEFAULT_SAMPLE_RATE", "", "DEFAULT_CHANNEL_COUNT", "fromBytes", "Lcom/stepos/aiengine/args/SingleFileBundle;", SingleFileBundle.KEY_BYTES, "", "sampleRate", "channelCount", "fromPath", "path", "fromFileDescriptor", "pfd", "Landroid/os/ParcelFileDescriptor;", "fromBundle", "bundle", "Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ SingleFileBundle fromBytes$default(Companion companion, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i10 = 16000;
            }
            if ((i12 & 4) != 0) {
                i11 = 1;
            }
            return companion.fromBytes(bArr, i10, i11);
        }

        public static /* synthetic */ SingleFileBundle fromFileDescriptor$default(Companion companion, ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i10 = 16000;
            }
            if ((i12 & 4) != 0) {
                i11 = 1;
            }
            return companion.fromFileDescriptor(parcelFileDescriptor, i10, i11);
        }

        public static /* synthetic */ SingleFileBundle fromPath$default(Companion companion, String str, int i10, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i10 = 16000;
            }
            if ((i12 & 4) != 0) {
                i11 = 1;
            }
            return companion.fromPath(str, i10, i11);
        }

        public final SingleFileBundle fromBundle(Bundle bundle) {
            p.i(bundle, "bundle");
            return new SingleFileBundle(bundle, null);
        }

        public final SingleFileBundle fromBytes(byte[] bytes, int sampleRate, int channelCount) {
            p.i(bytes, "bytes");
            Bundle bundle = new Bundle();
            bundle.putByteArray(SingleFileBundle.KEY_BYTES, bytes);
            bundle.putInt("sample_rate", sampleRate);
            bundle.putInt("channel_count", channelCount);
            return new SingleFileBundle(bundle, null);
        }

        public final SingleFileBundle fromFileDescriptor(ParcelFileDescriptor pfd, int sampleRate, int channelCount) {
            p.i(pfd, "pfd");
            Bundle bundle = new Bundle();
            bundle.putParcelable(SingleFileBundle.KEY_FILE_DESCRIPTOR, pfd);
            bundle.putInt("sample_rate", sampleRate);
            bundle.putInt("channel_count", channelCount);
            return new SingleFileBundle(bundle, null);
        }

        public final SingleFileBundle fromPath(String path, int sampleRate, int channelCount) {
            p.i(path, "path");
            Bundle bundle = new Bundle();
            bundle.putString("path", path);
            bundle.putInt("sample_rate", sampleRate);
            bundle.putInt("channel_count", channelCount);
            return new SingleFileBundle(bundle, null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ SingleFileBundle(Bundle bundle, i iVar) {
        this(bundle);
    }

    public final void putCloudScene(String bizCode, String sourceType) {
        if (bizCode != null && !H.x0(bizCode)) {
            this.bundle.putString(KEY_CLOUD_BIZ_CODE, bizCode);
        }
        if (sourceType == null || H.x0(sourceType)) {
            return;
        }
        this.bundle.putString(KEY_CLOUD_SOURCE_TYPE, sourceType);
    }

    public final void putFileDescriptor(ParcelFileDescriptor pfd) {
        p.i(pfd, "pfd");
        this.bundle.putParcelable(KEY_FILE_DESCRIPTOR, pfd);
    }

    public final Bundle toBundle() {
        return new Bundle(this.bundle);
    }

    public SingleFileBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
