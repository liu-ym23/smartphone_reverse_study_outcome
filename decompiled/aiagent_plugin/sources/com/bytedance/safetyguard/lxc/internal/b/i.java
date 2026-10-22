package com.bytedance.safetyguard.lxc.internal.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: OutboundSecurityConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9754a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f9755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f9756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<Integer> f9757d;

    /* JADX INFO: compiled from: OutboundSecurityConfig.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final i a() {
            return new i(ax.b(), ax.b(), ax.b(), null);
        }

        public final i a(Set<String> r6, Set<String> r7, Set<Integer> r8) {
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.aiagent.plugin");
            Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
            Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "allowedDomains");
            d.h.b.o.e(r9, "allowedDomainSuffixes");
            d.h.b.o.e(r10, "allowedPorts");
            Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
            Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r13 = r11.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            r12.add(i.f9754a.a((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin"), "domain"));
            goto L4
        L6:
            LinkedHashSet r14 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r12, LinkedHashSet.class, "com.obric.aiagent.plugin");
            Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
            Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r17 = r15.iterator();
        L8:
            if (r17.hasNext() == false) goto L10;
            r16.add(i.f9754a.a((String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin"), "domain suffix"));
            goto L8
        L10:
            LinkedHashSet r18 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r16, LinkedHashSet.class, "com.obric.aiagent.plugin");
            Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
            Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r21 = r19.iterator();
        L12:
            if (r21.hasNext() == false) goto L23;
            int r1 = ((Number) ZeusTransformUtils.preCheckCast(r21.next(), Number.class, "com.obric.aiagent.plugin")).intValue();
            boolean r2 = false;
            if (1 <= r1) goto L16;
        L18:
            if (r2 == false) goto L21;
            r20.add(Integer.valueOf(r1));
            goto L12
        L21:
            throw new IllegalArgumentException(("Allowed port is out of range: " + r1).toString());
        L16:
            if (r1 >= 65536) goto L18;
            r2 = true;
            goto L18
        L23:
            return new i((Set) ZeusTransformUtils.preCheckCast(r14, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.preCheckCast(r18, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.preCheckCast((LinkedHashSet) ZeusTransformUtils.preCheckCast(r20, LinkedHashSet.class, "com.obric.aiagent.plugin"), Set.class, "com.obric.aiagent.plugin"), null);
        }

        private final String a(String r3, String r4) {
            return s.f9797a.a(r3);
        L4:
            e = move-exception;
            throw new IllegalArgumentException("Invalid allowed " + r4, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f9754a = new a(null);
    }

    public /* synthetic */ i(Set r2, Set r3, Set r4, d.h.b.h r5) {
        this((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"));
    }

    private i(Set<String> r3, Set<String> r4, Set<Integer> r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        this.f9755b = d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin"));
        this.f9756c = d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"));
        this.f9757d = d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin"));
    }

    public final h a(g r10) {
        g r11 = (g) ZeusTransformUtils.wrapperContextForParams(r10, g.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "target");
        boolean r2 = true;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f9757d, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L9;
        if (this.f9757d.contains(Integer.valueOf(r11.b())) == true) goto L9;
        return h.f9751b;
    L9:
        if (this.f9755b.isEmpty() == false) goto L14;
        if (this.f9756c.isEmpty() == false) goto L14;
        return null;
    L14:
        if (ZeusTransformUtils.instanceOf(r11, g.a.class) == false) goto L16;
        g.a r12 = (g.a) ZeusTransformUtils.preCheckCast(r11, g.a.class, "com.obric.aiagent.plugin");
    L17:
        if (r12 == null) goto L19;
        boolean r0 = this.f9755b.contains(r12.a());
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(this.f9756c, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L23;
    L25:
        Iterator r13 = r9.iterator();
    L27:
        if (r13.hasNext() == false) goto L24;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r12.a(), r4) == false) goto L31;
    L34:
        boolean r5 = true;
    L35:
        if (r5 == false) goto L27;
    L36:
        if (r0 == true) goto L46;
        if (r2 == false) goto L40;
        return null;
    L40:
        return h.f9750a;
    L46:
        return null;
    L31:
        if (d.o.o.c(r12.a(), '.' + r4, false, 2, null) == true) goto L34;
        r5 = false;
    L24:
        r2 = false;
        goto L36
    L23:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L25;
    L19:
        return h.f9750a;
    L16:
        r12 = null;
        goto L17
    }
}
