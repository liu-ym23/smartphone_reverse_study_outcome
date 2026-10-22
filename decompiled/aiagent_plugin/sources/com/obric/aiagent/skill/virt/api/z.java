package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ShellApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface z {

    /* JADX INFO: compiled from: ShellApi.kt */
    public static final class a implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f21627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f21628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f21629c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f21627a == r6.f21627a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f21628b, r6.f21628b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f21629c, r6.f21629c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f21627a) * 31) + this.f21628b.hashCode()) * 31) + this.f21629c.hashCode();
        }

        public String toString() {
            return "Completed(exitCode=" + this.f21627a + ", stdout=" + this.f21628b + ", stderr=" + this.f21629c + ')';
        }

        public a(int r2, String r3, String r4) {
            d.h.b.o.e(r3, "stdout");
            d.h.b.o.e(r4, "stderr");
            this.f21627a = r2;
            this.f21628b = r3;
            this.f21629c = r4;
        }

        public final int b() {
            return this.f21627a;
        }

        public String c() {
            return this.f21628b;
        }

        @Override // com.obric.aiagent.skill.virt.api.z
        public String a() {
            return this.f21629c;
        }
    }

    /* JADX INFO: compiled from: ShellApi.kt */
    public static final class b implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f21631b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f21630a, r6.f21630a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f21631b, r6.f21631b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f21630a.hashCode() * 31) + this.f21631b.hashCode();
        }

        public String toString() {
            return "TimedOut(stdout=" + this.f21630a + ", stderr=" + this.f21631b + ')';
        }

        public b(String r2, String r3) {
            d.h.b.o.e(r2, "stdout");
            d.h.b.o.e(r3, "stderr");
            this.f21630a = r2;
            this.f21631b = r3;
        }

        @Override // com.obric.aiagent.skill.virt.api.z
        public String a() {
            return this.f21631b;
        }
    }

    String a();
}
