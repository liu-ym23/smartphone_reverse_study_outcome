package b49;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f17646b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f17645a == r101.f17645a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f17646b, r101.f17646b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f17645a * 31) + this.f17646b.hashCode();
        }

        public final String toString() {
            return "Failure(code=" + this.f17645a + ", message=" + this.f17646b + ')';
        }

        public a(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "message");
            this.f17645a = r100;
            this.f17646b = r101;
        }
    }

    /* JADX INFO: renamed from: b49.b$b, reason: collision with other inner class name */
    public static final class C0263b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f17647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17648b;

        public final String toString() {
            return "Success(data=" + Arrays.toString(this.f17647a) + ", retryCount=" + this.f17648b + ')';
        }

        public final int hashCode() {
            return Arrays.hashCode(this.f17647a);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(C0263b.class, r101) == true) goto L13;
            return false;
        L13:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.dora.api.model.AlbumResult.Success");
            return Arrays.equals(this.f17647a, ((C0263b) r100).f17647a);
        L8:
            r101 = null;
            goto L10
        }

        public C0263b(byte[] r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f17647a = r100;
            this.f17648b = r101;
        }
    }

    public b() {
    }
}
