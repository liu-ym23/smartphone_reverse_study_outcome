package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface as {

    /* JADX INFO: compiled from: SkillFormFileState.kt */
    public static final class a implements as {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20562a = null;

        static {
            f20562a = new a();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L9;
            return false;
        L9:
            a r2 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -1193046841;
        }

        public String toString() {
            return "Hidden";
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillFormFileState.kt */
    public static final class b implements as {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final aq f20563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final av f20564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final at f20565c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d.h.a.a<d.x> f20566d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final d.h.a.a<d.x> f20567e;

        public static /* synthetic */ b a(b r6, aq r7, av r8, at r9, d.h.a.a r10, d.h.a.a r11, int r12, Object r13) {
            d.h.a.a<d.x> r14 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a<d.x> r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.a.class, "com.obric.aiagent.plugin");
            if ((r12 & 1) == 0) goto L5;
            r7 = r6.f20563a;
        L5:
            aq r1 = r7;
            if ((r12 & 2) == 0) goto L8;
            r8 = r6.f20564b;
        L8:
            av r2 = r8;
            if ((r12 & 4) == 0) goto L11;
            r9 = r6.f20565c;
        L11:
            at r3 = r9;
            if ((r12 & 8) == 0) goto L14;
            r14 = r6.f20566d;
        L14:
            d.h.a.a<d.x> r4 = r14;
            if ((r12 & 16) == 0) goto L18;
            r15 = r6.f20567e;
        L18:
            return r6.a(r1, r2, r3, r4, r15);
        }

        public final b a(aq r8, av r9, at r10, d.h.a.a<d.x> r11, d.h.a.a<d.x> r12) {
            d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r8, "placement");
            d.h.b.o.e(r9, "usage");
            d.h.b.o.e(r10, "state");
            d.h.b.o.e(r5, "onSelect");
            return new b(r8, r9, r10, r5, r6);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f20563a == r6.f20563a) goto L12;
            return false;
        L12:
            if (this.f20564b == r6.f20564b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f20565c, r6.f20565c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f20566d, r6.f20566d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f20567e, r6.f20567e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((this.f20563a.hashCode() * 31) + this.f20564b.hashCode()) * 31) + this.f20565c.hashCode()) * 31) + this.f20566d.hashCode()) * 31;
            d.h.a.a<d.x> r2 = this.f20567e;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "Visible(placement=" + this.f20563a + ", usage=" + this.f20564b + ", state=" + this.f20565c + ", onSelect=" + this.f20566d + ", onDelete=" + this.f20567e + ')';
        }

        public b(aq r3, av r4, at r5, d.h.a.a<d.x> r6, d.h.a.a<d.x> r7) {
            d.h.a.a<d.x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a<d.x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "placement");
            d.h.b.o.e(r4, "usage");
            d.h.b.o.e(r5, "state");
            d.h.b.o.e(r8, "onSelect");
            this.f20563a = r3;
            this.f20564b = r4;
            this.f20565c = r5;
            this.f20566d = r8;
            this.f20567e = r9;
        }

        public /* synthetic */ b(aq r8, av r9, at r10, d.h.a.a r11, d.h.a.a r12, int r13, d.h.b.h r14) {
            d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
            if ((r13 & 16) == 0) goto L5;
            r15 = null;
        L5:
            this(r8, r9, r10, r5, r15);
        }

        public final aq a() {
            return this.f20563a;
        }

        public final av b() {
            return this.f20564b;
        }

        public final at c() {
            return this.f20565c;
        }

        public final d.h.a.a<d.x> d() {
            return this.f20566d;
        }

        public final d.h.a.a<d.x> e() {
            return this.f20567e;
        }
    }
}
