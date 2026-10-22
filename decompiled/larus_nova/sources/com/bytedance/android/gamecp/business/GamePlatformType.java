package com.bytedance.android.gamecp.business;

import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/gamecp/business/GamePlatformType;", "", "", "toTrackString", "", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "MOBILE_GAME", "MINI_GAME", "MINI_PLAY", "CLOUD_PLAY", "PC_GAME", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GamePlatformType extends Enum<GamePlatformType> {
    public static final GamePlatformType CLOUD_PLAY = null;
    public static final a Companion = null;
    public static final GamePlatformType MINI_GAME = null;
    public static final GamePlatformType MINI_PLAY = null;
    public static final GamePlatformType MOBILE_GAME = null;
    public static final GamePlatformType PC_GAME = null;
    public static final GamePlatformType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GamePlatformType[] f51749a = null;
    private final int type;

    public static final class a {
        public a() {
        }

        public static GamePlatformType a(Long r110) {
            GamePlatformType[] r100 = GamePlatformType.values();
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L14;
            GamePlatformType r103 = r100[r102];
            long r104 = r103.getType();
            if (r110 != null) goto L8;
        L10:
            boolean r105 = false;
        L11:
            if (r105 == true) goto L15;
            r102 = r102 + 1;
        L15:
            if (r103 == null) goto L17;
            return r103;
        L17:
            return GamePlatformType.UNKNOWN;
        L8:
            if (r104 != r110.longValue()) goto L10;
            r105 = true;
            goto L11
        L14:
            r103 = null;
            goto L15
        }

        public static boolean b(Integer r100) {
            GamePlatformType[] r101 = GamePlatformType.values();
            int r102 = r101.length;
            int r103 = 0;
        L4:
            if (r103 >= r102) goto L15;
            GamePlatformType r104 = r101[r103];
            int r105 = r104.getType();
            if (r100 != null) goto L9;
        L11:
            boolean r106 = false;
        L12:
            if (r106 == true) goto L16;
            r103 = r103 + 1;
        L16:
            if (r104 != null) goto L19;
            r104 = GamePlatformType.UNKNOWN;
        L19:
            if (r104 != GamePlatformType.MINI_GAME) goto L21;
        L22:
            return true;
        L21:
            if (r104 == GamePlatformType.MINI_PLAY) goto L22;
            return false;
        L9:
            if (r105 != r100.intValue()) goto L11;
            r106 = true;
            goto L12
        L15:
            r104 = null;
            goto L16
        }
    }

    static {
        GamePlatformType r100 = new GamePlatformType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        GamePlatformType r101 = new GamePlatformType("MOBILE_GAME", 1, 1);
        MOBILE_GAME = r101;
        GamePlatformType r102 = new GamePlatformType("MINI_GAME", 2, 2);
        MINI_GAME = r102;
        GamePlatformType r103 = new GamePlatformType("MINI_PLAY", 3, 3);
        MINI_PLAY = r103;
        GamePlatformType r104 = new GamePlatformType("CLOUD_PLAY", 4, 4);
        CLOUD_PLAY = r104;
        GamePlatformType r105 = new GamePlatformType("PC_GAME", 5, 5);
        PC_GAME = r105;
        f51749a = new GamePlatformType[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public static GamePlatformType valueOf(String r100) {
        return (GamePlatformType) r27.a.a(GamePlatformType.class, r100);
    }

    public static GamePlatformType[] values() {
        return (GamePlatformType[]) f51749a.clone();
    }

    public final String toTrackString() {
        int r100 = x.f56506a[ordinal()];
        if (r100 != 1) goto L5;
        return "app";
    L5:
        if (r100 != 2) goto L7;
        return "mini";
    L7:
        if (r100 != 3) goto L9;
        return "mini_play";
    L9:
        if (r100 != 4) goto L18;
        return BackupSeiMessage.SOURCE_PC;
    L18:
        return "app";
    }

    public final int getType() {
        return this.type;
    }

    public GamePlatformType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
