package com.bytedance.ai.bridge.service;

import com.amap.api.services.geocoder.GeocodeSearch;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/service/UserAction;", "", "value", "", "humanStr", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getHumanStr", "SELECT_MAP", "AUTONAVI", "INSTALL_AUTONAVI", "BAIDU", "TENCENT", "CANCEL", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UserAction extends Enum<UserAction> {
    public static final UserAction AUTONAVI = null;
    public static final UserAction BAIDU = null;
    public static final UserAction CANCEL = null;
    public static final UserAction INSTALL_AUTONAVI = null;
    public static final UserAction SELECT_MAP = null;
    public static final UserAction TENCENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserAction[] f36107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f36108b = null;
    private final String humanStr;
    private final String value;

    public static EnumEntries<UserAction> getEntries() {
        return f36108b;
    }

    static {
        UserAction r100 = new UserAction("SELECT_MAP", 0, "selectMap", "选择地图");
        SELECT_MAP = r100;
        UserAction r101 = new UserAction("AUTONAVI", 1, GeocodeSearch.AMAP, "高德地图");
        AUTONAVI = r101;
        UserAction r102 = new UserAction("INSTALL_AUTONAVI", 2, "installAutonavi", "高德地图（未安装）");
        INSTALL_AUTONAVI = r102;
        UserAction r103 = new UserAction("BAIDU", 3, "baidu", "百度地图");
        BAIDU = r103;
        UserAction r104 = new UserAction("TENCENT", 4, "tencent", "腾讯地图");
        TENCENT = r104;
        UserAction r105 = new UserAction("CANCEL", 5, "cancel", "取消");
        CANCEL = r105;
        UserAction[] r106 = {r100, r101, r102, r103, r104, r105};
        f36107a = r106;
        f36108b = EnumEntriesKt.enumEntries(r106);
    }

    public static UserAction[] values() {
        return (UserAction[]) f36107a.clone();
    }

    public final String getHumanStr() {
        return this.humanStr;
    }

    public final String getValue() {
        return this.value;
    }

    public static UserAction valueOf(String r100) {
        return (UserAction) a.a(UserAction.class, r100);
    }

    public UserAction(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.humanStr = r103;
    }
}
