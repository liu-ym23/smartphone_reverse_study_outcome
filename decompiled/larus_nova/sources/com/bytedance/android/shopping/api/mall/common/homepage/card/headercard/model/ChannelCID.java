package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelCID;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "LIVE_SQUARE", "CYCLE_ACTIVITY", "BRAND", "SUBSIDE", "SECKILL", "CHANNEL_ALL", "Hours", "COIN_CHANNEL", "NEW_COIN_CHANNEL", "DELIVERY", "DAY_DAY_BUY", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ChannelCID extends Enum<ChannelCID> {
    public static final ChannelCID BRAND = null;
    public static final ChannelCID CHANNEL_ALL = null;
    public static final ChannelCID COIN_CHANNEL = null;
    public static final ChannelCID CYCLE_ACTIVITY = null;
    public static final ChannelCID DAY_DAY_BUY = null;
    public static final ChannelCID DELIVERY = null;
    public static final ChannelCID Hours = null;
    public static final ChannelCID LIVE_SQUARE = null;
    public static final ChannelCID NEW_COIN_CHANNEL = null;
    public static final ChannelCID SECKILL = null;
    public static final ChannelCID SUBSIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChannelCID[] f170321a = null;
    private final String value;

    public static ChannelCID valueOf(String r100) {
        return (ChannelCID) a.a(ChannelCID.class, r100);
    }

    public static ChannelCID[] values() {
        return (ChannelCID[]) f170321a.clone();
    }

    static {
        ChannelCID r100 = new ChannelCID("LIVE_SQUARE", 0, "1");
        LIVE_SQUARE = r100;
        ChannelCID r101 = new ChannelCID("CYCLE_ACTIVITY", 1, "1");
        CYCLE_ACTIVITY = r101;
        ChannelCID r102 = new ChannelCID("BRAND", 2, "2");
        BRAND = r102;
        ChannelCID r103 = new ChannelCID("SUBSIDE", 3, "3");
        SUBSIDE = r103;
        ChannelCID r104 = new ChannelCID("SECKILL", 4, "4");
        SECKILL = r104;
        ChannelCID r105 = new ChannelCID("CHANNEL_ALL", 5, "200");
        CHANNEL_ALL = r105;
        ChannelCID r106 = new ChannelCID("Hours", 6, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        Hours = r106;
        ChannelCID r107 = new ChannelCID("COIN_CHANNEL", 7, "33");
        COIN_CHANNEL = r107;
        ChannelCID r108 = new ChannelCID("NEW_COIN_CHANNEL", 8, "35");
        NEW_COIN_CHANNEL = r108;
        ChannelCID r109 = new ChannelCID("DELIVERY", 9, BDLocationException.ERROR_BACKGROUND_LOCATE);
        DELIVERY = r109;
        ChannelCID r110 = new ChannelCID("DAY_DAY_BUY", 10, BDLocationException.ERROR_SDK_NO_PERMISSION);
        DAY_DAY_BUY = r110;
        f170321a = new ChannelCID[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public final String getValue() {
        return this.value;
    }

    public ChannelCID(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
