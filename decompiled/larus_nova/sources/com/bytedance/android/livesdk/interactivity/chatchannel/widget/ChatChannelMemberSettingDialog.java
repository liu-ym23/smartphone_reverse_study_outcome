package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChatChannelMemberSettingDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelMemberSettingDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int E = 0;
    public final a B;
    public final long C;
    public final s22.a D;

    public static final class a extends s22.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatChannelMemberSettingDialog f134545a;

        @Override // s22.e.a
        public final void a(s22.a r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "chatChannel");
        }

        public a(ChatChannelMemberSettingDialog r100) {
            this.f134545a = r100;
        }

        @Override // s22.e.a
        public final void b(long r100) {
            if (this.f134545a.D.getChannelId() != r100) goto L21;
            ChatChannelMemberSettingDialog r101 = this.f134545a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r103 == null) goto L18;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L7:
            if (Looper.myLooper() == r102.getLooper()) goto L9;
            r102.post(DialogLancet.createDismissRunnable(r101));
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final boolean V0() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_room_channel_member_setting_panel;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        s22.e r101 = ChatChannelUtils.b(RoomContext.a.c(RoomContext.Companion, null, this.C, 1));
        if (r101 == null) goto L26;
        r101.removeListener(this.B);
        return;
    L26:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        s22.e r100 = ChatChannelUtils.b(RoomContext.a.c(RoomContext.Companion, null, this.C, 1));
        if (r100 == null) goto L14;
        r100.addListener(this.B);
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

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (PadConfigUtils.c() == true) goto L10;
        int r101 = s1.w() - s1.A();
        Window r102 = getWindow();
        if (r102 == null) goto L10;
        if (r101 != 0) goto L9;
        r101 = -1;
    L9:
        r102.setLayout(-1, r101);
    L10:
        ((ImageView) findViewById(R.id.close_btn)).setOnClickListener(new m(this));
        ((ConstraintLayout) findViewById(R.id.exit_channel_container)).setOnClickListener(x0.a(new ChatChannelMemberSettingDialog$initView$2(this)));
        if (PadConfigUtils.c() == false) goto L13;
        ((ConstraintLayout) findViewById(R.id.member_setting_container)).setBackgroundResource(e62.a.f471120d);
        return;
    L13:
        ((ConstraintLayout) findViewById(R.id.member_setting_container)).setBackgroundResource(e62.a.f471122f);
    }

    public ChatChannelMemberSettingDialog(Context r100, long r101, s22.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "chatChannel");
        super(r100, false);
        this.C = r101;
        this.D = r102;
        this.B = new a(this);
    }
}
