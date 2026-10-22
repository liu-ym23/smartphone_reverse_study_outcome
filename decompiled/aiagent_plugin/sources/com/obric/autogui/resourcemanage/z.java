package com.obric.autogui.resourcemanage;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: ResourceUpdateSwitchPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: compiled from: ResourceUpdateSwitchPolicy.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30701a = null;

        static {
            int[] r0 = new int[k.values().length];
            r0[k.f30631a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[k.f30633c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[k.f30634d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[k.g.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[k.h.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[k.f30635e.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[k.f.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[k.f30632b.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f30701a = r0;
        }
    }

    public static final boolean a(k r2, aa r3) {
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r3, "snapshot");
        if (r2 != k.f30632b) goto L6;
        return true;
    L6:
        if (r3.a() == true) goto L10;
        return false;
    L10:
        switch(a.f30701a[r2.ordinal()]) {
            case 1: goto L16;
            case 2: goto L16;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L17;
            case 7: goto L17;
            case 8: goto L16;
            default: goto L12;
        };
    L16:
        return true;
    L12:
        throw new d.k();
    L17:
        return r3.e();
    L15:
        return r3.f();
    }

    public static final y a(aa r8, aa r9, boolean r10, boolean r11, boolean r12, k r13) {
        d.h.b.o.e(r9, "current");
        boolean r0 = true;
        if (r13 != null) goto L5;
    L7:
        boolean r14 = false;
    L9:
        if (r9.a() == false) goto L11;
        if (r11 == false) goto L14;
        if (r8 != null) goto L17;
        boolean r2 = true;
    L18:
        if (r8 != null) goto L20;
    L22:
        r0 = false;
    L23:
        LinkedHashSet r3 = new LinkedHashSet();
        Boolean r5 = null;
        if (a(r9, r2, r0, r8, k.f) == true) goto L31;
        boolean r4 = r9.e();
        if (r8 == null) goto L28;
        Boolean r7 = Boolean.valueOf(r8.e());
    L30:
        if (a(r2, r0, r4, r7) == true) goto L31;
    L35:
        if (a(r9, r2, r0, r8, k.f30631a) == true) goto L42;
        boolean r15 = r9.b();
        if (r8 == null) goto L39;
        Boolean r6 = Boolean.valueOf(r8.b());
    L41:
        if (a(r2, r0, r15, r6) == true) goto L42;
    L45:
        if (a(r9, r2, r0, r8, k.f30633c) == true) goto L52;
        boolean r16 = r9.c();
        if (r8 == null) goto L49;
        Boolean r17 = Boolean.valueOf(r8.c());
    L51:
        if (a(r2, r0, r16, r17) == true) goto L52;
    L55:
        if (a(r9, r2, r0, r8, k.f30634d) == true) goto L61;
        boolean r18 = r9.d();
        if (r8 == null) goto L60;
        r5 = Boolean.valueOf(r8.d());
    L60:
        if (a(r2, r0, r18, r5) == true) goto L61;
    L63:
        return new y((Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.aiagent.plugin"), r14, a(k.f30634d, r9), false);
    L61:
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).add(k.f30634d);
        goto L63
    L49:
        r17 = null;
    L52:
        if (r12 == false) goto L55;
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).add(k.f30633c);
        goto L55
    L39:
        r6 = null;
    L42:
        if (r11 == false) goto L45;
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).add(k.f30631a);
        goto L45
    L28:
        r7 = null;
    L31:
        if (r11 == false) goto L35;
        if (r10 == false) goto L35;
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).add(k.f);
        goto L35
    L20:
        if (r8.a() == true) goto L22;
    L17:
        r2 = false;
        goto L18
    L14:
        return new y(ax.b(), r14, a(k.f30634d, r9), false);
    L11:
        return new y(ax.b(), r14, false, true);
    L5:
        if (a(r13, r9) == true) goto L7;
        r14 = true;
        goto L9
    }

    private static final boolean a(aa r1, boolean r2, boolean r3, aa r4, k r5) {
        if (a(r5, r1) == true) goto L6;
        return false;
    L6:
        if (r2 == true) goto L15;
        if (r3 == true) goto L15;
        if (r4 != null) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L15;
        return false;
    L10:
        if (a(r5, r4) != true) goto L12;
        r6 = true;
    L15:
        return true;
    }

    private static final boolean a(boolean r1, boolean r2, boolean r3, Boolean r4) {
        if (r3 == false) goto L9;
        if (r1 == true) goto L11;
        if (r2 == false) goto L7;
        return true;
    L7:
        if (d.h.b.o.a(r4, true) == true) goto L9;
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    public static final long a(Set<? extends k> r2, long r3, long r5) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "pendingScenes");
        if (r4.contains(k.f30635e) == true) goto L6;
        return 0;
    L6:
        return d.l.n.a(r3 - r5, 0);
    }
}
