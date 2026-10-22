package a6;

import com.stepos.aicgroup.AiThermalManager;
import com.stepos.aicgroup.resource.ResourcePressureSceneManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.jvm.internal.g;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f42a;

    public /* synthetic */ a(int i10) {
        this.f42a = i10;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        switch (this.f42a) {
            case 0:
                return ResourcePressureSceneManager.createSceneListenerProxy$lambda$7(obj, method, objArr);
            default:
                AiThermalManager aiThermalManager = AiThermalManager.INSTANCE;
                if (!g.b(method.getDeclaringClass(), Object.class)) {
                    if (!g.b(method.getName(), "onThermalChanged")) {
                        return null;
                    }
                    AiThermalManager.f5636a.execute(new f(3));
                    return null;
                }
                String name = method.getName();
                if (name == null) {
                    return null;
                }
                int iHashCode = name.hashCode();
                if (iHashCode == -1776922004) {
                    if (name.equals("toString")) {
                        return ai.onnxruntime.a.k("AiThermalListener@", Integer.toHexString(System.identityHashCode(obj)));
                    }
                    return null;
                }
                if (iHashCode == -1295482945) {
                    if (name.equals("equals")) {
                        return Boolean.valueOf(obj == (objArr != null ? l.g0(objArr, 0) : null));
                    }
                    return null;
                }
                if (iHashCode == 147696667 && name.equals("hashCode")) {
                    return Integer.valueOf(System.identityHashCode(obj));
                }
                return null;
        }
    }
}
