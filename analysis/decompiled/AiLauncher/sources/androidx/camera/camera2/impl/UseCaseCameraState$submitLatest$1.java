package androidx.camera.camera2.impl;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseCameraState", f = "UseCaseCameraState.kt", l = {Const.I_TILE_TINY}, m = "submitLatest", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UseCaseCameraState$submitLatest$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f9993a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f9994b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraState f9995c;

    /* renamed from: d, reason: collision with root package name */
    public int f9996d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseCaseCameraState$submitLatest$1(UseCaseCameraState useCaseCameraState, InterfaceC4014c<? super UseCaseCameraState$submitLatest$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9995c = useCaseCameraState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9994b = obj;
        this.f9996d |= Integer.MIN_VALUE;
        return this.f9995c.g(this);
    }
}
