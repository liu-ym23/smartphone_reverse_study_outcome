package p7;

import java.lang.invoke.VarHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 implements m7.o {

    /* renamed from: c, reason: collision with root package name */
    public p5.c f9835c;

    /* renamed from: f, reason: collision with root package name */
    public int f9836f;

    /* renamed from: g, reason: collision with root package name */
    public o7.d f9837g;

    /* renamed from: h, reason: collision with root package name */
    public l f9838h;
    public List i;

    public static void b(Class cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + r7.c.c(field) + " and " + r7.c.c(field2) + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("duplicate-fields"));
    }

    @Override // m7.o
    public final m7.n a(m7.e eVar, t7.a aVar) throws NoSuchMethodException, SecurityException {
        Class rawType = aVar.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        ac.a aVar2 = r7.c.f10473a;
        if (!Modifier.isStatic(rawType.getModifiers()) && (rawType.isAnonymousClass() || rawType.isLocalClass())) {
            return new m7.b(2);
        }
        o7.h.e(this.i);
        ac.a aVar3 = r7.c.f10473a;
        if (!aVar3.D(rawType)) {
            o7.o oVarK = this.f9835c.k(aVar, true);
            y yVar = new y(c(eVar, aVar, rawType, false));
            yVar.f9916b = oVarK;
            VarHandle.storeStoreFence();
            return yVar;
        }
        a0 a0Var = new a0(c(eVar, aVar, rawType, true));
        a0Var.f9831d = new HashMap();
        Constructor constructorV = aVar3.v(rawType);
        a0Var.f9829b = constructorV;
        r7.c.f(constructorV);
        String[] strArrY = aVar3.y(rawType);
        for (int i = 0; i < strArrY.length; i++) {
            a0Var.f9831d.put(strArrY[i], Integer.valueOf(i));
        }
        Class<?>[] parameterTypes = a0Var.f9829b.getParameterTypes();
        a0Var.f9830c = new Object[parameterTypes.length];
        for (int i3 = 0; i3 < parameterTypes.length; i3++) {
            a0Var.f9830c[i3] = a0.f9828e.get(parameterTypes[i3]);
        }
        VarHandle.storeStoreFence();
        return a0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01f2  */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final p7.z c(m7.e r26, t7.a r27, java.lang.Class r28, boolean r29) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.b0.c(m7.e, t7.a, java.lang.Class, boolean):p7.z");
    }

    public final boolean d(Field field, boolean z10) {
        boolean z11;
        o7.d dVar = this.f9837g;
        dVar.getClass();
        if ((136 & field.getModifiers()) != 0 || field.isSynthetic() || dVar.b(field.getType(), z10)) {
            z11 = true;
        } else {
            List list = z10 ? dVar.f9248c : dVar.f9249f;
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    throw androidx.activity.b.g(it);
                }
            }
            z11 = false;
        }
        return !z11;
    }
}
