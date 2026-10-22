package Wb;

/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final b f6800a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6801b;

    public b(b bVar) {
        this.f6800a = bVar;
        if (bVar == null) {
            this.f6801b = "";
            return;
        }
        this.f6801b = bVar.f6801b + "   ";
    }

    public String a() {
        return this.f6801b;
    }

    public b b() {
        return this.f6800a;
    }
}
