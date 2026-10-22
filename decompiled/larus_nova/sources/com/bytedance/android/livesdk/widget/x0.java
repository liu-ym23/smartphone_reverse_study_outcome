package com.bytedance.android.livesdk.widget;

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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar.RecommendFastGiftConfirmView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes11.dex */
public final class x0 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f162227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f162228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f162229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Button f162230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Button f162231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f162232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f162233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Animation f162234h;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f162235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f162236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x0 f162237c;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            DialogInterface.OnClickListener r101 = this.f162235a.f162240b;
            if (r101 != null) goto L5;
            return;
        L5:
            r101.onClick(this.f162237c, this.f162236b);
        }

        public a(x0 r100, c r101, int r102) {
            this.f162237c = r100;
            this.f162235a = r101;
            this.f162236b = r102;
        }
    }

    public static class b implements z0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f162238a;

        @Override // com.bytedance.android.livesdk.widget.z0.a
        public Context getContext() {
            return this.f162238a.f162243b;
        }

        public final x0 h() {
            d r100 = this.f162238a;
            return new x0(r100.f162243b, r100);
        }

        @Override // com.bytedance.android.livesdk.widget.z0.a
        public final /* bridge */ /* synthetic */ x0 f() {
            return n();
        }

        public final x0 n() {
            x0 r100 = h();
            g(r100);
            return r100;
        }

        public static void g(x0 r100) {
            if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
            DialogLancet.handleBlockedDialogShow(r100);
            return;
        L10:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
        L7:
            DialogLancet.beforeDialogShow(r100);
            r100.show();
            DialogLancet.afterDialogShow(r100);
        }

        @Override // com.bytedance.android.livesdk.widget.z0.a
        public final b b(CharSequence r100) {
            this.f162238a.f162245d = r100;
            return this;
        }

        @Override // com.bytedance.android.livesdk.widget.z0.a
        public final b c(RecommendFastGiftConfirmView r100) {
            this.f162238a.f162246e = r100;
            return this;
        }

        @Override // com.bytedance.android.livesdk.widget.z0.a
        public final b d(boolean r100) {
            this.f162238a.f162252k = r100;
            return this;
        }

        public final void l(int r100) {
            this.f162238a.f162245d = this.f162238a.f162243b.getText(r100);
        }

        public final void m(int r100) {
            this.f162238a.f162244c = this.f162238a.f162243b.getText(r100);
        }

        @Override // com.bytedance.android.livesdk.widget.z0.a
        public final b setContentView(View r100) {
            this.f162238a.f162247f = r100;
            return this;
        }

        @Override // com.bytedance.android.livesdk.widget.z0.a
        public final b setCornerRadius(float r100) {
            d r101 = this.f162238a;
            r101.f162254m = Float.valueOf(r100);
            return this;
        }

        @Override // com.bytedance.android.livesdk.widget.z0.a
        public final b setOnDismissListener(DialogInterface.OnDismissListener r100) {
            this.f162238a.f162250i = r100;
            return this;
        }

        @Override // com.bytedance.android.livesdk.widget.z0.a
        public final b setTitle(CharSequence r100) {
            this.f162238a.f162244c = r100;
            return this;
        }

        @Override // com.bytedance.android.livesdk.widget.z0.a
        public final /* bridge */ /* synthetic */ b setTitle(int r100) {
            m(r100);
            return this;
        }

        public b(Context r100, int r101) {
            d r102 = new d();
            this.f162238a = r102;
            r102.f162243b = r100;
            r102.f162242a = r101;
        }

        public final b k(int r100, boolean r101) {
            if (r100 <= 4) goto L5;
            return this;
        L5:
            c[] r102 = this.f162238a.f162248g;
            c r103 = r102[r100];
            if (r103 != null) goto L8;
            r103 = new c();
            r102[r100] = r103;
        L8:
            r103.f162241c = r101;
            return this;
        }

        @Override // com.bytedance.android.livesdk.widget.z0.a
        public final /* bridge */ /* synthetic */ b a(int r100, int r101, DialogInterface.OnClickListener r102) {
            i(r100, r101, r102);
            return this;
        }

        @Override // com.bytedance.android.livesdk.widget.z0.a
        public final /* bridge */ /* synthetic */ b e(int r100, CharSequence r101, DialogInterface.OnClickListener r102) {
            j(r100, r101, r102);
            return this;
        }

        public final void i(int r100, int r101, DialogInterface.OnClickListener r102) {
            j(r100, this.f162238a.f162243b.getText(r101), r102);
        }

        public final void j(int r100, CharSequence r101, DialogInterface.OnClickListener r102) {
            if (r100 <= 4) goto L5;
            return;
        L5:
            c[] r103 = this.f162238a.f162248g;
            c r104 = r103[r100];
            if (r104 != null) goto L8;
            r104 = new c();
            r103[r100] = r104;
        L8:
            r104.f162239a = r101;
            r104.f162240b = r102;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f162239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public DialogInterface.OnClickListener f162240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f162241c;

        public c() {
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f162242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Context f162243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f162244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f162245d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f162246e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f162247f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c[] f162248g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public DialogInterface.OnCancelListener f162249h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public DialogInterface.OnDismissListener f162250i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public DialogInterface.OnShowListener f162251j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f162252k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f162253l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Float f162254m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f162255n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f162256o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public CompoundButton.OnCheckedChangeListener f162257p;

        public d() {
            this.f162242a = 0;
            this.f162248g = new c[5];
            this.f162252k = true;
            this.f162253l = true;
            this.f162254m = null;
            this.f162255n = false;
            this.f162256o = "";
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
        int r101 = y0.f162259a - 1;
        y0.f162259a = r101;
        if (r101 >= 0) goto L26;
        y0.f162259a = 0;
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
        y0.f162259a++;
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public final void b(d r110) {
        this.f162227a = (HSImageView) findViewById(R.id.live_dialog_image);
        this.f162228b = (TextView) findViewById(R.id.live_dialog_title);
        this.f162229c = (TextView) findViewById(R.id.live_dialog_message);
        if (r110.f162247f == null) goto L5;
        this.f162227a.setVisibility(8);
        this.f162228b.setVisibility(8);
        this.f162229c.setVisibility(8);
        findViewById(R.id.live_dialog_top_block).setVisibility(8);
        findViewById(R.id.live_dialog_title_message_block).setVisibility(8);
        findViewById(R.id.live_dialog_bottom_block).setVisibility(8);
        FrameLayout r100 = (FrameLayout) findViewById(R.id.live_dialog_frame);
        r100.addView(r110.f162247f);
        r100.setVisibility(0);
    L19:
        if (r110.f162254m == null) goto L27;
        ViewGroup r101 = (ViewGroup) findViewById(android.R.id.content);
        if (r101 == null) goto L27;
        View r102 = r101.getChildAt(0);
        if (r102 == null) goto L27;
        if ((r102.getBackground() instanceof GradientDrawable) == false) goto L27;
        GradientDrawable r103 = (GradientDrawable) r102.getBackground().mutate();
        r103.setCornerRadius(UIUtils.dip2Px(getContext(), r110.f162254m.floatValue()));
        r102.setBackground(r103);
    L27:
        int r104 = r110.f162242a;
        if (r104 == 0) goto L50;
        if (4 == r104) goto L50;
        if (8 == r104) goto L50;
        if (5 == r104) goto L50;
        if (6 == r104) goto L50;
        if (7 == r104) goto L50;
        if (10 == r104) goto L50;
        if (13 == r104) goto L50;
        if (1 == r104) goto L43;
        if (11 == r104) goto L43;
        if (11 == r104) goto L43;
        if (12 == r104) goto L43;
    L42:
        boolean r105 = false;
    L55:
        if (r105 == true) goto L57;
        findViewById(R.id.live_dialog_container).setVisibility(8);
    L91:
        setCancelable(r110.f162252k);
        setCanceledOnTouchOutside(r110.f162253l);
        setOnCancelListener(r110.f162249h);
        setOnDismissListener(r110.f162250i);
        setOnShowListener(r110.f162251j);
        return;
    L57:
        Button r106 = null;
        if (r104 == 0) goto L90;
        if (4 == r104) goto L90;
        if (8 == r104) goto L90;
        if (5 == r104) goto L90;
        if (6 == r104) goto L90;
        if (7 == r104) goto L90;
        if (10 == r104) goto L90;
        if (13 == r104) goto L90;
        if (11 != r104) goto L71;
        Button r107 = (Button) findViewById(R.id.live_dialog_btn_1);
        this.f162230d = r107;
        a(r107, 2, findViewById(R.id.live_dialog_divider_1), r110);
        this.f162230d.setTypeface(null, 1);
        Button r108 = (Button) findViewById(R.id.live_dialog_btn_2);
        this.f162231e = r108;
        a(r108, 3, findViewById(R.id.live_dialog_divider_2), r110);
        Button r109 = (Button) findViewById(R.id.live_dialog_btn_3);
        this.f162232f = r109;
        a(r109, 4, findViewById(R.id.live_dialog_divider_3), r110);
        goto L91
    L71:
        if (12 != r104) goto L89;
        Button r111 = (Button) findViewById(R.id.live_dialog_btn_1);
        this.f162230d = r111;
        a(r111, 2, findViewById(R.id.live_dialog_divider_1), r110);
        Button r112 = (Button) findViewById(R.id.live_dialog_btn_2);
        this.f162231e = r112;
        a(r112, 3, findViewById(R.id.live_dialog_divider_2), r110);
        Button r113 = (Button) findViewById(R.id.live_dialog_btn_3);
        this.f162232f = r113;
        a(r113, 4, findViewById(R.id.live_dialog_divider_3), r110);
        int r114 = 2;
        int r115 = 2;
    L73:
        c[] r116 = r110.f162248g;
        if (r114 >= r116.length) goto L79;
        if (r116[r114] == null) goto L79;
        r115 = r114;
        r114 = r114 + 1;
    L79:
        if (r115 != 2) goto L81;
        r106 = this.f162230d;
    L87:
        if (r106 == null) goto L91;
        r106.setBackgroundResource(R.drawable.ttlive_bg_ban_tips_notice_dialog);
        goto L91
    L81:
        if (r115 == 3) goto L85;
        if (r115 != 4) goto L87;
        r106 = this.f162232f;
        goto L87
    L85:
        r106 = this.f162231e;
        goto L87
    L89:
        Button r117 = (Button) findViewById(R.id.live_dialog_btn_1);
        this.f162230d = r117;
        a(r117, 2, findViewById(R.id.live_dialog_divider_1), r110);
        Button r118 = (Button) findViewById(R.id.live_dialog_btn_2);
        this.f162231e = r118;
        a(r118, 3, findViewById(R.id.live_dialog_divider_2), r110);
        Button r119 = (Button) findViewById(R.id.live_dialog_btn_3);
        this.f162232f = r119;
        a(r119, 4, findViewById(R.id.live_dialog_divider_3), r110);
    L90:
        Button r120 = (Button) findViewById(R.id.live_dialog_btn_1);
        this.f162230d = r120;
        a(r120, 0, null, r110);
        Button r121 = (Button) findViewById(R.id.live_dialog_btn_2);
        this.f162231e = r121;
        a(r121, 1, findViewById(R.id.live_dialog_divider_vertical), r110);
        this.f162233g = findViewById(R.id.live_dialog_title_message_block);
    L43:
        c[] r122 = r110.f162248g;
        if (r122[2] == null) goto L46;
    L49:
        r105 = true;
        goto L55
    L46:
        if (r122[3] != null) goto L49;
        if (r122[4] == null) goto L42;
    L50:
        c[] r123 = r110.f162248g;
        if (r123[0] != null) goto L49;
        if (r123[1] == null) goto L42;
    L5:
        this.f162227a.setVisibility(8);
        findViewById(R.id.live_dialog_image_block).setVisibility(8);
        CharSequence r124 = r110.f162244c;
        if (r124 == null) goto L8;
        this.f162228b.setText(r124);
        this.f162228b.setVisibility(0);
    L9:
        CharSequence r125 = r110.f162245d;
        if (r125 == null) goto L12;
        this.f162229c.setText(r125);
    L14:
        if (r110.f162255n == false) goto L19;
        View r126 = findViewById(R.id.live_dialog_checkbox);
        if ((r126 instanceof CheckBox) == false) goto L19;
        ((CheckBox) r126).setText(r110.f162256o);
        r126.setVisibility(0);
        ((CheckBox) r126).setOnCheckedChangeListener(r110.f162257p);
        goto L19
    L12:
        this.f162229c.setVisibility(8);
        findViewById(R.id.live_dialog_title_message_block).setVisibility(8);
        goto L14
    L8:
        this.f162228b.setVisibility(8);
        findViewById(R.id.live_dialog_title_message_block).setVisibility(8);
        goto L9
    }

    @Override // android.app.Dialog
    public final void setTitle(int r100) {
        setTitle(getContext().getText(r100));
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence r100) {
        TextView r101 = this.f162228b;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public x0(Context r100, d r101) {
        super(r100, R.style.ttlive_live_dialog);
        View r102 = r101.f162246e;
        if (r102 == null) goto L5;
        setContentView(r102);
        return;
    L5:
        int r103 = r101.f162242a;
        if (2 != r103) goto L14;
        View r104 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_common_loading, null);
        setContentView(r104);
        TextView r105 = (TextView) findViewById(R.id.live_dialog_message);
        this.f162229c = r105;
        if (r105 == null) goto L12;
        CharSequence r106 = r101.f162245d;
        if (r106 == null) goto L12;
        r105.setText(r106);
    L12:
        setCancelable(r101.f162252k);
        setCanceledOnTouchOutside(r101.f162253l);
        setOnCancelListener(r101.f162249h);
        setOnDismissListener(new v0(this, r101));
        setOnShowListener(new w0(this, r101));
        int r107 = (int) UIUtils.dip2Px(getContext(), 80.0f);
        ViewGroup.LayoutParams r108 = r104.getLayoutParams();
        r108.width = r107;
        r108.height = r107;
        r104.setLayoutParams(r108);
        return;
    L14:
        if (1 != r103) goto L17;
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_common_vertical, null));
        b(r101);
        return;
    L17:
        if (11 != r103) goto L20;
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_common_vertical_corner, null));
        b(r101);
        return;
    L20:
        if (r103 != 4) goto L23;
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_common_horizontal_new, null));
        b(r101);
        return;
    L23:
        if (r103 != 8) goto L26;
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_common_horizontal_new_ktv, null));
        b(r101);
        return;
    L26:
        if (r103 != 5) goto L29;
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_common_horizontal_compact, null));
        b(r101);
        return;
    L29:
        if (r103 != 6) goto L32;
        View r109 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_common_horizontal_new, null);
        setContentView(r109);
        b(r101);
        int r110 = (int) UIUtils.dip2Px(getContext(), 280.0f);
        ViewGroup.LayoutParams r111 = r109.getLayoutParams();
        r111.width = r110;
        r111.height = -2;
        r109.setLayoutParams(r111);
        return;
    L32:
        if (r103 != 7) goto L35;
        View r112 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_common_horizontal_v2, null);
        setContentView(r112);
        b(r101);
        int r113 = (int) UIUtils.dip2Px(getContext(), 280.0f);
        ViewGroup.LayoutParams r114 = r112.getLayoutParams();
        r114.width = r113;
        r114.height = -2;
        r112.setLayoutParams(r114);
        return;
    L35:
        if (r103 != 10) goto L37;
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_preview_permission_horizontal, null));
        b(r101);
        return;
    L37:
        if (r103 != 11) goto L40;
        View r115 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_block_trial_broadcast_vertical, null);
        setContentView(r115);
        b(r101);
        int r116 = (int) UIUtils.dip2Px(getContext(), 280.0f);
        ViewGroup.LayoutParams r117 = r115.getLayoutParams();
        r117.width = r116;
        r117.height = -2;
        r115.setLayoutParams(r117);
        return;
    L40:
        if (r103 != 12) goto L43;
        View r118 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_common_tips_vertical, null);
        setContentView(r118);
        b(r101);
        int r119 = (int) UIUtils.dip2Px(getContext(), 280.0f);
        ViewGroup.LayoutParams r120 = r118.getLayoutParams();
        r120.width = r119;
        r120.height = -2;
        r118.setLayoutParams(r120);
        return;
    L43:
        if (r103 != 13) goto L45;
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_revenue_setting, null));
        b(r101);
        return;
    L45:
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_common_horizontal, null));
        b(r101);
    }

    public final void a(Button r100, int r101, View r102, d r103) {
        c r104 = r103.f162248g[r101];
        if (r104 == null) goto L8;
        r100.setText(r104.f162239a);
        r100.setOnClickListener(new a(this, r104, r101));
        if (r104.f162241c == false) goto L7;
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
