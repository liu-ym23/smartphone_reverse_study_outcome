package com.android.ttcjpaysdk.integrated.counter.component.config;

import com.android.ttcjpaysdk.integrated.counter.data.PayComponentBean;
import com.android.ttcjpaysdk.integrated.counter.data.PayTypeData;
import com.android.ttcjpaysdk.integrated.counter.data.PayTypeInfo;
import com.android.ttcjpaysdk.integrated.counter.data.PayTypeItemInfo;
import com.android.ttcjpaysdk.integrated.counter.data.SubPayTypeInfo;
import com.android.ttcjpaysdk.integrated.counter.data.SubPayTypeSumInfo;
import com.android.ttcjpaysdk.integrated.counter.data.TypeItems;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bJ\u0016\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/config/DyPayTypeConfig;", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/IDYPayType;", "()V", "<set-?>", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/CombinePayType;", "combinePayType", "getCombinePayType", "()Lcom/android/ttcjpaysdk/integrated/counter/component/config/CombinePayType;", "", "index", "getIndex", "()I", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/DYPayType;", "subPayType", "getSubPayType", "()Lcom/android/ttcjpaysdk/integrated/counter/component/config/DYPayType;", BasicTestActionHandler.TEST_ACTION_RESET, "", "setBalancePayType", "setBankCardPayType", "bankIndex", "setCombinePayType", "setIncomePayType", "setNewBankCardPayType", "setSharePayType", "Companion", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyPayTypeConfig implements IDYPayType {
    public static final Companion Companion = null;
    private CombinePayType combinePayType;
    private int index;
    private DYPayType subPayType;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/config/DyPayTypeConfig$Companion;", "", "()V", "getDefaultDyPayTypeConfig", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/DyPayTypeConfig;", "payComponentBean", "Lcom/android/ttcjpaysdk/integrated/counter/data/PayComponentBean;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final DyPayTypeConfig getDefaultDyPayTypeConfig(PayComponentBean r100) {
            if (r100 == null) goto L31;
            ArrayList<TypeItems> r101 = r100.pay_type_items;
            if (r101 == null) goto L31;
            Iterator<T> r102 = r101.iterator();
        L8:
            if (r102.hasNext() == false) goto L12;
            Object r103 = r102.next();
            if (Intrinsics.areEqual(((TypeItems) r103).ptcode, PayType.BYTEPAY.getPtcode()) == false) goto L8;
        L13:
            TypeItems r104 = (TypeItems) r103;
            if (r104 == null) goto L31;
            PayTypeItemInfo r105 = r104.paytype_item;
            if (r105 == null) goto L31;
            PayTypeInfo r106 = r105.paytype_info;
            if (r106 == null) goto L31;
            SubPayTypeSumInfo r107 = r106.sub_pay_type_sum_info;
            if (r107 == null) goto L31;
            ArrayList<SubPayTypeInfo> r108 = r107.sub_pay_type_info_list;
            if (r108 == null) goto L31;
            Iterator<T> r109 = r108.iterator();
        L25:
            if (r109.hasNext() == false) goto L29;
            Object r110 = r109.next();
            if (((SubPayTypeInfo) r110).choose == false) goto L25;
        L30:
            SubPayTypeInfo r111 = (SubPayTypeInfo) r110;
        L32:
            if (r100 == null) goto L78;
            ArrayList<TypeItems> r112 = r100.pay_type_items;
            if (r112 == null) goto L78;
            Iterator<T> r113 = r112.iterator();
        L37:
            if (r113.hasNext() == false) goto L41;
            Object r114 = r113.next();
            if (Intrinsics.areEqual(((TypeItems) r114).ptcode, PayType.BYTEPAY.getPtcode()) == false) goto L37;
        L42:
            TypeItems r115 = (TypeItems) r114;
            if (r115 == null) goto L78;
            PayTypeItemInfo r116 = r115.paytype_item;
            if (r116 == null) goto L78;
            PayTypeInfo r117 = r116.paytype_info;
            if (r117 == null) goto L78;
            SubPayTypeSumInfo r118 = r117.sub_pay_type_sum_info;
            if (r118 == null) goto L78;
            ArrayList<SubPayTypeInfo> r119 = r118.sub_pay_type_info_list;
            if (r119 == null) goto L78;
            ArrayList r120 = new ArrayList();
            Iterator<T> r121 = r119.iterator();
        L54:
            if (r121.hasNext() == false) goto L58;
            Object r122 = r121.next();
            if (CollectionsKt.listOf(new String[]{DYPayType.BALANCE.getType(), DYPayType.INCOME.getType()}).contains(((SubPayTypeInfo) r122).sub_pay_type) == false) goto L54;
            r120.add(r122);
            goto L54
        L58:
            Iterator r123 = r120.iterator();
        L60:
            if (r123.hasNext() == false) goto L74;
            Object r124 = r123.next();
            PayTypeData r125 = ((SubPayTypeInfo) r124).pay_type_data;
            if (r125 == null) goto L68;
            PayTypeData.CombinePayInfo r126 = r125.combine_pay_info;
            if (r126 == null) goto L68;
            PayTypeData.SecondaryCombinePayInfo r127 = r126.secondary_combine_pay_info;
            if (r127 == null) goto L68;
            Boolean r128 = Boolean.valueOf(r127.btn_is_checked);
        L69:
            if (r128 == null) goto L71;
            boolean r129 = r128.booleanValue();
        L72:
            if (r129 == false) goto L60;
        L75:
            SubPayTypeInfo r130 = (SubPayTypeInfo) r124;
            if (r130 == null) goto L78;
            String r131 = r130.sub_pay_type;
        L79:
            if (r131 != null) goto L81;
            r131 = "";
        L81:
            DYPayType r132 = DYPayType.BALANCE;
            if (Intrinsics.areEqual(r131, r132.getType()) == false) goto L84;
            DYPayType r133 = r132;
        L88:
            if (r111 == null) goto L90;
            String r134 = r111.sub_pay_type;
        L92:
            if (Intrinsics.areEqual(r134, r132.getType()) == false) goto L94;
            DyPayTypeConfig r135 = new DyPayTypeConfig();
            r135.setBalancePayType(r111.index);
            return r135;
        L94:
            if (r111 == null) goto L96;
            String r136 = r111.sub_pay_type;
        L98:
            if (Intrinsics.areEqual(r136, DYPayType.INCOME.getType()) == false) goto L100;
            DyPayTypeConfig r137 = new DyPayTypeConfig();
            r137.setIncomePayType(r111.index);
            return r137;
        L100:
            if (r111 == null) goto L102;
            String r138 = r111.sub_pay_type;
        L103:
            DYPayType r139 = DYPayType.BANK_CARD;
            if (Intrinsics.areEqual(r138, r139.getType()) == false) goto L107;
            if (r133 != null) goto L107;
            DyPayTypeConfig r140 = new DyPayTypeConfig();
            r140.setBankCardPayType(r111.index);
            return r140;
        L107:
            if (r111 == null) goto L109;
            String r141 = r111.sub_pay_type;
        L110:
            DYPayType r142 = DYPayType.NEW_BANK_CARD;
            if (Intrinsics.areEqual(r141, r142.getType()) == false) goto L114;
            if (r133 != null) goto L114;
            DyPayTypeConfig r143 = new DyPayTypeConfig();
            r143.setNewBankCardPayType(r111.index);
            return r143;
        L114:
            if (r111 == null) goto L116;
            String r144 = r111.sub_pay_type;
        L118:
            if (Intrinsics.areEqual(r144, DYPayType.SHARE_PAY.getType()) == false) goto L121;
            if (r133 != null) goto L121;
            DyPayTypeConfig r145 = new DyPayTypeConfig();
            r145.setSharePayType(r111.index);
            return r145;
        L121:
            if (r111 == null) goto L123;
            String r146 = r111.sub_pay_type;
        L125:
            if (Intrinsics.areEqual(r146, r139.getType()) == false) goto L132;
            if (r133 == null) goto L132;
            DyPayTypeConfig r147 = new DyPayTypeConfig();
            CombinePayType r148 = CombinePayType.Companion.map2CombinePayType(r139, r133);
            if (r148 != null) goto L130;
        L131:
            r147.setBankCardPayType(r111.index);
            return r147;
        L130:
            if (r147.setCombinePayType(r148, r111.index) == null) goto L131;
            return r147;
        L132:
            if (r111 == null) goto L134;
            String r149 = r111.sub_pay_type;
        L136:
            if (Intrinsics.areEqual(r149, r142.getType()) == false) goto L170;
            if (r133 == null) goto L171;
            DyPayTypeConfig r150 = new DyPayTypeConfig();
            CombinePayType r151 = CombinePayType.Companion.map2CombinePayType(r142, r133);
            if (r151 != null) goto L141;
        L142:
            r150.setNewBankCardPayType(r111.index);
            return r150;
        L141:
            if (r150.setCombinePayType(r151, r111.index) == null) goto L142;
            return r150;
        L171:
            return null;
        L170:
            return null;
        L134:
            r149 = null;
            goto L136
        L123:
            r146 = null;
            goto L125
        L116:
            r144 = null;
            goto L118
        L109:
            r141 = null;
            goto L110
        L102:
            r138 = null;
            goto L103
        L96:
            r136 = null;
            goto L98
        L90:
            r134 = null;
            goto L92
        L84:
            r133 = DYPayType.INCOME;
            if (Intrinsics.areEqual(r131, r133.getType()) == true) goto L88;
            r133 = null;
            goto L88
        L71:
            r129 = false;
        L68:
            r128 = null;
            goto L69
        L74:
            r124 = null;
            goto L75
        L41:
            r114 = null;
        L78:
            r131 = null;
            goto L79
        L29:
            r110 = null;
            goto L30
        L12:
            r103 = null;
        L31:
            r111 = null;
            goto L32
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void reset() {
        this.subPayType = null;
        this.index = -1;
        this.combinePayType = null;
    }

    public DyPayTypeConfig() {
        this.index = -1;
    }

    public final CombinePayType getCombinePayType() {
        return this.combinePayType;
    }

    public final int getIndex() {
        return this.index;
    }

    public final DYPayType getSubPayType() {
        return this.subPayType;
    }

    public final DyPayTypeConfig setBalancePayType(int r100) {
        reset();
        this.subPayType = DYPayType.BALANCE;
        this.index = r100;
        return this;
    }

    public final DyPayTypeConfig setBankCardPayType(int r100) {
        reset();
        this.subPayType = DYPayType.BANK_CARD;
        this.index = r100;
        return this;
    }

    public final DyPayTypeConfig setIncomePayType(int r100) {
        reset();
        this.subPayType = DYPayType.INCOME;
        this.index = r100;
        return this;
    }

    public final DyPayTypeConfig setNewBankCardPayType(int r100) {
        reset();
        this.subPayType = DYPayType.NEW_BANK_CARD;
        this.index = r100;
        return this;
    }

    public final DyPayTypeConfig setSharePayType(int r100) {
        reset();
        this.subPayType = DYPayType.SHARE_PAY;
        this.index = r100;
        return this;
    }

    public final DyPayTypeConfig setCombinePayType(CombinePayType r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "combinePayType");
        reset();
        this.subPayType = DYPayType.COMBINE_PAY;
        this.combinePayType = r100;
        this.index = r101;
        return this;
    }
}
