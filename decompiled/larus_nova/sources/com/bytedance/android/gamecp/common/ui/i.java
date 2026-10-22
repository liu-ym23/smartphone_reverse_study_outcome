package com.bytedance.android.gamecp.common.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes44.dex */
public final class i extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f56993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f56994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f56995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f56996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Animation f56997e;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f56998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f56999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f57000c;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            DialogInterface.OnClickListener r101 = this.f56998a.f57002b;
            if (r101 != null) goto L5;
            return;
        L5:
            r101.onClick(this.f57000c, this.f56999b);
        }

        public a(i r100, b r101, int r102) {
            this.f57000c = r100;
            this.f56998a = r101;
            this.f56999b = r102;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f57001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public DialogInterface.OnClickListener f57002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f57003c;

        public b() {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f57004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Context f57005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f57006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f57007d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b[] f57008e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public DialogInterface.OnCancelListener f57009f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f57010g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f57011h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Float f57012i;

        public c() {
            this.f57004a = 0;
            this.f57008e = new b[5];
            this.f57010g = true;
            this.f57011h = true;
            this.f57012i = null;
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
    L17:
        int r101 = j.f57013a - 1;
        j.f57013a = r101;
        if (r101 >= 0) goto L26;
        j.f57013a = 0;
        return;
    L26:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        j.f57013a++;
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public final void b(c r110) {
        this.f56993a = (HSImageView) findViewById(R.id.live_dialog_image);
        this.f56994b = (TextView) findViewById(R.id.live_dialog_title);
        this.f56995c = (TextView) findViewById(R.id.live_dialog_message);
        r110.getClass();
        this.f56993a.setVisibility(8);
        findViewById(R.id.live_dialog_image_block).setVisibility(8);
        int r100 = r110.f57004a;
        if (r100 == 8) goto L5;
        if (r100 == 9) goto L5;
    L6:
        CharSequence r101 = r110.f57006c;
        if (r101 == null) goto L9;
        this.f56994b.setText(r101);
        this.f56994b.setVisibility(0);
    L10:
        CharSequence r102 = r110.f57007d;
        if (r102 == null) goto L13;
        this.f56995c.setText(r102);
    L15:
        if (r110.f57012i == null) goto L23;
        ViewGroup r103 = (ViewGroup) findViewById(android.R.id.content);
        if (r103 == null) goto L23;
        View r104 = r103.getChildAt(0);
        if (r104 == null) goto L23;
        if ((r104.getBackground() instanceof GradientDrawable) == false) goto L23;
        GradientDrawable r105 = (GradientDrawable) r104.getBackground().mutate();
        r105.setCornerRadius(UIUtils.dip2Px(getContext(), r110.f57012i.floatValue()));
        r104.setBackground(r105);
    L23:
        int r106 = r110.f57004a;
        if (r106 == 0) goto L42;
        if (4 == r106) goto L42;
        if (8 == r106) goto L42;
        if (9 == r106) goto L42;
        if (5 == r106) goto L42;
        if (6 == r106) goto L42;
        if (7 == r106) goto L42;
        if (1 != r106) goto L40;
        b[] r111 = r110.f57008e;
        if (r111[2] == null) goto L36;
    L48:
        boolean r112 = true;
    L50:
        if (r112 == true) goto L53;
        findViewById(R.id.live_dialog_container).setVisibility(8);
    L64:
        setCancelable(r110.f57010g);
        setCanceledOnTouchOutside(r110.f57011h);
        setOnCancelListener(r110.f57009f);
        setOnDismissListener(null);
        setOnShowListener(null);
        return;
    L53:
        if (r106 == 0) goto L63;
        if (3 == r106) goto L63;
        if (4 == r106) goto L63;
        if (8 == r106) goto L63;
        if (9 == r106) goto L63;
        if (5 == r106) goto L63;
        if (6 == r106) goto L63;
        if (7 == r106) goto L63;
        a((Button) findViewById(R.id.live_dialog_btn_1), 2, findViewById(R.id.live_dialog_divider_1), r110);
        a((Button) findViewById(R.id.live_dialog_btn_2), 3, findViewById(R.id.live_dialog_divider_2), r110);
        a((Button) findViewById(R.id.live_dialog_btn_3), 4, findViewById(R.id.live_dialog_divider_3), r110);
    L63:
        a((Button) findViewById(R.id.live_dialog_btn_1), 0, null, r110);
        a((Button) findViewById(R.id.live_dialog_btn_2), 1, findViewById(R.id.live_dialog_divider_vertical), r110);
        this.f56996d = findViewById(R.id.live_dialog_title_message_block);
        goto L64
    L36:
        if (r111[3] != null) goto L48;
        if (r111[4] != null) goto L48;
    L47:
        r112 = false;
        goto L50
    L40:
        if (3 != r106) goto L47;
    L42:
        b[] r113 = r110.f57008e;
        if (r113[0] != null) goto L48;
        if (r113[1] == null) goto L47;
    L13:
        this.f56995c.setVisibility(8);
        findViewById(R.id.live_dialog_title_message_block).setVisibility(8);
        goto L15
    L9:
        this.f56994b.setVisibility(8);
        findViewById(R.id.live_dialog_title_message_block).setVisibility(8);
    L5:
        RelativeLayout r107 = (RelativeLayout) findViewById(R.id.ttlive_xg_exit_dialog_close_button);
        goto L6
    }

    @Override // android.app.Dialog
    public final void setTitle(int r100) {
        setTitle(getContext().getText(r100));
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence r100) {
        TextView r101 = this.f56994b;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public i(Context r100, c r101) {
        super(r100, R.style.gamecp_live_dialog);
        r101.getClass();
        int r102 = r101.f57004a;
        if (2 != r102) goto L11;
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.gamecp_dialog_common_loading, null);
        setContentView(r103);
        TextView r104 = (TextView) findViewById(R.id.live_dialog_message);
        this.f56995c = r104;
        if (r104 == null) goto L9;
        CharSequence r105 = r101.f57007d;
        if (r105 == null) goto L9;
        r104.setText(r105);
    L9:
        setCancelable(r101.f57010g);
        setCanceledOnTouchOutside(r101.f57011h);
        setOnCancelListener(r101.f57009f);
        setOnDismissListener(new g(this, r101));
        setOnShowListener(new h(this, r101));
        int r106 = (int) UIUtils.dip2Px(getContext(), 80.0f);
        ViewGroup.LayoutParams r107 = r103.getLayoutParams();
        r107.width = r106;
        r107.height = r106;
        r103.setLayoutParams(r107);
        return;
    L11:
        if (1 != r102) goto L14;
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.gamecp_dialog_common_vertical, null));
        b(r101);
        return;
    L14:
        if (3 != r102) goto L17;
        View r108 = LayoutInflater.from(getContext()).inflate(R.layout.gamecp_dialog_pk_xt, null);
        setContentView(r108);
        int r109 = (int) UIUtils.dip2Px(getContext(), 280.0f);
        ViewGroup.LayoutParams r110 = r108.getLayoutParams();
        r110.width = r109;
        r108.setLayoutParams(r110);
        b(r101);
        return;
    L17:
        if (r102 != 4) goto L20;
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.gamecp_dialog_common_horizontal_new, null));
        b(r101);
        return;
    L20:
        if (r102 != 5) goto L23;
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.gamecp_dialog_common_horizontal_compact, null));
        b(r101);
        return;
    L23:
        if (r102 != 6) goto L26;
        View r111 = LayoutInflater.from(getContext()).inflate(R.layout.gamecp_dialog_common_horizontal_new, null);
        setContentView(r111);
        b(r101);
        int r112 = (int) UIUtils.dip2Px(getContext(), 280.0f);
        ViewGroup.LayoutParams r113 = r111.getLayoutParams();
        r113.width = r112;
        r113.height = -2;
        r111.setLayoutParams(r113);
        return;
    L26:
        if (r102 != 7) goto L29;
        View r114 = LayoutInflater.from(getContext()).inflate(R.layout.gamecp_dialog_common_horizontal_v2, null);
        setContentView(r114);
        b(r101);
        int r115 = (int) UIUtils.dip2Px(getContext(), 280.0f);
        ViewGroup.LayoutParams r116 = r114.getLayoutParams();
        r116.width = r115;
        r116.height = -2;
        r114.setLayoutParams(r116);
        return;
    L29:
        if (r102 != 8) goto L32;
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.gamecp_dialog_xg_exit_room_follow_guide, null));
        b(r101);
        return;
    L32:
        if (r102 != 9) goto L34;
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.gamecp_dialog_tt_exit_room_follow_guide, null));
        b(r101);
        return;
    L34:
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.gamecp_dialog_common_horizontal, null));
        b(r101);
    }

    public final void a(Button r100, int r101, View r102, c r103) {
        b r104 = r103.f57008e[r101];
        if (r104 == null) goto L8;
        r100.setText(r104.f57001a);
        r100.setOnClickListener(new a(this, r104, r101));
        if (r104.f57003c == false) goto L7;
        r100.setTypeface(null, 1);
        return;
    L7:
        r100.setTypeface(null, 0);
        return;
    L8:
        r100.setVisibility(8);
        if (r102 == null) goto L14;
        r102.setVisibility(8);
        return;
    }
}
