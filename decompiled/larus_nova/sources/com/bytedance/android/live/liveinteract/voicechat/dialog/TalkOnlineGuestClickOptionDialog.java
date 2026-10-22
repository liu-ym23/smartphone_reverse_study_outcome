package com.bytedance.android.live.liveinteract.voicechat.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/dialog/TalkOnlineGuestClickOptionDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "Option", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TalkOnlineGuestClickOptionDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f80044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f80045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Option, Unit> f80046c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/dialog/TalkOnlineGuestClickOptionDialog$Option;", "", "CHANGE_POSITION", "INVITE_FRIENDS", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Option extends Enum<Option> {
        public static final Option CHANGE_POSITION = null;
        public static final Option INVITE_FRIENDS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Option[] f80047a = null;

        static {
            Option r100 = new Option("CHANGE_POSITION", 0);
            CHANGE_POSITION = r100;
            Option r101 = new Option("INVITE_FRIENDS", 1);
            INVITE_FRIENDS = r101;
            f80047a = new Option[]{r100, r101};
        }

        public static Option valueOf(String r100) {
            return (Option) r27.a.a(Option.class, r100);
        }

        public static Option[] values() {
            return (Option[]) f80047a.clone();
        }

        public Option(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TalkOnlineGuestClickOptionDialog f80048a;

        public a(TalkOnlineGuestClickOptionDialog r100) {
            this.f80048a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f80048a.f80046c.invoke(Option.CHANGE_POSITION);
            TalkOnlineGuestClickOptionDialog r101 = this.f80048a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TalkOnlineGuestClickOptionDialog f80049a;

        public b(TalkOnlineGuestClickOptionDialog r100) {
            this.f80049a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f80049a.f80046c.invoke(Option.INVITE_FRIENDS);
            TalkOnlineGuestClickOptionDialog r101 = this.f80049a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TalkOnlineGuestClickOptionDialog f80050a;

        public c(TalkOnlineGuestClickOptionDialog r100) {
            this.f80050a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            TalkOnlineGuestClickOptionDialog r101 = this.f80050a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_interact_voice_chat_online_guest_click_option;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Boolean r101 = this.f80044a;
        if (r101 != null) goto L5;
    L9:
        Boolean r102 = this.f80045b;
        if (r102 != null) goto L12;
    L16:
        View r103 = findViewById(R.id.tv_change_position);
        if (r103 == null) goto L19;
        r103.setOnClickListener(new a(this));
    L19:
        View r104 = findViewById(R.id.tv_invite_friends);
        if (r104 == null) goto L22;
        r104.setOnClickListener(new b(this));
    L22:
        View r105 = findViewById(R.id.tv_cancel);
        if (r105 == null) goto L26;
        r105.setOnClickListener(new c(this));
        return;
    L26:
        return;
    L12:
        if (r102.booleanValue() == true) goto L16;
        View r106 = findViewById(R.id.tv_invite_friends);
        if (r106 == null) goto L16;
        r106.setVisibility(8);
        goto L16
    L5:
        if (r101.booleanValue() == true) goto L9;
        View r107 = findViewById(R.id.tv_change_position);
        if (r107 == null) goto L9;
        r107.setVisibility(8);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TalkOnlineGuestClickOptionDialog(Context r100, Boolean r101, Boolean r102, Function1<? super Option, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "callback");
        super(r100);
        this.f80044a = r101;
        this.f80045b = r102;
        this.f80046c = r103;
    }
}
