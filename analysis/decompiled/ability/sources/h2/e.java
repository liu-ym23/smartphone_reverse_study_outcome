package h2;

/* loaded from: classes2.dex */
public final class e {
    public static long c;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f4556a = false;
    public final /* synthetic */ g b;

    public e(g gVar) {
        this.b = gVar;
    }

    public final void a() {
        this.f4556a = false;
        g gVar = this.b;
        gVar.f4558a++;
        g.c(gVar, false, c);
        g gVar2 = this.b;
        gVar2.i = gVar2.f4559j;
        gVar2.f4559j = "no message running";
    }
}
