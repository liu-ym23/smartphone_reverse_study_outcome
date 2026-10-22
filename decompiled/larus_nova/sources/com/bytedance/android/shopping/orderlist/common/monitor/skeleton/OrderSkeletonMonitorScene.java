package com.bytedance.android.shopping.orderlist.common.monitor.skeleton;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/monitor/skeleton/OrderSkeletonMonitorScene;", "", "", "value", "I", "getValue", "()I", "SCENE_SKELETON_SHOW", "SCENE_LAST_PAGE_LEAVE", "SCENE_LAST_APP_BACKGROUND", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderSkeletonMonitorScene extends Enum<OrderSkeletonMonitorScene> {
    public static final OrderSkeletonMonitorScene SCENE_LAST_APP_BACKGROUND = null;
    public static final OrderSkeletonMonitorScene SCENE_LAST_PAGE_LEAVE = null;
    public static final OrderSkeletonMonitorScene SCENE_SKELETON_SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OrderSkeletonMonitorScene[] f179931a = null;
    private final int value;

    static {
        OrderSkeletonMonitorScene r100 = new OrderSkeletonMonitorScene("SCENE_SKELETON_SHOW", 0, 0);
        SCENE_SKELETON_SHOW = r100;
        OrderSkeletonMonitorScene r101 = new OrderSkeletonMonitorScene("SCENE_LAST_PAGE_LEAVE", 1, 1);
        SCENE_LAST_PAGE_LEAVE = r101;
        OrderSkeletonMonitorScene r102 = new OrderSkeletonMonitorScene("SCENE_LAST_APP_BACKGROUND", 2, 2);
        SCENE_LAST_APP_BACKGROUND = r102;
        f179931a = new OrderSkeletonMonitorScene[]{r100, r101, r102};
    }

    public static OrderSkeletonMonitorScene valueOf(String r100) {
        return (OrderSkeletonMonitorScene) r27.a.a(OrderSkeletonMonitorScene.class, r100);
    }

    public static OrderSkeletonMonitorScene[] values() {
        return (OrderSkeletonMonitorScene[]) f179931a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public OrderSkeletonMonitorScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
