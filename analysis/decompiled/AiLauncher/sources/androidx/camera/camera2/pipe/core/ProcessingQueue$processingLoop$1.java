package androidx.camera.camera2.pipe.core;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.pipe.core.ProcessingQueue", f = "ProcessingQueue.kt", l = {102, 117}, m = "processingLoop", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProcessingQueue$processingLoop$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f10709a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10710b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ProcessingQueue<T> f10711c;

    /* renamed from: d, reason: collision with root package name */
    public int f10712d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProcessingQueue$processingLoop$1(ProcessingQueue<T> processingQueue, InterfaceC4014c<? super ProcessingQueue$processingLoop$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10711c = processingQueue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10710b = obj;
        this.f10712d |= Integer.MIN_VALUE;
        return this.f10711c.h(this);
    }
}
