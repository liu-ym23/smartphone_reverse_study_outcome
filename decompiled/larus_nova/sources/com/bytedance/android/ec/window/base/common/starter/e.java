package com.bytedance.android.ec.window.base.common.starter;

import com.bytedance.android.ec.window.base.common.datachannel.ECWindowProductForm;
import com.bytedance.android.ec.window.base.common.datachannel.ECWindowSourceMethod;
import com.bytedance.android.ec.window.base.common.datachannel.ECWindowStoreType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECWindowStoreType f49153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECWindowSourceMethod f49154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f49155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f49156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ECWindowProductForm f49157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f49158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f49159g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f49160h;

    public e(ECWindowStoreType r100, ECWindowSourceMethod r101, ECWindowProductForm r102, String r103, String r104, Map r105) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE);
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD);
        Intrinsics.checkNotNullParameter("store_page", "page_name");
        Intrinsics.checkNotNullParameter("product_card", com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE);
        Intrinsics.checkNotNullParameter(r102, "product_form");
        Intrinsics.checkNotNullParameter(r103, "kolId");
        Intrinsics.checkNotNullParameter(r104, "secKolId");
        this.f49153a = r100;
        this.f49154b = r101;
        this.f49155c = "store_page";
        this.f49156d = "product_card";
        this.f49157e = r102;
        this.f49158f = r103;
        this.f49159g = r104;
        this.f49160h = r105;
    }
}
