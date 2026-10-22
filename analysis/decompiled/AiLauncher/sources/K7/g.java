package K7;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public String f4115a;

    /* renamed from: b, reason: collision with root package name */
    public int f4116b;

    /* renamed from: c, reason: collision with root package name */
    public long f4117c = System.currentTimeMillis() + 86400000;

    public g(String str, int i10) {
        this.f4115a = str;
        this.f4116b = i10;
    }

    public String toString() {
        return "ValueData{value='" + this.f4115a + "', code=" + this.f4116b + ", expired=" + this.f4117c + '}';
    }
}
