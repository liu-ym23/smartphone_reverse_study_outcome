package com.stepos.ailauncher.chat.wake;

import com.stepos.ailauncher.chat.view.BaseInputView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.wake.WakeService$Companion$sendTextToVisibleChatOrWake$1$handledInPlace$1", f = "WakeService.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class WakeService$Companion$sendTextToVisibleChatOrWake$1$handledInPlace$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ String $text;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WakeService$Companion$sendTextToVisibleChatOrWake$1$handledInPlace$1(String str, InterfaceC4014c<? super WakeService$Companion$sendTextToVisibleChatOrWake$1$handledInPlace$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$text = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new WakeService$Companion$sendTextToVisibleChatOrWake$1$handledInPlace$1(this.$text, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((WakeService$Companion$sendTextToVisibleChatOrWake$1$handledInPlace$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        BaseInputView baseInputViewR0 = WakeService.INSTANCE.r0();
        if (baseInputViewR0 == null) {
            return C4109a.a(false);
        }
        baseInputViewR0.db(this.$text, null, true);
        return C4109a.a(true);
    }
}
