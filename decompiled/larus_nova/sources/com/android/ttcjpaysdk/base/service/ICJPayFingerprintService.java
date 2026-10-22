package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import android.content.Context;
import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import java.util.Map;
import javax.crypto.Cipher;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ICJPayFingerprintService extends ICJPayService {
    void auth(Activity r100, ICJPayFingerprintAuthCallback r101);

    void cancelFingerprintVerify();

    void closeFingerprint(Context r100, String r101, JSONObject r102, ICJPayFingerprintSwitchCallback r103);

    void closeFingerprintByUserInfo(Context r100, String r101, JSONObject r102);

    void closeFingerprintWithSerialNum(Context r100, String r101, String r102, JSONObject r103);

    void enableFingerprint(Cipher r100, String r101, String r102, JSONObject r103, String r104, ICJPayFingerprintEnableCallback r105);

    void enableFingerprintWithoutPwd(Cipher r100, JSONObject r101, String r102, JSONObject r103, String r104, ICJPayFingerprintEnableCallback r105);

    void enableFingerprintWithoutPwdInPaymentManager(Cipher r100, String r101, String r102, JSONObject r103, String r104, ICJPayFingerprintEnableCallback r105);

    Map<String, Object> getFingerLocalStatus(String r100);

    ICJPayFingerprintSwitchCallback getSwitchCallback();

    boolean isLocalEnableFingerprint(Context r100, String r101);

    boolean isLocalEnableFingerprint(Context r100, String r101, boolean r102);

    boolean isLocalFingerprintTokenAvailable(Context r100, String r101);

    boolean isLocalTokenEmpty(String r100);

    boolean isSupportFingerprint(Context r100);

    boolean isSupportFingerprint(Context r100, Boolean r101);

    void openFingerprint(Context r100, String r101, ICJPayFingerprintSwitchCallback r102, JSONObject r103, String r104, String r105, JSONObject r106, String r107);

    void openFingerprint(Context r100, String r101, ICJPayFingerprintSwitchCallback r102, JSONObject r103, String r104, String r105, JSONObject r106, boolean r107);

    void queryFingerprintState(Context r100, String r101, ICJPayFingerprintStateCallback r102, JSONObject r103);

    void release();

    void releaseFingerprintGuide();

    void setIsShowToastWhenAuthError(boolean r100);

    void showFingerprintDialogForEnable(Activity r100, String r101, String r102, JSONObject r103, int r104, IFingerprintGuideCallback r105);

    void showFingerprintDialogInPaymentManager(Context r100, int r101, boolean r102, boolean r103, String r104, String r105, JSONObject r106, String r107, IFingerprintGuideCallback r108);

    void showFingerprintGuide(Context r100, int r101, boolean r102, boolean r103, JSONObject r104, String r105, JSONObject r106, String r107, IFingerprintGuideCallback r108);

    void showFingerprintGuide(Context r100, String r101, String r102, String r103, int r104, boolean r105, boolean r106, JSONObject r107, String r108, JSONObject r110, String r111, IFingerprintGuideCallback r112);

    void uploadFingerId(String r100);

    void verifyFingerprint(String r100, ICJPayFingerprintVerifyCallback r101);

    void verifyFingerprintWithEncryptCipher(String r100, ICJPayFingerprintVerifyOptCallback r101);

    void verifyFingerprintWithUI(Context r100, String r101, String r102, String r103, String r104, IH5PayCallback r105);
}
