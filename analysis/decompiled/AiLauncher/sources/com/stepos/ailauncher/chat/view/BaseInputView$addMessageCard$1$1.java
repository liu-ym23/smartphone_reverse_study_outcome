package com.stepos.ailauncher.chat.view;

import android.widget.Toast;
import com.stepos.ailauncher.chat.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.BaseInputView$addMessageCard$1$1", f = "BaseInputView.kt", l = {8083}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class BaseInputView$addMessageCard$1$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ InterfaceC5063a<Y8.t> $doSend;
    int label;
    final /* synthetic */ BaseInputView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseInputView$addMessageCard$1$1(BaseInputView baseInputView, InterfaceC5063a<Y8.t> interfaceC5063a, String str, InterfaceC4014c<? super BaseInputView$addMessageCard$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = baseInputView;
        this.$doSend = interfaceC5063a;
        this.$content = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new BaseInputView$addMessageCard$1$1(this.this$0, this.$doSend, this.$content, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((BaseInputView$addMessageCard$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            BaseInputView baseInputView = this.this$0;
            this.label = 1;
            obj = baseInputView.U4(30000L, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        this.this$0.uploadWaitJob = null;
        if (zBooleanValue) {
            this.$doSend.invoke();
            this.this$0.t6();
        } else {
            this.this$0.t6();
            this.this$0.setInputTxt(this.$content);
            C4148a.u("DIAG-WAKE-NOSEND", "addMessageCard 等待附件上传超时，终止发送，回填文字 len=" + this.$content.length(), false, 4, null);
            Toast.makeText(this.this$0.getContext(), this.this$0.getContext().getString(R$string.chat_upload_wait_timeout), 0).show();
        }
        return Y8.t.f7040a;
    }
}
