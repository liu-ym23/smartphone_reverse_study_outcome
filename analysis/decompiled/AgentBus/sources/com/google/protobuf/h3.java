package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class h3 implements t3 {

    /* renamed from: a, reason: collision with root package name */
    public final MessageLite f2387a;

    /* renamed from: b, reason: collision with root package name */
    public final d4 f2388b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f2389c;

    /* renamed from: d, reason: collision with root package name */
    public final v1 f2390d;

    public h3(d4 d4Var, v1 v1Var, MessageLite messageLite) {
        this.f2388b = d4Var;
        ((w1) v1Var).getClass();
        this.f2389c = messageLite instanceof h2;
        this.f2390d = v1Var;
        this.f2387a = messageLite;
    }

    @Override // com.google.protobuf.t3
    public final void a(Object obj, Object obj2) {
        u3.l(this.f2388b, obj, obj2);
        if (this.f2389c) {
            u3.k(this.f2390d, obj, obj2);
        }
    }

    @Override // com.google.protobuf.t3
    public final void b(Object obj) {
        this.f2388b.getClass();
        c4 c4Var = ((i2) obj).unknownFields;
        if (c4Var.f2332e) {
            c4Var.f2332e = false;
        }
        ((w1) this.f2390d).getClass();
        ((h2) obj).extensions.e();
    }

    @Override // com.google.protobuf.t3
    public final boolean c(Object obj) {
        ((w1) this.f2390d).getClass();
        ((h2) obj).extensions.c();
        return true;
    }

    @Override // com.google.protobuf.t3
    public final Object d() {
        MessageLite messageLite = this.f2387a;
        return messageLite instanceof i2 ? ((i2) messageLite).k() : messageLite.newBuilderForType().buildPartial();
    }

    @Override // com.google.protobuf.t3
    public final int e(i2 i2Var) {
        this.f2388b.getClass();
        c4 c4Var = i2Var.unknownFields;
        int iQ = c4Var.f2331d;
        if (iQ == -1) {
            iQ = 0;
            for (int i2 = 0; i2 < c4Var.f2328a; i2++) {
                int i10 = c4Var.f2329b[i2] >>> 3;
                iQ += r.Q(3, (l) c4Var.f2330c[i2]) + r.V(i10) + r.U(2) + (r.U(1) * 2);
            }
            c4Var.f2331d = iQ;
        }
        if (this.f2389c) {
            ((w1) this.f2390d).getClass();
            v3 v3Var = ((h2) i2Var).extensions.f2318a;
            if (v3Var.f2591g > 0) {
                v3Var.c(0).getKey().getClass();
                throw new ClassCastException();
            }
            Iterator it = v3Var.d().iterator();
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (entry.getKey() != null) {
                    throw new ClassCastException();
                }
                entry.getValue();
                throw null;
            }
        }
        return iQ;
    }

    @Override // com.google.protobuf.t3
    public final void f(Object obj, z2 z2Var) {
        ((w1) this.f2390d).getClass();
        Iterator itD = ((h2) obj).extensions.d();
        if (itD.hasNext()) {
            ((Map.Entry) itD.next()).getKey().getClass();
            throw new ClassCastException();
        }
        this.f2388b.getClass();
        c4 c4Var = ((i2) obj).unknownFields;
        c4Var.getClass();
        z2Var.getClass();
        for (int i2 = 0; i2 < c4Var.f2328a; i2++) {
            int i10 = c4Var.f2329b[i2] >>> 3;
            Object obj2 = c4Var.f2330c[i2];
            r rVar = (r) z2Var.f2665a;
            if (obj2 instanceof l) {
                rVar.m0(i10, (l) obj2);
            } else {
                rVar.l0(i10, (MessageLite) obj2);
            }
        }
    }

    @Override // com.google.protobuf.t3
    public final boolean g(i2 i2Var, i2 i2Var2) {
        this.f2388b.getClass();
        if (!i2Var.unknownFields.equals(i2Var2.unknownFields)) {
            return false;
        }
        if (!this.f2389c) {
            return true;
        }
        w1 w1Var = (w1) this.f2390d;
        w1Var.getClass();
        b2 b2Var = ((h2) i2Var).extensions;
        w1Var.getClass();
        return b2Var.equals(((h2) i2Var2).extensions);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0083 A[EDGE_INSN: B:52:0x0083->B:29:0x0083 BREAK  A[LOOP:1: B:14:0x0049->B:55:0x0049], SYNTHETIC] */
    @Override // com.google.protobuf.t3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.protobuf.g r15) throws com.google.protobuf.r2 {
        /*
            r10 = this;
            r0 = r11
            com.google.protobuf.i2 r0 = (com.google.protobuf.i2) r0
            com.google.protobuf.c4 r1 = r0.unknownFields
            com.google.protobuf.c4 r2 = com.google.protobuf.c4.f2327f
            if (r1 != r2) goto Lf
            com.google.protobuf.c4 r1 = com.google.protobuf.c4.c()
            r0.unknownFields = r1
        Lf:
            r6 = r1
            com.google.protobuf.h2 r11 = (com.google.protobuf.h2) r11
            r11.p()
        L15:
            if (r13 >= r14) goto L8f
            int r4 = a.a.E(r12, r13, r15)
            int r2 = r15.f2354a
            com.google.protobuf.u1 r11 = r15.f2357d
            r13 = 11
            com.google.protobuf.MessageLite r0 = r10.f2387a
            com.google.protobuf.v1 r1 = r10.f2390d
            r3 = 2
            if (r2 == r13) goto L45
            r13 = r2 & 7
            if (r13 != r3) goto L3e
            int r13 = r2 >>> 3
            com.google.protobuf.w1 r1 = (com.google.protobuf.w1) r1
            r1.getClass()
            r11.a(r13, r0)
            r3 = r12
            r5 = r14
            r7 = r15
            int r13 = a.a.A(r2, r3, r4, r5, r6, r7)
            goto L15
        L3e:
            r5 = r14
            r7 = r15
            int r13 = a.a.l0(r2, r12, r4, r5, r7)
            goto L15
        L45:
            r5 = r14
            r7 = r15
            r13 = 0
            r14 = 0
        L49:
            if (r4 >= r5) goto L82
            int r15 = a.a.E(r12, r4, r7)
            int r2 = r7.f2354a
            int r4 = r2 >>> 3
            r8 = r2 & 7
            if (r4 == r3) goto L66
            r9 = 3
            if (r4 == r9) goto L5b
            goto L78
        L5b:
            if (r8 != r3) goto L78
            int r4 = a.a.q(r12, r15, r7)
            java.lang.Object r14 = r7.f2356c
            com.google.protobuf.l r14 = (com.google.protobuf.l) r14
            goto L49
        L66:
            if (r8 != 0) goto L78
            int r4 = a.a.E(r12, r15, r7)
            int r13 = r7.f2354a
            r15 = r1
            com.google.protobuf.w1 r15 = (com.google.protobuf.w1) r15
            r15.getClass()
            r11.a(r13, r0)
            goto L49
        L78:
            r4 = 12
            if (r2 != r4) goto L7d
            goto L83
        L7d:
            int r4 = a.a.l0(r2, r12, r15, r5, r7)
            goto L49
        L82:
            r15 = r4
        L83:
            if (r14 == 0) goto L8b
            int r11 = r13 << 3
            r11 = r11 | r3
            r6.d(r11, r14)
        L8b:
            r13 = r15
            r14 = r5
            r15 = r7
            goto L15
        L8f:
            r5 = r14
            if (r13 != r5) goto L93
            return
        L93:
            com.google.protobuf.r2 r10 = com.google.protobuf.r2.f()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.h3.h(java.lang.Object, byte[], int, int, com.google.protobuf.g):void");
    }

    @Override // com.google.protobuf.t3
    public final int i(i2 i2Var) {
        this.f2388b.getClass();
        int iHashCode = i2Var.unknownFields.hashCode();
        if (!this.f2389c) {
            return iHashCode;
        }
        ((w1) this.f2390d).getClass();
        return ((h2) i2Var).extensions.f2318a.hashCode() + (iHashCode * 53);
    }

    @Override // com.google.protobuf.t3
    public final void j(Object obj, androidx.datastore.preferences.protobuf.k kVar, u1 u1Var) {
        d4 d4Var = this.f2388b;
        d4Var.getClass();
        c4 c4VarA = d4.a(obj);
        v1 v1Var = this.f2390d;
        ((w1) v1Var).getClass();
        ((h2) obj).p();
        while (kVar.a() != Integer.MAX_VALUE) {
            try {
                h3 h3Var = this;
                androidx.datastore.preferences.protobuf.k kVar2 = kVar;
                u1 u1Var2 = u1Var;
                if (!h3Var.k(kVar2, u1Var2, v1Var, d4Var, c4VarA)) {
                    break;
                }
                this = h3Var;
                kVar = kVar2;
                u1Var = u1Var2;
            } finally {
                ((i2) obj).unknownFields = c4VarA;
            }
        }
    }

    public final boolean k(androidx.datastore.preferences.protobuf.k kVar, u1 u1Var, v1 v1Var, d4 d4Var, c4 c4Var) throws androidx.datastore.preferences.protobuf.z, com.google.crypto.tink.shaded.protobuf.a0, r2 {
        int i2 = kVar.f893b;
        MessageLite messageLite = this.f2387a;
        if (i2 != 11) {
            if ((i2 & 7) != 2) {
                return kVar.W();
            }
            ((w1) v1Var).getClass();
            u1Var.a(i2 >>> 3, messageLite);
            d4Var.getClass();
            return d4.b(0, kVar, c4Var);
        }
        l lVarN = null;
        int iY = 0;
        while (kVar.a() != Integer.MAX_VALUE) {
            int i10 = kVar.f893b;
            if (i10 == 16) {
                kVar.V(0);
                iY = ((o) kVar.f896e).y();
                ((w1) v1Var).getClass();
                u1Var.a(iY, messageLite);
            } else if (i10 == 26) {
                lVarN = kVar.n();
            } else if (!kVar.W()) {
                break;
            }
        }
        if (kVar.f893b != 12) {
            throw new r2("Protocol message end-group tag did not match expected tag.");
        }
        if (lVarN == null) {
            return true;
        }
        d4Var.getClass();
        c4Var.d((iY << 3) | 2, lVarN);
        return true;
    }
}
