package androidx.camera.camera2.pipe.compat;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.RetryingCameraStateOpenerImpl", f = "RetryingCameraStateOpener.kt", l = {418, 423, 476}, m = "openCameraWithRetry-aeCOTgg", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RetryingCameraStateOpenerImpl$openCameraWithRetry$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f10589a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10590b;

    /* renamed from: c, reason: collision with root package name */
    public Object f10591c;

    /* renamed from: d, reason: collision with root package name */
    public Object f10592d;

    /* renamed from: e, reason: collision with root package name */
    public Object f10593e;

    /* renamed from: f, reason: collision with root package name */
    public Object f10594f;

    /* renamed from: g, reason: collision with root package name */
    public long f10595g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f10596h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ RetryingCameraStateOpenerImpl f10597i;

    /* renamed from: j, reason: collision with root package name */
    public int f10598j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetryingCameraStateOpenerImpl$openCameraWithRetry$1(RetryingCameraStateOpenerImpl retryingCameraStateOpenerImpl, InterfaceC4014c<? super RetryingCameraStateOpenerImpl$openCameraWithRetry$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10597i = retryingCameraStateOpenerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10596h = obj;
        this.f10598j |= Integer.MIN_VALUE;
        return this.f10597i.f(null, null, null, this);
    }
}
