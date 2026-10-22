package com.obric.autogui.agents.scripted.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ScriptResourceDownloader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: compiled from: ScriptResourceDownloader.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27094a = null;

        static {
            int[] r0 = new int[com.obric.autogui.resourcemanage.k.values().length];
            r0[com.obric.autogui.resourcemanage.k.f30632b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[com.obric.autogui.resourcemanage.k.g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[com.obric.autogui.resourcemanage.k.h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[com.obric.autogui.resourcemanage.k.f30635e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[com.obric.autogui.resourcemanage.k.f.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[com.obric.autogui.resourcemanage.k.f30631a.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[com.obric.autogui.resourcemanage.k.f30633c.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[com.obric.autogui.resourcemanage.k.f30634d.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f27094a = r0;
        }
    }

    public static final com.obric.autogui.resourcemanage.k a(Set<? extends com.obric.autogui.resourcemanage.k> r7, d.h.a.b<? super com.obric.autogui.resourcemanage.k, Boolean> r8) {
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "scenes");
        d.h.b.o.e(r10, "isEnabled");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r2 = r12.next();
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10.invoke(r2), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r13.hasNext() == true) goto L11;
        Object r14 = null;
    L22:
        return (com.obric.autogui.resourcemanage.k) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.resourcemanage.k.class, "com.obric.aiagent.plugin");
    L11:
        Object r15 = r13.next();
        if (r13.hasNext() == true) goto L14;
    L13:
        r14 = r15;
        goto L22
    L14:
        double r3 = a((com.obric.autogui.resourcemanage.k) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.resourcemanage.k.class, "com.obric.aiagent.plugin"));
    L15:
        Object r1 = r13.next();
        double r4 = a((com.obric.autogui.resourcemanage.k) ZeusTransformUtils.preCheckCast(r1, com.obric.autogui.resourcemanage.k.class, "com.obric.aiagent.plugin"));
        if (Double.compare(r3, r4) <= 0) goto L19;
        r15 = r1;
        r3 = r4;
    L19:
        if (r13.hasNext() == true) goto L15;
        goto L13
    }

    private static final double a(com.obric.autogui.resourcemanage.k r2) {
        switch(a.f27094a[r2.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        return 6.0d;
    L7:
        return 5.0d;
    L8:
        return 4.0d;
    L9:
        return 3.0d;
    L10:
        return 2.0d;
    L11:
        return 1.5d;
    L12:
        return 1.0d;
    L13:
        return 0.0d;
    L5:
        throw new d.k();
    }
}
