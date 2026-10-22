package com.zyql.agentfront.sdk.client;

import android.os.Handler;
import c8.InterfaceC1505c;
import com.zyql.agentfront.IMessageListener;
import com.zyql.agentfront.bean.Message;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0012\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"com/zyql/agentfront/sdk/client/AgentFrontClient$messageListenerStub$1", "Lcom/zyql/agentfront/IMessageListener$Stub;", "LY8/t;", "onConnected", "()V", "onDisconnected", "", "reason", "onBindFailed", "(Ljava/lang/String;)V", "Lcom/zyql/agentfront/bean/Message;", "message", "onMessageReceived", "(Lcom/zyql/agentfront/bean/Message;)V", "messageId", "", "success", "error", "onMessageSent", "(Ljava/lang/String;ZLjava/lang/String;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AgentFrontClient$messageListenerStub$1 extends IMessageListener.Stub {
    final /* synthetic */ AgentFrontClient this$0;

    public AgentFrontClient$messageListenerStub$1(AgentFrontClient agentFrontClient) {
        this.this$0 = agentFrontClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMessageSent$lambda$1(AgentFrontClient agentFrontClient, String str, boolean z10, String str2) {
        j jVar = (j) agentFrontClient.callbackMap.get(str);
        AgentFrontClient.f31910v.e("AgentFrontClient", "onMessageSent call back. callback=" + (jVar != null));
        if (jVar != null) {
            if (!z10) {
                if (str2 == null) {
                    str2 = "Unknown error";
                }
                jVar.a(str, str2);
                agentFrontClient.callbackMap.remove(str);
                return;
            }
            AgentFrontClient.f31910v.e("AgentFrontClient", "onMessageSent success. messageId=" + str);
            jVar.onSuccess(str);
        }
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onBindFailed(String reason) {
        AgentFrontClient.f31910v.e("AgentFrontClient", "onBindFailed: reason:" + reason);
        InterfaceC1505c clientStateListener = this.this$0.getClientStateListener();
        if (clientStateListener != null) {
            clientStateListener.onBindFailed(reason);
        }
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onConnected() {
        AgentFrontClient.f31910v.e("AgentFrontClient", "onConnected");
        InterfaceC1505c clientStateListener = this.this$0.getClientStateListener();
        if (clientStateListener != null) {
            clientStateListener.onConnected();
        }
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onDisconnected() {
        AgentFrontClient.f31910v.e("AgentFrontClient", "onDisconnected");
        InterfaceC1505c clientStateListener = this.this$0.getClientStateListener();
        if (clientStateListener != null) {
            clientStateListener.onDisconnected();
        }
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onMessageReceived(final Message message) {
        AgentFrontClient.f31910v.e("AgentFrontClient", "onMessageReceived: messageId:" + (message != null ? message.getMessageId() : null) + ", originMessageId:" + (message != null ? message.getOriginMessageId() : null) + ", conversationId:" + (message != null ? message.getConversationId() : null));
        if (message == null) {
            return;
        }
        Handler handler = this.this$0.callbackHandler;
        final AgentFrontClient agentFrontClient = this.this$0;
        handler.post(new Runnable() { // from class: com.zyql.agentfront.sdk.client.h
            @Override // java.lang.Runnable
            public final void run() {
                AgentFrontClient.H(agentFrontClient, message);
            }
        });
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onMessageSent(final String messageId, final boolean success, final String error) {
        AgentFrontClient.f31910v.e("AgentFrontClient", "onMessageSent: messageId:" + messageId + ", success:" + success + ", error:" + error);
        if (messageId == null) {
            return;
        }
        Handler handler = this.this$0.callbackHandler;
        final AgentFrontClient agentFrontClient = this.this$0;
        handler.post(new Runnable() { // from class: com.zyql.agentfront.sdk.client.i
            @Override // java.lang.Runnable
            public final void run() {
                AgentFrontClient$messageListenerStub$1.onMessageSent$lambda$1(agentFrontClient, messageId, success, error);
            }
        });
    }
}
