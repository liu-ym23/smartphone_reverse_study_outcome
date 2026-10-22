package com.stepos.ailauncher.chat.view;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.BaseInputView$createSpeechAsrCallback$1$onError$1", f = "BaseInputView.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class BaseInputView$createSpeechAsrCallback$1$onError$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ int $code;
    final /* synthetic */ String $longPressTimeoutPending;
    final /* synthetic */ String $message;
    int label;
    final /* synthetic */ BaseInputView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseInputView$createSpeechAsrCallback$1$onError$1(BaseInputView baseInputView, int i10, String str, String str2, InterfaceC4014c<? super BaseInputView$createSpeechAsrCallback$1$onError$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = baseInputView;
        this.$code = i10;
        this.$message = str;
        this.$longPressTimeoutPending = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new BaseInputView$createSpeechAsrCallback$1$onError$1(this.this$0, this.$code, this.$message, this.$longPressTimeoutPending, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((BaseInputView$createSpeechAsrCallback$1$onError$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.this$0.t6();
        if ((this.this$0.listenModeActive || this.this$0.slaOnlyVoiceActive) && !this.this$0.isManualAsrMode && ((i10 = this.$code) == 20002 || i10 == 20003 || i10 == 20004)) {
            this.this$0.asrCallback.c(this.$code, this.$message);
            this.this$0.K5();
            BaseInputView.la(this.this$0, false, 1, null);
            this.this$0.f6();
            this.this$0.ua();
            return Y8.t.f7040a;
        }
        this.this$0.K5();
        BaseInputView.la(this.this$0, false, 1, null);
        this.this$0.f6();
        this.this$0.ua();
        String str = this.$longPressTimeoutPending;
        if (str != null && !La.H.x0(str)) {
            C4148a.k(BaseInputView.WAKE_RECORD_LOG_TAG, "onError longPressTimeout: deliver pending=\"" + this.$longPressTimeoutPending + "\"", false, 4, null);
            this.this$0.asrCallback.e(this.$longPressTimeoutPending);
        }
        this.this$0.asrCallback.c(this.$code, this.$message);
        return Y8.t.f7040a;
    }
}
