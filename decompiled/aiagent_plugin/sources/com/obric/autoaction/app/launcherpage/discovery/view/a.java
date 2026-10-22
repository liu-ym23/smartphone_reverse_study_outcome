package com.obric.autoaction.app.launcherpage.discovery.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.obric.autoaction.app.launcherpage.a.o;
import com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition;
import com.obric.autoaction.app.launcherpage.ui.f;
import com.obric.autoaction.app.launcherpage.ui.g;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.oui.common.util.k;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: AutoInstructionCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends f<com.obric.autoaction.app.launcherpage.discovery.a.b.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o f23666a;

    /* JADX INFO: renamed from: lambda$N0VTthovJ3DIVxcCwzGsG-vUZD4, reason: not valid java name */
    public static /* synthetic */ void m496lambda$N0VTthovJ3DIVxcCwzGsGvUZD4(a r0, com.obric.autoaction.app.launcherpage.discovery.a.b.a r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$oaHQoXBp2OvfaSrqa5Bkr6Kdun8(a r0, com.obric.autoaction.app.launcherpage.discovery.a.b.a r1, View r2) {
        b(r0, r1, r2);
    }

    public a() {
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(h r3, List r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a((com.obric.autoaction.app.launcherpage.discovery.a.b.a) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.discovery.a.b.a.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r4) {
        d.h.b.o.e(r4, "parent");
        o r5 = o.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        d.h.b.o.c(r5, "inflate(...)");
        this.f23666a = r5;
        if (r5 != null) goto L5;
        d.h.b.o.c("binding");
        r5 = null;
    L5:
        OUIConstraintLayout r3 = r5.b();
        d.h.b.o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    public void a(final com.obric.autoaction.app.launcherpage.discovery.a.b.a r8, List<? extends Object> r9) {
        List<? extends Object> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "item");
        d.h.b.o.e(r10, "payloads");
        super.a((h) ZeusTransformUtils.preCheckCast(r8, h.class, "com.obric.aiagent.plugin"), r10);
        o r11 = this.f23666a;
        o r2 = null;
        if (r11 != null) goto L5;
        d.h.b.o.c("binding");
        r11 = null;
    L5:
        ImageView r12 = r11.f22843b;
        d.h.b.o.c(r12, "discoveryTaskIcon");
        com.obric.aiagent.assistant.common.ui.icon.d.a(r12, r8.a().e(), r8.a().f(), r8.a().a());
        o r13 = this.f23666a;
        if (r13 != null) goto L8;
        d.h.b.o.c("binding");
        r13 = null;
    L8:
        OTextView r14 = r13.f22846e;
        com.obric.autoaction.app.launcherpage.discovery.util.b r3 = com.obric.autoaction.app.launcherpage.discovery.util.b.f23658a;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r4, "getContext(...)");
        r3.a(r4, r8.b());
        r14.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8.b().a(), CharSequence.class, "com.obric.aiagent.plugin"));
        r14.setMaxLines(1);
        com.obric.autoaction.app.launcherpage.discovery.a.h r15 = r8.a().i();
        if (r15 == null) goto L15;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r5, "getContext(...)");
        ConditionGroup r16 = r15.a(r5);
        if (r16 == null) goto L15;
        List<AutoCondition> r17 = com.obric.autoaction.app.launcherpage.condition.a.a.a(r16);
        if (r17 == null) goto L15;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r6, "getContext(...)");
        String r18 = com.obric.autoaction.app.launcherpage.condition.a.a.a(r17, r6);
    L16:
        if (r18 != null) goto L19;
        r18 = "";
    L19:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L21;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L34;
        o r19 = this.f23666a;
        if (r19 != null) goto L27;
        d.h.b.o.c("binding");
        r19 = null;
    L27:
        r19.f22845d.setText((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin"));
        o r20 = this.f23666a;
        if (r20 != null) goto L30;
        d.h.b.o.c("binding");
        r20 = null;
    L30:
        OTextView r21 = r20.f22845d;
        d.h.b.o.c(r21, "subTitle");
        k.a((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.aiagent.plugin"));
        o r22 = this.f23666a;
        if (r22 != null) goto L33;
        d.h.b.o.c("binding");
        r22 = null;
    L33:
        r22.f22845d.setMaxLines(1);
    L38:
        o r23 = this.f23666a;
        if (r23 != null) goto L41;
        d.h.b.o.c("binding");
        r23 = null;
    L41:
        r23.f22842a.setOnClickListener(new $$Lambda$a$N0VTthovJ3DIVxcCwzGsGvUZD4(this, r8));
        o r24 = this.f23666a;
        if (r24 != null) goto L44;
        d.h.b.o.c("binding");
    L45:
        r2.b().setOnClickListener(new $$Lambda$a$oaHQoXBp2OvfaSrqa5Bkr6Kdun8(this, r8));
        return;
    L44:
        r2 = r24;
        goto L45
    L34:
        o r25 = this.f23666a;
        if (r25 != null) goto L37;
        d.h.b.o.c("binding");
        r25 = null;
    L37:
        OTextView r26 = r25.f22845d;
        d.h.b.o.c(r26, "subTitle");
        k.b((View) ZeusTransformUtils.preCheckCast(r26, View.class, "com.obric.aiagent.plugin"));
        goto L38
    L21:
        r7 = false;
    L15:
        r18 = null;
        goto L16
    }

    private static final void a(a r3, com.obric.autoaction.app.launcherpage.discovery.a.b.a r4, View r5) {
        com.obric.autoaction.app.launcherpage.ui.d r6 = ((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin")).b();
        com.obric.autoaction.app.launcherpage.ui.c r1 = null;
        if (r6 == null) goto L11;
        g r7 = r6.b();
        if (r7 == null) goto L11;
        com.obric.autoaction.app.launcherpage.ui.c r8 = r7.a().get(b.class);
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L10;
        r1 = r8;
    L10:
        r1 = (com.obric.autoaction.app.launcherpage.ui.c) ZeusTransformUtils.preCheckCast((b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.ui.c.class, "com.obric.aiagent.plugin");
    L11:
        b r9 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L15;
        com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b r10 = (com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b) ZeusTransformUtils.preCheckCast(r4, com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b.class, "com.obric.aiagent.plugin");
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r11, "getContext(...)");
        r9.a(r10, r11);
        return;
    }

    private static final void b(a r3, com.obric.autoaction.app.launcherpage.discovery.a.b.a r4, View r5) {
        com.obric.autoaction.app.launcherpage.ui.d r6 = ((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin")).b();
        com.obric.autoaction.app.launcherpage.ui.c r1 = null;
        if (r6 == null) goto L11;
        g r7 = r6.b();
        if (r7 == null) goto L11;
        com.obric.autoaction.app.launcherpage.ui.c r8 = r7.a().get(b.class);
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L10;
        r1 = r8;
    L10:
        r1 = (com.obric.autoaction.app.launcherpage.ui.c) ZeusTransformUtils.preCheckCast((b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin"), com.obric.autoaction.app.launcherpage.ui.c.class, "com.obric.aiagent.plugin");
    L11:
        b r9 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L15;
        com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b r10 = (com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b) ZeusTransformUtils.preCheckCast(r4, com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b.class, "com.obric.aiagent.plugin");
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r11, "getContext(...)");
        r9.a(r10, r11);
        return;
    }
}
