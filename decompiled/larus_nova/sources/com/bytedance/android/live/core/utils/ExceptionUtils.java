package com.bytedance.android.live.core.utils;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.uikit.dialog.AlertDialog;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: classes45.dex */
public class ExceptionUtils {
    private ExceptionUtils() {
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_core_utils_ExceptionUtils_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AlertDialog r100) {
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

    public static boolean isErrorCodeMatch(ApiServerException r100) {
        if (r100.getErrorCode() != 20047) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean shouldShowBindPhone(Exception r100) {
        if ((r100 instanceof ApiServerException) == true) goto L5;
    L7:
        return false;
    L5:
        if (isErrorCodeMatch((ApiServerException) r100) == false) goto L7;
        return true;
    }

    public static void handleException(Context r100, Throwable r101) {
        handleException(r100, r101, s1.B(R.string.ttlive_core_ss_error_unknown));
    }

    public static void handleExceptionWithOutCustom(Context r100, Throwable r101) {
        handleExceptionWithOutCustom(r100, r101, 0);
    }

    public static void showPopupToast(Context r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        bc1.e r102 = new bc1.e(r100);
        r102.f18567b.setVisibility(8);
        if (StringUtils.isEmpty(r101) == true) goto L7;
        r102.f18568c.setText(r101);
        boolean r103 = true;
    L8:
        if (r103 == false) goto L31;
        r102.f18570e.removeCallbacks(r102.f18571f);
        if (r102.f18566a.isShowing() == false) goto L25;
        bc1.e.a(r102.f18566a);     // Catch: Exception -> L22
    L25:
        r102.f18566a.getWindow().setGravity(17);     // Catch: Exception -> L24
        Dialog r104 = r102.f18566a;     // Catch: Exception -> L24
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L29;
        DialogLancet.handleBlockedDialogShow(r104);     // Catch: Exception -> L24
    L20:
        r102.f18570e.postDelayed(r102.f18571f, 2000);     // Catch: Exception -> L24
        return;
    L29:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L19:
        DialogLancet.beforeDialogShow(r104);     // Catch: Exception -> L24
        r104.show();     // Catch: Exception -> L24
        DialogLancet.afterDialogShow(r104);     // Catch: Exception -> L24
    L32:
        return;
    L31:
        return;
    L7:
        r103 = false;
        goto L8
    }

    public static void displayAlert(Context r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        AlertDialog.Builder r103 = new AlertDialog.Builder(r100);
        r103.setTitle(r100.getResources().getString(R.string.ttlive_core_tip));
        r103.setMessage(r101);
        r103.setPositiveButton(r102, null);
        INVOKEVIRTUAL_com_bytedance_android_live_core_utils_ExceptionUtils_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r103.create());
    }

    public static void handleException(Context r100, Throwable r101, String r102) {
        if (r101 == null) goto L19;
        if (r100 != null) goto L6;
        return;
    L6:
        if ((r101 instanceof ApiServerException) == false) goto L16;
        ApiServerException r103 = (ApiServerException) r101;
        String r104 = r103.getPrompt();
        String r105 = r103.getAlert();
        if (r103.isBlockNotice() == false) goto L10;
    L17:
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L10:
        if (TextUtils.isEmpty(r105) == true) goto L13;
        displayAlert(r100, r105, r100.getResources().getString(R.string.ttlive_core_known));
        goto L17
    L13:
        if (TextUtils.isEmpty(r104) == true) goto L15;
        IESUIUtils.displayToast(r100, r104);
        goto L17
    L15:
        IESUIUtils.displayToast(r100, r102);
        goto L17
    L16:
        IESUIUtils.displayToast(r100, r102);
        goto L17
    }

    public static void handleExceptionWithOutCustom(Context r100, Throwable r101, String r102) {
        if ((r101 instanceof ApiServerException) == false) goto L15;
        ApiServerException r103 = (ApiServerException) r101;
        if (r103.getErrorCode() == 20006) goto L15;
        String r104 = r103.getPrompt();
        String r105 = r103.getAlert();
        if (r103.isBlockNotice() == false) goto L9;
    L16:
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L9:
        if (TextUtils.isEmpty(r105) == true) goto L12;
        displayAlert(r100, r105, r100.getResources().getString(R.string.ttlive_core_known));
        goto L16
    L12:
        if (TextUtils.isEmpty(r104) == true) goto L14;
        IESUIUtils.displayToast(r100, r104);
        goto L16
    L14:
        f2.c(r102, 0);
    L15:
        f2.c(r102, 0);
        goto L16
    }

    public static void handleException(Context r100, Throwable r101, int r102) {
        if (r102 > 0) goto L5;
        r102 = R.string.ttlive_core_ss_error_unknown;
    L5:
        handleException(r100, r101, s1.B(r102));
    }

    public static void handleExceptionWithOutCustom(Context r100, Throwable r101, int r102) {
        if (r102 > 0) goto L5;
        r102 = R.string.ttlive_core_ss_error_unknown;
    L5:
        handleExceptionWithOutCustom(r100, r101, s1.B(r102));
    }

    public static void throwError(int r100, RequestError r101, String r102, String r103, String r104) throws Exception {
        if (r101 != null) goto L4;
        r101 = new RequestError();
        r101.prompts = s1.B(R.string.ttlive_core_ss_error_unknown);
    L4:
        CustomApiServerException r105 = new CustomApiServerException(r100, r101.url, r103, r104);
        r105.setErrorMsg(r101.message);
        r105.setPrompt(r101.prompts);
        r105.setAlert(r101.alert);
        r105.setBlockNotice(r101.isBlockNotice());
        r105.setExtra(r102);
        throw r105;
    }

    public static void throwError(int r100, RequestError r101, Extra r102, String r103, String r104) throws Exception {
        throwError(r100, r101, GsonProtectorUtils.toJson(GsonHelper.get(), r102), r103, r104);
    }
}
