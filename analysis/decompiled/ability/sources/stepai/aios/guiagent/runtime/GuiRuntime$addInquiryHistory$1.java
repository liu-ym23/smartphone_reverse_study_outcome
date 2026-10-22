package stepai.aios.guiagent.runtime;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "stepai.aios.guiagent.runtime.GuiRuntime$addInquiryHistory$1", f = "GuiRuntime.kt", l = {303, 307, 311}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class GuiRuntime$addInquiryHistory$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f6118a;
    public final /* synthetic */ a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuiRuntime$addInquiryHistory$1(a aVar, String str, String str2, String str3, H7.c cVar) {
        super(2, cVar);
        this.b = aVar;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new GuiRuntime$addInquiryHistory$1(this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((GuiRuntime$addInquiryHistory$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        if (r9.b(r6, r0, r8) != r1) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            stepai.aios.guiagent.runtime.a r0 = r8.b
            stepai.aios.guiagent.pipeline.b r0 = r0.g
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r8.f6118a
            r3 = 3
            r4 = 2
            r5 = 1
            java.lang.String r6 = r8.c
            if (r2 == 0) goto L29
            if (r2 == r5) goto L25
            if (r2 == r4) goto L21
            if (r2 != r3) goto L19
            kotlin.b.b(r9)
            goto L6e
        L19:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L21:
            kotlin.b.b(r9)
            goto L56
        L25:
            kotlin.b.b(r9)
            goto L3e
        L29:
            kotlin.b.b(r9)
            stepai.aios.guiagent.session.a r9 = r0.g
            za.b r2 = new za.b
            java.lang.String r7 = "用户需要补充更多信息"
            r2.<init>(r7)
            r8.f6118a = r5
            java.lang.Object r9 = r9.b(r6, r2, r8)
            if (r9 != r1) goto L3e
            goto L6d
        L3e:
            stepai.aios.guiagent.session.a r9 = r0.g
            za.b r2 = new za.b
            java.lang.String r5 = r8.d
            java.lang.String r7 = "已询问用户: "
            java.lang.String r5 = B7.a.k(r7, r5)
            r2.<init>(r5)
            r8.f6118a = r4
            java.lang.Object r9 = r9.b(r6, r2, r8)
            if (r9 != r1) goto L56
            goto L6d
        L56:
            stepai.aios.guiagent.session.a r9 = r0.g
            za.b r0 = new za.b
            java.lang.String r2 = r8.e
            java.lang.String r4 = "用户回答: "
            java.lang.String r2 = B7.a.k(r4, r2)
            r0.<init>(r2)
            r8.f6118a = r3
            java.lang.Object r8 = r9.b(r6, r0, r8)
            if (r8 != r1) goto L6e
        L6d:
            return r1
        L6e:
            C7.r r8 = C7.r.f317a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.runtime.GuiRuntime$addInquiryHistory$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
