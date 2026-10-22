package com.obric.autoaction.app.launcherpage.donation;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.UiType;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.z;
import d.x;

/* JADX INFO: compiled from: InputDialogWrapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f23758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f23760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f23761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.h.a.b<? super View, x> f23762e;
    private d.h.a.m<? super View, ? super String, x> f;

    /* JADX INFO: renamed from: lambda$Uad_vO-a2Hc_R4nOffbMWqdtYzo, reason: not valid java name */
    public static /* synthetic */ x m505lambda$Uad_vOa2Hc_R4nOffbMWqdtYzo(g r0, z.f r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$nD-QieC9TzCtLIRiVc5EVKB-hCc, reason: not valid java name */
    public static /* synthetic */ x m506lambda$nDQieC9TzCtLIRiVc5EVKBhCc(g r0, OInputLayout r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$pisI6G7s23GpjyhMQQDLgBxO5V8(g r0, z.f r1) {
        return b(r0, r1);
    }

    public g(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, DBDefinition.TITLE);
        this.f23758a = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f23759b = r4;
    }

    public final Context getContext() {
        return this.f23758a;
    }

    public final void a(String r1) {
        this.f23760c = r1;
    }

    public final void b(String r1) {
        this.f23761d = r1;
    }

    public final void a(d.h.a.b<? super View, x> r3) {
        this.f23762e = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public final void a(d.h.a.m<? super View, ? super String, x> r3) {
        this.f = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, com.obric.oui.dialog.v2.misc.OSimpleFormDialog] */
    public final void a() {
        final z.f r1 = new z.f();
        Context r3 = this.f23758a;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f23759b, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin");
        OSimpleFormDialog.b r7 = new OSimpleFormDialog.b(true, false, new $$Lambda$g$nDQieC9TzCtLIRiVc5EVKBhCc(this));
        OSimpleFormDialog.b r8 = new OSimpleFormDialog.b(false, false, null, 4, null);
        String r4 = this.f23758a.getString(ZeusTransformUtils.mapRes(R.string.donation_confirm, WsChannelMultiProcessSharedProvider.STRING_TYPE, "donation_confirm"));
        o.c(r4, "getString(...)");
        OBaseDialog.a r9 = new OBaseDialog.a(r4, new $$Lambda$g$Uad_vOa2Hc_R4nOffbMWqdtYzo(this, r1), null, 4, null);
        String r10 = this.f23758a.getString(ZeusTransformUtils.mapRes(R.string.donation_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "donation_cancel"));
        o.c(r10, "getString(...)");
        r1.f38504a = new OSimpleFormDialog(r3, new OSimpleFormDialog.c(r5, r6, r7, r8, r9, new OBaseDialog.a(r10, new $$Lambda$g$pisI6G7s23GpjyhMQQDLgBxO5V8(this, r1), null, 4, null)));
        OInputLayout r0 = ((OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r1.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin")).getInputView1();
        if (r0 == null) goto L7;
        OEditText r2 = r0.getVInput();
        if (r2 == null) goto L7;
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(r2, TextView.class, "com.obric.aiagent.plugin");
        TextWatcher r12 = new InputDialogWrapper$show$$inlined$addTextChangedListener$default$1(r1);
        r11.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r12, TextWatcher.class, "com.obric.aiagent.plugin"));
        TextWatcher r13 = (TextWatcher) ZeusTransformUtils.preCheckCast(r12, TextWatcher.class, "com.obric.aiagent.plugin");
    L7:
        OButton r14 = ((OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r1.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin")).getPositiveButton();
        OInputLayout r15 = ((OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r1.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin")).getInputView1();
        if (r15 == null) goto L12;
        OEditText r16 = r15.getVInput();
        if (r16 == null) goto L12;
        Editable r17 = r16.getText();
    L13:
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L16;
    L19:
        boolean r19 = true;
    L20:
        r14.setEnabled(!r19);
        ((OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r1.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin")).setAutoDismiss(true);
        ((OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r1.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin")).show();
        return;
    L16:
        if (r18.length() == 0) goto L19;
        r19 = false;
    L12:
        r17 = null;
        goto L13
    }

    private static final x a(g r5, OInputLayout r6) {
        o.e(r6, "it");
        r6.getVInput().setInputType(UiType.FLAG_PHONE_CARD);
        r6.setType(1);
        com.obric.oui.d.i.b((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"), d.i.a.a(TypedValue.applyDimension(1, 120, Resources.getSystem().getDisplayMetrics())));
        r6.getVInput().setHint((CharSequence) ZeusTransformUtils.preCheckCast(r5.f23760c, CharSequence.class, "com.obric.aiagent.plugin"));
        r6.getVInput().setGravity(48);
        String r7 = r5.f23761d;
        if (r7 == null) goto L6;
        r6.getVInput().setText((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"));
        r6.getVInput().setSelection(r7.length());
    L6:
        return x.f38692a;
    }

    private static final x a(g r3, z.f r4) {
        d.h.a.m<? super View, ? super String, x> r5 = r3.f;
        if (r5 == null) goto L26;
        OSimpleFormDialog r0 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r4.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L24;
        OButton r1 = r0.getPositiveButton();
        if (r1 == null) goto L24;
        OSimpleFormDialog r6 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r4.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L22;
        OInputLayout r7 = r6.getInputView1();
        if (r7 == null) goto L22;
        OEditText r8 = r7.getVInput();
        if (r8 == null) goto L22;
        Editable r9 = r8.getText();
        if (r9 == null) goto L22;
        String r10 = r9.toString();
        if (r10 == null) goto L22;
        r5.invoke(r1, r10);
    L22:
        return x.f38692a;
    L24:
        return x.f38692a;
    L26:
        return x.f38692a;
    }

    private static final x b(g r2, z.f r3) {
        d.h.a.b<? super View, x> r4 = r2.f23762e;
        if (r4 == null) goto L13;
        OSimpleFormDialog r5 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r3.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L11;
        OButton r6 = r5.getPositiveButton();
        if (r6 == null) goto L11;
        r4.invoke(r6);
    L11:
        return x.f38692a;
    L13:
        return x.f38692a;
    }
}
