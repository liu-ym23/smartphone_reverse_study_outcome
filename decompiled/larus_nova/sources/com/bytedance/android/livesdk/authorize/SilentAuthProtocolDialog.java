package com.bytedance.android.livesdk.authorize;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/authorize/SilentAuthProtocolDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class SilentAuthProtocolDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f104196b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f104197a;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SilentAuthProtocolDialog f104198a;

        public a(SilentAuthProtocolDialog r100) {
            this.f104198a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SilentAuthProtocolDialog r101 = this.f104198a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
        L17:
            String r103 = p.f104219a;
            p.e(false, true, "agreement", this.f104198a.f104197a);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r104 == null) goto L16;
            com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
            goto L17
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SilentAuthProtocolDialog f104199a;

        public b(SilentAuthProtocolDialog r100) {
            this.f104199a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SilentAuthProtocolDialog r101 = this.f104199a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
        L17:
            SilentAuthProtocolDialog r103 = this.f104199a;
            int r104 = SilentAuthProtocolDialog.f104196b;
            r103.getClass();
            com.bytedance.android.livesdk.user.f r105 = ((IUserService) jc1.k.n(IUserService.class)).user();
            if (r105.isLogin() == true) goto L20;
            com.bytedance.android.livesdk.user.l.a r106 = new com.bytedance.android.livesdk.user.l.a();
            r106.f158687c = -1;
            r106.f158688d = "silent_auth_guide_agreement";
            com.bytedance.android.livesdk.user.l r107 = new com.bytedance.android.livesdk.user.l(r106);
            r105.login(r103.getContext(), r107).subscribe(new v(r103), w.f104226a);
        L20:
            String r108 = p.f104219a;
            p.e(true, true, "agreement", this.f104199a.f104197a);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r109 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r109 == null) goto L16;
            com.bytedance.crash.d.d(r109, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
            goto L17
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_silent_auth_protocol;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        String r100 = p.f104219a;
        p.f("agreement", this.f104197a);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        setCanceledOnTouchOutside(true);
        View r111 = findViewById(R.id.ivClose);
        if (r111 == null) goto L5;
        r111.setOnClickListener(new a(this));
    L5:
        TextView r112 = (TextView) findViewById(R.id.tvAuthTitle);
        if (r112 == null) goto L8;
        r112.setText(getContext().getString(R.string.ttlive_dy_auth_protocol));
    L8:
        TextView r100 = (TextView) findViewById(R.id.btnConfirm);
        if (r100 == null) goto L11;
        r100.setText(getContext().getString(R.string.ttlive_dy_auth_button_agree_and_continue));
    L11:
        String r101 = getContext().getString(R.string.ttlive_dy_auth_protocol_dialog_content);
        String r102 = getContext().getString(R.string.ttlive_auth_guide_dy_user_agreement);
        String r103 = getContext().getString(R.string.ttlive_auth_guide_dy_privacy_policy);
        int r104 = StringsKt.indexOf$default(r101, r102, 0, false, 6, null);
        int r105 = StringsKt.indexOf$default(r101, r103, 0, false, 6, null);
        SpannableStringBuilder r106 = new SpannableStringBuilder(r101);
        SettingKey<com.bytedance.android.livesdk.config.v> r107 = LiveConfigSettingKeys.ACCOUNT_AUTH_GUIDE;
        String r108 = r107.getValue().b();
        String r109 = r107.getValue().a();
        r106.setSpan(new we1.c(getContext(), r109), r105, r103.length() + r105, 33);
        r106.setSpan(new we1.c(getContext(), r108), r104, r102.length() + r104, 33);
        r106.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.ttlive_std_link_4)), r105, r103.length() + r105, 33);
        r106.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.ttlive_std_link_4)), r104, r102.length() + r104, 33);
        TextView r113 = (TextView) findViewById(R.id.tvAuthContent);
        if (r113 == null) goto L14;
        r113.setMovementMethod(LinkMovementMethod.getInstance());
    L14:
        TextView r114 = (TextView) findViewById(R.id.tvAuthContent);
        if (r114 == null) goto L17;
        r114.setText(r106);
    L17:
        View r115 = findViewById(R.id.btnConfirm);
        if (r115 == null) goto L21;
        r115.setOnClickListener(new b(this));
        return;
    }

    public SilentAuthProtocolDialog(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f104197a = r101;
    }
}
