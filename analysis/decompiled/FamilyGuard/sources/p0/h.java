package p0;

import java.lang.reflect.Type;
import java.util.Arrays;
import o0.C0888a;
import o0.EnumC0889b;
import o0.InterfaceC0890c;

/* loaded from: classes.dex */
public class h implements t {

    /* renamed from: a, reason: collision with root package name */
    protected final Class<?> f19299a;

    /* renamed from: b, reason: collision with root package name */
    protected final Enum[] f19300b;

    /* renamed from: c, reason: collision with root package name */
    protected final Enum[] f19301c;

    /* renamed from: d, reason: collision with root package name */
    protected long[] f19302d;

    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(java.lang.Class<?> r22) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.h.<init>(java.lang.Class):void");
    }

    public Enum b(long j5) {
        int iBinarySearch;
        if (this.f19300b != null && (iBinarySearch = Arrays.binarySearch(this.f19302d, j5)) >= 0) {
            return this.f19300b[iBinarySearch];
        }
        return null;
    }

    public Enum<?> c(int i5) {
        return this.f19301c[i5];
    }

    @Override // p0.t
    public int d() {
        return 2;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        try {
            InterfaceC0890c interfaceC0890c = c0888a.f18948f;
            int iU = interfaceC0890c.U();
            if (iU == 2) {
                int iV = interfaceC0890c.v();
                interfaceC0890c.A(16);
                if (iV >= 0) {
                    Object[] objArr = this.f19301c;
                    if (iV < objArr.length) {
                        return (T) objArr[iV];
                    }
                }
                throw new l0.d("parse enum " + this.f19299a.getName() + " error, value : " + iV);
            }
            if (iU != 4) {
                if (iU == 8) {
                    interfaceC0890c.A(16);
                    return null;
                }
                throw new l0.d("parse enum " + this.f19299a.getName() + " error, value : " + c0888a.S());
            }
            String strN = interfaceC0890c.N();
            interfaceC0890c.A(16);
            if (strN.length() == 0) {
                return null;
            }
            long j5 = -3750763034362895579L;
            long j6 = -3750763034362895579L;
            for (int i5 = 0; i5 < strN.length(); i5++) {
                int iCharAt = strN.charAt(i5);
                long j7 = j5 ^ iCharAt;
                if (iCharAt >= 65 && iCharAt <= 90) {
                    iCharAt += 32;
                }
                j5 = j7 * 1099511628211L;
                j6 = (j6 ^ iCharAt) * 1099511628211L;
            }
            T t5 = (T) b(j5);
            if (t5 == null && j6 != j5) {
                t5 = (T) b(j6);
            }
            if (t5 == null && interfaceC0890c.I(EnumC0889b.ErrorOnEnumNotMatch)) {
                throw new l0.d("not match enum value, " + this.f19299a.getName() + " : " + strN);
            }
            return t5;
        } catch (l0.d e6) {
            throw e6;
        } catch (Exception e7) {
            throw new l0.d(e7.getMessage(), e7);
        }
    }
}
