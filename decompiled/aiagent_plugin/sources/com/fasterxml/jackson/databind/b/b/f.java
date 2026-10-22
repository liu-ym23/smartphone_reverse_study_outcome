package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.databind.n;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: JsonNodeDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class f<T extends com.fasterxml.jackson.databind.n> extends ab<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Boolean f12409a;

    /* JADX INFO: compiled from: JsonNodeDeserializer.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.fasterxml.jackson.databind.i.f[] f12410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f12411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f12412c;

        public a() {
        }

        public void a(com.fasterxml.jackson.databind.i.f r5) {
            int r0 = this.f12411b;
            int r1 = this.f12412c;
            if (r0 >= r1) goto L7;
            com.fasterxml.jackson.databind.i.f[] r2 = this.f12410a;
            this.f12411b = r0 + 1;
            r2[r0] = r5;
            return;
        L7:
            if (this.f12410a != null) goto L9;
            this.f12412c = 10;
            this.f12410a = new com.fasterxml.jackson.databind.i.f[10];
        L10:
            com.fasterxml.jackson.databind.i.f[] r3 = this.f12410a;
            int r4 = this.f12411b;
            this.f12411b = r4 + 1;
            r3[r4] = r5;
            return;
        L9:
            int r6 = r1 + Math.min(DownloadErrorCode.ERROR_CRONET_HTTP_ERROR_END, Math.max(20, r1 >> 1));
            this.f12412c = r6;
            this.f12410a = (com.fasterxml.jackson.databind.i.f[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(this.f12410a, r6), com.fasterxml.jackson.databind.i.f[].class, "com.obric.aiagent.plugin");
            goto L10
        }

        public com.fasterxml.jackson.databind.i.f a() {
            int r0 = this.f12411b;
            if (r0 != 0) goto L6;
            return null;
        L6:
            com.fasterxml.jackson.databind.i.f[] r1 = this.f12410a;
            int r2 = r0 - 1;
            this.f12411b = r2;
            return r1[r2];
        }
    }

    @Override // com.fasterxml.jackson.databind.l
    public boolean c() {
        return true;
    }

    public f(Class<T> r1, Boolean r2) {
        super(r1);
        this.f12409a = r2;
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return r3.d(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.f12971e;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return this.f12409a;
    }

    public void a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.i.l r4, String r5, com.fasterxml.jackson.databind.i.q r6, com.fasterxml.jackson.databind.n r7, com.fasterxml.jackson.databind.n r8) {
        if (r3.a(com.fasterxml.jackson.databind.i.i) == false) goto L6;
        r3.a(com.fasterxml.jackson.databind.n.class, "Duplicate field '%s' for `ObjectNode`: not allowed when `DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY` enabled", new Object[]{r5});
    L6:
        if (r3.a(com.fasterxml.jackson.a.r.f12158a) == true) goto L8;
        return;
    L8:
        if (r7.a() == false) goto L10;
        ((com.fasterxml.jackson.databind.i.a) ZeusTransformUtils.preCheckCast(r7, com.fasterxml.jackson.databind.i.a.class, "com.obric.aiagent.plugin")).a(r8);
        r6.b(r5, r7);
        return;
    L10:
        com.fasterxml.jackson.databind.i.a r1 = r4.b();
        r1.a(r7);
        r1.a(r8);
        r6.b(r5, r1);
    }

    public final com.fasterxml.jackson.databind.i.q a(com.fasterxml.jackson.a.k r16, com.fasterxml.jackson.databind.h r17, com.fasterxml.jackson.databind.i.l r18, a r19) {
        com.fasterxml.jackson.databind.i.q r8 = r18.c();
        String r4 = r16.w();
    L3:
        if (r4 == null) goto L18;
        com.fasterxml.jackson.a.n r0 = r16.g();
        if (r0 != null) goto L7;
        r0 = com.fasterxml.jackson.a.n.f12151a;
    L7:
        int r1 = r0.a();
        if (r1 != 1) goto L10;
        com.fasterxml.jackson.databind.n r2 = a(r16, r17, r18, r19, r18.c());
    L14:
        com.fasterxml.jackson.databind.n r7 = r2;
        com.fasterxml.jackson.databind.n r6 = r8.b(r4, r7);
        if (r6 == null) goto L17;
        a(r16, r17, r18, r4, r8, r6, r7);
    L17:
        r4 = r16.i();
        goto L3
    L10:
        if (r1 == 3) goto L12;
        r2 = b(r16, r17);
        goto L14
    L12:
        r2 = a(r16, r17, r18, r19, r18.b());
        goto L14
    L18:
        return r8;
    }

    public final com.fasterxml.jackson.databind.n a(com.fasterxml.jackson.a.k r10, com.fasterxml.jackson.databind.h r11, com.fasterxml.jackson.databind.i.q r12, a r13) {
        if (r10.r() == false) goto L6;
        String r0 = r10.i();
    L10:
        com.fasterxml.jackson.databind.i.l r8 = r11.l();
    L11:
        if (r0 == null) goto L47;
        com.fasterxml.jackson.a.n r2 = r10.g();
        com.fasterxml.jackson.databind.n r3 = r12.a(r0);
        if (r3 != null) goto L15;
    L26:
        if (r2 != null) goto L28;
        r2 = com.fasterxml.jackson.a.n.f12151a;
    L28:
        int r4 = r2.a();
        if (r4 != 1) goto L31;
        com.fasterxml.jackson.databind.n r5 = a(r10, r11, r8, r13, r8.c());
    L45:
        r12.a(r0, r5);
    L46:
        r0 = r10.i();
        goto L11
    L31:
        if (r4 != 3) goto L33;
        r5 = a(r10, r11, r8, r13, r8.b());
        goto L45
    L33:
        if (r4 != 6) goto L35;
        r5 = r8.a(r10.x());
        goto L45
    L35:
        if (r4 == 7) goto L41;
        switch(r4) {
            case 9: goto L40;
            case 10: goto L39;
            case 11: goto L38;
            default: goto L37;
        };
    L37:
        r5 = c(r10, r11);
        goto L45
    L38:
        r5 = r8.a();
        goto L45
    L39:
        r5 = r8.a(false);
        goto L45
    L40:
        r5 = r8.a(true);
        goto L45
    L41:
        r5 = a(r10, r11, r8);
        goto L45
    L15:
        if (ZeusTransformUtils.instanceOf(r3, com.fasterxml.jackson.databind.i.q.class) == false) goto L22;
        if (r2 != com.fasterxml.jackson.a.n.f12152b) goto L26;
        com.fasterxml.jackson.databind.n r6 = a(r10, r11, (com.fasterxml.jackson.databind.i.q) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.i.q.class, "com.obric.aiagent.plugin"), r13);
        if (r6 == r3) goto L46;
        r12.a(r0, r6);
        goto L46
    L22:
        if (ZeusTransformUtils.instanceOf(r3, com.fasterxml.jackson.databind.i.a.class) == false) goto L26;
        if (r2 != com.fasterxml.jackson.a.n.f12154d) goto L26;
        a(r10, r11, r8, r13, (com.fasterxml.jackson.databind.i.a) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.i.a.class, "com.obric.aiagent.plugin"));
        goto L46
    L47:
        return r12;
    L6:
        if (r10.a(com.fasterxml.jackson.a.n.f) == false) goto L8;
        r0 = r10.w();
        goto L10
    L8:
        return (com.fasterxml.jackson.databind.n) ZeusTransformUtils.preCheckCast(a(r10, r11), com.fasterxml.jackson.databind.n.class, "com.obric.aiagent.plugin");
    }

    public final com.fasterxml.jackson.databind.i.f<?> a(com.fasterxml.jackson.a.k r19, com.fasterxml.jackson.databind.h r20, com.fasterxml.jackson.databind.i.l r21, a r22, com.fasterxml.jackson.databind.i.f<?> r23) {
        int r12 = r20.i() & z;
        com.fasterxml.jackson.databind.i.f r0 = r23;
    L3:
        boolean r14 = true;
        if (ZeusTransformUtils.instanceOf(r0, com.fasterxml.jackson.databind.i.q.class) == false) goto L38;
        com.fasterxml.jackson.databind.i.q r1 = (com.fasterxml.jackson.databind.i.q) ZeusTransformUtils.preCheckCast(r0, com.fasterxml.jackson.databind.i.q.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.i.f r15 = r0;
        com.fasterxml.jackson.databind.i.q r7 = r1;
        String r4 = r19.i();
    L6:
        if (r4 == null) goto L51;
        com.fasterxml.jackson.a.n r2 = r19.g();
        if (r2 != null) goto L10;
        r2 = com.fasterxml.jackson.a.n.f12151a;
    L10:
        int r3 = r2.a();
        if (r3 != r14) goto L13;
        com.fasterxml.jackson.databind.i.q r16 = r7;
        com.fasterxml.jackson.databind.i.q r8 = r21.c();
        com.fasterxml.jackson.databind.n r6 = r16.b(r4, r8);
        if (r6 == null) goto L36;
        a(r19, r20, r21, r4, r16, r6, r8);
    L36:
        r22.a(r15);
        r7 = r8;
        r15 = r7;
    L37:
        r4 = r19.i();
        r14 = true;
        goto L6
    L13:
        if (r3 == 3) goto L28;
        switch(r3) {
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            default: goto L15;
        };
    L15:
        com.fasterxml.jackson.databind.n r5 = c(r19, r20);
    L16:
        com.fasterxml.jackson.databind.n r9 = r5;
        com.fasterxml.jackson.databind.n r17 = r7.b(r4, r9);
        if (r17 == null) goto L27;
        a(r19, r20, r21, r4, r7, r17, r9);
    L27:
        r7 = r7;
        goto L37
    L17:
        r5 = r21.a();
        goto L16
    L18:
        r5 = r21.a(false);
        goto L16
    L19:
        r5 = r21.a(r14);
        goto L16
    L20:
        r5 = b(r19, r20, r21);
        goto L16
    L21:
        r5 = a(r19, r12, r21);
        goto L16
    L22:
        r5 = r21.a(r19.x());
        goto L16
    L28:
        com.fasterxml.jackson.databind.i.q r18 = r7;
        com.fasterxml.jackson.databind.i.f r13 = r21.b();
        com.fasterxml.jackson.databind.n r10 = r18.b(r4, r13);
        if (r10 == null) goto L31;
        a(r19, r20, r21, r4, r18, r10, r13);
    L31:
        r22.a(r15);
        r0 = r13;
    L54:
        if (r0 != null) goto L3;
        return r23;
    L51:
        r0 = r22.a();
        goto L54
    L38:
        com.fasterxml.jackson.databind.i.a r11 = (com.fasterxml.jackson.databind.i.a) ZeusTransformUtils.preCheckCast(r0, com.fasterxml.jackson.databind.i.a.class, "com.obric.aiagent.plugin");
    L39:
        com.fasterxml.jackson.a.n r24 = r19.g();
        if (r24 != null) goto L43;
        r24 = com.fasterxml.jackson.a.n.f12151a;
    L43:
        switch(r24.a()) {
            case 1: goto L53;
            case 2: goto L44;
            case 3: goto L52;
            case 4: goto L51;
            case 5: goto L44;
            case 6: goto L50;
            case 7: goto L49;
            case 8: goto L48;
            case 9: goto L47;
            case 10: goto L46;
            case 11: goto L45;
            default: goto L44;
        };
    L45:
        r11.a(r21.a());
        goto L39
    L46:
        r11.a(r21.a(false));
        goto L39
    L47:
        r11.a(r21.a(true));
        goto L39
    L48:
        r11.a(b(r19, r20, r21));
        goto L39
    L49:
        r11.a(a(r19, r12, r21));
        goto L39
    L50:
        r11.a(r21.a(r19.x()));
        goto L39
    L52:
        r22.a(r0);
        r0 = r21.b();
        r11.a(r0);
        goto L54
    L53:
        r22.a(r0);
        r0 = r21.c();
        r11.a(r0);
        goto L54
    L44:
        r11.a(c(r19, r20));
        goto L39
    }

    public final com.fasterxml.jackson.databind.n b(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5) {
        com.fasterxml.jackson.databind.i.l r0 = r5.l();
        int r1 = r4.m();
        if (r1 == 2) goto L22;
        switch(r1) {
            case 6: goto L20;
            case 7: goto L18;
            case 8: goto L16;
            case 9: goto L14;
            case 10: goto L12;
            case 11: goto L10;
            case 12: goto L8;
            default: goto L6;
        };
    L6:
        return (com.fasterxml.jackson.databind.n) ZeusTransformUtils.preCheckCast(r5.a(a(), r4), com.fasterxml.jackson.databind.n.class, "com.obric.aiagent.plugin");
    L8:
        return d(r4, r5);
    L10:
        return r0.a();
    L12:
        return r0.a(false);
    L14:
        return r0.a(true);
    L16:
        return b(r4, r5, r0);
    L18:
        return a(r4, r5, r0);
    L20:
        return r0.a(r4.x());
    L22:
        return r0.c();
    }

    public final com.fasterxml.jackson.databind.n c(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
        int r0 = r3.m();
        if (r0 == 2) goto L15;
        if (r0 == 8) goto L13;
        if (r0 == 12) goto L11;
        return (com.fasterxml.jackson.databind.n) ZeusTransformUtils.preCheckCast(r4.a(a(), r3), com.fasterxml.jackson.databind.n.class, "com.obric.aiagent.plugin");
    L11:
        return d(r3, r4);
    L13:
        return b(r3, r4, r4.l());
    L15:
        return r4.l().c();
    }

    public final com.fasterxml.jackson.databind.n a(com.fasterxml.jackson.a.k r1, int r2, com.fasterxml.jackson.databind.i.l r3) {
        if (r2 != 0) goto L4;
        com.fasterxml.jackson.a.k.b r0 = r1.E();
        if (r0 != com.fasterxml.jackson.a.k.b.f12143a) goto L14;
        return r3.a(r1.H());
    L14:
        if (r0 != com.fasterxml.jackson.a.k.b.f12144b) goto L18;
        return r3.a(r1.I());
    L18:
        return r3.a(r1.J());
    L4:
        if (com.fasterxml.jackson.databind.i.f12755b.a(r2) == false) goto L8;
        return r3.a(r1.J());
    L8:
        return r3.a(r1.I());
    }

    public final com.fasterxml.jackson.databind.n a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.i.l r3) {
        int r0 = r2.i();
        if ((z & r0) != 0) goto L5;
        com.fasterxml.jackson.a.k.b r4 = r1.E();
    L13:
        if (r4 != com.fasterxml.jackson.a.k.b.f12143a) goto L17;
        return r3.a(r1.H());
    L17:
        if (r4 != com.fasterxml.jackson.a.k.b.f12144b) goto L21;
        return r3.a(r1.I());
    L21:
        return r3.a(r1.J());
    L5:
        if (com.fasterxml.jackson.databind.i.f12755b.a(r0) == false) goto L8;
        r4 = com.fasterxml.jackson.a.k.b.f12145c;
        goto L13
    L8:
        if (com.fasterxml.jackson.databind.i.f12756c.a(r0) == false) goto L10;
        r4 = com.fasterxml.jackson.a.k.b.f12144b;
        goto L13
    L10:
        r4 = r1.E();
        goto L13
    }

    public final com.fasterxml.jackson.databind.n b(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.i.l r4) {
        com.fasterxml.jackson.a.k.b r1 = r2.E();
        if (r1 != com.fasterxml.jackson.a.k.b.f) goto L7;
        return r4.a(r2.M());
    L7:
        if (r3.a(com.fasterxml.jackson.databind.i.f12754a) == false) goto L15;
        if (r2.t() == false) goto L13;
        return r4.a(r2.L());
    L13:
        return r4.a(r2.M());
    L15:
        if (r1 != com.fasterxml.jackson.a.k.b.f12146d) goto L19;
        return r4.a(r2.K());
    L19:
        return r4.a(r2.L());
    }

    public final com.fasterxml.jackson.databind.n d(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
        com.fasterxml.jackson.databind.i.l r5 = r4.l();
        Object r6 = r3.N();
        if (r6 != null) goto L7;
        return r5.a();
    L7:
        if (r6.getClass() != byte[].class) goto L11;
        return r5.a((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r6, byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin"));
    L11:
        if (ZeusTransformUtils.instanceOf(r6, com.fasterxml.jackson.databind.l.u.class) == false) goto L15;
        return r5.a((com.fasterxml.jackson.databind.l.u) ZeusTransformUtils.preCheckCast(r6, com.fasterxml.jackson.databind.l.u.class, "com.obric.aiagent.plugin"));
    L15:
        if (ZeusTransformUtils.instanceOf(r6, com.fasterxml.jackson.databind.n.class) == false) goto L19;
        return (com.fasterxml.jackson.databind.n) ZeusTransformUtils.preCheckCast(r6, com.fasterxml.jackson.databind.n.class, "com.obric.aiagent.plugin");
    L19:
        return r5.a(r6);
    }
}
