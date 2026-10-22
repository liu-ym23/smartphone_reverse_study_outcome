package kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u00012\u00060\u0004j\u0002`\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/Triple;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Triple<A, B, C> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f4891a;
    public final Object b;
    public final Object c;

    public Triple(Object obj, Object obj2, Object obj3) {
        this.f4891a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return k.b(this.f4891a, triple.f4891a) && k.b(this.b, triple.b) && k.b(this.c, triple.c);
    }

    public final int hashCode() {
        Object obj = this.f4891a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.c;
        return iHashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.f4891a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        return androidx.compose.foundation.b.t(sb, this.c, ')');
    }
}
