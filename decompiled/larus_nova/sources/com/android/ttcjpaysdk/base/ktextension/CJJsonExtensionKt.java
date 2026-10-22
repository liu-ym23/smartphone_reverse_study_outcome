package com.android.ttcjpaysdk.base.ktextension;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"toStringMap", "", "", "Lorg/json/JSONObject;", "base-context_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJJsonExtensionKt {
    public static final Map<String, String> toStringMap(JSONObject r100) {
        if (r100 == null) goto L4;
        Sequence r101 = SequencesKt.asSequence(r100.keys());
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        String r104 = (String) r103.next();
        Pair r105 = TuplesKt.to(r104, r100.optString(r104, ""));
        r102.put(r105.getFirst(), r105.getSecond());
        goto L7
    L9:
        return r102;
    L4:
        return new LinkedHashMap();
    }
}
