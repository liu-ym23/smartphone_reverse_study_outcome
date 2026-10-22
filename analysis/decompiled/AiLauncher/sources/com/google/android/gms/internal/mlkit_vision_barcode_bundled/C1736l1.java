package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.l1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1736l1 implements InterfaceC1791z1 {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1720h1 f20108a;

    /* renamed from: b, reason: collision with root package name */
    public final M1 f20109b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f20110c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC1762s0 f20111d;

    public C1736l1(M1 m12, AbstractC1762s0 abstractC1762s0, InterfaceC1720h1 interfaceC1720h1) {
        this.f20109b = m12;
        this.f20110c = interfaceC1720h1 instanceof C0;
        this.f20111d = abstractC1762s0;
        this.f20108a = interfaceC1720h1;
    }

    public static C1736l1 i(M1 m12, AbstractC1762s0 abstractC1762s0, InterfaceC1720h1 interfaceC1720h1) {
        return new C1736l1(m12, abstractC1762s0, interfaceC1720h1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    public final void a(Object obj) {
        this.f20109b.a(obj);
        this.f20111d.a(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    public final void b(Object obj, Z1 z12) throws IOException {
        Iterator itF = ((C0) obj).zzb.f();
        while (itF.hasNext()) {
            Map.Entry entry = (Map.Entry) itF.next();
            InterfaceC1774v0 interfaceC1774v0 = (InterfaceC1774v0) entry.getKey();
            if (interfaceC1774v0.zze() != zzhg.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            interfaceC1774v0.zzg();
            interfaceC1774v0.zzf();
            if (entry instanceof P0) {
                z12.F(interfaceC1774v0.zza(), ((P0) entry).a().b());
            } else {
                z12.F(interfaceC1774v0.zza(), entry.getValue());
            }
        }
        ((F0) obj).zzc.k(z12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    public final int c(Object obj) {
        int iHashCode = ((F0) obj).zzc.hashCode();
        return this.f20110c ? (iHashCode * 53) + ((C0) obj).zzb.f20143a.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    public final int d(Object obj) {
        int iB = ((F0) obj).zzc.b();
        return this.f20110c ? iB + ((C0) obj).zzb.b() : iB;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    public final void e(Object obj, Object obj2) {
        B1.u(this.f20109b, obj, obj2);
        if (this.f20110c) {
            B1.t(this.f20111d, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    public final boolean f(Object obj, Object obj2) {
        if (!((F0) obj).zzc.equals(((F0) obj2).zzc)) {
            return false;
        }
        if (this.f20110c) {
            return ((C0) obj).zzb.equals(((C0) obj2).zzb);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b8 A[EDGE_INSN: B:61:0x00b8->B:33:0x00b8 BREAK  A[LOOP:1: B:17:0x0064->B:64:0x0064], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.android.gms.internal.mlkit_vision_barcode_bundled.X r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0 r0 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0) r0
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.N1 r1 = r0.zzc
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.N1 r2 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.N1.c()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.N1 r1 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.N1.f()
            r0.zzc = r1
        L11:
            r6 = r1
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.C0 r11 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.C0) r11
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.w0 r11 = r11.H()
            r0 = 0
            r1 = r0
        L1a:
            if (r13 >= r14) goto Lc5
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.Y.j(r12, r13, r15)
            int r2 = r15.f20064a
            r13 = 11
            r3 = 2
            if (r2 == r13) goto L60
            r13 = r2 & 7
            if (r13 != r3) goto L59
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.r0 r13 = r15.f20067d
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.h1 r1 = r10.f20108a
            int r3 = r2 >>> 3
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.E0 r1 = r13.b(r1, r3)
            if (r1 == 0) goto L51
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.h1 r13 = r1.f20016a
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.p1 r2 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1752p1.a()
            java.lang.Class r13 = r13.getClass()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.z1 r13 = r2.b(r13)
            int r13 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.Y.e(r13, r12, r4, r14, r15)
            java.lang.Object r2 = r15.f20066c
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.D0 r3 = r1.f20017b
            r11.i(r3, r2)
            goto L1a
        L51:
            r3 = r12
            r5 = r14
            r7 = r15
            int r13 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.Y.i(r2, r3, r4, r5, r6, r7)
            goto L1a
        L59:
            r5 = r14
            r7 = r15
            int r13 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.Y.p(r2, r12, r4, r5, r7)
            goto L1a
        L60:
            r5 = r14
            r7 = r15
            r13 = 0
            r14 = r0
        L64:
            if (r4 >= r5) goto Lb7
            int r15 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.Y.j(r12, r4, r7)
            int r2 = r7.f20064a
            int r4 = r2 >>> 3
            r8 = r2 & 7
            if (r4 == r3) goto L9d
            r9 = 3
            if (r4 == r9) goto L76
            goto Lae
        L76:
            if (r1 == 0) goto L92
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.h1 r2 = r1.f20016a
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.p1 r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1752p1.a()
            java.lang.Class r2 = r2.getClass()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.z1 r2 = r4.b(r2)
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.Y.e(r2, r12, r15, r5, r7)
            java.lang.Object r15 = r7.f20066c
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.D0 r2 = r1.f20017b
            r11.i(r2, r15)
            goto L64
        L92:
            if (r8 != r3) goto Lae
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.Y.a(r12, r15, r7)
            java.lang.Object r14 = r7.f20066c
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf r14 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf) r14
            goto L64
        L9d:
            if (r8 != 0) goto Lae
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.Y.j(r12, r15, r7)
            int r13 = r7.f20064a
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.r0 r15 = r7.f20067d
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.h1 r1 = r10.f20108a
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.E0 r1 = r15.b(r1, r13)
            goto L64
        Lae:
            r4 = 12
            if (r2 == r4) goto Lb8
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.Y.p(r2, r12, r15, r5, r7)
            goto L64
        Lb7:
            r15 = r4
        Lb8:
            if (r14 == 0) goto Lc0
            int r13 = r13 << 3
            r13 = r13 | r3
            r6.j(r13, r14)
        Lc0:
            r13 = r15
            r14 = r5
            r15 = r7
            goto L1a
        Lc5:
            r5 = r14
            if (r13 != r5) goto Lc9
            return
        Lc9:
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer r10 = new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer
            java.lang.String r11 = "Failed to parse the message."
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1736l1.g(java.lang.Object, byte[], int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.X):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    public final boolean h(Object obj) {
        return ((C0) obj).zzb.k();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    public final Object zze() {
        InterfaceC1720h1 interfaceC1720h1 = this.f20108a;
        return interfaceC1720h1 instanceof F0 ? ((F0) interfaceC1720h1).o() : interfaceC1720h1.f().G();
    }
}
