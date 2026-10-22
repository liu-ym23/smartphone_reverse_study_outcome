package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/mallSessionmonitor/ECStageTriggerSource;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "GENERAL", "PUZZLE_LIFECYCLE_DELIVERY", "SECONDARY_PAGE_LIFECYCLE_DELIVERY", "SECONDARY_PAGE_LIFECYCLE_GENERAL", "NATIVE_LIFECYCLE_DELIVERY", "TABKIT_LIFECYCLE_DELIVERY", "NATIVE_LIFECYCLE_GENERAL", "MALL_DELIVERYRECORD_BRIDGE", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECStageTriggerSource extends Enum<ECStageTriggerSource> {
    public static final ECStageTriggerSource GENERAL = null;
    public static final ECStageTriggerSource MALL_DELIVERYRECORD_BRIDGE = null;
    public static final ECStageTriggerSource NATIVE_LIFECYCLE_DELIVERY = null;
    public static final ECStageTriggerSource NATIVE_LIFECYCLE_GENERAL = null;
    public static final ECStageTriggerSource PUZZLE_LIFECYCLE_DELIVERY = null;
    public static final ECStageTriggerSource SECONDARY_PAGE_LIFECYCLE_DELIVERY = null;
    public static final ECStageTriggerSource SECONDARY_PAGE_LIFECYCLE_GENERAL = null;
    public static final ECStageTriggerSource TABKIT_LIFECYCLE_DELIVERY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECStageTriggerSource[] f170337a = null;
    private final String type;

    public static ECStageTriggerSource valueOf(String r100) {
        return (ECStageTriggerSource) r27.a.a(ECStageTriggerSource.class, r100);
    }

    public static ECStageTriggerSource[] values() {
        return (ECStageTriggerSource[]) f170337a.clone();
    }

    static {
        ECStageTriggerSource r100 = new ECStageTriggerSource("GENERAL", 0, "general");
        GENERAL = r100;
        ECStageTriggerSource r101 = new ECStageTriggerSource("PUZZLE_LIFECYCLE_DELIVERY", 1, "puzzle_lifecycle_delivery");
        PUZZLE_LIFECYCLE_DELIVERY = r101;
        ECStageTriggerSource r102 = new ECStageTriggerSource("SECONDARY_PAGE_LIFECYCLE_DELIVERY", 2, "secondaryPage_lifecycle_delivery");
        SECONDARY_PAGE_LIFECYCLE_DELIVERY = r102;
        ECStageTriggerSource r103 = new ECStageTriggerSource("SECONDARY_PAGE_LIFECYCLE_GENERAL", 3, "secondaryPage_lifecycle_general");
        SECONDARY_PAGE_LIFECYCLE_GENERAL = r103;
        ECStageTriggerSource r104 = new ECStageTriggerSource("NATIVE_LIFECYCLE_DELIVERY", 4, "native_lifecycle_delivery");
        NATIVE_LIFECYCLE_DELIVERY = r104;
        ECStageTriggerSource r105 = new ECStageTriggerSource("TABKIT_LIFECYCLE_DELIVERY", 5, "tabkit_lifecycle_delivery");
        TABKIT_LIFECYCLE_DELIVERY = r105;
        ECStageTriggerSource r106 = new ECStageTriggerSource("NATIVE_LIFECYCLE_GENERAL", 6, "native_lifecycle_general");
        NATIVE_LIFECYCLE_GENERAL = r106;
        ECStageTriggerSource r107 = new ECStageTriggerSource("MALL_DELIVERYRECORD_BRIDGE", 7, "mall_deliveryRecord_bridge");
        MALL_DELIVERYRECORD_BRIDGE = r107;
        f170337a = new ECStageTriggerSource[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final String getType() {
        return this.type;
    }

    public ECStageTriggerSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
