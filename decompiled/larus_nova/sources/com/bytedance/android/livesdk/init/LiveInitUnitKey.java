package com.bytedance.android.livesdk.init;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "", "(Ljava/lang/String;I)V", "LivePreinitUnit", "LiveBaseinitUnit", "LivePlayerInitUnit", "LiveCommunityInitUnit", "LiveInteractInitUnit", "LiveMultiLinkInitUnit", "LiveOpenPlatformInitUnit", "LiveRevenueInitUnit", "LiveOtherInitUnit", "LiveOtherLazyInitUnit", "LiveBroadcastInitUnit", "LiveCompleteAfterInitUnit", "LivesdkInitUnit", "LiveInitLazyTaskUnit", "LiveInitLazyTaskUnit_V2", "LiveRevenueLazyInitUnit", "LiveInitLiveIOTask", "LiveEnsureLazyUnit", "live-spi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveInitUnitKey extends Enum<LiveInitUnitKey> {
    private static final /* synthetic */ LiveInitUnitKey[] $VALUES = null;
    public static final LiveInitUnitKey LiveBaseinitUnit = null;
    public static final LiveInitUnitKey LiveBroadcastInitUnit = null;
    public static final LiveInitUnitKey LiveCommunityInitUnit = null;
    public static final LiveInitUnitKey LiveCompleteAfterInitUnit = null;
    public static final LiveInitUnitKey LiveEnsureLazyUnit = null;
    public static final LiveInitUnitKey LiveInitLazyTaskUnit = null;
    public static final LiveInitUnitKey LiveInitLazyTaskUnit_V2 = null;
    public static final LiveInitUnitKey LiveInitLiveIOTask = null;
    public static final LiveInitUnitKey LiveInteractInitUnit = null;
    public static final LiveInitUnitKey LiveMultiLinkInitUnit = null;
    public static final LiveInitUnitKey LiveOpenPlatformInitUnit = null;
    public static final LiveInitUnitKey LiveOtherInitUnit = null;
    public static final LiveInitUnitKey LiveOtherLazyInitUnit = null;
    public static final LiveInitUnitKey LivePlayerInitUnit = null;
    public static final LiveInitUnitKey LivePreinitUnit = null;
    public static final LiveInitUnitKey LiveRevenueInitUnit = null;
    public static final LiveInitUnitKey LiveRevenueLazyInitUnit = null;
    public static final LiveInitUnitKey LivesdkInitUnit = null;

    static {
        LiveInitUnitKey r100 = new LiveInitUnitKey("LivePreinitUnit", 0);
        LivePreinitUnit = r100;
        LiveInitUnitKey r101 = new LiveInitUnitKey("LiveBaseinitUnit", 1);
        LiveBaseinitUnit = r101;
        LiveInitUnitKey r102 = new LiveInitUnitKey("LivePlayerInitUnit", 2);
        LivePlayerInitUnit = r102;
        LiveInitUnitKey r103 = new LiveInitUnitKey("LiveCommunityInitUnit", 3);
        LiveCommunityInitUnit = r103;
        LiveInitUnitKey r104 = new LiveInitUnitKey("LiveInteractInitUnit", 4);
        LiveInteractInitUnit = r104;
        LiveInitUnitKey r105 = new LiveInitUnitKey("LiveMultiLinkInitUnit", 5);
        LiveMultiLinkInitUnit = r105;
        LiveInitUnitKey r106 = new LiveInitUnitKey("LiveOpenPlatformInitUnit", 6);
        LiveOpenPlatformInitUnit = r106;
        LiveInitUnitKey r107 = new LiveInitUnitKey("LiveRevenueInitUnit", 7);
        LiveRevenueInitUnit = r107;
        LiveInitUnitKey r108 = new LiveInitUnitKey("LiveOtherInitUnit", 8);
        LiveOtherInitUnit = r108;
        LiveInitUnitKey r109 = new LiveInitUnitKey("LiveOtherLazyInitUnit", 9);
        LiveOtherLazyInitUnit = r109;
        LiveInitUnitKey r110 = new LiveInitUnitKey("LiveBroadcastInitUnit", 10);
        LiveBroadcastInitUnit = r110;
        LiveInitUnitKey r111 = new LiveInitUnitKey("LiveCompleteAfterInitUnit", 11);
        LiveCompleteAfterInitUnit = r111;
        LiveInitUnitKey r112 = new LiveInitUnitKey("LivesdkInitUnit", 12);
        LivesdkInitUnit = r112;
        LiveInitUnitKey r113 = new LiveInitUnitKey("LiveInitLazyTaskUnit", 13);
        LiveInitLazyTaskUnit = r113;
        LiveInitUnitKey r114 = new LiveInitUnitKey("LiveInitLazyTaskUnit_V2", 14);
        LiveInitLazyTaskUnit_V2 = r114;
        LiveInitUnitKey r115 = new LiveInitUnitKey("LiveRevenueLazyInitUnit", 15);
        LiveRevenueLazyInitUnit = r115;
        LiveInitUnitKey r116 = new LiveInitUnitKey("LiveInitLiveIOTask", 16);
        LiveInitLiveIOTask = r116;
        LiveInitUnitKey r117 = new LiveInitUnitKey("LiveEnsureLazyUnit", 17);
        LiveEnsureLazyUnit = r117;
        $VALUES = new LiveInitUnitKey[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117};
    }

    public static LiveInitUnitKey valueOf(String r100) {
        return (LiveInitUnitKey) r27.a.a(LiveInitUnitKey.class, r100);
    }

    public static LiveInitUnitKey[] values() {
        return (LiveInitUnitKey[]) $VALUES.clone();
    }

    private LiveInitUnitKey(String r100, int r101) {
        super(r100, r101);
    }
}
