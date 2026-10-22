package K1;

/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public final w f4072a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4073b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f4074c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4075d;

    public w(w wVar, Object obj, Object obj2, int i10) {
        this.f4072a = wVar;
        this.f4073b = obj;
        this.f4074c = obj2;
        this.f4075d = i10;
    }

    public String toString() {
        if (this.f4072a == null) {
            return "$";
        }
        if (!(this.f4074c instanceof Integer)) {
            return this.f4072a.toString() + "." + this.f4074c;
        }
        return this.f4072a.toString() + "[" + this.f4074c + "]";
    }
}
