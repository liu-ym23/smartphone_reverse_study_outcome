package J9;

import E9.InterfaceC0797b;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import ua.InterfaceC5636v;

/* loaded from: classes5.dex */
public final class j implements InterfaceC5636v {

    /* renamed from: b, reason: collision with root package name */
    public static final j f3799b = new j();

    @Override // ua.InterfaceC5636v
    public void a(CallableMemberDescriptor descriptor) {
        p.i(descriptor, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + descriptor);
    }

    @Override // ua.InterfaceC5636v
    public void b(InterfaceC0797b descriptor, List<String> unresolvedSuperClasses) {
        p.i(descriptor, "descriptor");
        p.i(unresolvedSuperClasses, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + descriptor.getName() + ", unresolved classes " + unresolvedSuperClasses);
    }
}
