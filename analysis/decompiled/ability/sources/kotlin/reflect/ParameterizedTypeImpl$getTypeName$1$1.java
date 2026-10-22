package kotlin.reflect;

import S7.k;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class ParameterizedTypeImpl$getTypeName$1$1 extends FunctionReferenceImpl implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final ParameterizedTypeImpl$getTypeName$1$1 f4933a = new ParameterizedTypeImpl$getTypeName$1$1();

    public ParameterizedTypeImpl$getTypeName$1$1() {
        super(1, b.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        Type p02 = (Type) obj;
        kotlin.jvm.internal.k.f(p02, "p0");
        return b.a(p02);
    }
}
