package com.obric.autoaction.app.launcherpage.detail.base.container;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.discovery.util.PromptSlotTagSpan;
import com.obric.autoaction.app.launcherpage.ui.DeletableSpan;
import com.obric.autoaction.app.launcherpage.ui.DeletableSpanWatcher;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DetailQueryViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends z<r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.obric.autoaction.app.launcherpage.a.h f23345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f23346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OInputLayout f23347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f23348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Spannable f23349e;
    private boolean f;

    public static /* synthetic */ void lambda$8qyYYCWb8shpVtK5YwWCkvBjCbQ(s r0, int r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$PYx4J8i1nOIWfQBghsEsveN5kQY(s r0, int r1) {
        b(r0, r1);
    }

    public s() {
        this.f23346b = true;
    }

    public static final /* synthetic */ void a(s r2, Spannable r3) {
        r2.f23349e = (Spannable) ZeusTransformUtils.wrapperContextForParams(r3, Spannable.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ boolean a(s r0) {
        return r0.f23348d;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public /* synthetic */ com.obric.autoaction.app.launcherpage.detail.base.f b(com.obric.autoaction.app.launcherpage.detail.base.a r2) {
        return (com.obric.autoaction.app.launcherpage.detail.base.f) ZeusTransformUtils.preCheckCast(a(r2), com.obric.autoaction.app.launcherpage.detail.base.f.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public View a(ViewGroup r8) {
        d.h.b.o.e(r8, "parent");
        com.obric.autoaction.app.launcherpage.a.h r9 = com.obric.autoaction.app.launcherpage.a.h.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r8, false);
        d.h.b.o.c(r9, "inflate(...)");
        this.f23345a = r9;
        com.obric.autoaction.app.launcherpage.a.h r3 = null;
        if (r9 != null) goto L5;
        d.h.b.o.c("binding");
        r9 = null;
    L5:
        LayoutInflater r10 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        int r4 = ZeusTransformUtils.mapRes(R.layout.autoaction_detail_query_input, "layout", "autoaction_detail_query_input");
        com.obric.autoaction.app.launcherpage.a.h r5 = this.f23345a;
        if (r5 != null) goto L8;
        d.h.b.o.c("binding");
        r5 = null;
    L8:
        View r11 = ZeusTransformUtils.inflate(r10, r4, (ViewGroup) ZeusTransformUtils.preCheckCast(r5.f22820a, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
        d.h.b.o.a(r11, "null cannot be cast to non-null type com.obric.oui.forms.OInputLayout");
        OInputLayout r12 = (OInputLayout) ZeusTransformUtils.preCheckCast(r11, OInputLayout.class, "com.obric.aiagent.plugin");
        r12.setType(1);
        r12.setHint((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_event_content_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_event_content_hint")), CharSequence.class, "com.obric.aiagent.plugin"));
        r12.getVInput().setGravity(48);
        this.f23347c = r12;
        com.obric.autoaction.app.launcherpage.a.h r13 = this.f23345a;
        if (r13 != null) goto L11;
        d.h.b.o.c("binding");
        r13 = null;
    L11:
        OCardListItem r14 = r13.f22820a;
        OInputLayout r2 = this.f23347c;
        if (r2 != null) goto L14;
        d.h.b.o.c("queryInput");
        r2 = null;
    L14:
        r14.setCustomStartView((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.h r7 = this.f23345a;
        if (r7 != null) goto L17;
        d.h.b.o.c("binding");
    L18:
        LinearLayout r15 = r3.b();
        d.h.b.o.c(r15, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.aiagent.plugin");
    L17:
        r3 = r7;
        goto L18
    }

    public r a(com.obric.autoaction.app.launcherpage.detail.base.a r3) {
        d.h.b.o.e(r3, "context");
        EventTask r2 = r3.c().a();
        if (ZeusTransformUtils.instanceOf(r2, ShortcutTask.class) == false) goto L6;
        String r4 = com.obric.autoaction.app.launcherpage.detail.shortcut.data.e.a((ShortcutTask) ZeusTransformUtils.preCheckCast(r2, ShortcutTask.class, "com.obric.aiagent.plugin"), r3.c().d());
    L10:
        return new r(r4, r3.c().d());
    L6:
        if (ZeusTransformUtils.instanceOf(r2, ConditionTask.class) == false) goto L8;
        r4 = com.obric.autoaction.app.launcherpage.detail.condition.a.a.a((ConditionTask) ZeusTransformUtils.preCheckCast(r2, ConditionTask.class, "com.obric.aiagent.plugin"), r3.c().d());
        goto L10
    L8:
        r4 = "";
        goto L10
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void a() {
        k();
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void b() {
        i();
        j();
        l();
    }

    private final void i() {
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        if (d.h.b.o.a(((r) ZeusTransformUtils.preCheckCast(f(), r.class, "com.obric.aiagent.plugin")).b(), "enter_from_discovery_add_instruct") == true) goto L8;
        return;
    L8:
        com.obric.autoaction.app.launcherpage.detail.base.a r0 = getContext();
        Spannable r1 = null;
        if (r0 == null) goto L13;
        com.obric.autoaction.app.launcherpage.detail.base.b r2 = r0.c();
        if (r2 == null) goto L13;
        EventTask r3 = r2.b();
    L15:
        if (ZeusTransformUtils.instanceOf(r3, ShortcutTask.class) == false) goto L18;
        r1 = com.obric.autoaction.app.launcherpage.detail.shortcut.data.e.b((ShortcutTask) ZeusTransformUtils.preCheckCast(r3, ShortcutTask.class, "com.obric.aiagent.plugin"), ((r) ZeusTransformUtils.preCheckCast(f(), r.class, "com.obric.aiagent.plugin")).b());
    L20:
        this.f23349e = r1;
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r3, ConditionTask.class) == false) goto L20;
        r1 = com.obric.autoaction.app.launcherpage.detail.condition.a.a.b((ConditionTask) ZeusTransformUtils.preCheckCast(r3, ConditionTask.class, "com.obric.aiagent.plugin"), ((r) ZeusTransformUtils.preCheckCast(f(), r.class, "com.obric.aiagent.plugin")).b());
    L13:
        r3 = null;
        goto L15
    }

    private final void j() {
        String r0 = ((r) ZeusTransformUtils.preCheckCast(f(), r.class, "com.obric.aiagent.plugin")).a();
        this.f23348d = true;
        OInputLayout r3 = null;
        if (d.h.b.o.a(((r) ZeusTransformUtils.preCheckCast(f(), r.class, "com.obric.aiagent.plugin")).b(), "enter_from_discovery_add_instruct") == false) goto L16;
        Spannable r1 = this.f23349e;
        if (r1 == null) goto L11;
        b(r1);
        OInputLayout r2 = this.f23347c;
        if (r2 != null) goto L9;
        d.h.b.o.c("queryInput");
    L10:
        r3.getVInput().setText((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"));
    L21:
        this.f23348d = false;
        return;
    L9:
        r3 = r2;
        goto L10
    L11:
        OInputLayout r4 = this.f23347c;
        if (r4 != null) goto L14;
        d.h.b.o.c("queryInput");
    L15:
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"));
        goto L21
    L14:
        r3 = r4;
        goto L15
    L16:
        OInputLayout r5 = this.f23347c;
        if (r5 != null) goto L19;
        d.h.b.o.c("queryInput");
    L20:
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"));
        goto L21
    L19:
        r3 = r5;
        goto L20
    }

    private final void k() {
        OInputLayout r0 = this.f23347c;
        OInputLayout r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("queryInput");
        r0 = null;
    L5:
        r0.getVInput().addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new DetailQueryViewContainer$bindBusiness$1(this), TextWatcher.class, "com.obric.aiagent.plugin"));
        if (d.h.b.o.a(((r) ZeusTransformUtils.preCheckCast(f(), r.class, "com.obric.aiagent.plugin")).b(), "enter_from_discovery_add_instruct") == false) goto L16;
        OInputLayout r2 = this.f23347c;
        if (r2 != null) goto L10;
        d.h.b.o.c("queryInput");
        r2 = null;
    L10:
        OEditText r3 = r2.getVInput();
        OInputLayout r6 = this.f23347c;
        if (r6 != null) goto L13;
        d.h.b.o.c("queryInput");
    L14:
        r3.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new DeletableSpanWatcher((EditText) ZeusTransformUtils.preCheckCast(r1.getVInput(), EditText.class, "com.obric.aiagent.plugin")), TextWatcher.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        r1 = r6;
        goto L14
    }

    private final void l() {
        if (this.f23346b == false) goto L32;
        this.f23346b = false;
        OInputLayout r0 = this.f23347c;
        OInputLayout r1 = null;
        if (r0 != null) goto L7;
        d.h.b.o.c("queryInput");
        r0 = null;
    L7:
        com.obric.autoaction.app.launcherpage.utils.p.b((View) ZeusTransformUtils.preCheckCast(r0.getVInput(), View.class, "com.obric.aiagent.plugin"));
        String r2 = ((r) ZeusTransformUtils.preCheckCast(f(), r.class, "com.obric.aiagent.plugin")).b();
        if (r2 != null) goto L10;
        return;
    L10:
        switch(r2.hashCode()) {
            case 28883551: goto L28;
            case 526139541: goto L24;
            case 596258243: goto L21;
            case 1987924087: goto L13;
            default: goto L36;
        };
    L36:
        return;
    L13:
        if (r2.equals("enter_from_auto_right_btn") == false) goto L37;
        OInputLayout r5 = this.f23347c;
        if (r5 != null) goto L18;
        d.h.b.o.c("queryInput");
    L19:
        com.obric.autoaction.app.launcherpage.utils.p.c((View) ZeusTransformUtils.preCheckCast(r1.getVInput(), View.class, "com.obric.aiagent.plugin"));
        return;
    L18:
        r1 = r5;
        goto L19
    L37:
        return;
    L21:
        if (r2.equals("enter_from_condition_detail") == false) goto L38;
    L30:
        n();
        return;
    L38:
        return;
    L24:
        if (r2.equals("enter_from_discovery_add_instruct") == false) goto L39;
        m();
        return;
    L39:
        return;
    L28:
        if (r2.equals("enter_from_short_cut_detail") == true) goto L30;
        return;
    }

    private final Integer a(Spannable r5) {
        Spannable r4 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r5, Spannable.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        PromptSlotTagSpan[] r1 = (PromptSlotTagSpan[]) ZeusTransformUtils.preCheckCast(r4.getSpans(0, r4.length(), PromptSlotTagSpan.class), PromptSlotTagSpan[].class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L11;
        PromptSlotTagSpan r0 = (PromptSlotTagSpan) ZeusTransformUtils.preCheckCast(d.a.i.c(r1), PromptSlotTagSpan.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L10;
        return null;
    L10:
        return Integer.valueOf(r4.getSpanEnd(r0));
    L11:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    private final void b(Spannable r12) {
        Spannable r13 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r12, Spannable.class, "com.obric.aiagent.plugin");
        int r3 = 0;
        PromptSlotTagSpan[] r0 = (PromptSlotTagSpan[]) ZeusTransformUtils.preCheckCast(r13.getSpans(0, r13.length(), PromptSlotTagSpan.class), PromptSlotTagSpan[].class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r0);
        int r2 = r0.length;
    L3:
        if (r3 >= r2) goto L8;
        PromptSlotTagSpan r4 = r0[r3];
        com.obric.autoaction.app.launcherpage.a.h r6 = this.f23345a;
        if (r6 != null) goto L7;
        d.h.b.o.c("binding");
        r6 = null;
    L7:
        float r7 = 2;
        r13.setSpan(new DeletableSpan(Integer.valueOf(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, "color", "oui_functional_blue_6"))), TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics()), TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())), r13.getSpanStart(r4), r13.getSpanEnd(r4), 34);
        r3 = r3 + 1;
        goto L3
    }

    private final void m() {
        Spannable r0 = this.f23349e;
        Integer r1 = a(r0);
        OInputLayout r2 = null;
        if (r1 != null) goto L7;
        if (r0 == null) goto L6;
        r1 = Integer.valueOf(r0.length());
        goto L7
    L6:
        r1 = null;
    L7:
        if (r1 == null) goto L14;
        final int r3 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue();
        OInputLayout r4 = this.f23347c;
        if (r4 != null) goto L11;
        d.h.b.o.c("queryInput");
    L12:
        r2.post(new $$Lambda$s$8qyYYCWb8shpVtK5YwWCkvBjCbQ(this, r3));
        return;
    L11:
        r2 = r4;
        goto L12
    }

    private static final void a(s r5, int r6) {
        OInputLayout r0 = r5.f23347c;
        OInputLayout r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("queryInput");
        r0 = null;
    L5:
        com.obric.autoaction.app.launcherpage.utils.p.c((View) ZeusTransformUtils.preCheckCast(r0.getVInput(), View.class, "com.obric.aiagent.plugin"));
        OInputLayout r7 = r5.f23347c;
        if (r7 != null) goto L8;
        d.h.b.o.c("queryInput");
    L9:
        r1.getVInput().setSelection(r6);
        return;
    L8:
        r1 = r7;
        goto L9
    }

    private final void n() {
        OInputLayout r0 = this.f23347c;
        OInputLayout r2 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("queryInput");
        r0 = null;
    L5:
        CharSequence r1 = r0.getText();
        if (r1 == null) goto L8;
        Integer r3 = Integer.valueOf(r1.length());
    L9:
        if (r3 == null) goto L16;
        final int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue();
        OInputLayout r5 = this.f23347c;
        if (r5 != null) goto L13;
        d.h.b.o.c("queryInput");
    L14:
        r2.post(new $$Lambda$s$PYx4J8i1nOIWfQBghsEsveN5kQY(this, r4));
        return;
    L13:
        r2 = r5;
        goto L14
    L16:
        return;
    L8:
        r3 = null;
        goto L9
    }

    private static final void b(s r5, int r6) {
        OInputLayout r0 = r5.f23347c;
        OInputLayout r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("queryInput");
        r0 = null;
    L5:
        com.obric.autoaction.app.launcherpage.utils.p.c((View) ZeusTransformUtils.preCheckCast(r0.getVInput(), View.class, "com.obric.aiagent.plugin"));
        OInputLayout r7 = r5.f23347c;
        if (r7 != null) goto L8;
        d.h.b.o.c("queryInput");
    L9:
        r1.getVInput().setSelection(r6);
        return;
    L8:
        r1 = r7;
        goto L9
    }
}
