package S9;

import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.InterfaceC0812q;
import ka.C4828h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* renamed from: S9.l, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1013l {
    public static /* synthetic */ void a(int i10) {
        Object[] objArr = new Object[3];
        if (i10 == 1 || i10 == 2) {
            objArr[0] = "companionObject";
        } else if (i10 != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i10 == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i10 == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i10 != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean b(CallableMemberDescriptor callableMemberDescriptor) {
        InterfaceC0812q interfaceC0812qR0;
        if (callableMemberDescriptor == null) {
            a(3);
        }
        if ((callableMemberDescriptor instanceof E9.O) && (interfaceC0812qR0 = ((E9.O) callableMemberDescriptor).r0()) != null && interfaceC0812qR0.getAnnotations().E(E.f5679b)) {
            return true;
        }
        return callableMemberDescriptor.getAnnotations().E(E.f5679b);
    }

    public static boolean c(InterfaceC0803h interfaceC0803h) {
        if (interfaceC0803h == null) {
            a(1);
        }
        return C4828h.x(interfaceC0803h) && C4828h.w(interfaceC0803h.b()) && !d((InterfaceC0797b) interfaceC0803h);
    }

    public static boolean d(InterfaceC0797b interfaceC0797b) {
        if (interfaceC0797b == null) {
            a(2);
        }
        return C9.e.a(C9.d.f1773a, interfaceC0797b);
    }

    public static boolean e(E9.O o10) {
        if (o10 == null) {
            a(0);
        }
        if (o10.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return false;
        }
        if (c(o10.b())) {
            return true;
        }
        return C4828h.x(o10.b()) && b(o10);
    }
}
