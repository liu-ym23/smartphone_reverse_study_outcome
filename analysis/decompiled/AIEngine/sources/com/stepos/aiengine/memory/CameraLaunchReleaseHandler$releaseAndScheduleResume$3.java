package com.stepos.aiengine.memory;

import android.util.Log;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.aiengine.memory.CameraLaunchReleaseHandler$releaseAndScheduleResume$3", f = "CameraLaunchReleaseHandler.kt", l = {123}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class CameraLaunchReleaseHandler$releaseAndScheduleResume$3 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f5828a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f5829b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CameraLaunchReleaseHandler f5830c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraLaunchReleaseHandler$releaseAndScheduleResume$3(CameraLaunchReleaseHandler cameraLaunchReleaseHandler, b<? super CameraLaunchReleaseHandler$releaseAndScheduleResume$3> bVar) {
        super(2, bVar);
        this.f5830c = cameraLaunchReleaseHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        CameraLaunchReleaseHandler$releaseAndScheduleResume$3 cameraLaunchReleaseHandler$releaseAndScheduleResume$3 = new CameraLaunchReleaseHandler$releaseAndScheduleResume$3(this.f5830c, bVar);
        cameraLaunchReleaseHandler$releaseAndScheduleResume$3.f5829b = obj;
        return cameraLaunchReleaseHandler$releaseAndScheduleResume$3;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
        return ((CameraLaunchReleaseHandler$releaseAndScheduleResume$3) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f5828a;
        CameraLaunchReleaseHandler cameraLaunchReleaseHandler = this.f5830c;
        if (i10 == 0) {
            kotlin.c.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f5829b;
            long jLongValue = cameraLaunchReleaseHandler.f5819e.invoke().longValue();
            this.f5829b = coroutineScope;
            this.f5828a = 1;
            if (DelayKt.delay(jLongValue, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
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
