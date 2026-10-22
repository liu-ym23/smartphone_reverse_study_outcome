package com.bytedance.android.livesdk.common;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/common/BottomConfirmAlertDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BottomConfirmAlertDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f119657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f119658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f119659c;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomConfirmAlertDialog f119660a;

        public b(BottomConfirmAlertDialog r100) {
            this.f119660a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            BottomConfirmAlertDialog r101 = this.f119660a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
        L17:
            this.f119660a.getClass();
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
            goto L17
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomConfirmAlertDialog f119661a;

        public c(BottomConfirmAlertDialog r100) {
            this.f119661a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            BottomConfirmAlertDialog r101 = this.f119661a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
        L17:
            this.f119661a.getClass();
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
            goto L17
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public int getLayoutId() {
        return R.layout.ttlive_dialog_bottom_confirm;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        TextView r101 = (TextView) findViewById(R.id.title_view);
        if (r101 == null) goto L5;
        r101.setText(this.f119657a);
    L5:
        TextView r102 = (TextView) findViewById(R.id.negativeBtn);
        if (r102 == null) goto L8;
        r102.setText(this.f119659c);
        r102.setOnClickListener(new b(this));
    L8:
        TextView r103 = (TextView) findViewById(R.id.positiveBtn);
        if (r103 == null) goto L12;
        r103.setText(this.f119658b);
        r103.setOnClickListener(new c(this));
        return;
    }

    public BottomConfirmAlertDialog(Context r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "titleText");
        Intrinsics.checkNotNullParameter(r102, "positiveText");
        Intrinsics.checkNotNullParameter(r103, "negativeText");
        super(r100);
        this.f119657a = r101;
        this.f119658b = r102;
        this.f119659c = r103;
    }
}
