package N2;

/* loaded from: classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    public String f4229a;

    /* renamed from: b, reason: collision with root package name */
    public int f4230b;

    /* renamed from: c, reason: collision with root package name */
    public long f4231c = System.currentTimeMillis() + 86400000;

    public d(String str, int i5) {
        this.f4229a = str;
        this.f4230b = i5;
    }

    public String toString() {
        return "ValueData{value='" + this.f4229a + "', code=" + this.f4230b + ", expired=" + this.f4231c + '}';
    }
}
