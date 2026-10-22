package u5;

import android.util.SparseArray;
import b0.b3;
import java.nio.ByteBuffer;
import java.util.WeakHashMap;
import o4.f1;
import o4.g1;
import o4.h1;
import o4.t1;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public Object f10129a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10130b;

    /* renamed from: c, reason: collision with root package name */
    public Object f10131c;

    public h(int i2) {
        switch (i2) {
            case 5:
                this.f10131c = new w4.a();
                break;
            case 8:
                this.f10129a = new WeakHashMap();
                this.f10130b = new WeakHashMap();
                this.f10131c = new WeakHashMap();
                break;
            default:
                this.f10129a = new int[10];
                this.f10130b = new int[10];
                this.f10131c = new int[10];
                break;
        }
    }

    public static y4.n f(t1 t1Var, boolean z4) {
        if (t1Var == null) {
            return new y4.n(z4, "IDLE", "IDLE", null, null, null, null);
        }
        f1 f1Var = t1Var.f7597y;
        f1 f1Var2 = t1Var.f7596x;
        g1 g1Var = (g1) f1Var2.f7346c.getValue();
        g1 g1Var2 = (g1) f1Var.f7346c.getValue();
        return new y4.n(z4, ((h1) f1Var2.f7345b.getValue()).name(), ((h1) f1Var.f7345b.getValue()).name(), g1Var != null ? g1Var.f7372a : null, g1Var != null ? Long.valueOf(g1Var.f7373b) : null, g1Var2 != null ? g1Var2.f7372a : null, g1Var2 != null ? Long.valueOf(g1Var2.f7373b) : null);
    }

    public u0.l a() {
        return ((w0.b) this.f10131c).f10629f.f10627c;
    }

    public long b() {
        return ((w0.b) this.f10131c).f10629f.f10628d;
    }

    public boolean c(CharSequence charSequence, int i2, int i10, x2.q qVar) {
        if ((qVar.f11148c & 3) == 0) {
            x2.d dVar = (x2.d) this.f10131c;
            y2.a aVarB = qVar.b();
            int iA = aVarB.a(8);
            if (iA != 0) {
                ((ByteBuffer) aVarB.f3097i).getShort(iA + aVarB.f3094f);
            }
            x2.b bVar = (x2.b) dVar;
            bVar.getClass();
            ThreadLocal threadLocal = x2.b.f11106b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb2 = (StringBuilder) threadLocal.get();
            sb2.setLength(0);
            while (i2 < i10) {
                sb2.append(charSequence.charAt(i2));
                i2++;
            }
            boolean zHasGlyph = bVar.f11107a.hasGlyph(sb2.toString());
            int i11 = qVar.f11148c & 4;
            qVar.f11148c = zHasGlyph ? i11 | 2 : i11 | 1;
        }
        return (qVar.f11148c & 3) == 2;
    }

    public boolean d() {
        if (((b3) this.f10129a).getValue() != this.f10131c) {
            return true;
        }
        h hVar = (h) this.f10130b;
        return hVar != null && hVar.d();
    }

    public Object e(CharSequence charSequence, int i2, int i10, int i11, boolean z4, x2.l lVar) {
        int i12;
        char c10;
        x2.m mVar = new x2.m((x2.p) ((i5.f) this.f10130b).f4655i);
        int iCodePointAt = Character.codePointAt(charSequence, i2);
        int i13 = 0;
        boolean zF = true;
        int iCharCount = i2;
        loop0: while (true) {
            i12 = iCharCount;
            while (iCharCount < i10 && i13 < i11 && zF) {
                SparseArray sparseArray = mVar.f11127c.f11143a;
                x2.p pVar = sparseArray == null ? null : (x2.p) sparseArray.get(iCodePointAt);
                if (mVar.f11125a == 2) {
                    if (pVar != null) {
                        mVar.f11127c = pVar;
                        mVar.f11130f++;
                    } else {
                        if (iCodePointAt == 65038) {
                            mVar.a();
                        } else if (iCodePointAt != 65039) {
                            x2.p pVar2 = mVar.f11127c;
                            if (pVar2.f11144b != null) {
                                if (mVar.f11130f != 1) {
                                    mVar.f11128d = pVar2;
                                    mVar.a();
                                } else if (mVar.b()) {
                                    mVar.f11128d = mVar.f11127c;
                                    mVar.a();
                                } else {
                                    mVar.a();
                                }
                                c10 = 3;
                            } else {
                                mVar.a();
                            }
                        }
                        c10 = 1;
                    }
                    c10 = 2;
                } else if (pVar == null) {
                    mVar.a();
                    c10 = 1;
                } else {
                    mVar.f11125a = 2;
                    mVar.f11127c = pVar;
                    mVar.f11130f = 1;
                    c10 = 2;
                }
                mVar.f11129e = iCodePointAt;
                if (c10 == 1) {
                    iCharCount = Character.charCount(Character.codePointAt(charSequence, i12)) + i12;
                    if (iCharCount < i10) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                } else if (c10 == 2) {
                    int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                    if (iCharCount2 < i10) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                    }
                    iCharCount = iCharCount2;
                } else if (c10 == 3) {
                    if (z4 || !c(charSequence, i12, iCharCount, mVar.f11128d.f11144b)) {
                        zF = lVar.f(charSequence, i12, iCharCount, mVar.f11128d.f11144b);
                        i13++;
                    }
                }
            }
            break loop0;
        }
        if (mVar.f11125a == 2 && mVar.f11127c.f11144b != null && ((mVar.f11130f > 1 || mVar.b()) && i13 < i11 && zF && (z4 || !c(charSequence, i12, iCharCount, mVar.f11127c.f11144b)))) {
            lVar.f(charSequence, i12, iCharCount, mVar.f11127c.f11144b);
        }
        return lVar.getResult();
    }

    public void g(u0.l lVar) {
        ((w0.b) this.f10131c).f10629f.f10627c = lVar;
    }

    public void h(d2.c cVar) {
        ((w0.b) this.f10131c).f10629f.f10625a = cVar;
    }

    public void i(d2.l lVar) {
        ((w0.b) this.f10131c).f10629f.f10626b = lVar;
    }

    public void j(long j2) {
        ((w0.b) this.f10131c).f10629f.f10628d = j2;
    }

    public y4.o k() {
        t1 t1Var = (t1) ((v4.a) this.f10129a).c();
        t1 t1Var2 = (t1) ((v4.a) this.f10130b).c();
        return new y4.o(f(t1Var, ((Boolean) ((v4.a) this.f10131c).c()).booleanValue()), f(t1Var2, t1Var2 != null));
    }

    public h(v1.r rVar, h hVar) {
        this.f10129a = rVar;
        this.f10130b = hVar;
        this.f10131c = rVar.f10376f;
    }
}
