package w3;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import com.networknt.schema.SpecificationVersion;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: w3.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2097b {
    public static final InterfaceC0315b g = AbstractC0317d.b(C2097b.class);

    /* renamed from: a, reason: collision with root package name */
    public final String f6840a;
    public final String b;
    public final HashMap c;
    public final Map d;
    public final SpecificationVersion e;
    public final M9.f f;

    public C2097b(String str, String str2, HashMap map, HashMap map2, SpecificationVersion specificationVersion, M9.f fVar) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("dialect id must not be null or blank");
        }
        if (str2 == null || str2.trim().isEmpty()) {
            throw new IllegalArgumentException("idKeyword must not be null or blank");
        }
        this.f6840a = str;
        this.b = str2;
        this.c = map;
        this.e = specificationVersion;
        this.d = map2;
        this.f = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C2097b.class == obj.getClass()) {
            return Objects.equals(this.f6840a, ((C2097b) obj).f6840a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6840a.hashCode();
    }

    public final String toString() {
        return this.f6840a;
    }
}
