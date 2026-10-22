package od;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f22570a;

        public a(float r10) {
            super(null);
            this.f22570a = r10;
        }

        public final float a() {
            return this.f22570a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L9;
            return false;
        L9:
            if (q.b(Float.valueOf(this.f22570a), Float.valueOf(((a) r10).f22570a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.f22570a);
        }

        public String toString() {
            return "DimensionDp(value=" + this.f22570a + ')';
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f22571a;

        public b(float r10) {
            super(null);
            this.f22571a = r10;
        }

        public final float a() {
            return this.f22571a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L9;
            return false;
        L9:
            if (q.b(Float.valueOf(this.f22571a), Float.valueOf(((b) r10).f22571a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.f22571a);
        }

        public String toString() {
            return "FloatValue(value=" + this.f22571a + ')';
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f22572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f22573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f22574c;

        public c(d r10, d r11, float r12) {
            q.g(r10, "from");
            q.g(r11, "to");
            super(null);
            this.f22572a = r10;
            this.f22573b = r11;
            this.f22574c = r12;
        }

        public final d a() {
            return this.f22572a;
        }

        public final float b() {
            return this.f22574c;
        }

        public final d c() {
            return this.f22573b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (q.b(this.f22572a, r11.f22572a) == true) goto L12;
            return false;
        L12:
            if (q.b(this.f22573b, r11.f22573b) == true) goto L15;
            return false;
        L15:
            if (q.b(Float.valueOf(this.f22574c), Float.valueOf(r11.f22574c)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f22572a.hashCode() * 31) + this.f22573b.hashCode()) * 31) + Float.hashCode(this.f22574c);
        }

        public String toString() {
            return "InterpolatedDimension(from=" + this.f22572a + ", to=" + this.f22573b + ", progress=" + this.f22574c + ')';
        }
    }

    /* JADX INFO: renamed from: od.d$d, reason: collision with other inner class name */
    public static final class C0329d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f22575a;

        public C0329d(float r10) {
            super(null);
            this.f22575a = r10;
        }

        public final float a() {
            return this.f22575a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0329d) == true) goto L9;
            return false;
        L9:
            if (q.b(Float.valueOf(this.f22575a), Float.valueOf(((C0329d) r10).f22575a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.f22575a);
        }

        public String toString() {
            return "TextWidthRatio(ratio=" + this.f22575a + ')';
        }
    }

    public /* synthetic */ d(DefaultConstructorMarker r10) {
        this();
    }

    public d() {
    }
}
