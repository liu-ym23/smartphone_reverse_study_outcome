package com.stepos.aiengine.args;

import B7.a;
import D7.w;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/stepos/aiengine/args/MultiFilesBundle;", "", "Landroid/os/Bundle;", "toBundle", "()Landroid/os/Bundle;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f3492a;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J;\u0010\u0010\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011JC\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001a8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001a8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0014\u0010 \u001a\u00020\u001a8\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u001cR\u0014\u0010!\u001a\u00020\u001a8\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u001cR\u0014\u0010\"\u001a\u00020\u001a8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0014\u0010#\u001a\u00020\u001a8\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u001cR\u0014\u0010$\u001a\u00020\u001a8\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u001cR\u0014\u0010%\u001a\u00020\u001a8\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u001cR\u0014\u0010&\u001a\u00020\u001a8\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\u001cR\u0014\u0010'\u001a\u00020\u001a8\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\u001c¨\u0006("}, d2 = {"Lcom/stepos/aiengine/args/MultiFilesBundle$Companion;", "", "Landroid/os/Bundle;", "bundle", "", "isMultiFilesMode", "(Landroid/os/Bundle;)Z", "", "Landroid/os/ParcelFileDescriptor;", "pfds", "", "timeOffsetsMs", "", "sampleRate", "channelCount", "Lcom/stepos/aiengine/args/MultiFilesBundle;", "fromFileDescriptors", "(Ljava/util/List;[JII)Lcom/stepos/aiengine/args/MultiFilesBundle;", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uris", "fromUris", "(Landroid/content/Context;Ljava/util/List;[JII)Lcom/stepos/aiengine/args/MultiFilesBundle;", "fromBundle", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/args/MultiFilesBundle;", "", "KEY_MULTI_FILES_MODE", "Ljava/lang/String;", "KEY_MULTI_FILES_COUNT", "KEY_MULTI_FILES_FDS", "KEY_MULTI_FILES_TIME_OFFSETS_MS", "KEY_MULTI_FILES_TIME_OFFSETS_CSV", "KEY_MULTI_FILES_EVENT_JSON", "KEY_MULTI_FILES_INDEX_JSON", "EVENT_FILE_RESULT", "EVENT_FILE_ERROR", "EVENT_FINAL", "KEY_SAMPLE_RATE", "KEY_CHANNEL_COUNT", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(e eVar) {
        }

        public static /* synthetic */ MultiFilesBundle fromFileDescriptors$default(Companion companion, List list, long[] jArr, int i, int i6, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                jArr = null;
            }
            if ((i10 & 4) != 0) {
                i = 16000;
            }
            if ((i10 & 8) != 0) {
                i6 = 1;
            }
            return companion.fromFileDescriptors(list, jArr, i, i6);
        }

        public static /* synthetic */ MultiFilesBundle fromUris$default(Companion companion, Context context, List list, long[] jArr, int i, int i6, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                jArr = null;
            }
            long[] jArr2 = jArr;
            if ((i10 & 8) != 0) {
                i = 16000;
            }
            int i11 = i;
            if ((i10 & 16) != 0) {
                i6 = 1;
            }
            return companion.fromUris(context, list, jArr2, i11, i6);
        }

        public final MultiFilesBundle fromBundle(Bundle bundle) {
            k.f(bundle, "bundle");
            return new MultiFilesBundle(bundle, null);
        }

        public final MultiFilesBundle fromFileDescriptors(List<? extends ParcelFileDescriptor> pfds, long[] timeOffsetsMs, int sampleRate, int channelCount) {
            k.f(pfds, "pfds");
            List<? extends ParcelFileDescriptor> list = pfds;
            if (list.isEmpty()) {
                throw new IllegalArgumentException("multi-file ASR requires at least one file");
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(MultiFilesBundle.KEY_MULTI_FILES_MODE, true);
            bundle.putInt(MultiFilesBundle.KEY_MULTI_FILES_COUNT, pfds.size());
            bundle.putParcelableArrayList(MultiFilesBundle.KEY_MULTI_FILES_FDS, new ArrayList<>(list));
            if (timeOffsetsMs != null) {
                bundle.putLongArray(MultiFilesBundle.KEY_MULTI_FILES_TIME_OFFSETS_MS, timeOffsetsMs);
            }
            bundle.putInt("sample_rate", sampleRate);
            bundle.putInt("channel_count", channelCount);
            return new MultiFilesBundle(bundle, null);
        }

        public final MultiFilesBundle fromUris(Context context, List<? extends Uri> uris, long[] timeOffsetsMs, int sampleRate, int channelCount) throws FileNotFoundException {
            k.f(context, "context");
            k.f(uris, "uris");
            List<? extends Uri> list = uris;
            ArrayList arrayList = new ArrayList(w.c0(list, 10));
            for (Uri uri : list) {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    throw new IllegalArgumentException(a.j("Cannot open URI: ", uri));
                }
                arrayList.add(parcelFileDescriptorOpenFileDescriptor);
            }
            return fromFileDescriptors(arrayList, timeOffsetsMs, sampleRate, channelCount);
        }

        public final boolean isMultiFilesMode(Bundle bundle) {
            k.f(bundle, "bundle");
            return bundle.getBoolean(MultiFilesBundle.KEY_MULTI_FILES_MODE, false);
        }
    }

    public MultiFilesBundle(Bundle bundle, e eVar) {
        this.f3492a = bundle;
    }

    public final Bundle toBundle() {
        return new Bundle(this.f3492a);
    }
}
