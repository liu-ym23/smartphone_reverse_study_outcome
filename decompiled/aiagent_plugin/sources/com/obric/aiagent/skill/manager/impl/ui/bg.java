package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface bg<T> {

    /* JADX INFO: compiled from: SkillFormFileState.kt */
    public static final class a implements bg {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final bf f20641a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f20641a == r6.f20641a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20641a.hashCode();
        }

        public String toString() {
            return "Invalid(reason=" + this.f20641a + ')';
        }

        public a(bf r2) {
            d.h.b.o.e(r2, "reason");
            this.f20641a = r2;
        }

        public final bf a() {
            return this.f20641a;
        }
    }

    /* JADX INFO: compiled from: SkillFormFileState.kt */
    public static final class b<T> implements bg<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f20642a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20642a, r6.f20642a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            T r0 = this.f20642a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Valid(value=" + this.f20642a + ')';
        }

        public b(T r1) {
            this.f20642a = r1;
        }

        public final T a() {
            return this.f20642a;
        }
    }
}
