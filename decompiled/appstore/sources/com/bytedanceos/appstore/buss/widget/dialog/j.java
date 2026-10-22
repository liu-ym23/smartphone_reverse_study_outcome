package com.bytedanceos.appstore.buss.widget.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.widget.LinearLayout;
import com.bytedanceos.common.toolbox.g0;
import com.obric.appstore.R;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f9266a = null;

    static {
        f9266a = new j();
    }

    public j() {
    }

    public static /* synthetic */ void a(x7.f r10, Function0 r11, DialogInterface r12, int r13) {
        d(r10, r11, r12, r13);
    }

    public static /* synthetic */ void b(Activity r10, x7.f r11, Function0 r12, DialogInterface r13, int r14) {
        e(r10, r11, r12, r13, r14);
    }

    public static final void d(x7.f r10, Function0 r11, DialogInterface r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "$binding");
        kotlin.jvm.internal.q.g(r11, "$listener");
        Bundle r14 = new Bundle();
        if (r10.f25555b.isChecked() == false) goto L5;
        g0.a().f(100003070);
        r14.putString("dialog_autoupdate_button_status", "cancle_select");
    L6:
        f9.b.b("click_dialog_autoupdate", r14);
        r11.invoke();
        return;
    L5:
        r14.putString("dialog_autoupdate_button_status", "cancle_notselect");
        goto L6
    }

    public static final void e(Activity r10, x7.f r11, Function0 r12, DialogInterface r13, int r14) {
        kotlin.jvm.internal.q.g(r10, "$activity");
        kotlin.jvm.internal.q.g(r11, "$binding");
        kotlin.jvm.internal.q.g(r12, "$listener");
        com.bytedanceos.common.toolbox.s.r(r10, true);
        Bundle r15 = new Bundle();
        if (r11.f25555b.isChecked() == false) goto L5;
        r15.putString("dialog_autoupdate_button_status", "open_select");
    L6:
        f9.b.b("click_dialog_autoupdate", r15);
        r12.invoke();
        return;
    L5:
        r15.putString("dialog_autoupdate_button_status", "open_notselect");
        goto L6
    }

    public final void c(final Activity r10, final Function0 r11) {
        kotlin.jvm.internal.q.g(r10, "activity");
        kotlin.jvm.internal.q.g(r11, "listener");
        final x7.f r12 = x7.f.c(r10.getLayoutInflater());
        kotlin.jvm.internal.q.f(r12, "inflate(...)");
        LinearLayout r13 = r12.b();
        kotlin.jvm.internal.q.f(r13, "getRoot(...)");
        r12.f25556c.setText(r10.getString(R.string.dialog_switch_update_msg));
        r12.f25555b.setText(r10.getString(R.string.dialog_switch_update_tips));
        new AlertDialog.Builder(new ContextThemeWrapper(r10, R.style.AppStoreDialogTheme)).setTitle(R.string.alert_installApp_title).setNegativeButton(R.string.dialog_switch_update_btn_left, new h(r12, r11)).setView(r13).setPositiveButton(R.string.dialog_switch_update_btn_right, new i(r10, r12, r11)).setCancelable(true).show();
    }
}
