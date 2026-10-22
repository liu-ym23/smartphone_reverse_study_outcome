package kotlin.reflect.jvm.internal.impl.descriptors;

import E9.AbstractC0811p;
import E9.InterfaceC0803h;
import E9.InterfaceC0816v;
import java.util.Collection;

/* loaded from: classes5.dex */
public interface CallableMemberDescriptor extends a, InterfaceC0816v {

    public enum Kind {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public boolean isReal() {
            return this != FAKE_OVERRIDE;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a, E9.InterfaceC0803h
    CallableMemberDescriptor a();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    Collection<? extends CallableMemberDescriptor> d();

    Kind getKind();

    void x0(Collection<? extends CallableMemberDescriptor> collection);

    CallableMemberDescriptor y(InterfaceC0803h interfaceC0803h, Modality modality, AbstractC0811p abstractC0811p, Kind kind, boolean z10);
}
