package W9;

import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import p9.InterfaceC5074l;

/* renamed from: W9.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C1110t implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final LazyJavaClassMemberScope f6775a;

    /* renamed from: b, reason: collision with root package name */
    public final V9.k f6776b;

    public C1110t(LazyJavaClassMemberScope lazyJavaClassMemberScope, V9.k kVar) {
        this.f6775a = lazyJavaClassMemberScope;
        this.f6776b = kVar;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return LazyJavaClassMemberScope.h1(this.f6775a, this.f6776b, (ga.e) obj);
    }
}
