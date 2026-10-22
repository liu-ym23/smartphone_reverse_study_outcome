package com.obric.event.task.nlp.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.o.o;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: TimeUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f33006a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.o.k f33007b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.o.k f33008c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final d.o.k f33009d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final DateTimeFormatter f33010e = null;
    private static final int f = 0;
    private static final int g = 0;

    private final int a(int r1) {
        if (r1 != 2) goto L5;
        return 29;
    L5:
        if (r1 != 4) goto L7;
    L13:
        return 30;
    L7:
        if (r1 == 6) goto L13;
        if (r1 == 9) goto L13;
        if (r1 == 11) goto L13;
        return 31;
    }

    private l() {
    }

    static {
        f33006a = new l();
        TAG = "TimeUtils";
        f33007b = new d.o.k("^(\\d{2})-(\\d{2})$");
        f33008c = new d.o.k("^(\\d{1,2}):(\\d{2})$");
        f33009d = new d.o.k("^([01]\\d|2[0-3]):([0-5]\\d)$");
        f33010e = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        f = 1800000;
        g = 86340000;
    }

    public final int a() {
        return f;
    }

    public final int b() {
        return g;
    }

    public final List<Integer> a(List<String> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == false) goto L13;
        return p.b();
    L13:
        if (r5.size() > 7) goto L15;
        LinkedHashSet r9 = new LinkedHashSet();
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L18:
        if (r10.hasNext() == false) goto L34;
        Integer r3 = o.d(o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString());
        if (r3 == null) goto L32;
        int r4 = r3.intValue();
        if (1 <= r4) goto L24;
    L26:
        boolean r11 = false;
    L27:
        if (r11 == false) goto L29;
        r9.add(Integer.valueOf(r4));
        goto L18
    L29:
        return p.b();
    L24:
        if (r4 >= 8) goto L26;
        r11 = true;
        goto L27
    L32:
        return p.b();
    L34:
        return p.o((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin"));
    L15:
        return p.b();
    L5:
        if (r7.isEmpty() == true) goto L8;
        r8 = false;
        goto L9
    }

    public final int b(List<String> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        String r5 = (String) ZeusTransformUtils.preCheckCast(p.l(r3), String.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L7;
        String r6 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L8:
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r0 = false;
        if (r7 != null) goto L11;
    L14:
        boolean r8 = true;
    L16:
        if (r8 == false) goto L18;
        return -1;
    L18:
        Integer r9 = o.d(r6);
        if (r9 == null) goto L28;
        int r10 = r9.intValue();
        if (1 <= r10) goto L23;
    L25:
        if (r0 == true) goto L27;
        return -1;
    L27:
        return r10;
    L23:
        if (r10 >= 32) goto L25;
        r0 = true;
        goto L25
    L28:
        return -1;
    L11:
        if (r7.length() == 0) goto L14;
        r8 = false;
    L7:
        r6 = null;
        goto L8
    }

    private final int d(String r6) {
        d.o.i r7 = f33007b.c((CharSequence) ZeusTransformUtils.preCheckCast(o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin"));
        if (r7 != null) goto L5;
        return -1;
    L5:
        boolean r3 = true;
        Integer r1 = o.d((String) ZeusTransformUtils.preCheckCast(r7.d().get(1), String.class, "com.obric.aiagent.plugin"));
        if (r1 == null) goto L26;
        int r2 = r1.intValue();
        Integer r8 = o.d((String) ZeusTransformUtils.preCheckCast(r7.d().get(2), String.class, "com.obric.aiagent.plugin"));
        if (r8 == null) goto L26;
        int r9 = r8.intValue();
        if (1 <= r2) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L17;
        return -1;
    L17:
        if (1 <= r9) goto L19;
    L21:
        r3 = false;
    L22:
        if (r3 == true) goto L25;
        return -1;
    L25:
        return (r2 * 100) + r9;
    L19:
        if (r9 > a(r2)) goto L21;
    L12:
        if (r2 >= 13) goto L14;
        r4 = true;
    L26:
        return -1;
    }

    public final String c(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L7;
        String r5 = (String) ZeusTransformUtils.preCheckCast(p.l(r4), String.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L7;
        String r6 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L8:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L16:
        if (r1 == false) goto L19;
        return "";
    L19:
        if (d(r6) < 0) goto L22;
        return r6;
    L22:
        return "";
    L11:
        if (r0.length() == 0) goto L14;
        r1 = false;
    L7:
        r6 = null;
        goto L8
    }

    public final int a(String r5) {
        d.h.b.o.e(r5, "value");
        d.o.i r4 = f33008c.c((CharSequence) ZeusTransformUtils.preCheckCast(o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin"));
        if (r4 != null) goto L5;
        return -1;
    L5:
        boolean r2 = true;
        Integer r0 = o.d((String) ZeusTransformUtils.preCheckCast(r4.d().get(1), String.class, "com.obric.aiagent.plugin"));
        if (r0 == null) goto L20;
        int r1 = r0.intValue();
        Integer r6 = o.d((String) ZeusTransformUtils.preCheckCast(r4.d().get(2), String.class, "com.obric.aiagent.plugin"));
        if (r6 == null) goto L20;
        int r7 = r6.intValue();
        if (r1 < 0) goto L20;
        if (r7 < 0) goto L15;
        if (r7 >= 60) goto L15;
    L16:
        if (r2 == false) goto L20;
        return (((r1 * 60) + r7) * 60) * 1000;
    L15:
        r2 = false;
    L20:
        return -1;
    }

    public final boolean b(String r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        return f33009d.a((CharSequence) ZeusTransformUtils.preCheckCast(o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin"));
    }

    public final String c() {
        String r1 = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        d.h.b.o.c(r1, "format(...)");
        return r1;
    }

    public final String c(String r5) {
        com.obric.event.task.nlp.a.a r4 = com.obric.event.task.nlp.a.a.f32889a;
        String r0 = TAG;
        r4.b(r0, "isoTimeToDate isoTime = " + r5);
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L10:
        if (r7 == false) goto L13;
        return null;
    L13:
        if (r5.length() >= 10) goto L17;
        com.obric.event.task.nlp.a.a.f32889a.d(r0, "isoTimeToDate invalid isoTime length: " + r5);
        return null;
    L17:
        return o.e(r5, 10);
    L5:
        if (o.d(r6) == true) goto L8;
        r7 = false;
        goto L10
    }

    public final Integer a(String r6, String r7) {
        d.h.b.o.e(r6, "firstDate");
        d.h.b.o.e(r7, "secondDate");
        LocalDate r0 = LocalDate.parse((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), DateTimeFormatter.ISO_LOCAL_DATE);     // Catch: Exception -> L12
        LocalDate r1 = LocalDate.parse((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), DateTimeFormatter.ISO_LOCAL_DATE);     // Catch: Exception -> L12
        if (r0.isAfter((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r1, ChronoLocalDate.class, "com.obric.aiagent.plugin")) == false) goto L7;
        int r2 = 1;
    L10:
        return Integer.valueOf(r2);
    L7:
        if (r0.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r1, ChronoLocalDate.class, "com.obric.aiagent.plugin")) == false) goto L9;
        r2 = -1;
        goto L10
    L9:
        r2 = 0;
    L12:
        e = move-exception;
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "compareDate invalid date: firstDate=" + r6 + ", secondDate=" + r7, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }
}
