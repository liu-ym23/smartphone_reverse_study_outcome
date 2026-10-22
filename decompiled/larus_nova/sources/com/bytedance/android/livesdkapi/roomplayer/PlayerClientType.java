package com.bytedance.android.livesdkapi.roomplayer;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/PlayerClientType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", EffectConstants.NORMAL, "FIRST_SHOW", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayerClientType extends Enum<PlayerClientType> {
    private static final /* synthetic */ PlayerClientType[] $VALUES = null;
    public static final PlayerClientType FIRST_SHOW = null;
    public static final PlayerClientType NORMAL = null;
    private final String type;

    static {
        PlayerClientType r100 = new PlayerClientType(EffectConstants.NORMAL, 0, "normal");
        NORMAL = r100;
        PlayerClientType r101 = new PlayerClientType("FIRST_SHOW", 1, "vs_first_show");
        FIRST_SHOW = r101;
        $VALUES = new PlayerClientType[]{r100, r101};
    }

    public static PlayerClientType valueOf(String r100) {
        return (PlayerClientType) a.a(PlayerClientType.class, r100);
    }

    public static PlayerClientType[] values() {
        return (PlayerClientType[]) $VALUES.clone();
    }

    public final String getType() {
        return this.type;
    }

    private PlayerClientType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
