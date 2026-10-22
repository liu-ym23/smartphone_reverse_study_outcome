package com.bytedance.android.livesdkapi.distribution.config;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/config/ShieldMode;", "", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "BLACK", "WHITE", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShieldMode extends Enum<ShieldMode> {
    private static final /* synthetic */ ShieldMode[] $VALUES = null;
    public static final ShieldMode BLACK = null;
    public static final ShieldMode NONE = null;
    public static final ShieldMode WHITE = null;

    static {
        ShieldMode r100 = new ShieldMode(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        ShieldMode r101 = new ShieldMode("BLACK", 1);
        BLACK = r101;
        ShieldMode r102 = new ShieldMode("WHITE", 2);
        WHITE = r102;
        $VALUES = new ShieldMode[]{r100, r101, r102};
    }

    public static ShieldMode valueOf(String r100) {
        return (ShieldMode) a.a(ShieldMode.class, r100);
    }

    public static ShieldMode[] values() {
        return (ShieldMode[]) $VALUES.clone();
    }

    private ShieldMode(String r100, int r101) {
        super(r100, r101);
    }
}
