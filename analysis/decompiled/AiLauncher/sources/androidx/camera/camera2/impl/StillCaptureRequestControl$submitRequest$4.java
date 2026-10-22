package androidx.camera.camera2.impl;

import D.C0761b0;
import Ua.M;
import Ua.Q;
import Y8.t;
import android.util.Log;
import androidx.camera.camera2.impl.StillCaptureRequestControl;
import com.stepos.ailauncher.chat.wake.circle.F;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.AwaitKt;
import p9.p;
import t.C5473b;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Ljava/lang/Void;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.StillCaptureRequestControl$submitRequest$4", f = "StillCaptureRequestControl.kt", l = {F.LOOP_END_FRAME}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class StillCaptureRequestControl$submitRequest$4 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends Void>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9875a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<Q<Void>> f9876b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StillCaptureRequestControl.CaptureRequest f9877c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StillCaptureRequestControl$submitRequest$4(List<? extends Q<Void>> list, StillCaptureRequestControl.CaptureRequest aVar, InterfaceC4014c<? super StillCaptureRequestControl$submitRequest$4> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f9876b = list;
        this.f9877c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new StillCaptureRequestControl$submitRequest$4(this.f9876b, this.f9877c, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<Void>> interfaceC4014c) {
        return ((StillCaptureRequestControl$submitRequest$4) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9875a;
        if (i10 == 0) {
            C4849c.b(obj);
            C5473b c5473b = C5473b.f41865a;
            StillCaptureRequestControl.CaptureRequest aVar = this.f9877c;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "StillCaptureRequestControl: Waiting for deferred list from " + aVar);
            }
            List<Q<Void>> list = this.f9876b;
            this.f9875a = 1;
            obj = AwaitKt.a(list, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        StillCaptureRequestControl.CaptureRequest aVar2 = this.f9877c;
        C5473b c5473b2 = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "StillCaptureRequestControl: Waiting for deferred list from " + aVar2 + " done");
        }
        return obj;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends Void>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<Void>>) interfaceC4014c);
    }
}
