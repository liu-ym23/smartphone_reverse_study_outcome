package com.android.ttcjpaysdk.base.service;

import androidx.fragment.app.Fragment;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCounterConstant;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001:\u0003-./J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\tH&J\b\u0010\u0014\u001a\u00020\u0012H&J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0012H&J\b\u0010\u0017\u001a\u00020\u0010H&J&\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u00122\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u001c\u001a\u00020\u0010H&J\b\u0010\u001d\u001a\u00020\u0010H&J\b\u0010\u001e\u001a\u00020\u0010H&J\u0012\u0010\u001f\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010!H&J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0003H&J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0007H&J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u000bH&J\u0012\u0010(\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010\rH&J\b\u0010*\u001a\u00020\u0010H&J\b\u0010+\u001a\u00020\u0010H&J\b\u0010,\u001a\u00020\u0010H&¨\u00060"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayCombineService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "getCombineType", "Lcom/android/ttcjpaysdk/base/service/ICJPayCombineService$CombineType;", "getCurrentMethod", "", "getErrorType", "Lcom/android/ttcjpaysdk/base/service/ICJPayCombineService$CombinePayErrorType;", "getFragment", "Landroidx/fragment/app/Fragment;", "getPaySource", "Lcom/android/ttcjpaysdk/base/service/ICJPayCombineService$CombinePaySource;", "getSelectedCardInfo", "", "getSelectedCardNo", "hideBtnLoading", "", "isCombineFragment", "", WidgetService.PARAM_FRAGMENT, "isInsufficentStatus", "isQueryConnecting", "query", "logBackBtnClick", "processRoutineErrorCode", "toastMsg", "isTriggerTradeCreate", "code", "refreshCardList", "refreshCombinePayHeader", "release", "setCallBack", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPayCombineCallback;", "setCombineType", "type", "setErrorType", "errorType", "setPaySource", "source", "setShareData", "data", "setUnionPayDisable", "showBigLoading", "showBtnLoading", "CombinePayErrorType", "CombinePaySource", "CombineType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayCombineService extends ICJPayService {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayCombineService$CombinePayErrorType;", "", "mType", "", "mDesc", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getMDesc", "()Ljava/lang/String;", "setMDesc", "(Ljava/lang/String;)V", "getMType", "()I", "setMType", "(I)V", "Init", "NewCardInsufficentError", "NewCardOtherError", "OldCardInsufficentError", "OldCardOtherError", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum CombinePayErrorType extends Enum<CombinePayErrorType> {
        private static final /* synthetic */ CombinePayErrorType[] $VALUES = null;
        public static final CombinePayErrorType Init = null;
        public static final CombinePayErrorType NewCardInsufficentError = null;
        public static final CombinePayErrorType NewCardOtherError = null;
        public static final CombinePayErrorType OldCardInsufficentError = null;
        public static final CombinePayErrorType OldCardOtherError = null;
        private String mDesc;
        private int mType;

        private static final /* synthetic */ CombinePayErrorType[] $values() {
            return new CombinePayErrorType[]{Init, NewCardInsufficentError, NewCardOtherError, OldCardInsufficentError, OldCardOtherError};
        }

        public static CombinePayErrorType valueOf(String r100) {
            return (CombinePayErrorType) a.a(CombinePayErrorType.class, r100);
        }

        public static CombinePayErrorType[] values() {
            return (CombinePayErrorType[]) $VALUES.clone();
        }

        static {
            Init = new CombinePayErrorType("Init", 0, -1, "初始状态");
            NewCardInsufficentError = new CombinePayErrorType("NewCardInsufficentError", 1, 0, "新卡余额不足");
            NewCardOtherError = new CombinePayErrorType("NewCardOtherError", 2, 1, "新卡非余额不足");
            OldCardInsufficentError = new CombinePayErrorType("OldCardInsufficentError", 3, 2, "老卡余额不足");
            OldCardOtherError = new CombinePayErrorType("OldCardOtherError", 4, 3, "老卡非余额不足");
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

        private CombinePayErrorType(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.mType = r102;
            this.mDesc = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayCombineService$CombinePaySource;", "", "from", "", "mDesc", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getFrom", "()I", "setFrom", "(I)V", "getMDesc", "()Ljava/lang/String;", "setMDesc", "(Ljava/lang/String;)V", "Init", "FromConfirmFragment", "FromMethodFragment", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum CombinePaySource extends Enum<CombinePaySource> {
        private static final /* synthetic */ CombinePaySource[] $VALUES = null;
        public static final CombinePaySource FromConfirmFragment = null;
        public static final CombinePaySource FromMethodFragment = null;
        public static final CombinePaySource Init = null;
        private int from;
        private String mDesc;

        private static final /* synthetic */ CombinePaySource[] $values() {
            return new CombinePaySource[]{Init, FromConfirmFragment, FromMethodFragment};
        }

        public static CombinePaySource valueOf(String r100) {
            return (CombinePaySource) a.a(CombinePaySource.class, r100);
        }

        public static CombinePaySource[] values() {
            return (CombinePaySource[]) $VALUES.clone();
        }

        static {
            Init = new CombinePaySource("Init", 0, -1, "初始状态");
            FromConfirmFragment = new CombinePaySource("FromConfirmFragment", 1, 0, "从收银台跳转过来，没有老卡的情况");
            FromMethodFragment = new CombinePaySource("FromMethodFragment", 2, 1, "从卡列表跳转过来，有老卡的情况");
            $VALUES = $values();
        }

        public final int getFrom() {
            return this.from;
        }

        public final String getMDesc() {
            return this.mDesc;
        }

        public final void setFrom(int r100) {
            this.from = r100;
        }

        public final void setMDesc(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.mDesc = r100;
        }

        private CombinePaySource(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.from = r102;
            this.mDesc = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nj\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayCombineService$CombineType;", "", "type", "", SocialConstants.PARAM_APP_DESC, "payType", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getPayType", "setPayType", "getType", "setType", "BalanceAndBankCard", "IncomeAndBankCard", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum CombineType extends Enum<CombineType> {
        private static final /* synthetic */ CombineType[] $VALUES = null;
        public static final CombineType BalanceAndBankCard = null;
        public static final CombineType IncomeAndBankCard = null;
        private String desc;
        private String payType;
        private String type;

        private static final /* synthetic */ CombineType[] $values() {
            return new CombineType[]{BalanceAndBankCard, IncomeAndBankCard};
        }

        public static CombineType valueOf(String r100) {
            return (CombineType) a.a(CombineType.class, r100);
        }

        public static CombineType[] values() {
            return (CombineType[]) $VALUES.clone();
        }

        static {
            BalanceAndBankCard = new CombineType("BalanceAndBankCard", 0, "3", "零钱+银行卡", "balance");
            IncomeAndBankCard = new CombineType("IncomeAndBankCard", 1, CJPayCounterConstant.CJ_PAY_KEY_COMBINE_TYPE_INCOME_BANK_CARD, "收入+银行卡", "income");
            $VALUES = $values();
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getPayType() {
            return this.payType;
        }

        public final String getType() {
            return this.type;
        }

        public final void setDesc(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.desc = r100;
        }

        public final void setPayType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.payType = r100;
        }

        public final void setType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.type = r100;
        }

        private CombineType(String r100, int r101, String r102, String r103, String r104) {
            super(r100, r101);
            this.type = r102;
            this.desc = r103;
            this.payType = r104;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void processRoutineErrorCode$default(ICJPayCombineService r100, String r101, boolean r102, String r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = "";
        L6:
            r100.processRoutineErrorCode(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processRoutineErrorCode");
        }
    }

    CombineType getCombineType();

    String getCurrentMethod();

    CombinePayErrorType getErrorType();

    Fragment getFragment();

    CombinePaySource getPaySource();

    Object getSelectedCardInfo();

    String getSelectedCardNo();

    void hideBtnLoading();

    boolean isCombineFragment(Fragment r100);

    boolean isInsufficentStatus();

    void isQueryConnecting(boolean r100);

    void logBackBtnClick();

    void processRoutineErrorCode(String r100, boolean r101, String r102);

    void refreshCardList();

    void refreshCombinePayHeader();

    void release();

    void setCallBack(ICJPayCombineCallback r100);

    void setCombineType(CombineType r100);

    void setErrorType(CombinePayErrorType r100);

    void setPaySource(CombinePaySource r100);

    void setShareData(Object r100);

    void setUnionPayDisable();

    void showBigLoading();

    void showBtnLoading();
}
