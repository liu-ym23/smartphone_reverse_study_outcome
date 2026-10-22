package a2a;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.ss.android.update.IUpdateConfig;
import kotlin.jvm.internal.Intrinsics;
import yhc.f0;
import yhc.j0;
import yhc.v;

/* JADX INFO: loaded from: classes31.dex */
public final class i extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.android.update.d f1458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences f1459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IUpdateConfig f1460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f1461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f1462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f1463h;

    public static final class a {
    }

    static {
    }

    public final void a() {
        this.f1458c.n(this.f1456a);
        cancel();
        if (this.f1458c.P() == false) goto L12;
        IUpdateConfig r100 = this.f1460e;
        if (r100 == null) goto L14;
        v r101 = r100.getUpdateConfig();
        if (r101 == null) goto L15;
        yhc.j r102 = r101.b();
        if (r102 == null) goto L16;
        r102.a(getContext());
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L12:
        j0.a.f567706a.b();
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        SharedPreferences r100 = this.f1459d;
        if (r100 == null) goto L10;
        SharedPreferences.Editor r101 = r100.edit();
        r101.putLong("last_show_timestamp", System.currentTimeMillis());
        r101.apply();
    L10:
        this.f1458c.e0(true);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        a();
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
        this.f1462g = (TextView) findViewById(R.id.tvDialogCancel);
        this.f1461f = (TextView) findViewById(R.id.btnDialogConfirm);
        this.f1463h = (TextView) findViewById(R.id.tvDialogContent);
        this.f1458c = com.ss.android.update.d.x();
        this.f1460e = f0.f567692a;
        this.f1459d = getContext().getSharedPreferences("upgrade_dialog.prefs", 0);
        TextView r103 = this.f1461f;
        if (r103 == null) goto L8;
        r103.setText(getContext().getResources().getString(R.string.larus_update_popup_agree));
    L8:
        String r104 = this.f1458c.K();
        if (this.f1458c.I() == null) goto L11;
        r104 = this.f1458c.u();
    L11:
        if (r104 != null) goto L13;
    L16:
        if (r101 == true) goto L21;
        TextView r105 = this.f1463h;
        if (r105 == null) goto L21;
        r105.setText(r104);
    L21:
        e1.d(this.f1462g, new g(this));
        TextView r106 = this.f1461f;
        if (r106 == null) goto L25;
        e1.d(r106, new h(this));
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
        Logger.d("UpdateDialog", "重新布局");
        return;
    L13:
        if (r102.getWidth() == 0) goto L14;
        return;
    L17:
        return;
    }

    public i(Context r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f1456a = r101;
        this.f1457b = r102;
        this.f1458c = com.ss.android.update.d.x();
    }
}
