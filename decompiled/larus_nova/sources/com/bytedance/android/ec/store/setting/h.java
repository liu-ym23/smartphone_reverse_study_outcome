package com.bytedance.android.ec.store.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/store/setting/h;", "", "", "loadMoreRangeSize", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("load_more_range_size")
    private final int loadMoreRangeSize;

    public h() {
        this(0);
    }

    public final int a() {
        return this.loadMoreRangeSize;
    }

    public h(int r100) {
        this.loadMoreRangeSize = r100;
    }
}
