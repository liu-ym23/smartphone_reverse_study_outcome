package com.stepos.aiengine.memory;

import android.util.Log;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.aiengine.memory.CameraLaunchReleaseHandler$onCameraScene$1", f = "CameraLaunchReleaseHandler.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CameraLaunchReleaseHandler$onCameraScene$1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CameraLaunchReleaseHandler f5824a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraLaunchReleaseHandler$onCameraScene$1(CameraLaunchReleaseHandler cameraLaunchReleaseHandler, b<? super CameraLaunchReleaseHandler$onCameraScene$1> bVar) {
        super(2, bVar);
        this.f5824a = cameraLaunchReleaseHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        return new CameraLaunchReleaseHandler$onCameraScene$1(this.f5824a, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
        return ((CameraLaunchReleaseHandler$onCameraScene$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        kotlin.c.b(obj);
        CameraLaunchReleaseHandler cameraLaunchReleaseHandler = this.f5824a;
        Job job = cameraLaunchReleaseHandler.f5822i;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        cameraLaunchReleaseHandler.f5822i = null;
        try {
            cameraLaunchReleaseHandler.f5816b.invoke(Boolean.FALSE);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.w("CameraLaunchRelease", "bgDispatchPauser(false) threw: " + thB.getMessage(), thB);
        }
        return n.f10413a;
    }
}
