package com.bytedance.android.live.revlink.impl.intercomment;

import com.bytedance.android.livesdk.log.filter.v;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, com.bytedance.android.livesdk.log.filter.m> f92537a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f92538b = null;

    public d() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f92538b = new d();
        f92537a = com.bytedance.revenue.platform.api.core.d.a(new Pair[]{TuplesKt.to("InIntercomInjector", new c())});
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (Intrinsics.areEqual(r100, "livesdk_audience_live_message") == false) goto L5;
        List r102 = com.bytedance.revenue.platform.api.core.c.a(new String[]{"InIntercomInjector"});
    L6:
        Iterator r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        String r104 = (String) r103.next();
        com.bytedance.android.livesdk.log.filter.m r105 = (com.bytedance.android.livesdk.log.filter.m) ((LinkedHashMap) f92537a).get(r104);
        if (r105 == null) goto L8;
        r105.a(r101);
        goto L8
    L12:
        return;
    L5:
        r102 = com.bytedance.revenue.platform.api.core.c.a(new String[0]);
        goto L6
    }
}
