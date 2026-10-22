package com.obric.aiagent.skill.manager.impl;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSigningRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface gl {

    /* JADX INFO: compiled from: SkillSigningRepository.kt */
    public static final class a implements gl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19998a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19998a, r6.f19998a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f19998a.hashCode();
        }

        public String toString() {
            return "Fail(reason=" + this.f19998a + ')';
        }

        public a(String r2) {
            d.h.b.o.e(r2, "reason");
            this.f19998a = r2;
        }

        public final String a() {
            return this.f19998a;
        }
    }

    /* JADX INFO: compiled from: SkillSigningRepository.kt */
    public static final class b implements gl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19999a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19999a, r6.f19999a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f19999a.hashCode();
        }

        public String toString() {
            return "FetchDecision(taskId=" + this.f19999a + ')';
        }

        public b(String r2) {
            d.h.b.o.e(r2, DBDefinition.TASK_ID);
            this.f19999a = r2;
        }

        public final String a() {
            return this.f19999a;
        }
    }

    /* JADX INFO: compiled from: SkillSigningRepository.kt */
    public static final class c implements gl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f20001b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20000a, r6.f20000a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f20001b, r6.f20001b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f20000a.hashCode() * 31) + this.f20001b.hashCode();
        }

        public String toString() {
            return "FetchManifest(manifestId=" + this.f20000a + ", taskId=" + this.f20001b + ')';
        }

        public c(String r2, String r3) {
            d.h.b.o.e(r2, "manifestId");
            d.h.b.o.e(r3, DBDefinition.TASK_ID);
            this.f20000a = r2;
            this.f20001b = r3;
        }

        public final String a() {
            return this.f20000a;
        }

        public final String b() {
            return this.f20001b;
        }
    }

    /* JADX INFO: compiled from: SkillSigningRepository.kt */
    public static final class d implements gl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20002a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20002a, r6.f20002a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20002a.hashCode();
        }

        public String toString() {
            return "PollTask(taskId=" + this.f20002a + ')';
        }

        public d(String r2) {
            d.h.b.o.e(r2, DBDefinition.TASK_ID);
            this.f20002a = r2;
        }

        public final String a() {
            return this.f20002a;
        }
    }

    /* JADX INFO: compiled from: SkillSigningRepository.kt */
    public static final class e implements gl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f20003a = null;

        static {
            f20003a = new e();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, e.class) == true) goto L9;
            return false;
        L9:
            e r2 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -145221516;
        }

        public String toString() {
            return "SkipStore";
        }

        private e() {
        }
    }

    /* JADX INFO: compiled from: SkillSigningRepository.kt */
    public static final class f implements gl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f20004a = null;

        static {
            f20004a = new f();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, f.class) == true) goto L9;
            return false;
        L9:
            f r2 = (f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 1845103395;
        }

        public String toString() {
            return "SubmitScan";
        }

        private f() {
        }
    }

    /* JADX INFO: compiled from: SkillSigningRepository.kt */
    public static final class g implements gl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f20006b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20005a, r6.f20005a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f20006b, r6.f20006b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f20005a.hashCode() * 31) + this.f20006b.hashCode();
        }

        public String toString() {
            return "VerifyManifest(manifestId=" + this.f20005a + ", taskId=" + this.f20006b + ')';
        }

        public g(String r2, String r3) {
            d.h.b.o.e(r2, "manifestId");
            d.h.b.o.e(r3, DBDefinition.TASK_ID);
            this.f20005a = r2;
            this.f20006b = r3;
        }

        public final String a() {
            return this.f20005a;
        }

        public final String b() {
            return this.f20006b;
        }
    }
}
