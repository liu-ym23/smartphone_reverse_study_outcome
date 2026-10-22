package com.baidu.location.b;

import android.os.HandlerThread;

/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private static HandlerThread f5493a;

    public static synchronized HandlerThread a() {
        try {
            if (f5493a == null) {
                try {
                    HandlerThread handlerThread = new HandlerThread("ServiceStartArguments", 10);
                    f5493a = handlerThread;
                    handlerThread.start();
                } catch (Throwable th) {
                    th.printStackTrace();
                    f5493a = null;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f5493a;
    }
}
