package androidx.camera.camera2.impl;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.StillCaptureRequestControl", f = "StillCaptureRequestControl.kt", l = {144}, m = "submitRequest", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StillCaptureRequestControl$submitRequest$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f9870a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9871b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f9872c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ StillCaptureRequestControl f9873d;

    /* renamed from: e, reason: collision with root package name */
    public int f9874e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StillCaptureRequestControl$submitRequest$1(StillCaptureRequestControl stillCaptureRequestControl, InterfaceC4014c<? super StillCaptureRequestControl$submitRequest$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9873d = stillCaptureRequestControl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9872c = obj;
        this.f9874e |= Integer.MIN_VALUE;
        return this.f9873d.k(null, null, this);
    }
}
