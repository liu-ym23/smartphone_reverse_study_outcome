package com.stepos.agentframework.adapter.bff;

import Ua.C1060i;
import Ua.C1073o0;
import Ua.M;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.zyql.protobuf.connection.StreamMsg;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C0917m;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/DemoAct;", "Lb/q;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/stepos/agentframework/adapter/bff/p;", "callback", "Lcom/stepos/agentframework/adapter/bff/p;", "getCallback", "()Lcom/stepos/agentframework/adapter/bff/p;", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DemoAct extends b.q {
    private final p callback = new a();

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/agentframework/adapter/bff/DemoAct$a", "Lcom/stepos/agentframework/adapter/bff/p;", "", "sendId", "LK6/m;", "chatReplyInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;LK6/m;)V", "id", "", "code", "reason", "onError", "(Ljava/lang/String;ILjava/lang/String;)V", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements p {
        @Override // com.stepos.agentframework.adapter.bff.p
        public void a(String sendId, C0917m chatReplyInfo) {
            kotlin.jvm.internal.p.i(sendId, "sendId");
            kotlin.jvm.internal.p.i(chatReplyInfo, "chatReplyInfo");
        }

        @Override // com.stepos.agentframework.adapter.bff.p
        public /* bridge */ boolean b(String str, StreamMsg streamMsg) {
            return super.b(str, streamMsg);
        }

        @Override // com.stepos.agentframework.adapter.bff.p
        public void onError(String id, int code, String reason) {
            kotlin.jvm.internal.p.i(id, "id");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.adapter.bff.DemoAct$onCreate$1", f = "DemoAct.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.adapter.bff.DemoAct$onCreate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C1060i.d(C1073o0.f6391a, null, null, new AnonymousClass1(null), 3, null);
    }
}
