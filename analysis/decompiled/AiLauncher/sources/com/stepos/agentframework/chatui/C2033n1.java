package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import u4.m;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u000b\u0010\nJ%\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/chatui/n1;", "", "<init>", "()V", "", "Lcom/stepos/agentframework/chatui/S1;", DidiCardProvider.KEY_ITEMS, "", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Iterable;)Ljava/util/Set;", "c", "Lcom/stepos/agentframework/chatui/N1;", "message", "", "flags", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatui/N1;Ljava/util/Set;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.n1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2033n1 {
    public static final C2033n1 INSTANCE = new C2033n1();

    public final void a(DisplayMessage message, Set<String> flags) {
        String messageId = message.getMessageId();
        if (messageId.length() > 0) {
            flags.add(messageId);
            flags.add(messageId + "_task");
        }
        for (DisplayChatMessage displayChatMessage : message.m()) {
            List<DisplayTool> listF = displayChatMessage.f();
            if (listF != null) {
                for (DisplayTool displayTool : listF) {
                    if (displayTool.getToolCallId().length() > 0) {
                        flags.add(displayTool.getToolCallId());
                    }
                    String strC = q4.j.INSTANCE.C(displayTool.getAppUIData());
                    if (strC != null) {
                        flags.add(strC);
                    }
                }
            }
            u4.m content = displayChatMessage.getContent();
            m.TaskMessage taskMessage = content instanceof m.TaskMessage ? (m.TaskMessage) content : null;
            String taskId = taskMessage != null ? taskMessage.getTaskId() : null;
            if (taskId != null && taskId.length() != 0) {
                flags.add(taskId);
            }
        }
    }

    public final Set<String> b(Iterable<? extends S1> items) {
        kotlin.jvm.internal.p.i(items, "items");
        HashSet hashSet = new HashSet();
        for (S1 s12 : items) {
            DisplayMessage displayMessage = s12 instanceof DisplayMessage ? (DisplayMessage) s12 : null;
            if (displayMessage != null) {
                a(displayMessage, hashSet);
            }
        }
        return hashSet;
    }

    public final Set<String> c(Iterable<? extends S1> items) {
        String sessionId;
        kotlin.jvm.internal.p.i(items, "items");
        HashSet hashSet = new HashSet();
        for (S1 s12 : items) {
            DisplayMessage displayMessage = s12 instanceof DisplayMessage ? (DisplayMessage) s12 : null;
            if (displayMessage != null && (sessionId = displayMessage.getSessionId()) != null && sessionId.length() > 0) {
                hashSet.add(sessionId);
            }
        }
        return hashSet;
    }
}
