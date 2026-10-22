package com.obric.autoaction.app.launcherpage.detail.base.container;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DetailShortInstructViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends z<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f23363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f23364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f23365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f23366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f23367e;
    private final d.f f;
    private com.obric.autoaction.app.launcherpage.a.j g;
    private OInputLayout h;

    public static /* synthetic */ OSwitch lambda$OJP3QzH66wOhuYvboB9C5Ohvn0I(v r0) {
        return f(r0);
    }

    public static /* synthetic */ void lambda$kwTh9PuoNtn_5I8rcKjDMofIxAQ(OEditText r0, View r1, boolean r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$o1Q8Zrlb6ndoT70amL83ckZsETI(v r0, CompoundButton r1, boolean r2) {
        a(r0, r1, r2);
    }

    public v() {
        this.f23363a = true;
        this.f23364b = true;
        this.f23365c = true;
        this.f23366d = true;
        this.f = d.g.a(new $$Lambda$v$OJP3QzH66wOhuYvboB9C5Ohvn0I(this));
    }

    public static final /* synthetic */ void a(v r0, boolean r1) {
        r0.f23363a = r1;
    }

    public static final /* synthetic */ boolean a(v r0) {
        return r0.f23363a;
    }

    public static final /* synthetic */ void b(v r0, boolean r1) {
        r0.f23367e = r1;
    }

    public static final /* synthetic */ boolean b(v r0) {
        return r0.f23367e;
    }

    public static final /* synthetic */ void c(v r0, boolean r1) {
        r0.f23365c = r1;
    }

    public static final /* synthetic */ boolean c(v r0) {
        return r0.f23365c;
    }

    public static final /* synthetic */ void d(v r0, boolean r1) {
        r0.f23366d = r1;
    }

    public static final /* synthetic */ boolean d(v r0) {
        return r0.f23366d;
    }

    public static final /* synthetic */ void e(v r0) {
        r0.l();
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public /* synthetic */ com.obric.autoaction.app.launcherpage.detail.base.f b(com.obric.autoaction.app.launcherpage.detail.base.a r2) {
        return (com.obric.autoaction.app.launcherpage.detail.base.f) ZeusTransformUtils.preCheckCast(a(r2), com.obric.autoaction.app.launcherpage.detail.base.f.class, "com.obric.aiagent.plugin");
    }

    private final OSwitch i() {
        return (OSwitch) ZeusTransformUtils.preCheckCast(this.f.b(), OSwitch.class, "com.obric.aiagent.plugin");
    }

    private static final OSwitch f(v r0) {
        com.obric.autoaction.app.launcherpage.a.j r1 = r0.g;
        if (r1 != null) goto L6;
        d.h.b.o.c("binding");
        r1 = null;
    L6:
        return r1.f22830c.getEndSwitch();
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public View a(ViewGroup r12) {
        d.h.b.o.e(r12, "parent");
        com.obric.autoaction.app.launcherpage.a.j r13 = com.obric.autoaction.app.launcherpage.a.j.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r12, false);
        d.h.b.o.c(r13, "inflate(...)");
        this.g = r13;
        com.obric.autoaction.app.launcherpage.a.j r0 = this.g;
        com.obric.autoaction.app.launcherpage.a.j r10 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.f22829b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r4, "getContext(...)");
        OInputLayout r14 = new OInputLayout(r4, null, 0, 6, null);
        r14.setInputType(1);
        r14.setType(0);
        r14.getVInput().setSingleLine(true);
        com.obric.autoaction.app.launcherpage.a.j r3 = this.g;
        if (r3 != null) goto L8;
        d.h.b.o.c("binding");
        r3 = null;
    L8:
        r14.setHint((CharSequence) ZeusTransformUtils.preCheckCast(androidx.core.content.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.detail_input_short_instruct_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "detail_input_short_instruct_hint")), CharSequence.class, "com.obric.aiagent.plugin"));
        r14.setLimitCount(5);
        r14.showTip(false);
        r14.showLimit(true);
        r14.showClear(true);
        r14.getVInput().setImeOptions(6);
        this.h = r14;
        com.obric.autoaction.app.launcherpage.a.j r15 = this.g;
        if (r15 != null) goto L11;
        d.h.b.o.c("binding");
        r15 = null;
    L11:
        r15.f22829b.setCustomStartView((View) ZeusTransformUtils.preCheckCast(this.h, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.j r16 = this.g;
        if (r16 != null) goto L14;
        d.h.b.o.c("binding");
        r16 = null;
    L14:
        OCardListItem r17 = r16.f22829b;
        d.h.b.o.c(r17, "detailShortcutInstructInput");
        com.obric.autoaction.app.launcherpage.utils.p.a(r17, 0, 1, null);
        com.obric.autoaction.app.launcherpage.a.j r11 = this.g;
        if (r11 != null) goto L17;
        d.h.b.o.c("binding");
    L18:
        LinearLayout r18 = r10.b();
        d.h.b.o.c(r18, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.aiagent.plugin");
    L17:
        r10 = r11;
        goto L18
    }

    public j a(com.obric.autoaction.app.launcherpage.detail.base.a r13) {
        d.h.b.o.e(r13, "context");
        EventTask r12 = r13.c().a();
        String r1 = null;
        if (ZeusTransformUtils.instanceOf(r12, ShortcutTask.class) == false) goto L5;
        ShortcutTask r14 = (ShortcutTask) ZeusTransformUtils.preCheckCast(r12, ShortcutTask.class, "com.obric.aiagent.plugin");
    L7:
        if (d.h.b.o.a(r13.c().d(), "enter_from_add_instruct") == false) goto L9;
    L8:
        boolean r7 = true;
    L14:
        String r15 = r13.c().d();
        if (r15 != null) goto L17;
        r15 = "";
    L17:
        String r5 = r15;
        if (r14 == null) goto L21;
        r1 = r14.getShortInstruct();
    L21:
        return new j(r5, r1, r7, false, 0, 24, null);
    L9:
        if (r14 != null) goto L11;
    L13:
        r7 = false;
        goto L14
    L11:
        if (r14.isShortInstructEnable() != true) goto L13;
    L5:
        r14 = null;
        goto L7
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void a() {
        j();
        k();
    }

    private final void j() {
        com.obric.autoaction.app.launcherpage.a.j r0 = this.g;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OCardListItem r1 = r0.f22829b;
        d.h.b.o.c(r1, "detailShortcutInstructInput");
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
        if (((j) ZeusTransformUtils.preCheckCast(f(), j.class, "com.obric.aiagent.plugin")).c() == false) goto L8;
        int r3 = 0;
    L9:
        r2.setVisibility(r3);
        m();
        OInputLayout r4 = this.h;
        if (r4 == null) goto L12;
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(((j) ZeusTransformUtils.preCheckCast(f(), j.class, "com.obric.aiagent.plugin")).b(), CharSequence.class, "com.obric.aiagent.plugin"));
    L12:
        OSwitch r5 = i();
        if (r5 == null) goto L15;
        r5.setOnCheckedChangeListener(null);
    L15:
        OSwitch r6 = i();
        if (r6 == null) goto L19;
        r6.setChecked(((j) ZeusTransformUtils.preCheckCast(f(), j.class, "com.obric.aiagent.plugin")).c());
        return;
    L19:
        return;
    L8:
        r3 = 8;
        goto L9
    }

    private final void k() {
        OInputLayout r0 = this.h;
        if (r0 == null) goto L16;
        final OEditText r1 = r0.getVInput();
        if (r1 == null) goto L19;
        r1.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new DetailShortInstructViewContainer$bindBusiness$1(this, r1), TextWatcher.class, "com.obric.aiagent.plugin"));
        r1.setOnFocusChangeListener(new $$Lambda$v$kwTh9PuoNtn_5I8rcKjDMofIxAQ(r1));
        OSwitch r2 = i();
        if (r2 == null) goto L11;
        r2.setOnCheckedChangeListener(new $$Lambda$v$o1Q8Zrlb6ndoT70amL83ckZsETI(this));
    L11:
        if (this.f23364b == true) goto L13;
        return;
    L13:
        if (d.h.b.o.a(((j) ZeusTransformUtils.preCheckCast(f(), j.class, "com.obric.aiagent.plugin")).a(), "enter_from_add_instruct") == false) goto L18;
        com.obric.autoaction.app.launcherpage.utils.p.b((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.utils.p.c((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"));
        l();
        this.f23364b = false;
        return;
    L18:
        return;
    L19:
        return;
    }

    private static final void a(OEditText r0, View r1, boolean r2) {
        if (r2 == false) goto L7;
        Editable r3 = r0.getText();
        if (r3 == null) goto L8;
        r0.setSelection(r3.length());
        return;
    L8:
        return;
    }

    private static final void a(v r4, CompoundButton r5, boolean r6) {
        com.obric.autoaction.app.launcherpage.a.j r7 = r4.g;
        com.obric.autoaction.app.launcherpage.a.j r0 = null;
        if (r7 != null) goto L5;
        d.h.b.o.c("binding");
        r7 = null;
    L5:
        OCardListItem r8 = r7.f22829b;
        d.h.b.o.c(r8, "detailShortcutInstructInput");
        View r9 = (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin");
        if (r6 == false) goto L8;
        int r2 = 0;
    L9:
        r9.setVisibility(r2);
        if (r6 == false) goto L16;
        com.obric.autoaction.app.launcherpage.a.j r10 = r4.g;
        if (r10 != null) goto L14;
        d.h.b.o.c("binding");
    L15:
        r0.f22829b.requestFocus();
        goto L16
    L14:
        r0 = r10;
    L16:
        r4.m();
        if (r6 == ((j) ZeusTransformUtils.preCheckCast(r4.f(), j.class, "com.obric.aiagent.plugin")).c()) goto L20;
        ((j) ZeusTransformUtils.preCheckCast(r4.f(), j.class, "com.obric.aiagent.plugin")).a(r6);
        r4.l();
        return;
    L20:
        return;
    L8:
        r2 = 8;
        goto L9
    }

    private final void l() {
        com.obric.autoaction.app.launcherpage.detail.base.a r0 = getContext();
        if (r0 == null) goto L6;
        r0.a((com.obric.autoaction.app.launcherpage.detail.base.h) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.detail.base.j.C0509j(((j) ZeusTransformUtils.preCheckCast(f(), j.class, "com.obric.aiagent.plugin")).b(), ((j) ZeusTransformUtils.preCheckCast(f(), j.class, "com.obric.aiagent.plugin")).c()), com.obric.autoaction.app.launcherpage.detail.base.h.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void m() {
        com.obric.autoaction.app.launcherpage.a.j r0 = this.g;
        com.obric.autoaction.app.launcherpage.a.j r2 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        OCardListItem r1 = r0.f22829b;
        d.h.b.o.c(r1, "detailShortcutInstructInput");
        if (((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L8;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L19;
        com.obric.autoaction.app.launcherpage.a.j r4 = this.g;
        if (r4 != null) goto L14;
        d.h.b.o.c("binding");
        r4 = null;
    L14:
        OCardListItem.setCardPosition$default(r4.f22830c, 1, false, 2, null);
        com.obric.autoaction.app.launcherpage.a.j r6 = this.g;
        if (r6 != null) goto L17;
        d.h.b.o.c("binding");
    L18:
        r2.f22830c.showDivider(true);
        return;
    L17:
        r2 = r6;
        goto L18
    L19:
        com.obric.autoaction.app.launcherpage.a.j r5 = this.g;
        if (r5 != null) goto L22;
        d.h.b.o.c("binding");
        r5 = null;
    L22:
        OCardListItem.setCardPosition$default(r5.f22830c, 0, false, 2, null);
        com.obric.autoaction.app.launcherpage.a.j r7 = this.g;
        if (r7 != null) goto L25;
        d.h.b.o.c("binding");
    L26:
        r2.f22830c.showDivider(false);
        return;
    L25:
        r2 = r7;
        goto L26
    L8:
        r3 = false;
        goto L10
    }
}
