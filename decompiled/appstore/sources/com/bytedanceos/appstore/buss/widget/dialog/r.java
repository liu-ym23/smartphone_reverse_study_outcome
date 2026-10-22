package com.bytedanceos.appstore.buss.widget.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import com.bytedanceos.appstore.buss.entity.GiftMyEntity;
import com.bytedanceos.appstore.buss.viewmodels.repository.MyGiftRepository;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.tracker.TrackerElement;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f9272a = null;

    static {
        f9272a = new r();
    }

    public r() {
    }

    public static /* synthetic */ void a(boolean r10, DialogInterface r11, int r12) {
        o(r10, r11, r12);
    }

    public static /* synthetic */ void b(DialogInterface r10, int r11) {
        l(r10, r11);
    }

    public static /* synthetic */ void c(DialogInterface r10, int r11) {
        j(r10, r11);
    }

    public static /* synthetic */ void d(DialogInterface r10, int r11) {
        i(r10, r11);
    }

    public static /* synthetic */ void e(boolean r10, DialogInterface r11, int r12) {
        p(r10, r11, r12);
    }

    public static /* synthetic */ void f(Activity r10, GiftMyEntity r11, DialogInterface r12, int r13) {
        m(r10, r11, r12, r13);
    }

    public static final void i(DialogInterface r10, int r11) {
        f9272a.g("click_dialog_goodies_use", "cancel_install");
    }

    public static final void j(DialogInterface r10, int r11) {
        f9272a.g("click_dialog_goodies_use", TrackerElement.INSTALL);
    }

    public static final void l(DialogInterface r10, int r11) {
        f9272a.g("click_dialog_goodies_use", "cancel_open");
    }

    public static final void m(Activity r10, GiftMyEntity r11, DialogInterface r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "$activity");
        kotlin.jvm.internal.q.g(r11, "$entity");
        com.bytedanceos.common.toolbox.e.v1(r10, r11.convertAppInfo());
        MyGiftRepository.f9032b.a().e(r11.getId());
        f9272a.g("click_dialog_goodies_use", "open");
    }

    public static final void o(boolean r10, DialogInterface r11, int r12) {
        if (r10 == false) goto L5;
        f9272a.g("click_dialog_goodies_acquire", "cancel_open");
        return;
    L5:
        f9272a.g("click_dialog_goodies_acquire", "cancel_install");
    }

    public static final void p(boolean r10, DialogInterface r11, int r12) {
        if (r10 == false) goto L5;
        f9272a.g("click_dialog_goodies_acquire", "open");
        return;
    L5:
        f9272a.g("click_dialog_goodies_acquire", TrackerElement.INSTALL);
    }

    public final void g(String r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "event");
        kotlin.jvm.internal.q.g(r11, "operation");
        Bundle r12 = new Bundle();
        r12.putString("gift_use_dialog_operation", r11);
        f9.b.b(r10, r12);
    }

    public final void h(Activity r10, GiftMyEntity r11) {
        kotlin.jvm.internal.q.g(r10, "activity");
        kotlin.jvm.internal.q.g(r11, "entity");
        if (BaseApplication.c().b().X(r11.getPackageName()) == false) goto L6;
        BaseApplication r12 = BaseApplication.c();
        kotlin.jvm.internal.q.f(r12, "getContext(...)");
        String r13 = BaseApplication.c().getString(R.string.auto_download_toast);
        kotlin.jvm.internal.q.f(r13, "getString(...)");
        com.bytedanceos.appstore.buss.utilities.s.b(r12, r13);
        return;
    L6:
        new AlertDialog.Builder(new ContextThemeWrapper(r10, R.style.AppStoreDialogTheme)).setTitle(R.string.use_gift_dialog_title_no_app).setMessage(r10.getString(R.string.gift_get_success_msg)).setNegativeButton(R.string.cancel, new n()).setPositiveButton(R.string.install, new o()).setCancelable(true).show();
    }

    public final void k(final Activity r10, final GiftMyEntity r11) {
        kotlin.jvm.internal.q.g(r10, "activity");
        kotlin.jvm.internal.q.g(r11, "entity");
        new AlertDialog.Builder(new ContextThemeWrapper(r10, R.style.AppStoreDialogTheme)).setTitle(R.string.use_gift_dialog_title).setMessage(r10.getString(R.string.gift_msg_content, new Object[]{r11.getCode()})).setNegativeButton(R.string.cancel, new l()).setPositiveButton(R.string.gift_open_app, new m(r10, r11)).setCancelable(true).show();
    }

    public final void n(Activity r10, GiftMyEntity r11, final boolean r12) {
        kotlin.jvm.internal.q.g(r10, "activity");
        kotlin.jvm.internal.q.g(r11, "entity");
        if (BaseApplication.c().b().X(r11.getPackageName()) == false) goto L6;
        BaseApplication r13 = BaseApplication.c();
        kotlin.jvm.internal.q.f(r13, "getContext(...)");
        String r14 = BaseApplication.c().getString(R.string.auto_download_toast);
        kotlin.jvm.internal.q.f(r14, "getString(...)");
        com.bytedanceos.appstore.buss.utilities.s.b(r13, r14);
        return;
    L6:
        String r15 = r10.getString(R.string.gift_get_success_msg);
        kotlin.jvm.internal.q.f(r15, "getString(...)");
        if (r12 == false) goto L9;
        r15 = r10.getString(R.string.gift_msg_content);
        kotlin.jvm.internal.q.f(r15, "getString(...)");
    L9:
        new AlertDialog.Builder(new ContextThemeWrapper(r10, R.style.AppStoreDialogTheme)).setTitle(R.string.gift_get_success_title).setMessage(r15).setNegativeButton(R.string.cancel, new p(r12)).setPositiveButton(R.string.install, new q(r12)).setCancelable(true).show();
    }
}
