package com.zyql.agentfront.sdk.client;

import com.autonavi.aps.amapapi.config.Const;
import com.zyql.agentfront.bean.Message;
import com.zyql.agentfront.bean.ToolCallRequest;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/zyql/agentfront/sdk/client/o;", "", "Lcom/zyql/agentfront/bean/Message;", "message", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/zyql/agentfront/bean/Message;)V", "Lcom/zyql/agentfront/bean/ToolCallRequest;", "toolCallRequest", "c", "(Lcom/zyql/agentfront/bean/ToolCallRequest;)V", "", "toolCallRequests", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface o {
    void a(Message message);

    default void b(List<ToolCallRequest> toolCallRequests) {
        kotlin.jvm.internal.p.i(toolCallRequests, "toolCallRequests");
        Iterator<T> it = toolCallRequests.iterator();
        while (it.hasNext()) {
            c((ToolCallRequest) it.next());
        }
    }

    void c(ToolCallRequest toolCallRequest);
}
