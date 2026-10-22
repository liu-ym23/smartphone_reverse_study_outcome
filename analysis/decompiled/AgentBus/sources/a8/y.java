package a8;

import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class y extends a0 implements f {

    /* renamed from: d, reason: collision with root package name */
    public final Object f466d;

    public y(Object obj, Method method) {
        super(method, d7.z.f2978f);
        this.f466d = obj;
    }

    @Override // a8.h
    public final Object h(Object[] objArr) {
        q7.k.e(objArr, "args");
        g.checkArguments(this, objArr);
        return this.f432a.invoke(this.f466d, Arrays.copyOf(objArr, objArr.length));
    }
}
