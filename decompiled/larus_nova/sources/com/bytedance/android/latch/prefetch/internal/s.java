package com.bytedance.android.latch.prefetch.internal;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f58486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PrefetchPartial f58487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Rule> f58488d;

    public s() {
        throw null;
    }

    public s(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        String r101 = r100.optString("version");
        int r102 = r100.optInt("min_sdk_version");
        if (Intrinsics.areEqual(r100.optString("prefetch_partial", "native"), "native") == false) goto L5;
        PrefetchPartial r103 = PrefetchPartial.NATIVE;
    L6:
        JSONObject r104 = r100.optJSONObject("native");
        if (r104 == null) goto L12;
        final JSONArray r105 = r104.optJSONArray("rules");
        if (r105 == null) goto L12;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        List<Rule> r106 = SequencesKt.toList(SequencesKt.map(CollectionsKt.asSequence(RangesKt.until(0, r105.length())), new PrefetchConfigKt$toNativePrefetchRules$1(r105)));
        if (r106 == null) goto L12;
    L13:
        Intrinsics.checkNotNullParameter(r101, "version");
        Intrinsics.checkNotNullParameter(r103, "prefetchPartial");
        Intrinsics.checkNotNullParameter(r106, "rules");
        this.f58485a = r101;
        this.f58486b = r102;
        this.f58487c = r103;
        this.f58488d = r106;
        return;
    L12:
        r106 = CollectionsKt.emptyList();
        goto L13
    L5:
        r103 = PrefetchPartial.LATCH;
        goto L6
    }
}
