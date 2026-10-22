package com.stepos.ailauncher.oobe;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.oobe.SdkInitUserActivity$startHintTypewriter$1", f = "SdkInitUserActivity.kt", l = {109, 110, 111, 112}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SdkInitUserActivity$startHintTypewriter$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ List<String> $hints;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SdkInitUserActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SdkInitUserActivity$startHintTypewriter$1(SdkInitUserActivity sdkInitUserActivity, List<String> list, InterfaceC4014c<? super SdkInitUserActivity$startHintTypewriter$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sdkInitUserActivity;
        this.$hints = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SdkInitUserActivity$startHintTypewriter$1 sdkInitUserActivity$startHintTypewriter$1 = new SdkInitUserActivity$startHintTypewriter$1(this.this$0, this.$hints, interfaceC4014c);
        sdkInitUserActivity$startHintTypewriter$1.L$0 = obj;
        return sdkInitUserActivity$startHintTypewriter$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SdkInitUserActivity$startHintTypewriter$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008a, code lost:
    
        if (Ua.U.a(400, r9) != r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f A[PHI: r2
      0x006f: PHI (r2v2 int) = (r2v3 int), (r2v11 int) binds: [B:22:0x006c, B:12:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007e A[PHI: r2
      0x007e: PHI (r2v1 int) = (r2v2 int), (r2v12 int) binds: [B:25:0x007b, B:11:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x008a -> B:30:0x008d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = r9.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r9.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L39
            if (r2 == r6) goto L33
            if (r2 == r5) goto L2d
            if (r2 == r4) goto L27
            if (r2 != r3) goto L1f
            int r2 = r9.I$0
            kotlin.C4849c.b(r10)
            goto L8d
        L1f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L27:
            int r2 = r9.I$0
            kotlin.C4849c.b(r10)
            goto L7e
        L2d:
            int r2 = r9.I$0
            kotlin.C4849c.b(r10)
            goto L6f
        L33:
            int r2 = r9.I$0
            kotlin.C4849c.b(r10)
            goto L60
        L39:
            kotlin.C4849c.b(r10)
            r10 = 0
        L3d:
            boolean r2 = kotlinx.coroutines.d.h(r0)
            if (r2 == 0) goto L97
            com.stepos.ailauncher.oobe.SdkInitUserActivity r2 = r9.this$0
            java.util.List<java.lang.String> r7 = r9.$hints
            java.lang.Object r7 = r7.get(r10)
            java.lang.String r8 = "get(...)"
            kotlin.jvm.internal.p.h(r7, r8)
            java.lang.String r7 = (java.lang.String) r7
            r9.L$0 = r0
            r9.I$0 = r10
            r9.label = r6
            java.lang.Object r2 = com.stepos.ailauncher.oobe.SdkInitUserActivity.J(r2, r7, r9)
            if (r2 != r1) goto L5f
            goto L8c
        L5f:
            r2 = r10
        L60:
            r9.L$0 = r0
            r9.I$0 = r2
            r9.label = r5
            r7 = 1400(0x578, double:6.917E-321)
            java.lang.Object r10 = Ua.U.a(r7, r9)
            if (r10 != r1) goto L6f
            goto L8c
        L6f:
            com.stepos.ailauncher.oobe.SdkInitUserActivity r10 = r9.this$0
            r9.L$0 = r0
            r9.I$0 = r2
            r9.label = r4
            java.lang.Object r10 = com.stepos.ailauncher.oobe.SdkInitUserActivity.B(r10, r9)
            if (r10 != r1) goto L7e
            goto L8c
        L7e:
            r9.L$0 = r0
            r9.I$0 = r2
            r9.label = r3
            r7 = 400(0x190, double:1.976E-321)
            java.lang.Object r10 = Ua.U.a(r7, r9)
            if (r10 != r1) goto L8d
        L8c:
            return r1
        L8d:
            int r2 = r2 + r6
            java.util.List<java.lang.String> r10 = r9.$hints
            int r10 = r10.size()
            int r10 = r2 % r10
            goto L3d
        L97:
            Y8.t r9 = Y8.t.f7040a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.oobe.SdkInitUserActivity$startHintTypewriter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
