package stepai.aios.guiagent.tracer;

import D7.w;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.a;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u001a\u001e\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001*\u0004\u0018\u00010\u0003H\u0000¨\u0006\u0004"}, d2 = {"asStringAnyMap", "", "", "", "guiagent_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GuiTraceMetadataHelperKt {
    public static final Map<String, Object> asStringAnyMap(Object obj) {
        if (obj == null || !(obj instanceof Map)) {
            return null;
        }
        Set<Map.Entry> setEntrySet = ((Map) obj).entrySet();
        int iP = a.P(w.c0(setEntrySet, 10));
        if (iP < 16) {
            iP = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
        for (Map.Entry entry : setEntrySet) {
            linkedHashMap.put(String.valueOf(entry.getKey()), entry.getValue());
        }
        return linkedHashMap;
    }
}
