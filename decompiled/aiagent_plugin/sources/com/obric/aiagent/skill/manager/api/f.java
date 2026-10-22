package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillAdmissionPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface f {

    /* JADX INFO: compiled from: SkillAdmissionPolicy.kt */
    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f19254a = null;

        static {
            f19254a = new a();
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
            return -906311337;
        }

        public String toString() {
            return "Allowed";
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillAdmissionPolicy.kt */
    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f19255a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f19255a == r6.f19255a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f19255a.hashCode();
        }

        public String toString() {
            return "Rejected(reason=" + this.f19255a + ')';
        }

        public b(h r2) {
            d.h.b.o.e(r2, "reason");
            this.f19255a = r2;
        }

        public final h a() {
            return this.f19255a;
        }
    }
}
