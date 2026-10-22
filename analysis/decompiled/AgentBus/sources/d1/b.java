package d1;

import d7.m;
import i5.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import k.t;
import n.f0;
import n.i;
import n.i1;
import n.n;
import n.u;
import n.y;
import q7.k;

/* loaded from: classes.dex */
public final class b implements i1 {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2766f;

    /* renamed from: g, reason: collision with root package name */
    public int f2767g;

    /* renamed from: h, reason: collision with root package name */
    public Object f2768h;

    public /* synthetic */ b(int i2, int i10, Object obj) {
        this.f2766f = i10;
        this.f2768h = obj;
        this.f2767g = i2;
    }

    public void b(long j2) {
        if (e(j2)) {
            return;
        }
        int i2 = this.f2767g;
        long[] jArrCopyOf = (long[]) this.f2768h;
        if (i2 >= jArrCopyOf.length) {
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, Math.max(i2 + 1, jArrCopyOf.length * 2));
            k.d(jArrCopyOf, "copyOf(...)");
            this.f2768h = jArrCopyOf;
        }
        jArrCopyOf[i2] = j2;
        if (i2 >= this.f2767g) {
            this.f2767g = i2 + 1;
        }
    }

    public f0 d(Float f10, int i2) {
        f0 f0Var = new f0(f10, u.f6737b);
        ((t) this.f2768h).g(i2, f0Var);
        return f0Var;
    }

    public boolean e(long j2) {
        int i2 = this.f2767g;
        for (int i10 = 0; i10 < i2; i10++) {
            if (((long[]) this.f2768h)[i10] == j2) {
                return true;
            }
        }
        return false;
    }

    public void f(int i2, int i10) {
        int i11 = i10 + i2;
        char[] cArr = (char[]) this.f2768h;
        if (cArr.length <= i11) {
            int i12 = i2 * 2;
            if (i11 < i12) {
                i11 = i12;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i11);
            k.d(cArrCopyOf, "copyOf(...)");
            this.f2768h = cArrCopyOf;
        }
    }

    public boolean g() {
        return this.f2767g < ((ArrayList) this.f2768h).size();
    }

    public void h() {
        ya.b bVar = ya.b.f11731c;
        char[] cArr = (char[]) this.f2768h;
        bVar.getClass();
        k.e(cArr, "array");
        synchronized (bVar) {
            int i2 = bVar.f881a;
            if (cArr.length + i2 < ya.a.f11730a) {
                bVar.f881a = i2 + cArr.length;
                ((m) bVar.f882b).addLast(cArr);
            }
        }
    }

    public void i(long j2) {
        int i2 = this.f2767g;
        int i10 = 0;
        while (i10 < i2) {
            if (j2 == ((long[]) this.f2768h)[i10]) {
                int i11 = this.f2767g - 1;
                while (i10 < i11) {
                    long[] jArr = (long[]) this.f2768h;
                    int i12 = i10 + 1;
                    jArr[i10] = jArr[i12];
                    i10 = i12;
                }
                this.f2767g--;
                return;
            }
            i10++;
        }
    }

    public void j(String str) {
        k.e(str, "text");
        int length = str.length();
        if (length == 0) {
            return;
        }
        f(this.f2767g, length);
        str.getChars(0, str.length(), (char[]) this.f2768h, this.f2767g);
        this.f2767g += length;
    }

    @Override // n.i1
    public int m() {
        return 0;
    }

    @Override // n.h1
    public n r(long j2, n nVar, n nVar2, n nVar3) {
        return ((f) this.f2768h).r(j2, nVar, nVar2, nVar3);
    }

    @Override // n.h1
    public n s(long j2, n nVar, n nVar2, n nVar3) {
        return ((f) this.f2768h).s(j2, nVar, nVar2, nVar3);
    }

    public String toString() {
        switch (this.f2766f) {
            case 4:
                StringBuilder sb2 = new StringBuilder("AnimationResult(endReason=");
                int i2 = this.f2767g;
                sb2.append(i2 != 1 ? i2 != 2 ? "null" : "Finished" : "BoundReached");
                sb2.append(", endState=");
                sb2.append((i) this.f2768h);
                sb2.append(')');
                return sb2.toString();
            case 8:
                return new String((char[]) this.f2768h, 0, this.f2767g);
            default:
                return super.toString();
        }
    }

    @Override // n.i1
    public int v() {
        return this.f2767g;
    }

    public /* synthetic */ b(int i2, boolean z4) {
        this.f2766f = i2;
    }

    public b(int i2, ArrayList arrayList) {
        this.f2766f = i2;
        switch (i2) {
            case 3:
                this.f2767g = 0;
                this.f2768h = arrayList;
                break;
            default:
                this.f2768h = arrayList;
                break;
        }
    }

    public b(int i2) {
        this.f2766f = i2;
        switch (i2) {
            case 5:
                this.f2767g = 300;
                t tVar = k.k.f5504a;
                this.f2768h = new t();
                break;
            default:
                this.f2767g = 1;
                this.f2768h = Collections.singletonList(null);
                break;
        }
    }

    public b(int i2, n.t tVar) {
        this.f2766f = 6;
        this.f2767g = i2;
        this.f2768h = new f(new y(i2, tVar));
    }
}
