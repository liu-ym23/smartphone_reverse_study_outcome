package com.bytedance.safetyguard.lxc.internal.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: ProxyFrameCodec.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f9831a = null;

    static {
        f9831a = new g();
    }

    private g() {
    }

    public final byte[] a(f r11) {
        d.h.b.o.e(r11, "frame");
        if (r11.c().length > 1048576) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return d.a.i.a(a(this, r11.getType(), r11.a(), r11.b(), r11.c().length, 0, 0, 48, null), r11.c());
    L10:
        throw new IllegalArgumentException("Payload exceeds hard limit".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final f a(InputStream r14) {
        d.h.b.o.e(r14, "input");
        byte[] r1 = new byte[20];
        if (a(r14, r1) != 0) goto L5;
        return null;
    L5:
        ByteBuffer r2 = ByteBuffer.wrap(r1).order(ByteOrder.BIG_ENDIAN);
        int r3 = r2.getInt();
        int r4 = r2.get() & 255;
        int r5 = r2.get() & 255;
        int r6 = r2.get() & 255;
        int r7 = r2.get() & 255;
        int r8 = r2.getShort() & 65535;
        int r9 = 65535 & r2.getShort();
        int r10 = r2.getInt();
        int r11 = r2.getInt();
        if (r3 != 1280853840) goto L26;
        if (r4 != 1) goto L24;
        if (r5 != 0) goto L24;
        if (r7 != 20) goto L22;
        if (r9 != 0) goto L20;
        if (r11 < 0) goto L18;
        if (r11 > 1048576) goto L18;
        byte[] r0 = new byte[r11];
        b(r14, r0);
        return new f(h.f9832a.a(r6), r10, r8, r0);
    L18:
        throw new k("Invalid payload length: " + r11, null, 2, null);
    L20:
        throw new k("Reserved header bits must be zero", null, 2, null);
    L22:
        throw new k("Unsupported header length: " + r7, null, 2, null);
    L24:
        throw new k("Unsupported protocol version: " + r4 + '.' + r5, null, 2, null);
    L26:
        throw new k("Invalid frame magic", null, 2, null);
    }

    public static /* synthetic */ byte[] a(g r9, h r10, int r11, int r12, int r13, int r14, int r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        int r5 = 0;
    L7:
        if ((r16 & 16) == 0) goto L9;
        int r7 = 1;
    L11:
        if ((r16 & 32) == 0) goto L13;
        int r8 = 0;
    L15:
        return r9.a(r10, r11, r5, r13, r7, r8);
    L13:
        r8 = r15;
        goto L15
    L9:
        r7 = r14;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    public final byte[] a(h r3, int r4, int r5, int r6, int r7, int r8) {
        d.h.b.o.e(r3, "type");
        byte[] r2 = ByteBuffer.allocate(20).order(ByteOrder.BIG_ENDIAN).putInt(1280853840).put((byte) r7).put((byte) r8).put((byte) r3.a()).put((byte) 20).putShort((short) r5).putShort(0).putInt(r4).putInt(r6).array();
        d.h.b.o.c(r2, "array(...)");
        return r2;
    }

    private final int a(InputStream r3, byte[] r4) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L13;
        int r1 = r3.read(r4, r0, r4.length - r0);
        if (r1 < 0) goto L7;
        if (r1 == 0) goto L4;
        r0 = r0 + r1;
        goto L4
    L7:
        if (r0 != 0) goto L10;
        return 0;
    L10:
        throw new k("Unexpected EOF in frame header", (Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.aiagent.plugin"));
    L13:
        return r0;
    }

    private final void b(InputStream r2, byte[] r3) {
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L11;
        int r0 = r2.read(r3, r1, r3.length - r1);
        if (r0 < 0) goto L10;
        if (r0 == 0) goto L4;
        r1 = r1 + r0;
        goto L4
    L10:
        throw new k("Unexpected EOF in frame payload", (Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.aiagent.plugin"));
    }
}
