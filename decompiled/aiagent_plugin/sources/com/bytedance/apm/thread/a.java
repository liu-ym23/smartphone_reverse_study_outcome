package com.bytedance.apm.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashSet;

/* JADX INFO: compiled from: ApmHandlerThread.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashSet<HandlerThread> f4868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Handler f4869b;

    static {
        f4868a = new HashSet();
        f4869b = new Handler(Looper.getMainLooper());
    }

    public static Handler a() {
        return f4869b;
    }
}
