package com.stepos.ailauncher.chat.view;

import android.content.Context;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.BaseInputView$asrCallback$1$onFail$3", f = "BaseInputView.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class BaseInputView$asrCallback$1$onFail$3 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $errMsg;
    int label;
    final /* synthetic */ BaseInputView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseInputView$asrCallback$1$onFail$3(BaseInputView baseInputView, Context context, String str, InterfaceC4014c<? super BaseInputView$asrCallback$1$onFail$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = baseInputView;
        this.$context = context;
        this.$errMsg = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new BaseInputView$asrCallback$1$onFail$3(this.this$0, this.$context, this.$errMsg, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((BaseInputView$asrCallback$1$onFail$3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0074  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            f9.C4063a.g()
            int r0 = r4.label
            if (r0 != 0) goto L89
            kotlin.C4849c.b(r5)
            com.stepos.ailauncher.chat.view.BaseInputView r5 = r4.this$0
            r0 = 0
            com.stepos.ailauncher.chat.view.BaseInputView.H3(r5, r0)
            com.stepos.ailauncher.chat.view.BaseInputView r5 = r4.this$0
            boolean r5 = r5.isAttachedToWindow()
            if (r5 != 0) goto L1b
            Y8.t r4 = Y8.t.f7040a
            return r4
        L1b:
            com.stepos.ailauncher.sla.SlaRouter r5 = com.stepos.ailauncher.sla.SlaRouter.INSTANCE
            android.content.Context r1 = r4.$context
            boolean r1 = r5.t(r1)
            if (r1 != 0) goto L47
            android.content.Context r0 = r4.$context
            boolean r0 = r5.q(r0)
            if (r0 == 0) goto L35
            com.stepos.ailauncher.chat.manager.AuthManager r5 = com.stepos.ailauncher.chat.manager.AuthManager.INSTANCE
            android.content.Context r4 = r4.$context
            r5.h1(r4)
            goto L44
        L35:
            android.content.Context r0 = r4.$context
            boolean r5 = r5.K(r0)
            if (r5 != 0) goto L44
            com.stepos.ailauncher.chat.manager.AuthManager r5 = com.stepos.ailauncher.chat.manager.AuthManager.INSTANCE
            android.content.Context r4 = r4.$context
            r5.h1(r4)
        L44:
            Y8.t r4 = Y8.t.f7040a
            return r4
        L47:
            java.lang.String r5 = r4.$errMsg
            if (r5 == 0) goto L74
            r1 = 0
            r2 = 2
            java.lang.String r3 = "inferSync rejected:"
            boolean r1 = La.D.X(r5, r3, r1, r2, r0)
            if (r1 != 0) goto L71
            java.lang.String r1 = "Model not yet ready"
            r2 = 1
            boolean r1 = La.H.e0(r5, r1, r2)
            if (r1 != 0) goto L71
            java.lang.String r1 = "Model validation failed"
            boolean r1 = La.H.e0(r5, r1, r2)
            if (r1 != 0) goto L71
            java.lang.String r1 = "preinstall extract"
            boolean r1 = La.H.e0(r5, r1, r2)
            if (r1 == 0) goto L70
            goto L71
        L70:
            r0 = r5
        L71:
            if (r0 == 0) goto L74
            goto L81
        L74:
            android.content.Context r5 = r4.$context
            int r0 = com.stepos.ailauncher.speech.R$string.speech_aiengine_not_ready
            java.lang.String r0 = r5.getString(r0)
            java.lang.String r5 = "getString(...)"
            kotlin.jvm.internal.p.h(r0, r5)
        L81:
            com.stepos.ailauncher.chat.view.BaseInputView r4 = r4.this$0
            com.stepos.ailauncher.chat.view.BaseInputView.h4(r4, r0)
            Y8.t r4 = Y8.t.f7040a
            return r4
        L89:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.BaseInputView$asrCallback$1$onFail$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
