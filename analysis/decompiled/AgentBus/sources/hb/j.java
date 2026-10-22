package hb;

import java.io.IOException;

/* loaded from: classes.dex */
public final class j extends db.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4293e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ p f4294f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4295g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f4296h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(String str, p pVar, int i2, int i10, int i11) {
        super(str, true);
        this.f4293e = i11;
        this.f4294f = pVar;
        this.f4295g = i2;
        this.f4296h = i10;
    }

    @Override // db.a
    public final long a() throws IOException {
        switch (this.f4293e) {
            case 0:
                p pVar = this.f4294f;
                try {
                    pVar.C.i(this.f4295g, this.f4296h, true);
                    return -1L;
                } catch (IOException e10) {
                    pVar.a(2, 2, e10);
                    return -1L;
                }
            case 1:
                a0 a0Var = this.f4294f.f4324p;
                int i2 = this.f4296h;
                a0Var.getClass();
                m.x.t(i2, "errorCode");
                synchronized (this.f4294f) {
                    this.f4294f.E.remove(Integer.valueOf(this.f4295g));
                }
                return -1L;
            default:
                p pVar2 = this.f4294f;
                try {
                    int i10 = this.f4295g;
                    int i11 = this.f4296h;
                    m.x.t(i11, "statusCode");
                    pVar2.C.k(i10, i11);
                    return -1L;
                } catch (IOException e11) {
                    pVar2.a(2, 2, e11);
                    return -1L;
                }
        }
    }
}
