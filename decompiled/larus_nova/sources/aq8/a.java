package aq8;

import com.larus.bmhome.actionbar.model.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class a {

    /* JADX INFO: renamed from: aq8.a$a, reason: collision with other inner class name */
    public static final class C0208a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f15920a;

        public C0208a() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0208a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f15920a, ((C0208a) r100).f15920a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Throwable r100 = this.f15920a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Error(throwable=" + this.f15920a + ')';
        }

        public C0208a(Throwable r100) {
            this.f15920a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f15921a = null;

        static {
            f15921a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x0 f15922a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f15922a, ((c) r100).f15922a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f15922a.hashCode();
        }

        public final String toString() {
            return "Success(result=" + this.f15922a + ')';
        }

        public c(x0 r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.f15922a = r100;
        }
    }

    public a() {
    }
}
