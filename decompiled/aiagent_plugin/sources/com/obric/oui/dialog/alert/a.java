package com.obric.oui.dialog.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ButtonStyleController.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0949a f35043a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f35044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f35045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OButton f35046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OButton f35047e;
    private OButton f;
    private OAlertDialog g;
    private View h;
    private FrameLayout i;

    /* JADX INFO: renamed from: com.obric.oui.dialog.alert.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ButtonStyleController.kt */
    public static final class C0949a {
        public /* synthetic */ C0949a(h r1) {
            this();
        }

        private C0949a() {
        }
    }

    /* JADX INFO: compiled from: ButtonStyleController.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f35048a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f35049b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f35050c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f35051d = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f35048a, f35049b, f35050c};
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f35051d.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f35048a = new b("TextReverse", 0);
            f35049b = new b("TextReverse2", 1);
            f35050c = new b("Negative", 2);
            f35051d = a();
        }
    }

    /* JADX INFO: compiled from: ButtonStyleController.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35052a = null;

        static {
            int[] r0 = new int[b.values().length];
            r0[b.f35050c.ordinal()] = 1;
            r0[b.f35048a.ordinal()] = 2;
            r0[b.f35049b.ordinal()] = 3;
            f35052a = r0;
        }
    }

    static {
        f35043a = new C0949a(null);
    }

    public static /* synthetic */ void lambda$N8AGDh_yUs7KXUYWui7PRyHJ6kg(a r0, DialogInterface.OnClickListener r1, View r2) {
        b(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$hvceQGohF3qqmetK2ZGqzB0TA8o(a r0, DialogInterface.OnClickListener r1, View r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$yMjLX4Hef-jHJVf8uk1alSBIgD8, reason: not valid java name */
    public static /* synthetic */ void m1003lambda$yMjLX4HefjHJVf8uk1alSBIgD8(a r0, DialogInterface.OnClickListener r1, View r2) {
        c(r0, r1, r2);
    }

    public final void d() {
    }

    public final void e() {
    }

    public a(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        this.f35044b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f35045c = r4;
    }

    @Override // com.obric.oui.dialog.alert.d
    public void a(Context r6, FrameLayout r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        o.e(r7, "parent");
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        int r2 = this.f35045c;
        if (r2 != 0) goto L5;
        int r3 = ZeusTransformUtils.mapRes(R.layout.o_dialog_button_horizontal, "layout", "o_dialog_button_horizontal");
    L9:
        View r9 = ZeusTransformUtils.inflate(LayoutInflater.from(r8), r3, (ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
        r7.addView(r9, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        this.h = r9;
        if (r9 == null) goto L13;
        r9.setVisibility(8);
    L13:
        this.f35046d = (OButton) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.actionPositive, DbHelper.COL_ID, "actionPositive")), OButton.class, "com.obric.aiagent.plugin");
        this.f35047e = (OButton) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.actionNegative, DbHelper.COL_ID, "actionNegative")), OButton.class, "com.obric.aiagent.plugin");
        this.f = (OButton) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.actionNeutral, DbHelper.COL_ID, "actionNeutral")), OButton.class, "com.obric.aiagent.plugin");
        this.i = (FrameLayout) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.custom_container, DbHelper.COL_ID, "custom_container")), FrameLayout.class, "com.obric.aiagent.plugin");
        return;
    L5:
        if (r2 == 1) goto L7;
        r3 = ZeusTransformUtils.mapRes(R.layout.o_dialog_button_primary, "layout", "o_dialog_button_primary");
        goto L9
    L7:
        r3 = ZeusTransformUtils.mapRes(R.layout.o_dialog_button_vertical, "layout", "o_dialog_button_vertical");
        goto L9
    }

    public final void a(CharSequence r6, DialogInterface.OnClickListener r7, b r8, boolean r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        final DialogInterface.OnClickListener r11 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r7, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        OButton r0 = this.f35046d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        View r1 = this.h;
        if (r1 == null) goto L13;
        r1.setVisibility(0);
    L13:
        if (r9 == false) goto L15;
        r0.setBackgroundTintList(androidx.core.content.a.b(this.f35044b, ZeusTransformUtils.mapRes(R.color.oui_red_6, "color", "oui_red_6")));
        r0.setTextColor(androidx.core.content.a.c(this.f35044b, ZeusTransformUtils.mapRes(R.color.white, "color", "white")));
    L15:
        r0.setText(r10);
        a(r0, r8);
        r0.setVisibility(0);
        r0.setOnClickListener(new $$Lambda$a$hvceQGohF3qqmetK2ZGqzB0TA8o(this, r11));
    }

    private static final void a(a r2, DialogInterface.OnClickListener r3, View r4) {
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r2, "this$0");
        OAlertDialog r6 = r2.g;
        if (r6 == null) goto L10;
        if (r5 == null) goto L8;
        r5.onClick((DialogInterface) ZeusTransformUtils.preCheckCast(r6, DialogInterface.class, "com.obric.aiagent.plugin"), -1);
    L8:
        r2.f();
        return;
    }

    public final void a(CharSequence r4, DialogInterface.OnClickListener r5, b r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        final DialogInterface.OnClickListener r8 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        OButton r0 = this.f35047e;
        if (r0 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r7) == false) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        View r1 = this.h;
        if (r1 == null) goto L13;
        r1.setVisibility(0);
    L13:
        r0.setText(r7);
        a(r0, r6);
        r0.setVisibility(0);
        r0.setOnClickListener(new $$Lambda$a$N8AGDh_yUs7KXUYWui7PRyHJ6kg(this, r8));
    }

    private static final void b(a r2, DialogInterface.OnClickListener r3, View r4) {
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r2, "this$0");
        OAlertDialog r6 = r2.g;
        if (r6 == null) goto L10;
        if (r5 == null) goto L8;
        r5.onClick((DialogInterface) ZeusTransformUtils.preCheckCast(r6, DialogInterface.class, "com.obric.aiagent.plugin"), -2);
    L8:
        r2.f();
        return;
    }

    public final void b(CharSequence r4, DialogInterface.OnClickListener r5, b r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        final DialogInterface.OnClickListener r8 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        OButton r0 = this.f;
        if (r0 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r7) == false) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        View r1 = this.h;
        if (r1 == null) goto L13;
        r1.setVisibility(0);
    L13:
        r0.setText(r7);
        a(r0, r6);
        r0.setVisibility(0);
        r0.setOnClickListener(new $$Lambda$a$yMjLX4HefjHJVf8uk1alSBIgD8(this, r8));
    }

    private static final void c(a r2, DialogInterface.OnClickListener r3, View r4) {
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r2, "this$0");
        OAlertDialog r6 = r2.g;
        if (r6 == null) goto L10;
        if (r5 == null) goto L8;
        r5.onClick((DialogInterface) ZeusTransformUtils.preCheckCast(r6, DialogInterface.class, "com.obric.aiagent.plugin"), -3);
    L8:
        r2.f();
        return;
    }

    public final void a(View r3) {
        o.e(r3, "view");
        if (this.f35045c == 2) goto L5;
        return;
    L5:
        if (this.i == null) goto L20;
        View r0 = this.h;
        if (r0 == null) goto L10;
        r0.setVisibility(0);
    L10:
        FrameLayout r1 = this.i;
        if (r1 == null) goto L14;
        r1.addView(r3);
    L14:
        FrameLayout r2 = this.i;
        if (r2 == null) goto L21;
        k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        return;
    L21:
        return;
    }

    public final OButton a() {
        return this.f35046d;
    }

    public final OButton b() {
        return this.f35047e;
    }

    public final OButton c() {
        return this.f;
    }

    private final void a(OButton r3, b r4) {
        if (r4 == null) goto L16;
        int r2 = c.f35052a[r4.ordinal()];
        if (r2 != 1) goto L6;
        int r5 = ZeusTransformUtils.mapRes(R.color.Negative, "color", "Negative");
    L14:
        r3.setTextColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5));
        return;
    L6:
        if (r2 != 2) goto L8;
        r5 = ZeusTransformUtils.mapRes(R.color.TextReverse, "color", "TextReverse");
        goto L14
    L8:
        if (r2 != 3) goto L11;
        r5 = ZeusTransformUtils.mapRes(R.color.TextReverse2, "color", "TextReverse2");
        goto L14
    L11:
        throw new d.k();
    }

    @Override // com.obric.oui.dialog.alert.d
    public void a(OAlertDialog r2) {
        o.e(r2, "dialog");
        this.g = r2;
    }

    private final void f() {
        OAlertDialog r0 = this.g;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        OAlertDialog r2 = this.g;
        if (r2 == null) goto L15;
        r2.dismiss();
        return;
    L15:
        return;
    L6:
        if (r0.isAutoDismiss() == true) goto L8;
        r1 = true;
        goto L8
    }
}
