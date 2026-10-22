package com.zyql.agentfront.sdk.client;

import Z8.C1172u;
import Z8.F;
import c8.InterfaceC1505c;
import com.zyql.agentfront.IMessageListener;
import com.zyql.agentfront.bean.Message;
import com.zyql.agentfront.bean.ToolCall;
import com.zyql.agentfront.bean.ToolContent;
import com.zyql.agentfront.bean.ToolContentItem;
import com.zyql.agentfront.bean.ToolResponse;
import com.zyql.agentfront.bean.ToolResult;
import d8.InterfaceC3961a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0012\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"com/zyql/agentfront/sdk/client/OpenClawBridgeClient$messageListenerStub$1", "Lcom/zyql/agentfront/IMessageListener$Stub;", "LY8/t;", "onConnected", "()V", "onDisconnected", "", "reason", "onBindFailed", "(Ljava/lang/String;)V", "Lcom/zyql/agentfront/bean/Message;", "message", "onMessageReceived", "(Lcom/zyql/agentfront/bean/Message;)V", "messageId", "", "success", "error", "onMessageSent", "(Ljava/lang/String;ZLjava/lang/String;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OpenClawBridgeClient$messageListenerStub$1 extends IMessageListener.Stub {
    final /* synthetic */ k this$0;

    public OpenClawBridgeClient$messageListenerStub$1(k kVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMessageReceived$lambda$0(Message message, k kVar) {
        if (!kotlin.jvm.internal.p.d(message.getType(), "tool_result") || message.getToolCall() == null) {
            return;
        }
        ToolCall toolCall = message.getToolCall();
        kotlin.jvm.internal.p.f(toolCall);
        String toolCallId = toolCall.getToolCallId();
        k.f31939l.a("OpenClawBridgeClient", "[AIDL] onMessageReceived: tool_result received, toolCallId=" + toolCallId);
        String result = toolCall.getResult();
        if (result == null) {
            result = "";
        }
        ToolResponse toolResponse = new ToolResponse(toolCallId, new ToolResult(new ToolContent(C1172u.e(new ToolContentItem("text", result, null, null, null, null, 60, null)), toolCall.isError())));
        String str = (String) k.B(kVar).remove(toolCallId);
        if (str == null) {
            p pVar = (p) k.C(kVar).remove(toolCallId);
            if (pVar == null) {
                k.f31939l.c("OpenClawBridgeClient", "[AIDL] onMessageReceived: no callback found for toolCallId=" + toolCallId);
                return;
            }
            pVar.b(toolResponse);
            k.f31939l.a("OpenClawBridgeClient", "[AIDL] onMessageReceived: callback.onResult() invoked for toolCallId=" + toolCallId);
            return;
        }
        List list = (List) k.A(kVar).get(str);
        if (list != null) {
            synchronized (list) {
                list.add(toolResponse);
            }
            Collection collectionValues = k.B(kVar).values();
            kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
            Collection collection = collectionValues;
            if (!collection.isEmpty()) {
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (kotlin.jvm.internal.p.d((String) it.next(), str)) {
                        return;
                    }
                }
            }
            p pVar2 = (p) k.C(kVar).remove(str);
            k.A(kVar).remove(str);
            if (pVar2 != null) {
                pVar2.a(F.m1(list));
                k.f31939l.a("OpenClawBridgeClient", "[AIDL] onMessageReceived: batch complete, onResults() invoked, count=" + list.size());
            }
        }
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onBindFailed(String reason) {
        InterfaceC3961a.b(k.f31939l, "OpenClawBridgeClient", "[AIDL] onBindFailed: reason=" + reason, null, 4, null);
        InterfaceC1505c interfaceC1505cE = k.E(null);
        if (interfaceC1505cE != null) {
            interfaceC1505cE.onBindFailed(reason);
        }
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onConnected() {
        k.f31939l.a("OpenClawBridgeClient", "[AIDL] onConnected: service connected");
        InterfaceC1505c interfaceC1505cE = k.E(null);
        if (interfaceC1505cE != null) {
            interfaceC1505cE.onConnected();
        }
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onDisconnected() {
        k.f31939l.c("OpenClawBridgeClient", "[AIDL] onDisconnected: service disconnected");
        InterfaceC1505c interfaceC1505cE = k.E(null);
        if (interfaceC1505cE != null) {
            interfaceC1505cE.onDisconnected();
        }
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onMessageReceived(final Message message) {
        if (message == null) {
            return;
        }
        k.f31939l.a("OpenClawBridgeClient", "[AIDL] onMessageReceived: messageId=" + message.getMessageId() + ", type=" + message.getType() + ", isFinish=" + message.isFinish());
        final k kVar = null;
        k.D(null).post(new Runnable(kVar) { // from class: com.zyql.agentfront.sdk.client.l
            @Override // java.lang.Runnable
            public final void run() {
                OpenClawBridgeClient$messageListenerStub$1.onMessageReceived$lambda$0(this.f31940a, null);
            }
        });
    }

    @Override // com.zyql.agentfront.IMessageListener
    public void onMessageSent(final String messageId, final boolean success, final String error) {
        if (messageId == null) {
            return;
        }
        k.f31939l.a("OpenClawBridgeClient", "onMessageSent: messageId=" + messageId + ", success=" + success);
        final k kVar = null;
        k.D(null).post(new Runnable(kVar, messageId, success, error) { // from class: com.zyql.agentfront.sdk.client.m

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f31941a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f31942b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f31943c;

            {
                this.f31941a = messageId;
                this.f31942b = success;
                this.f31943c = error;
            }

            @Override // java.lang.Runnable
            public final void run() {
                String str = this.f31941a;
                boolean z10 = this.f31942b;
                String str2 = this.f31943c;
                k.G(null);
            }
        });
    }
}
