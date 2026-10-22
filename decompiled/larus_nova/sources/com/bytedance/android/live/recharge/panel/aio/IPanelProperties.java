package com.bytedance.android.live.recharge.panel.aio;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;
import vw0.d;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(IPanelPropertiesSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\t\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R*\u0010\u0014\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\t\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R$\u0010\u0018\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\t\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u0019\u0010\u0007R\"\u0010!\u001a\u00020\u001b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\t\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/recharge/panel/aio/IPanelProperties;", "Lvw0/d;", "Lvh7/j;", "", "isRechargeAgreementAccepted", "()Ljava/lang/Boolean;", "setRechargeAgreementAccepted", "(Ljava/lang/Boolean;)V", "isRechargeAgreementAccepted$annotations", "()V", "isCombinedPaySelected", "setCombinedPaySelected", "isCombinedPaySelected$annotations", "", "Lcom/bytedance/android/live/recharge/utils/Fen;", "getCustomPrice", "()Ljava/lang/Long;", "setCustomPrice", "(Ljava/lang/Long;)V", "getCustomPrice$annotations", "customPrice", "isHidePanel", "setHidePanel", "isHidePanel$annotations", "isShowCenterLoading", "setShowCenterLoading", "isShowCenterLoading$annotations", "", "getPanelMode", "()I", "setPanelMode", "(I)V", "getPanelMode$annotations", "panelMode", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.panel.PanelProperties")
public interface IPanelProperties extends d, j<IPanelProperties> {

    @JsonAdapter(IPanelPropertiesSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vw0.d
    @FieldName(name = "custom_price")
    Long getCustomPrice();

    @Override // vw0.d
    @FieldName(name = "panel_mode")
    int getPanelMode();

    @Override // vw0.d
    @FieldName(name = "is_combined_pay_selected")
    Boolean isCombinedPaySelected();

    @Override // vw0.d
    @FieldName(name = "is_hide_panel")
    Boolean isHidePanel();

    @Override // vw0.d
    @FieldName(name = "is_recharge_agreement_accepted")
    Boolean isRechargeAgreementAccepted();

    @Override // vw0.d
    @FieldName(name = "is_show_center_loading")
    Boolean isShowCenterLoading();

    @Override // vw0.d
    @FieldName(name = "is_combined_pay_selected#setter")
    void setCombinedPaySelected(Boolean r100);

    @Override // vw0.d
    @FieldName(name = "custom_price#setter")
    void setCustomPrice(Long r100);

    @Override // vw0.d
    @FieldName(name = "is_hide_panel#setter")
    void setHidePanel(Boolean r100);

    @Override // vw0.d
    @FieldName(name = "panel_mode#setter")
    void setPanelMode(int r100);

    @Override // vw0.d
    @FieldName(name = "is_recharge_agreement_accepted#setter")
    void setRechargeAgreementAccepted(Boolean r100);

    @Override // vw0.d
    @FieldName(name = "is_show_center_loading#setter")
    void setShowCenterLoading(Boolean r100);
}
