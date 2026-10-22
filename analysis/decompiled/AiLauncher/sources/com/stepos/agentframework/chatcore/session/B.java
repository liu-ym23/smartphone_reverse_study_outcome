package com.stepos.agentframework.chatcore.session;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.json.JSONObject;
import p9.InterfaceC5074l;
import u4.AgentMessage;
import w4.ChatMessage;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ1\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/B;", "", "<init>", "()V", "Lw4/c;", "message", "", Const.INTENT_KEY_UMID, "(Lw4/c;)Z", "f", "causeIsSelfRunningStall", "holdForUserInput", "hasDisplayableContent", "toolsSettled", Const.INTENT_KEY_BACKGROUND_COMMAND, "(ZZZZ)Z", "Lcom/stepos/agentframework/chatcore/intent/e;", "tool", "e", "(Lcom/stepos/agentframework/chatcore/intent/e;)Z", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lw4/c;)Ljava/util/List;", "", "ABILITY_WRAPPER_NAME", "Ljava/lang/String;", "ACTION_SEARCH", "ACTION_SEARCH_TOKEN", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class B {
    private static final String ABILITY_WRAPPER_NAME = "ability";
    private static final String ACTION_SEARCH = "search";
    private static final String ACTION_SEARCH_TOKEN = "\"search\"";
    public static final B INSTANCE = new B();

    public static final boolean i(AgentMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getType() == AgentMessageType.TOOL;
    }

    public static final Ka.j j(AgentMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        List<AgentTool> listG = it.g();
        if (listG == null) {
            listG = C1173v.m();
        }
        return Z8.F.d0(listG);
    }

    public static final boolean k(AgentTool it) {
        kotlin.jvm.internal.p.i(it, "it");
        return !it.getHidden();
    }

    public final boolean d(ChatMessage message) {
        kotlin.jvm.internal.p.i(message, "message");
        List<AgentTool> listH = h(message);
        if ((listH instanceof Collection) && listH.isEmpty()) {
            return true;
        }
        Iterator<T> it = listH.iterator();
        while (it.hasNext()) {
            if (!((AgentTool) it.next()).getIsFinished()) {
                return false;
            }
        }
        return true;
    }

    public final boolean e(AgentTool tool) {
        Object objB;
        if ((!kotlin.jvm.internal.p.d(tool.getName(), ABILITY_WRAPPER_NAME) && !kotlin.jvm.internal.p.d(tool.getApiName(), ABILITY_WRAPPER_NAME)) || !La.H.g0(tool.getParameter(), ACTION_SEARCH_TOKEN, false, 2, null)) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(kotlin.jvm.internal.p.d(new JSONObject(tool.getParameter()).optString("action"), "search")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean f(ChatMessage message) {
        kotlin.jvm.internal.p.i(message, "message");
        List<AgentTool> listH = h(message);
        if (listH.isEmpty()) {
            return false;
        }
        List<AgentTool> list = listH;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!((AgentTool) it.next()).getIsFinished()) {
                    return false;
                }
            }
        }
        return !e((AgentTool) Z8.F.C0(listH));
    }

    public final boolean g(boolean causeIsSelfRunningStall, boolean holdForUserInput, boolean hasDisplayableContent, boolean toolsSettled) {
        if (!causeIsSelfRunningStall || holdForUserInput) {
            return false;
        }
        if (hasDisplayableContent) {
            return toolsSettled;
        }
        return true;
    }

    public final List<AgentTool> h(ChatMessage message) {
        return SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.L(SequencesKt___SequencesKt.F(Z8.F.d0(message.i()), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.y
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(B.i((AgentMessage) obj));
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return B.j((AgentMessage) obj);
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.A
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(B.k((AgentTool) obj));
            }
        }));
    }
}
