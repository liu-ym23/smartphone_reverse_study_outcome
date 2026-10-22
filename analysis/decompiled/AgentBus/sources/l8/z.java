package l8;

import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes.dex */
public final class z extends b0 implements v8.d {

    /* renamed from: a, reason: collision with root package name */
    public final Class f5888a;

    public z(Class cls) {
        this.f5888a = cls;
    }

    @Override // l8.b0
    public final Type b() {
        return this.f5888a;
    }

    @Override // v8.b
    public final Collection getAnnotations() {
        return d7.z.f2978f;
    }
}
