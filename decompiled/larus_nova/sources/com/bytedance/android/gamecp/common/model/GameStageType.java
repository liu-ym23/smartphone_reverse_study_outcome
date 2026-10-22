package com.bytedance.android.gamecp.common.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/gamecp/common/model/GameStageType;", "", "", "toTrackString", "", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, UserProfileEvent.POSITION_NONE, "RESERVATION", FlowDoraWifiScene.TEST, HttpMethod.DOWNLOAD, "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameStageType extends Enum<GameStageType> {
    public static final a Companion = null;
    public static final GameStageType DOWNLOAD = null;
    public static final GameStageType NONE = null;
    public static final GameStageType RESERVATION = null;
    public static final GameStageType TEST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GameStageType[] f56531a = null;
    private final int type;

    public static final class a {
        public a() {
        }

        public static GameStageType a(Integer r100) {
            GameStageType[] r101 = GameStageType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L14;
            GameStageType r104 = r101[r103];
            int r105 = r104.getType();
            if (r100 != null) goto L8;
        L10:
            boolean r106 = false;
        L11:
            if (r106 == true) goto L15;
            r103 = r103 + 1;
        L15:
            if (r104 == null) goto L17;
            return r104;
        L17:
            return GameStageType.NONE;
        L8:
            if (r105 != r100.intValue()) goto L10;
            r106 = true;
            goto L11
        L14:
            r104 = null;
            goto L15
        }
    }

    static {
        GameStageType r100 = new GameStageType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        GameStageType r101 = new GameStageType("RESERVATION", 1, 10);
        RESERVATION = r101;
        GameStageType r102 = new GameStageType(FlowDoraWifiScene.TEST, 2, 20);
        TEST = r102;
        GameStageType r103 = new GameStageType(HttpMethod.DOWNLOAD, 3, 30);
        DOWNLOAD = r103;
        f56531a = new GameStageType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static GameStageType valueOf(String r100) {
        return (GameStageType) r27.a.a(GameStageType.class, r100);
    }

    public static GameStageType[] values() {
        return (GameStageType[]) f56531a.clone();
    }

    public final String toTrackString() {
        if (c.f56534a[ordinal()] == 1) goto L5;
        return "download_page";
    L5:
        return "book_page";
    }

    public final int getType() {
        return this.type;
    }

    public GameStageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
