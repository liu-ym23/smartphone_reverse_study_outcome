package com.bytedance.android.live.profile.ui.util;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<String>> f86948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f86949b;

    public final void b() {
        List<String> r100 = this.f86948a.get(SlcCommonAction.KEY_ACTIONS);
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        List<String> r101 = this.f86948a.get("others");
        if (r101 == null) goto L8;
        r101.clear();
    L8:
        Map<String, String> r102 = this.f86949b;
        if (r102 == null) goto L12;
        ((LinkedHashMap) r102).clear();
        return;
    }

    public h() {
        this.f86948a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(SlcCommonAction.KEY_ACTIONS, new ArrayList()), TuplesKt.to("others", new ArrayList())});
    }

    public final void a(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<String> r101 = this.f86948a.get(SlcCommonAction.KEY_ACTIONS);
        if (r101 == null) goto L8;
        r101.add(r100);
        return;
    }
}
