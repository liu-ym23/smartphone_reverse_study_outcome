package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/model/BusinessToolType;", "", "Coupon", "PrivateMsg", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BusinessToolType extends Enum<BusinessToolType> {
    public static final BusinessToolType Coupon = null;
    public static final BusinessToolType PrivateMsg = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BusinessToolType[] f84699a = null;

    static {
        BusinessToolType r100 = new BusinessToolType("Coupon", 0);
        Coupon = r100;
        BusinessToolType r101 = new BusinessToolType("PrivateMsg", 1);
        PrivateMsg = r101;
        f84699a = new BusinessToolType[]{r100, r101};
    }

    public static BusinessToolType valueOf(String r100) {
        return (BusinessToolType) a.a(BusinessToolType.class, r100);
    }

    public static BusinessToolType[] values() {
        return (BusinessToolType[]) f84699a.clone();
    }

    public BusinessToolType(String r100, int r101) {
        super(r100, r101);
    }
}
