package com.google.android.gms.internal.mlkit_vision_common;

import A2.C0629i3;
import A2.H5;

/* loaded from: classes2.dex */
final class zzz extends zzr {

    /* renamed from: f, reason: collision with root package name */
    public static final zzr f20190f = new zzz(null, new Object[0], 0);

    /* renamed from: d, reason: collision with root package name */
    public final transient Object[] f20191d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f20192e;

    public zzz(Object obj, Object[] objArr, int i10) {
        this.f20191d = objArr;
        this.f20192e = i10;
    }

    public static zzz i(int i10, Object[] objArr, H5 h52) {
        Object obj = objArr[0];
        obj.getClass();
        Object obj2 = objArr[1];
        obj2.getClass();
        C0629i3.a(obj, obj2);
        return new zzz(null, objArr, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzr
    public final zzl b() {
        return new zzy(this.f20191d, 1, this.f20192e);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzr
    public final zzs e() {
        return new zzw(this, this.f20191d, 0, this.f20192e);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzr
    public final zzs g() {
        return new zzx(this, new zzy(this.f20191d, 0, this.f20192e));
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0007  */
    @Override // com.google.android.gms.internal.mlkit_vision_common.zzr, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object[] r0 = r3.f20191d
            int r3 = r3.f20192e
            r1 = 0
            if (r4 != 0) goto L9
        L7:
            r3 = r1
            goto L1d
        L9:
            r2 = 1
            if (r3 != r2) goto L7
            r3 = 0
            r3 = r0[r3]
            r3.getClass()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L7
            r3 = r0[r2]
            r3.getClass()
        L1d:
            if (r3 != 0) goto L20
            return r1
        L20:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzz.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.f20192e;
    }
}
