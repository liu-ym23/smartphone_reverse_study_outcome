package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChatChannelOwnerSettingDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelOwnerSettingDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int F = 0;
    public final String B;
    public final a C;
    public final long D;
    public final s22.a E;

    public static final class a extends s22.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatChannelOwnerSettingDialog f134546a;

        @Override // s22.e.a
        public final void a(s22.a r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "chatChannel");
        }

        public a(ChatChannelOwnerSettingDialog r100) {
            this.f134546a = r100;
        }

        @Override // s22.e.a
        public final void b(long r100) {
            if (this.f134546a.E.getChannelId() != r100) goto L21;
            ChatChannelOwnerSettingDialog r101 = this.f134546a;
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
        return R.layout.ttlive_room_channel_owner_setting_panel;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        RoomContext.a r101 = RoomContext.Companion;
        s22.e r102 = ChatChannelUtils.b(RoomContext.a.c(r101, null, this.D, 1));
        if (r102 == null) goto L20;
        r102.recordChatChannelDialog(this.B, null);
    L20:
        s22.e r103 = ChatChannelUtils.b(RoomContext.a.c(r101, null, this.D, 1));
        if (r103 == null) goto L23;
        r103.removeListener(this.C);
    L23:
        boolean r104 = ((LiveSwitchButton) findViewById(R.id.member_invite_setting_switch)).isChecked();
        if (((Boolean) this.E.z().f64752a).booleanValue() == r104) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == false) goto L37;
        s22.e r106 = ChatChannelUtils.b(RoomContext.a.c(r101, null, this.D, 1));
        if (r106 == null) goto L38;
        r106.updateSetting(this.E.getChannelId(), false, r104);
        return;
    L38:
        return;
    L37:
        return;
    L26:
        r105 = false;
        goto L27
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r107 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r107 == null) goto L16;
        com.bytedance.crash.d.d(r107, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
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
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        RoomContext.a r100 = RoomContext.Companion;
        s22.e r101 = ChatChannelUtils.b(RoomContext.a.c(r100, null, this.D, 1));
        if (r101 == null) goto L10;
        r101.recordChatChannelDialog(this.B, this);
    L10:
        s22.e r102 = ChatChannelUtils.b(RoomContext.a.c(r100, null, this.D, 1));
        if (r102 == null) goto L17;
        r102.addListener(this.C);
        return;
    L17:
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        int r101 = e62.a.f471117a;
        e62.a.a(getWindow(), findViewById(R.id.owner_setting_panel_container), RoomContext.a.c(RoomContext.Companion, null, 0, 3));
        r3.a(findViewById(R.id.back_iv), "返回");
        ((ImageView) findViewById(R.id.back_iv)).setOnClickListener(new p(this));
        if (this.E.e() == false) goto L5;
        final LiveSwitchButton r102 = (LiveSwitchButton) findViewById(R.id.member_invite_setting_switch);
        r102.setOnClickListener(x0.a(new ChatChannelOwnerSettingDialog$initView$$inlined$apply$lambda$1(r102, this)));
        r102.setEnableTouchEvent(false);
        r102.setAlpha(0.3f);
    L6:
        ((TextView) findViewById(R.id.disband_channel)).setOnClickListener(x0.a(new ChatChannelOwnerSettingDialog$initView$3(this)));
        ((TextView) findViewById(R.id.quit_channel)).setOnClickListener(x0.a(new ChatChannelOwnerSettingDialog$initView$4(this)));
        int r103 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.f133002a;
        boolean r104 = ((Boolean) this.E.d().f64752a).booleanValue();
        boolean r105 = ((Boolean) this.E.z().f64752a).booleanValue();
        HashMap r106 = new HashMap();
        String r107 = "1";
        if (r104 == false) goto L9;
        Object r108 = "1";
    L10:
        r106.put("voice_state", r108);
        if (r105 == true) goto L14;
        r107 = "0";
    L14:
        r106.put("member_invite_state", r107);
        r106.put(IPerformanceManager.Params.is_anchor, "0");
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.l("livesdk_match_chat_channel_set_panel_show", r106);
        return;
    L9:
        r108 = "0";
        goto L10
    L5:
        ((LiveSwitchButton) findViewById(R.id.member_invite_setting_switch)).setChecked(((Boolean) this.E.z().f64752a).booleanValue());
        goto L6
    }

    public ChatChannelOwnerSettingDialog(Context r100, long r101, s22.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "chatChannel");
        super(r100, false);
        this.D = r101;
        this.E = r102;
        this.B = "ChatChannelOwnerSettingDialog";
        this.C = new a(this);
    }
}
