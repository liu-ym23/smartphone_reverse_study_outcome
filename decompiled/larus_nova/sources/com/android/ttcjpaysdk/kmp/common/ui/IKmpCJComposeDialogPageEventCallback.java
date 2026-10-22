package com.android.ttcjpaysdk.kmp.common.ui;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0017¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/ui/IKmpCJComposeDialogPageEventCallback;", "", "onPageShow", "", "onPageDismiss", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJComposeDialogPageEventCallback {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onPageDismiss(IKmpCJComposeDialogPageEventCallback r100) {
        }

        public static void onPageShow(IKmpCJComposeDialogPageEventCallback r100) {
        }
    }

    void onPageDismiss();

    void onPageShow();
}
