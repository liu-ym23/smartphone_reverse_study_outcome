package com.bytedance.android.live.core.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes45.dex */
public final class MainPostOptUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f66069a = null;

    static {
        f66069a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, MainPostOptUtils$sHandler$2.INSTANCE);
    }
}
