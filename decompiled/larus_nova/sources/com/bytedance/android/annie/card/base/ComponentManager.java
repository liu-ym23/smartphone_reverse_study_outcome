package com.bytedance.android.annie.card.base;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes43.dex */
public final class ComponentManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f39132a = null;

    static {
        f39132a = LazyKt.lazy(LazyThreadSafetyMode.NONE, ComponentManager$containerMap$2.INSTANCE);
    }
}
