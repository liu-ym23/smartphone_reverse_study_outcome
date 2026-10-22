package com.obric.agent;

import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: IMMessageDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f15191a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f15192b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f15193c = null;

    /* JADX INFO: compiled from: IMMessageDispatcher.kt */
    public static final class a implements com.obric.agent.im.d {
        @Override // com.obric.agent.im.d
        public void onReceiveMessage(IMMessage r1) {
            d.h.b.o.e(r1, "message");
        }

        @Override // com.obric.agent.im.d
        public void onRegenMessage(IMMessage r1) {
            d.h.b.o.e(r1, "message");
        }

        a() {
        }

        @Override // com.obric.agent.im.d
        public void onInsertMessageList(List<IMMessage> r3) {
            com.obric.agent.im.d.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.agent.im.d
        public void onSendMessage(IMMessage r1) {
            d.h.b.o.e(r1, "message");
            j.f15187a.a(r1);
        }

        @Override // com.obric.agent.im.d
        public void onUpdateMessage(IMMessage r1) {
            d.h.b.o.e(r1, "message");
            j.f15187a.b(r1);
        }
    }

    private k() {
    }

    static {
        f15191a = new k();
        f15192b = new AtomicBoolean(false);
        f15193c = new a();
    }

    private final void a() {
        if (f15192b.compareAndSet(false, true) == false) goto L6;
        com.obric.agent.im.a.f14573a.c((com.obric.agent.im.d) ZeusTransformUtils.preCheckCast(f15193c, com.obric.agent.im.d.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void a(com.obric.agent.im.d r3) {
        com.obric.agent.im.d r4 = (com.obric.agent.im.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.agent.im.d.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "observer");
        a();
        com.obric.agent.im.a.f14573a.a(r4);
    }

    public final void b(com.obric.agent.im.d r2) {
        com.obric.agent.im.d r1 = (com.obric.agent.im.d) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.agent.im.d.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "observer");
        com.obric.agent.im.a.f14573a.b(r1);
    }
}
