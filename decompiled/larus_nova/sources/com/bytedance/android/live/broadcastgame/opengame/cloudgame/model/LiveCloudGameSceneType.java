package com.bytedance.android.live.broadcastgame.opengame.cloudgame.model;

import com.bytedance.android.live.broadcastgame.opengame.openapi.OpenCloudGameMethod;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/cloudgame/model/LiveCloudGameSceneType;", "", "", "isUnLimited", "Z", "()Z", "", "extra2Game", "Ljava/lang/String;", "getExtra2Game", "()Ljava/lang/String;", "", "scene", "I", "getScene", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "TIME_UNLIMITED", "TIME_LIMITED", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveCloudGameSceneType extends Enum<LiveCloudGameSceneType> {
    public static final a Companion = null;
    public static final LiveCloudGameSceneType TIME_LIMITED = null;
    public static final LiveCloudGameSceneType TIME_UNLIMITED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveCloudGameSceneType[] f59838a = null;
    private final String extra2Game;
    private final boolean isUnLimited;
    private final int scene;

    public static final class a {
        public a() {
        }

        public static LiveCloudGameSceneType a(OpenCloudGameMethod r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "$this$getSceneTypeByOpenApi");
            LiveCloudGameSceneType[] r102 = LiveCloudGameSceneType.values();
            int r103 = r102.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L11;
            LiveCloudGameSceneType r105 = r102[r104];
            if (r105.isUnLimited() != r101) goto L7;
            boolean r106 = true;
        L8:
            if (r106 == true) goto L12;
            r104 = r104 + 1;
        L12:
            if (r105 == null) goto L14;
            return r105;
        L14:
            return LiveCloudGameSceneType.TIME_UNLIMITED;
        L7:
            r106 = false;
            goto L8
        L11:
            r105 = null;
            goto L12
        }
    }

    static {
        LiveCloudGameSceneType r100 = new LiveCloudGameSceneType("TIME_UNLIMITED", 0, true, "1", 1);
        TIME_UNLIMITED = r100;
        LiveCloudGameSceneType r101 = new LiveCloudGameSceneType("TIME_LIMITED", 1, false, "0", 2);
        TIME_LIMITED = r101;
        f59838a = new LiveCloudGameSceneType[]{r100, r101};
        Companion = new a();
    }

    public static LiveCloudGameSceneType valueOf(String r100) {
        return (LiveCloudGameSceneType) r27.a.a(LiveCloudGameSceneType.class, r100);
    }

    public static LiveCloudGameSceneType[] values() {
        return (LiveCloudGameSceneType[]) f59838a.clone();
    }

    public final String getExtra2Game() {
        return this.extra2Game;
    }

    public final int getScene() {
        return this.scene;
    }

    public final boolean isUnLimited() {
        return this.isUnLimited;
    }

    public LiveCloudGameSceneType(String r100, int r101, boolean r102, String r103, int r104) {
        super(r100, r101);
        this.isUnLimited = r102;
        this.extra2Game = r103;
        this.scene = r104;
    }
}
