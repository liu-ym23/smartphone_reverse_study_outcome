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
import android.widget.TextView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h5 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f113554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f113555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f113556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f113557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Button f113558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f113559f;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f113560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f113561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f113562c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f113563d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f113564e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f113565f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public CharSequence f113566g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public DialogInterface.OnClickListener f113567h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CharSequence f113568i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public DialogInterface.OnClickListener f113569j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f113570k;

        public b() {
            this.f113570k = true;
        }
    }

    static {
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
        Context r102 = this.f113554a;
        Intrinsics.checkNotNull(r102);
        r101.width = (int) r102.getResources().getDimension(R.dimen.ttlive_room_center_dialog_width);
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
        Intrinsics.checkNotNullParameter(r100, "event");
        if (1 != r100.getAction()) goto L30;
        Context r101 = getContext();
        int r102 = (int) r100.getX();
        int r103 = (int) r100.getY();
        int r104 = ViewConfiguration.get(r101).getScaledWindowTouchSlop();
        if (getWindow() == null) goto L30;
        Window r105 = getWindow();
        View r106 = null;
        if (r105 == null) goto L9;
        View r107 = a(r105);
    L10:
        if (r107 == null) goto L30;
        Window r108 = getWindow();
        if (r108 == null) goto L15;
        r106 = a(r108);
    L15:
        int r109 = -r104;
        if (r102 < r109) goto L30;
        if (r103 < r109) goto L30;
        if (r106 == null) goto L20;
        int r110 = r106.getWidth();
    L21:
        if (r102 > r110) goto L30;
        if (r106 == null) goto L25;
        int r111 = r106.getHeight();
    L26:
        if (r103 <= r111) goto L30;
        goto L30
    L25:
        r111 = r104 + 0;
        goto L26
    L20:
        r110 = r104 + 0;
        goto L21
    L9:
        r107 = null;
    L30:
        return super.onTouchEvent(r100);
    }

    public h5(Context r100, b r101) {
        super(r100, R.style.ttlive_live_dialog);
        this.f113554a = r100;
        int r102 = r101.f113562c;
        if (r102 > 0) goto L6;
        r102 = R.layout.ttlive_dialog_zero_link_room_close_layout;
    L6:
        View r103 = LayoutInflater.from(getContext()).inflate(r102, null);
        this.f113555b = r103;
        setContentView(r103);
        int r104 = r101.f113561b;
        this.f113556c = (TextView) r103.findViewById(R.id.room_center_title);
        this.f113557d = (TextView) r103.findViewById(R.id.room_center_content);
        LinearLayout r105 = (LinearLayout) r103.findViewById(R.id.room_center_button_layout);
        this.f113558e = (Button) r103.findViewById(R.id.room_center_button_left);
        this.f113559f = (Button) r103.findViewById(R.id.room_center_button_right);
        if (r104 != 1) goto L17;
        TextView r106 = this.f113557d;
        if (r106 == null) goto L11;
        r106.setTextColor(com.bytedance.android.live.core.utils.s1.h(R.color.ttlive_room_notice_dialog_details_color));
    L11:
        Drawable r107 = com.bytedance.android.live.core.utils.s1.m(R.drawable.ttlive_icon_arrow_blue);
        TextView r108 = this.f113557d;
        if (r108 == null) goto L14;
        r108.setCompoundDrawablesWithIntrinsicBounds(null, null, r107, null);
    L14:
        TextView r109 = this.f113557d;
        if (r109 == null) goto L20;
        r109.setCompoundDrawablePadding(com.bytedance.android.live.core.utils.s1.f(3.6f));
    L20:
        TextView r110 = this.f113556c;
        Intrinsics.checkNotNull(r110);
        r110.setText(r101.f113563d);
        TextView r111 = this.f113557d;
        Intrinsics.checkNotNull(r111);
        r111.setText(r101.f113564e);
        TextView r112 = this.f113557d;
        Intrinsics.checkNotNull(r112);
        r112.setGravity(r101.f113565f);
        Button r113 = this.f113558e;
        Intrinsics.checkNotNull(r113);
        r113.setText(r101.f113566g);
        Button r114 = this.f113559f;
        Intrinsics.checkNotNull(r114);
        r114.setText(r101.f113568i);
        TextView r115 = this.f113557d;
        Intrinsics.checkNotNull(r115);
        r115.setText(r101.f113564e);
        TextView r116 = this.f113557d;
        Intrinsics.checkNotNull(r116);
        r116.setGravity(r101.f113565f);
        if (TextUtils.isEmpty(r101.f113564e) == false) goto L23;
        TextView r117 = this.f113557d;
        Intrinsics.checkNotNull(r117);
        r117.setVisibility(8);
    L25:
        if (r101.f113561b != 1) goto L29;
        TextView r118 = this.f113557d;
        if (r118 == null) goto L29;
        r118.setOnClickListener(new i5(this, r101));
    L29:
        Button r119 = this.f113558e;
        if (r119 == null) goto L32;
        r119.setOnClickListener(new j5(this, r101));
    L32:
        Button r120 = this.f113559f;
        if (r120 == null) goto L35;
        r120.setOnClickListener(new k5(this, r101));
    L35:
        setCanceledOnTouchOutside(r101.f113570k);
        setCancelable(true);
        setOnCancelListener(null);
        setOnDismissListener(null);
        setOnShowListener(null);
        return;
    L23:
        TextView r121 = this.f113557d;
        Intrinsics.checkNotNull(r121);
        r121.setVisibility(0);
        goto L25
    L17:
        TextView r122 = this.f113557d;
        if (r122 == null) goto L20;
        r122.setTextColor(com.bytedance.android.live.core.utils.s1.h(R.color.ttlive_room_notice_dialog_minor_textcolor));
        goto L20
    }
}
