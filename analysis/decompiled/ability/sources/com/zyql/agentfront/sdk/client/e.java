package com.zyql.agentfront.sdk.client;

import com.zyql.agentfront.bean.Message;
import com.zyql.agentfront.bean.ToolCallRequest;
import java.util.List;

/* loaded from: classes3.dex */
public interface e {
    void onPushMessage(Message message);

    void onPushToolCall(ToolCallRequest toolCallRequest);

    void onPushToolCalls(List list);
}
