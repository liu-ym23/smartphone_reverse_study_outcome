package com.bytedance.safetyguard.lxc.internal.b;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: IpAddressClassifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f9735a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f9736b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<byte[]> f9737c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<d.m<f, b>> f9738d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<byte[]> f9739e = null;
    private static final List<d.m<f, b>> f = null;

    private d() {
    }

    public final c a(InetAddress r2) {
        d.h.b.o.e(r2, SensitiveType.ADDRESS);
        byte[] r3 = r2.getAddress();
        d.h.b.o.c(r3, "getAddress(...)");
        return a(r3);
    }

    public final c a(byte[] r3) {
        d.h.b.o.e(r3, "addressBytes");
        int r0 = r3.length;
        if (r0 == 4) goto L10;
        if (r0 != 16) goto L8;
        return c(r3);
    L8:
        throw new IllegalArgumentException("IP address must contain 4 or 16 bytes");
    L10:
        return b(r3);
    }

    private final c b(byte[] r6) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(f9737c, Iterable.class, "com.obric.aiagent.plugin");
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (Arrays.equals((byte[]) ZeusTransformUtils.preCheckCast(r1.next(), byte[].class, "com.obric.aiagent.plugin"), r6) == false) goto L9;
        r3 = true;
    L13:
        if (r3 == true) goto L15;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(f9738d, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L18:
        if (r5.hasNext() == false) goto L22;
        Object r2 = r5.next();
        if (((f) ZeusTransformUtils.preCheckCast(((d.m) ZeusTransformUtils.preCheckCast(r2, d.m.class, "com.obric.aiagent.plugin")).c(), f.class, "com.obric.aiagent.plugin")).a(r6) == false) goto L18;
    L23:
        d.m r7 = (d.m) ZeusTransformUtils.preCheckCast(r2, d.m.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L28;
        b r8 = (b) ZeusTransformUtils.preCheckCast(r7.d(), b.class, "com.obric.aiagent.plugin");
        return f9735a.a(r8);
    L28:
        return f9736b;
    L22:
        r2 = null;
        goto L23
    L15:
        return a(b.o);
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final c c(byte[] r6) {
        if (d(r6) == false) goto L6;
        b r5 = b(d.a.i.a(r6, 12, 16)).a();
        return new c(b.n, r5);
    L6:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(f9739e, Iterable.class, "com.obric.aiagent.plugin");
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L9;
    L11:
        Iterator r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L17;
        if (Arrays.equals((byte[]) ZeusTransformUtils.preCheckCast(r1.next(), byte[].class, "com.obric.aiagent.plugin"), r6) == false) goto L13;
        r3 = true;
    L17:
        if (r3 == true) goto L19;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(f, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L22:
        if (r7.hasNext() == false) goto L26;
        Object r2 = r7.next();
        if (((f) ZeusTransformUtils.preCheckCast(((d.m) ZeusTransformUtils.preCheckCast(r2, d.m.class, "com.obric.aiagent.plugin")).c(), f.class, "com.obric.aiagent.plugin")).a(r6) == false) goto L22;
    L27:
        d.m r8 = (d.m) ZeusTransformUtils.preCheckCast(r2, d.m.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L32;
        b r9 = (b) ZeusTransformUtils.preCheckCast(r8.d(), b.class, "com.obric.aiagent.plugin");
        return f9735a.a(r9);
    L32:
        return f9736b;
    L26:
        r2 = null;
        goto L27
    L19:
        return a(b.o);
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L11;
        goto L11
    }

    private final boolean d(byte[] r7) {
        byte[] r1 = d.a.i.a(r7, d.l.n.b(0, 10));
        int r2 = r1.length;
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L12;
        if (r1[r3] != 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L10;
        r3 = r3 + 1;
        goto L4
    L10:
        boolean r4 = false;
    L13:
        if (r4 == true) goto L15;
        return false;
    L15:
        if (r7[10] == (-1)) goto L17;
        return false;
    L17:
        if (r7[11] == (-1)) goto L19;
        return false;
    L19:
        return true;
    L8:
        r5 = false;
        goto L9
    L12:
        r4 = true;
        goto L13
    }

    private final c a(b r3) {
        return new c(r3, null, 2, null);
    }

    static {
        f9735a = new d();
        f9736b = new c(b.f9728a, null, 2, null);
        f9737c = d.a.p.b((Object[]) ZeusTransformUtils.preCheckCast(new byte[][]{e.a(169, 254, 169, 254), e.a(169, 254, 170, 2), e.a(100, 100, 100, 200), e.a(OCardListItem.DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP, 63, 129, 16)}, Object[].class, "com.obric.aiagent.plugin"));
        f9738d = d.a.p.b(new d.m[]{d.s.a(e.a(0, 0, 0, 0, 8), b.f9729b), d.s.a(e.a(127, 0, 0, 0, 8), b.f9730c), d.s.a(e.a(169, 254, 0, 0, 16), b.f9731d), d.s.a(e.a(10, 0, 0, 0, 8), b.f9732e), d.s.a(e.a(172, 16, 0, 0, 12), b.f9732e), d.s.a(e.a(192, OCardListItem.DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP, 0, 0, 16), b.f9732e), d.s.a(e.a(100, 64, 0, 0, 10), b.f), d.s.a(e.a(192, 0, 2, 0, 24), b.k), d.s.a(e.a(198, 51, 100, 0, 24), b.k), d.s.a(e.a(203, 0, 113, 0, 24), b.k), d.s.a(e.a(198, 18, 0, 0, 15), b.l), d.s.a(e.a(224, 0, 0, 0, 4), b.i), d.s.a(e.a(192, 0, 0, 0, 24), b.j), d.s.a(e.a(192, 88, 99, 0, 24), b.j), d.s.a(e.a(240, 0, 0, 0, 4), b.j)});
        f9739e = d.a.p.b((Object[]) ZeusTransformUtils.preCheckCast(new byte[][]{e.a(new int[]{64768, 3778, 0, 0, 0, 0, 0, 596}), e.a(new int[]{65152, 0, 0, 0, 0, 0, 43518, 43518})}, Object[].class, "com.obric.aiagent.plugin"));
        f = d.a.p.b(new d.m[]{d.s.a(e.a(128, new int[]{0, 0, 0, 0, 0, 0, 0, 0}), b.f9729b), d.s.a(e.a(128, new int[]{0, 0, 0, 0, 0, 0, 0, 1}), b.f9730c), d.s.a(e.a(10, new int[]{65152}), b.f9731d), d.s.a(e.a(10, new int[]{65216}), b.h), d.s.a(e.a(7, new int[]{64512}), b.g), d.s.a(e.a(8, new int[]{65280}), b.i), d.s.a(e.a(32, new int[]{8193, 3512}), b.k), d.s.a(e.a(20, new int[]{16383}), b.k), d.s.a(e.a(48, new int[]{8193, 2, 0}), b.l), d.s.a(e.a(96, new int[]{100, 65435, 0, 0, 0, 0}), b.m), d.s.a(e.a(48, new int[]{100, 65435, 1}), b.m), d.s.a(e.a(32, new int[]{8193, 0}), b.m), d.s.a(e.a(16, new int[]{8194}), b.m), d.s.a(e.a(96, new int[]{0, 0, 0, 0, 0, 0}), b.j), d.s.a(e.a(64, new int[]{256, 0, 0, 0}), b.j), d.s.a(e.a(23, new int[]{8193}), b.j), d.s.a(e.a(16, new int[]{24320}), b.j)});
    }
}
