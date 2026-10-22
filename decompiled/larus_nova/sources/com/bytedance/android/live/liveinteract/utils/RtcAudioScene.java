package com.bytedance.android.live.liveinteract.utils;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/utils/RtcAudioScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", EffectConstants.NORMAL, "CHAT_ROOM", "KTV", "PK", "REAL_TIME_CHORUS", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RtcAudioScene extends Enum<RtcAudioScene> {
    public static final RtcAudioScene CHAT_ROOM = null;
    public static final RtcAudioScene KTV = null;
    public static final RtcAudioScene NORMAL = null;
    public static final RtcAudioScene PK = null;
    public static final RtcAudioScene REAL_TIME_CHORUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RtcAudioScene[] f78713a = null;
    private final String value;

    static {
        RtcAudioScene r100 = new RtcAudioScene(EffectConstants.NORMAL, 0, "IES_normal");
        NORMAL = r100;
        RtcAudioScene r101 = new RtcAudioScene("CHAT_ROOM", 1, "IES_chatroom");
        CHAT_ROOM = r101;
        RtcAudioScene r102 = new RtcAudioScene("KTV", 2, "IES_KTV");
        KTV = r102;
        RtcAudioScene r103 = new RtcAudioScene("PK", 3, "IES_PK");
        PK = r103;
        RtcAudioScene r104 = new RtcAudioScene("REAL_TIME_CHORUS", 4, "IES_REALTIME_CHORUS");
        REAL_TIME_CHORUS = r104;
        f78713a = new RtcAudioScene[]{r100, r101, r102, r103, r104};
    }

    public static RtcAudioScene valueOf(String r100) {
        return (RtcAudioScene) r27.a.a(RtcAudioScene.class, r100);
    }

    public static RtcAudioScene[] values() {
        return (RtcAudioScene[]) f78713a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public RtcAudioScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
