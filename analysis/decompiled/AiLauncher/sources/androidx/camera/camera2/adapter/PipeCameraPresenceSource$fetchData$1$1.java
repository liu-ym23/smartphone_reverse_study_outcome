package androidx.camera.camera2.adapter;

import D.C0777n;
import Ua.M;
import Y8.t;
import android.util.Log;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.adapter.PipeCameraPresenceSource$fetchData$1$1", f = "PipeCameraPresenceSource.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class PipeCameraPresenceSource$fetchData$1$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9335a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PipeCameraPresenceSource f9336b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a<List<C0777n>> f9337c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PipeCameraPresenceSource$fetchData$1$1(PipeCameraPresenceSource pipeCameraPresenceSource, CallbackToFutureAdapter.a<List<C0777n>> aVar, InterfaceC4014c<? super PipeCameraPresenceSource$fetchData$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f9336b = pipeCameraPresenceSource;
        this.f9337c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PipeCameraPresenceSource$fetchData$1$1(this.f9336b, this.f9337c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((PipeCameraPresenceSource$fetchData$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f9335a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        try {
            String[] cameraIdList = this.f9336b.cameraManager.getCameraIdList();
            kotlin.jvm.internal.p.h(cameraIdList, "getCameraIdList(...)");
            ArrayList arrayList = new ArrayList();
            for (String str : cameraIdList) {
                C0777n c0777nD = null;
                try {
                    kotlin.jvm.internal.p.f(str);
                    c0777nD = C0777n.a.d(str, null, null, 6, null);
                } catch (IllegalArgumentException e10) {
                    Log.w("PipePresenceSrc", "Could not create CameraIdentifier for system ID: " + str, e10);
                }
                if (c0777nD != null) {
                    arrayList.add(c0777nD);
                }
            }
            Log.d("PipePresenceSrc", "[FetchData] Refreshed camera list from hardware: " + arrayList);
            this.f9336b.h(arrayList);
            this.f9337c.c(arrayList);
        } catch (Exception e11) {
            Log.e("PipePresenceSrc", "[FetchData] Failed to refresh camera list from hardware.", e11);
            this.f9336b.i(e11);
            this.f9337c.f(e11);
        }
        return t.f7040a;
    }
}
