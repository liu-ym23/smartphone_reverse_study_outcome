package a78;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f2059a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f2059a, ((a) r100).f2059a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f2059a.hashCode();
        }

        public final String toString() {
            return "Image(imageUris=" + this.f2059a + ')';
        }

        public a(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "imageUris");
            this.f2059a = r100;
        }
    }

    /* JADX INFO: renamed from: a78.b$b, reason: collision with other inner class name */
    public static final class C0023b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2061b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0023b) == true) goto L8;
            return false;
        L8:
            C0023b r101 = (C0023b) r100;
            if (Intrinsics.areEqual(this.f2060a, r101.f2060a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f2061b, r101.f2061b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f2060a.hashCode() * 31) + this.f2061b.hashCode();
        }

        public final String toString() {
            return "Reply(questionId=" + this.f2060a + ", withdrawContent=" + this.f2061b + ')';
        }

        public C0023b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "questionId");
            Intrinsics.checkNotNullParameter(r101, "withdrawContent");
            this.f2060a = r100;
            this.f2061b = r101;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2063b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f2062a, r101.f2062a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f2063b, r101.f2063b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f2062a.hashCode() * 31) + this.f2063b.hashCode();
        }

        public final String toString() {
            return "Round(questionId=" + this.f2062a + ", withdrawContent=" + this.f2063b + ')';
        }

        public c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "questionId");
            Intrinsics.checkNotNullParameter(r101, "withdrawContent");
            this.f2062a = r100;
            this.f2063b = r101;
        }
    }

    public b() {
    }
}
