package com.stepos.agentframework.chatui;

import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import u4.AgentMessage;
import u4.m;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\b\u0018\u0000 12\u00020\u0001:\u0001\u000fBA\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJJ\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010!R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/stepos/agentframework/chatui/J1;", "", "Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "type", "", "deepThinkText", "Lu4/m;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "Lcom/stepos/agentframework/chatui/P1;", "tools", "", "hiddenToolExecuteView", "<init>", "(Lcom/stepos/agentframework/chatcore/session/AgentMessageType;Ljava/lang/String;Lu4/m;Ljava/util/List;Z)V", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/session/AgentMessageType;Ljava/lang/String;Lu4/m;Ljava/util/List;Z)Lcom/stepos/agentframework/chatui/J1;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "l", "(Lcom/stepos/agentframework/chatcore/session/AgentMessageType;)V", "Ljava/lang/String;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)V", "Lu4/m;", "c", "()Lu4/m;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lu4/m;)V", "Ljava/util/List;", "f", "()Ljava/util/List;", "k", "(Ljava/util/List;)V", "Z", "e", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Z)V", "Companion", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.J1, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class DisplayChatMessage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private u4.m content;
    private String deepThinkText;
    private boolean hiddenToolExecuteView;
    private List<DisplayTool> tools;
    private AgentMessageType type;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/chatui/J1$a;", "", "<init>", "()V", "Lu4/a;", "message", "Lcom/stepos/agentframework/chatui/J1;", Const.INTENT_KEY_APIKEY, "(Lu4/a;)Lcom/stepos/agentframework/chatui/J1;", "Lu4/m;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, Const.INTENT_KEY_PKGNAME, "(Lu4/m;)Lu4/m;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.J1$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final DisplayChatMessage a(AgentMessage message) {
            ArrayList arrayList;
            kotlin.jvm.internal.p.i(message, "message");
            DisplayChatMessage displayChatMessage = new DisplayChatMessage(null, null, null, null, false, 31, null);
            displayChatMessage.l(message.getType());
            displayChatMessage.h(DisplayChatMessage.INSTANCE.b(message.getContent()));
            displayChatMessage.i(O6.f.INSTANCE.b(message.getDeepThinkText()));
            displayChatMessage.j(message.getHiddenToolExecuteView());
            List<AgentTool> listG = message.g();
            if (listG != null) {
                List<AgentTool> list = listG;
                arrayList = new ArrayList(C1174w.x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(DisplayTool.INSTANCE.a((AgentTool) it.next()));
                }
            } else {
                arrayList = null;
            }
            displayChatMessage.k(arrayList);
            return displayChatMessage;
        }

        public final u4.m b(u4.m content) {
            m.TextMessage textMessage = content instanceof m.TextMessage ? (m.TextMessage) content : null;
            if (textMessage != null) {
                O6.f fVar = O6.f.INSTANCE;
                String strB = fVar.b(textMessage.getText());
                String streamChunk = textMessage.getStreamChunk();
                String strB2 = streamChunk != null ? fVar.b(streamChunk) : null;
                if (!kotlin.jvm.internal.p.d(strB, textMessage.getText()) || !kotlin.jvm.internal.p.d(strB2, textMessage.getStreamChunk())) {
                    return textMessage.k(strB, strB2);
                }
            }
            return content;
        }

        public Companion() {
        }
    }

    public DisplayChatMessage() {
        this(null, null, null, null, false, 31, null);
    }

    public static /* synthetic */ DisplayChatMessage b(DisplayChatMessage displayChatMessage, AgentMessageType agentMessageType, String str, u4.m mVar, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            agentMessageType = displayChatMessage.type;
        }
        if ((i10 & 2) != 0) {
            str = displayChatMessage.deepThinkText;
        }
        if ((i10 & 4) != 0) {
            mVar = displayChatMessage.content;
        }
        if ((i10 & 8) != 0) {
            list = displayChatMessage.tools;
        }
        if ((i10 & 16) != 0) {
            z10 = displayChatMessage.hiddenToolExecuteView;
        }
        boolean z11 = z10;
        u4.m mVar2 = mVar;
        return displayChatMessage.a(agentMessageType, str, mVar2, list, z11);
    }

    public final DisplayChatMessage a(AgentMessageType type, String deepThinkText, u4.m content, List<DisplayTool> tools, boolean hiddenToolExecuteView) {
        kotlin.jvm.internal.p.i(type, "type");
        kotlin.jvm.internal.p.i(deepThinkText, "deepThinkText");
        kotlin.jvm.internal.p.i(content, "content");
        return new DisplayChatMessage(type, deepThinkText, content, tools, hiddenToolExecuteView);
    }

    /* renamed from: c, reason: from getter */
    public final u4.m getContent() {
        return this.content;
    }

    /* renamed from: d, reason: from getter */
    public final String getDeepThinkText() {
        return this.deepThinkText;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getHiddenToolExecuteView() {
        return this.hiddenToolExecuteView;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisplayChatMessage)) {
            return false;
        }
        DisplayChatMessage displayChatMessage = (DisplayChatMessage) other;
        return this.type == displayChatMessage.type && kotlin.jvm.internal.p.d(this.deepThinkText, displayChatMessage.deepThinkText) && kotlin.jvm.internal.p.d(this.content, displayChatMessage.content) && kotlin.jvm.internal.p.d(this.tools, displayChatMessage.tools) && this.hiddenToolExecuteView == displayChatMessage.hiddenToolExecuteView;
    }

    public final List<DisplayTool> f() {
        return this.tools;
    }

    /* renamed from: g, reason: from getter */
    public final AgentMessageType getType() {
        return this.type;
    }

    public final void h(u4.m mVar) {
        kotlin.jvm.internal.p.i(mVar, "<set-?>");
        this.content = mVar;
    }

    public int hashCode() {
        int iHashCode = ((((this.type.hashCode() * 31) + this.deepThinkText.hashCode()) * 31) + this.content.hashCode()) * 31;
        List<DisplayTool> list = this.tools;
        return ((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.hiddenToolExecuteView);
    }

    public final void i(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.deepThinkText = str;
    }

    public final void j(boolean z10) {
        this.hiddenToolExecuteView = z10;
    }

    public final void k(List<DisplayTool> list) {
        this.tools = list;
    }

    public final void l(AgentMessageType agentMessageType) {
        kotlin.jvm.internal.p.i(agentMessageType, "<set-?>");
        this.type = agentMessageType;
    }

    public String toString() {
        return "DisplayChatMessage(type=" + this.type + ", deepThinkText=" + this.deepThinkText + ", content=" + this.content + ", tools=" + this.tools + ", hiddenToolExecuteView=" + this.hiddenToolExecuteView + ")";
    }

    public DisplayChatMessage(AgentMessageType type, String deepThinkText, u4.m content, List<DisplayTool> list, boolean z10) {
        kotlin.jvm.internal.p.i(type, "type");
        kotlin.jvm.internal.p.i(deepThinkText, "deepThinkText");
        kotlin.jvm.internal.p.i(content, "content");
        this.type = type;
        this.deepThinkText = deepThinkText;
        this.content = content;
        this.tools = list;
        this.hiddenToolExecuteView = z10;
    }

    public /* synthetic */ DisplayChatMessage(AgentMessageType agentMessageType, String str, u4.m mVar, List list, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? AgentMessageType.TEXT : agentMessageType, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? new m.TextMessage("", null, 2, null) : mVar, (i10 & 8) != 0 ? null : list, (i10 & 16) != 0 ? false : z10);
    }
}
