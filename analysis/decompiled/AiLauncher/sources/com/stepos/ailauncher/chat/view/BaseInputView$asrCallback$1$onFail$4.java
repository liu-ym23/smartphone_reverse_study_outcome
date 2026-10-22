package com.stepos.ailauncher.chat.view;

import android.content.Context;
import com.stepos.ailauncher.chat.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.BaseInputView$asrCallback$1$onFail$4", f = "BaseInputView.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class BaseInputView$asrCallback$1$onFail$4 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $errMsg;
    int label;
    final /* synthetic */ BaseInputView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseInputView$asrCallback$1$onFail$4(BaseInputView baseInputView, String str, Context context, InterfaceC4014c<? super BaseInputView$asrCallback$1$onFail$4> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = baseInputView;
        this.$errMsg = str;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new BaseInputView$asrCallback$1$onFail$4(this.this$0, this.$errMsg, this.$context, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((BaseInputView$asrCallback$1$onFail$4) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        BaseInputView baseInputView = this.this$0;
        String string = this.$errMsg;
        if (string == null) {
            string = this.$context.getString(R$string.unknown_error);
            kotlin.jvm.internal.p.h(string, "getString(...)");
        }
        baseInputView.Qc(string);
        this.this$0.currentVoiceStr = null;
        return Y8.t.f7040a;
    }
}
