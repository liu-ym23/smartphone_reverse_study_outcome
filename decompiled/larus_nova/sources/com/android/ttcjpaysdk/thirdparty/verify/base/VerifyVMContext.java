package com.android.ttcjpaysdk.thirdparty.verify.base;

import android.content.Context;
import com.android.ttcjpaysdk.base.eventbus.EventManager;
import com.android.ttcjpaysdk.base.service.ICJPayPaymentMethodService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.thirdparty.verify.constants.event.BankCardPointChangeEvent;
import com.android.ttcjpaysdk.thirdparty.verify.mode.VerifyMode;
import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyCommonParams;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyAddPwdVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyCardSignVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyFaceVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyFingerprintVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyInputPhoneVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyMemberVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyNothingVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyOneStepPaymentVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyPasswordVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifySmsVM;
import com.android.ttcjpaysdk.thirdparty.verify.vm.VerifyUploadIDCardVM;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class VerifyVMContext {
    private Map<String, AssetPayState> assetPayStateMap;
    public Context mContext;
    public VerifyBaseManager mManage;
    public VerifyMode mMode;
    public VerifyMonitorManager mMonitorManager;
    public VerifyStackManager mStack;
    public ICJPayPaymentMethodService paymentService;
    public Map<String, String> shareParams;
    public Map<String, Object> verifyProcessParams;

    public static class AssetPayState {
        public boolean bankCardPointSwitch;
        public String promotionScene;

        public AssetPayState() {
            this.bankCardPointSwitch = false;
            this.promotionScene = "";
        }
    }

    public static class Builder {
        private Context mContext;
        private VerifyMode mMode;
        private VerifyMonitorManager mMonitorManager;
        private VerifyStackManager mStackManage;
        private VerifyBaseManager mVerifyManage;

        public VerifyVMContext create() {
            return new VerifyVMContext(this);
        }

        public Builder() {
        }

        public static /* synthetic */ VerifyStackManager access$000(Builder r100) {
            return r100.mStackManage;
        }

        public static /* synthetic */ VerifyBaseManager access$100(Builder r100) {
            return r100.mVerifyManage;
        }

        public static /* synthetic */ VerifyMode access$200(Builder r100) {
            return r100.mMode;
        }

        public static /* synthetic */ Context access$300(Builder r100) {
            return r100.mContext;
        }

        public static /* synthetic */ VerifyMonitorManager access$400(Builder r100) {
            return r100.mMonitorManager;
        }

        public Builder setContext(Context r100) {
            this.mContext = r100;
            return this;
        }

        public Builder setMode(VerifyMode r100) {
            this.mMode = r100;
            return this;
        }

        public Builder setMonitorManager(VerifyMonitorManager r100) {
            this.mMonitorManager = r100;
            return this;
        }

        public Builder setStackManage(VerifyStackManager r100) {
            this.mStackManage = r100;
            return this;
        }

        public Builder setVerifyManage(VerifyBaseManager r100) {
            this.mVerifyManage = r100;
            return this;
        }
    }

    public String getCheckName() {
        VerifyBaseManager r100 = this.mManage;
        if (r100 != null) goto L5;
        return "无";
    L5:
        return r100.getCheckName();
    }

    public int getContainerId() {
        VerifyStackManager r100 = this.mStack;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getContainerId();
    }

    public VerifyInputPhoneVM getInputPhoneVM() {
        Iterator<VerifyBaseVM> r100 = this.mManage.getVMS().iterator();     // Catch: Exception -> L9
    L4:
        if (r100.hasNext() == false) goto L18;
        VerifyBaseVM r101 = r100.next();     // Catch: Exception -> L9
        if ((r101 instanceof VerifyInputPhoneVM) == false) goto L4;
        return (VerifyInputPhoneVM) r101;
    L18:
        return null;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyVMContext#return", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyVMContext#return", e);
        return null;
    }

    public VerifyPasswordVM getPwdVM() {
        Iterator<VerifyBaseVM> r100 = this.mManage.getVMS().iterator();     // Catch: Exception -> L9
    L4:
        if (r100.hasNext() == false) goto L18;
        VerifyBaseVM r101 = r100.next();     // Catch: Exception -> L9
        if ((r101 instanceof VerifyPasswordVM) == false) goto L4;
        return (VerifyPasswordVM) r101;
    L18:
        return null;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyVMContext#return", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyVMContext#return", e);
        return null;
    }

    public VerifySmsVM getSmsVM() {
        Iterator<VerifyBaseVM> r100 = this.mManage.getVMS().iterator();     // Catch: Exception -> L9
    L4:
        if (r100.hasNext() == false) goto L18;
        VerifyBaseVM r101 = r100.next();     // Catch: Exception -> L9
        if ((r101 instanceof VerifySmsVM) == false) goto L4;
        return (VerifySmsVM) r101;
    L18:
        return null;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyVMContext#return", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyVMContext#return", e);
        return null;
    }

    public VerifyUploadIDCardVM getUploadIDCardVM() {
        Iterator<VerifyBaseVM> r100 = this.mManage.getVMS().iterator();     // Catch: Exception -> L9
    L4:
        if (r100.hasNext() == false) goto L18;
        VerifyBaseVM r101 = r100.next();     // Catch: Exception -> L9
        if ((r101 instanceof VerifyUploadIDCardVM) == false) goto L4;
        return (VerifyUploadIDCardVM) r101;
    L18:
        return null;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyVMContext#return", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyVMContext#return", e);
        return null;
    }

    public VerifyAddPwdVM getVerifyAddPwdVM() {
        Iterator<VerifyBaseVM> r100 = this.mManage.getVMS().iterator();     // Catch: Exception -> L9
    L4:
        if (r100.hasNext() == false) goto L18;
        VerifyBaseVM r101 = r100.next();     // Catch: Exception -> L9
        if ((r101 instanceof VerifyAddPwdVM) == false) goto L4;
        return (VerifyAddPwdVM) r101;
    L18:
        return null;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyVMContext#return", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyVMContext#return", e);
        return null;
    }

    public VerifyCardSignVM getVerifyCardSignVM() {
        Iterator<VerifyBaseVM> r100 = this.mManage.getVMS().iterator();     // Catch: Exception -> L9
    L4:
        if (r100.hasNext() == false) goto L18;
        VerifyBaseVM r101 = r100.next();     // Catch: Exception -> L9
        if ((r101 instanceof VerifyCardSignVM) == false) goto L4;
        return (VerifyCardSignVM) r101;
    L18:
        return null;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyVMContext#return", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyVMContext#return", e);
        return null;
    }

    public VerifyFaceVM getVerifyFaceVM() {
        Iterator<VerifyBaseVM> r100 = this.mManage.getVMS().iterator();     // Catch: Exception -> L9
    L4:
        if (r100.hasNext() == false) goto L18;
        VerifyBaseVM r101 = r100.next();     // Catch: Exception -> L9
        if ((r101 instanceof VerifyFaceVM) == false) goto L4;
        return (VerifyFaceVM) r101;
    L18:
        return null;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyVMContext#return", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyVMContext#return", e);
        return null;
    }

    public VerifyFingerprintVM getVerifyFingerPrintVM() {
        Iterator<VerifyBaseVM> r100 = this.mManage.getVMS().iterator();     // Catch: Exception -> L9
    L4:
        if (r100.hasNext() == false) goto L18;
        VerifyBaseVM r101 = r100.next();     // Catch: Exception -> L9
        if ((r101 instanceof VerifyFingerprintVM) == false) goto L4;
        return (VerifyFingerprintVM) r101;
    L18:
        return null;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyVMContext#return", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyVMContext#return", e);
        return null;
    }

    public VerifyMemberVM getVerifyMemberVM() {
        Iterator<VerifyBaseVM> r100 = this.mManage.getVMS().iterator();     // Catch: Exception -> L9
    L4:
        if (r100.hasNext() == false) goto L18;
        VerifyBaseVM r101 = r100.next();     // Catch: Exception -> L9
        if ((r101 instanceof VerifyMemberVM) == false) goto L4;
        return (VerifyMemberVM) r101;
    L18:
        return null;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyVMContext#return", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyVMContext#return", e);
        return null;
    }

    public VerifyNothingVM getVerifyNothingVM() {
        Iterator<VerifyBaseVM> r100 = this.mManage.getVMS().iterator();     // Catch: Exception -> L9
    L4:
        if (r100.hasNext() == false) goto L18;
        VerifyBaseVM r101 = r100.next();     // Catch: Exception -> L9
        if ((r101 instanceof VerifyNothingVM) == false) goto L4;
        return (VerifyNothingVM) r101;
    L18:
        return null;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyVMContext#return", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyVMContext#return", e);
        return null;
    }

    public VerifyOneStepPaymentVM getVerifyOneStepPaymentVM() {
        Iterator<VerifyBaseVM> r100 = this.mManage.getVMS().iterator();     // Catch: Exception -> L9
    L4:
        if (r100.hasNext() == false) goto L18;
        VerifyBaseVM r101 = r100.next();     // Catch: Exception -> L9
        if ((r101 instanceof VerifyOneStepPaymentVM) == false) goto L4;
        return (VerifyOneStepPaymentVM) r101;
    L18:
        return null;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("VerifyVMContext#return", e);
        CJBasicCommonUtils.logCatch("CJCatch", "VerifyVMContext#return", e);
        return null;
    }

    public VerifyCommonParams getVerifyParams() {
        return this.mManage.getVerifyParams();
    }

    public boolean isHasViewPageVM() {
        VerifyStackManager r100 = this.mStack;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.size() <= 0) goto L10;
        return true;
    L10:
        return false;
    }

    public void releasePaymentService() {
        ICJPayPaymentMethodService r100 = this.paymentService;
        if (r100 == null) goto L6;
        r100.release();
        this.paymentService = null;
        return;
    }

    public VerifyVMContext(Builder r100) {
        this.shareParams = new HashMap();
        this.verifyProcessParams = new HashMap();
        this.assetPayStateMap = new HashMap();
        this.paymentService = null;
        this.mStack = Builder.access$000(r100);
        this.mManage = Builder.access$100(r100);
        this.mMode = Builder.access$200(r100);
        this.mContext = Builder.access$300(r100);
        this.mMonitorManager = Builder.access$400(r100);
    }

    public String getBankCardPointKey(String r100) {
        if (this.assetPayStateMap.containsKey(r100) == true) goto L5;
        return "";
    L5:
        return this.assetPayStateMap.get(r100).promotionScene;
    }

    public boolean getBankCardPointSwitch(String r100) {
        if (this.assetPayStateMap.containsKey(r100) == true) goto L5;
        return false;
    L5:
        return this.assetPayStateMap.get(r100).bankCardPointSwitch;
    }

    public boolean hasBankCardPointState(String r100) {
        if (this.assetPayStateMap.containsKey(r100) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public void setCheckName(String r100) {
        VerifyBaseManager r101 = this.mManage;
        if (r101 == null) goto L6;
        r101.setCheckName(r100);
        return;
    }

    public void setShowStyle(String r100) {
        VerifyBaseManager r101 = this.mManage;
        if (r101 == null) goto L6;
        r101.setShowStyle(r100);
        return;
    }

    public void finishFragment(VerifyBaseFragment r100, boolean r101) {
        this.mStack.finish(r100, r101);
    }

    public void setBankCardPointSwitch(String r100, boolean r101, String r102) {
        if (this.assetPayStateMap.containsKey(r100) == true) goto L5;
        AssetPayState r103 = new AssetPayState();
        r103.bankCardPointSwitch = r101;
        r103.promotionScene = r102;
        this.assetPayStateMap.put(r100, r103);
        EventManager.INSTANCE.notify(new BankCardPointChangeEvent(r101, r100));
        return;
    L5:
        if (this.assetPayStateMap.get(r100).bankCardPointSwitch == r101) goto L9;
        this.assetPayStateMap.get(r100).bankCardPointSwitch = r101;
        this.assetPayStateMap.get(r100).promotionScene = r102;
        EventManager.INSTANCE.notify(new BankCardPointChangeEvent(r101, r100));
        return;
    }

    public void startFragment(VerifyBaseFragment r100, boolean r101, int r102, int r110, boolean r111) {
        this.mStack.startFragment(r100, r101, r102, r110, r111);
    }

    public void startFragment(VerifyBaseFragment r100, boolean r101, int r110, int r111, boolean r112, int r113) {
        this.mStack.startFragment(r100, r101, r110, r111, r112, r113);
    }
}
