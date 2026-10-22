package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSigningRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
interface s {

    /* JADX INFO: compiled from: SkillSigningRepository.kt */
    public static final class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20164a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20164a, r6.f20164a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20164a.hashCode();
        }

        public String toString() {
            return "Failure(reason=" + this.f20164a + ')';
        }

        public a(String r2) {
            d.h.b.o.e(r2, "reason");
            this.f20164a = r2;
        }

        public final String a() {
            return this.f20164a;
        }
    }

    /* JADX INFO: compiled from: SkillSigningRepository.kt */
    public static final class b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f20165a = null;

        static {
            f20165a = new b();
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
            return 1882357926;
        }

        public String toString() {
            return "Success";
        }

        private b() {
        }
    }
}
