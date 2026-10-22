package c19;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f22088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f22089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f22090c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f22091d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float[] f22092e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<j> f22093f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f22094g;

        public a(float r100, float r101, float r102, float r103, float[] r104, List r105) {
            Intrinsics.checkNotNullParameter(r104, "transform");
            Intrinsics.checkNotNullParameter(r105, "stops");
            this.f22088a = r100;
            this.f22089b = r101;
            this.f22090c = r102;
            this.f22091d = r103;
            this.f22092e = r104;
            this.f22093f = r105;
            this.f22094g = 1.0f;
        }
    }

    public static final class b extends d {
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f22096b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f22095a, r101.f22095a) == true) goto L12;
            return false;
        L12:
            if (Float.compare(this.f22096b, r101.f22096b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f22095a.hashCode() * 31) + Float.floatToIntBits(this.f22096b);
        }

        public final String toString() {
            return "Solid(hex=" + this.f22095a + ", alpha=" + this.f22096b + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "hex");
            this.f22095a = r100;
            this.f22096b = 1.0f;
        }
    }

    /* JADX INFO: renamed from: c19.d$d, reason: collision with other inner class name */
    public static final class C0389d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f22097a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0389d) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.f22097a, ((C0389d) r100).f22097a) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f22097a);
        }

        public final String toString() {
            return "Tint(alpha=" + this.f22097a + ')';
        }

        public C0389d() {
            this.f22097a = 1.0f;
        }
    }

    public d() {
    }
}
