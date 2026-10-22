package com.stepos.aiengine.usagestats;

import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelLifecycleTracker {

    /* renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f5928a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f5929b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f5930c;

    public static void a() {
        if (f5930c) {
            return;
        }
        f5930c = true;
        BuildersKt__Builders_commonKt.launch$default(f5928a, null, null, new ModelLifecycleTracker$start$1(2, null), 3, null);
    }
}
