package bda;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface b {

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f18701b;

        public a() {
            this(null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f18700a, r101.f18700a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f18701b, r101.f18701b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f18700a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f18701b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "QueryData(content=" + this.f18700a + ", messageId=" + this.f18701b + ')';
        }

        public a(String r100, String r101) {
            this.f18700a = r100;
            this.f18701b = r101;
        }
    }

    Map<String, String> getExt(Map<String, String> r100, a r101);

    String getScene();
}
