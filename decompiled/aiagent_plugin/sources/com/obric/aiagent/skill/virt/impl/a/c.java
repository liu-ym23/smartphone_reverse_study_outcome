package com.obric.aiagent.skill.virt.impl.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: VirtBackend.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: compiled from: VirtBackend.kt */
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f21917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f21918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f21919c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f21917a == r6.f21917a) goto L12;
            return false;
        L12:
            if (o.a(this.f21918b, r6.f21918b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f21919c, r6.f21919c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f21917a) * 31) + this.f21918b.hashCode()) * 31) + this.f21919c.hashCode();
        }

        public String toString() {
            return "Completed(exitCode=" + this.f21917a + ", stdout=" + this.f21918b + ", stderr=" + this.f21919c + ')';
        }

        public a(int r2, String r3, String r4) {
            o.e(r3, "stdout");
            o.e(r4, "stderr");
            this.f21917a = r2;
            this.f21918b = r3;
            this.f21919c = r4;
        }

        public final int c() {
            return this.f21917a;
        }

        @Override // com.obric.aiagent.skill.virt.impl.a.c
        public String a() {
            return this.f21918b;
        }

        @Override // com.obric.aiagent.skill.virt.impl.a.c
        public String b() {
            return this.f21919c;
        }
    }

    /* JADX INFO: compiled from: VirtBackend.kt */
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f21921b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f21920a, r6.f21920a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f21921b, r6.f21921b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f21920a.hashCode() * 31) + this.f21921b.hashCode();
        }

        public String toString() {
            return "TimedOut(stdout=" + this.f21920a + ", stderr=" + this.f21921b + ')';
        }

        public b(String r2, String r3) {
            o.e(r2, "stdout");
            o.e(r3, "stderr");
            this.f21920a = r2;
            this.f21921b = r3;
        }

        @Override // com.obric.aiagent.skill.virt.impl.a.c
        public String a() {
            return this.f21920a;
        }

        @Override // com.obric.aiagent.skill.virt.impl.a.c
        public String b() {
            return this.f21921b;
        }
    }

    String a();

    String b();
}
