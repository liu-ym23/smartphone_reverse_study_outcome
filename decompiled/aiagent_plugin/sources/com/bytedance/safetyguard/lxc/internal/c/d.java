package com.bytedance.safetyguard.lxc.internal.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ProxyTlv.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9818a = null;
    private static final Set<Integer> g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m f9821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c f9822e;
    private final byte[] f;

    /* JADX INFO: compiled from: ProxyTlv.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.c.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ProxyTlv.kt */
        public /* synthetic */ class C0226a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f9823a = null;

            static {
                int[] r0 = new int[m.values().length];
                r0[m.f9853b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[m.f9854c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[m.f9855d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f9823a = r0;
            }
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final d a(byte[] r13) {
            d.h.b.o.e(r13, "payload");
            Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(o.f9861a.a(r13), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r14.hasNext() == false) goto L18;
            n r1 = (n) ZeusTransformUtils.preCheckCast(r14.next(), n.class, "com.obric.aiagent.plugin");
            if (d.f().contains(Integer.valueOf(r1.getType())) == false) goto L8;
            if (r0.put(Integer.valueOf(r1.getType()), r1) == null) goto L4;
            throw new k("Duplicate TLV: " + r1.getType(), null, 2, null);
        L8:
            if ((1 & r1.a()) == 0) goto L4;
            throw new k("Unsupported critical TLV: " + r1.getType(), null, 2, null);
        L18:
            if (p.a(r0, 1) != q.f9862a.a()) goto L32;
            m r9 = m.f9852a.a(p.a(r0, 2));
            c r10 = c.f9813a.a(p.a(r0, 5));
            n r15 = (n) ZeusTransformUtils.preCheckCast(r0.get(3), n.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L30;
            byte[] r16 = r15.b();
            if (r16 == null) goto L30;
            String r7 = a(r9, r16);
            int r8 = p.b(r0, 4);
            if (r8 == 0) goto L28;
            byte[] r11 = Arrays.copyOf(r16, r16.length);
            d.h.b.o.c(r11, "copyOf(...)");
            return new d(r7, r8, r9, r10, r11);
        L28:
            throw new k("Target port must not be zero", null, 2, null);
        L30:
            throw new k("Missing target address", null, 2, null);
        L32:
            throw new k("Only TCP transport is supported", null, 2, null);
        }

        private final String a(m r2, byte[] r3) {
            int r4 = C0226a.f9823a[r2.ordinal()];
            if (r4 == 1) goto L13;
            if (r4 == 2) goto L15;
            if (r4 != 3) goto L10;
            return a(r3, 16);
        L10:
            throw new d.k();
        L15:
            return a(r3, 4);
        L13:
            return b(r3);
        }

        private final String b(byte[] r10) {
            if (r10.length != 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == true) goto L20;
            if (r10.length > 253) goto L20;
            String r11 = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(r10)).toString();     // Catch: Exception -> L16
            d.h.b.o.a(r11);
            if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, false, 6, null) >= 0) goto L15;
            return r11;
        L15:
            throw new k("Domain contains NUL", null, 2, null);
        L16:
            e = move-exception;
            throw new k("Invalid UTF-8 domain", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        L20:
            throw new k("Invalid domain length", null, 2, null);
        L5:
            r0 = false;
            goto L7
        }

        private final String a(byte[] r3, int r4) {
            if (r3.length != r4) goto L10;
            String r2 = InetAddress.getByAddress(r3).getHostAddress();
            if (r2 == null) goto L8;
            return r2;
        L8:
            throw new k("Invalid IP address", null, 2, null);
        L10:
            throw new k("Invalid IP address length", null, 2, null);
        }
    }

    /* JADX INFO: compiled from: ProxyTlv.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9824a = null;

        static {
            int[] r0 = new int[m.values().length];
            r0[m.f9853b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[m.f9854c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[m.f9855d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f9824a = r0;
        }
    }

    public static /* synthetic */ d a(d r3, String r4, int r5, m r6, c r7, byte[] r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.f9819b;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.f9820c;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.f9821d;
    L11:
        m r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.f9822e;
    L14:
        c r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.f;
    L17:
        String r12 = r4;
        return r3.a(r12, r11, r0, r1, r8);
    }

    public final d a(String r7, int r8, m r9, c r10, byte[] r11) {
        d.h.b.o.e(r7, "host");
        d.h.b.o.e(r9, "targetType");
        d.h.b.o.e(r10, "ingressProxy");
        return new d(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f9819b, r6.f9819b) == true) goto L12;
        return false;
    L12:
        if (this.f9820c == r6.f9820c) goto L15;
        return false;
    L15:
        if (this.f9821d == r6.f9821d) goto L18;
        return false;
    L18:
        if (this.f9822e == r6.f9822e) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.f9819b.hashCode() * 31) + Integer.hashCode(this.f9820c)) * 31) + this.f9821d.hashCode()) * 31) + this.f9822e.hashCode()) * 31;
        byte[] r2 = this.f;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = Arrays.hashCode(r2);
        goto L7
    }

    public String toString() {
        return "OpenTcpRequest(host=" + this.f9819b + ", port=" + this.f9820c + ", targetType=" + this.f9821d + ", ingressProxy=" + this.f9822e + ", encodedAddressBytes=" + Arrays.toString(this.f) + ')';
    }

    public d(String r2, int r3, m r4, c r5, byte[] r6) {
        d.h.b.o.e(r2, "host");
        d.h.b.o.e(r4, "targetType");
        d.h.b.o.e(r5, "ingressProxy");
        this.f9819b = r2;
        this.f9820c = r3;
        this.f9821d = r4;
        this.f9822e = r5;
        this.f = r6;
    }

    public static final /* synthetic */ Set f() {
        return g;
    }

    public final String a() {
        return this.f9819b;
    }

    public final int b() {
        return this.f9820c;
    }

    public final m c() {
        return this.f9821d;
    }

    public final c d() {
        return this.f9822e;
    }

    public final byte[] e() {
        m r0 = this.f9821d;
        int r1 = b.f9824a[r0.ordinal()];
        if (r1 != 1) goto L5;
        byte[] r2 = this.f;
        if (r2 == null) goto L22;
        byte[] r3 = Arrays.copyOf(r2, r2.length);
        d.h.b.o.c(r3, "copyOf(...)");
        if (r3 == null) goto L22;
        return r3;
    L22:
        String r4 = this.f9819b;
        Charset r5 = StandardCharsets.UTF_8;
        d.h.b.o.c(r5, "UTF_8");
        byte[] r6 = r4.getBytes(r5);
        d.h.b.o.c(r6, "getBytes(...)");
        return r6;
    L5:
        if (r1 != 2) goto L7;
    L11:
        byte[] r7 = this.f;
        if (r7 == null) goto L15;
        byte[] r8 = Arrays.copyOf(r7, r7.length);
        d.h.b.o.c(r8, "copyOf(...)");
        return r8;
    L15:
        throw new IllegalArgumentException("Explicit IP targets require protocol address bytes".toString());
    L7:
        if (r1 == 3) goto L11;
        throw new d.k();
    }

    static {
        f9818a = new a(null);
        g = ax.a(new Integer[]{1, 2, 3, 4, 5});
    }
}
