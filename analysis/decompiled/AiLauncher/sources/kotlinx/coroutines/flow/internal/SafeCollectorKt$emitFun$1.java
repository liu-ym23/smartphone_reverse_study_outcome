package kotlinx.coroutines.flow.internal;

import Xa.c;
import Y8.t;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.q;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class SafeCollectorKt$emitFun$1 extends FunctionReferenceImpl implements q<c<? super Object>, Object, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final SafeCollectorKt$emitFun$1 f36762a = new SafeCollectorKt$emitFun$1();

    public SafeCollectorKt$emitFun$1() {
        super(3, c.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // p9.q
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Object invoke(c<Object> cVar, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
        return cVar.emit(obj, interfaceC4014c);
    }
}
