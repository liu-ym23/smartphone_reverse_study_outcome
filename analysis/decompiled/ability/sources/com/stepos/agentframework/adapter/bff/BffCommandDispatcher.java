package com.stepos.agentframework.adapter.bff;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.protobuf.ByteString;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.agentframework.adapter.bff.handler.AgentCallCmdHandler;
import com.stepos.agentframework.adapter.bff.handler.AuthCommandHandler;
import com.stepos.agentframework.adapter.bff.handler.ChatCommandHandler;
import com.stepos.agentframework.adapter.bff.handler.ChatCommandHandlerV2;
import com.stepos.agentframework.adapter.bff.handler.HeartbeatHandler;
import com.stepos.agentframework.adapter.bff.handler.IBffCommandHandler;
import com.stepos.agentframework.adapter.bff.handler.ToolCallHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import r7.f;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/BffCommandDispatcher;", "", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "client", AppAgent.CONSTRUCT, "(Lcom/stepos/agentframework/adapter/bff/BffClient;)V", "Lr7/f;", "head", "Lcom/google/protobuf/ByteString;", "bodyRaw", "Lcom/stepos/agentframework/adapter/bff/CacheBean;", "cacheBean", "LC7/r;", "dispatch", "(Lr7/f;Lcom/google/protobuf/ByteString;Lcom/stepos/agentframework/adapter/bff/CacheBean;)V", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "", "", "Lcom/stepos/agentframework/adapter/bff/handler/IBffCommandHandler;", "handlers", "Ljava/util/Map;", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BffCommandDispatcher {
    private final BffClient client;
    private final Map<String, IBffCommandHandler> handlers;

    public BffCommandDispatcher(BffClient client) {
        k.f(client, "client");
        this.client = client;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.handlers = linkedHashMap;
        linkedHashMap.put(BffConstant.Cmd.Auth, new AuthCommandHandler(client));
        linkedHashMap.put(BffConstant.Cmd.Heartbeat, new HeartbeatHandler(client));
        linkedHashMap.put(BffConstant.Cmd.CallTool, new ToolCallHandler(client));
        linkedHashMap.put(BffConstant.Cmd.AgentCall, new AgentCallCmdHandler(client));
        ChatCommandHandler chatCommandHandler = new ChatCommandHandler(client);
        linkedHashMap.put(BffConstant.Cmd.Chat, chatCommandHandler);
        linkedHashMap.put(BffConstant.Cmd.ImageLayout, chatCommandHandler);
        linkedHashMap.put(BffConstant.Cmd.VideoHighlight, chatCommandHandler);
        linkedHashMap.put(BffConstant.Cmd.VideoEdit, chatCommandHandler);
        linkedHashMap.put(BffConstant.Cmd.VideoVoiceEdit, chatCommandHandler);
        ChatCommandHandlerV2 chatCommandHandlerV2 = new ChatCommandHandlerV2();
        linkedHashMap.put(BffConstant.Cmd.VideoNewEdit, chatCommandHandlerV2);
        linkedHashMap.put(BffConstant.Cmd.NewChat, chatCommandHandlerV2);
    }

    public final void dispatch(f head, ByteString bodyRaw, CacheBean cacheBean) {
        k.f(head, "head");
        k.f(bodyRaw, "bodyRaw");
        LogUtilKt.getLogger().d(BffClient.TAG, "dispatch Command: " + head.T());
        IBffCommandHandler iBffCommandHandler = this.handlers.get(head.T());
        if (iBffCommandHandler != null) {
            iBffCommandHandler.handle(head, bodyRaw, cacheBean);
            return;
        }
        LogUtilKt.getLogger().e("BffClient", "UnSupport Command: " + head.T());
    }
}
