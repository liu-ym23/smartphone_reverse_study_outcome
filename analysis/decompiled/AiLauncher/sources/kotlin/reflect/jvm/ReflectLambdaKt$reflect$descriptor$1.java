package kotlin.reflect.jvm;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import p9.p;
import ua.C5601K;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class ReflectLambdaKt$reflect$descriptor$1 extends FunctionReferenceImpl implements p<C5601K, ProtoBuf$Function, g> {

    /* renamed from: a, reason: collision with root package name */
    public static final ReflectLambdaKt$reflect$descriptor$1 f34866a = new ReflectLambdaKt$reflect$descriptor$1();

    public ReflectLambdaKt$reflect$descriptor$1() {
        super(2, C5601K.class, "loadFunction", "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;", 0);
    }

    @Override // p9.p
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final g invoke(C5601K p02, ProtoBuf$Function p12) {
        kotlin.jvm.internal.p.i(p02, "p0");
        kotlin.jvm.internal.p.i(p12, "p1");
        return p02.v(p12);
    }
}
