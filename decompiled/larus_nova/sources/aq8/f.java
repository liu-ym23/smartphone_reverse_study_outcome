package aq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class f {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f15951b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f15950a == r101.f15950a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f15951b, r101.f15951b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f15950a * 31) + this.f15951b.hashCode();
        }

        public final String toString() {
            return "Failure(code=" + this.f15950a + ", message=" + this.f15951b + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f15950a = -1;
            this.f15951b = r100;
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f15952a = null;

        static {
            f15952a = new b();
        }

        public b() {
        }
    }

    public static final class c extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f15953a;

        public c() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f15953a, ((c) r100).f15953a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Object r100 = this.f15953a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.f15953a + ')';
        }

        public c(Object r100) {
            this.f15953a = r100;
        }
    }

    public f() {
    }
}
