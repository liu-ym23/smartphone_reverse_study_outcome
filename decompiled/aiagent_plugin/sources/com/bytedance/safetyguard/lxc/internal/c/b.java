package com.bytedance.safetyguard.lxc.internal.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: HelloHandshake.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9812a = null;

    static {
        f9812a = new b();
    }

    private b() {
    }

    public final i a(f r15) {
        d.h.b.o.e(r15, "frame");
        if (r15.getType() != h.f9833b) goto L37;
        if (r15.a() != 0) goto L37;
        Map<Integer, n> r14 = a(r15.c());
        String r5 = p.e(r14, 515);
        if (r5 == null) goto L35;
        Long r16 = p.d(r14, 513);
        if (r16 == null) goto L33;
        long r6 = r16.longValue();
        Long r17 = p.d(r14, 514);
        if (r17 == null) goto L13;
        long r0 = r17.longValue();
    L14:
        long r8 = r0;
        Integer r1 = p.c(r14, 516);
        if (r1 == null) goto L17;
        int r2 = r1.intValue();
    L18:
        int r10 = r2;
        Integer r3 = p.c(r14, 517);
        if (r3 == null) goto L21;
        int r4 = r3.intValue();
    L22:
        int r11 = r4;
        Integer r7 = p.c(r14, 518);
        if (r7 == null) goto L25;
        int r9 = r7.intValue();
    L26:
        int r12 = r9;
        Integer r18 = p.c(r14, 520);
        if (r18 == null) goto L29;
        int r19 = r18.intValue();
    L31:
        return new i(r5, r6, r8, r10, r11, r12, r19);
    L29:
        r19 = 300000;
        goto L31
    L25:
        r9 = 262144;
        goto L26
    L21:
        r4 = 32768;
        goto L22
    L17:
        r2 = 1048576;
        goto L18
    L13:
        r0 = 0;
        goto L14
    L33:
        throw new k("Missing feature bitmap", null, 2, null);
    L35:
        throw new k("Missing session id", null, 2, null);
    L37:
        throw new k("Expected HELLO on stream 0", null, 2, null);
    }

    public final j a(i r13) {
        d.h.b.o.e(r13, "hello");
        long r0 = r13.c() & (-512);
        if (r0 != 0) goto L5;
        long r1 = (~r13.b()) & 511;
        if (r1 == 0) goto L11;
        return a(r13, a.f9810d, "Gateway missing phase-one features: " + r1);
    L11:
        if (r13.d() <= 0) goto L33;
        if (r13.d() > 1048576) goto L33;
        if (r13.e() <= 0) goto L31;
        if (r13.e() > r13.d()) goto L31;
        if (r13.f() > 0) goto L25;
        return a(r13, a.f9811e, "Invalid stream window: " + r13.f());
    L25:
        if (r13.g() > 0) goto L29;
        return a(r13, a.f9811e, "Invalid open result timeout: " + r13.g());
    L29:
        return new j(r13.a(), r13.b() & 511, Math.min(r13.d(), 1048576), Math.min(r13.e(), 32768), Math.min(r13.f(), 262144), Math.min(r13.g(), 300000), null, null, 192, null);
    L31:
        return a(r13, a.f9811e, "Invalid data chunk size: " + r13.e());
    L33:
        return a(r13, a.f9811e, "Invalid max frame payload: " + r13.d());
    L5:
        return a(r13, a.f9810d, "Missing required features: " + r0);
    }

    public final byte[] a(j r10) {
        d.h.b.o.e(r10, "ack");
        List<n> r9 = d.a.p.c(new n[]{n.a.a(n.f9857a, 515, r10.a(), 0, 4, null), n.a.a(n.f9857a, 513, r10.b(), 0, 4, null), n.a.b(n.f9857a, 516, r10.c(), 0, 4, null), n.a.b(n.f9857a, 517, r10.d(), 0, 4, null), n.a.b(n.f9857a, 518, r10.e(), 0, 4, null), n.a.b(n.f9857a, 520, r10.f(), 0, 4, null), n.a.a(n.f9857a, 257, r10.g().a(), 0, 4, null)});
        String r2 = r10.h();
        if (r2 == null) goto L6;
        ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).add(n.a.a(n.f9857a, 519, r2, 0, 4, null));
    L6:
        return o.f9861a.a(r9);
    }

    private final j a(i r11, a r12, String r13) {
        return new j(r11.a(), 0, Math.min(r11.d(), 1048576), Math.min(r11.e(), 32768), Math.min(r11.f(), 262144), d.l.n.a(r11.g(), 0, 300000), r12, r13);
    }

    private final Map<Integer, n> a(byte[] r8) {
        Set r7 = ax.a(new Integer[]{513, 514, 515, 516, 517, 518, 520, 519, 257});
        Map<Integer, n> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(o.f9861a.a(r8), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L17;
        n r3 = (n) ZeusTransformUtils.preCheckCast(r9.next(), n.class, "com.obric.aiagent.plugin");
        if (r7.contains(Integer.valueOf(r3.getType())) == false) goto L8;
        if (r0.put(Integer.valueOf(r3.getType()), r3) == null) goto L4;
        throw new k("Duplicate TLV: " + r3.getType(), null, 2, null);
    L8:
        if ((r3.a() & 1) == 0) goto L4;
        throw new k("Unsupported critical TLV: " + r3.getType(), null, 2, null);
    L17:
        return r0;
    }
}
