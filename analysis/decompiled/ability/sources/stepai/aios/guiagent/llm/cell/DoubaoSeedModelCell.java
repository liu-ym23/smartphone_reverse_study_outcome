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
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import g1.AbstractC1451a;
import j9.l;
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
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import org.json.JSONArray;
import org.json.JSONObject;
import stepai.aios.guiagent.config.Action;
import stepai.aios.guiagent.config.ActionType;
import stepai.aios.guiagent.config.LlmConfig;
import stepai.aios.guiagent.llm.Message;
import stepai.aios.guiagent.llm.MessageContent;
import stepai.aios.guiagent.llm.MessageRole;
import stepai.aios.guiagent.llm.cell.config.ModelCatalog;
import stepai.aios.guiagent.llm.config.LlmMessageBuilder;
import stepai.aios.guiagent.llm.parser.GUIAgentMode;
import stepai.aios.guiagent.llm.parser.IModelCell;
import stepai.aios.guiagent.llm.parser.ModelParam;
import stepai.aios.guiagent.llm.parser.ModelRequestPayload;
import stepai.android.mindx.client.config.ConfigsKt;
import za.e;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 c2\u00020\u0001:\u0001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\"J!\u0010#\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u001fJ#\u0010$\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b$\u0010\u0015J\u0017\u0010&\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010'J\u0019\u0010(\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010'J\u0019\u0010)\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010'J\u0019\u0010*\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010+J\u0019\u0010,\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010+J\u0019\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u00100J+\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006032\u0006\u00102\u001a\u0002012\u0006\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u00105J+\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006032\u0006\u00106\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b7\u00108J3\u0010<\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020;0:2\u0006\u00102\u001a\u0002012\u0006\u00109\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b<\u0010=J-\u0010>\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020;\u0018\u00010:2\u0006\u00102\u001a\u0002012\u0006\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010?J\u001b\u0010C\u001a\u00020B*\u00020@2\u0006\u0010A\u001a\u00020;H\u0002¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020B2\u0006\u0010 \u001a\u00020\u000fH\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\tH\u0002¢\u0006\u0004\bI\u0010\u0003J\u000f\u0010J\u001a\u00020\tH\u0002¢\u0006\u0004\bJ\u0010\u0003R\u001a\u0010K\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010FR\u001a\u0010N\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\bN\u0010L\u001a\u0004\bO\u0010FR\u001c\u0010P\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\bP\u0010L\u001a\u0004\bQ\u0010FR\u001a\u0010R\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\bR\u0010L\u001a\u0004\bS\u0010FR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u000f0T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000f0W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010LR\u0018\u0010[\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010LR\u0018\u0010\\\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010LR\u0014\u0010]\u001a\u00020;8\u0002X\u0082D¢\u0006\u0006\n\u0004\b]\u0010^R\u001c\u0010b\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010a¨\u0006d"}, d2 = {"Lstepai/aios/guiagent/llm/cell/DoubaoSeedModelCell;", "Lstepai/aios/guiagent/llm/parser/IModelCell;", AppAgent.CONSTRUCT, "()V", "Lza/e;", "session", "", "question", "answer", "LC7/r;", "handleInquiry", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)V", "imageBase64", "imageUrl", "", "Lstepai/aios/guiagent/llm/Message;", "generateRequestMessage", "(Lza/e;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "response", "Lstepai/aios/guiagent/config/Action;", "parseActionResponse", "(Ljava/lang/String;Lza/e;)Lstepai/aios/guiagent/config/Action;", "Lstepai/aios/guiagent/llm/parser/ModelParam;", "getModelParam", "()Lstepai/aios/guiagent/llm/parser/ModelParam;", "Landroid/util/Size;", "getCompressBitmapSize", "()Landroid/util/Size;", "task", "openApp", "buildUserPrompt", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "message", "safeLogI", "(Ljava/lang/String;)V", "renderInquiryReplyText", "parseAction", "reason", "buildWaitAction", "(Ljava/lang/String;)Lstepai/aios/guiagent/config/Action;", "parseJsonAction", "parseLegacyAction", "extractJsonObject", "(Ljava/lang/String;)Ljava/lang/String;", "extractLegacyActionLine", "actionName", "Lstepai/aios/guiagent/config/ActionType;", "parseActionType", "(Ljava/lang/String;)Lstepai/aios/guiagent/config/ActionType;", "Lorg/json/JSONObject;", "actionJson", "", "parseJsonParameters", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/util/Map;", "paramsStr", "parseLegacyParameters", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "key", "Lkotlin/Pair;", "", "requireJsonPoint", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Lkotlin/Pair;", "parseOptionalJsonPoint", "(Lorg/json/JSONObject;Ljava/lang/String;)Lkotlin/Pair;", "Lorg/json/JSONArray;", "index", "", "isIntegerValue", "(Lorg/json/JSONArray;I)Z", "generateActionId", "()Ljava/lang/String;", "hasImage", "(Lstepai/aios/guiagent/llm/Message;)Z", "clearCache", "cleanupHistory", "type", "Ljava/lang/String;", "getType", HintConstants.AUTOFILL_HINT_NAME, "getName", "desc", "getDesc", "systemPrompt", "getSystemPrompt", "", "messageHistory", "Ljava/util/List;", "", "messagesWithImage", "Ljava/util/Set;", "currentSessionId", "pendingUserComment", "pendingInquiryQuestion", "maxRoundHistory", "I", "Lstepai/aios/guiagent/llm/parser/GUIAgentMode;", "getSupportedMode", "()Ljava/util/List;", "supportedMode", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DoubaoSeedModelCell implements IModelCell {
    private static final int SCROLL_MAX_OFFSET = 950;
    private static final int SCROLL_MIN_OFFSET = 50;
    private static final int SCROLL_OFFSET = 200;
    private String currentSessionId;
    private volatile String pendingInquiryQuestion;
    private volatile String pendingUserComment;
    private final String type = ModelCatalog.MODEL_CELL_TYPE_DOUBAO_SEED;
    private final String name = "DoubaoSeed";
    private final String desc = "用于豆包seed模型";
    private final String systemPrompt = "你是一个智能体分析专家，可以根据操作历史和当前状态图执行一系列操作来完成任务。\n你必须严格按照要求输出json格式的操作指令。\n\n## 基础设定\n请牢记，手机屏幕坐标系以左上角为原点：\n- x轴向右，取值范围 0-1000\n- y轴向下，取值范围 0-1000\n\n## 行动原则\n\n1. **【最高优先级】App 启动与优先级**：\n   - **强制使用 AWAKE**：启动 App 时，**必须且仅能**使用 `AWAKE` 指令（或系统级启动指令）。**严禁**尝试通过图像识别去寻找并点击桌面上的 App 图标。\n   - **初始截屏是 黑屏时请使用 AWAKE**: 当一个新的任务的第一张截图是**黑屏**时， 请根据任务描述，使用 `AWAKE` 打开app，** 当切仅当第一张截图是黑屏时 使用 ** 。\n   - **Native App 优先**：对于任何指定了 App 名称的任务，**必须优先打开对应的原生 App**，而不是打开浏览器去搜索网页版。\n   - **降级策略**：只有在多次尝试 `AWAKE` 失败，或明确确认未安装该 App 时，才允许降级使用浏览器搜索作为替代方案。\n\n2. **【最高优先级】独立状态验证与异常检测**：\n   - **永远不要假设屏幕状态是静态的或符合预期的**。页面可能会因为弹窗广告、人类意外干预、网络延迟或工程异常而发生突变。\n   - **每次思考的开头，必须独立判断当前页面状态**。\n   - **验证步骤**：\n     1. 检查当前页面是否符合上一步操作后的预期。\n     2. 检查是否存在非预期的干扰元素（如：突然弹出的广告、系统升级弹窗）。\n   - 如果发现异常，必须优先处理异常，而不是盲目继续执行原计划。\n\n4. **重要信息记录（Take Note）**：\n   - **必须善用 Note 字段**。在完成当前步骤的 Explain 之后，你必须检查屏幕上是否有对后续任务有用的关键信息（如：搜索到的具体商品名、价格、订单号、会议时间、联系人姓名等）。\n   - 如果有，**必须**将这些信息提取并记录在 `note` 字段中，以便后续步骤查阅，防止信息丢失。\n\n5. **输入前置条件检查**：\n   - **键盘未唤醒时禁止打字**。如果你想输入文字，首先检查屏幕下方是否有键盘弹起。\n   - 如果没有键盘，你必须先**点击（Tap）目标输入框**，等待键盘唤醒后，再在下一步进行输入操作。\n\n6. **明确操作意图描述**：\n   - 在解释（Explain）或描述你的下一步行动时，**必须明确指出你想点击或操作的具体对象是什么**。\n   - 例如：不要只说“点击坐标 (500, 500)”，而要说“点击‘搜索’按钮”。\n   - 注意：explain是你操作的解释，note是你记录的关键信息。\n\n7. **任务流转与状态重置**：\n   - 在 APP 内部执行任务时，如果某个子任务已经执行完毕，请尽量操作返回到该 APP 的首页/主界面，然后再开始执行下一个子任务。\n\n8. **操作对象锁定**：\n   - 如果输入包含多张屏幕截图，你**必须且只能**基于**最后一张图**（即最新的屏幕状态）进行分析和操作。\n\n9. **操作生效判断（失败检测）**：\n   - 在思考时，必须对比当前截图与上一张截图。\n   - **如果最后两张图完全一样（或高度相似）**，说明上一步操作可能未生效。必须在思考中显式判断并尝试调整策略。\n\n10. **记录追踪**：你需要明确记录自己上一次的 action。如果是滑动操作，连续滑动不能超过 5 次。\n\n11. **指令优先级**：严格遵循用户的指令。如果有多轮对话，优先遵守最后一轮的指令。\n\n12. **安全边界**：绝对禁止给用户直接下单支付。\n\n13. **输出格式要求**：\n    - 输出必须包含“action”字段，且action作为key值，需要有单引号包裹。action:必须使用# Action Space中的动作空间和对应的参数,你注意action需要作为key值，被单引号包括，例如：'action':'CLICK\\tpoint:x,y'\n    - 你必须严格按照要求输出json格式的操作指令。必须严格按照Action Space中的动作空间和对应的参数，不能有任何的修改。\n\n14. **需要用户接管或二次确认场景，这些场景需要输出的动作空间是CALLUSER**：\n    - 涉及到的场景是安全验证是指验证码，人脸识别等操作等，需要输出CALLUSER的动作空间\n    - 支付是需要付款的操作、登录是指APP登录，需要输出CALLUSER的动作空间\n    - 黑屏是指你看到的手机截图是黑屏，无法进行当前界面的理解，无法给出具体的操作，需要输出CALLUSER的动作空间\n    - 选择素材是剪映APP的，点击开始创作以后，进入素材选择界面，需要输出CALLUSER的动作空间\n    - 首启授权是指APP首次使用，需要用户授予一些权限，比如位置、相机、存储，隐私协议，服务协议等，需要输出CALLUSER的动作空间\n    - 需要删除东西时，无论是删除手机上的照片、视频、文件、联系人、短信等，还是删除APP中的帖子、消息等，需要输出CALLUSER的动作空间\n\n## Action Space操作指令及其作用如下：\n- `{\"explain\" : \"\", \"note\":\"\", \"action\" : \"AWAKE\", \"value\": \"xx\"}`\nAWAKE是启动目标app的操作。启动APP只能使用AWAKE实现。\n- {\"explain\":\"\",\"action\":\"LONGPRESS\",\"point\":[x,y]}\nLONGPRESS是长按操作，可用于触发上下文菜单、选择文本或激活长按交互。\n- {\"explain\":\"\",\"action\":\"CLICK\",\"point\":[x,y]}\nCLICK是点击操作，可用于与任何可点击的用户界面元素进行交互。\n- {\"explain\":\"\",\"action\":\"SLIDE\",\"point1\":[x1,y1],\"point2\":[x2,y2]}\nSLIDE是长按拖拽操作，通过从起始坐标point1拖动到结束坐标point2来执行移动物体的动作。\n- {\"explain\":\"\",\"action\":\"TYPE\",\"point\":[x,y],\"value\":\"xx\"}\nTYPE是输入文本的操作，在当前聚焦的输入框中输入文本。\n- `{\"explain\" : \"\", \"note\":\"\", \"action\" : \"WAIT\", \"value\": \"xx\"}`\nWAIT是等待页面加载完成或者等待广告倒计时结束，value表示等待的秒数，遇到广告时优先进行等待。\n- `{\"explain\" : \"\", \"note\":\"\", \"action\" : \"CALLUSER\", \"value\": \"xx\",tag:\"安全验证/支付/登录/黑屏/选择素材/首启授权\"}`\nCALLUSER是交给用户操作，需要在当前页面用户直接操作，涉及到的场景是安全验证是指验证码，人脸识别等操作、支付是需要付款的操作、登录是指APP登录、黑屏是指你看到的手机截图是黑屏，无法进行当前界面的理解，无法给出具体的操作，选择素材是剪映APP的，其他APP不涉及、首启授权是指APP首次使用，需要用户授予一些权限，比如位置、相机、存储，或需要删除用户数据等。\n- {\"explain\" : \"\", \"note\":\"\", \"action\" : \"HOME\"}\nHOME是返回到首页。\n- {\"explain\":\"\",\"action\":\"BACK\"}\nBACK是返回到上一页。\n- {\"explain\":\"\",\"action\":\"SCROLL\",\"point\":[x,y],\"direction\":\"left/right/up/down\"}\nSCROLL是页面滑动操作，可用于控制页面向direction方向滑动。direction只能是left、right、up、down之一。\n- {\"explain\":\"\",\"action\":\"INFO\",\"value\":\"xx\"}\nINFO是当有多个满足条件的选项时而触发的交互操作，询问用户如何选择。用户未指定使用什么app时，也要进行询问。\n- {\"explain\" : \"\", \"action\" : \"CALLUSER\", \"value\": \"xx\"}\nCALLUSER是交给用户操作，需要在当前页面用户直接操作，涉及到的场景是安全验证是指验证码，人脸识别等操作、支付是需要付款的操作、登录是指APP登录、黑屏是指你看到的手机截图是黑屏，无法进行当前界面的理解，无法给出具体的操作，选择素材是剪映APP的，其他APP不涉及、首启授权是指APP首次使用，需要用户授予一些权限，比如位置、相机、存储等。\n- {\"explain\":\"\",\"action\":\"COMPLETE\",\"return\":\"xx\"}\nCOMPLETE是结束任务的操作，表示准确完整完成任务。以及如下场景：\n    需要登录才能继续操作，但当前未登录或登录已过期。\n    遇到验证码（图形验证码、滑块验证码等）需要人工验证。\n    搜索或查找操作未找到符合条件的结果。\n    任务需要蓝牙连接，但设备未连接或连接失败。\n    网络连接失败、超时或无法访问服务器。\n    需要支付验证（如密码、指纹等）才能完成支付操作。\n    任务本身无法完成，例如任务要求不明确、逻辑矛盾或超出能力范围。\n    重复执行相同操作多次仍无法达到预期效果，可能陷入死循环。\n    需要用户授予特定权限（如位置、相机、存储等）才能继续。\n    需要输入密码但无法自动获取或输入。\n    用户主动接管操作或要求退出任务。\n    临时需要人工介入处理，但后续可能可以继续自动化执行。\n    需要人工验证或确认才能继续，如身份验证、二次确认等。\n\n注意：\n1. explain是你操作的解释。\n2. 所有操作的point都是相对坐标（整数），取值范围为[0,1000]，左上角为(0,0)，右下角为(1000,1000)。\n3. 你只能输出一个json对象，不要输出markdown，不要输出代码块，不要输出额外说明文字。\n4. action字段只能从以下集合中选择：AWAKE、LONGPRESS、CLICK、SLIDE、TYPE、WAIT、HOME、CALLUSER、SCROLL、BACK、INFO、COMPLETE。";
    private final List<Message> messageHistory = new ArrayList();
    private final Set<Message> messagesWithImage = new LinkedHashSet();
    private final int maxRoundHistory = 3;

    private final String buildUserPrompt(String task, String openApp) {
        return openApp == null ? a.k("用户的任务：\n", task) : a.n("用户的任务：\n", task, " \n app：", openApp);
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
        this.pendingUserComment = null;
        this.pendingInquiryQuestion = null;
    }

    private final String extractJsonObject(String response) {
        String str;
        String string;
        String string2 = m.R0(response).toString();
        if (m.s0(string2)) {
            return null;
        }
        RegexOption[] regexOptionArr = RegexOption.f5170a;
        Pattern patternCompile = Pattern.compile("```(?:json)?\\s*([\\s\\S]*?)\\s*```", 66);
        k.e(patternCompile, "compile(...)");
        l lVarB = new Regex(patternCompile).b(string2);
        if (lVarB != null && (str = (String) v.D0(1, lVarB.a())) != null && (string = m.R0(str).toString()) != null) {
            string2 = string;
        }
        int iP0 = m.p0(string2, '{', 0, 6);
        if (iP0 < 0) {
            return null;
        }
        int length = string2.length();
        boolean z10 = false;
        boolean z11 = false;
        int i = 0;
        for (int i6 = iP0; i6 < length; i6++) {
            char cCharAt = string2.charAt(i6);
            if (z10) {
                z10 = false;
            } else if (cCharAt == '\\') {
                z10 = true;
            } else if (cCharAt == '\"') {
                z11 = !z11;
            } else if (z11) {
                continue;
            } else {
                if (cCharAt == '{') {
                    i++;
                }
                if (cCharAt == '}' && i - 1 == 0) {
                    String strSubstring = string2.substring(iP0, i6 + 1);
                    k.e(strSubstring, "substring(...)");
                    return strSubstring;
                }
            }
        }
        return null;
    }

    private final String extractLegacyActionLine(String response) {
        Iterator it = m.w0(response).iterator();
        while (it.hasNext()) {
            String string = m.R0((String) it.next()).toString();
            if (t.e0(string, "Action:", true)) {
                return m.R0(m.H0(string, "Action:", string)).toString();
            }
        }
        return null;
    }

    private final String generateActionId() {
        return "action_" + System.currentTimeMillis() + "_" + AbstractC1451a.R(c.f1492a, new f(0, 999, 1));
    }

    private final boolean hasImage(Message message) {
        if (this.messagesWithImage.contains(message)) {
            return true;
        }
        List<MessageContent> content = message.getContent();
        if ((content instanceof Collection) && content.isEmpty()) {
            return false;
        }
        for (MessageContent messageContent : content) {
            if ((messageContent instanceof MessageContent.ImageBase64) || (messageContent instanceof MessageContent.Image)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isIntegerValue(JSONArray jSONArray, int i) {
        Object objOpt;
        if (i < 0 || i >= jSONArray.length() || (objOpt = jSONArray.opt(i)) == null) {
            return false;
        }
        return (objOpt instanceof Integer) || (objOpt instanceof Long);
    }

    private final Action parseAction(String response, e session) {
        try {
            Action jsonAction = parseJsonAction(response);
            if (jsonAction != null) {
                return jsonAction;
            }
            Action legacyAction = parseLegacyAction(response);
            if (legacyAction != null) {
                return legacyAction;
            }
            return buildWaitAction("未能解析响应, response=" + response);
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
                if (!lowerCase.equals("scroll")) {
                    return null;
                }
                return ActionType.SWIPE;
            case -673660814:
                if (!lowerCase.equals("finished")) {
                    return null;
                }
                return ActionType.COMPLETE;
            case -599445191:
                if (!lowerCase.equals("complete")) {
                    return null;
                }
                return ActionType.COMPLETE;
            case -504325460:
                if (!lowerCase.equals("open_app")) {
                    return null;
                }
                return ActionType.AWAKE;
            case -326696768:
                if (!lowerCase.equals("long_press")) {
                    return null;
                }
                return ActionType.CLICK;
            case -171636951:
                if (lowerCase.equals("calluser")) {
                    return ActionType.TAKEOVER;
                }
                return null;
            case 3015911:
                if (!lowerCase.equals("back")) {
                    return null;
                }
                return ActionType.BACK;
            case 3091764:
                if (!lowerCase.equals("drag")) {
                    return null;
                }
                return ActionType.SWIPE;
            case 3208415:
                if (!lowerCase.equals("home")) {
                    return null;
                }
                return ActionType.HOME;
            case 3237038:
                if (lowerCase.equals("info")) {
                    return ActionType.INQUIRY;
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
            case 93223301:
                if (!lowerCase.equals("awake")) {
                    return null;
                }
                return ActionType.AWAKE;
            case 94750088:
                if (lowerCase.equals(RequestInfo.FUNCTION_CLICK)) {
                    return ActionType.CLICK;
                }
                return null;
            case 109526449:
                if (!lowerCase.equals("slide")) {
                    return null;
                }
                return ActionType.SWIPE;
            case 143756103:
                if (!lowerCase.equals("longpress")) {
                    return null;
                }
                return ActionType.CLICK;
            case 1103194724:
                if (lowerCase.equals("longpressanddrag")) {
                    return ActionType.SWIPE;
                }
                return null;
            case 1870941027:
                if (!lowerCase.equals("press_back")) {
                    return null;
                }
                return ActionType.BACK;
            case 1871133531:
                if (!lowerCase.equals("press_home")) {
                    return null;
                }
                return ActionType.HOME;
            default:
                return null;
        }
    }

    private final Action parseJsonAction(String response) {
        String strExtractJsonObject = extractJsonObject(response);
        if (strExtractJsonObject == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(strExtractJsonObject);
        String strOptString = jSONObject.optString(GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION);
        k.e(strOptString, "optString(...)");
        String string = m.R0(strOptString).toString();
        if (m.s0(string)) {
            return buildWaitAction(a.k("JSON中缺少action字段, response=", response));
        }
        ActionType actionType = parseActionType(string);
        if (actionType == null) {
            return buildWaitAction("未知JSON actionType, actionName=".concat(string));
        }
        LinkedHashMap linkedHashMapA0 = kotlin.collections.a.a0(parseJsonParameters(jSONObject, string));
        linkedHashMapA0.put(AgentBusWakeContract.EXTRA_SOURCE, "llm");
        return new Action(generateActionId(), actionType, linkedHashMapA0, null, 0L, null, 56, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0315  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.Map<java.lang.String, java.lang.String> parseJsonParameters(org.json.JSONObject r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 870
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.DoubaoSeedModelCell.parseJsonParameters(org.json.JSONObject, java.lang.String):java.util.Map");
    }

    private final Action parseLegacyAction(String response) {
        l lVarB;
        String strExtractLegacyActionLine = extractLegacyActionLine(response);
        if (strExtractLegacyActionLine == null || (lVarB = new Regex("(\\w+)\\((.*?)\\)").b(strExtractLegacyActionLine)) == null) {
            return null;
        }
        String str = (String) ((K) lVarB.a()).get(1);
        String str2 = (String) ((K) lVarB.a()).get(2);
        ActionType actionType = parseActionType(str);
        if (actionType == null) {
            return buildWaitAction(a.k("未知legacy actionType, actionName=", str));
        }
        LinkedHashMap linkedHashMapA0 = kotlin.collections.a.a0(parseLegacyParameters(str2, str));
        linkedHashMapA0.put(AgentBusWakeContract.EXTRA_SOURCE, "llm");
        return new Action(generateActionId(), actionType, linkedHashMapA0, null, 0L, null, 56, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.Map<java.lang.String, java.lang.String> parseLegacyParameters(java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 864
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.DoubaoSeedModelCell.parseLegacyParameters(java.lang.String, java.lang.String):java.util.Map");
    }

    private final Pair<Integer, Integer> parseOptionalJsonPoint(JSONObject actionJson, String key) {
        JSONArray jSONArrayOptJSONArray;
        if (!actionJson.has(key) || actionJson.isNull(key) || (jSONArrayOptJSONArray = actionJson.optJSONArray(key)) == null || jSONArrayOptJSONArray.length() < 2 || !isIntegerValue(jSONArrayOptJSONArray, 0) || !isIntegerValue(jSONArrayOptJSONArray, 1)) {
            return null;
        }
        return new Pair<>(Integer.valueOf(jSONArrayOptJSONArray.getInt(0)), Integer.valueOf(jSONArrayOptJSONArray.getInt(1)));
    }

    private final String renderInquiryReplyText(String question, String answer) {
        String string = question != null ? m.R0(question).toString() : null;
        return ((string == null || string.length() == 0) ? "" : a.m("针对你的问题：", string, "\n")) + "用户回复说：\n---------\n" + answer + "\n---------\n用户回复结束";
    }

    private final Pair<Integer, Integer> requireJsonPoint(JSONObject actionJson, String key, String actionName) {
        Pair<Integer, Integer> optionalJsonPoint = parseOptionalJsonPoint(actionJson, key);
        if (optionalJsonPoint != null) {
            return optionalJsonPoint;
        }
        throw new IllegalArgumentException(androidx.appfunctions.metadata.a.m("[", actionName, "] ", key, " is not valid"));
    }

    private final void safeLogI(String message) {
        try {
            j.H(message, ConfigsKt.TAG);
        } catch (Throwable th) {
            kotlin.b.a(th);
        }
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
    public void handleInquiry(e session, String question, String answer) {
        String str;
        String string;
        if (session == null || (str = session.f7004a) == null) {
            return;
        }
        if (answer == null) {
            safeLogI(a.m("handleInquiry: null answer for session=", str, ", skip"));
            return;
        }
        String str2 = this.currentSessionId;
        if (str2 != null && !k.b(str2, str)) {
            clearCache();
        }
        this.currentSessionId = str;
        String string2 = m.R0(answer).toString();
        if (string2.length() == 0) {
            safeLogI(a.m("handleInquiry: blank answer for session=", str, ", skip"));
            return;
        }
        this.pendingUserComment = string2;
        if (question == null || (string = m.R0(question).toString()) == null || string.length() <= 0) {
            string = null;
        }
        this.pendingInquiryQuestion = string;
        safeLogI(a.q(androidx.appfunctions.metadata.a.t(string2.length(), "handleInquiry: pendingUserComment set (session=", str, ", len=", ", question="), question != null ? m.N0(40, question) : null, ")"));
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ void injectExperienceAction(String str, String str2, List<Integer> list, String str3, String str4) {
        super.injectExperienceAction(str, str2, list, str3, str4);
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public Action parseActionResponse(String response, e session) {
        k.f(response, "response");
        if (!m.s0(response)) {
            this.messageHistory.add(new LlmMessageBuilder().role(MessageRole.ASSISTANT).text(response).build());
        }
        return parseAction(response, session);
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
        arrayList.add(new LlmMessageBuilder().role(MessageRole.SYSTEM).text(effectiveSystemPrompt()).build());
        arrayList.add(new LlmMessageBuilder().role(MessageRole.USER).text(buildUserPrompt(session.b, session.c)).build());
        List<Message> list = this.messageHistory;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            Message message = (Message) obj;
            if (message.getRole() == MessageRole.USER && hasImage(message)) {
                arrayList2.add(obj);
            }
        }
        List<Message> list2 = this.messageHistory;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list2) {
            if (((Message) obj2).getRole() == MessageRole.ASSISTANT) {
                arrayList3.add(obj2);
            }
        }
        boolean z10 = true;
        int size = (arrayList2.size() + (((imageUrl == null || m.s0(imageUrl)) && (imageBase64 == null || m.s0(imageBase64))) ? 0 : 1)) - this.maxRoundHistory;
        if (size < 0) {
            size = 0;
        }
        int i = 0;
        for (Object obj3 : arrayList3) {
            int i6 = i + 1;
            if (i < 0) {
                o.X();
                throw null;
            }
            Message message2 = (Message) obj3;
            if (i < arrayList2.size() && i >= size) {
                arrayList.add(arrayList2.get(i));
            }
            arrayList.add(message2);
            i = i6;
        }
        boolean z11 = imageUrl == null || m.s0(imageUrl);
        if (imageBase64 != null && !m.s0(imageBase64)) {
            z10 = false;
        }
        if (z11 && z10) {
            return arrayList;
        }
        String str3 = this.pendingUserComment;
        String str4 = this.pendingInquiryQuestion;
        LlmMessageBuilder llmMessageBuilderRole = new LlmMessageBuilder().role(MessageRole.USER);
        if (str3 != null && str3.length() != 0) {
            llmMessageBuilderRole.text(renderInquiryReplyText(str4, str3));
        }
        if (!z11) {
            k.c(imageUrl);
            llmMessageBuilderRole.image(imageUrl);
        } else if (!z10) {
            k.c(imageBase64);
            LlmMessageBuilder.imageBase64$default(llmMessageBuilderRole, imageBase64, null, 2, null);
        }
        Message messageBuild = llmMessageBuilderRole.build();
        arrayList.add(messageBuild);
        this.messageHistory.add(messageBuild);
        this.messagesWithImage.add(messageBuild);
        if (str3 != null && str3.length() != 0) {
            safeLogI(androidx.appfunctions.metadata.a.i(str3.length(), "generateRequestMessage: consumed pendingUserComment (len=", ")"));
            this.pendingUserComment = null;
            this.pendingInquiryQuestion = null;
        }
        return arrayList;
    }

    @Override // stepai.aios.guiagent.llm.parser.IModelCell
    public /* bridge */ ModelRequestPayload generateRequestPayload(e eVar, String str, String str2) {
        return super.generateRequestPayload(eVar, str, str2);
    }
}
