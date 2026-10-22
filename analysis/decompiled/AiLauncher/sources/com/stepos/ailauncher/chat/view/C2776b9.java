package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.DisplayChatMessage;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import u4.m;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a%\u0010\u0006\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Lcom/stepos/agentframework/chatui/S1;", DidiCardProvider.KEY_ITEMS, "", "taskId", "", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;Ljava/lang/String;)I", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.b9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2776b9 {
    public static final int a(List<? extends com.stepos.agentframework.chatui.S1> items, String taskId) {
        List<DisplayChatMessage> listM;
        kotlin.jvm.internal.p.i(items, "items");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (La.H.x0(taskId)) {
            return -1;
        }
        int i10 = 0;
        for (com.stepos.agentframework.chatui.S1 s12 : items) {
            DisplayMessage displayMessage = s12 instanceof DisplayMessage ? (DisplayMessage) s12 : null;
            if (displayMessage != null && (listM = displayMessage.m()) != null) {
                List<DisplayChatMessage> list = listM;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        u4.m content = ((DisplayChatMessage) it.next()).getContent();
                        m.TaskMessage taskMessage = content instanceof m.TaskMessage ? (m.TaskMessage) content : null;
                        if (kotlin.jvm.internal.p.d(taskMessage != null ? taskMessage.getTaskId() : null, taskId)) {
                            return i10;
                        }
                    }
                }
            }
            i10++;
        }
        return -1;
    }
}
