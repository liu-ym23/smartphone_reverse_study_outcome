package com.obric.autogui.agents.a.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.al;
import d.a.i;
import d.h.b.o;
import d.l.n;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ActionEffectImageFingerprint.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26351a = null;

    /* JADX INFO: renamed from: com.obric.autogui.agents.a.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionEffectImageFingerprint.kt */
    private static final class C0663a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f26352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f26353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f26354c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0663a.class) == true) goto L8;
            return false;
        L8:
            C0663a r6 = (C0663a) ZeusTransformUtils.preCheckCast(r5, C0663a.class, "com.obric.aiagent.plugin");
            if (this.f26352a == r6.f26352a) goto L12;
            return false;
        L12:
            if (this.f26353b == r6.f26353b) goto L15;
            return false;
        L15:
            if (this.f26354c == r6.f26354c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f26352a) * 31) + Integer.hashCode(this.f26353b)) * 31) + Integer.hashCode(this.f26354c);
        }

        public String toString() {
            return "TargetRegion(centerX=" + this.f26352a + ", centerY=" + this.f26353b + ", radiusSquared=" + this.f26354c + ')';
        }

        public C0663a(int r1, int r2, int r3) {
            this.f26352a = r1;
            this.f26353b = r2;
            this.f26354c = r3;
        }

        public final boolean a(int r2, int r3) {
            int r4 = r2 - this.f26352a;
            int r5 = r3 - this.f26353b;
            if (((r4 * r4) + (r5 * r5)) > this.f26354c) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        f26351a = new a();
    }

    private a() {
    }

    public static /* synthetic */ b a(a r6, c r7, c r8, int r9, e r10, int r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        e r4 = r10;
        if ((r12 & 16) == 0) goto L9;
        r11 = 0;
    L9:
        return r6.a(r7, r8, r9, r4, r11);
    }

    public final b a(c r21, c r22, int r23, e r24, int r25) {
        o.e(r21, "before");
        o.e(r22, "after");
        int r7 = Long.bitCount(r21.a() ^ r22.a());
        if (a(r21, r22) == false) goto L5;
        int r1 = 0;
        int r5 = n.a(r23, 0, 255);
        C0663a r6 = a(r24, r21.b(), r21.c(), r25);
        int[] r9 = new int[32];
        int[] r8 = new int[32];
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(i.b(r21.d()), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r11 = 0;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L8:
        if (r10.hasNext() == false) goto L27;
        int r4 = ((al) ZeusTransformUtils.preCheckCast(r10, al.class, "com.obric.aiagent.plugin")).a();
        int r2 = r4 % r21.b();
        int r3 = r4 / r21.b();
        int r18 = (((r3 * 8) / r21.c()) * 4) + ((r2 * 4) / r21.b());
        Iterator r26 = r10;
        r8[r18] = r8[r18] + 1;
        if (r6 != null) goto L12;
    L14:
        boolean r12 = false;
    L15:
        if (r12 == false) goto L17;
        r13 = r13 + 1;
    L20:
        if (Math.abs((r21.d()[r4] & 255) - (r22.d()[r4] & 255)) <= r5) goto L26;
        r11 = r11 + 1;
        r9[r18] = r9[r18] + 1;
        if (r12 == false) goto L24;
        r14 = r14 + 1;
        goto L26
    L24:
        if (r6 == null) goto L26;
        r1 = r1 + 1;
    L26:
        r10 = r26;
        goto L8
    L17:
        if (r6 == null) goto L20;
        r15 = r15 + 1;
        goto L20
    L12:
        if (r6.a(r2, r3) != true) goto L14;
        r12 = true;
        goto L15
    L27:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(i.d(r9), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r16.hasNext() == false) goto L44;
        int r17 = ((al) ZeusTransformUtils.preCheckCast(r16, al.class, "com.obric.aiagent.plugin")).a();
        int r19 = f26351a.a(r9[r17], r8[r17]);
    L31:
        if (r16.hasNext() == false) goto L36;
        int r20 = ((al) ZeusTransformUtils.preCheckCast(r16, al.class, "com.obric.aiagent.plugin")).a();
        int r27 = f26351a.a(r9[r20], r8[r20]);
        if (r19 >= r27) goto L31;
        r19 = r27;
        goto L31
    L36:
        int r110 = a(r11, r21.d().length);
        if (r6 == null) goto L40;
        if (r13 <= 0) goto L40;
        boolean r111 = true;
    L42:
        return new b(r7, true, r11, r110, r19, r111, r13, r14, a(r14, r13), a(r1, r15));
    L40:
        r111 = false;
        goto L42
    L44:
        throw new NoSuchElementException();
    L5:
        return new b(r7, false, 0, 0, 0, false, 0, 0, 0, 0);
    }

    private final C0663a a(e r11, int r12, int r13, int r14) {
        if (r11 == null) goto L9;
        if (r12 <= 0) goto L11;
        if (r13 <= 0) goto L12;
        if (r14 <= 0) goto L13;
        long r6 = 1000;
        int r10 = (int) (((((long) n.a(r11.a(), 0, 1000)) * ((long) (r12 - 1))) + 500) / r6);
        int r15 = (int) (((((long) n.a(r11.b(), 0, 1000)) * ((long) (r13 - 1))) + 500) / r6);
        int r16 = n.c((int) ((((((long) Math.min(r12, r13)) * ((long) n.a(r14, 1, 1000))) + r6) - 1) / r6), 1);
        return new C0663a(r10, r15, r16 * r16);
    L13:
        return null;
    L12:
        return null;
    L11:
        return null;
    L9:
        return null;
    }

    private final boolean a(c r2, c r3) {
        if (r2.b() > 0) goto L5;
    L15:
        return false;
    L5:
        if (r2.c() <= 0) goto L15;
        if (r2.b() != r3.b()) goto L15;
        if (r2.c() != r3.c()) goto L15;
        if (r2.d().length != (r2.b() * r2.c())) goto L15;
        if (r3.d().length != (r3.b() * r3.c())) goto L15;
        return true;
    }

    private final int a(int r3, int r4) {
        if (r3 <= 0) goto L7;
        if (r4 > 0) goto L6;
        return 0;
    L6:
        return (int) ((((long) r3) * ((long) 1000)) / ((long) r4));
    L7:
        return 0;
    }
}
