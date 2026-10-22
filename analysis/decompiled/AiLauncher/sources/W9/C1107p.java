package W9;

import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import p9.InterfaceC5063a;

/* renamed from: W9.p, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C1107p implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final LazyJavaClassMemberScope f6769a;

    /* renamed from: b, reason: collision with root package name */
    public final V9.k f6770b;

    public C1107p(LazyJavaClassMemberScope lazyJavaClassMemberScope, V9.k kVar) {
        this.f6769a = lazyJavaClassMemberScope;
        this.f6770b = kVar;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return LazyJavaClassMemberScope.C0(this.f6769a, this.f6770b);
    }
}
