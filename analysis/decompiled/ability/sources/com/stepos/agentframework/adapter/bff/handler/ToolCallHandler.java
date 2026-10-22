package com.stepos.agentframework.adapter.bff.handler;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.protobuf.ByteString;
import com.stepos.agentframework.adapter.bff.BffClient;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.agentframework.adapter.bff.CacheBean;
import com.stepos.agentframework.adapter.bff.LogUtilKt;
import com.stepos.agentframework.adapter.netcore.ExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import r7.f;
import v7.v;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/handler/ToolCallHandler;", "Lcom/stepos/agentframework/adapter/bff/handler/IBffCommandHandler;", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "bffClient", AppAgent.CONSTRUCT, "(Lcom/stepos/agentframework/adapter/bff/BffClient;)V", "Lr7/f;", "head", "Lcom/google/protobuf/ByteString;", "bodyRaw", "Lcom/stepos/agentframework/adapter/bff/CacheBean;", "cacheBean", "LC7/r;", "handle", "(Lr7/f;Lcom/google/protobuf/ByteString;Lcom/stepos/agentframework/adapter/bff/CacheBean;)V", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ToolCallHandler implements IBffCommandHandler {
    private final BffClient bffClient;

    public ToolCallHandler(BffClient bffClient) {
        k.f(bffClient, "bffClient");
        this.bffClient = bffClient;
    }

    @Override // com.stepos.agentframework.adapter.bff.handler.IBffCommandHandler
    public void handle(f head, ByteString bodyRaw, CacheBean cacheBean) {
        k.f(head, "head");
        k.f(bodyRaw, "bodyRaw");
        LogUtilKt.getLogger().d(BffClient.TAG, BffConstant.Cmd.CallTool);
        v vVarA0 = v.a0(bodyRaw);
        LogUtilKt.getLogger().d(BffClient.TAG, "CallTool:" + ExtKt.toJson(vVarA0));
        BffClient bffClient = this.bffClient;
        String strB0 = head.b0();
        k.e(strB0, "getMsgId(...)");
        bffClient.callTool$bff_debug(strB0, vVarA0);
    }
}
