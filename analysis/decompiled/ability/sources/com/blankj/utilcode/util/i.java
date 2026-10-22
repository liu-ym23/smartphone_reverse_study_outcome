package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final Handler f2207a = new Handler(Looper.getMainLooper());
    public static final HashMap b = new HashMap();

    static {
        new ConcurrentHashMap();
        Runtime.getRuntime().availableProcessors();
        new Timer();
    }
}
