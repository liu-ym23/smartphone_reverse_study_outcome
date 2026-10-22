package com.obric.common.oea.foundation.animation.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.m.c;

/* JADX INFO: compiled from: AnimationCommand.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimationCommand.kt */
    public static final class C0880a<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f32330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f32331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final T f32332c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final c<T> f32333d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.obric.common.oea.foundation.animation.g.a<T> f32334e;
        private final Float f;

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, C0880a.class) == false) goto L19;
            C0880a r4 = (C0880a) ZeusTransformUtils.preCheckCast(r3, C0880a.class, "com.obric.aiagent.plugin");
            if (o.a(b(), r4.b()) == true) goto L9;
            return false;
        L9:
            if (o.a(c(), r4.c()) == true) goto L11;
            return false;
        L11:
            if (o.a(d(), r4.d()) == true) goto L13;
            return false;
        L13:
            if (o.a(e(), r4.e()) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f32334e, r4.f32334e) == true) goto L17;
            return false;
        L17:
            if (o.a(this.f, r4.f) == true) goto L29;
            return false;
        L29:
            return true;
        L19:
            return false;
        }

        public int hashCode() {
            String r0 = b();
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            T r4 = c();
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            T r7 = d();
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            c<T> r10 = e();
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            com.obric.common.oea.foundation.animation.g.a<T> r13 = this.f32334e;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            Float r16 = this.f;
            if (r16 == null) goto L26;
            r1 = r16.hashCode();
        L26:
            return r15 + r1;
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "SpringAnimationCommand(property=" + b() + ", initialValue=" + c() + ", targetValue=" + d() + ", valueClass=" + e() + ", spec=" + this.f32334e + ", initialVelocity=" + this.f + ")";
        }

        public String b() {
            return this.f32330a;
        }

        public T c() {
            return this.f32331b;
        }

        public T d() {
            return this.f32332c;
        }

        public c<T> e() {
            return this.f32333d;
        }

        public C0880a(String r3, T r4, T r5, c<T> r6, com.obric.common.oea.foundation.animation.g.a<T> r7, Float r8) {
            c<T> r9 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.aiagent.plugin");
            com.obric.common.oea.foundation.animation.g.a<T> r10 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            o.e(r3, "property");
            o.e(r4, "initialValue");
            o.e(r5, "targetValue");
            o.e(r9, "valueClass");
            o.e(r10, "spec");
            super(null);
            this.f32330a = r3;
            this.f32331b = r4;
            this.f32332c = r5;
            this.f32333d = r9;
            this.f32334e = r10;
            this.f = r8;
        }

        @Override // com.obric.common.oea.foundation.animation.c.a
        public com.obric.common.oea.foundation.animation.a<T> a() {
            return new com.obric.common.oea.foundation.animation.a(b(), c(), d(), this.f32334e, this.f, e(), 0.0f, 64, null);
        }
    }

    /* JADX INFO: compiled from: AnimationCommand.kt */
    public static final class b<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f32335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f32336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final T f32337c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final c<T> f32338d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.obric.common.oea.foundation.animation.g.a<T> f32339e;
        private final Float f;

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L19;
            b r4 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
            if (o.a(b(), r4.b()) == true) goto L9;
            return false;
        L9:
            if (o.a(c(), r4.c()) == true) goto L11;
            return false;
        L11:
            if (o.a(d(), r4.d()) == true) goto L13;
            return false;
        L13:
            if (o.a(e(), r4.e()) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f32339e, r4.f32339e) == true) goto L17;
            return false;
        L17:
            if (o.a(this.f, r4.f) == true) goto L29;
            return false;
        L29:
            return true;
        L19:
            return false;
        }

        public int hashCode() {
            String r0 = b();
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            T r4 = c();
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            T r7 = d();
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            c<T> r10 = e();
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            com.obric.common.oea.foundation.animation.g.a<T> r13 = this.f32339e;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            Float r16 = this.f;
            if (r16 == null) goto L26;
            r1 = r16.hashCode();
        L26:
            return r15 + r1;
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "TweenAnimationCommand(property=" + b() + ", initialValue=" + c() + ", targetValue=" + d() + ", valueClass=" + e() + ", spec=" + this.f32339e + ", initialVelocity=" + this.f + ")";
        }

        public String b() {
            return this.f32335a;
        }

        public T c() {
            return this.f32336b;
        }

        public T d() {
            return this.f32337c;
        }

        public c<T> e() {
            return this.f32338d;
        }

        public b(String r3, T r4, T r5, c<T> r6, com.obric.common.oea.foundation.animation.g.a<T> r7, Float r8) {
            c<T> r9 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.aiagent.plugin");
            com.obric.common.oea.foundation.animation.g.a<T> r10 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            o.e(r3, "property");
            o.e(r4, "initialValue");
            o.e(r5, "targetValue");
            o.e(r9, "valueClass");
            o.e(r10, "spec");
            super(null);
            this.f32335a = r3;
            this.f32336b = r4;
            this.f32337c = r5;
            this.f32338d = r9;
            this.f32339e = r10;
            this.f = r8;
        }

        @Override // com.obric.common.oea.foundation.animation.c.a
        public com.obric.common.oea.foundation.animation.a<T> a() {
            return new com.obric.common.oea.foundation.animation.a(b(), c(), d(), this.f32339e, this.f, e(), 0.0f, 64, null);
        }
    }

    public abstract com.obric.common.oea.foundation.animation.a<T> a();

    private a() {
    }

    public /* synthetic */ a(h r1) {
        this();
    }
}
