package W9;

import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import p9.InterfaceC5074l;

/* renamed from: W9.v, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C1112v implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.descriptors.g f6778a;

    /* renamed from: b, reason: collision with root package name */
    public final LazyJavaClassMemberScope f6779b;

    public C1112v(kotlin.reflect.jvm.internal.impl.descriptors.g gVar, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        this.f6778a = gVar;
        this.f6779b = lazyJavaClassMemberScope;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return LazyJavaClassMemberScope.f1(this.f6778a, this.f6779b, (ga.e) obj);
    }
}
