package com.bytedance.android.shopping.api.address;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/api/address/AddressUpdateDialogConfig;", "Ljava/io/Serializable;", "showTimes", "", "maxShowTimes", "(II)V", "getMaxShowTimes", "()I", "getShowTimes", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AddressUpdateDialogConfig implements Serializable {

    @SerializedName("max_show_times")
    private final int maxShowTimes;

    @SerializedName("show_times")
    private final int showTimes;

    public final int getMaxShowTimes() {
        return this.maxShowTimes;
    }

    public final int getShowTimes() {
        return this.showTimes;
    }

    public AddressUpdateDialogConfig(int r100, int r101) {
        this.showTimes = r100;
        this.maxShowTimes = r101;
    }
}
