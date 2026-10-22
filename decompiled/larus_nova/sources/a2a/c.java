package a2a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.common.utility.Logger;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.update.d f1446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f1447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f1448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f1449e;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f1446b.n(true);
        cancel();
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        this.f1446b.e0(true);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        boolean r101 = true;
        requestWindowFeature(1);
        setContentView(R.layout.larus_grace_update_dialog);
        Window r102 = getWindow();
        if (r102 == null) goto L5;
        r102.setBackgroundDrawableResource(R.drawable.transparent);
        r102.setLayout(-1, -2);
        r102.setGravity(17);
        r102.setWindowAnimations(R.style.update_dialog_animation);
    L5:
        setCanceledOnTouchOutside(false);
        this.f1448d = (TextView) findViewById(R.id.tvDialogCancel);
        this.f1447c = (TextView) findViewById(R.id.btnDialogConfirm);
        this.f1449e = (TextView) findViewById(R.id.tvDialogContent);
        this.f1446b = com.ss.android.update.d.x();
        TextView r103 = this.f1447c;
        if (r103 == null) goto L8;
        r103.setText(getContext().getResources().getString(R.string.larus_update_popup_agree));
    L8:
        String r104 = this.f1446b.K();
        if (this.f1446b.I() == null) goto L11;
        r104 = this.f1446b.u();
    L11:
        if (r104 != null) goto L13;
    L16:
        if (r101 == true) goto L21;
        TextView r105 = this.f1449e;
        if (r105 == null) goto L21;
        r105.setText(r104);
    L21:
        e1.d(this.f1448d, new a2a.a(this));
        TextView r106 = this.f1447c;
        if (r106 == null) goto L25;
        e1.b(r106, new b(this));
        return;
    L25:
        return;
    L13:
        if (r104.length() == 0) goto L16;
        r101 = false;
        goto L16
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        Window r101 = getWindow();
        if (r100 == false) goto L16;
        if (r101 == null) goto L17;
        View r102 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L11;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L11;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L11:
        if (r102.getHeight() != 0) goto L13;
    L14:
        r102.requestLayout();
        Logger.d("ManualCheckUpdateDialog", "重新布局");
        return;
    L13:
        if (r102.getWidth() == 0) goto L14;
        return;
    L17:
        return;
    }

    public c(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f1445a = r101;
        this.f1446b = com.ss.android.update.d.x();
    }
}
