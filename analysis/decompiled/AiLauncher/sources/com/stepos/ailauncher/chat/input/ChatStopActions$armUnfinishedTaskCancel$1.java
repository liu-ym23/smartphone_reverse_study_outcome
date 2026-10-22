package com.stepos.ailauncher.chat.input;

import Y8.t;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.q;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", Parameters.SESSION_ID, "tempSid", "LY8/t;", "<anonymous>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.input.ChatStopActions$armUnfinishedTaskCancel$1", f = "ChatStopActions.kt", l = {39}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatStopActions$armUnfinishedTaskCancel$1 extends SuspendLambda implements q<String, String, InterfaceC4014c<? super t>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public ChatStopActions$armUnfinishedTaskCancel$1(InterfaceC4014c<? super ChatStopActions$armUnfinishedTaskCancel$1> interfaceC4014c) {
        super(3, interfaceC4014c);
    }

    @Override // p9.q
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(String str, String str2, InterfaceC4014c<? super t> interfaceC4014c) {
        ChatStopActions$armUnfinishedTaskCancel$1 chatStopActions$armUnfinishedTaskCancel$1 = new ChatStopActions$armUnfinishedTaskCancel$1(interfaceC4014c);
        chatStopActions$armUnfinishedTaskCancel$1.L$0 = str;
        chatStopActions$armUnfinishedTaskCancel$1.L$1 = str2;
        return chatStopActions$armUnfinishedTaskCancel$1.invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str = (String) this.L$0;
        String str2 = (String) this.L$1;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            ChatStopActions chatStopActions = ChatStopActions.INSTANCE;
            this.L$0 = h.a(str);
            this.L$1 = h.a(str2);
            this.label = 1;
            if (chatStopActions.f(str, str2, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
