package com.obric.agent.im;

import com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: FlowMessageCallbackHub.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FlowMessageCallbackHub$ipcCallback$1 extends IFlowMessageCallbackIDL.Stub {
    public static /* synthetic */ x lambda$VGtKP5c0detiJPSnWZ4F1HPsiwc(IMMessage r0, d r1) {
        return onReceiveMessage$lambda$1(r0, r1);
    }

    public static /* synthetic */ x lambda$VeuMcDHKrWy4cRJN9Dlh9e22f40(List r0, d r1) {
        return onInsertMessageList$lambda$4(r0, r1);
    }

    public static /* synthetic */ x lambda$aNAcWehwEJ8Dql7IiWk1FJ04OJw(IMMessage r0, d r1) {
        return onRegenMessage$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$tkctotmZ-owpdb3uVVKqulqMm7o, reason: not valid java name */
    public static /* synthetic */ x m78lambda$tkctotmZowpdb3uVVKqulqMm7o(IMMessage r0, d r1) {
        return onSendMessage$lambda$0(r0, r1);
    }

    public static /* synthetic */ x lambda$zCTyFeoaejtVzHiq5YngnlvTKTw(IMMessage r0, d r1) {
        return onUpdateMessage$lambda$2(r0, r1);
    }

    FlowMessageCallbackHub$ipcCallback$1() {
    }

    private static final x onSendMessage$lambda$0(IMMessage r2, d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        o.e(r4, "it");
        r4.onSendMessage(r2);
        return x.f38692a;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
    public void onSendMessage(final IMMessage r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        a.a(a.f14573a, new $$Lambda$FlowMessageCallbackHub$ipcCallback$1$tkctotmZowpdb3uVVKqulqMm7o(r2));
    }

    private static final x onReceiveMessage$lambda$1(IMMessage r2, d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        o.e(r4, "it");
        r4.onReceiveMessage(r2);
        return x.f38692a;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
    public void onReceiveMessage(final IMMessage r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        a.a(a.f14573a, new $$Lambda$FlowMessageCallbackHub$ipcCallback$1$VGtKP5c0detiJPSnWZ4F1HPsiwc(r2));
    }

    private static final x onUpdateMessage$lambda$2(IMMessage r2, d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        o.e(r4, "it");
        r4.onUpdateMessage(r2);
        return x.f38692a;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
    public void onUpdateMessage(final IMMessage r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        a.a(a.f14573a, new $$Lambda$FlowMessageCallbackHub$ipcCallback$1$zCTyFeoaejtVzHiq5YngnlvTKTw(r2));
    }

    private static final x onRegenMessage$lambda$3(IMMessage r2, d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        o.e(r4, "it");
        r4.onRegenMessage(r2);
        return x.f38692a;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
    public void onRegenMessage(final IMMessage r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        a.a(a.f14573a, new $$Lambda$FlowMessageCallbackHub$ipcCallback$1$aNAcWehwEJ8Dql7IiWk1FJ04OJw(r2));
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL
    public void onInsertMessageList(List<IMMessage> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        final List r3 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin"));
        if (r3 == null) goto L10;
        a.a(a.f14573a, new $$Lambda$FlowMessageCallbackHub$ipcCallback$1$VeuMcDHKrWy4cRJN9Dlh9e22f40(r3));
        return;
    L10:
        return;
    }

    private static final x onInsertMessageList$lambda$4(List r2, d r3) {
        List<IMMessage> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        o.e(r5, "it");
        r5.onInsertMessageList(r4);
        return x.f38692a;
    }
}
