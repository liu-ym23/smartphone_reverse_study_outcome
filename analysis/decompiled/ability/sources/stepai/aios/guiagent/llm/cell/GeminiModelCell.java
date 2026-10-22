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

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u001a\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ3\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u0015J\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00062\u0006\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\"J#\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040$2\u0006\u0010#\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010#\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010\"J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b-\u0010,J\u000f\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010/J'\u00102\u001a\u00020\u0004*\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u00101\u001a\u00020\u0004H\u0002¢\u0006\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010/R\u001a\u00107\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b7\u00105\u001a\u0004\b8\u0010/R\u001a\u00109\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b9\u00105\u001a\u0004\b:\u0010/R\u001c\u0010;\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b;\u00105\u001a\u0004\b<\u0010/¨\u0006>"}, d2 = {"Lstepai/aios/guiagent/llm/cell/GeminiModelCell;", "Lstepai/aios/guiagent/llm/parser/IModelCell;", AppAgent.CONSTRUCT, "()V", "", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "", "Lza/b;", "actionHistoryList", "buildActionPrompt", "(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;", "Lza/e;", "session", "imageBase64", "imageUrl", "Lstepai/aios/guiagent/llm/Message;", "generateRequestMessage", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "response", "Lstepai/aios/guiagent/config/Action;", "parseActionResponse", "(Ljava/lang/String;Lza/e;)Lstepai/aios/guiagent/config/Action;", "input", "Lstepai/aios/guiagent/llm/parser/ParseResult;", "parseToolCallFormat", "(Ljava/lang/String;)Lstepai/aios/guiagent/llm/parser/ParseResult;", "parseNewFormat", "typeStr", "Lstepai/aios/guiagent/config/ActionType;", "parseActionType", "(Ljava/lang/String;)Lstepai/aios/guiagent/config/ActionType;", "toolCallsSection", "Lstepai/aios/guiagent/llm/parser/ToolCall;", "parseToolCalls", "(Ljava/lang/String;)Ljava/util/List;", "argsString", "", "parseArguments", "(Ljava/lang/String;)Ljava/util/Map;", "splitArguments", "value", "removeQuotes", "(Ljava/lang/String;)Ljava/lang/String;", "processAwakeAction", "(Lstepai/aios/guiagent/config/Action;)Lstepai/aios/guiagent/config/Action;", "ensureInquiryMessage", "generateActionId", "()Ljava/lang/String;", "prefix", "delimiter", "prependIfNotEmpty", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "systemPrompt", "Ljava/lang/String;", "getSystemPrompt", "type", "getType", HintConstants.AUTOFILL_HINT_NAME, "getName", "desc", "getDesc", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GeminiModelCell implements IModelCell {
    private static final String TOOL_DESCRIPTION = "参数格式：坐标类参数（x/y/x1/y1/x2/y2）必须用键=值形式书写，参数间用英文逗号分隔，无多余空格（如click(x=500,y=600)正确，click(x= 500 , y=600)错误）。\n参数类型：\n坐标 / 时长类参数（x/y/duration 等）：整数或数值类型，无单位、无引号（如wait(duration=3)正确，wait(duration=\"3秒\")错误）。\n字符串类参数（text/app_name 等）：必须用英文双引号包裹（如open_app(app_name=\"抖音\")正确，open_app(app_name=抖音)错误）。\n相对坐标规则：所有 x/y 相关参数取值范围必须为 0-1000（屏幕左上角为 x=0,y=0，右下角为 x=1000,y=1000），无需换算实际分辨率。\n无参数命令：直接写命令名 + 空括号，不可省略括号（如task_completed()正确，task_completed错误）。\n\n1. click(x=,y=)\n功能：执行单击操作，触发目标相对坐标点交互。\n参数约束：\nx：整数，取值 0-1000，需用x=指定。\ny：整数，取值 0-1000，需用y=指定。\n正确示例：click(x=350,y=720)；错误示例：click(350,720)（无键值对）、click(x=1050,y=720)（x 超范围）。\n2. type(text=,x=,y=)\n功能：在指定位置激活输入框, 并录入文本。\n参数约束：\ntext：字符串，需用text=指定，且用英文双引号包裹，不包含换行符。\nx：整数，取值 0-1000，需用x=指定。\ny：整数，取值 0-1000，需用y=指定。\n正确示例：type(text=\"2024产品规划\",x=350,y=720)；错误示例：type(\"2024产品规划\")（无键值对）、type(text=2024产品规划)（无引号）、type(text=\"2024产品规划\")（无坐标）。\n3. inquiry(text=)\n功能：向用户询问信息，暂停流程等待反馈。\n参数约束：\ntext：字符串，需用text=指定，且用英文双引号包裹，内容需明确询问需求。\n正确示例：inquiry(text=\"请确认目标坐标是否为x=500,y=500\")；错误示例：inquiry(请确认坐标)（无键值对与引号）。\n4. long_click(x=,y=)\n功能：执行长按操作，触发目标相对坐标点交互（如弹出菜单）。\n参数约束：与click(x=,y=)完全一致，x/y均为 0-1000 范围内的整数，且用键值对书写。\n正确示例：long_click(x=800,y=200)；错误示例：long_click(x=800,y=\"200\")（y 为字符串）。\n5. swipe(x1=,y1=,x2=,y2=)\n功能：从起始相对坐标滑动至目标相对坐标，实现页面滚动或拖动。\n参数约束：\nx1/y1：滑动起点坐标，整数（0-1000），需用x1=/y1=指定。\nx2/y2：滑动终点坐标，整数（0-1000），需用x2=/y2=指定。\n正确示例：swipe(x1=500,y1=800,x2=500,y2=300)；错误示例：swipe(500,800,x2=500,y2=300)（起点无键值对）。\n6. task_completed()\n功能：标识任务成功完成，终止流程。\n参数约束：无参数，不可添加任何内容或省略括号。\n正确示例：task_completed()；错误示例：task_completed(完成)（多参数）、task_completed（无括号）。\n7. task_impossible()\n功能：标识任务因客观限制无法完成，终止流程。\n参数约束：无参数，不可添加任何内容或省略括号。\n正确示例：task_impossible()；错误示例：task_impossible(无权限)（多参数）、task_impossible（无括号）。\n8. wait(duration=)\n功能：暂停流程指定时长，等待页面加载、弹窗等事件。\n参数约束：\nduration：数值（整数 / 小数均可），需用duration=指定，单位为 “秒”，无单位与引号。\n正确示例：wait(duration=2)、wait(duration=1.8)；错误示例：wait(2)（无键值对）、wait(duration=\"2秒\")（带单位引号）。\n9. back()\n功能：执行返回操作，回到上一级界面。\n参数约束：无参数，不可添加任何内容或省略括号。\n正确示例：back()；错误示例：back(返回)（多参数）、back（无括号）。";
    private final String systemPrompt = a.m("你是一个熟悉手机操作的APP Agent，你要根据task_content和history_path_all，在APP页面中执行合适的动作。\n# 可用动作\n```\n", TOOL_DESCRIPTION, "```\n# 输出格式\n```\n动作说明<|call_start|><|toolcall_start|>TOOL1(arg1=val1,arg2=val2,...)<|toolcall_end|><|call_end|>\n```\n# 注意事项\n- 可以输出一个或多个动作\n- 使用标准的python函数调用格式输出操作名和参数\n- 使用中文输出操作说明");
    private final String type = ModelCatalog.MODEL_CELL_TYPE_GEMINI;
    private final String name = "gemini";
    private final String desc = "适配gemini";

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

    public static /* synthetic */ String prependIfNotEmpty$default(GeminiModelCell geminiModelCell, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = "";
        }
        return geminiModelCell.prependIfNotEmpty(str, str2, str3);
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
        return n.R("\n            {\"task_content\": \"子任务：" + action + "\", \"screen_path2\": \"APP页面\", \"history_path_all\": [ " + v.I0(actionHistoryList, ",", null, null, new m5.a(14), 30) + "], \"app_name\": \"meituan\"}\n        }]}\n       ");
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
    public /* bridge */ Size getCompressBitmapSize() {
        return super.getCompressBitmapSize();
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
    public /* bridge */ List<GUIAgentMode> getSupportedMode() {
        return super.getSupportedMode();
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
