package com.obric.aiagent.skill.manager.impl.ui;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.obric.aiagent.skill.manager.impl.cx;
import com.obric.aiagent.skill.manager.impl.ee;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Random;

/* JADX INFO: compiled from: SkillDetailSigningProgressStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20492a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Gson f20493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.f f20494c;

    /* JADX INFO: compiled from: SkillDetailSigningProgressStore.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f20492a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$QZVTqQvJblbyQ3Jqgt8lirqG-NY, reason: not valid java name */
    public static /* synthetic */ Keva m325lambda$QZVTqQvJblbyQ3Jqgt8lirqGNY() {
        return b();
    }

    public ac() {
        this.f20493b = new Gson();
        this.f20494c = d.g.a($$Lambda$ac$QZVTqQvJblbyQ3Jqgt8lirqGNY.INSTANCE);
    }

    private final Keva a() {
        return (Keva) ZeusTransformUtils.preCheckCast(this.f20494c.b(), Keva.class, "com.obric.aiagent.plugin");
    }

    private static final Keva b() {
        return cx.f19710a.a();
    }

    public final ab a(String r17, int r18, long r19) {
        d.h.b.o.e(r17, "slug");
        ab r1 = b(r17);
        ab r2 = null;
        if (r1 != null) goto L5;
    L10:
        if (r2 == null) goto L13;
        c(r17);
        return r2;
    L13:
        ab r15 = new ab(0, r17, r18, d.k.c.f38513a.c(), 0, 0, r19, false, 177, null);
        b(r15);
        c(r17);
        return r15;
    L5:
        if (a(r1, r17, r18) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        r2 = c(r1);
        goto L10
    }

    public final ab a(ab r15, long r16) {
        d.h.b.o.e(r15, "snapshot");
        if (r15.h() == false) goto L6;
        ab r0 = ab.a(r15, 0, null, 0, 0, 0, 0, r16, false, 63, null);
    L13:
        if (d.h.b.o.a(r0, r15) == true) goto L15;
        b(r0);
    L15:
        return r0;
    L6:
        if (r16 >= r15.g()) goto L9;
        r0 = ab.a(r15, 0, null, 0, 0, 0, 0, r16, false, 191, null);
        goto L13
    L9:
        if (r15.e() < 30) goto L11;
        r0 = r15;
        goto L13
    L11:
        r0 = b(r15, r16);
        goto L13
    }

    public final ab a(ab r15) {
        d.h.b.o.e(r15, "snapshot");
        if (r15.h() == false) goto L5;
        return r15;
    L5:
        ab r16 = ab.a(r15, 0, null, 0, 0, 0, 0, 0, true, 127, null);
        b(r16);
        return r16;
    }

    public final void a(String r4) {
        d.h.b.o.e(r4, "slug");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L16;
        return;
    L16:
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L10
        ac r3 = (ac) ZeusTransformUtils.preCheckCast(this, ac.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        r3.a().erase(r3.d(r4));     // Catch: Throwable -> L10
        r3.a().erase(r3.e(r4));     // Catch: Throwable -> L10
        Object r5 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L10
    L12:
        Throwable r6 = d.n.c(r5);
        if (r6 == null) goto L18;
        ee.f19808a.a("SkillManager", "Clear detail signing progress failed", "Clear detail signing progress failed: slug=" + r4, r6);
        return;
    L18:
        return;
    L10:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    private final ab b(String r8) {
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        Object r4 = null;
        if (r0 == false) goto L31;
        return null;
    L31:
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L20
        ac r7 = (ac) ZeusTransformUtils.preCheckCast(this, ac.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        String r3 = r7.a().getString(r7.d(r8), "");     // Catch: Throwable -> L20
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        if (r5 != null) goto L12;
    L15:
        if (r2 == false) goto L17;
        ab r9 = null;
    L18:
        Object r10 = d.n.f(r9);     // Catch: Throwable -> L20
    L22:
        Throwable r6 = d.n.c(r10);
        if (r6 == null) goto L26;
        ee.f19808a.a("SkillManager", "Load detail signing progress failed", "Load detail signing progress failed: slug=" + r8, r6);
    L26:
        if (d.n.b(r10) == true) goto L30;
        r4 = r10;
    L30:
        return (ab) ZeusTransformUtils.preCheckCast(r4, ab.class, "com.obric.aiagent.plugin");
    L17:
        r9 = (ab) ZeusTransformUtils.preCheckCast(r7.f20493b.fromJson(r3, ab.class), ab.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        goto L18
    L12:
        if (d.o.o.d(r5) == true) goto L15;
        r2 = false;
    L20:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        r10 = d.n.f(d.o.a(th));
        goto L22
    L5:
        r0 = false;
        goto L6
    }

    private final void b(ab r4) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4.b(), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L16;
        return;
    L16:
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L10
        ac r3 = (ac) ZeusTransformUtils.preCheckCast(this, ac.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        r3.a().storeString(r3.d(r4.b()), r3.f20493b.toJson(r4));     // Catch: Throwable -> L10
        Object r5 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L10
    L12:
        Throwable r6 = d.n.c(r5);
        if (r6 == null) goto L18;
        ee.f19808a.a("SkillManager", "Save detail signing progress failed", "Save detail signing progress failed: slug=" + r4.b(), r6);
        return;
    L18:
        return;
    L10:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    private final ab b(ab r19, long r20) {
        int r0 = (int) d.l.n.b((r20 - r19.g()) / 10000, 30);
        int r11 = d.l.n.d(r19.e() + r0, 30);
        if (r11 != r19.e()) goto L6;
        return r19;
    L6:
        return ab.a(r19, 0, null, 0, 0, r11, a(r19.d(), r11), r19.g() + (((long) r0) * 10000), false, 143, null);
    }

    private final boolean a(ab r3, String r4, int r5) {
        if (r3.a() != 1) goto L26;
        if (d.h.b.o.a(r3.b(), r4) == false) goto L26;
        if (r3.c() != r5) goto L26;
        int r2 = r3.e();
        if (r2 >= 0) goto L11;
    L13:
        boolean r6 = false;
    L14:
        if (r6 == false) goto L26;
        int r7 = r3.f();
        if (r7 >= 0) goto L18;
    L20:
        boolean r8 = false;
    L21:
        if (r8 == false) goto L26;
        if (r3.g() <= 0) goto L26;
        return true;
    L18:
        if (r7 >= 100) goto L20;
        r8 = true;
        goto L21
    L11:
        if (r2 >= 31) goto L13;
        r6 = true;
    L26:
        return false;
    }

    private final ab c(ab r17) {
        return ab.a(r17, 0, null, 0, 0, 0, a(r17.d(), r17.e()), 0, false, 223, null);
    }

    private final int a(long r6, int r8) {
        int r5 = 0;
        if (r8 > 0) goto L5;
        return 0;
    L5:
        int[] r1 = new int[30];
        int r2 = 0;
    L7:
        if (r2 >= 30) goto L9;
        r1[r2] = 1;
        r2 = r2 + 1;
        goto L7
    L9:
        Random r3 = new Random(r6);
    L10:
        if (r5 >= 69) goto L13;
        int r7 = r3.nextInt(30);
        r1[r7] = r1[r7] + 1;
        r5 = r5 + 1;
        goto L10
    L13:
        return d.l.n.d(d.a.p.B((Iterable) ZeusTransformUtils.preCheckCast(d.a.i.c(r1, d.l.n.d(r8, 30)), Iterable.class, "com.obric.aiagent.plugin")), 99);
    }

    private final void c(String r4) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L4
        ac r3 = (ac) ZeusTransformUtils.preCheckCast(this, ac.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
        r3.a().erase(r3.e(r4));     // Catch: Throwable -> L4
        Object r5 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L4
    L6:
        Throwable r6 = d.n.c(r5);
        if (r6 == null) goto L12;
        ee.f19808a.a("SkillManager", "Clear legacy detail signing progress failed", "Clear legacy detail signing progress failed: slug=" + r4, r6);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L6
    }

    private final String d(String r2) {
        return "detail_signing_progress_v1_" + r2;
    }

    private final String e(String r2) {
        return "progress_" + r2;
    }
}
