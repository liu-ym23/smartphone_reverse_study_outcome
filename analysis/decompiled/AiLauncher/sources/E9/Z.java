package E9;

import java.util.Collection;
import p9.InterfaceC5074l;
import ya.v0;

/* loaded from: classes5.dex */
public interface Z {

    public static final class a implements Z {

        /* renamed from: a, reason: collision with root package name */
        public static final a f2446a = new a();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // E9.Z
        public Collection<ya.S> a(v0 currentTypeConstructor, Collection<? extends ya.S> superTypes, InterfaceC5074l<? super v0, ? extends Iterable<? extends ya.S>> neighbors, InterfaceC5074l<? super ya.S, Y8.t> reportLoop) {
            kotlin.jvm.internal.p.i(currentTypeConstructor, "currentTypeConstructor");
            kotlin.jvm.internal.p.i(superTypes, "superTypes");
            kotlin.jvm.internal.p.i(neighbors, "neighbors");
            kotlin.jvm.internal.p.i(reportLoop, "reportLoop");
            return superTypes;
        }
    }

    Collection<ya.S> a(v0 v0Var, Collection<? extends ya.S> collection, InterfaceC5074l<? super v0, ? extends Iterable<? extends ya.S>> interfaceC5074l, InterfaceC5074l<? super ya.S, Y8.t> interfaceC5074l2);
}
