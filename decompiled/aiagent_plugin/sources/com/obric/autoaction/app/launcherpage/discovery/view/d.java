package com.obric.autoaction.app.launcherpage.discovery.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.obric.autoaction.app.launcherpage.a.o;
import com.obric.autoaction.app.launcherpage.ui.f;
import com.obric.autoaction.app.launcherpage.ui.g;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.obric.oui.common.util.k;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ShortInstructionCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends f<com.obric.autoaction.app.launcherpage.discovery.a.b.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o f23669a;

    public static /* synthetic */ void lambda$6V99fXLMoa8PgF1dPwIOJlhGOEk(d r0, com.obric.autoaction.app.launcherpage.discovery.a.b.c r1, View r2) {
        b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$UqAJY5wTQ-D4H085iEx6GSWAHiY, reason: not valid java name */
    public static /* synthetic */ void m497lambda$UqAJY5wTQD4H085iEx6GSWAHiY(d r0, com.obric.autoaction.app.launcherpage.discovery.a.b.c r1, View r2) {
        a(r0, r1, r2);
    }

    public d() {
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(h r3, List r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a((com.obric.autoaction.app.launcherpage.discovery.a.b.c) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.discovery.a.b.c.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r4) {
        d.h.b.o.e(r4, "parent");
        o r5 = o.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        d.h.b.o.c(r5, "inflate(...)");
        this.f23669a = r5;
        if (r5 != null) goto L5;
        d.h.b.o.c("binding");
        r5 = null;
    L5:
        OUIConstraintLayout r3 = r5.b();
        d.h.b.o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    public void a(final com.obric.autoaction.app.launcherpage.discovery.a.b.c r10, List<? extends Object> r11) {
        List<? extends Object> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "item");
        d.h.b.o.e(r12, "payloads");
        super.a((h) ZeusTransformUtils.preCheckCast(r10, h.class, "com.obric.aiagent.plugin"), r12);
        o r13 = this.f23669a;
        o r0 = null;
        if (r13 != null) goto L5;
        d.h.b.o.c("binding");
        r13 = null;
    L5:
        ImageView r14 = r13.f22843b;
        d.h.b.o.c(r14, "discoveryTaskIcon");
        com.obric.aiagent.assistant.common.ui.icon.d.a(r14, r10.a().e(), r10.a().f(), r10.a().a());
        if (d.h.b.o.a(r10.a().h(), true) == false) goto L25;
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.a().g(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L10;
    L13:
        boolean r16 = true;
    L14:
        if (r16 == true) goto L25;
        o r17 = this.f23669a;
        if (r17 != null) goto L18;
        d.h.b.o.c("binding");
        r17 = null;
    L18:
        OTextView r18 = r17.f22846e;
        com.obric.autoaction.app.launcherpage.discovery.util.b r6 = com.obric.autoaction.app.launcherpage.discovery.util.b.f23658a;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r7, "getContext(...)");
        r6.a(r7, r10.b());
        r18.setText((CharSequence) ZeusTransformUtils.preCheckCast(r10.a().g(), CharSequence.class, "com.obric.aiagent.plugin"));
        r18.setMaxLines(1);
        o r19 = this.f23669a;
        if (r19 != null) goto L21;
        d.h.b.o.c("binding");
        r19 = null;
    L21:
        OTextView r110 = r19.f22845d;
        com.obric.autoaction.app.launcherpage.discovery.util.b r3 = com.obric.autoaction.app.launcherpage.discovery.util.b.f23658a;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r110.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r8, "getContext(...)");
        r3.a(r8, r10.b());
        r110.setText((CharSequence) ZeusTransformUtils.preCheckCast(r10.b().a(), CharSequence.class, "com.obric.aiagent.plugin"));
        o r111 = this.f23669a;
        if (r111 != null) goto L24;
        d.h.b.o.c("binding");
        r111 = null;
    L24:
        OTextView r112 = r111.f22845d;
        d.h.b.o.c(r112, "subTitle");
        k.a((View) ZeusTransformUtils.preCheckCast(r112, View.class, "com.obric.aiagent.plugin"));
    L32:
        o r113 = this.f23669a;
        if (r113 != null) goto L35;
        d.h.b.o.c("binding");
        r113 = null;
    L35:
        r113.f22842a.setOnClickListener(new $$Lambda$d$UqAJY5wTQD4H085iEx6GSWAHiY(this, r10));
        o r114 = this.f23669a;
        if (r114 != null) goto L38;
        d.h.b.o.c("binding");
    L39:
        r0.b().setOnClickListener(new $$Lambda$d$6V99fXLMoa8PgF1dPwIOJlhGOEk(this, r10));
        return;
    L38:
        r0 = r114;
        goto L39
    L10:
        if (r15.length() == 0) goto L13;
        r16 = false;
    L25:
        o r115 = this.f23669a;
        if (r115 != null) goto L28;
        d.h.b.o.c("binding");
        r115 = null;
    L28:
        OTextView r116 = r115.f22846e;
        com.obric.autoaction.app.launcherpage.discovery.util.b r4 = com.obric.autoaction.app.launcherpage.discovery.util.b.f23658a;
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r116.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r9, "getContext(...)");
        r4.a(r9, r10.b());
        r116.setText((CharSequence) ZeusTransformUtils.preCheckCast(r10.b().a(), CharSequence.class, "com.obric.aiagent.plugin"));
        r116.setMaxLines(2);
        o r117 = this.f23669a;
        if (r117 != null) goto L31;
        d.h.b.o.c("binding");
        r117 = null;
    L31:
        OTextView r118 = r117.f22845d;
        d.h.b.o.c(r118, "subTitle");
        k.b((View) ZeusTransformUtils.preCheckCast(r118, View.class, "com.obric.aiagent.plugin"));
        goto L32
    }

    private static final void a(d r3, com.obric.autoaction.app.launcherpage.discovery.a.b.c r4, View r5) {
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

    private static final void b(d r3, com.obric.autoaction.app.launcherpage.discovery.a.b.c r4, View r5) {
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
