package Tb;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public int f5922b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f5921a = new StringBuilder();

    public void a(CharSequence charSequence) {
        if (this.f5922b != 0) {
            this.f5921a.append('\n');
        }
        this.f5921a.append(charSequence);
        this.f5922b++;
    }

    public String b() {
        return this.f5921a.toString();
    }
}
