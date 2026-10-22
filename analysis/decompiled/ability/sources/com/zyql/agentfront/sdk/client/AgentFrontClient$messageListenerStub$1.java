package com.zyql.agentfront.sdk.client;

import D7.w;
import I4.l;
import android.util.Log;
import com.zyql.agentfront.IMessageListener;
import com.zyql.agentfront.bean.Message;
import com.zyql.agentfront.bean.ToolCall;
import com.zyql.agentfront.bean.ToolCallRequest;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import m7.C1680a;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0012\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"com/zyql/agentfront/sdk/client/AgentFrontClient$messageListenerStub$1", "Lcom/zyql/agentfront/IMessageListener$Stub;", "LC7/r;", "onConnected", "()V", "onDisconnected", "", "reason", "onBindFailed", "(Ljava/lang/String;)V", "Lcom/zyql/agentfront/bean/Message;", "message", "onMessageReceived", "(Lcom/zyql/agentfront/bean/Message;)V", "messageId", "", "success", "error", "onMessageSent", "(Ljava/lang/String;ZLjava/lang/String;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentFrontClient$messageListenerStub$1 extends IMessageListener.Stub {
    final /* synthetic */ b this$0;

    public AgentFrontClient$messageListenerStub$1(b bVar) {
        this.this$0 = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMessageReceived$lambda$0(b bVar, Message message) {
        e eVar = b.p;
        bVar.getClass();
        String originMessageId = message.getOriginMessageId();
        C1680a c1680a = b.f4243s;
        String messageId = message.getMessageId();
        String conversationId = message.getConversationId();
        String type = message.getType();
        String sourcePackage = message.getSourcePackage();
        String targetPackage = message.getTargetPackage();
        StringBuilder sbW = B7.a.w("dispatchMessage: originMessageId=", originMessageId, ", messageId=", messageId, ", conversationId:");
        androidx.constraintlayout.core.dsl.a.A(sbW, conversationId, ", type=", type, " sourcePackage=");
        sbW.append(sourcePackage);
        sbW.append(" targetPackage=");
        sbW.append(targetPackage);
        String msg = sbW.toString();
        c1680a.getClass();
        k.f(msg, "msg");
        Log.d("AgentFrontClient", msg);
        if (k.b(message.getType(), "channel")) {
            e eVar2 = bVar.m;
            if (eVar2 != null) {
                eVar2.onPushMessage(message);
                return;
            } else {
                b.f4243s.getClass();
                Log.d("AgentFrontClient", "dispatchMessage: no PushMessageListener for channel message");
                return;
            }
        }
        List<ToolCall> toolCalls = message.getToolCalls();
        if (k.b(message.getType(), "tool_call") && toolCalls != null && !toolCalls.isEmpty()) {
            C1680a c1680a2 = b.f4243s;
            String msg2 = "dispatchMessage: batch TOOL_CALL received, count=" + toolCalls.size() + ", isActive=" + message.isActive();
            c1680a2.getClass();
            k.f(msg2, "msg");
            Log.d("AgentFrontClient", msg2);
            List<ToolCall> list = toolCalls;
            ArrayList arrayList = new ArrayList(w.c0(list, 10));
            for (ToolCall toolCall : list) {
                String toolCallId = toolCall.getToolCallId();
                String conversationId2 = message.getConversationId();
                if (conversationId2 == null) {
                    conversationId2 = "";
                }
                arrayList.add(new ToolCallRequest(originMessageId, toolCallId, conversationId2, toolCall.getToolName(), toolCall.getArguments(), message.getTraceId()));
            }
            if (message.isActive()) {
                b.f4243s.getClass();
                Log.d("AgentFrontClient", "dispatchMessage: batch PushToolCall received, forwarding to pushMessageListener");
                e eVar3 = bVar.m;
                if (eVar3 != null) {
                    eVar3.onPushToolCalls(arrayList);
                    return;
                } else {
                    b.f4243s.getClass();
                    Log.d("AgentFrontClient", "dispatchMessage: no PushMessageListener for batch PushToolCall");
                    return;
                }
            }
            if (originMessageId == null || bVar.k.get(originMessageId) == null) {
                b.f4243s.b("AgentFrontClient", "dispatchMessage: no callback for originMessageId=" + originMessageId + ", forwarding to pushMessageListener");
                e eVar4 = bVar.m;
                if (eVar4 != null) {
                    eVar4.onPushToolCalls(arrayList);
                    return;
                }
                return;
            }
            Object obj = bVar.k.get(originMessageId);
            k.c(obj);
            ((c) obj).onToolCalls(arrayList);
            C1680a c1680a3 = b.f4243s;
            String msg3 = "dispatchMessage: batch TOOL_CALL dispatched to callback, count=" + arrayList.size();
            c1680a3.getClass();
            k.f(msg3, "msg");
            Log.d("AgentFrontClient", msg3);
            return;
        }
        if (k.b(message.getType(), "tool_call") && message.getToolCall() != null) {
            ToolCall toolCall2 = message.getToolCall();
            k.c(toolCall2);
            C1680a c1680a4 = b.f4243s;
            String toolCallId2 = toolCall2.getToolCallId();
            String toolName = toolCall2.getToolName();
            boolean zIsActive = message.isActive();
            String conversationId3 = message.getConversationId();
            StringBuilder sbW2 = B7.a.w("dispatchMessage: TOOL_CALL received, toolCallId=", toolCallId2, ", toolName=", toolName, ", isActive=");
            sbW2.append(zIsActive);
            sbW2.append(", cid=");
            sbW2.append(conversationId3);
            String msg4 = sbW2.toString();
            c1680a4.getClass();
            k.f(msg4, "msg");
            Log.d("AgentFrontClient", msg4);
            if (message.isActive()) {
                b.f4243s.getClass();
                Log.d("AgentFrontClient", "dispatchMessage: PushToolCall received, forwarding to pushMessageListener");
                e eVar5 = bVar.m;
                if (eVar5 == null) {
                    b.f4243s.getClass();
                    Log.d("AgentFrontClient", "dispatchMessage: no PushMessageListener for PushToolCall");
                    return;
                } else {
                    String toolCallId3 = toolCall2.getToolCallId();
                    String conversationId4 = message.getConversationId();
                    eVar5.onPushToolCall(new ToolCallRequest(originMessageId, toolCallId3, conversationId4 == null ? "" : conversationId4, toolCall2.getToolName(), toolCall2.getArguments(), message.getTraceId()));
                    return;
                }
            }
            String toolCallId4 = toolCall2.getToolCallId();
            String conversationId5 = message.getConversationId();
            if (conversationId5 == null) {
                conversationId5 = "";
            }
            ToolCallRequest toolCallRequest = new ToolCallRequest(originMessageId, toolCallId4, conversationId5, toolCall2.getToolName(), toolCall2.getArguments(), message.getTraceId());
            if (originMessageId == null || bVar.k.get(originMessageId) == null) {
                C1680a c1680a5 = b.f4243s;
                boolean z10 = bVar.m != null;
                StringBuilder sbW3 = B7.a.w("没有发现:", originMessageId, " 对应的callback. sourceMessageId:", originMessageId, ", 广播回去:");
                sbW3.append(z10);
                c1680a5.b("AgentFrontClient", sbW3.toString());
                e eVar6 = bVar.m;
                if (eVar6 != null) {
                    eVar6.onPushToolCall(toolCallRequest);
                    return;
                }
                return;
            }
            Object obj2 = bVar.k.get(originMessageId);
            k.c(obj2);
            ((c) obj2).onToolCall(toolCallRequest);
            C1680a c1680a6 = b.f4243s;
            String conversationId6 = message.getConversationId();
            String toolCallId5 = toolCall2.getToolCallId();
            String traceId = message.getTraceId();
            String traceId2 = toolCall2.getTraceId();
            StringBuilder sbW4 = B7.a.w("dispatchMessage. onReply ToolCall end: message: originMessageId=", originMessageId, ", conversationId=", conversationId6, ", toolCallId=");
            androidx.constraintlayout.core.dsl.a.A(sbW4, toolCallId5, ", traceId=", traceId, ", tTraceId=");
            sbW4.append(traceId2);
            String msg5 = sbW4.toString();
            c1680a6.getClass();
            k.f(msg5, "msg");
            Log.d("AgentFrontClient", msg5);
            return;
        }
        if (!k.b(message.getType(), "tool_result") || message.getToolCall() == null) {
            String originMessageId2 = message.getOriginMessageId();
            c cVar = (c) bVar.k.get(originMessageId2);
            if (originMessageId2 == null || cVar == null) {
                b.f4243s.b("AgentFrontClient", "dispatchMessage. onReply Message end. sourceMessageId:" + originMessageId2 + ", callbackMap.keys=" + bVar.k.keySet() + ", 广播回去:" + (bVar.m != null));
                e eVar7 = bVar.m;
                if (eVar7 != null) {
                    eVar7.onPushMessage(message);
                    return;
                }
                return;
            }
            cVar.onReply(message);
            C1680a c1680a7 = b.f4243s;
            String msg6 = "dispatchMessage. onReply Message end. sourceMessageId:".concat(originMessageId2);
            c1680a7.getClass();
            k.f(msg6, "msg");
            Log.d("AgentFrontClient", msg6);
            if (message.isFinish()) {
                bVar.k.remove(originMessageId2);
                C1680a c1680a8 = b.f4243s;
                String msg7 = "dispatchMessage. Message finished, callback removed. sourceMessageId:".concat(originMessageId2);
                c1680a8.getClass();
                k.f(msg7, "msg");
                Log.d("AgentFrontClient", msg7);
                return;
            }
            return;
        }
        ToolCall toolCall3 = message.getToolCall();
        k.c(toolCall3);
        C1680a c1680a9 = b.f4243s;
        String msg8 = "dispatchMessage: TOOL_RESULT received, toolCallId=" + toolCall3.getToolCallId() + ", extra=" + message.getExtra();
        c1680a9.getClass();
        k.f(msg8, "msg");
        Log.d("AgentFrontClient", msg8);
        c cVar2 = (c) bVar.l.get(toolCall3.getToolCallId());
        if (cVar2 == null) {
            C1680a c1680a10 = b.f4243s;
            String msg9 = "dispatchMessage. onReply ToolResult failed. toolCallId:" + toolCall3.getToolCallId();
            c1680a10.getClass();
            k.f(msg9, "msg");
            Log.d("AgentFrontClient", msg9);
            return;
        }
        cVar2.onReply(message);
        C1680a c1680a11 = b.f4243s;
        String messageId2 = message.getMessageId();
        String conversationId7 = message.getConversationId();
        String sourcePackage2 = message.getSourcePackage();
        String targetPackage2 = message.getTargetPackage();
        StringBuilder sbW5 = B7.a.w("dispatchMessage. onReply ToolResult end: message: messageId=", messageId2, ", conversionId=", conversationId7, ", source=");
        sbW5.append(sourcePackage2);
        sbW5.append(", target=");
        sbW5.append(targetPackage2);
        String msg10 = sbW5.toString();
        c1680a11.getClass();
        k.f(msg10, "msg");
        Log.d("AgentFrontClient", msg10);
        if (message.isFinish()) {
            b.f4243s.getClass();
            Log.d("AgentFrontClient", "dispatchMessage. onReply ToolResult finish. remove callback");
            bVar.l.remove(toolCall3.getToolCallId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMessageSent$lambda$1(b bVar, String str, boolean z10, String str2) {
        c cVar = (c) bVar.k.get(str);
        b.f4243s.b("AgentFrontClient", "onMessageSent call back. callback=" + (cVar != null));
        if (cVar != null) {
            if (!z10) {
                if (str2 == null) {
                    str2 = "Unknown error";
                }
                cVar.onError(str, str2);
                bVar.k.remove(str);
                return;
            }
            b.f4243s.b("AgentFrontClient", "onMessageSent success. messageId=" + str);
            cVar.onSuccess(str);
        }
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onBindFailed(String reason) {
        b.f4243s.b("AgentFrontClient", "onBindFailed: reason:" + reason);
        l7.b bVar = this.this$0.c;
        if (bVar != null) {
            bVar.onBindFailed(reason);
        }
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onConnected() {
        b.f4243s.b("AgentFrontClient", "onConnected");
        l7.b bVar = this.this$0.c;
        if (bVar != null) {
            bVar.onConnected();
        }
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onDisconnected() {
        b.f4243s.b("AgentFrontClient", "onDisconnected");
        l7.b bVar = this.this$0.c;
        if (bVar != null) {
            bVar.onDisconnected();
        }
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onMessageReceived(Message message) {
        C1680a c1680a = b.f4243s;
        String messageId = message != null ? message.getMessageId() : null;
        String originMessageId = message != null ? message.getOriginMessageId() : null;
        String conversationId = message != null ? message.getConversationId() : null;
        StringBuilder sbW = B7.a.w("onMessageReceived: messageId:", messageId, ", originMessageId:", originMessageId, ", conversationId:");
        sbW.append(conversationId);
        c1680a.b("AgentFrontClient", sbW.toString());
        if (message == null) {
            return;
        }
        b bVar = this.this$0;
        bVar.n.post(new l(16, bVar, message));
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onMessageSent(String messageId, boolean success, String error) {
        C1680a c1680a = b.f4243s;
        StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("onMessageSent: messageId:", messageId, ", success:", ", error:", success);
        sbL.append(error);
        c1680a.b("AgentFrontClient", sbL.toString());
        if (messageId == null) {
            return;
        }
        b bVar = this.this$0;
        bVar.n.post(new androidx.fragment.app.c(bVar, messageId, success, error, 1));
    }
}
