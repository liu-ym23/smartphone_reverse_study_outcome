package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/AudioChatStageUpdateType;", "", "UNKNOWN", "AUDIO_STAGE_UPDATE_SEAT_LOCATION", "STAGE_IS_INSERT", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AudioChatStageUpdateType extends Enum<AudioChatStageUpdateType> {
    public static final AudioChatStageUpdateType AUDIO_STAGE_UPDATE_SEAT_LOCATION = null;
    public static final AudioChatStageUpdateType STAGE_IS_INSERT = null;
    public static final AudioChatStageUpdateType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioChatStageUpdateType[] f77072a = null;

    static {
        AudioChatStageUpdateType r100 = new AudioChatStageUpdateType("UNKNOWN", 0);
        UNKNOWN = r100;
        AudioChatStageUpdateType r101 = new AudioChatStageUpdateType("AUDIO_STAGE_UPDATE_SEAT_LOCATION", 1);
        AUDIO_STAGE_UPDATE_SEAT_LOCATION = r101;
        AudioChatStageUpdateType r102 = new AudioChatStageUpdateType("STAGE_IS_INSERT", 2);
        STAGE_IS_INSERT = r102;
        f77072a = new AudioChatStageUpdateType[]{r100, r101, r102};
    }

    public static AudioChatStageUpdateType valueOf(String r100) {
        return (AudioChatStageUpdateType) a.a(AudioChatStageUpdateType.class, r100);
    }

    public static AudioChatStageUpdateType[] values() {
        return (AudioChatStageUpdateType[]) f77072a.clone();
    }

    public AudioChatStageUpdateType(String r100, int r101) {
        super(r100, r101);
    }
}
