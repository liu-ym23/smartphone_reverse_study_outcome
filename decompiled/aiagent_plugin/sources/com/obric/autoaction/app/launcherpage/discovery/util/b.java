package com.obric.autoaction.app.launcherpage.discovery.util;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.m;
import d.n;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PromptSlotParser.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f23658a = null;

    static {
        f23658a = new b();
    }

    private b() {
    }

    public static /* synthetic */ c a(b r1, String r2, d r3, int r4, Object r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r6 = (d) ZeusTransformUtils.preCheckCast(new a(), d.class, "com.obric.aiagent.plugin");
    L6:
        return r1.a(r2, r6);
    }

    public final c a(String r10, d r11) {
        d r12 = (d) ZeusTransformUtils.wrapperContextForParams(r11, d.class, "com.obric.aiagent.plugin");
        o.e(r10, "input");
        o.e(r12, "spanFactory");
        c r9 = a(r10);
        Spannable r13 = r9.a();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        m r2 = (m) ZeusTransformUtils.preCheckCast(r0.next(), m.class, "com.obric.aiagent.plugin");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r12.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        e r4 = (e) ZeusTransformUtils.preCheckCast(r3.next(), e.class, "com.obric.aiagent.plugin");
        r13.setSpan(r4.a(), ((Number) ZeusTransformUtils.preCheckCast(r2.a(), Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r2.b(), Number.class, "com.obric.aiagent.plugin")).intValue(), r4.b());
        goto L7
    L9:
        r9.a(true);
        return r9;
    }

    public final c a(String r13) {
        o.e(r13, "input");
        List r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        n.a r3 = n.f38560a;     // Catch: Throwable -> L16
        int r4 = 0;
    L5:
        if (r4 >= r13.length()) goto L14;
        int r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), "<oauto-prompt-slot>", r4, false, 4, null);     // Catch: Throwable -> L16
        if (r5 < 0) goto L9;
        String r6 = r13.substring(r4, r5);     // Catch: Throwable -> L16
        o.c(r6, "substring(...)");     // Catch: Throwable -> L16
        r0.append((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        int r7 = r5 + 19;     // Catch: Throwable -> L16
        int r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), "</oauto-prompt-slot>", r7, false, 4, null);     // Catch: Throwable -> L16
        if (r8 < 0) goto L12;
        String r9 = r13.substring(r7, r8);     // Catch: Throwable -> L16
        o.c(r9, "substring(...)");     // Catch: Throwable -> L16
        int r10 = r0.length();     // Catch: Throwable -> L16
        r0.append((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        r12.add(new m(Integer.valueOf(r10), Integer.valueOf(r0.length())));     // Catch: Throwable -> L16
        r4 = r8 + 20;     // Catch: Throwable -> L16
        goto L5
    L12:
        String r14 = r13.substring(r5);     // Catch: Throwable -> L16
        o.c(r14, "substring(...)");     // Catch: Throwable -> L16
        r0.append((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        goto L14
    L9:
        String r15 = r13.substring(r4);     // Catch: Throwable -> L16
        o.c(r15, "substring(...)");     // Catch: Throwable -> L16
        r0.append((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
    L14:
        n.f(x.f38692a);     // Catch: Throwable -> L16
    L19:
        return new c((Spannable) ZeusTransformUtils.preCheckCast(r0, Spannable.class, "com.obric.aiagent.plugin"), r12, false);
    L16:
        th = move-exception;
        n.a r11 = n.f38560a;
        n.f(d.o.a(th));
        goto L19
    }

    public final void a(Context r9, c r10) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        o.e(r10, "parseResult");
        if (r10.c() == false) goto L5;
        return;
    L5:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        m r1 = (m) ZeusTransformUtils.preCheckCast(r11.next(), m.class, "com.obric.aiagent.plugin");
        r10.a().setSpan(new UnderlineSpan(), ((Number) ZeusTransformUtils.preCheckCast(r1.a(), Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r1.b(), Number.class, "com.obric.aiagent.plugin")).intValue(), 33);
        r10.a().setSpan(new ForegroundColorSpan(r8.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, "color", "oui_basic_text_3b"))), ((Number) ZeusTransformUtils.preCheckCast(r1.a(), Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r1.b(), Number.class, "com.obric.aiagent.plugin")).intValue(), 33);
        goto L7
    L9:
        r10.a(true);
    }
}
