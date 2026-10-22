package com.android.ttcjpaysdk.integrated.counter.component.config.std;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.integrated.counter.component.config.IDYPayType;
import com.android.ttcjpaysdk.integrated.counter.component.config.IPayType;
import com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig;
import com.android.ttcjpaysdk.integrated.counter.component.config.PayType;
import com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo;
import com.android.ttcjpaysdk.integrated.counter.component.lynx.std.StdPayTypeChangeInfo;
import com.android.ttcjpaysdk.integrated.counter.data.PayComponentBean;
import com.android.ttcjpaysdk.integrated.counter.data.TypeItems;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u0000H\u0016J\u0012\u0010\u000f\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0000H\u0016J\b\u0010\u0015\u001a\u00020\u0000H\u0016J\b\u0010\u0016\u001a\u00020\u0000H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002J\u0012\u0010\"\u001a\u00020\u00182\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\u0014\u0010%\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0013H\u0016R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/config/std/StdPayTypeConfig;", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/IPayTypeConfig;", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/std/StdDyPayTypeConfig;", "Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/std/StdPayTypeChangeInfo;", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/IPayType;", "()V", "<set-?>", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/PayType;", "payType", "getPayType", "()Lcom/android/ttcjpaysdk/integrated/counter/component/config/PayType;", "stdDyPayType", "getStdDyPayType", "()Lcom/android/ttcjpaysdk/integrated/counter/component/config/std/StdDyPayTypeConfig;", "buildAliPayConfig", "buildDYConfig", "dyPayTypeConfig", "buildDefaultConfig", "payComponentBean", "Lcom/android/ttcjpaysdk/integrated/counter/data/PayComponentBean;", "buildFundPayConfig", "buildSuperPayConfig", "buildWXConfig", "buildWithChangeInfo", "", "payTypeChangeInfo", "Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/IPayTypeChangeInfo;", "getLogMethod", "", "getStdDYPayTypeConfig", "componentBean", BasicTestActionHandler.TEST_ACTION_RESET, "setAliPayType", "setFundPayType", "setStdDYPayType", "setSuperPayType", "setWXPayType", "toPayTypeChangeInfo", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StdPayTypeConfig implements IPayTypeConfig<StdPayTypeConfig, StdDyPayTypeConfig, StdPayTypeChangeInfo>, IPayType {
    private PayType payType;
    private StdDyPayTypeConfig stdDyPayType;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[PayType.values().length];
            r100[PayType.WX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[PayType.ALIPAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[PayType.SUPERPAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[PayType.FUNDPAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[PayType.BYTEPAY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public StdPayTypeConfig() {
    }

    private final void reset() {
        this.payType = null;
        this.stdDyPayType = null;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.logger.ILogPayTypeConfig
    public String getLogMethod() {
        PayType r100 = this.payType;
        if (r100 != null) goto L5;
        int r101 = -1;
    L7:
        if (r101 != 1) goto L9;
        return "wx";
    L9:
        if (r101 != 2) goto L11;
        return "alipay";
    L11:
        if (r101 != 3) goto L13;
        return "superpay";
    L13:
        if (r101 != 4) goto L15;
        return CJPayConstant.TT_CJ_PAY_KEY_FOR_MFUND_BCB_PAY;
    L15:
        if (r101 == 5) goto L17;
        return "";
    L17:
        return CJPayConstant.TT_CJ_PAY_KEY_FOR_BYTEPAY;
    L5:
        r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        goto L7
    }

    private final void setAliPayType() {
        reset();
        this.payType = PayType.ALIPAY;
    }

    private final void setFundPayType() {
        reset();
        this.payType = PayType.FUNDPAY;
    }

    private final void setSuperPayType() {
        reset();
        this.payType = PayType.SUPERPAY;
    }

    private final void setWXPayType() {
        reset();
        this.payType = PayType.WX;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig
    public /* bridge */ /* synthetic */ IPayType buildAliPayConfig() {
        return buildAliPayConfig();
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig
    public /* bridge */ /* synthetic */ IPayType buildFundPayConfig() {
        return buildFundPayConfig();
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig
    public /* bridge */ /* synthetic */ IPayType buildSuperPayConfig() {
        return buildSuperPayConfig();
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig
    public /* bridge */ /* synthetic */ IPayType buildWXConfig() {
        return buildWXConfig();
    }

    public final PayType getPayType() {
        return this.payType;
    }

    public final StdDyPayTypeConfig getStdDyPayType() {
        return this.stdDyPayType;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig
    public StdPayTypeConfig buildAliPayConfig() {
        setAliPayType();
        return this;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig
    public StdPayTypeConfig buildFundPayConfig() {
        setFundPayType();
        return this;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig
    public StdPayTypeConfig buildSuperPayConfig() {
        setSuperPayType();
        return this;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig
    public StdPayTypeConfig buildWXConfig() {
        setWXPayType();
        return this;
    }

    private final void setStdDYPayType(StdDyPayTypeConfig r100) {
        reset();
        this.payType = PayType.BYTEPAY;
        this.stdDyPayType = r100;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig
    public /* bridge */ /* synthetic */ IPayType buildDYConfig(IDYPayType r100) {
        return buildDYConfig((StdDyPayTypeConfig) r100);
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig
    public StdPayTypeConfig buildDefaultConfig(PayComponentBean r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.default_ptcode;
        if (Intrinsics.areEqual(r101, PayType.WX.getPtcode()) == false) goto L9;
        return buildWXConfig();
    L9:
        if (Intrinsics.areEqual(r101, PayType.ALIPAY.getPtcode()) == false) goto L12;
        return buildAliPayConfig();
    L12:
        if (Intrinsics.areEqual(r101, PayType.BYTEPAY.getPtcode()) == false) goto L15;
        return buildDYConfig(StdDyPayTypeConfig.Companion.getDefaultDyPayTypeConfig(r100));
    L15:
        if (Intrinsics.areEqual(r101, PayType.SUPERPAY.getPtcode()) == false) goto L18;
        return buildSuperPayConfig();
    L18:
        if (Intrinsics.areEqual(r101, PayType.FUNDPAY.getPtcode()) == true) goto L20;
        return null;
    L20:
        return buildFundPayConfig();
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.config.I2PayTypeChangeInfo
    public StdPayTypeChangeInfo toPayTypeChangeInfo(PayComponentBean r100) {
        String r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        PayType r102 = this.payType;
        if (r102 != null) goto L8;
        int r103 = -1;
    L9:
        String r104 = "";
        if (r103 != 1) goto L12;
        ArrayList<TypeItems> r105 = r100.pay_type_items;
        if (r105 == null) goto L120;
        Iterator<T> r106 = r105.iterator();
    L84:
        if (r106.hasNext() == false) goto L88;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((TypeItems) r107).ptcode, PayType.WX.getPtcode()) == false) goto L84;
    L89:
        TypeItems r108 = (TypeItems) r107;
        if (r108 != null) goto L92;
        return null;
    L92:
        return new StdPayTypeChangeInfo(r108.ptcode, "", "");
    L88:
        r107 = null;
        goto L89
    L120:
        return null;
    L12:
        if (r103 != 2) goto L14;
        ArrayList<TypeItems> r109 = r100.pay_type_items;
        if (r109 == null) goto L117;
        Iterator<T> r110 = r109.iterator();
    L72:
        if (r110.hasNext() == false) goto L76;
        Object r111 = r110.next();
        if (Intrinsics.areEqual(((TypeItems) r111).ptcode, PayType.ALIPAY.getPtcode()) == false) goto L72;
    L77:
        TypeItems r112 = (TypeItems) r111;
        if (r112 != null) goto L119;
        return null;
    L119:
        return new StdPayTypeChangeInfo(r112.ptcode, "", "");
    L76:
        r111 = null;
        goto L77
    L117:
        return null;
    L14:
        if (r103 != 3) goto L16;
        ArrayList<TypeItems> r113 = r100.pay_type_items;
        if (r113 == null) goto L114;
        Iterator<T> r114 = r113.iterator();
    L60:
        if (r114.hasNext() == false) goto L64;
        Object r115 = r114.next();
        if (Intrinsics.areEqual(((TypeItems) r115).ptcode, PayType.SUPERPAY.getPtcode()) == false) goto L60;
    L65:
        TypeItems r116 = (TypeItems) r115;
        if (r116 != null) goto L116;
        return null;
    L116:
        return new StdPayTypeChangeInfo(r116.ptcode, "", "");
    L64:
        r115 = null;
        goto L65
    L114:
        return null;
    L16:
        if (r103 != 4) goto L18;
        ArrayList<TypeItems> r117 = r100.pay_type_items;
        if (r117 == null) goto L111;
        Iterator<T> r118 = r117.iterator();
    L48:
        if (r118.hasNext() == false) goto L52;
        Object r119 = r118.next();
        if (Intrinsics.areEqual(((TypeItems) r119).ptcode, PayType.FUNDPAY.getPtcode()) == false) goto L48;
    L53:
        TypeItems r120 = (TypeItems) r119;
        if (r120 != null) goto L113;
        return null;
    L113:
        return new StdPayTypeChangeInfo(r120.ptcode, "", "");
    L52:
        r119 = null;
        goto L53
    L111:
        return null;
    L18:
        if (r103 != 5) goto L122;
        ArrayList<TypeItems> r121 = r100.pay_type_items;
        if (r121 == null) goto L108;
        Iterator<T> r122 = r121.iterator();
    L24:
        if (r122.hasNext() == false) goto L28;
        Object r123 = r122.next();
        if (Intrinsics.areEqual(((TypeItems) r123).ptcode, PayType.BYTEPAY.getPtcode()) == false) goto L24;
    L29:
        TypeItems r124 = (TypeItems) r123;
        if (r124 == null) goto L109;
        String r125 = r124.ptcode;
        StdDyPayTypeConfig r126 = this.stdDyPayType;
        if (r126 == null) goto L34;
        String r127 = Integer.valueOf(r126.getIndex()).toString();
    L35:
        if (r127 != null) goto L37;
        r127 = "";
    L37:
        StdDyPayTypeConfig r128 = this.stdDyPayType;
        if (r128 == null) goto L40;
        r101 = Integer.valueOf(r128.getCombineIndex()).toString();
    L40:
        if (r101 == null) goto L110;
        r104 = r101;
    L110:
        return new StdPayTypeChangeInfo(r125, r127, r104);
    L34:
        r127 = null;
        goto L35
    L109:
        return null;
    L28:
        r123 = null;
        goto L29
    L108:
        return null;
    L122:
        return null;
    L8:
        r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        goto L9
    }

    public StdPayTypeConfig buildDYConfig(StdDyPayTypeConfig r100) {
        setStdDYPayType(r100);
        return this;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig
    public /* bridge */ /* synthetic */ IPayType buildDefaultConfig(PayComponentBean r100) {
        return buildDefaultConfig(r100);
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.config.I2PayTypeChangeInfo
    public /* bridge */ /* synthetic */ IPayTypeChangeInfo toPayTypeChangeInfo(PayComponentBean r100) {
        return toPayTypeChangeInfo(r100);
    }

    private final StdDyPayTypeConfig getStdDYPayTypeConfig(PayComponentBean r100, IPayTypeChangeInfo r101) {
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getPayTypeIndex();
    L6:
        String r104 = "";
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        if (r101 == null) goto L11;
        r102 = r101.getCombineInfo();
    L11:
        if (r102 == null) goto L15;
        r104 = r102;
    L15:
        if (StringsKt.toIntOrNull(r103) == null) goto L20;
        if (StringsKt.isBlank(r104) == false) goto L20;
        return new StdDyPayTypeConfig().setIndependentPayType(CastIntegerProtector.parseInt(r103));
    L20:
        if (StringsKt.toIntOrNull(r103) == null) goto L25;
        if (StringsKt.toIntOrNull(r104) == null) goto L25;
        return new StdDyPayTypeConfig().setCombinePayType(CastIntegerProtector.parseInt(r103), CastIntegerProtector.parseInt(r104));
    L25:
        return StdDyPayTypeConfig.Companion.getDefaultDyPayTypeConfig(r100);
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig
    public void buildWithChangeInfo(PayComponentBean r100, IPayTypeChangeInfo r101) {
        if (r101 == null) goto L4;
        String r102 = r101.getPtCode();
    L6:
        if (Intrinsics.areEqual(r102, PayType.WX.getPtcode()) == false) goto L9;
        buildWXConfig();
        return;
    L9:
        if (Intrinsics.areEqual(r102, PayType.ALIPAY.getPtcode()) == false) goto L12;
        buildAliPayConfig();
        return;
    L12:
        if (Intrinsics.areEqual(r102, PayType.BYTEPAY.getPtcode()) == false) goto L15;
        buildDYConfig(getStdDYPayTypeConfig(r100, r101));
        return;
    L15:
        if (Intrinsics.areEqual(r102, PayType.SUPERPAY.getPtcode()) == false) goto L18;
        buildSuperPayConfig();
        return;
    L18:
        if (Intrinsics.areEqual(r102, PayType.FUNDPAY.getPtcode()) == false) goto L20;
        buildFundPayConfig();
        return;
    L20:
        buildDYConfig(StdDyPayTypeConfig.Companion.getDefaultDyPayTypeConfig(r100));
        return;
    L4:
        r102 = null;
        goto L6
    }
}
