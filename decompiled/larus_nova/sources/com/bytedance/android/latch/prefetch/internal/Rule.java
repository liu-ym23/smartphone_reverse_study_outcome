package com.bytedance.android.latch.prefetch.internal;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class Rule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f58438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, d0> f58439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f58440c;

    public Rule() {
        throw null;
    }

    public Rule(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(r100, "api_path");
        if (JSONObjectProtectorUtils.getJSONObject(r100, "api_path").has("__type") == false) goto L9;
        JSONObject r102 = r100.optJSONObject("apis");
        if (r102 == null) goto L8;
        Map<String, d0> r103 = MapsKt.mapOf(new Pair("anonymous", new d0(r102)));
        if (r103 == null) goto L8;
    L18:
        final JSONArray r104 = r100.optJSONArray("conditions");
        if (r104 == null) goto L22;
        List<a> r105 = SequencesKt.toList(SequencesKt.map(CollectionsKt.asSequence(RangesKt.until(0, r104.length())), new Rule$3$1(r104)));
        if (r105 == null) goto L22;
    L23:
        Intrinsics.checkNotNullParameter(r101, "apiPath");
        Intrinsics.checkNotNullParameter(r103, "apis");
        Intrinsics.checkNotNullParameter(r105, "conditions");
        this.f58438a = r101;
        this.f58439b = r103;
        this.f58440c = r105;
        return;
    L22:
        r105 = CollectionsKt.emptyList();
    L8:
        r103 = MapsKt.emptyMap();
        goto L18
    L9:
        r103 = new LinkedHashMap();
        JSONObject r106 = r100.optJSONObject("apis");
        if (r106 == null) goto L18;
        Iterator<String> r107 = r106.keys();
    L13:
        if (r107.hasNext() == false) goto L17;
        String r108 = r107.next();
        JSONObject r109 = r106.optJSONObject(r108);
        if (r109 == null) goto L13;
        d0 r110 = r103.put(r108, new d0(r109));
        goto L13
    L17:
        Unit r111 = Unit.INSTANCE;
        goto L18
    }
}
