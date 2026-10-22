package v3;

import java.util.Objects;
import u3.j;

/* renamed from: v3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2057a {

    /* renamed from: a, reason: collision with root package name */
    public final String f6768a;
    public final A3.a b;
    public final j c;
    public final A3.a d;
    public final Object e;
    public boolean f = true;

    public C2057a(String str, A3.a aVar, j jVar, A3.a aVar2, Object obj) {
        this.f6768a = str;
        this.b = aVar;
        this.c = jVar;
        this.d = aVar2;
        this.e = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2057a.class != obj.getClass()) {
            return false;
        }
        C2057a c2057a = (C2057a) obj;
        return Objects.equals(this.d, c2057a.d) && Objects.equals(this.b, c2057a.b) && Objects.equals(this.f6768a, c2057a.f6768a) && Objects.equals(this.c, c2057a.c) && Objects.equals(this.e, c2057a.e);
    }

    public final int hashCode() {
        return Objects.hash(this.d, this.b, this.f6768a, this.c, this.e);
    }

    public final String toString() {
        return "Annotation [evaluationPath=" + this.d + ", schemaLocation=" + this.c + ", instanceLocation=" + this.b + ", keyword=" + this.f6768a + ", value=" + this.e + "]";
    }
}
