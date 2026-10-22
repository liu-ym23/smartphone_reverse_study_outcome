package com.android.ttcjpaysdk.kmp.base.util;

import android.os.SystemClock;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/util/SystemTimePlatform;", "", "<init>", "()V", "elapsedRealtime", "", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemTimePlatform {
    public static final int $stable = 0;
    public static final SystemTimePlatform INSTANCE = null;

    static {
        INSTANCE = new SystemTimePlatform();
    }

    private SystemTimePlatform() {
    }

    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}
