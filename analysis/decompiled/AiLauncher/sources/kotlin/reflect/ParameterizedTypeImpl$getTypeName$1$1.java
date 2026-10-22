package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class ParameterizedTypeImpl$getTypeName$1$1 extends FunctionReferenceImpl implements InterfaceC5074l<Type, String> {

    /* renamed from: a, reason: collision with root package name */
    public static final ParameterizedTypeImpl$getTypeName$1$1 f34854a = new ParameterizedTypeImpl$getTypeName$1$1();

    public ParameterizedTypeImpl$getTypeName$1$1() {
        super(1, TypesJVMKt.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final String invoke(Type p02) {
        p.i(p02, "p0");
        return TypesJVMKt.h(p02);
    }
}
