package stepai.aios.guiagent.llm.cell;

import D7.v;
import H4.o;
import N9.j;
import android.util.Size;
import androidx.appfunctions.metadata.a;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONObject;
import stepai.aios.guiagent.config.ActionType;
import stepai.aios.guiagent.config.GuiAgentConfigKt;
import stepai.aios.guiagent.llm.Message;
import stepai.aios.guiagent.llm.MessageRole;
import stepai.aios.guiagent.llm.config.LlmMessageBuilder;
import stepai.aios.guiagent.llm.parser.AbsModelCell;
import stepai.aios.guiagent.llm.parser.GUIAgentMode;
import za.e;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b0\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0010J;\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J'\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010 \u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b0\t2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b \u0010!J\u0011\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b#\u0010$R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u0010/\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u001b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u0010'\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b2\u0010+\u001a\u0004\b3\u0010-R\u001c\u00104\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u0010+\u001a\u0004\b5\u0010-R\u001a\u00106\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u0010+\u001a\u0004\b7\u0010-¨\u00069"}, d2 = {"Lstepai/aios/guiagent/llm/cell/GLMModelCell;", "Lstepai/aios/guiagent/llm/parser/AbsModelCell;", AppAgent.CONSTRUCT, "()V", "", "actionType", "Lorg/json/JSONObject;", "actionDict", "cot", "Lkotlin/Pair;", "Lstepai/aios/guiagent/config/ActionType;", "", "convertGlmActionToInternal", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lkotlin/Pair;", "", "parseBox2d", "(Lorg/json/JSONObject;)Lkotlin/Pair;", "parseBox2dOrNull", "params", "step", "formatActionForHistory", "(Lstepai/aios/guiagent/config/ActionType;Ljava/util/Map;Ljava/lang/String;I)Ljava/lang/String;", "LC7/r;", "clearCache", "Lza/e;", "session", "imageBase64", "", "Lstepai/aios/guiagent/llm/Message;", "buildRequestMessage", "(Lza/e;Ljava/lang/String;)Ljava/util/List;", "response", "buildResponseAction", "(Ljava/lang/String;Lza/e;)Lkotlin/Pair;", "Landroid/util/Size;", "getCompressBitmapSize", "()Landroid/util/Size;", "", "actionHistory", "Ljava/util/List;", "stepCounter", "I", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Lstepai/aios/guiagent/llm/parser/GUIAgentMode;", "supportedMode", "getSupportedMode", "()Ljava/util/List;", HintConstants.AUTOFILL_HINT_NAME, "getName", "desc", "getDesc", "systemPrompt", "getSystemPrompt", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GLMModelCell extends AbsModelCell {
    private static final String TAG = "GLMModelCell";
    private int stepCounter;
    private final List<String> actionHistory = new ArrayList();
    private final String type = "GLMModelCell";
    private final List<GUIAgentMode> supportedMode = o.M(GUIAgentMode.NO_PATH);
    private final String name = "GLM-4.5V";
    private final String desc = "用于智谱 GLM-4.5V 模型";
    private final String systemPrompt = "You are a GUI Agent, and your primary task is to respond accurately to user requests or questions. In addition to directly answering the user's queries, you can also use tools or perform GUI operations directly until you fulfill the user's request or provide a correct answer. You should carefully read and understand the images and questions provided by the user, and engage in thinking and reflection when appropriate. The coordinates involved are all represented in thousandths (0-999).\n\n# Task:\n{instruction}\n\n# Task Platform\nMobile\n\n# Action Space\n### status\n\nCalling rule: `{{\"action_type\": \"status\", \"goal_status\": \"<complete|infeasible>\"}}`\n{{\n    \"name\": \"status\",\n    \"description\": \"Finish the task by using the status action with complete or infeasible as goal_status.\",\n    \"parameters\": {{\n        \"type\": \"object\",\n        \"properties\": {{\n            \"goal_status\": {{\n                \"type\": \"string\",\n                \"description\": \"The goal status of the task.\",\n                \"enum\": [\"complete\", \"infeasible\"]\n            }}\n        }},\n        \"required\": [\"goal_status\"]\n    }}\n}}\n\n### answer\n\nCalling rule: `{{\"action_type\": \"answer\", \"text\": \"<answer_text>\"}}`\n{{\n    \"name\": \"answer\",\n    \"description\": \"Answer user's question.\",\n    \"parameters\": {{\n        \"type\": \"object\",\n        \"properties\": {{\n            \"text\": {{\n                \"type\": \"string\",\n                \"description\": \"The answer text.\"\n            }}\n        }},\n        \"required\": [\"text\"]\n    }}\n}}\n\n### click\n\nCalling rule: `{{\"action_type\": \"click\", \"box_2d\": [[xmin,ymin,xmax,ymax]]}}`\n{{\n    \"name\": \"click\",\n    \"description\": \"Click/tap on an element on the screen. Use the box_2d to indicate which element you want to click. IMPORTANT: Do NOT use click to open an app. If you need to open an app, you MUST use the open_app action instead. Click should only be used for interacting with UI elements within an already opened app.\",\n    \"parameters\": {{\n        \"type\": \"object\",\n        \"properties\": {{\n            \"box_2d\": {{\n                \"type\": \"array\",\n                \"description\": \"The box_2d should be [[xmin,ymin,xmax,ymax]] normalized to 0-999, indicating the position of the element.\"\n            }}\n        }},\n        \"required\": [\"box_2d\"]\n    }}\n}}\n\n### long_press\n\nCalling rule: `{{\"action_type\": \"long_press\", \"box_2d\": [[xmin,ymin,xmax,ymax]]}}`\n{{\n    \"name\": \"long_press\",\n    \"description\": \"Long press on an element on the screen, similar with the click action above, use the box_2d to indicate which element you want to long press.\",\n    \"parameters\": {{\n        \"type\": \"object\",\n        \"properties\": {{\n            \"box_2d\": {{\n                \"type\": \"array\",\n                \"description\": \"The box_2d should be [[xmin,ymin,xmax,ymax]] normalized to 0-999, indicating the position of the element.\"\n            }}\n        }},\n        \"required\": [\"box_2d\"]\n    }}\n}}\n\n### input_text\n\nCalling rule: `{{\"action_type\": \"input_text\", \"text\": \"<text_input>\", \"box_2d\": [[xmin,ymin,xmax,ymax]], \"override\": true/false}}`\n{{\n    \"name\": \"input_text\",\n    \"description\": \"Type text into a text field (this action contains clicking the text field, typing in the text and pressing the enter). Use the box_2d to indicate the target text field.\",\n    \"parameters\": {{\n        \"type\": \"object\",\n        \"properties\": {{\n            \"text\": {{\"description\": \"The text to be input.\"}},\n            \"box_2d\": {{\"description\": \"The box_2d should be [[xmin,ymin,xmax,ymax]] normalized to 0-999, indicating the position of the element.\"}},\n            \"override\": {{\"description\": \"If true, the text field will be cleared before typing. If false, the text will be appended.\"}}\n        }},\n        \"required\": [\"text\", \"box_2d\", \"override\"]\n    }}\n}}\n\n### keyboard_enter\n\nCalling rule: `{{\"action_type\": \"keyboard_enter\"}}`\n{{\n    \"name\": \"keyboard_enter\",\n    \"description\": \"Press the Enter key.\",\n    \"parameters\": {{\"type\": \"object\", \"properties\": {{}}, \"required\": []}}\n}}\n\n### navigate_home\n\nCalling rule: `{{\"action_type\": \"navigate_home\"}}`\n{{\n    \"name\": \"navigate_home\",\n    \"description\": \"Navigate to the home screen.\",\n    \"parameters\": {{\"type\": \"object\", \"properties\": {{}}, \"required\": []}}\n}}\n\n### navigate_back\n\nCalling rule: `{{\"action_type\": \"navigate_back\"}}`\n{{\n    \"name\": \"navigate_back\",\n    \"description\": \"Navigate back.\",\n    \"parameters\": {{\"type\": \"object\", \"properties\": {{}}, \"required\": []}}\n}}\n\n### swipe\n\nCalling rule: `{{\"action_type\": \"swipe\", \"direction\": \"<up|down|left|right>\", \"box_2d\": [[xmin,ymin,xmax,ymax]](optional)}}`\n{{\n    \"name\": \"swipe\",\n    \"description\": \"Swipe the screen or a scrollable UI element in one of the four directions.\",\n    \"parameters\": {{\n        \"type\": \"object\",\n        \"properties\": {{\n            \"direction\": {{\"type\": \"string\", \"description\": \"The direction to swipe.\", \"enum\": [\"up\", \"down\", \"left\", \"right\"]}},\n            \"box_2d\": {{\"type\": \"array\", \"description\": \"The box_2d to swipe a specific UI element, leave it empty when swiping the whole screen.\"}}\n        }},\n        \"required\": [\"direction\"]\n    }}\n}}\n\n### open_app\n\nCalling rule: `{{\"action_type\": \"open_app\", \"app_name\": \"<name>\"}}`\n{{\n    \"name\": \"open_app\",\n    \"description\": \"Open an app (nothing will happen if the app is not installed). IMPORTANT: You MUST use open_app to open any app, even if the app icon is visible on the home screen. Do NOT use click to open apps. Using open_app ensures the app starts from its initial state, which is required for proper task execution.\",\n    \"parameters\": {{\n        \"type\": \"object\",\n        \"properties\": {{\n            \"app_name\": {{\"type\": \"string\", \"description\": \"The name of the app to open.\"}}\n        }},\n        \"required\": [\"app_name\"]\n    }}\n}}\n\n### wait\n\nCalling rule: `{{\"action_type\": \"wait\"}}`\n{{\n    \"name\": \"wait\",\n    \"description\": \"Wait for the screen to update.\",\n    \"parameters\": {{\"type\": \"object\", \"properties\": {{}}, \"required\": []}}\n}}\n\n# Historical Actions and Current Memory\n{history}\n\n# Output Format\n1. Memory: important information you want to remember for the future actions.\n2. Reason: the reason for the action and the memory.\n3. Action: the action you want to take, in the correct JSON format.\n\nYour answer should look like:\nMemory: ...\nReason: ...\nAction: {{\"action_type\":...}}\n\n输出请用中文";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ActionType.values().length];
            try {
                iArr[ActionType.CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ActionType.TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ActionType.SWIPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ActionType.AWAKE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ActionType.HOME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ActionType.BACK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ActionType.WAIT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ActionType.COMPLETE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ActionType.ABORT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ActionType.INQUIRY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlin.Pair<stepai.aios.guiagent.config.ActionType, java.util.Map<java.lang.String, java.lang.String>> convertGlmActionToInternal(java.lang.String r8, org.json.JSONObject r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 700
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.GLMModelCell.convertGlmActionToInternal(java.lang.String, org.json.JSONObject, java.lang.String):kotlin.Pair");
    }

    private final String formatActionForHistory(ActionType actionType, Map<String, String> params, String cot, int step) {
        Integer numF0;
        String string;
        Integer numF02;
        Integer numF03;
        Integer numF04;
        Integer numF05;
        switch (WhenMappings.$EnumSwitchMapping$0[actionType.ordinal()]) {
            case 1:
                String str = params.get("x");
                int iIntValue = 0;
                int iIntValue2 = (str == null || (numF03 = t.f0(str)) == null) ? 0 : numF03.intValue();
                String str2 = params.get("y");
                if (str2 != null && (numF02 = t.f0(str2)) != null) {
                    iIntValue = numF02.intValue();
                }
                String str3 = params.get(TypedValues.TransitionType.S_DURATION);
                numF0 = str3 != null ? t.f0(str3) : null;
                if (numF0 != null && numF0.intValue() >= 1000) {
                    StringBuilder sbS = a.s(iIntValue2, "{\"action_type\": \"long_press\", \"box_2d\": [[", iIntValue, ", ", ", ");
                    sbS.append(iIntValue2);
                    sbS.append(", ");
                    sbS.append(iIntValue);
                    sbS.append("]]}");
                    string = sbS.toString();
                    break;
                } else {
                    StringBuilder sbS2 = a.s(iIntValue2, "{\"action_type\": \"click\", \"box_2d\": [[", iIntValue, ", ", ", ");
                    sbS2.append(iIntValue2);
                    sbS2.append(", ");
                    sbS2.append(iIntValue);
                    sbS2.append("]]}");
                    string = sbS2.toString();
                    break;
                }
                break;
            case 2:
                String str4 = params.get("text");
                String str5 = str4 != null ? str4 : "";
                if (!str5.equals("\n")) {
                    String str6 = params.get("x");
                    int iIntValue3 = 500;
                    int iIntValue4 = (str6 == null || (numF05 = t.f0(str6)) == null) ? 500 : numF05.intValue();
                    String str7 = params.get("y");
                    if (str7 != null && (numF04 = t.f0(str7)) != null) {
                        iIntValue3 = numF04.intValue();
                    }
                    String str8 = params.get("override");
                    boolean z10 = str8 != null ? Boolean.parseBoolean(str8) : true;
                    StringBuilder sbT = a.t(iIntValue4, "{\"action_type\": \"input_text\", \"text\": \"", t.c0(t.c0(str5, "\"", "\\\""), "\n", "\\n"), "\", \"box_2d\": [[", ", ");
                    androidx.constraintlayout.core.dsl.a.y(sbT, iIntValue3, ", ", iIntValue4, ", ");
                    sbT.append(iIntValue3);
                    sbT.append("]], \"override\": ");
                    sbT.append(z10);
                    sbT.append("}");
                    string = sbT.toString();
                    break;
                } else {
                    string = "{\"action_type\": \"keyboard_enter\"}";
                    break;
                }
                break;
            case 3:
                String str9 = params.get("direction");
                if (str9 == null) {
                    str9 = "down";
                }
                String str10 = (String) kotlin.collections.a.R(new Pair("down", "up"), new Pair("up", "down"), new Pair("right", "left"), new Pair("left", "right")).get(str9);
                if (str10 != null) {
                    str9 = str10;
                }
                String str11 = params.get("x");
                Integer numF06 = str11 != null ? t.f0(str11) : null;
                String str12 = params.get("y");
                numF0 = str12 != null ? t.f0(str12) : null;
                if (numF06 != null && numF0 != null) {
                    string = "{\"action_type\": \"swipe\", \"direction\": \"" + str9 + "\", \"box_2d\": [[" + numF06 + ", " + numF0 + ", " + numF06 + ", " + numF0 + "]]}";
                    break;
                } else {
                    string = B7.a.m("{\"action_type\": \"swipe\", \"direction\": \"", str9, "\"}");
                    break;
                }
            case 4:
                String str13 = params.get(GuiAgentConfigKt.META_KEY_APP_NAME);
                string = B7.a.m("{\"action_type\": \"open_app\", \"app_name\": \"", str13 != null ? str13 : "", "\"}");
                break;
            case 5:
                string = "{\"action_type\": \"navigate_home\"}";
                break;
            case 6:
                string = "{\"action_type\": \"navigate_back\"}";
                break;
            case 7:
                string = "{\"action_type\": \"wait\"}";
                break;
            case 8:
                string = "{\"action_type\": \"status\", \"goal_status\": \"complete\"}";
                break;
            case 9:
                string = "{\"action_type\": \"status\", \"goal_status\": \"infeasible\"}";
                break;
            case 10:
                String str14 = params.get("value");
                string = B7.a.m("{\"action_type\": \"answer\", \"text\": \"", t.c0(t.c0(str14 != null ? str14 : "", "\"", "\\\""), "\n", "\\n"), "\"}");
                break;
            default:
                String lowerCase = actionType.toString().toLowerCase(Locale.ROOT);
                k.e(lowerCase, "toLowerCase(...)");
                string = "{\"action_type\": \"" + lowerCase + "\"}";
                break;
        }
        if (cot.length() <= 0) {
            return androidx.constraintlayout.core.dsl.a.c(step, "Step ", ":\nMemory: \nReason: \nAction: ", string);
        }
        StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(step, "Step ", ":\n", cot, "\nAction: ");
        sbK.append(string);
        return sbK.toString();
    }

    private final Pair<Integer, Integer> parseBox2d(JSONObject actionDict) {
        try {
            JSONArray jSONArray = actionDict.getJSONArray("box_2d").getJSONArray(0);
            return new Pair<>(Integer.valueOf((jSONArray.getInt(0) + jSONArray.getInt(2)) / 2), Integer.valueOf((jSONArray.getInt(1) + jSONArray.getInt(3)) / 2));
        } catch (Exception e) {
            j.J("警告：解析 box_2d 失败，使用默认值: " + e.getMessage(), "GLMModelCell");
            return new Pair<>(500, 500);
        }
    }

    private final Pair<Integer, Integer> parseBox2dOrNull(JSONObject actionDict) {
        try {
            JSONArray jSONArray = actionDict.getJSONArray("box_2d").getJSONArray(0);
            return new Pair<>(Integer.valueOf((jSONArray.getInt(0) + jSONArray.getInt(2)) / 2), Integer.valueOf((jSONArray.getInt(1) + jSONArray.getInt(3)) / 2));
        } catch (Exception e) {
            j.J("警告：解析 box_2d 失败，input_text 不附带坐标: " + e.getMessage(), "GLMModelCell");
            return null;
        }
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell
    public List<Message> buildRequestMessage(e session, String imageBase64) {
        k.f(session, "session");
        LlmMessageBuilder llmMessageBuilderText = new LlmMessageBuilder().role(MessageRole.USER).text(t.c0(t.c0(effectiveSystemPrompt(), "{instruction}", session.b), "{history}", !this.actionHistory.isEmpty() ? v.I0(this.actionHistory, "\n\n", null, null, null, 62) : "No previous actions."));
        if (imageBase64 != null && !m.s0(imageBase64)) {
            LlmMessageBuilder.imageBase64$default(llmMessageBuilderText, imageBase64, null, 2, null);
        }
        return o.M(llmMessageBuilderText.build());
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell
    public Pair<ActionType, Map<String, String>> buildResponseAction(String response, e session) {
        String string;
        String string2;
        String strGroup;
        JSONObject jSONObject;
        k.f(response, "response");
        k.f(session, "session");
        Matcher matcher = Pattern.compile("Memory:\\s*(.+?)(?=Reason:|Action:|$)", 32).matcher(response);
        if (matcher.find()) {
            String strGroup2 = matcher.group(1);
            k.e(strGroup2, "group(...)");
            string = m.R0(strGroup2).toString();
        } else {
            string = "";
        }
        Matcher matcher2 = Pattern.compile("Reason:\\s*(.+?)(?=Action:|$)", 32).matcher(response);
        if (matcher2.find()) {
            String strGroup3 = matcher2.group(1);
            k.e(strGroup3, "group(...)");
            string2 = m.R0(strGroup3).toString();
        } else {
            string2 = "";
        }
        String strN = (string.length() <= 0 && string2.length() <= 0) ? "" : B7.a.n("Memory: ", string, "\nReason: ", string2);
        String strC0 = t.c0(t.c0(response, "<|begin_of_box|>", ""), "<|end_of_box|>", "");
        Matcher matcher3 = Pattern.compile("Action:\\s*(\\{.+\\})", 32).matcher(strC0);
        if (matcher3.find()) {
            String strGroup4 = matcher3.group(1);
            k.e(strGroup4, "group(...)");
            strGroup = m.R0(strGroup4).toString();
        } else {
            Matcher matcher4 = Pattern.compile("\\{\"action_type\":\\s*\".+?\"[^}]*\\}", 32).matcher(strC0);
            strGroup = matcher4.find() ? matcher4.group(0) : null;
        }
        if (strGroup == null) {
            j.J("警告：无法解析 Action JSON，返回 WAIT: " + m.N0(200, strC0) + "...", "GLMModelCell");
            return new Pair<>(ActionType.WAIT, B7.a.x(TypedValues.TransitionType.S_DURATION, "3000"));
        }
        try {
            try {
                jSONObject = new JSONObject(strGroup);
            } catch (Exception unused) {
                j.J("警告：无法解析 Action JSON: ".concat(strGroup), "GLMModelCell");
                return new Pair<>(ActionType.WAIT, B7.a.x(TypedValues.TransitionType.S_DURATION, "3000"));
            }
        } catch (Exception unused2) {
            jSONObject = new JSONObject(t.c0(strGroup, "'", "\""));
        }
        String strOptString = jSONObject.optString("action_type", "");
        k.c(strOptString);
        Pair<ActionType, Map<String, String>> pairConvertGlmActionToInternal = convertGlmActionToInternal(strOptString, jSONObject, strN);
        int i = this.stepCounter + 1;
        this.stepCounter = i;
        this.actionHistory.add(formatActionForHistory((ActionType) pairConvertGlmActionToInternal.f4886a, (Map) pairConvertGlmActionToInternal.b, strN, i));
        return pairConvertGlmActionToInternal;
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell
    public void clearCache() {
        this.actionHistory.clear();
        this.stepCounter = 0;
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public Size getCompressBitmapSize() {
        return new Size(448, 1080);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getDesc() {
        return this.desc;
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getName() {
        return this.name;
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public List<GUIAgentMode> getSupportedMode() {
        return this.supportedMode;
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getSystemPrompt() {
        return this.systemPrompt;
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getType() {
        return this.type;
    }
}
