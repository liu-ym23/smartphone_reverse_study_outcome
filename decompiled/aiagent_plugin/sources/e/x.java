package e;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: compiled from: SegmentedByteString.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class x extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient byte[][] f38765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient int[] f38766d;

    public final byte[][] o() {
        return this.f38765c;
    }

    public final int[] p() {
        return this.f38766d;
    }

    public x(byte[][] r2, int[] r3) {
        d.h.b.o.e(r2, DBDefinition.SEGMENT_TABLE_NAME);
        d.h.b.o.e(r3, "directory");
        super(h.f38723b.a());
        this.f38765c = r2;
        this.f38766d = r3;
    }

    @Override // e.h
    public String e() {
        return q().e();
    }

    @Override // e.h
    public String i() {
        return q().i();
    }

    @Override // e.h
    public h j() {
        return q().j();
    }

    @Override // e.h
    public h b(String r7) {
        d.h.b.o.e(r7, "algorithm");
        MessageDigest r8 = MessageDigest.getInstance(r7);
        int r0 = ((Object[]) ZeusTransformUtils.preCheckCast(o(), Object[].class, "com.obric.aiagent.plugin")).length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r3 = p()[r0 + r1];
        int r4 = p()[r1];
        r8.update(o()[r1], r3, r4 - r2);
        r1 = r1 + 1;
        r2 = r4;
        goto L3
    L5:
        byte[] r6 = r8.digest();
        d.h.b.o.a(r6);
        return new h(r6);
    }

    private final h q() {
        return new h(m());
    }

    @Override // e.h
    public byte[] n() {
        return m();
    }

    @Override // e.h
    public String toString() {
        return q().toString();
    }

    @Override // e.h
    public byte b(int r11) {
        b.a(p()[((Object[]) ZeusTransformUtils.preCheckCast(o(), Object[].class, "com.obric.aiagent.plugin")).length - 1], r11, 1);
        int r0 = e.a.c.a(this, r11);
        if (r0 != 0) goto L5;
        int r1 = 0;
    L7:
        return o()[r0][(r11 - r1) + p()[((Object[]) ZeusTransformUtils.preCheckCast(o(), Object[].class, "com.obric.aiagent.plugin")).length + r0]];
    L5:
        r1 = p()[r0 - 1];
        goto L7
    }

    @Override // e.h
    public int l() {
        return p()[((Object[]) ZeusTransformUtils.preCheckCast(o(), Object[].class, "com.obric.aiagent.plugin")).length - 1];
    }

    @Override // e.h
    public byte[] m() {
        byte[] r0 = new byte[k()];
        int r1 = ((Object[]) ZeusTransformUtils.preCheckCast(o(), Object[].class, "com.obric.aiagent.plugin")).length;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int r5 = p()[r1 + r2];
        int r6 = p()[r2];
        int r7 = r6 - r3;
        d.a.i.a(o()[r2], r0, r4, r5, r5 + r7);
        r4 = r4 + r7;
        r2 = r2 + 1;
        r3 = r6;
        goto L3
    L5:
        return r0;
    }

    @Override // e.h
    public void a(e r12, int r13, int r14) {
        d.h.b.o.e(r12, "buffer");
        int r0 = r13 + r14;
        int r1 = e.a.c.a(this, r13);
    L3:
        if (r13 >= r0) goto L12;
        if (r1 != 0) goto L6;
        int r2 = 0;
    L7:
        int r3 = p()[r1] - r2;
        int r4 = p()[((Object[]) ZeusTransformUtils.preCheckCast(o(), Object[].class, "com.obric.aiagent.plugin")).length + r1];
        int r5 = Math.min(r0, r3 + r2) - r13;
        int r7 = r4 + (r13 - r2);
        v r6 = new v(o()[r1], r7, r7 + r5, true, false);
        if (r12.f38713a != null) goto L10;
        r6.h = r6;
        r6.g = r6.h;
        r12.f38713a = r6.g;
    L11:
        r13 = r13 + r5;
        r1 = r1 + 1;
        goto L3
    L10:
        v r8 = r12.f38713a;
        d.h.b.o.a(r8);
        v r9 = r8.h;
        d.h.b.o.a(r9);
        r9.a(r6);
        goto L11
    L6:
        r2 = p()[r1 - 1];
        goto L7
    L12:
        r12.a(r12.b() + ((long) r14));
    }

    @Override // e.h
    public boolean a(int r9, h r10, int r11, int r12) {
        d.h.b.o.e(r10, "other");
        if (r9 >= 0) goto L5;
        return false;
    L5:
        if (r9 > (k() - r12)) goto L21;
        int r13 = r12 + r9;
        int r1 = e.a.c.a(this, r9);
    L8:
        if (r9 >= r13) goto L16;
        if (r1 != 0) goto L11;
        int r2 = 0;
    L12:
        int r3 = p()[r1] - r2;
        int r4 = p()[((Object[]) ZeusTransformUtils.preCheckCast(o(), Object[].class, "com.obric.aiagent.plugin")).length + r1];
        int r5 = Math.min(r13, r3 + r2) - r9;
        if (r10.a(r11, o()[r1], r4 + (r9 - r2), r5) == false) goto L22;
        r11 = r11 + r5;
        r9 = r9 + r5;
        r1 = r1 + 1;
        goto L8
    L22:
        return false;
    L11:
        r2 = p()[r1 - 1];
        goto L12
    L16:
        return true;
    L21:
        return false;
    }

    @Override // e.h
    public boolean a(int r9, byte[] r10, int r11, int r12) {
        d.h.b.o.e(r10, "other");
        if (r9 >= 0) goto L5;
        return false;
    L5:
        if (r9 > (k() - r12)) goto L24;
        if (r11 >= 0) goto L8;
        return false;
    L8:
        if (r11 > (r10.length - r12)) goto L26;
        int r13 = r12 + r9;
        int r1 = e.a.c.a(this, r9);
    L11:
        if (r9 >= r13) goto L19;
        if (r1 != 0) goto L14;
        int r2 = 0;
    L15:
        int r3 = p()[r1] - r2;
        int r4 = p()[((Object[]) ZeusTransformUtils.preCheckCast(o(), Object[].class, "com.obric.aiagent.plugin")).length + r1];
        int r5 = Math.min(r13, r3 + r2) - r9;
        if (b.a(o()[r1], r4 + (r9 - r2), r10, r11, r5) == false) goto L27;
        r11 = r11 + r5;
        r9 = r9 + r5;
        r1 = r1 + 1;
        goto L11
    L27:
        return false;
    L14:
        r2 = p()[r1 - 1];
        goto L15
    L19:
        return true;
    L26:
        return false;
    L24:
        return false;
    }

    @Override // e.h
    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, h.class) == false) goto L13;
        if (((h) ZeusTransformUtils.preCheckCast(r6, h.class, "com.obric.aiagent.plugin")).k() != k()) goto L13;
        if (a(0, (h) ZeusTransformUtils.preCheckCast(r6, h.class, "com.obric.aiagent.plugin"), 0, k()) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // e.h
    public int hashCode() {
        int r0 = b();
        if (r0 != 0) goto L15;
        int r1 = ((Object[]) ZeusTransformUtils.preCheckCast(o(), Object[].class, "com.obric.aiagent.plugin")).length;
        int r2 = 0;
        int r3 = 1;
        int r4 = 0;
    L6:
        if (r2 >= r1) goto L11;
        int r5 = p()[r1 + r2];
        int r6 = p()[r2];
        byte[] r7 = o()[r2];
        int r8 = (r6 - r4) + r5;
    L8:
        if (r5 >= r8) goto L10;
        r3 = (r3 * 31) + r7[r5];
        r5 = r5 + 1;
        goto L8
    L10:
        r2 = r2 + 1;
        r4 = r6;
        goto L6
    L11:
        a(r3);
        return r3;
    L15:
        return r0;
    }
}
