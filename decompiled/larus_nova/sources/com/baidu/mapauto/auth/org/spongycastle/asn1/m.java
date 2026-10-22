package com.baidu.mapauto.auth.org.spongycastle.asn1;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes39.dex */
public final class m extends r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f31853c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f31854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f31855b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f31857b;

        public a(byte[] r100) {
            this.f31856a = com.baidu.mapauto.auth.org.spongycastle.util.a.b(r100);
            this.f31857b = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof a) == true) goto L5;
            return false;
        L5:
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f31857b, ((a) r100).f31857b);
        }

        public final int hashCode() {
            return this.f31856a;
        }
    }

    static {
        f31853c = new ConcurrentHashMap();
    }

    public m(byte[] r210) {
        StringBuffer r100 = new StringBuffer();
        boolean r101 = true;
        BigInteger r110 = null;
        int r102 = 0;
        long r103 = 0;
    L4:
        if (r102 == r210.length) goto L30;
        int r111 = r210[r102] & UByte.MAX_VALUE;
        if (r103 > 72057594037927808L) goto L21;
        long r104 = r103 + ((long) (r111 & 127));
        if ((r111 & 128) != 0) goto L20;
        if (r101 == true) goto L11;
    L18:
        r100.append('.');
        r100.append(r104);
    L19:
        r103 = 0;
    L29:
        r102 = r102 + 1;
        goto L4
    L11:
        if (r104 >= 40) goto L14;
        r100.append('0');
    L17:
        r101 = false;
        goto L18
    L14:
        if (r104 >= 80) goto L16;
        r100.append('1');
        r104 = r104 - 40;
        goto L17
    L16:
        r100.append('2');
        r104 = r104 - 80;
        goto L17
    L20:
        r103 = r104 << 7;
        goto L29
    L21:
        if (r110 != null) goto L23;
        r110 = BigInteger.valueOf(r103);
    L23:
        BigInteger r112 = r110.or(BigInteger.valueOf(r111 & 127));
        if ((r111 & 128) != 0) goto L28;
        if (r101 == false) goto L27;
        r100.append('2');
        r112 = r112.subtract(BigInteger.valueOf(80));
        r101 = false;
    L27:
        r100.append('.');
        r100.append(r112);
        r110 = null;
        goto L19
    L28:
        r110 = r112.shiftLeft(7);
        goto L29
    L30:
        this.f31854a = r100.toString();
        this.f31855b = com.baidu.mapauto.auth.org.spongycastle.util.a.a(r210);
    }

    public static void a(ByteArrayOutputStream r100, BigInteger r101) {
        int r102 = (r101.bitLength() + 6) / 7;
        if (r102 != 0) goto L5;
        r100.write(0);
        return;
    L5:
        byte[] r103 = new byte[r102];
        int r104 = r102 - 1;
        int r105 = r104;
    L6:
        if (r105 < 0) goto L8;
        r103[r105] = (byte) ((r101.intValue() & 127) | 128);
        r101 = r101.shiftRight(7);
        r105 = r105 - 1;
        goto L6
    L8:
        r103[r104] = (byte) (r103[r104] & ByteCompanionObject.MAX_VALUE);
        r100.write(r103, 0, r102);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L10;
        return false;
    L10:
        return this.f31854a.equals(((m) r100).f31854a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        int r100 = i().length;
        return (u1.a(r100) + 1) + r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return this.f31854a.hashCode();
    }

    public final synchronized byte[] i() {
        monitor-enter(this);
    L49:
        th = move-exception;
        throw th;
    L5:
        if (this.f31855b != null) goto L46;
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();     // Catch: Throwable -> L49
        String r101 = this.f31854a;     // Catch: Throwable -> L49
        int r102 = r101.indexOf(46, 0);     // Catch: Throwable -> L49
        if (r102 != (-1)) goto L9;
        String r103 = r101.substring(0);     // Catch: Throwable -> L49
        int r104 = -1;
    L10:
        int r105 = CastIntegerProtector.parseInt(r103) * 40;     // Catch: Throwable -> L49
        if (r104 != (-1)) goto L13;
        int r110 = r104;
        String r106 = null;
    L17:
        int r107 = 18;
        if (r106.length() > 18) goto L24;
        long r108 = CastLongProtector.parseLong(r106) + ((long) r105);     // Catch: Throwable -> L49
        byte[] r109 = new byte[9];     // Catch: Throwable -> L49
        r109[8] = (byte) (((int) r108) & 127);     // Catch: Throwable -> L49
        int r111 = 8;
    L21:
        if (r108 < 128) goto L23;
        r108 = r108 >> 7;     // Catch: Throwable -> L49
        r111 = r111 - 1;     // Catch: Throwable -> L49
        r109[r111] = (byte) ((((int) r108) & 127) | 128);     // Catch: Throwable -> L49
        goto L21
    L23:
        r100.write(r109, r111, 9 - r111);     // Catch: Throwable -> L49
    L25:
        int r112 = r110;
    L26:
        if (r112 == (-1)) goto L28;
        boolean r113 = true;
    L29:
        if (r113 == false) goto L45;
        if (r112 != (-1)) goto L32;
        String r114 = null;
    L37:
        if (r114.length() > r107) goto L43;
        long r115 = CastLongProtector.parseLong(r114);     // Catch: Throwable -> L49
        byte[] r116 = new byte[9];     // Catch: Throwable -> L49
        r116[8] = (byte) (((int) r115) & 127);     // Catch: Throwable -> L49
        int r117 = 8;
    L40:
        if (r115 < 128) goto L42;
        r115 = r115 >> 7;     // Catch: Throwable -> L49
        r117 = r117 - 1;     // Catch: Throwable -> L49
        r116[r117] = (byte) ((((int) r115) & 127) | 128);     // Catch: Throwable -> L49
        goto L40
    L42:
        r100.write(r116, r117, 9 - r117);     // Catch: Throwable -> L49
    L44:
        r107 = 18;
        goto L26
    L43:
        a(r100, new BigInteger(r114));     // Catch: Throwable -> L49
        goto L44
    L32:
        int r118 = r101.indexOf(46, r112);     // Catch: Throwable -> L49
        if (r118 != (-1)) goto L35;
        r114 = r101.substring(r112);     // Catch: Throwable -> L49
        r112 = -1;
        goto L37
    L35:
        String r119 = r101.substring(r112, r118);     // Catch: Throwable -> L49
        r112 = r118 + 1;     // Catch: Throwable -> L49
        r114 = r119;
        goto L37
    L45:
        this.f31855b = r100.toByteArray();     // Catch: Throwable -> L49
        goto L46
    L28:
        r113 = false;
        goto L29
    L24:
        a(r100, new BigInteger(r106).add(BigInteger.valueOf(r105)));     // Catch: Throwable -> L49
        goto L25
    L13:
        int r120 = r101.indexOf(46, r104);     // Catch: Throwable -> L49
        if (r120 != (-1)) goto L16;
        r106 = r101.substring(r104);     // Catch: Throwable -> L49
        r110 = -1;
        goto L17
    L16:
        r106 = r101.substring(r104, r120);     // Catch: Throwable -> L49
        r110 = r120 + 1;     // Catch: Throwable -> L49
        goto L17
    L9:
        r103 = r101.substring(0, r102);     // Catch: Throwable -> L49
        r104 = r102 + 1;     // Catch: Throwable -> L49
    L46:
        byte[] r121 = this.f31855b;     // Catch: Throwable -> L49
        monitor-exit(this);
        return r121;
    }

    public final String toString() {
        return this.f31854a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static m a(d r100) {
        if (r100 == 0) goto L21;
        if ((r100 instanceof m) == true) goto L21;
        if ((r100.c() instanceof m) == false) goto L11;
        return (m) r100.c();
    L11:
        if ((r100 instanceof byte[]) == true) goto L22;
        StringBuilder r101 = com.baidu.mapauto.auth.b.a("illegal object in getInstance: ");
        r101.append(r100.getClass().getName());
        throw new IllegalArgumentException(r101.toString());
    L22:
        return (m) r.a((byte[]) r100);
    L15:
        e = move-exception;
        StringBuilder r102 = com.baidu.mapauto.auth.b.a("failed to construct object identifier from byte[]: ");
        r102.append(e.getMessage());
        throw new IllegalArgumentException(r102.toString());
    L21:
        return (m) r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        byte[] r101 = i();
        r100.a(6);
        r100.b(r101.length);
        r100.f31869a.write(r101);
    }
}
