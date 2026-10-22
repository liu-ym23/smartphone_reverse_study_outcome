package androidx.camera.camera2.adapter;

import D.C0777n;
import Xa.c;
import Y8.t;
import android.util.Log;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.q;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"LXa/c;", "", "LD/n;", "", "e", "LY8/t;", "<anonymous>", "(LXa/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.adapter.PipeCameraPresenceSource$startMonitoring$3", f = "PipeCameraPresenceSource.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class PipeCameraPresenceSource$startMonitoring$3 extends SuspendLambda implements q<c<? super List<? extends C0777n>>, Throwable, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9342a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f9343b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PipeCameraPresenceSource f9344c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PipeCameraPresenceSource$startMonitoring$3(PipeCameraPresenceSource pipeCameraPresenceSource, InterfaceC4014c<? super PipeCameraPresenceSource$startMonitoring$3> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.f9344c = pipeCameraPresenceSource;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(c<? super List<C0777n>> cVar, Throwable th, InterfaceC4014c<? super t> interfaceC4014c) {
        PipeCameraPresenceSource$startMonitoring$3 pipeCameraPresenceSource$startMonitoring$3 = new PipeCameraPresenceSource$startMonitoring$3(this.f9344c, interfaceC4014c);
        pipeCameraPresenceSource$startMonitoring$3.f9343b = th;
        return pipeCameraPresenceSource$startMonitoring$3.invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f9342a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        Throwable th = (Throwable) this.f9343b;
        Log.e("PipePresenceSrc", "Error in camera ID flow collection.", th);
        if (this.f9344c.isMonitoring.get()) {
            this.f9344c.i(th);
        } else {
            C4109a.f(Log.d("PipePresenceSrc", "Ignoring error because monitoring is stopped."));
        }
        return t.f7040a;
    }

    @Override // p9.q
    public /* bridge */ /* synthetic */ Object invoke(c<? super List<? extends C0777n>> cVar, Throwable th, InterfaceC4014c<? super t> interfaceC4014c) {
        return invoke2((c<? super List<C0777n>>) cVar, th, interfaceC4014c);
    }
}
