package com.android.ttcjpaysdk.facelive.anniexextension;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayDialogBuilder;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayDialogUtils;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.ContainerContext;
import com.bytedance.caijing.sdk.infra.base.task.b;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.chameleon.WebMediaPermissionResources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0003J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\u001a\u0010\u0017\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/anniexextension/FaceCheckWebChromeClient;", "Landroid/webkit/WebChromeClient;", "containerContext", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;", "(Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;)V", "getContainerContext", "()Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;", "mPermissionDialog", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayCommonDialog;", "buildPermissionDialog", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayDialogBuilder;", "activity", "Landroid/app/Activity;", "title", "", "request", "Landroid/webkit/PermissionRequest;", "dismissPermissionDialog", "", "handleVideoCapturePermission", "requestUri", "Landroid/net/Uri;", "onPermissionRequest", "showPermissionDialog", "builder", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FaceCheckWebChromeClient extends WebChromeClient {
    private final ContainerContext containerContext;
    private CJPayCommonDialog mPermissionDialog;

    private final void dismissPermissionDialog() {
        CJPayCommonDialog r100 = this.mPermissionDialog;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.isShowing());
    L6:
        if (r101 == null) goto L8;
        boolean r102 = r101.booleanValue();
    L9:
        if (r102 == false) goto L14;
        CJPayCommonDialog r103 = this.mPermissionDialog;
        if (r103 == null) goto L15;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_facelive_anniexextension_FaceCheckWebChromeClient_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r103);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r102 = false;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    public final ContainerContext getContainerContext() {
        return this.containerContext;
    }

    public FaceCheckWebChromeClient(ContainerContext r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        this.containerContext = r100;
    }

    public static void INVOKEVIRTUAL_com_android_ttcjpaysdk_facelive_anniexextension_FaceCheckWebChromeClient_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(CJPayCommonDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKEVIRTUAL_com_android_ttcjpaysdk_facelive_anniexextension_FaceCheckWebChromeClient_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(CJPayCommonDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static final /* synthetic */ void access$dismissPermissionDialog(FaceCheckWebChromeClient r100) {
        r100.dismissPermissionDialog();
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(final PermissionRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        final Uri r101 = r100.getOrigin();
        if (TextUtils.equals("https://api.megvii.com/", r101.toString()) == true) goto L12;
        String r102 = r101.getHost();
        boolean r103 = false;
        Boolean r104 = null;
        if (r102 == null) goto L7;
        r104 = Boolean.valueOf(StringsKt.endsWith$default(r102, ".snssdk.com", false, 2, null));
    L7:
        if (r104 == null) goto L9;
        r103 = r104.booleanValue();
    L9:
        if (r103 == true) goto L12;
        super.onPermissionRequest(r100);
        return;
    L12:
        Handler r105 = b.f202770a;
        Runnable r106 = new RunnableC91571(this, r100, r101);
        Intrinsics.checkNotNullParameter(r106, "<this>");
        b.i(r106);
    }

    private final void handleVideoCapturePermission(PermissionRequest r110, Uri r111) {
        Activity r100 = this.containerContext.getActivity();
        boolean r101 = false;
        if (r100 == null) goto L13;
        String[] r102 = r110.getResources();
        int r103 = r102.length;
        int r104 = 0;
        boolean r105 = false;
    L5:
        if (r104 >= r103) goto L12;
        if (Intrinsics.areEqual(WebMediaPermissionResources.VIDEO_CAPTURE, r102[r104]) == false) goto L11;
        CJPayDialogBuilder r106 = buildPermissionDialog(r100, r100.getString(R.string.cj_pay_ask_permission_video_capture, new Object[]{r111.toString()}), r110);
        if (r106 == null) goto L11;
        showPermissionDialog(r100, r106);
        r105 = true;
    L11:
        r104 = r104 + 1;
        goto L5
    L12:
        r101 = r105;
    L13:
        if (r101 == true) goto L20;
        super.onPermissionRequest(r110);
        return;
    }

    private final void showPermissionDialog(Activity r100, CJPayDialogBuilder r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isFinishing() == true) goto L21;
        CJPayCommonDialog r102 = this.mPermissionDialog;
        if (r102 == null) goto L8;
        Boolean r103 = Boolean.valueOf(r102.isShowing());
    L9:
        if (r103 == null) goto L11;
        boolean r104 = r103.booleanValue();
    L12:
        if (r104 == false) goto L16;
        CJPayCommonDialog r105 = this.mPermissionDialog;
        if (r105 == null) goto L16;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_facelive_anniexextension_FaceCheckWebChromeClient_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r105);
    L16:
        CJPayCommonDialog r106 = CJPayDialogUtils.initDialog(r101);
        this.mPermissionDialog = r106;
        if (r106 == null) goto L22;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_facelive_anniexextension_FaceCheckWebChromeClient_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r106);
        return;
    L22:
        return;
    L11:
        r104 = false;
        goto L12
    L8:
        r103 = null;
        goto L9
    }

    public static final /* synthetic */ void access$handleVideoCapturePermission(FaceCheckWebChromeClient r100, PermissionRequest r101, Uri r102) {
        r100.handleVideoCapturePermission(r101, r102);
    }

    private final CJPayDialogBuilder buildPermissionDialog(Activity r100, String r101, final PermissionRequest r102) {
        return CJPayDialogUtils.getDefaultBuilder(r100).setTitle(r101).setLeftBtnStr(r100.getString(R.string.cj_pay_deny)).setRightBtnStr(r100.getString(R.string.cj_pay_allow)).setLeftBtnListener(new AnonymousClass1(this)).setRightBtnListener(new AnonymousClass2(this, r102));
    }
}
