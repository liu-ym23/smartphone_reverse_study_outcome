package kotlinx.coroutines.flow.internal;

import C7.r;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@J7.c(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", l = {208}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "it", "LC7/r;", "<anonymous>"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final class UndispatchedContextCollector$emitRef$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f5243a;
    public /* synthetic */ Object b;
    public final /* synthetic */ p9.d c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UndispatchedContextCollector$emitRef$1(p9.d dVar, H7.c cVar) {
        super(2, cVar);
        this.c = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        UndispatchedContextCollector$emitRef$1 undispatchedContextCollector$emitRef$1 = new UndispatchedContextCollector$emitRef$1(this.c, cVar);
        undispatchedContextCollector$emitRef$1.b = obj;
        return undispatchedContextCollector$emitRef$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((UndispatchedContextCollector$emitRef$1) create(obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f5243a;
        if (i == 0) {
            kotlin.b.b(obj);
            Object obj2 = this.b;
            this.f5243a = 1;
            if (this.c.emit(obj2, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        return r.f317a;
    }
}
