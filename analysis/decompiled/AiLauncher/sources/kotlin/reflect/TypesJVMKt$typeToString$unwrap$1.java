package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class TypesJVMKt$typeToString$unwrap$1 extends FunctionReferenceImpl implements InterfaceC5074l<Class<?>, Class<?>> {

    /* renamed from: a, reason: collision with root package name */
    public static final TypesJVMKt$typeToString$unwrap$1 f34856a = new TypesJVMKt$typeToString$unwrap$1();

    public TypesJVMKt$typeToString$unwrap$1() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Class<?> invoke(Class<?> p02) {
        p.i(p02, "p0");
        return p02.getComponentType();
    }
}
