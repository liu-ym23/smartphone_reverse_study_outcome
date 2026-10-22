package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ModeType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "KTV_MODE", "SOLO_KTV", "KTV_COMPONENT", "VIDEO_CHORUS", "MUSIC_EFFECT", "UNKNOWN", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ModeType extends Enum<ModeType> {
    private static final /* synthetic */ ModeType[] $VALUES = null;
    public static final ModeType KTV_COMPONENT = null;
    public static final ModeType KTV_MODE = null;
    public static final ModeType MUSIC_EFFECT = null;
    public static final ModeType SOLO_KTV = null;
    public static final ModeType UNKNOWN = null;
    public static final ModeType VIDEO_CHORUS = null;
    private final String value;

    static {
        ModeType r100 = new ModeType("KTV_MODE", 0, "ktv_mode");
        KTV_MODE = r100;
        ModeType r101 = new ModeType("SOLO_KTV", 1, "solo_ktv");
        SOLO_KTV = r101;
        ModeType r102 = new ModeType("KTV_COMPONENT", 2, "ktv_component");
        KTV_COMPONENT = r102;
        ModeType r103 = new ModeType("VIDEO_CHORUS", 3, "video_chorus");
        VIDEO_CHORUS = r103;
        ModeType r104 = new ModeType("MUSIC_EFFECT", 4, "music_effect");
        MUSIC_EFFECT = r104;
        ModeType r105 = new ModeType("UNKNOWN", 5, "");
        UNKNOWN = r105;
        $VALUES = new ModeType[]{r100, r101, r102, r103, r104, r105};
    }

    public static ModeType valueOf(String r100) {
        return (ModeType) a.a(ModeType.class, r100);
    }

    public static ModeType[] values() {
        return (ModeType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    private ModeType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
