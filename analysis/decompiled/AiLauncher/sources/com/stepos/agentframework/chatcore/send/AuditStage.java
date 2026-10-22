package com.stepos.agentframework.chatcore.send;

import La.H;
import Ua.Q;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.C0919o;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bc\u00122\b\u0002\u0010\u0006\u001a,\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005\u0018\u00010\u0002\u0012&\b\u0002\u0010\t\u001a \b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R>\u0010\u0006\u001a,\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0005\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R2\u0010\t\u001a \b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00198\u0016X\u0096D¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/agentframework/chatcore/send/AuditStage;", "", "Lkotlin/Function1;", "Le9/c;", "Lcom/stepos/agentframework/chatcore/audit/g;", "LUa/Q;", Parameters.LAUNCH, "Lkotlin/Function2;", "Lcom/stepos/agentframework/chatcore/send/e;", "audit", "<init>", "(Lp9/l;Lp9/p;)V", "ctx", "", "e", "(Lcom/stepos/agentframework/chatcore/send/e;)Z", "LY8/t;", "f", "(Lcom/stepos/agentframework/chatcore/send/e;)V", Const.INTENT_KEY_PKGNAME, "(Le9/c;)Ljava/lang/Object;", "c", "()V", "Lp9/l;", "Lp9/p;", "", "name", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "()Ljava/lang/String;", "deferred", "LUa/Q;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AuditStage {
    private final p<SendContext, InterfaceC4014c<? super com.stepos.agentframework.chatcore.audit.g>, Object> audit;
    private volatile Q<? extends com.stepos.agentframework.chatcore.audit.g> deferred;
    private final InterfaceC5074l<InterfaceC5074l<? super InterfaceC4014c<? super com.stepos.agentframework.chatcore.audit.g>, ? extends Object>, Q<com.stepos.agentframework.chatcore.audit.g>> launch;
    private final String name = "AUDIT";

    /* JADX WARN: Multi-variable type inference failed */
    public AuditStage(InterfaceC5074l<? super InterfaceC5074l<? super InterfaceC4014c<? super com.stepos.agentframework.chatcore.audit.g>, ? extends Object>, ? extends Q<? extends com.stepos.agentframework.chatcore.audit.g>> interfaceC5074l, p<? super SendContext, ? super InterfaceC4014c<? super com.stepos.agentframework.chatcore.audit.g>, ? extends Object> pVar) {
        this.launch = interfaceC5074l;
        this.audit = pVar;
    }

    public static final t g(AuditStage auditStage, Throwable th) {
        C0919o.c(auditStage.getName(), "安审结束", true);
        return t.f7040a;
    }

    public final Object b(InterfaceC4014c<? super com.stepos.agentframework.chatcore.audit.g> interfaceC4014c) {
        Q<? extends com.stepos.agentframework.chatcore.audit.g> q10 = this.deferred;
        if (q10 == null) {
            return null;
        }
        Object objA1 = q10.a1(interfaceC4014c);
        return objA1 == C4063a.g() ? objA1 : (com.stepos.agentframework.chatcore.audit.g) objA1;
    }

    public void c() {
        Q<? extends com.stepos.agentframework.chatcore.audit.g> q10 = this.deferred;
        if (q10 != null) {
            kotlinx.coroutines.g.Y0(q10, null, 1, null);
        }
        this.deferred = null;
    }

    /* renamed from: d, reason: from getter */
    public String getName() {
        return this.name;
    }

    public boolean e(SendContext ctx) {
        kotlin.jvm.internal.p.i(ctx, "ctx");
        if (this.launch == null || this.audit == null) {
            return false;
        }
        String text = ctx.getText();
        return !(text == null || H.x0(text));
    }

    public void f(SendContext ctx) {
        kotlin.jvm.internal.p.i(ctx, "ctx");
        InterfaceC5074l<InterfaceC5074l<? super InterfaceC4014c<? super com.stepos.agentframework.chatcore.audit.g>, ? extends Object>, Q<com.stepos.agentframework.chatcore.audit.g>> interfaceC5074l = this.launch;
        p<SendContext, InterfaceC4014c<? super com.stepos.agentframework.chatcore.audit.g>, Object> pVar = this.audit;
        if (!e(ctx) || interfaceC5074l == null || pVar == null) {
            this.deferred = null;
            return;
        }
        C0919o.b(getName(), "安审开始");
        Q<com.stepos.agentframework.chatcore.audit.g> qInvoke = interfaceC5074l.invoke(new AuditStage$start$d$1(pVar, ctx, null));
        qInvoke.J(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.send.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AuditStage.g(this.f22460a, (Throwable) obj);
            }
        });
        this.deferred = qInvoke;
    }
}
