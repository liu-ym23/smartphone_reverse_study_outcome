package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: UUIDSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class aq extends ai<UUID> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f12886a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Boolean f12887b;

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((UUID) ZeusTransformUtils.preCheckCast(r3, UUID.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
        return a(r3, (UUID) ZeusTransformUtils.preCheckCast(r4, UUID.class, "com.obric.aiagent.plugin"));
    }

    static {
        f12886a = "0123456789abcdef".toCharArray();
    }

    public aq() {
        this(null);
    }

    public aq(Boolean r2) {
        super(UUID.class);
        this.f12887b = r2;
    }

    public boolean a(com.fasterxml.jackson.databind.ac r3, UUID r4) {
        if (r4.getLeastSignificantBits() == 0) goto L5;
        return false;
    L5:
        if (r4.getMostSignificantBits() != 0) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.d r4) {
        JsonFormat.Value r5 = a(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), a());
        if (r5 == null) goto L10;
        JsonFormat.Shape r6 = r5.getShape();
        if (r6 != JsonFormat.Shape.BINARY) goto L8;
        Boolean r7 = true;
    L12:
        if (Objects.equals(r7, this.f12887b) == false) goto L14;
        return this;
    L14:
        return new aq(r7);
    L8:
        if (r6 != JsonFormat.Shape.STRING) goto L10;
        r7 = false;
    L10:
        r7 = null;
        goto L12
    }

    public void a(UUID r9, com.fasterxml.jackson.a.h r10, com.fasterxml.jackson.databind.ac r11) {
        if (a(r10) == false) goto L6;
        r10.a(a(r9));
        return;
    L6:
        char[] r12 = new char[36];
        long r0 = r9.getMostSignificantBits();
        a((int) (r0 >> 32), r12, 0);
        r12[8] = '-';
        int r1 = (int) r0;
        b(r1 >>> 16, r12, 9);
        r12[13] = '-';
        b(r1, r12, 14);
        r12[18] = '-';
        long r2 = r9.getLeastSignificantBits();
        b((int) (r2 >>> 48), r12, 19);
        r12[23] = '-';
        b((int) (r2 >>> 32), r12, 24);
        a((int) r2, r12, 28);
        r10.a(r12, 0, 36);
    }

    public boolean a(com.fasterxml.jackson.a.h r1) {
        Boolean r0 = this.f12887b;
        if (r0 == null) goto L7;
        return r0.booleanValue();
    L7:
        if (ZeusTransformUtils.instanceOf(r1, com.fasterxml.jackson.databind.l.y.class) == false) goto L9;
    L11:
        return false;
    L9:
        if (r1.f() == false) goto L11;
        return true;
    }

    private static void a(int r1, char[] r2, int r3) {
        b(r1 >> 16, r2, r3);
        b(r1, r2, r3 + 4);
    }

    private static void b(int r2, char[] r3, int r4) {
        char[] r0 = f12886a;
        r3[r4] = r0[(r2 >> 12) & 15];
        int r5 = r4 + 1;
        r3[r5] = r0[(r2 >> 8) & 15];
        int r6 = r5 + 1;
        r3[r6] = r0[(r2 >> 4) & 15];
        r3[r6 + 1] = r0[r2 & 15];
    }

    private static final byte[] a(UUID r7) {
        byte[] r0 = new byte[16];
        long r1 = r7.getMostSignificantBits();
        long r3 = r7.getLeastSignificantBits();
        a((int) (r1 >> 32), r0, 0);
        a((int) r1, r0, 4);
        a((int) (r3 >> 32), r0, 8);
        a((int) r3, r0, 12);
        return r0;
    }

    private static final void a(int r1, byte[] r2, int r3) {
        r2[r3] = (byte) (r1 >> 24);
        int r4 = r3 + 1;
        r2[r4] = (byte) (r1 >> 16);
        int r5 = r4 + 1;
        r2[r5] = (byte) (r1 >> 8);
        r2[r5 + 1] = (byte) r1;
    }
}
