package com.bytedance.android.livesdk.record.admin;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.backtrack.LiveVideoPreviewView;
import com.bytedance.android.livesdk.message.model.AdminRecordMessage;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.PublishItemTextExtraInfo;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/record/admin/AdminRecordAnchorPreviewDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdminRecordAnchorPreviewDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f157047f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f157048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.record.admin.b f157049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.record.admin.a f157050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AdminRecordMessage f157051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f157052e;

    public interface a {
        void a(AdminRecordMessage r100);

        void b(AdminRecordMessage r100);

        void onDismiss();
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdminRecordAnchorPreviewDialog f157053a;

        public b(AdminRecordAnchorPreviewDialog r100) {
            this.f157053a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            AdminRecordAnchorPreviewDialog r101 = this.f157053a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
        L17:
            this.f157053a.f157052e.onDismiss();
            AdminRecordAnchorPreviewDialog r103 = this.f157053a;
            r103.f157051d.setVideoText(((EditText) r103.findViewById(R.id.mAdminRecordAnchorPreviewEt)).getText().toString());
            AdminRecordAnchorPreviewDialog r104 = this.f157053a;
            r104.f157052e.b(r104.f157051d);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r105 == null) goto L16;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
            goto L17
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdminRecordAnchorPreviewDialog f157054a;

        public c(AdminRecordAnchorPreviewDialog r100) {
            this.f157054a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ((EditText) this.f157054a.findViewById(R.id.mAdminRecordAnchorPreviewEt)).requestFocus();
            Object r101 = this.f157054a.getContext().getSystemService("input_method");
            if ((r101 instanceof InputMethodManager) == true) goto L5;
            r101 = null;
        L5:
            InputMethodManager r102 = (InputMethodManager) r101;
            if (r102 == null) goto L8;
            r102.showSoftInput(this.f157054a.findViewById(R.id.mAdminRecordAnchorPreviewEt), 0);
        L8:
            ((EditText) this.f157054a.findViewById(R.id.mAdminRecordAnchorPreviewEt)).setSelection(((EditText) this.f157054a.findViewById(R.id.mAdminRecordAnchorPreviewEt)).getText().length());
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdminRecordAnchorPreviewDialog f157055a;

        public d(AdminRecordAnchorPreviewDialog r100) {
            this.f157055a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            AdminRecordAnchorPreviewDialog r101 = this.f157055a;
            r101.f157051d.setVideoText(((EditText) r101.findViewById(R.id.mAdminRecordAnchorPreviewEt)).getText().toString());
            AdminRecordAnchorPreviewDialog r102 = this.f157055a;
            r102.f157052e.a(r102.f157051d);
            AdminRecordAnchorPreviewDialog r103 = this.f157055a;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r103);
        L17:
            this.f157055a.f157052e.onDismiss();
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r105 == null) goto L16;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r104.getLooper()) goto L7;
            r104.post(DialogLancet.createDismissRunnable(r103));
            goto L17
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_admin_record_anchor_preview;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (findViewById(R.id.mAdminRecordAnchorPreviewEt) == null) goto L9;
        Object r100 = getContext().getSystemService("input_method");
        if (r100 == null) goto L8;
        ((InputMethodManager) r100).hideSoftInputFromWindow(((EditText) findViewById(R.id.mAdminRecordAnchorPreviewEt)).getWindowToken(), 0);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L9:
        Handler r101 = DialogLancet.resolveDialogHandler(this);
        if (r101 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(this);
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r102 == null) goto L23;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        if (Looper.myLooper() == r101.getLooper()) goto L14;
        r101.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        setCancelable(false);
        ((TextView) findViewById(R.id.mAdminRecordAnchorPreviewCancel)).setOnClickListener(new b(this));
        LiveVideoPreviewView r100 = (LiveVideoPreviewView) findViewById(R.id.mAdminRecordAnchorPreviewVideoView);
        r100.S5(true);
        r100.f105170k = true;
        r100.f105171l = true;
        r100.f105172m = true;
        r100.setDataSource(this.f157051d.getVideoUrl());
        ((LinearLayout) findViewById(R.id.mAdminRecordAnchorPreviewLlEtContent)).setOnClickListener(new c(this));
        ((LinearLayout) findViewById(R.id.mAdminRecordAnchorPreviewLlPost)).setOnClickListener(new d(this));
        if (this.f157051d.getAdmin() == null) goto L5;
        String r101 = "@" + this.f157051d.getAdmin().getName();
        String r102 = "管理员" + r101 + "为你录制了一段精彩片段";
        SpannableStringBuilder r103 = new SpannableStringBuilder(r102);
        int r104 = StringsKt.indexOf$default(r102, r101, 0, false, 6, null);
        r103.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FCDB00")), r104, r101.length() + r104, 33);
        ((TextView) findViewById(R.id.mAdminRecordAnchorPreviewTvTitle)).setText(r103);
    L5:
        String r105 = this.f157051d.getVideoText();
        if (r105 != null) goto L8;
        return;
    L8:
        if (r105.length() <= 0) goto L10;
        boolean r106 = true;
    L11:
        if (r106 != true) goto L36;
        String r107 = this.f157051d.getVideoText();
        if (r107 != null) goto L15;
        r107 = "";
    L15:
        SpannableStringBuilder r108 = new SpannableStringBuilder(this.f157051d.getVideoText());
        Iterator<T> r109 = this.f157051d.getTextDescInfos().iterator();
    L17:
        if (r109.hasNext() == false) goto L23;
        PublishItemTextExtraInfo r111 = (PublishItemTextExtraInfo) r109.next();
        if (r111.getStart() < 0) goto L17;
        if (r111.getStop() > r107.length()) goto L17;
        r108.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#88FFFFFF")), r111.getStart(), r111.getStop(), 33);
        goto L17
    L23:
        ((EditText) findViewById(R.id.mAdminRecordAnchorPreviewEt)).setText(r108);
        ((EditText) findViewById(R.id.mAdminRecordAnchorPreviewEt)).addTextChangedListener(this.f157049b);
        if (r107.length() <= this.f157048a) goto L26;
        this.f157048a = r107.length();
    L26:
        ((EditText) findViewById(R.id.mAdminRecordAnchorPreviewEt)).setFilters(new InputFilter[]{this.f157050c, new InputFilter.LengthFilter(this.f157048a)});
        return;
    L36:
        return;
    L10:
        r106 = false;
        goto L11
    }

    public AdminRecordAnchorPreviewDialog(Context r100, AdminRecordMessage r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "recordMsg");
        Intrinsics.checkNotNullParameter(r102, "actionListener");
        super(r100);
        this.f157051d = r101;
        this.f157052e = r102;
        this.f157048a = 55;
        this.f157049b = new com.bytedance.android.livesdk.record.admin.b(this);
        this.f157050c = new com.bytedance.android.livesdk.record.admin.a(this);
    }
}
