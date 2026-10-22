package com.stepos.agentframework.chatui.view;

import android.content.Context;
import com.stepos.agentframework.chatui.AgentFileSyncBridge;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatui.view.MessageContentContainer$openFilePreview$1", f = "MessageContentContainer.kt", l = {487}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class MessageContentContainer$openFilePreview$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $fid;
    final /* synthetic */ p9.r<Context, AgentFileSyncBridge.Result, String, String, Y8.t> $launcher;
    final /* synthetic */ String $sid;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MessageContentContainer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MessageContentContainer$openFilePreview$1(String str, p9.r<? super Context, ? super AgentFileSyncBridge.Result, ? super String, ? super String, Y8.t> rVar, MessageContentContainer messageContentContainer, String str2, InterfaceC4014c<? super MessageContentContainer$openFilePreview$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$fid = str;
        this.$launcher = rVar;
        this.this$0 = messageContentContainer;
        this.$sid = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        MessageContentContainer$openFilePreview$1 messageContentContainer$openFilePreview$1 = new MessageContentContainer$openFilePreview$1(this.$fid, this.$launcher, this.this$0, this.$sid, interfaceC4014c);
        messageContentContainer$openFilePreview$1.L$0 = obj;
        return messageContentContainer$openFilePreview$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((MessageContentContainer$openFilePreview$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            p9.p<String, InterfaceC4014c<? super AgentFileSyncBridge.Result>, Object> pVarA = AgentFileSyncBridge.a();
            if (pVarA != null) {
                String str = this.$fid;
                this.L$0 = m10;
                this.label = 1;
                obj = pVarA.invoke(str, this);
                if (obj == objG) {
                    return objG;
                }
            }
            return Y8.t.f7040a;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        AgentFileSyncBridge.Result result = (AgentFileSyncBridge.Result) obj;
        if (result != null) {
            p9.r<Context, AgentFileSyncBridge.Result, String, String, Y8.t> rVar = this.$launcher;
            MessageContentContainer messageContentContainer = this.this$0;
            String str2 = this.$fid;
            String str3 = this.$sid;
            try {
                Result.Companion companion = Result.INSTANCE;
                Context context = messageContentContainer.getContext();
                kotlin.jvm.internal.p.h(context, "getContext(...)");
                rVar.invoke(context, result, str2, str3);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            return Y8.t.f7040a;
        }
        return Y8.t.f7040a;
    }
}
