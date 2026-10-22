package stepai.aios.guiagent.tracer.remote;

import D7.q;
import D7.v;
import D7.w;
import N9.j;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.ActionType;
import stepai.aios.guiagent.tracer.GuiNodeStepTraceSnapshot;
import stepai.aios.guiagent.tracer.GuiStepScreenshotRef;
import stepai.aios.guiagent.tracer.GuiTaskNodeMetadata;
import stepai.aios.guiagent.tracer.GuiTaskNodeTraceSnapshot;
import stepai.aios.guiagent.tracer.GuiTaskTreeTraceSnapshot;
import stepai.android.util.JsonUtil;
import za.d;
import za.g;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\b\u001a\u00020\u0007*\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a+\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0015*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001f\u0010\u001a\u001a\u00020\u0019*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u001e*\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001f\u0010 \u001a\u0017\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b!\u0010\u0014¨\u0006\""}, d2 = {"Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;", "Lstepai/aios/guiagent/tracer/remote/GuiTraceTreeRecord;", "toTreeRecord", "(Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;)Lstepai/aios/guiagent/tracer/remote/GuiTraceTreeRecord;", "Lstepai/aios/guiagent/tracer/GuiTaskNodeTraceSnapshot;", "", "treeIdOverride", "Lstepai/aios/guiagent/tracer/remote/GuiTraceRecord;", "toRecord", "(Lstepai/aios/guiagent/tracer/GuiTaskNodeTraceSnapshot;Ljava/lang/String;)Lstepai/aios/guiagent/tracer/remote/GuiTraceRecord;", "Lstepai/aios/guiagent/tracer/GuiNodeStepTraceSnapshot;", "Lstepai/aios/guiagent/tracer/remote/GuiTraceStep;", "toStep", "(Lstepai/aios/guiagent/tracer/GuiNodeStepTraceSnapshot;)Lstepai/aios/guiagent/tracer/remote/GuiTraceStep;", "Lstepai/aios/guiagent/tracer/remote/GuiTraceCompressionEvent;", "toCompressionEvent", "(Lstepai/aios/guiagent/tracer/GuiNodeStepTraceSnapshot;)Lstepai/aios/guiagent/tracer/remote/GuiTraceCompressionEvent;", "Lza/g;", "info", "extractModelRequestExtra", "(Lza/g;)Ljava/lang/String;", "", "", "extractModelRequestMetadata", "(Ljava/util/Map;)Ljava/util/Map;", "", "containsAnyCompressionKey", "(Ljava/util/Map;)Z", "asBoolean", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "", "asInt", "(Ljava/lang/Object;)Ljava/lang/Integer;", "renderResult", "guiagent_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GuiTraceModelsKt {
    private static final Boolean asBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            return m.P0((String) obj);
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() != 0);
        }
        return null;
    }

    private static final Integer asInt(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Long) {
            return Integer.valueOf((int) ((Number) obj).longValue());
        }
        if (obj instanceof Float) {
            return Integer.valueOf((int) ((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return Integer.valueOf((int) ((Number) obj).doubleValue());
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            return t.f0((String) obj);
        }
        return null;
    }

    private static final boolean containsAnyCompressionKey(Map<String, ? extends Object> map) {
        Set setK0 = q.K0(new String[]{"triggered", "enabled", "configValid", "configIssues", "mode", "reason", "detail", "interval", "recentWindow", "maxFieldItems", "currentStep", "chunkStartStep", "chunkEndStep", "compressionTraceId", "compressedUptoStep", "rawHistoryStartStep", "rawHistoryEndStep"});
        Set<String> setKeySet = map.keySet();
        if ((setKeySet instanceof Collection) && setKeySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = setKeySet.iterator();
        while (it.hasNext()) {
            if (setK0.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private static final String extractModelRequestExtra(g gVar) {
        Map<String, Object> mapExtractModelRequestMetadata = extractModelRequestMetadata(gVar.n);
        if (mapExtractModelRequestMetadata.isEmpty()) {
            return null;
        }
        return JsonUtil.INSTANCE.toJson(mapExtractModelRequestMetadata);
    }

    private static final Map<String, Object> extractModelRequestMetadata(Map<String, ? extends Object> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            if (t.e0(entry.getKey(), "model_request_", false)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(a.P(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(m.y0("model_request_", (String) entry2.getKey()), entry2.getValue());
        }
        return linkedHashMap2;
    }

    public static final String renderResult(g info) {
        k.f(info, "info");
        Object obj = info.i;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Number) {
            return obj.toString();
        }
        if (obj instanceof Boolean) {
            return String.valueOf(((Boolean) obj).booleanValue());
        }
        if (!(obj instanceof Map) && !(obj instanceof Iterable)) {
            return obj.toString();
        }
        return JsonUtil.INSTANCE.toJson(obj);
    }

    public static final GuiTraceCompressionEvent toCompressionEvent(GuiNodeStepTraceSnapshot guiNodeStepTraceSnapshot) {
        String string;
        k.f(guiNodeStepTraceSnapshot, "<this>");
        Map<String, Object> mapExtractModelRequestMetadata = extractModelRequestMetadata(guiNodeStepTraceSnapshot.getStepInfo().n);
        if (mapExtractModelRequestMetadata.isEmpty() || !containsAnyCompressionKey(mapExtractModelRequestMetadata)) {
            return null;
        }
        g stepInfo = guiNodeStepTraceSnapshot.getStepInfo();
        String stepId = guiNodeStepTraceSnapshot.getStepId();
        int i = stepInfo.b;
        ActionType actionType = stepInfo.d;
        String strName = actionType != null ? actionType.name() : null;
        String strName2 = stepInfo.c;
        if (strName2 == null) {
            strName2 = actionType != null ? actionType.name() : null;
            if (strName2 == null) {
                strName2 = B7.a.h(stepInfo.b, "Step ");
            }
        }
        long updatedAt = guiNodeStepTraceSnapshot.getUpdatedAt();
        Object obj = mapExtractModelRequestMetadata.get("compressionTraceId");
        String str = (obj == null || (string = obj.toString()) == null || string.equals("none")) ? null : string;
        Boolean boolAsBoolean = asBoolean(mapExtractModelRequestMetadata.get("triggered"));
        Boolean boolAsBoolean2 = asBoolean(mapExtractModelRequestMetadata.get("enabled"));
        Boolean boolAsBoolean3 = asBoolean(mapExtractModelRequestMetadata.get("configValid"));
        Object obj2 = mapExtractModelRequestMetadata.get("configIssues");
        String string2 = obj2 != null ? obj2.toString() : null;
        Object obj3 = mapExtractModelRequestMetadata.get("mode");
        String string3 = obj3 != null ? obj3.toString() : null;
        Object obj4 = mapExtractModelRequestMetadata.get("reason");
        String string4 = obj4 != null ? obj4.toString() : null;
        Object obj5 = mapExtractModelRequestMetadata.get("detail");
        return new GuiTraceCompressionEvent(stepId, i, strName, strName2, updatedAt, str, null, boolAsBoolean, boolAsBoolean2, boolAsBoolean3, string2, string3, string4, obj5 != null ? obj5.toString() : null, asInt(mapExtractModelRequestMetadata.get("interval")), asInt(mapExtractModelRequestMetadata.get("recentWindow")), asInt(mapExtractModelRequestMetadata.get("maxFieldItems")), asInt(mapExtractModelRequestMetadata.get("currentStep")), asInt(mapExtractModelRequestMetadata.get("chunkStartStep")), asInt(mapExtractModelRequestMetadata.get("chunkEndStep")), asInt(mapExtractModelRequestMetadata.get("compressedUptoStep")), asInt(mapExtractModelRequestMetadata.get("rawHistoryStartStep")), asInt(mapExtractModelRequestMetadata.get("rawHistoryEndStep")), 64, null);
    }

    public static final GuiTraceRecord toRecord(GuiTaskNodeTraceSnapshot guiTaskNodeTraceSnapshot, String str) {
        String externalTraceId;
        String str2;
        String json;
        String str3;
        String json2;
        Map<String, Object> pathNode;
        Map<String, Object> slotMap;
        k.f(guiTaskNodeTraceSnapshot, "<this>");
        j.H("toRecord: sessionId=" + guiTaskNodeTraceSnapshot.getSessionId() + ", taskInfo.state=" + guiTaskNodeTraceSnapshot.getTaskInfo().c, "RobotTrace");
        List<GuiNodeStepTraceSnapshot> steps = guiTaskNodeTraceSnapshot.getSteps();
        ArrayList arrayList = new ArrayList(w.c0(steps, 10));
        Iterator<T> it = steps.iterator();
        while (it.hasNext()) {
            arrayList.add(toStep((GuiNodeStepTraceSnapshot) it.next()));
        }
        String sessionId = guiTaskNodeTraceSnapshot.getSessionId();
        GuiTaskNodeMetadata nodeMetadata = guiTaskNodeTraceSnapshot.getNodeMetadata();
        if (nodeMetadata == null || (externalTraceId = nodeMetadata.getTreeId()) == null) {
            externalTraceId = str == null ? guiTaskNodeTraceSnapshot.getExternalTraceId() : str;
        }
        String str4 = guiTaskNodeTraceSnapshot.getTaskInfo().b;
        GuiTaskNodeMetadata nodeMetadata2 = guiTaskNodeTraceSnapshot.getNodeMetadata();
        String nodeLabel = nodeMetadata2 != null ? nodeMetadata2.getNodeLabel() : null;
        String strName = guiTaskNodeTraceSnapshot.getTaskInfo().c.name();
        long createdAt = guiTaskNodeTraceSnapshot.getCreatedAt();
        long updatedAt = guiTaskNodeTraceSnapshot.getUpdatedAt();
        d lastResult = guiTaskNodeTraceSnapshot.getLastResult();
        Boolean boolValueOf = lastResult != null ? Boolean.valueOf(lastResult.f7001a) : null;
        d lastResult2 = guiTaskNodeTraceSnapshot.getLastResult();
        String str5 = lastResult2 != null ? lastResult2.c : null;
        String lastErrorMessage = guiTaskNodeTraceSnapshot.getLastErrorMessage();
        GuiTaskNodeMetadata nodeMetadata3 = guiTaskNodeTraceSnapshot.getNodeMetadata();
        Integer totalNodes = nodeMetadata3 != null ? nodeMetadata3.getTotalNodes() : null;
        GuiTaskNodeMetadata nodeMetadata4 = guiTaskNodeTraceSnapshot.getNodeMetadata();
        Integer nodeIndex = nodeMetadata4 != null ? nodeMetadata4.getNodeIndex() : null;
        GuiTaskNodeMetadata nodeMetadata5 = guiTaskNodeTraceSnapshot.getNodeMetadata();
        if (nodeMetadata5 == null || (slotMap = nodeMetadata5.getSlotMap()) == null) {
            str2 = sessionId;
            json = null;
        } else {
            str2 = sessionId;
            json = JsonUtil.INSTANCE.toJson(slotMap);
        }
        GuiTaskNodeMetadata nodeMetadata6 = guiTaskNodeTraceSnapshot.getNodeMetadata();
        if (nodeMetadata6 == null || (pathNode = nodeMetadata6.getPathNode()) == null) {
            str3 = json;
            json2 = null;
        } else {
            str3 = json;
            json2 = JsonUtil.INSTANCE.toJson(pathNode);
        }
        List<GuiNodeStepTraceSnapshot> steps2 = guiTaskNodeTraceSnapshot.getSteps();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = steps2.iterator();
        while (it2.hasNext()) {
            String str6 = json2;
            GuiTraceCompressionEvent compressionEvent = toCompressionEvent((GuiNodeStepTraceSnapshot) it2.next());
            if (compressionEvent != null) {
                arrayList2.add(compressionEvent);
            }
            json2 = str6;
        }
        return new GuiTraceRecord(str2, externalTraceId, str4, nodeLabel, strName, createdAt, updatedAt, boolValueOf, str5, lastErrorMessage, totalNodes, nodeIndex, str3, json2, arrayList, arrayList2);
    }

    public static /* synthetic */ GuiTraceRecord toRecord$default(GuiTaskNodeTraceSnapshot guiTaskNodeTraceSnapshot, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return toRecord(guiTaskNodeTraceSnapshot, str);
    }

    public static final GuiTraceStep toStep(GuiNodeStepTraceSnapshot guiNodeStepTraceSnapshot) {
        k.f(guiNodeStepTraceSnapshot, "<this>");
        g stepInfo = guiNodeStepTraceSnapshot.getStepInfo();
        String stepId = guiNodeStepTraceSnapshot.getStepId();
        int i = stepInfo.b;
        ActionType actionType = stepInfo.d;
        String strName = actionType != null ? actionType.name() : null;
        String strName2 = stepInfo.e.name();
        String strName3 = stepInfo.c;
        if (strName3 == null) {
            strName3 = actionType != null ? actionType.name() : null;
            if (strName3 == null) {
                strName3 = B7.a.h(stepInfo.b, "Step ");
            }
        }
        String strRenderResult = stepInfo.f7016j;
        if (strRenderResult == null) {
            strRenderResult = renderResult(stepInfo);
        }
        String str = strName;
        String str2 = strName3;
        long updatedAt = guiNodeStepTraceSnapshot.getUpdatedAt();
        GuiStepScreenshotRef screenshotRef = guiNodeStepTraceSnapshot.getScreenshotRef();
        return new GuiTraceStep(stepId, i, str, strName2, str2, strRenderResult, updatedAt, screenshotRef != null ? screenshotRef.getFileName() : null, guiNodeStepTraceSnapshot.getLlmTraceId(), null, extractModelRequestExtra(stepInfo), stepInfo.m, 512, null);
    }

    public static final GuiTraceTreeRecord toTreeRecord(GuiTaskTreeTraceSnapshot guiTaskTreeTraceSnapshot) {
        Object next;
        String nodeLabel;
        String lastErrorMessage;
        String str;
        Object next2;
        k.f(guiTaskTreeTraceSnapshot, "<this>");
        String treeId = guiTaskTreeTraceSnapshot.getTreeId();
        boolean completed = guiTaskTreeTraceSnapshot.getCompleted();
        Integer totalNodes = guiTaskTreeTraceSnapshot.getTotalNodes();
        int size = guiTaskTreeTraceSnapshot.getNodeTraces().size();
        List<GuiTaskNodeTraceSnapshot> nodeTraces = guiTaskTreeTraceSnapshot.getNodeTraces();
        ArrayList arrayList = new ArrayList(w.c0(nodeTraces, 10));
        Iterator<T> it = nodeTraces.iterator();
        while (it.hasNext()) {
            arrayList.add(((GuiTaskNodeTraceSnapshot) it.next()).getTaskInfo().c.name());
        }
        StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("toTreeRecord: treeId=", treeId, ", completed=", ", totalNodes=", completed);
        sbL.append(totalNodes);
        sbL.append(", nodeTraces=");
        sbL.append(size);
        sbL.append(", nodeStates=");
        sbL.append(arrayList);
        j.H(sbL.toString(), "RobotTrace");
        List<GuiTaskNodeTraceSnapshot> nodeTraces2 = guiTaskTreeTraceSnapshot.getNodeTraces();
        ArrayList arrayList2 = new ArrayList(w.c0(nodeTraces2, 10));
        Iterator<T> it2 = nodeTraces2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(toRecord((GuiTaskNodeTraceSnapshot) it2.next(), guiTaskTreeTraceSnapshot.getTreeId()));
        }
        List listZ0 = v.Z0(arrayList2, new Comparator() { // from class: stepai.aios.guiagent.tracer.remote.GuiTraceModelsKt$toTreeRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t9, T t10) {
                Integer nodeIndex = ((GuiTraceRecord) t9).getNodeIndex();
                Integer numValueOf = Integer.valueOf(nodeIndex != null ? nodeIndex.intValue() : Integer.MAX_VALUE);
                Integer nodeIndex2 = ((GuiTraceRecord) t10).getNodeIndex();
                return j.m(numValueOf, Integer.valueOf(nodeIndex2 != null ? nodeIndex2.intValue() : Integer.MAX_VALUE));
            }
        });
        GuiTraceRecord guiTraceRecord = (GuiTraceRecord) v.C0(listZ0);
        List list = listZ0;
        Iterator it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                next = null;
                break;
            }
            next = it3.next();
            Integer nodeIndex = ((GuiTraceRecord) next).getNodeIndex();
            if ((nodeIndex != null ? nodeIndex.intValue() : 0) == 0) {
                break;
            }
        }
        GuiTraceRecord guiTraceRecord2 = (GuiTraceRecord) next;
        if (guiTraceRecord2 == null || (nodeLabel = guiTraceRecord2.getNodeLabel()) == null) {
            nodeLabel = guiTraceRecord != null ? guiTraceRecord.getNodeLabel() : null;
            if (nodeLabel == null) {
                nodeLabel = guiTraceRecord != null ? guiTraceRecord.getTaskDescription() : null;
                if (nodeLabel == null) {
                    nodeLabel = guiTaskTreeTraceSnapshot.getTreeId();
                }
            }
        }
        Integer totalNodes2 = guiTaskTreeTraceSnapshot.getTotalNodes();
        if (totalNodes2 == null) {
            ArrayList arrayList3 = new ArrayList();
            Iterator it4 = list.iterator();
            while (it4.hasNext()) {
                Integer nodeIndex2 = ((GuiTraceRecord) it4.next()).getNodeIndex();
                if (nodeIndex2 != null) {
                    arrayList3.add(nodeIndex2);
                }
            }
            Iterator it5 = arrayList3.iterator();
            if (it5.hasNext()) {
                Integer numValueOf = Integer.valueOf(((Number) it5.next()).intValue() + 1);
                while (it5.hasNext()) {
                    Integer numValueOf2 = Integer.valueOf(((Number) it5.next()).intValue() + 1);
                    if (numValueOf.compareTo(numValueOf2) < 0) {
                        numValueOf = numValueOf2;
                    }
                }
                totalNodes2 = numValueOf;
            } else {
                totalNodes2 = null;
            }
        }
        Integer num = totalNodes2;
        String failureReason = guiTaskTreeTraceSnapshot.getFailureReason();
        if (failureReason == null) {
            Iterator it6 = list.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it6.next();
                if (((GuiTraceRecord) next2).getLastErrorMessage() != null) {
                    break;
                }
            }
            GuiTraceRecord guiTraceRecord3 = (GuiTraceRecord) next2;
            str = nodeLabel;
            lastErrorMessage = guiTraceRecord3 != null ? guiTraceRecord3.getLastErrorMessage() : null;
        } else {
            lastErrorMessage = failureReason;
            str = nodeLabel;
        }
        return new GuiTraceTreeRecord(guiTaskTreeTraceSnapshot.getTreeId(), str, guiTaskTreeTraceSnapshot.getCreatedAt(), guiTaskTreeTraceSnapshot.getUpdatedAt(), num, listZ0.size(), guiTaskTreeTraceSnapshot.getCompleted(), guiTaskTreeTraceSnapshot.getSuccess(), lastErrorMessage, listZ0);
    }
}
