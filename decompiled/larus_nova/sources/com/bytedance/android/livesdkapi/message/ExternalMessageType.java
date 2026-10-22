package com.bytedance.android.livesdkapi.message;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/ExternalMessageType;", "", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "description", "", "(Ljava/lang/String;IIILjava/lang/String;)V", "getMax", "()I", "getMin", "EXTERNAL_COMMERCE", "EXTERNAL_SHOPPING", "EXTERNAL_LIVE_LIFE", "EXTERNAL_LIVE_INTERACTIVITY", "EXTERNAL_LIVE_REVLINK", "EXTERNAL_GAME_PROMOTE", "LYNX_DYNAMIC_MESSAGE", "EXTERNAL_END_ROOM", "EXTERNAL_FORMAT_LIVE", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ExternalMessageType extends Enum<ExternalMessageType> {
    private static final /* synthetic */ ExternalMessageType[] $VALUES = null;
    public static final ExternalMessageType EXTERNAL_COMMERCE = null;
    public static final ExternalMessageType EXTERNAL_END_ROOM = null;
    public static final ExternalMessageType EXTERNAL_FORMAT_LIVE = null;
    public static final ExternalMessageType EXTERNAL_GAME_PROMOTE = null;
    public static final ExternalMessageType EXTERNAL_LIVE_INTERACTIVITY = null;
    public static final ExternalMessageType EXTERNAL_LIVE_LIFE = null;
    public static final ExternalMessageType EXTERNAL_LIVE_REVLINK = null;
    public static final ExternalMessageType EXTERNAL_SHOPPING = null;
    public static final ExternalMessageType LYNX_DYNAMIC_MESSAGE = null;
    private final int max;
    private final int min;

    public static ExternalMessageType valueOf(String r100) {
        return (ExternalMessageType) a.a(ExternalMessageType.class, r100);
    }

    public static ExternalMessageType[] values() {
        return (ExternalMessageType[]) $VALUES.clone();
    }

    static {
        ExternalMessageType r100 = new ExternalMessageType("EXTERNAL_COMMERCE", 0, 2001, 3000, "商业化");
        EXTERNAL_COMMERCE = r100;
        ExternalMessageType r101 = new ExternalMessageType("EXTERNAL_SHOPPING", 1, 1001, 2000, "电商");
        EXTERNAL_SHOPPING = r101;
        ExternalMessageType r102 = new ExternalMessageType("EXTERNAL_LIVE_LIFE", 2, 3001, 4000, "本地生活");
        EXTERNAL_LIVE_LIFE = r102;
        ExternalMessageType r103 = new ExternalMessageType("EXTERNAL_LIVE_INTERACTIVITY", 3, 4001, 5000, "社区互动");
        EXTERNAL_LIVE_INTERACTIVITY = r103;
        ExternalMessageType r104 = new ExternalMessageType("EXTERNAL_LIVE_REVLINK", 4, 5001, 6000, "营收连线");
        EXTERNAL_LIVE_REVLINK = r104;
        ExternalMessageType r105 = new ExternalMessageType("EXTERNAL_GAME_PROMOTE", 5, 6001, 7000, "抖音游戏");
        EXTERNAL_GAME_PROMOTE = r105;
        ExternalMessageType r106 = new ExternalMessageType("LYNX_DYNAMIC_MESSAGE", 6, 7001, 8000, "lynx动态新增消息");
        LYNX_DYNAMIC_MESSAGE = r106;
        ExternalMessageType r107 = new ExternalMessageType("EXTERNAL_END_ROOM", 7, 8001, 9000, "关播页消息");
        EXTERNAL_END_ROOM = r107;
        ExternalMessageType r108 = new ExternalMessageType("EXTERNAL_FORMAT_LIVE", 8, 9001, 10000, "AI实时互动空间");
        EXTERNAL_FORMAT_LIVE = r108;
        $VALUES = new ExternalMessageType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    private ExternalMessageType(String r100, int r101, int r102, int r103, String r104) {
        super(r100, r101);
        this.min = r102;
        this.max = r103;
    }
}
