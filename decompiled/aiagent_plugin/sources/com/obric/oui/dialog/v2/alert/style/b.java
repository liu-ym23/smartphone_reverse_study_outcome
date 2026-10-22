package com.obric.oui.dialog.v2.alert.style;

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
import com.obric.oui.d.h;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DefaultButtonStyleController.kt */
/* JADX INFO: loaded from: classes4.dex */
public class b extends com.obric.oui.dialog.v2.alert.style.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f35144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f35145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OButton f35146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OButton f35147e;
    private OButton f;
    private AlertDialogHost g;
    private View h;
    private FrameLayout i;

    /* JADX INFO: compiled from: DefaultButtonStyleController.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35148a = null;

        static {
            int[] r0 = new int[com.obric.oui.dialog.v2.alert.style.a.b.values().length];
            r0[com.obric.oui.dialog.v2.alert.style.a.b.f35142c.ordinal()] = 1;
            r0[com.obric.oui.dialog.v2.alert.style.a.b.f35140a.ordinal()] = 2;
            r0[com.obric.oui.dialog.v2.alert.style.a.b.f35141b.ordinal()] = 3;
            f35148a = r0;
        }
    }

    public static /* synthetic */ void lambda$MRGg43knBfuwNkfrcdpKJyYJGFM(b r0, DialogInterface.OnClickListener r1, View r2) {
        c(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$X0FceEF01_q7UVc681qQ1ehccIk(b r0, DialogInterface.OnClickListener r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$z1Pvs5qtG7CW6_1L3CIgtY0ZsDE(b r0, DialogInterface.OnClickListener r1, View r2) {
        b(r0, r1, r2);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.a, com.obric.oui.dialog.v2.alert.style.e
    public void a(AbstractDialog r1) {
        o.e(r1, "dialog");
    }

    @Override // com.obric.oui.dialog.v2.alert.style.a
    public /* synthetic */ View a() {
        return (View) ZeusTransformUtils.preCheckCast(d(), View.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.dialog.v2.alert.style.a
    public /* synthetic */ View b() {
        return (View) ZeusTransformUtils.preCheckCast(e(), View.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.dialog.v2.alert.style.a
    public /* synthetic */ View c() {
        return (View) ZeusTransformUtils.preCheckCast(f(), View.class, "com.obric.aiagent.plugin");
    }

    public final Context getContext() {
        return this.f35144b;
    }

    public b(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        this.f35144b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f35145c = r4;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.e
    public void a(Context r6, c r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        c r9 = (c) ZeusTransformUtils.wrapperContextForParams(r7, c.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        o.e(r9, "dialogContainer");
        FrameLayout r10 = r9.getButtonSlot();
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        int r2 = a(this.f35145c);
        View r11 = ZeusTransformUtils.inflate(LayoutInflater.from(r8), r2, (ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
        r10.addView(r11, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        this.h = r11;
        if (r11 == null) goto L6;
        r11.setVisibility(8);
    L6:
        this.f35146d = (OButton) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.actionPositive, DbHelper.COL_ID, "actionPositive")), OButton.class, "com.obric.aiagent.plugin");
        this.f35147e = (OButton) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.actionNegative, DbHelper.COL_ID, "actionNegative")), OButton.class, "com.obric.aiagent.plugin");
        this.f = (OButton) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.actionNeutral, DbHelper.COL_ID, "actionNeutral")), OButton.class, "com.obric.aiagent.plugin");
        this.i = (FrameLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.custom_container, DbHelper.COL_ID, "custom_container")), FrameLayout.class, "com.obric.aiagent.plugin");
    }

    public int a(int r3) {
        if (r3 == 0) goto L9;
        if (r3 == 1) goto L14;
        return ZeusTransformUtils.mapRes(R.layout.o_dialog_button_primary, "layout", "o_dialog_button_primary");
    L14:
        return ZeusTransformUtils.mapRes(R.layout.o_dialog_button_vertical, "layout", "o_dialog_button_vertical");
    L9:
        if (h.a(ZeusTransformUtils.getResources(this.f35144b, "com.obric.aiagent.plugin").getConfiguration().fontScale) == false) goto L12;
        return ZeusTransformUtils.mapRes(R.layout.o_dialog_button_vertical, "layout", "o_dialog_button_vertical");
    L12:
        return ZeusTransformUtils.mapRes(R.layout.o_dialog_button_horizontal, "layout", "o_dialog_button_horizontal");
    }

    @Override // com.obric.oui.dialog.v2.alert.style.a
    public void a(CharSequence r7, DialogInterface.OnClickListener r8, com.obric.oui.dialog.v2.alert.style.a.b r9, boolean r10) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        final DialogInterface.OnClickListener r12 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r8, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        OButton r0 = this.f35146d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r11) == false) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        View r2 = this.h;
        if (r2 == null) goto L13;
        r2.setVisibility(0);
    L13:
        if (r10 == false) goto L15;
        r0.setBackgroundColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_fill_element_2, "color", "oui_basic_fill_element_2")));
        r0.setTextColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, "color", "oui_functional_red_6")));
    L15:
        r0.setText(r11);
        a(r0, r9);
        r0.setVisibility(0);
        r0.setOnClickListener(new $$Lambda$b$X0FceEF01_q7UVc681qQ1ehccIk(this, r12));
    }

    private static final void a(b r2, DialogInterface.OnClickListener r3, View r4) {
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r2, "this$0");
        AlertDialogHost r6 = r2.g;
        if (r6 == null) goto L10;
        if (r5 == null) goto L8;
        r5.onClick((DialogInterface) ZeusTransformUtils.preCheckCast(r6, DialogInterface.class, "com.obric.aiagent.plugin"), -1);
    L8:
        r2.g();
        return;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.a
    public void a(CharSequence r4, DialogInterface.OnClickListener r5, com.obric.oui.dialog.v2.alert.style.a.b r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        final DialogInterface.OnClickListener r8 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        OButton r0 = this.f35147e;
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
        r0.setOnClickListener(new $$Lambda$b$z1Pvs5qtG7CW6_1L3CIgtY0ZsDE(this, r8));
    }

    private static final void b(b r2, DialogInterface.OnClickListener r3, View r4) {
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r2, "this$0");
        AlertDialogHost r6 = r2.g;
        if (r6 == null) goto L10;
        if (r5 == null) goto L8;
        r5.onClick((DialogInterface) ZeusTransformUtils.preCheckCast(r6, DialogInterface.class, "com.obric.aiagent.plugin"), -2);
    L8:
        r2.g();
        return;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.a
    public void b(CharSequence r4, DialogInterface.OnClickListener r5, com.obric.oui.dialog.v2.alert.style.a.b r6) {
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
        r0.setOnClickListener(new $$Lambda$b$MRGg43knBfuwNkfrcdpKJyYJGFM(this, r8));
    }

    private static final void c(b r2, DialogInterface.OnClickListener r3, View r4) {
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r2, "this$0");
        AlertDialogHost r6 = r2.g;
        if (r6 == null) goto L10;
        if (r5 == null) goto L8;
        r5.onClick((DialogInterface) ZeusTransformUtils.preCheckCast(r6, DialogInterface.class, "com.obric.aiagent.plugin"), -3);
    L8:
        r2.g();
        return;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.a
    public void a(View r3) {
        o.e(r3, "view");
        if (this.f35145c == 2) goto L5;
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

    public OButton d() {
        return this.f35146d;
    }

    public OButton e() {
        return this.f35147e;
    }

    public OButton f() {
        return this.f;
    }

    private final void a(OButton r3, com.obric.oui.dialog.v2.alert.style.a.b r4) {
        if (r4 == null) goto L16;
        int r2 = a.f35148a[r4.ordinal()];
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

    @Override // com.obric.oui.dialog.v2.alert.style.a, com.obric.oui.dialog.v2.alert.style.e
    public void a(AlertDialogHost r3) {
        AlertDialogHost r4 = (AlertDialogHost) ZeusTransformUtils.wrapperContextForParams(r3, AlertDialogHost.class, "com.obric.aiagent.plugin");
        o.e(r4, "host");
        this.g = r4;
        if (ZeusTransformUtils.instanceOf(r4, OAlertDialog.class) == false) goto L6;
        a((AbstractDialog) ZeusTransformUtils.preCheckCast(r4, AbstractDialog.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void g() {
        AlertDialogHost r0 = this.g;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        AlertDialogHost r2 = this.g;
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
