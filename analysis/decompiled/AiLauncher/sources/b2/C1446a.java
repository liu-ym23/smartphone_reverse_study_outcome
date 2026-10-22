package b2;

import com.google.android.datatransport.Priority;

/* renamed from: b2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1446a<T> extends c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f15246a;

    /* renamed from: b, reason: collision with root package name */
    public final T f15247b;

    /* renamed from: c, reason: collision with root package name */
    public final Priority f15248c;

    public C1446a(Integer num, T t10, Priority priority) {
        this.f15246a = num;
        if (t10 == null) {
            throw new NullPointerException("Null payload");
        }
        this.f15247b = t10;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        this.f15248c = priority;
    }

    @Override // b2.c
    public Integer a() {
        return this.f15246a;
    }

    @Override // b2.c
    public T b() {
        return this.f15247b;
    }

    @Override // b2.c
    public Priority c() {
        return this.f15248c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            Integer num = this.f15246a;
            if (num != null ? num.equals(cVar.a()) : cVar.a() == null) {
                if (this.f15247b.equals(cVar.b()) && this.f15248c.equals(cVar.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f15246a;
        return this.f15248c.hashCode() ^ (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f15247b.hashCode()) * 1000003);
    }

    public String toString() {
        return "Event{code=" + this.f15246a + ", payload=" + this.f15247b + ", priority=" + this.f15248c + "}";
    }
}
