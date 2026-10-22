package com.bytedance.android.live.revlink.impl.jsb;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class InvitePkMethodKt {
    public static final Map<String, String> a(n.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$extraMap");
        final JsonObject r101 = r100.getExtra();
        if (r101 == null) goto L15;
        Sequence r102 = SequencesKt.filter(CollectionsKt.asSequence(r101.keySet()), new InvitePkMethodKt$extraMap$1$1(r101));
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L13;
        String r105 = (String) r104.next();
        JsonElement r106 = r101.get(r105);
        if (r106 == null) goto L11;
        String r107 = r106.getAsString();
        if (r107 == null) goto L11;
    L12:
        Pair r108 = TuplesKt.to(r105, r107);
        r103.put(r108.getFirst(), r108.getSecond());
    L11:
        r107 = "";
        goto L12
    L13:
        return r103;
    L15:
        return MapsKt.emptyMap();
    }
}
