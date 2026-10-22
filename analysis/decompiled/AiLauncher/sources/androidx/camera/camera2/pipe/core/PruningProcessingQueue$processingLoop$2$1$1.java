package androidx.camera.camera2.pipe.core;

import Y8.t;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.a;
import p9.p;
import z.k;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "it", "LY8/t;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.core.PruningProcessingQueue$processingLoop$2$1$1", f = "PruningProcessingQueue.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class PruningProcessingQueue$processingLoop$2$1$1<T> extends SuspendLambda implements p<T, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10727a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10728b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PruningProcessingQueue<T> f10729c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PruningProcessingQueue$processingLoop$2$1$1(PruningProcessingQueue<T> pruningProcessingQueue, InterfaceC4014c<? super PruningProcessingQueue$processingLoop$2$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10729c = pruningProcessingQueue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        PruningProcessingQueue$processingLoop$2$1$1 pruningProcessingQueue$processingLoop$2$1$1 = new PruningProcessingQueue$processingLoop$2$1$1(this.f10729c, interfaceC4014c);
        pruningProcessingQueue$processingLoop$2$1$1.f10728b = obj;
        return pruningProcessingQueue$processingLoop$2$1$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(T t10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((PruningProcessingQueue$processingLoop$2$1$1) create(t10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f10727a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.f10729c.queue.add(this.f10728b);
        Object objS = this.f10729c.channel.s();
        while (a.j(objS)) {
            this.f10729c.queue.add(a.g(objS));
            objS = this.f10729c.channel.s();
        }
        k kVar = k.f44508a;
        PruningProcessingQueue<T> pruningProcessingQueue = this.f10729c;
        if (kVar.a()) {
            Log.d("CXCP", "PruningProcessingQueue: Pruning " + pruningProcessingQueue.queue);
        }
        this.f10729c.prune.invoke(this.f10729c.queue);
        return t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
        return invoke2((PruningProcessingQueue$processingLoop$2$1$1<T>) obj, interfaceC4014c);
    }
}
