package stepai.aios.guiagent.llm.cell;

import B7.a;
import D7.K;
import D7.v;
import F7.b;
import H4.o;
import N9.j;
import W7.c;
import Y7.f;
import android.util.Size;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import g1.AbstractC1451a;
import j9.l;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;
import stepai.aios.guiagent.config.Action;
import stepai.aios.guiagent.config.ActionType;
import stepai.aios.guiagent.config.LlmConfig;
import stepai.aios.guiagent.llm.Message;
import stepai.aios.guiagent.llm.MessageRole;
import stepai.aios.guiagent.llm.cell.config.ModelCatalog;
import stepai.aios.guiagent.llm.config.LlmMessageBuilder;
import stepai.aios.guiagent.llm.parser.GUIAgentMode;
import stepai.aios.guiagent.llm.parser.IModelCell;
import stepai.aios.guiagent.llm.parser.ModelParam;
import stepai.aios.guiagent.llm.parser.ModelRequestPayload;
import stepai.android.mindx.client.config.ConfigsKt;
import za.e;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 L2\u00020\u0001:\u0001LB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0010J\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0019J\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0019J\u0019\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010#J+\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010)J'\u0010,\u001a\u00020\u0006*\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020\nH\u0002¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H\u0002¢\u0006\u0004\b3\u0010\u0003J\u000f\u00104\u001a\u000202H\u0002¢\u0006\u0004\b4\u0010\u0003R\u001a\u00105\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010)R\u001a\u00108\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b8\u00106\u001a\u0004\b9\u0010)R\u001c\u0010:\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u0010)R\u001a\u0010<\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b<\u00106\u001a\u0004\b=\u0010)R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\n0A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010D\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u00106R\u0014\u0010F\u001a\u00020E8\u0002X\u0082D¢\u0006\u0006\n\u0004\bF\u0010GR\u001c\u0010K\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010J¨\u0006M"}, d2 = {"Lstepai/aios/guiagent/llm/cell/DoubaoTarsModelCell;", "Lstepai/aios/guiagent/llm/parser/IModelCell;", AppAgent.CONSTRUCT, "()V", "Lza/e;", "session", "", "imageBase64", "imageUrl", "", "Lstepai/aios/guiagent/llm/Message;", "generateRequestMessage", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "response", "Lstepai/aios/guiagent/config/Action;", "parseActionResponse", "(Ljava/lang/String;Lza/e;)Lstepai/aios/guiagent/config/Action;", "Lstepai/aios/guiagent/llm/parser/ModelParam;", "getModelParam", "()Lstepai/aios/guiagent/llm/parser/ModelParam;", "Landroid/util/Size;", "getCompressBitmapSize", "()Landroid/util/Size;", "task", "buildSystemPrompt", "(Ljava/lang/String;)Ljava/lang/String;", "parseAction", "reason", "buildWaitAction", "(Ljava/lang/String;)Lstepai/aios/guiagent/config/Action;", "extractActionLine", "extractThought", "actionName", "Lstepai/aios/guiagent/config/ActionType;", "parseActionType", "(Ljava/lang/String;)Lstepai/aios/guiagent/config/ActionType;", "paramsStr", "", "parseParameters", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "generateActionId", "()Ljava/lang/String;", "prefix", "delimiter", "prependIfNotEmpty", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "message", "", "hasImage", "(Lstepai/aios/guiagent/llm/Message;)Z", "LC7/r;", "clearCache", "cleanupHistory", "type", "Ljava/lang/String;", "getType", HintConstants.AUTOFILL_HINT_NAME, "getName", "desc", "getDesc", "systemPrompt", "getSystemPrompt", "", "messageHistory", "Ljava/util/List;", "", "messagesWithImage", "Ljava/util/Set;", "currentSessionId", "", "maxRoundHistory", "I", "Lstepai/aios/guiagent/llm/parser/GUIAgentMode;", "getSupportedMode", "()Ljava/util/List;", "supportedMode", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DoubaoTarsModelCell implements IModelCell {
    private static final int SCROLL_MAX_OFFSET = 950;
    private static final int SCROLL_MIN_OFFSET = 50;
    private static final int SCROLL_OFFSET = 200;
    private String currentSessionId;
    private final String type = ModelCatalog.MODEL_CELL_TYPE_DOUBAO_TARS;
    private final String name = "DoubaoTars";
    private final String desc = "用于豆包tars模型";
    private final String systemPrompt = "You are a GUI agent. You are given a task and your action history, with screenshots. You need to perform the next action to complete the task.\n## Output Format\n```\nThought: ...\nAction: ...\n```\n\n## Action Space\nclick(point='<point>x1 y1</point>')\nlong_press(point='<point>x1 y1</point>')\ntype(content='') #If you want to submit your input, use \"\\\\n\" at the end of `content`.\nscroll(point='<point>x1 y1</point>', direction='down or up or right or left')\nopen_app(app_name=\\'\\')\ndrag(start_point='<point>x1 y1</point>', end_point='<point>x2 y2</point>')\npress_home()\npress_back()\nfinished(content='xxx') # Use escape characters \\\\', \\\\\", and \\\\n in content part to ensure we can parse the content in normal python string format.\n\n## Note\n- Use Chinese in `Thought` part.\n- Write a small plan and finally summarize your next action (with its target element) in one sentence in `Thought` part.\n\n## User Instruction\n{task}\n## Hard Constraints\n- `Action` MUST be syntactically valid exactly as defined above.\n- `Action` MUST be executable — no hypothetical actions.\n- `Thought` MUST use {language}.\n- In `Thought`, write:\n  1) A short plan\n  2) The reasoning for choosing the next action\n  3) A final sentence summarizing the one action you will take next.\n- `Thought` MUST NOT contain coordinates or action syntax.\n- Only the `Action` field may include coordinates or action syntax.";
    private final List<Message> messageHistory = new ArrayList();
    private final Set<Message> messagesWithImage = new LinkedHashSet();
    private final int maxRoundHistory = 5;

    private final String buildSystemPrompt(String task) {
        return t.c0(getSystemPrompt(), "{task}", task);
    }

    private final Action buildWaitAction(String reason) {
        j.G("解析Action为空，返回wait兜底，原因: " + reason, ConfigsKt.TAG);
        return new Action(generateActionId(), ActionType.WAIT, a.x(AgentBusWakeContract.EXTRA_SOURCE, "llm"), null, 0L, null, 56, null);
    }

    private final void cleanupHistory() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : this.messageHistory) {
            int i6 = i + 1;
            if (i < 0) {
                o.X();
                throw null;
            }
            Message message = (Message) obj;
            if (message.getRole() == MessageRole.USER && hasImage(message)) {
                arrayList.add(Integer.valueOf(i));
            }
            i = i6;
        }
        if (arrayList.size() > this.maxRoundHistory) {
            int size = arrayList.size() - this.maxRoundHistory;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i10 = 0; i10 < size; i10++) {
                int iIntValue = ((Number) arrayList.get(i10)).intValue();
                linkedHashSet.add(Integer.valueOf(iIntValue));
                int i11 = iIntValue + 1;
                if (i11 < this.messageHistory.size() && this.messageHistory.get(i11).getRole() == MessageRole.ASSISTANT) {
                    linkedHashSet.add(Integer.valueOf(i11));
                }
            }
            Iterator it = v.Z0(linkedHashSet, b.c).iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Number) it.next()).intValue();
                Message message2 = this.messageHistory.get(iIntValue2);
                this.messageHistory.remove(iIntValue2);
                this.messagesWithImage.remove(message2);
            }
        }
    }

    private final void clearCache() {
        this.messageHistory.clear();
        this.messagesWithImage.clear();
    }

    private final String extractActionLine(String response) {
        Iterator it = m.w0(response).iterator();
        while (it.hasNext()) {
            String string = m.R0((String) it.next()).toString();
            if (t.e0(string, "Action:", true)) {
                return m.R0(m.H0(string, "Action:", string)).toString();
            }
        }
        return null;
    }

    private final String extractThought(String response) {
        Iterator it = m.w0(response).iterator();
        while (it.hasNext()) {
            String string = m.R0((String) it.next()).toString();
            if (t.e0(string, "Thought:", true)) {
                return m.R0(m.H0(string, "Thought:", string)).toString();
            }
        }
        return null;
    }

    private final String generateActionId() {
        return "action_" + System.currentTimeMillis() + "_" + AbstractC1451a.R(c.f1492a, new f(0, 999, 1));
    }

    private final boolean hasImage(Message message) {
        return this.messagesWithImage.contains(message);
    }

    private final Action parseAction(String response, e session) {
        try {
            String strExtractActionLine = extractActionLine(response);
            if (strExtractActionLine == null) {
                return buildWaitAction("extractActionLine返回null, response=" + response);
            }
            l lVarB = new Regex("(\\w+)\\((.*?)\\)").b(strExtractActionLine);
            if (lVarB == null) {
                return buildWaitAction("actionMatch正则匹配失败, actionLine=".concat(strExtractActionLine));
            }
            String str = (String) ((K) lVarB.a()).get(1);
            String str2 = (String) ((K) lVarB.a()).get(2);
            ActionType actionType = parseActionType(str);
            if (actionType == null) {
                return buildWaitAction("未知actionType, actionName=" + str);
            }
            LinkedHashMap linkedHashMapA0 = kotlin.collections.a.a0(parseParameters(str2, str));
            linkedHashMapA0.put(AgentBusWakeContract.EXTRA_SOURCE, "llm");
            return new Action(generateActionId(), actionType, linkedHashMapA0, null, 0L, null, 56, null);
        } catch (Exception e) {
            j.G(androidx.appfunctions.metadata.a.m("解析Action失败: ", e.getMessage(), "，response：", response, ","), ConfigsKt.TAG);
            return null;
        }
    }

    private final ActionType parseActionType(String actionName) {
        String lowerCase = actionName.toLowerCase(Locale.ROOT);
        k.e(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -907680051:
                if (lowerCase.equals("scroll")) {
                    return ActionType.SWIPE;
                }
                return null;
            case -673660814:
                if (lowerCase.equals("finished")) {
                    return ActionType.COMPLETE;
                }
                return null;
            case -504325460:
                if (lowerCase.equals("open_app")) {
                    return ActionType.AWAKE;
                }
                return null;
            case -326696768:
                if (lowerCase.equals("long_press")) {
                    return ActionType.CLICK;
                }
                return null;
            case 3091764:
                if (lowerCase.equals("drag")) {
                    return ActionType.SWIPE;
                }
                return null;
            case 3575610:
                if (lowerCase.equals("type")) {
                    return ActionType.TYPE;
                }
                return null;
            case 3641717:
                if (lowerCase.equals("wait")) {
                    return ActionType.WAIT;
                }
                return null;
            case 94750088:
                if (lowerCase.equals(RequestInfo.FUNCTION_CLICK)) {
                    return ActionType.CLICK;
                }
                return null;
            case 1870941027:
                if (lowerCase.equals("press_back")) {
                    return ActionType.BACK;
                }
                return null;
            case 1871133531:
                if (lowerCase.equals("press_home")) {
                    return ActionType.HOME;
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.Map<java.lang.String, java.lang.String> parseParameters(java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 864
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.DoubaoTarsModelCell.parseParameters(java.lang.String, java.lang.String):java.util.Map");
    }

    private final String prependIfNotEmpty(String str, String str2, String str3) {
        return (str2 == null || m.s0(str2)) ? str : a.B(str2, str3, str);
    }

    public static /* synthetic */ String prependIfNotEmpty$default(DoubaoTarsModelCell doubaoTarsModelCell, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = "";
        }
        return doubaoTarsModelCell.prependIfNotEmpty(str, str2, str3);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ String effectiveSystemPrompt() {
        return super.effectiveSystemPrompt();
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ Object generateRequestMessage(e eVar, String str, LlmConfig llmConfig, String str2, String str3, H7.c<? super List<Message>> cVar) {
        return super.generateRequestMessage(eVar, str, llmConfig, str2, str3, cVar);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ Object generateRequestPayload(e eVar, String str, LlmConfig llmConfig, String str2, String str3, H7.c<? super ModelRequestPayload> cVar) {
        return super.generateRequestPayload(eVar, str, llmConfig, str2, str3, cVar);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public Size getCompressBitmapSize() {
        return new Size(448, 1080);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getDesc() {
        return this.desc;
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ Map<String, Object> getLastRequestMetadata() {
        return super.getLastRequestMetadata();
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public ModelParam getModelParam() {
        return new ModelParam(0.0f, 0.7f, 4096, null, 8, null);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getName() {
        return this.name;
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public List<GUIAgentMode> getSupportedMode() {
        return o.M(GUIAgentMode.NO_PATH);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getSystemPrompt() {
        return this.systemPrompt;
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getType() {
        return this.type;
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ void handleInquiry(e eVar, String str, String str2) {
        super.handleInquiry(eVar, str, str2);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ void injectExperienceAction(String str, String str2, List<Integer> list, String str3, String str4) {
        super.injectExperienceAction(str, str2, list, str3, str4);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public Action parseActionResponse(String response, e session) {
        Object objPrevious;
        k.f(response, "response");
        if (!m.s0(response)) {
            this.messageHistory.add(new LlmMessageBuilder().role(MessageRole.ASSISTANT).text(response).build());
            cleanupHistory();
        }
        List listW0 = m.w0(response);
        ListIterator listIterator = listW0.listIterator(listW0.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            if (!m.s0((String) objPrevious)) {
                break;
            }
        }
        String str = (String) objPrevious;
        if (str == null) {
            str = "";
        }
        return parseAction(str, session);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ void removeSession(String str) {
        super.removeSession(str);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public List<Message> generateRequestMessage(e session, String imageBase64, String imageUrl) throws Exception {
        if (session == null) {
            throw new Exception("[generateRequestMessage] session is null");
        }
        String str = session.f7004a;
        String str2 = this.currentSessionId;
        if (str2 != null && !k.b(str2, str)) {
            clearCache();
        }
        this.currentSessionId = str;
        ArrayList arrayList = new ArrayList();
        buildSystemPrompt(session.b);
        arrayList.add(new LlmMessageBuilder().role(MessageRole.USER).text(effectiveSystemPrompt()).build());
        List<Message> list = this.messageHistory;
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        for (Object obj : list) {
            int i6 = i + 1;
            if (i < 0) {
                o.X();
                throw null;
            }
            Message message = (Message) obj;
            if (message.getRole() == MessageRole.USER && hasImage(message)) {
                arrayList2.add(obj);
            }
            i = i6;
        }
        List<Message> listB1 = v.b1(this.maxRoundHistory - 1, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Message message2 : listB1) {
            int iIndexOf = this.messageHistory.indexOf(message2);
            arrayList3.add(message2);
            int i10 = iIndexOf + 1;
            if (i10 < this.messageHistory.size() && this.messageHistory.get(i10).getRole() == MessageRole.ASSISTANT) {
                arrayList3.add(this.messageHistory.get(i10));
            }
        }
        arrayList.addAll(arrayList3);
        if (imageBase64 != null && !m.s0(imageBase64)) {
            Message messageBuild = LlmMessageBuilder.imageBase64$default(new LlmMessageBuilder().role(MessageRole.USER), imageBase64, null, 2, null).build();
            arrayList.add(messageBuild);
            this.messageHistory.add(messageBuild);
            this.messagesWithImage.add(messageBuild);
        }
        return arrayList;
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ ModelRequestPayload generateRequestPayload(e eVar, String str, String str2) {
        return super.generateRequestPayload(eVar, str, str2);
    }
}
