package stepai.aios.guiagent.llm.cell;

import B7.a;
import D7.v;
import F7.b;
import H4.o;
import N9.j;
import android.util.Size;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.highlight.HighlightCallback;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import stepai.aios.guiagent.config.ActionType;
import stepai.aios.guiagent.llm.Message;
import stepai.aios.guiagent.llm.MessageRole;
import stepai.aios.guiagent.llm.config.LlmMessageBuilder;
import stepai.aios.guiagent.llm.parser.AbsModelCell;
import stepai.aios.guiagent.llm.parser.GUIAgentMode;
import stepai.aios.guiagent.llm.parser.ModelParam;
import stepai.android.llm.base.twoway.FlowType;
import za.e;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ1\u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\t2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ=\u0010\u001c\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t\u0018\u00010\u00072\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\tH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010\u0003J'\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00182\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b)\u0010*J7\u0010,\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\u00072\u0006\u0010+\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b,\u0010-J\u0011\u0010/\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0004\b/\u00100J\u0011\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b2\u00103R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u001e048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\"\u0010;\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\bB\u0010?\u001a\u0004\bC\u0010AR\u001c\u0010D\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\bD\u0010?\u001a\u0004\bE\u0010AR\u001a\u0010F\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\bF\u0010?\u001a\u0004\bG\u0010A¨\u0006I"}, d2 = {"Lstepai/aios/guiagent/llm/cell/MiMoModelCell;", "Lstepai/aios/guiagent/llm/parser/AbsModelCell;", AppAgent.CONSTRUCT, "()V", "", "actionStr", "thinkStr", "Lkotlin/Pair;", "Lstepai/aios/guiagent/config/ActionType;", "", "tryParseMiMoJsonAction", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/Pair;", "pointStr", "", "parseJsonPoint", "(Ljava/lang/String;)Lkotlin/Pair;", "parseFunctionCallFormat", "actionLine", "tryParseAction", "functionStr", "", "parseFunctionToMap", "(Ljava/lang/String;)Ljava/util/Map;", "paramsStr", "", "splitParams", "(Ljava/lang/String;)Ljava/util/List;", "funcDict", "convertFuncDictToAction", "(Ljava/util/Map;)Lkotlin/Pair;", "Lstepai/aios/guiagent/llm/Message;", "message", "", "hasImage", "(Lstepai/aios/guiagent/llm/Message;)Z", "LC7/r;", "cleanupHistory", "clearCache", "Lza/e;", "session", "imageBase64", "buildRequestMessage", "(Lza/e;Ljava/lang/String;)Ljava/util/List;", "response", "buildResponseAction", "(Ljava/lang/String;Lza/e;)Lkotlin/Pair;", "Landroid/util/Size;", "getCompressBitmapSize", "()Landroid/util/Size;", "Lstepai/aios/guiagent/llm/parser/ModelParam;", "getModelParam", "()Lstepai/aios/guiagent/llm/parser/ModelParam;", "", "messageHistory", "Ljava/util/List;", "", "messagesWithImage", "Ljava/util/Set;", "Lstepai/aios/guiagent/llm/parser/GUIAgentMode;", "supportedMode", "getSupportedMode", "()Ljava/util/List;", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", HintConstants.AUTOFILL_HINT_NAME, "getName", "desc", "getDesc", "systemPrompt", "getSystemPrompt", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MiMoModelCell extends AbsModelCell {
    private static final int LAST_IMAGE_COUNT = 3;
    private static final String TAG = "MiMoModelCell";
    private final List<Message> messageHistory = new ArrayList();
    private final Set<Message> messagesWithImage = new LinkedHashSet();
    private final List<GUIAgentMode> supportedMode = o.M(GUIAgentMode.NO_PATH);
    private final String type = "MiMoModelCell";
    private final String name = "MiMo-Vision";
    private final String desc = "用于 MiMo 视觉模型";
    private final String systemPrompt = "You are a GUI agent. You are given a task and your action history, with screenshots. You need to perform the next action to complete the task.\n## Output Format\n```\nThought: ...\nAction: ...\n```\n\n## Action Space\nclick(point=<bbox>x1 y1 x2 y2</bbox>)\nlong_press(point=<bbox>x1 y1 x2 y2</bbox>)\ninput(text='') #If you want to submit your input, use \"\\n\" at the end of `text`.\nscroll(point=<bbox>x1 y1 x2 y2</bbox>, direction='down or up or right or left')\nopen_app(app_name='')\ndrag(start_point=<bbox>x1 y1 x2 y2</bbox>, end_point=<bbox>x1 y1 x2 y2</bbox>)\npress_home()\npress_back()\nfinished(content='xxx') # Use escape characters \\', \\\", and \\n in content part to ensure we can parse the content in normal python string format.\n\n## Note\n- Use Chinese in `Thought` part.\n- Write a small plan and finally summarize your next action (with its target element) in one sentence in `Thought` part.\n- Coordinates are in bbox format: <bbox>x1 y1 x2 y2</bbox> where (x1,y1) is top-left and (x2,y2) is bottom-right, normalized to 0-1000.\n- Only use the action space above, no other actions are allowed. Use action space instead of natural language.\n- Use open_app(app_name='') to open an app.\n- Output the coordinates range is 0-1000, the top-left is (0,0), the bottom-right is (1000,1000). Don't output the absolute coordinates, output the relative coordinates to the screen.\n- If the task is ordering food, don't go to the payment page. The task is completed when you submit the order. Don't try to pay for the order.\n\n## User Instruction\n{instruction}\n## Hard Constraints\n- `Action` MUST be syntactically valid exactly as defined above.\n- `Action` MUST be executable — no hypothetical actions.\n- In `Thought`, write:\n  1) A short plan\n  2) The reasoning for choosing the next action\n  3) A final sentence summarizing the one action you will take next.\n- `Thought` MUST NOT contain coordinates or action syntax.\n- Only the `Action` field may include coordinates or action syntax.";

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
        if (arrayList.size() > 4) {
            int size = arrayList.size() - 4;
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0065, code lost:
    
        if (r0.equals("input") != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c1, code lost:
    
        if (r0.equals("type") != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c3, code lost:
    
        r9 = r10.get("content");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c9, code lost:
    
        if ((r9 instanceof java.lang.String) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cb, code lost:
    
        r9 = (java.lang.String) r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ce, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d1, code lost:
    
        if (r9 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d3, code lost:
    
        r9 = r10.get("text");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d9, code lost:
    
        if ((r9 instanceof java.lang.String) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00db, code lost:
    
        r2 = (java.lang.String) r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00de, code lost:
    
        if (r2 != null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e0, code lost:
    
        r9 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e3, code lost:
    
        r9 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ef, code lost:
    
        return new kotlin.Pair<>(stepai.aios.guiagent.config.ActionType.TYPE, B7.a.x("text", r9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlin.Pair<stepai.aios.guiagent.config.ActionType, java.util.Map<java.lang.String, java.lang.String>> convertFuncDictToAction(java.util.Map<java.lang.String, ? extends java.lang.Object> r10) {
        /*
            Method dump skipped, instructions count: 734
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.MiMoModelCell.convertFuncDictToAction(java.util.Map):kotlin.Pair");
    }

    private final boolean hasImage(Message message) {
        return this.messagesWithImage.contains(message);
    }

    private final Pair<ActionType, Map<String, String>> parseFunctionCallFormat(String actionStr, String thinkStr) {
        Pair<ActionType, Map<String, String>> pairTryParseAction;
        Iterator it = m.D0(actionStr, new String[]{"\n"}, 6).iterator();
        int i = 0;
        while (it.hasNext()) {
            int i6 = i + 1;
            String string = m.R0(t.c0(t.c0((String) it.next(), "*", ""), "`", "")).toString();
            if (t.e0(string, "Action:", false) || t.e0(string, "Action：", false)) {
                string = m.R0(t.c0(t.c0(string, "Action:", ""), "Action：", "")).toString();
            }
            String string2 = m.R0(string).toString();
            try {
                pairTryParseAction = tryParseAction(string2);
            } catch (Exception unused) {
            }
            if (pairTryParseAction != null) {
                j.H("Successfully parsed line " + i + " [" + string2 + "] to action", "MiMoModelCell");
                return pairTryParseAction;
            }
            continue;
            i = i6;
        }
        List listN = o.N("任务完成", "任务已完成", "完成任务", "已完成", "任务结束", "finished", FlowType.COMPLETED, HighlightCallback.KEY_DONE, "task completed");
        String lowerCase = actionStr.toLowerCase(Locale.ROOT);
        k.e(lowerCase, "toLowerCase(...)");
        List<String> list = listN;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (String str : list) {
                String lowerCase2 = str.toLowerCase(Locale.ROOT);
                k.e(lowerCase2, "toLowerCase(...)");
                if (m.h0(lowerCase, lowerCase2, false) || m.h0(actionStr, str, false)) {
                    j.H("检测到任务完成关键词，返回 COMPLETE 动作", "MiMoModelCell");
                    return new Pair<>(ActionType.COMPLETE, a.x("message", "任务完成"));
                }
            }
        }
        j.J("Warning: 模型输出了自然语言而不是动作指令，返回 WAIT 动作。原始输出: " + m.N0(200, actionStr) + "...", "MiMoModelCell");
        return new Pair<>(ActionType.WAIT, a.x(TypedValues.TransitionType.S_DURATION, "3000"));
    }

    private final Map<String, Object> parseFunctionToMap(String functionStr) throws NumberFormatException {
        if (!m.h0(functionStr, "(", false) || !t.W(functionStr, ")", false)) {
            throw new IllegalArgumentException("Invalid function format: ".concat(functionStr));
        }
        String strSubstring = functionStr.substring(0, m.q0(functionStr, "(", 0, false, 6));
        k.e(strSubstring, "substring(...)");
        String string = m.R0(strSubstring).toString();
        String strSubstring2 = functionStr.substring(string.length() + 1, functionStr.length() - 1);
        k.e(strSubstring2, "substring(...)");
        String string2 = m.R0(strSubstring2).toString();
        LinkedHashMap linkedHashMapS = kotlin.collections.a.S(new Pair("function_name", string));
        if (string2.length() != 0) {
            for (String str : m.h0(string2, ",", false) ? splitParams(string2) : o.M(string2)) {
                if (!m.h0(str, "=", false)) {
                    throw new IllegalArgumentException("Invalid param: ".concat(str));
                }
                List listD0 = m.D0(str, new String[]{"="}, 2);
                String string3 = m.R0((String) listD0.get(0)).toString();
                String string4 = m.R0((String) listD0.get(1)).toString();
                if (t.e0(string4, "'", false) && t.W(string4, "'", false)) {
                    string4 = string4.substring(1, string4.length() - 1);
                    k.e(string4, "substring(...)");
                } else if (t.e0(string4, "\"", false) && t.W(string4, "\"", false)) {
                    string4 = string4.substring(1, string4.length() - 1);
                    k.e(string4, "substring(...)");
                }
                if (m.h0(string4, "<point>", false) && m.h0(string4, "</point>", false)) {
                    List listD02 = m.D0(m.R0(t.c0(t.c0(string4, "<point>", ""), "</point>", "")).toString(), new String[]{" "}, 6);
                    if (listD02.size() >= 2) {
                        linkedHashMapS.put(string3, new Pair(Integer.valueOf(Integer.parseInt((String) listD02.get(0))), Integer.valueOf(Integer.parseInt((String) listD02.get(1)))));
                    }
                } else if (m.h0(string4, "<bbox>", false) && m.h0(string4, "</bbox>", false)) {
                    List listD03 = m.D0(m.R0(t.c0(t.c0(string4, "<bbox>", ""), "</bbox>", "")).toString(), new String[]{" "}, 6);
                    if (listD03.size() >= 4) {
                        linkedHashMapS.put(string3, new Pair(Integer.valueOf((Integer.parseInt((String) listD03.get(0)) + Integer.parseInt((String) listD03.get(2))) / 2), Integer.valueOf((Integer.parseInt((String) listD03.get(1)) + Integer.parseInt((String) listD03.get(3))) / 2)));
                    } else if (listD03.size() == 2) {
                        linkedHashMapS.put(string3, new Pair(Integer.valueOf(Integer.parseInt((String) listD03.get(0))), Integer.valueOf(Integer.parseInt((String) listD03.get(1)))));
                    }
                } else {
                    linkedHashMapS.put(string3, string4);
                }
            }
        }
        return linkedHashMapS;
    }

    private final Pair<Integer, Integer> parseJsonPoint(String pointStr) {
        if (pointStr == null) {
            return new Pair<>(500, 500);
        }
        try {
            JSONArray jSONArray = new JSONArray(pointStr);
            return new Pair<>(Integer.valueOf(jSONArray.optInt(0, 500)), Integer.valueOf(jSONArray.optInt(1, 500)));
        } catch (Exception unused) {
            return new Pair<>(500, 500);
        }
    }

    private final List<String> splitParams(String paramsStr) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = paramsStr.length();
        char c = ' ';
        boolean z10 = false;
        for (int i = 0; i < length; i++) {
            char cCharAt = paramsStr.charAt(i);
            if ((cCharAt == '\"' || cCharAt == '\'') && !z10) {
                sb.append(cCharAt);
                z10 = true;
                c = cCharAt;
            } else if (cCharAt == c && z10) {
                sb.append(cCharAt);
                z10 = false;
            } else if (cCharAt != ',' || z10) {
                sb.append(cCharAt);
            } else {
                String string = sb.toString();
                k.e(string, "toString(...)");
                arrayList.add(string);
                sb = new StringBuilder();
            }
        }
        if (sb.length() > 0) {
            String string2 = sb.toString();
            k.e(string2, "toString(...)");
            arrayList.add(string2);
        }
        return arrayList;
    }

    private final Pair<ActionType, Map<String, String>> tryParseAction(String actionLine) {
        if (m.h0(actionLine, "(", false) && t.W(actionLine, ")", false)) {
            return convertFuncDictToAction(parseFunctionToMap(actionLine));
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0344, code lost:
    
        if (r9.equals("scroll") == false) goto L136;
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e1 A[PHI: r0
      0x01e1: PHI (r0v65 java.lang.String) = (r0v64 java.lang.String), (r0v68 java.lang.String) binds: [B:79:0x01d6, B:81:0x01de] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlin.Pair<stepai.aios.guiagent.config.ActionType, java.util.Map<java.lang.String, java.lang.String>> tryParseMiMoJsonAction(java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 1124
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.MiMoModelCell.tryParseMiMoJsonAction(java.lang.String, java.lang.String):kotlin.Pair");
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell
    public List<Message> buildRequestMessage(e session, String imageBase64) {
        k.f(session, "session");
        ArrayList arrayList = new ArrayList();
        String strConcat = t.c0(effectiveSystemPrompt(), "{instruction}", session.b).concat(" /no_think");
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
        List<Message> listB1 = v.b1(3, arrayList2);
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
            Message messageBuild = LlmMessageBuilder.imageBase64$default(new LlmMessageBuilder().role(MessageRole.USER), imageBase64, null, 2, null).text(strConcat).build();
            arrayList.add(messageBuild);
            this.messageHistory.add(messageBuild);
            this.messagesWithImage.add(messageBuild);
        }
        return arrayList;
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell
    public Pair<ActionType, Map<String, String>> buildResponseAction(String response, e session) {
        k.f(response, "response");
        k.f(session, "session");
        if (!m.s0(response)) {
            this.messageHistory.add(new LlmMessageBuilder().role(MessageRole.ASSISTANT).text(response).build());
            cleanupHistory();
        }
        String string = m.R0(response).toString();
        String string2 = "";
        if (m.h0(string, "</think>", false)) {
            List listD0 = m.D0(string, new String[]{"</think>"}, 2);
            string2 = m.R0(t.c0((String) listD0.get(0), "<think>", "")).toString();
            string = m.R0((String) listD0.get(1)).toString();
        }
        Pair<ActionType, Map<String, String>> pairTryParseMiMoJsonAction = tryParseMiMoJsonAction(string, string2);
        return pairTryParseMiMoJsonAction != null ? pairTryParseMiMoJsonAction : parseFunctionCallFormat(string, string2);
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell
    public void clearCache() {
        this.messageHistory.clear();
        this.messagesWithImage.clear();
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public Size getCompressBitmapSize() {
        return new Size(448, 1080);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public String getDesc() {
        return this.desc;
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell, stepai.aios.guiagent.llm.parser.IModelCell
    public ModelParam getModelParam() {
        return new ModelParam(0.0f, 0.7f, 4096, null, 8, null);
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
