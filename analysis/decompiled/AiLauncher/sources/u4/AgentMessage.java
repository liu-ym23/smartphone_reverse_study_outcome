package u4;

import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import u4.m;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b!\b\u0086\b\u0018\u0000 42\u00020\u0001:\u0001\u0010BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJT\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\"R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010-\u001a\u0004\b2\u0010/\"\u0004\b3\u00101¨\u00065"}, d2 = {"Lu4/a;", "", "Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "type", "", "deepThinkText", "Lu4/m;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "Lcom/stepos/agentframework/chatcore/intent/e;", "tools", "", "hiddenInUi", "hiddenToolExecuteView", "<init>", "(Lcom/stepos/agentframework/chatcore/session/AgentMessageType;Ljava/lang/String;Lu4/m;Ljava/util/List;ZZ)V", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/session/AgentMessageType;Ljava/lang/String;Lu4/m;Ljava/util/List;ZZ)Lu4/a;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "m", "(Lcom/stepos/agentframework/chatcore/session/AgentMessageType;)V", "Ljava/lang/String;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)V", "Lu4/m;", "c", "()Lu4/m;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lu4/m;)V", "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/List;", "l", "(Ljava/util/List;)V", "Z", "e", "()Z", "setHiddenInUi", "(Z)V", "f", "k", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: u4.a, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class AgentMessage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private m content;
    private String deepThinkText;
    private boolean hiddenInUi;
    private boolean hiddenToolExecuteView;
    private List<AgentTool> tools;
    private AgentMessageType type;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lu4/a$a;", "", "<init>", "()V", "", "Lu4/m;", "messages", "Lu4/a;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: u4.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final List<AgentMessage> a(List<? extends m> messages) throws Exception {
            AgentMessage agentMessage;
            p.i(messages, "messages");
            List<? extends m> list = messages;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            for (m mVar : list) {
                if (mVar instanceof m.TextMessage) {
                    agentMessage = new AgentMessage(AgentMessageType.TEXT, null, mVar, null, false, false, 58, null);
                } else if (mVar instanceof m.ImageMessage) {
                    agentMessage = new AgentMessage(AgentMessageType.IMAGE, null, mVar, null, ((m.ImageMessage) mVar).getSilent(), false, 42, null);
                } else if (mVar instanceof m.AudioMessage) {
                    agentMessage = new AgentMessage(AgentMessageType.AUDIO, null, mVar, null, false, false, 58, null);
                } else if (mVar instanceof m.FileMessage) {
                    agentMessage = new AgentMessage(AgentMessageType.FILE, null, mVar, null, false, false, 58, null);
                } else if (mVar instanceof m.FolderMessage) {
                    agentMessage = new AgentMessage(AgentMessageType.FOLDER, null, mVar, null, false, false, 58, null);
                } else {
                    if (!(mVar instanceof m.VideoMessage)) {
                        throw new Exception("不支持的消息类型");
                    }
                    agentMessage = new AgentMessage(AgentMessageType.VIDEO, null, mVar, null, false, false, 58, null);
                }
                arrayList.add(agentMessage);
            }
            return arrayList;
        }

        public Companion() {
        }
    }

    public AgentMessage() {
        this(null, null, null, null, false, false, 63, null);
    }

    public static /* synthetic */ AgentMessage b(AgentMessage agentMessage, AgentMessageType agentMessageType, String str, m mVar, List list, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            agentMessageType = agentMessage.type;
        }
        if ((i10 & 2) != 0) {
            str = agentMessage.deepThinkText;
        }
        if ((i10 & 4) != 0) {
            mVar = agentMessage.content;
        }
        if ((i10 & 8) != 0) {
            list = agentMessage.tools;
        }
        if ((i10 & 16) != 0) {
            z10 = agentMessage.hiddenInUi;
        }
        if ((i10 & 32) != 0) {
            z11 = agentMessage.hiddenToolExecuteView;
        }
        boolean z12 = z10;
        boolean z13 = z11;
        return agentMessage.a(agentMessageType, str, mVar, list, z12, z13);
    }

    public final AgentMessage a(AgentMessageType type, String deepThinkText, m content, List<AgentTool> tools, boolean hiddenInUi, boolean hiddenToolExecuteView) {
        p.i(type, "type");
        p.i(deepThinkText, "deepThinkText");
        p.i(content, "content");
        return new AgentMessage(type, deepThinkText, content, tools, hiddenInUi, hiddenToolExecuteView);
    }

    /* renamed from: c, reason: from getter */
    public final m getContent() {
        return this.content;
    }

    /* renamed from: d, reason: from getter */
    public final String getDeepThinkText() {
        return this.deepThinkText;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getHiddenInUi() {
        return this.hiddenInUi;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentMessage)) {
            return false;
        }
        AgentMessage agentMessage = (AgentMessage) other;
        return this.type == agentMessage.type && p.d(this.deepThinkText, agentMessage.deepThinkText) && p.d(this.content, agentMessage.content) && p.d(this.tools, agentMessage.tools) && this.hiddenInUi == agentMessage.hiddenInUi && this.hiddenToolExecuteView == agentMessage.hiddenToolExecuteView;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getHiddenToolExecuteView() {
        return this.hiddenToolExecuteView;
    }

    public final List<AgentTool> g() {
        return this.tools;
    }

    /* renamed from: h, reason: from getter */
    public final AgentMessageType getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((((this.type.hashCode() * 31) + this.deepThinkText.hashCode()) * 31) + this.content.hashCode()) * 31;
        List<AgentTool> list = this.tools;
        return ((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.hiddenInUi)) * 31) + Boolean.hashCode(this.hiddenToolExecuteView);
    }

    public final void i(m mVar) {
        p.i(mVar, "<set-?>");
        this.content = mVar;
    }

    public final void j(String str) {
        p.i(str, "<set-?>");
        this.deepThinkText = str;
    }

    public final void k(boolean z10) {
        this.hiddenToolExecuteView = z10;
    }

    public final void l(List<AgentTool> list) {
        this.tools = list;
    }

    public final void m(AgentMessageType agentMessageType) {
        p.i(agentMessageType, "<set-?>");
        this.type = agentMessageType;
    }

    public String toString() {
        return "AgentMessage(type=" + this.type + ", deepThinkText=" + this.deepThinkText + ", content=" + this.content + ", tools=" + this.tools + ", hiddenInUi=" + this.hiddenInUi + ", hiddenToolExecuteView=" + this.hiddenToolExecuteView + ")";
    }

    public AgentMessage(AgentMessageType type, String deepThinkText, m content, List<AgentTool> list, boolean z10, boolean z11) {
        p.i(type, "type");
        p.i(deepThinkText, "deepThinkText");
        p.i(content, "content");
        this.type = type;
        this.deepThinkText = deepThinkText;
        this.content = content;
        this.tools = list;
        this.hiddenInUi = z10;
        this.hiddenToolExecuteView = z11;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ AgentMessage(com.stepos.agentframework.chatcore.session.AgentMessageType r3, java.lang.String r4, u4.m r5, java.util.List r6, boolean r7, boolean r8, int r9, kotlin.jvm.internal.i r10) {
        /*
            r2 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L6
            com.stepos.agentframework.chatcore.session.AgentMessageType r3 = com.stepos.agentframework.chatcore.session.AgentMessageType.TEXT
        L6:
            r10 = r9 & 2
            java.lang.String r0 = ""
            if (r10 == 0) goto Ld
            r4 = r0
        Ld:
            r10 = r9 & 4
            r1 = 0
            if (r10 == 0) goto L18
            u4.m$h r5 = new u4.m$h
            r10 = 2
            r5.<init>(r0, r1, r10, r1)
        L18:
            r10 = r9 & 8
            if (r10 == 0) goto L1d
            r6 = r1
        L1d:
            r10 = r9 & 16
            r0 = 0
            if (r10 == 0) goto L23
            r7 = r0
        L23:
            r9 = r9 & 32
            if (r9 == 0) goto L2f
            r10 = r0
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            goto L36
        L2f:
            r10 = r8
            r9 = r7
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r4 = r2
        L36:
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.AgentMessage.<init>(com.stepos.agentframework.chatcore.session.AgentMessageType, java.lang.String, u4.m, java.util.List, boolean, boolean, int, kotlin.jvm.internal.i):void");
    }
}
