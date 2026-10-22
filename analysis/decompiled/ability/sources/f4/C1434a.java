package f4;

import D7.p;
import D7.v;
import D7.w;
import H4.o;
import androidx.compose.foundation.b;
import com.stepos.ability.mcpserver.model.BatchRequest;
import com.stepos.ability.mcpserver.model.BatchTask;
import com.stepos.ability.mcpserver.model.ExecutionLayer;
import com.stepos.ability.mcpserver.model.ExecutionPlan;
import com.stepos.ability.mcpserver.model.ExecutionTask;
import com.stepos.ability.mcpserver.model.McpServerConfig;
import j9.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

/* renamed from: f4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1434a {

    /* renamed from: a, reason: collision with root package name */
    public final McpServerConfig f4438a;

    public C1434a(McpServerConfig mcpServerConfig) {
        this.f4438a = mcpServerConfig;
    }

    public static final void b(LinkedHashMap linkedHashMap, String str, Object obj) {
        int i = 0;
        if (obj instanceof String) {
            if (t.e0((String) obj, "$ref:", false)) {
                linkedHashMap.put(str, obj);
                return;
            }
            return;
        }
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                b(linkedHashMap, str + "." + key, entry.getValue());
            }
            return;
        }
        if (obj instanceof List) {
            for (Object obj2 : (Iterable) obj) {
                int i6 = i + 1;
                if (i < 0) {
                    o.X();
                    throw null;
                }
                b(linkedHashMap, str + "[" + i + "]", obj2);
                i = i6;
            }
        }
    }

    public static final boolean c(LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2, LinkedHashMap linkedHashMap, String str) {
        if (linkedHashSet.contains(str)) {
            return true;
        }
        if (linkedHashSet2.contains(str)) {
            return false;
        }
        linkedHashSet2.add(str);
        linkedHashSet.add(str);
        List list = (List) linkedHashMap.get(str);
        if (list == null) {
            list = EmptyList.f4893a;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (c(linkedHashSet, linkedHashSet2, linkedHashMap, (String) it.next())) {
                return true;
            }
        }
        linkedHashSet.remove(str);
        return false;
    }

    public final ExecutionPlan a(BatchRequest batchRequest) {
        int i;
        List<BatchTask> tasks = batchRequest.getTasks();
        if (tasks.isEmpty()) {
            throw new IllegalArgumentException("Batch must contain at least one task");
        }
        int size = tasks.size();
        McpServerConfig mcpServerConfig = this.f4438a;
        if (size > mcpServerConfig.getMaxBatchTasks()) {
            throw new IllegalArgumentException(b.n(tasks.size(), mcpServerConfig.getMaxBatchTasks(), "Batch task count ", " exceeds limit ").toString());
        }
        List<BatchTask> list = tasks;
        int i6 = 10;
        int iP = kotlin.collections.a.P(w.c0(list, 10));
        if (iP < 16) {
            iP = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
        for (Object obj : list) {
            linkedHashMap.put(((BatchTask) obj).getId(), obj);
        }
        if (linkedHashMap.size() != tasks.size()) {
            throw new IllegalArgumentException("Batch task ids must be unique");
        }
        for (BatchTask batchTask : tasks) {
            List<String> dependsOn = batchTask.getDependsOn();
            if (dependsOn != null) {
                for (String str : dependsOn) {
                    if (!linkedHashMap.containsKey(str)) {
                        throw new IllegalArgumentException(androidx.appfunctions.metadata.a.m("Task '", batchTask.getId(), "' depends on unknown task '", str, "'").toString());
                    }
                }
            }
        }
        int iP2 = kotlin.collections.a.P(w.c0(list, 10));
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(iP2 >= 16 ? iP2 : 16);
        for (BatchTask batchTask2 : list) {
            String id = batchTask2.getId();
            List<String> dependsOn2 = batchTask2.getDependsOn();
            if (dependsOn2 == null) {
                dependsOn2 = EmptyList.f4893a;
            }
            linkedHashMap2.put(id, dependsOn2);
        }
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((BatchTask) it.next()).getId());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (c(linkedHashSet2, linkedHashSet, linkedHashMap2, (String) it2.next())) {
                    throw new IllegalArgumentException("Circular dependency detected");
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(w.c0(list, 10));
        Iterator<T> it3 = list.iterator();
        while (it3.hasNext()) {
            arrayList2.add(((BatchTask) it3.next()).getId());
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        Iterator it4 = arrayList2.iterator();
        while (true) {
            i = 0;
            if (!it4.hasNext()) {
                break;
            }
            String str2 = (String) it4.next();
            linkedHashMap3.put(str2, 0);
            linkedHashMap4.put(str2, new ArrayList());
        }
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            String str3 = (String) entry.getKey();
            List<String> list2 = (List) entry.getValue();
            linkedHashMap3.put(str3, Integer.valueOf(list2.size()));
            for (String str4 : list2) {
                Object arrayList3 = linkedHashMap4.get(str4);
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                    linkedHashMap4.put(str4, arrayList3);
                }
                ((List) arrayList3).add(str3);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        Iterator it5 = arrayList2.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            Integer num = (Integer) linkedHashMap3.get((String) next);
            if ((num != null ? num.intValue() : 0) == 0) {
                arrayList5.add(next);
            }
        }
        p pVar = new p(arrayList5);
        while (!pVar.isEmpty()) {
            List listF1 = v.f1(pVar);
            pVar.clear();
            arrayList4.add(listF1);
            Iterator it6 = listF1.iterator();
            while (it6.hasNext()) {
                List<String> list3 = (List) linkedHashMap4.get((String) it6.next());
                if (list3 == null) {
                    list3 = EmptyList.f4893a;
                }
                for (String str5 : list3) {
                    Integer num2 = (Integer) linkedHashMap3.get(str5);
                    int iIntValue = (num2 != null ? num2.intValue() : 1) - 1;
                    linkedHashMap3.put(str5, Integer.valueOf(iIntValue));
                    if (iIntValue == 0) {
                        pVar.addLast(str5);
                    }
                }
            }
        }
        Long timeoutMs = batchRequest.getTimeoutMs();
        long jLongValue = timeoutMs != null ? timeoutMs.longValue() : 60000L;
        String string = UUID.randomUUID().toString();
        k.e(string, "toString(...)");
        ArrayList arrayList6 = new ArrayList(w.c0(arrayList4, 10));
        Iterator it7 = arrayList4.iterator();
        while (it7.hasNext()) {
            Object next2 = it7.next();
            int i10 = i + 1;
            if (i < 0) {
                o.X();
                throw null;
            }
            List list4 = (List) next2;
            ArrayList arrayList7 = new ArrayList(w.c0(list4, i6));
            Iterator it8 = list4.iterator();
            while (it8.hasNext()) {
                Object obj2 = linkedHashMap.get((String) it8.next());
                k.c(obj2);
                BatchTask batchTask3 = (BatchTask) obj2;
                String id2 = batchTask3.getId();
                String tool = batchTask3.getTool();
                Map<String, Object> params = batchTask3.getParams();
                List<String> dependsOn3 = batchTask3.getDependsOn();
                if (dependsOn3 == null) {
                    dependsOn3 = EmptyList.f4893a;
                }
                Map<String, Object> params2 = batchTask3.getParams();
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                for (Map.Entry<String, Object> entry2 : params2.entrySet()) {
                    b(linkedHashMap5, entry2.getKey(), entry2.getValue());
                    arrayList4 = arrayList4;
                }
                ArrayList arrayList8 = arrayList4;
                int size2 = arrayList8.size();
                if (size2 < 1) {
                    size2 = 1;
                }
                arrayList7.add(new ExecutionTask(id2, tool, params, dependsOn3, linkedHashMap5, jLongValue / size2));
                it8 = it8;
                arrayList4 = arrayList8;
            }
            arrayList6.add(new ExecutionLayer(i, arrayList7));
            i = i10;
            arrayList4 = arrayList4;
            i6 = 10;
        }
        return new ExecutionPlan(string, arrayList6, jLongValue);
    }
}
