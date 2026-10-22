package com.stepos.aiengine.args;

import Z8.C1174w;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.autonavi.aps.amapapi.config.Const;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/stepos/aiengine/args/MultiFilesBundle;", "", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "toBundle", "()Landroid/os/Bundle;", Const.INTENT_KEY_APIKEY, "Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiFilesBundle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EVENT_FILE_ERROR = "file_error";
    public static final String EVENT_FILE_RESULT = "file_result";
    public static final String EVENT_FINAL = "final";
    public static final String KEY_CHANNEL_COUNT = "channel_count";
    public static final String KEY_MULTI_FILES_COUNT = "multi_files_count";
    public static final String KEY_MULTI_FILES_EVENT_JSON = "multi_files_event";
    public static final String KEY_MULTI_FILES_FDS = "multi_files_fds";
    public static final String KEY_MULTI_FILES_INDEX_JSON = "multi_files_index";
    public static final String KEY_MULTI_FILES_MODE = "multi_files_mode";
    public static final String KEY_MULTI_FILES_TIME_OFFSETS_CSV = "multi_files_time_offsets_csv";
    public static final String KEY_MULTI_FILES_TIME_OFFSETS_MS = "multi_files_time_offsets_ms";
    public static final String KEY_SAMPLE_RATE = "sample_rate";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle bundle;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J4\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001dJ<\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010$\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/stepos/aiengine/args/MultiFilesBundle$Companion;", "", "<init>", "()V", "KEY_MULTI_FILES_MODE", "", "KEY_MULTI_FILES_COUNT", "KEY_MULTI_FILES_FDS", "KEY_MULTI_FILES_TIME_OFFSETS_MS", "KEY_MULTI_FILES_TIME_OFFSETS_CSV", "KEY_MULTI_FILES_EVENT_JSON", "KEY_MULTI_FILES_INDEX_JSON", "EVENT_FILE_RESULT", "EVENT_FILE_ERROR", "EVENT_FINAL", "KEY_SAMPLE_RATE", "KEY_CHANNEL_COUNT", "isMultiFilesMode", "", "bundle", "Landroid/os/Bundle;", "fromFileDescriptors", "Lcom/stepos/aiengine/args/MultiFilesBundle;", "pfds", "", "Landroid/os/ParcelFileDescriptor;", "timeOffsetsMs", "", "sampleRate", "", "channelCount", "fromUris", "context", "Landroid/content/Context;", "uris", "Landroid/net/Uri;", "fromBundle", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ MultiFilesBundle fromFileDescriptors$default(Companion companion, List list, long[] jArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                jArr = null;
            }
            if ((i12 & 4) != 0) {
                i10 = 16000;
            }
            if ((i12 & 8) != 0) {
                i11 = 1;
            }
            return companion.fromFileDescriptors(list, jArr, i10, i11);
        }

        public static /* synthetic */ MultiFilesBundle fromUris$default(Companion companion, Context context, List list, long[] jArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                jArr = null;
            }
            long[] jArr2 = jArr;
            if ((i12 & 8) != 0) {
                i10 = 16000;
            }
            int i13 = i10;
            if ((i12 & 16) != 0) {
                i11 = 1;
            }
            return companion.fromUris(context, list, jArr2, i13, i11);
        }

        public final MultiFilesBundle fromBundle(Bundle bundle) {
            p.i(bundle, "bundle");
            return new MultiFilesBundle(bundle, null);
        }

        public final MultiFilesBundle fromFileDescriptors(List<? extends ParcelFileDescriptor> pfds, long[] timeOffsetsMs, int sampleRate, int channelCount) {
            p.i(pfds, "pfds");
            if (pfds.isEmpty()) {
                throw new IllegalArgumentException("multi-file ASR requires at least one file");
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(MultiFilesBundle.KEY_MULTI_FILES_MODE, true);
            bundle.putInt(MultiFilesBundle.KEY_MULTI_FILES_COUNT, pfds.size());
            bundle.putParcelableArrayList(MultiFilesBundle.KEY_MULTI_FILES_FDS, new ArrayList<>(pfds));
            if (timeOffsetsMs != null) {
                bundle.putLongArray(MultiFilesBundle.KEY_MULTI_FILES_TIME_OFFSETS_MS, timeOffsetsMs);
            }
            bundle.putInt("sample_rate", sampleRate);
            bundle.putInt("channel_count", channelCount);
            return new MultiFilesBundle(bundle, null);
        }

        public final MultiFilesBundle fromUris(Context context, List<? extends Uri> uris, long[] timeOffsetsMs, int sampleRate, int channelCount) throws FileNotFoundException {
            p.i(context, "context");
            p.i(uris, "uris");
            List<? extends Uri> list = uris;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            for (Uri uri : list) {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    throw new IllegalArgumentException("Cannot open URI: " + uri);
                }
                arrayList.add(parcelFileDescriptorOpenFileDescriptor);
            }
            return fromFileDescriptors(arrayList, timeOffsetsMs, sampleRate, channelCount);
        }

        public final boolean isMultiFilesMode(Bundle bundle) {
            p.i(bundle, "bundle");
            return bundle.getBoolean(MultiFilesBundle.KEY_MULTI_FILES_MODE, false);
        }

        public Companion() {
        }
    }

    public /* synthetic */ MultiFilesBundle(Bundle bundle, i iVar) {
        this(bundle);
    }

    public final Bundle toBundle() {
        return new Bundle(this.bundle);
    }

    public MultiFilesBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
