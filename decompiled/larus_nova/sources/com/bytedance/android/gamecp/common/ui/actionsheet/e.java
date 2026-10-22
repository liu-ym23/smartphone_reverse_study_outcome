package com.bytedance.android.gamecp.common.ui.actionsheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bv.b f56971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bv.a f56972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f56973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f56974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Dialog f56975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f56976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f56977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f56978h;

    public final void b() {
        Dialog r100 = this.f56975e;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L8;
        a(r100);
    L8:
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static void a(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public e(bv.b r110, bv.a r111, List r112, Context r113, Function2 r114) {
        Intrinsics.checkNotNullParameter(r114, "initTrack");
        this.f56971a = r110;
        this.f56972b = r111;
        this.f56973c = r112;
        this.f56974d = null;
        if (r113 == null) goto L31;
        Dialog r115 = new Dialog(r113, R.style.gamecp_custom_dialog);
        this.f56975e = r115;
        r115.setCancelable(true);
        Window r100 = r115.getWindow();
        if (r100 == null) goto L7;
        r100.setBackgroundDrawableResource(android.R.color.transparent);
        r100.setWindowAnimations(R.style.gamecp_bottom_dialog_anim);
        r100.setAttributes(r100.getAttributes());
        r100.setGravity(80);
    L7:
        View r101 = LayoutInflater.from(r113).inflate(R.layout.gamecp_action_sheet, null);
        r101.setMinimumWidth(10000);
        TextView r102 = (TextView) r101.findViewById(R.id.action_sheet_cancel);
        this.f56978h = r102;
        if (r102 == null) goto L10;
        r102.setOnClickListener(new d(this));
    L10:
        TextView r103 = (TextView) r101.findViewById(R.id.action_sheet_description);
        if (TextUtils.isEmpty(null) == false) goto L13;
        r103.setVisibility(8);
    L14:
        LinearLayout r104 = (LinearLayout) r101.findViewById(R.id.action_sheet_container);
        if (r112 == null) goto L26;
        int r105 = r112.size();
        int r106 = 0;
    L17:
        if (r106 >= r105) goto L26;
        if (r106 == 0) goto L20;
    L22:
        boolean r107 = false;
    L23:
        if (r107 == true) goto L25;
        View r108 = new View(r113);
        r108.setBackgroundColor(r113.getResources().getColor(R.color.gamecp_black_12));
        r108.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        r104.addView(r108);
    L25:
        View r109 = LayoutInflater.from(r113).inflate(R.layout.gamecp_action_sheet_item, null);
        r104.addView(r109);
        a r116 = (a) ListProtector.get(r112, r106);
        ((TextView) r109.findViewById(R.id.action_sheet_item_tv)).setText(r116.f56965b);
        r109.setOnClickListener(new c(r116, this));
        r106 = r106 + 1;
        goto L17
    L20:
        if (TextUtils.isEmpty(this.f56974d) == false) goto L22;
        r107 = true;
    L26:
        this.f56977g = r101;
        r115.setContentView(r101);
        r115.setOnDismissListener(new b(this, r114));
        r114.invoke(r115, r101);
        HashMap<String, String> r117 = GamecpTracker.f56755a;
        GamecpTracker.p(r115);
        return;
    L13:
        r103.setVisibility(0);
        r103.setText(null);
        goto L14
    }
}
