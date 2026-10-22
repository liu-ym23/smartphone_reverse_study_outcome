package androidx.camera.camera2.impl;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseSurfaceManager", f = "UseCaseSurfaceManager.kt", l = {193}, m = "awaitSetupCompletion$suspendImpl", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UseCaseSurfaceManager$awaitSetupCompletion$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f10010a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UseCaseSurfaceManager f10011b;

    /* renamed from: c, reason: collision with root package name */
    public int f10012c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseCaseSurfaceManager$awaitSetupCompletion$1(UseCaseSurfaceManager useCaseSurfaceManager, InterfaceC4014c<? super UseCaseSurfaceManager$awaitSetupCompletion$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10011b = useCaseSurfaceManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10010a = obj;
        this.f10012c |= Integer.MIN_VALUE;
        return UseCaseSurfaceManager.l(this.f10011b, this);
    }
}
