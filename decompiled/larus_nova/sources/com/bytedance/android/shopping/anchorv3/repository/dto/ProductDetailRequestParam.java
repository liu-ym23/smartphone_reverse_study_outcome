package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000eR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/ProductDetailRequestParam;", "Ljava/io/Serializable;", "promotionId", "", "enterFrom", "metaParam", "imageConstraintsMap", "", "tagGuaranteeHeader", "pdpNewEdition", "", "isShortScreen", RemoteMessageConst.Notification.CHANNEL_ID, "channelType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Integer;)V", "getChannelId", "()Ljava/lang/String;", "getChannelType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnterFrom", "getImageConstraintsMap", "()Ljava/util/Map;", "()I", "getMetaParam", "getPdpNewEdition", "getPromotionId", "getTagGuaranteeHeader", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductDetailRequestParam implements Serializable {
    private final String channelId;
    private final Integer channelType;
    private final String enterFrom;
    private final Map<String, String> imageConstraintsMap;
    private final int isShortScreen;
    private final String metaParam;
    private final int pdpNewEdition;
    private final String promotionId;
    private final String tagGuaranteeHeader;

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getChannelType() {
        return this.channelType;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final Map<String, String> getImageConstraintsMap() {
        return this.imageConstraintsMap;
    }

    public final String getMetaParam() {
        return this.metaParam;
    }

    public final int getPdpNewEdition() {
        return this.pdpNewEdition;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getTagGuaranteeHeader() {
        return this.tagGuaranteeHeader;
    }

    public final int isShortScreen() {
        return this.isShortScreen;
    }

    public ProductDetailRequestParam(String r100, String r101, String r102, Map<String, String> r103, String r104, int r105, int r106, String r107, Integer r110) {
        Intrinsics.checkNotNullParameter(r100, "promotionId");
        Intrinsics.checkNotNullParameter(r104, "tagGuaranteeHeader");
        this.promotionId = r100;
        this.enterFrom = r101;
        this.metaParam = r102;
        this.imageConstraintsMap = r103;
        this.tagGuaranteeHeader = r104;
        this.pdpNewEdition = r105;
        this.isShortScreen = r106;
        this.channelId = r107;
        this.channelType = r110;
    }

    public /* synthetic */ ProductDetailRequestParam(String r110, String r111, String r112, Map r113, String r114, int r115, int r210, String r211, Integer r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r213 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r213 & 8) == 0) goto L13;
        Map r102 = null;
    L15:
        if ((r213 & 32) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r213 & 64) == 0) goto L21;
        int r116 = 0;
    L23:
        if ((r213 & 128) == 0) goto L25;
        String r117 = null;
    L27:
        if ((r213 & 256) == 0) goto L29;
        Integer r118 = 0;
    L30:
        this(r110, r100, r101, r102, r114, r103, r116, r117, r118);
        return;
    L29:
        r118 = r212;
        goto L30
    L25:
        r117 = r211;
        goto L27
    L21:
        r116 = r210;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
