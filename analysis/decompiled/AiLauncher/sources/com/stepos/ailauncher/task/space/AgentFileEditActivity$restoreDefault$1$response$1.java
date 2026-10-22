package com.stepos.ailauncher.task.space;

import com.stepos.ailauncher.oobe.api.BotMsgApi;
import com.stepos.ailauncher.oobe.api.RestoreWorkspaceMdParams;
import com.stepos.ailauncher.oobe.api.RestoreWorkspaceMdResponse;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/oobe/api/RestoreWorkspaceMdResponse;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/oobe/api/RestoreWorkspaceMdResponse;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.AgentFileEditActivity$restoreDefault$1$response$1", f = "AgentFileEditActivity.kt", l = {237}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentFileEditActivity$restoreDefault$1$response$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super RestoreWorkspaceMdResponse>, Object> {
    final /* synthetic */ BotMsgApi $api;
    final /* synthetic */ RestoreWorkspaceMdParams $request;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentFileEditActivity$restoreDefault$1$response$1(BotMsgApi botMsgApi, RestoreWorkspaceMdParams restoreWorkspaceMdParams, InterfaceC4014c<? super AgentFileEditActivity$restoreDefault$1$response$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$api = botMsgApi;
        this.$request = restoreWorkspaceMdParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentFileEditActivity$restoreDefault$1$response$1(this.$api, this.$request, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super RestoreWorkspaceMdResponse> interfaceC4014c) {
        return ((AgentFileEditActivity$restoreDefault$1$response$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        BotMsgApi botMsgApi = this.$api;
        RestoreWorkspaceMdParams restoreWorkspaceMdParams = this.$request;
        this.label = 1;
        Object objRestoreWorkspaceMd = botMsgApi.restoreWorkspaceMd(restoreWorkspaceMdParams, this);
        return objRestoreWorkspaceMd == objG ? objG : objRestoreWorkspaceMd;
    }
}
