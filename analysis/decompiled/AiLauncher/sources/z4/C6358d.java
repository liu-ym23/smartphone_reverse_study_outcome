package z4;

import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.M;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatui.DisplayChatMessage;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.DisplayTool;
import com.stepos.agentframework.chatui.ToolNameMapping;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import u4.m;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\fB1\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010¨\u0006\u0012"}, d2 = {"Lz4/d;", "", "Lcom/stepos/agentframework/chatui/N1;", "source", "", "references", "values", "toolNames", "<init>", "(Lcom/stepos/agentframework/chatui/N1;Ljava/util/List;Lcom/stepos/agentframework/chatui/N1;Ljava/lang/Object;)V", "next", "", Const.INTENT_KEY_APIKEY, "(Lz4/d;)Z", "Lcom/stepos/agentframework/chatui/N1;", "Ljava/util/List;", "Ljava/lang/Object;", "Companion", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: z4.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6358d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Object> references;
    private final DisplayMessage source;
    private final Object toolNames;
    private final DisplayMessage values;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lz4/d$a;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatui/N1;", "message", "", "bodyPartIndex", "Lz4/d;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatui/N1;I)Lz4/d;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: z4.d$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C6358d a(DisplayMessage message, int bodyPartIndex) {
            m.TextMessage textMessageL;
            ArrayList arrayList;
            p.i(message, "message");
            if (message.getStatus() == EReplyStatus.COMPLETED && !message.m().isEmpty() && message.getApprovalRequestId() == null && message.getAskUserConversation() == null) {
                ArrayList arrayList2 = new ArrayList();
                if (bodyPartIndex >= 0 && bodyPartIndex < message.m().size()) {
                    List listF1 = F.f1(message.m(), bodyPartIndex + 1);
                    ArrayList arrayList3 = new ArrayList(C1174w.x(listF1, 10));
                    int i10 = 0;
                    for (Object obj : listF1) {
                        int i11 = i10 + 1;
                        if (i10 < 0) {
                            C1173v.w();
                        }
                        DisplayChatMessage displayChatMessage = (DisplayChatMessage) obj;
                        if (displayChatMessage.getType() != AgentMessageType.TEXT && displayChatMessage.getType() != AgentMessageType.THINKING_TEXT && displayChatMessage.getType() != AgentMessageType.TOOL) {
                            return null;
                        }
                        m content = displayChatMessage.getContent();
                        m.TextMessage textMessage = content instanceof m.TextMessage ? (m.TextMessage) content : null;
                        if (textMessage == null) {
                            return null;
                        }
                        List<DisplayTool> listF = displayChatMessage.f();
                        if (listF != null) {
                            List<DisplayTool> list = listF;
                            if (!(list instanceof Collection) || !list.isEmpty()) {
                                Iterator<T> it = list.iterator();
                                while (it.hasNext()) {
                                    if (((DisplayTool) it.next()).getAppUIData() != null) {
                                        return null;
                                    }
                                }
                            }
                        }
                        arrayList2.add(displayChatMessage);
                        if (i10 == bodyPartIndex) {
                            textMessageL = new m.TextMessage("", null, 2, null);
                        } else {
                            arrayList2.add(textMessage);
                            textMessageL = m.TextMessage.l(textMessage, null, null, 3, null);
                        }
                        m.TextMessage textMessage2 = textMessageL;
                        List<DisplayTool> listF2 = displayChatMessage.f();
                        if (listF2 != null) {
                            List<DisplayTool> list2 = listF2;
                            ArrayList arrayList4 = new ArrayList(C1174w.x(list2, 10));
                            for (DisplayTool displayTool : list2) {
                                arrayList2.add(displayTool);
                                arrayList4.add(displayTool.a((65535 & 1) != 0 ? displayTool.toolCallId : null, (65535 & 2) != 0 ? displayTool.logo : null, (65535 & 4) != 0 ? displayTool.name : null, (65535 & 8) != 0 ? displayTool.description : null, (65535 & 16) != 0 ? displayTool.content : null, (65535 & 32) != 0 ? displayTool.parameter : null, (65535 & 64) != 0 ? displayTool.packageName : null, (65535 & 128) != 0 ? displayTool.isFinished : false, (65535 & 256) != 0 ? displayTool.pluginName : null, (65535 & 512) != 0 ? displayTool.result : null, (65535 & 1024) != 0 ? displayTool.appUIData : null, (65535 & 2048) != 0 ? displayTool.toolId : null, (65535 & 4096) != 0 ? displayTool.isExpand : false, (65535 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? displayTool.toolLikeStatus : 0, (65535 & 16384) != 0 ? displayTool.hidden : false, (65535 & 32768) != 0 ? displayTool.displayName : null));
                            }
                            arrayList = arrayList4;
                        } else {
                            arrayList = null;
                        }
                        arrayList3.add(DisplayChatMessage.b(displayChatMessage, null, null, textMessage2, arrayList, false, 19, null));
                        i10 = i11;
                    }
                    List listP1 = F.p1(arrayList3);
                    List<String> listZ = message.z();
                    List listM1 = listZ != null ? F.m1(listZ) : null;
                    List<String> listC = message.C();
                    return new C6358d(message, arrayList2, DisplayMessage.e(message, null, null, null, null, null, null, listP1, 0L, null, listM1, null, 0, null, false, 0, null, null, null, null, null, null, null, 0L, null, 0, 0, listC != null ? F.m1(listC) : null, false, 199228863, null), ToolNameMapping.INSTANCE.e(), null);
                }
            }
            return null;
        }

        public Companion() {
        }
    }

    public /* synthetic */ C6358d(DisplayMessage displayMessage, List list, DisplayMessage displayMessage2, Object obj, kotlin.jvm.internal.i iVar) {
        this(displayMessage, list, displayMessage2, obj);
    }

    public final boolean a(C6358d next) {
        if (next == null || this.source != next.source || this.toolNames != next.toolNames || this.references.size() != next.references.size()) {
            return false;
        }
        Iterable iterableN = C1173v.n(this.references);
        if (!(iterableN instanceof Collection) || !((Collection) iterableN).isEmpty()) {
            Iterator it = iterableN.iterator();
            while (it.hasNext()) {
                int iNextInt = ((M) it).nextInt();
                if (this.references.get(iNextInt) != next.references.get(iNextInt)) {
                    return false;
                }
            }
        }
        return p.d(this.values, next.values);
    }

    public C6358d(DisplayMessage displayMessage, List<? extends Object> list, DisplayMessage displayMessage2, Object obj) {
        this.source = displayMessage;
        this.references = list;
        this.values = displayMessage2;
        this.toolNames = obj;
    }
}
