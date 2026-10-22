package f8;

/* loaded from: classes4.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public final G8.c f4445a;
    public final String b;

    public j(G8.c packageFqName, String str) {
        kotlin.jvm.internal.k.f(packageFqName, "packageFqName");
        this.f4445a = packageFqName;
        this.b = str;
    }

    public final G8.f a(int i) {
        return G8.f.e(this.b + i);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4445a);
        sb.append('.');
        return B7.a.g('N', this.b, sb);
    }
}
