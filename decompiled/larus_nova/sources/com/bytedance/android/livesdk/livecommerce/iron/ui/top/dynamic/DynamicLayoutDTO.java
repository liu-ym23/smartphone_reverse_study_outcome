package com.bytedance.android.livesdk.livecommerce.iron.ui.top.dynamic;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/top/dynamic/DynamicLayoutDTO;", "Ljava/io/Serializable;", "()V", "layoutParams", "", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/top/dynamic/DynamicLayoutParams;", "getLayoutParams", "()Ljava/util/List;", "layoutType", "", "getLayoutType", "()Ljava/lang/String;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DynamicLayoutDTO implements Serializable {

    @SerializedName("layout_params")
    private final List<DynamicLayoutParams> layoutParams;

    @SerializedName("layout_type")
    private final String layoutType;

    public DynamicLayoutDTO() {
    }

    public final List<DynamicLayoutParams> getLayoutParams() {
        return this.layoutParams;
    }

    public final String getLayoutType() {
        return this.layoutType;
    }
}
