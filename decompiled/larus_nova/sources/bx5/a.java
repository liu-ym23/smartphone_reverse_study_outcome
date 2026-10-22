package bx5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {

    /* JADX INFO: renamed from: bx5.a$a, reason: collision with other inner class name */
    public static final class C0371a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f21352b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0371a) == true) goto L8;
            return false;
        L8:
            C0371a r101 = (C0371a) r100;
            if (Intrinsics.areEqual(this.f21351a, r101.f21351a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f21352b, r101.f21352b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f21351a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f21352b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Ended(taskId=" + this.f21351a + ", sessionId=" + this.f21352b + ')';
        }

        public C0371a(String r100, String r101) {
            this.f21351a = r100;
            this.f21352b = r101;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f21354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final cx5.c f21355c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f21353a, r101.f21353a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f21354b, r101.f21354b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f21355c, r101.f21355c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f21353a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f21354b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return ((r103 + r101) * 31) + this.f21355c.hashCode();
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Response(taskId=" + this.f21353a + ", sessionId=" + this.f21354b + ", response=" + this.f21355c + ')';
        }

        public b(String r100, String r101, cx5.c r102) {
            Intrinsics.checkNotNullParameter(r102, "response");
            this.f21353a = r100;
            this.f21354b = r101;
            this.f21355c = r102;
        }
    }

    public a() {
    }
}
