package kotlin.reflect.jvm.internal.impl.types.checker;

import Ca.g;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import ya.K0;

/* loaded from: classes5.dex */
public final /* synthetic */ class KotlinTypePreparator$prepareType$1 extends FunctionReferenceImpl implements InterfaceC5074l<g, K0> {
    public KotlinTypePreparator$prepareType$1(Object obj) {
        super(1, obj, KotlinTypePreparator.class, "prepareType", "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;", 0);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final K0 invoke(g p02) {
        p.i(p02, "p0");
        return ((KotlinTypePreparator) this.receiver).a(p02);
    }
}
