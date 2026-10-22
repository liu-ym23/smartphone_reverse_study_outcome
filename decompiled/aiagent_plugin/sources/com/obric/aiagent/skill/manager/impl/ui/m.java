package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InstalledSkillListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20797a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.skill.manager.api.e f20798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f20799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f20800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k f20801e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final boolean j;
    private final boolean k;

    /* JADX INFO: compiled from: InstalledSkillListAdapter.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.m$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: InstalledSkillListAdapter.kt */
        public /* synthetic */ class C0436a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f20802a = null;

            static {
                int[] r0 = new int[f.values().length];
                r0[f.f20776a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[f.f20777b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f20802a = r0;
            }
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final m a(com.obric.aiagent.skill.manager.api.e r13, int r14, int r15, String r16, f r17) {
            d.h.b.o.e(r13, "skill");
            d.h.b.o.e(r17, "iconMode");
            boolean r10 = com.obric.aiagent.skill.manager.impl.az.a(r13);
            int r0 = C0436a.f20802a[r17.ordinal()];
            if (r0 != 1) goto L5;
            k r1 = (k) ZeusTransformUtils.preCheckCast(new k.b(r13.f()), k.class, "com.obric.aiagent.plugin");
        L21:
            k r4 = r1;
            String r5 = com.obric.aiagent.skill.manager.impl.az.d(r13);
            String r6 = com.obric.aiagent.skill.manager.impl.az.e(r13);
            String r7 = com.obric.aiagent.skill.manager.impl.az.b(r13, r16);
            String r8 = com.obric.aiagent.skill.manager.impl.az.g(r13);
            if (r13.l() == false) goto L25;
            if (r10 == true) goto L25;
            boolean r9 = true;
        L27:
            return new m(r13, r14, r15, r4, r5, r6, r7, r8, r9, r10);
        L25:
            r9 = false;
            goto L27
        L5:
            if (r0 != 2) goto L19;
            com.obric.aiagent.skill.manager.api.a r2 = r13.h();
            String r11 = null;
            CharSequence r12 = null;
            r11 = null;
            r11 = null;
            if (r2 == null) goto L17;
            String r3 = r2.a();
            if (r3 == null) goto L17;
            String r18 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (r18 == null) goto L17;
            CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin");
            if (d.o.o.d(r19) == true) goto L16;
            r12 = r19;
        L16:
            r11 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin");
        L17:
            r1 = (k) ZeusTransformUtils.preCheckCast(new k.a(r11), k.class, "com.obric.aiagent.plugin");
            goto L21
        L19:
            throw new d.k();
        }
    }

    static {
        f20797a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20798b, r6.f20798b) == true) goto L12;
        return false;
    L12:
        if (this.f20799c == r6.f20799c) goto L15;
        return false;
    L15:
        if (this.f20800d == r6.f20800d) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f20801e, r6.f20801e) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.h, r6.h) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.i, r6.i) == true) goto L33;
        return false;
    L33:
        if (this.j == r6.j) goto L36;
        return false;
    L36:
        if (this.k == r6.k) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((this.f20798b.hashCode() * 31) + Integer.hashCode(this.f20799c)) * 31) + Integer.hashCode(this.f20800d)) * 31) + this.f20801e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        String r1 = this.h;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((r0 + r2) * 31) + this.i.hashCode()) * 31) + Boolean.hashCode(this.j)) * 31) + Boolean.hashCode(this.k);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "InstalledSkillListRow(skill=" + this.f20798b + ", position=" + this.f20799c + ", itemCount=" + this.f20800d + ", icon=" + this.f20801e + ", name=" + this.f + ", description=" + this.g + ", sourceIconUrl=" + this.h + ", sourceText=" + this.i + ", switchChecked=" + this.j + ", securityBlocked=" + this.k + ')';
    }

    public m(com.obric.aiagent.skill.manager.api.e r3, int r4, int r5, k r6, String r7, String r8, String r9, String r10, boolean r11, boolean r12) {
        k r13 = (k) ZeusTransformUtils.wrapperContextForParams(r6, k.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "skill");
        d.h.b.o.e(r13, "icon");
        d.h.b.o.e(r7, "name");
        d.h.b.o.e(r8, "description");
        d.h.b.o.e(r10, "sourceText");
        this.f20798b = r3;
        this.f20799c = r4;
        this.f20800d = r5;
        this.f20801e = r13;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }

    public final com.obric.aiagent.skill.manager.api.e a() {
        return this.f20798b;
    }

    public final int b() {
        return this.f20799c;
    }

    public final int c() {
        return this.f20800d;
    }

    public final k d() {
        return this.f20801e;
    }

    public final String e() {
        return this.f;
    }

    public final String f() {
        return this.g;
    }

    public final String g() {
        return this.h;
    }

    public final String h() {
        return this.i;
    }

    public final boolean i() {
        return this.j;
    }

    public final boolean j() {
        return this.k;
    }

    public final boolean a(m r3) {
        d.h.b.o.e(r3, "other");
        if (this.f20799c == r3.f20799c) goto L5;
    L21:
        return false;
    L5:
        if (this.f20800d != r3.f20800d) goto L21;
        if (d.h.b.o.a(this.f20801e, r3.f20801e) == false) goto L21;
        if (d.h.b.o.a(this.f, r3.f) == false) goto L21;
        if (d.h.b.o.a(this.g, r3.g) == false) goto L21;
        if (d.h.b.o.a(this.h, r3.h) == false) goto L21;
        if (d.h.b.o.a(this.i, r3.i) == false) goto L21;
        if (this.j != r3.j) goto L21;
        if (this.k != r3.k) goto L21;
        return true;
    }
}
