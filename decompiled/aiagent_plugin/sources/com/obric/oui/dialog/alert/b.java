package com.obric.oui.dialog.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.obric.oui.dialog.base.AbstractDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;
import d.h.b.p;
import d.x;

/* JADX INFO: compiled from: OAlertDialogBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public class b extends com.obric.oui.dialog.base.a<OAlertDialog> {
    private boolean A;
    private boolean B;
    private boolean C;
    private View D;
    private boolean E;
    private boolean F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f35053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CharSequence f35054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CharSequence f35055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f35056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f35057e;
    private String f;
    private com.obric.oui.dialog.alert.view.a g;
    private a h;
    private Integer i;
    private Integer j;
    private boolean k;
    private int l;
    private CharSequence m;
    private DialogInterface.OnClickListener n;
    private com.obric.oui.dialog.alert.a.b o;
    private CharSequence p;
    private DialogInterface.OnClickListener q;
    private com.obric.oui.dialog.alert.a.b r;
    private boolean s;
    private CharSequence t;
    private DialogInterface.OnClickListener u;
    private com.obric.oui.dialog.alert.a.b v;
    private boolean w;
    private d x;
    private d y;
    private boolean z;

    /* JADX INFO: compiled from: OAlertDialogBuilder.kt */
    public interface a {
        void a(ImageView r1);
    }

    /* JADX INFO: renamed from: com.obric.oui.dialog.alert.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OAlertDialogBuilder.kt */
    static final class C0950b extends p implements d.h.a.b<CharSequence, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f35058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35059b;

        C0950b(b r1, OAlertDialog r2) {
            this.f35058a = r1;
            this.f35059b = r2;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(CharSequence r3) {
            a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            o.e(r4, "it");
            if (b.a(this.f35058a) == false) goto L5;
            this.f35059b.setOnlyTitleText(r4);
            return;
        L5:
            this.f35059b.setTitleText(r4);
        }
    }

    /* JADX INFO: compiled from: OAlertDialogBuilder.kt */
    static final class c extends p implements d.h.a.b<CharSequence, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f35061b;

        c(OAlertDialog r1, b r2) {
            this.f35060a = r1;
            this.f35061b = r2;
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
            OAlertDialog.setMessage$default(this.f35060a, r6, false, 2, null);
            if (b.b(this.f35061b) == false) goto L6;
            this.f35060a.allowMoreThanTwoLinesMessage();
            return;
        }
    }

    /* JADX INFO: renamed from: lambda$0BpzzckVIJBFY-UzEZS8Ighn0nM, reason: not valid java name */
    public static /* synthetic */ void m1004lambda$0BpzzckVIJBFYUzEZS8Ighn0nM(m r0, DialogInterface r1, int r2) {
        a(r0, r1, r2);
    }

    public final b b(int r7, DialogInterface.OnClickListener r8) {
        return a(this, r7, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r8, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin"), null, 4, null);
    }

    public final b c(int r7, DialogInterface.OnClickListener r8) {
        return b(this, r7, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r8, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin"), null, 4, null);
    }

    public static final /* synthetic */ boolean a(b r0) {
        return r0.f35056d;
    }

    public static final /* synthetic */ boolean b(b r0) {
        return r0.C;
    }

    @Override // com.obric.oui.dialog.base.a
    public /* synthetic */ AbstractDialog b() {
        return (AbstractDialog) ZeusTransformUtils.preCheckCast(a(), AbstractDialog.class, "com.obric.aiagent.plugin");
    }

    public b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        super(r4);
        this.f35053a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.f = "";
        this.w = true;
        super.c(false);
    }

    public static /* synthetic */ b a(b r2, CharSequence r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L8;
        r4 = false;
    L8:
        return r2.a(r7, r4);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: title");
    }

    public final b a(CharSequence r3, boolean r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.f35056d = r4;
        this.f35054b = r5;
        return this;
    }

    public final b a(int r4) {
        a(this, (CharSequence) ZeusTransformUtils.preCheckCast(this.f35053a.getString(r4), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null);
        return this;
    }

    public final b a(CharSequence r3) {
        this.f35055c = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        return this;
    }

    public final b b(CharSequence r3) {
        a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        this.C = true;
        return this;
    }

    public final b b(int r2) {
        Drawable r3 = androidx.appcompat.a.a.a.b(this.f35053a, r2);
        o.a(r3);
        o.c(r3, "getDrawable(context, icon)!!");
        return a(r3);
    }

    public final b a(Drawable r2) {
        o.e(r2, "drawable");
        this.f35057e = r2;
        this.k = false;
        return this;
    }

    public final b a(int r1, int r2) {
        this.i = Integer.valueOf(r1);
        this.j = Integer.valueOf(r2);
        return this;
    }

    public static /* synthetic */ b a(b r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = false;
    L7:
        return r0.a(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verticalButton");
    }

    public final b a(boolean r2) {
        this.l = 1;
        this.s = r2;
        return this;
    }

    public final b a(CharSequence r3, DialogInterface.OnClickListener r4, com.obric.oui.dialog.alert.a.b r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        DialogInterface.OnClickListener r7 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r6, "text");
        this.p = r6;
        this.q = r7;
        this.r = r5;
        return this;
    }

    public static /* synthetic */ b a(b r2, int r3, DialogInterface.OnClickListener r4, com.obric.oui.dialog.alert.a.b r5, int r6, Object r7) {
        DialogInterface.OnClickListener r8 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        return r2.a(r3, r8, r5);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: positiveButton");
    }

    public final b a(int r3, DialogInterface.OnClickListener r4, com.obric.oui.dialog.alert.a.b r5) {
        DialogInterface.OnClickListener r6 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        String r7 = this.f35053a.getString(r3);
        o.c(r7, "context.getString(text)");
        return a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), r6, r5);
    }

    public static /* synthetic */ b a(b r2, CharSequence r3, DialogInterface.OnClickListener r4, com.obric.oui.dialog.alert.a.b r5, int r6, Object r7) {
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

    public final b b(CharSequence r3, DialogInterface.OnClickListener r4, com.obric.oui.dialog.alert.a.b r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        DialogInterface.OnClickListener r7 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r6, "text");
        this.m = r6;
        this.n = r7;
        this.o = r5;
        return this;
    }

    public static /* synthetic */ b b(b r2, int r3, DialogInterface.OnClickListener r4, com.obric.oui.dialog.alert.a.b r5, int r6, Object r7) {
        DialogInterface.OnClickListener r8 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        return r2.b(r3, r8, r5);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: negativeButton");
    }

    public final b b(int r8, DialogInterface.OnClickListener r9, com.obric.oui.dialog.alert.a.b r10) {
        DialogInterface.OnClickListener r3 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r9, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        String r11 = this.f35053a.getString(r8);
        o.c(r11, "context.getString(text)");
        return a(this, (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), r3, null, 4, null);
    }

    public static /* synthetic */ b b(b r2, CharSequence r3, DialogInterface.OnClickListener r4, com.obric.oui.dialog.alert.a.b r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        DialogInterface.OnClickListener r9 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        return r2.c(r8, r9, r5);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: neutralButton");
    }

    public final b c(CharSequence r3, DialogInterface.OnClickListener r4, com.obric.oui.dialog.alert.a.b r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        DialogInterface.OnClickListener r7 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r6, "text");
        this.t = r6;
        this.u = r7;
        this.v = r5;
        this.l = 1;
        return this;
    }

    public final b a(CharSequence r3, m<? super DialogInterface, ? super Integer, x> r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        final m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        o.e(r5, "text");
        o.e(r6, "listener");
        this.t = r5;
        this.u = new $$Lambda$b$0BpzzckVIJBFYUzEZS8Ighn0nM(r6);
        return this;
    }

    private static final void a(m r2, DialogInterface r3, int r4) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.aiagent.plugin");
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        o.e(r5, "$listener");
        o.c(r6, "dialog");
        r5.invoke(r6, Integer.valueOf(r4));
    }

    public final b a(int r9, DialogInterface.OnClickListener r10) {
        DialogInterface.OnClickListener r4 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r10, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        String r11 = this.f35053a.getString(r9);
        o.c(r11, "context.getString(text)");
        return b(this, (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), r4, null, 4, null);
    }

    public final b a(int r3, m<? super DialogInterface, ? super Integer, x> r4) {
        m<? super DialogInterface, ? super Integer, x> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        o.e(r5, "listener");
        String r6 = this.f35053a.getString(r3);
        o.c(r6, "context.getString(text)");
        return a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), r5);
    }

    public final b b(boolean r1) {
        this.w = r1;
        return this;
    }

    public final b a(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        o.e(r4, "controller");
        this.x = r4;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OAlertDialog a() {
        OAlertDialog r0 = a(this.f35053a, this.A, this.z);
        a(this.f35054b, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C0950b(this, r0), d.h.a.b.class, "com.obric.aiagent.plugin"));
        a(this.f35055c, (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r0, this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        d r1 = this.y;
        if (r1 != null) goto L5;
        x r2 = null;
    L6:
        boolean r3 = true;
        if (r2 != null) goto L37;
        b r4 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4.f, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
        Object[] r6 = true;
    L12:
        if (r6 == true) goto L14;
    L16:
        Object[] r7 = false;
    L17:
        Drawable r8 = r4.f35057e;
        if (r8 != null) goto L22;
        if (r7 == true) goto L22;
        if (r4.h == null) goto L37;
    L22:
        ImageStyleController r9 = new ImageStyleController(r4.f35053a, r4.k ? 1 : 0);
        a r10 = r4.h;
        if (r10 == null) goto L25;
        o.a(r10);
        r9.a(r10);
    L36:
        r0.setTopImageStyleController((d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.aiagent.plugin"));
        goto L37
    L25:
        if (r8 == null) goto L27;
        r9.a(r8);
        r9.a(r4.i, r4.j);
        goto L36
    L27:
        r9.a(r4.f);
        com.obric.oui.dialog.alert.view.a r11 = r4.g;
        if (r11 == null) goto L31;
        r9.a(r11);
    L31:
        Integer r12 = r4.i;
        if (r12 == null) goto L36;
        Integer r5 = r4.j;
        if (r5 == null) goto L36;
        r9.a(r12, r5);
        goto L36
    L14:
        if (r4.g == null) goto L16;
        r7 = true;
        goto L17
    L11:
        r6 = false;
    L37:
        r0.setAutoDismiss(this.w);
        com.obric.oui.dialog.alert.a r13 = new com.obric.oui.dialog.alert.a(this.f35053a, this.l);
        r0.setButtonStyleController((d) ZeusTransformUtils.preCheckCast(r13, d.class, "com.obric.aiagent.plugin"));
        d r14 = this.x;
        if (r14 == null) goto L42;
        r0.setBodyStyleController(r14);
    L42:
        if (f() == true) goto L49;
        com.obric.oui.dialog.base.a r15 = (com.obric.oui.dialog.base.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.dialog.base.a.class, "com.obric.aiagent.plugin");
        if (this.l == 2) goto L47;
        r3 = false;
    L47:
        com.obric.oui.dialog.base.a.a(r15, r3, null, 2, null);
    L49:
        if (this.B == false) goto L52;
        com.obric.oui.dialog.base.a.a((com.obric.oui.dialog.base.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.dialog.base.a.class, "com.obric.aiagent.plugin"), false, null, 2, null);
    L52:
        if (this.E == false) goto L55;
        r0.forceHideFirstFrame();
    L55:
        if (this.F == false) goto L57;
        r0.adaptWindowDim();
    L57:
        r0.setOnShowListener(e());
        r0.setOnDismissListener(c());
        r0.setOnCancelListener(d());
        r13.a(this.p, this.q, this.r, this.s);
        r13.a(this.m, this.n, this.o);
        r13.b(this.t, this.u, this.v);
        View r16 = this.D;
        if (r16 == null) goto L60;
        o.a(r16);
        r13.a(r16);
    L60:
        return r0;
    L5:
        r0.setTopImageStyleController(r1);
        r2 = x.f38692a;
        goto L6
    }

    public OAlertDialog a(Context r2, boolean r3, boolean r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        return new OAlertDialog(r1, r3, r4);
    }

    private final void a(CharSequence r2, d.h.a.b<? super CharSequence, x> r3) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r1) == true) goto L6;
        o.a(r1);
        r4.invoke(r1);
        return;
    }
}
