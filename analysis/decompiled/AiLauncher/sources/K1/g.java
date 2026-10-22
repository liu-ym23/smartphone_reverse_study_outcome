package K1;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class g implements t, J1.f {

    /* renamed from: a, reason: collision with root package name */
    public static final g f4036a = new g();

    @Override // K1.t
    public void a(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f4048b;
        if (obj == null) {
            if ((zVar.f4092c & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
                zVar.write("[]");
                return;
            } else {
                zVar.Y();
                return;
            }
        }
        int i10 = zVar.f4092c;
        SerializerFeature serializerFeature = SerializerFeature.WriteClassName;
        Type typeY = (i10 & serializerFeature.mask) != 0 ? L1.d.y(type) : null;
        Collection collection = (Collection) obj;
        w wVar = mVar.f4059m;
        int i11 = 0;
        mVar.p(wVar, obj, obj2, 0);
        if ((zVar.f4092c & serializerFeature.mask) != 0) {
            if (HashSet.class == collection.getClass()) {
                zVar.append("Set");
            } else if (TreeSet.class == collection.getClass()) {
                zVar.append("TreeSet");
            }
        }
        try {
            zVar.write(91);
            for (Object obj3 : collection) {
                int i12 = i11 + 1;
                if (i11 != 0) {
                    zVar.write(44);
                }
                if (obj3 == null) {
                    zVar.Y();
                } else {
                    Class<?> cls = obj3.getClass();
                    if (cls == Integer.class) {
                        zVar.writeInt(((Integer) obj3).intValue());
                    } else if (cls == Long.class) {
                        zVar.writeLong(((Long) obj3).longValue());
                        if ((zVar.f4092c & SerializerFeature.WriteClassName.mask) != 0) {
                            zVar.write(76);
                        }
                    } else {
                        mVar.f4047a.a(cls).a(mVar, obj3, Integer.valueOf(i11), typeY);
                    }
                }
                i11 = i12;
            }
            zVar.write(93);
            mVar.f4059m = wVar;
        } catch (Throwable th) {
            mVar.f4059m = wVar;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v28, types: [T, com.alibaba.fastjson.JSONArray, java.util.Collection] */
    @Override // J1.f
    public <T> T b(I1.b bVar, Type type, Object obj) {
        Collection collection;
        if (bVar.f3258e.a0() == 8) {
            bVar.f3258e.t(16);
            return null;
        }
        if (type == JSONArray.class) {
            ?? r12 = (T) new JSONArray();
            bVar.e0(r12);
            return r12;
        }
        Type rawType = type;
        while (!(rawType instanceof Class)) {
            if (!(rawType instanceof ParameterizedType)) {
                throw new JSONException("TODO");
            }
            rawType = ((ParameterizedType) rawType).getRawType();
        }
        Class cls = (Class) rawType;
        if (cls == AbstractCollection.class || cls == Collection.class) {
            collection = (T) new ArrayList();
        } else if (cls.isAssignableFrom(HashSet.class)) {
            collection = (T) new HashSet();
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            collection = (T) new LinkedHashSet();
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            collection = (T) new TreeSet();
        } else if (cls.isAssignableFrom(ArrayList.class)) {
            collection = (T) new ArrayList();
        } else if (cls.isAssignableFrom(EnumSet.class)) {
            collection = (T) EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        } else {
            try {
                collection = (T) ((Collection) cls.newInstance());
            } catch (Exception unused) {
                throw new JSONException("create instane error, class " + cls.getName());
            }
        }
        bVar.Y(L1.d.y(type), collection, obj);
        return (T) collection;
    }
}
