package com.android.ttcjpaysdk.kmp.common.ui;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007J\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007J\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007J\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J+\u0010\u0011\u001a\u00020\u00052\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001f\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J+\u0010\u001c\u001a\u00020\u00052\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J+\u0010\u001d\u001a\u00020\u00052\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0018J\u0017\u0010\u001e\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u001fJ#\u0010\u001e\u001a\u00020\u00052\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010 J\u001a\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0007J\u0016\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007J\u000e\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0007J\u0006\u0010,\u001a\u00020\u0013J\u0006\u0010-\u001a\u00020\u0013¨\u0006."}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/ui/CJHostUi;", "", "<init>", "()V", "showToast", "", "text", "", "options", "Lcom/android/ttcjpaysdk/kmp/common/ui/CJToastOptions;", "showErrorIconToast", "title", "subTitle", "showSuccessIconToast", "showCustomIconToast", "srcUrl", "showPendingIconToast", "showPayLoading", "timeout", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "platformContext", "Landroid/content/Context;", "Lcom/android/ttcjpaysdk/kmp/base/context/CJPlatformContext;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)V", "hideLoading", "updateLoading", "showCircleLoading", "showCircleLoadingWithContext", "showHostLoading", "showSimpleHostLoading", "(Ljava/lang/Integer;)V", "(Landroid/content/Context;Ljava/lang/Integer;)V", "showHostDialog", "Lcom/android/ttcjpaysdk/kmp/common/ui/CJDialogOptions;", "callback", "Lcom/android/ttcjpaysdk/kmp/common/ui/IKmpCJComposeDialogPageEventCallback;", "dismissHostDialog", "dialogID", "showOverlay", "name", "params", "dismissOverlay", "overlayId", "getNavigationBarHeight", "getScreenHeight", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJHostUi {
    public static final int $stable = 0;
    public static final CJHostUi INSTANCE = null;

    static {
        INSTANCE = new CJHostUi();
    }

    private CJHostUi() {
    }

    public final int getNavigationBarHeight() {
        pd6.b r100 = pd6.c.f528682a;
        IKmpCJHostUIService r101 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getNavigationBarHeight();
    }

    public final int getScreenHeight() {
        pd6.b r100 = pd6.c.f528682a;
        IKmpCJHostUIService r101 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getScreenHeight();
    }

    public final void hideLoading() {
        pd6.b r100 = pd6.c.f528682a;
        IKmpCJHostUIService r101 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r101 == null) goto L6;
        r101.hideLoading();
        return;
    }

    public final void dismissHostDialog(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dialogID");
        pd6.b r101 = pd6.c.f528682a;
        IKmpCJHostUIService r102 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r102 == null) goto L6;
        r102.dismissHostDialog(r100);
        return;
    }

    public final void dismissOverlay(String r100) {
        Intrinsics.checkNotNullParameter(r100, "overlayId");
        pd6.b r101 = pd6.c.f528682a;
        IKmpCJHostUIService r102 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r102 == null) goto L6;
        r102.dismissOverlay(r100);
        return;
    }

    public final void showSimpleHostLoading(Integer r100) {
        pd6.b r101 = pd6.c.f528682a;
        IKmpCJHostUIService r102 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r102 == null) goto L6;
        r102.showSimpleHostLoading(r100);
        return;
    }

    public final void showToast(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        pd6.b r101 = pd6.c.f528682a;
        IKmpCJHostUIService r102 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r102 == null) goto L6;
        r102.showToast(r100, new CJToastOptions(0, null, 3, null));
        return;
    }

    public final void updateLoading(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        CJLoadingState.INSTANCE.setLoadingText(r100);
    }

    public final void showCircleLoading(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        pd6.b r102 = pd6.c.f528682a;
        IKmpCJHostUIService r103 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r103 == null) goto L6;
        r103.showCircleLoading(r100, r101);
        return;
    }

    public final void showErrorIconToast(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "subTitle");
        pd6.b r102 = pd6.c.f528682a;
        IKmpCJHostUIService r103 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r103 == null) goto L6;
        r103.showErrorIconToast(r100, r101);
        return;
    }

    public final String showHostDialog(CJDialogOptions r100, IKmpCJComposeDialogPageEventCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "options");
        pd6.b r102 = pd6.c.f528682a;
        IKmpCJHostUIService r103 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r103 == null) goto L6;
        String r104 = r103.showHostDialog(r100, r101);
        if (r104 == null) goto L6;
        return r104;
    L6:
        return "";
    }

    public final void showHostLoading(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        pd6.b r102 = pd6.c.f528682a;
        IKmpCJHostUIService r103 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r103 == null) goto L6;
        r103.showHostLoading(r100, r101);
        return;
    }

    public final String showOverlay(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        pd6.b r102 = pd6.c.f528682a;
        IKmpCJHostUIService r103 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r103 == null) goto L6;
        String r104 = r103.showOverlay(r100, r101);
        if (r104 == null) goto L6;
        return r104;
    L6:
        return "";
    }

    public final void showPayLoading(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        pd6.b r102 = pd6.c.f528682a;
        IKmpCJHostUIService r103 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r103 == null) goto L6;
        r103.showPayLoading(r100, r101);
        return;
    }

    public final void showPendingIconToast(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "subTitle");
        pd6.b r102 = pd6.c.f528682a;
        IKmpCJHostUIService r103 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r103 == null) goto L6;
        r103.showPendingIconToast(r100, r101);
        return;
    }

    public final void showSimpleHostLoading(Context r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "platformContext");
        pd6.b r102 = pd6.c.f528682a;
        IKmpCJHostUIService r103 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r103 == null) goto L6;
        r103.showSimpleHostLoadingWithContext(r100, r101);
        return;
    }

    public final void showSuccessIconToast(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "subTitle");
        pd6.b r102 = pd6.c.f528682a;
        IKmpCJHostUIService r103 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r103 == null) goto L6;
        r103.showSuccessIconToast(r100, r101);
        return;
    }

    public final void showToast(String r100, CJToastOptions r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "options");
        pd6.b r102 = pd6.c.f528682a;
        IKmpCJHostUIService r103 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r103 == null) goto L6;
        r103.showToast(r100, r101);
        return;
    }

    public final void showCircleLoadingWithContext(Context r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "platformContext");
        Intrinsics.checkNotNullParameter(r101, "text");
        pd6.b r103 = pd6.c.f528682a;
        IKmpCJHostUIService r104 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r104 == null) goto L6;
        r104.showCircleLoadingWithContext(r100, r101, r102);
        return;
    }

    public final void showCustomIconToast(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "srcUrl");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "subTitle");
        pd6.b r103 = pd6.c.f528682a;
        IKmpCJHostUIService r104 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r104 == null) goto L6;
        r104.showCustomIconToast(r100, r101, r102);
        return;
    }

    public final void showHostLoading(Context r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "platformContext");
        Intrinsics.checkNotNullParameter(r101, "text");
        pd6.b r103 = pd6.c.f528682a;
        IKmpCJHostUIService r104 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r104 == null) goto L6;
        r104.showHostLoadingWithContext(r100, r101, r102);
        return;
    }

    public final void showPayLoading(Context r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "platformContext");
        Intrinsics.checkNotNullParameter(r101, "text");
        pd6.b r103 = pd6.c.f528682a;
        IKmpCJHostUIService r104 = (IKmpCJHostUIService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJHostUIService.class));
        if (r104 == null) goto L6;
        r104.showPayLoadingWithContext(r100, r101, r102);
        return;
    }

    public static /* synthetic */ void showSimpleHostLoading$default(CJHostUi r100, Integer r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.showSimpleHostLoading(r101);
    }

    public static /* synthetic */ void showCircleLoading$default(CJHostUi r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.showCircleLoading(r101, r102);
    }

    public static /* synthetic */ String showHostDialog$default(CJHostUi r100, CJDialogOptions r101, IKmpCJComposeDialogPageEventCallback r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.showHostDialog(r101, r102);
    }

    public static /* synthetic */ void showHostLoading$default(CJHostUi r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.showHostLoading(r101, r102);
    }

    public static /* synthetic */ void showPayLoading$default(CJHostUi r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.showPayLoading(r101, r102);
    }

    public static /* synthetic */ void showSimpleHostLoading$default(CJHostUi r100, Context r101, Integer r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.showSimpleHostLoading(r101, r102);
    }

    public static /* synthetic */ void showCircleLoadingWithContext$default(CJHostUi r100, Context r101, String r102, Integer r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.showCircleLoadingWithContext(r101, r102, r103);
    }

    public static /* synthetic */ void showHostLoading$default(CJHostUi r100, Context r101, String r102, Integer r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.showHostLoading(r101, r102, r103);
    }

    public static /* synthetic */ void showPayLoading$default(CJHostUi r100, Context r101, String r102, Integer r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.showPayLoading(r101, r102, r103);
    }
}
