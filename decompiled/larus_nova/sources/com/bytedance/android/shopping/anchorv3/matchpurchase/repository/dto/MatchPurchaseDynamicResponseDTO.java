package com.bytedance.android.shopping.anchorv3.matchpurchase.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.shopping.threed.repository.dto.BuyButtonComponent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/repository/dto/MatchPurchaseDynamicResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "()V", "component", "Lcom/bytedance/android/shopping/threed/repository/dto/BuyButtonComponent;", "getComponent", "()Lcom/bytedance/android/shopping/threed/repository/dto/BuyButtonComponent;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchPurchaseDynamicResponseDTO extends CommerceBaseResponse {

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    @SerializedName("buy_button_component")
    private final BuyButtonComponent f165181component;

    public MatchPurchaseDynamicResponseDTO() {
    }

    public final BuyButtonComponent getComponent() {
        return this.f165181component;
    }
}
