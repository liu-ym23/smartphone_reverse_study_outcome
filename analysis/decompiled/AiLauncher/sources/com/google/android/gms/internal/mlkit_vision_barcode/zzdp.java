package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Objects;
import z2.C6057A;
import z2.C6245r;

/* loaded from: classes2.dex */
final class zzdp extends zzcu {

    /* renamed from: d, reason: collision with root package name */
    public final transient Object[] f20005d;

    public zzdp(Object obj, Object[] objArr, int i10) {
        this.f20005d = objArr;
    }

    public static zzdp i(int i10, Object[] objArr, C6057A c6057a) {
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[1];
        Objects.requireNonNull(obj2);
        C6245r.b(obj, obj2);
        return new zzdp(null, objArr, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcu
    public final zzcn b() {
        return new zzdo(this.f20005d, 1, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcu
    public final zzcv e() {
        return new zzdm(this, this.f20005d, 0, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcu
    public final zzcv g() {
        return new zzdn(this, new zzdo(this.f20005d, 0, 1));
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcu, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L5
        L3:
            r2 = r0
            goto L19
        L5:
            java.lang.Object[] r2 = r2.f20005d
            r1 = 0
            r1 = r2[r1]
            java.util.Objects.requireNonNull(r1)
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L3
            r3 = 1
            r2 = r2[r3]
            java.util.Objects.requireNonNull(r2)
        L19:
            if (r2 != 0) goto L1c
            return r0
        L1c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzdp.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return 1;
    }
}
