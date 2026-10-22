package com.obric.autoaction.app.launcherpage.shortcut.cell;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.ao;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.PinShortCutActivity;
import com.obric.autoaction.app.launcherpage.a.ae;
import com.obric.autoaction.app.launcherpage.ui.c;
import com.obric.autoaction.app.launcherpage.ui.d;
import com.obric.autoaction.app.launcherpage.ui.e;
import com.obric.autoaction.app.launcherpage.ui.f;
import com.obric.autoaction.app.launcherpage.ui.g;
import com.obric.autoaction.app.launcherpage.utils.k;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.event.task.base.report.m;
import com.obric.oui.button.OIconButton;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: ShortCutCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends f<com.obric.autoaction.app.launcherpage.shortcut.cell.b> implements com.obric.autoaction.app.launcherpage.ui.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0561a f24417a = null;
    private ae s;
    private final d.f t;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.shortcut.cell.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShortCutCell.kt */
    public static final class C0561a {
        public /* synthetic */ C0561a(h r1) {
            this();
        }

        private C0561a() {
        }
    }

    /* JADX INFO: compiled from: PowerAdapter.kt */
    public static final class b implements d.f<com.obric.autoaction.app.launcherpage.shortcut.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f24418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a f24420c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.obric.autoaction.app.launcherpage.shortcut.a f24421d;

        public b(f r3, d.h.a.a r4, d.h.a.a r5) {
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f24418a = r3;
            this.f24419b = r6;
            this.f24420c = r7;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.shortcut.a] */
        @Override // d.f
        public /* synthetic */ com.obric.autoaction.app.launcherpage.shortcut.a b() {
            return a();
        }

        /* JADX WARN: Type inference failed for: r0v14, types: [androidx.lifecycle.aj, com.obric.autoaction.app.launcherpage.shortcut.a] */
        public com.obric.autoaction.app.launcherpage.shortcut.a a() {
            com.obric.autoaction.app.launcherpage.shortcut.a r0 = this.f24421d;
            if (r0 != null) goto L20;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24418a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r1, "getContext(...)");
            ComponentActivity r2 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.a(r1), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L19;
            ao r3 = r2.getViewModelStore();
            o.c(r3, "<get-viewModelStore>(...)");
            d.h.a.a r4 = this.f24419b;
            if (r4 == null) goto L10;
            am.b r5 = (am.b) ZeusTransformUtils.preCheckCast(r4.invoke(), am.b.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L10;
        L11:
            d.h.a.a r6 = this.f24420c;
            if (r6 == null) goto L15;
            androidx.lifecycle.a.a r7 = (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(r6.invoke(), androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L15;
        L16:
            ?? r8 = new am(r3, r5, r7).a(com.obric.autoaction.app.launcherpage.shortcut.a.class);
            this.f24421d = r8;
            return r8;
        L15:
            r7 = r2.getDefaultViewModelCreationExtras();
            o.c(r7, "<get-defaultViewModelCreationExtras>(...)");
        L10:
            r5 = r2.getDefaultViewModelProviderFactory();
            o.c(r5, "<get-defaultViewModelProviderFactory>(...)");
            goto L11
        L19:
            throw new IllegalStateException("can not convert " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24418a.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) + " to activity.");
        L20:
            return r0;
        }
    }

    static {
        f24417a = new C0561a(null);
    }

    public static /* synthetic */ x lambda$GsoI2lpfR1O22w1Y6toByEqVsDY(a r0, com.obric.autoaction.app.launcherpage.shortcut.cell.b r1, View r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$HqTYM7r2PZosaKFBaqOwpmOoPjA(a r0, View r1, int[] r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$PCPBwaetGFTVHDUrxqbF97FNk7g(a r0, com.obric.autoaction.app.launcherpage.shortcut.cell.b r1, DialogInterface r2, int r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$PndtRy7FsIZXSTGVuo2DflA7vtw(OPopoverEntranceMenuView.a r0, com.obric.autoaction.app.launcherpage.shortcut.cell.b r1, d.h.a.a r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$UzTiEp2X5L-QkIJkjZXGb7xJGpM, reason: not valid java name */
    public static /* synthetic */ x m557lambda$UzTiEp2X5LQkIJkjZXGb7xJGpM(z.f r0, Context r1, com.obric.autoaction.app.launcherpage.shortcut.cell.b r2, String r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$ZREWbO8FOu3NSgYSLNi12X9HBl8(OPopoverEntranceMenuView.a r0, com.obric.autoaction.app.launcherpage.shortcut.cell.b r1, d.h.a.a r2) {
        return b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$dGrMdBUXTHX-EzhH1ckJlypMFtQ, reason: not valid java name */
    public static /* synthetic */ x m558lambda$dGrMdBUXTHXEzhH1ckJlypMFtQ(z.f r0) {
        return a(r0);
    }

    public static /* synthetic */ x lambda$eU57lF4AV68i6cjeADPSGdmbD2k(z.a r0, d.h.a.a r1, boolean r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$frQllV41JtuaSL-9nYexszfyuXc, reason: not valid java name */
    public static /* synthetic */ x m559lambda$frQllV41JtuaSL9nYexszfyuXc(z.f r0, z.a r1, OEditText r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$ke9a3O7S7xgHvkVLbsrQ8wkxE5A(z.f r0, com.obric.autoaction.app.launcherpage.shortcut.cell.b r1, a r2, OPopoverEntranceMenuView.a r3, d.h.a.a r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ x lambda$o2QFYdXz0obkeiDBspWNg_sFZNs(a r0, com.obric.autoaction.app.launcherpage.shortcut.cell.b r1, d.h.a.a r2, View r3, int r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ x lambda$qMM7xm9gh8J9L5IqTWLV5SbUS8Y(a r0, com.obric.autoaction.app.launcherpage.shortcut.cell.b r1, View r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$tRZvJhPwLB6yFjGReAXrZH8IY5M(OPopoverEntranceMenuView.a r0, com.obric.autoaction.app.launcherpage.shortcut.cell.b r1, d.h.a.a r2) {
        return c(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$v0qfzS5Qhv_0euTTNLhmejiINF0(z.f r0) {
        return b(r0);
    }

    public static /* synthetic */ x lambda$wev3FJEsK5pt_WT56a3hr378W3Y(String r0, z.f r1, OInputLayout r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$xsVXHk-m5wa7qp_hIGn4H0ipXrQ, reason: not valid java name */
    public static /* synthetic */ x m560lambda$xsVXHkm5wa7qp_hIGn4H0ipXrQ(a r0, OPopoverEntranceMenuView.a r1, com.obric.autoaction.app.launcherpage.shortcut.cell.b r2, boolean r3, d.h.a.a r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ x lambda$zim8omK3tMoWcbgio2VeBt0klmE(d.h.a.a r0, a r1, com.obric.autoaction.app.launcherpage.shortcut.cell.b r2) {
        return a(r0, r1, r2);
    }

    public a() {
        this.t = (d.f) ZeusTransformUtils.preCheckCast(new b((f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin"), null, null), d.f.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3) {
        a((com.obric.autoaction.app.launcherpage.shortcut.cell.b) ZeusTransformUtils.preCheckCast((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.shortcut.cell.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3, List r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a((com.obric.autoaction.app.launcherpage.shortcut.cell.b) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.shortcut.cell.b.class, "com.obric.aiagent.plugin"), r6);
    }

    private final com.obric.autoaction.app.launcherpage.shortcut.a I() {
        return (com.obric.autoaction.app.launcherpage.shortcut.a) ZeusTransformUtils.preCheckCast(this.t.b(), com.obric.autoaction.app.launcherpage.shortcut.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r5) {
        o.e(r5, "parent");
        ae r6 = ae.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r5, false);
        o.c(r6, "inflate(...)");
        this.s = r6;
        ae r0 = null;
        if (r6 != null) goto L5;
        o.c("binding");
        r6 = null;
    L5:
        r6.b().setChangeAlphaWhenPress(false);
        ae r4 = this.s;
        if (r4 != null) goto L8;
        o.c("binding");
    L9:
        OUICardConstraintLayout r7 = r0.b();
        o.c(r7, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin");
    L8:
        r0 = r4;
        goto L9
    }

    public void a(final com.obric.autoaction.app.launcherpage.shortcut.cell.b r11) {
        o.e(r11, "item");
        super.a((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.preCheckCast(r11, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"));
        ae r0 = this.s;
        ae r2 = null;
        if (r0 != null) goto L5;
        o.c("binding");
        r0 = null;
    L5:
        OIconButton r1 = r0.f22721a;
        o.c(r1, "play");
        p.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), 0, new $$Lambda$a$qMM7xm9gh8J9L5IqTWLV5SbUS8Y(this, r11), 1, null);
        ae r3 = this.s;
        if (r3 != null) goto L8;
        o.c("binding");
    L9:
        OUICardConstraintLayout r4 = r2.b();
        o.c(r4, "getRoot(...)");
        p.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), 0, new $$Lambda$a$GsoI2lpfR1O22w1Y6toByEqVsDY(this, r11), 1, null);
        return;
    L8:
        r2 = r3;
        goto L9
    }

    private static final x a(a r1, com.obric.autoaction.app.launcherpage.shortcut.cell.b r2, View r3) {
        o.e(r3, "it");
        r1.I().a(r2.a(), "shortcut_card");
        return x.f38692a;
    }

    private static final x b(a r9, com.obric.autoaction.app.launcherpage.shortcut.cell.b r10, View r11) {
        o.e(r11, "it");
        com.obric.autoaction.app.launcherpage.detail.shortcut.a r1 = com.obric.autoaction.app.launcherpage.detail.shortcut.a.f23480a;
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r12, "null cannot be cast to non-null type android.app.Activity");
        com.obric.autoaction.app.launcherpage.detail.shortcut.a.a(r1, (Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(r12, Activity.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "enter_from_shortcut_tab_cell", r10.a(), null, null, 24, null);
        return x.f38692a;
    }

    public void a(com.obric.autoaction.app.launcherpage.shortcut.cell.b r11, List<? extends Object> r12) {
        List<? extends Object> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        o.e(r11, "item");
        o.e(r13, "payloads");
        super.a((com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.preCheckCast(r11, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin"), r13);
        com.obric.autoaction.app.launcherpage.module.view.a r14 = com.obric.autoaction.app.launcherpage.module.view.a.f24286a;
        String r0 = r11.a();
        View r2 = this.f35660b;
        o.c(r2, "itemView");
        r14.a(r0, r2);
        ae r15 = this.s;
        ae r1 = null;
        if (r15 != null) goto L5;
        o.c("binding");
        r15 = null;
    L5:
        r15.f22722b.setAlpha(1.0f);
        k r4 = k.f24509a;
        ae r16 = this.s;
        if (r16 != null) goto L8;
        o.c("binding");
        r16 = null;
    L8:
        ImageView r5 = r16.f22722b;
        o.c(r5, "semanticIcon");
        k.a(r4, r5, r11.d(), false, 4, null);
        if (r11.c() == null) goto L35;
        ae r17 = this.s;
        if (r17 != null) goto L13;
        o.c("binding");
        r17 = null;
    L13:
        r17.f22724d.setMaxLines(1);
        ae r18 = this.s;
        if (r18 != null) goto L16;
        o.c("binding");
        r18 = null;
    L16:
        float r6 = 2;
        r18.f22724d.setPadding(0, d.i.a.a(TypedValue.applyDimension(1, r6, Resources.getSystem().getDisplayMetrics())), 0, 0);
        ae r19 = this.s;
        if (r19 != null) goto L19;
        o.c("binding");
        r19 = null;
    L19:
        r19.f22724d.setText((CharSequence) ZeusTransformUtils.preCheckCast(r11.c(), CharSequence.class, "com.obric.aiagent.plugin"));
        ae r110 = this.s;
        if (r110 != null) goto L22;
        o.c("binding");
        r110 = null;
    L22:
        r110.f22723c.setMaxLines(1);
        ae r111 = this.s;
        if (r111 != null) goto L25;
        o.c("binding");
        r111 = null;
    L25:
        r111.f22723c.setPadding(0, 0, 0, d.i.a.a(TypedValue.applyDimension(1, r6, Resources.getSystem().getDisplayMetrics())));
        ae r112 = this.s;
        if (r112 != null) goto L28;
        o.c("binding");
        r112 = null;
    L28:
        r112.f22723c.setText((CharSequence) ZeusTransformUtils.preCheckCast(r11.b(), CharSequence.class, "com.obric.aiagent.plugin"));
        ae r113 = this.s;
        if (r113 != null) goto L31;
        o.c("binding");
        r113 = null;
    L31:
        r113.f22723c.setVisibility(0);
        ae r114 = this.s;
        if (r114 != null) goto L34;
        o.c("binding");
        r114 = null;
    L34:
        OIconButton r115 = r114.f22721a;
        o.c(r115, "play");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r115, View.class, "com.obric.aiagent.plugin"));
    L54:
        ae r116 = this.s;
        if (r116 != null) goto L57;
        o.c("binding");
    L58:
        OUICardConstraintLayout r117 = r1.b();
        o.c(r117, "getRoot(...)");
        p.a((View) ZeusTransformUtils.preCheckCast(r117, View.class, "com.obric.aiagent.plugin"), new $$Lambda$a$HqTYM7r2PZosaKFBaqOwpmOoPjA(this));
        return;
    L57:
        r1 = r116;
        goto L58
    L35:
        ae r118 = this.s;
        if (r118 != null) goto L38;
        o.c("binding");
        r118 = null;
    L38:
        r118.f22724d.setMaxLines(2);
        ae r119 = this.s;
        if (r119 != null) goto L41;
        o.c("binding");
        r119 = null;
    L41:
        r119.f22724d.setPadding(0, 0, 0, 0);
        ae r120 = this.s;
        if (r120 != null) goto L44;
        o.c("binding");
        r120 = null;
    L44:
        r120.f22724d.setText((CharSequence) ZeusTransformUtils.preCheckCast(r11.b(), CharSequence.class, "com.obric.aiagent.plugin"));
        ae r121 = this.s;
        if (r121 != null) goto L47;
        o.c("binding");
        r121 = null;
    L47:
        r121.f22723c.setPadding(0, 0, 0, 0);
        ae r122 = this.s;
        if (r122 != null) goto L50;
        o.c("binding");
        r122 = null;
    L50:
        r122.f22723c.setVisibility(8);
        ae r123 = this.s;
        if (r123 != null) goto L53;
        o.c("binding");
        r123 = null;
    L53:
        OIconButton r124 = r123.f22721a;
        o.c(r124, "play");
        com.obric.oui.common.util.k.a((View) ZeusTransformUtils.preCheckCast(r124, View.class, "com.obric.aiagent.plugin"));
        goto L54
    }

    private static final boolean a(a r3, View r4, int[] r5) {
        o.e(r4, "<unused var>");
        o.e(r5, "rawPos");
        d r6 = ((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin")).b();
        c r1 = null;
        if (r6 == null) goto L11;
        g r7 = r6.b();
        if (r7 == null) goto L11;
        c r8 = r7.a().get(com.obric.autoaction.app.launcherpage.ui.k.class);
        if (ZeusTransformUtils.instanceOf(r8, com.obric.autoaction.app.launcherpage.ui.k.class) == false) goto L10;
        r1 = r8;
    L10:
        r1 = (c) ZeusTransformUtils.preCheckCast((com.obric.autoaction.app.launcherpage.ui.k) ZeusTransformUtils.preCheckCast(r1, com.obric.autoaction.app.launcherpage.ui.k.class, "com.obric.aiagent.plugin"), c.class, "com.obric.aiagent.plugin");
    L11:
        if (r1 == null) goto L14;
        return false;
    L14:
        r3.a(r5);
        return true;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.b
    public d.h.a.a<x> a(int[] r6) {
        o.e(r6, "rawPos");
        final com.obric.autoaction.app.launcherpage.shortcut.cell.b r0 = (com.obric.autoaction.app.launcherpage.shortcut.cell.b) ZeusTransformUtils.preCheckCast(a(), com.obric.autoaction.app.launcherpage.shortcut.cell.b.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        return null;
    L6:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r1, "null cannot be cast to non-null type android.app.Activity");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(r1, Activity.class, "com.obric.aiagent.plugin");
        final z.f r3 = new z.f();
        com.obric.autoaction.app.launcherpage.module.a.h.f24077a.a(r2, r6, new $$Lambda$a$ke9a3O7S7xgHvkVLbsrQ8wkxE5A(r3, r0, this));
        return new $$Lambda$a$dGrMdBUXTHXEzhH1ckJlypMFtQ(r3);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T, d.h.a.a, java.lang.Object] */
    private static final x a(z.f r20, final com.obric.autoaction.app.launcherpage.shortcut.cell.b r21, final a r22, final OPopoverEntranceMenuView.a r23, d.h.a.a r24) {
        final ?? r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r23, "$this$showPopup");
        o.e(r4, "dismiss");
        r20.f38504a = r4;
        if (r21.c() == null) goto L5;
        com.obric.autoaction.app.launcherpage.module.a.h.f24077a.b(r23, ZeusTransformUtils.mapRes(R.string.task_copy_short_query, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_copy_short_query"), new $$Lambda$a$PndtRy7FsIZXSTGVuo2DflA7vtw(r23, r21, r4));
        com.obric.autoaction.app.launcherpage.module.a.h.f24077a.b(r23, ZeusTransformUtils.mapRes(R.string.task_copy_full_query, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_copy_full_query"), new $$Lambda$a$ZREWbO8FOu3NSgYSLNi12X9HBl8(r23, r21, r4));
    L8:
        final boolean r8 = com.obric.autoaction.app.launcherpage.utils.g.f24481a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r23.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r21.a());
        com.obric.autoaction.app.launcherpage.module.a.h r9 = com.obric.autoaction.app.launcherpage.module.a.h.f24077a;
        if (r8 == false) goto L11;
        r23.a(d.i.a.a(TypedValue.applyDimension(1, 220, Resources.getSystem().getDisplayMetrics())));
        int r0 = ZeusTransformUtils.mapRes(R.string.task_added_pinned_short_cut, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_added_pinned_short_cut");
    L12:
        r9.a(r23, r0, new $$Lambda$a$xsVXHkm5wa7qp_hIGn4H0ipXrQ(r22, r23, r21, r8, r4));
        com.obric.autoaction.app.launcherpage.module.a.h.f24077a.a(r23, new $$Lambda$a$zim8omK3tMoWcbgio2VeBt0klmE(r4, r22, r21));
        return x.f38692a;
    L11:
        r0 = ZeusTransformUtils.mapRes(R.string.task_add_pinned_short_cut, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_add_pinned_short_cut");
        goto L12
    L5:
        com.obric.autoaction.app.launcherpage.module.a.h.f24077a.b(r23, ZeusTransformUtils.mapRes(R.string.task_copy, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_copy"), new $$Lambda$a$tRZvJhPwLB6yFjGReAXrZH8IY5M(r23, r21, r4));
        if (r22.I().f() == false) goto L8;
        OPopoverEntranceMenuView.a.a(r23, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.oic_bolt_circle, "drawable", "oic_bolt_circle")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r23.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.auto_add_short_cut, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_add_short_cut")), CharSequence.class, "com.obric.aiagent.plugin"), null, null, false, null, new $$Lambda$a$o2QFYdXz0obkeiDBspWNg_sFZNs(r22, r21, r4), 246, null);
        goto L8
    }

    private static final x a(OPopoverEntranceMenuView.a r8, com.obric.autoaction.app.launcherpage.shortcut.cell.b r9, d.h.a.a r10) {
        d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.module.a.h.a(com.obric.autoaction.app.launcherpage.module.a.h.f24077a, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r9.c(), null, 4, null);
        r11.invoke();
        return x.f38692a;
    }

    private static final x b(OPopoverEntranceMenuView.a r8, com.obric.autoaction.app.launcherpage.shortcut.cell.b r9, d.h.a.a r10) {
        d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.module.a.h.a(com.obric.autoaction.app.launcherpage.module.a.h.f24077a, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r9.b(), null, 4, null);
        r11.invoke();
        return x.f38692a;
    }

    private static final x c(OPopoverEntranceMenuView.a r8, com.obric.autoaction.app.launcherpage.shortcut.cell.b r9, d.h.a.a r10) {
        d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.module.a.h.a(com.obric.autoaction.app.launcherpage.module.a.h.f24077a, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r9.b(), null, 4, null);
        r11.invoke();
        return x.f38692a;
    }

    private static final x a(a r1, com.obric.autoaction.app.launcherpage.shortcut.cell.b r2, d.h.a.a r3, View r4, int r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "v");
        com.obric.autoaction.app.launcherpage.detail.shortcut.a r7 = com.obric.autoaction.app.launcherpage.detail.shortcut.a.f23480a;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, FragmentActivity.class) == false) goto L5;
        FragmentActivity r9 = (FragmentActivity) ZeusTransformUtils.preCheckCast(r8, FragmentActivity.class, "com.obric.aiagent.plugin");
    L6:
        if (r9 == null) goto L8;
        r7.a(r9, r2.a(), "enter_from_add_instruct");
        r6.invoke();
        return x.f38692a;
    L8:
        return x.f38692a;
    L5:
        r9 = null;
        goto L6
    }

    private static final x a(a r2, OPopoverEntranceMenuView.a r3, com.obric.autoaction.app.launcherpage.shortcut.cell.b r4, boolean r5, d.h.a.a r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        r2.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, r5);
        r7.invoke();
        return x.f38692a;
    }

    private static final x a(d.h.a.a r12, final a r13, final com.obric.autoaction.app.launcherpage.shortcut.cell.b r14) {
        ((d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "getContext(...)");
        p.a(r2, p.a(ZeusTransformUtils.mapRes(R.string.condition_event_detail_delete_event, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_detail_delete_event"), null, 1, null), (CharSequence) ZeusTransformUtils.preCheckCast(p.a(ZeusTransformUtils.mapRes(R.string.condition_event_detail_delete_event_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_detail_delete_event_desc"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"), p.a(ZeusTransformUtils.mapRes(R.string.delete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "delete"), null, 1, null), null, true, false, new $$Lambda$a$PCPBwaetGFTVHDUrxqbF97FNk7g(r13, r14), 80, null);
        return x.f38692a;
    }

    private static final void a(a r1, com.obric.autoaction.app.launcherpage.shortcut.cell.b r2, DialogInterface r3, int r4) {
        ((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin")).dismiss();
        r1.I().a(r2.a());
    }

    private static final x a(z.f r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.preCheckCast(r2.f38504a, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.invoke();
    L6:
        return x.f38692a;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.obric.oui.button.OButton] */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, com.obric.oui.dialog.v2.misc.OSimpleFormDialog] */
    private final void a(Context r29, final com.obric.autoaction.app.launcherpage.shortcut.cell.b r30, boolean r31) {
        final Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r29, Context.class, "com.obric.aiagent.plugin");
        if (r31 == false) goto L5;
        Toast.makeText(r0, ZeusTransformUtils.mapRes(R.string.task_added_pinned_short_cut, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_added_pinned_short_cut"), 1).show();
        return;
    L5:
        final z.f r4 = new z.f();
        final String r5 = r30.c();
        if (r5 != null) goto L8;
        r5 = r30.b();
    L8:
        final z.f r6 = new z.f();
        r4.f38504a = new OSimpleFormDialog(r0, new OSimpleFormDialog.c((CharSequence) ZeusTransformUtils.preCheckCast(p.a(ZeusTransformUtils.mapRes(R.string.task_pinned_short_cut_label_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_pinned_short_cut_label_title"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), new OSimpleFormDialog.b(true, false, new $$Lambda$a$wev3FJEsK5pt_WT56a3hr378W3Y(r5, r6)), new OSimpleFormDialog.b(false, false, null, 4, null), new OBaseDialog.a(p.a(ZeusTransformUtils.mapRes(R.string.oui_confirm, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_confirm"), null, 1, null), new $$Lambda$a$UzTiEp2X5LQkIJkjZXGb7xJGpM(r4, r0, r30, r5), null, 4, null), new OBaseDialog.a(p.a(ZeusTransformUtils.mapRes(R.string.oui_cancel_only, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_cancel_only"), null, 1, null), new $$Lambda$a$v0qfzS5Qhv_0euTTNLhmejiINF0(r4), null, 4, null)));
        OSimpleFormDialog r1 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r4.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        r6.f38504a = r1.getPositiveButton();
        r1.show();
    }

    private static final x a(String r5, final z.f r6, OInputLayout r7) {
        o.e(r7, "it");
        final OEditText r0 = r7.getVInput();
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.e(r5, 50), CharSequence.class, "com.obric.aiagent.plugin"));
        r0.setHint((CharSequence) ZeusTransformUtils.preCheckCast(p.a(ZeusTransformUtils.mapRes(R.string.task_pinned_short_cut_label_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_pinned_short_cut_label_hint"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"));
        r0.selectAll();
        final z.a r8 = new z.a();
        final d.h.a.a r2 = new $$Lambda$a$frQllV41JtuaSL9nYexszfyuXc(r6, r8, r0);
        p.a(r7, 50, new $$Lambda$a$eU57lF4AV68i6cjeADPSGdmbD2k(r8, r2));
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r0, TextView.class, "com.obric.aiagent.plugin");
        TextWatcher r10 = new ShortCutCell$onAddPinShortCutClick$lambda$15$$inlined$addTextChangedListener$default$1(r2);
        r9.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r10, TextWatcher.class, "com.obric.aiagent.plugin"));
        TextWatcher r11 = (TextWatcher) ZeusTransformUtils.preCheckCast(r10, TextWatcher.class, "com.obric.aiagent.plugin");
        r2.invoke();
        return x.f38692a;
    }

    private static final x a(z.f r3, z.a r4, OEditText r5) {
        View r6 = (View) ZeusTransformUtils.preCheckCast(r3.f38504a, View.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L22;
        boolean r0 = true;
        if (r4.f38499a == true) goto L19;
        Editable r7 = r5.getText();
        if (r7 == null) goto L9;
        String r8 = r7.toString();
    L10:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L13;
    L16:
        boolean r10 = true;
    L17:
        if (r10 == true) goto L19;
    L20:
        r6.setEnabled(r0);
        goto L22
    L13:
        if (r9.length() == 0) goto L16;
        r10 = false;
        goto L17
    L9:
        r8 = null;
    L19:
        r0 = false;
    L22:
        return x.f38692a;
    }

    private static final x a(z.a r2, d.h.a.a r3, boolean r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        r2.f38499a = r4;
        r5.invoke();
        return x.f38692a;
    }

    private static final x a(z.f r11, Context r12, com.obric.autoaction.app.launcherpage.shortcut.cell.b r13, String r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        OSimpleFormDialog r15 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r11.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L11;
        OInputLayout r16 = r15.getInputView1();
        if (r16 == null) goto L11;
        OEditText r17 = r16.getVInput();
        if (r17 == null) goto L11;
        Editable r18 = r17.getText();
        if (r18 == null) goto L11;
        String r19 = r18.toString();
    L12:
        if (r19 != null) goto L14;
    L20:
        m.f32868a.c();
        com.obric.autoaction.app.launcherpage.utils.g r2 = com.obric.autoaction.app.launcherpage.utils.g.f24481a;
        String r4 = r13.a();
        if (r19 != null) goto L23;
        String r5 = r14;
    L24:
        Intent r6 = PinShortCutActivity.Companion.a(r3, r13.a());
        Bitmap r110 = k.f24509a.a(r3, r13.d());
        if (r110 == null) goto L27;
        Icon r7 = Icon.createWithBitmap(r110);
    L28:
        com.obric.autoaction.app.launcherpage.utils.g.a(r2, r3, r4, r5, r6, r7, null, 32, null);
        OSimpleFormDialog r111 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r11.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        if (r111 == null) goto L32;
        r111.dismiss();
    L32:
        return x.f38692a;
    L27:
        r7 = null;
        goto L28
    L23:
        r5 = r19;
        goto L24
    L14:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L20;
        return x.f38692a;
    L16:
        r8 = false;
    L11:
        r19 = null;
        goto L12
    }

    private static final x b(z.f r2) {
        OSimpleFormDialog r3 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r2.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.dismiss();
    L6:
        return x.f38692a;
    }
}
