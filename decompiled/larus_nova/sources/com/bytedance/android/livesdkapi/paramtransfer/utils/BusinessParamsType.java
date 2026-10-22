package com.bytedance.android.livesdkapi.paramtransfer.utils;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/paramtransfer/utils/BusinessParamsType;", "", "(Ljava/lang/String;I)V", "ECOM_LIVE_PARAMS", "ROOM_ENTER_PARAMS", "LIVE_EXTRA_PARAMS", "ROOM_ENTER_AD_PARAMS", "LIVE_COMMUNITY_PARAMS", "LOCAL_LIFE_LIVE_PARAMS", "LIVE_GAMECP_PARAMS", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BusinessParamsType extends Enum<BusinessParamsType> {
    private static final /* synthetic */ BusinessParamsType[] $VALUES = null;
    public static final BusinessParamsType ECOM_LIVE_PARAMS = null;
    public static final BusinessParamsType LIVE_COMMUNITY_PARAMS = null;
    public static final BusinessParamsType LIVE_EXTRA_PARAMS = null;
    public static final BusinessParamsType LIVE_GAMECP_PARAMS = null;
    public static final BusinessParamsType LOCAL_LIFE_LIVE_PARAMS = null;
    public static final BusinessParamsType ROOM_ENTER_AD_PARAMS = null;
    public static final BusinessParamsType ROOM_ENTER_PARAMS = null;

    static {
        BusinessParamsType r100 = new BusinessParamsType("ECOM_LIVE_PARAMS", 0);
        ECOM_LIVE_PARAMS = r100;
        BusinessParamsType r101 = new BusinessParamsType("ROOM_ENTER_PARAMS", 1);
        ROOM_ENTER_PARAMS = r101;
        BusinessParamsType r102 = new BusinessParamsType("LIVE_EXTRA_PARAMS", 2);
        LIVE_EXTRA_PARAMS = r102;
        BusinessParamsType r103 = new BusinessParamsType("ROOM_ENTER_AD_PARAMS", 3);
        ROOM_ENTER_AD_PARAMS = r103;
        BusinessParamsType r104 = new BusinessParamsType("LIVE_COMMUNITY_PARAMS", 4);
        LIVE_COMMUNITY_PARAMS = r104;
        BusinessParamsType r105 = new BusinessParamsType("LOCAL_LIFE_LIVE_PARAMS", 5);
        LOCAL_LIFE_LIVE_PARAMS = r105;
        BusinessParamsType r106 = new BusinessParamsType("LIVE_GAMECP_PARAMS", 6);
        LIVE_GAMECP_PARAMS = r106;
        $VALUES = new BusinessParamsType[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static BusinessParamsType valueOf(String r100) {
        return (BusinessParamsType) a.a(BusinessParamsType.class, r100);
    }

    public static BusinessParamsType[] values() {
        return (BusinessParamsType[]) $VALUES.clone();
    }

    private BusinessParamsType(String r100, int r101) {
        super(r100, r101);
    }
}
