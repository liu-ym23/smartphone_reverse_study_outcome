package com.android.ttcjpaysdk.kmp.base.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/util/SystemTimeUtils;", "", "<init>", "()V", "elapsedRealtime", "", "currentTimeMillis", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemTimeUtils {
    public static final int $stable = 0;
    public static final SystemTimeUtils INSTANCE = null;

    static {
        INSTANCE = new SystemTimeUtils();
    }

    private SystemTimeUtils() {
    }

    public final long elapsedRealtime() {
        return SystemTimePlatform.INSTANCE.elapsedRealtime();
    }

    public final long currentTimeMillis() {
        return fuc.a.a().a();
    }
}
