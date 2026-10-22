package bx5;

import cx5.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f21359a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f21359a, ((a) r100).f21359a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f21359a.hashCode();
        }

        public final String toString() {
            return "Audio(response=" + this.f21359a + ')';
        }

        public a(g r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            this.f21359a = r100;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f21360a = null;

        static {
            f21360a = new b();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            b r101 = (b) r100;
            return true;
        }

        public final int hashCode() {
            return 278511077;
        }

        public final String toString() {
            return "Chat";
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: bx5.c$c, reason: collision with other inner class name */
    public static final class C0373c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f21361a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0373c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f21361a, ((C0373c) r100).f21361a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Boolean r100 = this.f21361a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "End(noContent=" + this.f21361a + ')';
        }

        public C0373c(Boolean r100) {
            this.f21361a = r100;
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f21362a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f21362a, ((d) r100).f21362a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f21362a.hashCode();
        }

        public final String toString() {
            return "SentenceBegin(response=" + this.f21362a + ')';
        }

        public d(g r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            this.f21362a = r100;
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final nw5.b f21363a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f21363a, ((e) r100).f21363a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            nw5.b r100 = this.f21363a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "SentenceEnd(info=" + this.f21363a + ')';
        }

        public e(nw5.b r100) {
            this.f21363a = r100;
        }
    }

    public c() {
    }
}
