package com.bytedanceos.appstore.buss.widget.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9250a = null;

    static {
        f9250a = new c();
    }

    public c() {
    }

    public static /* synthetic */ void a(Activity r10, DialogInterface r11, int r12) {
        c(r10, r11, r12);
    }

    public static final void c(Activity r10, DialogInterface r11, int r12) {
        kotlin.jvm.internal.q.g(r10, "$activity");
        com.bytedanceos.common.toolbox.e.l1(r10, 1);
    }

    public final void b(final Activity r10) {
        kotlin.jvm.internal.q.g(r10, "activity");
        new AlertDialog.Builder(new ContextThemeWrapper(r10, R.style.AppStoreDialogTheme)).setTitle(R.string.nickname_alert_title).setMessage(R.string.nickname_alert_context).setNegativeButton(r10.getString(R.string.cancel), null).setPositiveButton(R.string.nickname_settings, new b(r10)).setCancelable(true).show();
    }
}
