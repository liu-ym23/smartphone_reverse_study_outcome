package com.android.ttcjpaysdk.integrated.counter.component.config.std;

import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.integrated.counter.component.config.IDYPayType;
import com.android.ttcjpaysdk.integrated.counter.component.config.PayType;
import com.android.ttcjpaysdk.integrated.counter.data.PayComponentBean;
import com.android.ttcjpaysdk.integrated.counter.data.PayTypeItemInfo;
import com.android.ttcjpaysdk.integrated.counter.data.TypeItems;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/config/std/StdDyPayTypeConfig;", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/IDYPayType;", "()V", "<set-?>", "", "combineIndex", "getCombineIndex", "()I", "index", "getIndex", "", "isCombine", "()Z", BasicTestActionHandler.TEST_ACTION_RESET, "", "setCombinePayType", "fundBillIndex", "combineFundBillIndex", "setIndependentPayType", "Companion", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StdDyPayTypeConfig implements IDYPayType {
    public static final Companion Companion = null;
    private int combineIndex;
    private int index;
    private boolean isCombine;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/config/std/StdDyPayTypeConfig$Companion;", "", "()V", "getDefaultDyPayTypeConfig", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/std/StdDyPayTypeConfig;", "payComponentBean", "Lcom/android/ttcjpaysdk/integrated/counter/data/PayComponentBean;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final StdDyPayTypeConfig getDefaultDyPayTypeConfig(PayComponentBean r100) {
            int r101 = 0;
            if (r100 == null) goto L46;
            ArrayList<TypeItems> r102 = r100.pay_type_items;
            if (r102 == null) goto L46;
            Iterator<T> r103 = r102.iterator();
        L8:
            if (r103.hasNext() == false) goto L12;
            Object r104 = r103.next();
            if (Intrinsics.areEqual(((TypeItems) r104).ptcode, PayType.BYTEPAY.getPtcode()) == false) goto L8;
        L13:
            TypeItems r105 = (TypeItems) r104;
            if (r105 == null) goto L46;
            PayTypeItemInfo r106 = r105.paytype_item;
            if (r106 == null) goto L46;
            AssetInfoBean r107 = r106.getAssetInfo();
            if (r107 == null) goto L46;
            ArrayList<AssetInfoBean> r108 = r107.subPayTypeInfoList();
            if (r108 == null) goto L46;
            Iterator<T> r109 = r108.iterator();
        L23:
            if (r109.hasNext() == false) goto L27;
            Object r110 = r109.next();
            if (((AssetInfoBean) r110).asset_basic_show_info.choose == false) goto L23;
        L28:
            AssetInfoBean r111 = (AssetInfoBean) r110;
            if (r111 == null) goto L46;
            int r112 = r111.asset_basic_show_info.index;
            Iterator<T> r113 = r111.asset_combine_pay_info.asset_to_combine_asset_info_list.iterator();
        L32:
            if (r113.hasNext() == false) goto L41;
            Object r114 = r113.next();
            AssetInfoBean.AssetToCombineAssetInfoBean r115 = (AssetInfoBean.AssetToCombineAssetInfoBean) r114;
            if (r115.default_show == true) goto L36;
        L38:
            boolean r116 = false;
        L39:
            if (r116 == false) goto L32;
        L42:
            AssetInfoBean.AssetToCombineAssetInfoBean r117 = (AssetInfoBean.AssetToCombineAssetInfoBean) r114;
            if (r117 == null) goto L45;
            r101 = r117.to_combine_asset_index;
        L45:
            int r118 = r101;
            r101 = r112;
            int r119 = r118;
        L47:
            if (r101 == 0) goto L50;
            if (r119 != 0) goto L50;
            return new StdDyPayTypeConfig().setIndependentPayType(r101);
        L50:
            if (r101 == 0) goto L66;
            if (r119 != 0) goto L53;
            return null;
        L53:
            return new StdDyPayTypeConfig().setCombinePayType(r101, r119);
        L66:
            return null;
        L36:
            if (r115.btn_is_checked == false) goto L38;
            r116 = true;
            goto L39
        L41:
            r114 = null;
            goto L42
        L27:
            r110 = null;
            goto L28
        L12:
            r104 = null;
        L46:
            r119 = 0;
            goto L47
        }
    }

    static {
        Companion = new Companion(null);
    }

    public StdDyPayTypeConfig() {
    }

    private final void reset() {
        this.index = 0;
        this.combineIndex = 0;
        this.isCombine = false;
    }

    public final int getCombineIndex() {
        return this.combineIndex;
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean isCombine() {
        return this.isCombine;
    }

    public final StdDyPayTypeConfig setIndependentPayType(int r100) {
        reset();
        this.isCombine = false;
        this.index = r100;
        return this;
    }

    public final StdDyPayTypeConfig setCombinePayType(int r100, int r101) {
        reset();
        this.isCombine = true;
        this.index = r100;
        this.combineIndex = r101;
        return this;
    }
}
