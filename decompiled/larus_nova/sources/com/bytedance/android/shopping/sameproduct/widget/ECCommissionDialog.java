package com.bytedance.android.shopping.sameproduct.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/widget/ECCommissionDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCommissionDialog extends AppCompatDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f182452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f182453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f182454c;

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Context r100 = getContext();
        Context r101 = null;
        if ((r100 instanceof Activity) == true) goto L5;
        r100 = null;
    L5:
        Activity r102 = (Activity) r100;
        if (r102 != null) goto L8;
    L9:
        Context r103 = getContext();
        if ((r103 instanceof Activity) == false) goto L13;
        r101 = r103;
    L13:
        Activity r104 = (Activity) r101;
        if (r104 != null) goto L16;
    L18:
        Handler r105 = DialogLancet.resolveDialogHandler(this);
        if (r105 != null) goto L21;
    L23:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L26 Exception -> L28
    L32:
        DialogLancet.afterDialogDismiss(this);
        return;
    L28:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L26
        Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L26
        if (r106 == null) goto L32;
        d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L21:
        if (Looper.myLooper() == r105.getLooper()) goto L23;
        r105.post(DialogLancet.createDismissRunnable(this));
        return;
    L16:
        if (r104.isDestroyed() != true) goto L18;
        return;
    L8:
        if (r102.isFinishing() != true) goto L9;
    }

    public ECCommissionDialog(Context r100) {
        super(r100);
        setContentView(R.layout.ec_commerce_same_product_commission_dialog_layout);
        this.f182452a = (TextView) findViewById(R.id.ec_commission_dialog_tv_title);
        this.f182453b = (TextView) findViewById(R.id.ec_commission_dialog_tv_content);
        TextView r101 = (TextView) findViewById(R.id.ec_commission_dialog_tv_button_text);
        this.f182454c = r101;
        if (r101 == null) goto L5;
        r101.setOnClickListener(this);
    L5:
        setCanceledOnTouchOutside(false);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getId() != R.id.ec_commission_dialog_tv_button_text) goto L26;
        Handler r101 = DialogLancet.resolveDialogHandler(this);
        if (r101 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r102 == null) goto L19;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L8:
        if (Looper.myLooper() == r101.getLooper()) goto L10;
        r101.post(DialogLancet.createDismissRunnable(this));
        return;
    }
}
