package stepai.aios.guiagent.llm.cell;

import B7.a;
import D7.K;
import D7.v;
import H4.o;
import N9.j;
import W7.c;
import Y7.f;
import android.util.Size;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import g1.AbstractC1451a;
import i9.h;
import j9.InterfaceC1616j;
import j9.l;
import j9.m;
import j9.n;
import j9.t;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
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
import stepai.aios.guiagent.llm.parser.ParseResult;
import stepai.aios.guiagent.llm.parser.ToolCall;
import stepai.android.mindx.client.config.ConfigsKt;
import ua.C2052a;
import za.b;
import za.e;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ3\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010 \u001a\u00020\u001f2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b \u0010!J#\u0010\"\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\"\u0010\u0018J\u0019\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010#\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010&J\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00062\u0006\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010*J#\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040,2\u0006\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010.J\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b/\u0010*J\u0017\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0016H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0016H\u0002¢\u0006\u0004\b5\u00104J\u000f\u00106\u001a\u00020\u0004H\u0002¢\u0006\u0004\b6\u00107J'\u0010:\u001a\u00020\u0004*\u00020\u00042\b\u00108\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u00109\u001a\u00020\u0004H\u0002¢\u0006\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u00107R\u001a\u0010?\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b?\u0010=\u001a\u0004\b@\u00107R\u001c\u0010A\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\bA\u0010=\u001a\u0004\bB\u00107R\u001a\u0010C\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\bC\u0010=\u001a\u0004\bD\u00107R\u001c\u0010H\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006I"}, d2 = {"Lstepai/aios/guiagent/llm/cell/StepPlanTreeModelCell;", "Lstepai/aios/guiagent/llm/parser/IModelCell;", AppAgent.CONSTRUCT, "()V", "", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "", "Lza/b;", "actionHistoryList", "buildActionPrompt", "(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;", "Lza/e;", "session", "imageBase64", "imageUrl", "Lstepai/aios/guiagent/llm/Message;", "generateRequestMessage", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Landroid/util/Size;", "getCompressBitmapSize", "()Landroid/util/Size;", "response", "Lstepai/aios/guiagent/config/Action;", "parseActionResponse", "(Ljava/lang/String;Lza/e;)Lstepai/aios/guiagent/config/Action;", "input", "Lstepai/aios/guiagent/llm/parser/ParseResult;", "parseToolCallFormat", "(Ljava/lang/String;)Lstepai/aios/guiagent/llm/parser/ParseResult;", "question", "answer", "LC7/r;", "handleInquiry", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)V", "parseNewFormat", "typeStr", "Lstepai/aios/guiagent/config/ActionType;", "parseActionType", "(Ljava/lang/String;)Lstepai/aios/guiagent/config/ActionType;", "toolCallsSection", "Lstepai/aios/guiagent/llm/parser/ToolCall;", "parseToolCalls", "(Ljava/lang/String;)Ljava/util/List;", "argsString", "", "parseArguments", "(Ljava/lang/String;)Ljava/util/Map;", "splitArguments", "value", "removeQuotes", "(Ljava/lang/String;)Ljava/lang/String;", "processAwakeAction", "(Lstepai/aios/guiagent/config/Action;)Lstepai/aios/guiagent/config/Action;", "ensureInquiryMessage", "generateActionId", "()Ljava/lang/String;", "prefix", "delimiter", "prependIfNotEmpty", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "type", "Ljava/lang/String;", "getType", HintConstants.AUTOFILL_HINT_NAME, "getName", "desc", "getDesc", "systemPrompt", "getSystemPrompt", "Lstepai/aios/guiagent/llm/parser/GUIAgentMode;", "getSupportedMode", "()Ljava/util/List;", "supportedMode", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepPlanTreeModelCell implements IModelCell {
    private final String type = ModelCatalog.MODEL_CELL_TYPE_STEP_PLAN_TREE;
    private final String name = "StepPlanTree";
    private final String desc = "用于阶跃规划树模型,在会话中匹配规划树模式!!";
    private final String systemPrompt = "你是一个熟悉手机操作的APP Agent，你要根据task_content和history_path_all，在APP页面中执行合适的动作。\n# 可用动作\n```\nclick(x,y)\ntype(text)\ninquiry(text)\nlong_click(x,y)\nopen_app(name)\nswipe(x1,y1,x2,y2)\ntask_completed()\ntask_impossible()\nwait(duration)\nback()\npress_enter()\npress_home()```\n# 输出格式\n```\n动作说明<|call_start|><|toolcall_start|>TOOL1(arg1=val1,arg2=val2,...)<|toolcall_end|><|call_end|>\n```\n# 注意事项\n- 可以输出一个或多个动作\n- 使用标准的python函数调用格式输出操作名和参数\n- 使用中文输出操作说明";

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildActionPrompt$lambda$0(b item) {
        k.f(item, "item");
        return a.m("\"", item.f6999a, "\"");
    }

    private final Action ensureInquiryMessage(Action action) {
        Object obj = action.getParameters().get("message");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null || m.s0(str)) {
            Object obj2 = action.getParameters().get("text");
            String str2 = obj2 instanceof String ? (String) obj2 : null;
            if (str2 != null && !m.s0(str2)) {
                return Action.copy$default(action, null, null, kotlin.collections.a.T(action.getParameters(), kotlin.collections.a.Q(new Pair("message", str2))), null, 0L, null, 59, null);
            }
        }
        return action;
    }

    private final String generateActionId() {
        return "action_" + System.currentTimeMillis() + "_" + AbstractC1451a.R(c.f1492a, new f(0, 999, 1));
    }

    private final ActionType parseActionType(String typeStr) {
        String lowerCase = typeStr.toLowerCase(Locale.ROOT);
        k.e(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -2127196196:
                if (lowerCase.equals("press_enter")) {
                    return ActionType.ENTER;
                }
                return null;
            case -1138047983:
                if (lowerCase.equals("task_completed")) {
                    return ActionType.COMPLETE;
                }
                return null;
            case -504325460:
                if (lowerCase.equals("open_app")) {
                    return ActionType.AWAKE;
                }
                return null;
            case -338877947:
                if (lowerCase.equals("long_click")) {
                    return ActionType.CLICK;
                }
                return null;
            case 3015911:
                if (lowerCase.equals("back")) {
                    return ActionType.BACK;
                }
                return null;
            case 3575610:
                if (lowerCase.equals("type")) {
                    return ActionType.TYPE;
                }
                return null;
            case 94750088:
                if (lowerCase.equals(RequestInfo.FUNCTION_CLICK)) {
                    return ActionType.CLICK;
                }
                return null;
            case 109854522:
                if (lowerCase.equals(RequestInfo.FUNCTION_SWIPE)) {
                    return ActionType.SWIPE;
                }
                return null;
            case 1775041935:
                if (lowerCase.equals("task_impossible")) {
                    return ActionType.ABORT;
                }
                return null;
            case 1871133531:
                if (lowerCase.equals("press_home")) {
                    return ActionType.HOME;
                }
                return null;
            case 1955760583:
                if (lowerCase.equals("inquiry")) {
                    return ActionType.INQUIRY;
                }
                return null;
            default:
                return null;
        }
    }

    private final Map<String, String> parseArguments(String argsString) {
        if (m.s0(argsString)) {
            return kotlin.collections.a.M();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : splitArguments(argsString)) {
            int iP0 = m.p0(str, '=', 0, 6);
            if (iP0 > 0) {
                String strSubstring = str.substring(0, iP0);
                k.e(strSubstring, "substring(...)");
                String string = m.R0(strSubstring).toString();
                String strSubstring2 = str.substring(iP0 + 1);
                k.e(strSubstring2, "substring(...)");
                linkedHashMap.put(string, removeQuotes(m.R0(strSubstring2).toString()));
            }
        }
        return linkedHashMap;
    }

    private final Action parseNewFormat(String response, e session) {
        String str;
        j.H("parse:response:" + response, ConfigsKt.TAG);
        ParseResult toolCallFormat = parseToolCallFormat(response);
        String prefix = toolCallFormat.getPrefix();
        ToolCall toolCall = (ToolCall) v.A0(toolCallFormat.getToolCalls());
        String toolName = toolCall.getToolName();
        Map<String, Object> arguments = toolCall.getArguments();
        j.H("parse:toolName:" + toolName + ",arguments:" + arguments, ConfigsKt.TAG);
        ActionType actionType = !m.s0(toolName) ? parseActionType(toolName) : null;
        if (actionType == null) {
            return null;
        }
        j.H("解析参数成功: " + arguments, ConfigsKt.TAG);
        String strPrependIfNotEmpty = prependIfNotEmpty(prefix, null, "-");
        if (session != null && (str = session.f7004a) != null) {
            stepai.aios.guiagent.runtime.a aVar = C2052a.c;
            if (aVar == null) {
                throw new IllegalStateException("GuiAgentManager is not initialized");
            }
            aVar.f(str, new b(strPrependIfNotEmpty));
        }
        LinkedHashMap linkedHashMapA0 = kotlin.collections.a.a0(arguments);
        linkedHashMapA0.put(AgentBusWakeContract.EXTRA_SOURCE, "llm");
        Action action = new Action(generateActionId(), actionType, linkedHashMapA0, null, 0L, null, 56, null);
        if (action.getType() == ActionType.AWAKE) {
            action = processAwakeAction(action);
        }
        return action.getType() == ActionType.INQUIRY ? ensureInquiryMessage(action) : action;
    }

    private final List<ToolCall> parseToolCalls(String toolCallsSection) {
        ArrayList arrayList = new ArrayList();
        h hVar = new h(Regex.c(new Regex("<\\|toolcall_start\\|>([^(]+)\\(([^)]*)\\)<\\|toolcall_end\\|>"), toolCallsSection));
        while (hVar.hasNext()) {
            l lVar = (l) ((InterfaceC1616j) hVar.next());
            arrayList.add(new ToolCall((String) ((K) lVar.a()).get(1), parseArguments((String) ((K) lVar.a()).get(2))));
        }
        return arrayList;
    }

    private final String prependIfNotEmpty(String str, String str2, String str3) {
        return (str2 == null || m.s0(str2)) ? str : a.B(str2, str3, str);
    }

    public static /* synthetic */ String prependIfNotEmpty$default(StepPlanTreeModelCell stepPlanTreeModelCell, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = "";
        }
        return stepPlanTreeModelCell.prependIfNotEmpty(str, str2, str3);
    }

    private final Action processAwakeAction(Action action) {
        Object obj = action.getParameters().get("app");
        String str = obj instanceof String ? (String) obj : null;
        return (str == null || m.s0(str)) ? action : Action.copy$default(action, null, null, kotlin.collections.a.T(action.getParameters(), kotlin.collections.a.Q(new Pair("app", str))), null, 0L, null, 59, null);
    }

    private final String removeQuotes(String value) {
        String string = m.R0(value).toString();
        if (t.e0(string, "\"", false) && t.W(string, "\"", false) && string.length() >= 2) {
            String strSubstring = string.substring(1, string.length() - 1);
            k.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        if (!t.e0(string, "'", false) || !t.W(string, "'", false) || string.length() < 2) {
            return string;
        }
        String strSubstring2 = string.substring(1, string.length() - 1);
        k.e(strSubstring2, "substring(...)");
        return strSubstring2;
    }

    private final List<String> splitArguments(String argsString) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        boolean z10 = false;
        Character chValueOf = null;
        for (int i = 0; i < argsString.length(); i++) {
            char cCharAt = argsString.charAt(i);
            if ((cCharAt == '\"' || cCharAt == '\'') && !z10) {
                chValueOf = Character.valueOf(cCharAt);
                sb.append(cCharAt);
                z10 = true;
            } else if (chValueOf != null && cCharAt == chValueOf.charValue() && z10) {
                sb.append(cCharAt);
                z10 = false;
                chValueOf = null;
            } else if (cCharAt != ',' || z10) {
                sb.append(cCharAt);
            } else {
                String string = sb.toString();
                k.e(string, "toString(...)");
                arrayList.add(m.R0(string).toString());
                sb = new StringBuilder();
            }
        }
        if (sb.length() > 0) {
            String string2 = sb.toString();
            k.e(string2, "toString(...)");
            arrayList.add(m.R0(string2).toString());
        }
        return arrayList;
    }

    public final String buildActionPrompt(String action, List<b> actionHistoryList) {
        k.f(action, "action");
        k.f(actionHistoryList, "actionHistoryList");
        return n.R("\n            {\"task_content\": \"子任务：" + action + "\", \"screen_path2\": \"APP页面\", \"history_path_all\": [ " + v.I0(actionHistoryList, ",", null, null, new m5.a(21), 30) + "], \"app_name\": \"meituan\"}\n        }]}\n       ");
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
    public /* bridge */ ModelParam getModelParam() {
        return super.getModelParam();
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getName() {
        return this.name;
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public List<GUIAgentMode> getSupportedMode() {
        return o.M(GUIAgentMode.PLANNING_TREE);
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
    public void handleInquiry(e session, String question, String answer) {
        if (session != null) {
            stepai.aios.guiagent.runtime.a aVar = C2052a.c;
            if (aVar == null) {
                throw new IllegalStateException("GuiAgentManager is not initialized");
            }
            aVar.g(session.f7004a, question, answer);
        }
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ void injectExperienceAction(String str, String str2, List<Integer> list, String str3, String str4) {
        super.injectExperienceAction(str, str2, list, str3, str4);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public Action parseActionResponse(String response, e session) {
        Object objPrevious;
        k.f(response, "response");
        try {
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
            j.H("开始解析LLM响应: " + m.N0(200, str) + "...", ConfigsKt.TAG);
            Action newFormat = parseNewFormat(str, session);
            if (newFormat == null) {
                j.J("所有解析方法都失败", ConfigsKt.TAG);
                return null;
            }
            j.H("解析成功: " + newFormat.getType(), ConfigsKt.TAG);
            return newFormat;
        } catch (Exception e) {
            j.G("解析动作响应失败: " + e.getMessage(), ConfigsKt.TAG);
            e.printStackTrace();
            return null;
        }
    }

    public final ParseResult parseToolCallFormat(String input) {
        k.f(input, "input");
        int iQ0 = m.q0(input, "<|call_start|>", 0, false, 6);
        if (iQ0 == -1) {
            return new ParseResult(input, EmptyList.f4893a);
        }
        String strSubstring = input.substring(0, iQ0);
        k.e(strSubstring, "substring(...)");
        int i = iQ0 + 14;
        int iQ02 = m.q0(input, "<|call_end|>", 0, false, 6);
        if (iQ02 == -1) {
            throw new IllegalArgumentException("找不到匹配的 <|call_end|>");
        }
        String strSubstring2 = input.substring(i, iQ02);
        k.e(strSubstring2, "substring(...)");
        return new ParseResult(strSubstring, parseToolCalls(strSubstring2));
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
        String strBuildActionPrompt = buildActionPrompt(session.b, v.f1(session.f7005j));
        Message messageBuild = new LlmMessageBuilder().role(MessageRole.SYSTEM).text(effectiveSystemPrompt()).build();
        LlmMessageBuilder llmMessageBuilder = new LlmMessageBuilder();
        llmMessageBuilder.role(MessageRole.USER);
        if (imageBase64 != null && !m.s0(imageBase64)) {
            LlmMessageBuilder.imageBase64$default(llmMessageBuilder, imageBase64, null, 2, null);
        }
        llmMessageBuilder.text(strBuildActionPrompt);
        return o.k(messageBuild, llmMessageBuilder.build());
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ ModelRequestPayload generateRequestPayload(e eVar, String str, String str2) {
        return super.generateRequestPayload(eVar, str, str2);
    }
}
