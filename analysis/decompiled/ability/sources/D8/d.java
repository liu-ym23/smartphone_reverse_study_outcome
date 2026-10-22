package D8;

/* loaded from: classes4.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f408a;
    public final int b;

    public d(int i, int i6) {
        this.f408a = i;
        this.b = i6;
    }

    public static b a(d dVar) {
        return new b(dVar.f408a + dVar.b, 1);
    }

    public static b b() {
        return new b(0, 1);
    }
}
