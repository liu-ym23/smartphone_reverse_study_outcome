package com.android.ttcjpaysdk.verify.constants;

import android.util.Pair;
import com.amap.api.services.core.AMapException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0007J\b\u0010\u0010\u001a\u00020\u0007H\u0007J\b\u0010\u0011\u001a\u00020\u0007H\u0007R,\u0010\u0003\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R,\u0010\b\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R,\u0010\t\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R,\u0010\n\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R,\u0010\u000b\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R,\u0010\f\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R,\u0010\r\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R,\u0010\u000e\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/verify/constants/DyVerifyResultCode;", "", "()V", "CJ_PAY_DY_VERIFY_BLOCK", "Landroid/util/Pair;", "", "kotlin.jvm.PlatformType", "", "CJ_PAY_DY_VERIFY_CANCEL", "CJ_PAY_DY_VERIFY_CHANGE", "CJ_PAY_DY_VERIFY_FAILED", "CJ_PAY_DY_VERIFY_NOT_CALLBACK", "CJ_PAY_DY_VERIFY_PARAMS_ERROR", "CJ_PAY_DY_VERIFY_SUCCESS", "CJ_PAY_DY_VERIFY_UNKNOWN_ERROR", "getCancelMsg", "getFailMsg", "getSuccessMsg", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyResultCode {
    public static final Pair<Integer, String> CJ_PAY_DY_VERIFY_BLOCK = null;
    public static final Pair<Integer, String> CJ_PAY_DY_VERIFY_CANCEL = null;
    public static final Pair<Integer, String> CJ_PAY_DY_VERIFY_CHANGE = null;
    public static final Pair<Integer, String> CJ_PAY_DY_VERIFY_FAILED = null;
    public static final Pair<Integer, String> CJ_PAY_DY_VERIFY_NOT_CALLBACK = null;
    public static final Pair<Integer, String> CJ_PAY_DY_VERIFY_PARAMS_ERROR = null;
    public static final Pair<Integer, String> CJ_PAY_DY_VERIFY_SUCCESS = null;
    public static final Pair<Integer, String> CJ_PAY_DY_VERIFY_UNKNOWN_ERROR = null;
    public static final DyVerifyResultCode INSTANCE = null;

    private DyVerifyResultCode() {
    }

    static {
        INSTANCE = new DyVerifyResultCode();
        CJ_PAY_DY_VERIFY_SUCCESS = new Pair(0, "验证身份成功");
        CJ_PAY_DY_VERIFY_CANCEL = new Pair(1, "已取消验证身份");
        CJ_PAY_DY_VERIFY_FAILED = new Pair(2, "未通过身份验证");
        CJ_PAY_DY_VERIFY_PARAMS_ERROR = new Pair(3, "抱歉，当前系统异常，请稍后再试");
        CJ_PAY_DY_VERIFY_BLOCK = new Pair(4, "抱歉，为了保证账户安全，暂无法继续");
        CJ_PAY_DY_VERIFY_CHANGE = new Pair(5, "切换其他付款方式");
        CJ_PAY_DY_VERIFY_UNKNOWN_ERROR = new Pair(-1, AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        CJ_PAY_DY_VERIFY_NOT_CALLBACK = new Pair(-10000, "非回调类型");
    }

    @JvmStatic
    public static final String getCancelMsg() {
        return (String) CJ_PAY_DY_VERIFY_CANCEL.second;
    }

    @JvmStatic
    public static final String getFailMsg() {
        return (String) CJ_PAY_DY_VERIFY_FAILED.second;
    }

    @JvmStatic
    public static final String getSuccessMsg() {
        return (String) CJ_PAY_DY_VERIFY_SUCCESS.second;
    }
}
