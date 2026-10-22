package com.bytedanceos.appstore.buss.widget.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.bytedanceos.appstore.buss.entity.AppSubEntity;
import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.tracker.TrackerElement;
import com.obric.appstore.R;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f9279a = null;

    static {
        f9279a = new v();
    }

    public v() {
    }

    public static /* synthetic */ void a(Activity r10, HashMap r11, AppSubEntity r12, DialogInterface r13, int r14) {
        h(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void b(Function0 r10, DialogInterface r11, int r12) {
        f(r10, r11, r12);
    }

    public static /* synthetic */ void c(HashMap r10, AppSubEntity r11, DialogInterface r12, int r13) {
        i(r10, r11, r12, r13);
    }

    public static final void f(Function0 r10, DialogInterface r11, int r12) {
        kotlin.jvm.internal.q.g(r10, "$listener");
        r10.invoke();
    }

    public static final void h(Activity r10, HashMap r11, AppSubEntity r12, DialogInterface r13, int r14) {
        kotlin.jvm.internal.q.g(r10, "$activity");
        kotlin.jvm.internal.q.g(r11, "$param");
        kotlin.jvm.internal.q.g(r12, "$appSubEntity");
        CommonUtil.f8830a.h(r10, "dialog_subscribe_success", true);
        r11.put("button_name", TrackerElement.ISLOGIN);
        d9.a.e().R("0096", r11);
        f9279a.d(r12, TrackerElement.ISLOGIN);
    }

    public static final void i(HashMap r10, AppSubEntity r11, DialogInterface r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "$param");
        kotlin.jvm.internal.q.g(r11, "$appSubEntity");
        r10.put("button_name", "cancel");
        d9.a.e().R("0096", r10);
        f9279a.d(r11, "give_up_gift");
    }

    public final void d(AppSubEntity r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "appSubEntity");
        kotlin.jvm.internal.q.g(r11, "operation");
        Bundle r12 = new Bundle();
        r12.putString(TrackerElement.GAME_NAME, r10.getName());
        r12.putString("game_category", r10.getCategory());
        r12.putString("game_online_time", r10.getOnline_time());
        r12.putString("game_reserved_dialog_click", r11);
        f9.b.b("dialog_reserved_success_logout", r12);
    }

    public final void e(Activity r10, final Function0 r11) {
        kotlin.jvm.internal.q.g(r10, "activity");
        kotlin.jvm.internal.q.g(r11, "listener");
        new AlertDialog.Builder(r10, 5).setTitle(r10.getString(R.string.game_give_up_reserve_dialog_title)).setMessage(r10.getString(R.string.game_give_up_reserve_dialog_content)).setPositiveButton(r10.getString(R.string.game_give_up_confirm), new u(r11)).setCancelable(false).setNegativeButton(R.string.cancel, null).show();
    }

    public final void g(final Activity r10, final AppSubEntity r11) {
        kotlin.jvm.internal.q.g(r10, "activity");
        kotlin.jvm.internal.q.g(r11, "appSubEntity");
        final HashMap r12 = new HashMap();
        if (AccountDataCache.b().n() == false) goto L5;
        e0.e(R.string.game_reserve_success_toast);
        return;
    L5:
        new AlertDialog.Builder(r10, 5).setTitle(R.string.game_reserve_success_dialog_title).setMessage(R.string.game_reserve_success_dialog_content).setCancelable(false).setPositiveButton(r10.getString(R.string.game_reserve_success_dialog_login), new s(r10, r12, r11)).setNegativeButton(R.string.game_reserve_success_dialog_give_up, new t(r12, r11)).show();
    }
}
