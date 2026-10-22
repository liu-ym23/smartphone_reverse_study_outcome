package g5;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import d5.u;
import g5.k;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l extends k.c {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f9016d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Method f9017e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ u f9018f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ u f9019g;
    public final /* synthetic */ boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f9020i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, Field field, boolean z, Method method, u uVar, u uVar2, boolean z3, boolean z10) {
        super(str, field);
        this.f9016d = z;
        this.f9017e = method;
        this.f9018f = uVar;
        this.f9019g = uVar2;
        this.h = z3;
        this.f9020i = z10;
    }

    @Override // g5.k.c
    public final void a(k5.a aVar, int i10, Object[] objArr) {
        Object objA = this.f9019g.a(aVar);
        if (objA != null || !this.h) {
            objArr[i10] = objA;
            return;
        }
        throw new JsonParseException("null is not allowed as value for record component '" + this.f9007c + "' of primitive type; at path " + aVar.S());
    }

    @Override // g5.k.c
    public final void b(k5.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException {
        Object objA = this.f9019g.a(aVar);
        if (objA == null && this.h) {
            return;
        }
        boolean z = this.f9016d;
        Field field = this.f9006b;
        if (z) {
            k.a(obj, field);
        } else if (this.f9020i) {
            throw new JsonIOException(ai.onnxruntime.a.k("Cannot set value of 'static final' ", i5.a.d(field, false)));
        }
        field.set(obj, objA);
    }

    @Override // g5.k.c
    public final void c(k5.b bVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        boolean z = this.f9016d;
        Field field = this.f9006b;
        Method method = this.f9017e;
        if (z) {
            if (method == null) {
                k.a(obj, field);
            } else {
                k.a(obj, method);
            }
        }
        if (method != null) {
            try {
                objInvoke = method.invoke(obj, null);
            } catch (InvocationTargetException e10) {
                throw new JsonIOException(a0.a.k("Accessor ", i5.a.d(method, false), " threw exception"), e10.getCause());
            }
        } else {
            objInvoke = field.get(obj);
        }
        if (objInvoke == obj) {
            return;
        }
        bVar.Q(this.f9005a);
        this.f9018f.b(bVar, objInvoke);
    }
}
