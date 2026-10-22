package com.zyql.agentfront.sdk.client;

import com.autonavi.aps.amapapi.config.Const;
import com.zyql.agentfront.bean.Message;
import com.zyql.agentfront.bean.ToolCallRequest;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/zyql/agentfront/sdk/client/j;", "", "", "messageId", "LY8/t;", "onSuccess", "(Ljava/lang/String;)V", "error", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/zyql/agentfront/bean/Message;", "message", Const.INTENT_KEY_UMID, "(Lcom/zyql/agentfront/bean/Message;)V", "Lcom/zyql/agentfront/bean/ToolCallRequest;", "request", Const.INTENT_KEY_PKGNAME, "(Lcom/zyql/agentfront/bean/ToolCallRequest;)V", "", "requests", "c", "(Ljava/util/List;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface j {
    default void a(String messageId, String error) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(error, "error");
    }

    default void b(ToolCallRequest request) {
        kotlin.jvm.internal.p.i(request, "request");
    }

    default void c(List<ToolCallRequest> requests) {
        kotlin.jvm.internal.p.i(requests, "requests");
        Iterator<T> it = requests.iterator();
        while (it.hasNext()) {
            b((ToolCallRequest) it.next());
        }
    }

    default void d(Message message) {
        kotlin.jvm.internal.p.i(message, "message");
    }

    default void onSuccess(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
    }
}
