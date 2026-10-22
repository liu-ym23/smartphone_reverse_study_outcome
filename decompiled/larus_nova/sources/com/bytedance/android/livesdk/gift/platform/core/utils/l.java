package com.bytedance.android.livesdk.gift.platform.core.utils;

import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f132052a = 0;

    public static long a() {
        ReadOnlyProperty r100 = com.bytedance.android.livesdk.gift.platform.core.h.f130643c;
        KProperty<?>[] r101 = com.bytedance.android.livesdk.gift.platform.core.h.f130639a;
        if ((((Number) r100.getValue(null, r101[1])).intValue() & 1) != 0) goto L7;
        return -1;
    L7:
        return ((Number) com.bytedance.android.livesdk.gift.platform.core.h.f130665n.getValue(null, r101[12])).longValue() * 1000;
    }

    static {
    }
}
