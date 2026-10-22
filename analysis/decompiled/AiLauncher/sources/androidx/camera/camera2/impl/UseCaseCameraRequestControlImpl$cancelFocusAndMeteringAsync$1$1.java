package androidx.camera.camera2.impl;

import Ua.Q;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import w.Result3A;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/Q;", "Lw/N;", "<anonymous>", "()LUa/Q;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1", f = "UseCaseCameraRequestControl.kt", l = {749, 497, 497, 761}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Q<? extends Result3A>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f9933a;

    /* renamed from: b, reason: collision with root package name */
    public int f9934b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraRequestControlImpl f9935c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1(UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl, InterfaceC4014c<? super UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f9935c = useCaseCameraRequestControlImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1(this.f9935c, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(InterfaceC4014c<? super Q<Result3A>> interfaceC4014c) {
        return ((UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f6, code lost:
    
        if (r0 != r11) goto L65;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e5 A[PHI: r13
      0x00e5: PHI (r13v5 java.lang.Throwable) = (r13v18 java.lang.Throwable), (r13v15 java.lang.Throwable) binds: [B:59:0x00e2, B:14:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v3 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$cancelFocusAndMeteringAsync$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Object invoke(InterfaceC4014c<? super Q<? extends Result3A>> interfaceC4014c) {
        return invoke2((InterfaceC4014c<? super Q<Result3A>>) interfaceC4014c);
    }
}
