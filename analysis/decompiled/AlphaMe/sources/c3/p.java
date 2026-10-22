package c3;

import b3.InterfaceC0380i;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes2.dex */
public final /* synthetic */ class p extends FunctionReferenceImpl implements Function3, SuspendFunction {

    /* renamed from: a, reason: collision with root package name */
    public static final p f4513a = new p();

    public p() {
        super(3, InterfaceC0380i.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((InterfaceC0380i) obj).emit(obj2, (Continuation) obj3);
    }
}
