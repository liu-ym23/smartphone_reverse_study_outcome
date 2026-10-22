package com.android.ttcjpaysdk.thirdparty.front.counter.utils;

import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObjectExtensionKt;
import com.android.ttcjpaysdk.base.ui.component.tag.CJEventType;
import com.android.ttcjpaysdk.base.ui.component.tag.CJVoucherTagBean;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJOptionShowInfo;
import com.android.ttcjpaysdk.base.ui.data.CJOptionShowInfoDataExtInfo;
import com.android.ttcjpaysdk.std.asset.bean.StdAssetItemBean;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.OptionShowInfoStorage;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyMethodFoldBean;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyMethodGroupFoldBean;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyPayMethodTuple;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001LB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJp\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\u0006\u0010\u0016\u001a\u00020\u00172&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013j\b\u0012\u0004\u0012\u00020\u0001`\u0015H\u0002Jp\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\u0006\u0010\u0016\u001a\u00020\u00172&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013j\b\u0012\u0004\u0012\u00020\u0001`\u0015H\u0002J\u009c\u0001\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013j\b\u0012\u0004\u0012\u00020\u0001`\u00152\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110 2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\u0006\u0010\u0016\u001a\u00020\u00172&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u001a2\b\b\u0002\u0010%\u001a\u00020\u001a2\b\b\u0002\u0010&\u001a\u00020\u001aH\u0002J\u001c\u0010'\u001a\u00020\u000f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010 2\u0006\u0010)\u001a\u00020\"J\"\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010 2\b\u0010+\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010-\u001a\u00020.JH\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013j\b\u0012\u0004\u0012\u00020\u0001`\u00152\u0006\u00100\u001a\u00020\r2(\b\u0002\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001bJ\u0012\u00101\u001a\u0004\u0018\u00010\u00142\b\u00102\u001a\u0004\u0018\u00010\u0014JT\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013j\b\u0012\u0004\u0012\u00020\u0001`\u00152\b\u00102\u001a\u0004\u0018\u00010\u00142(\b\u0002\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b2\b\b\u0002\u0010&\u001a\u00020\u001aJ.\u00104\u001a\u0004\u0018\u00010\u000b2\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00152\b\u00105\u001a\u0004\u0018\u00010\u0014J:\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013j\b\u0012\u0004\u0012\u00020\u0001`\u00152\u001a\u00107\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u00108\u001a\b\u0012\u0004\u0012\u00020\u00110 2\u0006\u00102\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J:\u00109\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u00112(\b\u0002\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001bH\u0002J\"\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010 2\b\u0010+\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010-\u001a\u00020.J)\u0010;\u001a\u0004\u0018\u00010\u000b2\b\u0010<\u001a\u0004\u0018\u00010\u00142\u0006\u00102\u001a\u00020\u00142\b\u0010=\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010>J(\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00142\b\u0010A\u001a\u0004\u0018\u00010B2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010 J(\u0010E\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00142\b\u0010A\u001a\u0004\u0018\u00010B2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010 J\u0014\u0010F\u001a\u00020\u001a2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00140 J\u0012\u0010H\u001a\u0004\u0018\u00010I2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0012\u0010J\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010 *\u00020\u0014J\n\u0010K\u001a\u00020\u0014*\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/utils/CJUnifyPayAssetInfoUtils;", "", "()V", "COMBINE_SUFFIX", "", "TAG", "buildCJVoucherTagBean", "Lcom/android/ttcjpaysdk/base/ui/component/tag/CJVoucherTagBean;", "voucherTagBean", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherTagBean;", "buildDefaultSelectMethod", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "unifyCashierRenderInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "buildGroupWithDisplayCount", "", "groupInfo", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetSelectPageGroupInfoBean;", "subAssetInfoList", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "Lkotlin/collections/ArrayList;", "eventType", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgBean$VoucherEventType;", "groupExpandedStatus", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "dataList", "buildGroupWithDisplayIndex", "buildPayMethodDataList", "groupInfoList", "", "parentGroupDisplayCount", "", "foldDescribe", "includeEnhanceIconHeader", "applyGroupFoldGating", "useDisplayIndex", "changeListCheck", "list", "targetIndex", "getCJVoucherTag56List", "voucherMsgBean", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgBean;", "tagType", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/utils/CJUnifyPayAssetInfoUtils$CJTagType;", "getCombinePayDisplayList", "cashierInfo", "getDefaultAssetInfo", "assetInfo", "getDefaultPayDisplayList", "getDefaultPayTuple", "defaultSelectedAsset", "getFlatPayMethodDataList", "assetInfoList", "getHomePageGroupInfoList", "getItemShowCount", "getRecommendTagList", "getSelectCombinePayTuple", "rootAssetInfoBean", "currentSelectIndex", "(Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;Ljava/lang/Integer;)Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "getSubTitle", "assetInfoBean", "optionShowInfoStorage", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/OptionShowInfoStorage;", "optionShowInfoList", "Lcom/android/ttcjpaysdk/base/ui/data/CJOptionShowInfo;", "getTitle", "isFoldHasChosenAsset", "foldMethods", "resolveFoldStyleDisplayInfo", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$FoldStyleDisplayInfo;", "getOptionShowInfoList", "getRealSelect", "CJTagType", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayAssetInfoUtils {
    private static final String COMBINE_SUFFIX = "_combine";
    public static final CJUnifyPayAssetInfoUtils INSTANCE = null;
    private static final String TAG = "CJUnifyPayAssetInfoUtils";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/utils/CJUnifyPayAssetInfoUtils$CJTagType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "FILL_LIGHT", "STROKE", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum CJTagType extends Enum<CJTagType> {
        private static final /* synthetic */ CJTagType[] $VALUES = null;
        public static final CJTagType FILL_LIGHT = null;
        public static final CJTagType STROKE = null;
        private final String type;

        private static final /* synthetic */ CJTagType[] $values() {
            return new CJTagType[]{FILL_LIGHT, STROKE};
        }

        public static CJTagType valueOf(String r100) {
            return (CJTagType) a.a(CJTagType.class, r100);
        }

        public static CJTagType[] values() {
            return (CJTagType[]) $VALUES.clone();
        }

        static {
            FILL_LIGHT = new CJTagType("FILL_LIGHT", 0, "FILL_LIGHT");
            STROKE = new CJTagType("STROKE", 1, "STROKE");
            $VALUES = $values();
        }

        public final String getType() {
            return this.type;
        }

        private CJTagType(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    static {
        INSTANCE = new CJUnifyPayAssetInfoUtils();
    }

    private CJUnifyPayAssetInfoUtils() {
    }

    private final CJVoucherTagBean buildCJVoucherTagBean(AssetInfoBean.VoucherTagBean r100) {
        return (CJVoucherTagBean) CJPayJsonParser.fromJson(String.valueOf(CJPayObjectExtensionKt.toJson(r100)), CJVoucherTagBean.class);
    }

    public final CJUnifyPayMethodTuple buildDefaultSelectMethod(UnifyCashierRenderInfo r100) {
        ArrayList<AssetInfoBean> r101 = null;
        if (r100 == null) goto L5;
        AssetInfoBean r102 = r100.asset_info;
    L6:
        AssetInfoBean r103 = getDefaultAssetInfo(r102);
        if (r100 == null) goto L12;
        AssetInfoBean r104 = r100.asset_info;
        if (r104 == null) goto L12;
        r101 = r104.sub_asset_info_list;
    L12:
        return getDefaultPayTuple(r101, r103);
    L5:
        r102 = null;
        goto L6
    }

    public final AssetInfoBean getDefaultAssetInfo(AssetInfoBean r100) {
        Object r101 = null;
        if (r100 == null) goto L16;
        ArrayList<AssetInfoBean> r102 = r100.sub_asset_info_list;
        if (r102 == null) goto L16;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        Object r104 = r103.next();
        if (((AssetInfoBean) r104).asset_basic_show_info.choose == false) goto L8;
    L13:
        AssetInfoBean r105 = (AssetInfoBean) r104;
        if (r105 != null) goto L17;
        r105 = (AssetInfoBean) CollectionsKt.firstOrNull(r102);
    L17:
        if (r105 != null) goto L19;
    L28:
        return r105;
    L19:
        if ((!r105.sub_asset_info_list.isEmpty()) == false) goto L28;
        Iterator<T> r106 = r105.sub_asset_info_list.iterator();
    L22:
        if (r106.hasNext() == false) goto L26;
        Object r107 = r106.next();
        if (((AssetInfoBean) r107).asset_basic_show_info.choose == false) goto L22;
        r101 = r107;
    L26:
        if (r101 != null) goto L28;
        ((AssetInfoBean) ListProtector.get(r105.sub_asset_info_list, 0)).asset_basic_show_info.choose = true;
        Unit r108 = Unit.INSTANCE;
        goto L28
    L12:
        r104 = null;
    L16:
        r105 = null;
        goto L17
    }

    public final List<CJOptionShowInfo> getOptionShowInfoList(AssetInfoBean r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.asset_extension_show_info.option_show_info_list;
    }

    public final AssetInfoBean getRealSelect(AssetInfoBean r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((!r100.sub_asset_info_list.isEmpty()) == false) goto L16;
        Iterator<T> r101 = r100.sub_asset_info_list.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        if (((AssetInfoBean) r102).asset_basic_show_info.choose == false) goto L6;
    L11:
        AssetInfoBean r103 = (AssetInfoBean) r102;
        if (r103 == null) goto L14;
        return r103;
    L14:
        return (AssetInfoBean) ListProtector.get(r100.sub_asset_info_list, 0);
    L10:
        r102 = null;
        goto L11
    L16:
        return r100;
    }

    public final boolean isFoldHasChosenAsset(List<AssetInfoBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "foldMethods");
        if (r100.isEmpty() == false) goto L5;
        return false;
    L5:
        List<AssetInfoBean> r101 = r100;
        if ((r101 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L42;
        AssetInfoBean r103 = (AssetInfoBean) r102.next();
        if (r103.asset_basic_show_info.choose == true) goto L29;
        ArrayList<AssetInfoBean> r104 = r103.sub_asset_info_list;
        if ((r104 instanceof Collection) == true) goto L18;
    L20:
        Iterator<T> r105 = r104.iterator();
    L22:
        if (r105.hasNext() == false) goto L19;
        if (((AssetInfoBean) r105.next()).asset_basic_show_info.choose == false) goto L22;
        boolean r106 = true;
    L26:
        if (r106 == true) goto L29;
        boolean r107 = false;
    L30:
        if (r107 == false) goto L12;
        return true;
    L19:
        r106 = false;
        goto L26
    L18:
        if (r104.isEmpty() == false) goto L20;
    L29:
        r107 = true;
        goto L30
    L42:
        return false;
    L8:
        if (r101.isEmpty() == false) goto L10;
        return false;
    }

    public final AssetInfoBean.FoldStyleDisplayInfo resolveFoldStyleDisplayInfo(UnifyCashierRenderInfo r100) {
        if (r100 == null) goto L10;
        AssetInfoBean r101 = r100.asset_info;
        if (r101 == null) goto L10;
        AssetInfoBean.AssetPrimaryShowInfoBean r102 = r101.asset_primary_show_info;
        if (r102 == null) goto L10;
        AssetInfoBean.AssetHomePageGroupInfo r103 = r102.asset_home_page_group_info;
        if (r103 == null) goto L10;
        return r103.fold_style_display_info;
    L10:
        return null;
    }

    private final List<AssetInfoBean.AssetSelectPageGroupInfoBean> getHomePageGroupInfoList(AssetInfoBean r100, AssetInfoBean.VoucherMsgBean.VoucherEventType r101) {
        ArrayList<AssetInfoBean.AssetSelectPageGroupInfoBean> r102 = r100.asset_primary_show_info.asset_home_page_group_info.home_page_group_info_list;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L12;
        Object r105 = r104.next();
        boolean r106 = false;
        boolean r107 = StringsKt.endsWith$default(((AssetInfoBean.AssetSelectPageGroupInfoBean) r105).group_type, COMBINE_SUFFIX, false, 2, null);
        if (r101 != AssetInfoBean.VoucherMsgBean.VoucherEventType.COMBINE_PAY) goto L8;
        r106 = r107;
    L10:
        if (r106 == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        if (r107 == true) goto L10;
        r106 = true;
        goto L10
    L12:
        return r103;
    }

    private final int getItemShowCount(AssetInfoBean.AssetSelectPageGroupInfoBean r100, HashMap<String, Boolean> r101) {
        int r102 = r100.asset_index_list.size();
        if (r101 == null) goto L5;
        Boolean r103 = r101.get(r100.group_type);
    L6:
        if (r103 == null) goto L8;
        boolean r104 = r103.booleanValue();
    L9:
        if (r104 == true) goto L15;
        int r105 = r100.display_count;
        if (r105 == 0) goto L16;
        if (r102 > r105) goto L14;
        return r102;
    L14:
        return r105;
    L16:
        return r102;
    L15:
        return r102;
    L8:
        r104 = false;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    public final void changeListCheck(List<? extends Object> r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "list");
        ArrayList r100 = new ArrayList();
        Iterator<T> r112 = r110.iterator();
    L4:
        if (r112.hasNext() == false) goto L8;
        Object r101 = r112.next();
        if ((r101 instanceof StdAssetItemBean) == false) goto L4;
        r100.add(r101);
        goto L4
    L8:
        Iterator r113 = r100.iterator();
        StdAssetItemBean r102 = null;
        Object r103 = null;
        int r104 = 0;
    L9:
        boolean r105 = true;
        if (r113.hasNext() == false) goto L59;
        Object r106 = r113.next();
        int r107 = r104 + 1;
        if (r104 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        StdAssetItemBean r108 = (StdAssetItemBean) r106;
        ArrayList<StdAssetItemBean> r109 = r108.getSubPaymentItem();
        if (r104 == 0) goto L17;
    L32:
        r108.changeAssetInfoBeanChoose(false);
        if (r108.getIndex() != r111) goto L36;
        r102 = r108;
    L36:
        if ((r109 instanceof Collection) == true) goto L38;
    L40:
        Iterator<T> r114 = r109.iterator();
    L42:
        if (r114.hasNext() == false) goto L39;
        if (((StdAssetItemBean) r114.next()).getIndex() != r111) goto L46;
        boolean r115 = true;
    L47:
        if (r115 == false) goto L42;
    L48:
        if (r105 == true) goto L51;
        r109 = null;
    L51:
        if (r109 == null) goto L58;
        Iterator<T> r116 = r109.iterator();
    L54:
        if (r116.hasNext() == false) goto L58;
        StdAssetItemBean r117 = (StdAssetItemBean) r116.next();
        r117.changeAssetInfoBeanChoose(false);
        if (r117.getIndex() != r111) goto L54;
        r102 = r108;
        r103 = r117;
    L58:
        r104 = r107;
        goto L9
    L46:
        r115 = false;
    L39:
        r105 = false;
        goto L48
    L38:
        if (r109.isEmpty() == false) goto L40;
    L17:
        if ((!r109.isEmpty()) == true) goto L19;
    L31:
        r102 = r108;
        goto L32
    L19:
        if ((r109 instanceof Collection) == true) goto L21;
    L23:
        Iterator<T> r118 = r109.iterator();
    L25:
        if (r118.hasNext() == false) goto L22;
        if (((StdAssetItemBean) r118.next()).isChecked() == false) goto L25;
        boolean r119 = true;
    L29:
        if (r119 == true) goto L31;
        r103 = CollectionsKt.firstOrNull(r109);
    L22:
        r119 = false;
        goto L29
    L21:
        if (r109.isEmpty() == false) goto L23;
    L59:
        if (r102 == null) goto L61;
        r102.changeAssetInfoBeanChoose(true);
    L61:
        StdAssetItemBean r120 = (StdAssetItemBean) r103;
        if (r120 == null) goto L85;
        r120.changeAssetInfoBeanChoose(true);
        return;
    }

    public final List<CJVoucherTagBean> getCJVoucherTag56List(AssetInfoBean.VoucherMsgBean r100, CJTagType r101) {
        Intrinsics.checkNotNullParameter(r101, "tagType");
        if (r100 == null) goto L13;
        ArrayList<AssetInfoBean.VoucherTagBean> r102 = r100.tag56;
        if (r102 == null) goto L13;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L18;
        AssetInfoBean.VoucherTagBean r105 = (AssetInfoBean.VoucherTagBean) r104.next();
        CJVoucherTagBean r106 = INSTANCE.buildCJVoucherTagBean(r105);
        if (StringsKt.isBlank(r106.style_type) == false) goto L12;
        r106.style_type = CJEventType.DEFAULT.getTypeStr();
    L12:
        r106.tag_type = r101.getType();
        r103.add(r106);
        goto L8
    L18:
        return r103;
    L13:
        return null;
    }

    public final ArrayList<Object> getCombinePayDisplayList(UnifyCashierRenderInfo r110, HashMap<String, Boolean> r111) {
        Intrinsics.checkNotNullParameter(r110, "cashierInfo");
        AssetInfoBean r112 = r110.asset_info;
        if (r112 == null) goto L5;
        AssetInfoBean.VoucherMsgBean.VoucherEventType r100 = AssetInfoBean.VoucherMsgBean.VoucherEventType.COMBINE_PAY;
        List<AssetInfoBean.AssetSelectPageGroupInfoBean> r101 = getHomePageGroupInfoList(r112, r100);
        ArrayList<AssetInfoBean> r102 = r112.sub_asset_info_list;
        AssetInfoBean.AssetHomePageGroupInfo r113 = r112.asset_primary_show_info.asset_home_page_group_info;
        return buildPayMethodDataList$default(this, r101, r102, r100, r111, r113.display_count, r113.fold_describe, true, false, false, 256, null);
    L5:
        return new ArrayList();
    }

    public final CJUnifyPayMethodTuple getDefaultPayTuple(ArrayList<AssetInfoBean> r100, AssetInfoBean r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        AssetInfoBean.AssetCombinePayInfoBean r102 = r101.asset_combine_pay_info;
        Iterator<T> r103 = r102.asset_to_combine_asset_info_list.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (((AssetInfoBean.AssetToCombineAssetInfoBean) r104).btn_is_checked == false) goto L7;
    L12:
        AssetInfoBean.AssetToCombineAssetInfoBean r105 = (AssetInfoBean.AssetToCombineAssetInfoBean) r104;
        if (r105 == null) goto L28;
        if (r100 == null) goto L28;
        Iterator<T> r106 = r100.iterator();
    L17:
        if (r106.hasNext() == false) goto L21;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((AssetInfoBean) r107).asset_meta_info.getUniqueSymbol(), r105.asset_meta_info.getUniqueSymbol()) == false) goto L17;
    L22:
        AssetInfoBean r108 = (AssetInfoBean) r107;
        if (r108 == null) goto L28;
        if (r102.isLimit() == false) goto L27;
        CJUnifyPayMethodTuple r109 = new CJUnifyPayMethodTuple(r101, r108);
    L29:
        if (r109 == null) goto L31;
        return r109;
    L31:
        return new CJUnifyPayMethodTuple(r101, null, 2, null);
    L27:
        r109 = new CJUnifyPayMethodTuple(r108, r101);
        goto L29
    L21:
        r107 = null;
    L28:
        r109 = null;
        goto L29
    L11:
        r104 = null;
        goto L12
    }

    public final ArrayList<Object> getFlatPayMethodDataList(ArrayList<AssetInfoBean> r110, AssetInfoBean.VoucherMsgBean.VoucherEventType r111) {
        Intrinsics.checkNotNullParameter(r111, "eventType");
        ArrayList<Object> r100 = new ArrayList();
        AssetInfoBean.AssetSelectPageGroupInfoBean r101 = new AssetInfoBean.AssetSelectPageGroupInfoBean();
        r101.group_title = "付款方式";
        r100.add(r101);
        int r102 = 0;
        if (r110 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        return r100;
    L12:
        if ((r110 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r104 = r110.iterator();
    L18:
        if (r104.hasNext() == false) goto L15;
        if (((AssetInfoBean) r104.next()).asset_basic_show_info.choose == false) goto L18;
        boolean r105 = true;
    L22:
        Iterator<T> r112 = r110.iterator();
    L24:
        if (r112.hasNext() == false) goto L33;
        Object r106 = r112.next();
        int r107 = r102 + 1;
        if (r102 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        StdAssetItemBean r108 = new StdAssetItemBean((AssetInfoBean) r106, r111, null, 4, null);
        if (r105 == true) goto L32;
        if (r102 != 0) goto L32;
        r108.changeAssetInfoBeanChoose(true);
    L32:
        r100.add(r108);
        r102 = r107;
        goto L24
    L33:
        return r100;
    L15:
        r105 = false;
        goto L22
    L14:
        if (r110.isEmpty() == false) goto L16;
    L5:
        if (r110.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    public final List<CJVoucherTagBean> getRecommendTagList(AssetInfoBean.VoucherMsgBean r100, CJTagType r101) {
        Intrinsics.checkNotNullParameter(r101, "tagType");
        if (r100 == null) goto L13;
        ArrayList<AssetInfoBean.VoucherTagBean> r102 = r100.recommend_tag;
        if (r102 == null) goto L13;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L18;
        AssetInfoBean.VoucherTagBean r105 = (AssetInfoBean.VoucherTagBean) r104.next();
        CJVoucherTagBean r106 = INSTANCE.buildCJVoucherTagBean(r105);
        if (StringsKt.isBlank(r106.style_type) == false) goto L12;
        r106.style_type = CJEventType.DEFAULT.getTypeStr();
    L12:
        r106.tag_type = r101.getType();
        r103.add(r106);
        goto L8
    L18:
        return r103;
    L13:
        return null;
    }

    public final ArrayList<Object> getDefaultPayDisplayList(AssetInfoBean r110, HashMap<String, Boolean> r111, boolean r112) {
        if (r110 == null) goto L4;
        AssetInfoBean.VoucherMsgBean.VoucherEventType r100 = AssetInfoBean.VoucherMsgBean.VoucherEventType.DEFAULT;
        List<AssetInfoBean.AssetSelectPageGroupInfoBean> r101 = getHomePageGroupInfoList(r110, r100);
        ArrayList<AssetInfoBean> r102 = r110.sub_asset_info_list;
        AssetInfoBean.AssetHomePageGroupInfo r113 = r110.asset_primary_show_info.asset_home_page_group_info;
        return buildPayMethodDataList$default(this, r101, r102, r100, r111, r113.display_count, r113.fold_describe, false, false, r112, 192, null);
    L4:
        return new ArrayList();
    }

    public final CJUnifyPayMethodTuple getSelectCombinePayTuple(AssetInfoBean r110, AssetInfoBean r111, Integer r112) {
        Intrinsics.checkNotNullParameter(r111, "assetInfo");
        ArrayList<AssetInfoBean.AssetToCombineAssetInfoBean> r100 = r111.asset_combine_pay_info.asset_to_combine_asset_info_list;
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        if (r111.isLimitAsset() == true) goto L8;
        CJReporter r101 = CJReporter.f202294a;
        CJReporter.k(CJPayCallBackCenter.getInstance().getCjContext(), "unify_pay_combine_create_fail", 1, r111.asset_meta_info.asset_id);
    L8:
        Iterator<T> r102 = r100.iterator();
    L10:
        if (r102.hasNext() == false) goto L20;
        Object r103 = r102.next();
        int r104 = ((AssetInfoBean.AssetToCombineAssetInfoBean) r103).to_combine_asset_index;
        if (r112 != null) goto L15;
    L17:
        boolean r105 = false;
    L18:
        if (r105 == false) goto L10;
    L22:
        if (r103 != null) goto L24;
        r103 = CollectionsKt.firstOrNull(r100);
        CJLogger.d(TAG, "currentSelect:" + r112 + " is null, select first asset");
    L24:
        if (r103 != null) goto L27;
        CJLogger.b(TAG, "没有找到可组合的资产，无法构建组合支付");
        return null;
    L27:
        if (r110 == null) goto L44;
        ArrayList<AssetInfoBean> r113 = r110.sub_asset_info_list;
        if (r113 == null) goto L44;
        Iterator<T> r114 = r113.iterator();
    L32:
        if (r114.hasNext() == false) goto L39;
        Object r115 = r114.next();
        if (((AssetInfoBean) r115).asset_basic_show_info.index != ((AssetInfoBean.AssetToCombineAssetInfoBean) r103).to_combine_asset_index) goto L36;
        boolean r106 = true;
    L37:
        if (r106 == false) goto L32;
    L40:
        AssetInfoBean r116 = (AssetInfoBean) r115;
        if (r116 == null) goto L44;
        return new CJUnifyPayMethodTuple(r111, r116);
    L36:
        r106 = false;
        goto L37
    L39:
        r115 = null;
    L44:
        StringBuilder r117 = new StringBuilder("没有找到可组合的资产，无法构建组合支付 ");
        AssetInfoBean.AssetToCombineAssetInfoBean r107 = (AssetInfoBean.AssetToCombineAssetInfoBean) r103;
        r117.append(r107.to_combine_asset_index);
        CJLogger.b(TAG, r117.toString());
        CJReporter r118 = CJReporter.f202294a;
        CJReporter.k(CJPayCallBackCenter.getInstance().getCjContext(), "unify_pay_combine_create_fail", 1, r107.to_combine_asset_desc + '_' + r107.to_combine_asset_index);
        return null;
    L15:
        if (r104 != r112.intValue()) goto L17;
        r105 = true;
        goto L18
    L20:
        r103 = null;
        goto L22
    }

    public final String getSubTitle(AssetInfoBean r100, OptionShowInfoStorage r101, List<CJOptionShowInfo> r102) {
        Intrinsics.checkNotNullParameter(r100, "assetInfoBean");
        Object r103 = null;
        if (r101 == null) goto L5;
        CJOptionShowInfoDataExtInfo r104 = r101.getExtInfo(r102);
    L6:
        String r105 = r100.asset_extension_show_info.select_page_show_info.select_page_priority_sub_title;
        String r106 = r100.asset_basic_show_info.sub_title;
        if (r104 == null) goto L20;
        Iterator r107 = CollectionsKt.listOf(new String[]{r104.select_page_priority_sub_title, r105, r106}).iterator();
    L10:
        if (r107.hasNext() == false) goto L17;
        Object r108 = r107.next();
        if (((String) r108).length() <= 0) goto L14;
        boolean r109 = true;
    L15:
        if (r109 == false) goto L10;
        r103 = r108;
        goto L17
    L14:
        r109 = false;
    L17:
        String r110 = (String) r103;
        if (r110 != null) goto L33;
        return "";
    L33:
        return r110;
    L20:
        Iterator r111 = CollectionsKt.listOf(new String[]{r105, r106}).iterator();
    L22:
        if (r111.hasNext() == false) goto L29;
        Object r112 = r111.next();
        if (((String) r112).length() <= 0) goto L26;
        boolean r113 = true;
    L27:
        if (r113 == false) goto L22;
        r103 = r112;
        goto L29
    L26:
        r113 = false;
    L29:
        r110 = (String) r103;
        if (r110 != null) goto L33;
        return "";
    L5:
        r104 = null;
        goto L6
    }

    public final String getTitle(AssetInfoBean r100, OptionShowInfoStorage r101, List<CJOptionShowInfo> r102) {
        Intrinsics.checkNotNullParameter(r100, "assetInfoBean");
        Object r103 = null;
        if (r101 == null) goto L5;
        CJOptionShowInfoDataExtInfo r104 = r101.getExtInfo(r102);
    L6:
        String r105 = r100.asset_extension_show_info.select_page_show_info.select_page_priority_title;
        String r106 = r100.asset_basic_show_info.title;
        if (r104 == null) goto L20;
        Iterator r107 = CollectionsKt.listOf(new String[]{r104.select_page_priority_title, r105, r106}).iterator();
    L10:
        if (r107.hasNext() == false) goto L17;
        Object r108 = r107.next();
        if (((String) r108).length() <= 0) goto L14;
        boolean r109 = true;
    L15:
        if (r109 == false) goto L10;
        r103 = r108;
        goto L17
    L14:
        r109 = false;
    L17:
        String r110 = (String) r103;
        if (r110 != null) goto L33;
        return "";
    L33:
        return r110;
    L20:
        Iterator r111 = CollectionsKt.listOf(new String[]{r105, r106}).iterator();
    L22:
        if (r111.hasNext() == false) goto L29;
        Object r112 = r111.next();
        if (((String) r112).length() <= 0) goto L26;
        boolean r113 = true;
    L27:
        if (r113 == false) goto L22;
        r103 = r112;
        goto L29
    L26:
        r113 = false;
    L29:
        r110 = (String) r103;
        if (r110 != null) goto L33;
        return "";
    L5:
        r104 = null;
        goto L6
    }

    private final void buildGroupWithDisplayCount(AssetInfoBean.AssetSelectPageGroupInfoBean r210, ArrayList<AssetInfoBean> r211, AssetInfoBean.VoucherMsgBean.VoucherEventType r212, HashMap<String, Boolean> r213, ArrayList<Object> r214) {
        int r100 = getItemShowCount(r210, r213);
        ArrayList r101 = new ArrayList(r210.asset_index_list);
        if ((!r101.isEmpty()) == true) goto L7;
        r101 = null;
    L7:
        if (r101 == null) goto L34;
        Iterator r102 = r101.iterator();
        CJUnifyMethodFoldBean r103 = null;
        int r104 = 0;
    L10:
        if (r102.hasNext() == false) goto L35;
        Object r110 = r102.next();
        Iterator<T> r111 = r211.iterator();
    L13:
        if (r111.hasNext() == false) goto L23;
        Object r112 = r111.next();
        int r113 = ((AssetInfoBean) r112).asset_basic_show_info.index;
        if ((r110 instanceof Integer) == true) goto L18;
    L20:
        boolean r114 = false;
    L21:
        if (r114 == false) goto L13;
    L24:
        AssetInfoBean r115 = (AssetInfoBean) r112;
        if (r115 == null) goto L10;
        if (r104 < r100) goto L32;
        if (r103 != null) goto L29;
        CJUnifyMethodFoldBean r116 = new CJUnifyMethodFoldBean(r210.group_type, r210.fold_desc);
        r214.add(r116);
        r103 = r116;
    L29:
        ArrayList<Object> r117 = r103.getFoldItemList();
        if (r117 == null) goto L33;
        r117.add(new StdAssetItemBean(r115, r212, null, 4, null));
    L33:
        r104 = r104 + 1;
        goto L10
    L32:
        r214.add(new StdAssetItemBean(r115, r212, null, 4, null));
        goto L33
    L18:
        if (r113 != ((Number) r110).intValue()) goto L20;
        r114 = true;
        goto L21
    L23:
        r112 = null;
    L35:
        ArrayList r105 = new ArrayList(r210.can_display_icon_asset_index_list);
        if ((!r105.isEmpty()) == true) goto L39;
        r105 = null;
    L39:
        if (r105 == null) goto L62;
        Iterator r106 = r105.iterator();
    L42:
        if (r106.hasNext() == false) goto L87;
        Object r107 = r106.next();
        Iterator<T> r108 = r211.iterator();
    L45:
        if (r108.hasNext() == false) goto L55;
        Object r109 = r108.next();
        int r118 = ((AssetInfoBean) r109).asset_basic_show_info.index;
        if ((r107 instanceof Integer) == true) goto L50;
    L52:
        boolean r119 = false;
    L53:
        if (r119 == false) goto L45;
    L56:
        AssetInfoBean r120 = (AssetInfoBean) r109;
        if (r120 == null) goto L42;
        if (r103 == null) goto L42;
        ArrayList<String> r121 = r103.getFoldItemIconList();
        if (r121 == null) goto L42;
        r121.add(r120.asset_basic_show_info.icon_url);
        goto L42
    L50:
        if (r118 != ((Number) r107).intValue()) goto L52;
        r119 = true;
        goto L53
    L55:
        r109 = null;
        goto L56
    L87:
        return;
    L62:
        return;
    L34:
        r103 = null;
        goto L35
    }

    private final void buildGroupWithDisplayIndex(AssetInfoBean.AssetSelectPageGroupInfoBean r110, ArrayList<AssetInfoBean> r210, AssetInfoBean.VoucherMsgBean.VoucherEventType r211, HashMap<String, Boolean> r212, ArrayList<Object> r213) {
        ArrayList r100 = new ArrayList(r110.display_index_list);
        ArrayList r101 = new ArrayList();
        Object r102 = null;
        if ((!r100.isEmpty()) == false) goto L5;
        ArrayList r103 = r100;
    L6:
        int r104 = 0;
        if (r103 == null) goto L27;
        Iterator r105 = r103.iterator();
    L10:
        if (r105.hasNext() == false) goto L27;
        Object r106 = r105.next();
        Iterator<T> r107 = r210.iterator();
    L13:
        if (r107.hasNext() == false) goto L23;
        Object r111 = r107.next();
        int r112 = ((AssetInfoBean) r111).asset_basic_show_info.index;
        if ((r106 instanceof Integer) == true) goto L18;
    L20:
        boolean r113 = false;
    L21:
        if (r113 == false) goto L13;
    L24:
        AssetInfoBean r114 = (AssetInfoBean) r111;
        if (r114 == null) goto L10;
        r101.add(new StdAssetItemBean(r114, r211, null, 4, null));
        goto L10
    L18:
        if (r112 != ((Number) r106).intValue()) goto L20;
        r113 = true;
        goto L21
    L23:
        r111 = null;
    L27:
        HashSet r108 = new HashSet(r100);
        ArrayList r109 = new ArrayList();
        ArrayList r115 = new ArrayList(r110.asset_index_list);
        if ((!r115.isEmpty()) == true) goto L31;
        r115 = null;
    L31:
        if (r115 == null) goto L54;
        Iterator r116 = r115.iterator();
    L34:
        if (r116.hasNext() == false) goto L54;
        Object r117 = r116.next();
        if (r108.contains(r117) == true) goto L34;
        Iterator<T> r118 = r210.iterator();
    L39:
        if (r118.hasNext() == false) goto L49;
        Object r119 = r118.next();
        int r120 = ((AssetInfoBean) r119).asset_basic_show_info.index;
        if ((r117 instanceof Integer) == true) goto L44;
    L46:
        boolean r121 = false;
    L47:
        if (r121 == false) goto L39;
    L50:
        AssetInfoBean r122 = (AssetInfoBean) r119;
        if (r122 == null) goto L34;
        r109.add(new StdAssetItemBean(r122, r211, null, 4, null));
        goto L34
    L44:
        if (r120 != ((Number) r117).intValue()) goto L46;
        r121 = true;
        goto L47
    L49:
        r119 = null;
    L54:
        if ((!r109.isEmpty()) == false) goto L83;
        CJUnifyMethodFoldBean r123 = new CJUnifyMethodFoldBean(r110.group_type, r110.fold_desc);
        r123.getFoldItemList().addAll(r109);
        ArrayList r124 = new ArrayList(r110.can_display_icon_asset_index_list);
        if ((!r124.isEmpty()) == true) goto L59;
        r124 = null;
    L59:
        if (r124 == null) goto L81;
        Iterator r125 = r124.iterator();
    L62:
        if (r125.hasNext() == false) goto L81;
        Object r126 = r125.next();
        Iterator<T> r127 = r210.iterator();
    L65:
        if (r127.hasNext() == false) goto L75;
        Object r128 = r127.next();
        int r129 = ((AssetInfoBean) r128).asset_basic_show_info.index;
        if ((r126 instanceof Integer) == true) goto L70;
    L72:
        boolean r130 = false;
    L73:
        if (r130 == false) goto L65;
    L76:
        AssetInfoBean r131 = (AssetInfoBean) r128;
        if (r131 == null) goto L62;
        ArrayList<String> r132 = r123.getFoldItemIconList();
        if (r132 == null) goto L62;
        r132.add(r131.asset_basic_show_info.icon_url);
        goto L62
    L70:
        if (r129 != ((Number) r126).intValue()) goto L72;
        r130 = true;
        goto L73
    L75:
        r128 = null;
    L81:
        r102 = r123;
    L83:
        if (r101.isEmpty() == false) goto L86;
        buildGroupWithDisplayCount(r110, r210, r211, r212, r213);
        return;
    L86:
        int r133 = r110.fold_cell_index;
        if (r102 != null) goto L89;
        r133 = -1;
    L89:
        if (r133 > 0) goto L91;
    L92:
        r133 = r101.size();
    L93:
        Iterator r134 = r101.iterator();
    L95:
        if (r134.hasNext() == false) goto L104;
        Object r135 = r134.next();
        int r136 = r104 + 1;
        if (r104 >= 0) goto L99;
        CollectionsKt.throwIndexOverflow();
    L99:
        r213.add((StdAssetItemBean) r135);
        if (r102 == null) goto L103;
        if (r136 != r133) goto L103;
        r213.add(r102);
    L103:
        r104 = r136;
        goto L95
    L104:
        return;
    L91:
        if (r133 <= r101.size()) goto L93;
    L5:
        r103 = null;
        goto L6
    }

    public static /* synthetic */ List getCJVoucherTag56List$default(CJUnifyPayAssetInfoUtils r100, AssetInfoBean.VoucherMsgBean r101, CJTagType r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = CJTagType.STROKE;
    L6:
        return r100.getCJVoucherTag56List(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArrayList getCombinePayDisplayList$default(CJUnifyPayAssetInfoUtils r100, UnifyCashierRenderInfo r101, HashMap r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.getCombinePayDisplayList(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ int getItemShowCount$default(CJUnifyPayAssetInfoUtils r100, AssetInfoBean.AssetSelectPageGroupInfoBean r101, HashMap r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.getItemShowCount(r101, r102);
    }

    public static /* synthetic */ List getRecommendTagList$default(CJUnifyPayAssetInfoUtils r100, AssetInfoBean.VoucherMsgBean r101, CJTagType r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = CJTagType.STROKE;
    L6:
        return r100.getRecommendTagList(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArrayList getDefaultPayDisplayList$default(CJUnifyPayAssetInfoUtils r100, AssetInfoBean r101, HashMap r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return r100.getDefaultPayDisplayList(r101, r102, r103);
    }

    private final ArrayList<Object> buildPayMethodDataList(List<AssetInfoBean.AssetSelectPageGroupInfoBean> r110, ArrayList<AssetInfoBean> r111, AssetInfoBean.VoucherMsgBean.VoucherEventType r112, HashMap<String, Boolean> r113, int r114, String r115, boolean r210, boolean r211, boolean r212) {
        ArrayList<Object> r100 = new ArrayList();
        if (r110.isEmpty() == false) goto L5;
        return r100;
    L5:
        Iterator<T> r116 = r110.iterator();
        int r101 = 0;
    L7:
        if (r116.hasNext() == false) goto L54;
        Object r102 = r116.next();
        int r117 = r101 + 1;
        if (r101 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        AssetInfoBean.AssetSelectPageGroupInfoBean r103 = (AssetInfoBean.AssetSelectPageGroupInfoBean) r102;
        Boolean r104 = null;
        if (r113 == null) goto L14;
        Boolean r105 = r113.get(r103.group_type);
    L15:
        if (r105 == null) goto L17;
        boolean r106 = r105.booleanValue();
    L19:
        if (r103.group_type.length() <= 0) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == true) goto L37;
        if (r210 == false) goto L38;
        AssetInfoBean.GroupEnhanceInfo r108 = r103.group_enhance_info;
        if (r108 == null) goto L33;
        String r109 = r108.enhance_title_icon;
        if (r109 == null) goto L33;
        if (r109.length() <= 0) goto L31;
        boolean r118 = true;
    L32:
        r104 = Boolean.valueOf(r118);
        goto L33
    L31:
        r118 = false;
    L33:
        if (r104 == null) goto L35;
        boolean r119 = r104.booleanValue();
    L36:
        if (r119 == false) goto L38;
    L35:
        r119 = false;
    L38:
        if (r211 == false) goto L47;
        if (r114 <= 0) goto L44;
        if (r101 < r114) goto L44;
        if (r106 == true) goto L44;
        r100.add(new CJUnifyMethodGroupFoldBean(r103.group_type, r115, true));
    L53:
        r101 = r117;
    L44:
        if (r103.is_folded == false) goto L47;
        if (r106 == true) goto L47;
        r100.add(new CJUnifyMethodGroupFoldBean(r103.group_type, r115, true));
    L47:
        if (r212 == true) goto L49;
    L52:
        INSTANCE.buildGroupWithDisplayCount(r103, r111, r112, r113, r100);
        goto L53
    L49:
        if ((!r103.display_index_list.isEmpty()) == false) goto L52;
        if (r106 == true) goto L52;
        INSTANCE.buildGroupWithDisplayIndex(r103, r111, r112, r113, r100);
    L37:
        r100.add(r103);
        goto L38
    L21:
        r107 = false;
        goto L22
    L17:
        r106 = false;
        goto L19
    L14:
        r105 = null;
        goto L15
    L54:
        return r100;
    }

    public static /* synthetic */ ArrayList buildPayMethodDataList$default(CJUnifyPayAssetInfoUtils r110, List r111, ArrayList r112, AssetInfoBean.VoucherMsgBean.VoucherEventType r113, HashMap r114, int r115, String r116, boolean r210, boolean r211, boolean r212, int r213, Object r214) {
        if ((r213 & 64) == 0) goto L5;
        boolean r117 = false;
    L7:
        if ((r213 & 128) == 0) goto L9;
        boolean r118 = true;
    L11:
        if ((r213 & 256) == 0) goto L13;
        boolean r119 = false;
    L15:
        return r110.buildPayMethodDataList(r111, r112, r113, r114, r115, r116, r117, r118, r119);
    L13:
        r119 = r212;
        goto L15
    L9:
        r118 = r211;
        goto L11
    L5:
        r117 = r210;
        goto L7
    }
}
