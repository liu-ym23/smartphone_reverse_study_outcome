package q0;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import o0.C0888a;

/* renamed from: q0.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0940C implements U, p0.t {

    /* renamed from: a, reason: collision with root package name */
    public static C0940C f19670a = new C0940C();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        e0 e0Var = c0946i.f19676k;
        if (obj instanceof Multimap) {
            c0946i.G(((Multimap) obj).asMap());
        }
    }

    @Override // p0.t
    public int d() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, com.google.common.collect.ArrayListMultimap] */
    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        }
        if (type != ArrayListMultimap.class) {
            return null;
        }
        ?? r12 = (T) ArrayListMultimap.create();
        for (Map.Entry<String, Object> entry : c0888a.n0().entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Collection) {
                r12.putAll(entry.getKey(), (List) value);
            } else {
                r12.put(entry.getKey(), value);
            }
        }
        return r12;
    }
}
