package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.CJStringExtensionKt;
import com.android.ttcjpaysdk.thirdparty.base.CJPayBaseConstant;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u001d\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u001b\u001a\u00020\u001cR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/JumpInfoBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "action", "", "ext_map", "Lcom/android/ttcjpaysdk/base/ui/data/JumpInfoBean$ExtMap;", "ext_map_pb", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getExt_map_pb", "()Ljava/util/HashMap;", "setExt_map_pb", "(Ljava/util/HashMap;)V", "param", "Lcom/android/ttcjpaysdk/base/ui/data/JumpInfoBean$Param;", "param_pb", "getParam_pb", "()Ljava/lang/String;", "setParam_pb", "(Ljava/lang/String;)V", "show_info", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayUIComponent;", "Lkotlin/collections/ArrayList;", "url", "afterProtoDecode", "", TTVideoEngineInterface.PLAY_API_KEY_ACTION, "ExtMap", "Param", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JumpInfoBean implements CJPayObject, Serializable {
    public String action;
    public ExtMap ext_map;
    private HashMap<String, String> ext_map_pb;
    public Param param;
    private String param_pb;
    public ArrayList<CJPayUIComponent> show_info;
    public String url;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/JumpInfoBean$Action;", "", "value", "", SocialConstants.PARAM_APP_DESC, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getValue", "SubmitOrder", "BindCard", "UnlockCard", "CreditPayActive", "CreditPayUnlock", "RealNameAuth", "IncomeActivate", "AddPwd", "NewBankCardShare", "LargePay", "ActiveAndPay", "SwitchCombinePay", "DirectBank", "BankResign", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Action extends Enum<Action> {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final Action ActiveAndPay = null;
        public static final Action AddPwd = null;
        public static final Action BankResign = null;
        public static final Action BindCard = null;
        public static final Action CreditPayActive = null;
        public static final Action CreditPayUnlock = null;
        public static final Action DirectBank = null;
        public static final Action IncomeActivate = null;
        public static final Action LargePay = null;
        public static final Action NewBankCardShare = null;
        public static final Action RealNameAuth = null;
        public static final Action SubmitOrder = null;
        public static final Action SwitchCombinePay = null;
        public static final Action UnlockCard = null;
        private final String desc;
        private final String value;

        private static final /* synthetic */ Action[] $values() {
            return new Action[]{SubmitOrder, BindCard, UnlockCard, CreditPayActive, CreditPayUnlock, RealNameAuth, IncomeActivate, AddPwd, NewBankCardShare, LargePay, ActiveAndPay, SwitchCombinePay, DirectBank, BankResign};
        }

        public static Action valueOf(String r100) {
            return (Action) a.a(Action.class, r100);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }

        static {
            SubmitOrder = new Action("SubmitOrder", 0, "submit_order", "调用聚合的tradeconfirm");
            BindCard = new Action("BindCard", 1, "bind_card", CJPayBaseConstant.CJ_PAY_TYPE_BIND_CARD);
            UnlockCard = new Action("UnlockCard", 2, "unlock_card", "解锁银行卡");
            CreditPayActive = new Action("CreditPayActive", 3, "credit_activate", "月付激活");
            CreditPayUnlock = new Action("CreditPayUnlock", 4, "credit_unlock", "月付解锁");
            RealNameAuth = new Action("RealNameAuth", 5, "real_name_activate", "实名开户");
            IncomeActivate = new Action("IncomeActivate", 6, "income_activate", "业务收入开户");
            AddPwd = new Action("AddPwd", 7, "add_pwd", "补设密");
            NewBankCardShare = new Action("NewBankCardShare", 8, "new_bankcard_share", "共享新卡邀请");
            LargePay = new Action("LargePay", 9, "large_pay", "大额支付");
            ActiveAndPay = new Action("ActiveAndPay", 10, "active_and_pay", "先用后付");
            SwitchCombinePay = new Action("SwitchCombinePay", 11, "switch_combine_pay", "组合支付");
            DirectBank = new Action("DirectBank", 12, "direct_bank_sign", "直连银行");
            BankResign = new Action("BankResign", 13, "bank_resign", "补签约");
            $VALUES = $values();
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getValue() {
            return this.value;
        }

        private Action(String r100, int r101, String r102, String r103) {
            super(r100, r101);
            this.value = r102;
            this.desc = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/JumpInfoBean$ExtMap;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "active_then_pay", "", "add_new_card_index", "asset_verify_tag", "direct_unlock", "index", "need_pay", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ExtMap implements CJPayObject, Serializable {
        public String active_then_pay;
        public String add_new_card_index;
        public String asset_verify_tag;
        public String direct_unlock;
        public String index;
        public String need_pay;

        public ExtMap() {
            this.need_pay = "";
            this.direct_unlock = "";
            this.index = "";
            this.add_new_card_index = "";
            this.active_then_pay = "";
            this.asset_verify_tag = "";
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/JumpInfoBean$Param;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "bind_card_info", "", "card_trade_scene", "process_info", "real_trade_amount_raw", "tea_source", "track_info", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Param implements CJPayObject, Serializable {
        public String bind_card_info;
        public String card_trade_scene;
        public String process_info;
        public String real_trade_amount_raw;
        public String tea_source;
        public String track_info;

        public Param() {
            this.card_trade_scene = "";
            this.tea_source = "";
            this.bind_card_info = "";
            this.track_info = "";
            this.process_info = "";
            this.real_trade_amount_raw = "";
        }
    }

    public final void afterProtoDecode() {
        String r100 = this.param_pb;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L9;
        this.param = (Param) CJPayJsonParser.fromJson(this.param_pb, Param.class);
    L9:
        HashMap<String, String> r102 = this.ext_map_pb;
        if (r102 != null) goto L12;
    L36:
        this.param_pb = null;
        this.ext_map_pb = null;
        return;
    L12:
        if ((true ^ r102.isEmpty()) == true) goto L15;
        r102 = null;
    L15:
        if (r102 == null) goto L36;
        ExtMap r103 = new ExtMap();
        String r104 = r102.get("need_pay");
        String r105 = "";
        if (r104 != null) goto L19;
        r104 = "";
    L19:
        r103.need_pay = r104;
        String r106 = r102.get("direct_unlock");
        if (r106 != null) goto L22;
        r106 = "";
    L22:
        r103.direct_unlock = r106;
        String r107 = r102.get("index");
        if (r107 != null) goto L25;
        r107 = "";
    L25:
        r103.index = r107;
        String r108 = r102.get("add_new_card_index");
        if (r108 != null) goto L28;
        r108 = "";
    L28:
        r103.add_new_card_index = r108;
        String r109 = r102.get("active_then_pay");
        if (r109 != null) goto L31;
        r109 = "";
    L31:
        r103.active_then_pay = r109;
        String r110 = r102.get("asset_verify_tag");
        if (r110 == null) goto L35;
        r105 = r110;
    L35:
        r103.asset_verify_tag = r105;
        this.ext_map = r103;
        goto L36
    L5:
        if (CJStringExtensionKt.isNotNullOrEmpty(r100) != true) goto L7;
        r101 = true;
        goto L7
    }

    public JumpInfoBean() {
        this.show_info = new ArrayList();
        this.action = "";
        this.url = "";
        this.param = new Param();
        this.ext_map = new ExtMap();
    }

    public final HashMap<String, String> getExt_map_pb() {
        return this.ext_map_pb;
    }

    public final String getParam_pb() {
        return this.param_pb;
    }

    public final void setExt_map_pb(HashMap<String, String> r100) {
        this.ext_map_pb = r100;
    }

    public final void setParam_pb(String r100) {
        this.param_pb = r100;
    }
}
