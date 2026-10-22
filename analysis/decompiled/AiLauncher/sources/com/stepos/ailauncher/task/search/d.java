package com.stepos.ailauncher.task.search;

import La.H;
import La.K;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.netcore.BusTaskStatus;
import com.stepos.agentframework.chatcore.search.ConversationSearchSnapshot;
import com.stepos.agentframework.chatcore.search.MessageSearchHit;
import com.stepos.agentframework.chatcore.search.SessionSearchHit;
import com.stepos.agentframework.chatcore.search.TaskSearchHit;
import com.stepos.agentframework.chatcore.search.TaskSearchMatchedField;
import com.stepos.agentframework.chatcore.session.ConversationSessionKind;
import com.stepos.agentframework.chatcore.session.list.SessionAgentCategory;
import com.stepos.agentframework.chatcore.session.list.SessionAuthorizationState;
import com.stepos.agentframework.chatcore.session.list.SessionChatPhase;
import com.stepos.agentframework.chatcore.session.list.SessionListItem;
import com.stepos.ailauncher.contract.model.search.SearchMatchedField;
import com.stepos.ailauncher.contract.model.search.SearchTaskStatus;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import com.stepos.ailauncher.contract.model.search.SidebarSessionKind;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.ailauncher.task.space.C3664r1;
import com.stepos.ailauncher.task.space.TaskSearchTextExtractor;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u001a!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\u0001*\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a%\u0010\u0014\u001a\u00020\u0013*\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a%\u0010\u0016\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0017\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a)\u0010\u001f\u001a\u00020\u001e*\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a\u0013\u0010\"\u001a\u00020\u001b*\u00020!H\u0002¢\u0006\u0004\b\"\u0010#\u001a\u0013\u0010&\u001a\u00020%*\u00020$H\u0002¢\u0006\u0004\b&\u0010'\u001a%\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001b0(*\b\u0012\u0004\u0012\u00020\u00110\u0003H\u0002¢\u0006\u0004\b)\u0010*\u001a\u0013\u0010-\u001a\u00020,*\u00020+H\u0000¢\u0006\u0004\b-\u0010.\u001a\u0013\u0010/\u001a\u00020\u0001*\u00020+H\u0000¢\u0006\u0004\b/\u00100\u001a)\u00104\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u00103\u001a\u000202H\u0000¢\u0006\u0004\b4\u00105\u001a\u001f\u00106\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b6\u00107\"\u0014\u00108\u001a\u0002028\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/stepos/agentframework/chatcore/search/a;", "", "query", "", "Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", "q", "(Lcom/stepos/agentframework/chatcore/search/a;Ljava/lang/String;)Ljava/util/List;", "title", "message", "preview", "Lcom/stepos/ailauncher/task/search/a;", "l", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/task/search/a;", "Lcom/stepos/agentframework/chatcore/search/m;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentframework/chatcore/search/m;)Ljava/lang/String;", "Lcom/stepos/agentframework/chatcore/search/n;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "Lcom/stepos/ailauncher/contract/model/search/TaskSearchHit;", "p", "(Lcom/stepos/agentframework/chatcore/search/n;Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Lcom/stepos/ailauncher/contract/model/search/TaskSearchHit;", "o", "(Lcom/stepos/agentframework/chatcore/search/n;Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Ljava/lang/String;", "m", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Ljava/lang/String;", "Lcom/stepos/agentframework/chatcore/session/list/b;", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "taskState", "chatState", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "u", "(Lcom/stepos/agentframework/chatcore/session/list/b;Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;)Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;", "t", "(Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;)Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "Lcom/stepos/agentframework/chatcore/session/ConversationSessionKind;", "Lcom/stepos/ailauncher/contract/model/search/SidebarSessionKind;", "r", "(Lcom/stepos/agentframework/chatcore/session/ConversationSessionKind;)Lcom/stepos/ailauncher/contract/model/search/SidebarSessionKind;", "", "k", "(Ljava/util/List;)Ljava/util/Map;", "Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "Lcom/stepos/ailauncher/contract/model/search/SearchTaskStatus;", "s", "(Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;)Lcom/stepos/ailauncher/contract/model/search/SearchTaskStatus;", "f", "(Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;)Ljava/lang/String;", UxipConstants.f30680s, "", "maxLength", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "MAX_SNIPPET_LEADING_CONTEXT_LENGTH", "I", "task_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    private static final int MAX_SNIPPET_LEADING_CONTEXT_LENGTH = 6;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[SessionChatPhase.values().length];
            try {
                iArr[SessionChatPhase.REPLYING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SessionChatPhase.WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SessionChatPhase.REPLIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SessionChatPhase.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ConversationSessionKind.values().length];
            try {
                iArr2[ConversationSessionKind.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ConversationSessionKind.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ConversationSessionKind.CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[BusTaskStatus.values().length];
            try {
                iArr3[BusTaskStatus.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[BusTaskStatus.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[BusTaskStatus.PLANNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[BusTaskStatus.PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[BusTaskStatus.RUNNING.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[BusTaskStatus.IN_PROGRESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[BusTaskStatus.PAUSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[BusTaskStatus.COMPLETED.ordinal()] = 8;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[BusTaskStatus.SKIPPED.ordinal()] = 9;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[BusTaskStatus.FAILED.ordinal()] = 10;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr3[BusTaskStatus.CANCELLED.ordinal()] = 11;
            } catch (NoSuchFieldError unused18) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final String f(BusTaskStatus busTaskStatus) {
        p.i(busTaskStatus, "<this>");
        switch (a.$EnumSwitchMapping$2[busTaskStatus.ordinal()]) {
            case 1:
                return "等待输入";
            case 2:
                return "已创建";
            case 3:
                return "规划中";
            case 4:
                return "待执行";
            case 5:
            case 6:
                return "执行中";
            case 7:
                return "已暂停";
            case 8:
                return AlipayXuiIsland.LABEL_COMPLETED;
            case 9:
                return "已跳过";
            case 10:
                return "失败";
            case 11:
                return AlipayXuiIsland.LABEL_CANCELLED;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final String g(SessionSearchHit sessionSearchHit) {
        String agentDisplayName = sessionSearchHit.getAgentDisplayName();
        if (sessionSearchHit.getAgentCategory() != SessionAgentCategory.EXTERNAL) {
            agentDisplayName = null;
        }
        return agentDisplayName == null ? "" : agentDisplayName;
    }

    public static final String h(String value, String query) {
        p.i(value, "value");
        p.i(query, "query");
        return H.e0(value, query, true) ? j(value, query, 0, 4, null) : "";
    }

    public static final String i(String value, String query, int i10) {
        p.i(value, "value");
        p.i(query, "query");
        String string = H.D1(new Regex("\\s+").l(value, " ")).toString();
        int iF = C5685n.f(i10, 1);
        if (string.length() <= iF) {
            return string;
        }
        int iU0 = H.u0(string, query, 0, true, 2, null);
        if (H.x0(query) || iU0 < 0) {
            return H.F1(K.R1(string, iF)).toString() + "…";
        }
        int iMax = Math.max(iF, query.length());
        int iMin = iU0 - Math.min(iU0, Math.min(6, C5685n.f(iMax - query.length(), 0)));
        int iJ = C5685n.j(iMax + iMin, string.length());
        StringBuilder sb2 = new StringBuilder();
        if (iMin > 0) {
            sb2.append((char) 8230);
        }
        String strSubstring = string.substring(iMin, iJ);
        p.h(strSubstring, "substring(...)");
        sb2.append(H.D1(strSubstring).toString());
        if (iJ < string.length()) {
            sb2.append((char) 8230);
        }
        return sb2.toString();
    }

    public static /* synthetic */ String j(String str, String str2, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 48;
        }
        return i(str, str2, i10);
    }

    public static final Map<String, SessionActivityState> k(List<TaskInfoCard> list) {
        return A6.c.INSTANCE.g(list);
    }

    public static final SessionSearchTextProjection l(String title, String message, String query, String preview) {
        p.i(title, "title");
        p.i(message, "message");
        p.i(query, "query");
        p.i(preview, "preview");
        boolean zE0 = H.e0(title, query, true);
        String strH = h(message, query);
        if (strH.length() == 0) {
            strH = j(preview, query, 0, 4, null);
        }
        return new SessionSearchTextProjection(strH, zE0 ? SearchMatchedField.TITLE : SearchMatchedField.MESSAGE);
    }

    public static final String m(TaskInfoCard card) {
        p.i(card, "card");
        String strC = C3664r1.INSTANCE.c(card);
        if (!H.x0(strC)) {
            return strC;
        }
        List<TaskInfoPart> result = card.getResult();
        if (result == null) {
            result = C1173v.m();
        }
        String str = (String) SequencesKt___SequencesKt.K(SequencesKt___SequencesKt.S(F.d0(result), new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.search.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return d.n((TaskInfoPart) obj);
            }
        }));
        return str == null ? "" : str;
    }

    public static final String n(TaskInfoPart part) {
        String string;
        String string2;
        p.i(part, "part");
        String title = part.getTitle();
        if (title != null && (string2 = H.D1(title).toString()) != null) {
            if (H.x0(string2)) {
                string2 = null;
            }
            if (string2 != null) {
                return string2;
            }
        }
        String fileName = part.getFileName();
        if (fileName == null || (string = H.D1(fileName).toString()) == null || H.x0(string)) {
            return null;
        }
        return string;
    }

    public static final String o(TaskSearchHit taskSearchHit, String str, TaskInfoCard taskInfoCard) {
        if (taskInfoCard == null) {
            return taskSearchHit.getMatchedField() == TaskSearchMatchedField.DETAIL ? h(taskSearchHit.getMatchedText(), str) : "";
        }
        String strM = m(taskInfoCard);
        if (H.e0(strM, str, true)) {
            return j(strM, str, 0, 4, null);
        }
        String strP = TaskSearchTextExtractor.INSTANCE.p(taskInfoCard);
        String str2 = H.e0(strP, str, true) ? strP : null;
        if (str2 == null) {
            if (H.x0(strM)) {
                strM = strP;
            }
            str2 = strM;
        }
        return j(str2, str, 0, 4, null);
    }

    public static final com.stepos.ailauncher.contract.model.search.TaskSearchHit p(TaskSearchHit taskSearchHit, String query, TaskInfoCard taskInfoCard) {
        p.i(taskSearchHit, "<this>");
        p.i(query, "query");
        return new com.stepos.ailauncher.contract.model.search.TaskSearchHit(taskSearchHit.getTaskId(), taskSearchHit.getSessionId(), taskSearchHit.getAgentId(), taskSearchHit.getDeviceId(), taskSearchHit.getTitle(), o(taskSearchHit, query, taskInfoCard), s(taskSearchHit.getStatus()), f(taskSearchHit.getStatus()), taskSearchHit.getUpdatedAt());
    }

    public static final List<com.stepos.ailauncher.contract.model.search.SessionSearchHit> q(ConversationSearchSnapshot conversationSearchSnapshot, String str) {
        List<MessageSearchHit> listC = conversationSearchSnapshot.c();
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(listC, 10)), 16));
        for (Object obj : listC) {
            linkedHashMap.put(((MessageSearchHit) obj).getSessionId(), obj);
        }
        List<SessionSearchHit> listD = conversationSearchSnapshot.d();
        ArrayList arrayList = new ArrayList(C1174w.x(listD, 10));
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            SessionSearchHit sessionSearchHit = (SessionSearchHit) it.next();
            MessageSearchHit messageSearchHit = (MessageSearchHit) linkedHashMap.get(sessionSearchHit.getSessionId());
            String title = sessionSearchHit.getTitle();
            String text = messageSearchHit != null ? messageSearchHit.getText() : null;
            if (text == null) {
                text = "";
            }
            SessionSearchTextProjection sessionSearchTextProjectionL = l(title, text, str, sessionSearchHit.getPreviewText());
            Iterator it2 = it;
            arrayList.add(new com.stepos.ailauncher.contract.model.search.SessionSearchHit(sessionSearchHit.getSessionId(), sessionSearchHit.getAgentId(), sessionSearchHit.getDeviceId(), sessionSearchHit.getTitle(), sessionSearchTextProjectionL.getSnippet(), sessionSearchTextProjectionL.getMatchedField(), Math.max(sessionSearchHit.getUpdatedAt(), messageSearchHit != null ? messageSearchHit.getUpdatedAt() : 0L), g(sessionSearchHit)));
            it = it2;
        }
        return arrayList;
    }

    public static final SidebarSessionKind r(ConversationSessionKind conversationSessionKind) {
        int i10 = a.$EnumSwitchMapping$1[conversationSessionKind.ordinal()];
        if (i10 == 1) {
            return SidebarSessionKind.NORMAL;
        }
        if (i10 == 2) {
            return SidebarSessionKind.MAIN;
        }
        if (i10 == 3) {
            return SidebarSessionKind.CHANNEL;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final SearchTaskStatus s(BusTaskStatus busTaskStatus) {
        p.i(busTaskStatus, "<this>");
        switch (a.$EnumSwitchMapping$2[busTaskStatus.ordinal()]) {
            case 1:
                return SearchTaskStatus.WAITING_FOR_USER;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return SearchTaskStatus.RUNNING;
            case 8:
            case 9:
                return SearchTaskStatus.COMPLETED;
            case 10:
                return SearchTaskStatus.FAILED;
            case 11:
                return SearchTaskStatus.CANCELLED;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final SessionActivityState t(SessionChatPhase sessionChatPhase) {
        int i10 = a.$EnumSwitchMapping$0[sessionChatPhase.ordinal()];
        if (i10 == 1) {
            return SessionActivityState.RUNNING;
        }
        if (i10 == 2) {
            return SessionActivityState.WAITING_FOR_USER;
        }
        if (i10 == 3) {
            return SessionActivityState.COMPLETED_UNREAD;
        }
        if (i10 == 4) {
            return SessionActivityState.FAILED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final SidebarSession u(SessionListItem sessionListItem, SessionActivityState sessionActivityState, SessionActivityState sessionActivityState2) {
        boolean z10;
        boolean z11;
        String sessionId = sessionListItem.getSessionId();
        String agentId = sessionListItem.getAgentId();
        String deviceId = sessionListItem.getDeviceId();
        String title = sessionListItem.getTitle();
        String agentDisplayName = sessionListItem.getAgentDisplayName();
        SessionAgentCategory agentCategory = sessionListItem.getAgentCategory();
        SessionAgentCategory sessionAgentCategory = SessionAgentCategory.EXTERNAL;
        if (agentCategory != sessionAgentCategory) {
            agentDisplayName = null;
        }
        if (agentDisplayName == null) {
            agentDisplayName = "";
        }
        String str = agentDisplayName;
        if (sessionListItem.getAgentCategory() == sessionAgentCategory) {
            z10 = true;
            z11 = true;
        } else {
            z10 = false;
            z11 = true;
        }
        return new SidebarSession(sessionId, agentId, deviceId, title, str, z10, sessionListItem.getCreatedAt(), sessionListItem.getUpdatedAt(), sessionListItem.getIsRead(), sessionListItem.getSendFailed(), r(sessionListItem.getSessionKind()), A6.c.INSTANCE.e(sessionActivityState, sessionListItem.getAuthorizationState() != SessionAuthorizationState.NONE, sessionActivityState2, sessionListItem.getIsRead()));
    }
}
