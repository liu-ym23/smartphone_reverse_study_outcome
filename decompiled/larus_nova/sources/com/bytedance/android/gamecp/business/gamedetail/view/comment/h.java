package com.bytedance.android.gamecp.business.gamedetail.view.comment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class h extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f55838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f55839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f55840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f55841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f55842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f55843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f55844g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f55845h;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        View r101 = this.f55841d;
        if (r101 == null) goto L26;
        HashMap<String, String> r102 = GamecpTracker.f56755a;
        GamecpTracker.o(r101);
        return;
    L26:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r103 == null) goto L16;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        View r100 = this.f55841d;
        if (r100 == null) goto L14;
        HashMap<String, String> r101 = GamecpTracker.f56755a;
        GamecpTracker.p(r100);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.gamecp_live_dialog);
        this.f55842e = 0;
    }

    public final Map<String, String> a(String r100) {
        HashMap r101 = new HashMap();
        r101.put(com.bytedance.android.ec.core.event.a.KEY_SCORE, String.valueOf(this.f55842e));
        String r102 = this.f55843f;
        if (r102 == null) goto L5;
        r101.put("entry", r102);
    L5:
        if (r100 == null) goto L7;
        r101.put("button", r100);
    L7:
        return r101;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        setContentView(R.layout.gamecp_comment_write_guide_dialog_layout2);
        this.f55841d = findViewById(R.id.cl_write_comment_guide);
        this.f55838a = (TextView) findViewById(R.id.comment_guide_title);
        this.f55839b = (TextView) findViewById(R.id.tv_write_comment);
        this.f55840c = (TextView) findViewById(R.id.tv_next_time);
        String r100 = this.f55844g;
        if (r100 != null) goto L5;
    L12:
        TextView r101 = this.f55840c;
        if (r101 == null) goto L15;
        r101.setOnClickListener(new CommentWriteGuideDialog2$initListener$1(this));
    L15:
        TextView r102 = this.f55839b;
        if (r102 == null) goto L18;
        r102.setOnClickListener(new i(this));
    L18:
        View r103 = this.f55841d;
        if (r103 == null) goto L21;
        HashMap<String, String> r104 = GamecpTracker.f56755a;
        GamecpTracker.v(r103, r103, "comment_floating_window_star_success", a(null), MapsKt.emptyMap(), null, false, 256);
    L21:
        TextView r111 = this.f55840c;
        if (r111 == null) goto L24;
        HashMap<String, String> r105 = GamecpTracker.f56755a;
        GamecpTracker.r(r111, "comment_floating_window_star_success", a("next_time"), new j(), false, 112);
    L24:
        TextView r106 = this.f55839b;
        if (r106 == null) goto L28;
        HashMap<String, String> r107 = GamecpTracker.f56755a;
        GamecpTracker.r(r106, "comment_floating_window_star_success", a("write_comment"), new k(), false, 112);
        return;
    L28:
        return;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L12;
        TextView r108 = this.f55838a;
        if (r108 == null) goto L12;
        r108.setText(r100);
        goto L12
    }
}
