package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import com.android.ttcjpaysdk.base.service.bean.NormalBindCardBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00172\u00020\u0001:\u0004\u0015\u0016\u0017\u0018J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH&J*\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "getNormalBindCardCallback", "Lcom/android/ttcjpaysdk/base/service/INormalBindCardCallback;", "isLynxBindCardProcess", "", "release", "", "setPayNewCardCallback", "cardCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayNewCardCallback;", "setPayTimeTrackCallback", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPayTimeTrackCallback;", "startBindCardProcess", "activity", "Landroid/app/Activity;", "type", "Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService$BindCardType;", "params", "Lcom/android/ttcjpaysdk/base/service/bean/NormalBindCardBean;", "BindCardType", "BizType", "Companion", "SourceType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayNormalBindCardService extends ICJPayService {
    public static final String BIND_CARD_RESULT = "bind_card_result";
    public static final int CARD_LIST = 3;
    public static final int CHARGE = 1;
    public static final int CHARGE_MAIN = 6;
    public static final Companion Companion = null;
    public static final int FRONT_PAY = 8;
    public static final int INDEPENDENT_BIND_CARD = 9;
    public static final int MY_BIND_CARD = 4;
    public static final int MY_BIND_CARD_TWO = 5;
    public static final int PAY = 0;
    public static final int SIGN_BIND_CARD = 10;
    public static final int SUPER_PAY_BIND_CARD = 11;
    public static final int WITHDRAW = 2;
    public static final int WITHDRAW_MAIN = 7;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService$BindCardType;", "", "string", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getString", "()Ljava/lang/String;", "setString", "(Ljava/lang/String;)V", "TYPE_PAY", "TYPE_BALANCE", "TYPE_MY_BANK_CARD", "TYPE_INDEPENDENT", "TYPE_SIGN", "TYPE_QUICK_BIND_CARD_LIST", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum BindCardType extends Enum<BindCardType> {
        private static final /* synthetic */ BindCardType[] $VALUES = null;
        public static final BindCardType TYPE_BALANCE = null;
        public static final BindCardType TYPE_INDEPENDENT = null;
        public static final BindCardType TYPE_MY_BANK_CARD = null;
        public static final BindCardType TYPE_PAY = null;
        public static final BindCardType TYPE_QUICK_BIND_CARD_LIST = null;
        public static final BindCardType TYPE_SIGN = null;
        private String string;

        private static final /* synthetic */ BindCardType[] $values() {
            return new BindCardType[]{TYPE_PAY, TYPE_BALANCE, TYPE_MY_BANK_CARD, TYPE_INDEPENDENT, TYPE_SIGN, TYPE_QUICK_BIND_CARD_LIST};
        }

        public static BindCardType valueOf(String r100) {
            return (BindCardType) a.a(BindCardType.class, r100);
        }

        public static BindCardType[] values() {
            return (BindCardType[]) $VALUES.clone();
        }

        static {
            TYPE_PAY = new BindCardType("TYPE_PAY", 0, "绑卡并支付");
            TYPE_BALANCE = new BindCardType("TYPE_BALANCE", 1, "余额充提");
            TYPE_MY_BANK_CARD = new BindCardType("TYPE_MY_BANK_CARD", 2, "我的银行卡");
            TYPE_INDEPENDENT = new BindCardType("TYPE_INDEPENDENT", 3, "独立绑卡");
            TYPE_SIGN = new BindCardType("TYPE_SIGN", 4, "签约绑卡");
            TYPE_QUICK_BIND_CARD_LIST = new BindCardType("TYPE_QUICK_BIND_CARD_LIST", 5, "一键绑卡卡列表");
            $VALUES = $values();
        }

        public final String getString() {
            return this.string;
        }

        public final void setString(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.string = r100;
        }

        private BindCardType(String r100, int r101, String r102) {
            super(r100, r101);
            this.string = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService$BizType;", "", "mType", "", "mDesc", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getMDesc", "()Ljava/lang/String;", "setMDesc", "(Ljava/lang/String;)V", "getMType", "()I", "setMType", "(I)V", "Null", "ECommerce", "LocalLife", "TTPayBindCard", "BDPayCounter", "Balance", "Integrated", "Integrated_Outer", "BDPay_Outer", "LARGE_AMOUNT_BIND_CARD_PAY", "SUPER_PAY_AGAIN", "SUPER_PAY_FAIL_PAY_AGAIN", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum BizType extends Enum<BizType> {
        private static final /* synthetic */ BizType[] $VALUES = null;
        public static final BizType BDPayCounter = null;
        public static final BizType BDPay_Outer = null;
        public static final BizType Balance = null;
        public static final BizType ECommerce = null;
        public static final BizType Integrated = null;
        public static final BizType Integrated_Outer = null;
        public static final BizType LARGE_AMOUNT_BIND_CARD_PAY = null;
        public static final BizType LocalLife = null;
        public static final BizType Null = null;
        public static final BizType SUPER_PAY_AGAIN = null;
        public static final BizType SUPER_PAY_FAIL_PAY_AGAIN = null;
        public static final BizType TTPayBindCard = null;
        private String mDesc;
        private int mType;

        private static final /* synthetic */ BizType[] $values() {
            return new BizType[]{Null, ECommerce, LocalLife, TTPayBindCard, BDPayCounter, Balance, Integrated, Integrated_Outer, BDPay_Outer, LARGE_AMOUNT_BIND_CARD_PAY, SUPER_PAY_AGAIN, SUPER_PAY_FAIL_PAY_AGAIN};
        }

        public static BizType valueOf(String r100) {
            return (BizType) a.a(BizType.class, r100);
        }

        public static BizType[] values() {
            return (BizType[]) $VALUES.clone();
        }

        static {
            Null = new BizType("Null", 0, -1, "");
            ECommerce = new BizType("ECommerce", 1, 0, "电商绑卡并支付");
            LocalLife = new BizType("LocalLife", 2, 1, "标准前置绑卡并支付");
            TTPayBindCard = new BizType("TTPayBindCard", 3, 2, "Lynx走TTPay独立绑卡");
            BDPayCounter = new BizType("BDPayCounter", 4, 3, "追光绑卡并支付");
            Balance = new BizType("Balance", 5, 4, "零钱充提独立绑卡");
            Integrated = new BizType("Integrated", 6, 5, "聚合收银台绑卡并支付");
            Integrated_Outer = new BizType("Integrated_Outer", 7, 6, "唤端聚合绑卡并支付");
            BDPay_Outer = new BizType("BDPay_Outer", 8, 7, "唤端追光绑卡并支付");
            LARGE_AMOUNT_BIND_CARD_PAY = new BizType("LARGE_AMOUNT_BIND_CARD_PAY", 9, 8, "大额支付独立绑卡");
            SUPER_PAY_AGAIN = new BizType("SUPER_PAY_AGAIN", 10, 9, "极速付二次支付独立绑卡");
            SUPER_PAY_FAIL_PAY_AGAIN = new BizType("SUPER_PAY_FAIL_PAY_AGAIN", 11, 10, "极速付失败跳二次支付");
            $VALUES = $values();
        }

        public final String getMDesc() {
            return this.mDesc;
        }

        public final int getMType() {
            return this.mType;
        }

        public final void setMDesc(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.mDesc = r100;
        }

        public final void setMType(int r100) {
            this.mType = r100;
        }

        private BizType(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.mType = r102;
            this.mDesc = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService$Companion;", "", "()V", "BIND_CARD_RESULT", "", "CARD_LIST", "", "CHARGE", "CHARGE_MAIN", "FRONT_PAY", "INDEPENDENT_BIND_CARD", "MY_BIND_CARD", "MY_BIND_CARD_TWO", "PAY", "SIGN_BIND_CARD", "SUPER_PAY_BIND_CARD", "WITHDRAW", "WITHDRAW_MAIN", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String BIND_CARD_RESULT = "bind_card_result";
        public static final int CARD_LIST = 3;
        public static final int CHARGE = 1;
        public static final int CHARGE_MAIN = 6;
        public static final int FRONT_PAY = 8;
        public static final int INDEPENDENT_BIND_CARD = 9;
        public static final int MY_BIND_CARD = 4;
        public static final int MY_BIND_CARD_TWO = 5;
        public static final int PAY = 0;
        public static final int SIGN_BIND_CARD = 10;
        public static final int SUPER_PAY_BIND_CARD = 11;
        public static final int WITHDRAW = 2;
        public static final int WITHDRAW_MAIN = 7;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayNormalBindCardService$SourceType;", "", "mType", "", "mDesc", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getMDesc", "()Ljava/lang/String;", "setMDesc", "(Ljava/lang/String;)V", "getMType", "()I", "setMType", "(I)V", "Null", "Pay", "Charge", "WithDraw", "CardList", "MyBindCard", "MyBindCardTwo", "ChargeMain", "WithDrawMain", "FrontPay", "IndependentBindCard", "SignAndPayIndependentBindCard", "SuperPay", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum SourceType extends Enum<SourceType> {
        private static final /* synthetic */ SourceType[] $VALUES = null;
        public static final SourceType CardList = null;
        public static final SourceType Charge = null;
        public static final SourceType ChargeMain = null;
        public static final SourceType FrontPay = null;
        public static final SourceType IndependentBindCard = null;
        public static final SourceType MyBindCard = null;
        public static final SourceType MyBindCardTwo = null;
        public static final SourceType Null = null;
        public static final SourceType Pay = null;
        public static final SourceType SignAndPayIndependentBindCard = null;
        public static final SourceType SuperPay = null;
        public static final SourceType WithDraw = null;
        public static final SourceType WithDrawMain = null;
        private String mDesc;
        private int mType;

        private static final /* synthetic */ SourceType[] $values() {
            return new SourceType[]{Null, Pay, Charge, WithDraw, CardList, MyBindCard, MyBindCardTwo, ChargeMain, WithDrawMain, FrontPay, IndependentBindCard, SignAndPayIndependentBindCard, SuperPay};
        }

        public static SourceType valueOf(String r100) {
            return (SourceType) a.a(SourceType.class, r100);
        }

        public static SourceType[] values() {
            return (SourceType[]) $VALUES.clone();
        }

        static {
            Null = new SourceType("Null", 0, -1, "");
            Pay = new SourceType("Pay", 1, 0, "支付收银台");
            Charge = new SourceType("Charge", 2, 1, "充值收银台");
            WithDraw = new SourceType("WithDraw", 3, 2, "提现收银台");
            CardList = new SourceType("CardList", 4, 3, "卡列表");
            MyBindCard = new SourceType("MyBindCard", 5, 4, "我的银行卡绑卡");
            MyBindCardTwo = new SourceType("MyBindCardTwo", 6, 5, "我的银行卡首页");
            ChargeMain = new SourceType("ChargeMain", 7, 6, "充值收银台入口");
            WithDrawMain = new SourceType("WithDrawMain", 8, 7, "提现收银台入口");
            FrontPay = new SourceType("FrontPay", 9, 8, "电商前置收银台");
            IndependentBindCard = new SourceType("IndependentBindCard", 10, 9, "H5独立绑卡入口");
            SignAndPayIndependentBindCard = new SourceType("SignAndPayIndependentBindCard", 11, 10, "签约并支付独立绑卡");
            SuperPay = new SourceType("SuperPay", 12, 11, "极速付");
            $VALUES = $values();
        }

        public final String getMDesc() {
            return this.mDesc;
        }

        public final int getMType() {
            return this.mType;
        }

        public final void setMDesc(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.mDesc = r100;
        }

        public final void setMType(int r100) {
            this.mType = r100;
        }

        private SourceType(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.mType = r102;
            this.mDesc = r103;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    INormalBindCardCallback getNormalBindCardCallback();

    boolean isLynxBindCardProcess();

    void release();

    void setPayNewCardCallback(ICJPayNewCardCallback r100);

    void setPayTimeTrackCallback(ICJPayTimeTrackCallback r100);

    void startBindCardProcess(Activity r100, BindCardType r101, NormalBindCardBean r102, INormalBindCardCallback r103);
}
