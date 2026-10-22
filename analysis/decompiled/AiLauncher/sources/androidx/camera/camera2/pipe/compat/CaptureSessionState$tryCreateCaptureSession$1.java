package androidx.camera.camera2.pipe.compat;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.CaptureSessionState", f = "CaptureSessionState.kt", l = {567}, m = "tryCreateCaptureSession", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CaptureSessionState$tryCreateCaptureSession$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f10510a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10511b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f10512c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CaptureSessionState f10513d;

    /* renamed from: e, reason: collision with root package name */
    public int f10514e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptureSessionState$tryCreateCaptureSession$1(CaptureSessionState captureSessionState, InterfaceC4014c<? super CaptureSessionState$tryCreateCaptureSession$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10513d = captureSessionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10512c = obj;
        this.f10514e |= Integer.MIN_VALUE;
        return this.f10513d.B(this);
    }
}
