package com.fasterxml.jackson.databind.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: compiled from: UUIDDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class al extends o<UUID> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[] f12401a = null;

    @Override // com.fasterxml.jackson.databind.b.b.o
    public /* synthetic */ UUID a(Object r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.b.o
    public /* synthetic */ UUID a(String r1, com.fasterxml.jackson.databind.h r2) {
        return c(r1, r2);
    }

    static {
        int[] r0 = new int[127];
        f12401a = r0;
        Arrays.fill(r0, -1);
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= 10) goto L7;
        f12401a[r2 + 48] = r2;
        r2 = r2 + 1;
    L7:
        if (r1 >= 6) goto L9;
        int[] r3 = f12401a;
        int r4 = r1 + 10;
        r3[r1 + 97] = r4;
        r3[r1 + 65] = r4;
        r1 = r1 + 1;
        goto L7
    }

    public al() {
        super(UUID.class);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r3) {
        return new UUID(0, 0);
    }

    public UUID c(String r10, com.fasterxml.jackson.databind.h r11) {
        if (r10.length() == 36) goto L11;
        if (r10.length() != 24) goto L9;
        return a(com.fasterxml.jackson.a.b.a().a(r10), r11);
    L9:
        return d(r10, r11);
    L11:
        if (r10.charAt(8) == '-') goto L13;
    L18:
        d(r10, r11);
    L19:
        long r2 = (((long) a(r10, 0, r11)) << 32) + ((((long) b(r10, 9, r11)) << 16) | ((long) b(r10, 14, r11)));
        int r4 = b(r10, 19, r11) << 16;
        long r5 = ((long) (b(r10, 24, r11) | r4)) << 32;
        return new UUID(r2, ((((long) a(r10, 28, r11)) << 32) >>> 32) | r5);
    L13:
        if (r10.charAt(13) != '-') goto L18;
        if (r10.charAt(18) != '-') goto L18;
        if (r10.charAt(23) == '-') goto L19;
        goto L18
    }

    public UUID b(Object r4, com.fasterxml.jackson.databind.h r5) {
        if ((r4 instanceof byte[]) == false) goto L7;
        return a((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin"), r5);
    L7:
        return (UUID) ZeusTransformUtils.preCheckCast(super.a(r4, r5), UUID.class, "com.obric.aiagent.plugin");
    }

    private UUID d(String r3, com.fasterxml.jackson.databind.h r4) {
        return (UUID) ZeusTransformUtils.preCheckCast(r4.b(a(), r3, "UUID has to be represented by standard 36-char representation", new Object[0]), UUID.class, "com.obric.aiagent.plugin");
    }

    int a(String r3, int r4, com.fasterxml.jackson.databind.h r5) {
        return (((c(r3, r4, r5) << 24) + (c(r3, r4 + 2, r5) << 16)) + (c(r3, r4 + 4, r5) << 8)) + c(r3, r4 + 6, r5);
    }

    int b(String r2, int r3, com.fasterxml.jackson.databind.h r4) {
        return (c(r2, r3, r4) << 8) + c(r2, r3 + 2, r4);
    }

    int c(String r7, int r8, com.fasterxml.jackson.databind.h r9) {
        char r0 = r7.charAt(r8);
        int r1 = r8 + 1;
        char r2 = r7.charAt(r1);
        if (r0 > 127) goto L8;
        if (r2 > 127) goto L8;
        int[] r4 = f12401a;
        int r5 = r4[r0] << 4;
        int r6 = r4[r2] | r5;
        if (r6 < 0) goto L8;
        return r6;
    L8:
        if (r0 > 127) goto L15;
        if (f12401a[r0] < 0) goto L15;
        return a(r7, r1, r9, r2);
    L15:
        return a(r7, r8, r9, r0);
    }

    int a(String r3, int r4, com.fasterxml.jackson.databind.h r5, char r6) {
        throw r5.a(r3, a(), String.format("Non-hex character '%c' (value 0x%s), not valid for UUID String", new Object[]{Character.valueOf(r6), Integer.toHexString(r6)}));
    }

    private UUID a(byte[] r3, com.fasterxml.jackson.databind.h r4) {
        if (r3.length != 16) goto L7;
        return new UUID(a(r3, 0), a(r3, 8));
    L7:
        throw com.fasterxml.jackson.databind.c.c.a(r4.j(), "Can only construct UUIDs from byte[16]; got " + r3.length + " bytes", r3, a());
    }

    private static long a(byte[] r3, int r4) {
        long r0 = ((long) b(r3, r4)) << 32;
        return ((((long) b(r3, r4 + 4)) << 32) >>> 32) | r0;
    }

    private static int b(byte[] r2, int r3) {
        int r0 = ((r2[r3] << 24) | ((r2[r3 + 1] & 255) << 16)) | ((r2[r3 + 2] & 255) << 8);
        return (r2[r3 + 3] & 255) | r0;
    }
}
