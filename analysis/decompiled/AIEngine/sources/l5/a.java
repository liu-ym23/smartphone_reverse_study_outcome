package l5;

import java.util.Arrays;
import lb.n;
import mb.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class a implements u0.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10232a;

    /* renamed from: b, reason: collision with root package name */
    public int f10233b;

    /* renamed from: c, reason: collision with root package name */
    public Object f10234c;

    public a(int[] iArr) {
        this.f10232a = 0;
        this.f10234c = iArr;
        this.f10233b = iArr.length;
    }

    public static void h(int i10, int i11, int[] iArr) {
        int i12 = ((i10 + i11) / 2) & (-2);
        int i13 = iArr[i12];
        int i14 = iArr[i12 + 1];
        int i15 = i10;
        int i16 = i11;
        while (i15 <= i16) {
            while (i15 < i11) {
                int i17 = iArr[i15] - i13;
                if (i17 == 0) {
                    i17 = i14 - iArr[i15 + 1];
                }
                if (i17 >= 0) {
                    break;
                } else {
                    i15 += 2;
                }
            }
            while (i16 > i10) {
                int i18 = iArr[i16] - i13;
                if (i18 == 0) {
                    i18 = i14 - iArr[i16 + 1];
                }
                if (i18 <= 0) {
                    break;
                } else {
                    i16 -= 2;
                }
            }
            if (i15 <= i16) {
                if (i15 != i16) {
                    int i19 = iArr[i15];
                    iArr[i15] = iArr[i16];
                    iArr[i16] = i19;
                    int i20 = i15 + 1;
                    int i21 = iArr[i20];
                    int i22 = i16 + 1;
                    iArr[i20] = iArr[i22];
                    iArr[i22] = i21;
                }
                i15 += 2;
                i16 -= 2;
            }
        }
        if (i10 < i16) {
            h(i10, i16, iArr);
        }
        if (i15 < i11) {
            h(i15, i11, iArr);
        }
    }

    public void a(int[] iArr, int i10) {
        int i11 = 0;
        if (i10 >= 0) {
            while (i11 < iArr.length) {
                d(iArr[i11], iArr[i11 + 1]);
                i11 += 2;
            }
            return;
        }
        int i12 = 0;
        while (i11 < iArr.length) {
            int i13 = iArr[i11];
            int i14 = iArr[i11 + 1];
            int i15 = i13 - 1;
            if (i12 <= i15) {
                d(i12, i15);
            }
            i12 = i14 + 1;
            i11 += 2;
        }
        if (i12 <= 1114111) {
            d(i12, 1114111);
        }
    }

    @Override // u0.c
    public Object acquire() {
        Object[] objArr = (Object[]) this.f10234c;
        int i10 = this.f10233b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object obj = objArr[i11];
        kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        objArr[i11] = null;
        this.f10233b--;
        return obj;
    }

    public void b(int i10, int i11) {
        if (i10 <= 65 && i11 >= 66639) {
            d(i10, i11);
            return;
        }
        if (i11 < 65 || i10 > 66639) {
            d(i10, i11);
            return;
        }
        if (i10 < 65) {
            d(i10, 64);
            i10 = 65;
        }
        if (i11 > 66639) {
            d(66640, i11);
            i11 = 66639;
        }
        while (i10 <= i11) {
            d(i10, i10);
            for (int iG = jd.b.G(i10); iG != i10; iG = jd.b.G(iG)) {
                d(iG, iG);
            }
            i10++;
        }
    }

    public void c(b bVar, boolean z) {
        int[] iArrJ = bVar.f10238b;
        if (z) {
            a aVar = new a(0, (byte) 0);
            for (int i10 = 0; i10 < iArrJ.length; i10 += 2) {
                aVar.b(iArrJ[i10], iArrJ[i10 + 1]);
            }
            aVar.f();
            iArrJ = aVar.j();
        }
        a(iArrJ, bVar.f10237a);
    }

    public void d(int i10, int i11) {
        if (this.f10233b > 0) {
            for (int i12 = 2; i12 <= 4; i12 += 2) {
                int i13 = this.f10233b;
                if (i13 >= i12) {
                    int[] iArr = (int[]) this.f10234c;
                    int i14 = i13 - i12;
                    int i15 = iArr[i14];
                    int i16 = i14 + 1;
                    int i17 = iArr[i16];
                    if (i10 <= i17 + 1 && i15 <= i11 + 1) {
                        if (i10 < i15) {
                            iArr[i14] = i10;
                        }
                        if (i11 > i17) {
                            iArr[i16] = i11;
                            return;
                        }
                        return;
                    }
                }
            }
        }
        int i18 = this.f10233b;
        int i19 = i18 + 2;
        int[] iArr2 = (int[]) this.f10234c;
        if (iArr2.length < i19) {
            int i20 = i18 * 2;
            if (i19 < i20) {
                i19 = i20;
            }
            int[] iArr3 = new int[i19];
            System.arraycopy(iArr2, 0, iArr3, 0, i18);
            this.f10234c = iArr3;
        }
        int[] iArr4 = (int[]) this.f10234c;
        int i21 = this.f10233b;
        int i22 = i21 + 1;
        this.f10233b = i22;
        iArr4[i21] = i10;
        this.f10233b = i21 + 2;
        iArr4[i22] = i11;
    }

    public void e(int[][] iArr) {
        for (int[] iArr2 : iArr) {
            int i10 = iArr2[0];
            int i11 = iArr2[1];
            int i12 = iArr2[2];
            if (i12 == 1) {
                d(i10, i11);
            } else {
                while (i10 <= i11) {
                    d(i10, i10);
                    i10 += i12;
                }
            }
        }
    }

    public void f() {
        int i10 = this.f10233b;
        if (i10 < 4) {
            return;
        }
        h(0, i10 - 2, (int[]) this.f10234c);
        int i11 = 2;
        for (int i12 = 2; i12 < this.f10233b; i12 += 2) {
            int[] iArr = (int[]) this.f10234c;
            int i13 = iArr[i12];
            int i14 = iArr[i12 + 1];
            int i15 = i11 - 1;
            int i16 = iArr[i15];
            if (i13 > i16 + 1) {
                iArr[i11] = i13;
                iArr[i11 + 1] = i14;
                i11 += 2;
            } else if (i14 > i16) {
                iArr[i15] = i14;
            }
        }
        this.f10233b = i11;
    }

    public void g(int i10, int i11) {
        int i12 = i11 + i10;
        char[] cArr = (char[]) this.f10234c;
        if (cArr.length <= i12) {
            int i13 = i10 * 2;
            if (i12 < i13) {
                i12 = i13;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i12);
            kotlin.jvm.internal.g.e(cArrCopyOf, "copyOf(...)");
            this.f10234c = cArrCopyOf;
        }
    }

    public void i() {
        vc.b bVar = vc.b.f13493c;
        char[] array = (char[]) this.f10234c;
        bVar.getClass();
        kotlin.jvm.internal.g.f(array, "array");
        synchronized (bVar) {
            try {
                int i10 = bVar.f8518a;
                if (array.length + i10 < vc.a.f13492a) {
                    bVar.f8518a = i10 + array.length;
                    ((k) bVar.f8519b).addLast(array);
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int[] j() {
        int i10 = this.f10233b;
        int[] iArr = (int[]) this.f10234c;
        if (i10 == iArr.length) {
            return iArr;
        }
        int[] iArr2 = new int[i10];
        System.arraycopy(iArr, 0, iArr2, 0, i10);
        return iArr2;
    }

    public void k(String text) {
        kotlin.jvm.internal.g.f(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        g(this.f10233b, length);
        text.getChars(0, text.length(), (char[]) this.f10234c, this.f10233b);
        this.f10233b += length;
    }

    public void l(long j10) {
        k(String.valueOf(j10));
    }

    @Override // u0.c
    public boolean release(Object instance) {
        boolean z;
        Object[] objArr = (Object[]) this.f10234c;
        kotlin.jvm.internal.g.f(instance, "instance");
        int i10 = this.f10233b;
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                z = false;
                break;
            }
            if (objArr[i11] == instance) {
                z = true;
                break;
            }
            i11++;
        }
        if (z) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i12 = this.f10233b;
        if (i12 >= objArr.length) {
            return false;
        }
        objArr[i12] = instance;
        this.f10233b = i12 + 1;
        return true;
    }

    public String toString() {
        switch (this.f10232a) {
            case 0:
                int[] iArr = (int[]) this.f10234c;
                int i10 = this.f10233b;
                StringBuilder sb2 = new StringBuilder("[");
                for (int i11 = 0; i11 < i10; i11 += 2) {
                    if (i11 > 0) {
                        sb2.append(' ');
                    }
                    int i12 = iArr[i11];
                    int i13 = iArr[i11 + 1];
                    if (i12 == i13) {
                        sb2.append("0x");
                        sb2.append(Integer.toHexString(i12));
                    } else {
                        sb2.append("0x");
                        sb2.append(Integer.toHexString(i12));
                        sb2.append("-0x");
                        sb2.append(Integer.toHexString(i13));
                    }
                }
                sb2.append(']');
                return sb2.toString();
            case 1:
            default:
                return super.toString();
            case 2:
                return new String((char[]) this.f10234c, 0, this.f10233b);
        }
    }

    public a(int i10, byte b10) {
        this.f10232a = i10;
        switch (i10) {
            case 2:
                break;
            default:
                this.f10234c = j.f10341a;
                this.f10233b = 0;
                break;
        }
    }

    public a(int i10) {
        this.f10232a = 1;
        if (i10 > 0) {
            this.f10234c = new Object[i10];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }
}
