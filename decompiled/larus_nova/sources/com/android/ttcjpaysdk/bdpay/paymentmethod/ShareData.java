package com.android.ttcjpaysdk.bdpay.paymentmethod;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.service.ICJPayPaymentMethodService;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayPayTypeInfo;
import com.android.ttcjpaysdk.thirdparty.data.FrontPreTradeInfo;
import com.android.ttcjpaysdk.thirdparty.data.FrontSubPayTypeInfo;
import com.android.ttcjpaysdk.thirdparty.data.FrontSubPayTypeSumInfo;
import com.android.ttcjpaysdk.thirdparty.data.PreTradeInfo;
import com.android.ttcjpaysdk.thirdparty.data.SubPayTypeGroupInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010B\u001a\u00020CJ\u0010\u0010D\u001a\u0004\u0018\u00010\u001b2\u0006\u0010E\u001a\u00020\u0004J\b\u0010F\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010G\u001a\u00020HJ\u0006\u00100\u001a\u00020\rJ\u0006\u0010I\u001a\u00020CJ\u0006\u0010J\u001a\u00020CJ\u000e\u0010K\u001a\u00020C2\u0006\u0010L\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R.\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010&j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006M"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/paymentmethod/ShareData;", "", "()V", "HEIGHT", "", "ISCOMBINEPAY", "START_HEIGHT", "STD_ASSET_ID", "STD_LIMIT_ASSET_ID", "STD_PAGE_TITLE", "STD_SUBASSET_ASSET_ID", "collapseMap", "", "", "getCollapseMap", "()Ljava/util/Map;", "setCollapseMap", "(Ljava/util/Map;)V", "combineCardId", "getCombineCardId", "()Ljava/lang/String;", "setCombineCardId", "(Ljava/lang/String;)V", "combineType", "getCombineType", "setCombineType", "firstAvailableCard", "Lcom/android/ttcjpaysdk/thirdparty/data/FrontSubPayTypeInfo;", "firstSelectedGroupInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/SubPayTypeGroupInfo;", "firstSelectedPayTypeInfo", "frontPreTradeInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/FrontPreTradeInfo;", "getFrontPreTradeInfo", "()Lcom/android/ttcjpaysdk/thirdparty/data/FrontPreTradeInfo;", "setFrontPreTradeInfo", "(Lcom/android/ttcjpaysdk/thirdparty/data/FrontPreTradeInfo;)V", "insufficientCardIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getInsufficientCardIds", "()Ljava/util/ArrayList;", "setInsufficientCardIds", "(Ljava/util/ArrayList;)V", "isExpanded", "()Z", "setExpanded", "(Z)V", "isNeedAfresh", "outParams", "Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$OutParams;", "getOutParams", "()Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$OutParams;", "setOutParams", "(Lcom/android/ttcjpaysdk/base/service/ICJPayPaymentMethodService$OutParams;)V", "selectedPayInfo", "getSelectedPayInfo", "()Lcom/android/ttcjpaysdk/thirdparty/data/FrontSubPayTypeInfo;", "setSelectedPayInfo", "(Lcom/android/ttcjpaysdk/thirdparty/data/FrontSubPayTypeInfo;)V", "to_combine_asset_index", "", "getTo_combine_asset_index", "()I", "setTo_combine_asset_index", "(I)V", "adapterPreTradeInfo", "", "getCombineSubPayTypeInfo", "subPayType", "getFirstAvailableCard", "getPayInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;", "release", "releaseCallbacks", "setNeedAfresh", "need", "bdpay-paymentmethod_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShareData {
    public static final String HEIGHT = "height";
    public static final ShareData INSTANCE = null;
    public static final String ISCOMBINEPAY = "isCombinePay";
    public static final String START_HEIGHT = "startHeight";
    public static final String STD_ASSET_ID = "std_asset_id";
    public static final String STD_LIMIT_ASSET_ID = "std_limit_asset_id";
    public static final String STD_PAGE_TITLE = "std_page_title";
    public static final String STD_SUBASSET_ASSET_ID = "std_subAsset_asset_id";
    private static Map<String, Boolean> collapseMap;
    private static String combineCardId;
    private static String combineType;
    private static FrontSubPayTypeInfo firstAvailableCard;
    private static SubPayTypeGroupInfo firstSelectedGroupInfo;
    private static FrontSubPayTypeInfo firstSelectedPayTypeInfo;
    private static FrontPreTradeInfo frontPreTradeInfo;
    private static ArrayList<String> insufficientCardIds;
    private static boolean isExpanded;
    private static boolean isNeedAfresh;
    private static ICJPayPaymentMethodService.OutParams outParams;
    private static FrontSubPayTypeInfo selectedPayInfo;
    private static int to_combine_asset_index;

    private ShareData() {
    }

    public final void release() {
        isNeedAfresh = false;
        isExpanded = false;
        releaseCallbacks();
        outParams = null;
        frontPreTradeInfo = new FrontPreTradeInfo(null, null, null, 7, null);
        selectedPayInfo = null;
        combineCardId = null;
        collapseMap = new HashMap();
    }

    static {
        INSTANCE = new ShareData();
        frontPreTradeInfo = new FrontPreTradeInfo(null, null, null, 7, null);
        combineType = "";
        to_combine_asset_index = -1;
        collapseMap = new HashMap();
    }

    public final void adapterPreTradeInfo() {
        ICJPayPaymentMethodService.OutParams r100 = outParams;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.isStdAssetProcess());
    L7:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L12;
        Iterator<T> r102 = frontPreTradeInfo.pre_trade_info.cashier_page_info.asset_info.sub_asset_info_list.iterator();
    L10:
        if (r102.hasNext() == false) goto L109;
        ((AssetInfoBean) r102.next()).asset_basic_show_info.choose = false;
        goto L10
    L109:
        return;
    L12:
        ICJPayPaymentMethodService.OutParams r103 = outParams;
        if (r103 != null) goto L15;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == false) goto L88;
        Iterator<T> r105 = frontPreTradeInfo.pre_trade_info.paytype_info.sub_pay_type_sum_info.sub_pay_type_info_list.iterator();
    L21:
        if (r105.hasNext() == false) goto L23;
        ((FrontSubPayTypeInfo) r105.next()).choose = false;
        goto L21
    L23:
        SubPayTypeGroupInfo r106 = (SubPayTypeGroupInfo) CollectionsKt.firstOrNull(frontPreTradeInfo.pre_trade_info.paytype_info.sub_pay_type_group_info_list);
        firstSelectedGroupInfo = r106;
        if (r106 == null) goto L28;
        ArrayList<Integer> r107 = r106.sub_pay_type_index_list;
        if (r107 == null) goto L28;
        Integer r108 = (Integer) CollectionsKt.firstOrNull(r107);
    L29:
        PreTradeInfo r109 = frontPreTradeInfo.pre_trade_info;
        if (r109 == null) goto L51;
        CJPayPayTypeInfo r110 = r109.paytype_info;
        if (r110 == null) goto L51;
        FrontSubPayTypeSumInfo r111 = r110.sub_pay_type_sum_info;
        if (r111 == null) goto L51;
        ArrayList<FrontSubPayTypeInfo> r112 = r111.sub_pay_type_info_list;
        if (r112 == null) goto L51;
        Iterator<T> r113 = r112.iterator();
    L39:
        if (r113.hasNext() == false) goto L49;
        Object r114 = r113.next();
        int r115 = ((FrontSubPayTypeInfo) r114).index;
        if (r108 != null) goto L44;
    L46:
        boolean r116 = false;
    L47:
        if (r116 == false) goto L39;
    L50:
        FrontSubPayTypeInfo r117 = (FrontSubPayTypeInfo) r114;
    L52:
        firstSelectedPayTypeInfo = r117;
        if (r117 == null) goto L56;
        r117.choose = true;
    L56:
        Iterator<T> r118 = frontPreTradeInfo.pre_trade_info.paytype_info.sub_pay_type_group_info_list.iterator();
    L58:
        if (r118.hasNext() == false) goto L62;
        Object r119 = r118.next();
        if (Intrinsics.areEqual(((SubPayTypeGroupInfo) r119).group_type, "payment_tool") == false) goto L58;
    L63:
        SubPayTypeGroupInfo r120 = (SubPayTypeGroupInfo) r119;
        if (r120 == null) goto L107;
        ArrayList<Integer> r121 = r120.sub_pay_type_index_list;
        if (r121 == null) goto L108;
        Iterator<T> r122 = r121.iterator();
    L69:
        if (r122.hasNext() == false) goto L110;
        int r123 = ((Number) r122.next()).intValue();
        Iterator<T> r124 = frontPreTradeInfo.pre_trade_info.paytype_info.sub_pay_type_sum_info.sub_pay_type_info_list.iterator();
    L72:
        if (r124.hasNext() == false) goto L85;
        Object r125 = r124.next();
        FrontSubPayTypeInfo r126 = (FrontSubPayTypeInfo) r125;
        if (r126.index == r123) goto L76;
    L82:
        boolean r127 = false;
    L83:
        if (r127 == false) goto L72;
    L86:
        FrontSubPayTypeInfo r128 = (FrontSubPayTypeInfo) r125;
        firstAvailableCard = r128;
        if (r128 == null) goto L69;
        return;
    L76:
        if (Intrinsics.areEqual(r126.sub_pay_type, "bank_card") == false) goto L82;
        if (Intrinsics.areEqual(r126.status, "1") == false) goto L82;
        if (r126.pay_type_data.combine_pay_info == null) goto L82;
        r127 = true;
        goto L83
    L85:
        r125 = null;
        goto L86
    L110:
        return;
    L108:
        return;
    L107:
        return;
    L62:
        r119 = null;
        goto L63
    L44:
        if (r115 != r108.intValue()) goto L46;
        r116 = true;
        goto L47
    L49:
        r114 = null;
    L51:
        r117 = null;
    L28:
        r108 = null;
        goto L29
    L88:
        return;
    L15:
        if (r103.isUseNewGroupInfo() != true) goto L17;
        r104 = true;
        goto L18
    L5:
        r101 = null;
        goto L7
    }

    public final CJPayPayInfo getPayInfo() {
        ICJPayPaymentMethodService.OutParams r100 = outParams;
        if (r100 == null) goto L5;
        JSONObject r101 = r100.getPayInfo();
    L6:
        CJPayPayInfo r102 = (CJPayPayInfo) CJPayJsonParser.fromJson(r101, CJPayPayInfo.class);
        if (r102 == null) goto L9;
        return r102;
    L9:
        return new CJPayPayInfo();
    L5:
        r101 = null;
        goto L6
    }

    public final boolean isNeedAfresh() {
        if (isNeedAfresh == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(frontPreTradeInfo.code, "CD000000") == false) goto L8;
        return false;
    }

    public final void releaseCallbacks() {
        ICJPayPaymentMethodService.OutParams r100 = outParams;
        if (r100 == null) goto L6;
        r100.setBindCardCallback(null);
        r100.setChangeMethodCallback(null);
        r100.setAnimCallback(null);
        return;
    }

    public final Map<String, Boolean> getCollapseMap() {
        return collapseMap;
    }

    public final String getCombineCardId() {
        return combineCardId;
    }

    public final String getCombineType() {
        return combineType;
    }

    public final FrontSubPayTypeInfo getFirstAvailableCard() {
        return firstAvailableCard;
    }

    public final FrontPreTradeInfo getFrontPreTradeInfo() {
        return frontPreTradeInfo;
    }

    public final ArrayList<String> getInsufficientCardIds() {
        return insufficientCardIds;
    }

    public final ICJPayPaymentMethodService.OutParams getOutParams() {
        return outParams;
    }

    public final FrontSubPayTypeInfo getSelectedPayInfo() {
        return selectedPayInfo;
    }

    public final int getTo_combine_asset_index() {
        return to_combine_asset_index;
    }

    public final boolean isExpanded() {
        return isExpanded;
    }

    public final FrontSubPayTypeInfo getCombineSubPayTypeInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "subPayType");
        PreTradeInfo r101 = frontPreTradeInfo.pre_trade_info;
        Object r102 = null;
        if (r101 == null) goto L21;
        CJPayPayTypeInfo r103 = r101.paytype_info;
        if (r103 == null) goto L22;
        FrontSubPayTypeSumInfo r104 = r103.sub_pay_type_sum_info;
        if (r104 == null) goto L23;
        ArrayList<FrontSubPayTypeInfo> r105 = r104.sub_pay_type_info_list;
        if (r105 == null) goto L24;
        Iterator<T> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L17;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((FrontSubPayTypeInfo) r107).sub_pay_type, r100) == false) goto L12;
        r102 = r107;
    L17:
        return (FrontSubPayTypeInfo) r102;
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L21:
        return null;
    }

    public final void setCollapseMap(Map<String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        collapseMap = r100;
    }

    public final void setCombineCardId(String r100) {
        combineCardId = r100;
    }

    public final void setCombineType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        combineType = r100;
    }

    public final void setExpanded(boolean r100) {
        isExpanded = r100;
    }

    public final void setFrontPreTradeInfo(FrontPreTradeInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        frontPreTradeInfo = r100;
    }

    public final void setInsufficientCardIds(ArrayList<String> r100) {
        insufficientCardIds = r100;
    }

    public final void setNeedAfresh(boolean r100) {
        isNeedAfresh = r100;
    }

    public final void setOutParams(ICJPayPaymentMethodService.OutParams r100) {
        outParams = r100;
    }

    public final void setSelectedPayInfo(FrontSubPayTypeInfo r100) {
        selectedPayInfo = r100;
    }

    public final void setTo_combine_asset_index(int r100) {
        to_combine_asset_index = r100;
    }
}
