package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class t implements com.bytedance.android.livesdk.log.filter.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.log.b f77145a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Map<String, String>> f77146b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f77147c = null;

    public t() {
    }

    static {
        f77147c = new t();
        f77145a = new com.bytedance.android.livesdk.log.b("MultiLinkDynamicLogInjector", null);
        f77146b = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
        f77145a.a("added");
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
        f77145a.a("removed");
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Map<String, Map<String, String>> r102 = f77146b;
        if (r102.containsKey(r100) == false) goto L10;
        Map r103 = (Map) ((LinkedHashMap) r102).get(r100);
        if (r103 == null) goto L12;
        Iterator r104 = r103.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        Map.Entry r105 = (Map.Entry) r104.next();
        r101.put((String) r105.getKey(), (String) r105.getValue());
        goto L8
    L13:
        return;
    L12:
        return;
    }
}
