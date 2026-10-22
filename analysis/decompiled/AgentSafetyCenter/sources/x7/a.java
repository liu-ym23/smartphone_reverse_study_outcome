package x7;

import java.util.Objects;
import w7.n;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f15584a;

    /* renamed from: b, reason: collision with root package name */
    public c8.a f15585b;

    /* renamed from: c, reason: collision with root package name */
    public n f15586c;

    /* renamed from: d, reason: collision with root package name */
    public c8.a f15587d;

    /* renamed from: e, reason: collision with root package name */
    public Object f15588e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15589f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return Objects.equals(this.f15587d, aVar.f15587d) && Objects.equals(this.f15585b, aVar.f15585b) && Objects.equals(this.f15584a, aVar.f15584a) && Objects.equals(this.f15586c, aVar.f15586c) && Objects.equals(this.f15588e, aVar.f15588e);
    }

    public final int hashCode() {
        return Objects.hash(this.f15587d, this.f15585b, this.f15584a, this.f15586c, this.f15588e);
    }

    public final String toString() {
        return "Annotation [evaluationPath=" + this.f15587d + ", schemaLocation=" + this.f15586c + ", instanceLocation=" + this.f15585b + ", keyword=" + this.f15584a + ", value=" + this.f15588e + "]";
    }
}
