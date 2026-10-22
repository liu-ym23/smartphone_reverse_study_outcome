package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.alert.style.ImageStyleController;
import com.obric.oui.dialog.v2.alert.style.e;
import com.obric.oui.dialog.v2.common.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;
import d.h.b.p;
import d.x;

/* JADX INFO: compiled from: OAlertDialogBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public class a extends com.obric.oui.dialog.base.a<OAlertDialog> {
    private e A;
    private boolean B;
    private boolean C;
    private boolean D;
    private View E;
    private boolean F;
    private boolean G;
    private Boolean H;
    private m<? super Context, ? super Integer, ? extends com.obric.oui.dialog.v2.alert.style.a> I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f35127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CharSequence f35128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CharSequence f35129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f35130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f35131e;
    private String f;
    private b g;
    private com.obric.oui.dialog.v2.common.a h;
    private Integer i;
    private Integer j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private CharSequence o;
    private DialogInterface.OnClickListener p;
    private com.obric.oui.dialog.v2.alert.style.a.b q;
    private CharSequence r;
    private DialogInterface.OnClickListener s;
    private com.obric.oui.dialog.v2.alert.style.a.b t;
    private boolean u;
    private CharSequence v;
    private DialogInterface.OnClickListener w;
    private com.obric.oui.dialog.v2.alert.style.a.b x;
    private boolean y;
    private e z;

    /* JADX INFO: renamed from: com.obric.oui.dialog.v2.alert.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OAlertDialogBuilder.kt */
    static final class C0951a extends p implements d.h.a.b<CharSequence, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f35133b;

        C0951a(OAlertDialog r1, a r2) {
            this.f35132a = r1;
            this.f35133b = r2;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(CharSequence r3) {
            a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(CharSequence r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
            o.e(r6, "it");
            OAlertDialog.setMessage$default(this.f35132a, r6, false, 2, null);
            if (a.a(this.f35133b) == false) goto L6;
            this.f35132a.allowMoreThanTwoLinesMessage();
            return;
        }
    }

    /* JADX INFO: renamed from: lambda$DR-1DZVO8Ok79MW0RCx3OJRwE-o, reason: not valid java name */
    public static /* synthetic */ void m1035lambda$DR1DZVO8Ok79MW0RCx3OJRwEo(m r0, DialogInterface r1, int r2) {
        b(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$f4gkIfVdMylc44y3k1KOKHHXwPY(m r0, DialogInterface r1, int r2) {
        a(r0, r1, r2);
    }

    public static final /* synthetic */ boolean a(a r0) {
        return r0.D;
    }

    @Override // com.obric.oui.dialog.base.a
    public /* synthetic */ AbstractDialog b() {
        return (AbstractDialog) ZeusTransformUtils.preCheckCast(i(), AbstractDialog.class, "com.obric.aiagent.plugin");
    }

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        super(r4);
        this.f35127a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.f = "";
        this.y = true;
        super.c(false);
    }

    public static /* synthetic */ a a(a r2, CharSequence r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L8;
        r4 = false;
    L8:
        return r2.a(r7, r4);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: title");
    }

    public final a a(CharSequence r3, boolean r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.f35130d = r4;
        this.f35128b = r5;
        return this;
    }

    public final a a(int r4) {
        a(this, this.f35127a.getText(r4), false, 2, null);
        return this;
    }

    public final a a(CharSequence r3) {
        this.f35129c = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        return this;
    }

    public final a b(CharSequence r3) {
        a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        this.D = true;
        return this;
    }

    public static /* synthetic */ a a(a r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = false;
    L7:
        return r0.a(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: horizontalButton");
    }

    public final a a(boolean r2) {
        this.n = 0;
        this.u = r2;
        return this;
    }

    public static /* synthetic */ a a(a r2, CharSequence r3, DialogInterface.OnClickListener r4, com.obric.oui.dialog.v2.alert.style.a.b r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        DialogInterface.OnClickListener r9 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        return r2.a(r8, r9, r5);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: positiveButton");
    }

    public final a a(CharSequence r3, DialogInterface.OnClickListener r4, com.obric.oui.dialog.v2.alert.style.a.b r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        DialogInterface.OnClickListener r7 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r6, "text");
        this.r = r6;
        this.s = r7;
        this.t = r5;
        return this;
    }

    public final a a(CharSequence r3, m<? super DialogInterface, ? super Integer, x> r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        final m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        o.e(r5, "text");
        o.e(r6, "listener");
        this.r = r5;
        this.s = new $$Lambda$a$f4gkIfVdMylc44y3k1KOKHHXwPY(r6);
        return this;
    }

    private static final void a(m r2, DialogInterface r3, int r4) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.aiagent.plugin");
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        o.e(r5, "$listener");
        o.c(r6, "dialog");
        r5.invoke(r6, Integer.valueOf(r4));
    }

    public final a a(int r3, m<? super DialogInterface, ? super Integer, x> r4) {
        m<? super DialogInterface, ? super Integer, x> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        o.e(r5, "listener");
        String r6 = this.f35127a.getString(r3);
        o.c(r6, "context.getString(text)");
        return a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), r5);
    }

    public static /* synthetic */ a b(a r2, CharSequence r3, DialogInterface.OnClickListener r4, com.obric.oui.dialog.v2.alert.style.a.b r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        DialogInterface.OnClickListener r9 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        return r2.b(r8, r9, r5);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: negativeButton");
    }

    public final a b(CharSequence r3, DialogInterface.OnClickListener r4, com.obric.oui.dialog.v2.alert.style.a.b r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        DialogInterface.OnClickListener r7 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r6, "text");
        this.o = r6;
        this.p = r7;
        this.q = r5;
        return this;
    }

    public final a b(CharSequence r3, m<? super DialogInterface, ? super Integer, x> r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        final m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        o.e(r5, "text");
        o.e(r6, "listener");
        this.o = r5;
        this.p = new $$Lambda$a$DR1DZVO8Ok79MW0RCx3OJRwEo(r6);
        return this;
    }

    private static final void b(m r2, DialogInterface r3, int r4) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.aiagent.plugin");
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        o.e(r5, "$listener");
        o.c(r6, "dialog");
        r5.invoke(r6, Integer.valueOf(r4));
    }

    public final a b(int r3, m<? super DialogInterface, ? super Integer, x> r4) {
        m<? super DialogInterface, ? super Integer, x> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        o.e(r5, "listener");
        String r6 = this.f35127a.getString(r3);
        o.c(r6, "context.getString(text)");
        return b((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), r5);
    }

    public final a b(boolean r1) {
        this.y = r1;
        return this;
    }

    public final a a(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        o.e(r4, "controller");
        this.z = r4;
        return this;
    }

    public final a a() {
        this.F = true;
        return this;
    }

    public OAlertDialog i() {
        OAlertDialog r0 = a(this.f35127a, this.B);
        if (this.f35130d == false) goto L5;
        r0.setOnlyTitleText(this.f35128b);
    L6:
        a(this.f35129c, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C0951a(r0, this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        e r1 = this.A;
        if (r1 != null) goto L9;
        x r2 = null;
    L10:
        if (r2 != null) goto L15;
        ImageStyleController r3 = ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).j();
        if (r3 == null) goto L15;
        r0.setTopImageStyleController((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin"));
    L15:
        r0.setAutoDismiss(this.y);
        m<? super Context, ? super Integer, ? extends com.obric.oui.dialog.v2.alert.style.a> r4 = this.I;
        if (r4 != null) goto L18;
        com.obric.oui.dialog.v2.alert.style.a r5 = null;
    L19:
        if (r5 != null) goto L21;
        r5 = (com.obric.oui.dialog.v2.alert.style.a) ZeusTransformUtils.preCheckCast(new com.obric.oui.dialog.v2.alert.style.b(this.f35127a, this.n), com.obric.oui.dialog.v2.alert.style.a.class, "com.obric.aiagent.plugin");
    L21:
        r0.setButtonStyleController((e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin"));
        e r6 = this.z;
        if (r6 == null) goto L26;
        r0.setBodyStyleController(r6);
    L26:
        if (f() == true) goto L33;
        com.obric.oui.dialog.base.a r7 = (com.obric.oui.dialog.base.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.dialog.base.a.class, "com.obric.aiagent.plugin");
        if (this.n != 2) goto L30;
        boolean r8 = true;
    L31:
        com.obric.oui.dialog.base.a.a(r7, r8, null, 2, null);
        goto L33
    L30:
        r8 = false;
    L33:
        if (this.C == false) goto L36;
        com.obric.oui.dialog.base.a.a((com.obric.oui.dialog.base.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.dialog.base.a.class, "com.obric.aiagent.plugin"), false, null, 2, null);
    L36:
        if (this.F == false) goto L39;
        r0.forceHideFirstFrame();
    L39:
        if (this.G == false) goto L41;
        r0.adaptWindowDim();
    L41:
        r0.setIncludeCutoutInLandscape(this.H);
        r0.setOnShowListener(e());
        r0.setOnDismissListener(c());
        r0.setOnCancelListener(d());
        r5.a(this.r, this.s, this.t, this.u);
        r5.a(this.o, this.p, this.q);
        r5.b(this.v, this.w, this.x);
        View r9 = this.E;
        if (r9 == null) goto L44;
        o.a(r9);
        r5.a(r9);
    L44:
        return r0;
    L18:
        r5 = (com.obric.oui.dialog.v2.alert.style.a) ZeusTransformUtils.preCheckCast(r4.invoke(this.f35127a, Integer.valueOf(this.n)), com.obric.oui.dialog.v2.alert.style.a.class, "com.obric.aiagent.plugin");
        goto L19
    L9:
        r0.setTopImageStyleController(r1);
        r2 = x.f38692a;
        goto L10
    L5:
        r0.setTitleText(this.f35128b);
        goto L6
    }

    public OAlertDialog a(Context r2, boolean r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        return new OAlertDialog(r1, r3);
    }

    private final void a(CharSequence r2, d.h.a.b<? super CharSequence, x> r3) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r1) == true) goto L6;
        o.a(r1);
        r4.invoke(r1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ImageStyleController j() {
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        Object[] r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        r1 = false;
    L11:
        Drawable r2 = this.f35131e;
        if (r2 != null) goto L18;
        if (r1 == true) goto L18;
        if (this.h != null) goto L18;
        return null;
    L18:
        ImageStyleController r3 = new ImageStyleController(this.f35127a, this.k ? 1 : 0);
        r3.a(this.l);
        r3.b(this.m);
        com.obric.oui.dialog.v2.common.a r4 = this.h;
        if (r4 == null) goto L21;
        o.a(r4);
        r3.a(r4);
    L32:
        return r3;
    L21:
        if (r2 == null) goto L23;
        r3.a(r2);
        r3.a(this.i, this.j);
        goto L32
    L23:
        r3.a(this.f);
        b r5 = this.g;
        if (r5 == null) goto L27;
        r3.a(r5);
    L27:
        Integer r6 = this.i;
        if (r6 == null) goto L32;
        Integer r7 = this.j;
        if (r7 == null) goto L32;
        r3.a(r6, r7);
        goto L32
    L8:
        if (this.g == null) goto L10;
    L5:
        r0 = false;
        goto L6
    }
}
