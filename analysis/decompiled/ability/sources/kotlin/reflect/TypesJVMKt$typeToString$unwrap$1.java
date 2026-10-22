package kotlin.reflect;

import S7.k;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class TypesJVMKt$typeToString$unwrap$1 extends FunctionReferenceImpl implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final TypesJVMKt$typeToString$unwrap$1 f4934a = new TypesJVMKt$typeToString$unwrap$1();

    public TypesJVMKt$typeToString$unwrap$1() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        Class p02 = (Class) obj;
        kotlin.jvm.internal.k.f(p02, "p0");
        return p02.getComponentType();
    }
}
