package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes9.dex */
public class s1 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f131724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f131725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f131726c;

    @Override // com.bytedance.android.scope.o
    public void onStart() {
        g(new IntRange(0, 7));
    }

    public s1() {
        this.f131724a = new LinkedHashMap();
    }

    public final void a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$addLocationInfo");
        String r101 = (String) ((LinkedHashMap) this.f131724a).get("start_row_location");
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.put("start_row_location", r101);
        String r103 = (String) ((LinkedHashMap) this.f131724a).get("end_row_location");
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        r100.put("end_row_location", r102);
    }

    public final void d(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$addTabInfo");
        String r101 = (String) ((LinkedHashMap) this.f131724a).get(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r101);
        String r103 = (String) ((LinkedHashMap) this.f131724a).get("tab_location");
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        r100.put("tab_location", r102);
    }

    public final void f(int r100) {
        if (r100 == (-1)) goto L6;
        this.f131724a.put("diy_card_chosen_type", String.valueOf(r100));
        return;
    }

    public final void g(IntRange r100) {
        Intrinsics.checkNotNullParameter(r100, "giftRange");
        this.f131724a.put("start_row_location", String.valueOf((r100.getFirst() / 4) + 1));
        this.f131724a.put("end_row_location", String.valueOf((r100.getLast() / 4) + 1));
    }

    public final void h(int r100, int r101) {
        this.f131724a.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r101));
        this.f131724a.put("tab_location", String.valueOf(r100 + 1));
    }

    public final void c(int r100, int r101, int r102) {
        this.f131724a.put("from_tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r100));
        this.f131724a.put("from_tab_location", String.valueOf(r101 + 1));
        this.f131724a.put("tab_gift_cnt", String.valueOf(r102));
    }
}
