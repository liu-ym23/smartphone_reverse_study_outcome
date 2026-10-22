package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model;

import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayUserInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.api.UnifyCommonBizParams;
import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyFingerprintPayParams;
import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyForgetPwdParams;
import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyIdParams;
import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyKeepDialogParams;
import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyLogParams;
import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyNoPwdPayParams;
import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyThemeParams;
import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyTokenPayParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010\u001aR\u001a\u00102\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0018\"\u0004\b3\u0010\u001aR\u001a\u00104\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001aR\u001a\u00106\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0018\"\u0004\b7\u0010\u001aR\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0018\"\u0004\bR\u0010\u001aR\u001c\u0010S\u001a\u0004\u0018\u00010TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Y\u001a\u0004\u0018\u00010ZX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^¨\u0006_"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyCommonParams;", "", "()V", "cancelMaxCount", "", "getCancelMaxCount", "()I", "setCancelMaxCount", "(I)V", "cjPayUserInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayUserInfo;", "getCjPayUserInfo", "()Lcom/android/ttcjpaysdk/thirdparty/data/CJPayUserInfo;", "setCjPayUserInfo", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayUserInfo;)V", "commonBizParams", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/api/UnifyCommonBizParams;", "getCommonBizParams", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/api/UnifyCommonBizParams;", "setCommonBizParams", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/api/UnifyCommonBizParams;)V", "enableStdThemePatch", "", "getEnableStdThemePatch", "()Z", "setEnableStdThemePatch", "(Z)V", "failMaxCount", "getFailMaxCount", "setFailMaxCount", "fingerprintPayParams", "Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyFingerprintPayParams;", "getFingerprintPayParams", "()Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyFingerprintPayParams;", "setFingerprintPayParams", "(Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyFingerprintPayParams;)V", "forgetPwdParams", "Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyForgetPwdParams;", "getForgetPwdParams", "()Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyForgetPwdParams;", "setForgetPwdParams", "(Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyForgetPwdParams;)V", "idParams", "Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyIdParams;", "getIdParams", "()Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyIdParams;", "setIdParams", "(Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyIdParams;)V", "isBioDegrade", "setBioDegrade", "isBioSwitchPwd", "setBioSwitchPwd", "isFastPay", "setFastPay", "isPwdFreeDegrade", "setPwdFreeDegrade", "keepDialogParams", "Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyKeepDialogParams;", "getKeepDialogParams", "()Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyKeepDialogParams;", "setKeepDialogParams", "(Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyKeepDialogParams;)V", "logParams", "Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyLogParams;", "getLogParams", "()Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyLogParams;", "setLogParams", "(Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyLogParams;)V", "noPwdPayParams", "Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyNoPwdPayParams;", "getNoPwdPayParams", "()Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyNoPwdPayParams;", "setNoPwdPayParams", "(Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyNoPwdPayParams;)V", "payInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;", "getPayInfo", "()Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;", "setPayInfo", "(Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;)V", "showDegradeInfo", "getShowDegradeInfo", "setShowDegradeInfo", "themeParams", "Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyThemeParams;", "getThemeParams", "()Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyThemeParams;", "setThemeParams", "(Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyThemeParams;)V", "verifyTokenPayParams", "Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyTokenPayParams;", "getVerifyTokenPayParams", "()Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyTokenPayParams;", "setVerifyTokenPayParams", "(Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyTokenPayParams;)V", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class UnifyPreVerifyCommonParams {
    private int cancelMaxCount;
    private CJPayUserInfo cjPayUserInfo;
    private UnifyCommonBizParams commonBizParams;
    private boolean enableStdThemePatch;
    private int failMaxCount;
    private VerifyFingerprintPayParams fingerprintPayParams;
    private VerifyForgetPwdParams forgetPwdParams;
    private VerifyIdParams idParams;
    private boolean isBioDegrade;
    private boolean isBioSwitchPwd;
    private boolean isFastPay;
    private boolean isPwdFreeDegrade;
    private VerifyKeepDialogParams keepDialogParams;
    private VerifyLogParams logParams;
    private VerifyNoPwdPayParams noPwdPayParams;
    private CJPayPayInfo payInfo;
    private boolean showDegradeInfo;
    private VerifyThemeParams themeParams;
    private VerifyTokenPayParams verifyTokenPayParams;

    public UnifyPreVerifyCommonParams() {
        this.fingerprintPayParams = new VerifyFingerprintPayParams(false, false, null, false, null, false, null, 127, null);
        this.failMaxCount = 5;
        this.cancelMaxCount = 5;
    }

    public final int getCancelMaxCount() {
        return this.cancelMaxCount;
    }

    public CJPayUserInfo getCjPayUserInfo() {
        return this.cjPayUserInfo;
    }

    public final UnifyCommonBizParams getCommonBizParams() {
        return this.commonBizParams;
    }

    public final boolean getEnableStdThemePatch() {
        return this.enableStdThemePatch;
    }

    public final int getFailMaxCount() {
        return this.failMaxCount;
    }

    public VerifyFingerprintPayParams getFingerprintPayParams() {
        return this.fingerprintPayParams;
    }

    public final VerifyForgetPwdParams getForgetPwdParams() {
        return this.forgetPwdParams;
    }

    public final VerifyIdParams getIdParams() {
        return this.idParams;
    }

    public final VerifyKeepDialogParams getKeepDialogParams() {
        return this.keepDialogParams;
    }

    public final VerifyLogParams getLogParams() {
        return this.logParams;
    }

    public final VerifyNoPwdPayParams getNoPwdPayParams() {
        return this.noPwdPayParams;
    }

    public final CJPayPayInfo getPayInfo() {
        return this.payInfo;
    }

    public final boolean getShowDegradeInfo() {
        return this.showDegradeInfo;
    }

    public final VerifyThemeParams getThemeParams() {
        return this.themeParams;
    }

    public final VerifyTokenPayParams getVerifyTokenPayParams() {
        return this.verifyTokenPayParams;
    }

    public final boolean isBioDegrade() {
        return this.isBioDegrade;
    }

    public final boolean isBioSwitchPwd() {
        return this.isBioSwitchPwd;
    }

    public final boolean isFastPay() {
        return this.isFastPay;
    }

    public final boolean isPwdFreeDegrade() {
        return this.isPwdFreeDegrade;
    }

    public final void setBioDegrade(boolean r100) {
        this.isBioDegrade = r100;
    }

    public final void setBioSwitchPwd(boolean r100) {
        this.isBioSwitchPwd = r100;
    }

    public final void setCancelMaxCount(int r100) {
        this.cancelMaxCount = r100;
    }

    public void setCjPayUserInfo(CJPayUserInfo r100) {
        this.cjPayUserInfo = r100;
    }

    public final void setCommonBizParams(UnifyCommonBizParams r100) {
        this.commonBizParams = r100;
    }

    public final void setEnableStdThemePatch(boolean r100) {
        this.enableStdThemePatch = r100;
    }

    public final void setFailMaxCount(int r100) {
        this.failMaxCount = r100;
    }

    public final void setFastPay(boolean r100) {
        this.isFastPay = r100;
    }

    public void setFingerprintPayParams(VerifyFingerprintPayParams r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fingerprintPayParams = r100;
    }

    public final void setForgetPwdParams(VerifyForgetPwdParams r100) {
        this.forgetPwdParams = r100;
    }

    public final void setIdParams(VerifyIdParams r100) {
        this.idParams = r100;
    }

    public final void setKeepDialogParams(VerifyKeepDialogParams r100) {
        this.keepDialogParams = r100;
    }

    public final void setLogParams(VerifyLogParams r100) {
        this.logParams = r100;
    }

    public final void setNoPwdPayParams(VerifyNoPwdPayParams r100) {
        this.noPwdPayParams = r100;
    }

    public final void setPayInfo(CJPayPayInfo r100) {
        this.payInfo = r100;
    }

    public final void setPwdFreeDegrade(boolean r100) {
        this.isPwdFreeDegrade = r100;
    }

    public final void setShowDegradeInfo(boolean r100) {
        this.showDegradeInfo = r100;
    }

    public final void setThemeParams(VerifyThemeParams r100) {
        this.themeParams = r100;
    }

    public final void setVerifyTokenPayParams(VerifyTokenPayParams r100) {
        this.verifyTokenPayParams = r100;
    }
}
