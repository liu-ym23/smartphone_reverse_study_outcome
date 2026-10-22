package f5;

import i5.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements g<Object> {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Constructor f8741g;

    public d(Constructor constructor) {
        this.f8741g = constructor;
    }

    @Override // f5.g
    public final Object c() {
        Constructor constructor = this.f8741g;
        try {
            return constructor.newInstance(null);
        } catch (IllegalAccessException e10) {
            a.AbstractC0090a abstractC0090a = i5.a.f9539a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.11.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("Failed to invoke constructor '" + i5.a.b(constructor) + "' with no args", e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException("Failed to invoke constructor '" + i5.a.b(constructor) + "' with no args", e12.getCause());
        }
    }
}
