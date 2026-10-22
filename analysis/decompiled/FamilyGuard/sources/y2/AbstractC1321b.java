package y2;

import android.content.Context;

/* renamed from: y2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1321b extends AbstractC1322c implements h {

    /* renamed from: c, reason: collision with root package name */
    private g[] f23914c;

    /* renamed from: d, reason: collision with root package name */
    private j f23915d;

    /* renamed from: e, reason: collision with root package name */
    private z2.e f23916e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f23917f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f23918g;

    public AbstractC1321b(Context context, z2.e eVar) {
        super(context);
        this.f23917f = true;
        this.f23916e = eVar;
        this.f23918g = context;
    }

    @Override // y2.i
    public void a(z2.f fVar) {
        this.f23916e.a(fVar);
        z2.e eVarH = h();
        if (eVarH != null) {
            if (this.f23914c == null) {
                this.f23914c = eVarH.e(this.f23918g);
                return;
            }
            int iC = eVarH.c();
            int iB = eVarH.b().b();
            int i5 = 0;
            int i6 = iB;
            while (i6 < iB + iC) {
                eVarH.d(this.f23918g, i6, this.f23914c[i5]);
                i6++;
                i5++;
            }
        }
    }

    @Override // y2.h
    public z2.f b() {
        return this.f23916e.b();
    }

    @Override // y2.AbstractC1322c, y2.i
    public boolean e() {
        return this.f23917f;
    }

    @Override // y2.h
    public g[] f() {
        return this.f23914c;
    }

    @Override // y2.h
    public z2.e h() {
        return this.f23916e;
    }

    @Override // y2.h
    public j i() {
        return this.f23915d;
    }

    @Override // y2.h
    public void k(z2.e eVar) {
        this.f23916e = eVar;
    }

    public void m(j jVar) {
        this.f23915d = jVar;
    }
}
