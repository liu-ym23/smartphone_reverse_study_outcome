package com.android.ttcjpaysdk.asset.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.ui.Utils.StdLogUtils;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.JumpInfoBean;
import com.android.ttcjpaysdk.base.ui.data.UIComponent;
import com.android.ttcjpaysdk.base.utils.html.utils.UIComponentSpannableParser;
import com.android.ttcjpaysdk.std.asset.callback.JumpActionHandleCallback;
import com.android.ttcjpaysdk.thirdparty.data.CJPayPaymentMethodInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeConfirmBizContentBasicParams;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001`B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002JF\u0010\u0007\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ8\u0010\u0010\u001a\u0004\u0018\u00010\t2\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ4\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000bj\b\u0012\u0004\u0012\u00020\t`\f2\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u000fJ<\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004J!\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ \u0010\u001d\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u001e2\u0006\u0010\r\u001a\u00020\u0004H\u0002J(\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0014\u001a\u00020\t2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$J:\u0010%\u001a\u0004\u0018\u00010\u00042&\u0010&\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010'j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`(2\b\b\u0002\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u0018J\u000e\u0010-\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\tJ\u000e\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/J\u0010\u00100\u001a\u00020\u000f2\b\u00101\u001a\u0004\u0018\u00010\u0013J\u0010\u00102\u001a\u00020\u000f2\b\u00101\u001a\u0004\u0018\u00010\u0013J\u0018\u00103\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u000105J&\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\b2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00107\u001a\u0004\u0018\u000108J\u0010\u00109\u001a\u00020\u000f2\b\u0010:\u001a\u0004\u0018\u00010\tJ&\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010<\u001a\u00020\u001bJ \u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000bj\b\u0012\u0004\u0012\u00020\u0004`\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\tJ\u0018\u0010>\u001a\u00020\u00042\b\u0010?\u001a\u0004\u0018\u00010\u00182\u0006\u0010@\u001a\u00020\u0004J\u0018\u0010A\u001a\u00020\u00042\b\u0010?\u001a\u0004\u0018\u00010\u00182\u0006\u0010@\u001a\u00020\u0004J\u0018\u0010B\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010@\u001a\u00020\u0004J\u0018\u0010E\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010@\u001a\u00020\u0004J\u001a\u0010F\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010G\u001a\u00020\u000fJ\u0018\u0010H\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00182\u0006\u0010@\u001a\u00020\u0004J\u001a\u0010I\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010G\u001a\u00020\u000fJ\u001a\u0010J\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010G\u001a\u00020\u000fJ\u0018\u0010K\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00182\u0006\u0010@\u001a\u00020\u0004J\u001a\u0010L\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010G\u001a\u00020\u000fJ\u001a\u0010M\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010G\u001a\u00020\u000fJ\u0018\u0010N\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00182\u0006\u0010@\u001a\u00020\u0004J\u001a\u0010O\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010G\u001a\u00020\u000fJ\u0018\u0010P\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00182\u0006\u0010@\u001a\u00020\u0004J\u001a\u0010Q\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010G\u001a\u00020\u000fJ\u001a\u0010R\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010G\u001a\u00020\u000fJ\u0010\u0010S\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\tJ\u0010\u0010T\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\tJ\u001a\u0010U\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010D2\b\b\u0002\u0010G\u001a\u00020\u000fJ\u001a\u0010V\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010D2\b\b\u0002\u0010G\u001a\u00020\u000fJD\u0010W\u001a\u00020\u00042&\u0010X\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010'j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`(2\b\u0010Y\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010G\u001a\u00020\u000fH\u0002J\u001a\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010^\u001a\u0004\u0018\u00010_¨\u0006a"}, d2 = {"Lcom/android/ttcjpaysdk/asset/utils/AssetInfoUtil;", "", "()V", "buildAmountDescWithPrefix", "", "rawAmount", "prefixDesc", "changeAndFindAssetWithId", "Lkotlin/Pair;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "assetInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "assetInfoID", "isSelect", "", "changeAndFindSelectedAsset", "changeAndFindSelectedAssetFromList", "findAssetStandardCombinePay", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetMetaInfoBean;", "assetInfo", "isSingleCombineStyle", "findAssetWithId", "findCombineAssetInfo", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetToCombineAssetInfoBean;", "assetInfoBean", "assetCombineIndex", "", "(Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;Ljava/lang/Integer;)Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetToCombineAssetInfoBean;", "findSelectedAssetFromList", "", "getTipsMsgInfo", "Landroid/text/SpannableStringBuilder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "textView", "Landroid/widget/TextView;", "getValueByTag", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "assetMapTag", "Lcom/android/ttcjpaysdk/asset/utils/AssetInfoUtil$AssetMapTag;", "hasCombineChannelMarkUpgradeData", "assetToCombineAssetInfoBean", "isBindCardPay", "jumpInfoBean", "Lcom/android/ttcjpaysdk/base/ui/data/JumpInfoBean;", "isCreditScore", "assetMetaInfoBean", "isEcny", "jumpAction", "callback", "Lcom/android/ttcjpaysdk/std/asset/callback/JumpActionHandleCallback;", "needJump", "action", "Lcom/android/ttcjpaysdk/base/ui/data/JumpInfoBean$Action;", "needResignCard", "usedAssetInfoBean", "parseAmountAndDesc", "toCombineIndex", "parseAssetMetaInfo2ArrayList", "parseBindCardPointCombineStandardRecDesc", "combineAssetInfoBean", "key", "parseBindCardPointCombineStandardShowAmount", "parseBindCardPointStandardRecDesc", "extensionShowInfo", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetExtensionShowInfo;", "parseBindCardPointStandardShowAmount", "parseCombinePayDesc1", "isVoucherExpand", "parseCombinePayDesc1FromKey", "parseCombinePayDesc1WithPrefix", "parseCombinePayDesc2", "parseCombinePayDesc2FromKey", "parseCombinePayDesc2WithPrefix", "parseCombinePayTitle1", "parseCombinePayTitle1FromKey", "parseCombinePayTitle2", "parseCombinePayTitle2FromKey", "parseCombineStandardRecDesc", "parseCombineStandardShowAmount", "parseFee", "parseShowIcon", "parseStandardRecDesc", "parseStandardShowAmount", "parseStrFromMapWithFallback", "valueMap", "fallback", "setupAssetStandardParam", "", "bizContentParams", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeConfirmBizContentBasicParams;", "paymentMethodInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPaymentMethodInfo;", "AssetMapTag", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AssetInfoUtil {
    public static final AssetInfoUtil INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/asset/utils/AssetInfoUtil$AssetMapTag;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "DEFAULT", "RETAIN", "FEE", "HAS_USE_STANDARD_REC_BUTTON_INFO", "PAY_AND_X", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum AssetMapTag extends Enum<AssetMapTag> {
        private static final /* synthetic */ AssetMapTag[] $VALUES = null;
        public static final AssetMapTag DEFAULT = null;
        public static final AssetMapTag FEE = null;
        public static final AssetMapTag HAS_USE_STANDARD_REC_BUTTON_INFO = null;
        public static final AssetMapTag PAY_AND_X = null;
        public static final AssetMapTag RETAIN = null;
        private final String key;

        private static final /* synthetic */ AssetMapTag[] $values() {
            return new AssetMapTag[]{DEFAULT, RETAIN, FEE, HAS_USE_STANDARD_REC_BUTTON_INFO, PAY_AND_X};
        }

        public static AssetMapTag valueOf(String r100) {
            return (AssetMapTag) a.a(AssetMapTag.class, r100);
        }

        public static AssetMapTag[] values() {
            return (AssetMapTag[]) $VALUES.clone();
        }

        static {
            DEFAULT = new AssetMapTag("DEFAULT", 0, "default");
            RETAIN = new AssetMapTag("RETAIN", 1, "retain");
            FEE = new AssetMapTag("FEE", 2, "fee");
            HAS_USE_STANDARD_REC_BUTTON_INFO = new AssetMapTag("HAS_USE_STANDARD_REC_BUTTON_INFO", 3, "has_use_standard_rec_button_info");
            PAY_AND_X = new AssetMapTag("PAY_AND_X", 4, "pay_and_x");
            $VALUES = $values();
        }

        public final String getKey() {
            return this.key;
        }

        private AssetMapTag(String r100, int r101, String r102) {
            super(r100, r101);
            this.key = r102;
        }
    }

    static {
        INSTANCE = new AssetInfoUtil();
    }

    private AssetInfoUtil() {
    }

    public final boolean hasCombineChannelMarkUpgradeData(AssetInfoBean.AssetToCombineAssetInfoBean r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.origin_asset_prefix_desc.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
    L24:
        return true;
    L10:
        if (r100.to_combine_asset_prefix_desc.length() <= 0) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == true) goto L24;
        if (r100.origin_asset_icon.length() <= 0) goto L17;
        boolean r103 = true;
    L18:
        if (r103 == true) goto L24;
        if (r100.to_combine_asset_icon.length() <= 0) goto L22;
        boolean r104 = true;
    L23:
        if (r104 == true) goto L24;
        return false;
    L22:
        r104 = false;
        goto L23
    L17:
        r103 = false;
        goto L18
    L12:
        r102 = false;
        goto L13
    L7:
        r101 = false;
        goto L8
    }

    public final boolean isBindCardPay(AssetInfoBean r100) {
        Intrinsics.checkNotNullParameter(r100, "assetInfo");
        if (r100.asset_extension_show_info.jump_info.action == JumpInfoBean.Action.BindCard.getValue()) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual("1", r100.asset_extension_show_info.jump_info.ext_map.need_pay) == false) goto L7;
        return true;
    }

    public final boolean isCreditScore(AssetInfoBean.AssetMetaInfoBean r100) {
        if (r100 == null) goto L4;
        String r101 = r100.asset_type;
    L6:
        return Intrinsics.areEqual(r101, "CREDITASSET");
    L4:
        r101 = null;
        goto L6
    }

    public final boolean isEcny(AssetInfoBean.AssetMetaInfoBean r100) {
        if (r100 == null) goto L4;
        String r101 = r100.asset_type;
    L6:
        return Intrinsics.areEqual(r101, "DCEP");
    L4:
        r101 = null;
        goto L6
    }

    public final boolean needResignCard(AssetInfoBean r100) {
        if (r100 != null) goto L5;
    L26:
        return false;
    L5:
        if (r100.asset_extension_show_info.need_resign == false) goto L8;
        return true;
    L8:
        if (r100.isNeedCombine() == false) goto L26;
        ArrayList<AssetInfoBean.AssetToCombineAssetInfoBean> r101 = r100.asset_combine_pay_info.asset_to_combine_asset_info_list;
        if (r101.size() <= 0) goto L12;
        boolean r102 = true;
    L13:
        AssetInfoBean.AssetToCombineAssetInfoBean r103 = null;
        if (r102 == true) goto L17;
        r101 = null;
    L17:
        if (r101 == null) goto L19;
        r103 = (AssetInfoBean.AssetToCombineAssetInfoBean) ListProtector.get(r101, 0);
    L19:
        if (r103 != null) goto L21;
    L23:
        boolean r104 = false;
    L24:
        if (r104 == false) goto L26;
        return true;
    L21:
        if (r103.need_resign != true) goto L23;
        r104 = true;
        goto L24
    L12:
        r102 = false;
        goto L13
    }

    public final ArrayList<String> parseAssetMetaInfo2ArrayList(AssetInfoBean r100) {
        ArrayList<String> r101 = new ArrayList();
        if (r100 == null) goto L10;
        ArrayList<AssetInfoBean> r102 = r100.sub_asset_info_list;
        if (r102 == null) goto L10;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r101.add(((AssetInfoBean) r103.next()).asset_meta_info.getUniqueSymbol());
    L10:
        return r101;
    }

    public final String parseFee(AssetInfoBean r100) {
        if (r100 == null) goto L13;
        AssetInfoBean.AssetExtensionShowInfo r101 = r100.asset_extension_show_info;
        if (r101 == null) goto L14;
        HashMap<String, String> r102 = r101.standard_rec_desc_map;
        if (r102 == null) goto L15;
        String r103 = INSTANCE.getValueByTag(r102, AssetMapTag.FEE);
        if (r103 != null) goto L12;
        return "";
    L12:
        return r103;
    L15:
        return "";
    L14:
        return "";
    L13:
        return "";
    }

    public final String parseShowIcon(AssetInfoBean r100) {
        if (r100 == null) goto L13;
        AssetInfoBean.AssetExtensionShowInfo r101 = r100.asset_extension_show_info;
        if (r101 == null) goto L14;
        HashMap<String, String> r102 = r101.standard_rec_desc_map;
        if (r102 == null) goto L15;
        String r103 = INSTANCE.getValueByTag(r102, AssetMapTag.HAS_USE_STANDARD_REC_BUTTON_INFO);
        if (r103 != null) goto L12;
        return "";
    L12:
        return r103;
    L15:
        return "";
    L14:
        return "";
    L13:
        return "";
    }

    public final boolean isBindCardPay(JumpInfoBean r100) {
        Intrinsics.checkNotNullParameter(r100, "jumpInfoBean");
        if (Intrinsics.areEqual(r100.action, JumpInfoBean.Action.BindCard.getValue()) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual("1", r100.ext_map.need_pay) == false) goto L7;
        return true;
    }

    private final String buildAmountDescWithPrefix(String r100, String r101) {
        boolean r102 = true;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        return "";
    L10:
        if (r101.length() > 0) goto L13;
        r102 = false;
    L13:
        if (r102 == true) goto L15;
        return r100;
    L15:
        return r101 + r100;
    L5:
        r103 = false;
        goto L6
    }

    private final AssetInfoBean findSelectedAssetFromList(List<AssetInfoBean> r100, String r101) {
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((AssetInfoBean) r103).asset_meta_info.getUniqueSymbol(), r101) == false) goto L4;
    L10:
        return (AssetInfoBean) r103;
    L8:
        r103 = null;
        goto L10
    }

    public final AssetInfoBean.AssetMetaInfoBean findAssetStandardCombinePay(AssetInfoBean r100, boolean r101) {
        if (r101 == false) goto L10;
        if (r100 == null) goto L6;
        AssetInfoBean.AssetToCombineAssetInfoBean r102 = r100.findDefaultCombineInfo();
    L7:
        if (r102 != null) goto L9;
    L20:
        if (r100 != null) goto L22;
        return null;
    L22:
        return r100.asset_meta_info;
    L9:
        return r102.asset_meta_info;
    L6:
        r102 = null;
        goto L7
    L10:
        if (r100 == null) goto L20;
        if (r100.isNeedCombine() == false) goto L14;
        AssetInfoBean r103 = r100;
    L15:
        if (r103 == null) goto L20;
        AssetInfoBean.AssetToCombineAssetInfoBean r104 = r103.findDefaultCombineInfo();
        if (r104 != null) goto L19;
        return null;
    L19:
        return r104.asset_meta_info;
    L14:
        r103 = null;
        goto L15
    }

    public final Pair<AssetInfoBean, AssetInfoBean> findAssetWithId(ArrayList<AssetInfoBean> r100, String r101) {
        if (r100 == null) goto L33;
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L33;
        AssetInfoBean r103 = findSelectedAssetFromList(r100, r101);
        if (r103 != null) goto L16;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r100.iterator();
    L19:
        if (r105.hasNext() == false) goto L23;
        Object r106 = r105.next();
        if ((!((AssetInfoBean) r106).sub_asset_info_list.isEmpty()) == false) goto L19;
        r104.add(r106);
        goto L19
    L23:
        Iterator r107 = r104.iterator();
    L25:
        if (r107.hasNext() == false) goto L31;
        AssetInfoBean r108 = (AssetInfoBean) r107.next();
        AssetInfoBean r109 = INSTANCE.findSelectedAssetFromList(r108.sub_asset_info_list, r101);
        if (r109 == null) goto L25;
        return new Pair(r109, r108);
    L31:
        return new Pair(null, null);
    L16:
        return new Pair(r103, null);
    L7:
        if (StringsKt.isBlank(r101) == true) goto L10;
        r102 = false;
    L33:
        return new Pair(null, null);
    }

    public final AssetInfoBean.AssetToCombineAssetInfoBean findCombineAssetInfo(AssetInfoBean r100, Integer r101) {
        Object r102 = null;
        if (r100 == null) goto L27;
        AssetInfoBean.AssetCombinePayInfoBean r103 = r100.asset_combine_pay_info;
        if (r103 == null) goto L28;
        ArrayList<AssetInfoBean.AssetToCombineAssetInfoBean> r104 = r103.asset_to_combine_asset_info_list;
        if (r104 == null) goto L29;
        Iterator<T> r105 = r104.iterator();
    L10:
        if (r105.hasNext() == false) goto L21;
        Object r106 = r105.next();
        int r107 = ((AssetInfoBean.AssetToCombineAssetInfoBean) r106).to_combine_asset_index;
        if (r101 != null) goto L15;
    L17:
        boolean r108 = false;
    L18:
        if (r108 == false) goto L10;
        r102 = r106;
        goto L21
    L15:
        if (r107 != r101.intValue()) goto L17;
        r108 = true;
    L21:
        return (AssetInfoBean.AssetToCombineAssetInfoBean) r102;
    L29:
        return null;
    L28:
        return null;
    L27:
        return null;
    }

    public final String getValueByTag(HashMap<String, String> r100, AssetMapTag r101) {
        Intrinsics.checkNotNullParameter(r101, "assetMapTag");
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.get(r101.getKey());
    }

    public final boolean jumpAction(AssetInfoBean r100, JumpActionHandleCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "assetInfo");
        if (r100.isNeedJump() == true) goto L5;
        return false;
    L5:
        StdLogUtils.INSTANCE.logInfo("jumpInfo", "title: " + r100.asset_basic_show_info.title + ' ' + r100.asset_extension_show_info.select_page_show_info.select_page_priority_title + " fundBillIndex: " + r100.asset_meta_info.fund_bill_index + " , " + r100.asset_extension_show_info.jump_info.action);
        AssetInfoBean.AssetExtensionShowInfo r102 = r100.asset_extension_show_info;
        if (r102.need_resign == false) goto L10;
        if (r101 == null) goto L9;
        r101.signPay();
    L9:
        return true;
    L10:
        String r103 = r102.jump_info.action;
        if (Intrinsics.areEqual(r103, JumpInfoBean.Action.SubmitOrder.getValue()) == false) goto L16;
        if (r101 == null) goto L14;
        r101.submitOrder();
    L14:
        return true;
    L16:
        if (Intrinsics.areEqual(r103, JumpInfoBean.Action.BindCard.getValue()) == false) goto L26;
        if (Intrinsics.areEqual("1", r100.asset_extension_show_info.jump_info.ext_map.need_pay) == false) goto L22;
        if (r101 == null) goto L21;
        r101.bindCardPay();
    L21:
        return true;
    L22:
        if (r101 == null) goto L24;
        r101.bindCard();
    L24:
        return true;
    L26:
        if (Intrinsics.areEqual(r103, JumpInfoBean.Action.UnlockCard.getValue()) == false) goto L31;
        if (r101 == null) goto L29;
        r101.unLockCard();
    L29:
        return true;
    L31:
        if (Intrinsics.areEqual(r103, JumpInfoBean.Action.CreditPayActive.getValue()) == false) goto L36;
        if (r101 == null) goto L34;
        r101.creditPayActive(r100.asset_extension_show_info.jump_info.url);
    L34:
        return true;
    L36:
        if (Intrinsics.areEqual(r103, JumpInfoBean.Action.RealNameAuth.getValue()) == false) goto L40;
        if (r101 == null) goto L39;
        r101.realNameAuth();
    L39:
        return true;
    L40:
        return false;
    }

    public final Pair<Boolean, String> needJump(JumpInfoBean r100, JumpInfoBean.Action r101) {
        if (r101 == null) goto L21;
        if (r100 == null) goto L21;
        String r102 = null;
        if (Intrinsics.areEqual(r100.action, r101.getValue()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L21;
        String r103 = r100.url;
        if (r103 == null) goto L21;
        if (r103.length() <= 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L17;
        r102 = r103;
    L17:
        if (r102 == null) goto L21;
        return new Pair(Boolean.TRUE, r102);
    L14:
        r104 = false;
    L21:
        return new Pair(Boolean.FALSE, "");
    }

    public final Pair<String, String> parseAmountAndDesc(AssetInfoBean r100, int r101) {
        boolean r102 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == true) goto L13;
        if (r101 != (-1)) goto L13;
        boolean r104 = false;
    L14:
        Pair<String, String> r105 = new Pair("", "");
        Pair<String, String> r106 = null;
        if (r104 == true) goto L20;
        if (r100 == null) goto L18;
        AssetInfoBean.AssetExtensionShowInfo r107 = r100.asset_extension_show_info;
    L19:
        AssetInfoUtil r108 = INSTANCE;
        r106 = new Pair(parseStandardShowAmount$default(r108, r107, false, 2, null), parseStandardRecDesc$default(r108, r107, false, 2, null));
    L31:
        if (r106 != null) goto L34;
        return r105;
    L34:
        return r106;
    L18:
        r107 = null;
        goto L19
    L20:
        if (r101 != (-1)) goto L28;
        if (r100 != null) goto L23;
    L25:
        r102 = false;
    L26:
        if (r102 == false) goto L28;
        AssetInfoBean.AssetToCombineAssetInfoBean r109 = r100.findDefaultCombineInfo();
    L29:
        if (r109 == null) goto L31;
        AssetInfoUtil r110 = INSTANCE;
        r106 = new Pair(parseCombineStandardShowAmount$default(r110, r109, false, 2, null), parseCombineStandardRecDesc$default(r110, r109, false, 2, null));
        goto L31
    L23:
        if (r100.isNeedCombine() != true) goto L25;
    L28:
        r109 = findCombineAssetInfo(r100, Integer.valueOf(r101));
    L13:
        r104 = true;
        goto L14
    L5:
        if (r100.isNeedCombine() != true) goto L7;
        r103 = true;
        goto L9
    }

    public final String parseBindCardPointCombineStandardRecDesc(AssetInfoBean.AssetToCombineAssetInfoBean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L11;
        HashMap<String, String> r102 = r100.standard_rec_desc_map;
        if (r102 == null) goto L12;
        String r103 = r102.get(r101);
        if (r103 != null) goto L10;
        return "";
    L10:
        return r103;
    L12:
        return "";
    L11:
        return "";
    }

    public final String parseBindCardPointCombineStandardShowAmount(AssetInfoBean.AssetToCombineAssetInfoBean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L11;
        HashMap<String, String> r102 = r100.standard_show_amount_map;
        if (r102 == null) goto L12;
        String r103 = r102.get(r101);
        if (r103 != null) goto L10;
        return "";
    L10:
        return r103;
    L12:
        return "";
    L11:
        return "";
    }

    public final String parseBindCardPointStandardRecDesc(AssetInfoBean.AssetExtensionShowInfo r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L11;
        HashMap<String, String> r102 = r100.standard_rec_desc_map;
        if (r102 == null) goto L12;
        String r103 = r102.get(r101);
        if (r103 != null) goto L10;
        return "";
    L10:
        return r103;
    L12:
        return "";
    L11:
        return "";
    }

    public final String parseBindCardPointStandardShowAmount(AssetInfoBean.AssetExtensionShowInfo r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L11;
        HashMap<String, String> r102 = r100.standard_show_amount_map;
        if (r102 == null) goto L12;
        String r103 = r102.get(r101);
        if (r103 != null) goto L10;
        return "";
    L10:
        return r103;
    L12:
        return "";
    L11:
        return "";
    }

    public final String parseCombinePayDesc1(AssetInfoBean.AssetToCombineAssetInfoBean r100, boolean r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        HashMap<String, String> r103 = r100.origin_asset_amount_desc_map;
    L6:
        if (r100 == null) goto L9;
        r102 = r100.origin_asset_amount_desc;
    L9:
        return parseStrFromMapWithFallback(r103, r102, r101);
    L5:
        r103 = null;
        goto L6
    }

    public final String parseCombinePayDesc1FromKey(AssetInfoBean.AssetToCombineAssetInfoBean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L8;
        HashMap<String, String> r102 = r100.origin_asset_amount_desc_map;
        if (r102 == null) goto L8;
        String r103 = r102.get(r101);
        if (r103 == null) goto L8;
    L18:
        if (r103 != null) goto L21;
        return "";
    L21:
        return r103;
    L8:
        r103 = null;
        if (r100 == null) goto L13;
        HashMap<String, String> r104 = r100.origin_asset_amount_desc_map;
        if (r104 == null) goto L13;
        String r105 = r104.get(AssetMapTag.RETAIN.getKey());
    L14:
        if (r105 != null) goto L17;
        if (r100 == null) goto L18;
        r103 = r100.origin_asset_amount_desc;
        goto L18
    L17:
        r103 = r105;
    L13:
        r105 = null;
        goto L14
    }

    public final String parseCombinePayDesc1WithPrefix(AssetInfoBean.AssetToCombineAssetInfoBean r100, boolean r101) {
        String r102 = parseCombinePayDesc1(r100, r101);
        if (r100 == null) goto L5;
        String r103 = r100.origin_asset_prefix_desc;
    L6:
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        return buildAmountDescWithPrefix(r102, r103);
    L5:
        r103 = null;
        goto L6
    }

    public final String parseCombinePayDesc2(AssetInfoBean.AssetToCombineAssetInfoBean r100, boolean r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        HashMap<String, String> r103 = r100.to_combine_asset_amount_desc_map;
    L6:
        if (r100 == null) goto L9;
        r102 = r100.to_combine_asset_amount_desc;
    L9:
        return parseStrFromMapWithFallback(r103, r102, r101);
    L5:
        r103 = null;
        goto L6
    }

    public final String parseCombinePayDesc2FromKey(AssetInfoBean.AssetToCombineAssetInfoBean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L8;
        HashMap<String, String> r102 = r100.to_combine_asset_amount_desc_map;
        if (r102 == null) goto L8;
        String r103 = r102.get(r101);
        if (r103 == null) goto L8;
    L18:
        if (r103 != null) goto L21;
        return "";
    L21:
        return r103;
    L8:
        r103 = null;
        if (r100 == null) goto L13;
        HashMap<String, String> r104 = r100.to_combine_asset_amount_desc_map;
        if (r104 == null) goto L13;
        String r105 = r104.get(AssetMapTag.RETAIN.getKey());
    L14:
        if (r105 != null) goto L17;
        if (r100 == null) goto L18;
        r103 = r100.to_combine_asset_amount_desc;
        goto L18
    L17:
        r103 = r105;
    L13:
        r105 = null;
        goto L14
    }

    public final String parseCombinePayDesc2WithPrefix(AssetInfoBean.AssetToCombineAssetInfoBean r100, boolean r101) {
        String r102 = parseCombinePayDesc2(r100, r101);
        if (r100 == null) goto L5;
        String r103 = r100.to_combine_asset_prefix_desc;
    L6:
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        return buildAmountDescWithPrefix(r102, r103);
    L5:
        r103 = null;
        goto L6
    }

    public final String parseCombinePayTitle1(AssetInfoBean.AssetToCombineAssetInfoBean r100, boolean r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        HashMap<String, String> r103 = r100.origin_asset_desc_map;
    L6:
        if (r100 == null) goto L9;
        r102 = r100.origin_asset_desc;
    L9:
        return parseStrFromMapWithFallback(r103, r102, r101);
    L5:
        r103 = null;
        goto L6
    }

    public final String parseCombinePayTitle1FromKey(AssetInfoBean.AssetToCombineAssetInfoBean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L8;
        HashMap<String, String> r102 = r100.origin_asset_desc_map;
        if (r102 == null) goto L8;
        String r103 = r102.get(r101);
        if (r103 == null) goto L8;
    L18:
        if (r103 != null) goto L21;
        return "";
    L21:
        return r103;
    L8:
        r103 = null;
        if (r100 == null) goto L13;
        HashMap<String, String> r104 = r100.origin_asset_desc_map;
        if (r104 == null) goto L13;
        String r105 = r104.get(AssetMapTag.RETAIN.getKey());
    L14:
        if (r105 != null) goto L17;
        if (r100 == null) goto L18;
        r103 = r100.origin_asset_desc;
        goto L18
    L17:
        r103 = r105;
    L13:
        r105 = null;
        goto L14
    }

    public final String parseCombinePayTitle2(AssetInfoBean.AssetToCombineAssetInfoBean r100, boolean r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        HashMap<String, String> r103 = r100.to_combine_asset_desc_map;
    L6:
        if (r100 == null) goto L9;
        r102 = r100.to_combine_asset_desc;
    L9:
        return parseStrFromMapWithFallback(r103, r102, r101);
    L5:
        r103 = null;
        goto L6
    }

    public final String parseCombinePayTitle2FromKey(AssetInfoBean.AssetToCombineAssetInfoBean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L8;
        HashMap<String, String> r102 = r100.to_combine_asset_desc_map;
        if (r102 == null) goto L8;
        String r103 = r102.get(r101);
        if (r103 == null) goto L8;
    L18:
        if (r103 != null) goto L21;
        return "";
    L21:
        return r103;
    L8:
        r103 = null;
        if (r100 == null) goto L13;
        HashMap<String, String> r104 = r100.to_combine_asset_desc_map;
        if (r104 == null) goto L13;
        String r105 = r104.get(AssetMapTag.RETAIN.getKey());
    L14:
        if (r105 != null) goto L17;
        if (r100 == null) goto L18;
        r103 = r100.to_combine_asset_desc;
        goto L18
    L17:
        r103 = r105;
    L13:
        r105 = null;
        goto L14
    }

    public final String parseCombineStandardRecDesc(AssetInfoBean.AssetToCombineAssetInfoBean r100, boolean r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        HashMap<String, String> r103 = r100.standard_rec_desc_map;
    L6:
        if (r100 == null) goto L9;
        r102 = r100.standard_rec_desc;
    L9:
        return parseStrFromMapWithFallback(r103, r102, r101);
    L5:
        r103 = null;
        goto L6
    }

    public final String parseCombineStandardShowAmount(AssetInfoBean.AssetToCombineAssetInfoBean r100, boolean r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        HashMap<String, String> r103 = r100.standard_show_amount_map;
    L6:
        if (r100 == null) goto L9;
        r102 = r100.standard_show_amount;
    L9:
        return parseStrFromMapWithFallback(r103, r102, r101);
    L5:
        r103 = null;
        goto L6
    }

    public final String parseStandardRecDesc(AssetInfoBean.AssetExtensionShowInfo r100, boolean r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        HashMap<String, String> r103 = r100.standard_rec_desc_map;
    L6:
        if (r100 == null) goto L9;
        r102 = r100.standard_rec_desc;
    L9:
        return parseStrFromMapWithFallback(r103, r102, r101);
    L5:
        r103 = null;
        goto L6
    }

    public final String parseStandardShowAmount(AssetInfoBean.AssetExtensionShowInfo r100, boolean r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        HashMap<String, String> r103 = r100.standard_show_amount_map;
    L6:
        if (r100 == null) goto L9;
        r102 = r100.standard_show_amount;
    L9:
        return parseStrFromMapWithFallback(r103, r102, r101);
    L5:
        r103 = null;
        goto L6
    }

    public final void setupAssetStandardParam(CJPayTradeConfirmBizContentBasicParams r100, CJPayPaymentMethodInfo r101) {
        if (r101 == null) goto L6;
        AssetInfoBean r102 = r101.asset_info;
        if (r102 == null) goto L6;
        AssetInfoBean.AssetToCombineAssetInfoBean r103 = r102.findDefaultCombineInfo();
    L7:
        if (r100 == null) goto L16;
        if (r103 == null) goto L17;
        AssetInfoBean.AssetMetaInfoBean r104 = r103.asset_meta_info;
        r100.fund_bill_index = r104.fund_bill_index;
        r100.uniqueSymbol = r104.getUniqueSymbol();
        r100.hasOptionVoucher = r103.isShowPaymentSelectionMaterial();
        r100.to_combine_asset_index = r103.to_combine_asset_index;
        ArrayList<AssetInfoBean.AssetMetaInfoBean> r105 = new ArrayList();
        AssetInfoBean r106 = r101.asset_info;
        if (r106 == null) goto L14;
        AssetInfoBean.AssetMetaInfoBean r107 = r106.asset_meta_info;
        if (r107 == null) goto L14;
        r105.add(r107);
    L14:
        r105.add(r103.asset_meta_info);
        r100.asset_meta_info_list = r105;
        return;
    L17:
        return;
    L16:
        return;
    L6:
        r103 = null;
        goto L7
    }

    private final AssetInfoBean changeAndFindSelectedAssetFromList(ArrayList<AssetInfoBean> r100, String r101, boolean r102) {
        Iterator<T> r103 = r100.iterator();
        AssetInfoBean r104 = null;
    L4:
        if (r103.hasNext() == false) goto L11;
        AssetInfoBean r105 = (AssetInfoBean) r103.next();
        if (Intrinsics.areEqual(r105.asset_meta_info.getUniqueSymbol(), r101) == true) goto L7;
        r105.asset_basic_show_info.choose = false;
        goto L4
    L7:
        if (r102 == false) goto L9;
        r105.asset_basic_show_info.choose = true;
    L9:
        r104 = r105;
        goto L4
    L11:
        return r104;
    }

    private final String parseStrFromMapWithFallback(HashMap<String, String> r100, String r101, boolean r102) {
        if (r102 == false) goto L13;
        String r103 = getValueByTag(r100, AssetMapTag.RETAIN);
        boolean r104 = false;
        if (r103 != null) goto L6;
    L11:
        if (r104 == false) goto L13;
        return r103;
    L6:
        if (r103.length() <= 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 != true) goto L11;
        r104 = true;
        goto L11
    L8:
        r105 = false;
    L13:
        String r106 = getValueByTag(r100, AssetMapTag.DEFAULT);
        if (r101 != null) goto L17;
        r101 = "";
    L17:
        return KtSafeMethodExtensionKt.or(r106, r101);
    }

    public final Pair<AssetInfoBean, AssetInfoBean> changeAndFindAssetWithId(ArrayList<AssetInfoBean> r100, String r101, boolean r102) {
        if (r100 == null) goto L35;
        if (r101 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L35;
        AssetInfoBean r104 = changeAndFindSelectedAssetFromList(r100, r101, r102);
        if (r104 != null) goto L16;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r100.iterator();
    L19:
        if (r106.hasNext() == false) goto L23;
        Object r107 = r106.next();
        if ((!((AssetInfoBean) r107).sub_asset_info_list.isEmpty()) == false) goto L19;
        r105.add(r107);
        goto L19
    L23:
        Iterator r108 = r105.iterator();
    L25:
        if (r108.hasNext() == false) goto L33;
        AssetInfoBean r109 = (AssetInfoBean) r108.next();
        AssetInfoBean r110 = INSTANCE.changeAndFindSelectedAssetFromList(r109.sub_asset_info_list, r101, r102);
        if (r110 == null) goto L25;
        if (r102 == false) goto L31;
        r109.asset_basic_show_info.choose = true;
        r110.asset_basic_show_info.choose = true;
    L31:
        return new Pair(r110, r109);
    L33:
        return new Pair(null, null);
    L16:
        return new Pair(r104, null);
    L7:
        if (StringsKt.isBlank(r101) == true) goto L10;
        r103 = false;
    L35:
        return new Pair(null, null);
    }

    public final AssetInfoBean changeAndFindSelectedAsset(ArrayList<AssetInfoBean> r100, String r101, boolean r102) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r101 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        if (r103 == true) goto L41;
        AssetInfoBean r104 = changeAndFindSelectedAssetFromList(r100, r101, r102);
        if (r104 != null) goto L28;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r100.iterator();
    L16:
        if (r106.hasNext() == false) goto L20;
        Object r107 = r106.next();
        if ((!((AssetInfoBean) r107).sub_asset_info_list.isEmpty()) == false) goto L16;
        r105.add(r107);
        goto L16
    L20:
        Iterator r108 = r105.iterator();
    L22:
        if (r108.hasNext() == false) goto L28;
        AssetInfoBean r109 = (AssetInfoBean) r108.next();
        if (INSTANCE.changeAndFindSelectedAssetFromList(r109.sub_asset_info_list, r101, r102) == null) goto L22;
        if (r102 == false) goto L27;
        r109.asset_basic_show_info.choose = true;
    L27:
        r104 = r109;
    L28:
        return r104;
    L41:
        return null;
    L6:
        if (StringsKt.isBlank(r101) == true) goto L9;
        r103 = false;
        goto L10
    }

    public final SpannableStringBuilder getTipsMsgInfo(AssetInfoBean r100, Context r101, TextView r102) {
        Intrinsics.checkNotNullParameter(r100, "assetInfo");
        ArrayList<UIComponent> r103 = r100.getTipsMsgInfo();
        boolean r104 = false;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        return null;
    L12:
        if (r102 == null) goto L14;
        WeakReference<TextView> r106 = new WeakReference(r102);
    L15:
        SpannableStringBuilder r107 = UIComponentSpannableParser.INSTANCE.convertComponentsToSpannable(r103, r101, null, r106);
        if (r107.length() <= 0) goto L18;
        r104 = true;
    L18:
        if (r104 == false) goto L20;
        return r107;
    L20:
        return null;
    L14:
        r106 = null;
        goto L15
    L5:
        if (r103.isEmpty() == true) goto L8;
        r105 = false;
        goto L10
    }

    public static /* synthetic */ String getValueByTag$default(AssetInfoUtil r100, HashMap r101, AssetMapTag r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = AssetMapTag.DEFAULT;
    L6:
        return r100.getValueByTag(r101, r102);
    }

    public static /* synthetic */ Pair parseAmountAndDesc$default(AssetInfoUtil r100, AssetInfoBean r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = -1;
    L6:
        return r100.parseAmountAndDesc(r101, r102);
    }

    public static /* synthetic */ String parseCombinePayDesc1$default(AssetInfoUtil r100, AssetInfoBean.AssetToCombineAssetInfoBean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.parseCombinePayDesc1(r101, r102);
    }

    public static /* synthetic */ String parseCombinePayDesc1WithPrefix$default(AssetInfoUtil r100, AssetInfoBean.AssetToCombineAssetInfoBean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.parseCombinePayDesc1WithPrefix(r101, r102);
    }

    public static /* synthetic */ String parseCombinePayDesc2$default(AssetInfoUtil r100, AssetInfoBean.AssetToCombineAssetInfoBean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.parseCombinePayDesc2(r101, r102);
    }

    public static /* synthetic */ String parseCombinePayDesc2WithPrefix$default(AssetInfoUtil r100, AssetInfoBean.AssetToCombineAssetInfoBean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.parseCombinePayDesc2WithPrefix(r101, r102);
    }

    public static /* synthetic */ String parseCombinePayTitle1$default(AssetInfoUtil r100, AssetInfoBean.AssetToCombineAssetInfoBean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.parseCombinePayTitle1(r101, r102);
    }

    public static /* synthetic */ String parseCombinePayTitle2$default(AssetInfoUtil r100, AssetInfoBean.AssetToCombineAssetInfoBean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.parseCombinePayTitle2(r101, r102);
    }

    public static /* synthetic */ String parseCombineStandardRecDesc$default(AssetInfoUtil r100, AssetInfoBean.AssetToCombineAssetInfoBean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.parseCombineStandardRecDesc(r101, r102);
    }

    public static /* synthetic */ String parseCombineStandardShowAmount$default(AssetInfoUtil r100, AssetInfoBean.AssetToCombineAssetInfoBean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.parseCombineStandardShowAmount(r101, r102);
    }

    public static /* synthetic */ String parseStandardRecDesc$default(AssetInfoUtil r100, AssetInfoBean.AssetExtensionShowInfo r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.parseStandardRecDesc(r101, r102);
    }

    public static /* synthetic */ String parseStandardShowAmount$default(AssetInfoUtil r100, AssetInfoBean.AssetExtensionShowInfo r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.parseStandardShowAmount(r101, r102);
    }

    public static /* synthetic */ Pair changeAndFindAssetWithId$default(AssetInfoUtil r100, ArrayList r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        return r100.changeAndFindAssetWithId(r101, r102, r103);
    }

    public static /* synthetic */ AssetInfoBean changeAndFindSelectedAsset$default(AssetInfoUtil r100, ArrayList r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        return r100.changeAndFindSelectedAsset(r101, r102, r103);
    }

    public static /* synthetic */ AssetInfoBean changeAndFindSelectedAssetFromList$default(AssetInfoUtil r100, ArrayList r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        return r100.changeAndFindSelectedAssetFromList(r101, r102, r103);
    }

    public static /* synthetic */ SpannableStringBuilder getTipsMsgInfo$default(AssetInfoUtil r100, AssetInfoBean r101, Context r102, TextView r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = null;
    L9:
        return r100.getTipsMsgInfo(r101, r102, r103);
    }

    public static /* synthetic */ String parseStrFromMapWithFallback$default(AssetInfoUtil r100, HashMap r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        return r100.parseStrFromMapWithFallback(r101, r102, r103);
    }
}
