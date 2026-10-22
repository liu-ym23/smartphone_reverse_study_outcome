package kotlin.reflect.jvm.internal.impl.types.checker;

import S7.k;
import Z7.f;
import a9.InterfaceC0310b;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.m;

/* loaded from: classes4.dex */
final /* synthetic */ class KotlinTypePreparator$prepareType$1 extends FunctionReference implements k {
    @Override // kotlin.jvm.internal.CallableReference, Z7.c
    public final String getName() {
        return "prepareType";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final f getOwner() {
        return m.f4928a.b(a.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;";
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        InterfaceC0310b p02 = (InterfaceC0310b) obj;
        kotlin.jvm.internal.k.f(p02, "p0");
        return ((a) this.receiver).a(p02);
    }
}
