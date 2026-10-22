package com.obric.autoaction.app.launcherpage.detail.base.container;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.PinShortCutActivity;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.toast.OToast;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: DetailAddPinShortCutViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends z<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.obric.autoaction.app.launcherpage.a.d f23301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DetailAddPinShortCutViewContainer$lifecycleObserver$1 f23302b;

    public static /* synthetic */ d.x lambda$0wqlud5OZodXBVyI2Zfas1VUgMY(d.h.b.z.f r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$I0dMtdV47-sluCvDASQZbRzHk5g, reason: not valid java name */
    public static /* synthetic */ d.x m471lambda$I0dMtdV47sluCvDASQZbRzHk5g(d.h.b.z.f r0, d.h.b.z.a r1, OEditText r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$KrwJkGCNMxvZVlYf34730IOIbOI(b r0, View r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$LIK4M-g31kg7m5LM8FlIeBUx3OE, reason: not valid java name */
    public static /* synthetic */ d.x m472lambda$LIK4Mg31kg7m5LM8FlIeBUx3OE(String r0, d.h.b.z.f r1, OInputLayout r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ d.x lambda$V6kf5UMdluQwo8W2G1Euu6Uq79w(d.h.b.z.a r0, d.h.a.a r1, boolean r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$gMq2jvYIndHW3LcsrLxQ6IKJOpA(b r0, String r1, DialogInterface r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ d.x lambda$ov2McNyEX8l9GFHHlTm6gKapVdw(b r0, String r1, boolean r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ d.x lambda$ypgPbzRb1mkguPmE1a2Mxih1MKU(d.h.b.z.f r0, Context r1, String r2, String r3, b r4) {
        return a(r0, r1, r2, r3, r4);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.autoaction.app.launcherpage.detail.base.container.DetailAddPinShortCutViewContainer$lifecycleObserver$1] */
    public b() {
        this.f23302b = new DetailAddPinShortCutViewContainer$lifecycleObserver$1(this);
    }

    public static final /* synthetic */ void a(b r0, String r1) {
        r0.a(r1);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public /* synthetic */ com.obric.autoaction.app.launcherpage.detail.base.f b(com.obric.autoaction.app.launcherpage.detail.base.a r2) {
        return (com.obric.autoaction.app.launcherpage.detail.base.f) ZeusTransformUtils.preCheckCast(a(r2), com.obric.autoaction.app.launcherpage.detail.base.f.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public View a(ViewGroup r5) {
        d.h.b.o.e(r5, "parent");
        com.obric.autoaction.app.launcherpage.a.d r6 = com.obric.autoaction.app.launcherpage.a.d.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r5, false);
        d.h.b.o.c(r6, "inflate(...)");
        this.f23301a = r6;
        com.obric.autoaction.app.launcherpage.a.d r0 = null;
        if (r6 != null) goto L5;
        d.h.b.o.c("binding");
        r6 = null;
    L5:
        OSwitch r7 = r6.f22808a.getEndSwitch();
        if (r7 == null) goto L8;
        r7.setClickable(false);
    L8:
        com.obric.autoaction.app.launcherpage.a.d r4 = this.f23301a;
        if (r4 != null) goto L11;
        d.h.b.o.c("binding");
    L12:
        LinearLayout r8 = r0.b();
        d.h.b.o.c(r8, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin");
    L11:
        r0 = r4;
        goto L12
    }

    public a a(com.obric.autoaction.app.launcherpage.detail.base.a r6) {
        d.h.b.o.e(r6, "context");
        EventTask r5 = r6.c().a();
        Map<String, String> r1 = null;
        if (ZeusTransformUtils.instanceOf(r5, ShortcutTask.class) == false) goto L5;
        ShortcutTask r7 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r5, ShortcutTask.class, "com.obric.aiagent.plugin");
    L6:
        if (r7 == null) goto L8;
        String r0 = r7.getId();
    L9:
        String r2 = "";
        if (r0 != null) goto L12;
        r0 = "";
    L12:
        if (r7 == null) goto L22;
        String r3 = r7.getShortInstruct();
        if (r3 == null) goto L22;
        if (r7.isShortInstructEnable() == true) goto L19;
        r3 = null;
    L19:
        if (r3 == null) goto L22;
        r2 = r3;
    L28:
        if (r7 == null) goto L31;
        r1 = r7.getExt();
    L31:
        return new a(r0, r2, r1);
    L22:
        if (r7 == null) goto L24;
        String r8 = com.obric.autoaction.app.launcherpage.detail.shortcut.data.e.a(r7, r6.c().d());
    L25:
        if (r8 == null) goto L28;
        r2 = r8;
        goto L28
    L24:
        r8 = null;
        goto L25
    L8:
        r0 = null;
        goto L9
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void a() {
        com.obric.autoaction.app.launcherpage.detail.base.a r0 = getContext();
        if (r0 == null) goto L9;
        androidx.lifecycle.p r1 = r0.b();
        if (r1 == null) goto L9;
        androidx.lifecycle.i r2 = r1.getLifecycle();
        if (r2 == null) goto L9;
        r2.a((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(this.f23302b, androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
    L9:
        j();
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void b() {
        i();
    }

    private final void i() {
        com.obric.autoaction.app.launcherpage.a.d r0 = this.f23301a;
        com.obric.autoaction.app.launcherpage.a.d r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r4 = r2.getString(ZeusTransformUtils.mapRes(R.string.detail_add_pin_shortcut_cell_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "detail_add_pin_shortcut_cell_title"));
        d.h.b.o.c(r4, "getString(...)");
        if (com.obric.autoaction.app.launcherpage.utils.a.f24463a.e() == false) goto L8;
        String r5 = r2.getString(ZeusTransformUtils.mapRes(R.string.detail_add_pin_shortcut_superscript, WsChannelMultiProcessSharedProvider.STRING_TYPE, "detail_add_pin_shortcut_superscript"));
        d.h.b.o.c(r5, "getString(...)");
        SpannableString r6 = new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(r4 + ' ' + r5, CharSequence.class, "com.obric.aiagent.plugin"));
        r6.setSpan(new ImageSpan(r2, ZeusTransformUtils.mapRes(R.drawable.autoaciton_add_pin_shortcut_tag, "drawable", "autoaciton_add_pin_shortcut_tag"), 2), r4.length() + 1, r6.length(), 33);
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
    L9:
        com.obric.autoaction.app.launcherpage.a.d r7 = this.f23301a;
        if (r7 != null) goto L12;
        d.h.b.o.c("binding");
    L13:
        r1.f22808a.setTitle(r3);
        String r8 = ((a) ZeusTransformUtils.preCheckCast(f(), a.class, "com.obric.aiagent.plugin")).a();
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        a(r8);
        return;
    L12:
        r1 = r7;
        goto L13
    L8:
        r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        goto L9
    }

    private final void j() {
        com.obric.autoaction.app.launcherpage.a.d r0 = this.f23301a;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f22808a.setOnContentClickListener(new $$Lambda$b$KrwJkGCNMxvZVlYf34730IOIbOI(this));
    }

    private static final void a(b r12, View r13) {
        com.obric.autoaction.app.launcherpage.a.d r14 = r12.f23301a;
        com.obric.autoaction.app.launcherpage.a.d r0 = null;
        if (r14 != null) goto L5;
        d.h.b.o.c("binding");
        r14 = null;
    L5:
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.a.d r3 = r12.f23301a;
        if (r3 != null) goto L8;
        d.h.b.o.c("binding");
    L9:
        OSwitch r1 = r0.f22808a.getEndSwitch();
        boolean r2 = true;
        if (r1 != null) goto L12;
    L14:
        r2 = false;
    L15:
        if (r2 == false) goto L20;
        d.h.b.o.a(r15);
        ComponentActivity r4 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r15), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L19;
        return;
    L19:
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.aiagent.plugin");
        String r6 = r15.getString(ZeusTransformUtils.mapRes(R.string.detail_add_pin_shortcut_added_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "detail_add_pin_shortcut_added_toast"));
        d.h.b.o.c(r6, "getString(...)");
        new OToast(r5, r6, 0, false, null, 0, 52, null).f();
        return;
    L20:
        com.obric.autoaction.app.launcherpage.utils.a.f24463a.f();
        d.h.b.o.a(r15);
        String r7 = ((a) ZeusTransformUtils.preCheckCast(r12.f(), a.class, "com.obric.aiagent.plugin")).a();
        String r8 = "";
        if (r7 != null) goto L23;
        r7 = "";
    L23:
        String r9 = ((a) ZeusTransformUtils.preCheckCast(r12.f(), a.class, "com.obric.aiagent.plugin")).b();
        if (r9 == null) goto L27;
        r8 = r9;
    L27:
        r12.a(r15, r7, r8);
        return;
    L12:
        if (r1.isChecked() != true) goto L14;
    L8:
        r0 = r3;
        goto L9
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void c() {
        com.obric.autoaction.app.launcherpage.detail.base.a r0 = getContext();
        if (r0 == null) goto L9;
        androidx.lifecycle.p r1 = r0.b();
        if (r1 == null) goto L9;
        androidx.lifecycle.i r2 = r1.getLifecycle();
        if (r2 == null) goto L9;
        r2.b((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(this.f23302b, androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
    L9:
        com.obric.autoaction.app.launcherpage.utils.g r3 = com.obric.autoaction.app.launcherpage.utils.g.f24481a;
        String r4 = ((a) ZeusTransformUtils.preCheckCast(f(), a.class, "com.obric.aiagent.plugin")).a();
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        r3.a(r4);
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [T, com.obric.oui.dialog.v2.misc.OSimpleFormDialog] */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.obric.oui.button.OButton] */
    private final void a(Context r30, final String r31, final String r32) {
        final Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r30, Context.class, "com.obric.aiagent.plugin");
        final d.h.b.z.f r8 = new d.h.b.z.f();
        final d.h.b.z.f r9 = new d.h.b.z.f();
        r8.f38504a = new OSimpleFormDialog(r0, new OSimpleFormDialog.c((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.task_pinned_short_cut_label_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_pinned_short_cut_label_title"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), new OSimpleFormDialog.b(true, false, new $$Lambda$b$LIK4Mg31kg7m5LM8FlIeBUx3OE(r32, r9)), new OSimpleFormDialog.b(false, false, null, 4, null), new OBaseDialog.a("确认", new $$Lambda$b$ypgPbzRb1mkguPmE1a2Mxih1MKU(r8, r0, r31, r32, this), null, 4, null), new OBaseDialog.a("取消", new $$Lambda$b$0wqlud5OZodXBVyI2Zfas1VUgMY(r8), null, 4, null)));
        ((OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r8.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin")).setOnDismissListener(new $$Lambda$b$gMq2jvYIndHW3LcsrLxQ6IKJOpA(this, r31));
        OSimpleFormDialog r1 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r8.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        r9.f38504a = r1.getPositiveButton();
        r1.show();
    }

    private static final d.x a(String r5, final d.h.b.z.f r6, OInputLayout r7) {
        d.h.b.o.e(r7, "it");
        final OEditText r0 = r7.getVInput();
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.e(r5, 50), CharSequence.class, "com.obric.aiagent.plugin"));
        r0.setHint((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.task_pinned_short_cut_label_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_pinned_short_cut_label_hint"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"));
        r0.selectAll();
        final d.h.b.z.a r8 = new d.h.b.z.a();
        final d.h.a.a r2 = new $$Lambda$b$I0dMtdV47sluCvDASQZbRzHk5g(r6, r8, r0);
        com.obric.autoaction.app.launcherpage.utils.p.a(r7, 50, new $$Lambda$b$V6kf5UMdluQwo8W2G1Euu6Uq79w(r8, r2));
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r0, TextView.class, "com.obric.aiagent.plugin");
        TextWatcher r10 = new DetailAddPinShortCutViewContainer$showAddShortCutDialog$lambda$7$$inlined$addTextChangedListener$default$1(r2);
        r9.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r10, TextWatcher.class, "com.obric.aiagent.plugin"));
        TextWatcher r11 = (TextWatcher) ZeusTransformUtils.preCheckCast(r10, TextWatcher.class, "com.obric.aiagent.plugin");
        r2.invoke();
        return d.x.f38692a;
    }

    private static final d.x a(d.h.b.z.f r3, d.h.b.z.a r4, OEditText r5) {
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
        return d.x.f38692a;
    }

    private static final d.x a(d.h.b.z.a r2, d.h.a.a r3, boolean r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        r2.f38499a = r4;
        r5.invoke();
        return d.x.f38692a;
    }

    private static final d.x a(d.h.b.z.f r9, Context r10, final String r11, String r12, final b r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        OSimpleFormDialog r14 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r9.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L11;
        OInputLayout r15 = r14.getInputView1();
        if (r15 == null) goto L11;
        OEditText r16 = r15.getVInput();
        if (r16 == null) goto L11;
        Editable r17 = r16.getText();
        if (r17 == null) goto L11;
        String r18 = r17.toString();
    L12:
        if (r18 != null) goto L14;
    L20:
        com.obric.event.task.base.report.m.f32868a.c();
        com.obric.autoaction.app.launcherpage.utils.g r2 = com.obric.autoaction.app.launcherpage.utils.g.f24481a;
        if (r18 != null) goto L23;
        String r5 = r12;
    L24:
        Intent r6 = PinShortCutActivity.Companion.a(r3, r11);
        Bitmap r19 = com.obric.autoaction.app.launcherpage.utils.k.f24509a.a(r3, ((a) ZeusTransformUtils.preCheckCast(r13.f(), a.class, "com.obric.aiagent.plugin")).c());
        if (r19 == null) goto L27;
        Icon r7 = Icon.createWithBitmap(r19);
    L28:
        r2.a(r3, r11, r5, r6, r7, new $$Lambda$b$ov2McNyEX8l9GFHHlTm6gKapVdw(r13, r11));
        OSimpleFormDialog r20 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r9.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L32;
        r20.dismiss();
    L32:
        return d.x.f38692a;
    L27:
        r7 = null;
        goto L28
    L23:
        r5 = r18;
        goto L24
    L14:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L20;
        return d.x.f38692a;
    L16:
        r4 = false;
    L11:
        r18 = null;
        goto L12
    }

    private static final d.x a(b r0, String r1, boolean r2) {
        r0.a(r1);
        return d.x.f38692a;
    }

    private static final d.x a(d.h.b.z.f r2) {
        OSimpleFormDialog r3 = (OSimpleFormDialog) ZeusTransformUtils.preCheckCast(r2.f38504a, OSimpleFormDialog.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.dismiss();
    L6:
        return d.x.f38692a;
    }

    private static final void a(b r2, String r3, DialogInterface r4) {
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.class, "com.obric.aiagent.plugin");
        r2.a(r3);
    }

    private final void a(String r10) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        com.obric.autoaction.app.launcherpage.a.d r1 = this.f23301a;
        if (r1 != null) goto L11;
        d.h.b.o.c("binding");
        r1 = null;
    L11:
        OSwitch r2 = r1.f22808a.getEndSwitch();
        com.obric.autoaction.app.launcherpage.utils.g r6 = com.obric.autoaction.app.launcherpage.utils.g.f24481a;
        com.obric.autoaction.app.launcherpage.a.d r7 = this.f23301a;
        if (r7 != null) goto L14;
        d.h.b.o.c("binding");
        r7 = null;
    L14:
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r3, "getContext(...)");
        boolean r11 = r6.a(r3, r10);
        if (r2 == null) goto L17;
        r2.setEnabled(false);
    L17:
        if (r11 == false) goto L28;
        if (r2 == null) goto L20;
        r2.setChecked(true);
    L20:
        com.obric.autoaction.app.launcherpage.a.d r9 = this.f23301a;
        if (r9 != null) goto L23;
        d.h.b.o.c("binding");
        r9 = null;
    L23:
        View r12 = r9.f22808a.findViewById(ZeusTransformUtils.mapRes(R.id.content_container, DbHelper.COL_ID, "content_container"));
        if (r12 == null) goto L26;
        r12.setBackground(null);
    L26:
        if (r2 == null) goto L37;
        r2.setAlpha(0.5f);
        return;
    L37:
        return;
    L28:
        if (r2 == null) goto L30;
        r2.setChecked(false);
    L30:
        com.obric.autoaction.app.launcherpage.a.d r13 = this.f23301a;
        if (r13 != null) goto L33;
        d.h.b.o.c("binding");
        r13 = null;
    L33:
        r13.f22808a.setOnContentLongClickListener(null);
        if (r2 == null) goto L39;
        r2.setAlpha(1.0f);
        return;
    L39:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
