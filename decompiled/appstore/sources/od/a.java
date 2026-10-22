package od;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: od.a$a, reason: collision with other inner class name */
    public static final class C0327a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f22549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f22550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f22551c;

        public /* synthetic */ C0327a(int r10, float r11, float r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 1) == 0) goto L6;
            r10 = 0;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = 0.0f;
        L9:
            if ((r13 & 4) == 0) goto L11;
            r12 = 0.0f;
        L11:
            this(r10, r11, r12);
        }

        public final float a() {
            return this.f22551c;
        }

        public final float b() {
            return this.f22550b;
        }

        public final int c() {
            return this.f22549a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0327a) == true) goto L8;
            return false;
        L8:
            C0327a r11 = (C0327a) r10;
            if (this.f22549a == r11.f22549a) goto L12;
            return false;
        L12:
            if (q.b(Float.valueOf(this.f22550b), Float.valueOf(r11.f22550b)) == true) goto L15;
            return false;
        L15:
            if (q.b(Float.valueOf(this.f22551c), Float.valueOf(r11.f22551c)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f22549a) * 31) + Float.hashCode(this.f22550b)) * 31) + Float.hashCode(this.f22551c);
        }

        public String toString() {
            return "AeAnimator(mode=" + this.f22549a + ", easeLow=" + this.f22550b + ", easeHigh=" + this.f22551c + ')';
        }

        public C0327a(int r10, float r11, float r12) {
            super(null);
            this.f22549a = r10;
            this.f22550b = r11;
            this.f22551c = r12;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f22552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f22553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f22554c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f22555d;

        public b(float r10, float r11, float r12, float r13) {
            super(null);
            this.f22552a = r10;
            this.f22553b = r11;
            this.f22554c = r12;
            this.f22555d = r13;
        }

        public final float a() {
            return this.f22552a;
        }

        public final float b() {
            return this.f22554c;
        }

        public final float c() {
            return this.f22553b;
        }

        public final float d() {
            return this.f22555d;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (q.b(Float.valueOf(this.f22552a), Float.valueOf(r11.f22552a)) == true) goto L12;
            return false;
        L12:
            if (q.b(Float.valueOf(this.f22553b), Float.valueOf(r11.f22553b)) == true) goto L15;
            return false;
        L15:
            if (q.b(Float.valueOf(this.f22554c), Float.valueOf(r11.f22554c)) == true) goto L18;
            return false;
        L18:
            if (q.b(Float.valueOf(this.f22555d), Float.valueOf(r11.f22555d)) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.f22552a) * 31) + Float.hashCode(this.f22553b)) * 31) + Float.hashCode(this.f22554c)) * 31) + Float.hashCode(this.f22555d);
        }

        public String toString() {
            return "CubicBezier(x1=" + this.f22552a + ", y1=" + this.f22553b + ", x2=" + this.f22554c + ", y2=" + this.f22555d + ')';
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f22556a = null;

        static {
            f22556a = new c();
        }

        public c() {
            super(null);
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker r10) {
        this();
    }

    public a() {
    }
}
