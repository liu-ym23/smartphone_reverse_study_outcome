package K1;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;

/* renamed from: K1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0904b implements t, J1.f {

    /* renamed from: a, reason: collision with root package name */
    public static final C0904b f4028a = new C0904b();

    @Override // K1.t
    public final void a(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f4048b;
        Object[] objArr = (Object[]) obj;
        if (obj == null) {
            if ((zVar.f4092c & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
                zVar.write("[]");
                return;
            } else {
                zVar.Y();
                return;
            }
        }
        int length = objArr.length;
        int i10 = length - 1;
        if (i10 == -1) {
            zVar.append("[]");
            return;
        }
        w wVar = mVar.f4059m;
        int i11 = 0;
        mVar.p(wVar, obj, obj2, 0);
        try {
            zVar.write(91);
            if ((zVar.f4092c & SerializerFeature.PrettyFormat.mask) != 0) {
                mVar.l();
                mVar.m();
                while (i11 < length) {
                    if (i11 != 0) {
                        zVar.write(44);
                        mVar.m();
                    }
                    mVar.r(objArr[i11]);
                    i11++;
                }
                mVar.d();
                mVar.m();
                zVar.write(93);
                mVar.f4059m = wVar;
                return;
            }
            Class<?> cls = null;
            t tVarA = null;
            while (i11 < i10) {
                Object obj3 = objArr[i11];
                if (obj3 == null) {
                    zVar.append("null,");
                } else {
                    IdentityHashMap<Object, w> identityHashMap = mVar.f4058l;
                    if (identityHashMap == null || !identityHashMap.containsKey(obj3)) {
                        Class<?> cls2 = obj3.getClass();
                        if (cls2 == cls) {
                            tVarA.a(mVar, obj3, null, null);
                        } else {
                            tVarA = mVar.f4047a.a(cls2);
                            tVarA.a(mVar, obj3, null, null);
                            cls = cls2;
                        }
                    } else {
                        mVar.t(obj3);
                    }
                    zVar.write(44);
                }
                i11++;
            }
            Object obj4 = objArr[i10];
            if (obj4 == null) {
                zVar.append("null]");
            } else {
                IdentityHashMap<Object, w> identityHashMap2 = mVar.f4058l;
                if (identityHashMap2 == null || !identityHashMap2.containsKey(obj4)) {
                    mVar.u(obj4, Integer.valueOf(i10));
                } else {
                    mVar.t(obj4);
                }
                zVar.write(93);
            }
            mVar.f4059m = wVar;
        } catch (Throwable th) {
            mVar.f4059m = wVar;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // J1.f
    public <T> T b(I1.b bVar, Type type, Object obj) throws NumberFormatException {
        I1.d dVar = bVar.f3258e;
        int iA0 = dVar.a0();
        if (iA0 == 8) {
            dVar.t(16);
            return null;
        }
        if (type != char[].class) {
            if (iA0 == 4) {
                T t10 = (T) dVar.a();
                dVar.t(16);
                return t10;
            }
            Class<?> componentType = ((Class) type).getComponentType();
            JSONArray jSONArray = new JSONArray();
            bVar.Y(componentType, jSONArray, obj);
            return (T) c(bVar, componentType, jSONArray);
        }
        if (iA0 == 4) {
            String strX = dVar.X();
            dVar.t(16);
            return (T) strX.toCharArray();
        }
        if (iA0 != 2) {
            return (T) G1.a.N(bVar.J()).toCharArray();
        }
        Number numberK = dVar.k();
        dVar.t(16);
        return (T) numberK.toString().toCharArray();
    }

    public final <T> T c(I1.b bVar, Class<?> cls, JSONArray jSONArray) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (jSONArray == null) {
            return null;
        }
        int size = jSONArray.size();
        T t10 = (T) Array.newInstance(cls, size);
        for (int i10 = 0; i10 < size; i10++) {
            Object objA = jSONArray.get(i10);
            if (objA == jSONArray) {
                Array.set(t10, i10, t10);
            } else {
                if (!cls.isArray()) {
                    objA = L1.d.a(objA, cls, bVar.f3255b);
                } else if (!cls.isInstance(objA)) {
                    objA = c(bVar, cls, (JSONArray) objA);
                }
                Array.set(t10, i10, objA);
            }
        }
        jSONArray.T(t10);
        jSONArray.S(cls);
        return t10;
    }
}
