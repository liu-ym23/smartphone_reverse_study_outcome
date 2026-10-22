package com.stepos.agentframework.adapter.bff;

import C7.r;
import J7.c;
import S7.n;
import V4.k;
import android.os.Bundle;
import android.view.ComponentActivity;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.C1704W;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/DemoAct;", "Landroidx/activity/ComponentActivity;", AppAgent.CONSTRUCT, "()V", "Landroid/os/Bundle;", "savedInstanceState", "LC7/r;", AppAgent.ON_CREATE, "(Landroid/os/Bundle;)V", "Lcom/stepos/agentframework/adapter/bff/IDataCallback;", "callback", "Lcom/stepos/agentframework/adapter/bff/IDataCallback;", "getCallback", "()Lcom/stepos/agentframework/adapter/bff/IDataCallback;", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DemoAct extends ComponentActivity {
    private final IDataCallback callback = new IDataCallback() { // from class: com.stepos.agentframework.adapter.bff.DemoAct$callback$1
        @Override // com.stepos.agentframework.adapter.bff.IDataCallback
        public void onDataReceived(String sendId, k chatReplyInfo) {
            kotlin.jvm.internal.k.f(sendId, "sendId");
            kotlin.jvm.internal.k.f(chatReplyInfo, "chatReplyInfo");
        }

        @Override // com.stepos.agentframework.adapter.bff.IDataCallback
        public void onError(String id, int code, String reason) {
            kotlin.jvm.internal.k.f(id, "id");
        }

        @Override // com.stepos.agentframework.adapter.bff.IDataCallback
        public /* bridge */ boolean onOriginalDataReceived(String str, r7.k kVar) {
            return super.onOriginalDataReceived(str, kVar);
        }
    };

    @c(c = "com.stepos.agentframework.adapter.bff.DemoAct$onCreate$1", f = "DemoAct.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.bff.DemoAct$onCreate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        int label;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public final IDataCallback getCallback() {
        return this.callback;
    }

    @Override // android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AbstractC1683A.n(C1704W.f5321a, null, new AnonymousClass1(null), 3);
    }
}
