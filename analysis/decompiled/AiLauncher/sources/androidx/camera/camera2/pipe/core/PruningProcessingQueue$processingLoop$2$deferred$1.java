package androidx.camera.camera2.pipe.core;

import Ua.M;
import Y8.t;
import android.util.Log;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import z.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.core.PruningProcessingQueue$processingLoop$2$deferred$1", f = "PruningProcessingQueue.kt", l = {152}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class PruningProcessingQueue$processingLoop$2$deferred$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10732a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PruningProcessingQueue<T> f10733b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ T f10734c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PruningProcessingQueue$processingLoop$2$deferred$1(PruningProcessingQueue<T> pruningProcessingQueue, T t10, InterfaceC4014c<? super PruningProcessingQueue$processingLoop$2$deferred$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10733b = pruningProcessingQueue;
        this.f10734c = t10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PruningProcessingQueue$processingLoop$2$deferred$1(this.f10733b, this.f10734c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((PruningProcessingQueue$processingLoop$2$deferred$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10732a;
        if (i10 == 0) {
            C4849c.b(obj);
            k kVar = k.f44508a;
            Object obj2 = this.f10734c;
            if (kVar.a()) {
                Log.d("CXCP", "PruningProcessingQueue: Processing " + obj2);
            }
            p pVar = this.f10733b.process;
            T t10 = this.f10734c;
            this.f10732a = 1;
            if (pVar.invoke(t10, this) == objG) {
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
