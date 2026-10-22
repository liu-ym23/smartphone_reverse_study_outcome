package com.obric.autoaction.vdplayer.components;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Window;
import androidx.core.view.ai;
import androidx.lifecycle.p;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.a.f;
import com.obric.autoaction.vdplayer.d.q;
import com.obric.autoaction.vdplayer.d.r;
import com.obric.autoaction.vdplayer.d.u;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: TakeOverConfirmDialogComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TakeOverConfirmDialogComponent implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Dialog f25326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private u f25327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f25328c;

    /* JADX INFO: compiled from: TakeOverConfirmDialogComponent.kt */
    @d.c.b.a.f(b = "TakeOverConfirmDialogComponent.kt", c = {28}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.components.TakeOverConfirmDialogComponent$onAttach$1")
    static final class a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TakeOverConfirmDialogComponent f25330b;

        a(TakeOverConfirmDialogComponent r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25330b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f25330b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25329a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            o.a(r6);
        L16:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            u r7 = TakeOverConfirmDialogComponent.a(this.f25330b);
            if (r7 == null) goto L18;
            ab<q> r8 = r7.c();
            if (r8 == null) goto L18;
            final TakeOverConfirmDialogComponent r3 = this.f25330b;
            i<? super q> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f25329a = 1;
            if (r8.collect(r2, r4) != r0) goto L16;
            return r0;
        L18:
            return x.f38692a;
        }
    }

    /* JADX INFO: renamed from: lambda$RDF8FwkarKJobL0_PcjWnZ0-ZfY, reason: not valid java name */
    public static /* synthetic */ x m659lambda$RDF8FwkarKJobL0_PcjWnZ0ZfY(DialogInterface r0, int r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$TekN6rUZEr_ObNFZLNAwLmfaO9A(TakeOverConfirmDialogComponent r0, OAlertDialog r1, DialogInterface r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$WVudwbw_IlIKIhFVRm6RWIXLDnI(TakeOverConfirmDialogComponent r0, DialogInterface r1, int r2) {
        return a(r0, r1, r2);
    }

    public TakeOverConfirmDialogComponent() {
    }

    public static final /* synthetic */ u a(TakeOverConfirmDialogComponent r0) {
        return r0.f25327b;
    }

    public static final /* synthetic */ void b(TakeOverConfirmDialogComponent r0) {
        r0.a();
    }

    public static final /* synthetic */ void c(TakeOverConfirmDialogComponent r0) {
        r0.b();
    }

    @Override // com.obric.autoaction.a.f
    public void a(com.obric.autoaction.a.c r9) {
        d.h.b.o.e(r9, "componentHost");
        this.f25328c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f25327b = (u) ZeusTransformUtils.preCheckCast(r9.c().a(u.class), u.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(r9.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new a(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void a() {
        Context r0 = this.f25328c;
        if (r0 != null) goto L5;
        return;
    L5:
        Dialog r1 = this.f25326a;
        boolean r2 = true;
        if (r1 != null) goto L8;
    L10:
        r2 = false;
    L11:
        if (r2 == false) goto L13;
        return;
    L13:
        final OAlertDialog r3 = (OAlertDialog) ZeusTransformUtils.preCheckCast(new com.obric.oui.dialog.v2.alert.a(r0).b(false).a(ZeusTransformUtils.mapRes(R.string.vd_takeover_confirm_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "vd_takeover_confirm_title")).a(false).a(ZeusTransformUtils.mapRes(R.string.vd_takeover_confirm_confirm, WsChannelMultiProcessSharedProvider.STRING_TYPE, "vd_takeover_confirm_confirm"), new $$Lambda$TakeOverConfirmDialogComponent$WVudwbw_IlIKIhFVRm6RWIXLDnI(this)).b(ZeusTransformUtils.mapRes(R.string.vd_takeover_confirm_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "vd_takeover_confirm_cancel"), $$Lambda$TakeOverConfirmDialogComponent$RDF8FwkarKJobL0_PcjWnZ0ZfY.INSTANCE).g(), OAlertDialog.class, "com.obric.aiagent.plugin");
        r3.setOnDismissListener(new $$Lambda$TakeOverConfirmDialogComponent$TekN6rUZEr_ObNFZLNAwLmfaO9A(this, r3));
        this.f25326a = (Dialog) ZeusTransformUtils.preCheckCast(r3, Dialog.class, "com.obric.aiagent.plugin");
        r3.show();
        if (ZeusTransformUtils.instanceOf(r0, Activity.class) == false) goto L16;
        Activity r6 = (Activity) ZeusTransformUtils.preCheckCast(r0, Activity.class, "com.obric.aiagent.plugin");
    L17:
        if (r6 == null) goto L25;
        Window r7 = ZeusTransformUtils.getWindow(r6, "com.obric.aiagent.plugin");
        if (r7 == null) goto L27;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L26;
        r4.setNavigationBarColor(r7.getNavigationBarColor());
        r4.setNavigationBarDividerColor(r7.getNavigationBarDividerColor());
        r4.setNavigationBarContrastEnforced(r7.isNavigationBarContrastEnforced());
        ai.a(r4, r4.getDecorView()).b(ai.a(r7, r7.getDecorView()).a());
        return;
    L26:
        return;
    L27:
        return;
    L25:
        return;
    L16:
        r6 = null;
        goto L17
    L8:
        if (r1.isShowing() != true) goto L10;
        goto L10
    }

    private static final x a(TakeOverConfirmDialogComponent r1, DialogInterface r2, int r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "dialog");
        r4.dismiss();
        u r5 = r1.f25327b;
        if (r5 == null) goto L6;
        r5.a((com.obric.autoaction.vdplayer.c.b) ZeusTransformUtils.preCheckCast(r.c.f25541a, com.obric.autoaction.vdplayer.c.b.class, "com.obric.aiagent.plugin"));
    L6:
        return x.f38692a;
    }

    private static final x a(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "dialog");
        r3.dismiss();
        return x.f38692a;
    }

    private static final void a(TakeOverConfirmDialogComponent r2, OAlertDialog r3, DialogInterface r4) {
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.class, "com.obric.aiagent.plugin");
        if (r2.f25326a != r3) goto L6;
        r2.f25326a = null;
        return;
    }

    private final void b() {
        Dialog r0 = this.f25326a;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        this.f25326a = null;
    }

    @Override // androidx.lifecycle.d
    public void d(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "owner");
        super.d(r4);
        b();
    }

    @Override // androidx.lifecycle.d
    public void e(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "owner");
        super.e(r4);
        b();
        this.f25328c = ZeusTransformUtils.wrapperContext(null, "com.obric.aiagent.plugin");
        this.f25327b = null;
    }
}
