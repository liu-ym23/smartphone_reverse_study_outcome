package com.stepos.ailauncher.agent.service;

import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.t;
import Z4.TaskIconInfo;
import Z4.a;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$drawable;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository;
import com.stepos.ailauncher.contract.api.agent.IAgentSpaceService;
import com.stepos.ailauncher.foundation.account.AccountInfo;
import com.stepos.ailauncher.foundation.account.f;
import com.stepos.ailauncher.foundation.account.i;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.d;
import p9.p;

@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/agent/service/AgentSpaceServiceImpl;", "Lcom/stepos/ailauncher/contract/api/agent/IAgentSpaceService;", "<init>", "()V", "LY8/t;", "init", "showWindow", "hideWindow", "", "isWindowShowing", "()Z", "", "title", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "taskId", "notifyAiReply", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "iconRes", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "LUa/M;", "serviceScope", "LUa/M;", "com/stepos/ailauncher/agent/service/AgentSpaceServiceImpl$accountCallback$1", "accountCallback", "Lcom/stepos/ailauncher/agent/service/AgentSpaceServiceImpl$accountCallback$1;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentSpaceServiceImpl implements IAgentSpaceService {
    private final AtomicBoolean initialized = new AtomicBoolean(false);
    private final M serviceScope = d.a(L0.b(null, 1, null).plus(Y.b()));
    private final AgentSpaceServiceImpl$accountCallback$1 accountCallback = new i() { // from class: com.stepos.ailauncher.agent.service.AgentSpaceServiceImpl$accountCallback$1
        @Override // com.stepos.ailauncher.foundation.account.i
        public void a(AccountInfo accountInfo) {
            C1060i.d(this.this$0.serviceScope, null, null, new AgentSpaceServiceImpl$accountCallback$1$accountStateChanged$1(null), 3, null);
        }
    };

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.service.AgentSpaceServiceImpl$init$1", f = "AgentSpaceServiceImpl.kt", l = {32}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.service.AgentSpaceServiceImpl$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                AgentDeviceRepository agentDeviceRepository = AgentDeviceRepository.INSTANCE;
                this.label = 1;
                if (agentDeviceRepository.I(this) == objG) {
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

    public final void b(String taskId, int iconRes, String title, String content) {
        a aVar = a.INSTANCE;
        aVar.e();
        aVar.a(new TaskIconInfo(taskId, iconRes, title, content));
        aVar.f(taskId);
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IAgentSpaceService
    public void hideWindow() {
        a.INSTANCE.c();
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IAgentSpaceService
    public void init() {
        if (this.initialized.compareAndSet(false, true)) {
            f.INSTANCE.z(this.accountCallback);
            C1060i.d(this.serviceScope, null, null, new AnonymousClass1(null), 3, null);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IAgentSpaceService
    public boolean isWindowShowing() {
        return a.INSTANCE.d();
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IAgentSpaceService
    public void notifyAiReply(String title, String content, String taskId) {
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(content, "content");
        if (taskId == null) {
            taskId = "ai_reply_" + System.currentTimeMillis();
        }
        b(taskId, R$drawable.icon_window_camera, title, content);
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IAgentSpaceService
    public void showWindow() {
        a.INSTANCE.e();
    }
}
