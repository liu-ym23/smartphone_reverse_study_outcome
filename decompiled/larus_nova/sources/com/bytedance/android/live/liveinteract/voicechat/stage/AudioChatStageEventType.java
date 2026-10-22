package com.bytedance.android.live.liveinteract.voicechat.stage;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/stage/AudioChatStageEventType;", "", "UNKNOWN", "STAGE_UPDATE_POSITION", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AudioChatStageEventType extends Enum<AudioChatStageEventType> {
    public static final AudioChatStageEventType STAGE_UPDATE_POSITION = null;
    public static final AudioChatStageEventType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioChatStageEventType[] f80583a = null;

    static {
        AudioChatStageEventType r100 = new AudioChatStageEventType("UNKNOWN", 0);
        UNKNOWN = r100;
        AudioChatStageEventType r101 = new AudioChatStageEventType("STAGE_UPDATE_POSITION", 1);
        STAGE_UPDATE_POSITION = r101;
        f80583a = new AudioChatStageEventType[]{r100, r101};
    }

    public static AudioChatStageEventType valueOf(String r100) {
        return (AudioChatStageEventType) r27.a.a(AudioChatStageEventType.class, r100);
    }

    public static AudioChatStageEventType[] values() {
        return (AudioChatStageEventType[]) f80583a.clone();
    }

    public AudioChatStageEventType(String r100, int r101) {
        super(r100, r101);
    }
}
