package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.support;

import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.JumpInfoBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/support/CJStandardAssetUtils;", "", "()V", "buildSelectedMethodFromQueryResult", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "assetInfo", "topAssetList", "Lorg/json/JSONArray;", "getJumpInfo", "Lcom/android/ttcjpaysdk/base/ui/data/JumpInfoBean;", "usedAssetInfo", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJStandardAssetUtils {
    public static final CJStandardAssetUtils INSTANCE = null;

    static {
        INSTANCE = new CJStandardAssetUtils();
    }

    private CJStandardAssetUtils() {
    }

    public final JumpInfoBean getJumpInfo(AssetInfoBean r100) {
        if (r100 == null) goto L17;
        AssetInfoBean.AssetToCombineAssetInfoBean r101 = r100.findDefaultCombineInfo();
        if (r101 == null) goto L17;
        JumpInfoBean r102 = r101.jump_info;
        if (r102 == null) goto L17;
        if (r102.action.length() <= 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L15;
        r102 = null;
    L15:
        if (r102 == null) goto L17;
        return r102;
    L11:
        r103 = false;
    L17:
        if (r100 == null) goto L23;
        AssetInfoBean.AssetExtensionShowInfo r104 = r100.asset_extension_show_info;
        if (r104 != null) goto L21;
        return null;
    L21:
        return r104.jump_info;
    L23:
        return null;
    }

    public final AssetInfoBean buildSelectedMethodFromQueryResult(AssetInfoBean r100, JSONArray r101) {
        Intrinsics.checkNotNullParameter(r100, "assetInfo");
        String r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        ArrayList<AssetInfoBean> r103 = r100.sub_asset_info_list;
        Iterator<T> r104 = r103.iterator();
    L7:
        if (r104.hasNext() == false) goto L11;
        Object r105 = r104.next();
        if (((AssetInfoBean) r105).asset_basic_show_info.choose == false) goto L7;
    L12:
        AssetInfoBean r106 = (AssetInfoBean) r105;
        boolean r107 = true;
        if (r106 != null) goto L21;
        r106 = (AssetInfoBean) CollectionsKt.firstOrNull(r103);
        if (r106 == null) goto L17;
        r106.asset_basic_show_info.choose = true;
    L18:
        if (r106 != null) goto L21;
        return null;
    L17:
        r106 = null;
    L21:
        if (r106.findDefaultCombineInfo() == null) goto L64;
        int r108 = -1;
        if (r101.length() != 1) goto L26;
        AssetInfoBean r109 = r106.cp();
        AssetInfoBean.AssetCombinePayInfoBean r110 = r109.asset_combine_pay_info;
        r110.default_combine_asset_index = -1;
        r110.asset_to_combine_asset_info_list.clear();
        return r109;
    L26:
        int r111 = r106.asset_combine_pay_info.default_combine_asset_index;
        Iterator<T> r112 = r103.iterator();
    L28:
        if (r112.hasNext() == false) goto L35;
        Object r113 = r112.next();
        if (((AssetInfoBean) r113).asset_basic_show_info.index != r111) goto L32;
        boolean r114 = true;
    L33:
        if (r114 == false) goto L28;
    L36:
        AssetInfoBean r115 = (AssetInfoBean) r113;
        if (r115 == null) goto L41;
        AssetInfoBean.AssetMetaInfoBean r116 = r115.asset_meta_info;
        if (r116 == null) goto L41;
    L45:
        ArrayList<AssetInfoBean.AssetToCombineAssetInfoBean> r117 = r106.asset_combine_pay_info.asset_to_combine_asset_info_list;
        if (r116 == null) goto L48;
        r102 = r116.getUniqueSymbol();
    L48:
        if (r102 != null) goto L50;
    L53:
        if (r107 == true) goto L64;
        Iterator<AssetInfoBean.AssetToCombineAssetInfoBean> r118 = r117.iterator();
        int r119 = 0;
    L56:
        if (r118.hasNext() == false) goto L61;
        if (Intrinsics.areEqual(r118.next().asset_meta_info.getUniqueSymbol(), r102) == true) goto L59;
        r119 = r119 + 1;
        goto L56
    L59:
        r108 = r119;
    L61:
        if (r108 <= 0) goto L64;
        ListProtector.add(r117, 0, (AssetInfoBean.AssetToCombineAssetInfoBean) ListProtector.remove(r117, r108));
        goto L64
    L50:
        if (r102.length() == 0) goto L53;
        r107 = false;
    L41:
        AssetInfoBean.AssetToCombineAssetInfoBean r120 = (AssetInfoBean.AssetToCombineAssetInfoBean) CollectionsKt.firstOrNull(r106.asset_combine_pay_info.asset_to_combine_asset_info_list);
        if (r120 == null) goto L44;
        r116 = r120.asset_meta_info;
        goto L45
    L44:
        r116 = null;
        goto L45
    L32:
        r114 = false;
        goto L33
    L35:
        r113 = null;
    L64:
        return r106.cp();
    L11:
        r105 = null;
        goto L12
    }
}
