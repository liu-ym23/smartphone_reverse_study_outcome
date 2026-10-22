package stepai.aios.guiagent.llm.cell.config;

import S7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.ExecutionBundle;
import j9.m;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import n5.C1741a;
import stepai.aios.guiagent.llm.cell.DoubaoSeedModelCell;
import stepai.aios.guiagent.llm.cell.DoubaoTarsModelCell;
import stepai.aios.guiagent.llm.cell.GLMModelCell;
import stepai.aios.guiagent.llm.cell.GeminiModelCell;
import stepai.aios.guiagent.llm.cell.GlmAutoModelCell;
import stepai.aios.guiagent.llm.cell.LocalCloudModelCell;
import stepai.aios.guiagent.llm.cell.LocalModelCell;
import stepai.aios.guiagent.llm.cell.MiMoModelCell;
import stepai.aios.guiagent.llm.cell.StepGelabModelCell;
import stepai.aios.guiagent.llm.cell.StepPlanTreeModelCell;
import stepai.aios.guiagent.llm.parser.IModelCell;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001:B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u000bR\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u000bR\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u000bR\u0014\u0010\u001d\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u000bR\u0014\u0010\u001e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u000bR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010,R+\u0010/\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070.\u0012\u0004\u0012\u00020\u00040-8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R)\u00103\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060-8\u0006¢\u0006\f\n\u0004\b3\u00100\u001a\u0004\b4\u00102R)\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060-8\u0006¢\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00102R\u001d\u00108\u001a\b\u0012\u0004\u0012\u0002070%8\u0006¢\u0006\f\n\u0004\b8\u0010'\u001a\u0004\b9\u0010)¨\u0006;"}, d2 = {"Lstepai/aios/guiagent/llm/cell/config/ModelCatalog;", "", AppAgent.CONSTRUCT, "()V", "", "modelId", "Lkotlin/Function0;", "Lstepai/aios/guiagent/llm/parser/IModelCell;", "inferModelCellFactoryByModelId", "(Ljava/lang/String;)LS7/a;", "MODEL_ID_STEP_PLAN_TREE", "Ljava/lang/String;", "MODEL_ID_DOUBAO_TARS", "MODEL_ID_GEMINI_PRO", "MODEL_ID_STEP_GELAB", "MODEL_ID_GLM_AUTO", "MODEL_ID_GLM", "MODEL_ID_MIMO", "MODEL_ID_DOUBAO_SEED", "MODEL_ID_LOCAL", "MODEL_ID_LOCAL_CLOUD_TEST", "MODEL_CELL_TYPE_STEP_PLAN_TREE", "MODEL_CELL_TYPE_DOUBAO_TARS", "MODEL_CELL_TYPE_GEMINI", "MODEL_CELL_TYPE_STEP_GELAB", "MODEL_CELL_TYPE_GLM_AUTO", "MODEL_CELL_TYPE_GLM", "MODEL_CELL_TYPE_MIMO", "MODEL_CELL_TYPE_DOUBAO_SEED", "MODEL_CELL_TYPE_LOCAL", "MODEL_CELL_TYPE_LOCAL_CLOUD_TEST", "", "Lstepai/aios/guiagent/llm/cell/config/ModelCatalog$Item;", "ITEMS", "[Lstepai/aios/guiagent/llm/cell/config/ModelCatalog$Item;", "getITEMS", "()[Lstepai/aios/guiagent/llm/cell/config/ModelCatalog$Item;", "", "MODEL_OPTIONS", "Ljava/util/List;", "getMODEL_OPTIONS", "()Ljava/util/List;", "DEFAULT_MODEL_ID", "getDEFAULT_MODEL_ID", "()Ljava/lang/String;", "", "Ljava/lang/Class;", "modelCellTypeNameMap", "Ljava/util/Map;", "getModelCellTypeNameMap", "()Ljava/util/Map;", "modelCellTypeFactoryMap", "getModelCellTypeFactoryMap", "modelIdToModelCellFactoryMap", "getModelIdToModelCellFactoryMap", "Lstepai/aios/guiagent/llm/cell/config/ModelCellOption;", "MODEL_CELL_OPTIONS", "getMODEL_CELL_OPTIONS", "Item", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ModelCatalog {
    private static final String DEFAULT_MODEL_ID;
    public static final ModelCatalog INSTANCE = new ModelCatalog();
    private static final Item[] ITEMS;
    private static final List<ModelCellOption> MODEL_CELL_OPTIONS;
    public static final String MODEL_CELL_TYPE_DOUBAO_SEED = "DoubaoSeedModelCell";
    public static final String MODEL_CELL_TYPE_DOUBAO_TARS = "DoubaoTarsModelCell";
    public static final String MODEL_CELL_TYPE_GEMINI = "GeminiModelCell";
    public static final String MODEL_CELL_TYPE_GLM = "GLMModelCell";
    public static final String MODEL_CELL_TYPE_GLM_AUTO = "GlmAtuoModelCell";
    public static final String MODEL_CELL_TYPE_LOCAL = "LocalModelCell";
    public static final String MODEL_CELL_TYPE_LOCAL_CLOUD_TEST = "LocalCloudModelCell";
    public static final String MODEL_CELL_TYPE_MIMO = "MiMoModelCell";
    public static final String MODEL_CELL_TYPE_STEP_GELAB = "StepGelabModelCell";
    public static final String MODEL_CELL_TYPE_STEP_PLAN_TREE = "StepPlanTreeModelCell";
    public static final String MODEL_ID_DOUBAO_SEED = "doubao-seed-1-8-251228";
    public static final String MODEL_ID_DOUBAO_TARS = "doubao-1.5-ui-tars";
    public static final String MODEL_ID_GEMINI_PRO = "google/gemini-2.5-pro";
    public static final String MODEL_ID_GLM = "glm-4.6v";
    public static final String MODEL_ID_GLM_AUTO = "autoglm-phone";
    public static final String MODEL_ID_LOCAL = "local-vlm";
    public static final String MODEL_ID_LOCAL_CLOUD_TEST = "q3-4b-tob-sample-ge-cap-aw-aoss2v4-ls1v15-260530-aos-prod";
    public static final String MODEL_ID_MIMO = "MiMo-VL-7B-RL-2508-V1-1209";
    public static final String MODEL_ID_STEP_GELAB = "step3p7-mtp3-0520-mm-reasoning-effort-fp8-aos-prod";
    public static final String MODEL_ID_STEP_PLAN_TREE = "uiagentmeituan-12071133";
    private static final List<String> MODEL_OPTIONS;
    private static final Map<String, a> modelCellTypeFactoryMap;
    private static final Map<Class<? extends IModelCell>, String> modelCellTypeNameMap;
    private static final Map<String, a> modelIdToModelCellFactoryMap;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0018\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014JP\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000eJ\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b!\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b\"\u0010\u000eR\u001f\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010\u0012R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010\u0014¨\u0006'"}, d2 = {"Lstepai/aios/guiagent/llm/cell/config/ModelCatalog$Item;", "", "", "modelId", "modelCellType", "defaultDesc", "Ljava/lang/Class;", "Lstepai/aios/guiagent/llm/parser/IModelCell;", "cellClass", "Lkotlin/Function0;", "factory", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;LS7/a;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Ljava/lang/Class;", "component5", "()LS7/a;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;LS7/a;)Lstepai/aios/guiagent/llm/cell/config/ModelCatalog$Item;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getModelId", "getModelCellType", "getDefaultDesc", "Ljava/lang/Class;", "getCellClass", "LS7/a;", "getFactory", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Item {
        private final Class<? extends IModelCell> cellClass;
        private final String defaultDesc;
        private final a factory;
        private final String modelCellType;
        private final String modelId;

        public Item(String modelId, String modelCellType, String defaultDesc, Class<? extends IModelCell> cellClass, a factory) {
            k.f(modelId, "modelId");
            k.f(modelCellType, "modelCellType");
            k.f(defaultDesc, "defaultDesc");
            k.f(cellClass, "cellClass");
            k.f(factory, "factory");
            this.modelId = modelId;
            this.modelCellType = modelCellType;
            this.defaultDesc = defaultDesc;
            this.cellClass = cellClass;
            this.factory = factory;
        }

        public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, Class cls, a aVar, int i, Object obj) {
            if ((i & 1) != 0) {
                str = item.modelId;
            }
            if ((i & 2) != 0) {
                str2 = item.modelCellType;
            }
            if ((i & 4) != 0) {
                str3 = item.defaultDesc;
            }
            if ((i & 8) != 0) {
                cls = item.cellClass;
            }
            if ((i & 16) != 0) {
                aVar = item.factory;
            }
            a aVar2 = aVar;
            String str4 = str3;
            return item.copy(str, str2, str4, cls, aVar2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getModelId() {
            return this.modelId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getModelCellType() {
            return this.modelCellType;
        }

        /* renamed from: component3, reason: from getter */
        public final String getDefaultDesc() {
            return this.defaultDesc;
        }

        public final Class<? extends IModelCell> component4() {
            return this.cellClass;
        }

        /* renamed from: component5, reason: from getter */
        public final a getFactory() {
            return this.factory;
        }

        public final Item copy(String modelId, String modelCellType, String defaultDesc, Class<? extends IModelCell> cellClass, a factory) {
            k.f(modelId, "modelId");
            k.f(modelCellType, "modelCellType");
            k.f(defaultDesc, "defaultDesc");
            k.f(cellClass, "cellClass");
            k.f(factory, "factory");
            return new Item(modelId, modelCellType, defaultDesc, cellClass, factory);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return k.b(this.modelId, item.modelId) && k.b(this.modelCellType, item.modelCellType) && k.b(this.defaultDesc, item.defaultDesc) && k.b(this.cellClass, item.cellClass) && k.b(this.factory, item.factory);
        }

        public final Class<? extends IModelCell> getCellClass() {
            return this.cellClass;
        }

        public final String getDefaultDesc() {
            return this.defaultDesc;
        }

        public final a getFactory() {
            return this.factory;
        }

        public final String getModelCellType() {
            return this.modelCellType;
        }

        public final String getModelId() {
            return this.modelId;
        }

        public int hashCode() {
            return this.factory.hashCode() + ((this.cellClass.hashCode() + B7.a.c(B7.a.c(this.modelId.hashCode() * 31, 31, this.modelCellType), 31, this.defaultDesc)) * 31);
        }

        public String toString() {
            String str = this.modelId;
            String str2 = this.modelCellType;
            String str3 = this.defaultDesc;
            Class<? extends IModelCell> cls = this.cellClass;
            a aVar = this.factory;
            StringBuilder sbW = B7.a.w("Item(modelId=", str, ", modelCellType=", str2, ", defaultDesc=");
            sbW.append(str3);
            sbW.append(", cellClass=");
            sbW.append(cls);
            sbW.append(", factory=");
            sbW.append(aVar);
            sbW.append(")");
            return sbW.toString();
        }
    }

    static {
        Item[] itemArr = {new Item(MODEL_ID_STEP_PLAN_TREE, MODEL_CELL_TYPE_STEP_PLAN_TREE, "规划树模型配置", StepPlanTreeModelCell.class, new C1741a(9)), new Item(MODEL_ID_DOUBAO_TARS, MODEL_CELL_TYPE_DOUBAO_TARS, "豆包 Tars 模型配置", DoubaoTarsModelCell.class, new C1741a(19)), new Item(MODEL_ID_DOUBAO_SEED, MODEL_CELL_TYPE_DOUBAO_SEED, "豆包 Seed 模型配置", DoubaoSeedModelCell.class, new C1741a(20)), new Item(MODEL_ID_GEMINI_PRO, MODEL_CELL_TYPE_GEMINI, "Gemini 模型配置", GeminiModelCell.class, new C1741a(21)), new Item(MODEL_ID_STEP_GELAB, MODEL_CELL_TYPE_STEP_GELAB, "Gelab 模型配置", StepGelabModelCell.class, new C1741a(22)), new Item(MODEL_ID_GLM_AUTO, MODEL_CELL_TYPE_GLM_AUTO, "智谱auto glm模型配置", GlmAutoModelCell.class, new C1741a(23)), new Item(MODEL_ID_GLM, MODEL_CELL_TYPE_GLM, "智谱glm模型配置", GLMModelCell.class, new C1741a(24)), new Item(MODEL_ID_MIMO, MODEL_CELL_TYPE_MIMO, "Mimo模型配置", MiMoModelCell.class, new C1741a(25)), new Item("local-vlm", MODEL_CELL_TYPE_LOCAL, "端侧本地视觉语言模型", LocalModelCell.class, new C1741a(26)), new Item(MODEL_ID_LOCAL_CLOUD_TEST, MODEL_CELL_TYPE_LOCAL_CLOUD_TEST, "端侧模型云测配置", LocalCloudModelCell.class, new C1741a(27))};
        ITEMS = itemArr;
        ArrayList arrayList = new ArrayList(itemArr.length);
        for (Item item : itemArr) {
            arrayList.add(item.getModelId());
        }
        MODEL_OPTIONS = arrayList;
        DEFAULT_MODEL_ID = MODEL_ID_STEP_GELAB;
        Item[] itemArr2 = ITEMS;
        int iP = kotlin.collections.a.P(itemArr2.length);
        if (iP < 16) {
            iP = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
        for (Item item2 : itemArr2) {
            linkedHashMap.put(item2.getCellClass(), item2.getModelCellType());
        }
        modelCellTypeNameMap = linkedHashMap;
        Item[] itemArr3 = ITEMS;
        int iP2 = kotlin.collections.a.P(itemArr3.length);
        if (iP2 < 16) {
            iP2 = 16;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(iP2);
        for (Item item3 : itemArr3) {
            linkedHashMap2.put(item3.getModelCellType(), item3.getFactory());
        }
        modelCellTypeFactoryMap = linkedHashMap2;
        Item[] itemArr4 = ITEMS;
        int iP3 = kotlin.collections.a.P(itemArr4.length);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(iP3 >= 16 ? iP3 : 16);
        for (Item item4 : itemArr4) {
            linkedHashMap3.put(item4.getModelId(), item4.getFactory());
        }
        modelIdToModelCellFactoryMap = linkedHashMap3;
        Item[] itemArr5 = ITEMS;
        ArrayList arrayList2 = new ArrayList(itemArr5.length);
        for (Item item5 : itemArr5) {
            IModelCell iModelCell = (IModelCell) item5.getFactory().invoke();
            String modelCellType = item5.getModelCellType();
            String name = ((IModelCell) item5.getFactory().invoke()).getName();
            String desc = ((IModelCell) item5.getFactory().invoke()).getDesc();
            if (desc == null) {
                desc = item5.getDefaultDesc();
            }
            arrayList2.add(new ModelCellOption(modelCellType, iModelCell, name, desc));
        }
        MODEL_CELL_OPTIONS = arrayList2;
    }

    private ModelCatalog() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IModelCell ITEMS$lambda$0() {
        return new StepPlanTreeModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IModelCell ITEMS$lambda$1() {
        return new DoubaoTarsModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IModelCell ITEMS$lambda$2() {
        return new DoubaoSeedModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IModelCell ITEMS$lambda$3() {
        return new GeminiModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IModelCell ITEMS$lambda$4() {
        return new StepGelabModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IModelCell ITEMS$lambda$5() {
        return new GlmAutoModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IModelCell ITEMS$lambda$6() {
        return new GLMModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IModelCell ITEMS$lambda$7() {
        return new MiMoModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IModelCell ITEMS$lambda$8() {
        return new LocalModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IModelCell ITEMS$lambda$9() {
        return new LocalCloudModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepPlanTreeModelCell inferModelCellFactoryByModelId$lambda$1() {
        return new StepPlanTreeModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DoubaoSeedModelCell inferModelCellFactoryByModelId$lambda$2() {
        return new DoubaoSeedModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DoubaoTarsModelCell inferModelCellFactoryByModelId$lambda$3() {
        return new DoubaoTarsModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GeminiModelCell inferModelCellFactoryByModelId$lambda$4() {
        return new GeminiModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepGelabModelCell inferModelCellFactoryByModelId$lambda$5() {
        return new StepGelabModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GlmAutoModelCell inferModelCellFactoryByModelId$lambda$6() {
        return new GlmAutoModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalModelCell inferModelCellFactoryByModelId$lambda$7() {
        return new LocalModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalCloudModelCell inferModelCellFactoryByModelId$lambda$8() {
        return new LocalCloudModelCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepGelabModelCell inferModelCellFactoryByModelId$lambda$9() {
        return new StepGelabModelCell();
    }

    public final String getDEFAULT_MODEL_ID() {
        return DEFAULT_MODEL_ID;
    }

    public final Item[] getITEMS() {
        return ITEMS;
    }

    public final List<ModelCellOption> getMODEL_CELL_OPTIONS() {
        return MODEL_CELL_OPTIONS;
    }

    public final List<String> getMODEL_OPTIONS() {
        return MODEL_OPTIONS;
    }

    public final Map<String, a> getModelCellTypeFactoryMap() {
        return modelCellTypeFactoryMap;
    }

    public final Map<Class<? extends IModelCell>, String> getModelCellTypeNameMap() {
        return modelCellTypeNameMap;
    }

    public final Map<String, a> getModelIdToModelCellFactoryMap() {
        return modelIdToModelCellFactoryMap;
    }

    public final a inferModelCellFactoryByModelId(String modelId) {
        k.f(modelId, "modelId");
        a aVar = modelIdToModelCellFactoryMap.get(modelId);
        return aVar != null ? aVar : m.h0(modelId, "uiagentmeituan", true) ? new C1741a(10) : (m.h0(modelId, "doubao", true) || m.h0(modelId, "seed", true) || m.h0(modelId, "bytedance", true)) ? m.h0(modelId, "seed", true) ? new C1741a(11) : new C1741a(12) : m.h0(modelId, "gemini", true) ? new C1741a(13) : m.h0(modelId, "gelab", true) ? new C1741a(14) : (m.h0(modelId, "glm", true) || m.h0(modelId, "autoglm", true)) ? new C1741a(15) : m.h0(modelId, ExecutionBundle.PREF_LOCAL, true) ? new C1741a(16) : modelId.equals(MODEL_ID_LOCAL_CLOUD_TEST) ? new C1741a(17) : new C1741a(18);
    }
}
