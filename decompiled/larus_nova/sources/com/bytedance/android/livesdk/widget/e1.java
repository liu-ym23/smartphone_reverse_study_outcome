package com.bytedance.android.livesdk.widget;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes11.dex */
public final class e1 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f161692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f161693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f161694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f161695d;

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        ImageView r100 = this.f161695d;
        if (r100 == null) goto L6;
        r100.clearAnimation();
    L6:
        if (getOwnerActivity() != null) goto L8;
        return;
    L8:
        if (getOwnerActivity().isFinishing() == true) goto L21;
        a(this);     // Catch: Exception -> L12
    L13:
        LiveDoubleColorBallAnimationView r101 = this.f161692a;
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
        LiveDoubleColorBallAnimationView r100 = this.f161692a;
        if (r100 == null) goto L15;
        r100.setVisibility(0);
    L15:
        ImageView r101 = this.f161695d;
        if (r101 == null) goto L18;
        r101.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_loading_dialog_animation));
    L18:
        TextView r102 = this.f161693b;
        if (r102 == null) goto L26;
        r102.setVisibility(0);
        this.f161693b.setText(this.f161694c);
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

    public e1(Activity r100) {
        super(r100, R.style.ttlive_RedEnvelopeDialogStyle);
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
        setContentView(R.layout.ttlive_layout_douyin_loading_view);
        LinearLayout r101 = (LinearLayout) findViewById(R.id.bg_view);
        this.f161692a = (LiveDoubleColorBallAnimationView) findViewById(R.id.double_loading_view);
        this.f161693b = (TextView) findViewById(R.id.double_loading_text);
        this.f161695d = (ImageView) findViewById(R.id.iv_loading);
    }
}
