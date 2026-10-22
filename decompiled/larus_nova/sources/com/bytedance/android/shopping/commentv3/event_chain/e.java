package com.bytedance.android.shopping.commentv3.event_chain;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v96.h;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ic3.d f172801a;

    public e() {
        this(0);
    }

    @Override // v96.h
    public final void c(Map<String, ? extends Object> r100) {
    }

    public e(int r100) {
        this.f172801a = null;
    }

    @Override // v96.h
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r100, "btm");
    }

    @Override // v96.h
    public final void a(String r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        ic3.d r102 = this.f172801a;
        if (r102 == null) goto L11;
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "extra");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(r102.f489160a);
        r103.putAll(r102.f489161b);
        r103.put("tab_id", String.valueOf(r102.f489164e.f172740e.f512875b.f()));
        r103.put(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE, String.valueOf(r102.f489164e.f172740e.f512875b.g()));
        Iterator<Map.Entry<String, Object>> r104 = r101.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        Map.Entry<String, Object> r105 = r104.next();
        r103.put(r105.getKey(), String.valueOf(r105.getValue()));
        goto L6
    L8:
        new ic3.a(r100, r103).post(null, null);
        return;
    }
}
