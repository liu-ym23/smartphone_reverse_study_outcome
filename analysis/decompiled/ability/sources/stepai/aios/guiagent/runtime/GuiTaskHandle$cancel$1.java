package stepai.aios.guiagent.runtime;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "stepai.aios.guiagent.runtime.GuiTaskHandle$cancel$1", f = "GuiTaskHandle.kt", l = {21}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class GuiTaskHandle$cancel$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f6127a;
    public final /* synthetic */ b b;
    public final /* synthetic */ String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiTaskHandle$cancel$1(b bVar, String str, H7.c cVar) {
        super(2, cVar);
        this.b = bVar;
        this.c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new GuiTaskHandle$cancel$1(this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((GuiTaskHandle$cancel$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f6127a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        b bVar = this.b;
        a aVar = bVar.b;
        String str = bVar.f6130a;
        this.f6127a = 1;
        stepai.aios.guiagent.pipeline.b bVar2 = aVar.g;
        bVar2.getClass();
        Object objK = stepai.aios.guiagent.pipeline.b.K(bVar2, str, this.c, this);
        return objK == coroutineSingletons ? coroutineSingletons : objK;
    }
}
