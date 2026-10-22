package com.bytedance.android.annie.business.latch;

import com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Pair<IAnnieBusinessLatchService.b, String>> f39024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f39025b;

    public e() {
        this.f39024a = new LinkedHashMap();
        this.f39025b = new AtomicInteger(0);
    }
}
