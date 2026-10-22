package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import ga.e;
import java.util.Collection;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final /* synthetic */ class LazyJavaClassMemberScope$computeNonDeclaredFunctions$3 extends FunctionReferenceImpl implements InterfaceC5074l<e, Collection<? extends g>> {
    public LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(Object obj) {
        super(1, obj, LazyJavaClassMemberScope.class, "searchMethodsByNameWithoutBuiltinMagic", "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;", 0);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Collection<g> invoke(e p02) {
        p.i(p02, "p0");
        return ((LazyJavaClassMemberScope) this.receiver).p1(p02);
    }
}
