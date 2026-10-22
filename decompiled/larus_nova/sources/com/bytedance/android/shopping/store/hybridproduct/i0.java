package com.bytedance.android.shopping.store.hybridproduct;

import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/i0;", "", "", "layoutType", "I", "getLayoutType", "()I", "", UserInfo.UPDATE_TIME, "J", "getUpdateTime", "()J", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i0 {

    @SerializedName("layout_type")
    private final int layoutType;

    @SerializedName("update_time")
    private final long updateTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i0) == false) goto L10;
        i0 r101 = (i0) r100;
        if (this.layoutType == r101.layoutType) goto L8;
        return false;
    L8:
        if (this.updateTime == r101.updateTime) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.layoutType * 31;
        long r101 = this.updateTime;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "LayoutConfig(layoutType=" + this.layoutType + ", updateTime=" + this.updateTime + ")";
    }
}
