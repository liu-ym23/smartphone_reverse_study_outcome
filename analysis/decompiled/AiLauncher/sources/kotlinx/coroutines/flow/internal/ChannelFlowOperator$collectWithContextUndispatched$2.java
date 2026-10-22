package kotlinx.coroutines.flow.internal;

import Xa.c;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LXa/c;", "it", "LY8/t;", "<anonymous>", "(LXa/c;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", l = {148}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class ChannelFlowOperator$collectWithContextUndispatched$2<T> extends SuspendLambda implements p<c<? super T>, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f36697a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36698b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ChannelFlowOperator<S, T> f36699c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlowOperator$collectWithContextUndispatched$2(ChannelFlowOperator<S, T> channelFlowOperator, InterfaceC4014c<? super ChannelFlowOperator$collectWithContextUndispatched$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f36699c = channelFlowOperator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ChannelFlowOperator$collectWithContextUndispatched$2 channelFlowOperator$collectWithContextUndispatched$2 = new ChannelFlowOperator$collectWithContextUndispatched$2(this.f36699c, interfaceC4014c);
        channelFlowOperator$collectWithContextUndispatched$2.f36698b = obj;
        return channelFlowOperator$collectWithContextUndispatched$2;
    }

    @Override // p9.p
    public final Object invoke(c<? super T> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ChannelFlowOperator$collectWithContextUndispatched$2) create(cVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        c<? super T> cVar = (c) this.f36698b;
        Object objG = C4063a.g();
        int i10 = this.f36697a;
        if (i10 == 0) {
            C4849c.b(obj);
            ChannelFlowOperator<S, T> channelFlowOperator = this.f36699c;
            this.f36698b = h.a(cVar);
            this.f36697a = 1;
            if (channelFlowOperator.r(cVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
