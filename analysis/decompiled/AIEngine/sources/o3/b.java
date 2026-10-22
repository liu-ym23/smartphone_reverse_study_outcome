package o3;

import b3.f;
import com.fasterxml.jackson.databind.JavaType;
import java.util.HashMap;
import java.util.Map;
import q3.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final a[] f10742a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10743b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final f<Object> f10744a;

        /* renamed from: b, reason: collision with root package name */
        public final a f10745b;

        /* renamed from: c, reason: collision with root package name */
        public final Class<?> f10746c;

        /* renamed from: d, reason: collision with root package name */
        public final JavaType f10747d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f10748e;

        public a(a aVar, r rVar, f<Object> fVar) {
            this.f10745b = aVar;
            this.f10744a = fVar;
            this.f10748e = rVar.f11612d;
            this.f10746c = rVar.f11610b;
            this.f10747d = rVar.f11611c;
        }
    }

    public b(HashMap map) {
        int size = map.size();
        int i10 = 8;
        while (i10 < (size <= 64 ? size + size : size + (size >> 2))) {
            i10 += i10;
        }
        this.f10743b = i10 - 1;
        a[] aVarArr = new a[i10];
        for (Map.Entry entry : map.entrySet()) {
            r rVar = (r) entry.getKey();
            int i11 = rVar.f11609a & this.f10743b;
            aVarArr[i11] = new a(aVarArr[i11], rVar, (f) entry.getValue());
        }
        this.f10742a = aVarArr;
    }

    public final f<Object> a(JavaType javaType) {
        a aVar = this.f10742a[(javaType.f3691b - 1) & this.f10743b];
        if (aVar == null) {
            return null;
        }
        if (!aVar.f10748e && javaType.equals(aVar.f10747d)) {
            return aVar.f10744a;
        }
        while (true) {
            aVar = aVar.f10745b;
            if (aVar == null) {
                return null;
            }
            if (!aVar.f10748e && javaType.equals(aVar.f10747d)) {
                return aVar.f10744a;
            }
        }
    }

    public final f<Object> b(Class<?> cls) {
        a aVar = this.f10742a[cls.getName().hashCode() & this.f10743b];
        if (aVar == null) {
            return null;
        }
        if (aVar.f10746c == cls && !aVar.f10748e) {
            return aVar.f10744a;
        }
        while (true) {
            aVar = aVar.f10745b;
            if (aVar == null) {
                return null;
            }
            if (aVar.f10746c == cls && !aVar.f10748e) {
                return aVar.f10744a;
            }
        }
    }
}
