package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.content.Context;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.uikit.dialog.AlertDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class j {
    public static boolean b(Exception r100) {
        if ((r100 instanceof ApiServerException) == true) goto L5;
        return false;
    L5:
        if (((ApiServerException) r100).getErrorCode() != com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.n().f()) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    }

    public static void a(Context r100, String r101, String r102) {
        AlertDialog.Builder r103 = new AlertDialog.Builder(r100);
        r103.setTitle(r100.getResources().getString(R.string.ttlive_core_tip));
        r103.setMessage(r101);
        r103.setPositiveButton(r102, null);
        AlertDialog r104 = r103.create();
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r104);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
    }
}
