package com.bytedance.android.live.uikit.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes7.dex */
public class AlertDialog extends Dialog implements DialogInterface {
    public static final int LAYOUT_HINT_NONE = 0;
    public static final int LAYOUT_HINT_SIDE = 1;
    public static final int THEME_LIGHT = 1;
    public static final int THEME_NIGHT = 2;
    private static NightMode sNightMode;
    private a mAlert;

    public static class Builder {
        private final a.b P;
        private int mTheme;

        public AlertDialog create() {
            AlertDialog r100 = new AlertDialog(this.P.f102148a, this.mTheme);
            a.b r101 = this.P;
            a r102 = AlertDialog.access$000(r100);
            View r103 = r101.f102153f;
            if (r103 == null) goto L5;
            r102.C = r103;
        L18:
            CharSequence r104 = r101.f102154g;
            if (r104 == null) goto L23;
            r102.f102124e = r104;
            TextView r105 = r102.B;
            if (r105 == null) goto L23;
            r105.setText(r104);
        L23:
            CharSequence r106 = r101.f102155h;
            if (r106 == null) goto L26;
            r102.c(-1, r106, r101.f102156i, null);
        L26:
            CharSequence r107 = r101.f102157j;
            if (r107 == null) goto L29;
            r102.c(-2, r107, r101.f102158k, null);
        L29:
            CharSequence r108 = r101.f102159l;
            if (r108 == null) goto L33;
            r102.c(-3, r108, r101.f102160m, null);
        L33:
            if (r101.f102147J == false) goto L36;
            r102.getClass();
        L36:
            if (r101.f102165r == null) goto L38;
        L41:
            RecycleListView r110 = (RecycleListView) r101.f102149b.inflate(r102.G, null);
            if (r101.C == false) goto L48;
            if (r101.G != null) goto L46;
            ListAdapter r111 = new b(r101, r101.f102148a, r102.H, r101.f102165r, r110);
        L59:
            r102.D = r111;
            r102.E = r101.E;
            if (r101.f102167t == null) goto L63;
            r110.setOnItemClickListener(new d(r101, r102));
        L65:
            AdapterView.OnItemSelectedListener r109 = r101.K;
            if (r109 == null) goto L69;
            r110.setOnItemSelectedListener(r109);
        L69:
            if (r101.D == false) goto L72;
            r110.setChoiceMode(1);
        L74:
            r110.getClass();
            r102.f102125f = r110;
        L75:
            View r112 = r101.f102169v;
            if (r112 != null) goto L78;
            int r113 = r101.f102168u;
            if (r113 == 0) goto L84;
            r102.f102126g = null;
            r102.f102127h = r113;
            r102.f102132m = false;
        L84:
            r100.setCancelable(this.P.f102161n);
            if (this.P.f102161n == false) goto L87;
            r100.setCanceledOnTouchOutside(true);
        L87:
            r100.setOnCancelListener(this.P.f102162o);
            r100.setOnDismissListener(this.P.f102163p);
            DialogInterface.OnKeyListener r114 = this.P.f102164q;
            if (r114 == null) goto L90;
            r100.setOnKeyListener(r114);
        L90:
            return r100;
        L78:
            if (r101.A == false) goto L80;
            int r115 = r101.f102170w;
            int r116 = r101.f102171x;
            int r117 = r101.f102172y;
            int r118 = r101.f102173z;
            r102.f102126g = r112;
            r102.f102127h = 0;
            r102.f102132m = true;
            r102.f102128i = r115;
            r102.f102129j = r116;
            r102.f102130k = r117;
            r102.f102131l = r118;
            goto L84
        L80:
            r102.f102126g = r112;
            r102.f102127h = 0;
            r102.f102132m = false;
            goto L84
        L72:
            if (r101.C == false) goto L74;
            r110.setChoiceMode(2);
            goto L74
        L63:
            if (r101.F == null) goto L65;
            r110.setOnItemClickListener(new e(r101, r110, r102));
            goto L65
        L46:
            r111 = new c(r101, r101.f102148a, r101.G, r110, r102);
            goto L59
        L48:
            if (r101.D == false) goto L50;
            int r119 = r102.I;
        L52:
            if (r101.G != null) goto L58;
            ListAdapter r120 = r101.f102166s;
            if (r120 != null) goto L57;
            r120 = new a.d(r101.f102148a, r119, r101.f102165r);
        L57:
            r111 = r120;
            goto L59
        L58:
            r111 = new SimpleCursorAdapter(r101.f102148a, r119, r101.G, new String[]{r101.H}, new int[]{R.id.text1});
            goto L59
        L50:
            r119 = r102.f102119J;
            goto L52
        L38:
            if (r101.G != null) goto L41;
            if (r101.f102166s == null) goto L75;
        L5:
            CharSequence r121 = r101.f102152e;
            if (r121 == null) goto L10;
            r102.f102123d = r121;
            TextView r122 = r102.A;
            if (r122 == null) goto L10;
            r122.setText(r121);
        L10:
            Drawable r123 = r101.f102151d;
            if (r123 == null) goto L15;
            r102.f102144y = r123;
            r102.f102143x = 0;
            ImageView r124 = r102.f102145z;
            if (r124 == null) goto L15;
            r124.setImageDrawable(r123);
        L15:
            int r125 = r101.f102150c;
            if (r125 == 0) goto L18;
            r102.d(r125);
            goto L18
        }

