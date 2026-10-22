package kotlinx.coroutines.flow.internal;

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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LWa/p;", "it", "LY8/t;", "<anonymous>", "(LWa/p;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {56}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class ChannelFlow$collectToFun$1<T> extends SuspendLambda implements p<Wa.p<? super T>, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f36681a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36682b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ChannelFlow<T> f36683c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlow$collectToFun$1(ChannelFlow<T> channelFlow, InterfaceC4014c<? super ChannelFlow$collectToFun$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f36683c = channelFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this.f36683c, interfaceC4014c);
        channelFlow$collectToFun$1.f36682b = obj;
        return channelFlow$collectToFun$1;
    }

    @Override // p9.p
    public final Object invoke(Wa.p<? super T> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ChannelFlow$collectToFun$1) create(pVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Wa.p<? super T> pVar = (Wa.p) this.f36682b;
        Object objG = C4063a.g();
        int i10 = this.f36681a;
        if (i10 == 0) {
            C4849c.b(obj);
            ChannelFlow<T> channelFlow = this.f36683c;
            this.f36682b = h.a(pVar);
            this.f36681a = 1;
            if (channelFlow.i(pVar, this) == objG) {
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
