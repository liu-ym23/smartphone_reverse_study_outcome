package a8;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class s extends r implements f {

    /* renamed from: g, reason: collision with root package name */
    public final Object f456g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Object obj, Method method) {
        super(method, false, 4);
        q7.k.e(method, "method");
        this.f456g = obj;
    }

    @Override // a8.r, a8.h
    public final Object h(Object[] objArr) {
        q7.k.e(objArr, "args");
        g.checkArguments(this, objArr);
        return c(objArr, this.f456g);
    }
}
