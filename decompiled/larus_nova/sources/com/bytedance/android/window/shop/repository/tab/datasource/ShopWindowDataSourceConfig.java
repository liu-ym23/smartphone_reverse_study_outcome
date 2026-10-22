package com.bytedance.android.window.shop.repository.tab.datasource;

import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import mq3.e;

/* JADX INFO: loaded from: classes14.dex */
public abstract class ShopWindowDataSourceConfig<T extends mq3.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f189428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WindowTabDataListResponseDTODeprecated f189429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WindowHybridTabDataListResponseDTO f189430c;

    public abstract T a();

    public final T b() {
        return (T) this.f189428a.getValue();
    }

    public ShopWindowDataSourceConfig() {
        this.f189428a = LazyKt.lazy(new ShopWindowDataSourceConfig$reqParam$2(this));
    }
}
