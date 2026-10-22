package ib;

import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: ib.a$a, reason: collision with other inner class name */
    public static final class C0270a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f20537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f20538c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final KClass f20539d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AnimationSpec f20540e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Float f20541f;

        public C0270a(String r10, Object r11, Object r12, KClass r13, AnimationSpec r14, Float r15) {
            q.g(r10, "property");
            q.g(r11, "initialValue");
            q.g(r12, "targetValue");
            q.g(r13, "valueClass");
            q.g(r14, "spec");
            super(null);
            this.f20536a = r10;
            this.f20537b = r11;
            this.f20538c = r12;
            this.f20539d = r13;
            this.f20540e = r14;
            this.f20541f = r15;
        }

        @Override // ib.a
        public gb.a a() {
            return new gb.a(c(), b(), d(), this.f20540e, this.f20541f, e(), 0.0f, 64, null);
        }

        public Object b() {
            return this.f20537b;
        }

        public String c() {
            return this.f20536a;
        }

        public Object d() {
            return this.f20538c;
        }

        public KClass e() {
            return this.f20539d;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof C0270a) == false) goto L18;
            C0270a r11 = (C0270a) r10;
            if (q.b(c(), r11.c()) == true) goto L8;
            return false;
        L8:
            if (q.b(b(), r11.b()) == true) goto L10;
            return false;
        L10:
            if (q.b(d(), r11.d()) == true) goto L12;
            return false;
        L12:
            if (q.b(e(), r11.e()) == true) goto L14;
            return false;
        L14:
            if (q.b(this.f20540e, r11.f20540e) == true) goto L16;
            return false;
        L16:
            if (q.b(this.f20541f, r11.f20541f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            String r10 = c();
            int r11 = 0;
            if (r10 == null) goto L5;
            int r12 = r10.hashCode();
        L6:
            int r13 = r12 * 31;
            Object r14 = b();
            if (r14 == null) goto L9;
            int r15 = r14.hashCode();
        L10:
            int r16 = (r13 + r15) * 31;
            Object r17 = d();
            if (r17 == null) goto L13;
            int r18 = r17.hashCode();
        L14:
            int r19 = (r16 + r18) * 31;
            KClass r20 = e();
            if (r20 == null) goto L17;
            int r21 = r20.hashCode();
        L18:
            int r22 = (r19 + r21) * 31;
            AnimationSpec r23 = this.f20540e;
            if (r23 == null) goto L21;
            int r24 = r23.hashCode();
        L22:
            int r25 = (r22 + r24) * 31;
            Float r26 = this.f20541f;
            if (r26 == null) goto L26;
            r11 = r26.hashCode();
        L26:
            return r25 + r11;
        L21:
            r24 = 0;
            goto L22
        L17:
            r21 = 0;
            goto L18
        L13:
            r18 = 0;
            goto L14
        L9:
            r15 = 0;
            goto L10
        L5:
            r12 = 0;
            goto L6
        }

        public String toString() {
            return "SpringAnimationCommand(property=" + c() + ", initialValue=" + b() + ", targetValue=" + d() + ", valueClass=" + e() + ", spec=" + this.f20540e + ", initialVelocity=" + this.f20541f + ")";
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f20543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f20544c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final KClass f20545d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AnimationSpec f20546e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Float f20547f;

        public b(String r10, Object r11, Object r12, KClass r13, AnimationSpec r14, Float r15) {
            q.g(r10, "property");
            q.g(r11, "initialValue");
            q.g(r12, "targetValue");
            q.g(r13, "valueClass");
            q.g(r14, "spec");
            super(null);
            this.f20542a = r10;
            this.f20543b = r11;
            this.f20544c = r12;
            this.f20545d = r13;
            this.f20546e = r14;
            this.f20547f = r15;
        }

        @Override // ib.a
        public gb.a a() {
            return new gb.a(c(), b(), d(), this.f20546e, this.f20547f, e(), 0.0f, 64, null);
        }

        public Object b() {
            return this.f20543b;
        }

        public String c() {
            return this.f20542a;
        }

        public Object d() {
            return this.f20544c;
        }

        public KClass e() {
            return this.f20545d;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof b) == false) goto L18;
            b r11 = (b) r10;
            if (q.b(c(), r11.c()) == true) goto L8;
            return false;
        L8:
            if (q.b(b(), r11.b()) == true) goto L10;
            return false;
        L10:
            if (q.b(d(), r11.d()) == true) goto L12;
            return false;
        L12:
            if (q.b(e(), r11.e()) == true) goto L14;
            return false;
        L14:
            if (q.b(this.f20546e, r11.f20546e) == true) goto L16;
            return false;
        L16:
            if (q.b(this.f20547f, r11.f20547f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            String r10 = c();
            int r11 = 0;
            if (r10 == null) goto L5;
            int r12 = r10.hashCode();
        L6:
            int r13 = r12 * 31;
            Object r14 = b();
            if (r14 == null) goto L9;
            int r15 = r14.hashCode();
        L10:
            int r16 = (r13 + r15) * 31;
            Object r17 = d();
            if (r17 == null) goto L13;
            int r18 = r17.hashCode();
        L14:
            int r19 = (r16 + r18) * 31;
            KClass r20 = e();
            if (r20 == null) goto L17;
            int r21 = r20.hashCode();
        L18:
            int r22 = (r19 + r21) * 31;
            AnimationSpec r23 = this.f20546e;
            if (r23 == null) goto L21;
            int r24 = r23.hashCode();
        L22:
            int r25 = (r22 + r24) * 31;
            Float r26 = this.f20547f;
            if (r26 == null) goto L26;
            r11 = r26.hashCode();
        L26:
            return r25 + r11;
        L21:
            r24 = 0;
            goto L22
        L17:
            r21 = 0;
            goto L18
        L13:
            r18 = 0;
            goto L14
        L9:
            r15 = 0;
            goto L10
        L5:
            r12 = 0;
            goto L6
        }

        public String toString() {
            return "TweenAnimationCommand(property=" + c() + ", initialValue=" + b() + ", targetValue=" + d() + ", valueClass=" + e() + ", spec=" + this.f20546e + ", initialVelocity=" + this.f20547f + ")";
        }
    }

    public a() {
    }

    public abstract gb.a a();

    public /* synthetic */ a(DefaultConstructorMarker r10) {
        this();
    }
}
