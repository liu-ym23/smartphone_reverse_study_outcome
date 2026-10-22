package n8;

import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.collections.EmptyList;
import x8.InterfaceC2121d;

/* loaded from: classes4.dex */
public final class s extends u implements InterfaceC2121d {

    /* renamed from: a, reason: collision with root package name */
    public final Class f5364a;
    public final EmptyList b = EmptyList.f4893a;

    public s(Class cls) {
        this.f5364a = cls;
    }

    @Override // n8.u
    public final Type b() {
        return this.f5364a;
    }

    @Override // x8.InterfaceC2119b
    public final Collection getAnnotations() {
        return this.b;
    }
}
