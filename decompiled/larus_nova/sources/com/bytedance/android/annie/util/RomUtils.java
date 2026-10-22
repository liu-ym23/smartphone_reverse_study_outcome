package com.bytedance.android.annie.util;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public final class RomUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f40050a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f40051b = null;

    static {
        f40050a = LazyKt.lazy(RomUtils$isMiui$2.INSTANCE);
        f40051b = LazyKt.lazy(RomUtils$isFlyme$2.INSTANCE);
    }
}
