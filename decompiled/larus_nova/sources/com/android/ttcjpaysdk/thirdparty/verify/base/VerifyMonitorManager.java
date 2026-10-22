package com.android.ttcjpaysdk.thirdparty.verify.base;

import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyCommonParams;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/base/VerifyMonitorManager;", "", "()V", "isFirstShow", "", "onFirstPageShowListener", "Lcom/android/ttcjpaysdk/thirdparty/verify/base/VerifyMonitorManager$OnFirstPageShowListener;", "getOnFirstPageShowListener", "()Lcom/android/ttcjpaysdk/thirdparty/verify/base/VerifyMonitorManager$OnFirstPageShowListener;", "setOnFirstPageShowListener", "(Lcom/android/ttcjpaysdk/thirdparty/verify/base/VerifyMonitorManager$OnFirstPageShowListener;)V", "vmContext", "Lcom/android/ttcjpaysdk/thirdparty/verify/base/VerifyVMContext;", "getVmContext", "()Lcom/android/ttcjpaysdk/thirdparty/verify/base/VerifyVMContext;", "setVmContext", "(Lcom/android/ttcjpaysdk/thirdparty/verify/base/VerifyVMContext;)V", "doFirstPageShow", "", "checkType", "", "OnFirstPageShowListener", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyMonitorManager {
    private boolean isFirstShow;
    private OnFirstPageShowListener onFirstPageShowListener;
    private VerifyVMContext vmContext;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/base/VerifyMonitorManager$OnFirstPageShowListener;", "", SendEventContainerMethodParamModel.EventKinds.onShow, "", "checkType", "", "processType", "", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnFirstPageShowListener {
        void onShow(String r100, int r101);
    }

    public VerifyMonitorManager() {
        this.isFirstShow = true;
    }

    public final OnFirstPageShowListener getOnFirstPageShowListener() {
        return this.onFirstPageShowListener;
    }

    public final VerifyVMContext getVmContext() {
        return this.vmContext;
    }

    public final void doFirstPageShow(String r100) {
        Intrinsics.checkNotNullParameter(r100, "checkType");
        if (this.isFirstShow == false) goto L15;
        OnFirstPageShowListener r101 = this.onFirstPageShowListener;
        if (r101 == null) goto L15;
        VerifyVMContext r102 = this.vmContext;
        if (r102 == null) goto L13;
        VerifyCommonParams r103 = r102.getVerifyParams();
        if (r103 == null) goto L13;
        int r104 = 1;
        if (r103.mIsFastPay != true) goto L13;
    L14:
        r101.onShow(r100, r104);
    L13:
        r104 = 0;
    L15:
        this.isFirstShow = false;
    }

    public final void setOnFirstPageShowListener(OnFirstPageShowListener r100) {
        this.onFirstPageShowListener = r100;
    }

    public final void setVmContext(VerifyVMContext r100) {
        this.vmContext = r100;
    }
}
