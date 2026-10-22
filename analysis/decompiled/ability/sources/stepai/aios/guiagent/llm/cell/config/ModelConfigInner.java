package stepai.aios.guiagent.llm.cell.config;

import D7.v;
import D7.w;
import N9.j;
import S7.a;
import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.ExecutionBundle;
import com.tencent.mmkv.MMKV;
import io.modelcontextprotocol.spec.McpSchema;
import j9.m;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;
import stepai.aios.guiagent.config.AgentConfig;
import stepai.aios.guiagent.config.LlmConfig;
import stepai.aios.guiagent.llm.LlmService;
import stepai.aios.guiagent.llm.StepService;
import stepai.aios.guiagent.llm.local.LocalLlmService;
import stepai.aios.guiagent.llm.parser.IModelCell;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010\"\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0012J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u001cH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u001b\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0 H\u0016¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\u001cH\u0016¢\u0006\u0004\b#\u0010\u001eJ\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b'\u0010\u001bJ\u0017\u0010(\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b(\u0010\u001bJ\u0017\u0010*\u001a\u00020\r2\u0006\u0010)\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010\u0012J\u001f\u0010+\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b+\u0010,J'\u0010.\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u0019H\u0002¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b0\u0010\u0010J\u0017\u00101\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u0010\u0003J\u000f\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u0010\u0003J\u0017\u00105\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b5\u0010\u001bJ!\u00108\u001a\u0002062\u0006\u0010\n\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u000106H\u0002¢\u0006\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010;R\u0014\u0010=\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u0010;R\u0014\u0010>\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u0010;R\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020\t0\u001c8\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u001eR\u0017\u0010B\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\bB\u0010;\u001a\u0004\bC\u0010DR\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020E0\u001c8\u0006¢\u0006\f\n\u0004\bF\u0010@\u001a\u0004\bG\u0010\u001eR(\u0010I\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0H\u0012\u0004\u0012\u00020\t0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR&\u0010L\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0K0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010JR&\u0010M\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0K0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR \u0010T\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010JR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\t0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR$\u0010Y\u001a\u00020\t2\u0006\u0010X\u001a\u00020\t8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bY\u0010;\u001a\u0004\bZ\u0010DR$\u0010[\u001a\u00020\r2\u0006\u0010X\u001a\u00020\r8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u0018\u0010_\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`¨\u0006a"}, d2 = {"Lstepai/aios/guiagent/llm/cell/config/ModelConfigInner;", "Lstepai/aios/guiagent/llm/cell/config/IModelConfig;", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "LC7/r;", McpSchema.METHOD_INITIALIZE, "(Landroid/content/Context;)V", "", "modelId", "setCurrentModel", "(Ljava/lang/String;)V", "Lstepai/aios/guiagent/llm/parser/IModelCell;", "modelCell", "addModel", "(Ljava/lang/String;Lstepai/aios/guiagent/llm/parser/IModelCell;)V", "getModelCellByModelId", "(Ljava/lang/String;)Lstepai/aios/guiagent/llm/parser/IModelCell;", "resolveModelCellForTask", "Lstepai/aios/guiagent/config/LlmConfig;", "baseLlmConfig", "resolveLlmConfigForTask", "(Ljava/lang/String;Lstepai/aios/guiagent/config/LlmConfig;)Lstepai/aios/guiagent/config/LlmConfig;", "getModelCellByModelCellType", "", "hasModel", "(Ljava/lang/String;)Z", "", "getAllModelIds", "()Ljava/util/List;", "getAllModelCellTypes", "", "getAllConfiguredModels", "()Ljava/util/Map;", "getAllModelCells", "", "removeAllCustomModels", "()I", "removeCustomModelsById", "isCustomModel", "modelCellType", "createModelCellByType", "updateModelCell", "(Ljava/lang/String;Lstepai/aios/guiagent/llm/parser/IModelCell;)Z", "persist", "applyCurrentModel", "(Ljava/lang/String;Lstepai/aios/guiagent/llm/parser/IModelCell;Z)V", "applyModelCellToRuntime", "getModelCellTypeName", "(Lstepai/aios/guiagent/llm/parser/IModelCell;)Ljava/lang/String;", "saveToPreferences", "loadFromPreferences", "isLocalModel", "Lstepai/aios/guiagent/llm/LlmService;", "currentService", "resolveLlmService", "(Ljava/lang/String;Lstepai/aios/guiagent/llm/LlmService;)Lstepai/aios/guiagent/llm/LlmService;", "TAG", "Ljava/lang/String;", "PREFS_NAME", "KEY_CURRENT_MODEL_ID", "KEY_MODEL_MAP", "MODEL_OPTIONS", "Ljava/util/List;", "getMODEL_OPTIONS", "DEFAULT_STEP_NET_MODEL", "getDEFAULT_STEP_NET_MODEL", "()Ljava/lang/String;", "Lstepai/aios/guiagent/llm/cell/config/ModelCellOption;", "MODEL_CELL_OPTIONS", "getMODEL_CELL_OPTIONS", "Ljava/lang/Class;", "modelCellTypeNameMap", "Ljava/util/Map;", "Lkotlin/Function0;", "modelCellTypeFactoryMap", "modelIdToModelCellFactoryMap", "Lcom/tencent/mmkv/MMKV;", "mmkv", "Lcom/tencent/mmkv/MMKV;", "initialized", "Z", "", "modelCellMap", "", "defaultModelIds", "Ljava/util/Set;", "value", "currentModelId", "getCurrentModelId", "currentModelCell", "Lstepai/aios/guiagent/llm/parser/IModelCell;", "getCurrentModelCell", "()Lstepai/aios/guiagent/llm/parser/IModelCell;", "savedNetworkService", "Lstepai/aios/guiagent/llm/LlmService;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ModelConfigInner implements IModelConfig {
    private static final String DEFAULT_STEP_NET_MODEL;
    public static final ModelConfigInner INSTANCE = new ModelConfigInner();
    private static final String KEY_CURRENT_MODEL_ID = "current_model_id";
    private static final String KEY_MODEL_MAP = "model_map";
    private static final List<ModelCellOption> MODEL_CELL_OPTIONS;
    private static final List<String> MODEL_OPTIONS;
    private static final String PREFS_NAME = "model_config_prefs";
    private static final String TAG = "ModelConfig";
    private static IModelCell currentModelCell;
    private static String currentModelId;
    private static final Set<String> defaultModelIds;
    private static boolean initialized;
    private static MMKV mmkv;
    private static final Map<String, IModelCell> modelCellMap;
    private static final Map<String, a> modelCellTypeFactoryMap;
    private static final Map<Class<? extends IModelCell>, String> modelCellTypeNameMap;
    private static final Map<String, a> modelIdToModelCellFactoryMap;
    private static volatile LlmService savedNetworkService;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        ModelCatalog modelCatalog = ModelCatalog.INSTANCE;
        List<String> model_options = modelCatalog.getMODEL_OPTIONS();
        MODEL_OPTIONS = model_options;
        DEFAULT_STEP_NET_MODEL = modelCatalog.getDEFAULT_MODEL_ID();
        MODEL_CELL_OPTIONS = modelCatalog.getMODEL_CELL_OPTIONS();
        modelCellTypeNameMap = modelCatalog.getModelCellTypeNameMap();
        modelCellTypeFactoryMap = modelCatalog.getModelCellTypeFactoryMap();
        Map<String, a> modelIdToModelCellFactoryMap2 = modelCatalog.getModelIdToModelCellFactoryMap();
        modelIdToModelCellFactoryMap = modelIdToModelCellFactoryMap2;
        modelCellMap = new LinkedHashMap();
        defaultModelIds = v.j1(model_options);
        for (Map.Entry<String, a> entry : modelIdToModelCellFactoryMap2.entrySet()) {
            modelCellMap.put(entry.getKey(), entry.getValue().invoke());
        }
        String str = DEFAULT_STEP_NET_MODEL;
        currentModelId = str;
        IModelCell iModelCell = modelCellMap.get(str);
        if (iModelCell == null) {
            throw new IllegalStateException(B7.a.k("默认模型cell不存在,", str));
        }
        currentModelCell = iModelCell;
    }

    private ModelConfigInner() {
    }

    private final void applyCurrentModel(String modelId, IModelCell modelCell, boolean persist) throws JSONException {
        currentModelId = modelId;
        currentModelCell = modelCell;
        modelCellMap.put(modelId, modelCell);
        AgentConfig.INSTANCE.setGUI_LLM_MODEL_ID(modelId);
        if (initialized) {
            applyModelCellToRuntime(modelId, modelCell);
        } else {
            j.H("GuiAgent 未初始化，暂不应用 ModelCell，稍后由初始化流程接管", TAG);
        }
        if (persist) {
            saveToPreferences();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void applyModelCellToRuntime(java.lang.String r13, stepai.aios.guiagent.llm.parser.IModelCell r14) {
        /*
            r12 = this;
            stepai.aios.guiagent.runtime.a r0 = ua.C2052a.c     // Catch: java.lang.Throwable -> L50
            if (r0 == 0) goto L53
            stepai.aios.guiagent.config.RuntimeConfig r1 = r0.f6128a     // Catch: java.lang.Throwable -> L50
            stepai.aios.guiagent.config.LlmConfig r2 = r1.getLlmConfig()     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L11
            stepai.aios.guiagent.llm.LlmService r3 = r2.getLlmService()     // Catch: java.lang.Throwable -> L50
            goto L12
        L11:
            r3 = 0
        L12:
            stepai.aios.guiagent.llm.LlmService r3 = r12.resolveLlmService(r13, r3)     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L28
            r8 = 18
            r9 = 0
            r4 = 0
            r7 = 0
            r5 = r13
            r6 = r14
            stepai.aios.guiagent.config.LlmConfig r12 = stepai.aios.guiagent.config.LlmConfig.copy$default(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L50
            if (r12 != 0) goto L26
            goto L2a
        L26:
            r5 = r12
            goto L3e
        L28:
            r5 = r13
            r6 = r14
        L2a:
            stepai.aios.guiagent.config.LlmConfig r4 = new stepai.aios.guiagent.config.LlmConfig     // Catch: java.lang.Throwable -> L50
            r8 = r6
            t5.a r6 = new t5.a     // Catch: java.lang.Throwable -> L50
            r12 = 24
            r6.<init>(r12)     // Catch: java.lang.Throwable -> L50
            r10 = 16
            r11 = 0
            r9 = 0
            r7 = r5
            r5 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L50
            r5 = r4
        L3e:
            r8 = 55
            r9 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            stepai.aios.guiagent.config.RuntimeConfig r12 = stepai.aios.guiagent.config.RuntimeConfig.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L50
            r0.p(r12)     // Catch: java.lang.Throwable -> L50
            C7.r r12 = C7.r.f317a     // Catch: java.lang.Throwable -> L50
            goto L5f
        L50:
            r0 = move-exception
            r12 = r0
            goto L5b
        L53:
            java.lang.String r12 = "GuiAgentManager is not initialized"
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L50
            r13.<init>(r12)     // Catch: java.lang.Throwable -> L50
            throw r13     // Catch: java.lang.Throwable -> L50
        L5b:
            kotlin.Result$Failure r12 = kotlin.b.a(r12)
        L5f:
            java.lang.Throwable r12 = kotlin.Result.a(r12)
            if (r12 == 0) goto L70
            java.lang.String r12 = r12.getMessage()
            java.lang.String r13 = "更新 GuiAgent 模型失败: "
            java.lang.String r14 = "ModelConfig"
            com.stepos.statsrpk.service.c.n(r13, r12, r14)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.llm.cell.config.ModelConfigInner.applyModelCellToRuntime(java.lang.String, stepai.aios.guiagent.llm.parser.IModelCell):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap applyModelCellToRuntime$lambda$0$0(Bitmap it) {
        k.f(it, "it");
        return it;
    }

    private final String getModelCellTypeName(IModelCell modelCell) {
        String str = modelCellTypeNameMap.get(modelCell.getClass());
        return str == null ? ModelCatalog.MODEL_CELL_TYPE_STEP_PLAN_TREE : str;
    }

    private final boolean isLocalModel(String modelId) {
        return k.b(modelId, "local-vlm") || m.h0(modelId, ExecutionBundle.PREF_LOCAL, true);
    }

    private final void loadFromPreferences() throws JSONException {
        MMKV mmkv2 = mmkv;
        if (mmkv2 == null) {
            j.G("加载失败: MMKV 未初始化", TAG);
            return;
        }
        String strDecodeString = mmkv2.decodeString(KEY_MODEL_MAP, null);
        j.H("从持久化加载模型配置，JSON: " + strDecodeString, TAG);
        if (strDecodeString == null || strDecodeString.length() <= 0 || strDecodeString.equals("{}")) {
            j.H("没有保存的自定义模型配置", TAG);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(strDecodeString);
                Iterator<String> itKeys = jSONObject.keys();
                int i = 0;
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (defaultModelIds.contains(next)) {
                        j.H("跳过默认模型: " + next, TAG);
                    } else {
                        String string = jSONObject.getString(next);
                        k.c(string);
                        modelCellMap.put(next, createModelCellByType(string));
                        i++;
                        j.H("加载自定义模型: " + next + " -> " + string, TAG);
                    }
                }
                j.H("成功加载 " + i + " 个自定义模型", TAG);
            } catch (Exception e) {
                j.G("加载模型配置失败: " + e.getMessage(), TAG);
                e.printStackTrace();
            }
        }
        String strDecodeString2 = mmkv2.decodeString(KEY_CURRENT_MODEL_ID, null);
        j.H("从持久化加载当前模型 ID: " + strDecodeString2, TAG);
        if (strDecodeString2 != null) {
            Map<String, IModelCell> map = modelCellMap;
            if (map.containsKey(strDecodeString2)) {
                IModelCell iModelCell = map.get(strDecodeString2);
                k.c(iModelCell);
                applyCurrentModel(strDecodeString2, iModelCell, false);
                j.H("成功恢复当前模型: " + getCurrentModelId() + ",cell:" + getCurrentModelCell().getName(), TAG);
                return;
            }
        }
        if (strDecodeString2 != null) {
            j.G("保存的模型 ID " + strDecodeString2 + " 在 Map 中不存在，使用默认模型", TAG);
        }
    }

    private final LlmService resolveLlmService(String modelId, LlmService currentService) {
        if (isLocalModel(modelId)) {
            if (currentService != null && !(currentService instanceof LocalLlmService)) {
                savedNetworkService = currentService;
            }
            LocalLlmService localLlmService = currentService instanceof LocalLlmService ? (LocalLlmService) currentService : null;
            return localLlmService == null ? new LocalLlmService() : localLlmService;
        }
        if (currentService != null && !(currentService instanceof LocalLlmService)) {
            return currentService;
        }
        LlmService llmService = savedNetworkService;
        return llmService == null ? new StepService() : llmService;
    }

    private final void saveToPreferences() throws JSONException {
        MMKV mmkv2 = mmkv;
        if (mmkv2 == null) {
            j.G("保存失败: MMKV 未初始化", TAG);
            return;
        }
        mmkv2.encode(KEY_CURRENT_MODEL_ID, getCurrentModelId());
        j.H("保存当前模型 ID: " + getCurrentModelId(), TAG);
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        for (Map.Entry<String, IModelCell> entry : modelCellMap.entrySet()) {
            String key = entry.getKey();
            IModelCell value = entry.getValue();
            if (!defaultModelIds.contains(key)) {
                String modelCellTypeName = INSTANCE.getModelCellTypeName(value);
                jSONObject.put(key, modelCellTypeName);
                i++;
                j.H("保存自定义模型: " + key + " -> " + modelCellTypeName, TAG);
            }
        }
        mmkv2.encode(KEY_MODEL_MAP, jSONObject.toString());
        j.H("配置保存成功，自定义模型数量: " + i, TAG);
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public void addModel(String modelId, IModelCell modelCell) throws JSONException {
        k.f(modelId, "modelId");
        k.f(modelCell, "modelCell");
        Map<String, IModelCell> map = modelCellMap;
        if (map.containsKey(modelId)) {
            j.G("addModel 失败：modelId 已存在：".concat(modelId), TAG);
        } else {
            map.put(modelId, modelCell);
            saveToPreferences();
        }
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public IModelCell createModelCellByType(String modelCellType) {
        IModelCell iModelCell;
        k.f(modelCellType, "modelCellType");
        a aVar = modelCellTypeFactoryMap.get(modelCellType);
        return (aVar == null || (iModelCell = (IModelCell) aVar.invoke()) == null) ? (IModelCell) ModelCatalog.INSTANCE.inferModelCellFactoryByModelId(DEFAULT_STEP_NET_MODEL).invoke() : iModelCell;
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public Map<String, IModelCell> getAllConfiguredModels() {
        return kotlin.collections.a.Y(modelCellMap);
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public List<String> getAllModelCellTypes() {
        List<IModelCell> allModelCells = getAllModelCells();
        ArrayList arrayList = new ArrayList(w.c0(allModelCells, 10));
        Iterator<T> it = allModelCells.iterator();
        while (it.hasNext()) {
            arrayList.add(((IModelCell) it.next()).getType());
        }
        return arrayList;
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public List<IModelCell> getAllModelCells() {
        List listZ0 = v.Z0(modelCellMap.entrySet(), new Comparator() { // from class: stepai.aios.guiagent.llm.cell.config.ModelConfigInner$getAllModelCells$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t9, T t10) {
                return j.m((String) ((Map.Entry) t9).getKey(), (String) ((Map.Entry) t10).getKey());
            }
        });
        ArrayList arrayList = new ArrayList(w.c0(listZ0, 10));
        Iterator it = listZ0.iterator();
        while (it.hasNext()) {
            arrayList.add((IModelCell) ((Map.Entry) it.next()).getValue());
        }
        return v.v0(arrayList);
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public List<String> getAllModelIds() {
        return v.Y0(v.f1(modelCellMap.keySet()));
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public IModelCell getCurrentModelCell() {
        return currentModelCell;
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public String getCurrentModelId() {
        return currentModelId;
    }

    public final String getDEFAULT_STEP_NET_MODEL() {
        return DEFAULT_STEP_NET_MODEL;
    }

    public final List<ModelCellOption> getMODEL_CELL_OPTIONS() {
        return MODEL_CELL_OPTIONS;
    }

    public final List<String> getMODEL_OPTIONS() {
        return MODEL_OPTIONS;
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public IModelCell getModelCellByModelCellType(String modelId) {
        k.f(modelId, "modelId");
        for (IModelCell iModelCell : getAllModelCells()) {
            if (k.b(iModelCell.getType(), modelId)) {
                return iModelCell;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public IModelCell getModelCellByModelId(String modelId) {
        k.f(modelId, "modelId");
        return modelCellMap.get(modelId);
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public boolean hasModel(String modelId) {
        k.f(modelId, "modelId");
        return modelCellMap.containsKey(modelId);
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public void initialize(Context context) throws JSONException {
        k.f(context, "context");
        if (initialized && mmkv != null) {
            j.H("ModelConfig 已初始化，跳过重复初始化", TAG);
            return;
        }
        j.H("初始化 ModelConfig", TAG);
        MMKV.initialize(context.getApplicationContext());
        mmkv = MMKV.mmkvWithID(PREFS_NAME);
        loadFromPreferences();
        j.H("ModelConfig 初始化完成，当前模型: " + getCurrentModelId() + "，模型总数: " + modelCellMap.size(), TAG);
        initialized = true;
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public boolean isCustomModel(String modelId) {
        k.f(modelId, "modelId");
        return !defaultModelIds.contains(modelId) && hasModel(modelId);
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public int removeAllCustomModels() throws JSONException {
        Set<String> setKeySet = modelCellMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (!defaultModelIds.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        List<String> listF1 = v.f1(arrayList);
        int i = 0;
        if (listF1.isEmpty()) {
            j.H("没有自定义模型需要删除", TAG);
            return 0;
        }
        if (!defaultModelIds.contains(getCurrentModelId())) {
            j.H("当前使用自定义模型，切换到默认模型", TAG);
            setCurrentModel(DEFAULT_STEP_NET_MODEL);
        }
        for (String str : listF1) {
            if (modelCellMap.remove(str) != null) {
                i++;
                j.H("删除自定义模型: " + str, TAG);
            }
        }
        if (i > 0) {
            j.H("成功删除 " + i + " 个自定义模型", TAG);
            saveToPreferences();
        }
        return i;
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public boolean removeCustomModelsById(String modelId) throws JSONException {
        k.f(modelId, "modelId");
        if (defaultModelIds.contains(modelId)) {
            j.G("model id:" + modelId + " 默认模型不能删除", TAG);
            return false;
        }
        if (!hasModel(modelId)) {
            j.G("model id:" + modelId + " 模型未添加", TAG);
            return false;
        }
        modelCellMap.remove(modelId);
        if (!k.b(getCurrentModelId(), modelId)) {
            saveToPreferences();
            return true;
        }
        j.H("自定义模型即将被删除，切换到默认模型", TAG);
        setCurrentModel(DEFAULT_STEP_NET_MODEL);
        return true;
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public LlmConfig resolveLlmConfigForTask(String modelId, LlmConfig baseLlmConfig) {
        k.f(modelId, "modelId");
        k.f(baseLlmConfig, "baseLlmConfig");
        IModelCell iModelCellResolveModelCellForTask = resolveModelCellForTask(modelId);
        boolean zIsLocalModel = isLocalModel(modelId);
        LlmService localLlmService = zIsLocalModel ? new LocalLlmService() : baseLlmConfig.getLlmService();
        String serviceId = localLlmService.getServiceId();
        String name = iModelCellResolveModelCellForTask.getName();
        StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("resolveLlmConfigForTask: modelId=", modelId, ", isLocal=", ", llmService=", zIsLocalModel);
        sbL.append(serviceId);
        sbL.append(", modelCell=");
        sbL.append(name);
        j.H(sbL.toString(), TAG);
        return LlmConfig.copy$default(baseLlmConfig, localLlmService, null, modelId, iModelCellResolveModelCellForTask, null, 18, null);
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public IModelCell resolveModelCellForTask(String modelId) {
        k.f(modelId, "modelId");
        IModelCell iModelCell = modelCellMap.get(modelId);
        if (iModelCell != null) {
            return iModelCell;
        }
        j.H("resolveModelCellForTask: modelId=" + modelId + " 未注册,使用 Catalog 推断创建临时实例", TAG);
        return (IModelCell) ModelCatalog.INSTANCE.inferModelCellFactoryByModelId(modelId).invoke();
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public void setCurrentModel(String modelId) throws JSONException {
        k.f(modelId, "modelId");
        IModelCell iModelCell = modelCellMap.get(modelId);
        if (iModelCell == null) {
            j.G("setCurrentModel 失败：modelId 不存在于配置中：".concat(modelId), TAG);
        } else {
            applyCurrentModel(modelId, iModelCell, true);
        }
    }

    @Override // stepai.aios.guiagent.llm.cell.config.IModelConfig
    public boolean updateModelCell(String modelId, IModelCell modelCell) throws JSONException {
        k.f(modelId, "modelId");
        k.f(modelCell, "modelCell");
        if (defaultModelIds.contains(modelId)) {
            j.G("updateModelCell 失败：默认模型不可修改 Cell：".concat(modelId), TAG);
            return false;
        }
        Map<String, IModelCell> map = modelCellMap;
        if (!map.containsKey(modelId)) {
            j.G("updateModelCell 失败：modelId 未注册：".concat(modelId), TAG);
            return false;
        }
        map.put(modelId, modelCell);
        if (k.b(getCurrentModelId(), modelId)) {
            j.H("更新当前模型的 Cell，同步运行时：" + modelId + " -> " + modelCell.getType(), TAG);
            applyCurrentModel(modelId, modelCell, true);
        } else {
            saveToPreferences();
        }
        j.H("updateModelCell 成功：" + modelId + " -> " + modelCell.getType(), TAG);
        return true;
    }
}
