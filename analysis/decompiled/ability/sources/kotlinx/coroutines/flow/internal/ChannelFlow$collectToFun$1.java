package kotlinx.coroutines.flow.internal;

import C7.r;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import o9.InterfaceC1786l;

@J7.c(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {56}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lo9/l;", "it", "LC7/r;", "<anonymous>", "(Lo9/l;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final class ChannelFlow$collectToFun$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f5231a;
    public /* synthetic */ Object b;
    public final /* synthetic */ a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlow$collectToFun$1(a aVar, H7.c cVar) {
        super(2, cVar);
        this.c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this.c, cVar);
        channelFlow$collectToFun$1.b = obj;
        return channelFlow$collectToFun$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelFlow$collectToFun$1) create((InterfaceC1786l) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f5231a;
        if (i == 0) {
            kotlin.b.b(obj);
            InterfaceC1786l interfaceC1786l = (InterfaceC1786l) this.b;
            this.f5231a = 1;
            if (this.c.e(interfaceC1786l, this) == coroutineSingletons) {
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
