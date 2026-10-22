package D9;

import C9.AbstractC0200b;
import g1.AbstractC1451a;

/* loaded from: classes4.dex */
public final class i extends A9.a {

    /* renamed from: a, reason: collision with root package name */
    public final t f439a;
    public final E9.e b;

    public i(t tVar, AbstractC0200b json) {
        kotlin.jvm.internal.k.f(json, "json");
        this.f439a = tVar;
        this.b = json.b;
    }

    @Override // A9.a, A9.e
    public final byte decodeByte() {
        C7.h hVar;
        t tVar = this.f439a;
        String strK = tVar.k();
        try {
            kotlin.jvm.internal.k.f(strK, "<this>");
            C7.k kVarV = AbstractC1451a.V(strK);
            if (kVarV != null) {
                int i = kVarV.f310a;
                hVar = Integer.compareUnsigned(i, 255) > 0 ? null : new C7.h((byte) i);
            }
            if (hVar != null) {
                return hVar.f307a;
            }
            j9.t.Y(strK);
            throw null;
        } catch (IllegalArgumentException unused) {
            t.o(tVar, androidx.compose.foundation.b.m('\'', "Failed to parse type 'UByte' for input '", strK), 0, null, 6);
            throw null;
        }
    }

    @Override // A9.c
    public final int decodeElementIndex(z9.g descriptor) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        throw new IllegalStateException("unsupported");
    }

    @Override // A9.a, A9.e
    public final int decodeInt() {
        t tVar = this.f439a;
        String strK = tVar.k();
        try {
            kotlin.jvm.internal.k.f(strK, "<this>");
            C7.k kVarV = AbstractC1451a.V(strK);
            if (kVarV != null) {
                return kVarV.f310a;
            }
            j9.t.Y(strK);
            throw null;
        } catch (IllegalArgumentException unused) {
            t.o(tVar, androidx.compose.foundation.b.m('\'', "Failed to parse type 'UInt' for input '", strK), 0, null, 6);
            throw null;
        }
    }

    @Override // A9.a, A9.e
    public final long decodeLong() {
        t tVar = this.f439a;
        String strK = tVar.k();
        try {
            kotlin.jvm.internal.k.f(strK, "<this>");
            C7.m mVarW = AbstractC1451a.W(strK);
            if (mVarW != null) {
                return mVarW.f312a;
            }
            j9.t.Y(strK);
            throw null;
        } catch (IllegalArgumentException unused) {
            t.o(tVar, androidx.compose.foundation.b.m('\'', "Failed to parse type 'ULong' for input '", strK), 0, null, 6);
            throw null;
        }
    }

    @Override // A9.a, A9.e
    public final short decodeShort() {
        C7.p pVar;
        t tVar = this.f439a;
        String strK = tVar.k();
        try {
            kotlin.jvm.internal.k.f(strK, "<this>");
            C7.k kVarV = AbstractC1451a.V(strK);
            if (kVarV != null) {
                int i = kVarV.f310a;
                pVar = Integer.compareUnsigned(i, 65535) > 0 ? null : new C7.p((short) i);
            }
            if (pVar != null) {
                return pVar.f315a;
            }
            j9.t.Y(strK);
            throw null;
        } catch (IllegalArgumentException unused) {
            t.o(tVar, androidx.compose.foundation.b.m('\'', "Failed to parse type 'UShort' for input '", strK), 0, null, 6);
            throw null;
        }
    }

    @Override // A9.c
    public final E9.e getSerializersModule() {
        return this.b;
    }
}
