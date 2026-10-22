package com.obric.autogui.agents.vlm.models.omni.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PrewarmBackend.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r {

    /* JADX INFO: compiled from: PrewarmBackend.kt */
    public static final class a extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28322a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f28322a, r6.f28322a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f28322a.hashCode();
        }

        public String toString() {
            return "Failed(reason=" + this.f28322a + ')';
        }

        public a(String r2) {
            d.h.b.o.e(r2, "reason");
            super(null);
            this.f28322a = r2;
        }

        public final String a() {
            return this.f28322a;
        }
    }

    /* JADX INFO: compiled from: PrewarmBackend.kt */
    public static final class b extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f28324b;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
            return false;
        L8:
            b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f28323a, r8.f28323a) == true) goto L12;
            return false;
        L12:
            if (this.f28324b == r8.f28324b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f28323a.hashCode() * 31) + Long.hashCode(this.f28324b);
        }

        public String toString() {
            return "Launched(packageName=" + this.f28323a + ", startedAtElapsedMs=" + this.f28324b + ')';
        }

        public final String a() {
            return this.f28323a;
        }

        public final long b() {
            return this.f28324b;
        }

        public b(String r2, long r3) {
            d.h.b.o.e(r2, "packageName");
            super(null);
            this.f28323a = r2;
            this.f28324b = r3;
        }
    }

    /* JADX INFO: compiled from: PrewarmBackend.kt */
    public static final class c extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f28326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f28327c;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
            return false;
        L8:
            c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f28325a, r10.f28325a) == true) goto L12;
            return false;
        L12:
            if (this.f28326b == r10.f28326b) goto L15;
            return false;
        L15:
            if (this.f28327c == r10.f28327c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f28325a.hashCode() * 31) + Long.hashCode(this.f28326b)) * 31) + Long.hashCode(this.f28327c);
        }

        public String toString() {
            return "Ready(packageName=" + this.f28325a + ", launchStartedAtElapsedMs=" + this.f28326b + ", processReadyAtElapsedMs=" + this.f28327c + ')';
        }

        public final String a() {
            return this.f28325a;
        }

        public final long b() {
            return this.f28326b;
        }

        public final long c() {
            return this.f28327c;
        }

        public c(String r2, long r3, long r5) {
            d.h.b.o.e(r2, "packageName");
            super(null);
            this.f28325a = r2;
            this.f28326b = r3;
            this.f28327c = r5;
        }
    }

    public /* synthetic */ r(d.h.b.h r1) {
        this();
    }

    private r() {
    }
}
