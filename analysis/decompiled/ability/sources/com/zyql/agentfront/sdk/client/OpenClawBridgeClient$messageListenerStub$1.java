package com.zyql.agentfront.sdk.client;

import H4.o;
import android.util.Log;
import com.zyql.agentfront.IMessageListener;
import com.zyql.agentfront.bean.Message;
import com.zyql.agentfront.bean.ToolCall;
import com.zyql.agentfront.bean.ToolContent;
import com.zyql.agentfront.bean.ToolContentItem;
import com.zyql.agentfront.bean.ToolResponse;
import com.zyql.agentfront.bean.ToolResult;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import m7.C1680a;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0012\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"com/zyql/agentfront/sdk/client/OpenClawBridgeClient$messageListenerStub$1", "Lcom/zyql/agentfront/IMessageListener$Stub;", "LC7/r;", "onConnected", "()V", "onDisconnected", "", "reason", "onBindFailed", "(Ljava/lang/String;)V", "Lcom/zyql/agentfront/bean/Message;", "message", "onMessageReceived", "(Lcom/zyql/agentfront/bean/Message;)V", "messageId", "", "success", "error", "onMessageSent", "(Ljava/lang/String;ZLjava/lang/String;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OpenClawBridgeClient$messageListenerStub$1 extends IMessageListener.Stub {
    final /* synthetic */ d this$0;

    public OpenClawBridgeClient$messageListenerStub$1(d dVar) {
    }

    private static final void onMessageReceived$lambda$0(Message message, d dVar) {
        if (!k.b(message.getType(), "tool_result") || message.getToolCall() == null) {
            return;
        }
        ToolCall toolCall = message.getToolCall();
        k.c(toolCall);
        String toolCallId = toolCall.getToolCallId();
        String msg = "[AIDL] onMessageReceived: tool_result received, toolCallId=" + toolCallId;
        d.f4245j.getClass();
        k.f(msg, "msg");
        Log.d("OpenClawBridgeClient", msg);
        String result = toolCall.getResult();
        if (result == null) {
            result = "";
        }
        new ToolResponse(toolCallId, new ToolResult(new ToolContent(o.M(new ToolContentItem("text", result, null, null, null, null, 60, null)), toolCall.isError())));
        throw null;
    }

    private static final void onMessageSent$lambda$1(d dVar, String str, boolean z10, String str2) {
        C1680a c1680a = d.f4245j;
        throw null;
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onBindFailed(String reason) {
        d.f4245j.a("OpenClawBridgeClient", "[AIDL] onBindFailed: reason=" + reason, null);
        throw null;
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onConnected() {
        d.f4245j.getClass();
        Log.d("OpenClawBridgeClient", "[AIDL] onConnected: service connected");
        throw null;
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onDisconnected() {
        d.f4245j.getClass();
        Log.w("OpenClawBridgeClient", "[AIDL] onDisconnected: service disconnected");
        throw null;
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onMessageReceived(Message message) {
        if (message == null) {
            return;
        }
        C1680a c1680a = d.f4245j;
        String messageId = message.getMessageId();
        String type = message.getType();
        boolean zIsFinish = message.isFinish();
        StringBuilder sbW = B7.a.w("[AIDL] onMessageReceived: messageId=", messageId, ", type=", type, ", isFinish=");
        sbW.append(zIsFinish);
        String msg = sbW.toString();
        c1680a.getClass();
        k.f(msg, "msg");
        Log.d("OpenClawBridgeClient", msg);
        throw null;
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onMessageSent(String messageId, boolean success, String error) {
        if (messageId == null) {
            return;
        }
        String msg = "onMessageSent: messageId=" + messageId + ", success=" + success;
        d.f4245j.getClass();
        k.f(msg, "msg");
        Log.d("OpenClawBridgeClient", msg);
        throw null;
    }
}
