package com.alipay.sdk.m.x;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes28.dex */
public class b {

    public static class a implements DialogInterface.OnKeyListener {
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
            if (r101 != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public a() {
        }
    }

    public b() {
    }

    public static void INVOKEVIRTUAL_com_alipay_sdk_m_x_b_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(Dialog r100) {
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

    public static AlertDialog.Builder a(Context r100, String r101, String r102, DialogInterface.OnClickListener r103, String r104, DialogInterface.OnClickListener r105) {
        AlertDialog.Builder r106 = new AlertDialog.Builder(r100);
        if (TextUtils.isEmpty(r104) == true) goto L7;
        if (r105 == null) goto L7;
        r106.setPositiveButton(r104, r105);
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L10;
        if (r103 == null) goto L10;
        r106.setNegativeButton(r102, r103);
    L10:
        return r106;
    }

    public static Dialog a(Context r100, String r101, String r102, String r103, DialogInterface.OnClickListener r110, String r111, DialogInterface.OnClickListener r112) {
        AlertDialog.Builder r104 = a(r100, r101, r103, r110, r111, r112);
        r104.setTitle(r101);
        r104.setMessage(r102);
        AlertDialog r105 = r104.create();
        r105.setCanceledOnTouchOutside(false);
        r105.setOnKeyListener(new a());
        INVOKEVIRTUAL_com_alipay_sdk_m_x_b_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r105);     // Catch: Throwable -> L5
    L7:
        return r105;
    L5:
        th = move-exception;
        com.alipay.sdk.m.u.e.a(com.alipay.sdk.m.l.a.A, "showDialog ", th);
        goto L7
    }
}
