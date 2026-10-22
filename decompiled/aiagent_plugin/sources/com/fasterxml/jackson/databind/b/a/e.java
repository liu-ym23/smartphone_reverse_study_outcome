package com.fasterxml.jackson.databind.b.a;

import com.fasterxml.jackson.databind.b.b.af;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Member;
import java.util.HashMap;

/* JADX INFO: compiled from: CreatorCollector.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final String[] f12286a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.c f12287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final boolean f12288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final boolean f12289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.e.o[] f12290e;
    protected int f;
    protected boolean g;
    protected com.fasterxml.jackson.databind.b.v[] h;
    protected com.fasterxml.jackson.databind.b.v[] i;
    protected com.fasterxml.jackson.databind.b.v[] j;

    static {
        f12286a = new String[]{DownloadSettingKeys.BugFix.DEFAULT, "from-String", "from-int", "from-long", "from-big-integer", "from-double", "from-big-decimal", "from-boolean", "delegate", "property-based", "array-delegate"};
    }

    public e(com.fasterxml.jackson.databind.c r2, com.fasterxml.jackson.databind.a.m<?> r3) {
        this.f12290e = new com.fasterxml.jackson.databind.e.o[11];
        this.f = 0;
        this.g = false;
        this.f12287b = r2;
        this.f12288c = r3.g();
        this.f12289d = r3.a(com.fasterxml.jackson.databind.r.o);
    }

    public com.fasterxml.jackson.databind.b.y a(com.fasterxml.jackson.databind.h r13) {
        com.fasterxml.jackson.databind.g r0 = r13.c();
        com.fasterxml.jackson.databind.k r7 = a(r13, this.f12290e[8], this.h);
        com.fasterxml.jackson.databind.k r14 = a(r13, this.f12290e[10], this.i);
        af r11 = new af(r0, this.f12287b.getType());
        com.fasterxml.jackson.databind.e.o[] r1 = this.f12290e;
        r11.a(r1[0], r1[8], r7, this.h, r1[9], this.j);
        r11.a(this.f12290e[10], r14, this.i);
        r11.a(this.f12290e[1]);
        r11.b(this.f12290e[2]);
        r11.c(this.f12290e[3]);
        r11.d(this.f12290e[4]);
        r11.e(this.f12290e[5]);
        r11.f(this.f12290e[6]);
        r11.g(this.f12290e[7]);
        return r11;
    }

    public void a(com.fasterxml.jackson.databind.e.o r3) {
        this.f12290e[0] = (com.fasterxml.jackson.databind.e.o) ZeusTransformUtils.preCheckCast(a(r3), com.fasterxml.jackson.databind.e.o.class, "com.obric.aiagent.plugin");
    }

    public void a(com.fasterxml.jackson.databind.e.o r2, boolean r3) {
        a(r2, 1, r3);
    }

    public void b(com.fasterxml.jackson.databind.e.o r2, boolean r3) {
        a(r2, 2, r3);
    }

    public void c(com.fasterxml.jackson.databind.e.o r2, boolean r3) {
        a(r2, 3, r3);
    }

    public void d(com.fasterxml.jackson.databind.e.o r2, boolean r3) {
        a(r2, 4, r3);
    }

    public void e(com.fasterxml.jackson.databind.e.o r2, boolean r3) {
        a(r2, 5, r3);
    }

    public void f(com.fasterxml.jackson.databind.e.o r2, boolean r3) {
        a(r2, 6, r3);
    }

    public void g(com.fasterxml.jackson.databind.e.o r2, boolean r3) {
        a(r2, 7, r3);
    }

    public void a(com.fasterxml.jackson.databind.e.o r1, boolean r2, com.fasterxml.jackson.databind.b.v[] r3, int r4) {
        if (r1.b(r4).r() == false) goto L8;
        if (a(r1, 10, r2) == false) goto L11;
        this.i = r3;
        return;
    L11:
        return;
    L8:
        if (a(r1, 8, r2) == false) goto L13;
        this.h = r3;
        return;
    }

    public void a(com.fasterxml.jackson.databind.e.o r8, boolean r9, com.fasterxml.jackson.databind.b.v[] r10) {
        if (a(r8, 9, r9) == true) goto L5;
        return;
    L5:
        if (r10.length <= 1) goto L18;
        HashMap r11 = new HashMap();
        int r0 = r10.length;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L18;
        String r3 = r10[r2].a();
        if (r3.isEmpty() == true) goto L11;
    L13:
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r11.put(r3, Integer.valueOf(r2)), Integer.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L15;
        throw new IllegalArgumentException(String.format("Duplicate creator property \"%s\" (index %s vs %d) for type %s ", new Object[]{r3, r4, Integer.valueOf(r2), com.fasterxml.jackson.databind.l.h.h(this.f12287b.a())}));
    L15:
        r2 = r2 + 1;
        goto L7
    L11:
        if (r10[r2].h() == null) goto L13;
    L18:
        this.j = r10;
    }

    public boolean a() {
        if (this.f12290e[0] == null) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean b() {
        if (this.f12290e[8] == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean c() {
        if (this.f12290e[9] == null) goto L5;
        return true;
    L5:
        return false;
    }

    private com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.databind.e.o r5, com.fasterxml.jackson.databind.b.v[] r6) {
        if (this.g == false) goto L21;
        if (r5 == null) goto L27;
        int r3 = 0;
        if (r6 == null) goto L14;
        int r0 = r6.length;
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L14;
        if (r6[r1] == null) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        r3 = r1;
    L14:
        com.fasterxml.jackson.databind.g r7 = r4.c();
        com.fasterxml.jackson.databind.k r2 = r5.b(r3);
        com.fasterxml.jackson.databind.b r8 = r7.j();
        if (r8 == null) goto L25;
        com.fasterxml.jackson.databind.e.n r9 = r5.d(r3);
        Object r10 = r8.x(r9);
        if (r10 == null) goto L20;
        return r2.c(r4.b(r9, r10));
    L20:
        return r8.b(r7, r9, r2);
    L25:
        return r2;
    L27:
        return null;
    L21:
        return null;
    }

    private <T extends com.fasterxml.jackson.databind.e.j> T a(T r4) {
        if (r4 != null) goto L4;
    L6:
        return r4;
    L4:
        if (this.f12288c == false) goto L6;
        com.fasterxml.jackson.databind.l.h.a((Member) ZeusTransformUtils.preCheckCast(r4.a(), Member.class, "com.obric.aiagent.plugin"), this.f12289d);
        goto L6
    }

    public boolean a(com.fasterxml.jackson.databind.e.o r8, int r9, boolean r10) {
        int r1 = 1 << r9;
        this.g = true;
        com.fasterxml.jackson.databind.e.o r2 = this.f12290e[r9];
        if (r2 != null) goto L5;
    L34:
        if (r10 == false) goto L36;
        this.f |= r1;
    L36:
        this.f12290e[r9] = (com.fasterxml.jackson.databind.e.o) ZeusTransformUtils.preCheckCast(a(r8), com.fasterxml.jackson.databind.e.o.class, "com.obric.aiagent.plugin");
        return true;
    L5:
        if ((this.f & r1) == 0) goto L9;
        if (r10 == true) goto L8;
        return false;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L34;
        if (r2.getClass() != r8.getClass()) goto L34;
        Class<?> r4 = r2.a(0);
        Class<?> r5 = r8.a(0);
        if (r4 != r5) goto L23;
        if (b(r8) == false) goto L19;
        return false;
    L19:
        if (b(r2) == true) goto L34;
        a(r9, r10, r2, r8);
        goto L34
    L23:
        if (r5.isAssignableFrom(r4) == false) goto L26;
        return false;
    L26:
        if (r4.isAssignableFrom(r5) == true) goto L34;
        if (r4.isPrimitive() != r5.isPrimitive()) goto L31;
        a(r9, r10, r2, r8);
        goto L34
    L31:
        if (r4.isPrimitive() == false) goto L34;
        return false;
    L9:
        r3 = !r10;
        goto L10
    }

    public void a(int r3, boolean r4, com.fasterxml.jackson.databind.e.o r5, com.fasterxml.jackson.databind.e.o r6) {
        Object[] r0 = new Object[4];
        r0[0] = f12286a[r3];
        if (r4 == false) goto L5;
        String r7 = "explicitly marked";
    L6:
        r0[1] = r7;
        r0[2] = r5;
        r0[3] = r6;
        throw new IllegalArgumentException(String.format("Conflicting %s creators: already had %s creator %s, encountered another: %s", r0));
    L5:
        r7 = "implicitly discovered";
        goto L6
    }

    public boolean b(com.fasterxml.jackson.databind.e.o r1) {
        if (com.fasterxml.jackson.databind.l.h.l(r1.f()) == true) goto L5;
    L7:
        return false;
    L5:
        if ("valueOf".equals(r1.b()) == false) goto L7;
        return true;
    }
}
