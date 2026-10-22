package com.bytedance.safetyguard.lxc.internal.e.g;

import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.l;
import d.h.b.o;
import d.h.b.p;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SidecarSessionStore.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10839a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<Long> f10840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SecureRandom f10841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, com.bytedance.safetyguard.lxc.internal.e.g.a> f10842d;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.g.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: SidecarSessionStore.kt */
    /* synthetic */ class AnonymousClass1 extends l implements d.h.a.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f10843a = null;

        static {
            f10843a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        public final Long a() {
            return Long.valueOf(System.currentTimeMillis());
        }

        @Override // d.h.a.a
        public /* synthetic */ Long invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: SidecarSessionStore.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final String a(String r3) {
            o.e(r3, "host");
            String r2 = d.o.o.c(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString(), new char[]{'.'});
            Locale r4 = Locale.US;
            o.c(r4, "US");
            String r5 = r2.toLowerCase(r4);
            o.c(r5, "toLowerCase(...)");
            return r5;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.g.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SidecarSessionStore.kt */
    static final class C0244b extends p implements d.h.a.b<Map.Entry<String, com.bytedance.safetyguard.lxc.internal.e.g.a>, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f10844a;

        C0244b(long r1) {
            this.f10844a = r1;
            super(1);
        }

        public final Boolean a(Map.Entry<String, com.bytedance.safetyguard.lxc.internal.e.g.a> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
            o.e(r4, "it");
            if (((com.bytedance.safetyguard.lxc.internal.e.g.a) ZeusTransformUtils.preCheckCast(r4.getValue(), com.bytedance.safetyguard.lxc.internal.e.g.a.class, "com.obric.aiagent.plugin")).g() > this.f10844a) goto L5;
            boolean r2 = true;
        L7:
            return Boolean.valueOf(r2);
        L5:
            r2 = false;
            goto L7
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(Map.Entry<String, com.bytedance.safetyguard.lxc.internal.e.g.a> r3) {
            return a((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f10839a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ boolean lambda$uddsev2dkEG0X44zuKhrFCiSpWI(d.h.a.b r0, Object r1) {
        return a(r0, r1);
    }

    public b(d.h.a.a<Long> r3, SecureRandom r4) {
        d.h.a.a<Long> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r5, "nowMillis");
        o.e(r4, "random");
        this.f10840b = r5;
        this.f10841c = r4;
        this.f10842d = new ConcurrentHashMap();
    }

    public /* synthetic */ b(d.h.a.a r2, SecureRandom r3, int r4, h r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f10843a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = new SecureRandom();
    L8:
        this(r6, r3);
    }

    public final com.bytedance.safetyguard.lxc.internal.e.g.a a(String r19, String r20, String r21, SidecarBrand r22, Set<String> r23, long r24) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r23, Set.class, "com.obric.aiagent.plugin");
        o.e(r19, "cliName");
        o.e(r20, "appId");
        o.e(r21, "userOpenId");
        o.e(r22, PlatformConst.BUNDLE_KEY_BRAND);
        o.e(r3, "targetHosts");
        if (r24 <= 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L14;
        c();
        long r14 = ((Number) ZeusTransformUtils.preCheckCast(this.f10840b.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        long r16 = Math.addExact(r14, r24);
        String r7 = UUID.randomUUID().toString();
        o.c(r7, "toString(...)");
        String r12 = d();
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r1.iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");
        r2.add(f10839a.a(r6));
        goto L9
    L11:
        com.bytedance.safetyguard.lxc.internal.e.g.a r8 = new com.bytedance.safetyguard.lxc.internal.e.g.a(r7, r19, r20, r21, r22, r12, (Set) ZeusTransformUtils.preCheckCast(r2, Set.class, "com.obric.aiagent.plugin"), r14, r16);
        ((Map) ZeusTransformUtils.preCheckCast(this.f10842d, Map.class, "com.obric.aiagent.plugin")).put(r8.a(), r8);
        return r8;
    L14:
        throw new IllegalArgumentException("ttlMillis must be positive".toString());
    L5:
        r5 = false;
        goto L6
    }

    public final boolean a(String r2) {
        o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
        c();
        if (this.f10842d.remove(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final int a(String r8, String r9) {
        o.e(r8, "appId");
        o.e(r9, "userOpenId");
        c();
        Set<Map.Entry<String, com.bytedance.safetyguard.lxc.internal.e.g.a>> r0 = this.f10842d.entrySet();
        o.c(r0, "<get-entries>(...)");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L13;
        Object r4 = r3.next();
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.aiagent.plugin");
        if (o.a(((com.bytedance.safetyguard.lxc.internal.e.g.a) ZeusTransformUtils.preCheckCast(r5.getValue(), com.bytedance.safetyguard.lxc.internal.e.g.a.class, "com.obric.aiagent.plugin")).b(), r8) == true) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        if (o.a(((com.bytedance.safetyguard.lxc.internal.e.g.a) ZeusTransformUtils.preCheckCast(r5.getValue(), com.bytedance.safetyguard.lxc.internal.e.g.a.class, "com.obric.aiagent.plugin")).c(), r9) == false) goto L10;
        r6 = true;
        goto L11
    L13:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r10, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r10.iterator();
    L15:
        if (r12.hasNext() == false) goto L17;
        r11.add((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        goto L15
    L17:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L19:
        if (r14.hasNext() == false) goto L22;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin");
        this.f10842d.remove(r7);
        goto L19
    L22:
        return r13.size();
    }

    public final int b(String r7) {
        o.e(r7, "appId");
        c();
        Set<Map.Entry<String, com.bytedance.safetyguard.lxc.internal.e.g.a>> r0 = this.f10842d.entrySet();
        o.c(r0, "<get-entries>(...)");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if (o.a(((com.bytedance.safetyguard.lxc.internal.e.g.a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), com.bytedance.safetyguard.lxc.internal.e.g.a.class, "com.obric.aiagent.plugin")).b(), r7) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L12;
        r5.add((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        goto L10
    L12:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r6.hasNext() == false) goto L17;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
        this.f10842d.remove(r11);
        goto L14
    L17:
        return r10.size();
    }

    public final int a() {
        int r0 = this.f10842d.size();
        this.f10842d.clear();
        return r0;
    }

    public final List<com.bytedance.safetyguard.lxc.internal.e.g.a> b() {
        c();
        Collection<com.bytedance.safetyguard.lxc.internal.e.g.a> r2 = this.f10842d.values();
        o.c(r2, "<get-values>(...)");
        return d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"));
    }

    private final void c() {
        long r0 = ((Number) ZeusTransformUtils.preCheckCast(this.f10840b.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        Set<Map.Entry<String, com.bytedance.safetyguard.lxc.internal.e.g.a>> r4 = this.f10842d.entrySet();
        final d.h.a.b r1 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new C0244b(r0), d.h.a.b.class, "com.obric.aiagent.plugin");
        r4.removeIf(new $$Lambda$b$uddsev2dkEG0X44zuKhrFCiSpWI(r1));
    }

    private static final boolean a(d.h.a.b r2, Object r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "$tmp0");
        return ((Boolean) ZeusTransformUtils.preCheckCast(r4.invoke(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private final String d() {
        byte[] r0 = new byte[32];
        this.f10841c.nextBytes(r0);
        String r1 = Base64.getUrlEncoder().withoutPadding().encodeToString(r0);
        o.c(r1, "encodeToString(...)");
        return r1;
    }
}
