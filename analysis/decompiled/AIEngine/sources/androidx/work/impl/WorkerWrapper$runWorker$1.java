package androidx.work.impl;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "androidx.work.impl.WorkerWrapper", f = "WorkerWrapper.kt", l = {299}, m = "runWorker")
/* loaded from: classes.dex */
final class WorkerWrapper$runWorker$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public d f2849a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2850b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f2851c;

    /* renamed from: d, reason: collision with root package name */
    public int f2852d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$runWorker$1(d dVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f2851c = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f2850b = obj;
        this.f2852d |= Integer.MIN_VALUE;
        return d.a(this.f2851c, this);
    }
}
