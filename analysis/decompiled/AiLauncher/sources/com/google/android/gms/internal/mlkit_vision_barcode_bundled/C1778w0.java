package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.w0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1778w0 {

    /* renamed from: d, reason: collision with root package name */
    public static final C1778w0 f20142d = new C1778w0(true);

    /* renamed from: a, reason: collision with root package name */
    public final J1 f20143a = new C1();

    /* renamed from: b, reason: collision with root package name */
    public boolean f20144b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20145c;

    public C1778w0() {
    }

    public static int a(InterfaceC1774v0 interfaceC1774v0, Object obj) {
        int iF;
        int iA;
        zzhf zzhfVarZzd = interfaceC1774v0.zzd();
        int iZza = interfaceC1774v0.zza();
        interfaceC1774v0.zzg();
        int iA2 = AbstractC1739m0.a(iZza << 3);
        if (zzhfVarZzd == zzhf.zzj) {
            Charset charset = N0.f20038a;
            if (((InterfaceC1720h1) obj) instanceof U) {
                throw null;
            }
            iA2 += iA2;
        }
        zzhg zzhgVar = zzhg.INT;
        int iB = 4;
        switch (zzhfVarZzd.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                iB = 8;
                return iA2 + iB;
            case 1:
                ((Float) obj).getClass();
                return iA2 + iB;
            case 2:
                iB = AbstractC1739m0.b(((Long) obj).longValue());
                return iA2 + iB;
            case 3:
                iB = AbstractC1739m0.b(((Long) obj).longValue());
                return iA2 + iB;
            case 4:
                iB = AbstractC1739m0.b(((Integer) obj).intValue());
                return iA2 + iB;
            case 5:
                ((Long) obj).getClass();
                iB = 8;
                return iA2 + iB;
            case 6:
                ((Integer) obj).getClass();
                return iA2 + iB;
            case 7:
                ((Boolean) obj).getClass();
                iB = 1;
                return iA2 + iB;
            case 8:
                if (!(obj instanceof zzdf)) {
                    iB = AbstractC1739m0.C((String) obj);
                    return iA2 + iB;
                }
                iF = ((zzdf) obj).f();
                iA = AbstractC1739m0.a(iF);
                iB = iA + iF;
                return iA2 + iB;
            case 9:
                iB = ((InterfaceC1720h1) obj).a();
                return iA2 + iB;
            case 10:
                if (!(obj instanceof R0)) {
                    iB = AbstractC1739m0.A((InterfaceC1720h1) obj);
                    return iA2 + iB;
                }
                iF = ((R0) obj).a();
                iA = AbstractC1739m0.a(iF);
                iB = iA + iF;
                return iA2 + iB;
            case 11:
                if (obj instanceof zzdf) {
                    iF = ((zzdf) obj).f();
                    iA = AbstractC1739m0.a(iF);
                } else {
                    iF = ((byte[]) obj).length;
                    iA = AbstractC1739m0.a(iF);
                }
                iB = iA + iF;
                return iA2 + iB;
            case 12:
                iB = AbstractC1739m0.a(((Integer) obj).intValue());
                return iA2 + iB;
            case 13:
                iB = obj instanceof H0 ? AbstractC1739m0.b(((H0) obj).zza()) : AbstractC1739m0.b(((Integer) obj).intValue());
                return iA2 + iB;
            case 14:
                ((Integer) obj).getClass();
                return iA2 + iB;
            case 15:
                ((Long) obj).getClass();
                iB = 8;
                return iA2 + iB;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                iB = AbstractC1739m0.a((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iA2 + iB;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                iB = AbstractC1739m0.b((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iA2 + iB;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static C1778w0 d() {
        return f20142d;
    }

    public static Object l(Object obj) {
        if (obj instanceof InterfaceC1740m1) {
            return ((InterfaceC1740m1) obj).zzc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public static boolean n(Map.Entry entry) {
        InterfaceC1774v0 interfaceC1774v0 = (InterfaceC1774v0) entry.getKey();
        if (interfaceC1774v0.zze() != zzhg.MESSAGE) {
            return true;
        }
        interfaceC1774v0.zzg();
        Object value = entry.getValue();
        if (value instanceof InterfaceC1724i1) {
            return ((InterfaceC1724i1) value).h();
        }
        if (value instanceof R0) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public static final int o(Map.Entry entry) {
        int i10;
        int iA;
        int iA2;
        InterfaceC1774v0 interfaceC1774v0 = (InterfaceC1774v0) entry.getKey();
        Object value = entry.getValue();
        if (interfaceC1774v0.zze() != zzhg.MESSAGE) {
            return a(interfaceC1774v0, value);
        }
        interfaceC1774v0.zzg();
        interfaceC1774v0.zzf();
        if (value instanceof R0) {
            int iZza = ((InterfaceC1774v0) entry.getKey()).zza();
            int iA3 = AbstractC1739m0.a(8);
            i10 = iA3 + iA3;
            iA = AbstractC1739m0.a(16) + AbstractC1739m0.a(iZza);
            int iA4 = AbstractC1739m0.a(24);
            int iA5 = ((R0) value).a();
            iA2 = iA4 + AbstractC1739m0.a(iA5) + iA5;
        } else {
            int iZza2 = ((InterfaceC1774v0) entry.getKey()).zza();
            int iA6 = AbstractC1739m0.a(8);
            i10 = iA6 + iA6;
            iA = AbstractC1739m0.a(16) + AbstractC1739m0.a(iZza2);
            iA2 = AbstractC1739m0.a(24) + AbstractC1739m0.A((InterfaceC1720h1) value);
        }
        return i10 + iA + iA2;
    }

    public final int b() {
        int iD = this.f20143a.d();
        int iO = 0;
        for (int i10 = 0; i10 < iD; i10++) {
            iO += o(this.f20143a.i(i10));
        }
        Iterator it = this.f20143a.e().iterator();
        while (it.hasNext()) {
            iO += o((Map.Entry) it.next());
        }
        return iO;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final C1778w0 clone() {
        C1778w0 c1778w0 = new C1778w0();
        int iD = this.f20143a.d();
        for (int i10 = 0; i10 < iD; i10++) {
            Map.Entry entryI = this.f20143a.i(i10);
            c1778w0.i((InterfaceC1774v0) ((D1) entryI).a(), entryI.getValue());
        }
        for (Map.Entry entry : this.f20143a.e()) {
            c1778w0.i((InterfaceC1774v0) entry.getKey(), entry.getValue());
        }
        c1778w0.f20145c = this.f20145c;
        return c1778w0;
    }

    public final Object e(InterfaceC1774v0 interfaceC1774v0) {
        Object obj = this.f20143a.get(interfaceC1774v0);
        if (obj instanceof R0) {
            throw null;
        }
        return obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1778w0) {
            return this.f20143a.equals(((C1778w0) obj).f20143a);
        }
        return false;
    }

    public final Iterator f() {
        return this.f20143a.isEmpty() ? Collections.emptyIterator() : this.f20145c ? new Q0(this.f20143a.entrySet().iterator()) : this.f20143a.entrySet().iterator();
    }

    public final void g() {
        if (this.f20144b) {
            return;
        }
        int iD = this.f20143a.d();
        for (int i10 = 0; i10 < iD; i10++) {
            Map.Entry entryI = this.f20143a.i(i10);
            if (entryI.getValue() instanceof F0) {
                ((F0) entryI.getValue()).x();
            }
        }
        this.f20143a.b();
        this.f20144b = true;
    }

    public final void h(C1778w0 c1778w0) {
        int iD = c1778w0.f20143a.d();
        for (int i10 = 0; i10 < iD; i10++) {
            m(c1778w0.f20143a.i(i10));
        }
        Iterator it = c1778w0.f20143a.e().iterator();
        while (it.hasNext()) {
            m((Map.Entry) it.next());
        }
    }

    public final int hashCode() {
        return this.f20143a.hashCode();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.H0) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if ((r4 instanceof byte[]) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        if (r0 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.R0) == false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1774v0 r3, java.lang.Object r4) {
        /*
            r2 = this;
            r3.zzg()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhf r0 = r3.zzd()
            java.nio.charset.Charset r1 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.N0.f20038a
            r4.getClass()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhf r1 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhf.zza
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhg r1 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhg.INT
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhg r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L46;
                case 1: goto L43;
                case 2: goto L40;
                case 3: goto L3d;
                case 4: goto L3a;
                case 5: goto L37;
                case 6: goto L2e;
                case 7: goto L25;
                case 8: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L57
        L1c:
            boolean r0 = r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1720h1
            if (r0 != 0) goto L4a
            boolean r0 = r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.R0
            if (r0 == 0) goto L57
            goto L4a
        L25:
            boolean r0 = r4 instanceof java.lang.Integer
            if (r0 != 0) goto L4a
            boolean r0 = r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.H0
            if (r0 == 0) goto L57
            goto L4a
        L2e:
            boolean r0 = r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf
            if (r0 != 0) goto L4a
            boolean r0 = r4 instanceof byte[]
            if (r0 == 0) goto L57
            goto L4a
        L37:
            boolean r0 = r4 instanceof java.lang.String
            goto L48
        L3a:
            boolean r0 = r4 instanceof java.lang.Boolean
            goto L48
        L3d:
            boolean r0 = r4 instanceof java.lang.Double
            goto L48
        L40:
            boolean r0 = r4 instanceof java.lang.Float
            goto L48
        L43:
            boolean r0 = r4 instanceof java.lang.Long
            goto L48
        L46:
            boolean r0 = r4 instanceof java.lang.Integer
        L48:
            if (r0 == 0) goto L57
        L4a:
            boolean r0 = r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.R0
            if (r0 == 0) goto L51
            r0 = 1
            r2.f20145c = r0
        L51:
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.J1 r2 = r2.f20143a
            r2.put(r3, r4)
            return
        L57:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            int r0 = r3.zza()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhf r3 = r3.zzd()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhg r3 = r3.zza()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.Object[] r3 = new java.lang.Object[]{r0, r3, r4}
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1778w0.i(com.google.android.gms.internal.mlkit_vision_barcode_bundled.v0, java.lang.Object):void");
    }

    public final boolean j() {
        return this.f20144b;
    }

    public final boolean k() {
        int iD = this.f20143a.d();
        for (int i10 = 0; i10 < iD; i10++) {
            if (!n(this.f20143a.i(i10))) {
                return false;
            }
        }
        Iterator it = this.f20143a.e().iterator();
        while (it.hasNext()) {
            if (!n((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void m(Map.Entry entry) {
        InterfaceC1774v0 interfaceC1774v0 = (InterfaceC1774v0) entry.getKey();
        Object value = entry.getValue();
        boolean z10 = value instanceof R0;
        interfaceC1774v0.zzg();
        if (interfaceC1774v0.zze() != zzhg.MESSAGE) {
            if (z10) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.f20143a.put(interfaceC1774v0, l(value));
            return;
        }
        Object objE = e(interfaceC1774v0);
        if (objE != null) {
            if (z10) {
                throw null;
            }
            this.f20143a.put(interfaceC1774v0, objE instanceof InterfaceC1740m1 ? interfaceC1774v0.h((InterfaceC1740m1) objE, (InterfaceC1740m1) value) : interfaceC1774v0.g(((InterfaceC1720h1) objE).j(), (InterfaceC1720h1) value).zzj());
        } else {
            this.f20143a.put(interfaceC1774v0, l(value));
            if (z10) {
                this.f20145c = true;
            }
        }
    }

    public C1778w0(boolean z10) {
        g();
        g();
    }
}
