package com.bytedance.android.ec.window.base.setting;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R:\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b0\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/window/base/setting/a;", "", "", "", "events", "Ljava/util/Set;", "getEvents", "()Ljava/util/Set;", "", "", "filterMap", "Ljava/util/Map;", "getFilterMap", "()Ljava/util/Map;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("events")
    private final Set<String> events;

    @SerializedName("filters")
    private final Map<String, List<Map<String, String>>> filterMap;

    public a() {
        LinkedHashSet r100 = new LinkedHashSet();
        LinkedHashMap r101 = new LinkedHashMap();
        this.events = r100;
        this.filterMap = r101;
    }
}
