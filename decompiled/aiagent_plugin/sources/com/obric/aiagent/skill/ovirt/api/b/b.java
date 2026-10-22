package com.obric.aiagent.skill.ovirt.api.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.h;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: ShellExecution.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: compiled from: ShellExecution.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f20975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final EnumC0440b f20976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f20977c;

        public static /* synthetic */ a a(a r0, c r1, EnumC0440b r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.f20975a;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.f20976b;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.f20977c;
        L12:
            return r0.a(r1, r2, r3);
        }

        public final a a(c r1, EnumC0440b r2, String r3) {
            o.e(r1, "snapshot");
            o.e(r2, "returnReason");
            return new a(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f20975a, r6.f20975a) == true) goto L12;
            return false;
        L12:
            if (this.f20976b == r6.f20976b) goto L15;
            return false;
        L15:
            if (o.a(this.f20977c, r6.f20977c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f20975a.hashCode() * 31) + this.f20976b.hashCode()) * 31;
            String r2 = this.f20977c;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "Return(snapshot=" + this.f20975a + ", returnReason=" + this.f20976b + ", errorMessage=" + this.f20977c + ')';
        }

        public a(c r2, EnumC0440b r3, String r4) {
            o.e(r2, "snapshot");
            o.e(r3, "returnReason");
            this.f20975a = r2;
            this.f20976b = r3;
            this.f20977c = r4;
        }

        public /* synthetic */ a(c r1, EnumC0440b r2, String r3, int r4, h r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = null;
        L5:
            this(r1, r2, r3);
        }

        public final c a() {
            return this.f20975a;
        }

        public final String b() {
            return this.f20977c;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.api.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShellExecution.kt */
    public static final enum EnumC0440b extends Enum<EnumC0440b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0440b f20978a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0440b f20979b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0440b f20980c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumC0440b[] f20981d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f20982e = null;

        private static final /* synthetic */ EnumC0440b[] a() {
            return new EnumC0440b[]{f20978a, f20979b, f20980c};
        }

        private EnumC0440b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f20978a = new EnumC0440b("COMPLETED", 0);
            f20979b = new EnumC0440b("INACTIVITY_RETURN", 1);
            f20980c = new EnumC0440b("HARD_TIMEOUT", 2);
            EnumC0440b[] r0 = a();
            f20981d = r0;
            f20982e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static EnumC0440b valueOf(String r2) {
            return (EnumC0440b) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0440b.class, r2), EnumC0440b.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0440b[] values() {
            return (EnumC0440b[]) ZeusTransformUtils.preCheckCast(f20981d.clone(), EnumC0440b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ShellExecution.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f20984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f20985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f20986d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f20987e;
        private final String f;
        private final String g;
        private final boolean h;
        private final Integer i;
        private final boolean j;
        private final long k;
        private final long l;
        private final File m;
        private final File n;
        private final String o;
        private final String p;
        private final String q;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
            return false;
        L8:
            c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f20983a, r10.f20983a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f20984b, r10.f20984b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f20985c, r10.f20985c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f20986d, r10.f20986d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f20987e, r10.f20987e) == true) goto L24;
            return false;
        L24:
            if (o.a(this.f, r10.f) == true) goto L27;
            return false;
        L27:
            if (o.a(this.g, r10.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r10.h) goto L33;
            return false;
        L33:
            if (o.a(this.i, r10.i) == true) goto L36;
            return false;
        L36:
            if (this.j == r10.j) goto L39;
            return false;
        L39:
            if (this.k == r10.k) goto L42;
            return false;
        L42:
            if (this.l == r10.l) goto L45;
            return false;
        L45:
            if (o.a(this.m, r10.m) == true) goto L48;
            return false;
        L48:
            if (o.a(this.n, r10.n) == true) goto L51;
            return false;
        L51:
            if (o.a(this.o, r10.o) == true) goto L54;
            return false;
        L54:
            if (o.a(this.p, r10.p) == true) goto L57;
            return false;
        L57:
            if (o.a(this.q, r10.q) == true) goto L59;
            return false;
        L59:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((((((((((this.f20983a.hashCode() * 31) + this.f20984b.hashCode()) * 31) + this.f20985c.hashCode()) * 31) + this.f20986d.hashCode()) * 31) + this.f20987e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Boolean.hashCode(this.h)) * 31;
            Integer r1 = this.i;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((((r0 + r3) * 31) + Boolean.hashCode(this.j)) * 31) + Long.hashCode(this.k)) * 31) + Long.hashCode(this.l)) * 31;
            File r5 = this.m;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            File r8 = this.n;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.o;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.p;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.q;
            if (r17 == null) goto L27;
            r2 = r17.hashCode();
        L27:
            return r16 + r2;
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("Snapshot(groupId=").append(this.f20983a).append(", executionId=").append(this.f20984b).append(", workDir=").append(this.f20985c).append(", command=").append(this.f20986d).append(", stdout=").append(this.f20987e).append(", stderr=").append(this.f).append(", status=").append(this.g).append(", completed=").append(this.h).append(", exitCode=").append(this.i).append(", killed=").append(this.j).append(", startedAtMs=").append(this.k).append(", durationMs=");
            r0.append(this.l).append(", stdoutFile=").append(this.m).append(", stderrFile=").append(this.n).append(", stdoutPath=").append(this.o).append(", stderrPath=").append(this.p).append(", clientEgressResultJson=").append(this.q).append(')');
            return r0.toString();
        }

        public c(String r10, String r11, String r12, String r13, String r14, String r15, String r16, boolean r17, Integer r18, boolean r19, long r20, long r22, File r24, File r25, String r26, String r27, String r28) {
            o.e(r10, "groupId");
            o.e(r11, "executionId");
            o.e(r12, "workDir");
            o.e(r13, "command");
            o.e(r14, "stdout");
            o.e(r15, "stderr");
            o.e(r16, "status");
            this.f20983a = r10;
            this.f20984b = r11;
            this.f20985c = r12;
            this.f20986d = r13;
            this.f20987e = r14;
            this.f = r15;
            this.g = r16;
            this.h = r17;
            this.i = r18;
            this.j = r19;
            this.k = r20;
            this.l = r22;
            this.m = r24;
            this.n = r25;
            this.o = r26;
            this.p = r27;
            this.q = r28;
        }

        public final String a() {
            return this.f20984b;
        }

        public final String b() {
            return this.f20985c;
        }

        public final String c() {
            return this.f20986d;
        }

        public final String d() {
            return this.f20987e;
        }

        public final String e() {
            return this.f;
        }

        public final boolean f() {
            return this.h;
        }

        public final Integer g() {
            return this.i;
        }

        public final boolean h() {
            return this.j;
        }

        public final long i() {
            return this.l;
        }

        public final String j() {
            return this.o;
        }

        public final String k() {
            return this.p;
        }

        public final String l() {
            return this.q;
        }
    }

    Object a(d<? super a> r1);

    String a();

    c b();
}
