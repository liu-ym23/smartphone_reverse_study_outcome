package j9;

import f8.z;

/* loaded from: classes.dex */
public final class y extends o {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5418b = 0;

    public y(byte b10) {
        super(Byte.valueOf(b10));
    }

    @Override // j9.g
    public final v9.v a(z zVar) {
        switch (this.f5418b) {
            case 0:
                q7.k.e(zVar, "module");
                f8.e eVarD = f8.v.d(zVar, c8.m.R);
                v9.z zVarK = eVarD != null ? eVarD.k() : null;
                if (zVarK == null) {
                    return x9.i.c(x9.h.E, "UByte");
                }
                return zVarK;
            case 1:
                q7.k.e(zVar, "module");
                f8.e eVarD2 = f8.v.d(zVar, c8.m.T);
                v9.z zVarK2 = eVarD2 != null ? eVarD2.k() : null;
                if (zVarK2 == null) {
                    return x9.i.c(x9.h.E, "UInt");
                }
                return zVarK2;
            case 2:
                q7.k.e(zVar, "module");
                f8.e eVarD3 = f8.v.d(zVar, c8.m.U);
                v9.z zVarK3 = eVarD3 != null ? eVarD3.k() : null;
                if (zVarK3 == null) {
                    return x9.i.c(x9.h.E, "ULong");
                }
                return zVarK3;
            default:
                q7.k.e(zVar, "module");
                f8.e eVarD4 = f8.v.d(zVar, c8.m.S);
                v9.z zVarK4 = eVarD4 != null ? eVarD4.k() : null;
                if (zVarK4 == null) {
                    return x9.i.c(x9.h.E, "UShort");
                }
                return zVarK4;
        }
    }

    @Override // j9.g
    public final String toString() {
        switch (this.f5418b) {
            case 0:
                return ((Number) this.f5408a).intValue() + ".toUByte()";
            case 1:
                return ((Number) this.f5408a).intValue() + ".toUInt()";
            case 2:
                return ((Number) this.f5408a).longValue() + ".toULong()";
            default:
                return ((Number) this.f5408a).intValue() + ".toUShort()";
        }
    }

    public y(short s10) {
        super(Short.valueOf(s10));
    }

    public y(int i2) {
        super(Integer.valueOf(i2));
    }

    public y(long j2) {
        super(Long.valueOf(j2));
    }
}
