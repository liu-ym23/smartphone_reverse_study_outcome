package com.obric.agent.im;

import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: OnIMMessageChangedObserver.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface d {

    /* JADX INFO: compiled from: OnIMMessageChangedObserver.kt */
    public static final class a {
        public static void a(d r2, List<IMMessage> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
            o.e((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), "messageList");
        }
    }

    void onInsertMessageList(List<IMMessage> r1);

    void onReceiveMessage(IMMessage r1);

    void onRegenMessage(IMMessage r1);

    void onSendMessage(IMMessage r1);

    void onUpdateMessage(IMMessage r1);
}
