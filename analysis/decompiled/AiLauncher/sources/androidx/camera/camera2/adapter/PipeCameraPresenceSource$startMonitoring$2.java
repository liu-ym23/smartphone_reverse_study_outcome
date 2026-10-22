package androidx.camera.camera2.adapter;

import D.C0777n;
import Y8.t;
import Z8.F;
import android.util.Log;
import androidx.concurrent.futures.ListenableFutureKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g3.InterfaceFutureC4095a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "LD/n;", "identifiers", "LY8/t;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.adapter.PipeCameraPresenceSource$startMonitoring$2", f = "PipeCameraPresenceSource.kt", l = {84}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class PipeCameraPresenceSource$startMonitoring$2 extends SuspendLambda implements p<List<? extends C0777n>, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9338a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f9339b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PipeCameraPresenceSource f9340c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref$BooleanRef f9341d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PipeCameraPresenceSource$startMonitoring$2(PipeCameraPresenceSource pipeCameraPresenceSource, Ref$BooleanRef ref$BooleanRef, InterfaceC4014c<? super PipeCameraPresenceSource$startMonitoring$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f9340c = pipeCameraPresenceSource;
        this.f9341d = ref$BooleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        PipeCameraPresenceSource$startMonitoring$2 pipeCameraPresenceSource$startMonitoring$2 = new PipeCameraPresenceSource$startMonitoring$2(this.f9340c, this.f9341d, interfaceC4014c);
        pipeCameraPresenceSource$startMonitoring$2.f9339b = obj;
        return pipeCameraPresenceSource$startMonitoring$2;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(List<C0777n> list, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((PipeCameraPresenceSource$startMonitoring$2) create(list, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9338a;
        if (i10 == 0) {
            C4849c.b(obj);
            List list = (List) this.f9339b;
            Log.d("PipePresenceSrc", "Flow emitted new camera set: " + F.A0(list, null, null, null, 0, null, null, 63, null));
            if (!this.f9340c.isMonitoring.get()) {
                C4109a.f(Log.d("PipePresenceSrc", "Ignoring camera update because monitoring is stopped."));
            } else if (this.f9341d.f34815a) {
                Log.i("PipePresenceSrc", "Handling first camera set, triggering fresh query.");
                InterfaceFutureC4095a<List<C0777n>> interfaceFutureC4095aB = this.f9340c.b();
                this.f9338a = 1;
                if (ListenableFutureKt.b(interfaceFutureC4095aB, this) == objG) {
                    return objG;
                }
            } else {
                this.f9340c.h(list);
            }
            return t.f7040a;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.f9341d.f34815a = false;
        return t.f7040a;
    }
}
