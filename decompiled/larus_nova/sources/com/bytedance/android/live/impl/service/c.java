package com.bytedance.android.live.impl.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T, U> implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f69293a;

    public c(Object r100) {
        this.f69293a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiConsumer
    public final void accept(Object r100, Object r101) {
        String r102 = (String) r100;
        Intrinsics.checkNotNullParameter(r102, "name");
        if (StringsKt.startsWith$default(r102, "player_monitor_features_", false, 2, null) == false) goto L15;
        Object r103 = ((JSONObject) this.f69293a).opt(StringsKt.removePrefix(r102, "player_monitor_features_"));
        if ((!Intrinsics.areEqual(r101, r103)) == false) goto L23;
        if (r103 == null) goto L24;
        Iterator<Map.Entry<z90.a.b, List<String>>> r104 = FeatureManager.f69265k.entrySet().iterator();
    L9:
        if (r104.hasNext() == false) goto L25;
        Map.Entry<z90.a.b, List<String>> r105 = r104.next();
        if (r105.getValue().contains(r102) == false) goto L9;
        z90.a.b r106 = r105.getKey();
        if (r106 == 0) goto L9;
        r106.a(r102, r103);
        goto L9
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }
}
