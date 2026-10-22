package com.android.ttcjpaysdk.kmp.common.ui;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J!\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0012J-\u0010\u0013\u001a\u00020\u00032\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u00162\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0003H&J!\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0012J-\u0010\u001a\u001a\u00020\u00032\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u00162\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0017J!\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0012J-\u0010\u001c\u001a\u00020\u00032\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u00162\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0017J\u0019\u0010\u001d\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u001eJ%\u0010\u001f\u001a\u00020\u00032\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u00162\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\"\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0005H&J\u0018\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0016J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0011H&J\b\u0010.\u001a\u00020\u0011H&¨\u0006/"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/ui/IKmpCJHostUIService;", "Lcom/bytedance/kmp/spi/IKmpService;", "showToast", "", "text", "", "options", "Lcom/android/ttcjpaysdk/kmp/common/ui/CJToastOptions;", "showErrorIconToast", "title", "subTitle", "showSuccessIconToast", "showCustomIconToast", "srcUrl", "showPendingIconToast", "showPayLoading", "timeout", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "showPayLoadingWithContext", "platformContext", "Landroid/content/Context;", "Lcom/android/ttcjpaysdk/kmp/base/context/CJPlatformContext;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)V", "hideLoading", "showCircleLoading", "showCircleLoadingWithContext", "showHostLoading", "showHostLoadingWithContext", "showSimpleHostLoading", "(Ljava/lang/Integer;)V", "showSimpleHostLoadingWithContext", "(Landroid/content/Context;Ljava/lang/Integer;)V", "updateLoading", "showHostDialog", "Lcom/android/ttcjpaysdk/kmp/common/ui/CJDialogOptions;", "callback", "Lcom/android/ttcjpaysdk/kmp/common/ui/IKmpCJComposeDialogPageEventCallback;", "dismissHostDialog", "dialogID", "showOverlay", "name", "params", "dismissOverlay", "overlayId", "getNavigationBarHeight", "getScreenHeight", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJHostUIService extends pd6.a {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void dismissOverlay(IKmpCJHostUIService r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "overlayId");
        }

        public static String showOverlay(IKmpCJHostUIService r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "params");
            return "";
        }

        public static /* synthetic */ void showSimpleHostLoading$default(IKmpCJHostUIService r100, Integer r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            r100.showSimpleHostLoading(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSimpleHostLoading");
        }

        public static /* synthetic */ void showCircleLoading$default(IKmpCJHostUIService r100, String r101, Integer r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.showCircleLoading(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCircleLoading");
        }

        public static /* synthetic */ String showHostDialog$default(IKmpCJHostUIService r100, CJDialogOptions r101, IKmpCJComposeDialogPageEventCallback r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.showHostDialog(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showHostDialog");
        }

        public static /* synthetic */ void showHostLoading$default(IKmpCJHostUIService r100, String r101, Integer r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.showHostLoading(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showHostLoading");
        }

        public static /* synthetic */ void showPayLoading$default(IKmpCJHostUIService r100, String r101, Integer r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.showPayLoading(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPayLoading");
        }

        public static /* synthetic */ void showSimpleHostLoadingWithContext$default(IKmpCJHostUIService r100, Context r101, Integer r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.showSimpleHostLoadingWithContext(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSimpleHostLoadingWithContext");
        }

        public static /* synthetic */ void showCircleLoadingWithContext$default(IKmpCJHostUIService r100, Context r101, String r102, Integer r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.showCircleLoadingWithContext(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCircleLoadingWithContext");
        }

        public static /* synthetic */ void showHostLoadingWithContext$default(IKmpCJHostUIService r100, Context r101, String r102, Integer r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.showHostLoadingWithContext(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showHostLoadingWithContext");
        }

        public static /* synthetic */ void showPayLoadingWithContext$default(IKmpCJHostUIService r100, Context r101, String r102, Integer r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.showPayLoadingWithContext(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPayLoadingWithContext");
        }
    }

    void dismissHostDialog(String r100);

    void dismissOverlay(String r100);

    int getNavigationBarHeight();

    int getScreenHeight();

    void hideLoading();

    void showCircleLoading(String r100, Integer r101);

    void showCircleLoadingWithContext(Context r100, String r101, Integer r102);

    void showCustomIconToast(String r100, String r101, String r102);

    void showErrorIconToast(String r100, String r101);

    String showHostDialog(CJDialogOptions r100, IKmpCJComposeDialogPageEventCallback r101);

    void showHostLoading(String r100, Integer r101);

    void showHostLoadingWithContext(Context r100, String r101, Integer r102);

    String showOverlay(String r100, String r101);

    void showPayLoading(String r100, Integer r101);

    void showPayLoadingWithContext(Context r100, String r101, Integer r102);

    void showPendingIconToast(String r100, String r101);

    void showSimpleHostLoading(Integer r100);

    void showSimpleHostLoadingWithContext(Context r100, Integer r101);

    void showSuccessIconToast(String r100, String r101);

    void showToast(String r100, CJToastOptions r101);

    void updateLoading(String r100);
}
