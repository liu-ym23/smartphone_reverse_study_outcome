package com.bytedance.android.gamecp.common.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes44.dex */
public final class r extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f57128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f57129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f57130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f57131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Button f57132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f57133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f57134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Button f57135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Button f57136i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Button f57137j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f57138k;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f57139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f57140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f57141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f57142d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f57143e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f57144f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public DialogInterface.OnClickListener f57145g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f57146h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public DialogInterface.OnClickListener f57147i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public DialogInterface.OnCancelListener f57148j;

        public a() {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r100 = getWindow();
        if (r100 == null) goto L14;
        WindowManager.LayoutParams r101 = new WindowManager.LayoutParams();
        r101.copyFrom(r100.getAttributes());
        r101.width = (int) this.f57128a.getResources().getDimension(R.dimen.gamecp_room_center_dialog_width);
        r101.height = -2;
        r100.setAttributes(r101);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r100) {
        if (1 != r100.getAction()) goto L19;
        Context r101 = getContext();
        int r102 = (int) r100.getX();
        int r103 = (int) r100.getY();
        int r104 = ViewConfiguration.get(r101).getScaledWindowTouchSlop();
        if (getWindow() == null) goto L19;
        if (a(getWindow()) == null) goto L19;
        View r105 = a(getWindow());
        int r106 = -r104;
        if (r102 < r106) goto L19;
        if (r103 < r106) goto L19;
        if (r102 > (r105.getWidth() + r104)) goto L19;
        if (r103 > (r105.getHeight() + r104)) goto L19;
    L19:
        return super.onTouchEvent(r100);
    }

    public r(Context r100, a r101) {
        super(r100, R.style.gamecp_live_dialog);
        this.f57128a = r100;
        r101.getClass();
        View r102 = LayoutInflater.from(getContext()).inflate(R.layout.gamecp_dialog_room_center_layout, null);
        this.f57129b = r102;
        setContentView(r102);
        int r103 = r101.f57140b;
        RelativeLayout r104 = (RelativeLayout) r102.findViewById(R.id.top_image_container);
        LiveRoundImageView r105 = (LiveRoundImageView) r102.findViewById(R.id.top_image);
        HSImageView r106 = (HSImageView) r102.findViewById(R.id.top_close);
        this.f57130c = (TextView) r102.findViewById(R.id.room_center_title);
        this.f57131d = (TextView) r102.findViewById(R.id.room_center_content);
        this.f57132e = (Button) r102.findViewById(R.id.room_center_button);
        this.f57133f = (TextView) r102.findViewById(R.id.room_center_bottom_tip);
        this.f57134g = (LinearLayout) r102.findViewById(R.id.room_center_button_layout);
        this.f57135h = (Button) r102.findViewById(R.id.room_center_button_left);
        this.f57136i = (Button) r102.findViewById(R.id.room_center_button_right);
        this.f57137j = (Button) r102.findViewById(R.id.room_center_button_middle);
        this.f57138k = r102.findViewById(R.id.middle_btn_line);
        if (r103 != 1) goto L5;
        this.f57132e.setVisibility(0);
        this.f57134g.setVisibility(8);
    L11:
        this.f57130c.setText(r101.f57141c);
        if (TextUtils.isEmpty(r101.f57141c) == false) goto L14;
        this.f57130c.setVisibility(8);
    L15:
        this.f57131d.setText(r101.f57142d);
        this.f57131d.setGravity(r101.f57143e);
        if (TextUtils.isEmpty(r101.f57142d) == false) goto L18;
        this.f57131d.setVisibility(8);
    L19:
        int r107 = r101.f57140b;
        if (r107 != 1) goto L22;
        this.f57132e.setVisibility(0);
        this.f57134g.setVisibility(8);
        this.f57132e.setText(null);
        this.f57132e.setOnClickListener(new l(this, r101));
    L30:
        if (TextUtils.isEmpty(null) == true) goto L32;
        this.f57133f.setVisibility(0);
        this.f57133f.setText(null);
        this.f57133f.setOnClickListener(null);
    L32:
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        setOnCancelListener(r101.f57148j);
        setOnDismissListener(null);
        setOnShowListener(null);
        return;
    L22:
        if (r107 != 2) goto L27;
        this.f57132e.setVisibility(8);
        Button r108 = this.f57137j;
        if (r108 == null) goto L26;
        r108.setVisibility(8);
        this.f57138k.setVisibility(8);
    L26:
        this.f57134g.setVisibility(0);
        this.f57135h.setText(r101.f57144f);
        this.f57136i.setText(r101.f57146h);
        this.f57135h.setOnClickListener(new m(this, r101));
        this.f57136i.setOnClickListener(new n(this, r101));
        goto L30
    L27:
        if (r107 != 3) goto L30;
        this.f57132e.setVisibility(8);
        this.f57134g.setVisibility(0);
        this.f57135h.setText(r101.f57144f);
        this.f57137j.setText(null);
        this.f57136i.setText(r101.f57146h);
        this.f57135h.setOnClickListener(new o(this, r101));
        this.f57137j.setOnClickListener(new p(this, r101));
        this.f57136i.setOnClickListener(new q(this, r101));
        goto L30
    L18:
        this.f57131d.setVisibility(0);
        goto L19
    L14:
        this.f57130c.setVisibility(0);
        goto L15
    L5:
        if (r103 != 2) goto L9;
        this.f57132e.setVisibility(8);
        this.f57134g.setVisibility(0);
        Button r109 = this.f57137j;
        if (r109 == null) goto L11;
        r109.setVisibility(8);
        this.f57138k.setVisibility(8);
        goto L11
    L9:
        if (r103 != 3) goto L11;
        this.f57132e.setVisibility(8);
        this.f57134g.setVisibility(0);
        goto L11
    }
}
