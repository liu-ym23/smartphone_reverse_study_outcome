package a8;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: classes.dex */
public final class b0 implements h {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f440a = new b0();

    @Override // a8.h
    public final Type f() {
        Class cls = Void.TYPE;
        q7.k.d(cls, "TYPE");
        return cls;
    }

    @Override // a8.h
    public final Object h(Object[] objArr) {
        q7.k.e(objArr, "args");
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    @Override // a8.h
    public final List i() {
        return d7.z.f2978f;
    }

    @Override // a8.h
    public final /* bridge */ /* synthetic */ Member j() {
        return null;
    }
}
