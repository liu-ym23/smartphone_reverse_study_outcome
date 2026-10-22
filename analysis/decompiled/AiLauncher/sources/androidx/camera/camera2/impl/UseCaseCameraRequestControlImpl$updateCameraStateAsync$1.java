package androidx.camera.camera2.impl;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl", f = "UseCaseCameraRequestControl.kt", l = {638}, m = "updateCameraStateAsync", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UseCaseCameraRequestControlImpl$updateCameraStateAsync$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9966a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraRequestControlImpl f9967b;

    /* renamed from: c, reason: collision with root package name */
    public int f9968c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseCaseCameraRequestControlImpl$updateCameraStateAsync$1(UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl, InterfaceC4014c<? super UseCaseCameraRequestControlImpl$updateCameraStateAsync$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9967b = useCaseCameraRequestControlImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9966a = obj;
        this.f9968c |= Integer.MIN_VALUE;
        return this.f9967b.N(null, null, this);
    }
}
