package com.bytedance.android.ecom.bcm.track.impl.monitor;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f51110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f51111b;

    public c() {
        this(null);
    }

    public final String toString() {
        return "CheckResult(success=" + this.f51110a + ", param=" + CollectionsKt.joinToString$default(MapsKt.toList(this.f51111b), null, "[", "]", 0, null, null, 57, null) + ')';
    }

    public c(Object r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        this.f51110a = true;
        this.f51111b = r101;
    }
}
