package stepai.aios.guiagent.tracer;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.k;
import za.f;
import za.j;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lstepai/aios/guiagent/tracer/GuiTraceMetadataHelper;", "", AppAgent.CONSTRUCT, "()V", "Lza/f;", "param", "", "", "buildMetadata", "(Lza/f;)Ljava/util/Map;", "Lza/i;", "taskInfo", "Lstepai/aios/guiagent/tracer/GuiTaskNodeMetadata;", "extractNodeMetadata", "(Lza/i;)Lstepai/aios/guiagent/tracer/GuiTaskNodeMetadata;", "KEY_TASK_TREE", "Ljava/lang/String;", "KEY_SLOT_MAP", "KEY_PATH_NODE", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GuiTraceMetadataHelper {
    public static final GuiTraceMetadataHelper INSTANCE = new GuiTraceMetadataHelper();
    private static final String KEY_PATH_NODE = "pathNode";
    private static final String KEY_SLOT_MAP = "slotMap";
    private static final String KEY_TASK_TREE = "taskTree";

    private GuiTraceMetadataHelper() {
    }

    public final Map<String, Object> buildMetadata(f param) {
        k.f(param, "param");
        MapBuilder mapBuilder = new MapBuilder();
        LinkedHashMap linkedHashMap = param.f;
        if (linkedHashMap != null) {
            mapBuilder.putAll(linkedHashMap);
        }
        j jVar = param.c;
        if (jVar != null) {
            MapBuilder mapBuilder2 = new MapBuilder();
            mapBuilder2.put("treeId", jVar.f7020a);
            mapBuilder.put(KEY_TASK_TREE, mapBuilder2.b());
        }
        return mapBuilder.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final stepai.aios.guiagent.tracer.GuiTaskNodeMetadata extractNodeMetadata(za.i r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "taskInfo"
            kotlin.jvm.internal.k.f(r0, r1)
            java.util.Map r1 = r0.p
            java.lang.String r2 = "taskTree"
            java.lang.Object r2 = r1.get(r2)
            boolean r3 = r2 instanceof java.util.Map
            r4 = 0
            if (r3 == 0) goto L17
            java.util.Map r2 = (java.util.Map) r2
            goto L18
        L17:
            r2 = r4
        L18:
            java.lang.String r3 = "treeId"
            if (r2 == 0) goto L22
            java.lang.Object r5 = r2.get(r3)
            if (r5 != 0) goto L26
        L22:
            java.lang.Object r5 = r1.get(r3)
        L26:
            if (r5 == 0) goto L2e
            java.lang.String r3 = r5.toString()
            r6 = r3
            goto L2f
        L2e:
            r6 = r4
        L2f:
            java.lang.String r3 = "slotMap"
            if (r2 == 0) goto L39
            java.lang.Object r5 = r2.get(r3)
            if (r5 != 0) goto L3d
        L39:
            java.lang.Object r5 = r1.get(r3)
        L3d:
            java.util.Map r10 = stepai.aios.guiagent.tracer.GuiTraceMetadataHelperKt.asStringAnyMap(r5)
            java.lang.String r3 = "pathNode"
            if (r2 == 0) goto L4b
            java.lang.Object r5 = r2.get(r3)
            if (r5 != 0) goto L4f
        L4b:
            java.lang.Object r5 = r1.get(r3)
        L4f:
            java.util.Map r5 = stepai.aios.guiagent.tracer.GuiTraceMetadataHelperKt.asStringAnyMap(r5)
            if (r2 == 0) goto L5c
            java.lang.String r7 = "totalNodes"
            java.lang.Object r7 = r2.get(r7)
            goto L5d
        L5c:
            r7 = r4
        L5d:
            boolean r8 = r7 instanceof java.lang.Number
            if (r8 == 0) goto L64
            java.lang.Number r7 = (java.lang.Number) r7
            goto L65
        L64:
            r7 = r4
        L65:
            if (r7 == 0) goto L70
            int r7 = r7.intValue()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L71
        L70:
            r7 = r4
        L71:
            if (r2 == 0) goto L7a
            java.lang.String r8 = "nodeIndex"
            java.lang.Object r8 = r2.get(r8)
            goto L7b
        L7a:
            r8 = r4
        L7b:
            boolean r9 = r8 instanceof java.lang.Number
            if (r9 == 0) goto L82
            java.lang.Number r8 = (java.lang.Number) r8
            goto L83
        L82:
            r8 = r4
        L83:
            if (r8 == 0) goto L8e
            int r8 = r8.intValue()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L8f
        L8e:
            r8 = r4
        L8f:
            java.lang.String r9 = "nodeLabel"
            if (r2 == 0) goto L99
            java.lang.Object r2 = r2.get(r9)
            if (r2 != 0) goto L9d
        L99:
            java.lang.Object r2 = r1.get(r9)
        L9d:
            boolean r9 = r2 instanceof java.lang.String
            if (r9 == 0) goto La4
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
        La4:
            if (r6 != 0) goto Lb9
            if (r5 != 0) goto Lb9
            if (r10 != 0) goto Lb9
            stepai.aios.guiagent.tracer.GuiTaskNodeMetadata r11 = new stepai.aios.guiagent.tracer.GuiTaskNodeMetadata
            java.lang.String r15 = r0.b
            r16 = 0
            r17 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r11.<init>(r12, r13, r14, r15, r16, r17)
            return r11
        Lb9:
            r2 = r5
            stepai.aios.guiagent.tracer.GuiTaskNodeMetadata r5 = new stepai.aios.guiagent.tracer.GuiTaskNodeMetadata
            if (r4 != 0) goto Lc0
            java.lang.String r4 = r0.b
        Lc0:
            r9 = r4
            if (r2 != 0) goto Lcd
            java.lang.Object r0 = r1.get(r3)
            java.util.Map r0 = stepai.aios.guiagent.tracer.GuiTraceMetadataHelperKt.asStringAnyMap(r0)
            r11 = r0
            goto Lce
        Lcd:
            r11 = r2
        Lce:
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.tracer.GuiTraceMetadataHelper.extractNodeMetadata(za.i):stepai.aios.guiagent.tracer.GuiTaskNodeMetadata");
    }
}
