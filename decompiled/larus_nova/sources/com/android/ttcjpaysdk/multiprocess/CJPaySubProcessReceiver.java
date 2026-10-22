package com.android.ttcjpaysdk.multiprocess;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayResult;
import com.bytedance.caijing.sdk.infra.base.api.plugin.receiver.PlugInReceiverManager;

/* JADX INFO: loaded from: classes39.dex */
public class CJPaySubProcessReceiver implements PlugInReceiverManager.a {
    private static final String CJ_PAY_MULTI_PROCESS_PERMISSION = "permission.cjpay.multi.process";
    private static final String CJ_PAY_SUB_PROCESS_ACTION = "CJ_PAY_SUB_PROCESS_ACTION";
    private static final String MULTI_PROCESS_H5_CODE_RESULT = "multi_process_h5_code_result";
    private static final String MULTI_PROCESS_H5_MSG_RESULT = "multi_process_h5_msg_result";
    private static final String MULTI_PROCESS_PAY_RESULT = "multi_process_pay_result";
    private static final String MULTI_PROCESS_RESULT_H5_PAY = "H5_RESULT";
    private static final String MULTI_PROCESS_RESULT_TYPE = "multi_process_result_type";
    private static final String MULTI_PROCESS_RESULT_TYPE_PAY = "PAY_RESULT";

    public CJPaySubProcessReceiver() {
    }

    public static void payResultNotify(Context r100, TTCJPayResult r101) {
        Intent r102 = new Intent(CJ_PAY_SUB_PROCESS_ACTION);
        r102.putExtra(MULTI_PROCESS_RESULT_TYPE, MULTI_PROCESS_RESULT_TYPE_PAY);
        r102.putExtra(MULTI_PROCESS_PAY_RESULT, r101);
        r100.sendBroadcast(r102);
    }

    public static void registerReceiver(Context r100, PlugInReceiverManager.a r101) {
        PlugInReceiverManager.f202242a.registerReceiver(r100, r101, new IntentFilter(CJ_PAY_SUB_PROCESS_ACTION), r100.getPackageName() + ".permission.cjpay.multi.process", null);
    }

    public static void unregisterReceiver(Context r100, PlugInReceiverManager.a r101) {
        PlugInReceiverManager.f202242a.unregisterReceiver(r101);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.receiver.PlugInReceiverManager.a
    public void onReceive(Context r100, Intent r101) {
        String r102 = r101.getStringExtra(MULTI_PROCESS_RESULT_TYPE);     // Catch: Exception -> L20
        int r103 = r102.hashCode();     // Catch: Exception -> L20
        if (r103 == 1257036724) goto L11;
        if (r103 == 1714305967) goto L8;
    L13:
        byte r104 = -1;
    L14:
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L24;
        int r105 = r101.getIntExtra(MULTI_PROCESS_H5_CODE_RESULT, 0);     // Catch: Exception -> L20
        String r106 = r101.getStringExtra(MULTI_PROCESS_H5_MSG_RESULT);     // Catch: Exception -> L20
        CJPayCallBackCenter.getInstance().getH5PayCallback().onResult(r105, r106);     // Catch: Exception -> L20
        return;
    L24:
        return;
    L18:
        TTCJPayResult r107 = (TTCJPayResult) r101.getParcelableExtra(MULTI_PROCESS_PAY_RESULT);     // Catch: Exception -> L20
        CJPayCallBackCenter.getInstance().getObserver().onPayCallback(r107);     // Catch: Exception -> L20
        return;
    L8:
        if (r102.equals(MULTI_PROCESS_RESULT_H5_PAY) == false) goto L13;
        r104 = 1;
        goto L14
    L11:
        if (r102.equals(MULTI_PROCESS_RESULT_TYPE_PAY) == false) goto L13;
        r104 = 0;
    L20:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySubProcessReceiver#onReceive", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySubProcessReceiver#onReceive", e);
    }

    public static void h5ResultNotify(Context r100, int r101, String r102) {
        Intent r103 = new Intent(CJ_PAY_SUB_PROCESS_ACTION);
        r103.putExtra(MULTI_PROCESS_RESULT_TYPE, MULTI_PROCESS_RESULT_H5_PAY);
        r103.putExtra(MULTI_PROCESS_H5_CODE_RESULT, r101);
        r103.putExtra(MULTI_PROCESS_H5_MSG_RESULT, r102);
        r100.sendBroadcast(r103);
    }
}
