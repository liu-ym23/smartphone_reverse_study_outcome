package z9;

import H9.C0836o;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lz9/k;", "LH9/o;", "Lkotlin/reflect/jvm/internal/d;", "LY8/t;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "LE9/O;", "descriptor", "data", "visitPropertyDescriptor", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;LY8/t;)Lkotlin/reflect/jvm/internal/d;", "Lkotlin/reflect/jvm/internal/impl/descriptors/e;", "visitFunctionDescriptor", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;LY8/t;)Lkotlin/reflect/jvm/internal/d;", Const.INTENT_KEY_APIKEY, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: z9.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C6423k extends C0836o<kotlin.reflect.jvm.internal.d<?>, Y8.t> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final KDeclarationContainerImpl container;

    public C6423k(KDeclarationContainerImpl container) {
        kotlin.jvm.internal.p.i(container, "container");
        this.container = container;
    }

    @Override // H9.C0836o, E9.InterfaceC0805j
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.d<?> i(kotlin.reflect.jvm.internal.impl.descriptors.e descriptor, Y8.t data) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(data, "data");
        return new kotlin.reflect.jvm.internal.f(this.container, descriptor);
    }

    @Override // E9.InterfaceC0805j
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.d<?> h(E9.O descriptor, Y8.t data) {
        int i10;
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(data, "data");
        List<E9.S> listS0 = descriptor.s0();
        kotlin.jvm.internal.p.h(listS0, "getContextReceiverParameters(...)");
        if (listS0.isEmpty()) {
            i10 = (descriptor.H() != null ? 1 : 0) + (descriptor.K() != null ? 1 : 0);
        } else {
            i10 = -1;
        }
        if (descriptor.J()) {
            if (i10 == -1) {
                return new kotlin.reflect.jvm.internal.j(this.container, descriptor);
            }
            if (i10 == 0) {
                return new kotlin.reflect.jvm.internal.g(this.container, descriptor);
            }
            if (i10 == 1) {
                return new kotlin.reflect.jvm.internal.h(this.container, descriptor);
            }
            if (i10 == 2) {
                return new kotlin.reflect.jvm.internal.i(this.container, descriptor);
            }
        } else {
            if (i10 == -1) {
                return new kotlin.reflect.jvm.internal.r(this.container, descriptor);
            }
            if (i10 == 0) {
                return new kotlin.reflect.jvm.internal.m(this.container, descriptor);
            }
            if (i10 == 1) {
                return new kotlin.reflect.jvm.internal.n(this.container, descriptor);
            }
            if (i10 == 2) {
                return new kotlin.reflect.jvm.internal.o(this.container, descriptor);
            }
        }
        throw new KotlinReflectionInternalError("Unsupported property: " + descriptor);
    }
}
