package com.obric.assistant.dm.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.o;
import d.m;
import d.o.k;
import d.s;
import d.x;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: RuleMatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f22491a = null;

    static {
        f22491a = new g();
    }

    public static /* synthetic */ CharSequence lambda$2LSmMFihWGEq25Mr2MlnYUCUoVE(Map r0, d.o.i r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$AtAYt18jCXf8BZMZqzQZiPFKgIU(Map r0, d.o.i r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$eRIgCyXKJy8vAdUvZ38D1fFCejU(Map r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$mTvFyPXDp_ESRKc5DC1K2Ho4B94(Map r0, d.o.i r1) {
        return c(r0, r1);
    }

    private g() {
    }

    private final String b(String r4) {
        k r3 = new k("[一二三四五六七八九]");
        final Map r0 = ao.a(new m[]{s.a("一", "1"), s.a("二", "2"), s.a("三", "3"), s.a("四", "4"), s.a("五", "5"), s.a("六", "6"), s.a("七", "7"), s.a("八", "8"), s.a("九", "9")});
        return r3.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), new $$Lambda$g$2LSmMFihWGEq25Mr2MlnYUCUoVE(r0));
    }

    private static final CharSequence a(Map r2, d.o.i r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.o.i r5 = (d.o.i) ZeusTransformUtils.wrapperContextForParams(r3, d.o.i.class, "com.obric.aiagent.plugin");
        o.e(r5, "matchResult");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.get(r5.b()), String.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        r6 = r5.b();
    L7:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final String c(String r4) {
        k r3 = new k("\\b(first|second|third|fourth|fifth|sixth|seventh|eighth|ninth)\\b");
        final Map r0 = ao.a(new m[]{s.a("first", "No.1"), s.a("second", "No.2"), s.a("third", "No.3"), s.a("fourth", "No.4"), s.a("fifth", "No.5"), s.a("sixth", "No.6"), s.a("seventh", "No.7"), s.a("eighth", "No.8"), s.a("ninth", "No.9")});
        return r3.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), new $$Lambda$g$AtAYt18jCXf8BZMZqzQZiPFKgIU(r0));
    }

    private static final CharSequence b(Map r2, d.o.i r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.o.i r5 = (d.o.i) ZeusTransformUtils.wrapperContextForParams(r3, d.o.i.class, "com.obric.aiagent.plugin");
        o.e(r5, "matchResult");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.get(r5.b()), String.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        r6 = r5.b();
    L7:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final String d(String r12) {
        final Map r11 = ao.a(new m[]{s.a("one", "1"), s.a("two", "2"), s.a("three", "3"), s.a("four", "4"), s.a("five", "5"), s.a("six", "6"), s.a("seven", "7"), s.a("eight", "8"), s.a("nine", "9")});
        return p.a((Iterable) ZeusTransformUtils.preCheckCast(d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{" "}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, new $$Lambda$g$eRIgCyXKJy8vAdUvZ38D1fFCejU(r11), 30, null);
    }

    private static final CharSequence a(Map r3, String r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "word");
        String r0 = r4.toLowerCase(Locale.ROOT);
        o.c(r0, "toLowerCase(...)");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get(r0), String.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L5;
        Object r7 = ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
    L7:
        return (CharSequence) r7;
    L5:
        r7 = ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        goto L7
    }

    private final String e(String r4) {
        k r3 = new k("\\b(number 1|number 2|number 3|number 4|number 5|number 6|number 7|number 8|number 9)\\b");
        final Map r0 = ao.a(new m[]{s.a("number 1", "No.1"), s.a("number 2", "No.2"), s.a("number 3", "No.3"), s.a("number 4", "No.4"), s.a("number 5", "No.5"), s.a("number 6", "No.6"), s.a("number 7", "No.7"), s.a("number 8", "No.8"), s.a("number 9", "No.9")});
        return r3.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), new $$Lambda$g$mTvFyPXDp_ESRKc5DC1K2Ho4B94(r0));
    }

    private static final CharSequence c(Map r2, d.o.i r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.o.i r5 = (d.o.i) ZeusTransformUtils.wrapperContextForParams(r3, d.o.i.class, "com.obric.aiagent.plugin");
        o.e(r5, "matchResult");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.get(r5.b()), String.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        r6 = r5.b();
    L7:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final String f(String r1) {
        return e(d(c(b(r1))));
    }

    public final Integer a(String r8) {
        o.e(r8, "input");
        String r7 = f(r8);
        d.o.i r9 = k.a(new k("倒数第(\\d+)(?:个|项|条|行|排|)?"), (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        System.out.println(r7);
        if (r9 == null) goto L7;
        int r10 = -Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r9.d().get(1), String.class, "com.obric.aiagent.plugin"));
        System.out.println(r10);
        return Integer.valueOf(-Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r9.d().get(1), String.class, "com.obric.aiagent.plugin")));
    L7:
        if (new k("最后(?:一|个|项|条|行|排)?").b((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L9;
        d.o.i r11 = k.a(new k("(?:第(\\d+)(?:个|项|条|行|排|))"), (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        if (r11 != null) goto L13;
        d.o.i r12 = k.a(new k("(?:the (?:initial|first|(\\d+)(?:st|nd|rd|th)))"), (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        if (r12 == null) goto L20;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.d().get(1), String.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L20;
        return Integer.valueOf(Integer.parseInt(r13) - 1);
    L20:
        d.o.i r14 = k.a(new k("(?:(\\d+)(?:st|nd|rd|th))|(?:No\\.? (\\d+))"), (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        if (r14 == null) goto L31;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r14.d().get(1), String.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L25;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.d().get(2), String.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L31;
        return Integer.valueOf(Integer.parseInt(r15) - 1);
    L25:
        return Integer.valueOf(Integer.parseInt(r5) - 1);
    L31:
        if (k.a(new k("(?:前边的|开头的|前面的)"), (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null) != null) goto L33;
        d.o.i r16 = k.a(new k("^\\s*(\\d+)\\s*$"), (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
        if (r16 != null) goto L37;
        return null;
    L37:
        return Integer.valueOf(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r16.d().get(1), String.class, "com.obric.aiagent.plugin")) - 1);
    L33:
        return 0;
    L13:
        return Integer.valueOf(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r11.d().get(1), String.class, "com.obric.aiagent.plugin")) - 1);
    L9:
        return -1;
    }

    public final void a(String r3, d.h.a.m<? super Integer, ? super List<Integer>, x> r4) {
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
        o.e(r3, "input");
        o.e(r5, "callback");
        Integer r2 = a(r3);
        if (r2 == null) goto L5;
        r5.invoke(0, p.a(r2));
        return;
    L5:
        r5.invoke(-1, p.b());
    }
}
