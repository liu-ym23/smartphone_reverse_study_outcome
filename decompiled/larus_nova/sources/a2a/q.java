package a2a;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.update.IUpdateConfig;
import com.ss.android.update.OnUpdateStatusChangedListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import yhc.f0;
import yhc.v;

/* JADX INFO: loaded from: classes31.dex */
public final class q extends Dialog implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHandler f1475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.ss.android.update.d f1476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IUpdateConfig f1477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r f1478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f1479g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f1480h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f1481i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f1482j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f1483k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ProgressBar f1484l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public yhc.a f1485m;

    public static final class a {
    }

    static {
    }

    public final void b() {
        yhc.a r100 = this.f1485m;
        int r101 = r100.f567683c;
        int r102 = 100;
        if (r101 == 0) goto L34;
        if (r101 == 1) goto L34;
        if (r101 == 2) goto L23;
        if (r101 == 3) goto L11;
        return;
    L11:
        if (this.f1474b == false) goto L13;
        a(false);
    L13:
        TextView r103 = this.f1479g;
        if (r103 == null) goto L16;
        r103.setText(getContext().getResources().getString(R.string.larus_update_download_completed));
    L16:
        TextView r104 = this.f1480h;
        if (r104 == null) goto L19;
        r104.setText(getContext().getResources().getString(R.string.larus_update_popup_install));
    L19:
        ProgressBar r105 = this.f1484l;
        if (r105 == null) goto L63;
        r105.setProgress(100);
        return;
    L63:
        return;
    L23:
        if (this.f1474b == false) goto L25;
        a(false);
    L25:
        TextView r106 = this.f1479g;
        if (r106 == null) goto L28;
        r106.setText(getContext().getResources().getString(R.string.larus_update_download_failed));
    L28:
        TextView r107 = this.f1480h;
        if (r107 == null) goto L31;
        r107.setText(getContext().getResources().getString(R.string.larus_update_popup_retry));
    L31:
        ProgressBar r108 = this.f1484l;
        if (r108 == null) goto L65;
        r108.setProgress(0);
        return;
    L65:
        return;
    L34:
        int r109 = r100.f567681a;
        int r110 = r100.f567682b;
        if (r109 < 0) goto L42;
        if (r110 <= 0) goto L42;
        int r111 = (int) ((r109 / r110) * 100);
        if (r111 > 100) goto L43;
        r102 = r111;
    L43:
        TextView r112 = this.f1479g;
        if (r112 == null) goto L47;
        r112.setText(getContext().getResources().getString(R.string.larus_update_popup_downloading) + ' ' + r102 + '%');
    L47:
        if (com.ss.android.update.d.x().P() == false) goto L49;
        int r113 = R.string.larus_update_popup_quit;
    L51:
        if (this.f1474b == false) goto L53;
        a(!com.ss.android.update.d.x().P());
    L53:
        TextView r114 = this.f1480h;
        if (r114 == null) goto L56;
        r114.setText(getContext().getResources().getString(r113));
    L56:
        ProgressBar r115 = this.f1484l;
        if (r115 != null) goto L59;
        return;
    L59:
        if (24 > Build.VERSION.SDK_INT) goto L61;
        r115.setProgress(r102, true);
        return;
    L61:
        r115.setProgress(r102);
        return;
    L49:
        r113 = R.string.larus_toast_confirm;
    L42:
        r102 = 0;
        goto L43
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        if (com.ss.android.update.d.x().P() == false) goto L12;
        IUpdateConfig r100 = this.f1477e;
        if (r100 == null) goto L13;
        v r101 = r100.getUpdateConfig();
        if (r101 == null) goto L14;
        yhc.j r102 = r101.b();
        if (r102 == null) goto L15;
        r102.a(getContext());
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void a(boolean r100) {
        LinearLayout r101 = this.f1483k;
        int r102 = 0;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        int r103 = 0;
    L7:
        r101.setVisibility(r103);
        goto L8
    L6:
        r103 = 8;
    L8:
        TextView r104 = this.f1480h;
        if (r104 == null) goto L14;
        if (r100 == false) goto L12;
        r102 = 8;
    L12:
        r104.setVisibility(r102);
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        int r101 = r100.what;
        if (r101 != 1) goto L5;
        Object r102 = r100.obj;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.update.DownloadInfo");
        this.f1485m = (yhc.a) r102;
        b();
        return;
    L5:
        if (r101 != 2) goto L11;
        Object r103 = r100.obj;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.ss.android.update.DownloadInfo");
        this.f1485m = (yhc.a) r103;
        b();
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        requestWindowFeature(1);
        setContentView(R.layout.larus_grace_force_update_progress_dialog);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setBackgroundDrawableResource(R.drawable.transparent);
        r101.setLayout(-1, -2);
        r101.setGravity(17);
        r101.setWindowAnimations(R.style.update_dialog_animation);
    L5:
        setCanceledOnTouchOutside(false);
        this.f1479g = (TextView) findViewById(R.id.tvDialogTitle);
        this.f1480h = (TextView) findViewById(R.id.tv_update_hint);
        this.f1484l = (ProgressBar) findViewById(R.id.updateProgressBar);
        if (this.f1474b == false) goto L8;
        this.f1481i = (TextView) findViewById(R.id.btn_update_cancel);
        this.f1482j = (TextView) findViewById(R.id.btn_update_pause);
        this.f1483k = (LinearLayout) findViewById(R.id.layout_user_action);
        a(!com.ss.android.update.d.x().P());
        setCanceledOnTouchOutside(true ^ com.ss.android.update.d.x().P());
        FLogger.f375446a.d("ForceUpdateProcessDialog", "initUI, " + this.f1473a + ", " + this + ", " + this.f1479g + ", " + this.f1480h + ", " + this.f1481i + ", " + this.f1482j);
    L8:
        com.ss.android.update.d r102 = com.ss.android.update.d.x();
        this.f1476d = r102;
        this.f1477e = f0.f567692a;
        r r103 = new r(this);
        this.f1478f = r103;
        monitor-enter(r102);
        List<OnUpdateStatusChangedListener> r104 = r102.f455265g0;     // Catch: Throwable -> L23
        monitor-enter(r104);     // Catch: Throwable -> L23
        ((ArrayList) r102.f455265g0).add(r103);     // Catch: Throwable -> L20
        monitor-exit(r104);     // Catch: Throwable -> L20
        monitor-exit(r102);     // Catch: Throwable -> L23
        setOnDismissListener(new m(this));
        if (this.f1474b == false) goto L18;
        e1.b(this.f1481i, new n(this));
        e1.b(this.f1482j, new o(this));
    L18:
        e1.b(this.f1480h, new p(this));
        this.f1476d.h0(false);
        com.ss.android.update.d.x().E(this.f1485m);
        b();
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
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
        Logger.d("ForceUpdateProcessDialog", "request layout again");
        return;
    L13:
        if (r102.getWidth() == 0) goto L14;
        return;
    L17:
        return;
    }

    public q(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f1473a = r100;
        this.f1474b = r101;
        this.f1475c = new WeakHandler(this);
        this.f1476d = com.ss.android.update.d.x();
        this.f1485m = new yhc.a();
    }
}
