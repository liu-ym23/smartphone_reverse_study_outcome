package com.typesafe.config.impl;

import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.zyql.ai.selector.camera.CustomCameraView;

/* renamed from: com.typesafe.config.impl.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C3898d<K, V> {

    /* renamed from: c, reason: collision with root package name */
    public static final a[] f31845c = new a[0];

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f31846d = {2, 5, 11, 17, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, CustomCameraView.BUTTON_STATE_ONLY_CAPTURE, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, AMapException.CODE_AMAP_USERKEY_PLAT_NOMATCH, ReportUtil.EXCEPTION_CODE_DESCRYPTRESPONSE, 3079, 4057, 7103, 10949, 16069, 32609, 65867, 104729};

    /* renamed from: a, reason: collision with root package name */
    public final int f31847a;

    /* renamed from: b, reason: collision with root package name */
    public final a[] f31848b;

    /* renamed from: com.typesafe.config.impl.d$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f31849a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f31850b;

        /* renamed from: c, reason: collision with root package name */
        public final Object f31851c;

        /* renamed from: d, reason: collision with root package name */
        public final a f31852d;

        public a(int i10, Object obj, Object obj2, a aVar) {
            this.f31849a = i10;
            this.f31850b = obj;
            this.f31851c = obj2;
            this.f31852d = aVar;
        }

        public Object a(Object obj) {
            if (this.f31850b.equals(obj)) {
                return this.f31851c;
            }
            a aVar = this.f31852d;
            if (aVar != null) {
                return aVar.a(obj);
            }
            return null;
        }
    }

    public C3898d() {
        this(0, f31845c);
    }

    public static int c(int i10) {
        for (int i11 : f31846d) {
            if (i11 > i10) {
                return i11;
            }
        }
        return f31846d[r4.length - 1];
    }

    public static void d(a[] aVarArr, a[] aVarArr2) {
        for (a aVar : aVarArr) {
            for (; aVar != null; aVar = aVar.f31852d) {
                f(aVarArr2, aVar);
            }
        }
    }

    public static <K, V> void e(a[] aVarArr, int i10, K k10, V v10) {
        int length = i10 % aVarArr.length;
        aVarArr[length] = new a(i10, k10, v10, aVarArr[length]);
    }

    public static void f(a[] aVarArr, a aVar) {
        int i10 = aVar.f31849a;
        int length = i10 % aVarArr.length;
        a aVar2 = aVarArr[length];
        if (aVar2 == null && aVar.f31852d == null) {
            aVarArr[length] = aVar;
        } else {
            aVarArr[length] = new a(i10, aVar.f31850b, aVar.f31851c, aVar2);
        }
    }

    public C3898d<K, V> a(K k10, V v10) {
        int i10 = this.f31847a + 1;
        a[] aVarArr = this.f31848b;
        a[] aVarArr2 = i10 > aVarArr.length ? new a[c((i10 * 2) - 1)] : new a[aVarArr.length];
        int length = aVarArr2.length;
        a[] aVarArr3 = this.f31848b;
        if (length == aVarArr3.length) {
            System.arraycopy(aVarArr3, 0, aVarArr2, 0, aVarArr3.length);
        } else {
            d(aVarArr3, aVarArr2);
        }
        e(aVarArr2, Math.abs(k10.hashCode()), k10, v10);
        return new C3898d<>(i10, aVarArr2);
    }

    public V b(K k10) {
        if (this.f31848b.length == 0) {
            return null;
        }
        int iAbs = Math.abs(k10.hashCode());
        a[] aVarArr = this.f31848b;
        a aVar = aVarArr[iAbs % aVarArr.length];
        if (aVar == null) {
            return null;
        }
        return (V) aVar.a(k10);
    }

    public C3898d(int i10, a[] aVarArr) {
        this.f31847a = i10;
        this.f31848b = aVarArr;
    }
}
