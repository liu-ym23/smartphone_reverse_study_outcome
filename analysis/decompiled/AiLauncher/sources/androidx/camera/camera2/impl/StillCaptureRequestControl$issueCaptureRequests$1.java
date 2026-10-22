package androidx.camera.camera2.impl;

import Ua.InterfaceC1083u;
import Ua.M;
import Y8.t;
import androidx.camera.core.impl.l;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.StillCaptureRequestControl$issueCaptureRequests$1", f = "StillCaptureRequestControl.kt", l = {99, 100, 222}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class StillCaptureRequestControl$issueCaptureRequests$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f9849a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9850b;

    /* renamed from: c, reason: collision with root package name */
    public Object f9851c;

    /* renamed from: d, reason: collision with root package name */
    public int f9852d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List<l> f9853e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9854f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9855g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1083u<List<Void>> f9856h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ StillCaptureRequestControl f9857i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StillCaptureRequestControl$issueCaptureRequests$1(List<l> list, int i10, int i11, InterfaceC1083u<List<Void>> interfaceC1083u, StillCaptureRequestControl stillCaptureRequestControl, InterfaceC4014c<? super StillCaptureRequestControl$issueCaptureRequests$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f9853e = list;
        this.f9854f = i10;
        this.f9855g = i11;
        this.f9856h = interfaceC1083u;
        this.f9857i = stillCaptureRequestControl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new StillCaptureRequestControl$issueCaptureRequests$1(this.f9853e, this.f9854f, this.f9855g, this.f9856h, this.f9857i, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((StillCaptureRequestControl$issueCaptureRequests$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4 A[PHI: r12
      0x00a4: PHI (r12v2 androidx.camera.camera2.impl.StillCaptureRequestControl$a) = 
      (r12v1 androidx.camera.camera2.impl.StillCaptureRequestControl$a)
      (r12v3 androidx.camera.camera2.impl.StillCaptureRequestControl$a)
     binds: [B:13:0x0062, B:18:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.StillCaptureRequestControl$issueCaptureRequests$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
