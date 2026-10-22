package hb;

import java.io.IOException;

/* loaded from: classes.dex */
public final class l extends db.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ p f4300e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4301f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ob.h f4302g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f4303h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, p pVar, int i2, ob.h hVar, int i10, boolean z4) {
        super(str, true);
        this.f4300e = pVar;
        this.f4301f = i2;
        this.f4302g = hVar;
        this.f4303h = i10;
    }

    @Override // db.a
    public final long a() {
        try {
            a0 a0Var = this.f4300e.f4324p;
            ob.h hVar = this.f4302g;
            int i2 = this.f4303h;
            a0Var.getClass();
            hVar.skip(i2);
            this.f4300e.C.k(this.f4301f, 9);
            synchronized (this.f4300e) {
                this.f4300e.E.remove(Integer.valueOf(this.f4301f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
