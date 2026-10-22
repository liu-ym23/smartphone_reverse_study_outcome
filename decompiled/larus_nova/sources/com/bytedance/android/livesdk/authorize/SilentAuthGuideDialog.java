package com.bytedance.android.livesdk.authorize;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.auth.IAuthDialogCallback;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/authorize/SilentAuthGuideDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class SilentAuthGuideDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f104188f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f104189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SilentAuthProtocolDialog f104190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f104191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IAuthDialogCallback f104192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.bottomguide.a f104193e;

    public static final class a implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SilentAuthGuideDialog f104194a;

        public a(SilentAuthGuideDialog r100) {
            this.f104194a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            this.f104194a.f104192d.onCancel();
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SilentAuthGuideDialog f104195a;

        public b(SilentAuthGuideDialog r100) {
            this.f104195a = r100;
        }

        public static void a(SilentAuthGuideDialog r100) {
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r102 == null) goto L10;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L8;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CheckBox r101 = (CheckBox) this.f104195a.findViewById(R.id.cbProtocol);
            if (r101 != null) goto L5;
        L10:
            a(this.f104195a);
            String r102 = p.f104219a;
            p.e(true, false, "guide", false);
            SilentAuthGuideDialog r103 = this.f104195a;
            if (r103.f104190b != null) goto L13;
            r103.f104190b = new SilentAuthProtocolDialog(r103.f104191c, false);
        L13:
            SilentAuthProtocolDialog r104 = r103.f104190b;
            if (r104 != null) goto L16;
        L36:
            SilentAuthProtocolDialog r105 = r103.f104190b;
            if (r105 != null) goto L39;
            return;
        L39:
            if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L45;
            DialogLancet.handleBlockedDialogShow(r105);
            return;
        L45:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L44
        L42:
            DialogLancet.beforeDialogShow(r105);
            r105.show();
            DialogLancet.afterDialogShow(r105);
            return;
        L16:
            if (r104.isShowing() != true) goto L36;
            SilentAuthProtocolDialog r106 = r103.f104190b;
            if (r106 == null) goto L36;
            Handler r107 = DialogLancet.resolveDialogHandler(r106);
            if (r107 != null) goto L22;
        L24:
            DialogLancet.beforeDialogDismiss(r106);
            r106.dismiss();     // Catch: Throwable -> L27 Exception -> L29
        L33:
            DialogLancet.afterDialogDismiss(r106);
            goto L36
        L27:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r106);
            throw th;
        L29:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L27
            Throwable r108 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L27
            if (r108 == null) goto L33;
            com.bytedance.crash.d.d(r108, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L27
            goto L33
        L22:
            if (Looper.myLooper() == r107.getLooper()) goto L24;
            r107.post(DialogLancet.createDismissRunnable(r106));
            goto L36
        L5:
            if (r101.isChecked() != true) goto L10;
            a(this.f104195a);
            SilentAuthGuideDialog r109 = this.f104195a;
            int r110 = SilentAuthGuideDialog.f104188f;
            r109.getClass();
            com.bytedance.android.livesdk.user.f r111 = ((IUserService) jc1.k.n(IUserService.class)).user();
            if (r111.isLogin() == true) goto L9;
            com.bytedance.android.livesdk.user.l.a r112 = new com.bytedance.android.livesdk.user.l.a();
            r112.f158687c = -1;
            r112.f158688d = "silent_auth_guide";
            com.bytedance.android.livesdk.user.l r113 = new com.bytedance.android.livesdk.user.l(r112);
            r111.login(r109.getContext(), r113).subscribe(s.f104222a, t.f104223a);
        L9:
            String r114 = p.f104219a;
            p.e(true, true, "guide", false);
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_silent_auth_confirm;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        String r100 = p.f104219a;
        p.f("guide", false);
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
        TextView r100 = (TextView) findViewById(R.id.tvAuthTitle);
        if (r100 != null) goto L5;
    L22:
        TextView r111 = (TextView) findViewById(R.id.tvAuthContent);
        if (r111 == null) goto L25;
        r111.setText(getContext().getString(R.string.ttlive_silent_auth_guide_sub_content));
    L25:
        TextView r101 = (TextView) findViewById(R.id.btnConfirm);
        if (r101 == null) goto L28;
        r101.setText(getContext().getString(R.string.ttlive_coupon_silent_auth_dialog_confirm_auth));
    L28:
        String r102 = getContext().getString(R.string.ttlive_dy_auth_protocol_dialog_content);
        String r103 = getContext().getString(R.string.ttlive_auth_guide_dy_user_agreement);
        String r104 = getContext().getString(R.string.ttlive_auth_guide_dy_privacy_policy);
        int r112 = StringsKt.indexOf$default(r102, r103, 0, false, 6, null);
        int r105 = StringsKt.indexOf$default(r102, r104, 0, false, 6, null);
        SpannableStringBuilder r106 = new SpannableStringBuilder(r102);
        SettingKey<com.bytedance.android.livesdk.config.v> r107 = LiveConfigSettingKeys.ACCOUNT_AUTH_GUIDE;
        String r108 = r107.getValue().b();
        r106.setSpan(new we1.c(getContext(), r107.getValue().a()), r105, r104.length() + r105, 33);
        r106.setSpan(new we1.c(getContext(), r108), r112, r103.length() + r112, 33);
        r106.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.ttlive_std_link_4)), r105, r104.length() + r105, 33);
        r106.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.ttlive_std_link_4)), r112, r103.length() + r112, 33);
        setOnCancelListener(new a(this));
        View r109 = findViewById(R.id.ivClose);
        if (r109 == null) goto L31;
        r109.setOnClickListener(this.f104189a);
    L31:
        View r113 = findViewById(R.id.iv_close);
        if (r113 == null) goto L34;
        r113.setOnClickListener(this.f104189a);
    L34:
        TextView r114 = (TextView) findViewById(R.id.tvProtocol);
        if (r114 == null) goto L37;
        r114.setMovementMethod(LinkMovementMethod.getInstance());
    L37:
        TextView r115 = (TextView) findViewById(R.id.tvProtocol);
        if (r115 == null) goto L40;
        r115.setText(r106);
    L40:
        View r116 = findViewById(R.id.btnConfirm);
        if (r116 == null) goto L44;
        r116.setOnClickListener(new b(this));
        return;
    L44:
        return;
    L5:
        if (this.f104193e != null) goto L7;
        String r117 = getContext().getString(R.string.ttlive_silent_auth_guide_title_default);
    L21:
        r100.setText(r117);
        goto L22
    L7:
        IMiddlewareRoomService r118 = (IMiddlewareRoomService) jc1.k.f(IMiddlewareRoomService.class);
        if (r118 == null) goto L10;
        ILiveOntologyInfoManager r119 = r118.getLiveOntologyRecord();
    L11:
        if (r119 == null) goto L20;
        String r120 = r119.getEnterFromMerge();
        if (r120 == null) goto L20;
        if (StringsKt.contains$default(r120, "ad_union", false, 2, null) != true) goto L20;
        if (r119.isAuthRewardRoom() == false) goto L19;
        r117 = this.f104193e.b();
        goto L21
    L19:
        r117 = this.f104193e.c();
    L20:
        r117 = this.f104193e.a();
        goto L21
    L10:
        r119 = null;
        goto L11
    }

    public SilentAuthGuideDialog(Context r100, NewAuthGuideManager.b r101, com.bytedance.android.livesdk.bottomguide.a r102) {
        Intrinsics.checkNotNullParameter(r100, "outContext");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f104191c = r100;
        this.f104192d = r101;
        this.f104193e = r102;
        this.f104189a = new u(this);
    }
}
