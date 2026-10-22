package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import zf2.c;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/data/LiveWrappedAudioChannel;", "", "", "value", "", "toString", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AUDIO_CHANNEL_AUTO", "AUDIO_CHANNEL_MONO", "AUDIO_CHANNEL_STEREO", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedAudioChannel extends Enum<LiveWrappedAudioChannel> {
    public static final LiveWrappedAudioChannel AUDIO_CHANNEL_AUTO = null;
    public static final LiveWrappedAudioChannel AUDIO_CHANNEL_MONO = null;
    public static final LiveWrappedAudioChannel AUDIO_CHANNEL_STEREO = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveWrappedAudioChannel[] f147320a = null;
    private int value;

    public static final class a {
        public a() {
        }
    }

    static {
        LiveWrappedAudioChannel r100 = new LiveWrappedAudioChannel("AUDIO_CHANNEL_AUTO", 0, -1);
        AUDIO_CHANNEL_AUTO = r100;
        LiveWrappedAudioChannel r101 = new LiveWrappedAudioChannel("AUDIO_CHANNEL_MONO", 1, 1);
        AUDIO_CHANNEL_MONO = r101;
        LiveWrappedAudioChannel r102 = new LiveWrappedAudioChannel("AUDIO_CHANNEL_STEREO", 2, 2);
        AUDIO_CHANNEL_STEREO = r102;
        f147320a = new LiveWrappedAudioChannel[]{r100, r101, r102};
        Companion = new a();
    }

    public static LiveWrappedAudioChannel valueOf(String r100) {
        return (LiveWrappedAudioChannel) r27.a.a(LiveWrappedAudioChannel.class, r100);
    }

    public static LiveWrappedAudioChannel[] values() {
        return (LiveWrappedAudioChannel[]) f147320a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = c.f571696a[ordinal()];
        if (r100 != 1) goto L5;
        return "kAudioChannelAuto";
    L5:
        if (r100 != 2) goto L7;
        return "kAudioChannelMono";
    L7:
        if (r100 == 3) goto L9;
        return "kAudioChannelUnknown";
    L9:
        return "kAudioChannelStereo";
    }

    public final int value() {
        return this.value;
    }

    @JvmStatic
    public static final LiveWrappedAudioChannel fromId(int r100) {
        Companion.getClass();
        LiveWrappedAudioChannel[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        LiveWrappedAudioChannel r104 = r101[r103];
        if (r104.value() == r100) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return r104;
    L9:
        return AUDIO_CHANNEL_AUTO;
    }

    public LiveWrappedAudioChannel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
