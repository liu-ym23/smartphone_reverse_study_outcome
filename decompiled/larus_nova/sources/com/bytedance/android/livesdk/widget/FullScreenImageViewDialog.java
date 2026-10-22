package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.browser.jsbridge.newmethods.s8;
import com.bytedance.android.livesdk.widget.crop.PinchImageView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes11.dex */
public class FullScreenImageViewDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f160869d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PinchImageView f160870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f160871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f160872c;

    public interface a {
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        I0(this);
    }

    public FullScreenImageViewDialog(Context r100) {
        super(r100, R.style.ttlive_FullScreenBlackDialog);
    }

    public static void I0(FullScreenImageViewDialog r100) {
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

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setCancelable(false);
        RelativeLayout r101 = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.ttlive_fullscreen_image_view_dialog, null);
        PinchImageView r102 = (PinchImageView) r101.findViewById(R.id.pinch_image_view);
        this.f160870a = r102;
        r102.setOnClickListener(new w(this));
        Bitmap r103 = this.f160871b;
        if (r103 == null) goto L5;
        this.f160870a.setImageBitmap(r103);
        this.f160871b = null;
    L5:
        setContentView(r101);
        a r104 = this.f160872c;
        if (r104 == null) goto L9;
        ((s8) r104).f63652a.finishWithSuccess();
        this.f160872c = null;
        return;
    }
}
