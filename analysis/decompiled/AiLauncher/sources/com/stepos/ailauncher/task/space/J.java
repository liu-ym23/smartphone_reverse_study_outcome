package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "Lcom/stepos/ailauncher/task/space/h0;", DidiCardProvider.KEY_ITEMS, "Lorg/json/JSONObject;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Lorg/json/JSONObject;", "task_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class J {
    public static final JSONObject a(List<MemoryItemParsed> items) throws JSONException {
        kotlin.jvm.internal.p.i(items, "items");
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            if (!((MemoryItemParsed) obj).a().isEmpty()) {
                arrayList.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList) {
            String memoryName = ((MemoryItemParsed) obj2).getMemoryName();
            Object arrayList2 = linkedHashMap.get(memoryName);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(memoryName, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            List list = (List) ((Map.Entry) it.next()).getValue();
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Z8.A.E(arrayList3, ((MemoryItemParsed) it2.next()).a());
            }
            List listG0 = Z8.F.g0(arrayList3);
            if (!listG0.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", ChatTracker.CLICK_DELETE);
                jSONObject.put("memory_ids", new JSONArray((Collection) listG0));
                jSONArray.put(jSONObject);
            }
        }
        JSONObject jSONObjectPut = new JSONObject().put("ingest_memories", jSONArray);
        kotlin.jvm.internal.p.h(jSONObjectPut, "put(...)");
        return jSONObjectPut;
    }
}
