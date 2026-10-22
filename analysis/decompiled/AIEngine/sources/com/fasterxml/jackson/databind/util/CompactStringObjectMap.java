package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CompactStringObjectMap implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final CompactStringObjectMap f4495d = new CompactStringObjectMap(new Object[4], 1, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f4496a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4497b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f4498c;

    public CompactStringObjectMap(Object[] objArr, int i10, int i11) {
        this.f4496a = i10;
        this.f4497b = i11;
        this.f4498c = objArr;
    }

    public final Object a(String str) {
        int iHashCode = str.hashCode();
        int i10 = this.f4496a;
        int i11 = iHashCode & i10;
        int i12 = i11 << 1;
        Object[] objArr = this.f4498c;
        Object obj = objArr[i12];
        if (obj == str || str.equals(obj)) {
            return objArr[i12 + 1];
        }
        if (obj == null) {
            return null;
        }
        int i13 = i10 + 1;
        int i14 = ((i11 >> 1) + i13) << 1;
        Object obj2 = objArr[i14];
        if (str.equals(obj2)) {
            return objArr[i14 + 1];
        }
        if (obj2 == null) {
            return null;
        }
        int i15 = (i13 + (i13 >> 1)) << 1;
        int i16 = this.f4497b + i15;
        while (i15 < i16) {
            Object obj3 = objArr[i15];
            if (obj3 == str || str.equals(obj3)) {
                return objArr[i15 + 1];
            }
            i15 += 2;
        }
        return null;
    }
}
