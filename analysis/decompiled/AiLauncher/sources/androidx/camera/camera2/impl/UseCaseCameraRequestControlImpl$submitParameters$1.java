package androidx.camera.camera2.impl;

import Ua.M;
import Y8.t;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.core.impl.Config;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$submitParameters$1", f = "UseCaseCameraRequestControl.kt", l = {365, 365}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class UseCaseCameraRequestControlImpl$submitParameters$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9957a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraRequestControlImpl f9958b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraRequestControl.Type f9959c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map<CaptureRequest.Key<?>, Object> f9960d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Config.OptionPriority f9961e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseCaseCameraRequestControlImpl$submitParameters$1(UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl, UseCaseCameraRequestControl.Type type, Map<CaptureRequest.Key<?>, ? extends Object> map, Config.OptionPriority optionPriority, InterfaceC4014c<? super UseCaseCameraRequestControlImpl$submitParameters$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f9958b = useCaseCameraRequestControlImpl;
        this.f9959c = type;
        this.f9960d = map;
        this.f9961e = optionPriority;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new UseCaseCameraRequestControlImpl$submitParameters$1(this.f9958b, this.f9959c, this.f9960d, this.f9961e, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((UseCaseCameraRequestControlImpl$submitParameters$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
    
        if (((Ua.Q) r7).a1(r6) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.f9957a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.C4849c.b(r7)
            goto L3d
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1a:
            kotlin.C4849c.b(r7)
            goto L32
        L1e:
            kotlin.C4849c.b(r7)
            androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl r7 = r6.f9958b
            androidx.camera.camera2.impl.UseCaseCameraRequestControl$Type r1 = r6.f9959c
            java.util.Map<android.hardware.camera2.CaptureRequest$Key<?>, java.lang.Object> r4 = r6.f9960d
            androidx.camera.core.impl.Config$OptionPriority r5 = r6.f9961e
            r6.f9957a = r3
            java.lang.Object r7 = androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl.y(r7, r1, r4, r5, r6)
            if (r7 != r0) goto L32
            goto L3c
        L32:
            Ua.Q r7 = (Ua.Q) r7
            r6.f9957a = r2
            java.lang.Object r6 = r7.a1(r6)
            if (r6 != r0) goto L3d
        L3c:
            return r0
        L3d:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$submitParameters$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
