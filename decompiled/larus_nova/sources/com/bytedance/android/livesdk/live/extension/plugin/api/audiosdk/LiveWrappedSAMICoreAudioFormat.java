package com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk;

import android.util.SparseArray;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/audiosdk/LiveWrappedSAMICoreAudioFormat;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PCM", "WAV", "AAC", "OPUS", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSAMICoreAudioFormat extends Enum<LiveWrappedSAMICoreAudioFormat> {
    public static final LiveWrappedSAMICoreAudioFormat AAC = null;
    public static final a Companion = null;
    public static final LiveWrappedSAMICoreAudioFormat OPUS = null;
    public static final LiveWrappedSAMICoreAudioFormat PCM = null;
    public static final LiveWrappedSAMICoreAudioFormat WAV = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedSAMICoreAudioFormat[] f147270a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseArray<LiveWrappedSAMICoreAudioFormat> f147271b = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICoreAudioFormat$a] */
    static {
        int r100 = 0;
        LiveWrappedSAMICoreAudioFormat r101 = new LiveWrappedSAMICoreAudioFormat("PCM", 0, 0);
        PCM = r101;
        LiveWrappedSAMICoreAudioFormat r102 = new LiveWrappedSAMICoreAudioFormat("WAV", 1, 1);
        WAV = r102;
        LiveWrappedSAMICoreAudioFormat r103 = new LiveWrappedSAMICoreAudioFormat("AAC", 2, 2);
        AAC = r103;
        LiveWrappedSAMICoreAudioFormat r104 = new LiveWrappedSAMICoreAudioFormat("OPUS", 3, 3);
        OPUS = r104;
        f147270a = new LiveWrappedSAMICoreAudioFormat[]{r101, r102, r103, r104};
        Companion = new a();
        f147271b = new SparseArray();
        LiveWrappedSAMICoreAudioFormat[] r105 = values();
        int r106 = r105.length;
    L3:
        if (r100 >= r106) goto L5;
        LiveWrappedSAMICoreAudioFormat r107 = r105[r100];
        f147271b.put(r107.value, r107);
        r100 = r100 + 1;
        goto L3
    }

    public static LiveWrappedSAMICoreAudioFormat valueOf(String r100) {
        return (LiveWrappedSAMICoreAudioFormat) r27.a.a(LiveWrappedSAMICoreAudioFormat.class, r100);
    }

    public static LiveWrappedSAMICoreAudioFormat[] values() {
        return (LiveWrappedSAMICoreAudioFormat[]) f147270a.clone();
    }

    public static final /* synthetic */ SparseArray access$getIntToEnumMap$cp() {
        return f147271b;
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedSAMICoreAudioFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
