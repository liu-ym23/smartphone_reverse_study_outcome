package com.bytedance.safetyguard.lxc.internal.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: ProxyTlv.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9857a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f9860d;

    /* JADX INFO: compiled from: ProxyTlv.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static /* synthetic */ n a(a r0, int r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = 1;
        L6:
            return r0.a(r1, r2, r3);
        }

        public final n a(int r3, int r4, int r5) {
            boolean r2 = false;
            if (r4 >= 0) goto L5;
        L7:
            if (r2 == false) goto L11;
            byte[] r6 = ByteBuffer.allocate(2).order(ByteOrder.BIG_ENDIAN).putShort((short) r4).array();
            d.h.b.o.c(r6, "array(...)");
            return new n(r3, r5, r6);
        L11:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            if (r4 >= 65536) goto L7;
            r2 = true;
            goto L7
        }

        public static /* synthetic */ n b(a r0, int r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = 1;
        L6:
            return r0.b(r1, r2, r3);
        }

        public final n b(int r3, int r4, int r5) {
            if (r4 < 0) goto L4;
            boolean r2 = true;
        L5:
            if (r2 == false) goto L9;
            byte[] r6 = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(r4).array();
            d.h.b.o.c(r6, "array(...)");
            return new n(r3, r5, r6);
        L9:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L4:
            r2 = false;
            goto L5
        }

        public static /* synthetic */ n a(a r0, int r1, long r2, int r4, int r5, Object r6) {
            if ((r5 & 4) == 0) goto L6;
            r4 = 1;
        L6:
            return r0.a(r1, r2, r4);
        }

        public final n a(int r3, long r4, int r6) {
            if (r4 < 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L10;
            byte[] r5 = ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN).putLong(r4).array();
            d.h.b.o.c(r5, "array(...)");
            return new n(r3, r6, r5);
        L10:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r2 = false;
            goto L6
        }

        public static /* synthetic */ n a(a r0, int r1, String r2, int r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = 1;
        L6:
            return r0.a(r1, r2, r3);
        }

        public final n a(int r3, String r4, int r5) {
            d.h.b.o.e(r4, "value");
            Charset r0 = StandardCharsets.UTF_8;
            d.h.b.o.c(r0, "UTF_8");
            byte[] r6 = r4.getBytes(r0);
            d.h.b.o.c(r6, "getBytes(...)");
            return new n(r3, r5, r6);
        }
    }

    static {
        f9857a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == true) goto L8;
        return false;
    L8:
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
        if (this.f9858b == r6.f9858b) goto L12;
        return false;
    L12:
        if (this.f9859c == r6.f9859c) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f9860d, r6.f9860d) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f9858b) * 31) + Integer.hashCode(this.f9859c)) * 31) + Arrays.hashCode(this.f9860d);
    }

    public String toString() {
        return "ProxyTlv(type=" + this.f9858b + ", flags=" + this.f9859c + ", value=" + Arrays.toString(this.f9860d) + ')';
    }

    public n(int r2, int r3, byte[] r4) {
        d.h.b.o.e(r4, "value");
        this.f9858b = r2;
        this.f9859c = r3;
        this.f9860d = r4;
    }

    public final int getType() {
        return this.f9858b;
    }

    public final int a() {
        return this.f9859c;
    }

    public final byte[] b() {
        return this.f9860d;
    }
}
