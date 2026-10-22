package stepai.aios.guiagent.takeover;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "stepai.aios.guiagent.takeover.TakeoverErrorHandler$executeWithRetry$4$1", f = "TakeoverErrorHandler.kt", l = {94}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lm9/z;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class TakeoverErrorHandler$executeWithRetry$4$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f6152a;
    public final /* synthetic */ k b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TakeoverErrorHandler$executeWithRetry$4$1(k kVar, H7.c cVar) {
        super(2, cVar);
        this.b = kVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new TakeoverErrorHandler$executeWithRetry$4$1(this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TakeoverErrorHandler$executeWithRetry$4$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f6152a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        this.f6152a = 1;
        Object objInvoke = this.b.invoke(this);
        return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
    }
}
