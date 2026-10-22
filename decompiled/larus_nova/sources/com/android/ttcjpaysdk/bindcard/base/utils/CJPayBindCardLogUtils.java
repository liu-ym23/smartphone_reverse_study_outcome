package com.android.ttcjpaysdk.bindcard.base.utils;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.service.ICJPayNormalBindCardService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.bindcard.base.constants.CJPayBindCardType;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayBindCardLogUtils {
    private static String addbcard_type = "";
    private static int bindSourceType = 0;
    private static long bind_card_base_time = 0;
    private static int entry_name = 0;
    private static int haspass = 0;
    private static int is_auth = 0;
    private static boolean is_entry_name_init = false;
    private static int is_onestep = 0;
    private static int is_showPhone = 0;
    private static int needIdentify = 0;
    private static String source = "";
    private static ICJPayNormalBindCardService.SourceType type;

    public CJPayBindCardLogUtils() {
    }

    public static JSONObject getBindCardBizLogParams() {
        JSONObject r100 = new JSONObject();
        r100.put("needidentify", needIdentify);     // Catch: JSONException -> L24
        r100.put("haspass", haspass);     // Catch: JSONException -> L24
        r100.put("is_onestep", is_onestep);     // Catch: JSONException -> L24
        r100.put("show_onestep", 0);     // Catch: JSONException -> L24
        r100.put("is_auth", is_auth);     // Catch: JSONException -> L24
        r100.put("is_showphone", is_showPhone);     // Catch: JSONException -> L24
        if (TextUtils.isEmpty(source) == true) goto L6;
        r100.put("source", source);     // Catch: JSONException -> L24
    L6:
        r100.put("addbcard_type", addbcard_type);     // Catch: JSONException -> L24
        if (is_entry_name_init == false) goto L9;
        Object r101 = Integer.valueOf(entry_name);     // Catch: JSONException -> L24
    L10:
        r100.put("entry_name", r101);     // Catch: JSONException -> L24
        if (getBindSourceType() != 1) goto L14;
    L21:
        r100.put("tea_source", "balance_recharge");     // Catch: JSONException -> L24
    L22:
        r100.put("client_bankcard_duration", System.currentTimeMillis() - bind_card_base_time);     // Catch: JSONException -> L24
    L26:
        return r100;
    L14:
        if (getBindSourceType() == 6) goto L21;
        if (getBindSourceType() != 2) goto L19;
    L20:
        r100.put("tea_source", "balance_withdraw");     // Catch: JSONException -> L24
        goto L22
    L19:
        if (getBindSourceType() != 7) goto L22;
    L9:
        r101 = "";
    L24:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBindCardLogUtils#getBindCardBizLogParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBindCardLogUtils#getBindCardBizLogParams", e);
        goto L26
    }

    public static int getBindCardBizType() {
        ICJPayNormalBindCardService.SourceType r100 = type;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getMType();
    }

    public static ICJPayNormalBindCardService.SourceType getSourceType() {
        ICJPayNormalBindCardService.SourceType r100 = type;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return ICJPayNormalBindCardService.SourceType.Pay;
    }

    public static void startBindCardProcess() {
        bind_card_base_time = System.currentTimeMillis();
    }

    public static int getBindSourceType() {
        return bindSourceType;
    }

    public static int getEntryName() {
        return entry_name;
    }

    public static int getIsAuth() {
        return is_auth;
    }

    public static boolean getIsEntryNameInit() {
        return is_entry_name_init;
    }

    public static int getIsShowPhone() {
        return is_showPhone;
    }

    public static String getSource() {
        return source;
    }

    public static String getBankType(String r100) {
        int r101 = 0;
        CJPayBindCardType[] r102 = {CJPayBindCardType.ALL, CJPayBindCardType.DEBIT, CJPayBindCardType.CREDIT};
    L3:
        if (r101 >= 3) goto L9;
        CJPayBindCardType r103 = r102[r101];
        if (TextUtils.equals(r103.mType, r100) == true) goto L7;
        r101 = r101 + 1;
        goto L3
    L7:
        return r103.mDesc;
    L9:
        return "";
    }

    public static void setAddCardTypeForUnionPay(JSONObject r100) {
        if (r100 == null) goto L10;
        r100.put("addbcard_type", "云闪付");     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBindCardLogUtils#setAddCardTypeForUnionPay", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBindCardLogUtils#setAddCardTypeForUnionPay", e);
        return;
    }

    public static void setBindCardBizLogParams(ICJPayNormalBindCardService.SourceType r100) {
        type = r100;
    }

    public static void setBindSourceType(int r100) {
        bindSourceType = r100;
    }

    public static void setEntryName(int r100) {
        if (is_entry_name_init == true) goto L6;
        entry_name = r100;
        is_entry_name_init = true;
        return;
    }

    public static void setSource(String r100) {
        source = r100;
    }

    public static void doReport(String r100, JSONObject... r101) {
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayBindCardLogUtils#doReport", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayBindCardLogUtils#doReport", e);
    L13:
        CJPayCallBackCenter.getInstance().onEvent(r100, r101);
        return;
    L4:
        if (r101[0] == null) goto L13;
        BindCardCommonInfoUtil r102 = BindCardCommonInfoUtil.INSTANCE;     // Catch: Exception -> L11
        if (r102.getPayNewCardCallback() == null) goto L13;
        String r103 = r102.getPayNewCardCallback().getPayNewCardConfigs().optString(CrashHianalyticsData.PROCESS_ID);     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r103) == true) goto L13;
        r101[0].put(CrashHianalyticsData.PROCESS_ID, r103);     // Catch: Exception -> L11
        goto L13
    }

    public static void setAuthAndShowPhoneParams(int r100, int r101) {
        is_auth = r100;
        is_showPhone = r101;
    }

    public static void setBindCardBizLogParams(int r100, int r101, int r102) {
        needIdentify = r100;
        haspass = r101;
        is_onestep = r102;
    }

    public static void setBindCardBizLogParams(int r100, int r101, int r102, ICJPayNormalBindCardService.SourceType r103, boolean r104) {
        needIdentify = r100;
        haspass = r101;
        is_onestep = r102;
        type = r103;
    }
}
