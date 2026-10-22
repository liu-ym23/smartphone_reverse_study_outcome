package androidx.camera.camera2.pipe.graph;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.pipe.graph.CameraGraphImpl", f = "CameraGraphImpl.kt", l = {175}, m = "acquireSession", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CameraGraphImpl$acquireSession$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f10794a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraGraphImpl f10795b;

    /* renamed from: c, reason: collision with root package name */
    public int f10796c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraGraphImpl$acquireSession$1(CameraGraphImpl cameraGraphImpl, InterfaceC4014c<? super CameraGraphImpl$acquireSession$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10795b = cameraGraphImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10794a = obj;
        this.f10796c |= Integer.MIN_VALUE;
        return this.f10795b.A0(this);
    }
}
