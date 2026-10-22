package com.bytedance.android.live.core.performance;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f65108a = null;

    static {
        f65108a = new a();
        new Handler(Looper.getMainLooper());
    }

    public a() {
        new ConcurrentHashMap();
    }
}
