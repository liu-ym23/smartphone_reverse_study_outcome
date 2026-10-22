package com.bytedance.android.scope.tree;

import com.bytedance.android.scope.j;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes12.dex */
public final class NodeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f163458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<j, d> f163459b;

    public NodeManager() {
        d r100 = new d(c.f163464e, Reflection.getOrCreateKotlinClass(j.class), null, NodeManager$nodeRoot$1.INSTANCE);
        this.f163458a = r100;
        ConcurrentHashMap r101 = new ConcurrentHashMap();
        r101.put(r100.f163471j, r100);
        Unit r102 = Unit.INSTANCE;
        this.f163459b = r101;
    }
}
