package com.android.ttcjpaysdk.base;

import android.content.Context;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayPerformanceService;
import com.android.ttcjpaysdk.thirdparty.base.CJPayBaseConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class CJPayPerformance {
    public static final long FPS_START_DELAY = 4000;
    private static volatile CJPayPerformance instance;
    private ICJPayPerformanceService performanceService;

    public static final enum Module extends Enum<Module> {
        private static final /* synthetic */ Module[] $VALUES = null;
        public static final Module ALI_PAY = null;
        public static final Module AUTH = null;
        public static final Module BASE_PAY = null;
        public static final Module BD_COUNTER = null;
        public static final Module BIND_CARD = null;
        public static final Module CARD_LIST = null;
        public static final Module CMB_PAY = null;
        public static final Module FACE_LIVE = null;
        public static final Module FAST_PAY = null;
        public static final Module FINGER_PRINT = null;
        public static final Module GECKO = null;
        public static final Module H5 = null;
        public static final Module IMAGE_LOADER = null;
        public static final Module INTEGRATED_COUNTER = null;
        public static final Module INTEGRATED_SIGN_COUNTER = null;
        public static final Module LOGIN = null;
        public static final Module MY_BANK_CARD = null;
        public static final Module NETWORK = null;
        public static final Module OCR = null;
        public static final Module OFFLINE = null;
        public static final Module OUTER_PAY = null;
        public static final Module PAYMENT_METHOD = null;
        public static final Module RECHARGE = null;
        public static final Module RESTRICTED = null;
        public static final Module SDK_API = null;
        public static final Module SETTINGS = null;
        public static final Module SIGN_ONLY = null;
        public static final Module SUPPLEMENTARY_SIGN = null;
        public static final Module VERIFY = null;
        public static final Module WITHDRAW = null;
        public static final Module WX_PAY = null;
        private String name;

        private static /* synthetic */ Module[] $values() {
            return new Module[]{AUTH, H5, LOGIN, OCR, SETTINGS, OFFLINE, RECHARGE, WITHDRAW, BIND_CARD, BD_COUNTER, FACE_LIVE, FINGER_PRINT, CARD_LIST, MY_BANK_CARD, RESTRICTED, SUPPLEMENTARY_SIGN, INTEGRATED_COUNTER, VERIFY, BASE_PAY, ALI_PAY, WX_PAY, CMB_PAY, NETWORK, SDK_API, IMAGE_LOADER, FAST_PAY, INTEGRATED_SIGN_COUNTER, SIGN_ONLY, OUTER_PAY, PAYMENT_METHOD, GECKO};
        }

        static {
            AUTH = new Module("AUTH", 0, "实名授权");
            H5 = new Module("H5", 1, "h5");
            LOGIN = new Module("LOGIN", 2, "无感登录");
            OCR = new Module("OCR", 3, "银行卡OCR");
            SETTINGS = new Module("SETTINGS", 4, "settings");
            OFFLINE = new Module("OFFLINE", 5, "离线包");
            RECHARGE = new Module("RECHARGE", 6, "余额充值");
            WITHDRAW = new Module("WITHDRAW", 7, "余额提现");
            BIND_CARD = new Module("BIND_CARD", 8, CJPayBaseConstant.CJ_PAY_TYPE_BIND_CARD);
            BD_COUNTER = new Module("BD_COUNTER", 9, "追光收银台");
            FACE_LIVE = new Module("FACE_LIVE", 10, "活体");
            FINGER_PRINT = new Module("FINGER_PRINT", 11, "指纹");
            CARD_LIST = new Module("CARD_LIST", 12, "前置卡列表");
            MY_BANK_CARD = new Module("MY_BANK_CARD", 13, "我的银行卡");
            RESTRICTED = new Module("RESTRICTED", 14, "一键支付");
            SUPPLEMENTARY_SIGN = new Module("SUPPLEMENTARY_SIGN", 15, "补签约");
            INTEGRATED_COUNTER = new Module("INTEGRATED_COUNTER", 16, "聚合收银台");
            VERIFY = new Module("VERIFY", 17, "验证组件");
            BASE_PAY = new Module("BASE_PAY", 18, "三方支付基础");
            ALI_PAY = new Module("ALI_PAY", 19, "支付宝");
            WX_PAY = new Module("WX_PAY", 20, "微信支付");
            CMB_PAY = new Module("CMB_PAY", 21, "招行一网通");
            NETWORK = new Module("NETWORK", 22, "网络库");
            SDK_API = new Module("SDK_API", 23, "SDK_API");
            IMAGE_LOADER = new Module("IMAGE_LOADER", 24, "图片加载");
            FAST_PAY = new Module("FAST_PAY", 25, "极速支付");
            INTEGRATED_SIGN_COUNTER = new Module("INTEGRATED_SIGN_COUNTER", 26, "聚合签约收银台");
            SIGN_ONLY = new Module("SIGN_ONLY", 27, "代扣签约");
            OUTER_PAY = new Module("OUTER_PAY", 28, "唤端组件");
            PAYMENT_METHOD = new Module("PAYMENT_METHOD", 29, "支付方式");
            GECKO = new Module("GECKO", 30, "离线包—gecko");
            $VALUES = $values();
        }

        public static Module[] values() {
            return (Module[]) $VALUES.clone();
        }

        public String getName() {
            return this.name;
        }

        public static Module valueOf(String r100) {
            return (Module) r27.a.a(Module.class, r100);
        }

        private Module(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public void stopFpsTrace(String r100) {
    }

    public static CJPayPerformance getInstance() {
        if (instance != null) goto L15;
        monitor-enter(CJPayPerformance.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CJPayPerformance();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CJPayPerformance.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public boolean isInstallApmMonitor() {
        ICJPayPerformanceService r100 = this.performanceService;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isInstallApmMonitor();
    }

    public boolean isInstallAppLog() {
        ICJPayPerformanceService r100 = this.performanceService;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isInstallAppLog();
    }

    private CJPayPerformance() {
        this.performanceService = (ICJPayPerformanceService) CJPayServiceManager.getInstance().getIService(ICJPayPerformanceService.class);
    }

    public void endKeepPage(String r100) {
        ICJPayPerformanceService r101 = this.performanceService;
        if (r101 == null) goto L6;
        r101.endKeepPage(r100);
        return;
    }

    public void init(Context r100) {
        ICJPayPerformanceService r101 = this.performanceService;
        if (r101 == null) goto L6;
        r101.init(r100);
        return;
    }

    public void initByModule(String r100) {
        ICJPayPerformanceService r101 = this.performanceService;
        if (r101 == null) goto L6;
        r101.initModule(r100);
        return;
    }

    public void startKeepPage(String r100) {
        ICJPayPerformanceService r101 = this.performanceService;
        if (r101 == null) goto L6;
        r101.startKeepPage(r100);
        return;
    }

    public void onAppLogEvent(String r100, JSONObject r101) {
        ICJPayPerformanceService r102 = this.performanceService;
        if (r102 == null) goto L6;
        r102.onAppLogEvent(r100, r101);
        return;
    }

    public void onApmMonitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        ICJPayPerformanceService r104 = this.performanceService;
        if (r104 == null) goto L6;
        r104.onApmMonitorEvent(r100, r101, r102, r103);
        return;
    }
}
