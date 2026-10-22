package com.baidu.a;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    private static volatile k f4706a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f4707b = new ThreadPoolExecutor(5, 25, 20, TimeUnit.SECONDS, new LinkedBlockingDeque(50));

    private k() {
    }

    public static k a() {
        if (f4706a == null) {
            synchronized (k.class) {
                try {
                    if (f4706a == null) {
                        f4706a = new k();
                    }
                } finally {
                }
            }
        }
        return f4706a;
    }

    public Executor b() {
        return this.f4707b;
    }
}
