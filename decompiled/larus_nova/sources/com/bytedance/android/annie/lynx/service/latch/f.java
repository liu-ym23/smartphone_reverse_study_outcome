package com.bytedance.android.annie.lynx.service.latch;

import com.bytedance.android.annie.service.latch.ILatchService;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Pair<ILatchService.e, String>> f39563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f39564b;

    public f() {
        this.f39563a = new LinkedHashMap();
        this.f39564b = new AtomicInteger(0);
    }
}
