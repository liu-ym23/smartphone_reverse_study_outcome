package com.stepos.ailauncher.taskstore.widget;

import android.content.Context;
import android.content.ContextWrapper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.view.BaseInputView;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0080\u0010¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroid/content/Context;", "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Ljava/lang/String;", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "artifact", "source", "LY8/t;", "c", "(Landroid/content/Context;Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;)V", "taskstore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.widget.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3738d {
    public static final ChatActivity a(Context context) {
        kotlin.jvm.internal.p.i(context, "<this>");
        while (!(context instanceof ChatActivity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
            kotlin.jvm.internal.p.h(context, "getBaseContext(...)");
        }
        return (ChatActivity) context;
    }

    public static final String b(Context context) {
        Object objB;
        AgentSession.AgentConversation agentConversationR1;
        String strH6;
        SessionHandler sessionHandler;
        AgentSession.AgentConversation agentConversationR12;
        String strB;
        kotlin.jvm.internal.p.i(context, "<this>");
        BaseInputView baseInputViewR0 = InputViewManager.INSTANCE.r0();
        String strB2 = null;
        if (baseInputViewR0 != null && (sessionHandler = baseInputViewR0.getSessionHandler()) != null && (agentConversationR12 = sessionHandler.R1()) != null && (strB = agentConversationR12.B()) != null) {
            if (strB.length() <= 0) {
                strB = null;
            }
            if (strB != null) {
                return strB;
            }
        }
        ChatActivity chatActivityA = a(context);
        if (chatActivityA != null && (strH6 = chatActivityA.H6()) != null) {
            if (strH6.length() <= 0) {
                strH6 = null;
            }
            if (strH6 != null) {
                return strH6;
            }
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            SessionHandler sessionHandler2 = AgentConfig.INSTANCE.a().getSessionHandler();
            if (sessionHandler2 != null && (agentConversationR1 = sessionHandler2.R1()) != null) {
                strB2 = agentConversationR1.B();
            }
            if (strB2 == null) {
                strB2 = "";
            }
            objB = Result.b(strB2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (String) (Result.g(objB) ? "" : objB);
    }

    public static final void c(Context context, SessionArtifact artifact, String source) {
        kotlin.jvm.internal.p.i(context, "<this>");
        kotlin.jvm.internal.p.i(artifact, "artifact");
        kotlin.jvm.internal.p.i(source, "source");
        ChatActivity chatActivityA = a(context);
        if (chatActivityA != null) {
            chatActivityA.n8(artifact, source);
            return;
        }
        String strB = b(context);
        if (strB.length() <= 0) {
            strB = null;
        }
        com.stepos.ailauncher.foundation.task.a.a(context, artifact, source, strB);
    }

    public static /* synthetic */ void d(Context context, SessionArtifact sessionArtifact, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "chatview";
        }
        c(context, sessionArtifact, str);
    }
}
