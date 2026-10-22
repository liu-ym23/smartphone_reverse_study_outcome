package com.android.ttcjpaysdk.std.asset.bean;

import com.android.ttcjpaysdk.base.service.bean.VoucherDialogExpandResult;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\b\u0016\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005¢\u0006\u0002\u0010\bB\u0005¢\u0006\u0002\u0010\tJ4\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!H\u0002J]\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010%\u001a\u00020\"2\u0006\u0010 \u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020#2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020#0(H\u0002Ja\u0010,\u001a\u00020\u00002\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020#2#\b\u0002\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020#0(R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR*\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0003j\b\u0012\u0004\u0012\u00020\u0017`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\r¨\u0006-"}, d2 = {"Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetListBean;", "", "groupInfoBeanList", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetSelectPageGroupInfoBean;", "Lkotlin/collections/ArrayList;", "assetInfoBeanList", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "()V", "getAssetInfoBeanList", "()Ljava/util/ArrayList;", "setAssetInfoBeanList", "(Ljava/util/ArrayList;)V", "expandResult", "Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;", "getExpandResult", "()Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;", "setExpandResult", "(Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;)V", "getGroupInfoBeanList", "setGroupInfoBeanList", "groupList", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetGroupBean;", "getGroupList", "setGroupList", "generateGroupBeanWithSubGroup", "", "group", "showIndexList", "", "", "collapse", "", "", "", "generateGroupBeanWithoutSubGroup", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "handleOptionVoucher", "optionVoucherStateCheck", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "info", "getAssetListData", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StdAssetListBean {
    private ArrayList<AssetInfoBean> assetInfoBeanList;
    private VoucherDialogExpandResult expandResult;
    private ArrayList<AssetInfoBean.AssetSelectPageGroupInfoBean> groupInfoBeanList;
    private ArrayList<StdAssetGroupBean> groupList;

    public StdAssetListBean() {
        this.groupList = new ArrayList();
        this.groupInfoBeanList = new ArrayList();
        this.assetInfoBeanList = new ArrayList();
    }

    public final ArrayList<AssetInfoBean> getAssetInfoBeanList() {
        return this.assetInfoBeanList;
    }

    public final VoucherDialogExpandResult getExpandResult() {
        return this.expandResult;
    }

    public final ArrayList<AssetInfoBean.AssetSelectPageGroupInfoBean> getGroupInfoBeanList() {
        return this.groupInfoBeanList;
    }

    public final ArrayList<StdAssetGroupBean> getGroupList() {
        return this.groupList;
    }

    public final void setAssetInfoBeanList(ArrayList<AssetInfoBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.assetInfoBeanList = r100;
    }

    public final void setExpandResult(VoucherDialogExpandResult r100) {
        this.expandResult = r100;
    }

    public final void setGroupInfoBeanList(ArrayList<AssetInfoBean.AssetSelectPageGroupInfoBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groupInfoBeanList = r100;
    }

    public final void setGroupList(ArrayList<StdAssetGroupBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groupList = r100;
    }

    public StdAssetListBean(ArrayList<AssetInfoBean.AssetSelectPageGroupInfoBean> r100, ArrayList<AssetInfoBean> r101) {
        Intrinsics.checkNotNullParameter(r100, "groupInfoBeanList");
        Intrinsics.checkNotNullParameter(r101, "assetInfoBeanList");
        this();
        this.groupInfoBeanList = r100;
        this.assetInfoBeanList = r101;
    }

    private final void generateGroupBeanWithSubGroup(AssetInfoBean.AssetSelectPageGroupInfoBean r110, final List<Integer> r210, Map<String, Boolean> r211) {
        StdAssetGroupBean r100 = new StdAssetGroupBean();
        ArrayList<StdAssetItemBean> r101 = new ArrayList();
        Iterator<AssetInfoBean.SubGroupInfoBean> r102 = r110.sub_group_list.iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L53;
        AssetInfoBean.SubGroupInfoBean r104 = r102.next();
        Boolean r111 = r211.get(r104.sub_group_type);
        if (r111 == null) goto L8;
    L7:
        boolean r112 = r111.booleanValue();
    L12:
        ArrayList r113 = new ArrayList();
        ArrayList<Integer> r114 = r104.asset_index_list;
        if (r210 == null) goto L21;
        ArrayList r115 = new ArrayList();
        Iterator<T> r116 = r114.iterator();
    L16:
        if (r116.hasNext() == false) goto L20;
        Object r117 = r116.next();
        if (r210.contains(Integer.valueOf(((Number) r117).intValue())) == false) goto L16;
        r115.add(r117);
        goto L16
    L20:
        r114 = new ArrayList(CollectionsKt.sortedWith(r115, new StdAssetListBean$generateGroupBeanWithSubGroup$lambda$2$$inlined$sortedBy$1(r210)));
    L21:
        Iterator<T> r105 = r114.iterator();
    L23:
        if (r105.hasNext() == false) goto L52;
        int r118 = ((Number) r105.next()).intValue();
        Iterator<T> r119 = this.assetInfoBeanList.iterator();
    L26:
        if (r119.hasNext() == false) goto L33;
        Object r120 = r119.next();
        if (((AssetInfoBean) r120).asset_basic_show_info.index != r118) goto L30;
        boolean r121 = true;
    L31:
        if (r121 == false) goto L26;
    L34:
        AssetInfoBean r122 = (AssetInfoBean) r120;
        if (r122 == null) goto L23;
        if (r122.asset_basic_show_info.choose == false) goto L40;
        if (r103 == true) goto L40;
        r103 = true;
    L41:
        if (r112 == false) goto L48;
        if (r104.display_count <= 0) goto L48;
        if (r113.size() != r104.display_count) goto L48;
        ((StdAssetItemBean) ListProtector.get(r113, r113.size() - 1)).setShowFooter(true);
        ((StdAssetItemBean) ListProtector.get(r113, r113.size() - 1)).setFoldDesc(r104.fold_desc);
        ((StdAssetItemBean) ListProtector.get(r113, r113.size() - 1)).setCollapse(true);
    L48:
        if (r110.checkCombineGroup() == false) goto L50;
        AssetInfoBean.VoucherMsgBean.VoucherEventType r123 = AssetInfoBean.VoucherMsgBean.VoucherEventType.COMBINE_PAY;
    L51:
        r113.add(new StdAssetItemBean(r122, r123, r104.sub_group_type));
        goto L23
    L50:
        r123 = AssetInfoBean.VoucherMsgBean.VoucherEventType.DEFAULT;
    L40:
        r103 = false;
        goto L41
    L30:
        r121 = false;
        goto L31
    L33:
        r120 = null;
        goto L34
    L52:
        r101.addAll(r113);
        goto L4
    L8:
        r111 = r211.get("default");
        if (r111 != null) goto L7;
        r112 = true;
        goto L12
    L53:
        r100.setGroupInfoAssetSelectPageGroupInfoBean(r110);
        r100.setAssetItemList(r101);
        Function1<AssetInfoBean, Boolean> r106 = new StdAssetListBean$generateGroupBeanWithSubGroup$isAssetExpanded$1(this);
        ArrayList<StdAssetItemBean> r107 = r100.getAssetItemList();
        if (r107 == null) goto L80;
        Iterator<T> r108 = r107.iterator();
    L57:
        if (r108.hasNext() == false) goto L80;
        StdAssetItemBean r109 = (StdAssetItemBean) r108.next();
        if (r109.isHasSubAsset() == false) goto L78;
        Iterator<T> r124 = r109.getAssetInfo().sub_asset_info_list.iterator();
    L62:
        if (r124.hasNext() == false) goto L70;
        Object r125 = r124.next();
        String r126 = ((AssetInfoBean) r125).asset_meta_info.getUniqueSymbol();
        VoucherDialogExpandResult r127 = this.expandResult;
        if (r127 == null) goto L66;
        String r128 = r127._origin_method_unique_id;
    L68:
        if (Intrinsics.areEqual(r126, r128) == false) goto L62;
    L71:
        if (r125 == null) goto L78;
        VoucherDialogExpandResult r129 = this.expandResult;
        if (r129 == null) goto L75;
        String r130 = r129._origin_method_unique_id;
    L76:
        r109.setExpandedSubAssetUniqueId(r130);
        goto L78
    L75:
        r130 = null;
        goto L76
    L66:
        r128 = null;
        goto L68
    L70:
        r125 = null;
    L78:
        if (r106.invoke(r109.getAssetInfo()).booleanValue() == false) goto L57;
        r109.setVoucherExpanded(Boolean.TRUE);
    L80:
        if (r103 == false) goto L82;
        ListProtector.add(this.groupList, 0, r100);
        return;
    L82:
        this.groupList.add(r100);
    }

    public final StdAssetListBean getAssetListData(Map<String, Boolean> r110, List<Integer> r111, String r112, boolean r113, Function1<? super AssetInfoBean, Boolean> r114) {
        Intrinsics.checkNotNullParameter(r110, "collapse");
        Intrinsics.checkNotNullParameter(r112, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        Intrinsics.checkNotNullParameter(r114, "optionVoucherStateCheck");
        this.groupList.clear();
        Iterator<T> r100 = this.groupInfoBeanList.iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        AssetInfoBean.AssetSelectPageGroupInfoBean r101 = (AssetInfoBean.AssetSelectPageGroupInfoBean) r100.next();
        if ((!r101.sub_group_list.isEmpty()) == true) goto L7;
        Boolean r102 = r110.get("default");
        if (r102 == null) goto L11;
        boolean r103 = r102.booleanValue();
    L12:
        generateGroupBeanWithoutSubGroup(r101, r111, r112, r103, r113, r114);
        goto L4
    L11:
        r103 = true;
        goto L12
    L7:
        generateGroupBeanWithSubGroup(r101, r111, r110);
        goto L4
    L13:
        return this;
    }

    private final void generateGroupBeanWithoutSubGroup(AssetInfoBean.AssetSelectPageGroupInfoBean r210, final List<Integer> r211, String r212, boolean r213, boolean r214, Function1<? super AssetInfoBean, Boolean> r215) {
        StdAssetGroupBean r100 = new StdAssetGroupBean();
        ArrayList<StdAssetItemBean> r101 = new ArrayList();
        ArrayList<Integer> r102 = r210.asset_index_list;
        if (r211 == null) goto L11;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        Object r105 = r104.next();
        if (r211.contains(Integer.valueOf(((Number) r105).intValue())) == false) goto L6;
        r103.add(r105);
        goto L6
    L10:
        r102 = new ArrayList(CollectionsKt.sortedWith(r103, new StdAssetListBean$generateGroupBeanWithoutSubGroup$lambda$10$$inlined$sortedBy$1(r211)));
    L11:
        Iterator<T> r106 = r102.iterator();
        int r107 = 0;
        boolean r108 = false;
    L13:
        if (r106.hasNext() == false) goto L67;
        int r110 = ((Number) r106.next()).intValue();
        Iterator<T> r111 = this.assetInfoBeanList.iterator();
    L16:
        if (r111.hasNext() == false) goto L23;
        Object r112 = r111.next();
        if (((AssetInfoBean) r112).asset_basic_show_info.index != r110) goto L20;
        boolean r113 = true;
    L21:
        if (r113 == false) goto L16;
        Object r114 = r112;
    L24:
        AssetInfoBean r115 = (AssetInfoBean) r114;
        if (r115 == null) goto L13;
        if (r115.asset_basic_show_info.choose == false) goto L31;
        if (r108 == true) goto L31;
        r108 = true;
    L31:
        if (Intrinsics.areEqual(r212, "pay_again") == true) goto L33;
        if (Intrinsics.areEqual(r115.asset_basic_show_info.status, "1") == true) goto L51;
        if (r210.checkCombineGroup() == false) goto L64;
        AssetInfoBean.VoucherMsgBean.VoucherEventType r116 = AssetInfoBean.VoucherMsgBean.VoucherEventType.COMBINE_PAY;
    L65:
        r101.add(new StdAssetItemBean(r115, r116, null, 4, null));
        goto L13
    L64:
        r116 = AssetInfoBean.VoucherMsgBean.VoucherEventType.DEFAULT;
        goto L65
    L51:
        if (r213 == false) goto L56;
        int r117 = r210.display_count;
        if (r117 <= 0) goto L56;
        if (r107 != r117) goto L56;
        int r118 = r107 - 1;
        ((StdAssetItemBean) ListProtector.get(r101, r118)).setShowFooter(true);
        ((StdAssetItemBean) ListProtector.get(r101, r118)).setFoldDesc(r210.fold_desc);
        ((StdAssetItemBean) ListProtector.get(r101, r118)).setCollapse(true);
    L56:
        r107 = r107 + 1;
        if (r210.checkCombineGroup() == false) goto L59;
        AssetInfoBean.VoucherMsgBean.VoucherEventType r119 = AssetInfoBean.VoucherMsgBean.VoucherEventType.COMBINE_PAY;
    L60:
        r101.add(new StdAssetItemBean(r115, r119, null, 4, null));
        goto L13
    L59:
        r119 = AssetInfoBean.VoucherMsgBean.VoucherEventType.DEFAULT;
        goto L60
    L33:
        if (r210.checkCombineGroup() == false) goto L35;
        AssetInfoBean.VoucherMsgBean.VoucherEventType r120 = AssetInfoBean.VoucherMsgBean.VoucherEventType.COMBINE_PAY;
    L36:
        StdAssetItemBean r121 = new StdAssetItemBean(r115, r120, null, 4, null);
        if (Intrinsics.areEqual(r115.asset_basic_show_info.status, "1") == false) goto L48;
        if (r214 == false) goto L48;
        if (r121.isChecked() == false) goto L48;
        if (r115.isShowPaymentSelectionMaterial() == false) goto L48;
        r121.setHasOptionVoucher(true);
        if (r215 == null) goto L46;
        boolean r122 = r215.invoke(r115).booleanValue();
    L47:
        r121.setOptionVoucherChecked(r122);
        r121.setOptionVoucherKey(r115.getPaymentSelectionMaterialKey());
        r121.setOptionVoucherLeftTitle(r115.asset_extension_show_info.payment_selection_material.left_title);
        r121.setOptionVoucherRightTitle(r115.asset_extension_show_info.payment_selection_material.right_title);
        goto L48
    L46:
        r122 = false;
    L48:
        r101.add(r121);
        goto L13
    L35:
        r120 = AssetInfoBean.VoucherMsgBean.VoucherEventType.DEFAULT;
        goto L36
    L20:
        r113 = false;
        goto L21
    L23:
        r114 = null;
        goto L24
    L67:
        if (Intrinsics.areEqual(r212, "pay_again") == false) goto L70;
        r100.setGroupInfoAssetSelectPageGroupInfoBean(r210);
        r100.setAssetItemList(r101);
        this.groupList.add(r100);
        return;
    L70:
        int r109 = r101.size();
        int r123 = 0;
    L71:
        if (r123 >= r109) goto L81;
        if (Intrinsics.areEqual(((StdAssetItemBean) ListProtector.get(r101, r123)).getAssetInfo().asset_basic_show_info.status, "0") == true) goto L81;
        if (r123 >= (r101.size() - 1)) goto L80;
        int r124 = r123 + 1;
        if (Intrinsics.areEqual(((StdAssetItemBean) ListProtector.get(r101, r124)).getAssetInfo().asset_basic_show_info.status, "0") == false) goto L80;
        ((StdAssetItemBean) ListProtector.get(r101, r124)).setShowLine(true);
        ((StdAssetItemBean) ListProtector.get(r101, r124)).setFoldDesc(r210.fold_desc);
    L80:
        r123 = r123 + 1;
    L81:
        if (r213 == true) goto L86;
        int r125 = r210.display_count;
        if (r125 <= 0) goto L86;
        if (r107 <= r125) goto L86;
        int r126 = r107 - 1;
        ((StdAssetItemBean) ListProtector.get(r101, r126)).setShowFooter(true);
        ((StdAssetItemBean) ListProtector.get(r101, r126)).setCollapse(false);
    L86:
        r100.setGroupInfoAssetSelectPageGroupInfoBean(r210);
        r100.setAssetItemList(r101);
        Function1<AssetInfoBean, Boolean> r127 = new StdAssetListBean$generateGroupBeanWithoutSubGroup$isAssetExpanded$1(this);
        ArrayList<StdAssetItemBean> r128 = r100.getAssetItemList();
        if (r128 == null) goto L113;
        Iterator<T> r129 = r128.iterator();
    L90:
        if (r129.hasNext() == false) goto L113;
        StdAssetItemBean r130 = (StdAssetItemBean) r129.next();
        if (r130.isHasSubAsset() == false) goto L111;
        Iterator<T> r131 = r130.getAssetInfo().sub_asset_info_list.iterator();
    L95:
        if (r131.hasNext() == false) goto L103;
        Object r132 = r131.next();
        String r133 = ((AssetInfoBean) r132).asset_meta_info.getUniqueSymbol();
        VoucherDialogExpandResult r134 = this.expandResult;
        if (r134 == null) goto L99;
        String r135 = r134._origin_method_unique_id;
    L101:
        if (Intrinsics.areEqual(r133, r135) == false) goto L95;
    L104:
        if (r132 == null) goto L111;
        VoucherDialogExpandResult r136 = this.expandResult;
        if (r136 == null) goto L108;
        String r137 = r136._origin_method_unique_id;
    L109:
        r130.setExpandedSubAssetUniqueId(r137);
        goto L111
    L108:
        r137 = null;
        goto L109
    L99:
        r135 = null;
        goto L101
    L103:
        r132 = null;
    L111:
        if (r127.invoke(r130.getAssetInfo()).booleanValue() == false) goto L90;
        r130.setVoucherExpanded(Boolean.TRUE);
    L113:
        if (r108 == false) goto L115;
        ListProtector.add(this.groupList, 0, r100);
        return;
    L115:
        this.groupList.add(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StdAssetListBean getAssetListData$default(StdAssetListBean r100, Map r101, List r102, String r103, boolean r110, Function1 r111, int r112, Object r113) {
        if ((r112 & 8) == 0) goto L5;
        boolean r104 = false;
    L7:
        if ((r112 & 16) == 0) goto L10;
        r111 = AnonymousClass1.INSTANCE;
    L10:
        return r100.getAssetListData(r101, r102, r103, r104, r111);
    L5:
        r104 = r110;
        goto L7
    }

    public static /* synthetic */ void generateGroupBeanWithoutSubGroup$default(StdAssetListBean r100, AssetInfoBean.AssetSelectPageGroupInfoBean r101, List r102, String r110, boolean r111, boolean r112, Function1 r113, int r114, Object r115) {
        if ((r114 & 16) == 0) goto L5;
        boolean r103 = false;
    L6:
        r100.generateGroupBeanWithoutSubGroup(r101, r102, r110, r111, r103, r113);
        return;
    L5:
        r103 = r112;
        goto L6
    }
}
