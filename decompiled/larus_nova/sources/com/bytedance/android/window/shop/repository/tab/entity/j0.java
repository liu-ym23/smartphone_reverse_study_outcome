package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.window.base.SyncType;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/j0;", "", "", "notice", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "productCount", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "Lcom/bytedance/android/ec/window/base/SyncType;", "syncType", "Lcom/bytedance/android/ec/window/base/SyncType;", "c", "()Lcom/bytedance/android/ec/window/base/SyncType;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j0 {

    @SerializedName("title")
    private final String notice;

    @SerializedName("product_count")
    private final Integer productCount;

    @SerializedName("type")
    private final SyncType syncType;

    public j0() {
        this.notice = null;
        this.productCount = null;
        this.syncType = null;
    }

    public final String a() {
        return this.notice;
    }

    public final Integer b() {
        return this.productCount;
    }

    public final SyncType c() {
        return this.syncType;
    }
}
