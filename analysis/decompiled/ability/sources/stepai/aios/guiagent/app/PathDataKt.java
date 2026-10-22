package stepai.aios.guiagent.app;

import D7.v;
import H4.o;
import j9.m;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.a;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\u001a\u0016\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u0004*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001\u001a$\u0010\u0006\u001a\u0004\u0018\u00010\u0002*\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0002\u001a*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t*\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\n"}, d2 = {"toMap", "", "", "", "Lstepai/aios/guiagent/app/GuiPathNode;", "toUberPathNode", "getStringParam", "key", "getStringListParam", "", "guiagent_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PathDataKt {
    public static final List<String> getStringListParam(Map<String, ? extends Object> map, String key) {
        Object obj;
        k.f(key, "key");
        if (map != null && (obj = map.get(key)) != null) {
            if (obj instanceof String) {
                return o.M(obj);
            }
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : (Iterable) obj) {
                    if (obj2 instanceof String) {
                        arrayList.add(obj2);
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    public static final String getStringParam(Map<String, ? extends Object> map, String key) {
        Object obj;
        k.f(key, "key");
        if (map != null && (obj = map.get(key)) != null) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof List) {
                Object objC0 = v.C0((List) obj);
                if (objC0 != null) {
                    return objC0.toString();
                }
                return null;
            }
            String string = obj.toString();
            if (!m.s0(string)) {
                return string;
            }
        }
        return null;
    }

    public static final Map<String, Object> toMap(GuiPathNode guiPathNode) {
        k.f(guiPathNode, "<this>");
        Map mapR = a.R(new Pair("op_type", guiPathNode.getOpType()), new Pair("op_params", guiPathNode.getOpParams()), new Pair("op_desc", guiPathNode.getOpDesc()), new Pair("op_desc_display", guiPathNode.getOpDescDisplay()), new Pair("node_type", guiPathNode.getNodeType()), new Pair("op_desc_path", guiPathNode.getOpDescPath()), new Pair("slot_match", guiPathNode.getSlotMatch()), new Pair("repetition", guiPathNode.getRepetition()), new Pair("subtask_history_name", guiPathNode.getSubTaskHistoryName()));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapR.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final GuiPathNode toUberPathNode(Map<String, ? extends Object> map) {
        k.f(map, "<this>");
        Object obj = map.get("op_type");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("op_params");
        Map map2 = obj2 instanceof Map ? (Map) obj2 : null;
        Object obj3 = map.get("op_desc");
        String str2 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = map.get("op_desc_display");
        String str3 = obj4 instanceof String ? (String) obj4 : null;
        Object obj5 = map.get("node_type");
        k.d(obj5, "null cannot be cast to non-null type kotlin.String");
        String str4 = (String) obj5;
        Object obj6 = map.get("op_desc_path");
        List list = obj6 instanceof List ? (List) obj6 : null;
        Object obj7 = map.get("slot_match");
        Map map3 = obj7 instanceof Map ? (Map) obj7 : null;
        Object obj8 = map.get("repetition");
        Boolean bool = obj8 instanceof Boolean ? (Boolean) obj8 : null;
        Object obj9 = map.get("subtask_history_name");
        return new GuiPathNode(str, map2, str2, str3, str4, list, map3, bool, obj9 instanceof String ? (String) obj9 : null);
    }
}
