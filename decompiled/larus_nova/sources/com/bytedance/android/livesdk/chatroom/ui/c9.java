package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
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
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes8.dex */
public final class c9 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f112666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RelativeLayout f112667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LiveRoundImageView f112668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f112669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f112670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f112671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f112672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Button f112673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f112674i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f112675j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Button f112676k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Button f112677l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Button f112678m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f112679n;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f112680a;

        public final void e() {
            b r100 = this.f112680a;
            c9 r101 = new c9(r100.f112681a, r100);
            if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r101);
            return;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r101);
            r101.show();
            DialogLancet.afterDialogShow(r101);
        }

        public a(Context r100) {
            b r101 = new b();
            this.f112680a = r101;
            r101.f112681a = r100;
            r101.f112682b = 2;
        }

        public final void a(int r100) {
            this.f112680a.f112686f = this.f112680a.f112681a.getText(r100);
        }

        public final void d(int r100) {
            this.f112680a.f112685e = this.f112680a.f112681a.getText(r100);
        }

        public final void b(int r100, DialogInterface.OnClickListener r101) {
            b r102 = this.f112680a;
            r102.f112690j = r102.f112681a.getText(r100);
            this.f112680a.f112691k = r101;
        }

        public final void c(int r100, DialogInterface.OnClickListener r101) {
            b r102 = this.f112680a;
            r102.f112692l = r102.f112681a.getText(r100);
            this.f112680a.f112693m = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f112681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f112682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f112683c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f112684d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f112685e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f112686f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f112687g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f112688h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public DialogInterface.OnClickListener f112689i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CharSequence f112690j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f112691k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f112692l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public DialogInterface.OnClickListener f112693m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public DialogInterface.OnCancelListener f112694n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public DialogInterface.OnShowListener f112695o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f112696p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f112697q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f112698r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f112699s;

        public b() {
            this.f112696p = true;
            this.f112697q = true;
            this.f112698r = 0;
            this.f112699s = 0;
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
        r101.width = (int) this.f112666a.getResources().getDimension(R.dimen.ttlive_room_center_dialog_width);
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

    public c9(Context r100) {
        super(r100, R.style.ttlive_live_dialog);
        this.f112666a = r100;
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_room_center_layout, null);
        this.f112670e = r101;
        setContentView(r101);
        b(1);
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

    public final void b(int r100) {
        this.f112667b = (RelativeLayout) this.f112670e.findViewById(R.id.top_image_container);
        this.f112668c = (LiveRoundImageView) this.f112670e.findViewById(R.id.top_image);
        this.f112669d = (HSImageView) this.f112670e.findViewById(R.id.top_close);
        this.f112671f = (TextView) this.f112670e.findViewById(R.id.room_center_title);
        this.f112672g = (TextView) this.f112670e.findViewById(R.id.room_center_content);
        this.f112673h = (Button) this.f112670e.findViewById(R.id.room_center_button);
        this.f112674i = (TextView) this.f112670e.findViewById(R.id.room_center_bottom_tip);
        this.f112675j = (LinearLayout) this.f112670e.findViewById(R.id.room_center_button_layout);
        this.f112676k = (Button) this.f112670e.findViewById(R.id.room_center_button_left);
        this.f112677l = (Button) this.f112670e.findViewById(R.id.room_center_button_right);
        this.f112678m = (Button) this.f112670e.findViewById(R.id.room_center_button_middle);
        this.f112679n = this.f112670e.findViewById(R.id.middle_btn_line);
        if (r100 != 1) goto L6;
        this.f112673h.setVisibility(0);
        this.f112675j.setVisibility(8);
        return;
    L6:
        if (r100 != 2) goto L11;
        this.f112673h.setVisibility(8);
        this.f112675j.setVisibility(0);
        Button r101 = this.f112678m;
        if (r101 == null) goto L15;
        r101.setVisibility(8);
        this.f112679n.setVisibility(8);
        return;
    L15:
        return;
    L11:
        if (r100 != 3) goto L17;
        this.f112673h.setVisibility(8);
        this.f112675j.setVisibility(0);
        return;
    }

    public final void c(CharSequence r100) {
        this.f112672g.setText(r100);
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f112672g.setVisibility(0);
        return;
    }

    public final void d(CharSequence r100) {
        this.f112671f.setText(r100);
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f112671f.setVisibility(0);
        return;
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

    public c9(Context r100, b r101) {
        super(r100, R.style.ttlive_live_dialog);
        this.f112666a = r100;
        int r102 = r101.f112683c;
        if (r102 > 0) goto L6;
        r102 = R.layout.ttlive_dialog_room_center_layout;
    L6:
        View r103 = LayoutInflater.from(getContext()).inflate(r102, null);
        this.f112670e = r103;
        setContentView(r103);
        b(r101.f112682b);
        this.f112671f.setText(r101.f112685e);
        if (TextUtils.isEmpty(r101.f112685e) == false) goto L9;
        this.f112671f.setVisibility(8);
    L10:
        this.f112672g.setText(r101.f112686f);
        this.f112672g.setGravity(r101.f112687g);
        if (TextUtils.isEmpty(r101.f112686f) == false) goto L13;
        this.f112672g.setVisibility(8);
    L14:
        int r104 = r101.f112682b;
        if (r104 != 1) goto L18;
        this.f112673h.setVisibility(0);
        this.f112675j.setVisibility(8);
        this.f112673h.setText(r101.f112688h);
        this.f112673h.setOnClickListener(new v8(this, r101));
    L39:
        if (r101.f112684d == null) goto L42;
        this.f112667b.setVisibility(0);
        this.f112668c.setImageDrawable(r101.f112684d);
        this.f112668c.setOnClickListener(null);
        this.f112669d.setOnClickListener(new b9(this));
    L42:
        if (TextUtils.isEmpty(null) == true) goto L44;
        this.f112674i.setVisibility(0);
        this.f112674i.setText(null);
        this.f112674i.setOnClickListener(null);
    L44:
        setCanceledOnTouchOutside(r101.f112697q);
        setCancelable(r101.f112696p);
        setOnCancelListener(r101.f112694n);
        setOnDismissListener(null);
        setOnShowListener(r101.f112695o);
        return;
    L18:
        if (r104 != 2) goto L30;
        this.f112673h.setVisibility(8);
        Button r105 = this.f112678m;
        if (r105 == null) goto L22;
        r105.setVisibility(8);
        this.f112679n.setVisibility(8);
    L22:
        this.f112675j.setVisibility(0);
        this.f112676k.setText(r101.f112690j);
        if (r101.f112698r == 0) goto L26;
        Button r106 = this.f112676k;
        r106.setTextAppearance(r106.getContext(), r101.f112698r);
    L26:
        if (r101.f112699s == 0) goto L28;
        Button r107 = this.f112677l;
        r107.setTextAppearance(r107.getContext(), r101.f112699s);
    L28:
        this.f112677l.setText(r101.f112692l);
        this.f112676k.setOnClickListener(new w8(this, r101));
        this.f112677l.setOnClickListener(new x8(this, r101));
        goto L39
    L30:
        if (r104 != 3) goto L39;
        this.f112673h.setVisibility(8);
        this.f112675j.setVisibility(0);
        this.f112676k.setText(r101.f112690j);
        this.f112678m.setText(null);
        this.f112677l.setText(r101.f112692l);
        if (r101.f112698r == 0) goto L35;
        Button r108 = this.f112676k;
        r108.setTextAppearance(r108.getContext(), r101.f112698r);
    L35:
        if (r101.f112699s == 0) goto L37;
        Button r109 = this.f112677l;
        r109.setTextAppearance(r109.getContext(), r101.f112699s);
    L37:
        this.f112676k.setOnClickListener(new y8(this, r101));
        this.f112678m.setOnClickListener(new z8(this, r101));
        this.f112677l.setOnClickListener(new a9(this, r101));
        goto L39
    L13:
        this.f112672g.setVisibility(0);
        goto L14
    L9:
        this.f112671f.setVisibility(0);
        goto L10
    }
}
