package androidx.camera.camera2.impl;

import com.stepos.ailauncher.chat.wake.circle.F;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseCameraState", f = "UseCaseCameraState.kt", l = {F.GESTURE_HEIGHT_DP}, m = "updateAsync-Tp9XwKQ", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UseCaseCameraState$updateAsync$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f9997a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f9998b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraState f9999c;

    /* renamed from: d, reason: collision with root package name */
    public int f10000d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseCaseCameraState$updateAsync$1(UseCaseCameraState useCaseCameraState, InterfaceC4014c<? super UseCaseCameraState$updateAsync$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9999c = useCaseCameraState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9998b = obj;
        this.f10000d |= Integer.MIN_VALUE;
        return this.f9999c.j(null, false, null, false, null, null, null, this);
    }
}
