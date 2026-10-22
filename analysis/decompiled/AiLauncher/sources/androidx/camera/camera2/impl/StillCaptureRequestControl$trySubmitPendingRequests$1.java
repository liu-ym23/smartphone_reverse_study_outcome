package androidx.camera.camera2.impl;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.StillCaptureRequestControl$trySubmitPendingRequests$1", f = "StillCaptureRequestControl.kt", l = {118, 222, 123}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class StillCaptureRequestControl$trySubmitPendingRequests$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f9878a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9879b;

    /* renamed from: c, reason: collision with root package name */
    public Object f9880c;

    /* renamed from: d, reason: collision with root package name */
    public Object f9881d;

    /* renamed from: e, reason: collision with root package name */
    public Object f9882e;

    /* renamed from: f, reason: collision with root package name */
    public Object f9883f;

    /* renamed from: g, reason: collision with root package name */
    public int f9884g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ StillCaptureRequestControl f9885h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StillCaptureRequestControl$trySubmitPendingRequests$1(StillCaptureRequestControl stillCaptureRequestControl, InterfaceC4014c<? super StillCaptureRequestControl$trySubmitPendingRequests$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f9885h = stillCaptureRequestControl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new StillCaptureRequestControl$trySubmitPendingRequests$1(this.f9885h, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((StillCaptureRequestControl$trySubmitPendingRequests$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009a A[Catch: all -> 0x002f, TryCatch #0 {all -> 0x002f, blocks: (B:8:0x002a, B:39:0x00be, B:31:0x0090, B:33:0x009a, B:35:0x00a7, B:40:0x00c6), top: B:46:0x002a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00bc -> B:39:0x00be). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.StillCaptureRequestControl$trySubmitPendingRequests$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
