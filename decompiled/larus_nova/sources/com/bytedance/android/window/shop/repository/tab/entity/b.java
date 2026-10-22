package com.bytedance.android.window.shop.repository.tab.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/b;", "", "Lcom/bytedance/android/window/shop/repository/tab/entity/c;", "prefix", "Lcom/bytedance/android/window/shop/repository/tab/entity/c;", "b", "()Lcom/bytedance/android/window/shop/repository/tab/entity/c;", "title", "d", "suffix", "c", "", "backgroundColor", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("bg_color")
    private final String backgroundColor;

    @SerializedName("prefix")
    private final c prefix;

    @SerializedName("suffix")
    private final c suffix;

    @SerializedName("title")
    private final c title;

    public final String a() {
        return this.backgroundColor;
    }

    public final c b() {
        return this.prefix;
    }

    public final c c() {
        return this.suffix;
    }

    public final c d() {
        return this.title;
    }
}
