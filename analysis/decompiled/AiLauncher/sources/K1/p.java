package K1;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class p implements t {
    @Override // K1.t
    public void a(m mVar, Object obj, Object obj2, Type type) throws IOException {
        boolean z10;
        Object objN;
        Object objO;
        z zVar = mVar.f4048b;
        if (obj == null) {
            zVar.Y();
            return;
        }
        Map treeMap = (Map) obj;
        Class<?> cls = treeMap.getClass();
        boolean z11 = (cls == JSONObject.class || cls == HashMap.class || cls == LinkedHashMap.class) && treeMap.containsKey("@type");
        if ((zVar.f4092c & SerializerFeature.SortField.mask) != 0 && !(treeMap instanceof SortedMap) && !(treeMap instanceof LinkedHashMap)) {
            try {
                treeMap = new TreeMap(treeMap);
            } catch (Exception unused) {
            }
        }
        IdentityHashMap<Object, w> identityHashMap = mVar.f4058l;
        if (identityHashMap != null && identityHashMap.containsKey(obj)) {
            mVar.t(obj);
            return;
        }
        w wVar = mVar.f4059m;
        mVar.p(wVar, obj, obj2, 0);
        try {
            zVar.write(123);
            mVar.l();
            if ((zVar.f4092c & SerializerFeature.WriteClassName.mask) == 0 || z11) {
                z10 = true;
            } else {
                zVar.J(mVar.f4047a.f4078b, false);
                zVar.e0(obj.getClass().getName());
                z10 = false;
            }
            Class<?> cls2 = null;
            t tVar = null;
            for (Map.Entry entry : treeMap.entrySet()) {
                Object value = entry.getValue();
                Object key = entry.getKey();
                if (mVar.b(obj, key) && mVar.a(obj, key, value) && ((objO = m.o(mVar, obj, (objN = mVar.n(obj, key, value)), value)) != null || (zVar.f4092c & SerializerFeature.WriteMapNullValue.mask) != 0)) {
                    if (objN instanceof String) {
                        String str = (String) objN;
                        if (!z10) {
                            zVar.write(44);
                        }
                        if ((zVar.f4092c & SerializerFeature.PrettyFormat.mask) != 0) {
                            mVar.m();
                        }
                        zVar.J(str, true);
                    } else {
                        if (!z10) {
                            zVar.write(44);
                        }
                        int i10 = zVar.f4092c;
                        if ((SerializerFeature.BrowserCompatible.mask & i10) == 0 && (i10 & SerializerFeature.WriteNonStringKeyAsString.mask) == 0) {
                            mVar.r(objN);
                        } else {
                            mVar.s(G1.a.N(objN));
                        }
                        zVar.write(58);
                    }
                    if (objO == null) {
                        zVar.Y();
                    } else {
                        Class<?> cls3 = objO.getClass();
                        if (cls3 == cls2) {
                            tVar.a(mVar, objO, objN, null);
                        } else {
                            t tVarA = mVar.f4047a.a(cls3);
                            tVarA.a(mVar, objO, objN, null);
                            tVar = tVarA;
                            cls2 = cls3;
                        }
                    }
                    z10 = false;
                }
            }
            mVar.f4059m = wVar;
            mVar.d();
            if ((zVar.f4092c & SerializerFeature.PrettyFormat.mask) != 0 && treeMap.size() > 0) {
                mVar.m();
            }
            zVar.write(125);
        } catch (Throwable th) {
            mVar.f4059m = wVar;
            throw th;
        }
    }
}
