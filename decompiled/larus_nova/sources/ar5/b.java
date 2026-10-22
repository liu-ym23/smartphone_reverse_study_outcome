package ar5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f16017a;

        public a() {
            this(false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f16017a == ((a) r100).f16017a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f16017a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Fallback(legacyValid=" + this.f16017a + ')';
        }

        public a(boolean r100) {
            this.f16017a = r100;
        }
    }

    /* JADX INFO: renamed from: ar5.b$b, reason: collision with other inner class name */
    public static final class C0212b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e3 f16018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f16019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f16020c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0212b) == true) goto L8;
            return false;
        L8:
            C0212b r101 = (C0212b) r100;
            if (Intrinsics.areEqual(this.f16018a, r101.f16018a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f16019b, r101.f16019b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f16020c, r101.f16020c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f16018a.hashCode() * 31) + this.f16019b.hashCode()) * 31) + this.f16020c.hashCode();
        }

        public final String toString() {
            return "Success(workspace=" + this.f16018a + ", visiblePath=" + this.f16019b + ", targetUid=" + this.f16020c + ')';
        }

        public C0212b(e3 r100, d r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "workspace");
            Intrinsics.checkNotNullParameter(r101, "visiblePath");
            Intrinsics.checkNotNullParameter(r102, "targetUid");
            this.f16018a = r100;
            this.f16019b = r101;
            this.f16020c = r102;
        }
    }

    public b() {
    }
}
