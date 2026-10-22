package com.bytedance.android.gamecp.common.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.gamecp.host_api.GameCpTargetUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes44.dex */
public final class k extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DouyinBallLoadingAnimationView f57014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f57015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f57016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f57017d;

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        ImageView r100 = this.f57017d;
        if (r100 == null) goto L6;
        r100.clearAnimation();
    L6:
        if (getOwnerActivity() != null) goto L8;
        return;
    L8:
        if (getOwnerActivity().isFinishing() == true) goto L21;
        a(this);     // Catch: Exception -> L12
    L13:
        DouyinBallLoadingAnimationView r101 = this.f57014a;
        if (r101 == null) goto L20;
        r101.setVisibility(8);
        return;
    L20:
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (getOwnerActivity() != null) goto L5;
        return;
    L5:
        if (getOwnerActivity().isFinishing() == false) goto L8;
        return;
    L8:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L23;
        DialogLancet.handleBlockedDialogShow(this);
    L12:
        DouyinBallLoadingAnimationView r100 = this.f57014a;
        if (r100 == null) goto L15;
        r100.setVisibility(0);
    L15:
        ImageView r101 = this.f57017d;
        if (r101 == null) goto L18;
        r101.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.gamecp_loading_dialog_animation));
    L18:
        TextView r102 = this.f57015b;
        if (r102 == null) goto L26;
        r102.setVisibility(0);
        this.f57015b.setText(this.f57016c);
        return;
    L26:
        return;
    L23:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L11:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L12
    }

    public k(Activity r100) {
        super(r100, R.style.gamecp_RedEnvelopeDialogStyle);
        setOwnerActivity(r100);
    }

    public static void a(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        super.dismiss();     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (GameCpTargetUtils.c() == false) goto L6;
        setContentView(R.layout.gamecp_layout_douyin_loading_view);
    L13:
        this.f57014a = (DouyinBallLoadingAnimationView) findViewById(R.id.double_loading_view);
        this.f57015b = (TextView) findViewById(R.id.double_loading_text);
        this.f57017d = (ImageView) findViewById(R.id.iv_loading);
        return;
    L6:
        if (GameCpTargetUtils.i() == true) goto L15;
        setContentView(R.layout.gamecp_layout_hotsoon_loading_view);
        goto L13
    L15:
        setContentView(R.layout.gamecp_layout_xg_loading_view);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        setContentView(new TextView(getContext()));
        e.printStackTrace();
        goto L13
    }
}
