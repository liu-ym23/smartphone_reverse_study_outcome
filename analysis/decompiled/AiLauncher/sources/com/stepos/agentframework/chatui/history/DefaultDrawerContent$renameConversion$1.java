package com.stepos.agentframework.chatui.history;

import Ua.M;
import Y8.t;
import android.content.Context;
import android.widget.Toast;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.audit.ContentAuditClient;
import com.stepos.agentframework.chatcore.audit.g;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatui.history.DefaultDrawerContent$renameConversion$1", f = "DefaultDrawerContent.kt", l = {111}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class DefaultDrawerContent$renameConversion$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ String $newTitle;
    final /* synthetic */ String $sessionId;
    int label;
    final /* synthetic */ DefaultDrawerContent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultDrawerContent$renameConversion$1(DefaultDrawerContent defaultDrawerContent, String str, String str2, InterfaceC4014c<? super DefaultDrawerContent$renameConversion$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = defaultDrawerContent;
        this.$newTitle = str;
        this.$sessionId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DefaultDrawerContent$renameConversion$1(this.this$0, this.$newTitle, this.$sessionId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((DefaultDrawerContent$renameConversion$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SessionHandler sessionHandler;
        Object objG = C4063a.g();
        int i10 = this.label;
        Context context = null;
        if (i10 == 0) {
            C4849c.b(obj);
            ContentAuditClient contentAuditClient = ContentAuditClient.INSTANCE;
            SessionHandler sessionHandler2 = this.this$0.sessionHandler;
            if (sessionHandler2 == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
                sessionHandler2 = null;
            }
            String agentId = sessionHandler2.getConfiguration().getSessionConfig().getAgentId();
            String str = this.$newTitle;
            this.label = 1;
            obj = contentAuditClient.g(agentId, str, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        if (kotlin.jvm.internal.p.d(((com.stepos.agentframework.chatcore.audit.g) obj).a(), g.a.INSTANCE)) {
            Context context2 = this.this$0.context;
            if (context2 == null) {
                kotlin.jvm.internal.p.A("context");
            } else {
                context = context2;
            }
            Toast.makeText(context, R$string.chat_rename_failed, 0).show();
            return t.f7040a;
        }
        SessionHandler sessionHandler3 = this.this$0.sessionHandler;
        if (sessionHandler3 == null) {
            kotlin.jvm.internal.p.A("sessionHandler");
            sessionHandler = null;
        } else {
            sessionHandler = sessionHandler3;
        }
        SessionHandler.m3(sessionHandler, this.$sessionId, this.$newTitle, null, 4, null);
        return t.f7040a;
    }
}
