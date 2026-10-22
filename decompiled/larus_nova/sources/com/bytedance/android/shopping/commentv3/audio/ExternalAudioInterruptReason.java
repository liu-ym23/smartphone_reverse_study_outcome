package com.bytedance.android.shopping.commentv3.audio;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/audio/ExternalAudioInterruptReason;", "", "COMMENT_AUDIO_PLAY", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ExternalAudioInterruptReason extends Enum<ExternalAudioInterruptReason> {
    public static final ExternalAudioInterruptReason COMMENT_AUDIO_PLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExternalAudioInterruptReason[] f172597a = null;

    static {
        ExternalAudioInterruptReason r100 = new ExternalAudioInterruptReason();
        COMMENT_AUDIO_PLAY = r100;
        f172597a = new ExternalAudioInterruptReason[]{r100};
    }

    public static ExternalAudioInterruptReason valueOf(String r100) {
        return (ExternalAudioInterruptReason) r27.a.a(ExternalAudioInterruptReason.class, r100);
    }

    public static ExternalAudioInterruptReason[] values() {
        return (ExternalAudioInterruptReason[]) f172597a.clone();
    }

    public ExternalAudioInterruptReason() {
        super("COMMENT_AUDIO_PLAY", 0);
    }
}
