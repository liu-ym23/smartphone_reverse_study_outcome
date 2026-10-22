package com.bytedance.android.live.revenue.common;

import android.content.Context;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.dialog.AlertDialog;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k {
    public static final void c(Throwable r100) {
        a(com.bytedance.live.kmp.util.c.f255167a.getContext(), r100);
    }

    public static final void a(Context r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
        return;
    L5:
        com.bytedance.live.kmp.util.c r102 = com.bytedance.live.kmp.util.c.f255167a;
        int r103 = nx0.a.f521035a;
        b(r100, r101, com.bytedance.live.kmp.util.c.a(R.string.ttlive_core_ss_error_unknown, new Object[0]));
    }

    public static final void d(Throwable r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r101, "fallbackPrompt");
        b(com.bytedance.live.kmp.util.c.f255167a.getContext(), r100, r101);
    }

    public static final void e(Context r100, Throwable r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        com.bytedance.live.kmp.util.c r102 = com.bytedance.live.kmp.util.c.f255167a;
        int r103 = nx0.a.f521035a;
        String r104 = com.bytedance.live.kmp.util.c.a(R.string.ttlive_core_ss_error_unknown, new Object[0]);
        if (r100 != null) goto L7;
        r100 = r102.getContext();
    L7:
        b(r100, r101, r104);
    }

    public static final void b(Context r100, Throwable r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r102, "fallbackPrompt");
        if ((r101 instanceof ApiServerException) == false) goto L37;
        ApiServerException r103 = (ApiServerException) r101;
        String r104 = r103.getPrompt();
        String r105 = r103.getAlert();
        if (r103.isBlockNotice() == true) goto L41;
        if (r105 != null) goto L9;
    L12:
        boolean r106 = true;
    L13:
        if (r106 == true) goto L22;
        com.bytedance.live.kmp.util.c r107 = com.bytedance.live.kmp.util.c.f255167a;
        int r108 = nx0.a.f521035a;
        String r109 = com.bytedance.live.kmp.util.c.a(R.string.ttlive_core_tip, new Object[0]);
        String r110 = com.bytedance.live.kmp.util.c.a(R.string.ttlive_core_known, new Object[0]);
        Intrinsics.checkNotNullParameter(r109, "title");
        Intrinsics.checkNotNullParameter(r105, "message");
        Intrinsics.checkNotNullParameter(r110, "confirmBtnText");
        if (r100 != null) goto L17;
        r100 = s1.getContext();
    L17:
        AlertDialog.Builder r111 = new AlertDialog.Builder(r100);
        r111.setTitle(r109);
        r111.setMessage(r105);
        r111.setPositiveButton(r110, null);
        AlertDialog r112 = r111.create();
        if (DialogLancet.shouldBlockDialogShow(r112) == false) goto L44;
        DialogLancet.handleBlockedDialogShow(r112);
        goto L41
    L44:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L43
    L21:
        DialogLancet.beforeDialogShow(r112);
        r112.show();
        DialogLancet.afterDialogShow(r112);
        goto L41
    L22:
        if (r104 != null) goto L24;
    L27:
        boolean r113 = true;
    L28:
        if (r113 == true) goto L33;
        Intrinsics.checkNotNullParameter(r104, "message");
        if (r100 != null) goto L32;
        r100 = s1.getContext();
    L32:
        IESUIUtils.displayToast(r100, r104);
        goto L41
    L33:
        Intrinsics.checkNotNullParameter(r102, "message");
        if (r100 != null) goto L36;
        r100 = s1.getContext();
    L36:
        IESUIUtils.displayToast(r100, r102);
        goto L41
    L24:
        if (r104.length() == 0) goto L27;
        r113 = false;
        goto L28
    L9:
        if (r105.length() == 0) goto L12;
        r106 = false;
    L41:
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L37:
        Intrinsics.checkNotNullParameter(r102, "message");
        if (r100 != null) goto L40;
        r100 = s1.getContext();
    L40:
        IESUIUtils.displayToast(r100, r102);
        goto L41
    }
}
