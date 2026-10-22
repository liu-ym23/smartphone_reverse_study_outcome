package com.obric.autogui.agents.vlm.models.omni.upload;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: OmniInferenceImageUploadBusyTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f28809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashMap<String, String> f28810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedHashSet<String> f28811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28812d;

    public l() {
        this.f28809a = new Object();
        this.f28810b = new LinkedHashMap();
        this.f28811c = new LinkedHashSet();
    }

    public final k a(String r9) {
        d.h.b.o.e(r9, DBDefinition.TASK_ID);
        String r10 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        k r3 = null;
        if (r0 == true) goto L10;
        r10 = null;
    L10:
        if (r10 != null) goto L12;
        return null;
    L12:
        Object r2 = this.f28809a;
        monitor-enter(r2);
    L42:
        th = move-exception;
        throw th;
    L15:
        if (d.h.b.o.a(this.f28812d, r10) == true) goto L40;
        String r4 = this.f28812d;     // Catch: Throwable -> L42
        if (r4 != null) goto L30;
        Collection<String> r5 = this.f28810b.values();     // Catch: Throwable -> L42
        d.h.b.o.c(r5, "<get-values>(...)");     // Catch: Throwable -> L42
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L42
    L21:
        if (r6.hasNext() == false) goto L28;
        Object r7 = r6.next();     // Catch: Throwable -> L42
        if (((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin")) == null) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == false) goto L21;
    L29:
        r4 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        goto L30
    L25:
        r8 = false;
        goto L26
    L28:
        r7 = null;
    L30:
        int r11 = this.f28810b.size();     // Catch: Throwable -> L42
        this.f28810b.clear();     // Catch: Throwable -> L42
        this.f28811c.clear();     // Catch: Throwable -> L42
        this.f28812d = r10;     // Catch: Throwable -> L42
        Integer r12 = Integer.valueOf(r11);     // Catch: Throwable -> L42
        if (((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L34;
        r1 = false;
    L34:
        if (r1 == true) goto L37;
        r12 = null;
    L37:
        if (r12 == null) goto L40;
        r3 = new k(r4, ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L42
    L40:
        monitor-exit(r2);
        return r3;
    L5:
        r0 = false;
        goto L6
    }

    public final k b(String r7) {
        d.h.b.o.e(r7, DBDefinition.TASK_ID);
        String r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        k r3 = null;
        if (r0 == true) goto L10;
        r8 = null;
    L10:
        if (r8 != null) goto L12;
        return null;
    L12:
        Object r2 = this.f28809a;
        monitor-enter(r2);
    L29:
        th = move-exception;
        throw th;
    L15:
        if (d.h.b.o.a(this.f28812d, r8) == false) goto L27;
        int r4 = this.f28810b.size();     // Catch: Throwable -> L29
        this.f28810b.clear();     // Catch: Throwable -> L29
        this.f28811c.clear();     // Catch: Throwable -> L29
        this.f28812d = null;     // Catch: Throwable -> L29
        Integer r6 = Integer.valueOf(r4);     // Catch: Throwable -> L29
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L21;
        r1 = false;
    L21:
        if (r1 == true) goto L24;
        r6 = null;
    L24:
        if (r6 == null) goto L27;
        r3 = new k(r8, ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L29
    L27:
        monitor-exit(r2);
        return r3;
    L5:
        r0 = false;
        goto L6
    }

    public final j a(String r9, String r10) {
        d.h.b.o.e(r9, "requestToken");
        String r11 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        k r3 = null;
        if (r0 == true) goto L9;
        Object r1 = this.f28809a;
        monitor-enter(r1);
        if (r10 != null) goto L66;
    L23:
        String r12 = null;
    L24:
        if (r12 == null) goto L51;
        String r4 = this.f28812d;     // Catch: Throwable -> L21
        if (r4 == null) goto L51;
        if (d.h.b.o.a(r4, r12) == true) goto L51;
        String r5 = this.f28812d;     // Catch: Throwable -> L21
        if (r5 != null) goto L42;
        Collection<String> r6 = this.f28810b.values();     // Catch: Throwable -> L21
        d.h.b.o.c(r6, "<get-values>(...)");     // Catch: Throwable -> L21
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L21
    L33:
        if (r7.hasNext() == false) goto L40;
        Object r8 = r7.next();     // Catch: Throwable -> L21
        if (((String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin")) == null) goto L37;
        boolean r13 = true;
    L38:
        if (r13 == false) goto L33;
    L41:
        r5 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        goto L42
    L37:
        r13 = false;
        goto L38
    L40:
        r8 = null;
    L42:
        int r14 = this.f28810b.size();     // Catch: Throwable -> L21
        this.f28810b.clear();     // Catch: Throwable -> L21
        this.f28811c.clear();     // Catch: Throwable -> L21
        Integer r15 = Integer.valueOf(r14);     // Catch: Throwable -> L21
        if (((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L45;
        boolean r16 = true;
    L46:
        if (r16 == true) goto L49;
        r15 = null;
    L49:
        if (r15 == null) goto L51;
        r3 = new k(r5, ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L21
        goto L51
    L45:
        r16 = false;
    L51:
        if (r12 == null) goto L53;
        this.f28812d = r12;     // Catch: Throwable -> L21
    L53:
        if (r12 != null) goto L56;
        r12 = this.f28812d;     // Catch: Throwable -> L21
    L56:
        if (this.f28810b.containsKey(r11) == false) goto L58;
        j r17 = new j(false, r3);     // Catch: Throwable -> L21
    L62:
        monitor-exit(r1);
        return r17;
    L58:
        ((Map) ZeusTransformUtils.preCheckCast(this.f28810b, Map.class, "com.obric.aiagent.plugin")).put(r11, r12);     // Catch: Throwable -> L21
        if (r12 == null) goto L61;
        this.f28811c.add(r12);     // Catch: Throwable -> L21
    L61:
        r17 = new j(true, r3);     // Catch: Throwable -> L21
        goto L62
    L66:
        r12 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L21
        if (r12 == null) goto L23;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L18;
        boolean r18 = true;
    L19:
        if (r18 == false) goto L23;
    L18:
        r18 = false;
    L21:
        th = move-exception;
        throw th;
    L9:
        return new j(false, null, 2, null);
    L5:
        r0 = false;
        goto L6
    }

    public final Set<String> c(String r5) {
        d.h.b.o.e(r5, "requestToken");
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        Object r1 = this.f28809a;
        monitor-enter(r1);
    L24:
        th = move-exception;
        throw th;
    L12:
        if (this.f28810b.containsKey(r6) == true) goto L16;
        Set<String> r4 = ax.b();     // Catch: Throwable -> L24
        monitor-exit(r1);
        return r4;
    L16:
        this.f28810b.remove(r6);     // Catch: Throwable -> L24
        if ((!((Map) ZeusTransformUtils.preCheckCast(this.f28810b, Map.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L21;
        Set<String> r7 = ax.b();     // Catch: Throwable -> L24
        monitor-exit(r1);
        return r7;
    L21:
        Set<String> r8 = d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(this.f28811c, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L24
        this.f28811c.clear();     // Catch: Throwable -> L24
        monitor-exit(r1);
        return r8;
    L8:
        return ax.b();
    L5:
        r0 = false;
        goto L6
    }

    public final boolean a() {
        Object r0 = this.f28809a;
        monitor-enter(r0);
        boolean r3 = !((Map) ZeusTransformUtils.preCheckCast(this.f28810b, Map.class, "com.obric.aiagent.plugin")).isEmpty();
        monitor-exit(r0);
        return r3;
    L8:
        th = move-exception;
        throw th;
    }
}
