package vc;

import androidx.datastore.preferences.protobuf.b1;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g extends sc.a {

    /* renamed from: a, reason: collision with root package name */
    public final m f13499a;

    public g(m mVar, uc.a json) {
        kotlin.jvm.internal.g.f(json, "json");
        this.f13499a = mVar;
        androidx.datastore.preferences.protobuf.f fVar = json.f13195b;
    }

    @Override // sc.a, sc.d
    public final byte A() {
        lb.e eVar;
        m mVar = this.f13499a;
        String strJ = mVar.j();
        try {
            kotlin.jvm.internal.g.f(strJ, "<this>");
            lb.g gVarX = b1.X(strJ);
            if (gVarX != null) {
                int i10 = gVarX.f10400a;
                eVar = Integer.compareUnsigned(i10, 255) > 0 ? null : new lb.e((byte) i10);
            }
            if (eVar != null) {
                return eVar.f10396a;
            }
            gc.n.b0(strJ);
            throw null;
        } catch (IllegalArgumentException unused) {
            m.n(mVar, "Failed to parse type 'UByte' for input '" + strJ + '\'', 0, 6);
            throw null;
        }
    }

    @Override // sc.b
    public final int f(rc.e descriptor) {
        kotlin.jvm.internal.g.f(descriptor, "descriptor");
        throw new IllegalStateException("unsupported");
    }

    @Override // sc.a, sc.d
    public final int h() {
        m mVar = this.f13499a;
        String strJ = mVar.j();
        try {
            kotlin.jvm.internal.g.f(strJ, "<this>");
            lb.g gVarX = b1.X(strJ);
            if (gVarX != null) {
                return gVarX.f10400a;
            }
            gc.n.b0(strJ);
            throw null;
        } catch (IllegalArgumentException unused) {
            m.n(mVar, "Failed to parse type 'UInt' for input '" + strJ + '\'', 0, 6);
            throw null;
        }
    }

    @Override // sc.a, sc.d
    public final long j() {
        m mVar = this.f13499a;
        String strJ = mVar.j();
        try {
            kotlin.jvm.internal.g.f(strJ, "<this>");
            lb.i iVarY = b1.Y(strJ);
            if (iVarY != null) {
                return iVarY.f10404a;
            }
            gc.n.b0(strJ);
            throw null;
        } catch (IllegalArgumentException unused) {
            m.n(mVar, "Failed to parse type 'ULong' for input '" + strJ + '\'', 0, 6);
            throw null;
        }
    }

    @Override // sc.a, sc.d
    public final short l() {
        lb.l lVar;
        m mVar = this.f13499a;
        String strJ = mVar.j();
        try {
            kotlin.jvm.internal.g.f(strJ, "<this>");
            lb.g gVarX = b1.X(strJ);
            if (gVarX != null) {
                int i10 = gVarX.f10400a;
                lVar = Integer.compareUnsigned(i10, 65535) > 0 ? null : new lb.l((short) i10);
            }
            if (lVar != null) {
                return lVar.f10409a;
            }
            gc.n.b0(strJ);
            throw null;
        } catch (IllegalArgumentException unused) {
            m.n(mVar, "Failed to parse type 'UShort' for input '" + strJ + '\'', 0, 6);
            throw null;
        }
    }
}
