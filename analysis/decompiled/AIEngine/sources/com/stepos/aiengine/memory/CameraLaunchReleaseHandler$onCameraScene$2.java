package com.stepos.aiengine.memory;

import android.util.Log;
import com.stepos.base.health.EngineMetrics;
import h0.e;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import lb.n;
import mb.k;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.aiengine.memory.CameraLaunchReleaseHandler$onCameraScene$2", f = "CameraLaunchReleaseHandler.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CameraLaunchReleaseHandler$onCameraScene$2 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CameraLaunchReleaseHandler f5825a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5826b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5827c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraLaunchReleaseHandler$onCameraScene$2(CameraLaunchReleaseHandler cameraLaunchReleaseHandler, int i10, int i11, b<? super CameraLaunchReleaseHandler$onCameraScene$2> bVar) {
        super(2, bVar);
        this.f5825a = cameraLaunchReleaseHandler;
        this.f5826b = i10;
        this.f5827c = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        return new CameraLaunchReleaseHandler$onCameraScene$2(this.f5825a, this.f5826b, this.f5827c, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
        return ((CameraLaunchReleaseHandler$onCameraScene$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        Object objA2;
        int iIntValue;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        kotlin.c.b(obj);
        int i10 = this.f5826b;
        CameraLaunchReleaseHandler cameraLaunchReleaseHandler = this.f5825a;
        zb.a<Integer> aVar = cameraLaunchReleaseHandler.f5820f;
        Job job = cameraLaunchReleaseHandler.f5822i;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        try {
            cameraLaunchReleaseHandler.f5816b.invoke(Boolean.TRUE);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.w("CameraLaunchRelease", "bgDispatchPauser(true) threw: " + thB.getMessage(), thB);
        }
        int iIntValue2 = aVar.invoke().intValue();
        try {
            objA2 = Integer.valueOf(cameraLaunchReleaseHandler.f5815a.invoke("camera:" + i10).intValue());
        } catch (Throwable th2) {
            objA2 = kotlin.c.a(th2);
        }
        Throwable thB2 = Result.b(objA2);
        if (thB2 != null) {
            Log.w("CameraLaunchRelease", "forceLowRelease threw: " + thB2.getMessage(), thB2);
        }
        if (objA2 instanceof Result.Failure) {
            objA2 = 0;
        }
        int iIntValue3 = ((Number) objA2).intValue();
        EngineMetrics.z.incrementAndGet();
        if (iIntValue3 > 0 && iIntValue2 >= 0 && (iIntValue = aVar.invoke().intValue()) >= 0 && iIntValue <= iIntValue2) {
            int i11 = iIntValue2 - iIntValue;
            k<Integer> kVar = cameraLaunchReleaseHandler.f5823j;
            kVar.addLast(Integer.valueOf(i11));
            while (kVar.f10558c > 32) {
                kVar.removeFirst();
            }
            List listH0 = kotlin.collections.a.H0(kVar);
            EngineMetrics.C.set(((Number) listH0.get(listH0.size() / 2)).intValue());
        }
        StringBuilder sbD = e.d(i10, "[memory] camera launch release: scene=", this.f5827c, " uid=", " released=");
        sbD.append(iIntValue3);
        Log.i("CameraLaunchRelease", sbD.toString());
        cameraLaunchReleaseHandler.f5822i = BuildersKt__Builders_commonKt.launch$default(cameraLaunchReleaseHandler.f5821g, null, null, new CameraLaunchReleaseHandler$releaseAndScheduleResume$3(cameraLaunchReleaseHandler, null), 3, null);
        return n.f10413a;
    }
}
