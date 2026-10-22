package androidx.camera.camera2.pipe.core;

import Ua.Q;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.p;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LY8/t;", "it", "<anonymous>", "(V)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.core.PruningProcessingQueue$processingLoop$2$1$2", f = "PruningProcessingQueue.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class PruningProcessingQueue$processingLoop$2$1$2 extends SuspendLambda implements p<t, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10730a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<Q<t>> f10731b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PruningProcessingQueue$processingLoop$2$1$2(Ref$ObjectRef<Q<t>> ref$ObjectRef, InterfaceC4014c<? super PruningProcessingQueue$processingLoop$2$1$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10731b = ref$ObjectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PruningProcessingQueue$processingLoop$2$1$2(this.f10731b, interfaceC4014c);
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(t tVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((PruningProcessingQueue$processingLoop$2$1$2) create(tVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f10730a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.f10731b.f34820a = null;
        return t.f7040a;
    }
}
