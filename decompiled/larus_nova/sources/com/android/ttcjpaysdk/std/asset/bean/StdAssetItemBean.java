package com.android.ttcjpaysdk.std.asset.bean;

import com.android.ttcjpaysdk.base.ui.Utils.AssetProcessUtils;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.ButtonInfoLabel;
import com.android.ttcjpaysdk.base.ui.data.CJPayBubbleInfo;
import com.android.ttcjpaysdk.base.ui.data.IconTips;
import com.android.ttcjpaysdk.base.ui.data.JumpInfoBean;
import com.android.ttcjpaysdk.base.ui.data.LabelData;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.util.UriUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b-\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\r\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0018J\u0006\u0010H\u001a\u00020\u0007J\u0010\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0007J\u0006\u0010K\u001a\u00020\u0007J\u0006\u0010L\u001a\u00020\u0007J\u0006\u0010M\u001a\u00020\u0007J\u0006\u0010N\u001a\u00020\u0007J\u0006\u0010O\u001a\u00020PJ\u0006\u0010Q\u001a\u00020\u0007J\u0006\u0010R\u001a\u00020SJ\u0006\u0010T\u001a\u00020UJ\u0006\u0010V\u001a\u00020\u0007J\u0006\u0010W\u001a\u00020\u0007J\u0016\u0010X\u001a\u0012\u0012\u0004\u0012\u00020\u00000Yj\b\u0012\u0004\u0012\u00020\u0000`ZJ\u0006\u0010[\u001a\u00020\u0007J\u0006\u0010\\\u001a\u00020\u0007J\u0006\u0010]\u001a\u00020\u0007J\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00070_J\u0006\u0010`\u001a\u00020\u0018J\u0006\u0010a\u001a\u00020\u0018J\u0006\u0010b\u001a\u00020\u0018J\u0006\u0010c\u001a\u00020\u0018J\u0006\u0010d\u001a\u00020\u0018J\u0006\u0010e\u001a\u00020\u0018J\u0006\u0010f\u001a\u00020FJ\u0006\u0010g\u001a\u00020FJ\u000e\u0010h\u001a\u00020F2\u0006\u0010i\u001a\u00020\u0018J\u0010\u0010j\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u0003H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\u001f\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001a\u0010!\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010#\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001a\u0010%\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001e\u0010'\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010,\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR\u001a\u0010/\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u0010\u0013R\u001a\u00102\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013R\u001a\u00105\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010\u0013R\u001a\u00108\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0011\"\u0004\b:\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0011\"\u0004\b<\u0010\u0013R\u001a\u0010=\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0011\"\u0004\b?\u0010\u0013R\u001a\u0010@\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006l"}, d2 = {"Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetItemBean;", "", "info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "eventType", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgBean$VoucherEventType;", "subGroupType", "", "(Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgBean$VoucherEventType;Ljava/lang/String;)V", "TAG", "assetInfo", "getAssetInfo", "()Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "setAssetInfo", "(Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;)V", "expandedSubAssetUniqueId", "getExpandedSubAssetUniqueId", "()Ljava/lang/String;", "setExpandedSubAssetUniqueId", "(Ljava/lang/String;)V", "foldDesc", "getFoldDesc", "setFoldDesc", "hasOptionVoucher", "", "getHasOptionVoucher", "()Z", "setHasOptionVoucher", "(Z)V", "isChecked", "setChecked", "isCollapse", "setCollapse", "isLoading", "setLoading", "isShowFooter", "setShowFooter", "isShowLine", "setShowLine", "isVoucherExpanded", "()Ljava/lang/Boolean;", "setVoucherExpanded", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "optionVoucherChecked", "getOptionVoucherChecked", "setOptionVoucherChecked", "optionVoucherKey", "getOptionVoucherKey", "setOptionVoucherKey", "optionVoucherLeftTitle", "getOptionVoucherLeftTitle", "setOptionVoucherLeftTitle", "optionVoucherRightTitle", "getOptionVoucherRightTitle", "setOptionVoucherRightTitle", "status", "getStatus", "setStatus", "getSubGroupType", "setSubGroupType", "subTitle", "getSubTitle", "setSubTitle", "voucherEventType", "getVoucherEventType", "()Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgBean$VoucherEventType;", "setVoucherEventType", "(Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgBean$VoucherEventType;)V", "changeAssetInfoBeanChoose", "", "isChoose", "getAssetType", "getCrossPrice", "key", "getDescTitleText", "getFoldDescText", "getGuideShowChooseText", "getGuideShowText", "getIconTips", "Lcom/android/ttcjpaysdk/base/ui/data/IconTips;", "getIconUrl", "getIndex", "", "getJumpInfo", "Lcom/android/ttcjpaysdk/base/ui/data/JumpInfoBean;", "getRecommondTagText", "getStandardShowAmount", "getSubPaymentItem", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSubTitleShowText", "getTitleShowText", "getTradeConfirmButtonLabel", "getVoucherShowTextList", "", "isArrowStyle", "isEnable", "isHasSubAsset", "isNeedSignPay", "isShowIconTips", "isSubAssetNoChoose", "updateAssetInfoBean", "updateSubAssetChooseFirst", "updateSubPaymentItemChecked", "c", "wrapAssetInfoToPaymentItemBean", UriUtil.LOCAL_ASSET_SCHEME, "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StdAssetItemBean {
    private final String TAG;
    private AssetInfoBean assetInfo;
    private String expandedSubAssetUniqueId;
    private String foldDesc;
    private boolean hasOptionVoucher;
    private boolean isChecked;
    private boolean isCollapse;
    private boolean isLoading;
    private boolean isShowFooter;
    private boolean isShowLine;
    private Boolean isVoucherExpanded;
    private boolean optionVoucherChecked;
    private String optionVoucherKey;
    private String optionVoucherLeftTitle;
    private String optionVoucherRightTitle;
    private String status;
    private String subGroupType;
    private String subTitle;
    private AssetInfoBean.VoucherMsgBean.VoucherEventType voucherEventType;

    public final String getAssetType() {
        return this.assetInfo.getAssetType();
    }

    public final String getDescTitleText() {
        return this.assetInfo.asset_basic_show_info.desc_title;
    }

    public final String getGuideShowChooseText() {
        return this.assetInfo.asset_extension_show_info.select_page_show_info.select_page_guide_choice_text;
    }

    public final String getGuideShowText() {
        return this.assetInfo.asset_extension_show_info.select_page_show_info.select_page_guide_text;
    }

    public final IconTips getIconTips() {
        return this.assetInfo.asset_extension_show_info.icon_tips;
    }

    public final String getIconUrl() {
        return this.assetInfo.asset_basic_show_info.icon_url;
    }

    public final int getIndex() {
        return this.assetInfo.asset_basic_show_info.index;
    }

    public final JumpInfoBean getJumpInfo() {
        return this.assetInfo.asset_extension_show_info.jump_info;
    }

    public final String getRecommondTagText() {
        CJPayBubbleInfo r100 = this.assetInfo.asset_extension_show_info.bubble_info_map;
        if (r100 == null) goto L12;
        ButtonInfoLabel r101 = r100.paytype;
        if (r101 == null) goto L12;
        List<LabelData> r102 = r101.label;
        if (r102 == null) goto L12;
        LabelData r103 = (LabelData) ListProtector.get(r102, 0);
        if (r103 == null) goto L12;
        String r104 = r103.text;
        if (r104 == null) goto L12;
        return r104;
    L12:
        return "";
    }

    public final String getStandardShowAmount() {
        return this.assetInfo.asset_extension_show_info.standard_show_amount;
    }

    public final ArrayList<StdAssetItemBean> getSubPaymentItem() {
        ArrayList<StdAssetItemBean> r100 = new ArrayList();
        Iterator<T> r101 = this.assetInfo.sub_asset_info_list.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.add(wrapAssetInfoToPaymentItemBean((AssetInfoBean) r101.next()));
        goto L4
    L6:
        return r100;
    }

    public final String getSubTitleShowText() {
        String r100 = this.subTitle;
        boolean r101 = false;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L12;
        AssetProcessUtils r103 = AssetProcessUtils.INSTANCE;
        AssetInfoBean r104 = this.assetInfo;
        Boolean r105 = this.isVoucherExpanded;
        if (r105 == null) goto L11;
        r101 = r105.booleanValue();
    L11:
        return r103.parseSelectPageSubTitle(r104, r101);
    L12:
        return r100;
    L5:
        r102 = false;
        goto L6
    }

    public final String getTitleShowText() {
        AssetProcessUtils r100 = AssetProcessUtils.INSTANCE;
        AssetInfoBean r101 = this.assetInfo;
        Boolean r102 = this.isVoucherExpanded;
        if (r102 == null) goto L5;
        boolean r103 = r102.booleanValue();
    L7:
        return r100.parseSelectPageTitle(r101, r103);
    L5:
        r103 = false;
        goto L7
    }

    public final String getTradeConfirmButtonLabel() {
        return this.assetInfo.asset_extension_show_info.trade_confirm_button_label;
    }

    public final List<String> getVoucherShowTextList() {
        boolean r100 = false;
        if (this.voucherEventType != AssetInfoBean.VoucherMsgBean.VoucherEventType.COMBINE_PAY) goto L8;
        AssetInfoBean.VoucherMsgBean r101 = this.assetInfo.asset_extension_show_info.voucher_msg_map;
        Boolean r102 = this.isVoucherExpanded;
        if (r102 == null) goto L13;
        r100 = r102.booleanValue();
    L13:
        return r101.getCombineVoucherMsgV2OfCardList(r100);
    L8:
        AssetInfoBean.VoucherMsgBean r103 = this.assetInfo.asset_extension_show_info.voucher_msg_map;
        Boolean r104 = this.isVoucherExpanded;
        if (r104 == null) goto L12;
        r100 = r104.booleanValue();
    L12:
        return r103.getVoucherMsgV2OfCardList(r100);
    }

    public final boolean isArrowStyle() {
        return this.assetInfo.isNeedJump();
    }

    public final boolean isEnable() {
        if (this.status.length() <= 0) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L10;
        return Intrinsics.areEqual(this.status, "1");
    L10:
        return Intrinsics.areEqual(this.assetInfo.asset_basic_show_info.status, "1");
    L5:
        r100 = false;
        goto L7
    }

    public final boolean isHasSubAsset() {
        if (this.assetInfo.sub_asset_info_list.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNeedSignPay() {
        return this.assetInfo.asset_extension_show_info.need_resign;
    }

    public final boolean isShowIconTips() {
        if (this.assetInfo.asset_extension_show_info.icon_tips.title.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSubAssetNoChoose() {
        Iterator<T> r100 = this.assetInfo.sub_asset_info_list.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        if (((AssetInfoBean) r101).asset_basic_show_info.choose == false) goto L4;
    L10:
        if (((AssetInfoBean) r101) == null) goto L12;
        return false;
    L12:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void updateAssetInfoBean() {
        AssetInfoBean.AssetBasicShowInfoBean r100 = this.assetInfo.asset_basic_show_info;
        r100.choose = this.isChecked;
    }

    public final void updateSubAssetChooseFirst() {
        ArrayList<AssetInfoBean> r100 = this.assetInfo.sub_asset_info_list;
        if (r100.size() <= 0) goto L5;
        boolean r101 = true;
    L6:
        ArrayList<AssetInfoBean> r102 = null;
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L15;
        Iterator<T> r103 = r100.iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        ((AssetInfoBean) r103.next()).asset_basic_show_info.choose = false;
    L15:
        ArrayList<AssetInfoBean> r104 = this.assetInfo.sub_asset_info_list;
        if (r104.size() <= 0) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L21;
        r102 = r104;
    L21:
        if (r102 == null) goto L25;
        ((AssetInfoBean) ListProtector.get(r102, 0)).asset_basic_show_info.choose = true;
        return;
    L25:
        return;
    L18:
        r105 = false;
        goto L19
    L5:
        r101 = false;
        goto L6
    }

    public final AssetInfoBean getAssetInfo() {
        return this.assetInfo;
    }

    public final String getExpandedSubAssetUniqueId() {
        return this.expandedSubAssetUniqueId;
    }

    public final String getFoldDesc() {
        return this.foldDesc;
    }

    public final String getFoldDescText() {
        return this.foldDesc;
    }

    public final boolean getHasOptionVoucher() {
        return this.hasOptionVoucher;
    }

    public final boolean getOptionVoucherChecked() {
        return this.optionVoucherChecked;
    }

    public final String getOptionVoucherKey() {
        return this.optionVoucherKey;
    }

    public final String getOptionVoucherLeftTitle() {
        return this.optionVoucherLeftTitle;
    }

    public final String getOptionVoucherRightTitle() {
        return this.optionVoucherRightTitle;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getSubGroupType() {
        return this.subGroupType;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final AssetInfoBean.VoucherMsgBean.VoucherEventType getVoucherEventType() {
        return this.voucherEventType;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final boolean isCollapse() {
        return this.isCollapse;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final boolean isShowFooter() {
        return this.isShowFooter;
    }

    public final boolean isShowLine() {
        return this.isShowLine;
    }

    public final Boolean isVoucherExpanded() {
        return this.isVoucherExpanded;
    }

    private final StdAssetItemBean wrapAssetInfoToPaymentItemBean(AssetInfoBean r100) {
        StdAssetItemBean r101 = new StdAssetItemBean(r100, this.voucherEventType, null, 4, null);
        String r102 = this.expandedSubAssetUniqueId;
        if (r102 == null) goto L18;
        boolean r103 = true;
        if (r102.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L10;
    L12:
        r103 = false;
    L13:
        if (r103 == true) goto L16;
        r102 = null;
    L16:
        if (r102 == null) goto L18;
        r101.isVoucherExpanded = Boolean.TRUE;
        goto L18
    L10:
        if (Intrinsics.areEqual(r100.asset_meta_info.getUniqueSymbol(), r102) == false) goto L12;
    L7:
        r104 = false;
    L18:
        return r101;
    }

    public final void changeAssetInfoBeanChoose(boolean r100) {
        this.assetInfo.asset_basic_show_info.choose = r100;
        this.isChecked = r100;
        if (r100 == false) goto L6;
        CJLogger.d(this.TAG, "changeAssetInfoBeanChoose " + this.assetInfo.asset_meta_info.asset_id);
        return;
    }

    @Deprecated(message = "use getCrossPriceNew")
    public final String getCrossPrice(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = this.assetInfo.asset_extension_show_info.standard_show_amount_map.get(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    public final void setAssetInfo(AssetInfoBean r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.assetInfo = r100;
    }

    public final void setChecked(boolean r100) {
        this.isChecked = r100;
    }

    public final void setCollapse(boolean r100) {
        this.isCollapse = r100;
    }

    public final void setExpandedSubAssetUniqueId(String r100) {
        this.expandedSubAssetUniqueId = r100;
    }

    public final void setFoldDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.foldDesc = r100;
    }

    public final void setHasOptionVoucher(boolean r100) {
        this.hasOptionVoucher = r100;
    }

    public final void setLoading(boolean r100) {
        this.isLoading = r100;
    }

    public final void setOptionVoucherChecked(boolean r100) {
        this.optionVoucherChecked = r100;
    }

    public final void setOptionVoucherKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.optionVoucherKey = r100;
    }

    public final void setOptionVoucherLeftTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.optionVoucherLeftTitle = r100;
    }

    public final void setOptionVoucherRightTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.optionVoucherRightTitle = r100;
    }

    public final void setShowFooter(boolean r100) {
        this.isShowFooter = r100;
    }

    public final void setShowLine(boolean r100) {
        this.isShowLine = r100;
    }

    public final void setStatus(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.status = r100;
    }

    public final void setSubGroupType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.subGroupType = r100;
    }

    public final void setSubTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.subTitle = r100;
    }

    public final void setVoucherEventType(AssetInfoBean.VoucherMsgBean.VoucherEventType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.voucherEventType = r100;
    }

    public final void setVoucherExpanded(Boolean r100) {
        this.isVoucherExpanded = r100;
    }

    public final void updateSubPaymentItemChecked(boolean r100) {
        this.isChecked = r100;
        if (r100 == false) goto L5;
        CJLogger.d(this.TAG, "update sub choose " + this.assetInfo.asset_meta_info.asset_id);
    L5:
        this.assetInfo.asset_basic_show_info.choose = r100;
    }

    public StdAssetItemBean(AssetInfoBean r100, AssetInfoBean.VoucherMsgBean.VoucherEventType r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        Intrinsics.checkNotNullParameter(r102, "subGroupType");
        this.foldDesc = "";
        this.optionVoucherKey = "";
        this.optionVoucherLeftTitle = "";
        this.optionVoucherRightTitle = "";
        this.assetInfo = new AssetInfoBean();
        this.voucherEventType = AssetInfoBean.VoucherMsgBean.VoucherEventType.DEFAULT;
        this.status = "";
        this.subTitle = "";
        this.isVoucherExpanded = Boolean.FALSE;
        this.expandedSubAssetUniqueId = "";
        this.subGroupType = "";
        this.TAG = "StdAssetItemBean";
        this.assetInfo = r100;
        boolean r103 = r100.asset_basic_show_info.choose;
        this.isChecked = r103;
        if (r103 == false) goto L5;
        CJLogger.d("StdAssetItemBean", "init choose " + this.assetInfo.asset_meta_info.asset_id);
    L5:
        this.voucherEventType = r101;
        this.subGroupType = r102;
    }

    public /* synthetic */ StdAssetItemBean(AssetInfoBean r100, AssetInfoBean.VoucherMsgBean.VoucherEventType r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = "default";
    L5:
        this(r100, r101, r102);
    }
}
