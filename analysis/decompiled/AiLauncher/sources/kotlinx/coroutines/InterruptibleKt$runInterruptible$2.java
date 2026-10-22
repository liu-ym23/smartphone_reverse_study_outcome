package kotlinx.coroutines;

import Ua.M;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class InterruptibleKt$runInterruptible$2<T> extends SuspendLambda implements p<M, InterfaceC4014c<? super T>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f36228a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36229b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC5063a<T> f36230c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InterruptibleKt$runInterruptible$2(InterfaceC5063a<? extends T> interfaceC5063a, InterfaceC4014c<? super InterruptibleKt$runInterruptible$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f36230c = interfaceC5063a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(this.f36230c, interfaceC4014c);
        interruptibleKt$runInterruptible$2.f36229b = obj;
        return interruptibleKt$runInterruptible$2;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super T> interfaceC4014c) {
        return ((InterruptibleKt$runInterruptible$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        M m10 = (M) this.f36229b;
        C4063a.g();
        if (this.f36228a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return InterruptibleKt.d(m10.getCoroutineContext(), this.f36230c);
    }
}
