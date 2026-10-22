package com.android.ttcjpaysdk.kmp.common.lynx;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0017J \u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0017¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/lynx/IKmpCJLynxDialogLifecycle;", "", "onPageShow", "", "onPageDismiss", "onCloseCallback", "code", "", "data", "", "msg", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJLynxDialogLifecycle {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onCloseCallback(IKmpCJLynxDialogLifecycle r100, int r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r102, "data");
            Intrinsics.checkNotNullParameter(r103, "msg");
        }

        public static void onPageDismiss(IKmpCJLynxDialogLifecycle r100) {
        }

        public static void onPageShow(IKmpCJLynxDialogLifecycle r100) {
        }
    }

    void onCloseCallback(int r100, String r101, String r102);

    void onPageDismiss();

    void onPageShow();
}
