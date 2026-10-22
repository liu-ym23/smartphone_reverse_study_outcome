package com.bytedance.android.ec.core.utils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes43.dex */
public final class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45613a = 0;

    static {
    }

    public static String a(long r100) {
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        TimeUnit r102 = TimeUnit.MILLISECONDS;
        return String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r102.toMinutes(r100) - TimeUnit.HOURS.toMinutes(r102.toHours(r100))), Long.valueOf(r102.toSeconds(r100) - TimeUnit.MINUTES.toSeconds(r102.toMinutes(r100)))}, 2));
    }
}
