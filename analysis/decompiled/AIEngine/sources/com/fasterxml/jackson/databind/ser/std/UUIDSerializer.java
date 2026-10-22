package com.fasterxml.jackson.databind.ser.std;

import b3.h;
import java.util.UUID;
import n3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class UUIDSerializer extends StdScalarSerializer<UUID> implements c {

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f4419d = "0123456789abcdef".toCharArray();

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f4420c;

    public UUIDSerializer() {
        this(null);
    }

    public static final void o(byte[] bArr, int i10, int i11) {
        bArr[i11] = (byte) (i10 >> 24);
        bArr[i11 + 1] = (byte) (i10 >> 16);
        bArr[i11 + 2] = (byte) (i10 >> 8);
        bArr[i11 + 3] = (byte) i10;
    }

    public static void p(char[] cArr, int i10, int i11) {
        char[] cArr2 = f4419d;
        cArr[i11] = cArr2[(i10 >> 12) & 15];
        cArr[i11 + 1] = cArr2[(i10 >> 8) & 15];
        cArr[i11 + 2] = cArr2[(i10 >> 4) & 15];
        cArr[i11 + 3] = cArr2[i10 & 15];
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    @Override // n3.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b3.f<?> a(b3.h r2, com.fasterxml.jackson.databind.BeanProperty r3) {
        /*
            r1 = this;
            java.lang.Class<T> r0 = r1.f4417a
            com.fasterxml.jackson.annotation.JsonFormat$Value r2 = com.fasterxml.jackson.databind.ser.std.StdSerializer.k(r2, r3, r0)
            if (r2 == 0) goto L18
            com.fasterxml.jackson.annotation.JsonFormat$Shape r2 = r2.f3451b
            com.fasterxml.jackson.annotation.JsonFormat$Shape r3 = com.fasterxml.jackson.annotation.JsonFormat.Shape.f3447m
            if (r2 != r3) goto L11
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            goto L19
        L11:
            com.fasterxml.jackson.annotation.JsonFormat$Shape r3 = com.fasterxml.jackson.annotation.JsonFormat.Shape.f3446l
            if (r2 != r3) goto L18
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            goto L19
        L18:
            r2 = 0
        L19:
            java.lang.Boolean r3 = r1.f4420c
            boolean r3 = java.util.Objects.equals(r2, r3)
            if (r3 != 0) goto L26
            com.fasterxml.jackson.databind.ser.std.UUIDSerializer r1 = new com.fasterxml.jackson.databind.ser.std.UUIDSerializer
            r1.<init>(r2)
        L26:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.UUIDSerializer.a(b3.h, com.fasterxml.jackson.databind.BeanProperty):b3.f");
    }

    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        UUID uuid = (UUID) obj;
        return uuid.getLeastSignificantBits() == 0 && uuid.getMostSignificantBits() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    @Override // b3.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.Object r11, com.fasterxml.jackson.core.JsonGenerator r12, b3.h r13) {
        /*
            r10 = this;
            java.util.UUID r11 = (java.util.UUID) r11
            r13 = 0
            java.lang.Boolean r10 = r10.f4420c
            if (r10 == 0) goto Lc
            boolean r10 = r10.booleanValue()
            goto L1a
        Lc:
            boolean r10 = r12 instanceof q3.p
            if (r10 != 0) goto L19
            r12.getClass()
            boolean r10 = r12 instanceof q3.p
            if (r10 == 0) goto L19
            r10 = 1
            goto L1a
        L19:
            r10 = r13
        L1a:
            r0 = 4
            r1 = 8
            r2 = 32
            if (r10 == 0) goto L4c
            r10 = 16
            byte[] r3 = new byte[r10]
            long r4 = r11.getMostSignificantBits()
            long r6 = r11.getLeastSignificantBits()
            long r8 = r4 >> r2
            int r11 = (int) r8
            o(r3, r11, r13)
            int r11 = (int) r4
            o(r3, r11, r0)
            long r4 = r6 >> r2
            int r11 = (int) r4
            o(r3, r11, r1)
            int r11 = (int) r6
            r0 = 12
            o(r3, r11, r0)
            r12.getClass()
            com.fasterxml.jackson.core.Base64Variant r11 = v2.a.f13372b
            r12.c0(r11, r3, r13, r10)
            return
        L4c:
            r10 = 36
            char[] r3 = new char[r10]
            long r4 = r11.getMostSignificantBits()
            long r6 = r4 >> r2
            int r6 = (int) r6
            int r7 = r6 >> 16
            p(r3, r7, r13)
            p(r3, r6, r0)
            r0 = 45
            r3[r1] = r0
            int r1 = (int) r4
            int r4 = r1 >>> 16
            r5 = 9
            p(r3, r4, r5)
            r4 = 13
            r3[r4] = r0
            r4 = 14
            p(r3, r1, r4)
            r1 = 18
            r3[r1] = r0
            long r4 = r11.getLeastSignificantBits()
            r11 = 48
            long r6 = r4 >>> r11
            int r11 = (int) r6
            r1 = 19
            p(r3, r11, r1)
            r11 = 23
            r3[r11] = r0
            long r0 = r4 >>> r2
            int r11 = (int) r0
            r0 = 24
            p(r3, r11, r0)
            int r11 = (int) r4
            int r0 = r11 >> 16
            r1 = 28
            p(r3, r0, r1)
            p(r3, r11, r2)
            r12.h1(r3, r13, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.UUIDSerializer.f(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, b3.h):void");
    }

    public UUIDSerializer(Boolean bool) {
        super(UUID.class);
        this.f4420c = bool;
    }
}
