package stepai.aios.guiagent.llm.cell;

import B7.a;
import D7.v;
import F7.b;
import H4.o;
import android.util.Size;
import androidx.autofill.HintConstants;
import ca.AbstractC0897f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import j9.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.ActionType;
import stepai.aios.guiagent.llm.Message;
import stepai.aios.guiagent.llm.MessageRole;
import stepai.aios.guiagent.llm.cell.config.ModelCatalog;
import stepai.aios.guiagent.llm.config.LlmMessageBuilder;
import stepai.aios.guiagent.llm.parser.AbsModelCell;
import stepai.aios.guiagent.llm.parser.GUIAgentMode;
import za.e;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J'\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 J7\u0010\"\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\u00072\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\"\u0010#J\u0011\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b%\u0010&R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00130*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b2\u0010)\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b6\u00100R\u001c\u00107\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b7\u0010.\u001a\u0004\b8\u00100R\u001a\u00109\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b9\u0010.\u001a\u0004\b:\u00100¨\u0006<"}, d2 = {"Lstepai/aios/guiagent/llm/cell/GlmAutoModelCell;", "Lstepai/aios/guiagent/llm/parser/AbsModelCell;", AppAgent.CONSTRUCT, "()V", "", "actionStr", "cot", "Lkotlin/Pair;", "Lstepai/aios/guiagent/config/ActionType;", "", "parseActionString", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/Pair;", "paramsStr", "parseParams", "(Ljava/lang/String;)Ljava/util/Map;", "elementStr", "", "parseElement", "(Ljava/lang/String;)Lkotlin/Pair;", "Lstepai/aios/guiagent/llm/Message;", "message", "", "hasImage", "(Lstepai/aios/guiagent/llm/Message;)Z", "LC7/r;", "cleanupHistory", "clearCache", "Lza/e;", "session", "imageBase64", "", "buildRequestMessage", "(Lza/e;Ljava/lang/String;)Ljava/util/List;", "response", "buildResponseAction", "(Ljava/lang/String;Lza/e;)Lkotlin/Pair;", "Landroid/util/Size;", "getCompressBitmapSize", "()Landroid/util/Size;", "", "messageHistory", "Ljava/util/List;", "", "messagesWithImage", "Ljava/util/Set;", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Lstepai/aios/guiagent/llm/parser/GUIAgentMode;", "supportedMode", "getSupportedMode", "()Ljava/util/List;", HintConstants.AUTOFILL_HINT_NAME, "getName", "desc", "getDesc", "systemPrompt", "getSystemPrompt", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GlmAutoModelCell extends AbsModelCell {
    private static final int LAST_IMAGE_COUNT = 3;
    private static final String TAG = "GlmModelCell";
    private final List<Message> messageHistory = new ArrayList();
    private final Set<Message> messagesWithImage = new LinkedHashSet();
    private final String type = ModelCatalog.MODEL_CELL_TYPE_GLM_AUTO;
    private final List<GUIAgentMode> supportedMode = o.M(GUIAgentMode.NO_PATH);
    private final String name = "AutoGLM-phone-9B";
    private final String desc = "用于智谱AutoGLM phone模型";
    private final String systemPrompt = "今天的日期是:{formatted_date}\n你是一个智能体分析专家，可以根据操作历史和当前状态图执行一系列操作来完成任务。\n你必须严格按照要求输出以下格式：\n<think>{think}</think>\n<answer>{action}</answer>\n\n其中：\n- {think} 是对你为什么选择这个操作的简短推理说明。\n- {action} 是本次执行的具体操作指令，必须严格遵循下方定义的指令格式。\n\n操作指令及其作用如下：\n- do(action=\"Launch\", app=\"xxx\")\n    Launch是启动目标app的操作，这比通过主屏幕导航更快。此操作完成后，您将自动收到结果状态的截图。\n- do(action=\"Tap\", element=[x,y])\n    Tap是点击操作，点击屏幕上的特定点。可用此操作点击按钮、选择项目、从主屏幕打开应用程序，或与任何可点击的用户界面元素进行交互。坐标系统从左上角 (0,0) 开始到右下角（999,999)结束。此操作完成后，您将自动收到结果状态的截图。\n- do(action=\"Tap\", element=[x,y], message=\"重要操作\")\n    基本功能同Tap，点击涉及财产、支付、隐私等敏感按钮时触发。\n- do(action=\"Type\", text=\"xxx\")\n    Type是输入操作，在当前聚焦的输入框中输入文本。使用此操作前，请确保输入框已被聚焦（先点击它）。输入的文本将像使用键盘输入一样输入。重要提示：手机可能正在使用 ADB 键盘，该键盘不会像普通键盘那样占用屏幕空间。要确认键盘已激活，请查看屏幕底部是否显示 'ADB Keyboard {ON}' 类似的文本，或者检查输入框是否处于激活/高亮状态。不要仅仅依赖视觉上的键盘显示。自动清除文本：当你使用输入操作时，输入框中现有的任何文本（包括占位符文本和实际输入）都会在输入新文本前自动清除。你无需在输入前手动清除文本——直接使用输入操作输入所需文本即可。操作完成后，你将自动收到结果状态的截图。\n- do(action=\"Type_Name\", text=\"xxx\")\n    Type_Name是输入人名的操作，基本功能同Type。\n- do(action=\"Interact\")\n    Interact是当有多个满足条件的选项时而触发的交互操作，询问用户如何选择。\n- do(action=\"Swipe\", start=[x1,y1], end=[x2,y2])\n    Swipe是滑动操作，通过从起始坐标拖动到结束坐标来执行滑动手势。可用于滚动内容、在屏幕之间导航、下拉通知栏以及项目栏或进行基于手势的导航。坐标系统从左上角 (0,0) 开始到右下角（999,999)结束。滑动持续时间会自动调整以实现自然的移动。此操作完成后，您将自动收到结果状态的截图。\n- do(action=\"Note\", message=\"True\")\n    记录当前页面内容以便后续总结。\n- do(action=\"Call_API\", instruction=\"xxx\")\n    总结或评论当前页面或已记录的内容。\n- do(action=\"Long Press\", element=[x,y])\n    Long Pres是长按操作，在屏幕上的特定点长按指定时间。可用于触发上下文菜单、选择文本或激活长按交互。坐标系统从左上角 (0,0) 开始到右下角（999,999)结束。此操作完成后，您将自动收到结果状态的屏幕截图。\n- do(action=\"Double Tap\", element=[x,y])\n    Double Tap在屏幕上的特定点快速连续点按两次。使用此操作可以激活双击交互，如缩放、选择文本或打开项目。坐标系统从左上角 (0,0) 开始到右下角（999,999)结束。此操作完成后，您将自动收到结果状态的截图。\n- do(action=\"Take_over\", message=\"xxx\")\n    Take_over是接管操作，表示在登录和验证阶段需要用户协助。\n- do(action=\"Back\")\n    导航返回到上一个屏幕或关闭当前对话框。相当于按下 Android 的返回按钮。使用此操作可以从更深的屏幕返回、关闭弹出窗口或退出当前上下文。此操作完成后，您将自动收到结果状态的截图。\n- do(action=\"Home\")\n    Home是回到系统桌面的操作，相当于按下 Android 主屏幕按钮。使用此操作可退出当前应用并返回启动器，或从已知状态启动新任务。此操作完成后，您将自动收到结果状态的截图。\n- do(action=\"Wait\", duration=\"x seconds\")\n    等待页面加载，x为需要等待多少秒。\n- finish(message=\"xxx\")\n    finish是结束任务的操作，表示准确完整完成任务，message是终止信息。\n\n必须遵循的规则：\n1. 在执行任何操作前，先检查当前app是否是目标app，如果不是，先执行 Launch。\n2. 如果进入到了无关页面，先执行 Back。如果执行Back后页面没有变化，请点击页面左上角的返回键进行返回，或者右上角的X号关闭。\n3. 如果页面未加载出内容，最多连续 Wait 三次，否则执行 Back重新进入。\n4. 如果页面显示网络问题，需要重新加载，请点击重新加载。\n5. 如果当前页面找不到目标联系人、商品、店铺等信息，可以尝试 Swipe 滑动查找。\n6. 遇到价格区间、时间区间等筛选条件，如果没有完全符合的，可以放宽要求。\n7. 在做小红书总结类任务时一定要筛选图文笔记。\n8. 购物车全选后再点击全选可以把状态设为全不选，在做购物车任务时，如果购物车里已经有商品被选中时，你需要点击全选后再点击取消全选，再去找需要购买或者删除的商品。\n9. 在做外卖任务时，如果相应店铺购物车里已经有其他商品你需要先把购物车清空再去购买用户指定的外卖。\n10. 在做点外卖任务时，如果用户需要点多个外卖，请尽量在同一店铺进行购买，如果无法找到可以下单，并说明某个商品未找到。\n11. 请严格遵循用户意图执行任务，用户的特殊要求可以执行多次搜索，滑动查找。比如（i）用户要求点一杯咖啡，要咸的，你可以直接搜索咸咖啡，或者搜索咖啡后滑动查找咸的咖啡，比如海盐咖啡。（ii）用户要找到XX群，发一条消息，你可以先搜索XX群，找不到结果后，将\"群\"字去掉，搜索XX重试。（iii）用户要找到宠物友好的餐厅，你可以搜索餐厅，找到筛选，找到设施，选择可带宠物，或者直接搜索可带宠物，必要时可以使用AI搜索。\n12. 在选择日期时，如果原滑动方向与预期日期越来越远，请向反方向滑动查找。\n13. 执行任务过程中如果有多个可选择的项目栏，请逐个查找每个项目栏，直到完成任务，一定不要在同一项目栏多次查找，从而陷入死循环。\n14. 在执行下一步操作前请一定要检查上一步的操作是否生效，如果点击没生效，可能因为app反应较慢，请先稍微等待一下，如果还是不生效请调整一下点击位置重试，如果仍然不生效请跳过这一步继续任务，并在finish message说明点击不生效。\n15. 在执行任务中如果遇到滑动不生效的情况，请调整一下起始点位置，增大滑动距离重试，如果还是不生效，有可能是已经滑到底了，请继续向反方向滑动，直到顶部或底部，如果仍然没有符合要求的结果，请跳过这一步继续任务，并在finish message说明但没找到要求的项目。\n16. 在做游戏任务时如果在战斗页面如果有自动战斗一定要开启自动战斗，如果多轮历史状态相似要检查自动战斗是否开启。\n17. 如果没有合适的搜索结果，可能是因为搜索页面不对，请返回到搜索页面的上一级尝试重新搜索，如果尝试三次返回上一级搜索后仍然没有符合要求的结果，执行 finish(message=\"原因\")。\n18. 在结束任务前请一定要仔细检查任务是否完整准确的完成，如果出现错选、漏选、多选的情况，请返回之前的步骤进行纠正。";

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

    private final boolean hasImage(Message message) {
        return this.messagesWithImage.contains(message);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0390, code lost:
    
        if (r14.equals("Type_Name") != false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0392, code lost:
    
        r13 = r13.get("text");
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x039a, code lost:
    
        if (r13 == null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x039c, code lost:
    
        r13 = j9.m.S0(r13, com.fasterxml.jackson.core.JsonFactory.DEFAULT_QUOTE_CHAR, '\'');
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x03a5, code lost:
    
        if (r13 != null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x03a8, code lost:
    
        r0 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x03b4, code lost:
    
        return new kotlin.Pair<>(stepai.aios.guiagent.config.ActionType.TYPE, B7.a.x("text", r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x020c, code lost:
    
        if (r14.equals("Type") != false) goto L125;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlin.Pair<stepai.aios.guiagent.config.ActionType, java.util.Map<java.lang.String, java.lang.String>> parseActionString(java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 1124
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.GlmAutoModelCell.parseActionString(java.lang.String, java.lang.String):kotlin.Pair");
    }

    private final Pair<Integer, Integer> parseElement(String elementStr) {
        Matcher matcher = Pattern.compile("\\[(\\d+)\\s*,\\s*(\\d+)\\]").matcher(elementStr);
        if (!matcher.find()) {
            return new Pair<>(0, 0);
        }
        String strGroup = matcher.group(1);
        k.e(strGroup, "group(...)");
        Integer numF0 = t.f0(strGroup);
        int iIntValue = numF0 != null ? numF0.intValue() : 0;
        String strGroup2 = matcher.group(2);
        k.e(strGroup2, "group(...)");
        Integer numF02 = t.f0(strGroup2);
        return new Pair<>(Integer.valueOf(iIntValue), Integer.valueOf(numF02 != null ? numF02.intValue() : 0));
    }

    private final Map<String, String> parseParams(String paramsStr) {
        String string;
        int i;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i6 = 0;
        while (i6 < paramsStr.length()) {
            while (i6 < paramsStr.length() && (AbstractC0897f.F(paramsStr.charAt(i6)) || paramsStr.charAt(i6) == ',')) {
                i6++;
            }
            if (i6 >= paramsStr.length()) {
                break;
            }
            int i10 = i6;
            while (i10 < paramsStr.length() && (Character.isLetterOrDigit(paramsStr.charAt(i10)) || paramsStr.charAt(i10) == '_')) {
                i10++;
            }
            if (i10 == i6) {
                break;
            }
            String strSubstring = paramsStr.substring(i6, i10);
            k.e(strSubstring, "substring(...)");
            while (i10 < paramsStr.length() && (AbstractC0897f.F(paramsStr.charAt(i10)) || paramsStr.charAt(i10) == '=')) {
                i10++;
            }
            if (i10 >= paramsStr.length()) {
                break;
            }
            int i11 = 1;
            if (paramsStr.charAt(i10) == '\"' || paramsStr.charAt(i10) == '\'') {
                char cCharAt = paramsStr.charAt(i10);
                i10++;
                StringBuilder sb = new StringBuilder();
                while (i10 < paramsStr.length() && paramsStr.charAt(i10) != cCharAt) {
                    if (paramsStr.charAt(i10) != '\\' || (i = i10 + 1) >= paramsStr.length()) {
                        sb.append(paramsStr.charAt(i10));
                    } else {
                        sb.append(paramsStr.charAt(i));
                        i10 = i;
                    }
                    i10++;
                }
                if (i10 < paramsStr.length()) {
                    i10++;
                }
                string = sb.toString();
                k.e(string, "toString(...)");
            } else if (paramsStr.charAt(i10) == '[') {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(paramsStr.charAt(i10));
                while (true) {
                    i10++;
                    if (i10 >= paramsStr.length() || i11 <= 0) {
                        break;
                    }
                    sb2.append(paramsStr.charAt(i10));
                    char cCharAt2 = paramsStr.charAt(i10);
                    if (cCharAt2 == '[') {
                        i11++;
                    } else if (cCharAt2 == ']') {
                        i11--;
                    }
                }
                string = sb2.toString();
                k.e(string, "toString(...)");
            } else {
                StringBuilder sb3 = new StringBuilder();
                while (i10 < paramsStr.length() && paramsStr.charAt(i10) != ',') {
                    sb3.append(paramsStr.charAt(i10));
                    i10++;
                }
                String string2 = sb3.toString();
                k.e(string2, "toString(...)");
                string = m.R0(string2).toString();
            }
            linkedHashMap.put(strSubstring, string);
            i6 = i10;
        }
        return linkedHashMap;
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell
    public List<Message> buildRequestMessage(e session, String imageBase64) {
        k.f(session, "session");
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        arrayList.add(new LlmMessageBuilder().role(MessageRole.SYSTEM).text(t.c0(effectiveSystemPrompt(), "{formatted_date}", a.B(new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault()).format(calendar.getTime()), " ", new String[]{"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"}[(calendar.get(7) + 5) % 7]))).build());
        arrayList.add(new LlmMessageBuilder().role(MessageRole.USER).text(session.b).build());
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
            Message messageBuild = LlmMessageBuilder.imageBase64$default(new LlmMessageBuilder().role(MessageRole.USER), imageBase64, null, 2, null).build();
            arrayList.add(messageBuild);
            this.messageHistory.add(messageBuild);
            this.messagesWithImage.add(messageBuild);
        }
        return arrayList;
    }

    @Override // stepai.aios.guiagent.llm.parser.AbsModelCell
    public Pair<ActionType, Map<String, String>> buildResponseAction(String response, e session) {
        String string;
        String string2;
        k.f(response, "response");
        k.f(session, "session");
        if (!m.s0(response)) {
            this.messageHistory.add(new LlmMessageBuilder().role(MessageRole.ASSISTANT).text(response).build());
            cleanupHistory();
        }
        Matcher matcher = Pattern.compile("<answer>(.*?)</answer>", 32).matcher(response);
        if (matcher.find()) {
            String strGroup = matcher.group(1);
            k.e(strGroup, "group(...)");
            string = m.R0(strGroup).toString();
        } else {
            string = m.R0(response).toString();
        }
        Matcher matcher2 = Pattern.compile("<think>(.*?)</think>", 32).matcher(response);
        if (matcher2.find()) {
            String strGroup2 = matcher2.group(1);
            k.e(strGroup2, "group(...)");
            string2 = m.R0(strGroup2).toString();
        } else {
            string2 = null;
        }
        return parseActionString(string, string2);
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
