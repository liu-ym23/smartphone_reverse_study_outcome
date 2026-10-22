package androidx.camera.camera2.impl;

import Ua.M;
import Ua.Q;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "", "LUa/Q;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.DeferredUseCaseCameraRequestControl$issueSingleCaptureAsync$$inlined$runOnSequentialList$1", f = "DeferredUseCaseCameraRequestControl.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class DeferredUseCaseCameraRequestControl$issueSingleCaptureAsync$$inlined$runOnSequentialList$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends Q<? extends Void>>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9715a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DeferredUseCaseCameraRequestControl f9716b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f9717c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f9718d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f9719e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9720f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeferredUseCaseCameraRequestControl$issueSingleCaptureAsync$$inlined$runOnSequentialList$1(DeferredUseCaseCameraRequestControl deferredUseCaseCameraRequestControl, InterfaceC4014c interfaceC4014c, List list, int i10, int i11, int i12) {
        super(2, interfaceC4014c);
        this.f9716b = deferredUseCaseCameraRequestControl;
        this.f9717c = list;
        this.f9718d = i10;
        this.f9719e = i11;
        this.f9720f = i12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DeferredUseCaseCameraRequestControl$issueSingleCaptureAsync$$inlined$runOnSequentialList$1(this.f9716b, interfaceC4014c, this.f9717c, this.f9718d, this.f9719e, this.f9720f);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super List<? extends Q<? extends Void>>> interfaceC4014c) {
        return ((DeferredUseCaseCameraRequestControl$issueSingleCaptureAsync$$inlined$runOnSequentialList$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f9715a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return this.f9716b.p().e(this.f9717c, this.f9718d, this.f9719e, this.f9720f);
    }
}
