package com.bytedance.safetyguard.lxc.internal.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* JADX INFO: compiled from: ProxyTlv.kt */
/* JADX INFO: loaded from: classes.dex */
public final class p {
    public static final int a(Map<Integer, n> r4, int r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        n r7 = (n) ZeusTransformUtils.preCheckCast(r6.get(Integer.valueOf(r5)), n.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        byte[] r8 = r7.b();
        if (r8 == null) goto L13;
        if (r8.length != 1) goto L11;
        return r8[0] & 255;
    L11:
        throw new k("TLV " + r5 + " must be uint8", null, 2, null);
    L13:
        throw new k("Missing TLV: " + r5, null, 2, null);
    }

    public static final int b(Map<Integer, n> r4, int r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        n r7 = (n) ZeusTransformUtils.preCheckCast(r6.get(Integer.valueOf(r5)), n.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L13;
        byte[] r8 = r7.b();
        if (r8 == null) goto L13;
        if (r8.length != 2) goto L11;
        return ByteBuffer.wrap(r8).order(ByteOrder.BIG_ENDIAN).getShort() & 65535;
    L11:
        throw new k("TLV " + r5 + " must be uint16", null, 2, null);
    L13:
        throw new k("Missing TLV: " + r5, null, 2, null);
    }

    public static final Integer c(Map<Integer, n> r3, int r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5.get(Integer.valueOf(r4)), n.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L13;
        byte[] r7 = r6.b();
        if (r7 == null) goto L13;
        if (r7.length != 4) goto L12;
        return Integer.valueOf(ByteBuffer.wrap(r7).order(ByteOrder.BIG_ENDIAN).getInt());
    L12:
        throw new k("TLV " + r4 + " must be uint32", null, 2, null);
    L13:
        return null;
    }

    public static final Long d(Map<Integer, n> r3, int r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5.get(Integer.valueOf(r4)), n.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L13;
        byte[] r7 = r6.b();
        if (r7 == null) goto L13;
        if (r7.length != 8) goto L12;
        return Long.valueOf(ByteBuffer.wrap(r7).order(ByteOrder.BIG_ENDIAN).getLong());
    L12:
        throw new k("TLV " + r4 + " must be uint64", null, 2, null);
    L13:
        return null;
    }

    public static final String e(Map<Integer, n> r2, int r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        n r5 = (n) ZeusTransformUtils.preCheckCast(r4.get(Integer.valueOf(r3)), n.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L9;
        byte[] r6 = r5.b();
        if (r6 == null) goto L11;
        Charset r7 = StandardCharsets.UTF_8;
        d.h.b.o.c(r7, "UTF_8");
        return new String(r6, r7);
    L11:
        return null;
    L9:
        return null;
    }
}
