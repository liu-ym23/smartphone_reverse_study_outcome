package f8;

/* loaded from: classes.dex */
public abstract class e1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f3475a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3476b;

    public e1(String str, boolean z4) {
        this.f3475a = str;
        this.f3476b = z4;
    }

    public Integer a(e1 e1Var) {
        q7.k.e(e1Var, "visibility");
        e7.g gVar = d1.f3474a;
        if (this == e1Var) {
            return 0;
        }
        e7.g gVar2 = d1.f3474a;
        Integer num = (Integer) gVar2.get(this);
        Integer num2 = (Integer) gVar2.get(e1Var);
        if (num == null || num2 == null || num.equals(num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public String b() {
        return this.f3475a;
    }

    public e1 c() {
        return this;
    }

    public final String toString() {
        return b();
    }
}
