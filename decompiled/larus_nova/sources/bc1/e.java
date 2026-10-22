package bc1;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Dialog f18566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f18567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f18568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f18569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f18570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f18571f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f18572a;

        @Override // java.lang.Runnable
        public final void run() {
            e r100 = this.f18572a;     // Catch: Throwable -> L7
            r100.getClass();     // Catch: Throwable -> L7
            if (r100.f18566a.isShowing() == false) goto L10;
            e.a(r100.f18566a);     // Catch: Throwable -> L7 Exception -> L12
            goto L18
        L17:
            return;
        L10:
            return;
        L18:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(e r100) {
            this.f18572a = r100;
        }
    }

    public e(Context r100) {
        this.f18570e = new Handler();
        this.f18571f = new a(this);
        LayoutInflater r101 = LayoutInflater.from(r100);
        Dialog r102 = new Dialog(r100, R.style.popuptoast_dialog);
        this.f18566a = r102;
        View r103 = r101.inflate(R.layout.liveuikit_popup_toast, null);     // Catch: Throwable -> L5
        this.f18569d = r103;     // Catch: Throwable -> L5
        this.f18567b = (ImageView) r103.findViewById(R.id.icon);     // Catch: Throwable -> L5
        this.f18568c = (TextView) r103.findViewById(R.id.text);     // Catch: Throwable -> L5
        r102.setContentView(r103);     // Catch: Throwable -> L5
        r102.getWindow().addFlags(8);     // Catch: Throwable -> L5
        r102.getWindow().addFlags(32);     // Catch: Throwable -> L5
        r102.getWindow().addFlags(16);     // Catch: Throwable -> L5
        r102.getWindow().setLayout(-2, -2);     // Catch: Throwable -> L5
        r102.getWindow().setGravity(17);     // Catch: Throwable -> L5
        return;
    }

    public static void a(Dialog r100) {
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
}
