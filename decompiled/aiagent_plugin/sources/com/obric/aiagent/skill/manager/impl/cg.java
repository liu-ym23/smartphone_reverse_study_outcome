package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SkillImportTempCleaner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cg f19656a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<d.o.k> f19657b = null;

    private cg() {
    }

    public static /* synthetic */ ch a(cg r6, File r7, long r8, long r10, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r10 = System.currentTimeMillis();
    L6:
        return r6.a(r7, r8, r10);
    }

    public final ch a(File r11, long r12, long r14) {
        d.h.b.o.e(r11, "cacheDir");
        if (r11.exists() == true) goto L6;
        File[] r10 = new File[0];
    L9:
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r1 = r10.length;
        int r3 = 0;
    L10:
        if (r3 >= r1) goto L32;
        File r4 = r10[r3];
        boolean r6 = true;
        if (r4.isDirectory() == false) goto L28;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(f19657b, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L16;
    L18:
        Iterator r7 = r5.iterator();
    L20:
        if (r7.hasNext() == false) goto L17;
        d.o.k r8 = (d.o.k) ZeusTransformUtils.preCheckCast(r7.next(), d.o.k.class, "com.obric.aiagent.plugin");
        String r9 = r4.getName();
        d.h.b.o.c(r9, "getName(...)");
        if (r8.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L20;
        boolean r15 = true;
    L24:
        if (r15 == false) goto L28;
        if ((r14 - r4.lastModified()) < r12) goto L28;
    L29:
        if (r6 == false) goto L31;
        r13.add(r4);
    L31:
        r3 = r3 + 1;
    L17:
        r15 = false;
        goto L24
    L16:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L18;
    L28:
        r6 = false;
        goto L29
    L32:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r17 = 0;
        int r18 = 0;
    L34:
        if (r16.hasNext() == false) goto L43;
        File r19 = (File) ZeusTransformUtils.preCheckCast(r16.next(), File.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r19);     // Catch: Exception -> L38
        boolean r110 = d.f.k.h(r19);     // Catch: Exception -> L38
    L39:
        if (r110 == true) goto L40;
        r18 = r18 + 1;
        goto L34
    L40:
        r17 = r17 + 1;
    L38:
        r110 = false;
        goto L39
    L43:
        return new ch(r17, r18);
    L6:
        if (r11.isDirectory() == false) goto L47;
        r10 = r11.listFiles();
        if (r10 != null) goto L9;
        throw new IOException("Failed to list Skill cache directory.");
    L47:
        throw new IOException("Skill cache path is not a directory.");
    }

    static {
        f19656a = new cg();
        f19657b = d.a.p.b(new d.o.k[]{new d.o.k("skill_import_\\d+_-?\\d+"), new d.o.k("skill_import_api_\\d+_-?\\d+")});
    }
}
