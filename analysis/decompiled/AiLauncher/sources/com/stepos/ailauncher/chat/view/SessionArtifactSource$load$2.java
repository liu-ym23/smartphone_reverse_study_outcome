package com.stepos.ailauncher.chat.view;

import Z8.C1173v;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.view.SessionArtifactSource;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.contract.model.SessionArtifactKt;
import com.stepos.ailauncher.foundation.task.TaskModule;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import u4.m;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/chat/view/SessionArtifactSource$a;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/chat/view/SessionArtifactSource$a;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.SessionArtifactSource$load$2", f = "SessionArtifactSource.kt", l = {38}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SessionArtifactSource$load$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super SessionArtifactSource.Result>, Object> {
    final /* synthetic */ List<String> $keys;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionArtifactSource$load$2(List<String> list, InterfaceC4014c<? super SessionArtifactSource$load$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$keys = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SessionArtifactSource$load$2 sessionArtifactSource$load$2 = new SessionArtifactSource$load$2(this.$keys, interfaceC4014c);
        sessionArtifactSource$load$2.L$0 = obj;
        return sessionArtifactSource$load$2;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super SessionArtifactSource.Result> interfaceC4014c) {
        return ((SessionArtifactSource$load$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        m.FolderMessage folderMessage;
        Object objB2;
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                if (this.$keys.isEmpty()) {
                    return new SessionArtifactSource.Result(C1173v.m(), null);
                }
                List<String> list = this.$keys;
                Result.Companion companion = Result.INSTANCE;
                TaskModule taskModule = TaskModule.INSTANCE;
                this.L$0 = m10;
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = taskModule.e(list, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b((List) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("SessionArtifactSource", "getSessionArtifacts failed", thE, false, 8, null);
        }
        List listM = C1173v.m();
        if (Result.g(objB)) {
            objB = listM;
        }
        List<SessionArtifact> listLatestFileProducts = SessionArtifactKt.latestFileProducts((List) objB);
        SessionHandler sessionHandlerN = AgentConfig.INSTANCE.a().n();
        Iterator<T> it = this.$keys.iterator();
        while (true) {
            if (!it.hasNext()) {
                folderMessage = null;
                break;
            }
            String str = (String) it.next();
            try {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(sessionHandlerN != null ? sessionHandlerN.O1(str) : null);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            Throwable thE2 = Result.e(objB2);
            if (thE2 != null) {
                C4148a.t("SessionArtifactSource", "getSessionFileTree failed key=" + str, thE2, false, 8, null);
            }
            if (Result.g(objB2)) {
                objB2 = null;
            }
            folderMessage = (m.FolderMessage) objB2;
            if (folderMessage != null) {
                break;
            }
        }
        return new SessionArtifactSource.Result(listLatestFileProducts, folderMessage != null ? SessionArtifactSource.INSTANCE.d(folderMessage, listLatestFileProducts) : null);
    }
}
