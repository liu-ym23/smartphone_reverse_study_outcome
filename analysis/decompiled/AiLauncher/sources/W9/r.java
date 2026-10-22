package W9;

import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import p9.InterfaceC5063a;

/* loaded from: classes5.dex */
public class r implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final V9.k f6772a;

    /* renamed from: b, reason: collision with root package name */
    public final LazyJavaClassMemberScope f6773b;

    public r(V9.k kVar, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        this.f6772a = kVar;
        this.f6773b = lazyJavaClassMemberScope;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return LazyJavaClassMemberScope.X0(this.f6772a, this.f6773b);
    }
}
