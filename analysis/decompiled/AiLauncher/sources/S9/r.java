package S9;

import java.util.Arrays;
import java.util.Set;

/* loaded from: classes5.dex */
public interface r {
    Z9.u a(ga.c cVar, boolean z10);

    Set<String> b(ga.c cVar);

    Z9.g c(a aVar);

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final ga.b f5763a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f5764b;

        /* renamed from: c, reason: collision with root package name */
        public final Z9.g f5765c;

        public a(ga.b classId, byte[] bArr, Z9.g gVar) {
            kotlin.jvm.internal.p.i(classId, "classId");
            this.f5763a = classId;
            this.f5764b = bArr;
            this.f5765c = gVar;
        }

        public final ga.b a() {
            return this.f5763a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.p.d(this.f5763a, aVar.f5763a) && kotlin.jvm.internal.p.d(this.f5764b, aVar.f5764b) && kotlin.jvm.internal.p.d(this.f5765c, aVar.f5765c);
        }

        public int hashCode() {
            int iHashCode = this.f5763a.hashCode() * 31;
            byte[] bArr = this.f5764b;
            int iHashCode2 = (iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            Z9.g gVar = this.f5765c;
            return iHashCode2 + (gVar != null ? gVar.hashCode() : 0);
        }

        public String toString() {
            return "Request(classId=" + this.f5763a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.f5764b) + ", outerClass=" + this.f5765c + ')';
        }

        public /* synthetic */ a(ga.b bVar, byte[] bArr, Z9.g gVar, int i10, kotlin.jvm.internal.i iVar) {
            this(bVar, (i10 & 2) != 0 ? null : bArr, (i10 & 4) != 0 ? null : gVar);
        }
    }
}
