package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.z;
import d.x;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: LowStorageCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: compiled from: LowStorageCondition.kt */
    static final class a implements d.h.a.b<OInputLayout, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f23037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z.f<View> f23038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z.f<OSimpleFormDialog> f23039c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f23040d;

        a(int r3, z.f<View> r4, z.f<OSimpleFormDialog> r5, Context r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            this.f23037a = r3;
            this.f23038b = r4;
            this.f23039c = r5;
            this.f23040d = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(OInputLayout r3) {
            a((OInputLayout) ZeusTransformUtils.preCheckCast(r3, OInputLayout.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(OInputLayout r5) {
            o.e(r5, "it");
            r5.getVInput().setInputType(2);
            r5.getVInput().setText((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(this.f23037a), CharSequence.class, "com.obric.aiagent.plugin"));
            r5.getVInput().setHint((CharSequence) ZeusTransformUtils.preCheckCast("20%", CharSequence.class, "com.obric.aiagent.plugin"));
            r5.getVInput().selectAll();
            TextView r6 = (TextView) ZeusTransformUtils.preCheckCast(r5.getVInput(), TextView.class, "com.obric.aiagent.plugin");
            final z.f<View> r0 = this.f23038b;
            final z.f<OSimpleFormDialog> r1 = this.f23039c;
            final Context r4 = this.f23040d;
            TextWatcher r2 = new LowStorageConditionKt$selectLowStoragePercent$2$1$invoke$$inlined$addTextChangedListener$default$1(r0, r1, r4);
            r6.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r2, TextWatcher.class, "com.obric.aiagent.plugin"));
            TextWatcher r7 = (TextWatcher) ZeusTransformUtils.preCheckCast(r2, TextWatcher.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: LowStorageCondition.kt */
    static final class b implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z.f<OSimpleFormDialog> f23041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z.a f23042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z.a f23043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ n<Integer> f23044d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ z.f<View> f23045e;
        final /* synthetic */ Context f;

        b(z.f<OSimpleFormDialog> r3, z.a r4, z.a r5, n<? super Integer> r6, z.f<View> r7, Context r8) {
            n<Integer> r9 = (n) ZeusTransformUtils.wrapperContextForParams(r6, n.class, "com.obric.aiagent.plugin");
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
            this.f23041a = r3;
            this.f23042b = r4;
            this.f23043c = r5;
            this.f23044d = r9;
            this.f23045e = r7;
            this.f = ZeusTransformUtils.wrapperContext(r10, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            OSimpleFormDialog r0 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(this.f23041a.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
            String r1 = null;
            if (r0 == null) goto L15;
            OInputLayout r2 = r0.getInputView1();
            if (r2 == null) goto L15;
            OEditText r3 = r2.getVInput();
            if (r3 == null) goto L15;
            Editable r4 = r3.getText();
            if (r4 == null) goto L15;
            String r5 = r4.toString();
            if (r5 == null) goto L15;
            String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (r6 == null) goto L15;
            Integer r7 = d.o.o.d(r6);
        L16:
            if (r7 != null) goto L18;
        L27:
            z.f<View> r8 = this.f23045e;
            z.f<OSimpleFormDialog> r9 = this.f23041a;
            Context r10 = this.f;
            OSimpleFormDialog r11 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r9.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L38;
            OInputLayout r12 = r11.getInputView1();
            if (r12 == null) goto L38;
            OEditText r13 = r12.getVInput();
            if (r13 == null) goto L38;
            Editable r14 = r13.getText();
            if (r14 == null) goto L38;
            String r15 = r14.toString();
            if (r15 == null) goto L38;
            r1 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        L38:
            if (r1 != null) goto L40;
            r1 = "";
        L40:
            i.a(r8, r9, r10, r1);
            return;
        L18:
            if (new d.l.j(1, 100).a(r7.intValue()) == false) goto L27;
            if (this.f23042b.f38499a == true) goto L42;
            this.f23042b.f38499a = true;
            this.f23043c.f38499a = true;
            OSimpleFormDialog r16 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(this.f23041a.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L25;
            r16.dismiss();
        L25:
            d.c.d r17 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f23044d, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r18 = d.n.f38560a;
            r17.resumeWith(d.n.f(r7));
            return;
        L42:
            return;
        L15:
            r7 = null;
            goto L16
        }
    }

    /* JADX INFO: compiled from: LowStorageCondition.kt */
    static final class c implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z.f<OSimpleFormDialog> f23046a;

        c(z.f<OSimpleFormDialog> r1) {
            this.f23046a = r1;
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            OSimpleFormDialog r2 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(this.f23046a.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L6;
            r2.dismiss();
            return;
        }
    }

    /* JADX INFO: compiled from: LowStorageCondition.kt */
    static final class d implements d.h.a.b<Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z.a f23047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z.f<OSimpleFormDialog> f23048b;

        d(z.a r1, z.f<OSimpleFormDialog> r2) {
            this.f23047a = r1;
            this.f23048b = r2;
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(Throwable r2) {
            if (this.f23047a.f38499a == true) goto L8;
            this.f23047a.f38499a = true;
            OSimpleFormDialog r1 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(this.f23048b.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L9;
            r1.dismiss();
            return;
        L9:
            return;
        }
    }

    public static final /* synthetic */ Object a(Context r2, int r3, d.c.d r4) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(z.f r2, z.f r3, Context r4, String r5) {
        b(r2, r3, (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), r5);
    }

    private static final void b(z.f<View> r7, z.f<OSimpleFormDialog> r8, Context r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        Integer r0 = d.o.o.d(r10);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        View r12 = (View) ZeusTransformUtils.preCheckCast(r7.f38504a, View.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L11;
        r12.setEnabled(r1);
    L11:
        OSimpleFormDialog r13 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r8.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L17;
        OInputLayout r14 = r13.getInputView1();
        if (r14 == null) goto L17;
        r14.setTip((CharSequence) ZeusTransformUtils.preCheckCast(r11.getString(ZeusTransformUtils.mapRes(R.string.condition_input_percent_tip, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_input_percent_tip")), CharSequence.class, "com.obric.aiagent.plugin"));
    L17:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L19;
        boolean r15 = true;
    L20:
        if (r15 == false) goto L32;
        if (r1 == true) goto L32;
        OSimpleFormDialog r16 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r8.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L27;
        OInputLayout r17 = r16.getInputView1();
        if (r17 == null) goto L27;
        r17.setTextState(true);
    L27:
        OSimpleFormDialog r18 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r8.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L43;
        OInputLayout r19 = r18.getInputView1();
        if (r19 == null) goto L44;
        r19.showTip(true);
        return;
    L44:
        return;
    L43:
        return;
    L32:
        OSimpleFormDialog r20 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r8.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L37;
        OInputLayout r21 = r20.getInputView1();
        if (r21 == null) goto L37;
        r21.setTextState(false);
    L37:
        OSimpleFormDialog r22 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r8.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        if (r22 == null) goto L46;
        OInputLayout r23 = r22.getInputView1();
        if (r23 == null) goto L47;
        r23.showTip(false);
        return;
    L47:
        return;
    L46:
        return;
    L19:
        r15 = false;
        goto L20
    L5:
        if (new d.l.j(1, 100).a(r0.intValue()) == false) goto L7;
        r1 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v38, types: [T, com.obric.oui.button.OButton] */
    /* JADX WARN: Type inference failed for: r8v0, types: [T, com.obric.oui.dialog.v2.misc.OSimpleFormDialog] */
    private static final Object b(Context r33, int r34, d.c.d<? super Integer> r35) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r33, Context.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r35, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r10 = new kotlinx.coroutines.o(d.c.a.b.a(r9), 1);
        r10.e();
        final n r11 = (n) ZeusTransformUtils.preCheckCast(r10, n.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Activity.class) == false) goto L5;
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(r0, Activity.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 != null) goto L8;
    L13:
        d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r3 = d.n.f38560a;
        r1.resumeWith(d.n.f(null));
    L14:
        Object r4 = r10.h();
        if (r4 != d.c.a.b.a()) goto L17;
        d.c.b.a.h.c(r9);
    L17:
        return r4;
    L8:
        if (r2.isFinishing() == true) goto L13;
        if (r2.isDestroyed() == true) goto L13;
        z.f r12 = new z.f();
        z.f r13 = new z.f();
        final z.a r14 = new z.a();
        final z.a r15 = new z.a();
        String r5 = r0.getString(ZeusTransformUtils.mapRes(R.string.condition_low_storage_dialog_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_low_storage_dialog_title"));
        o.c(r5, "getString(...)");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
        OSimpleFormDialog.b r6 = new OSimpleFormDialog.b(true, false, (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r34, r13, r12, r0), d.h.a.b.class, "com.obric.aiagent.plugin"));
        OSimpleFormDialog.b r25 = new OSimpleFormDialog.b(false, false, null, 4, null);
        String r7 = r0.getString(ZeusTransformUtils.mapRes(R.string.common_save, WsChannelMultiProcessSharedProvider.STRING_TYPE, "common_save"));
        o.c(r7, "getString(...)");
        OBaseDialog.a r21 = new OBaseDialog.a(r7, (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(r12, r14, r15, r11, r13, r0), d.h.a.a.class, "com.obric.aiagent.plugin"), null, 4, null);
        String r8 = r0.getString(ZeusTransformUtils.mapRes(R.string.common_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "common_cancel"));
        o.c(r8, "getString(...)");
        r12.f38504a = new OSimpleFormDialog(r0, new OSimpleFormDialog.c(r17, r18, r6, r25, r21, new OBaseDialog.a(r8, (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r12), d.h.a.a.class, "com.obric.aiagent.plugin"), null, 4, null)));
        ((OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r12.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin")).setOnDismissListener((DialogInterface.OnDismissListener) ZeusTransformUtils.preCheckCast(new LowStorageConditionKt$selectLowStoragePercent$2$4(r15, r14, r11), DialogInterface.OnDismissListener.class, "com.obric.aiagent.plugin"));
        r11.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r14, r12), d.h.a.b.class, "com.obric.aiagent.plugin"));
        OSimpleFormDialog r16 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r12.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        r13.f38504a = r16.getPositiveButton();
        a(r13, r12, r0, String.valueOf(r34));
        r16.show();
        goto L14
    L5:
        r2 = null;
        goto L6
    }
}
