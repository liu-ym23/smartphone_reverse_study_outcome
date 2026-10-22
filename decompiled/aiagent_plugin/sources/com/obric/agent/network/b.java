package com.obric.agent.network;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.h;
import d.h.b.l;
import d.h.b.o;
import d.x;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AgentNetworkManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.a<String> f15230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<String, x> f15231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.b<String, x> f15232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q<String, String, Exception, x> f15233d;

    /* JADX INFO: compiled from: AgentNetworkManager.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.h.a.b<String, x> f15235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final q<String, String, Exception, x> f15236c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AtomicBoolean f15237d;

        public a(String r3, d.h.a.b<? super String, x> r4, q<? super String, ? super String, ? super Exception, x> r5) {
            d.h.a.b<String, x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            q<String, String, Exception, x> r7 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
            o.e(r3, "requestToken");
            o.e(r6, "onFinished");
            o.e(r7, "reportCallbackFailure");
            this.f15234a = r3;
            this.f15235b = r6;
            this.f15236c = r7;
            this.f15237d = new AtomicBoolean(false);
        }

        public final boolean a() {
            if (this.f15237d.compareAndSet(false, true) == true) goto L10;
            return false;
        L10:
            this.f15235b.invoke(this.f15234a);     // Catch: Exception -> L7
        L9:
            return true;
        L7:
            e = move-exception;
            this.f15236c.invoke("finish", this.f15234a, e);
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.network.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AgentNetworkManager.kt */
    /* synthetic */ class C0311b extends l implements q<String, String, Exception, x> {
        C0311b(Object r8) {
            super(3, r8, b.class, "reportCallbackFailure", "reportCallbackFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V", 0);
        }

        public final void a(String r3, String r4, Exception r5) {
            o.e(r3, "p0");
            o.e(r4, "p1");
            o.e(r5, "p2");
            b.a((b) ZeusTransformUtils.preCheckCast(this.receiver, b.class, "com.obric.aiagent.plugin"), r3, r4, r5);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, String r4, Exception r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"), (Exception) ZeusTransformUtils.preCheckCast(r5, Exception.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    /* JADX INFO: renamed from: lambda$2YS0JV7j_-eeqTFUisOmroUORdM, reason: not valid java name */
    public static /* synthetic */ String m98lambda$2YS0JV7j_eeqTFUisOmroUORdM() {
        return a();
    }

    public static /* synthetic */ x lambda$TH9g8mwoWh4wcB_RzJtKe965w7M(String r0, String r1, Exception r2) {
        return b(r0, r1, r2);
    }

    public b(d.h.a.a<String> r3, d.h.a.b<? super String, x> r4, d.h.a.b<? super String, x> r5, q<? super String, ? super String, ? super Exception, x> r6) {
        d.h.a.a<String> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b<String, x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<String, x> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        q<String, String, Exception, x> r10 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.aiagent.plugin");
        o.e(r7, "tokenFactory");
        o.e(r8, "onStarted");
        o.e(r9, "onFinished");
        o.e(r10, "onCallbackFailure");
        this.f15230a = r7;
        this.f15231b = r8;
        this.f15232c = r9;
        this.f15233d = r10;
    }

    public static final /* synthetic */ void a(b r0, String r1, String r2, Exception r3) {
        r0.a(r1, r2, r3);
    }

    public /* synthetic */ b(d.h.a.a r2, d.h.a.b r3, d.h.a.b r4, q r5, int r6, h r7) {
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        q r11 = (q) ZeusTransformUtils.wrapperContextForParams(r5, q.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = $$Lambda$b$2YS0JV7j_eeqTFUisOmroUORdM.INSTANCE;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r11 = $$Lambda$b$TH9g8mwoWh4wcB_RzJtKe965w7M.INSTANCE;
    L8:
        this(r8, r9, r10, r11);
    }

    private static final String a() {
        return UUID.randomUUID().toString();
    }

    private static final x b(String r1, String r2, Exception r3) {
        o.e(r1, "<unused var>");
        o.e(r2, "<unused var>");
        o.e(r3, "<unused var>");
        return x.f38692a;
    }

    public final a a(boolean r5) {
        if (r5 == true) goto L5;
        return null;
    L5:
        String r6 = (String) ZeusTransformUtils.preCheckCast(this.f15230a.invoke(), String.class, "com.obric.aiagent.plugin");
        this.f15231b.invoke(r6);     // Catch: Exception -> L8
    L11:
        return new a(r6, this.f15232c, (q) ZeusTransformUtils.preCheckCast(new C0311b(this), q.class, "com.obric.aiagent.plugin"));
    L8:
        e = move-exception;
        a("start", r6, e);
        goto L11
    }

    private final void a(String r1, String r2, Exception r3) {
        this.f15233d.invoke(r1, r2, r3);     // Catch: Exception -> L4
        return;
    }
}
