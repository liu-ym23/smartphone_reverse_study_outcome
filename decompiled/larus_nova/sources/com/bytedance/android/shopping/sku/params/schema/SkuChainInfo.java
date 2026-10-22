package com.bytedance.android.shopping.sku.params.schema;

import com.bytedance.common.wschannel.WsConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/sku/params/schema/SkuChainInfo;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaMapParam;", "()V", "bizCampaignType", "", "getBizCampaignType", "()Ljava/lang/String;", RemoteMessageConst.Notification.CHANNEL_ID, "getChannelId", "channelType", "", "getChannelType", "()Ljava/lang/Integer;", "ecomEntranceForm", "getEcomEntranceForm", "enterFrom", "getEnterFrom", "marketingChannel", "getMarketingChannel", "touTiaoAppId", "getTouTiaoAppId", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuChainInfo extends SkuSchemaMapParam {
    public SkuChainInfo() {
        super("chain_info");
    }

    public final Integer getChannelType() {
        return getInt(WsConstants.KEY_CHANNEL_TYPE);
    }

    public final Integer getTouTiaoAppId() {
        return getInt("toutiao_app_id");
    }

    public final String getBizCampaignType() {
        Object r100 = getMap().get("biz_campaign_type");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getChannelId() {
        Object r100 = getMap().get("channel_id");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getEcomEntranceForm() {
        Object r100 = getMap().get(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM);
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getEnterFrom() {
        Object r100 = getMap().get("enter_from");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final String getMarketingChannel() {
        Object r100 = getMap().get(com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL);
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }
}
