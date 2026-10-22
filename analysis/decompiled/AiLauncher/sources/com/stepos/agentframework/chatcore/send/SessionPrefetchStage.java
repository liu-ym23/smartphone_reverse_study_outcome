package com.stepos.agentframework.chatcore.send;

import Ua.Q;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import e9.InterfaceC4014c;
import kotlin.C0919o;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B[\u00122\u0010\u0006\u001a.\u0012\u001c\u0012\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00050\u0002\u0012\u001e\u0010\u0007\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R@\u0010\u0006\u001a.\u0012\u001c\u0012\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R,\u0010\u0007\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/agentframework/chatcore/send/SessionPrefetchStage;", "", "Lkotlin/Function1;", "Le9/c;", "", "LUa/Q;", Parameters.LAUNCH, "fetch", "<init>", "(Lp9/l;Lp9/l;)V", "Lcom/stepos/agentframework/chatcore/send/e;", "ctx", "", "e", "(Lcom/stepos/agentframework/chatcore/send/e;)Z", "LY8/t;", "f", "(Lcom/stepos/agentframework/chatcore/send/e;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()LUa/Q;", "c", "()V", "Lp9/l;", "name", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "()Ljava/lang/String;", "deferred", "LUa/Q;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionPrefetchStage {
    private volatile Q<String> deferred;
    private final InterfaceC5074l<InterfaceC4014c<? super String>, Object> fetch;
    private final InterfaceC5074l<InterfaceC5074l<? super InterfaceC4014c<? super String>, ? extends Object>, Q<String>> launch;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public SessionPrefetchStage(InterfaceC5074l<? super InterfaceC5074l<? super InterfaceC4014c<? super String>, ? extends Object>, ? extends Q<String>> launch, InterfaceC5074l<? super InterfaceC4014c<? super String>, ? extends Object> fetch) {
        p.i(launch, "launch");
        p.i(fetch, "fetch");
        this.launch = launch;
        this.fetch = fetch;
        this.name = "SESSION_PREFETCH";
    }

    public static final t g(SessionPrefetchStage sessionPrefetchStage, Throwable th) {
        C0919o.c(sessionPrefetchStage.getName(), "会话预取结束", true);
        return t.f7040a;
    }

    public void c() {
        this.deferred = null;
    }

    /* renamed from: d, reason: from getter */
    public String getName() {
        return this.name;
    }

    public boolean e(SendContext ctx) {
        p.i(ctx, "ctx");
        return true;
    }

    public void f(SendContext ctx) {
        p.i(ctx, "ctx");
        if (!e(ctx)) {
            this.deferred = null;
            return;
        }
        C0919o.b(getName(), "会话预取开始");
        Q<String> qInvoke = this.launch.invoke(new SessionPrefetchStage$start$d$1(this, null));
        qInvoke.J(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.send.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SessionPrefetchStage.g(this.f22462a, (Throwable) obj);
            }
        });
        this.deferred = qInvoke;
    }

    public final Q<String> h() {
        return this.deferred;
    }
}
