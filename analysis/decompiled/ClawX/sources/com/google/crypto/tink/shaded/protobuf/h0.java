package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h0 extends i0 {
    @Override // com.google.crypto.tink.shaded.protobuf.i0
    public final void a(Object obj, long j4) {
        ((b) ((z) n1.f1499c.i(obj, j4))).f1433a = false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.i0
    public final void b(long j4, Object obj, Object obj2) {
        m1 m1Var = n1.f1499c;
        z zVarA = (z) m1Var.i(obj, j4);
        z zVar = (z) m1Var.i(obj2, j4);
        int size = zVarA.size();
        int size2 = zVar.size();
        if (size > 0 && size2 > 0) {
            if (!((b) zVarA).f1433a) {
                zVarA = zVarA.a(size2 + size);
            }
            zVarA.addAll(zVar);
        }
        if (size > 0) {
            zVar = zVarA;
        }
        n1.p(j4, obj, zVar);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.i0
    public final List c(Object obj, long j4) {
        z zVar = (z) n1.f1499c.i(obj, j4);
        if (((b) zVar).f1433a) {
            return zVar;
        }
        int size = zVar.size();
        z zVarA = zVar.a(size == 0 ? 10 : size * 2);
        n1.p(j4, obj, zVarA);
        return zVarA;
    }
}
