package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.chatroom.ui.LittlePluginCloseDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class u0 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f117388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f117389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.api.model.e f117390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f117391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Dialog f117392e;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r100, DataCenter r101) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void p4(View r100, DataCenter r101) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f117388a == false) goto L28;
        LittlePluginCloseDialog r101 = new LittlePluginCloseDialog(this.f117389b, this.f117391d, this.f117390c);
        r101.setCancelable(false);
        r101.setCanceledOnTouchOutside(false);
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L35;
        DialogLancet.handleBlockedDialogShow(r101);
    L9:
        Dialog r102 = this.f117392e;
        if (r102 == null) goto L38;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r104 == null) goto L25;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
        goto L25
    L14:
        if (Looper.myLooper() == r103.getLooper()) goto L16;
        r103.post(DialogLancet.createDismissRunnable(r102));
        return;
    L38:
        return;
    L35:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L8:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
        goto L9
    L28:
        DataCenter r105 = this.f117391d;
        if (r105 == null) goto L41;
        r105.put("cmd_open_little_plugin", this.f117390c);
        return;
    }

    public u0(boolean r100, Context r101, com.bytedance.android.live.broadcastgame.api.model.e r102, DataCenter r103, Dialog r104) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        this.f117389b = r101;
        this.f117390c = r102;
        this.f117391d = r103;
        this.f117392e = r104;
        this.f117388a = r100;
    }
}
