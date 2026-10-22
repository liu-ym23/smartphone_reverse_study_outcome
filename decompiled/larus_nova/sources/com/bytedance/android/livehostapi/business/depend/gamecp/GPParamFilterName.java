package com.bytedance.android.livehostapi.business.depend.gamecp;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/GPParamFilterName;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BIZ_INFO", "CONTENT_INFO", "TRAFFIC_INFO", "GAME_INFO", "USER_INFO", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GPParamFilterName extends Enum<GPParamFilterName> {
    private static final /* synthetic */ GPParamFilterName[] $VALUES = null;
    public static final GPParamFilterName BIZ_INFO = null;
    public static final GPParamFilterName CONTENT_INFO = null;
    public static final GPParamFilterName GAME_INFO = null;
    public static final GPParamFilterName TRAFFIC_INFO = null;
    public static final GPParamFilterName USER_INFO = null;
    private final String value;

    static {
        GPParamFilterName r100 = new GPParamFilterName("BIZ_INFO", 0, "BizInfo");
        BIZ_INFO = r100;
        GPParamFilterName r101 = new GPParamFilterName("CONTENT_INFO", 1, "ContentInfo");
        CONTENT_INFO = r101;
        GPParamFilterName r102 = new GPParamFilterName("TRAFFIC_INFO", 2, "TrafficInfo");
        TRAFFIC_INFO = r102;
        GPParamFilterName r103 = new GPParamFilterName("GAME_INFO", 3, "GameInfo");
        GAME_INFO = r103;
        GPParamFilterName r104 = new GPParamFilterName("USER_INFO", 4, "UserInfo");
        USER_INFO = r104;
        $VALUES = new GPParamFilterName[]{r100, r101, r102, r103, r104};
    }

    public static GPParamFilterName valueOf(String r100) {
        return (GPParamFilterName) a.a(GPParamFilterName.class, r100);
    }

    public static GPParamFilterName[] values() {
        return (GPParamFilterName[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    private GPParamFilterName(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
