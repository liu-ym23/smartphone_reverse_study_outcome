package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.req;

import com.android.ttcjpaysdk.thirdparty.front.counter.dypay.activity.DyPayCoreActivity;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b+\u0018\u00002\u00020\u0001:\u00029:B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001c\u0010*\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001c\u0010-\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001c\u00100\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001c\u00103\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001c\u00106\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\b¨\u0006;"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyRefreshPreTradeCreateReq;", "", "()V", "fail_reason_code", "", "getFail_reason_code", "()Ljava/lang/String;", "setFail_reason_code", "(Ljava/lang/String;)V", "fail_reason_msg", "getFail_reason_msg", "setFail_reason_msg", DyPayCoreActivity.EXTRA_HIT_SDK_CASHIER_CORE_MERGE, "getHit_sdk_cashier_core_merge", "setHit_sdk_cashier_core_merge", "is_choose_pay_and_x", "", "()Ljava/lang/Boolean;", "set_choose_pay_and_x", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "is_choose_recommend_info", "set_choose_recommend_info", "is_show_pay_and_x_info", "set_show_pay_and_x_info", "is_show_recommend_info", "set_show_recommend_info", "last_pay_process_id", "getLast_pay_process_id", "setLast_pay_process_id", "last_pay_process_info", "getLast_pay_process_info", "setLast_pay_process_info", "pre_select_paytype", "getPre_select_paytype", "setPre_select_paytype", "previous_process", "getPrevious_process", "setPrevious_process", a.KEY_RECOMMEND_TYPE, "getRecommend_type", "setRecommend_type", "refresh_passback_param", "getRefresh_passback_param", "setRefresh_passback_param", "refresh_scene", "getRefresh_scene", "setRefresh_scene", "reload_from", "getReload_from", "setReload_from", "target_page_pay_mode", "getTarget_page_pay_mode", "setTarget_page_pay_mode", "top_asset_meta_info_list", "getTop_asset_meta_info_list", "setTop_asset_meta_info_list", "ReloadFrom", "TargetPagePayMode", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyRefreshPreTradeCreateReq {
    private String fail_reason_code;
    private String fail_reason_msg;
    private String hit_sdk_cashier_core_merge;
    private Boolean is_choose_pay_and_x;
    private Boolean is_choose_recommend_info;
    private Boolean is_show_pay_and_x_info;
    private Boolean is_show_recommend_info;
    private String last_pay_process_id;
    private String last_pay_process_info;
    private String pre_select_paytype;
    private String previous_process;
    private String recommend_type;
    private String refresh_passback_param;
    private String refresh_scene;
    private String reload_from;
    private String target_page_pay_mode;
    private String top_asset_meta_info_list;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyRefreshPreTradeCreateReq$ReloadFrom;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AUXILIARY_BTN", "TOP_RIGHT_BTN", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ReloadFrom extends Enum<ReloadFrom> {
        private static final /* synthetic */ ReloadFrom[] $VALUES = null;
        public static final ReloadFrom AUXILIARY_BTN = null;
        public static final ReloadFrom TOP_RIGHT_BTN = null;
        private final String value;

        private static final /* synthetic */ ReloadFrom[] $values() {
            return new ReloadFrom[]{AUXILIARY_BTN, TOP_RIGHT_BTN};
        }

        public static ReloadFrom valueOf(String r100) {
            return (ReloadFrom) r27.a.a(ReloadFrom.class, r100);
        }

        public static ReloadFrom[] values() {
            return (ReloadFrom[]) $VALUES.clone();
        }

        static {
            AUXILIARY_BTN = new ReloadFrom("AUXILIARY_BTN", 0, "auxiliary_btn");
            TOP_RIGHT_BTN = new ReloadFrom("TOP_RIGHT_BTN", 1, "top_right_btn");
            $VALUES = $values();
        }

        public final String getValue() {
            return this.value;
        }

        private ReloadFrom(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyRefreshPreTradeCreateReq$TargetPagePayMode;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NORMAL_PAY_MODE", "FRONT_HOMEPAGE_MODE", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum TargetPagePayMode extends Enum<TargetPagePayMode> {
        private static final /* synthetic */ TargetPagePayMode[] $VALUES = null;
        public static final TargetPagePayMode FRONT_HOMEPAGE_MODE = null;
        public static final TargetPagePayMode NORMAL_PAY_MODE = null;
        private final String value;

        private static final /* synthetic */ TargetPagePayMode[] $values() {
            return new TargetPagePayMode[]{NORMAL_PAY_MODE, FRONT_HOMEPAGE_MODE};
        }

        public static TargetPagePayMode valueOf(String r100) {
            return (TargetPagePayMode) r27.a.a(TargetPagePayMode.class, r100);
        }

        public static TargetPagePayMode[] values() {
            return (TargetPagePayMode[]) $VALUES.clone();
        }

        static {
            NORMAL_PAY_MODE = new TargetPagePayMode("NORMAL_PAY_MODE", 0, "0");
            FRONT_HOMEPAGE_MODE = new TargetPagePayMode("FRONT_HOMEPAGE_MODE", 1, "1");
            $VALUES = $values();
        }

        public final String getValue() {
            return this.value;
        }

        private TargetPagePayMode(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public CJUnifyRefreshPreTradeCreateReq() {
    }

    public final String getFail_reason_code() {
        return this.fail_reason_code;
    }

    public final String getFail_reason_msg() {
        return this.fail_reason_msg;
    }

    public final String getHit_sdk_cashier_core_merge() {
        return this.hit_sdk_cashier_core_merge;
    }

    public final String getLast_pay_process_id() {
        return this.last_pay_process_id;
    }

    public final String getLast_pay_process_info() {
        return this.last_pay_process_info;
    }

    public final String getPre_select_paytype() {
        return this.pre_select_paytype;
    }

    public final String getPrevious_process() {
        return this.previous_process;
    }

    public final String getRecommend_type() {
        return this.recommend_type;
    }

    public final String getRefresh_passback_param() {
        return this.refresh_passback_param;
    }

    public final String getRefresh_scene() {
        return this.refresh_scene;
    }

    public final String getReload_from() {
        return this.reload_from;
    }

    public final String getTarget_page_pay_mode() {
        return this.target_page_pay_mode;
    }

    public final String getTop_asset_meta_info_list() {
        return this.top_asset_meta_info_list;
    }

    public final Boolean is_choose_pay_and_x() {
        return this.is_choose_pay_and_x;
    }

    public final Boolean is_choose_recommend_info() {
        return this.is_choose_recommend_info;
    }

    public final Boolean is_show_pay_and_x_info() {
        return this.is_show_pay_and_x_info;
    }

    public final Boolean is_show_recommend_info() {
        return this.is_show_recommend_info;
    }

    public final void setFail_reason_code(String r100) {
        this.fail_reason_code = r100;
    }

    public final void setFail_reason_msg(String r100) {
        this.fail_reason_msg = r100;
    }

    public final void setHit_sdk_cashier_core_merge(String r100) {
        this.hit_sdk_cashier_core_merge = r100;
    }

    public final void setLast_pay_process_id(String r100) {
        this.last_pay_process_id = r100;
    }

    public final void setLast_pay_process_info(String r100) {
        this.last_pay_process_info = r100;
    }

    public final void setPre_select_paytype(String r100) {
        this.pre_select_paytype = r100;
    }

    public final void setPrevious_process(String r100) {
        this.previous_process = r100;
    }

    public final void setRecommend_type(String r100) {
        this.recommend_type = r100;
    }

    public final void setRefresh_passback_param(String r100) {
        this.refresh_passback_param = r100;
    }

    public final void setRefresh_scene(String r100) {
        this.refresh_scene = r100;
    }

    public final void setReload_from(String r100) {
        this.reload_from = r100;
    }

    public final void setTarget_page_pay_mode(String r100) {
        this.target_page_pay_mode = r100;
    }

    public final void setTop_asset_meta_info_list(String r100) {
        this.top_asset_meta_info_list = r100;
    }

    public final void set_choose_pay_and_x(Boolean r100) {
        this.is_choose_pay_and_x = r100;
    }

    public final void set_choose_recommend_info(Boolean r100) {
        this.is_choose_recommend_info = r100;
    }

    public final void set_show_pay_and_x_info(Boolean r100) {
        this.is_show_pay_and_x_info = r100;
    }

    public final void set_show_recommend_info(Boolean r100) {
        this.is_show_recommend_info = r100;
    }
}
