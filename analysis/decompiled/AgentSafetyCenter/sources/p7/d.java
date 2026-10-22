package p7;

import java.lang.invoke.VarHandle;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements m7.o {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9842c;

    /* renamed from: f, reason: collision with root package name */
    public p5.c f9843f;

    public /* synthetic */ d(int i) {
        this.f9842c = i;
    }

    @Override // m7.o
    public final m7.n a(m7.e eVar, t7.a aVar) throws NoSuchMethodException, SecurityException {
        Class cls;
        Type[] actualTypeArguments;
        cls = Object.class;
        switch (this.f9842c) {
            case 0:
                Type type = aVar.getType();
                Class rawType = aVar.getRawType();
                if (!Collection.class.isAssignableFrom(rawType)) {
                    return null;
                }
                Type typeH = o7.h.h(type, rawType, Collection.class);
                cls = typeH instanceof ParameterizedType ? ((ParameterizedType) typeH).getActualTypeArguments()[0] : Object.class;
                r rVar = new r(eVar, eVar.c(t7.a.get(cls)), cls);
                o7.o oVarK = this.f9843f.k(aVar, false);
                c cVar = new c(0);
                cVar.f9840b = rVar;
                cVar.f9841c = oVarK;
                VarHandle.storeStoreFence();
                return cVar;
            default:
                Type type2 = aVar.getType();
                Class rawType2 = aVar.getRawType();
                if (!Map.class.isAssignableFrom(rawType2)) {
                    return null;
                }
                if (Properties.class.isAssignableFrom(rawType2)) {
                    actualTypeArguments = new Type[]{String.class, String.class};
                } else {
                    Type typeH2 = o7.h.h(type2, rawType2, Map.class);
                    actualTypeArguments = typeH2 instanceof ParameterizedType ? ((ParameterizedType) typeH2).getActualTypeArguments() : new Type[]{cls, cls};
                }
                Type type3 = actualTypeArguments[0];
                Type type4 = actualTypeArguments[1];
                r rVar2 = new r(eVar, (type3 == Boolean.TYPE || type3 == Boolean.class) ? g1.f9847c : eVar.c(t7.a.get(type3)), type3);
                r rVar3 = new r(eVar, eVar.c(t7.a.get(type4)), type4);
                o7.o oVarK2 = this.f9843f.k(aVar, false);
                r rVar4 = new r();
                rVar4.f9893b = rVar2;
                rVar4.f9894c = rVar3;
                rVar4.f9895d = oVarK2;
                VarHandle.storeStoreFence();
                return rVar4;
        }
    }
}
