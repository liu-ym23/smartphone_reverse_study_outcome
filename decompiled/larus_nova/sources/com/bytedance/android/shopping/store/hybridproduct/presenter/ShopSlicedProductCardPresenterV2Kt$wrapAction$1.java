package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"com/bytedance/android/shopping/store/hybridproduct/presenter/ShopSlicedProductCardPresenterV2Kt$wrapAction$1", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "", "getDisable", "()Z", "disable", "", "getExposureThreshold", "()F", "exposureThreshold", "", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getScrollCallbackThreshold", "()J", "scrollCallbackThreshold", "getType", "()Ljava/lang/String;", "type", "", "getActions", "()Ljava/util/List;", SlcCommonAction.KEY_ACTIONS, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSlicedProductCardPresenterV2Kt$wrapAction$1 implements IAction {
    final /* synthetic */ List $actions;
    final /* synthetic */ IAction $origin;
    final /* synthetic */ Map $wrapperParams;

    @Override // com.bytedance.android.ecom.arch.slice.action.IAction
    public boolean getDisable() {
        return this.$origin.getDisable();
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.IAction
    public float getExposureThreshold() {
        return this.$origin.getExposureThreshold();
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.IAction
    public long getScrollCallbackThreshold() {
        return this.$origin.getScrollCallbackThreshold();
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.IAction
    public String getType() {
        return this.$origin.getType();
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.IAction
    public List<IAction> getActions() {
        return this.$actions;
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.IAction
    public Map<String, Object> getParams() {
        return this.$wrapperParams;
    }

    public ShopSlicedProductCardPresenterV2Kt$wrapAction$1(IAction r100, Map r101, List r102) {
        this.$origin = r100;
        this.$wrapperParams = r101;
        this.$actions = r102;
    }
}
