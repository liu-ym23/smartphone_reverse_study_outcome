package g5;

import com.google.gson.ToNumberPolicy;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import d5.u;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j extends u<Object> {

    /* renamed from: c, reason: collision with root package name */
    public static final i f8996c = new i(ToNumberPolicy.f5438a, 0);

    /* renamed from: a, reason: collision with root package name */
    public final d5.i f8997a;

    /* renamed from: b, reason: collision with root package name */
    public final d5.t f8998b;

    public j(d5.i iVar, d5.t tVar) {
        this.f8997a = iVar;
        this.f8998b = tVar;
    }

    @Override // d5.u
    public final Object a(k5.a aVar) throws IOException {
        Object arrayList;
        Serializable arrayList2;
        JsonToken jsonTokenR0 = aVar.R0();
        int iOrdinal = jsonTokenR0.ordinal();
        if (iOrdinal == 0) {
            aVar.a();
            arrayList = new ArrayList();
        } else if (iOrdinal != 2) {
            arrayList = null;
        } else {
            aVar.o();
            arrayList = new LinkedTreeMap();
        }
        if (arrayList == null) {
            return c(aVar, jsonTokenR0);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.x0()) {
                String strL0 = arrayList instanceof Map ? aVar.L0() : null;
                JsonToken jsonTokenR02 = aVar.R0();
                int iOrdinal2 = jsonTokenR02.ordinal();
                if (iOrdinal2 == 0) {
                    aVar.a();
                    arrayList2 = new ArrayList();
                } else if (iOrdinal2 != 2) {
                    arrayList2 = null;
                } else {
                    aVar.o();
                    arrayList2 = new LinkedTreeMap();
                }
                boolean z = arrayList2 != null;
                if (arrayList2 == null) {
                    arrayList2 = c(aVar, jsonTokenR02);
                }
                if (arrayList instanceof List) {
                    ((List) arrayList).add(arrayList2);
                } else {
                    ((Map) arrayList).put(strL0, arrayList2);
                }
                if (z) {
                    arrayDeque.addLast(arrayList);
                    arrayList = arrayList2;
                }
            } else {
                if (arrayList instanceof List) {
                    aVar.K();
                } else {
                    aVar.P();
                }
                if (arrayDeque.isEmpty()) {
                    return arrayList;
                }
                arrayList = arrayDeque.removeLast();
            }
        }
    }

    @Override // d5.u
    public final void b(k5.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.c0();
            return;
        }
        Class<?> cls = obj.getClass();
        d5.i iVar = this.f8997a;
        iVar.getClass();
        u uVarE = iVar.e(TypeToken.get((Class) cls));
        if (!(uVarE instanceof j)) {
            uVarE.b(bVar, obj);
        } else {
            bVar.w();
            bVar.P();
        }
    }

    public final Serializable c(k5.a aVar, JsonToken jsonToken) throws IOException {
        int iOrdinal = jsonToken.ordinal();
        if (iOrdinal == 5) {
            return aVar.P0();
        }
        if (iOrdinal == 6) {
            return this.f8998b.a(aVar);
        }
        if (iOrdinal == 7) {
            return Boolean.valueOf(aVar.H0());
        }
        if (iOrdinal == 8) {
            aVar.N0();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + jsonToken);
    }
}
