package com.android.ttcjpaysdk.kmp.common.view.lynx;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0017J\b\u0010\u0005\u001a\u00020\u0003H\u0017J\b\u0010\u0006\u001a\u00020\u0003H\u0017J\b\u0010\u0007\u001a\u00020\u0003H\u0017J\b\u0010\b\u001a\u00020\u0003H\u0017J\b\u0010\t\u001a\u00020\u0003H\u0017J\b\u0010\n\u001a\u00020\u0003H\u0017J\b\u0010\u000b\u001a\u00020\u0003H\u0017J\b\u0010\f\u001a\u00020\u0003H\u0017J\b\u0010\r\u001a\u00020\u0003H\u0017¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/lynx/IKmpCJLynxCardLifecycle;", "", "onPageShow", "", "onPageStarted", "onPageDismiss", "onLoadSuccess", "onFirstScreen", "onPageUpdate", "onDataUpdated", "onRuntimeReady", "onReceivedError", "onUpdateDataWithoutChange", LiveCommonConstants.REASON_ON_DEDTROY, "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJLynxCardLifecycle {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onDataUpdated(IKmpCJLynxCardLifecycle r100) {
        }

        public static void onDestroy(IKmpCJLynxCardLifecycle r100) {
        }

        public static void onFirstScreen(IKmpCJLynxCardLifecycle r100) {
        }

        public static void onLoadSuccess(IKmpCJLynxCardLifecycle r100) {
        }

        public static void onPageDismiss(IKmpCJLynxCardLifecycle r100) {
        }

        public static void onPageShow(IKmpCJLynxCardLifecycle r100) {
        }

        public static void onPageStarted(IKmpCJLynxCardLifecycle r100) {
        }

        public static void onPageUpdate(IKmpCJLynxCardLifecycle r100) {
        }

        public static void onReceivedError(IKmpCJLynxCardLifecycle r100) {
        }

        public static void onRuntimeReady(IKmpCJLynxCardLifecycle r100) {
        }

        public static void onUpdateDataWithoutChange(IKmpCJLynxCardLifecycle r100) {
        }
    }

    void onDataUpdated();

    void onDestroy();

    void onFirstScreen();

    void onLoadSuccess();

    void onPageDismiss();

    void onPageShow();

    void onPageStarted();

    void onPageUpdate();

    void onReceivedError();

    void onRuntimeReady();

    void onUpdateDataWithoutChange();
}
