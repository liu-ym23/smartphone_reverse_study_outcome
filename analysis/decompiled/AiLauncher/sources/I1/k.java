package I1;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public Object f3326a;

    /* renamed from: b, reason: collision with root package name */
    public final k f3327b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f3328c;

    /* renamed from: d, reason: collision with root package name */
    public Type f3329d;

    /* renamed from: e, reason: collision with root package name */
    public transient String f3330e;

    public k(k kVar, Object obj, Object obj2) {
        this.f3327b = kVar;
        this.f3326a = obj;
        this.f3328c = obj2;
    }

    public String toString() {
        if (this.f3330e == null) {
            if (this.f3327b == null) {
                this.f3330e = "$";
            } else if (this.f3328c instanceof Integer) {
                this.f3330e = this.f3327b.toString() + "[" + this.f3328c + "]";
            } else {
                this.f3330e = this.f3327b.toString() + "." + this.f3328c;
            }
        }
        return this.f3330e;
    }
}
