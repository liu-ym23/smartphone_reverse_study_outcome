package ua;

import E9.InterfaceC0797b;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* renamed from: ua.v, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC5636v {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC5636v f42653a = new a();

    /* renamed from: ua.v$a */
    public static class a implements InterfaceC5636v {
        public static /* synthetic */ void c(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "unresolvedSuperClasses";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
            if (i10 != 2) {
                objArr[2] = "reportIncompleteHierarchy";
            } else {
                objArr[2] = "reportCannotInferVisibility";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ua.InterfaceC5636v
        public void a(CallableMemberDescriptor callableMemberDescriptor) {
            if (callableMemberDescriptor == null) {
                c(2);
            }
        }

        @Override // ua.InterfaceC5636v
        public void b(InterfaceC0797b interfaceC0797b, List<String> list) {
            if (interfaceC0797b == null) {
                c(0);
            }
            if (list == null) {
                c(1);
            }
        }
    }

    void a(CallableMemberDescriptor callableMemberDescriptor);

    void b(InterfaceC0797b interfaceC0797b, List<String> list);
}
