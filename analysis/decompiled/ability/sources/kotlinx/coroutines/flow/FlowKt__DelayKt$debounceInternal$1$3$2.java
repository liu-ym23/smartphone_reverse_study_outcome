package kotlinx.coroutines.flow;

import C7.r;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import o9.C1780f;
import o9.C1781g;
import o9.C1782h;

@J7.c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", l = {236}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lo9/h;", "", "value", "LC7/r;", "<anonymous>", "(Lo9/h;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public Ref$ObjectRef f5201a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ Ref$ObjectRef d;
    public final /* synthetic */ p9.d e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1$3$2(H7.c cVar, Ref$ObjectRef ref$ObjectRef, p9.d dVar) {
        super(2, cVar);
        this.d = ref$ObjectRef;
        this.e = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(cVar, this.d, this.e);
        flowKt__DelayKt$debounceInternal$1$3$2.c = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(new C1782h(((C1782h) obj).f5457a), (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.b;
        if (i == 0) {
            kotlin.b.b(obj);
            Object obj2 = ((C1782h) this.c).f5457a;
            boolean z10 = obj2 instanceof C1781g;
            ref$ObjectRef = this.d;
            if (!z10) {
                ref$ObjectRef.f4920a = obj2;
            }
            if (z10) {
                C1780f c1780f = obj2 instanceof C1780f ? (C1780f) obj2 : null;
                Throwable th = c1780f != null ? c1780f.f5456a : null;
                if (th != null) {
                    throw th;
                }
                Object obj3 = ref$ObjectRef.f4920a;
                if (obj3 != null) {
                    Object obj4 = obj3 != q9.b.b ? obj3 : null;
                    this.c = obj2;
                    this.f5201a = ref$ObjectRef;
                    this.b = 1;
                    if (this.e.emit(obj4, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    ref$ObjectRef2 = ref$ObjectRef;
                }
                ref$ObjectRef.f4920a = q9.b.d;
            }
            return r.f317a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ref$ObjectRef2 = this.f5201a;
        kotlin.b.b(obj);
        ref$ObjectRef = ref$ObjectRef2;
        ref$ObjectRef.f4920a = q9.b.d;
        return r.f317a;
    }
}
