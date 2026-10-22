package com.zyql.agentfront.sdk.client;

import com.zyql.agentfront.bean.Message;
import com.zyql.agentfront.bean.ToolCallRequest;
import java.util.List;

/* loaded from: classes3.dex */
public interface c {
    void onError(String str, String str2);

    void onReply(Message message);

    void onSuccess(String str);

    void onToolCall(ToolCallRequest toolCallRequest);

    void onToolCalls(List list);
}
