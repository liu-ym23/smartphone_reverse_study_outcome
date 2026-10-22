package com.bytedance.safetyguard.lxc.internal.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ProxyTlvCodec.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f9861a = null;

    static {
        f9861a = new o();
    }

    private o() {
    }

    public final byte[] a(List<n> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "tlvs");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L7;
        r2 = r2 + (((n) ZeusTransformUtils.preCheckCast(r7.next(), n.class, "com.obric.aiagent.plugin")).b().length + 8);
        goto L4
    L7:
        if (r2 > 16384) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L17;
        ByteBuffer r8 = ByteBuffer.allocate(r2).order(ByteOrder.BIG_ENDIAN);
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        n r3 = (n) ZeusTransformUtils.preCheckCast(r9.next(), n.class, "com.obric.aiagent.plugin");
        r8.putShort((short) r3.getType());
        r8.putShort((short) r3.a());
        r8.putInt(r3.b().length);
        r8.put(r3.b());
        goto L12
    L14:
        byte[] r10 = r8.array();
        d.h.b.o.c(r10, "array(...)");
        return r10;
    L17:
        throw new IllegalArgumentException("Control payload exceeds limit".toString());
    }

    public final List<n> a(byte[] r9) {
        d.h.b.o.e(r9, "payload");
        if (r9.length > 16384) goto L20;
        ByteBuffer r8 = ByteBuffer.wrap(r9).order(ByteOrder.BIG_ENDIAN);
        List<n> r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L6:
        if (r8.hasRemaining() == false) goto L18;
        if (r8.remaining() < 8) goto L17;
        int r2 = r8.getShort() & 65535;
        int r4 = 65535 & r8.getShort();
        int r5 = r8.getInt();
        if (r5 < 0) goto L15;
        if (r5 > r8.remaining()) goto L15;
        byte[] r6 = new byte[r5];
        r8.get(r6);
        ((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).add(new n(r2, r4, r6));
    L15:
        throw new k("Invalid TLV length: " + r5, null, 2, null);
    L17:
        throw new k("Truncated TLV header", null, 2, null);
    L18:
        return r10;
    L20:
        throw new k("Control payload exceeds limit", null, 2, null);
    }
}
