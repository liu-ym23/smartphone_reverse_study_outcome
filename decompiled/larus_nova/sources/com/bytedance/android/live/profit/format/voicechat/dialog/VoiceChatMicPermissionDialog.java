package com.bytedance.android.live.profit.format.voicechat.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/dialog/VoiceChatMicPermissionDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VoiceChatMicPermissionDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TokenCert f87606b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f87607c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f87608a;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceChatMicPermissionDialog f87609a;

        public b(VoiceChatMicPermissionDialog r100) {
            this.f87609a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function1<? super Boolean, Unit> r101 = this.f87609a.f87608a;
            if (r101 == null) goto L5;
            Unit r102 = r101.invoke(Boolean.TRUE);
        L5:
            VoiceChatMicPermissionDialog r103 = this.f87609a;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L8;
        L10:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L13 Exception -> L15
        L19:
            DialogLancet.afterDialogDismiss(r103);
            return;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
            if (r105 == null) goto L19;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L8:
            if (Looper.myLooper() == r104.getLooper()) goto L10;
            r104.post(DialogLancet.createDismissRunnable(r103));
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceChatMicPermissionDialog f87610a;

        public c(VoiceChatMicPermissionDialog r100) {
            this.f87610a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function1<? super Boolean, Unit> r101 = this.f87610a.f87608a;
            if (r101 == null) goto L5;
            Unit r102 = r101.invoke(Boolean.FALSE);
        L5:
            VoiceChatMicPermissionDialog r103 = this.f87610a;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L8;
        L10:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L13 Exception -> L15
        L19:
            DialogLancet.afterDialogDismiss(r103);
            return;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
            if (r105 == null) goto L19;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L8:
            if (Looper.myLooper() == r104.getLooper()) goto L10;
            r104.post(DialogLancet.createDismissRunnable(r103));
        }
    }

    public static final class d implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceChatMicPermissionDialog f87611a;

        public d(VoiceChatMicPermissionDialog r100) {
            this.f87611a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            Function1<? super Boolean, Unit> r101 = this.f87611a.f87608a;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke(Boolean.FALSE);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_format_voice_chat_permission_dialog;
    }

    static {
        f87606b = TokenCert.Companion.with("bpea-live_format_voice_chat_audio_permission");
        f87607c = CollectionsKt.mutableListOf(new String[]{"android.permission.RECORD_AUDIO"});
    }

    public VoiceChatMicPermissionDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        View r101 = findViewById(R.id.voice_chat_permission_button);
        if (r101 == null) goto L5;
        r101.setOnClickListener(new b(this));
    L5:
        View r102 = findViewById(R.id.voice_chat_permission_dialog_close);
        if (r102 == null) goto L8;
        r102.setOnClickListener(new c(this));
    L8:
        setOnCancelListener(new d(this));
    }
}
