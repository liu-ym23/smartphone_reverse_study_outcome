package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class at {

    /* JADX INFO: compiled from: SkillFormFileState.kt */
    public static final class a extends at {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.aiagent.skill.manager.impl.bt f20569b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20568a, r6.f20568a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f20569b, r6.f20569b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f20568a.hashCode() * 31) + this.f20569b.hashCode();
        }

        public String toString() {
            return "Failed(fileName=" + this.f20568a + ", reason=" + this.f20569b + ')';
        }

        public final String a() {
            return this.f20568a;
        }

        public final com.obric.aiagent.skill.manager.impl.bt b() {
            return this.f20569b;
        }

        public a(String r2, com.obric.aiagent.skill.manager.impl.bt r3) {
            d.h.b.o.e(r2, "fileName");
            d.h.b.o.e(r3, "reason");
            super(null);
            this.f20568a = r2;
            this.f20569b = r3;
        }
    }

    /* JADX INFO: compiled from: SkillFormFileState.kt */
    public static final class b extends at {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f20570a = null;

        static {
            f20570a = new b();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L9;
            return false;
        L9:
            b r2 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -308028155;
        }

        public String toString() {
            return "Idle";
        }

        private b() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SkillFormFileState.kt */
    public static final class c extends at {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20571a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20571a, r6.f20571a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20571a.hashCode();
        }

        public String toString() {
            return "Parsing(fileName=" + this.f20571a + ')';
        }

        public c(String r2) {
            d.h.b.o.e(r2, "fileName");
            super(null);
            this.f20571a = r2;
        }

        public final String a() {
            return this.f20571a;
        }
    }

    /* JADX INFO: compiled from: SkillFormFileState.kt */
    public static final class d extends at {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20572a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20572a, r6.f20572a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20572a.hashCode();
        }

        public String toString() {
            return "Success(fileName=" + this.f20572a + ')';
        }

        public d(String r2) {
            d.h.b.o.e(r2, "fileName");
            super(null);
            this.f20572a = r2;
        }
    }

    public /* synthetic */ at(d.h.b.h r1) {
        this();
    }

    private at() {
    }
}
