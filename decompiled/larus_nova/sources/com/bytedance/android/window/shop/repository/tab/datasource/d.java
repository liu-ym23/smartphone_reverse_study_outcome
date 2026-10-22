package com.bytedance.android.window.shop.repository.tab.datasource;

import com.bytedance.android.window.shop.repository.api.WindowProductTabRequestParamDeprecated;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends ShopWindowDataSourceConfig<WindowProductTabRequestParamDeprecated> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WindowLayoutType f189432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f189433e;

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowDataSourceConfig
    public final mq3.e a() {
        return new WindowProductTabRequestParamDeprecated();
    }

    public d() {
        this.f189433e = true;
    }
}
