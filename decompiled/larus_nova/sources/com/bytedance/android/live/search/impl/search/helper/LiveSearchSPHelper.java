package com.bytedance.android.live.search.impl.search.helper;

import android.content.SharedPreferences;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes47.dex */
public final class LiveSearchSPHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f100770a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SharedPreferences.Editor f100771b = null;

    static {
        Lazy r100 = LazyKt.lazy(LiveSearchSPHelper$sharedPreferences$2.INSTANCE);
        f100770a = r100;
        SharedPreferences r101 = (SharedPreferences) r100.getValue();
        if (r101 == null) goto L5;
        SharedPreferences.Editor r102 = r101.edit();
    L6:
        f100771b = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }
}
