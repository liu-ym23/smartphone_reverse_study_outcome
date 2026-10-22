package com.bytedance.android.live.revlink.impl.rtc;

import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final String a(float r100) {
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        return String.format("%.6f", Arrays.copyOf(new Object[]{Double.valueOf(Math.rint(((double) r100) * 1.0E7d) / ((double) 1.0E7f))}, 1));
    }
}
