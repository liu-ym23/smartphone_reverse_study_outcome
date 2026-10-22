package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: ObricSkillPackageMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ab {

    /* JADX INFO: compiled from: ObricSkillPackageMetadata.kt */
    public static final class a implements ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Throwable f19435b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19434a, r6.f19434a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f19435b, r6.f19435b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f19434a.hashCode() * 31;
            Throwable r1 = this.f19435b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "Invalid(reason=" + this.f19434a + ", error=" + this.f19435b + ')';
        }

        public a(String r2, Throwable r3) {
            d.h.b.o.e(r2, "reason");
            this.f19434a = r2;
            this.f19435b = r3;
        }

        public /* synthetic */ a(String r1, Throwable r2, int r3, d.h.b.h r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }

        public final String a() {
            return this.f19434a;
        }

        public final Throwable b() {
            return this.f19435b;
        }
    }

    /* JADX INFO: compiled from: ObricSkillPackageMetadata.kt */
    public static final class b implements ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f19436a = null;

        static {
            f19436a = new b();
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
            return -590710155;
        }

        public String toString() {
            return "Missing";
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: ObricSkillPackageMetadata.kt */
    public static final class c implements ab {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f19437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final aa f19438b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19437a, r6.f19437a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f19438b, r6.f19438b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f19437a.hashCode() * 31) + this.f19438b.hashCode();
        }

        public String toString() {
            return "Valid(packageRoot=" + this.f19437a + ", descriptor=" + this.f19438b + ')';
        }

        public c(File r2, aa r3) {
            d.h.b.o.e(r2, "packageRoot");
            d.h.b.o.e(r3, "descriptor");
            this.f19437a = r2;
            this.f19438b = r3;
        }

        public final File a() {
            return this.f19437a;
        }

        public final aa b() {
            return this.f19438b;
        }
    }
}
