package kotlinx.coroutines.flow.internal;

import S7.o;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class SafeCollectorKt$emitFun$1 extends FunctionReferenceImpl implements o {

    /* renamed from: a, reason: collision with root package name */
    public static final SafeCollectorKt$emitFun$1 f5242a = new SafeCollectorKt$emitFun$1();

    public SafeCollectorKt$emitFun$1() {
        super(3, p9.d.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((p9.d) obj).emit(obj2, (H7.c) obj3);
    }
}
