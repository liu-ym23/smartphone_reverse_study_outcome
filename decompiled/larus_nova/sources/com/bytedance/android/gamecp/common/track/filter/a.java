package com.bytedance.android.gamecp.common.track.filter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class a<T> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f56801a;

    public a() {
        this.f56801a = Collections.synchronizedMap(new HashMap());
    }

    @Override // com.bytedance.android.gamecp.common.track.filter.d
    public void a(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        r100.putAll(this.f56801a);
    }
}
