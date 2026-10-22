package com.bytedance.android.live.profile.usecase;

import com.bytedance.android.live.profile.p004enum.TrackArea;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<TrackArea, List<String>> f87053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f87054b;

    public static final class a {
    }

    static {
    }

    public s() {
        this.f87053a = new LinkedHashMap();
        this.f87054b = new LinkedHashMap();
    }

    public final void a(Map<String, String> r110) {
        Intrinsics.checkNotNullParameter(r110, "map");
        Iterator r100 = ((LinkedHashMap) this.f87053a).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Map.Entry r101 = (Map.Entry) r100.next();
        r110.put(((TrackArea) r101.getKey()).getParamName(), CollectionsKt.joinToString$default((Iterable) r101.getValue(), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null));
        goto L4
    L6:
        Set r102 = ((LinkedHashMap) this.f87053a).keySet();
        Iterator r103 = CollectionsKt.minus(ArraysKt.toList(TrackArea.values()), r102).iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r110.put(((TrackArea) r103.next()).getParamName(), "");
        goto L8
    }
}
