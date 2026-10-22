package com.android.ttcjpaysdk.base.performance.crash;

import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayPerformance;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.thirdparty.counter.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class CrashCatchManager {
    private static volatile CrashCatchManager instance;
    private static Map<String, CrashModule> modules;

    static {
        modules = new HashMap();
    }

    public static CrashCatchManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(CrashCatchManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CrashCatchManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CrashCatchManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public void init() {
        HashMap r100 = new HashMap();
        modules = r100;
        r100.put("com.android.ttcjpaysdk.base.auth", new CrashModule(CJPayPerformance.Module.AUTH.getName()));
        modules.put("com.android.ttcjpaysdk.base.h5", new CrashModule(CJPayPerformance.Module.H5.getName()));
        modules.put("com.android.ttcjpaysdk.login", new CrashModule(CJPayPerformance.Module.LOGIN.getName()));
        modules.put("com.android.ttcjpaysdk.ocr", new CrashModule(CJPayPerformance.Module.OCR.getName()));
        modules.put("com.android.ttcjpaysdk.thirdparty.balancerecharge", new CrashModule(CJPayPerformance.Module.RECHARGE.getName()));
        modules.put("com.android.ttcjpaysdk.thirdparty.balancewithdraw", new CrashModule(CJPayPerformance.Module.WITHDRAW.getName()));
        Map<String, CrashModule> r101 = modules;
        CJPayPerformance.Module r102 = CJPayPerformance.Module.BIND_CARD;
        r101.put("com.android.ttcjpaysdk.bdpay.bindcard.normal", new CrashModule(r102.getName()));
        modules.put("com.android.ttcjpaysdk.bindcard", new CrashModule(r102.getName()));
        modules.put(BuildConfig.LIBRARY_PACKAGE_NAME, new CrashModule(CJPayPerformance.Module.BD_COUNTER.getName()));
        modules.put(com.android.ttcjpaysdk.facelive.BuildConfig.LIBRARY_PACKAGE_NAME, new CrashModule(CJPayPerformance.Module.FACE_LIVE.getName()));
        modules.put(com.android.ttcjpaysdk.thirdparty.fingerprint.BuildConfig.LIBRARY_PACKAGE_NAME, new CrashModule(CJPayPerformance.Module.FINGER_PRINT.getName()));
        modules.put("com.android.ttcjpaysdk.thirdparty.front.cardlist", new CrashModule(CJPayPerformance.Module.CARD_LIST.getName()));
        modules.put("com.android.ttcjpaysdk.thirdparty.front.mybankcard", new CrashModule(CJPayPerformance.Module.MY_BANK_CARD.getName()));
        modules.put(com.android.ttcjpaysdk.integrated.counter.BuildConfig.LIBRARY_PACKAGE_NAME, new CrashModule(CJPayPerformance.Module.INTEGRATED_COUNTER.getName()));
        modules.put("com.android.ttcjpaysdk.thirdparty.restricted", new CrashModule(CJPayPerformance.Module.RESTRICTED.getName()));
        modules.put(com.android.ttcjpaysdk.thirdparty.supplementarysign.BuildConfig.LIBRARY_PACKAGE_NAME, new CrashModule(CJPayPerformance.Module.SUPPLEMENTARY_SIGN.getName()));
        modules.put(com.android.ttcjpaysdk.thirdparty.verify.BuildConfig.LIBRARY_PACKAGE_NAME, new CrashModule(CJPayPerformance.Module.VERIFY.getName()));
        modules.put(com.android.ttcjpaysdk.base.paymentbasis.BuildConfig.LIBRARY_PACKAGE_NAME, new CrashModule(CJPayPerformance.Module.BASE_PAY.getName()));
        modules.put(com.android.ttcjpaysdk.base.alipay.BuildConfig.LIBRARY_PACKAGE_NAME, new CrashModule(CJPayPerformance.Module.ALI_PAY.getName()));
        modules.put(com.android.ttcjpaysdk.base.wxpay.BuildConfig.LIBRARY_PACKAGE_NAME, new CrashModule(CJPayPerformance.Module.WX_PAY.getName()));
        modules.put("com.android.ttcjpaysdk.base.cmbpay", new CrashModule(CJPayPerformance.Module.CMB_PAY.getName()));
        modules.put("com.android.ttcjpaysdk.base.imageloader", new CrashModule(CJPayPerformance.Module.IMAGE_LOADER.getName()));
        modules.put(com.android.ttcjpaysdk.fastpay.BuildConfig.LIBRARY_PACKAGE_NAME, new CrashModule(CJPayPerformance.Module.FAST_PAY.getName()));
        modules.put(com.android.ttcjpaysdk.integrated.sign.counter.BuildConfig.LIBRARY_PACKAGE_NAME, new CrashModule(CJPayPerformance.Module.INTEGRATED_SIGN_COUNTER.getName()));
        modules.put(com.android.ttcjpaysdk.bdpay.sign.BuildConfig.LIBRARY_PACKAGE_NAME, new CrashModule(CJPayPerformance.Module.SIGN_ONLY.getName()));
        modules.put(com.android.ttcjpaysdk.outer.pay.BuildConfig.LIBRARY_PACKAGE_NAME, new CrashModule(CJPayPerformance.Module.OUTER_PAY.getName()));
        modules.put(com.android.ttcjpaysdk.bdpay.paymentmethod.BuildConfig.LIBRARY_PACKAGE_NAME, new CrashModule(CJPayPerformance.Module.PAYMENT_METHOD.getName()));
    }

    private CrashCatchManager() {
    }

    public void initModule(String r100) {
        CrashModule r101 = modules.get(r100);     // Catch: Exception -> L11
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.isEntry == true) goto L16;
        JSONObject r102 = CJPayParamsUtils.getCommonLogParams("", "");     // Catch: Exception -> L11
        r102.put("code", "0");     // Catch: Exception -> L11
        r102.put("name", r101.moduleName);     // Catch: Exception -> L11
        CJPayCallBackCenter.getInstance().onEvent("wallet_rd_crash_module_rate", new JSONObject[]{r102});     // Catch: Exception -> L11
        r101.isEntry = true;     // Catch: Exception -> L11
        return;
    L16:
        return;
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CrashCatchManager#initModule", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CrashCatchManager#initModule", e);
    }
}
