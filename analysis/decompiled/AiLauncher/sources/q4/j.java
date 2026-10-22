package q4;

import La.H;
import Z8.A;
import Z8.B;
import Z8.C1173v;
import Z8.F;
import Z8.Q;
import Z8.Y;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import org.json.JSONObject;
import u4.AgentMessage;
import u4.m;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\"\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0010J#\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001f\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010\"\u001a\u0004\u0018\u00010\n2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b$\u0010%J)\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b&\u0010'J)\u0010)\u001a\u0004\u0018\u00010\u00012\b\u0010!\u001a\u0004\u0018\u00010\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u0002¢\u0006\u0004\b)\u0010*J\u001d\u0010+\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b+\u0010%J\u001b\u0010,\u001a\u0004\u0018\u00010\n2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b,\u0010#J1\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020-0\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020-0\u0004H\u0002¢\u0006\u0004\b.\u0010/J/\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b0\u0010/J\u001b\u00102\u001a\u0004\u0018\u00010\n2\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b2\u0010#J\u0019\u00105\u001a\u0004\u0018\u00010\n2\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b7\u0010\fJ#\u0010:\u001a\u0004\u0018\u00010\n2\b\u00108\u001a\u0004\u0018\u00010\n2\b\u00109\u001a\u0004\u0018\u000103¢\u0006\u0004\b:\u0010;J\u001f\u0010=\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010<¢\u0006\u0004\b=\u0010>J\u001f\u0010A\u001a\u0004\u0018\u00010\n2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010<¢\u0006\u0004\bA\u0010>J\u001d\u0010B\u001a\u00020\u001b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\bB\u0010CJ\u001d\u0010D\u001a\u00020\u001b2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010<¢\u0006\u0004\bD\u0010EJ\u0015\u0010F\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\bF\u0010\u0010J-\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050<2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bG\u0010HJ\u0015\u0010I\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\bI\u0010\u0010J+\u0010K\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050<2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n¢\u0006\u0004\bK\u0010LJ\u001d\u0010M\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\bM\u0010NJ#\u0010O\u001a\u00020\u001b2\u0006\u00104\u001a\u0002032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0004\bO\u0010PJ\u0015\u0010Q\u001a\u00020\u000e2\u0006\u00104\u001a\u000203¢\u0006\u0004\bQ\u0010RJ#\u0010S\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u0005¢\u0006\u0004\bS\u0010TJ%\u0010U\u001a\u00020\u000e2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\bU\u0010\u0013R\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\n0V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020\n0V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010X¨\u0006Z"}, d2 = {"Lq4/j;", "", "<init>", "()V", "", "Lcom/stepos/agentframework/chatcore/intent/e;", "tools", "o", "(Ljava/util/List;)Lcom/stepos/agentframework/chatcore/intent/e;", "host", "", "v", "(Lcom/stepos/agentframework/chatcore/intent/e;)Ljava/lang/String;", "tool", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/agentframework/chatcore/intent/e;)Z", "taskId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;Ljava/lang/String;)Z", "k", "raw", "key", "n", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "target", "incoming", "LY8/t;", "G", "(Lcom/stepos/agentframework/chatcore/intent/e;Lcom/stepos/agentframework/chatcore/intent/e;)V", "existing", "s", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "D", "(Ljava/lang/Object;)Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;)Ljava/util/List;", "p", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;", "ids", "t", "(Ljava/lang/Object;Ljava/util/List;)Ljava/lang/Object;", "c", "H", "Lq4/e;", "q", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "r", "item", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "data", "C", "(Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "result", "appUIData", "B", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)Ljava/lang/String;", "", "z", "(Ljava/lang/Iterable;)Ljava/lang/String;", "Lu4/a;", "parts", "y", "e", "(Ljava/util/List;)V", Const.INTENT_KEY_UMID, "(Ljava/lang/Iterable;)V", "m", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/Iterable;Ljava/lang/String;)Ljava/util/List;", "l", "failedToolCallId", "w", "(Ljava/lang/Iterable;Ljava/lang/String;Ljava/lang/String;)Z", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)Ljava/util/List;", "u", "(Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;Ljava/util/List;)V", "f", "(Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;Lcom/stepos/agentframework/chatcore/intent/e;)V", "x", "", "TERMINAL_TASK_PHASES", "Ljava/util/Set;", "TERMINAL_TASK_STATES", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class j {
    public static final j INSTANCE = new j();
    private static final Set<String> TERMINAL_TASK_PHASES = Y.j("finish", "success", "failed", "fail", "error", "cancel", "cancelled", "canceled");
    private static final Set<String> TERMINAL_TASK_STATES = Y.j("finish", "success", "completed", "failed", "error", "cancelled", "canceled");

    public static /* synthetic */ List F(j jVar, Iterable iterable, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        return jVar.E(iterable, str);
    }

    public final String A(AgentTool tool) {
        p.i(tool, "tool");
        return B(tool.getResult(), tool.getAppUIData());
    }

    public final String B(String result, AppUIData appUIData) {
        String strU = i.INSTANCE.u(result);
        return strU == null ? C(appUIData) : strU;
    }

    public final String C(AppUIData data) {
        if (p.d(data != null ? data.getAppUIName() : null, m.TaskMessage.APP_UI_NAME_TEXT_TO_IMAGE)) {
            return D(data.getStructuredContent());
        }
        return null;
    }

    public final String D(Object content) {
        String string;
        if (content instanceof String) {
            if (H.x0((String) content)) {
                content = null;
            }
            return (String) content;
        }
        if (content instanceof TaskResultFileAppUiPayload) {
            String taskId = ((TaskResultFileAppUiPayload) content).getTaskId();
            if (taskId == null || H.x0(taskId)) {
                return null;
            }
            return taskId;
        }
        if (content instanceof Map) {
            Map map = (Map) content;
            Object obj = map.get("task_id");
            if (obj == null) {
                obj = map.get("taskId");
            }
            if (obj != null && (string = obj.toString()) != null && !H.x0(string)) {
                return string;
            }
        }
        return null;
    }

    public final List<String> E(Iterable<AgentTool> tools, String taskId) {
        p.i(tools, "tools");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (AgentTool agentTool : tools) {
            j jVar = INSTANCE;
            if (jVar.m(agentTool)) {
                String strA = jVar.A(agentTool);
                if (taskId == null || strA == null || p.d(strA, taskId)) {
                    linkedHashSet.add(agentTool.getToolCallId());
                }
            }
        }
        return F.m1(linkedHashSet);
    }

    public final void G(AgentTool target, AgentTool incoming) {
        AppUIData appUIData;
        AppUIData appUIData2 = target.getAppUIData();
        if (appUIData2 == null || (appUIData = incoming.getAppUIData()) == null) {
            return;
        }
        appUIData2.setStructuredContent(s(appUIData2.getStructuredContent(), appUIData.getStructuredContent()));
    }

    public final String H(Object content) {
        String string;
        if (content instanceof TaskResultFileAppUiPayload) {
            String versionId = ((TaskResultFileAppUiPayload) content).getVersionId();
            if (versionId == null || H.x0(versionId)) {
                return null;
            }
            return versionId;
        }
        if (content instanceof Map) {
            Map map = (Map) content;
            Object obj = map.get("version_id");
            if (obj == null) {
                obj = map.get("versionId");
            }
            if (obj != null && (string = obj.toString()) != null && !H.x0(string)) {
                return string;
            }
        }
        return null;
    }

    public final List<String> a(AppUIData data) {
        return !p.d(data != null ? data.getAppUIName() : null, m.TaskMessage.APP_UI_NAME_TEXT_TO_IMAGE) ? C1173v.m() : b(data.getStructuredContent());
    }

    public final List<String> b(Object content) {
        String string;
        if (content instanceof TaskResultFileAppUiPayload) {
            List<String> listC = ((TaskResultFileAppUiPayload) content).c();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listC) {
                if (!H.x0((String) obj)) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        if (!(content instanceof Map)) {
            return C1173v.m();
        }
        Map map = (Map) content;
        Object obj2 = map.get(i.KEY_ACTIVE_TOOL_CALL_IDS);
        if (obj2 == null) {
            obj2 = map.get("activeToolCallIds");
        }
        ArrayList arrayList2 = null;
        List list = obj2 instanceof List ? (List) obj2 : null;
        if (list != null) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : list) {
                if (obj3 == null || (string = obj3.toString()) == null || H.x0(string)) {
                    string = null;
                }
                if (string != null) {
                    arrayList3.add(string);
                }
            }
            arrayList2 = arrayList3;
        }
        return arrayList2 == null ? C1173v.m() : arrayList2;
    }

    public final List<?> c(Object content) {
        if (content instanceof TaskResultFileAppUiPayload) {
            return ((TaskResultFileAppUiPayload) content).d();
        }
        if (!(content instanceof Map)) {
            return C1173v.m();
        }
        Object obj = ((Map) content).get("artifacts");
        List<?> list = obj instanceof List ? (List) obj : null;
        return list == null ? C1173v.m() : list;
    }

    public final void d(Iterable<AgentMessage> parts) {
        ArrayList arrayList;
        if (parts != null) {
            arrayList = new ArrayList();
            Iterator<AgentMessage> it = parts.iterator();
            while (it.hasNext()) {
                List<AgentTool> listG = it.next().g();
                if (listG == null) {
                    listG = C1173v.m();
                }
                A.E(arrayList, listG);
            }
        } else {
            arrayList = null;
        }
        e(arrayList);
    }

    public final void e(List<AgentTool> tools) {
        AgentTool agentToolO;
        String str;
        List<AgentTool> list = tools;
        if (list == null || list.isEmpty() || (agentToolO = o(tools)) == null) {
            return;
        }
        List<AgentTool> list2 = tools;
        String strZ = z(list2);
        String strC = C(agentToolO.getAppUIData());
        if (strZ != null) {
            str = strZ;
        } else if (strC == null) {
            return;
        } else {
            str = strC;
        }
        List<String> listM = i(tools, str) ? C1173v.m() : F(this, list2, null, 2, null);
        String strV = v(agentToolO);
        if (strZ != null && strC != null && !p.d(strZ, strC)) {
            agentToolO.x(i.f(i.INSTANCE, strV, strZ, null, 4, null));
        } else if (agentToolO.getAppUIData() == null) {
            agentToolO.x(i.f(i.INSTANCE, strV, str, null, 4, null));
        } else if (p.d(listM, a(agentToolO.getAppUIData()))) {
            return;
        }
        AppUIData appUIData = agentToolO.getAppUIData();
        if (appUIData != null) {
            INSTANCE.u(appUIData, listM);
        }
    }

    public final boolean f(AppUIData data) {
        p.i(data, "data");
        if (!p.d(data.getAppUIName(), m.TaskMessage.APP_UI_NAME_TEXT_TO_IMAGE) || a(data).isEmpty()) {
            return false;
        }
        u(data, C1173v.m());
        return true;
    }

    public final void g(List<AgentTool> existing, AgentTool incoming) {
        Object next;
        p.i(existing, "existing");
        p.i(incoming, "incoming");
        String strC = C(incoming.getAppUIData());
        if (strC == null) {
            return;
        }
        Iterator<T> it = existing.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            AgentTool agentTool = (AgentTool) next;
            if (!p.d(agentTool.getToolCallId(), incoming.getToolCallId()) && p.d(INSTANCE.C(agentTool.getAppUIData()), strC)) {
                break;
            }
        }
        AgentTool agentTool2 = (AgentTool) next;
        if (agentTool2 != null) {
            G(agentTool2, incoming);
            incoming.x(null);
        }
    }

    public final String h(Object item) {
        Object obj;
        if (item instanceof TaskResultFileAppUiItem) {
            return ((TaskResultFileAppUiItem) item).getFileId();
        }
        if (!(item instanceof Map) || (obj = ((Map) item).get("fileId")) == null) {
            return null;
        }
        return obj.toString();
    }

    public final boolean i(List<AgentTool> tools, String taskId) {
        List<AgentTool> list = tools;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (AgentTool agentTool : list) {
            j jVar = INSTANCE;
            if (jVar.j(agentTool) && jVar.k(agentTool) && p.d(jVar.A(agentTool), taskId)) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(AgentTool tool) {
        String name = tool.getName();
        if (H.x0(name)) {
            name = null;
        }
        if (name == null) {
            name = tool.getApiName();
        }
        return p.d(name, "task") || p.d(name, "task_create");
    }

    public final boolean k(AgentTool tool) {
        String lowerCase;
        String strN = n(tool.getParameter(), "phase");
        String lowerCase2 = null;
        if (strN != null) {
            lowerCase = strN.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (F.f0(TERMINAL_TASK_PHASES, lowerCase)) {
            return true;
        }
        String strN2 = n(tool.getResult(), VoiceWakeupReceiver.EXTRA_STATE);
        if (strN2 != null) {
            lowerCase2 = strN2.toLowerCase(Locale.ROOT);
            p.h(lowerCase2, "toLowerCase(...)");
        }
        return F.f0(TERMINAL_TASK_STATES, lowerCase2);
    }

    public final boolean l(AgentTool tool) {
        p.i(tool, "tool");
        String name = tool.getName();
        if (H.x0(name)) {
            name = null;
        }
        if (name == null) {
            name = tool.getApiName();
        }
        return i.INSTANCE.l(name, tool.getParameter());
    }

    public final boolean m(AgentTool tool) {
        p.i(tool, "tool");
        return (tool.getIsFinished() || H.x0(tool.getToolCallId()) || !l(tool)) ? false : true;
    }

    public final String n(String raw, String key) {
        Object objB;
        if (raw == null || H.x0(raw)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            String strOptString = new JSONObject(raw).optString(key);
            p.f(strOptString);
            if (H.x0(strOptString)) {
                strOptString = null;
            }
            objB = Result.b(strOptString);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (String) (Result.g(objB) ? null : objB);
    }

    public final AgentTool o(List<AgentTool> tools) {
        Object next;
        Object next2;
        ArrayList arrayList = new ArrayList();
        for (Object obj : tools) {
            AgentTool agentTool = (AgentTool) obj;
            if (INSTANCE.l(agentTool) && !H.x0(agentTool.getToolCallId())) {
                arrayList.add(obj);
            }
        }
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (m((AgentTool) next)) {
                break;
            }
        }
        AgentTool agentTool2 = (AgentTool) next;
        if (agentTool2 != null) {
            return agentTool2;
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            if (i.INSTANCE.u(((AgentTool) next2).getResult()) != null) {
                break;
            }
        }
        AgentTool agentTool3 = (AgentTool) next2;
        if (agentTool3 != null) {
            return agentTool3;
        }
        Iterator it3 = arrayList.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next3 = it3.next();
            if (((AgentTool) next3).getAppUIData() != null) {
                obj2 = next3;
                break;
            }
        }
        AgentTool agentTool4 = (AgentTool) obj2;
        return agentTool4 == null ? (AgentTool) F.q0(arrayList) : agentTool4;
    }

    public final List<String> p(Object existing, Object incoming) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(b(existing));
        linkedHashSet.addAll(b(incoming));
        return F.m1(linkedHashSet);
    }

    public final List<TaskResultFileAppUiItem> q(List<TaskResultFileAppUiItem> existing, List<TaskResultFileAppUiItem> incoming) {
        ArrayList arrayList = new ArrayList(existing);
        for (TaskResultFileAppUiItem taskResultFileAppUiItem : incoming) {
            Iterator it = arrayList.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i10 = -1;
                    break;
                }
                if (p.d(((TaskResultFileAppUiItem) it.next()).getFileId(), taskResultFileAppUiItem.getFileId())) {
                    break;
                }
                i10++;
            }
            if (i10 >= 0) {
                arrayList.set(i10, taskResultFileAppUiItem);
            } else {
                arrayList.add(taskResultFileAppUiItem);
            }
        }
        return arrayList;
    }

    public final List<Object> r(List<?> existing, List<?> incoming) {
        ArrayList arrayList = new ArrayList(existing);
        for (Object obj : incoming) {
            String strH = INSTANCE.h(obj);
            int i10 = -1;
            if (strH != null) {
                Iterator it = arrayList.iterator();
                int i11 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (p.d(INSTANCE.h(it.next()), strH)) {
                        i10 = i11;
                        break;
                    }
                    i11++;
                }
            }
            if (i10 >= 0) {
                arrayList.set(i10, obj);
            } else {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r12, java.lang.Object r13) {
        /*
            r11 = this;
            java.lang.String r0 = r11.H(r12)
            java.lang.String r1 = r11.H(r13)
            if (r0 == 0) goto L14
            if (r1 == 0) goto L14
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)
            if (r0 != 0) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L1c
            java.util.List r1 = r11.b(r13)
            goto L20
        L1c:
            java.util.List r1 = r11.p(r12, r13)
        L20:
            java.util.List r2 = r11.c(r12)
            java.util.List r3 = r11.c(r13)
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L2f
            goto L90
        L2f:
            boolean r4 = r2.isEmpty()
            if (r4 != 0) goto L8f
            if (r0 == 0) goto L38
            goto L8f
        L38:
            boolean r0 = r12 instanceof q4.TaskResultFileAppUiPayload
            if (r0 == 0) goto L66
            boolean r0 = r13 instanceof q4.TaskResultFileAppUiPayload
            if (r0 == 0) goto L66
            r4 = r12
            q4.f r4 = (q4.TaskResultFileAppUiPayload) r4
            q4.f r13 = (q4.TaskResultFileAppUiPayload) r13
            java.lang.String r12 = r13.getVersionId()
            if (r12 != 0) goto L4f
            java.lang.String r12 = r4.getVersionId()
        L4f:
            r6 = r12
            java.util.List r12 = r4.d()
            java.util.List r13 = r13.d()
            java.util.List r7 = r11.q(r12, r13)
            r9 = 9
            r10 = 0
            r5 = 0
            r8 = 0
            q4.f r12 = q4.TaskResultFileAppUiPayload.b(r4, r5, r6, r7, r8, r9, r10)
            goto L90
        L66:
            boolean r0 = r12 instanceof java.util.Map
            if (r0 == 0) goto L8f
            boolean r0 = r13 instanceof java.util.Map
            if (r0 == 0) goto L8f
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            java.util.Map r12 = (java.util.Map) r12
            r0.<init>(r12)
            java.util.Map r13 = (java.util.Map) r13
            java.lang.String r12 = "version_id"
            java.lang.Object r13 = r13.get(r12)
            if (r13 == 0) goto L82
            r0.put(r12, r13)
        L82:
            q4.j r12 = q4.j.INSTANCE
            java.util.List r12 = r12.r(r2, r3)
            java.lang.String r13 = "artifacts"
            r0.put(r13, r12)
            r12 = r0
            goto L90
        L8f:
            r12 = r13
        L90:
            java.lang.Object r11 = r11.t(r12, r1)
            if (r11 != 0) goto L97
            return r12
        L97:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.j.s(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final Object t(Object content, List<String> ids) {
        if (content instanceof TaskResultFileAppUiPayload) {
            return TaskResultFileAppUiPayload.b((TaskResultFileAppUiPayload) content, null, null, null, ids, 7, null);
        }
        if (!(content instanceof Map)) {
            if (ids.isEmpty()) {
                return content;
            }
            String strD = D(content);
            return strD == null ? Q.f(Y8.j.a(i.KEY_ACTIVE_TOOL_CALL_IDS, ids)) : kotlin.collections.a.m(Y8.j.a("task_id", strD), Y8.j.a(i.KEY_ACTIVE_TOOL_CALL_IDS, ids));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap((Map) content);
        if (!ids.isEmpty()) {
            linkedHashMap.put(i.KEY_ACTIVE_TOOL_CALL_IDS, ids);
            return linkedHashMap;
        }
        linkedHashMap.remove(i.KEY_ACTIVE_TOOL_CALL_IDS);
        linkedHashMap.remove("activeToolCallIds");
        return linkedHashMap;
    }

    public final void u(AppUIData data, List<String> ids) {
        Object objT;
        p.i(data, "data");
        p.i(ids, "ids");
        if (p.d(data.getAppUIName(), m.TaskMessage.APP_UI_NAME_TEXT_TO_IMAGE)) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : ids) {
                if (!H.x0((String) obj)) {
                    arrayList.add(obj);
                }
            }
            List<String> listG0 = F.g0(arrayList);
            if (p.d(listG0, a(data)) || (objT = t(data.getStructuredContent(), listG0)) == null) {
                return;
            }
            data.setStructuredContent(objT);
        }
    }

    public final String v(AgentTool host) {
        String result = host.getResult();
        if (i.INSTANCE.m(result)) {
            return null;
        }
        return result;
    }

    public final boolean w(Iterable<AgentTool> tools, String taskId, String failedToolCallId) {
        p.i(tools, "tools");
        p.i(taskId, "taskId");
        p.i(failedToolCallId, "failedToolCallId");
        if (H.x0(taskId)) {
            return false;
        }
        if (!E(tools, taskId).isEmpty()) {
            return true;
        }
        if ((tools instanceof Collection) && ((Collection) tools).isEmpty()) {
            return false;
        }
        for (AgentTool agentTool : tools) {
            if (!p.d(agentTool.getToolCallId(), failedToolCallId) && INSTANCE.l(agentTool) && p.d(i.INSTANCE.u(agentTool.getResult()), taskId)) {
                return true;
            }
        }
        return false;
    }

    public final boolean x(List<AgentTool> tools, String taskId) {
        p.i(taskId, "taskId");
        List<AgentTool> list = tools;
        boolean z10 = false;
        if (list != null && !list.isEmpty() && !H.x0(taskId)) {
            for (AgentTool agentTool : tools) {
                if (p.d(C(agentTool.getAppUIData()), taskId)) {
                    agentTool.x(null);
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public final String y(Iterable<AgentMessage> parts) {
        ArrayList arrayList;
        if (parts != null) {
            arrayList = new ArrayList();
            Iterator<AgentMessage> it = parts.iterator();
            while (it.hasNext()) {
                List<AgentTool> listG = it.next().g();
                if (listG == null) {
                    listG = C1173v.m();
                }
                A.E(arrayList, listG);
            }
        } else {
            arrayList = null;
        }
        return z(arrayList);
    }

    public final String z(Iterable<AgentTool> tools) {
        List listM1;
        String strA = null;
        if (tools != null && (listM1 = F.m1(tools)) != null) {
            String strC = null;
            for (AgentTool agentTool : B.U(listM1)) {
                if (l(agentTool)) {
                    String strU = i.INSTANCE.u(agentTool.getResult());
                    if (strU != null) {
                        return strU;
                    }
                    if (strC == null) {
                        strC = C(agentTool.getAppUIData());
                    }
                } else if (strA == null && j(agentTool) && !k(agentTool)) {
                    strA = A(agentTool);
                }
            }
            if (strA == null) {
                return strC;
            }
        }
        return strA;
    }
}
