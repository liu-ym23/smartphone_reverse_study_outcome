package com.bytedanceos.appstore.buss.widget.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f9282a = null;

    static {
        f9282a = new x();
    }

    public x() {
    }

    public static /* synthetic */ void a(Activity r10, String r11, DialogInterface r12, int r13) {
        c(r10, r11, r12, r13);
    }

    public static final void c(Activity r10, String r11, DialogInterface r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "$activity");
        kotlin.jvm.internal.q.g(r11, "$source");
        CommonUtil.f8830a.h(r10, r11, true);
    }

    public final boolean b(final Activity r10, int r11, final String r12) {
        kotlin.jvm.internal.q.g(r10, "activity");
        kotlin.jvm.internal.q.g(r12, "source");
        if (AccountDataCache.b().n() == true) goto L7;
        new AlertDialog.Builder(new ContextThemeWrapper(r10, R.style.AppStoreDialogTheme)).setTitle(R.string.TICKET_IS_LOGOUT).setMessage(BaseApplication.c().getString(r11)).setNegativeButton(R.string.cancel, null).setPositiveButton(R.string.settings_login, new w(r10, r12)).setCancelable(true).show();
        return false;
    L7:
        return true;
    }
}
