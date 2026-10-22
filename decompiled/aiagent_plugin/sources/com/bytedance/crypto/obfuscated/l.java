package com.bytedance.crypto.obfuscated;

import androidx.core.internal.view.SupportMenu;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f7869a = null;

    static {
        f7869a = new byte[]{83, 76, 70, 75};
    }

    public static byte[] a(int r2, String r3) {
        byte[] r4 = r3.getBytes(StandardCharsets.UTF_8);
        ByteBuffer r0 = ByteBuffer.allocate(r4.length + 12).order(ByteOrder.BIG_ENDIAN);
        r0.put(f7869a);
        a(r0, 1);
        a(r0, r2);
        a(r0, 1);
        a(r0, 32);
        r0.put(r4);
        return r0.array();
    }

    public static byte[] a(int r2, byte[] r3, byte[] r4) {
        if (r4 != null) goto L4;
        r4 = new byte[0];
    L4:
        if (r3 == null) goto L16;
        if (r3.length != 12) goto L16;
        int r0 = r3.length;
        if (r0 < 0) goto L14;
        if (r0 > 65535) goto L14;
        ByteBuffer r1 = ByteBuffer.allocate(((r3.length + 14) + 4) + r4.length).order(ByteOrder.BIG_ENDIAN);
        r1.put(f7869a);
        a(r1, 1);
        a(r1, r2);
        a(r1, 1);
        a(r1, 32);
        a(r1, r3.length);
        r1.put(r3);
        r1.putInt(r4.length);
        r1.put(r4);
        return r1.array();
    L14:
        throw new IllegalArgumentException("u16 overflow");
    L16:
        throw new IllegalArgumentException("invalid iv length");
    }

    public static void a(ByteBuffer r1, int r2) {
        if (r2 < 0) goto L8;
        if (r2 > 65535) goto L8;
        r1.putShort((short) (r2 & SupportMenu.USER_MASK));
        return;
    L8:
        throw new IllegalArgumentException("u16 overflow");
    }
}
