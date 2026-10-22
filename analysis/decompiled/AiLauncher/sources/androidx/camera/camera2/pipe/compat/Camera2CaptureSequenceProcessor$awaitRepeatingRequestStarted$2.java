package androidx.camera.camera2.pipe.compat;

import com.stepos.ailauncher.foundation.appui.card.provider.amap.MapAspectFrameLayout;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import x.M;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY8/t;", "<anonymous>", "()V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2CaptureSequenceProcessor$awaitRepeatingRequestStarted$2", f = "Camera2CaptureSequenceProcessor.kt", l = {MapAspectFrameLayout.DESIGN_HEIGHT}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class Camera2CaptureSequenceProcessor$awaitRepeatingRequestStarted$2 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10350a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ M f10351b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2CaptureSequenceProcessor$awaitRepeatingRequestStarted$2(M m10, InterfaceC4014c<? super Camera2CaptureSequenceProcessor$awaitRepeatingRequestStarted$2> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f10351b = m10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new Camera2CaptureSequenceProcessor$awaitRepeatingRequestStarted$2(this.f10351b, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((Camera2CaptureSequenceProcessor$awaitRepeatingRequestStarted$2) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10350a;
        if (i10 == 0) {
            C4849c.b(obj);
            M m10 = this.f10351b;
            this.f10350a = 1;
            if (m10.g(this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
