package com.bytedance.android.livesdk.livecommerce.promotionlist.model;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/Toggle;", "Ljava/io/Serializable;", "()V", SlcElement.KEY_ELEMENTS, "", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/ToggleElement;", "getElements", "()Ljava/util/List;", "toggleType", "", "getToggleType", "()I", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Toggle implements Serializable {

    @SerializedName(SlcElement.KEY_ELEMENTS)
    private final List<ToggleElement> elements;

    @SerializedName("toggle_type")
    private final int toggleType;

    public Toggle() {
    }

    public final List<ToggleElement> getElements() {
        return this.elements;
    }

    public final int getToggleType() {
        return this.toggleType;
    }
}
