package kotlin.reflect.jvm.internal;

import S7.n;
import T8.v;
import Z7.f;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class KClassImpl$getLocalProperty$2$1$1 extends FunctionReference implements n {

    /* renamed from: a, reason: collision with root package name */
    public static final KClassImpl$getLocalProperty$2$1$1 f4937a = new KClassImpl$getLocalProperty$2$1$1();

    public KClassImpl$getLocalProperty$2$1$1() {
        super(2);
    }

    @Override // kotlin.jvm.internal.CallableReference, Z7.c
    public final String getName() {
        return "loadProperty";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final f getOwner() {
        return m.f4928a.b(v.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        v p02 = (v) obj;
        ProtoBuf$Property p1 = (ProtoBuf$Property) obj2;
        k.f(p02, "p0");
        k.f(p1, "p1");
        return p02.f(p1);
    }
}