        public Context getContext() {
            return this.P.f102148a;
        }

        public AlertDialog show() {
            AlertDialog r100 = create();
            INVOKEVIRTUAL_com_bytedance_android_live_uikit_dialog_AlertDialog$Builder_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r100);
            return r100;
        }

        public Builder(Context r100) {
            this(r100, 0);
        }

        public static void INVOKEVIRTUAL_com_bytedance_android_live_uikit_dialog_AlertDialog$Builder_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AlertDialog r100) {
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

        public Builder setCancelable(boolean r100) {
            this.P.f102161n = r100;
            return this;
        }

        public Builder setCustomTitle(View r100) {
            this.P.f102153f = r100;
            return this;
        }

        public Builder setIcon(int r100) {
            this.P.f102150c = r100;
            return this;
        }

        public Builder setIconAttribute(int r100) {
            TypedValue r101 = new TypedValue();
            this.P.f102148a.getTheme().resolveAttribute(r100, r101, true);
            a.b r102 = this.P;
            r102.f102150c = r101.resourceId;
            return this;
        }

        public Builder setInverseBackgroundForced(boolean r100) {
            this.P.f102147J = r100;
            return this;
        }

        public Builder setMessage(int r100) {
            a.b r101 = this.P;
            r101.f102154g = r101.f102148a.getText(r100);
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener r100) {
            this.P.f102162o = r100;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener r100) {
            this.P.f102163p = r100;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener r100) {
            this.P.K = r100;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener r100) {
            this.P.f102164q = r100;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean r100) {
            this.P.getClass();
            return this;
        }

        public Builder setTitle(int r100) {
            a.b r101 = this.P;
            r101.f102152e = r101.f102148a.getText(r100);
            return this;
        }

        public Builder setView(int r100) {
            a.b r101 = this.P;
            r101.f102169v = null;
            r101.f102168u = r100;
            r101.A = false;
            return this;
        }

        public Builder setIcon(Drawable r100) {
            this.P.f102151d = r100;
            return this;
        }

        public Builder setMessage(CharSequence r100) {
            this.P.f102154g = r100;
            return this;
        }

        public Builder setTitle(CharSequence r100) {
            this.P.f102152e = r100;
            return this;
        }

        public Builder setView(View r100) {
            a.b r101 = this.P;
            r101.f102169v = r100;
            r101.f102168u = 0;
            r101.A = false;
            return this;
        }

        public Builder(Context r100, int r101) {
            this.P = new a.b(new ContextThemeWrapper(r100, AlertDialog.resolveDialogTheme(r100, r101)));
            this.mTheme = r101;
        }

        public Builder setAdapter(ListAdapter r100, DialogInterface.OnClickListener r101) {
            a.b r102 = this.P;
            r102.f102166s = r100;
            r102.f102167t = r101;
            return this;
        }

        public Builder setItems(int r100, DialogInterface.OnClickListener r101) {
            a.b r102 = this.P;
            r102.f102165r = r102.f102148a.getResources().getTextArray(r100);
            this.P.f102167t = r101;
            return this;
        }

        public Builder setNegativeButton(int r100, DialogInterface.OnClickListener r101) {
            a.b r102 = this.P;
            r102.f102157j = r102.f102148a.getText(r100);
            this.P.f102158k = r101;
            return this;
        }

        public Builder setNeutralButton(int r100, DialogInterface.OnClickListener r101) {
            a.b r102 = this.P;
            r102.f102159l = r102.f102148a.getText(r100);
            this.P.f102160m = r101;
            return this;
        }

        public Builder setPositiveButton(int r100, DialogInterface.OnClickListener r101) {
            a.b r102 = this.P;
            r102.f102155h = r102.f102148a.getText(r100);
            this.P.f102156i = r101;
            return this;
        }

        public Builder setItems(CharSequence[] r100, DialogInterface.OnClickListener r101) {
            a.b r102 = this.P;
            r102.f102165r = r100;
            r102.f102167t = r101;
            return this;
        }

        public Builder setNegativeButton(CharSequence r100, DialogInterface.OnClickListener r101) {
            a.b r102 = this.P;
            r102.f102157j = r100;
            r102.f102158k = r101;
            return this;
        }

        public Builder setNeutralButton(CharSequence r100, DialogInterface.OnClickListener r101) {
            a.b r102 = this.P;
            r102.f102159l = r100;
            r102.f102160m = r101;
            return this;
        }

        public Builder setPositiveButton(CharSequence r100, DialogInterface.OnClickListener r101) {
            a.b r102 = this.P;
            r102.f102155h = r100;
            r102.f102156i = r101;
            return this;
        }

        public Builder setCursor(Cursor r100, DialogInterface.OnClickListener r101, String r102) {
            a.b r103 = this.P;
            r103.G = r100;
            r103.H = r102;
            r103.f102167t = r101;
            return this;
        }

        public Builder setMultiChoiceItems(int r100, boolean[] r101, DialogInterface.OnMultiChoiceClickListener r102) {
            a.b r103 = this.P;
            r103.f102165r = r103.f102148a.getResources().getTextArray(r100);
            a.b r104 = this.P;
            r104.F = r102;
            r104.B = r101;
            r104.C = true;
            return this;
        }

        public Builder setSingleChoiceItems(int r100, int r101, DialogInterface.OnClickListener r102) {
            a.b r103 = this.P;
            r103.f102165r = r103.f102148a.getResources().getTextArray(r100);
            a.b r104 = this.P;
            r104.f102167t = r102;
            r104.E = r101;
            r104.D = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] r100, boolean[] r101, DialogInterface.OnMultiChoiceClickListener r102) {
            a.b r103 = this.P;
            r103.f102165r = r100;
            r103.F = r102;
            r103.B = r101;
            r103.C = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter r100, int r101, DialogInterface.OnClickListener r102) {
            a.b r103 = this.P;
            r103.f102166s = r100;
            r103.f102167t = r102;
            r103.E = r101;
            r103.D = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] r100, int r101, DialogInterface.OnClickListener r102) {
            a.b r103 = this.P;
            r103.f102165r = r100;
            r103.f102167t = r102;
            r103.E = r101;
            r103.D = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor r100, String r101, String r102, DialogInterface.OnMultiChoiceClickListener r103) {
            a.b r104 = this.P;
            r104.G = r100;
            r104.F = r103;
            r104.I = r101;
            r104.H = r102;
            r104.C = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor r100, int r101, String r102, DialogInterface.OnClickListener r103) {
            a.b r104 = this.P;
            r104.G = r100;
            r104.f102167t = r103;
            r104.E = r101;
            r104.H = r102;
            r104.D = true;
            return this;
        }

        public Builder setView(View r100, int r101, int r102, int r103, int r104) {
            a.b r105 = this.P;
            r105.f102169v = r100;
            r105.f102168u = 0;
            r105.A = true;
            r105.f102170w = r101;
            r105.f102171x = r102;
            r105.f102172y = r103;
            r105.f102173z = r104;
            return this;
        }
    }

    public interface NightMode {
        boolean isToggled();
    }

    public ListView getListView() {
        return this.mAlert.f102125f;
    }

    public AlertDialog(Context r100) {
        this(r100, 0);
    }

    public static /* synthetic */ a access$000(AlertDialog r100) {
        return r100.mAlert;
    }

    public static void setNightMode(NightMode r100) {
        sNightMode = r100;
    }

    public Button getButton(int r100) {
        a r101 = this.mAlert;
        if (r100 == (-3)) goto L12;
        if (r100 == (-2)) goto L15;
        if (r100 == (-1)) goto L14;
        r101.getClass();
        return null;
    L14:
        return r101.f102133n;
    L15:
        return r101.f102136q;
    L12:
        return r101.f102139t;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r110) {
        super.onCreate(r110);
        a r100 = this.mAlert;
        r100.f102122c.requestFeature(1);
        r100.f102122c.setContentView(r100.F);
        ViewGroup r101 = (ViewGroup) r100.f102122c.findViewById(R.id.contentPanel);
        ScrollView r102 = (ScrollView) r100.f102122c.findViewById(R.id.scrollView);
        r100.f102142w = r102;
        boolean r103 = false;
        r102.setFocusable(false);
        TextView r104 = (TextView) r100.f102122c.findViewById(R.id.message);
        r100.B = r104;
        if (r104 == null) goto L25;
        CharSequence r105 = r100.f102124e;
        if (r105 == null) goto L8;
        r104.setText(r105);
    L12:
        View r106 = r100.f102122c.findViewById(R.id.scrollIndicatorUp);
        View r107 = r100.f102122c.findViewById(R.id.scrollIndicatorDown);
        if (r106 != null) goto L16;
        if (r107 == null) goto L25;
    L16:
        if (r100.f102124e == null) goto L18;
        r100.f102142w.post(new ub1.b(r100, r106, r107));
        goto L25
    L18:
        ListView r108 = r100.f102125f;
        if (r108 == null) goto L21;
        r108.setOnScrollListener(new ub1.c(r106, r107));
        r100.f102125f.post(new ub1.d(r100, r106, r107));
        goto L25
    L21:
        if (r106 == null) goto L23;
        r101.removeView(r106);
    L23:
        if (r107 == null) goto L25;
        r101.removeView(r107);
        goto L25
    L8:
        r104.setVisibility(8);
        r100.f102142w.removeView(r100.B);
        if (r100.f102125f == null) goto L11;
        ViewGroup r109 = (ViewGroup) r100.f102142w.getParent();
        int r111 = r109.indexOfChild(r100.f102142w);
        r109.removeViewAt(r111);
        r109.addView(r100.f102125f, r111, new ViewGroup.LayoutParams(-1, -1));
        goto L12
    L11:
        r101.setVisibility(8);
    L25:
        Button r112 = (Button) r100.f102122c.findViewById(R.id.button1);
        r100.f102133n = r112;
        r112.setOnClickListener(r100.L);
        if (TextUtils.isEmpty(r100.f102134o) == false) goto L28;
        r100.f102133n.setVisibility(8);
        int r113 = 0;
    L29:
        Button r114 = (Button) r100.f102122c.findViewById(R.id.button2);
        r100.f102136q = r114;
        r114.setOnClickListener(r100.L);
        if (TextUtils.isEmpty(r100.f102137r) == false) goto L32;
        r100.f102136q.setVisibility(8);
    L33:
        Button r115 = (Button) r100.f102122c.findViewById(R.id.button3);
        r100.f102139t = r115;
        r115.setOnClickListener(r100.L);
        if (TextUtils.isEmpty(r100.f102140u) == false) goto L36;
        r100.f102139t.setVisibility(8);
    L37:
        if (r113 == 0) goto L39;
        boolean r116 = true;
    L40:
        ViewGroup r117 = (ViewGroup) r100.f102122c.findViewById(R.id.topPanel);
        if (r100.C == null) goto L43;
        r117.addView(r100.C, 0, new ViewGroup.LayoutParams(-1, -2));
        r100.f102122c.findViewById(R.id.title_template).setVisibility(8);
    L52:
        boolean r118 = true;
    L54:
        View r119 = r100.f102122c.findViewById(R.id.buttonPanel);
        if (r116 == true) goto L63;
        r119.setVisibility(8);
        if (r100.f102124e != null) goto L63;
        ListView r120 = r100.f102125f;
        if (r120 == null) goto L63;
        if (r120.getParent() == null) goto L63;
        ListView r121 = r100.f102125f;
        r121.setPadding(r121.getPaddingLeft(), r100.f102125f.getPaddingTop(), r100.f102125f.getPaddingRight(), r100.f102125f.getPaddingTop());
    L63:
        FrameLayout r122 = (FrameLayout) r100.f102122c.findViewById(R.id.customPanel);
        View r123 = r100.f102126g;
        if (r123 == null) goto L67;
    L70:
        if (r123 == null) goto L72;
        boolean r124 = true;
    L73:
        if (r124 == true) goto L75;
    L76:
        r100.f102122c.setFlags(131072, 131072);
    L77:
        if (r124 == false) goto L84;
        FrameLayout r125 = (FrameLayout) r100.f102122c.findViewById(R.id.custom);
        r125.addView(r123, new ViewGroup.LayoutParams(-1, -1));
        if (r100.f102132m == false) goto L82;
        r125.setPadding(r100.f102128i, r100.f102129j, r100.f102130k, r100.f102131l);
    L82:
        if (r100.f102125f == null) goto L85;
        ((LinearLayout.LayoutParams) r122.getLayoutParams()).weight = 0.0f;
    L85:
        if (r118 == false) goto L97;
        if (r100.f102124e != null) goto L93;
        if (r123 != null) goto L93;
        if (r100.f102125f != null) goto L93;
        View r126 = r100.f102122c.findViewById(R.id.titleDividerTop);
    L94:
        if (r126 == null) goto L97;
        r126.setVisibility(0);
    L93:
        r126 = r100.f102122c.findViewById(R.id.titleDivider);
    L97:
        if (r101.getVisibility() != 0) goto L99;
        r103 = true;
    L99:
        if (r116 == false) goto L104;
        if (r118 == false) goto L104;
        if (r124 == true) goto L104;
        if (r103 == true) goto L104;
        UIUtils.updateLayoutMargin(r117, -3, -3, -3, (int) UIUtils.dip2Px(r100.f102120a, 16.0f));
    L104:
        ListView r127 = r100.f102125f;
        if (r127 == null) goto L111;
        ListAdapter r128 = r100.D;
        if (r128 == null) goto L111;
        r127.setAdapter(r128);
        int r129 = r100.E;
        if (r129 <= (-1)) goto L111;
        r127.setItemChecked(r129, true);
        r127.setSelection(r129);
    L111:
        View r130 = r100.f102122c.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L116;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r131 = ThreadMethodProxy.currentThread();
        if (r131 == com.larus.home.impl.utils.c.f346341a) goto L116;
        com.larus.home.impl.utils.c.a(r131, "getDecorView");
    L116:
        View r132 = r100.f102122c.findViewById(R.id.parentPanel);
        if (r132 == null) goto L121;
        if (r130 == null) goto L122;
        r130.setOnApplyWindowInsetsListener(new ub1.a(r100, r132));
        r130.setFitsSystemWindows(true);
        r130.requestApplyInsets();
        return;
    L122:
        return;
    L121:
        return;
    L84:
        r122.setVisibility(8);
        goto L85
    L75:
        if (a.b(r123) == true) goto L77;
    L72:
        r124 = false;
        goto L73
    L67:
        if (r100.f102127h == 0) goto L69;
        r123 = LayoutInflater.from(r100.f102120a).inflate(r100.f102127h, r122, false);
        goto L70
    L69:
        r123 = null;
        goto L70
    L43:
        r100.f102145z = (ImageView) r100.f102122c.findViewById(R.id.icon);
        if ((!TextUtils.isEmpty(r100.f102123d)) == false) goto L53;
        TextView r133 = (TextView) r100.f102122c.findViewById(R.id.alertTitle);
        r100.A = r133;
        r133.setText(r100.f102123d);
        int r134 = r100.f102143x;
        if (r134 == 0) goto L48;
        r100.f102145z.setImageResource(r134);
        goto L52
    L48:
        Drawable r135 = r100.f102144y;
        if (r135 == null) goto L51;
        r100.f102145z.setImageDrawable(r135);
        goto L52
    L51:
        r100.A.setPadding(r100.f102145z.getPaddingLeft(), r100.f102145z.getPaddingTop(), r100.f102145z.getPaddingRight(), r100.f102145z.getPaddingBottom());
        r100.f102145z.setVisibility(8);
        goto L52
    L53:
        r100.f102122c.findViewById(R.id.title_template).setVisibility(8);
        r100.f102145z.setVisibility(8);
        r117.setVisibility(8);
        r118 = false;
        goto L54
    L39:
        r116 = false;
        goto L40
    L36:
        r100.f102139t.setText(r100.f102140u);
        r100.f102139t.setVisibility(0);
        r113 = r113 | 4;
        goto L37
    L32:
        r100.f102136q.setText(r100.f102137r);
        r100.f102136q.setVisibility(0);
        r113 = r113 | 2;
        goto L33
    L28:
        r100.f102133n.setText(r100.f102134o);
        r100.f102133n.setVisibility(0);
        r113 = 1;
        goto L29
    }

    public void setCustomTitle(View r100) {
        this.mAlert.C = r100;
    }

    public void setIcon(Drawable r100) {
        a r101 = this.mAlert;
        r101.f102144y = r100;
        r101.f102143x = 0;
        ImageView r102 = r101.f102145z;
        if (r102 == null) goto L8;
        if (r100 == null) goto L6;
        r102.setImageDrawable(r100);
        return;
    L6:
        r102.setVisibility(8);
        return;
    }

    public void setIconAttribute(int r100) {
        TypedValue r101 = new TypedValue();
        getContext().getTheme().resolveAttribute(r100, r101, true);
        this.mAlert.d(r101.resourceId);
    }

    public void setInverseBackgroundForced(boolean r100) {
        this.mAlert.getClass();
    }

    public void setMessage(CharSequence r100) {
        a r101 = this.mAlert;
        r101.f102124e = r100;
        TextView r102 = r101.B;
        if (r102 == null) goto L6;
        r102.setText(r100);
        return;
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence r100) {
        super.setTitle(r100);
        a r101 = this.mAlert;
        r101.f102123d = r100;
        TextView r102 = r101.A;
        if (r102 == null) goto L6;
        r102.setText(r100);
        return;
    }

    public void setView(View r100) {
        a r101 = this.mAlert;
        r101.f102126g = r100;
        r101.f102127h = 0;
        r101.f102132m = false;
    }

    public void setIcon(int r100) {
        this.mAlert.d(r100);
    }

    public AlertDialog(Context r100, int r101) {
        super(r100, resolveDialogTheme(r100, r101));
        this.mAlert = new a(getContext(), this, getWindow());
        if (sNightMode == null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("NightMode is NUll");
    }

    public static int resolveDialogTheme(Context r100, int r101) {
        if (r101 != 1) goto L6;
        return R.style.SSTheme_Dialog_Alert;
    L6:
        if (r101 != 2) goto L9;
        return R.style.SSTheme_Dialog_Alert_Night;
    L9:
        if (r101 < 16777216) goto L11;
        return r101;
    L11:
        NightMode r102 = sNightMode;
        if (r102 != null) goto L14;
        return R.style.SSTheme_Dialog_Alert;
    L14:
        if (r102.isToggled() == false) goto L18;
        return R.style.SSTheme_Dialog_Alert_Night;
    L18:
        return R.style.SSTheme_Dialog_Alert;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r100, KeyEvent r101) {
        ScrollView r102 = this.mAlert.f102142w;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        return true;
    L11:
        return super.onKeyDown(r100, r101);
    L5:
        if (r102.executeKeyEvent(r101) == false) goto L7;
        r103 = true;
        goto L8
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r100, KeyEvent r101) {
        ScrollView r102 = this.mAlert.f102142w;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        return true;
    L11:
        return super.onKeyUp(r100, r101);
    L5:
        if (r102.executeKeyEvent(r101) == false) goto L7;
        r103 = true;
        goto L8
    }

    public void setButton(CharSequence r100, DialogInterface.OnClickListener r101) {
        setButton(-1, r100, r101);
    }

    public void setButton2(CharSequence r100, DialogInterface.OnClickListener r101) {
        setButton(-2, r100, r101);
    }

    public void setButton3(CharSequence r100, DialogInterface.OnClickListener r101) {
        setButton(-3, r100, r101);
    }

    public void setButton(CharSequence r100, Message r101) {
        setButton(-1, r100, r101);
    }

    public void setButton2(CharSequence r100, Message r101) {
        setButton(-2, r100, r101);
    }

    public void setButton3(CharSequence r100, Message r101) {
        setButton(-3, r100, r101);
    }

    public void setButton(int r100, CharSequence r101, DialogInterface.OnClickListener r102) {
        this.mAlert.c(r100, r101, r102, null);
    }

    public void setButton(int r100, CharSequence r101, Message r102) {
        this.mAlert.c(r100, r101, null, r102);
    }

    public void setView(View r100, int r101, int r102, int r103, int r104) {
        a r105 = this.mAlert;
        r105.f102126g = r100;
        r105.f102127h = 0;
        r105.f102132m = true;
        r105.f102128i = r101;
        r105.f102129j = r102;
        r105.f102130k = r103;
        r105.f102131l = r104;
    }
}
