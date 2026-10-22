package com.obric.aiagent.skill.manager.api;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillOperationResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface u<T> {

    /* JADX INFO: compiled from: SkillOperationResult.kt */
    public static final class a implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r f19313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f19314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f19315c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final s f19316d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f19313a == r6.f19313a) goto L12;
            return false;
        L12:
            if (this.f19314b == r6.f19314b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f19315c, r6.f19315c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f19316d, r6.f19316d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.f19313a.hashCode() * 31) + Boolean.hashCode(this.f19314b)) * 31) + this.f19315c.hashCode()) * 31;
            s r2 = this.f19316d;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "Failure(code=" + this.f19313a + ", retryable=" + this.f19314b + ", diagnostic=" + this.f19315c + ", detail=" + this.f19316d + ')';
        }

        public a(r r2, boolean r3, String r4, s r5) {
            d.h.b.o.e(r2, MonitorConstants.CODE);
            d.h.b.o.e(r4, "diagnostic");
            this.f19313a = r2;
            this.f19314b = r3;
            this.f19315c = r4;
            this.f19316d = r5;
        }

        public /* synthetic */ a(r r1, boolean r2, String r3, s r4, int r5, d.h.b.h r6) {
            if ((r5 & 2) == 0) goto L6;
            r2 = false;
        L6:
            if ((r5 & 4) == 0) goto L9;
            r3 = "";
        L9:
            if ((r5 & 8) == 0) goto L11;
            r4 = null;
        L11:
            this(r1, r2, r3, r4);
        }

        public final r a() {
            return this.f19313a;
        }

        public final boolean b() {
            return this.f19314b;
        }

        public final String c() {
            return this.f19315c;
        }

        public final s d() {
            return this.f19316d;
        }
    }

    /* JADX INFO: compiled from: SkillOperationResult.kt */
    public static final class b<T> implements u<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f19317a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19317a, r6.f19317a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            T r0 = this.f19317a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Success(value=" + this.f19317a + ')';
        }

        public b(T r1) {
            this.f19317a = r1;
        }

        public final T a() {
            return this.f19317a;
        }
    }
}
