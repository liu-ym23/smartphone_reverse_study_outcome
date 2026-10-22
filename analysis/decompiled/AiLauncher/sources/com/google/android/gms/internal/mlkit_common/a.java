package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;
import y2.C5921b;
import y2.C5923d;
import y2.O;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f19909a = new Object[8];

    /* renamed from: b, reason: collision with root package name */
    public int f19910b = 0;

    /* renamed from: c, reason: collision with root package name */
    public C5923d f19911c;

    public final a a(Object obj, Object obj2) {
        int i10 = this.f19910b + 1;
        Object[] objArr = this.f19909a;
        int length = objArr.length;
        int i11 = i10 + i10;
        if (i11 > length) {
            this.f19909a = Arrays.copyOf(objArr, C5921b.a(length, i11));
        }
        O.a(obj, obj2);
        Object[] objArr2 = this.f19909a;
        int i12 = this.f19910b;
        int i13 = i12 + i12;
        objArr2[i13] = obj;
        objArr2[i13 + 1] = obj2;
        this.f19910b = i12 + 1;
        return this;
    }

    public final zzai b() {
        C5923d c5923d = this.f19911c;
        if (c5923d != null) {
            throw c5923d.a();
        }
        zzaq zzaqVarI = zzaq.i(this.f19910b, this.f19909a, this);
        C5923d c5923d2 = this.f19911c;
        if (c5923d2 == null) {
            return zzaqVarI;
        }
        throw c5923d2.a();
    }
}
