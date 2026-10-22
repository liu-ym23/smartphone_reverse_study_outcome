package kotlin.reflect.jvm;

import S7.n;
import T8.v;
import Z7.f;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final /* synthetic */ class ReflectLambdaKt$reflect$descriptor$1 extends FunctionReference implements n {

    /* renamed from: a, reason: collision with root package name */
    public static final ReflectLambdaKt$reflect$descriptor$1 f4936a = new ReflectLambdaKt$reflect$descriptor$1();

    public ReflectLambdaKt$reflect$descriptor$1() {
        super(2);
    }

    @Override // kotlin.jvm.internal.CallableReference, Z7.c
    public final String getName() {
        return "loadFunction";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final f getOwner() {
        return m.f4928a.b(v.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        v p02 = (v) obj;
        ProtoBuf$Function p1 = (ProtoBuf$Function) obj2;
        k.f(p02, "p0");
        k.f(p1, "p1");
        return p02.e(p1);
    }
}
