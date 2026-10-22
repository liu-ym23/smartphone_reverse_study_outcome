package com.bytedance.android.ec.window.base.common.starter;

import com.bytedance.android.ec.window.base.common.datachannel.ECWindowSourceMethod;
import com.bytedance.android.ec.window.base.common.datachannel.ECWindowStoreType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECWindowStoreType f49161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECWindowSourceMethod f49162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f49163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f49164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f49165e;

    public g(ECWindowStoreType r100, ECWindowSourceMethod r101) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE);
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD);
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_REPlAY_POPUP_CARD, "carrier_type");
        Intrinsics.checkNotNullParameter("store_page_temai_live_store_video_card", "source_page");
        Intrinsics.checkNotNullParameter("live", com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE);
        this.f49161a = r100;
        this.f49162b = r101;
        this.f49163c = com.bytedance.android.ec.core.event.a.VALUE_REPlAY_POPUP_CARD;
        this.f49164d = "store_page_temai_live_store_video_card";
        this.f49165e = "live";
    }
}
