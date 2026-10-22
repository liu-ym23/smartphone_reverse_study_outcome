package d2;

import java.util.List;

/* renamed from: d2.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3945c extends AbstractC3949g {

    /* renamed from: a, reason: collision with root package name */
    public final List<AbstractC3951i> f32076a;

    public C3945c(List<AbstractC3951i> list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.f32076a = list;
    }

    @Override // d2.AbstractC3949g
    public List<AbstractC3951i> c() {
        return this.f32076a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC3949g) {
            return this.f32076a.equals(((AbstractC3949g) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f32076a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f32076a + "}";
    }
}
