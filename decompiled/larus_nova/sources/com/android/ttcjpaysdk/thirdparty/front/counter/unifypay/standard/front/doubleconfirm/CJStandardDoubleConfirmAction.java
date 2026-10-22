package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.front.doubleconfirm;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0014\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0016¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/front/doubleconfirm/CJStandardDoubleConfirmAction;", "", "onBioFinger", "", "callbackData", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/front/doubleconfirm/CJStandardDoubleConfirmCallbackData;", "onChangePayMethod", "isCombine", "", "onClose", "onNoPwd", "onSetPwd", "setPwdUrl", "", "onUnknownAction", "action", "onUseCarrier", "onUseFace", "onUsePassword", "onUseSms", "tryCloseWithRetainPlatform", "onNoDialogShown", "Lkotlin/Function0;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJStandardDoubleConfirmAction {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean tryCloseWithRetainPlatform(CJStandardDoubleConfirmAction r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r101, "onNoDialogShown");
            return false;
        }
    }

    void onBioFinger(CJStandardDoubleConfirmCallbackData r100);

    void onChangePayMethod(CJStandardDoubleConfirmCallbackData r100, boolean r101);

    void onClose(CJStandardDoubleConfirmCallbackData r100);

    void onNoPwd(CJStandardDoubleConfirmCallbackData r100);

    void onSetPwd(CJStandardDoubleConfirmCallbackData r100, String r101);

    void onUnknownAction(CJStandardDoubleConfirmCallbackData r100, String r101);

    void onUseCarrier(CJStandardDoubleConfirmCallbackData r100);

    void onUseFace(CJStandardDoubleConfirmCallbackData r100);

    void onUsePassword(CJStandardDoubleConfirmCallbackData r100);

    void onUseSms(CJStandardDoubleConfirmCallbackData r100);

    boolean tryCloseWithRetainPlatform(Function0<Unit> r100);
}
