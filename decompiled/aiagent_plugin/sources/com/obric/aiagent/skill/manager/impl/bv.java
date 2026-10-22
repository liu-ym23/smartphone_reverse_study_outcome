package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: SkillFileFailure.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bv {
    public static /* synthetic */ Void a(bt r0, Throwable r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = null;
    L6:
        return a(r0, r1);
    }

    public static final Void a(bt r1, Throwable r2) {
        d.h.b.o.e(r1, "failure");
        throw new bu(r1, r2);
    }

    public static final bt a(Throwable r6) {
        d.h.b.o.e(r6, "<this>");
        Set r0 = Collections.newSetFromMap((Map) ZeusTransformUtils.preCheckCast(new IdentityHashMap(), Map.class, "com.obric.aiagent.plugin"));
        List r1 = d.a.p.a();
    L3:
        if (r6 == null) goto L9;
        if (r1.size() >= 16) goto L9;
        if (r0.add(r6) == false) goto L9;
        r1.add(r6);
        r6 = r6.getCause();
    L9:
        List r7 = d.a.p.a(r1);
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L11:
        if (r4.hasNext() == false) goto L15;
        Object r5 = r4.next();
        if (ZeusTransformUtils.instanceOf(r5, bu.class) == false) goto L11;
        r3.add(r5);
        goto L11
    L15:
        bu r8 = (bu) ZeusTransformUtils.preCheckCast(d.a.p.l((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin")), bu.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L18;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        boolean r10 = true;
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L22;
    L24:
        Iterator r11 = r9.iterator();
    L26:
        if (r11.hasNext() == false) goto L23;
        if (ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r11.next(), Throwable.class, "com.obric.aiagent.plugin"), ZipException.class) == false) goto L26;
        boolean r12 = true;
    L30:
        if (r12 == true) goto L84;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L35;
    L37:
        Iterator r14 = r13.iterator();
    L39:
        if (r14.hasNext() == false) goto L36;
        Throwable r15 = (Throwable) ZeusTransformUtils.preCheckCast(r14.next(), Throwable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, FileNotFoundException.class) == false) goto L43;
    L46:
        boolean r16 = true;
    L47:
        if (r16 == false) goto L39;
        boolean r17 = true;
    L49:
        if (r17 == true) goto L85;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r18, Collection.class) == true) goto L54;
    L56:
        Iterator r19 = r18.iterator();
    L58:
        if (r19.hasNext() == false) goto L55;
        if (ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r19.next(), Throwable.class, "com.obric.aiagent.plugin"), IOException.class) == false) goto L58;
    L61:
        if (r10 == false) goto L64;
        return (bt) ZeusTransformUtils.preCheckCast(bt.t.f19612a, bt.class, "com.obric.aiagent.plugin");
    L64:
        return (bt) ZeusTransformUtils.preCheckCast(bt.j.f19602a, bt.class, "com.obric.aiagent.plugin");
    L55:
        r10 = false;
        goto L61
    L54:
        if (((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L56;
    L85:
        return (bt) ZeusTransformUtils.preCheckCast(bt.g.f19599a, bt.class, "com.obric.aiagent.plugin");
    L43:
        if (ZeusTransformUtils.instanceOf(r15, SecurityException.class) == true) goto L46;
        r16 = false;
    L36:
        r17 = false;
        goto L49
    L35:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L37;
    L84:
        return (bt) ZeusTransformUtils.preCheckCast(bt.l.f19604a, bt.class, "com.obric.aiagent.plugin");
    L23:
        r12 = false;
        goto L30
    L22:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L24;
    L18:
        return r8.a();
    }
}
