package com.bytedance.android.gamecp.business;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/gamecp/business/GamePlatformV2Type;", "", "", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "MOBILE_GAME", "PC_GAME", "MINI_GAME", "PAGE_GAME", "CLOUD_PLAY", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GamePlatformV2Type extends Enum<GamePlatformV2Type> {
    public static final GamePlatformV2Type CLOUD_PLAY = null;
    public static final a Companion = null;
    public static final GamePlatformV2Type MINI_GAME = null;
    public static final GamePlatformV2Type MOBILE_GAME = null;
    public static final GamePlatformV2Type PAGE_GAME = null;
    public static final GamePlatformV2Type PC_GAME = null;
    public static final GamePlatformV2Type UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GamePlatformV2Type[] f51750a = null;
    private final int type;

    public static final class a {
        public a() {
        }

        public static boolean a(Integer r100) {
            GamePlatformV2Type[] r101 = GamePlatformV2Type.values();
            int r102 = r101.length;
            int r103 = 0;
        L4:
            if (r103 >= r102) goto L15;
            GamePlatformV2Type r104 = r101[r103];
            int r105 = r104.getType();
            if (r100 != null) goto L9;
        L11:
            boolean r106 = false;
        L12:
            if (r106 == true) goto L16;
            r103 = r103 + 1;
        L16:
            if (r104 != null) goto L19;
            r104 = GamePlatformV2Type.UNKNOWN;
        L19:
            if (r104 != GamePlatformV2Type.PC_GAME) goto L24;
            return true;
        L24:
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
        GamePlatformV2Type r100 = new GamePlatformV2Type("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        GamePlatformV2Type r101 = new GamePlatformV2Type("MOBILE_GAME", 1, 1);
        MOBILE_GAME = r101;
        GamePlatformV2Type r102 = new GamePlatformV2Type("PC_GAME", 2, 2);
        PC_GAME = r102;
        GamePlatformV2Type r103 = new GamePlatformV2Type("MINI_GAME", 3, 3);
        MINI_GAME = r103;
        GamePlatformV2Type r104 = new GamePlatformV2Type("PAGE_GAME", 4, 4);
        PAGE_GAME = r104;
        GamePlatformV2Type r105 = new GamePlatformV2Type("CLOUD_PLAY", 5, 5);
        CLOUD_PLAY = r105;
        f51750a = new GamePlatformV2Type[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public static GamePlatformV2Type valueOf(String r100) {
        return (GamePlatformV2Type) r27.a.a(GamePlatformV2Type.class, r100);
    }

    public static GamePlatformV2Type[] values() {
        return (GamePlatformV2Type[]) f51750a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public GamePlatformV2Type(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
