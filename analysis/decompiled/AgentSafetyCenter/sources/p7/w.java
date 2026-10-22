package p7;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public String f9904a;

    /* renamed from: b, reason: collision with root package name */
    public Field f9905b;

    /* renamed from: c, reason: collision with root package name */
    public String f9906c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Method f9907d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ m7.n f9908e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ m7.n f9909f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ boolean f9910g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ boolean f9911h;

    public final void a(u7.c cVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        Field field = this.f9905b;
        Method method = this.f9907d;
        if (method != null) {
            try {
                objInvoke = method.invoke(obj, null);
            } catch (InvocationTargetException e10) {
                throw new m7.h(k0.a.C("Accessor ", r7.c.d(method, false), " threw exception"), e10.getCause());
            }
        } else {
            objInvoke = field.get(obj);
        }
        if (objInvoke == obj) {
            return;
        }
        cVar.r(this.f9904a);
        this.f9908e.write(cVar, objInvoke);
    }
}
