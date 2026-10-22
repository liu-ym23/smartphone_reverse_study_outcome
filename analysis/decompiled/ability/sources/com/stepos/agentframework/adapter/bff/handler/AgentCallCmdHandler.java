package com.stepos.agentframework.adapter.bff.handler;

import H4.o;
import V4.C0257d;
import V4.l;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.protobuf.ByteString;
import com.stepos.agentframework.adapter.bff.BffClient;
import com.stepos.agentframework.adapter.bff.CacheBean;
import com.stepos.agentframework.adapter.bff.IDataCallback;
import com.stepos.agentframework.adapter.bff.LogUtilKt;
import com.stepos.aiengine.args.SingleFileBundle;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import r7.f;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/handler/AgentCallCmdHandler;", "Lcom/stepos/agentframework/adapter/bff/handler/IBffCommandHandler;", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "bffClient", AppAgent.CONSTRUCT, "(Lcom/stepos/agentframework/adapter/bff/BffClient;)V", "Lr7/f;", "head", "Lcom/google/protobuf/ByteString;", "bodyRaw", "Lcom/stepos/agentframework/adapter/bff/CacheBean;", "cacheBean", "LC7/r;", "handle", "(Lr7/f;Lcom/google/protobuf/ByteString;Lcom/stepos/agentframework/adapter/bff/CacheBean;)V", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentCallCmdHandler implements IBffCommandHandler {
    private final BffClient bffClient;

    public AgentCallCmdHandler(BffClient bffClient) {
        k.f(bffClient, "bffClient");
        this.bffClient = bffClient;
    }

    @Override // com.stepos.agentframework.adapter.bff.handler.IBffCommandHandler
    public void handle(f head, ByteString bodyRaw, CacheBean cacheBean) {
        WeakReference<IDataCallback> callback;
        IDataCallback iDataCallback;
        String str;
        k.f(head, "head");
        k.f(bodyRaw, "bodyRaw");
        LogUtilKt.getLogger().d(BffClient.TAG, "receive_AgentCall");
        C0257d c0257d = new C0257d(bodyRaw.o());
        if (cacheBean == null || (callback = cacheBean.getCallback()) == null || (iDataCallback = callback.get()) == null) {
            return;
        }
        String strB0 = head.b0();
        k.e(strB0, "getMsgId(...)");
        l chatRequestInfo = cacheBean.getChatRequestInfo();
        if (chatRequestInfo == null || (str = chatRequestInfo.f1364a) == null) {
            str = "";
        }
        String str2 = str;
        l chatRequestInfo2 = cacheBean.getChatRequestInfo();
        Integer numValueOf = chatRequestInfo2 != null ? Integer.valueOf(chatRequestInfo2.h) : null;
        l chatRequestInfo3 = cacheBean.getChatRequestInfo();
        String str3 = chatRequestInfo3 != null ? chatRequestInfo3.e : null;
        cacheBean.getChatRequestInfo();
        iDataCallback.onDataReceived(strB0, new V4.k(o.M(c0257d), "assistant", str3, SingleFileBundle.KEY_BYTES, null, str2, null, 1, true, numValueOf, 0, head.b0(), null, null, -680730640));
    }
}
